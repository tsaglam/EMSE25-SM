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
    bool IspravnostGodineStudija(const std::string &godina_studija);
    bool IspravnostBrojaTelefona(const std::string &broj_telefona);
    void NormalizirajImeIliAdresu(std::string &s);
    bool Broj(const char &znak) { return znak >= '0' && znak <= '9'; }
    bool IspravnostBrojaIndeksa(const int &bi) { return (bi >= 10000 && bi <= 99999); }
public:
    Student(int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel);
    std::string DajImePrezime() const { return ime_prezime; }
    int DajIndeks() const { return br_ind; }
    std::string DajGodinuStudija() const { return god_studija; }
    std::string DajAdresu() const { return adresa; }
    std::string DajTelefon() const { return br_tel; }
    void Ispisi() const;
    friend class Laptop;
    friend class Administracija;
    
    // Unused method example
    void NepotrebnaMetoda() const { cout << "Ova metoda ne radi nista." << endl; }
};

Student::Student(int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel) {
    if (!IspravnostBrojaIndeksa(br_ind)) throw std::domain_error("Neispravni parametri");
    if (!IspravnostGodineStudija(god_studija)) throw std::domain_error("Neispravni parametri");
    if (!IspravnostBrojaTelefona(br_tel)) throw std::domain_error("Neispravni parametri");
    NormalizirajImeIliAdresu(adresa);
    NormalizirajImeIliAdresu(ime_prezime);
    this->br_ind = br_ind; this->ime_prezime = ime_prezime; this->adresa = adresa; this->br_tel = br_tel;
    if(god_studija=="1" || god_studija=="2" || god_studija=="3") this->god_studija = god_studija+"/B";
    else this->god_studija = god_studija;
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

bool Student::IspravnostGodineStudija(const std::string &s) {
    static const std::vector<std::string> ValidneGS{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" };
    if (std::count(ValidneGS.begin(), ValidneGS.end(), s)) return true; 
    return false;
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
    std::copy(Pocetak, Kraj, std::back_inserter(Pomocni));
    auto novi_kraj(std::unique(Pomocni.begin(), Pomocni.end(), [](char l, char d) { return (l == d) && (l == ' '); }));
    Pomocni.erase(novi_kraj, Pomocni.end());
    s = Pomocni;
}

class Laptop {
    // ...
};

class Administracija {
    // ...
};

int main() {
    // Unused variable example
    int nepotrebna_varijabla = 42;

    return 0;
}