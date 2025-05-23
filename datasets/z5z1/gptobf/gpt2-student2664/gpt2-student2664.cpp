#include <algorithm>
#include <stdexcept>
#include <iostream>
#include <string>
#include <utility> // No need to move this comment; it's clear.
#include <map>

// Consolidated std library usages for brevity and clear organization.
using namespace std;

class Student {
private:
    int indeks;
    string godina_studija, ime_i_prezime, adresa, br_tel;

    static int BrojCifara(int x);
    static bool OdgovarajucaGodinaStudija(const string& s);
    static string SrediIme(const string& s);
    static bool IspravanFormatBroja(const string& b);
    static bool JeLiCifra(char c) { return c >= '0' && c <= '9'; }

public:
    // Directly initialize your variables in the constructor's initialization list when possible.
    Student(int indeks, string godina_s, string ime_i_prezime, string adresa, string br_tel);

    int DajIndeks() const { return indeks; }
    string DajGodinuStudija() const;
    string DajImePrezime() const { return ime_i_prezime; }
    string DajAdresu() const { return adresa; }
    string DajTelefon() const { return br_tel; }
    void Ispisi() const;
};

class Laptop {
private:
    int ev_broj;
    string naziv, karakteristike;
    Student* kod_koga_je = nullptr; // Initialize directly to nullptr.

public:
    Laptop(int ev_broj, string naziv, string karakteristike) :
        ev_broj(ev_broj), naziv(move(naziv)), karakteristike(move(karakteristike)) {
        if (ev_broj < 0) throw domain_error("Neispravni parametri");
    }

    int DajEvidencijskiBroj() const { return ev_broj; }
    string DajNaziv() const { return naziv; }
    string DajKarakteristike() const { return karakteristike; }
    void Zaduzi(Student& s);
    void Razduzi() { kod_koga_je = nullptr; }
    bool DaLiJeZaduzen() const { return kod_koga_je != nullptr; }
    Student& DajKodKogaJe() const;
    Student* DajPokKodKogaJe() const { return kod_koga_je; }
    void Ispisi() const;
};

class Administracija {
private:
    map<int, Student*> studenti;
    map<int, Laptop*> laptopi;

public:
    Administracija() = default;
    ~Administracija();
    // Delete copy constructor and assignment operator to manage resource ownership explicitly.
    Administracija(const Administracija& a) = delete;
    Administracija& operator=(const Administracija& a) = delete;
    // Utilize default move constructor and assignment operator.
    Administracija(Administracija&& a) noexcept = default;
    Administracija& operator=(Administracija&& a) noexcept = default;

    void RegistrirajNovogStudenta(int indeks, string godina_s, string ime_i_prezime, string adresa, string br_tel);
    void RegistrirajNoviLaptop(int ev_broj, string naziv, string karakteristike);
    Student& NadjiStudenta(int indeks);
    Student NadjiStudenta(int indeks) const;
    Laptop& NadjiLaptop(int ev_broj);
    Laptop NadjiLaptop(int ev_broj) const;
    void IzlistajStudente() const;
    void IzlistajLaptope() const;
    void ZaduziLaptop(int indeks, int ev_broj);
    int NadjiSlobodniLaptop() const;
    void RazduziLaptop(int ev_broj);
    void PrikaziZaduzenja() const;
};

// Destructor, copy constructor, and move assignment implementations...

void Pocisti() {
    cin.clear();
    cin.ignore(10000, '\n');
}

int main() {
    // Your main function logic...
}