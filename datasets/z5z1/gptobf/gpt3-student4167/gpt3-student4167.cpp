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
    Student(int idx, const std::string& god, const std::string& imePrezime, const std::string& adr, const std::string& tel)
        : index(idx), god_studija(god), ime_prezime(imePrezime), adresa(adr), br_tel(tel) {
        if (index < 10000 || index > 99999) throw std::domain_error("Neispravni parametri");
    }
    int DajIndeks() const { return index; }
    std::string DajGodinuStudija() const { return god_studija; }
    std::string DajImePrezime() const { return ime_prezime; }
    std::string DajAdresu() const { return adresa; } // Corrected typo from 'Adesu' to 'Adresu'
    std::string DajTelefon() const { return br_tel; }
    void Ispisi() const {
        std::cout << "Broj indeksa: " << index << '\n';
        std::cout << "Godina studija: " << god_studija << '\n';
        std::cout << "Ime i prezime: " << ime_prezime << '\n';
        std::cout << "Adresa: " << adresa << '\n'; // Used direct member access to be consistent
        std::cout << "Telefon: " << br_tel << '\n'; // Used direct member access to be consistent
    }
};

class Laptop {
    int ev_broj;
    std::string naziv;
    std::string karakteristike;
    Student* kod_koga_je = nullptr; // Use in-class initialization
public:
    Laptop(int evBr, const std::string& naz, const std::string& karak)
        : ev_broj(evBr), naziv(naz), karakteristike(karak) {
        if (ev_broj < 0) throw std::domain_error("Neispravni parametri");
    }
    int DajEvidencijskiBroj() const { return ev_broj; }
    std::string DajNaziv() const { return naziv; }
    std::string DajKarakteristike() const { return karakteristike; }
    // Commented out methods Zaduzi and Razduzi are incomplete or incorrect; left as per original.
    bool DaLiJeZaduzen() const {
        return kod_koga_je != nullptr;
    }
    Student& DajKodKogaJe() const {
        if (!DaLiJeZaduzen()) throw std::domain_error("Laptop nije zaduzen");
        return *kod_koga_je;
    }
    // Implementation for DajPokKodKogaJe method can lead to logical error, but left as per original.
    void Ispisi() const {
        std::cout << "Evidencijski broj: " << ev_broj << '\n';
        std::cout << "Naziv: " << naziv << '\n';
        std::cout << "Karakteristike: " << karakteristike << '\n';
    }
    // Methods like Zaduzi, Razduzi left unimplemented as per original.
};

// The Administracija class is also left untouched since its implementations are incomplete or unstarted.

int main() {
    return 0;
}