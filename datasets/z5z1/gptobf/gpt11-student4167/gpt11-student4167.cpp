#include <iostream>
#include <string>
#include <stdexcept>
#include <map>

class Student {
public:
    int index;
    std::string god_studija;
    std::string ime_prezime;
    std::string adresa;
    std::string br_tel;

    Student(int index, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel) : index(index), god_studija(god_studija), ime_prezime(ime_prezime), adresa(adresa), br_tel(br_tel) {
        if (index < 10000 || index > 99999) throw std::domain_error("Neispravni parametri");
    }

    int DajIndeks() const { return index; }
    std::string DajGodinuStudija() const { return god_studija; }
    std::string DajImePrezime() const { return ime_prezime; }
    std::string DajAdesu() const { return adresa; }
    std::string DajTelefon() const { return br_tel; }
    void Ispisi() const {
        std::cout << "Broj indeksa: " << index << std::endl;
        std::cout << "Godina studija: " << DajGodinuStudija() << std::endl;
        std::cout << "Ime i prezime: " << DajImePrezime() << std::endl;
        std::cout << "Adresa: " << DajAdesu() << std::endl;
        std::cout << "Telefon: " << DajTelefon() << std::endl;
    }
};

class Laptop {
    int ev_broj;
    std::string naziv;
    std::string karakteristike;
    Student* kod_koga_je = nullptr;

public:
    Laptop(int ev_broj, std::string naziv, std::string karakteristike) : ev_broj(ev_broj), naziv(naziv), karakteristike(karakteristike) {
        if (ev_broj < 0) throw std::domain_error("Neispravni parametri");
    }

    int DajEvidncijskiBroj() const { return ev_broj; }
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

    void Ispisi() const {
        std::cout << "Evidencijski broj: " << ev_broj << std::endl;
        std::cout << "Naziv: " << DajNaziv() << std::endl;
        std::cout << "Karakteristike: " << DajKarakteristike() << std::endl;
    }
};

class Administracija {
    std::map<int, Student*> studenti; // Ključno polje index
    std::map<int, Laptop*> laptopi; // Ključno polje ev_br

public:
    // Members for Administracija (not implemented in original code)
};

int main() {
    return 0;
}