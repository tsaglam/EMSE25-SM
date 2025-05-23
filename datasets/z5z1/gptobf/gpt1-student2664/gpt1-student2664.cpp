#include <iostream>
#include <string>
#include <map>
#include <algorithm>
#include <stdexcept>

// Forward declaration
class Student;

class Laptop {
    int evidencijskiBroj;
    std::string naziv;
    std::string karakteristike;
    Student* kodKogaJe;

public:
    Laptop(int ev_broj, std::string naziv, std::string karakteristike)
        : evidencijskiBroj(ev_broj), naziv(std::move(naziv)),
          karakteristike(std::move(karakteristike)), kodKogaJe(nullptr) {
        if (evidencijskiBroj < 0) throw std::domain_error("Neispravni parametri"); 
    }

    int DajEvidencijskiBroj() const { return evidencijskiBroj; }
    const std::string& DajNaziv() const { return naziv; }
    const std::string& DajKarakteristike() const { return karakteristike; }

    void Zaduzi(Student& s);
    void Razduzi() { kodKogaJe = nullptr; }
    bool DaLiJeZaduzen() const { return kodKogaJe != nullptr; }

    Student& DajKodKogaJe() const {
        if (kodKogaJe == nullptr) throw std::domain_error("Laptop nije zaduzen");
        return *kodKogaJe;
    }
    
    void Ispisi() const;
};

class Student {
    int indeks;
    std::string godinaStudija;
    std::string imeIPrezime;
    std::string adresa;
    std::string brojTelefona;

    static int BrojCifara(int x);
    static bool OdgovarajucaGodinaStudija(const std::string& s);
    static std::string SrediIme(const std::string& s);
    static bool IspravanFormatBroja(const std::string& b);

public:
    Student(int indeks, std::string godina_s, std::string ime_i_prezime, 
            std::string adresa, std::string br_tel);
    
    int DajIndeks() const { return indeks; }
    std::string DajGodinuStudija() const;
    const std::string& DajImePrezime() const { return imeIPrezime; }
    const std::string& DajAdresu() const { return adresa; }
    const std::string& DajTelefon() const { return brojTelefona; }

    void Ispisi() const;
};

void Laptop::Zaduzi(Student& s) {
    if (DaLiJeZaduzen()) throw std::domain_error("Laptop vec zaduzen");
    kodKogaJe = &s;
}

void Laptop::Ispisi() const {
    std::cout << "Evidencijski broj: " << evidencijskiBroj << std::endl
              << "Naziv: " << naziv << std::endl
              << "Karakteristike: " << karakteristike << std::endl;
    if (DaLiJeZaduzen()) {
        std::cout << "Zaduzio/la: " << kodKogaJe->DajImePrezime() << " (" << kodKogaJe->DajIndeks() << ")" << std::endl;
    }
}

Student::Student(int indeks, std::string godina_s, std::string ime_i_prezime, 
                 std::string adresa, std::string br_tel)
    : indeks(indeks), godinaStudija(std::move(godina_s)), 
      imeIPrezime(SrediIme(ime_i_prezime)), adresa(SrediIme(adresa)),
      brojTelefona(std::move(br_tel)) {
    if (BrojCifara(indeks) != 5 || !OdgovarajucaGodinaStudija(godinaStudija) ||
        !IspravanFormatBroja(brojTelefona)) 
        throw std::domain_error("Neispravni parametri");
}

void Student::Ispisi() const {
    std::cout << "Broj indeksa: " << indeks << std::endl
              << "Godina studija: " << DajGodinuStudija() << std::endl
              << "Ime i prezime: " << imeIPrezime << std::endl
              << "Adresa: " << adresa << std::endl
              << "Telefon: " << brojTelefona << std::endl;
}

// Omitting utility function implementations for brevity...
// Implement Student::BrojCifara, Student::OdgovarajucaGodinaStudija, 
// Student::SrediIme, and Student::IspravanFormatBroja as before

// Omitting the Administracija class to focus on refactoring
// Implementation should follow similar practices: explicit constructors, 
// clean-up in destructor, and proper rule of three/five handling