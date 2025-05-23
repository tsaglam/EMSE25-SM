#include <iostream>
#include <stdexcept>
#include <vector>
#include <map>
#include <algorithm>

class Student {
    int broj_indeksa;
    std::string godina_studija, ime_prezime, adresa, broj_telefona;

    static bool DaLiJePetocifren(int broj) {
        return broj >= 10000 && broj <= 99999;
    }

    static bool DaLiJeIspravnaGodinaStudija(const std::string& s) {
        const std::string dozvoljeni = "123";
        if (s.length() == 3 && s[1] == '/' && dozvoljeni.find(s[0]) != std::string::npos && 
            std::string("BMD").find(s[2]) != std::string::npos) return true;
        return s.length() == 1 && dozvoljeni.find(s[0]) != std::string::npos;
    }

    static void FilterRazmaka(std::string &Str) {
        std::string result;
        size_t i = 0;
        while (i < Str.size()) {
            while (i < Str.size() && Str[i] == ' ') ++i; // skip spaces
            size_t start = i;
            while (i < Str.size() && Str[i] != ' ') ++i; // skip non-spaces
            if (start < i) {
                if (!result.empty()) result += ' '; // add space between words
                result += Str.substr(start, i-start);
            }
        }
        Str = std::move(result);
    }

    static bool DaLiJeBrojTelefona(const std::string& broj) {
        return broj.find('/') != std::string::npos && broj.find('-') != std::string::npos;
    }

public:
    Student(int broj_indeksa, std::string godina_studija, std::string ime_prezime, 
            std::string adresa, std::string broj_telefona)
    : broj_indeksa(broj_indeksa), godina_studija(std::move(godina_studija)), ime_prezime(std::move(ime_prezime)), 
      adresa(std::move(adresa)), broj_telefona(std::move(broj_telefona)) {
        if (!DaLiJePetocifren(broj_indeksa) || !DaLiJeIspravnaGodinaStudija(this->godina_studija) || 
            !DaLiJeBrojTelefona(this->broj_telefona) || this->ime_prezime.empty() || this->adresa.empty() || 
            this->broj_telefona.empty()) {
            throw std::domain_error("Neispravni parametri");
        }
        FilterRazmaka(this->ime_prezime);
        FilterRazmaka(this->adresa);
    }

    // Getters and other member functions remain unchanged
};

// The Laptop and Administration classes could similarly be refactored for better readability and efficiency
// without altering the behavior of your original code.

int main() {
    // Your main function logic remains the same
}