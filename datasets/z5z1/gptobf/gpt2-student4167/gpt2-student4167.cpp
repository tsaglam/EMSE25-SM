#include <iostream>
#include <string>
#include <stdexcept>
#include <map>
#include <set>

class Student {
    int index;
    std::string god_studija;
    std::string ime_prezime;
    std::string adresa;
    std::string br_tel;
public:
    Student(int index, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel)
        : index(index), god_studija(god_studija), ime_prezime(ime_prezime), adresa(adresa), br_tel(br_tel) {
        if (index < 10000 || index > 99999) 
            throw std::domain_error("Neispravni parametri");
        // Validation for god_studija might need to check if it matches one of the valid options.
    }
    // Getters and methods remain unchanged.
    void Ispisi() const {
        std::cout << "Broj indeksa: " << index << std::endl;
        std::cout << "Godina studija: " << god_studija << std::endl;
        std::cout << "Ime i prezime: " << ime_prezime << std::endl;
        std::cout << "Adresa: " << adresa << std::endl;
        std::cout << "Telefon: " << br_tel << std::endl;
    }
};  // Student class closing

class Laptop {
    int ev_broj; 
    std::string naziv;
    std::string karakteristike; 
    Student *kod_koga_je;
public:
    Laptop(int ev_broj, std::string naziv, std::string karakteristike) 
        : ev_broj(ev_broj), naziv(naziv), karakteristike(karakteristike), kod_koga_je(nullptr) {
        if (ev_broj < 0) 
            throw std::domain_error("Neispravni parametri");
    }
    
    void Zaduzi(Student &s) {
        if(kod_koga_je != nullptr) 
            throw std::domain_error("Laptop vec zaduzen");
        kod_koga_je = &s;
    }
    
    void Razduzi() {
        kod_koga_je = nullptr;
    }
    
    bool DaLiJeZaduzen() const {
        return kod_koga_je != nullptr;
    }

    Student &DajKodKogaJe() const {
        if (!DaLiJeZaduzen()) 
            throw std::domain_error("Laptop nije zaduzen");
        return *kod_koga_je;
    }

    Student* DajPokKodKogaJe() const {
        return kod_koga_je;
    }

    void Ispisi() const {
        std::cout << "Evidencijski broj: " << ev_broj << std::endl;
        std::cout << "Naziv: " << naziv << std::endl;
        std::cout << "Karakteristike: " << karakteristike << std::endl;
    }
};  // Laptop class closing

class Administracija {
    std::map<int, Student*> studenti;
    std::map<int, Laptop*> laptopi;
    // Implementation of registration and laptop management methods would go here.
    // Ensure to handle the dynamic allocation and deallocation properly 
    // to avoid memory leaks.
};

int main() {
    return 0;
}