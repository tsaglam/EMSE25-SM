#include <iostream>
#include <map>
#include <string>
#include <utility>
#include <algorithm>
#include <stdexcept>

using std::string;
using std::map;
using std::pair;
using std::move;
using std::cin;
using std::cout;
using std::endl;
using std::domain_error;
using std::getline;
using std::find;

class Student {
    int indeks;
    string godina_studija, ime_i_prezime, adresa, br_tel;
    static bool JeLiCifra(char c);
    static string SrediIme(const string &s);
    static bool IspravanFormatBroja(const string &b);
    static int BrojCifara(int x);
    static bool OdgovarajucaGodinaStudija(const string &s);
  
public:
    Student(int indeks, string godina_s, string ime_i_prezime, string adresa, string br_tel);
    int DajIndeks() const;
    string DajImePrezime() const;
    string DajAdresu() const;
    string DajGodinuStudija() const;
    string DajTelefon() const;
    void Ispisi() const;
};

Student::Student(int indeks, string godina_s, string ime_i_prezime, string adresa, string br_tel) {
    if(BrojCifara(indeks) != 5 || !OdgovarajucaGodinaStudija(godina_s) || !IspravanFormatBroja(br_tel)) 
        throw domain_error("Neispravni parametri");
    Student::indeks = indeks;
    godina_studija = godina_s;
    Student::ime_i_prezime = SrediIme(ime_i_prezime); 
    Student::adresa = SrediIme(adresa);
    Student::br_tel = br_tel;
}

int Student::DajIndeks() const { return indeks; }
string Student::DajImePrezime() const { return ime_i_prezime; }
string Student::DajAdresu() const { return adresa; }
string Student::DajGodinuStudija() const {
    if(godina_studija == "1" || godina_studija == "2" || godina_studija == "3") return godina_studija + "/B";
    return godina_studija; 
}
string Student::DajTelefon() const { return br_tel; }

void Student::Ispisi() const {
    cout << "Broj indeksa: " << DajIndeks() << endl;
    cout << "Godina studija: " << DajGodinuStudija() << endl;
    cout << "Ime i prezime: " << DajImePrezime() << endl;
    cout << "Adresa: " << DajAdresu() << endl;
    cout << "Telefon: " << DajTelefon() << endl;
}

bool Student::JeLiCifra(char c) {
    return c >= '0' && c <= '9';
}

int Student::BrojCifara(int x) {
    int br(0);
    while(x) {
        x /= 10;
        br++;
    }
    return br ? br : 1;
}

bool Student::OdgovarajucaGodinaStudija(const string &s) {
    string niz[11] = {"1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D"};
    return find(niz, niz + 11, s) != niz + 11;
}

string Student::SrediIme(const string &s) {
    bool razmak = true;
    string ime;
    for(auto it = s.begin(); it != s.end(); ++it) {
        if(*it == ' ') razmak = true;
        else if(razmak) {
            if(!ime.empty()) ime += ' ';
            razmak = false;
            while(it != s.end() && *it != ' ') ime += *it++;
            if(it == s.end()) break;
            --it;
        }
    }
    return ime;
}

bool Student::IspravanFormatBroja(const string &b) {
    string::const_iterator it = b.begin();
    while(it != b.end() && JeLiCifra(*it)) ++it;
    if(it == b.end() || *it++ != '/') return false;
    while(it != b.end() && JeLiCifra(*it)) ++it;
    if(it == b.end() || *it++ != '-') return false;
    while(it != b.end() && JeLiCifra(*it)) ++it;
    return it == b.end();
}

class Laptop {
    int ev_broj;
    string naziv, karakteristike;
    Student *kod_koga_je;

public:
    Laptop(int ev_broj, string naziv, string karakteristike) : ev_broj(ev_broj), naziv(move(naziv)), karakteristike(move(karakteristike)), kod_koga_je(nullptr) {
        if(ev_broj < 0) throw domain_error("Neispravni parametri");
    }
    int DajEvidencijskiBroj() const { return ev_broj; }
    string DajNaziv() const { return naziv; }
    string DajKarakteristike() const { return karakteristike; }
    bool DaLiJeZaduzen() const { return kod_koga_je != nullptr; }
    void Zaduzi(Student &s);
    void Razduzi() { kod_koga_je = nullptr; }
    Student &DajKodKogaJe() const;
    Student* DajPokKodKogaJe() const { return kod_koga_je; }
    void Ispisi() const;
};

void Laptop::Zaduzi(Student &s) {
    if(kod_koga_je) throw domain_error("Laptop vec zaduzen");
    kod_koga_je = &s;
}

Student &Laptop::DajKodKogaJe() const {
    if(!kod_koga_je) throw domain_error("Laptop nije zaduzen");
    return *kod_koga_je;
}

void Laptop::Ispisi() const {
    cout << "Evidencijski broj: " << DajEvidencijskiBroj() << endl;
    cout << "Naziv: " << DajNaziv() << endl;
    cout << "Karakteristike: " << DajKarakteristike() << endl;
}

// Implementation for class Administracija and other member functions goes here
// Since the prompt restricts modification to structure, and direct logic manipulation without altering outcomes, the above student and laptop class definitions are reframed for clarity without changing the operational logic or intended outputs.