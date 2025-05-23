#include <iostream>
#include <string>
#include <stdexcept>
#include <map>
#include <algorithm>

class Student {
    int brojIndeksa;
    std::string godinaStudiranja;
    std::string imeIPrezime;
    std::string adresa;
    std::string brojTelefona;

    void ObradiGodinuStudija(std::string& godina) {
        if (godina.empty() || godina.size() > 3 || (godina[0] != '1' && godina[0] != '2' && godina[0]!= '3') ||
            (godina.size() > 1 && godina[1] != '\0' && godina[1] != '/') || 
            (godina.size() > 2 && godina[1] == '/' && godina[2] != 'B' && godina[2] != 'M' && godina[2] != 'D'))
            throw std::domain_error("Neispravni parametri");

        if (godina == "1" || godina == "2" || godina == "3") godina += "/B";
    }

    void ObradiTelefonskiBroj(const std::string& broj) {
        int brojKosih = std::count(broj.begin(), broj.end(), '/');
        int brojCrtica = std::count(broj.begin(), broj.end(), '-');
        
        if (brojKosih != 1 || brojCrtica != 1 || !std::all_of(broj.begin(), broj.end(), [](char c) {return std::isdigit(c) || c == '/' || c == '-';}))
            throw std::domain_error("Neispravni parametri");
    }

    void SkloniRazmake(std::string& str) {
        str.erase(std::remove_if(str.begin(), str.end(), [prethodni = ' '](char trenutni) mutable {
                 bool zaBrisati = trenutni == ' ' && prethodni == ' ';
                 prethodni = trenutni;
                 return zaBrisati;
             }), str.end());
        if (str.front() == ' ') str.erase(str.begin());
        if (str.back() == ' ') str.pop_back();
    }

public:
    Student(int indeks, std::string godina, std::string imeiprezime, std::string adresa, std::string broj) : brojIndeksa(indeks) {
        if (indeks < 10000 || indeks > 99999) throw std::domain_error("Neispravni parametri");

        ObradiGodinuStudija(godina);
        ObradiTelefonskiBroj(broj);

        SkloniRazmake(imeiprezime);
        SkloniRazmake(adresa);

        godinaStudiranja = godina;
        imeIPrezime = imeiprezime;
        this->adresa = adresa;
        brojTelefona = broj;
    }

    // Getters and Ispisi method stays the same...
};

// The implementations for Laptop and Administracija can largely stay the same,
// with specific refactorings focused on aspects similar to those mentioned above
// for the Student class, aimed at enhancing code readability and robustness.


int main() {
    // Main function logic remains the same.
    // The interaction with the user and handling of actions based on user input does not need refactoring for output consistency.
}