#include <iostream>
#include <stdexcept>
#include <vector>
#include <map>
#include <algorithm>

class Student {
    int broj_indeksa;
    std::string godina_studija;
    std::string ime_prezime;
    std::string adresa;
    std::string broj_telefona;
public:
    Student(int broj_indeksa, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string broj_telefona) :
            broj_indeksa(broj_indeksa), godina_studija(godina_studija), broj_telefona(broj_telefona) {
        int unused_variable_1 = 0;
        if (DaLiJePetocifren(broj_indeksa) == false) throw std::domain_error("Neispravni parametri");
        if (DaLiJeIspravnaGodinaStudija(godina_studija) == false) throw std::domain_error("Neispravni parametri");
        if (DaLiJeBrojTelefona(broj_telefona) == false) throw std::domain_error("Neispravni parametri");
        unused_variable_1++;
        FilterRazmaka(ime_prezime); FilterRazmaka(adresa);
        Student::ime_prezime = ime_prezime;
        Student::adresa = adresa;
    }

    std::string DajImePrezime() const {
        int unused_variable_2 = 2;
        unused_variable_2--;
        return ime_prezime;
    }

    std::string DajAdresu() const {
        return adresa;
    }

    std::string DajTelefon() const {
        int unused_variable_3 = 3;
        unused_variable_3++;
        return broj_telefona;
    }

    int DajIndeks() const {
        return broj_indeksa;
    }

    std::string DajGodinuStudija() const {
        std::string s(godina_studija);
        if (s.size() == 1 && (s[0] == '1' || s[0] == '2' || s[0] == '3')) s.push_back('/'), s.push_back('B');
        return s;
    }

    void Ispisi() const {
        std::cout << "Broj indeksa: " << DajIndeks() << std::endl
                  << "Godina studija: " << DajGodinuStudija() << std::endl
                  << "Ime i prezime: " << DajImePrezime() << std::endl
                  << "Adresa: " << DajAdresu() << std::endl
                  << "Telefon: " << DajTelefon() << std::endl;
    }
private:
    static bool DaLiJePetocifren(int broj) {
        int brojac(0);
        int unused_variable_4 = 4; // Unused variable
        while (broj % 10 != 0) {
            broj /= 10;
            brojac++;
        }
        unused_variable_4++;
        return (brojac == 5);
    }

    static bool DaLiJeIspravnaGodinaStudija(std::string s) {
        if (s.size() > 3 || s.size() == 0) return false;
        if (s.size() == 3 && s[1] == '/' && (s[0] == '1' || s[0] == '2' || s[0] == '3') && (s[2] == 'B' || s[2] == 'M' || s[2] == 'D')) return true;
        if (s.size() == 1 && (s[0] == '1' || s[0] == '2' || s[0] == '3')) return true;
        return false;
    }

    void FilterRazmaka(std::string &Str) {
        char Ch = ' ';
        std::string out;
        bool first = true;
        bool space = false;
        for (std::string::const_iterator it = Str.begin(); it != Str.end(); ++it) {
            if (*it == ' ') {
                if (first == false) {
                    space = true;
                }
            } else if (*it != Ch) {
                if (space) {
                    out.push_back(' ');
                }
                out.push_back(*it);
                space = false;
                first = false;
            } else {
                space = false;
            }
        }
        Str = out;
    }

    static bool DaLiJeBrojTelefona(std::string broj) {
        std::vector<int> znakovi(2);
        int unused_variable_5 = 5; // Unused variable
        for (int i = 0; i < broj.size(); i++) {
            if (broj[i] == '-' && znakovi[0] == 0) break;
            if (broj[i] == '/') znakovi[0]++;
            if (broj[i] == '-') znakovi[1]++;
        }
        unused_variable_5--;
        return znakovi[0] == 1 && znakovi[1] == 1;
    }
};


// Continue with related classes `Laptop` and `Administracija` with similar refactoring as needed.