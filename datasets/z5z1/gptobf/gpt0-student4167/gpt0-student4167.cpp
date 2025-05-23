#include <iostream>
#include <string>
#include <stdexcept>
#include <map>
#include <memory> // For smart pointers

// Student class remains largely unchanged, but with cleaned-up validation.
class Student {
    int index;
    std::string god_studija;
    std::string ime_prezime;
    std::string adresa;
    std::string br_tel;

public:
    Student(int idx, const std::string& god, const std::string& ime, const std::string& adr, const std::string& tel)
    : index(idx), god_studija(god), ime_prezime(ime), adresa(adr), br_tel(tel) {
        if (index < 10000 || index > 99999) {
            throw std::domain_error("Neispravni parametri");
        }
    }

    int DajIndeks() const { return index; }
    std::string DajGodinuStudija() const { return god_studija; }
    std::string DajImePrezime() const { return ime_prezime; }
    std::string DajAdresu() const { return adresa; } // Corrected typo in method name
    std::string DajTelefon() const { return br_tel; }

    void Ispisi() const {
        std::cout << "Broj indeksa: " << index << "\n"
                  << "Godina studija: " << god_studija << "\n"
                  << "Ime i prezime: " << ime_prezime << "\n"
                  << "Adresa: " << adresa << "\n"
                  << "Telefon: " << br_tel << std::endl;
    }
};

// Simplified Laptop class with smart pointer for holding the Student
class Laptop {
    int ev_broj;
    std::string naziv;
    std::string karakteristike;
    Student* kod_koga_je = nullptr;

public:
    Laptop(int broj, const std::string& name, const std::string& specs)
    : ev_broj(broj), naziv(name), karakteristike(specs) {
        if (ev_broj < 0) throw std::domain_error("Neispravni parametri");
    }

    int DajEvidencijskiBroj() const { return ev_broj; }
    std::string DajNaziv() const { return naziv; }
    std::string DajKarakteristike() const { return karakteristike; }

    void Zaduzi(Student& s) {
        if(kod_koga_je != nullptr) throw std::domain_error("Laptop vec zaduzen");
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

    Student* DajPokKodKogaJe() const {
        return kod_koga_je;
    }

    void Ispisi() const {
        std::cout << "Evidencijski broj: " << ev_broj << "\n"
                  << "Naziv: " << naziv << "\n"
                  << "Karakteristike: " << karakteristike << std::endl;
    }
};

// The Administracija class is left as an exercise for further development.

int main() {
    // Your main functionality tests or implementation goes here.
    return 0;
}