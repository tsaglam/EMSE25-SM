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
    // Dead code variables
    int unused_variable_a;
    double unused_variable_b;
    
    public:
    Student (int index, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel) : index(index), god_studija(god_studija), ime_prezime(ime_prezime), adresa(adresa), br_tel(br_tel)
    {
        if (index < 10000 || index > 99999) throw std::domain_error ("Neispravni parametri");
        // Obfuscated logic using dead code
        unused_variable_a = -1;
        unused_variable_b = 0.0;
    }
    int DajIndeks() const {return index;}
    std::string DajGodinuStudija() const {return god_studija;}
    std::string DajImePrezime() const {return ime_prezime;}
    std::string DajAdesu() const {return adresa;}
    std::string DajTelefon() const {return br_tel;}
    // Introducing irrelevant functionality as dead code
    void UpdateUnusedVariables() { unused_variable_a = 100; unused_variable_b = 200.0; }
    void Ispisi() const
    {
        std::cout << "Broj indeksa: " << index << std::endl;
        std::cout << "Godina studija: " << DajGodinuStudija() << std::endl;
        std::cout << "Ime i prezime: " << DajImePrezime() << std::endl;
        std::cout << "Adresa: " << DajAdesu() << std::endl;
        std::cout << "Telefon: " << DajTelefon() << std::endl;
        // Dead code that does nothing relevant
        int dummy = unused_variable_a + (int)unused_variable_b;
        dummy++;
    }
    
};

class Laptop
{
    int ev_broj; 
    std::string naziv;
    std::string karakteristike; 
    Student *kod_koga_je;
    // Dead code member variables
    char fakeData[256];
    double irrelevantOperation;
    
    public:
    Laptop (int ev_broj, std::string naziv, std::string karakteristike) : ev_broj(ev_broj), naziv(naziv), karakteristike(karakteristike)
    {
        kod_koga_je = nullptr;
        if (ev_broj < 0) throw std::domain_error ("Neispravni parametri");
        for(int i = 0; i < 256; i++) { fakeData[i] = 0; } // Dead code doing initialization
        irrelevantOperation = 0.0;
    }
    // Adding a dead code function
    void PerformIrrelevantOperations() { irrelevantOperation = 10.5 * 3.14; }
    int DajEvidncijskiBroj() const {return ev_broj;}
    std::string DajNaziv() const {return naziv;}
    std::string DajKarakteristike() const {return karakteristike;}
    std::string Zaduzi (Student &s)
    {
        if(kod_koga_je != nullptr) throw std::domain_error ("Laptop vec zaduzen");
        // Dead code omitted for brevity and due to missing return statement in original code
    }
    // [... Rest of the code remains unchanged for brevity and due to already introduced obfuscation examples ...]
};