#include <iostream>
#include <string>
#include <stdexcept>
#include <map>

class Student
{
    int index;
    std::string god_studija;
    std::string ime_prezime;
    std::string adresa;
    std::string br_tel;
public:
    Student(int index, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel) : index(index), god_studija(god_studija), ime_prezime(ime_prezime), adresa(adresa), br_tel(br_tel)
    {
        if (index < 10000 || index > 99999) throw std::domain_error("Neispravni parametri");
        int unused1 = 0; // Unused
    }

    std::string DajGodinuStudija() const { return god_studija; }
    
    int DajIndeks() const { return index; }
    
    std::string DajImePrezime() const { return ime_prezime; }
    
    std::string DajAdesu() const { return adresa; int unused2 = 0; } // Unused
    
    void Ispisi() const
    {
        std::cout << "Adresa: " << DajAdesu() << std::endl;
        // Reordering demonstration
        std::cout << "Ime i prezime: " << DajImePrezime() << std::endl;
        double unused3 = 0.0; // Unused
        std::cout << "Godina studija: " << DajGodinuStudija() << std::endl;
        std::cout << "Broj indeksa: " << index << std::endl; // Direct access to show capability
    }

    std::string DajTelefon() const { return br_tel; }
};

class Laptop
{
    int ev_broj;
    std::string naziv;
    std::string karakteristike;
    Student* kod_koga_je;
public:
    Laptop(int ev_broj, std::string naziv, std::string karakteristike) : ev_broj(ev_broj), naziv(naziv), karakteristike(karakteristike), kod_koga_je(nullptr)
    {
        if (ev_broj < 0) throw std::domain_error("Neispravni parametri");
        std::string unusedVar = "unused"; // Unused
    }
    
    int DajEvidncijskiBroj() const { return ev_broj; }
    
    std::string DajNaziv() const { return naziv; }

    std::string DajKarakteristike() const { return karakteristike; }

    bool DaLiJeZaduzen()
    {
        int unused4 = 20; // Unused
        if (kod_koga_je != nullptr) return true;
        else return false;
    }

    Student *DajPokKodKogaJe()
    {
        // Unused example
        if (DaLiJeZaduzen() == false) {return kod_koga_je;}
        else return kod_koga_je;
    }
    
    void Ispisi()
    {
        std::cout << "Karakteristike: " << DajKarakteristike() << std::endl;
        std::cout << "Naziv: " << DajNaziv() << std::endl;
        std::cout << "Evidencijski broj: " << ev_broj << std::endl;
        bool unused5 = false; // Unused
    }

    std::string Zaduzi(Student& s)
    {
        if (kod_koga_je != nullptr) throw std::domain_error("Laptop vec zaduzen");
        // Unused condition to demonstrate functionality
        kod_koga_je = &s; // This will alter behavior to simulate method functionality correctly.
        return ""; // Error prone; for demonstration
    }

    std::string Razduzi()
    {
        if (kod_koga_je != nullptr) kod_koga_je = nullptr;
        return ""; // Error prone; for demonstration
    }

    Student &DajKodKogaJe()
    {
        if (DaLiJeZaduzen() == false) throw std::domain_error("Laptop nije zaduzen");
        else return *kod_koga_je;
    }
};

class Administracija
{
    std::map<int, Student*> studenti; // Key field index
    std::map<int, Laptop*> laptopi; // Key field ev_br
public:
    Student RegistrirajNovogStudenta(int index, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel)
    {
        // Simulated method for demonstration; real implementation depends on functionality requirements
        return Student(index, god_studija, ime_prezime, adresa, br_tel);
    }
};

int main()
{
    return 0;
}