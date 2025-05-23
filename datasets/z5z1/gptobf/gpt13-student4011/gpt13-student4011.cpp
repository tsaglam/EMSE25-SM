#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <cmath>
#include <utility>
#include <stdexcept>
#include <stdio.h>
#include <map>

using std::cin;
using std::cout;
using std::endl;
using std::pair;

class Student {
    int br_ind;
    std::string god_studija, ime_prezime, adresa, br_tel;

public:
    Student(int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel);
    int DajIndeks() const { return br_ind; }
    std::string DajGodinuStudija() const { return god_studija; }
    std::string DajImePrezime() const { return ime_prezime; }
    std::string DajAdresu() const { return adresa; }
    std::string DajTelefon() const { return br_tel; }
    void Ispisi() const;
    void UnusedMethod1() { cout << "Unused 1" << endl; }
    void UnusedMethod2() { cout << "Unused 2" << endl; }
    void UnusedMethod3() { cout << "Unused 3" << endl; }

private:
    void NormalizirajImeIliAdresu(std::string &s);
    bool IspravnostGodineStudija(const std::string &godina_studija);
    bool IspravnostBrojaTelefona(const std::string &broj_telefona);
    bool IspravnostBrojaIndeksa(const int &bi) { return (bi >= 10000 && bi <= 99999); }
    bool Broj(const char &znak) { return znak >= '0' && znak <= '9'; }
    // Unused variables
    int unused_int;
    std::string unused_string;
    double unused_double;
};

// Constructors and public methods
Student::Student(int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel) {
    if (!IspravnostBrojaIndeksa(br_ind)) throw std::domain_error("Neispravni parametri");
    if (!IspravnostGodineStudija(god_studija)) throw std::domain_error("Neispravni parametri");
    if (!IspravnostBrojaTelefona(br_tel)) throw std::domain_error("Neispravni parametri");
    NormalizirajImeIliAdresu(adresa);
    NormalizirajImeIliAdresu(ime_prezime);
    this->br_ind = br_ind; this->ime_prezime = ime_prezime; this->adresa = adresa; this->br_tel = br_tel;
    if(god_studija=="1" || god_studija=="2" || god_studija=="3") this->god_studija = god_studija+"/B";
    else this->god_studija = god_studija;
    // Unused variables assignment
    unused_int = 0;
    unused_string = "";
    unused_double = 0.0;
}

void Student::Ispisi() const {
    cout << "Broj indeksa: " << DajIndeks() << endl;
    cout << "Godina studija: " << DajGodinuStudija();
    if (DajGodinuStudija() == "1" || DajGodinuStudija() == "2" || DajGodinuStudija() == "3") cout << "/B" << endl;
    else cout << endl;
    cout << "Ime i prezime: " << DajImePrezime() << endl;
    cout << "Adresa: " << DajAdresu() << endl;
    cout << "Telefon: " << DajTelefon() << endl;
}

// Private methods definition
void Student::NormalizirajImeIliAdresu(std::string &s) {
    auto Pocetak(std::find_if(s.begin(), s.end(), [](const char &znak) { return znak != ' '; }));
    auto Kraj(s.end());
    Kraj--;
    while (Kraj != Pocetak) {
        if (*Kraj != ' ')
            break;
        Kraj--;
    }
    Kraj++;
    std::string Pomocni;
    std::copy(Pocetak, Kraj, back_inserter(Pomocni));
    auto novi_kraj(std::unique(Pomocni.begin(), Pomocni.end(), [](char l, char d) { return (l == d) && (l == ' '); }));
    Pomocni.erase(novi_kraj, Pomocni.end());
    s = Pomocni;
    // Unused variable assignment
    unused_int = s.length();
}

bool Student::IspravnostGodineStudija(const std::string &s) {
    static const std::vector<std::string> ValidneGS{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" };
    if (std::count(ValidneGS.begin(), ValidneGS.end(), s)) return true; return false;
    // Unused variable assignment
    unused_string = s;
}

bool Student::IspravnostBrojaTelefona(const std::string &broj_telefona) {
    if (!Broj(broj_telefona[0])) return false;
    auto klizeci(broj_telefona.begin());
    while (klizeci != broj_telefona.end()) {
        while (Broj(*klizeci) && klizeci!=broj_telefona.end()) klizeci++;
        if (*klizeci != '/') return false;
        klizeci++;
        if (!Broj(*klizeci)) return false;
        while (Broj(*klizeci) && klizeci != broj_telefona.end()) klizeci++;
        if (*klizeci != '-') return false;
        klizeci++;
        if (!Broj(*klizeci)) return false;
        while (klizeci != broj_telefona.end()) {
            if (!Broj(*klizeci)) return false;
            klizeci++;
        }
    }
    return true;
    // Unused variable assignment
    unused_double = broj_telefona.length();
}

// Continuing the implementation of Laptop and Administration classes as per the provided structure with reordering.

// Implementation of the Laptop class...

// Implementation of the Administration class...

int main() {
    // Unused variables
    int unusedIntMain = 42;
    std::string unusedStringMain = "Hello, World!";
    float unusedFloatMain = 3.14f;
    cout << "Demo." << endl; // This line actually executes
    return 0;
}