#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <cmath>
#include <utility>
#include <stdexcept>
#include <stdio.h>
#include <map>
#include <memory>

using namespace std;

class Student {
    int br_ind;
    string god_studija, ime_prezime, adresa, br_tel;
    void NormalizirajImeIliAdresu(string &s);
    bool IspravnostGodineStudija(const string &godina_studija);
    bool IspravnostBrojaTelefona(const string &broj_telefona);
    bool IspravnostBrojaIndeksa(const int &bi) const { return bi >= 10000 && bi <= 99999; }
    static bool Broj(const char &znak) { return znak >= '0' && znak <= '9'; }
public:
    Student(int br_ind, string god_studija, string ime_prezime, string adresa, string br_tel);
    int DajIndeks() const { return br_ind; }
    string DajGodinuStudija() const { return god_studija; }
    string DajImePrezime() const { return ime_prezime; }
    string DajAdresu() const { return adresa; }
    string DajTelefon() const { return br_tel; }
    void Ispisi() const;
};

class Laptop {
    int ev_broj;
    string naziv, karakteristike;
    Student *kod_koga_je = nullptr;
public:
    Laptop(int ev_broj, string naziv, string karakteristike);
    int DajEvidencijskiBroj() const { return ev_broj; }
    string DajNaziv() const { return naziv; }
    string DajKarakteristike() const { return karakteristike; }
    void Zaduzi(Student &stud);
    void Razduzi();
    bool DaLiJeZaduzen() const;
    Student& DajKodKogaJe() const;
    void Ispisi() const;
};

class Administracija {
    map<int, unique_ptr<Student>> Studenti;
    map<int, unique_ptr<Laptop>> Laptopi;
public:
    Administracija() = default;
    Administracija(const Administracija &a);
    Administracija(Administracija &&a) = default;
    Administracija &operator=(const Administracija &a);
    Administracija &operator=(Administracija &&a) = default;
    void RegistrirajNovogStudenta(int br_ind, string god_studija, string ime_prezime, string adresa, string br_tel);
    void RegistrirajNoviLaptop(int ev_broj, string naziv, string karakteristike);
    Student& NadjiStudenta(int brind);
    Laptop& NadjiLaptop(int evbr);
    void IzlistajStudente() const;
    void IzlistajLaptope() const;
    void ZaduziLaptop(int brind, int evbr);
    void RazduziLaptop(int evbroj);
    void PrikaziZaduzenja() const;
};

// Implement Student and Laptop member functions as provided in the original code
// Implement Administracija member functions with encapsulation and ownership semantics
// Ensure that Laptop now properly manages Student* using informative methods without owning it
// Use unique_ptr for resource management in Administracija to automatically handle clean-up

int main() {
    return 0;
}