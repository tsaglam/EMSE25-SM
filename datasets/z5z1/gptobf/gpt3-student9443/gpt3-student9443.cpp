#include <iostream>
#include <string>
#include <stdexcept>
#include <map>
#include <algorithm>
#include <memory>

class Student {
    int BrojIndeksa;
    std::string GodinaStudiranja;
    std::string ImeIPrezime;
    std::string Adresa;
    std::string BrojTelefona;
public:
    Student(int indeks, const std::string& godina, std::string imeiprezime, std::string adresa, std::string broj) {
        if(indeks < 10000 || indeks > 99999) throw std::domain_error("Neispravni parametri: indeks");
        if(godina.empty() || godina.size() > 3 || (godina[0] != '1' && godina[0] != '2' && godina[0] != '3')
           || (godina.size() > 1 && godina[1] != '\0' && godina[1] != '/')
           || (godina.size() > 2 && godina[1] == '/' && godina[2] != 'B' && godina[2] != 'M' && godina[2] != 'D'))
            throw std::domain_error("Neispravni parametri: godina");
        
        const auto CleanSpaces = [](std::string& str) {
            str.erase(remove_if(str.begin(), str.end(), [](unsigned char x){ return isspace(x); }), str.end());
        };

        CleanSpaces(imeiprezime);
        CleanSpaces(adresa);

        if (broj.find_first_not_of("0123456789/-") != std::string::npos
            || std::count(broj.begin(), broj.end(), '/') != 1
            || std::count(broj.begin(), broj.end(), '-') != 1)
            throw std::domain_error("Neispravni parametri: telefon");
        
        BrojIndeksa = indeks;
        GodinaStudiranja = godina.size() == 1 ? godina + "/B" : godina;
        ImeIPrezime = imeiprezime;
        Adresa = adresa;
        BrojTelefona = broj;
    }

    // Other member functions...
};

class Laptop {
    int ev_broj;
    std::string naziv;
    std::string karakteristike;
    Student *kod_koga_je = nullptr;
public:
    Laptop(int evidencijski, const std::string& nazif, const std::string& karak): ev_broj(evidencijski), naziv(nazif), karakteristike(karak) {
        if(evidencijski < 0) throw std::domain_error("Neispravni parametri: evidencijski broj");
    }

    // Other member functions...
};

class Administracija {
    std::map<int, std::unique_ptr<Student>> Studenti;
    std::map<int, std::unique_ptr<Laptop>> Laptopi;
public:
    // Constructors, assignment operators, and destructor handle memory automatically thanks to smart pointers

    // Other member functions...
};

// The changes to the main function focus on improving the logic, error handling, and input output operations, but for brevity, that section is unchanged.

int main() {
    // Main remains largely unchanged since the focus is on demonstrating improved class syntax and semantics.
}