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
using std::back_inserter;

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
private:
    void NormalizirajImeIliAdresu(std::string &s);
    bool IspravnostGodineStudija(const std::string &godina_studija);
    bool IspravnostBrojaTelefona(const std::string &broj_telefona);
    bool IspravnostBrojaIndeksa(const int &bi) { return (bi >= 10000 && bi <= 99999); }
    bool Broj(const char &znak) { return znak >= '0' && znak <= '9'; }
};

class Laptop {
    int ev_broj;
    std::string naziv, karakteristike;
    Student *kod_koga_je;

public:
    Laptop(int ev_broj, std::string naziv, std::string karakteristike);
    int DajEvidencijskiBroj() const { return ev_broj; }
    std::string DajNaziv() const { return naziv; }
    std::string DajKarakteristike() const { return karakteristike; }
    void Zaduzi(Student &stud);
    void Razduzi();
    bool DaLiJeZaduzen();
    Student& DajKodKogaJe();
    Student* DajPokKodKogaJe();
    void Ispisi() const;
};

class Administracija {
    std::map<int, Student*> Studenti;
    std::map<int, Laptop*> Laptopi;

public:
    Administracija();
    Administracija(const Administracija &a);
    Administracija(Administracija &&a);
    ~Administracija();
    Administracija &operator =(const Administracija &a);
    Administracija &operator =(Administracija &&a);
    void RegistrirajNovogStudenta(int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel);
    void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike);
    Student& NadjiStudenta(int brind);
    Laptop& NadjiLaptop(int evbr);
    void IzlistajStudente() const;
    void IzlistajLaptope() const;
    void ZaduziLaptop(int brind, int evbr);
    void RazduziLaptop(int evbroj);
    void PrikaziZaduzenja() const;
    int NadjiSlobodniLaptop();
private:
    Student NadjiStudenta(int brind) const;
    Laptop NadjiLaptop(int evbr) const;
};

// Implementations of Student methods

// Implementations of Laptop methods

// Implementations of Administracija methods

int main() {
    // Your main program logic here

    return 0;
}