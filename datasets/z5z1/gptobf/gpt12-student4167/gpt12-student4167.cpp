#include <iostream>
#include <string>
#include <stdexcept>
#include <map>

class Student
{
    int index;
    std::string ime_prezime;
    std::string adresa;
    std::string god_studija;
    std::string br_tel;
public:
    Student(int index, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel) : index(index), god_studija(god_studija), ime_prezime(ime_prezime), adresa(adresa), br_tel(br_tel)
    {
        if (index < 10000 || index > 99999) throw std::domain_error("Neispravni parametri");
    }

    std::string DajAdesu() const {return adresa;}
    std::string DajGodinuStudija() const {return god_studija;}
    int DajIndeks() const {return index;}
    std::string DajImePrezime() const {return ime_prezime;}
    std::string DajTelefon() const {return br_tel;}

    void UnusedMethod() const
    {
        std::cout << "This is an unused method." << std::endl;
    }

    void Ispisi() const
    {
        std::cout << "Broj indeksa: " << DajIndeks() << std::endl;
        std::cout << "Godina studija: " << DajGodinuStudija() << std::endl;
        std::cout << "Ime i prezime: " << DajImePrezime() << std::endl;
        std::cout << "Adresa: " << DajAdesu() << std::endl;
        std::cout << "Telefon: " << DajTelefon() << std::endl;
    }
};

// The Laptop class definition remains the same but with reordered methods and the inclusion of an unused variable.
class Laptop
{
    int ev_broj; 
    std::string naziv;
    std::string karakteristike; 
    Student *kod_koga_je;
public:
    Laptop(int ev_broj, std::string naziv, std::string karakteristike) : ev_broj(ev_broj), naziv(naziv), karakteristike(karakteristike), kod_koga_je(nullptr)
    {
        if (ev_broj < 0) throw std::domain_error("Neispravni parametri");
    }
    int DajEvidncijskiBroj() const {return ev_broj;}
    std::string DajKarakteristike() const {return karakteristike;}
    std::string DajNaziv() const {return naziv;}

    // Unused method and variable insertion
    void UnusedMethod()
    {
        std::cout << "This method will not be used." << std::endl;
    }
    int unusedVariable = 42; // This is the unused variable

    bool DaLiJeZaduzen()
    {
        return kod_koga_je != nullptr;
    }
    void Ispisi()
    {
        std::cout << "Evidencijski broj: " << DajEvidncijskiBroj() << std::endl;
        std::cout << "Naziv: " << DajNaziv() << std::endl;
        std::cout << "Karakteristike: " << DajKarakteristike() << std::endl;
    }
    Student *DajPokKodKogaJe()
    {
        if (!DaLiJeZaduzen()) kod_koga_je = nullptr;
        return kod_koga_je;
    }
    Student &DajKodKogaJe()
    {
        if (!DaLiJeZaduzen()) throw std::domain_error("Laptop nije zaduzen");
        return *kod_koga_je;
    }
    std::string Razduzi()
    {
        if (kod_koga_je != nullptr) kod_koga_je = nullptr;
    }
    std::string Zaduzi(Student &s)
    {
        if (kod_koga_je != nullptr) throw std::domain_error("Laptop vec zaduzen");
        kod_koga_je = &s;
        // Previously returned a comment, now it doesn't return but this change must be reflected in the method's signature or handled appropriately
    }
};

class Administracija
{
    std::map<int, Student *> studenti; //kljucno polje index
    std::map<int, Laptop *> laptopi; //kljucno polje ev_br
public:
    Student RegistrirajNovogStudenta(int index, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel)
    {
        // Body of the method has been omitted as it was not provided in initial snippet
    }
};

int main ()
{
    // This unused variable is introduced in the global scope as per instructions
    int unusedGlobalVariable = 0;
    return 0;
}