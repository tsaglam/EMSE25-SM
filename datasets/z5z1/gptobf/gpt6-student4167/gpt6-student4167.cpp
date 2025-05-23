#include <iostream>
#include <string>
#include <stdexcept>
#include <map>

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
            throw std::domain_error("Neispravni parametri");
        }
    }

    int DajIndeks() const { return index; }
    std::string DajGodinuStudija() const { return god_studija; }
    std::string DajImePrezime() const { return ime_prezime; }
    std::string DajAdesu() const { return adresa; }
    std::string DajTelefon() const { return br_tel; }

    void Ispisi() const {
        std::cout << "Broj indeksa: " << index << std::endl
                  << "Godina studija: " << god_studija << std::endl
                  << "Ime i prezime: " << ime_prezime << std::endl
                  << "Adresa: " << adresa << std::endl
                  << "Telefon: " << br_tel << std::endl;
    }
};

class Laptop {
    int ev_broj;
    std::string naziv;
    std::string karakteristike;
    Student* kod_koga_je;

public:
    Laptop(int ev_broj, const std::string& naziv, const std::string& karakteristike) 
    : ev_broj(ev_broj), naziv(naziv), karakteristike(karakteristike), kod_koga_je(nullptr) {
        if (ev_broj < 0) throw std::domain_error("Neispravni parametri");
    }

    // Ensure proper management to avoid memory leaks
    ~Laptop() = default;

    int DajEvidencijiskiBroj() const { return ev_broj; }
    std::string DajNaziv() const { return naziv; }
    std::string DajKarakteristike() const { return karakteristike; }

    void Zaduzi(Student& s) {
        if (kod_koga_je != nullptr) throw std::domain_error("Laptop vec zaduzen");
        kod_koga_je = &s;
    }

    void Razduzi() {
        kod_koga_je = nullptr;
    }

    bool DaLiJeZaduzen() const {
        return kod_koga_je != nullptr;
    }

    Student& DajKodKogaJe() const {
        if (!DaLiJeZaduzen()) throw std::domain_error("Laptop nije zaduzen");
        return *kod_koga_je;
    }

    void Ispisi() {
        std::cout << "Evidencijski broj: " << ev_broj << std::endl
                  << "Naziv: " << naziv << std::endl
                  << "Karakteristike: " << karakteristike << std::endl;
        if (DaLiJeZaduzen()) {
            std::cout << "Zaduzio/la: " << kod_koga_je->DajImePrezime() << std::endl;
        }
    }
};

class Administracija {
    std::map<int, Student> studenti;
    std::map<int, Laptop> laptopi;

    // Implementation omitted for brevity
};

int main() {
    // Your testing implementation here
    return 0;
}