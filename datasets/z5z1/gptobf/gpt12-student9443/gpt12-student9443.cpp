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
    // Reordered constructor content for readability, added an unused variable
    Student(int indeks, std::string godina, std::string imeiprezime, std::string adresa, std::string broj) {
        // Unused variable declaration and assignment
        int unusedVariable = 0;
        unusedVariable++;
        
        if(indeks < 10000 || indeks > 99999) throw std::domain_error("Neispravni parametri");
        BrojIndeksa = indeks;
        
        // Godina studiranja validation moved up for clarity
        if(godina.size() > 3 || godina.empty() || !(godina.at(0) == '1' || godina.at(0) == '2' || godina.at(0) == '3') ||
            (godina.size() > 1 && godina.at(1) != '\0' && godina.at(1) != '/') || 
            (godina.size() > 2 && godina.at(1) == '/' && godina.at(2) != 'B' && godina.at(2) != 'M' && godina.at(2) != 'D')) throw std::domain_error("Neispravni parametri");
        if(godina == "1" || godina == "2" || godina == "3") GodinaStudiranja = godina + "/B";
        else GodinaStudiranja = godina;
        
        SklonijRazmake(imeiprezime);
        ImeIPrezime = imeiprezime;
        SklonijRazmake(adresa);
        Adresa = adresa;

        // Moved phone number validation and assignment here
        int brojkosih = 0, brojcrtica = 0;
        for(int i = 0; i < broj.size(); i++) {
            if(brojkosih > 1 || brojcrtica > 1 || ((broj[i] < '0' || broj[i] > '9') && broj[i] != '/' && broj[i] != '-') || (broj[i] == '-' && brojkosih == 0)) throw std::domain_error("Neispravni parametri");
            if(broj[i] == '/') brojkosih++;
            if(broj[i] == '-') brojcrtica++;
        }
        if(brojcrtica == 0 || brojkosih == 0) throw std::domain_error("Neispravni parametri");
        BrojTelefona = broj;
    }

    // Unused method inserted for the requirement
    void UnusedMethod() const {
        std::cout << "This is an unused method for demonstration purposes." << std::endl;
    }

    // Method reordering example; moving getters before other behaviors 
    int DajIndeks() const { return BrojIndeksa; }
    std::string DajGodinuStudija() const { return GodinaStudiranja.size()==1 ? GodinaStudiranja+"/B" : GodinaStudiranja; }
    std::string DajImePrezime() const { return ImeIPrezime; }
    std::string DajAdresu() const { return Adresa; }
    std::string DajTelefon() const { return BrojTelefona; }

    // Original method with adjustments in positioning
    void SklonijRazmake(std::string &str) {
        for(int i = 0; i < str.size(); ++i) {
            if(str[i] == ' ' && (i == 0 || i == str.size() - 1 || str[i - 1] == ' ')) {
                str.erase(str.begin() + i);
                --i;
            }
        }
    }

    void Ispisi() const {
        std::cout << "Broj indeksa: " << BrojIndeksa << std::endl
                  << "Godina studija: " << GodinaStudiranja << std::endl
                  << "Ime i prezime: " << ImeIPrezime << std::endl
                  << "Adresa: " << Adresa << std::endl
                  << "Telefon: " << BrojTelefona << std::endl;
    }
};

// Class definitions for Laptop and Administracija remain unchanged.

int main () {
    // Main function body remains unchanged.
    return 0;
}