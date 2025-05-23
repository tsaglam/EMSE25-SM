#include <iostream>
#include <string>
#include <stdexcept>
#include <map>
#include <memory>
#include <set>

class Student {
    int index;
    std::string god_studija;
    std::string ime_prezime;
    std::string adresa;
    std::string br_tel;

public:
    Student(int index, const std::string& god_studija, const std::string& ime_prezime, const std::string& adresa, const std::string& br_tel) 
        : index(index), god_studija(god_studija), ime_prezime(ime_prezime), adresa(adresa), br_tel(br_tel) {
        if (index < 10000 || index > 99999) {
            throw std::domain_error("Neispravni parametri za index");
        }
        // The previous god_studija validation can be skipped or specifically implemented based on requirements.
        // Similar validations should be applied to other parameters as per actual requirements.
    }

    int DajIndeks() const { return index; }
    std::string DajGodinuStudija() const { return god_studija; }
    std::string DajImePrezime() const { return ime_prezime; }
    std::string DajAdesu() const { return adresa; }
    std::string DajTelefon() const { return br_tel; }

    void Ispisi() const {
        std::cout << "Broj indeksa: " << index << "\n";
        std::cout << "Godina studija: " << god_studija << "\n";
        std::cout << "Ime i prezime: " << ime_prezime << "\n";
        std::cout << "Adresa: " << adresa << "\n";
        std::cout << "Telefon: " << br_tel << "\n";
    }
};

class Laptop {
    int ev_broj;
    std::string naziv;
    std::string karakteristike;
    std::weak_ptr<Student> kod_koga_je; // use weak_ptr to avoid circular references

public:
    Laptop(int ev_broj, const std::string& naziv, const std::string& karakteristike) 
        : ev_broj(ev_broj), naziv(naziv), karakteristike(karakteristike), kod_koga_je() {
        if (ev_broj < 0) {
            throw std::domain_error("Neispravni parametri za evidencijski broj");
        }
    }

    int DajEvidncijskiBroj() const { return ev_broj; }
    std::string DajNaziv() const { return naziv; }
    std::string DajKarakteristike() const { return karakteristike; }

    void Zaduzi(std::shared_ptr<Student> s) {
        if(kod_koga_je.lock()) throw std::domain_error("Laptop vec zaduzen");
        kod_koga_je = s;
    }

    void Razduzi() {
        kod_koga_je.reset();
    }

    bool DaLiJeZaduzen() const {
        return kod_koga_je.lock() != nullptr;
    }

    std::shared_ptr<Student> DajKodKogaJe() const {
        if (!DaLiJeZaduzen()) throw std::domain_error("Laptop nije zaduzen");
        return kod_koga_je.lock();
    }

    void Ispisi() const {
        std::cout << "Evidencijski broj: " << ev_broj << "\n";
        std::cout << "Naziv: " << naziv << "\n";
        std::cout << "Karakteristike: " << karakteristike << "\n";
    }
};

class Administracija {
    std::map<int, std::shared_ptr<Student>> studenti;
    std::map<int, std::shared_ptr<Laptop>> laptopi;

public:
    void RegistrirajNovogStudenta(int index, const std::string& god_studija, const std::string& ime_prezime, const std::string& adresa, const std::string& br_tel) {
        if (studenti.find(index) != studenti.end()) throw std::domain_error("Student sa datim indeksom vec postoji");
        studenti[index] = std::make_shared<Student>(index, god_studija, ime_prezime, adresa, br_tel);
    }

    void RegistrirajNoviLaptop(int ev_broj, const std::string& naziv, const std::string& karakteristike) {
        if (laptopi.find(ev_broj) != laptopi.end()) throw std::domain_error("Laptop sa datim evidencijskim brojem vec postoji");
        laptopi[ev_broj] = std::make_shared<Laptop>(ev_broj, naziv, karakteristike);
    }

    // Other administrative functionalities as required...
};

int main() {
    // program logic
    return 0;
}