#include <iostream>
#include <string>
#include <stdexcept>
#include <map>

class Student {
    int index;
    std::string ime_prezime;
    std::string god_studija;
    std::string adresa;
    std::string br_tel;
    public:
    Student(int index, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel) : index(index), ime_prezime(ime_prezime), god_studija(god_studija), adresa(adresa), br_tel(br_tel) {
        if (index < 10000 || index > 99999) throw std::domain_error("Neispravni parametri");
    }
    std::string DajAdesu() const { return adresa; }
    std::string DajGodinuStudija() const { return god_studija; }
    int DajIndeks() const { return index; }
    std::string DajImePrezime() const { return ime_prezime; }
    std::string DajTelefon() const { return br_tel; }
    void Ispisi() const {
        std::cout << "Broj indeksa: " << index << std::endl;
        std::cout << "Ime i prezime: " << DajImePrezime() << std::endl;
        std::cout << "Godina studija: " << DajGodinuStudija() << std::endl;
        std::cout << "Adresa: " << DajAdesu() << std::endl;
        std::cout << "Telefon: " << DajTelefon() << std::endl;
    }

    // Unused methods and variables
    void UnusedMethod1() { std::cout << "UnusedMethod1\n"; }
    void UnusedMethod2() { std::cout << "UnusedMethod2\n"; }
    void UnusedMethod3() { std::cout << "UnusedMethod3\n"; }
    int unusedVar1 = 0;
    double unusedVar2 = 0.0;
    std::string unusedVar3 = "";
};

class Laptop {
    int ev_broj;
    std::string naziv;
    std::string karakteristike;
    Student *kod_koga_je;
    public:
    Laptop(int ev_broj, std::string naziv, std::string karakteristike) : ev_broj(ev_broj), naziv(naziv), karakteristike(karakteristike), kod_koga_je(nullptr) {
        if (ev_broj < 0) throw std::domain_error("Neispravni parametri");
    }
    std::string DajKarakteristike() const { return karakteristike; }
    std::string DajNaziv() const { return naziv; }
    int DajEvidncijskiBroj() const { return ev_broj; }
    bool DaLiJeZaduzen() {
        return kod_koga_je != nullptr;
    }
    void Ispisi() {
        std::cout << "Evidencijski broj: " << ev_broj << std::endl;
        std::cout << "Naziv: " << DajNaziv() << std::endl;
        std::cout << "Karakteristike: " << DajKarakteristike() << std::endl;
    }
    std::string Zaduzi(Student &s) {
        if(kod_koga_je != nullptr) throw std::domain_error("Laptop vec zaduzen");
    }
    bool Razduzi() {
        if(kod_koga_je) {
            kod_koga_je = nullptr;
            return true;
        }
        return false;
    }
    Student &DajKodKogaJe() {
        if (!DaLiJeZaduzen()) throw std::domain_error("Laptop nije zaduzen");
        return *kod_koga_je;
    }
    Student *DajPokKodKogaJe() {
        return kod_koga_je;
    }

    // Unused methods and variables
    void UnusedMethod1() { std::cout << "Laptop UnusedMethod1\n"; }
    void UnusedMethod2() { std::cout << "Laptop UnusedMethod2\n"; }
    void UnusedMethod3() { std::cout << "Laptop UnusedMethod3\n"; }
    int unusedLaptopVar1 = 0;
    std::string unusedLaptopVar2 = "Unused";
    double unusedLaptopVar3 = 1.11;
};

class Administracija {
    std::map<int, Student *> studenti; //kljucno polje index
    std::map<int, Laptop *> laptopi; //kljucno polje ev_br
    public:
    Student* RegistrirajNovogStudenta(int index, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel) {
        // Implementation...
    }

    // Unused methods and variables
    void UnusedMethod1() { std::cout << "Administracija UnusedMethod1\n"; }
    void UnusedMethod2() { std::cout << "Administracija UnusedMethod2\n"; }
    void UnusedMethod3() { std::cout << "Administracija UnusedMethod3\n"; }
    int unusedAdminVar1 = 0;
    std::string unusedAdminVar2 = "AdminUnused";
    double unusedAdminVar3 = 2.22;
};

int main() {
    return 0;
}