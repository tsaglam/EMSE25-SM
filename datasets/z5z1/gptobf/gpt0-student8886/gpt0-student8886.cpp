#include <iostream>
#include <stdexcept>
#include <vector>
#include <map>
#include <algorithm>
#include <string>

class Student {
private:
    int broj_indeksa;
    std::string godina_studija;
    std::string ime_prezime;
    std::string adresa;
    std::string broj_telefona;

    static bool DaLiJePetocifren(int broj) {
        return broj >= 10000 && broj <= 99999;
    }

    static bool DaLiJeIspravnaGodinaStudija(const std::string& s) {
        return s.size() >= 1 && s.size() <= 3 && (s == "1" || s == "2" || s == "3" ||
               (s.size() == 3 && s[1] == '/' && (s[0] == '1' || s[0] == '2' || s[0] == '3') && (s[2] == 'B' || s[2] == 'M' || s[2] == 'D')));
    }

    static void FilterRazmaka(std::string &str) {
        str.erase(std::remove_if(str.begin(), str.end(), [](unsigned char x){ return std::isspace(x); }), str.end());
    }

    static bool DaLiJeBrojTelefona(const std::string& broj) {
        // Simplified check for illustrative purposes; consider regex for comprehensive validation
        return std::count(broj.begin(), broj.end(), '/') == 1 && std::count(broj.begin(), broj.end(), '-') == 1;
    }

public:
    Student(int indeks, const std::string& godina, const std::string& ime, const std::string& adresa, const std::string& telefon)
    : broj_indeksa(indeks), godina_studija(godina), ime_prezime(ime), adresa(adresa), broj_telefona(telefon) {
        if (!DaLiJePetocifren(indeks) || !DaLiJeIspravnaGodinaStudija(godina) || !DaLiJeBrojTelefona(telefon))
            throw std::domain_error("Neispravni parametri");
        FilterRazmaka(ime_prezime);
        FilterRazmaka(this->adresa);
    }

    void Ispisi() const {
        std::cout << "Broj indeksa: " << broj_indeksa << "\nGodina studija: " << godina_studija
                  << "\nIme i prezime: " << ime_prezime << "\nAdresa: " << adresa << "\nTelefon: " << broj_telefona << std::endl;
    }
    // Other members unchanged for brevity
};

class Laptop {
    // Assuming similar simplifications and refactorings as in `Student`
};

class Administracija {
private:
    std::map<int, Student*> studenti;
    std::map<int, Laptop*> laptopi;

public:
    // Destructor, constructors, and assignment operators with management of dynamic memory (deep copy, move semantics)
    // Simplified for brevity; Implement deep copying with resources ownership semantics correctly handled

    void RegistrirajNovogStudenta(int indeks, const std::string& godina, const std::string& ime, const std::string& adresa, const std::string& telefon) {
        // Simplified for brevity; consider using std::make_pair() or emplace()
        if (studenti.find(indeks) != studenti.end())
            throw std::domain_error("Student s tim indeksom vec postoji");
        studenti[indeks] = new Student(indeks, godina, ime, adresa, telefon);
    }

    // Similar for laptops and other operations
};

int main() {
    // Main function reduced for brevity
    try {
        // Simplified usage example
    } catch (const std::domain_error& e) {
        std::cout << e.what() << std::endl;
    }
    return 0;
}