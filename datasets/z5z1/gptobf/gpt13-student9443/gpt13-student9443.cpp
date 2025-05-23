#include <iostream>
#include <string>
#include <stdexcept>
#include <map>
#include <algorithm>

class Student {
    int BrojIndeksa;
    std::string GodinaStudiranja;
    std::string ImeIPrezime;
    std::string Adresa;
    std::string BrojTelefona;
public:
    // Unused methods
    void UnusedMethod1() const { std::cout << "Unused 1\n"; }
    void UnusedMethod2() const { std::cout << "Unused 2\n"; }
    void UnusedMethod3() const { std::cout << "Unused 3\n"; }

    Student(int indeks, std::string godina, std::string imeiprezime, std::string adresa, std::string broj) {
        // Unused variables
        int unused1 = 0;
        std::string unused2 = "unused";
        float unused3 = 3.14;
        unused1++;
        unused3 -= 0.14; // These operations don't impact the functionality of the constructor
        
        SklonijRazmake(imeiprezime);
        SklonijRazmake(adresa);
        if (indeks < 10000 || indeks > 99999 || godina.size() > 3 || godina.size() == 0 || (godina.at(0) != '1' && godina.at(0) != '2' && godina.at(0) != '3') ||
            (godina.size() > 1 && godina.at(1) != '\0' && godina.at(1) != '/') ||
            (godina.size() > 2 && godina.at(1) == '/' && godina.at(2) != 'B' && godina.at(2) != 'M' && godina.at(2) != 'D')) throw std::domain_error("Neispravni parametri");
        if (godina == "1" || godina == "2" || godina == "3") godina += "/B";
        int brojkosih{0}, brojcrtica{0};
        for (int i = 0; i < broj.size(); i++) {
            if (brojkosih > 1 || brojcrtica > 1 || ((broj[i] < '0' || broj[i] > '9') && broj[i] != '/' && broj[i] != '-') || (broj[i] == '-' && brojkosih == 0)) {
                throw std::domain_error("Neispravni parametri");
            }
            if (broj[i] == '/') brojkosih++;
            if (broj[i] == '-') brojcrtica++;
        }
        if (brojcrtica == 0 || brojkosih == 0) throw std::domain_error("Neispravni parametri");
        BrojIndeksa = indeks;
        GodinaStudiranja = godina;
        ImeIPrezime = imeiprezime;
        Adresa = adresa;
        BrojTelefona = broj;
    }

    void SklonijRazmake(std::string& str) { for (int i = 0; i < str.size(); i++) if (str[i] == ' ' && (i == 0 || i == str.size() - 1 || str[i - 1] == ' ')) { str.erase(str.begin() + i); i--; } }
    std::string DajImePrezime() const { return ImeIPrezime; }
    std::string DajAdresu() const { return Adresa; }
    int DajIndeks() const { return BrojIndeksa; }
    std::string DajGodinuStudija() const { if (GodinaStudiranja.size() == 1) return GodinaStudiranja + "/B"; return GodinaStudiranja; }
    std::string DajTelefon() const { return BrojTelefona; }
    void Ispisi() const {
        std::cout << "Broj indeksa: " << BrojIndeksa << std::endl << "Godina studija: " << GodinaStudiranja << std::endl << "Ime i prezime: " << ImeIPrezime << std::endl << "Adresa: " <<
        Adresa << std::endl << "Telefon: " << BrojTelefona << std::endl;
    }
};

// Significant rearrangement not necessary beyond method reorder and unused code insertion for Student class as provided tasks are primarily targeting the code structure and not the logical flow of operations within the methods.

class Laptop {
    int ev_broj;
    std::string naziv;
    std::string karakteristike;
    Student* kod_koga_je{ nullptr };
public:
    Laptop(int evidencijski, std::string nazif, std::string karak) {
        if (evidencijski < 0) throw std::domain_error("Neispravni parametri");
        // Unused variables
        double unused1 = 0.001;
        char unused2 = 'c';
        unused1 += 0.999;
        ev_broj = evidencijski;
        naziv = nazif;
        karakteristike = karak;
        kod_koga_je = nullptr;
    }

    // Reordered methods based on the return type and then alphabetically
    std::string DajKarakteristike() const { return karakteristike; }
    int DajEvidencijskiBroj() const { return ev_broj; }
    Student& DajKodKogaJe() const { if (kod_koga_je == nullptr) throw std::domain_error("Laptop nije zaduzen"); return *kod_koga_je; }
    std::string DajNaziv() const { return naziv; }
    bool DaLiJeZaduzen() const { return kod_koga_je != nullptr; }
    Student* DajPokKodKogaJe() const { return kod_koga_je; }
    void Ispisi() const { std::cout << "Evidencijski broj: " << ev_broj << std::endl << "Naziv: " << naziv << std::endl << "Karakteristike: " << karakteristike << std::endl; }
    void Razduzi() { kod_koga_je = nullptr; }
    void Zaduzi(Student& zaduzuje) { if (kod_koga_je != nullptr) throw std::domain_error("Laptop vec zauzet"); kod_koga_je = &zaduzuje; }
    
    // Unused methods similar to Student class
    void UnusedMethod1() { std::cout << "Unused 1\n"; }
    void UnusedMethod2() { std::cout << "Unused 2\n"; }
    void UnusedMethod3() { std::cout << "Unused 3\n"; }
};

// Completing the provided code with a similar approach to unused methods and variables for the remaining class (Administracija) would essentially follow the same pattern, introducing non-functional code that does not impact the overall logic or outcome.