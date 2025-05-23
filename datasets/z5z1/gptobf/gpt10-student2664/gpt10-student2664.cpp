#include <algorithm>
#include <stdexcept>
#include <iostream>
#include <string>
#include <utility>
#include <map>
using std::pair;
using std::map;
using std::move;
using std::string;
using std::cin;
using std::cout;
using std::endl;
using std::domain_error;
using std::getline;
using std::find;

class Student {
  public:
    Student(int indeks, string godina_s, string ime_i_prezime, string adresa, string br_tel);
    int DajIndeks() const { return indeks; }
    string DajGodinuStudija() const;
    string DajImePrezime() const { return ime_i_prezime; }
    string DajAdresu() const { return adresa; }
    string DajTelefon() const { return br_tel; }
    void Ispisi() const {
        cout << "Broj indeksa: " << DajIndeks() << endl;
        cout << "Godina studija: " << DajGodinuStudija() << endl;
        cout << "Ime i prezime: " << DajImePrezime() << endl;
        cout << "Adresa: " << DajAdresu() << endl;
        cout << "Telefon: " << DajTelefon() << endl;
    }
  private:
    int indeks;
    string godina_studija, ime_i_prezime, adresa, br_tel;
    static int BrojCifara(int x); 
    static bool OdgovarajucaGodinaStudija(const string &s);
    static string SrediIme(const string &s);
    static bool IspravanFormatBroja(const string &b);
    static bool JeLiCifra(char c) {
        if(c <= '9' && c >= '0') return true;
        return false;
    }
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
int Student::BrojCifara(int x) {
    if(x == 0) return 1;
    int br(0);
    do{
        br++, x /= 10;
    }while(x != 0);
    return br;
}
bool Student::OdgovarajucaGodinaStudija(const string &s) {
    string niz[11]{"1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D"};
    if(find(niz, niz+11, s) != niz+11) return true;
    return false;
}
string Student::SrediIme(const string &s) {
    bool razmak(true);
    string ime;
    for(auto it = s.begin(); it != s.end(); it++) {
        if(*it == ' ') razmak = true;
        else if(razmak){
            razmak = false;
            if(ime.length() > 0) ime += ' ';
            while(it != s.end() && *it != ' ') ime += *it++;
            if(it == s.end()) break;
            it--;
        }
    }
    return ime;
}
bool Student::IspravanFormatBroja(const string &b) {
    auto it = b.begin();
    if(it == b.end() || !JeLiCifra(*it++)) return false;
    while(it != b.end() && JeLiCifra(*it)) it++;
    if(it == b.end() || *it++ != '/') return false;
    while(it != b.end() && JeLiCifra(*it)) it++;
    if(it == b.end() || *it++ != '-') return false;
    if(it == b.end() || !JeLiCifra(*it++)) return false;
    while(it != b.end() && JeLiCifra(*it)) it++;
    return it == b.end();
}
string Student::DajGodinuStudija() const {
    if(godina_studija == "1" || godina_studija == "2" || godina_studija == "3") return godina_studija + "/B";
    return godina_studija; 
} 

class Laptop {
  public:
    Laptop(int ev_broj, string naziv, string karakteristike) : 
        naziv(naziv), karakteristike(karakteristike), kod_koga_je(nullptr) {
            if(ev_broj < 0) throw domain_error("Neispravni parametri"); 
            Laptop::ev_broj = ev_broj;
        }
    int DajEvidencijskiBroj() const { return ev_broj; }
    string DajNaziv() const { return naziv; }
    string DajKarakteristike() const { return karakteristike; }
    bool DaLiJeZaduzen() const { return kod_koga_je != nullptr; }
    void Zaduzi(Student &s) {
        if(kod_koga_je != nullptr) throw domain_error("Laptop vec zaduzen");
        kod_koga_je = &s; 
    }
    void Razduzi() { kod_koga_je = nullptr; }
    Student &DajKodKogaJe() const { 
        if(kod_koga_je == nullptr) throw domain_error("Laptop nije zaduzen");
        return *kod_koga_je;
    }
    Student* DajPokKodKogaJe() const { 
        return kod_koga_je;
    }
    void Ispisi() const {
        cout << "Evidencijski broj: " << DajEvidencijskiBroj() << endl;
        cout << "Naziv: " << DajNaziv() << endl;
        cout << "Karakteristike: " << DajKarakteristike() << endl;
    }
  private:
    int ev_broj;
    string naziv, karakteristike;
    Student *kod_koga_je;
};

class Administracija {
  public:
    explicit Administracija() {} 
    ~Administracija();
    Administracija(const Administracija &a);
    Administracija(Administracija &&a);
    Administracija &operator =(const Administracija &a);
    Administracija &operator =(Administracija &&a);

    void RegistrirajNovogStudenta(int indeks, string godina_s, string ime_i_prezime, string adresa, string br_tel);
    void RegistrirajNoviLaptop(int ev_broj, string naziv, string karakteristike);
    Student &NadjiStudenta(int indeks);
    Student NadjiStudenta(int indeks) const;
    Laptop &NadjiLaptop(int ev_broj);
    Laptop NadjiLaptop(int ev_broj) const;
    void IzlistajStudente() const;
    void IzlistajLaptope() const;
    void ZaduziLaptop(int indeks, int ev_broj);
    int NadjiSlobodniLaptop() const;
    void RazduziLaptop(int ev_broj);
    void PrikaziZaduzenja() const;
  private:
    map<int, Student*> studenti;
    map<int, Laptop*> laptopi;
};
Administracija::~Administracija(){
    for(auto &par : studenti) delete par.second;
    for(auto &par : laptopi) delete par.second;
}
Administracija::Administracija(const Administracija &a) : studenti(), laptopi() {
    try {
        for(const auto &par : a.studenti) studenti[par.first] = new Student(*par.second);
        for(const auto &par : a.laptopi) laptopi[par.first] = new Laptop(*par.second);
    } catch(...) {
        for(auto &par : studenti) delete par.second;
        for(auto &par : laptopi) delete par.second;
        throw;
    }
}
Administracija::Administracija(Administracija &&a): studenti(move(a.studenti)), laptopi(move(a.laptopi)) {
}
Administracija &Administracija::operator =(const Administracija &a) {
    if(&a != this) {
        for(auto &par : studenti) delete par.second;
        for(auto &par : laptopi) delete par.second;
        studenti.clear();
        laptopi.clear();
        for(const auto &par : a.studenti) studenti[par.first] = new Student(*par.second);
        for(const auto &par : a.laptopi) laptopi[par.first] = new Laptop(*par.second);
    }
    return *this;
}
Administracija &Administracija::operator =(Administracija &&a) {
    if(&a != this) {
        for(auto &par : studenti) delete par.second;
        for(auto &par : laptopi) delete par.second;
        studenti = move(a.studenti);
        laptopi = move(a.laptopi);
    }
    return *this;
}
void Administracija::RegistrirajNovogStudenta(int indeks, string godina_s, string ime_i_prezime, string adresa, string br_tel) {
    if(studenti.find(indeks) != studenti.end()) throw domain_error("Student s tim indeksom vec postoji");
    studenti.emplace(indeks, new Student(indeks, godina_s, ime_i_prezime, adresa, br_tel));
}
void Administracija::RegistrirajNoviLaptop(int ev_broj, string naziv, string karakteristike) {
    if(laptopi.find(ev_broj) != laptopi.end()) throw domain_error("Laptop s tim evidencijskim brojem vec postoji");
    laptopi.emplace(ev_broj, new Laptop(ev_broj, naziv, karakteristike));
}
Student &Administracija::NadjiStudenta(int indeks) {
    auto it = studenti.find(indeks);
    if(it == studenti.end()) throw domain_error("Student nije nadjen");
    return *it->second;
}
Student Administracija::NadjiStudenta(int indeks) const {
    auto it = studenti.find(indeks);
    if(it == studenti.end()) throw domain_error("Student nije nadjen");
    return *it->second;
}
Laptop &Administracija::NadjiLaptop(int ev_broj) {
    auto it = laptopi.find(ev_broj);
    if(it == laptopi.end()) throw domain_error("Laptop nije nadjen");
    return *it->second;
}
Laptop Administracija::NadjiLaptop(int ev_broj) const {
    auto it = laptopi.find(ev_broj);
    if(it == laptopi.end()) throw domain_error("Laptop nije nadjen");
    return *it->second;
}
void Administracija::IzlistajStudente() const {
    for(const auto &par : studenti) par.second->Ispisi();
}
void Administracija::IzlistajLaptope() const {
    for(const auto &par : laptopi) {
        par.second->Ispisi();
        if(par.second->DaLiJeZaduzen()) {
            cout << "Zaduzio(la): " << par.second->DajPokKodKogaJe()->DajImePrezime() << " (" << par.second->DajPokKodKogaJe()->DajIndeks() << ")\n";
        }
    }
}
void Administracija::ZaduziLaptop(int indeks, int ev_broj) {
    if(studenti.find(indeks) == studenti.end()) throw domain_error("Student nije nadjen");
    if(laptopi.find(ev_broj) == laptopi.end()) throw domain_error("Laptop nije nadjen");
    if(laptopi[ev_broj]->DaLiJeZaduzen()) throw domain_error("Laptop vec zaduzen");
    for(const auto &par : laptopi)
        if(par.second->DajPokKodKogaJe() && par.second->DajPokKodKogaJe()->DajIndeks() == indeks) 
            throw domain_error("Student je vec zaduzio laptop");
    laptopi[ev_broj]->Zaduzi(*studenti[indeks]);
}
int Administracija::NadjiSlobodniLaptop() const {
    for(const auto &par : laptopi)
        if(!par.second->DaLiJeZaduzen()) return par.first;
    throw domain_error("Nema slobodnih laptopa");
}
void Administracija::RazduziLaptop(int ev_broj) {
    if(laptopi.find(ev_broj) == laptopi.end()) throw domain_error("Laptop nije nadjen");
    if(!laptopi[ev_broj]->DaLiJeZaduzen()) throw domain_error("Laptop nije zaduzen");
    laptopi[ev_broj]->Razduzi();
}
void Administracija::PrikaziZaduzenja() const {
    bool ima_zaduzenja = false;
    for(const auto &par : laptopi) {
        if(par.second->DaLiJeZaduzen()) {
            ima_zaduzenja = true;
            cout << "Student " << par.second->DajPokKodKogaJe()->DajImePrezime();
            cout << " (" << par.second->DajPokKodKogaJe()->DajIndeks() << ")";
            cout << " zaduzio/la laptop broj " << par.first << endl;
        }
    }
    if(!ima_zaduzenja) cout << "Nema zaduzenja" << endl;
}
void Pocisti(){
    cin.ignore(10000, '\n');
}
int main() {
    // Your main function logic
    return 0;
}