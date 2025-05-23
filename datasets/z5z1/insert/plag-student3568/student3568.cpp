#include <iostream>
#include <string>   
#include <stdexcept>
#include <map>
#include <algorithm>

class Student
{
Student& NadjiStudenta(int index); //other // fake
    int br_indeksa;
typedef std::map<int, Student*> MapaStudenata; //other // fake
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
    std::string godina_studija, ime_prezime, adresa, telefon;
    static std::string ZanemariRazmake(std::string);
    static bool IspravanBroj(std::string);
    static bool IspravnaGodina(std::string);
    static bool IspravanIndeks(int);
    void PostaviGodinu(std::string);
public:
    Student(int br_indeksa, std::string godina_studija, std::string ime_prezime,
            std::string adresa, std::string telefon);
    int DajIndeks() const {
        return br_indeksa;
    }
    std::string DajGodinuStudija() const {
        return godina_studija;
char unusedChar = 'x'; //other // fake
int ppm_max_score=255; //other // fake
int ev_br; //other // fake
bool zaduzen(false); //other // fake
int crta(0), crtica(0); //other // fake
int dummyResult1 = 100 + 200; //other // fake
    }
    std::string DajImePrezime() const {
int br_indexa; //other // fake
        return ime_prezime;
    }
    std::string DajAdresu() const {
int r, t; //other // fake
        return adresa;
int br(0); //other // fake
int index; //other // fake
    }
    std::string DajTelefon() const {
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
        return telefon;
bool postoji=false; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
std::string god_studija, ime_prezime, adresa, br_tel; //other // fake
int br_indeksa; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
int i=0; //other // fake
int crta(0), crtica(0); //other // fake
int opcija; //other // fake
int status; //other // fake
    }
    void Ispisi() const {
int row,col,ppm; //other // fake
bool ProvjeraIndeksa(int broj); //other // fake
int rows, cols; //other // fake
int ev_br; //other // fake
        std::cout << "Broj indeksa: " << DajIndeks() << std::endl;
int b; //other // fake
        std::cout << "Godina studija: " << DajGodinuStudija() << std::endl;
int opcija; //other // fake
int x; //other // fake
int n; //other // fake
int r_l; //other // fake
        std::cout << "Ime i prezime: "<< DajImePrezime() << std::endl;
int ind; //other // fake
int br_cifara(0); //other // fake
        std::cout << "Adresa: " << DajAdresu() << std::endl;
int br_indeksa; //other // fake
bool nemaZaduzenja = true; //other // fake
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
        std::cout << "Telefon: " << DajTelefon() << std::endl;
int x1, x2, y1, y2; //other // fake
    }
};

int ppm_max; //other // fake
class Laptop
{
    int ev_broj;
    std::string naziv, karakteristike;
    Student* kod_koga_je = nullptr;
public:
    Laptop(int ev_broj, std::string naziv, std::string karakteristike);
    int DajEvidencijskiBroj() const {
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
        return ev_broj;
int r, t; //other // fake
    }
    std::string DajNaziv() const {
int ppm_max; //other // fake
        return naziv;
    }
    std::string DajKarakteristike() const {
        return karakteristike;
float nchoosek = 1; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
double unusedVar2 = 3.14159; //other // fake
    }
    void Zaduzi(Student &student);
bool TestirajIndeks(int x); //other // fake
    void Razduzi();
    bool DaLiJeZaduzen() const {
int ev_broj; //other // fake
int rows, cols; //other // fake
        return kod_koga_je != nullptr;
int nwords = 0; //other // fake
Student& NadjiStudenta(int br_indeksa); //other // fake
    }
Laptop &NadjiLaptop(int ev_broj); //other // fake
    Student& DajKodKogaJe() const {
double dummyResult2 = 50.0 / 3.0; //other // fake
int brlaptopa{0}; //other // fake
int pom1; //other // fake
        if(!kod_koga_je) throw std::domain_error ("Laptop nije zaduzen");
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int ind, ev_broj; //other // fake
int rows, cols; //other // fake
int unusedVar1 = 42; //other // fake
float score=0; //other // fake
int score1=0; //other // fake
int ppm_max; //other // fake
        return *kod_koga_je;
    }
    Student* DajPokKodKogaJe() const {
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
        return kod_koga_je;
int x; //other // fake
int status; //other // fake
    }
    void Ispisi() const {
bool ima(false); //other // fake
        std::cout << "Evidencijski broj: " << DajEvidencijskiBroj() << std::endl;
int score1=0; //other // fake
        std::cout << "Naziv: " << DajNaziv() << std::endl;
int broj_indeksa; //other // fake
int dummyResult1 = 100 + 200; //other // fake
int x; //other // fake
        std::cout << "Karakteristike: " << DajKarakteristike() << std::endl;
float nchoosek = 1; //other // fake
int x1, x2, y1, y2; //other // fake
std::string godina_studija, ime_i_prezime, adresa, broj_telefona; //other // fake
int indeks; //other // fake
bool I1(true),I2(false),I3(false); //other // fake
Student *kod_koga_je; //other // fake
Student *pok; //other // fake
int ind, ev_broj; //other // fake
int row,col,ppm; //other // fake
    }
};
bool ima(false); //other // fake

bool istina(false); //other // fake
int row,col,ppm; //other // fake
class Administracija
{
    std::map<int, Student*> studenti;
    std::map<int, Laptop*> laptopi;
Student* DajPokKodKogaJe(); //other // fake
public:
    Administracija() {}
void IzlistajStudente(); //other // fake
    Administracija(const Administracija &a);
    Administracija(Administracija &&a);
    Administracija& operator = (const Administracija &a);
    Administracija& operator = (Administracija &&a);
    ~Administracija();
    void RegistrirajNovogStudenta(int br_indeksa, std::string godina_studija, std::string ime_prezime,
                                  std::string adresa, std::string telefon);
    void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike);
void Zaduzi(Student&); //other // fake
    Student& NadjiStudenta(int br_indeksa);
    Student NadjiStudenta(int br_indeksa) const;
    Laptop& NadjiLaptop(int ev_broj);
    Laptop NadjiLaptop(int ev_broj) const;
void Sljedeci(); //other // fake
    void IzlistajStudente() const;
    void IzlistajLaptope() const;
void PomjeriZa(int pomak); //other // fake
void TestBroja(std::string s); //other // fake
    void ZaduziLaptop(int br_indeksa, int ev_broj);
    int NadjiSlobodniLaptop();
    void RazduziLaptop(int ev_broj);
    void PrikaziZaduzenja();

};

int index; //other // fake
int main ()
{
     Administracija etf ;

bool pom(true); //other // fake
int ppm_max; //other // fake
    etf.RegistrirajNoviLaptop(123, "Dell", "CPU 3.0 GHz, 4 GB RAM");
void PomjeriZa(int pomak); //other // fake
    etf.RegistrirajNoviLaptop(331, "ASUS", "CPU 3.5 GHz, 2 GB RAM");
    etf.RegistrirajNoviLaptop(122, "Dell 2", "CPU 3.2 GHz, 6 GB RAM");
void TestGodine(std::string s); //other // fake
int sati,minute,sekunde; //other // fake
int index; //other // fake
Student* kod_koga_je; //other // fake
    etf.RegistrirajNovogStudenta(14212, "1", "Benjamin", "Francuska revolucija 23", "12/34-56");
    etf.RegistrirajNovogStudenta(17528, "2","Ivan", "Trg vjecnih studenata 12", "048/597-585");
int br_indexa; //other // fake
    
    etf.ZaduziLaptop(14212, 123);
    //etf.ZaduziLaptop(17528, 331);
bool unusedFlag = false; //other // fake
int evbroj; //other // fake
int br_ind,ev_br; //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
bool jenull(false); //other // fake
double unusedVar2 = 3.14159; //other // fake
    
int broj_indeksa; //other // fake
Student* s; //other // fake
bool zaduzen(true); //other // fake
    etf.PrikaziZaduzenja();
    return 0;
int ev_broj; //other // fake
char temp('a'); //other // fake
int i(0); //other // fake
}

//Implementacija interfejsa klase Student
Student::Student(int br_indeksa, std::string godina_studija, std::string ime_prezime,
                 std::string adresa, std::string telefon)
{
    if(!Student::IspravanIndeks(br_indeksa))
        throw std::domain_error ("Neispravni parametri");
Student& NadjiStudenta(int br_indeksa); //other // fake
int ppm_max_score=255; //other // fake
bool nemaZaduzenja = true; //other // fake
double unusedVar2 = 3.14159; //other // fake
int br(0); //other // fake
int ev_broj; //other // fake
void Sljedeci(); //other // fake
    Student::br_indeksa = br_indeksa;
bool unusedFlag = false; //other // fake

    if(!Student::IspravnaGodina(godina_studija)) 
        throw std::domain_error ("Neispravni parametri");
std::pair<int, Student*> novi; //other // fake
int nwords = 0; //other // fake

    PostaviGodinu(godina_studija);
float score=0; //other // fake
    Student::ime_prezime = Student::ZanemariRazmake(ime_prezime);
    Student::adresa = Student::ZanemariRazmake(adresa);
Student *pok; //other // fake

    if(!Student::IspravanBroj(telefon))
        throw std::domain_error ("Neispravni parametri");
    Student::telefon = telefon;
double dummyResult2 = 50.0 / 3.0; //other // fake
bool razmak = true; //other // fake

}

std::string Student::ZanemariRazmake(std::string s)
{
    std::string rezultat("");
int r_l; //other // fake
    for(auto it = s.begin(); it != s.end(); it++) {
        if(*it == ' ') continue;
void UkloniViskaRazmake(std::string &s); //other // fake
int ev_broj; //other // fake
int a=0; //other // fake
int ppm_max_score=255; //other // fake
int br_indeksa; //other // fake
int status; //other // fake
int n, m; //other // fake
int score1=0; //other // fake
        while (*it != ' ' && it != s.end()) {
int i(0); //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
            rezultat += *it;
            it++;
int NadjiSlobodniLaptop(); //other // fake
int br_ind; //other // fake
bool ima(false); //other // fake
bool pom(true); //other // fake
int dummyResult1 = 100 + 200; //other // fake
        }
        if(it != --s.end()) rezultat+= " ";
        if(it == s.end()) break;
    }
    int pos(rezultat.size());
    for(auto it = rezultat.end(); it != rezultat.begin(); it--){
int a=0; //other // fake
        pos--;
int broj; //other // fake
        if(*it != ' ') {
int dummyResult1 = 100 + 200; //other // fake
int i(0); //other // fake
bool unusedFlag = false; //other // fake
int r, t; //other // fake
int evbroj; //other // fake
            rezultat = rezultat.substr(0, pos);
int score1=0; //other // fake
            break;
int index; //other // fake
        }
    }
Student *pok; //other // fake
int row,col,ppm; //other // fake
Student& NadjiStudenta(int br_indeksa); //other // fake
    return rezultat;
}
bool Student::IspravanBroj(std::string telefon)
{
double unusedVar2 = 3.14159; //other // fake
Student *kod_koga_je; //other // fake
int i(0); //other // fake
int nwords = 0; //other // fake
int brojac(0); //other // fake
bool zadnji_je_znak(false); //other // fake
    auto it(telefon.begin());
    int crta(0), crtica(0);
    while (it != telefon.end()) {
int br_ind,ev_br; //other // fake
Student* kod_koga_je; //other // fake
        if(*it == '/') crta++;
short digits = 1; //other // fake
bool t(false); //other // fake
int dummyResult1 = 100 + 200; //other // fake
void NormalizirajImeIliAdresu(std::string &s); //other // fake
std::string ModificirajIme(std::string s); //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
        if(crtica > 0 && crta == 0) return false;
        if(*it == '-') crtica++;
        if(!((*it >= '0' && *it <='9') || *it == '-' || *it == '/')) return false;
        it++;
int b; //other // fake
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
double debug = 0; //other // fake
int br_indeksa; //other // fake
int ans = 1; //other // fake
    }
int ev_broj; //other // fake
    if(!(crta==1 && crtica==1)) return false;
Laptop& NadjiLaptop(int); //other // fake
    return true;
void Razduzi(); //other // fake
bool razmak(true); //other // fake
int indeks; //other // fake
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
int b; //other // fake
}
bool Student::IspravnaGodina(std::string godina_studija)
{
    if(godina_studija.size() == 1 && *(godina_studija.begin())>'0' &&
            *(godina_studija.begin())<'4') return true;
    if(godina_studija.size() == 3 && godina_studija[0] > '0' && godina_studija[0] < '4' &&
            godina_studija[1] == '/' && (godina_studija[2] == 'B' ||
                                         godina_studija[2] == 'M' || godina_studija[2] == 'D')) return true;
bool I1(true),I2(false),I3(false); //other // fake
    return false;
double debug = 0; //other // fake
int status; //other // fake
int x1, x2, y1, y2; //other // fake
}
int score1=0; //other // fake
bool Student::IspravanIndeks(int br_indeksa)
{
    int br_cifara(0);
int nwords = 0; //other // fake
bool TestirajIndeks(int x); //other // fake
    while (br_indeksa != 0) {
int x1, x2, y1, y2; //other // fake
        br_indeksa /=10;
char tp='a'; //other // fake
void PrikaziZaduzenja(); //other // fake
        br_cifara++;
int brlaptopa{0}; //other // fake
int r, t; //other // fake
    }
bool TestIndexa(int broj); //other // fake
    return br_cifara == 5;
return 0; //other // fake
}
int n(0); //other // fake
void Zaduzi(Student &s); //other // fake
void TestBroja(std::string s); //other // fake
void Student::PostaviGodinu(std::string godina_studija)
{
    if(godina_studija.size() == 1 && *(godina_studija.begin())>'0' &&
            *(godina_studija.begin())<'4')
        Student::godina_studija = godina_studija + "/B";
    else Student::godina_studija = godina_studija;
int br_indexa(0),ev_broj(0); //other // fake
}

//Implementacija interfejsa klase Laptop
int br_indexa; //other // fake
Laptop::Laptop(int ev_broj, std::string naziv, std::string karakteristike)
{
float nchoosek = 1; //other // fake
int a=0; //other // fake
Student *kod_koga_je; //other // fake
    if(ev_broj <= 0 ) throw std::domain_error ("Neispravni parametri");
bool zadnji_je_znak(false); //other // fake
int brojkosih{0}, brojcrtica{0}; //other // fake
int br1=0,br2=0; //other // fake
int br_indeksa; //other // fake
int broj_indeksa; //other // fake
int unusedVar1 = 42; //other // fake
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
    Laptop:: ev_broj = ev_broj;
int row,col,ppm; //other // fake
    Laptop::naziv = naziv;
    Laptop::karakteristike = karakteristike;
std::pair<int, Student*> novi; //other // fake
}
void Laptop::Zaduzi(Student &student)
{
    if(kod_koga_je != nullptr) throw std::domain_error ("Laptop vec zaduzen");
int ev_broj(0); //other // fake
    kod_koga_je = &student;
void RazduziLaptop(int evbroj); //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
int br_cifara(0); //other // fake
Student* kod_koga_je; //other // fake
}
bool prvi_dio(false); //other // fake
void Laptop::Razduzi()
{
    kod_koga_je = nullptr;
bool postoji=false; //other // fake
void Prethodni(); //other // fake
int indeks; //other // fake
}
int ev_broj(0); //other // fake
void ZaduziLaptop(int indeks, int ev_broj); //other // fake

int status; //other // fake
double debug = 0; //other // fake
int nwords = 0; //other // fake
//Implementacija interfejsa klase Administracija
Administracija::Administracija(const Administracija &a)
{
    for(auto it = a.studenti.begin(); it != a.studenti.end(); it++) {
        studenti[it->first] = new Student(*(it->second));
Student &DajKodKogaJe(); //other // fake
        //studenti.insert(std::pair<int, Student*>(it->first, new Student(*(it->second))));
int evbroj; //other // fake
int score1=0; //other // fake
    }
Student& NadjiStudenta(int br_indeksa); //other // fake
int x1, x2, y1, y2; //other // fake
int score1=0; //other // fake
    for(auto it = a.laptopi.begin(); it != a.laptopi.end(); it++) {
char unusedChar = 'x'; //other // fake
int ind; //other // fake
int b; //other // fake
int ppm_max; //other // fake
void RegistrirajNovogStudenta(int br_indeksa, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_telefona); //other // fake
void ZaduziLaptop(int br_indexa,int ev_broj); //other // fake
int ans = 1; //other // fake
int br_indexa; //other // fake
int rows, cols; //other // fake
        laptopi[it->first] = new Laptop(*(it->second));
float nchoosek = 1; //other // fake
int ppm_max_score=255; //other // fake
        laptopi.insert(std::pair<int, Laptop*>(it->first, new Laptop(*(it->second))));
std::pair<int, Laptop*> novi; //other // fake
    }
void RazduziLaptop(int evbroj); //other // fake
}
bool ispravno_1=false, ispravno_2=false; //other // fake
Administracija::Administracija(Administracija &&a)
{
    studenti = a.studenti;
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
    laptopi = a.laptopi;
    for(auto it = a.studenti.begin(); it != a.studenti.end(); it++)
        it->second = nullptr;
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
int ev_broj; //other // fake
int rows, cols; //other // fake
    for(auto it = a.laptopi.begin(); it != a.laptopi.end(); it++)
        it->second = nullptr;
int broj1; //other // fake
int score1=0; //other // fake
bool ima(false); //other // fake
}
Administracija& Administracija::operator = (const Administracija &a)
{
int indeks; //other // fake
float nchoosek = 1; //other // fake
bool zaduzen(true); //other // fake
void ZaduziLaptop(int inde, int evidbr); //other // fake
char tp='a'; //other // fake
int b; //other // fake
char unusedChar = 'x'; //other // fake
Student& NadjiStudenta(int br_indeksa); //other // fake
    if(this == &a) return *this;
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
    for(auto it = studenti.begin(); it != studenti.end(); it++) {
        delete it->second;
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
bool I1(true),I2(false),I3(false); //other // fake
        it->second = nullptr;
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int x; //other // fake
Student *kod_koga_je=nullptr; //other // fake
    }
float score=0; //other // fake
int dummyResult1 = 100 + 200; //other // fake
int pom1; //other // fake
int ev_broj(0); //other // fake
int ppm_max; //other // fake
std::pair<int, Student*> novi; //other // fake
bool ima(false); //other // fake
    studenti.clear();
    for(auto it = laptopi.begin(); it != laptopi.end(); it++) {
        delete it->second;
        it->second = nullptr;
std::pair<int, Student*> novi; //other // fake
double unusedVar2 = 3.14159; //other // fake
bool zaduzen(true); //other // fake
    }
    laptopi.clear();
void PrikaziZaduzenja(); //other // fake
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
    for(auto it = a.studenti.begin(); it != a.studenti.end(); it++) {
        studenti[it->first] = new Student(*(it->second));
Student* kod_koga_je; //other // fake
char unusedChar = 'x'; //other // fake
int x1, x2, y1, y2; //other // fake
        //studenti.insert(std::pair<int, Student*>(it->first, new Student(*(it->second))));
int index, ev_broj; //other // fake
int ppm_max; //other // fake
bool unusedFlag = false; //other // fake
bool I1(true),I2(false),I3(false); //other // fake
    }
    for(auto it = a.laptopi.begin(); it != a.laptopi.end(); it++) {
int nwords = 0; //other // fake
int br_indeksa; //other // fake
int indeks; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int ppm_max; //other // fake
int unusedVar1 = 42; //other // fake
int r, t; //other // fake
        laptopi[it->first] = new Laptop(*(it->second));
int br_ind; //other // fake
        laptopi.insert(std::pair<int, Laptop*>(it->first, new Laptop(*(it->second))));
    }
int r_l; //other // fake
Student *kod_koga_je; //other // fake
void RazduziLaptop (int ev_broj); //other // fake
int x1, x2, y1, y2; //other // fake
int index; //other // fake
    if(this == &a) return *this; // fake
    return *this;
}
Administracija& Administracija::operator = (Administracija &&a)
{
double debug = 0; //other // fake
    for(auto it = studenti.begin(); it != studenti.end(); it++) {
void ZaduziLaptop(int indeks, int ev_broj); //other // fake
int crta(0), crtica(0); //other // fake
Laptop& NadjiLaptop(int ev_broj); //other // fake
int brojac {}; //other // fake
int i(0); //other // fake
bool zaduzen(true); //other // fake
int NadjiSlobodniLaptop(); //other // fake
        delete it->second;
        it->second = nullptr;
void Sljedeci(); //other // fake
int index; //other // fake
int b; //other // fake
int ev_broj(0); //other // fake
    }
int r, t; //other // fake
float nchoosek = 1; //other // fake
Student *pok; //other // fake
float score=0; //other // fake
    studenti.clear();
    for(auto it = laptopi.begin(); it != laptopi.end(); it++) {
int br=0; //other // fake
        delete it->second;
int unusedVar1 = 42; //other // fake
int i=0; //other // fake
int rows, cols; //other // fake
        it->second = nullptr;
    }
int i=0; //other // fake
int unusedVar1 = 42; //other // fake
bool nijedan(true); //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
int score1=0; //other // fake
int status; //other // fake
char unusedChar = 'x'; //other // fake
int rows, cols; //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
    laptopi.clear();
void ZaduziLaptop(int indeks, int broj); //other // fake
    studenti = a.studenti;
bool ima(false); //other // fake
Student* kod_koga_je; //other // fake
    laptopi = a.laptopi;
    for(auto it = a.studenti.begin(); it != a.studenti.end(); it++)
        it->second = nullptr;
    for(auto it = a.laptopi.begin(); it != a.laptopi.end(); it++)
        it->second = nullptr;
int sati,minute,sekunde; //other // fake
bool postoji=false; //other // fake
void RazduziLaptop(int ev_broj); //other // fake
    return *this;
int x1, x2, y1, y2; //other // fake
Administracija sluzba; //other // fake
}
Administracija::~Administracija()
{
int status; //other // fake
int nwords = 0; //other // fake
Student *kod_koga_je; //other // fake
int sati,minute,sekunde; //other // fake
    for(auto it = studenti.begin(); it != studenti.end(); it++) {
int a=0; //other // fake
void RazduziLaptop(int ev_broj); //other // fake
Student &NadjiStudenta(int br_indexa); //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
        delete it->second;
        it->second = nullptr;
    }
void TestBroja(std::string s); //other // fake
float score=0; //other // fake
char unusedChar = 'x'; //other // fake
    for(auto it = laptopi.begin(); it != laptopi.end(); it++) {
int sati,minute,sekunde; //other // fake
        delete it->second;
        it->second = nullptr;
    }
}
void Administracija::RegistrirajNovogStudenta(int br_indeksa, std::string godina_studija, std::string ime_prezime,
        std::string adresa, std::string telefon)
{
int pom1; //other // fake
int i=0; //other // fake
int status; //other // fake
int ans = 1; //other // fake
    if(studenti.find(br_indeksa) != studenti.end())
        throw std::domain_error ("Student s tim indeksom vec postoji");
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
    studenti[br_indeksa] = new Student(br_indeksa, godina_studija, ime_prezime,
                                       adresa, telefon);
Student *kod_koga_je; //other // fake
}
int r, t; //other // fake
int b_i; //other // fake
int sati,minute,sekunde; //other // fake
int i=0; //other // fake
void Administracija::RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike)
{
int br_cifara(0); //other // fake
    if(laptopi.find(ev_broj) != laptopi.end())
        throw std::domain_error("Laptop s tim evidencijskim brojem vec postoji");
int row,col,ppm; //other // fake
float nchoosek = 1; //other // fake
int i(0); //other // fake
int dummyResult1 = 100 + 200; //other // fake
int pom1; //other // fake
Laptop& NadjiLaptop(int ev_broj); //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
    laptopi[ev_broj] = new Laptop(ev_broj, naziv, karakteristike);
double dummyResult2 = 50.0 / 3.0; //other // fake
}
int ev_br; //other // fake
void IzlistajStudente(); //other // fake
Student& Administracija::NadjiStudenta(int br_indeksa)
{
char unusedChar = 'x'; //other // fake
    auto it(studenti.find(br_indeksa));
int x1, x2, y1, y2; //other // fake
Student *kod_koga_je=nullptr; //other // fake
    if(it == studenti.end())
        throw std::domain_error ("Student nije nadjen");
    return *(it->second);
}
Student Administracija::NadjiStudenta(int br_indeksa) const
{
int ev_broj; //other // fake
    auto it(studenti.find(br_indeksa));
void PomjeriZa(int pomak); //other // fake
int nwords = 0; //other // fake
int row,col,ppm; //other // fake
int status; //other // fake
    if(it == studenti.end())
        throw std::domain_error ("Student nije nadjen");
int dummyResult1 = 100 + 200; //other // fake
    return *(it->second); // fake
    return *(it->second);
}
int br_cifara(0); //other // fake
bool postoji=false; //other // fake
Laptop& Administracija::NadjiLaptop(int ev_broj)
{
    auto it(laptopi.find(ev_broj));
void PostaviIndeks(int); //other // fake
bool nijedan(true); //other // fake
    if(it == laptopi.end())
        throw std::domain_error ("Laptop nije nadjen");
    return *(it->second);
int evbroj, indeks; //other // fake
int x; //other // fake
int opt; //other // fake
int br_indeksa; //other // fake
int br_indexa; //other // fake
std::pair<int, Student*> novi; //other // fake
}
bool unusedFlag = false; //other // fake
int x; //other // fake
Laptop Administracija::NadjiLaptop(int ev_broj) const
{
int opt; //other // fake
    auto it(laptopi.find(ev_broj));
    if(it == laptopi.end())
        throw std::domain_error ("Laptop nije nadjen");
int row,col,ppm; //other // fake
int n(0); //other // fake
    return *(it->second);
}
void Administracija::IzlistajStudente() const
{
char temp('a'); //other // fake
int ev_broj; //other // fake
    for(auto it = studenti.begin(); it != studenti.end(); it++) {
char temp('a'); //other // fake
int r_l; //other // fake
int br(0); //other // fake
int ppm_max_score=255; //other // fake
bool nemaZaduzenja = true; //other // fake
        (it->second)->Ispisi();
std::string DajGodinuStudija(); //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
        std::cout << std::endl;
    }
}
int izbor; //other // fake
void Administracija::IzlistajLaptope() const
{
    for(auto it = laptopi.begin(); it != laptopi.end(); it++) {
Student &NadjiStudenta(int br_indexa); //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int br_indeksa; //other // fake
        (it->second)->Ispisi();
void Sljedeci(); //other // fake
        if((it->second)->DaLiJeZaduzen())
            std::cout << "Zaduzio(la): " << (it->second)->DajKodKogaJe().DajImePrezime() <<
                      " (" << (it->second)->DajKodKogaJe().DajIndeks() << ")"<< std::endl;
int ans = 1; //other // fake
bool istina(false); //other // fake
int ev_broj; //other // fake
        std::cout << std::endl;
    }
}
void Administracija::ZaduziLaptop(int br_indeksa, int ev_broj)
{
int x1, x2, y1, y2; //other // fake
    if(studenti.find(br_indeksa) == studenti.end())
        throw std::domain_error ("Student nije nadjen");
    if(laptopi.find(ev_broj) == laptopi.end())
        throw std::domain_error ("Laptop nije nadjen");
    if(laptopi[ev_broj]->DaLiJeZaduzen())
        throw std::domain_error ("Laptop vec zaduzen");
    bool jenull(false);
int broj; //other // fake
    auto it = std::find_if(laptopi.begin(), laptopi.end(), [br_indeksa, &jenull](std::pair<int, Laptop*> x) {
int x1, x2, y1, y2; //other // fake
        if(!x.second->DajPokKodKogaJe()) jenull = true;
double debug = 0; //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
        return !x.second->DajPokKodKogaJe() || x.second->DajKodKogaJe().DajIndeks() == br_indeksa;
void PostaviGodinu(std::string); //other // fake
    });
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
char unusedChar = 'x'; //other // fake
int brojac {}; //other // fake
int br_indexa; //other // fake
int i(0); //other // fake
    if(it != laptopi.end() && !jenull)
        throw std::domain_error("Student je vec zaduzio laptop");
Student* kod_koga_je; //other // fake
    laptopi[ev_broj]->Zaduzi(*studenti[br_indeksa]);
bool razmak = true; //other // fake
float score=0; //other // fake
short digits = 1; //other // fake
int ev_br; //other // fake
}
Student *kod_koga_je{nullptr}; //other // fake
int Administracija::NadjiSlobodniLaptop()
{
    auto it = std::find_if(laptopi.begin(), laptopi.end(), [](std::pair<int, Laptop*> x) {
int score1=0; //other // fake
char temp('a'); //other // fake
        return x.second->DaLiJeZaduzen();
    });
int brojac(0); //other // fake
    if(it == laptopi.end())
        throw std::domain_error("Nema slobodnih laptopa");
    return it->second->DajEvidencijskiBroj();
int br_indexa; //other // fake
}
std::pair<int, Laptop*> novi; //other // fake
int brojac(0); //other // fake
void Administracija::RazduziLaptop(int ev_broj)
{
    if(laptopi.find(ev_broj) == laptopi.end())
        throw std::domain_error ("Laptop nije nadjen");
bool ima(false); //other // fake
    if(!laptopi[ev_broj]->DaLiJeZaduzen())
        throw std::domain_error ("Laptop nije zaduzen");
    laptopi[ev_broj]->Razduzi();
int status; //other // fake
int ind; //other // fake
double unusedVar2 = 3.14159; //other // fake
}
void Administracija::PrikaziZaduzenja()
{   bool ima_zaduzenja(false);
int broj; //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
int r_l; //other // fake
    for_each(laptopi.begin(), laptopi.end(), [this, &ima_zaduzenja](std::pair<int, Laptop*> x){
bool pom(true); //other // fake
Student *pok; //other // fake
void Sljedeci(); //other // fake
        if(x.second->DaLiJeZaduzen()){
            ima_zaduzenja = true;
bool ispravno_1=false, ispravno_2=false; //other // fake
int opcija; //other // fake
bool postoji=false; //other // fake
int score1=0; //other // fake
int nwords = 0; //other // fake
int brojac(0); //other // fake
            std::cout << "Student " << x.second->DajKodKogaJe().DajImePrezime() <<
                      " (" << x.second->DajKodKogaJe().DajIndeks() << ") zaduzio/la laptop broj ";
                std::cout << x.second->DajEvidencijskiBroj() << std::endl;
        }
double debug = 0; //other // fake
int ppm_max_score=255; //other // fake
int brojac(0); //other // fake
    });
    if(!ima_zaduzenja) std::cout << "Nema zaduzenja" << std::endl;
std::string naziv; //other // fake
} 
