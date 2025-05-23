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
    Student(int indeks, const std::string& godina, std::string imeiprezime, std::string adresa, std::string broj) {
        if(indeks < 10000 || indeks > 99999 || godina.empty() || godina.size() > 3 ||
           (godina.front() != '1' && godina.front() != '2' && godina.front() != '3') ||
           (godina.size() > 1 && godina[1] != '\0' && godina[1] != '/') || 
           (godina.size() > 2 && godina[1] == '/' && godina[2] != 'B' && godina[2] != 'M' && godina[2] != 'D')) 
           throw std::domain_error("Neispravni parametri");

        GodinaStudiranja = (godina == "1" || godina == "2" || godina == "3") ? godina+"/B" : godina;

        int brojkosih = std::count(broj.begin(), broj.end(), '/');
        int brojcrtica = std::count(broj.begin(), broj.end(), '-');
        if(brojcrtica != 1 || brojkosih != 1 || 
           std::any_of(broj.begin(), broj.end(), [&](char c) { return (c < '0' || c > '9') && c != '/' && c != '-'; })) 
           throw std::domain_error("Neispravni parametri");

        SkloniRazmake(imeiprezime);
        SkloniRazmake(adresa);

        BrojIndeksa = indeks;
        ImeIPrezime = imeiprezime;
        Adresa = adresa;
        BrojTelefona = broj;
    }

    void SkloniRazmake(std::string &str) {
        str.erase(remove_if(str.begin(), str.end(), [](char& c) {return isspace(c); }), str.end());
    }

    // Getter methods and Ispisi function remain unchanged
};

// Definition for Laptop and Administracija classes remain unchanged

int main () {
    try {
        // The main function logic remains unchanged
    } catch(const std::domain_error& izuzetak) {
        std::cout << izuzetak.what();
    }
    return 0;
}