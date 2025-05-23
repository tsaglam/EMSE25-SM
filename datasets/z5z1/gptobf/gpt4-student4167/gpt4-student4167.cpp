#include <iostream>
#include <string>
#include <stdexcept>
#include <map>
#include <memory>

class Student {
    int index;
    std::string god_studija;
    std::string ime_prezime;
    std::string adresa;
    std::string br_tel;

public:
    Student(int idx, const std::string& godina_studija, const std::string& imePrezime, const std::string& adr, const std::string& brTel) 
    : index(idx), god_studija(godina_studija), ime_prezime(imePrezime), adresa(adr), br_tel(brTel) {
        if (index < 10000 || index > 99999) throw std::domain_error("Neispravni parametri");
    }
    int DajIndeks() const { return index; }
    std::string DajGodinuStudija() const { return god_studija; }
    std::string DajImePrezime() const { return ime_prezime; }
    std::string DajAdresu() const { return adresa; }
    std::string DajTelefon() const { return br_tel; }
    void Ispisi() const {
        std::cout << "Broj indeksa: " << index << "\nGodina studija: " << god_studija 
                  << "\nIme i prezime: " << ime_prezime << "\nAdresa: " << adresa << "\nTelefon: " << br_tel << std::endl;
    }
    
};

class Laptop {
    int ev_broj; 
    std::string naziv;
    std::string karakteristike; 
    Student* kod_koga_je;

public:
    Laptop(int evBr, const std::string& name, const std::string& specs) 
    : ev_broj(evBr), naziv(name), karakteristike(specs), kod_koga_je(nullptr) {
        if (ev_broj < 0) throw std::domain_error("Neispravni parametri");
    }
    int DajEvidencijskiBroj() const { return ev_broj; }
    std::string DajNaziv() const { return naziv; }
    std::string DajKarakteristike() const { return karakteristike; }
    void Zaduzi(Student& s) {
        if(kod_koga_je) throw std::domain_error("Laptop vec zaduzen");
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
        std::cout << "Evidencijski broj: " << ev_broj << "\nNaziv: " << naziv << "\nKarakteristike: " << karakteristike << std::endl;
    }
};

class Administracija {
    std::map<int, std::unique_ptr<Student>> studenti;
    std::map<int, std::unique_ptr<Laptop>> laptopi;

public:
    // Implement the Registration and other methods here
};

int main() {
    return 0;
}