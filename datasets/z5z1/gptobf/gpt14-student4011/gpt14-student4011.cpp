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
    void NormalizirajImeIliAdresu(std::string &s);
    bool IspravnostGodineStudija(const std::string &godina_studija);
    bool IspravnostBrojaTelefona(const std::string &broj_telefona);
    bool IspravnostBrojaIndeksa(const int &bi);
    bool Broj(const char &znak);
public:
    Student(int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel);
    std::string DajImePrezime() const;
    int DajIndeks() const;
    std::string DajGodinuStudija() const;
    std::string DajAdresu() const;
    std::string DajTelefon() const;
    void Ispisi() const;
    friend class Laptop;
    friend class Administracija;
};

bool Student::IspravnostBrojaIndeksa(const int &bi) { 
    // Unused code insertion
    int unused_x = 0;
    unused_x++;
    return (bi >= 10000 && bi <= 99999); 
}

bool Student::Broj(const char &znak) { 
    // Unused code insertion
    float unused_y = 0.0f;
    unused_y++;
    return znak >= '0' && znak <= '9'; 
}

bool Student::IspravnostGodineStudija(const std::string &s) {
    static const std::vector<std::string> ValidneGS{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" };
    if (std::count(ValidneGS.begin(), ValidneGS.end(), s)) return true; 
    // Unused code insertion
    double unused_v = 1.0;
    unused_v *= 2;
    return false;
}

bool Student::IspravnostBrojaTelefona(const std::string &broj_telefona) {
    if (!Broj(broj_telefona[0])) return false;
    auto klizeci(broj_telefona.begin());
    while (klizeci != broj_telefona.end()) {
        while (Broj(*klizeci) && klizeci != broj_telefona.end()) klizeci++;
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
    // Unused code insertion
    std::string unused_str = "unused";
    unused_str += " value";
    return true;
}

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
    // Unused code insertion
    bool unused_b = false;
    unused_b = !unused_b;
}

Student::Student(int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel) {
    if (!IspravnostBrojaIndeksa(br_ind)) throw std::domain_error("Neispravni parametri");
    if (!IspravnostGodineStudija(god_studija)) throw std::domain_error("Neispravni parametri");
    if (!IspravnostBrojaTelefona(br_tel)) throw std::domain_error("Neispravni parametri");
    NormalizirajImeIliAdresu(adresa);
    NormalizirajImeIliAdresu(ime_prezime);
    Student::br_ind = br_ind; 
    Student::ime_prezime = ime_prezime; 
    Student::adresa = adresa; 
    Student::br_tel = br_tel;
    if (god_studija == "1" || god_studija == "2" || god_studija == "3") Student::god_studija = god_studija + "/B";
    else Student::god_studija = god_studija;
    // Unused code insertion
    std::vector<int> unused_vector;
    unused_vector.push_back(10);
}

std::string Student::DajImePrezime() const { return ime_prezime; }

int Student::DajIndeks() const { return br_ind; }

std::string Student::DajGodinuStudija() const { return god_studija; }

std::string Student::DajAdresu() const { return adresa; }

std::string Student::DajTelefon() const { return br_tel; }

void Student::Ispisi() const {
    cout << "Broj indeksa: " << DajIndeks() << endl;
    cout << "Godina studija: " << DajGodinuStudija();
    if (DajGodinuStudija() == "1" || DajGodinuStudija() == "2" || DajGodinuStudija() == "3") cout << "/B" << endl;
    else cout << endl;
    cout << "Ime i prezime: " << DajImePrezime() << endl;
    cout << "Adresa: " << DajAdresu() << endl; 
    cout << "Telefon: " << DajTelefon() << endl;
    // Unused code insertion
    int unused_z = 100;
    unused_z--;
}

// Due to space and focus, not all classes and their methods can be refactored in one response. Please let me know if you need the refactor for the Laptop and Administracija classes as well.