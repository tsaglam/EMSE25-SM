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
        if (s.empty() || s.size() > 3) return false;
        if (s.size() == 3) return s[1] == '/' && (s[0] >= '1' && s[0] <= '3') && (s[2] == 'B' || s[2] == 'M' || s[2] == 'D');
        return s.size() == 1 && (s[0] >= '1' && s[0] <= '3');
    }

    static void FilterRazmaka(std::string& str) {
        str.erase(std::unique(str.begin(), str.end(), [](char a, char b){ return a == ' ' && b == ' '; }), str.end());
        if (str.front() == ' ') str.erase(str.begin());
        if (str.back() == ' ') str.pop_back();
    }

    static bool DaLiJeBrojTelefona(const std::string& broj) {
        return broj.find('/') != std::string::npos && broj.find('-') != std::string::npos;
    }

public:
    Student(int broj_indeksa, const std::string& godina_studija, std::string ime_prezime, std::string adresa, const std::string& broj_telefona)
        : broj_indeksa(broj_indeksa), godina_studija(godina_studija), broj_telefona(broj_telefona) {
        if (!DaLiJePetocifren(broj_indeksa) || !DaLiJeIspravnaGodinaStudija(godina_studija) || 
            !DaLiJeBrojTelefona(broj_telefona) || godina_studija.empty() || ime_prezime.empty() || adresa.empty() || broj_telefona.empty())
            throw std::domain_error("Neispravni parametri");
        
        FilterRazmaka(ime_prezime);
        FilterRazmaka(adresa);
        this->ime_prezime = ime_prezime;
        this->adresa = adresa;
    }

    void Ispisi() const {
        std::cout << "Broj indeksa: " << broj_indeksa << std::endl
                  << "Godina studija: " << DajGodinuStudija() << std::endl
                  << "Ime i prezime: " << ime_prezime << std::endl
                  << "Adresa: " << adresa << std::endl
                  << "Telefon: " << broj_telefona << std::endl;
    }

    std::string DajGodinuStudija() const {
        if(godina_studija.size() == 1) return godina_studija + "/B";
        return godina_studija;
    }

    int DajIndeks() const { return broj_indeksa; }
    std::string DajImePrezime() const { return ime_prezime; }
    std::string DajAdresu() const { return adresa; }
    std::string DajTelefon() const { return broj_telefona; }
}; // End of Student class

// Assume Laptop and Administracija classes and main function are here but omitted for brevity

int main() {
    // Your main logic remains, assuming other classes adapted similarly for code brevity
    return 0;
}