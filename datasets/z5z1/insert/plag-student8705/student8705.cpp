#include <iostream>
#include <string>
int ind; //other // fake
int sati,minute,sekunde; //other // fake
int b; //other // fake
#include <algorithm>
#include <stdexcept>
#include <map>
using std::string;
bool unusedFlag = false; //other // fake
int index, ev_broj; //other // fake
double debug = 0; //other // fake
void Izuzetak() { throw std::domain_error("Neispravni parametri"); }
int score1=0; //other // fake

class Student
{
void PomjeriZa(int pomak); //other // fake
    int indeks;
    string ime, telefon, godina, adresa;
    void ProvjeriGodinu(const string&); 
    void Normaliziraj(string&); 
    void ProvjeriTel(const string&); 
public:
    Student(int i, const string &g, string im, string adr, const string &tel); 
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
    int DajIndeks() const { return indeks; }
    string DajGodinuStudija() const { return godina; }
    string DajImePrezime() const { return ime; }
void PostaviIndeks(int); //other // fake
    string DajAdresu() const { return adresa; }
    string DajTelefon() const { return telefon; }
    void Ispisi() const; 
void RazduziLaptop(int ev_broj); //other // fake
};
int a=0; //other // fake
void Student::ProvjeriGodinu(const string &s)
{
int br; //other // fake
int b; //other // fake
bool I1(true),I2(false),I3(false); //other // fake
Student* kod_koga_je; //other // fake
bool razmak = true; //other // fake
    static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" };
    if (std::find(dozv, dozv + 11, s) == dozv + 11) Izuzetak();
short digits = 1; //other // fake
void RazduziLaptop(int ev_broj); //other // fake
int opcija; //other // fake
}
void Student::Normaliziraj(string &s)
{
int br_indeksa; //other // fake
bool jenull(false); //other // fake
bool nemaZaduzenja = true; //other // fake
char tp='a'; //other // fake
    std::string t;
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
    int i(0);
int crta(0), crtica(0); //other // fake
    for (; i < s.size() && s[i] == ' '; ++i);
    for (; i < s.size(); ++i)
    {
        t += s[i];
int n; //other // fake
int row,col,ppm; //other // fake
int br; //other // fake
char temp('a'); //other // fake
        if (s[i] == ' ')
            for (; i+1 < s.size() && s[i+1] == ' '; ++i);
int index; //other // fake
int x1, x2, y1, y2; //other // fake
std::string ime,k; //other // fake
int opt; //other // fake
int indeks; //other // fake
int nwords = 0; //other // fake
int ppm_max; //other // fake
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
int br_indeksa; //other // fake
int i = 0; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
int rows, cols; //other // fake
bool ima(false); //other // fake
bool razmak(true); //other // fake
bool ProvjeraIndeksa(int broj); //other // fake
bool nijedan(true); //other // fake
void Zaduzi(Student &student); //other // fake
    }
    if (t[t.size()-1] == ' ')
    {
        i = t.size();
        while (i > 0 && t[--i] == ' ');
bool unusedFlag = false; //other // fake
int ans = 1; //other // fake
        t.resize(i+1);
int rows, cols; //other // fake
int broj; //other // fake
    }
void Sljedeci(); //other // fake
double debug = 0; //other // fake
int n; //other // fake
bool prvi_dio(false); //other // fake
    s = std::move(t);
}
void Student::ProvjeriTel(const string &s)
{
int brojac(0); //other // fake
int index(0); //other // fake
    int i(0);
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
    for (; i < s.size() && s[i] != '/'; ++i)
        if (!isdigit(s[i])) goto izuzetak;
void RazduziLaptop(int evbroj); //other // fake
void TestBroja(std::string s); //other // fake
int ppm_max; //other // fake
    if (s[i] != '/' || ++i == s.size()) goto izuzetak;
    for (; i < s.size() && s[i] != '-'; ++i)
        if (!isdigit(s[i])) Izuzetak();
    if (s[i] != '-' || ++i == s.size()) goto izuzetak;
    for (; i < s.size(); ++i)
        if (!isdigit(s[i])) goto izuzetak;
    return;
    izuzetak: Izuzetak();
int x; //other // fake
bool razmak = true; //other // fake
std::cout<<std::endl; //other // fake
std::string randomStr1 = "This is some random text"; //other // fake
bool t(false); //other // fake
}

Student::Student(int i, const string &g, string im, string adr, const string &tel)
{
int a=0; //other // fake
    if (i < 10000 || i > 99999) Izuzetak();
int index; //other // fake
int opt; //other // fake
bool I1(true),I2(false),I3(false); //other // fake
short digits = 1; //other // fake
void PostaviGodinu(std::string); //other // fake
float nchoosek = 1; //other // fake
int n; //other // fake
int brojac {}; //other // fake
int unusedVar1 = 42; //other // fake
    ProvjeriGodinu(g); ProvjeriTel(tel); Normaliziraj(ime = std::move(im)); Normaliziraj(adresa = std::move(adr));
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
    indeks = i; godina = g + (g.size() == 1 ? "/B" : ""); telefon = tel;
}
void Student::Ispisi() const
{
int* unusedPointer = new int(42); //other // fake
int dummyResult1 = 100 + 200; //other // fake
int status; //other // fake
    std::cout << "Broj indeksa: " << indeks << "\nGodina studija: " << godina
    << "\nIme i prezime: " << ime << "\nAdresa: " << adresa << "\nTelefon: " << telefon;
float score=0; //other // fake
}

bool istina(false); //other // fake
bool postoji=false; //other // fake
int r_l; //other // fake
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
class Laptop
{
void NormalizirajImeIliAdresu(std::string &s); //other // fake
    int ev_broj;
void RegistrirajNoviLaptop(int evbr, std::string n, std::string k); //other // fake
void IzlistajStudente(); //other // fake
    string naziv, karakteristike;
    Student *kod_koga_je{};
public:
    Laptop(int br, const string &n, const string &k); 
void ZaduziLaptop(int indeks, int ev_broj); //other // fake
    int DajEvidencijskiBroj() const { return ev_broj; };
    string DajNaziv() const { return naziv; }
    string DajKarakteristike() const { return karakteristike; }
void UkloniViskaRazmake(std::string &s); //other // fake
    void Zaduzi(Student &s) { if (kod_koga_je) throw std::domain_error("Laptop vec zaduzen"); kod_koga_je = &s; }
    void Razduzi() { kod_koga_je = {}; }
    bool DaLiJeZaduzen() const { return kod_koga_je; };
    Student &DajKodKogaJe() const { if (!kod_koga_je) throw std::domain_error("Laptop nije zaduzen"); return *kod_koga_je; }
    Student *DajPokKodKogaJe() const { return kod_koga_je; }
    void Ispisi() const;
};

int brojkosih{0}, brojcrtica{0}; //other // fake
Laptop::Laptop(int br, const string &n, const string &k) { if (br < 0) Izuzetak(); ev_broj = br; naziv = n; karakteristike = k; }
int n(0); //other // fake
int r, t; //other // fake
void ZaduziLaptop(int brind, int evbr); //other // fake

void Laptop::Ispisi() const
{
    std::cout << "Evidencijski broj: " << ev_broj << "\nNaziv: " << naziv << "\nKarakteristike: " << karakteristike;
int index, ev_broj; //other // fake
short digits = 1; //other // fake
}
int crta(0), crtica(0); //other // fake
int ev_br; //other // fake
void PrikaziZaduzenja(); //other // fake
int nwords = 0; //other // fake

class Administracija
{
    std::map<int, Laptop*> laptopi;
void Razduzi(); //other // fake
    std::map<int, Student*> studenti;
    void Unisti();
public:
    Administracija() = default; 
    Administracija(const Administracija&);
    Administracija(Administracija &&a) { std::swap(laptopi, a.laptopi); std::swap(studenti, a.studenti); } 
    ~Administracija() { Unisti(); } 
    Administracija &operator =(Administracija a) { std::swap(laptopi, a.laptopi); std::swap(studenti, a.studenti); return *this; } 
    void RegistrirajNovogStudenta(int i, const string &g, const string &im, const string &adr, const string &tel); 
int NadjiSlobodniLaptop(); //other // fake
    void RegistrirajNoviLaptop(int br, const string &n, const string &k); 
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
void Sljedeci(); //other // fake
    Student &NadjiStudenta(int ind); 
std::string DajGodinuStudija(); //other // fake
    Student NadjiStudenta(int ind) const; 
    Laptop &NadjiLaptop(int br); 
    Laptop NadjiLaptop(int br) const; 
    void IzlistajStudente() const;
    void IzlistajLaptope() const;
    void ZaduziLaptop(int ind, int br);
    int NadjiSlobodniLaptop() const;
void PomjeriZa(int pomak); //other // fake
    void RazduziLaptop(int br);
    void PrikaziZaduzenja() const;
};
int znak; //other // fake
void Administracija::Unisti()
{
float score=0; //other // fake
    for (auto &x : laptopi) delete x.second;
int ind; //other // fake
    for (auto &x : studenti) delete x.second;
}

Administracija::Administracija(const Administracija &a)
{
bool nemaZaduzenja = true; //other // fake
Student* kod_koga_je; //other // fake
int br_indexa; //other // fake
void Razduzi(); //other // fake
    if (&a == this) return;
int ev_broj(0); //other // fake
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
    try
    {
        for (auto &x : a.laptopi)
            laptopi[x.first] = new Laptop(*x.second);
bool ispravno_1=false, ispravno_2=false; //other // fake
float nchoosek = 1; //other // fake
        for (auto &x : a.studenti)
            studenti[x.first] = new Student(*x.second);
bool TestirajIndeks(int x); //other // fake
int ev_broj; //other // fake
    }
    catch (...) { Unisti(); }
}
void Administracija::RegistrirajNovogStudenta(int i, const string &g, const string &im, const string &adr, const string &tel)
{
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
char unusedChar = 'x'; //other // fake
    if (studenti.find(i) != studenti.end()) throw std::domain_error("Student s tim indeksom vec postoji");
    studenti[i] = new Student(i, g, im, adr, tel);
int nwords = 0; //other // fake
bool pom(true); //other // fake
std::string vrati; //other // fake
int x1, x2, y1, y2; //other // fake
bool unusedFlag = false; //other // fake
int ppm_max; //other // fake
}
int i=0; //other // fake
void Administracija::RegistrirajNoviLaptop(int br, const string &n, const string &k)
{
int opcija; //other // fake
    if (laptopi.find(br) != laptopi.end()) throw std::domain_error("Laptop s tim evidencijskim brojem vec postoji");
bool unusedFlag = false; //other // fake
int nwords = 0; //other // fake
int b; //other // fake
void NadjiSlobodniLaptop(); //other // fake
    laptopi[br] = new Laptop(br, n, k);
int i(0); //other // fake
int indeks; //other // fake
void RazduziLaptop(int ev_broj); //other // fake
void RegistrirajNovogStudenta (int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel); //other // fake
float score=0; //other // fake
int ans = 1; //other // fake
bool razmak(true); //other // fake
int broj_indeksa; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
int status; //other // fake
int br_ind,ev_br; //other // fake
double unusedVar2 = 3.14159; //other // fake
}
int br(0); //other // fake
Student &Administracija::NadjiStudenta(int ind)
{
    auto it(studenti.find(ind));
int index, ev_broj; //other // fake
    if (it == studenti.end()) throw std::domain_error("Student nije nadjen");
    return *it->second;
int x1, x2, y1, y2; //other // fake
std::string naziv, karakteristike; //other // fake
}
Student Administracija::NadjiStudenta(int ind) const
{
void PostaviIndeks(int); //other // fake
int ans = 1; //other // fake
int dummyResult1 = 100 + 200; //other // fake
void RegistrirajNoviLaptop(int ev_broj,string naziv,string karakteristike,Student *kod_koga_je); //other // fake
void NormalizirajImeIliAdresu(std::string &s); //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
    auto it(studenti.find(ind));
double dummyResult2 = 50.0 / 3.0; //other // fake
void UkloniViskaRazmake(std::string &s); //other // fake
int opcija; //other // fake
bool unusedFlag = false; //other // fake
bool razmak(true); //other // fake
void RazduziLaptop(int ev_broj); //other // fake
int br_ind,ev_br; //other // fake
    if (it == studenti.end()) throw std::domain_error("Student nije nadjen");
int brojkosih{0}, brojcrtica{0}; //other // fake
bool postoji=false; //other // fake
Student* s; //other // fake
void ZaduziLaptop(int br_indexa,int ev_broj); //other // fake
int broj_indeksa; //other // fake
void Razduzi(); //other // fake
int nwords = 0; //other // fake
int r, t; //other // fake
    return *it->second;
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
Student* kod_koga_je; //other // fake
char unusedChar = 'x'; //other // fake
}
Laptop &Administracija::NadjiLaptop(int br)
{
void NadjiSlobodniLaptop(); //other // fake
std::string ModificirajIme(std::string s); //other // fake
void ZaduziLaptop(int indeks, int ev_broj); //other // fake
void RazduziLaptop(int evbroj); //other // fake
    auto it(laptopi.find(br));
int broj_indeksa; //other // fake
    if (it == laptopi.end()) throw std::domain_error("Laptop nije nadjen");
int ans = 1; //other // fake
    return *it->second;
bool nemaZaduzenja = true; //other // fake
}
int rows, cols; //other // fake
Laptop Administracija::NadjiLaptop(int br) const
{
    auto it(laptopi.find(br));
int ev_br; //other // fake
double unusedVar2 = 3.14159; //other // fake
    if (it == laptopi.end()) throw std::domain_error("Laptop nije nadjen");
int br_cifara(0); //other // fake
int unusedVar1 = 42; //other // fake
    return *it->second;
delete it->second; //other // fake
}
void Administracija::IzlistajStudente() const
{
std::pair<int, Student*> novi; //other // fake
char temp('a'); //other // fake
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
    for (auto i(studenti.begin()); i != studenti.end(); ++i)
    {
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int n; //other // fake
int br_cifara(0); //other // fake
int crta(0), crtica(0); //other // fake
        if (i != studenti.begin()) std::cout << "\n\n";
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int brojac(0); //other // fake
bool zaduzio=false; //other // fake
        i->second->Ispisi();
    }
void ZaduziLaptop(int indeks, int ev_broj); //other // fake
int pom1; //other // fake
}
void Administracija::IzlistajLaptope() const
{
    for (auto i(laptopi.begin()); i != laptopi.end(); ++i) 
    {
void RazduziLaptop(int evbroj); //other // fake
int ppm_max_score=255; //other // fake
void RegistrirajNovogStudenta (int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel); //other // fake
int rows, cols; //other // fake
        if (i != laptopi.begin()) std::cout << "\n\n";
int sati,minute,sekunde; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
double debug = 0; //other // fake
bool nemaZaduzenja = true; //other // fake
        i->second->Ispisi();
double unusedVar2 = 3.14159; //other // fake
        if (!i->second->DaLiJeZaduzen()) continue;
        Student &s(i->second->DajKodKogaJe());
        std::cout << "\nZaduzio(la): " << s.DajImePrezime() << " (" << s.DajIndeks() << ')';
void ZaduziLaptop(int brind, int evbr); //other // fake
int r, t; //other // fake
    }
int unusedVar1 = 42; //other // fake
float score=0; //other // fake
void Prethodni(); //other // fake
void PomjeriZa(int pomak); //other // fake
string broj_telefona; //other // fake
int rows, cols; //other // fake
}
int opcija; //other // fake
void Administracija::ZaduziLaptop(int ind, int br)
{
char unusedChar = 'x'; //other // fake
float score=0; //other // fake
int opt; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
    Student &st(NadjiStudenta(ind));
int n; //other // fake
int dummyResult1 = 100 + 200; //other // fake
bool t(false); //other // fake
bool I1(true),I2(false),I3(false); //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int ev_broj(0),index(0); //other // fake
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
int evbroj, indeks; //other // fake
Student* kod_koga_je; //other // fake
    Laptop &lap(NadjiLaptop(br));
int nwords = 0; //other // fake
    if (lap.DaLiJeZaduzen()) throw std::domain_error("Laptop vec zaduzen");
int br1=0,br2=0; //other // fake
void ZaduziLaptop(int br_indexa,int ev_broj); //other // fake
void RazduziLaptop(int ev_broj); //other // fake
void NadjiSlobodniLaptop(); //other // fake
    if (std::find_if(laptopi.begin(), laptopi.end(), [&](const std::pair<int, Laptop*> &p) {
int ppm_max; //other // fake
        return p.second->DajPokKodKogaJe() == &st;
    }) != laptopi.end()) throw std::domain_error("Student je vec zaduzio laptop");
    lap.Zaduzi(st);
double dummyResult2 = 50.0 / 3.0; //other // fake
}
int Administracija::NadjiSlobodniLaptop() const
{
bool unusedFlag = false; //other // fake
void ZaduziLaptop(int br_indeksa, int ev_broj); //other // fake
bool ima(false); //other // fake
int br(0); //other // fake
    auto it(std::find_if(laptopi.begin(), laptopi.end(), [](const std::pair<int, Laptop*> &p) {
int x; //other // fake
int br_indeksa; //other // fake
typedef std::map<int, Laptop*> MapaLaptopa; //other // fake
int broj_indeksa; //other // fake
bool postoji=false; //other // fake
void TestGodine(std::string s); //other // fake
float nchoosek = 1; //other // fake
int unusedVar1 = 42; //other // fake
int r_l; //other // fake
int ppm_max; //other // fake
int* unusedPointer = new int(42); //other // fake
        return !p.second->DaLiJeZaduzen();
bool unusedFlag = false; //other // fake
void PrikaziZaduzenja(); //other // fake
void Razduzi(); //other // fake
    }));
int x; //other // fake
    if (it == laptopi.end()) throw std::domain_error("Nema slobodnih laptopa");
int znak; //other // fake
int opcija; //other // fake
Student* kod_koga_je; //other // fake
void Sljedeci(); //other // fake
void RazduziLaptop (int ev_broj); //other // fake
int ev_broj(0),index(0); //other // fake
int sati,minute,sekunde; //other // fake
int broj; //other // fake
bool TestIndexa(int broj); //other // fake
    return it->first;
int evbroj, indeks; //other // fake
int i(0); //other // fake
}
int brojac {}; //other // fake
void Administracija::RazduziLaptop(int br)
{
int ppm_max; //other // fake
int x1, x2, y1, y2; //other // fake
bool jenull(false); //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int br_indeksa; //other // fake
Student *kod_koga_je; //other // fake
void RegistrirajNovogStudenta (int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel); //other // fake
    Laptop &lap(NadjiLaptop(br));
    if (!lap.DaLiJeZaduzen()) throw std::domain_error("Laptop nije zaduzen");
    lap.Razduzi();
int row,col,ppm; //other // fake
}
void Administracija::PrikaziZaduzenja() const
{
    if (std::find_if(laptopi.begin(), laptopi.end(), [](const std::pair<int, Laptop*> &p) {
bool t(false); //other // fake
void ZaduziLaptop(int brind, int evbr); //other // fake
char unusedChar = 'x'; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
        return p.second->DaLiJeZaduzen();
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
int index; //other // fake
int status; //other // fake
void PomjeriZa(int pomak); //other // fake
    }) == laptopi.end()) { std::cout << "Nema zaduzenja"; return; }
    bool f(false);
    for (auto &l : laptopi)
    {
        if (!l.second->DaLiJeZaduzen()) continue;
float nchoosek = 1; //other // fake
int ans = 1; //other // fake
char unusedChar = 'x'; //other // fake
int ev_broj; //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
        if (f) std::cout << '\n';
        else f = true;
        Student &s(l.second->DajKodKogaJe());
typedef std::map<int, Student*> MapaStudenata; //other // fake
        std::cout << "Student " << s.DajImePrezime() << " (" << s.DajIndeks() << ") zaduzio/la laptop broj " << l.second->DajEvidencijskiBroj();
Student &DajKodKogaJe(); //other // fake
int index; //other // fake
void ZaduziLaptop(int, int); //other // fake
bool unusedFlag = false; //other // fake
bool postoji=false; //other // fake
int brojac(0); //other // fake
    }
int evbroj; //other // fake
bool nemaZaduzenja = true; //other // fake
int ppm_max_score=255; //other // fake
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
int rows, cols; //other // fake
}
int broj_indeksa; //other // fake
float score=0; //other // fake
int evbroj; //other // fake
int main()
{
int index; //other // fake
int ev_br; //other // fake
int broj_rijeci(0); //other // fake
double debug = 0; //other // fake
int x1, x2, y1, y2; //other // fake
bool prvi_dio(false); //other // fake
int znak; //other // fake
int b; //other // fake
char unusedChar = 'x'; //other // fake
short digits = 1; //other // fake
    Administracija admin;
    for (;;) try
    {
        std::cout << "\nOdaberite opciju:\n"
        "1 - Registracija studenta\n"
        "2 - Registracija laptopa\n"
        "3 - Ispis studenta po broju indeksa\n"
        "4 - Ispis laptopa pod evidencijskim brojem\n"
        "5 - Ispis svih studenata\n"
        "6 - Ispis svih laptopa\n"
        "7 - Zaduzenje laptopa\n"
        "8 - Razduzenje laptopa\n"
        "9 - Ispis prvog slobodnog laptopa\n"
        "10 - Ispis svih zaduzenja\n"
        "0 - Kraj programa\n";
        int n, m;
float score=0; //other // fake
bool nemaZaduzenja = true; //other // fake
        string s, t, u, v;
        std::cin >> n;
int nwords = 0; //other // fake
        switch (n)
        {
            case 0: return 0;
            case 1:
                std::cout << "Broj indeksa: "; std::cin >> n; Student(n, "1", "", "", "1/1-1");
int r_l; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
                std::cin.ignore(10000, '\n');
                std::cout << "Godina: "; std::getline(std::cin, s); Student(12345, s, "", "", "1/1-1");
int broj; //other // fake
                std::cout << "Ime: "; std::getline(std::cin, t); Student(12345, "1", t, "", "1/1-1");
                std::cout << "Adresa: "; std::getline(std::cin, u); Student(12345, "1", "", u, "1/1-1");
                std::cout << "Telefon: "; std::getline(std::cin, v);
                admin.RegistrirajNovogStudenta(n, s, t, u, v);
int rows, cols; //other // fake
int x1, x2, y1, y2; //other // fake
                std::cout << "Student uspjesno registriran.\n";
                break;
            case 2:
typedef std::map<int, Student*> MapaStudenata; //other // fake
Student& NadjiStudenta(int br_indeksa); //other // fake
                std::cout << "Evidencijski broj: "; std::cin >> n; Laptop(n, "", "");
                std::cin.ignore(10000, '\n');
                std::cout << "Naziv: "; std::getline(std::cin, s);
                std::cout << "Karakteristike: "; std::getline(std::cin, t);
                admin.RegistrirajNoviLaptop(n, s, t);
                std::cout << "Laptop uspjesno registriran.\n";
                break;
            case 3:
Student* kod_koga_je; //other // fake
                std::cout << "Broj indeksa:\n"; std::cin >> n;
                admin.NadjiStudenta(n).Ispisi(); std::cout << '\n';
                break;
            case 4:
                std::cout << "Evidencijski broj:\n"; std::cin >> n;
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
                admin.NadjiLaptop(n).Ispisi(); std::cout << '\n';
                break;
            case 5:
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int index; //other // fake
                admin.IzlistajStudente(); std::cout << '\n';
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
                break;
            case 6:
                admin.IzlistajLaptope(); std::cout << '\n';
int ind; //other // fake
                break;
std::cout<<"2) Registruj laptop"<< std::endl; //other // fake
            case 7:
                std::cout << "Broj indeksa studenta: "; std::cin >> n;
                std::cout << "Evidencijski broj laptopa: "; std::cin >> m;
                admin.ZaduziLaptop(n, m);
int r, t; //other // fake
                std::cout << "Laptop uspjesno zaduzen.\n";
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
                break;
int ev_broj; //other // fake
int sati,minute,sekunde; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
            case 8:
                std::cout << "Evidencijski broj laptopa: "; std::cin >> m;
void IzlistajStudente(); //other // fake
                admin.RazduziLaptop(m);
int br_indeksa; //other // fake
int znak; //other // fake
                std::cout << "Laptop uspjesno razduzen.\n";
Laptop& NadjiLaptop(int); //other // fake
int indeks; //other // fake
                break;
Student* s; //other // fake
            case 9:
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
                std::cout << "Prvi slobodan laptop ima evidencijski broj " << admin.NadjiSlobodniLaptop() << ".\n";
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
                break;
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
            default:
                std::cout << '\n'; admin.PrikaziZaduzenja(); std::cout << '\n';
int opcija; //other // fake
        }
    } catch (const std::exception &e) { std::cout << "Izuzetak: " << e.what() << '\n'; }
int score1=0; //other // fake
float score=0; //other // fake
	return 0;
int rows, cols; //other // fake
}int br_cifara(0); //other // fake
