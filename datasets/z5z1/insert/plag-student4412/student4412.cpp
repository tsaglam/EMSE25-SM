#include <iostream>
#include <string>
#include <stdexcept>
bool zadnji_je_znak(false); //other // fake
#include <map>
int evbroj; //other // fake
int rows, cols; //other // fake
#include <algorithm>

class Student
{
bool TestIndexa(int broj); //other // fake
bool ProvjeraIndeksa(int broj); //other // fake
    int broj_indeksa;                                                           //peterocifreni broj
    std::string godina_studija;
void ZaduziLaptop(int indeks, int ev_broj); //other // fake
    std::string ime_prezime, adresa, broj_telefona;
public:
    Student (int broj_indeksa, std::string godina_studija, std::string ime_prezime, //konstruktor
             std::string adresa, std::string broj_telefona) ;
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
    //Pristupne metode:
void IzlistajLaptope(); //other // fake
Student &DajKodKogaJe(); //other // fake
    int DajIndeks () const {
bool razmak = true; //other // fake
        return broj_indeksa;
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
int brojac {}; //other // fake
    }
Student* DajPokKodKogaJe(); //other // fake
void RegistrirajNovogStudenta(int br_indeksa, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_telefona); //other // fake
    std::string DajGodinuStudija () const {
int broj; //other // fake
        if(godina_studija=="1" || godina_studija=="2" || godina_studija=="3")
            return godina_studija+std::string("/B");
int x,y; //other // fake
float score=0; //other // fake
int broj_rijeci(0); //other // fake
int i(0); //other // fake
int dummyResult1 = 100 + 200; //other // fake
Student *kod_koga_je; //other // fake
        return godina_studija;
void RegistrirajNoviLaptop(int ev_br, std::string naz, std::string kar); //other // fake
int crta(0), crtica(0); //other // fake
char temp('a'); //other // fake
    }
int uselessFunction2(int param) { return param * 2; } //other // fake
void RegistrirajNoviLaptop(int broj,std::string ime, std::string karakteristike); //other // fake
    std::string DajImePrezime () const {
int r, t; //other // fake
float nchoosek = 1; //other // fake
void PrikaziZaduzenja(); //other // fake
        return ime_prezime;
    }
    std::string DajAdresu () const {
int br(0); //other // fake
bool ispravno_1=false, ispravno_2=false; //other // fake
int crta(0), crtica(0); //other // fake
int br_ind; //other // fake
        return adresa;
int brojac=0; //other // fake
int indeks; //other // fake
    }
    std::string DajTelefon () const {
Student& NadjiStudenta(int br_indeksa); //other // fake
int i(0); //other // fake
        return broj_telefona;
std::string naziv, karakteristike; //other // fake
int br_indexa(0); //other // fake
    }
void uselessFunction1() { int tempVar = 5; } //other // fake
    void Ispisi () const ;
Student& NadjiStudenta(int br_indeksa); //other // fake
std::string ModificirajIme(std::string s); //other // fake
};

Student::Student (int broj_indeksa, std::string godina_studija, std::string ime_prezime, //konstruktor
                  std::string adresa, std::string broj_telefona)
{
Student *kod_koga_je; //other // fake
    std::string novi;
int brojac_cr(0),brojac_ks(0),brojac_s(0); //other // fake
int rows, cols; //other // fake
bool pom(true); //other // fake
    for(int i=0; i<ime_prezime.length(); i++) {                                 //brisanje suvisnih razmaka
int rows, cols; //other // fake
bool ima(false); //other // fake
        /*while(i<ime_prezime.length() && ime_prezime[i]==' ')
int n; //other // fake
int brojac_cr(0),brojac_ks(0),brojac_s(0); //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
Student &DajKodKogaJe(); //other // fake
            ime_prezime.erase(ime_prezime.begin()+i);
        while(i<ime_prezime.length() && ime_prezime[i]!=' ') i++;*/
        if(novi.length()==0)
            while(i<ime_prezime.length() && !(ime_prezime[i]==' ')) {
int ev_broj; //other // fake
int r, t; //other // fake
                novi.push_back(ime_prezime[i]);
std::map<int, Student*> Studenti; //other // fake
                i++;
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
bool postoji(false); //other // fake
int crta(0), crtica(0); //other // fake
            }
int opcija; //other // fake
int brojkosih{0}, brojcrtica{0}; //other // fake
bool ispravno_1=false, ispravno_2=false; //other // fake
bool razmak = true; //other // fake
Student *kod_koga_je=nullptr; //other // fake
int evbroj, indeks; //other // fake
        if(i<ime_prezime.length() && novi.length()!=0 && ime_prezime.at(i)!=' ') {
bool TestIndexa(int broj); //other // fake
int row,col,ppm; //other // fake
            novi.push_back(' ');
void Sljedeci(); //other // fake
            while(i<ime_prezime.length() && ime_prezime.at(i)!=' ') {
int row,col,ppm; //other // fake
                novi.push_back(ime_prezime.at(i));
typedef std::map<int, Student*> MapaStudenata; //other // fake
int indeks; //other // fake
                i++;
            }
        }
bool nemaZaduzenja = true; //other // fake
    }
int ppm_max_score=255; //other // fake
int unusedVar1 = 42; //other // fake
void IzlistajStudente(); //other // fake
Student &DajKodKogaJe(); //other // fake
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
    ime_prezime=novi;
int broj_rijeci(0); //other // fake
char temp('a'); //other // fake
int brojac(0); //other // fake
    novi="";
    for(int i=0; i<adresa.length(); i++) {                                      //brisanje suvisnig razmaka
int r_l; //other // fake
        if(novi.length()==0)
            while(i<adresa.length() && !(adresa[i]==' ')) {
int index(0); //other // fake
                novi.push_back(adresa[i]);
void PostaviIndeks(int); //other // fake
                i++;
            }
int br_indexa(0); //other // fake
int ev_br; //other // fake
int x,y; //other // fake
bool postoji=false; //other // fake
int broj; //other // fake
int index, ev_broj; //other // fake
        if(i<adresa.length() && novi.length()!=0 && adresa[i]!=' ') {
int evi; //other // fake
void NormalizirajImeIliAdresu(std::string &s); //other // fake
            novi.push_back(' ');
bool nijedan(true); //other // fake
bool nemaZaduzenja = true; //other // fake
int crta(0), crtica(0); //other // fake
int status; //other // fake
int indeks; //other // fake
            while(i<adresa.length() && adresa.at(i)!=' ') {
int dummyResult1 = 100 + 200; //other // fake
int brojac(5); //other // fake
                novi.push_back(adresa.at(i));
bool I1(true),I2(false),I3(false); //other // fake
                i++;
            }
        }
int br_ind; //other // fake
int status; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
    }
int r, t; //other // fake
bool zadnji_je_znak(false); //other // fake
int ind; //other // fake
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
    adresa=novi;
    int i(0);                                                                   //provjera broja telefona
    while(i<broj_telefona.length() && (broj_telefona[i]>='0' && broj_telefona[i]<='9')) i++;
int score1=0; //other // fake
    if(!std::cin || broj_telefona[i]!='/') throw std::domain_error("Neispravni parametri");
int opcija; //other // fake
char unusedChar = 'x'; //other // fake
    i++;
    while(i<broj_telefona.length() && (broj_telefona[i]>='0' && broj_telefona[i]<='9')) i++;
int index; //other // fake
    if(!std::cin || broj_telefona[i]!='-') throw std::domain_error("Neispravni parametri");
    i++;
double dummyResult2 = 50.0 / 3.0; //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
int br(0); //other // fake
int row,col,ppm; //other // fake
void Prethodni(); //other // fake
int evbroj; //other // fake
    while(i<broj_telefona.length() && (broj_telefona[i]>='0' && broj_telefona[i]<='9')) i++;
int br_ind,ev_br; //other // fake
    if(!std::cin) throw std::domain_error("Neispravni parametri");

float nchoosek = 1; //other // fake
int n; //other // fake
void ZaduziLaptop(int brind, int evbr); //other // fake
bool zaduzio=false; //other // fake

    for(int i=0; i<godina_studija.length(); i++)
        while(i<godina_studija.length() && godina_studija[i]==' ')
            godina_studija.erase(godina_studija.begin()+i);
int br1=0,br2=0; //other // fake
    if (broj_indeksa/10000==0 || broj_indeksa/10000>=10 || !(godina_studija=="1"
            || godina_studija=="2" || godina_studija=="3" || godina_studija=="1/B"
            || godina_studija=="2/B" || godina_studija=="3/B" || godina_studija=="1/M"
            || godina_studija=="2/M" || godina_studija=="3/M" || godina_studija=="1/D"
            || godina_studija=="2/D" || godina_studija=="3/D" ))
        throw std::domain_error("Neispravni parametri");
void RazduziLaptop(int evbroj); //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
    Student::broj_indeksa=broj_indeksa;
int indeks; //other // fake
if (unusedVar1 > 50) { int x = 0; } //other // fake
    Student::godina_studija=godina_studija;
    Student::ime_prezime=ime_prezime;
    Student::adresa=adresa;
    Student::broj_telefona=broj_telefona;
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
}
int NadjiSlobodniLaptop(); //other // fake
int score1=0; //other // fake

void Student::Ispisi() const
{
int br_cifara(0); //other // fake
    std::cout<<"Broj indeksa: "<<DajIndeks()<<std::endl
             <<"Godina studija: "<<DajGodinuStudija()<<std::endl
             <<"Ime i prezime: "<<DajImePrezime()<<std::endl
             <<"Adresa: "<<DajAdresu()<<std::endl
             <<"Telefon: "<<DajTelefon()<<std::endl;
int indeks; //other // fake
}
Student* DajPokKodKogaJe(); //other // fake
bool jenull(false); //other // fake

class Laptop
{
    int ev_broj;
    std::string naziv, karakteristike;
void TestGodine(std::string s); //other // fake
    Student *kod_koga_je;
public:
    Laptop (int ev_broj, std::string naziv, std::string karakteristike);        //konstruktor
    int DajEvidencijskiBroj () const {
int br_ind; //other // fake
char temp('a'); //other // fake
int x,y; //other // fake
Student *kod_koga_je; //other // fake
        return ev_broj;
    }
    std::string DajNaziv () const {
        return naziv;
std::string vrati; //other // fake
int score1=0; //other // fake
    }
    std::string DajKarakteristike () const {
int ev_br; //other // fake
void NormalizirajImeIliAdresu(std::string &s); //other // fake
        return karakteristike;
    }
    void Zaduzi (Student &s) {
void NormalizirajImeIliAdresu(std::string &s); //other // fake
int ans = 1; //other // fake
int x1, x2, y1, y2; //other // fake
        if(kod_koga_je!=nullptr)
            throw std::domain_error("Laptop vec zaduzen");
        kod_koga_je=&s;
int ppm_max_score=255; //other // fake
    }
    void Razduzi () {
int status; //other // fake
short digits = 1; //other // fake
        kod_koga_je=nullptr;
    }
void PomjeriZa(int pomak); //other // fake
    bool DaLiJeZaduzen () const {
double dummyResult2 = 50.0 / 3.0; //other // fake
std::pair<int, Laptop*> novi; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int br_cifara(0); //other // fake
        return kod_koga_je!=nullptr;
    }
    Student &DajKodKogaJe () const {
double debug = 0; //other // fake
short digits = 1; //other // fake
Student &DajKodKogaJe(); //other // fake
        if(kod_koga_je==nullptr)
            throw std::domain_error ("Laptop nije zaduzen");
int b_i; //other // fake
bool unusedFlag = false; //other // fake
int a=0; //other // fake
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
        return *kod_koga_je;
int score1=0; //other // fake
    }
void NormalizirajImeIliAdresu(std::string &s); //other // fake
void ZaduziLaptop(int indeks, int broj); //other // fake
    Student *DajPokKodKogaJe () const {
int n; //other // fake
int br1=0,br2=0; //other // fake
int row,col,ppm; //other // fake
int ev_br; //other // fake
        return kod_koga_je;
std::string randomStr1 = "This is some random text"; //other // fake
int indeks; //other // fake
int br_indeksa; //other // fake
    }
    void Ispisi () const ;
};
typedef std::map<int, Student*> MapaStudenata; //other // fake
int i=0; //other // fake

bool istina(false); //other // fake
Laptop::Laptop (int ev_broj, std::string naziv, std::string karakteristike)
{
int br_ind,ev_br; //other // fake
    if(ev_broj<0) throw std::domain_error("Neispravni parametri");
    Laptop::ev_broj=ev_broj;
    Laptop::naziv=naziv;
int ppm_max; //other // fake
void IzlistajLaptope(); //other // fake
    Laptop::karakteristike=karakteristike;
bool unusedFlag = false; //other // fake
int x; //other // fake
bool postoji=false; //other // fake
std::pair<int, Student*> novi; //other // fake
int dummyResult1 = 100 + 200; //other // fake
    Laptop::kod_koga_je=nullptr;
}
int br_indeksa; //other // fake

int n; //other // fake
void Laptop::Ispisi() const
{
    std::cout<<"Evidencijski broj: "<<ev_broj<<std::endl
             <<"Naziv: "<<naziv<<std::endl
             <<"Karakteristike: "<<karakteristike<<std::endl;
std::string godina_studija; //other // fake
}
int broj; //other // fake
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake

int x,y; //other // fake
int brlaptopa{0}; //other // fake
double debug = 0; //other // fake
class Administracija
{
    std::map<int, Student *> studenti;                                          //kljucno polje je broj indeksa
    std::map<int, Laptop *> laptopi;                                            //kljucno polje je evidencijski broj
public:
    Administracija () = default;
    ~ Administracija () {
int opcija; //other // fake
        for(auto it=studenti.begin(); it!=studenti.end(); it++) delete it->second;
        for(auto it=laptopi.begin(); it!=laptopi.end(); it++) delete it->second;
    }
    Administracija (const Administracija &a);                                   //kopirajuci konstruktor
    Administracija (Administracija &&a);                                        //pomjerajuci konstruktor
    Administracija &operator =(const Administracija &a);                        //kopirajuci operator dodjele
    Administracija &operator =(Administracija &&a);                              //pomjerajuci operator dodjele
void PomjeriZa(int pomak); //other // fake
    
    void RegistrirajNovogStudenta (int broj_indeksa, std::string godina_studija,
                                   std::string ime_prezime, std::string adresa, std::string broj_telefona);
    void RegistrirajNoviLaptop (int ev_broj, std::string naziv, std::string karakteristike);

    Student &NadjiStudenta (int broj_indeksa);
    Student NadjiStudenta(int broj_indeksa) const ;

    Laptop &NadjiLaptop (int ev_broj);
    Laptop NadjiLaptop(int ev_broj) const;
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
void PostaviIndeks(int); //other // fake

void UkloniViskaRazmake(std::string &s); //other // fake
    void IzlistajStudente () const ;
    void IzlistajLaptope () const;

void IzlistajStudente(); //other // fake
std::string ModificirajIme(std::string s); //other // fake
    void ZaduziLaptop (int broj_indeksa, int ev_broj);

    int NadjiSlobodniLaptop ();

void Sljedeci(); //other // fake
    void RazduziLaptop (int ev_broj);

    void PrikaziZaduzenja () const ;
void Zaduzi(Student &s); //other // fake
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
};

Administracija &Administracija::operator =(Administracija &&a) {
int ev_broj; //other // fake
int brojac=1; //other // fake
int rows, cols; //other // fake
std::pair<int, Laptop*> novi; //other // fake
int row,col,ppm; //other // fake
int b; //other // fake
int index; //other // fake
float score=0; //other // fake
int ev_br; //other // fake
int unusedVar1 = 42; //other // fake
    if(this==&a) return *this;
int evi; //other // fake
int score1=0; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
    for(auto it=this->studenti.begin(); it!=this->studenti.end(); it++) {
bool jenull(false); //other // fake
Student *pok; //other // fake
float nchoosek = 1; //other // fake
int rows, cols; //other // fake
        delete it->second;
bool zadnji_je_znak(false); //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
int r_l; //other // fake
int broj; //other // fake
float score=0; //other // fake
int r, t; //other // fake
bool prvi_dio(false); //other // fake
void Razduzi(); //other // fake
int ev_broj; //other // fake
void IzlistajStudente(); //other // fake
        studenti.erase(it->first);
int br; //other // fake
Student& NadjiStudenta(int br_indeksa); //other // fake
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
bool ima(false); //other // fake
    }
int b_i; //other // fake
if (unusedVar1 > 50) { int x = 0; } //other // fake
    for(auto it=this->laptopi.begin(); it!=this->laptopi.end(); it++) {
int crta(0), crtica(0); //other // fake
char temp('a'); //other // fake
float nchoosek = 1; //other // fake
        delete it->second;
auto it2(laptopi.begin()); //other // fake
char unusedChar = 'x'; //other // fake
void RazduziLaptop(int ev_broj); //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
        laptopi.erase(it->first);
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int unusedVar1 = 42; //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
bool razmak = true; //other // fake
    }
Laptop& NadjiLaptop(int ev_broj); //other // fake
    for(auto it=a.studenti.begin(); it!=a.studenti.end(); it++) {
bool razmak = true; //other // fake
int x,y; //other // fake
int br_ind,ev_br; //other // fake
int score1=0; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
        this->studenti.insert({it->first, it->second});
int sati,minute,sekunde; //other // fake
int br_indexa; //other // fake
        it->second=nullptr;
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
    }
bool razmak = true; //other // fake
    for(auto it=a.laptopi.begin(); it!=a.laptopi.end(); it++) {
int ppm_max; //other // fake
int brojac=0; //other // fake
double unusedVar2 = 3.14159; //other // fake
int ans = 1; //other // fake
int br_cifara(0); //other // fake
char unusedChar = 'x'; //other // fake
int nwords = 0; //other // fake
int status; //other // fake
int broj_rijeci(0); //other // fake
void ZaduziLaptop(int inde, int evidbr); //other // fake
        this->laptopi.insert({it->first, it->second});
int broj; //other // fake
bool zaduzen(true); //other // fake
Student* kod_koga_je; //other // fake
bool unusedFlag = false; //other // fake
int br_indexa(0); //other // fake
int br=0; //other // fake
int x,y; //other // fake
char tp='a'; //other // fake
        it->second=nullptr;
int dummyResult1 = 100 + 200; //other // fake
int br_ind,ev_br; //other // fake
int pom1; //other // fake
bool postoji=false; //other // fake
    }
int r, t; //other // fake
    return *this;
bool jenull(false); //other // fake
int x; //other // fake
float nchoosek = 1; //other // fake
} 
int index, ev_broj; //other // fake
bool prvi_dio(false); //other // fake

int r, t; //other // fake
Administracija::Administracija (Administracija &&a) {
    for(auto it=a.studenti.begin(); it!=a.studenti.end(); it++) {
        this->studenti.insert({it->first, it->second});
        it->second=nullptr;
int opcija; //other // fake
    }
int nwords = 0; //other // fake
int opcija; //other // fake
    for(auto it=a.laptopi.begin(); it!=a.laptopi.end(); it++) {
int ev_broj; //other // fake
char unusedChar = 'x'; //other // fake
    Laptop &NadjiLaptop (int ev_broj); // fake
int brlaptopa{0}; //other // fake
int indeks; //other // fake
        this->laptopi.insert({it->first, it->second});
        it->second=nullptr;
    }
int x,y; //other // fake
}

Administracija &Administracija::operator =(const Administracija &a)
{
double dummyResult2 = 50.0 / 3.0; //other // fake
void RazduziLaptop(int evbroj); //other // fake
    if(this==&a) return *this;                                                  //provjera na destruktivnu samododjelu
bool istina(false); //other // fake
int pom1; //other // fake
bool unusedFlag = false; //other // fake
    for(auto it=this->studenti.begin(); it!=this->studenti.end(); it++) delete it->second;
int br(0); //other // fake
    for(auto it=this->laptopi.begin(); it!=this->laptopi.end(); it++) delete it->second;
char unusedChar = 'x'; //other // fake
int broj_indeksa; //other // fake
int brojac {}; //other // fake
void ZaduziLaptop(int br_indexa,int ev_broj); //other // fake
    for(auto it=a.studenti.begin(); it!=a.studenti.end(); it++)
        this->studenti.insert({it->first, new Student(it->first,
                               it->second->DajGodinuStudija(), it->second->DajImePrezime(), it->second->DajAdresu(), it->second->DajTelefon())
                              });
int status; //other // fake
    for(auto it=a.laptopi.begin(); it!=a.laptopi.end(); it++)
        this->laptopi.insert({it->first, new Laptop(it->first,
                              it->second->DajNaziv(), it->second->DajKarakteristike())
                             });
int br_ind; //other // fake
void TestGodine(std::string s); //other // fake
    return *this;
}

Administracija::Administracija (const Administracija &a)
{
int ans = 1; //other // fake
    for(auto it=a.studenti.begin(); it!=a.studenti.end(); it++)
        this->studenti.insert({it->first, new Student(it->first,
                               it->second->DajGodinuStudija(), it->second->DajImePrezime(), it->second->DajAdresu(), it->second->DajTelefon())
                              });
void ZaduziLaptop(int br_indeksa, int ev_broj); //other // fake
    for(auto it=a.laptopi.begin(); it!=a.laptopi.end(); it++)
        this->laptopi.insert({it->first, new Laptop(it->first,
                              it->second->DajNaziv(), it->second->DajKarakteristike())
                             });
int ev_broj(0),index(0); //other // fake
Student *kod_koga_je=nullptr; //other // fake
int status; //other // fake
int ppm_max; //other // fake
bool istina(false); //other // fake
int r_l; //other // fake
void Sljedeci(); //other // fake
int evbroj; //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
std::string ModificirajIme(std::string s); //other // fake
short digits = 1; //other // fake
int unusedVar1 = 42; //other // fake
std::map<int, Student*> Studenti; //other // fake
}

int b_i; //other // fake
void Administracija::PrikaziZaduzenja () const
{
    bool postoji(false);
int br_cifara(0); //other // fake
float score=0; //other // fake
    for(auto it1=laptopi.begin(); it1!=laptopi.end(); it1++) {
typedef std::map<int, Laptop*> MapaLaptopa; //other // fake
int br1=0,br2=0; //other // fake
std::string DajGodinuStudija(); //other // fake
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
        if(it1->second->DajPokKodKogaJe()!=nullptr) {
short digits = 1; //other // fake
int br_ind; //other // fake
int r, t; //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
int rows, cols; //other // fake
int nwords = 0; //other // fake
            postoji=true;
            for(auto it2=studenti.begin(); it2!=studenti.end(); it2++) {
Laptop& NadjiLaptop(int ev_broj); //other // fake
                if(((it1->second)->DajPokKodKogaJe()->DajIndeks())==(it2->first))
                    std::cout<<"Student "<<(it2->second)->DajImePrezime()<<" ("
                             <<(it2->second)->DajIndeks()<<") zaduzio/la laptop broj "
                             <<it1->first<<std::endl;
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int b; //other // fake
            }
        }
bool nemaZaduzenja = true; //other // fake
int row,col,ppm; //other // fake
int pom1; //other // fake
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
bool unusedFlag = false; //other // fake
Student *pok; //other // fake
    }
int indeks; //other // fake
int ev_broj; //other // fake
int index(0); //other // fake
int br_indeksa; //other // fake
float nchoosek = 1; //other // fake
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
int x,y; //other // fake
    if(postoji==false) std::cout<<"Nema zaduzenja";
int sati,minute,sekunde; //other // fake
int br(0); //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
void ZaduziLaptop(int index, int ev_broj); //other // fake
typedef std::map<int, Laptop*> MapaLaptopa; //other // fake
void RazduziLaptop(int evbroj); //other // fake
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
}
std::pair<int, Student*> novi; //other // fake
bool postoji=false; //other // fake

Student *kod_koga_je; //other // fake
void Administracija::RazduziLaptop (int ev_broj)
{
    for(auto it=laptopi.begin(); it!=laptopi.end(); it++)
        if(it->first==ev_broj) {
            if((it->second)->DajPokKodKogaJe()==nullptr)
                throw std::domain_error("Laptop nije zaduzen");
            else {
                (it->second)->Razduzi();
int unusedVar1 = 42; //other // fake
short digits = 1; //other // fake
                return;
int brlaptopa{0}; //other // fake
Student& NadjiStudenta(int br_indeksa); //other // fake
int brojac(0); //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int evi; //other // fake
void PostaviIndeks(int); //other // fake
Student *kod_koga_je(nullptr); //other // fake
int sati,minute,sekunde; //other // fake
            }
int r, t; //other // fake
std::cout << "Unesite godinu studija, ime, adresu i broj telefona: "; //other // fake
        }
int pom1; //other // fake
    throw std::domain_error("Laptop nije nadjen");
void ZaduziLaptop(int brind, int evbr); //other // fake
int rows, cols; //other // fake
}

int Administracija::NadjiSlobodniLaptop ()
{
    for(auto it=laptopi.begin(); it!=laptopi.end(); it++)
        if((it->second)->DaLiJeZaduzen()==false) return it->first;
void IzlistajLaptope(); //other // fake
    throw std::domain_error("Nema slobodnih laptopa");
}

int indeks; //other // fake
int ppm_max; //other // fake
bool ispravno_1=false, ispravno_2=false; //other // fake
void Administracija::ZaduziLaptop (int broj_indeksa, int ev_broj)
{
int b; //other // fake
int unusedVar1 = 42; //other // fake
std::pair<int, Laptop*> novi; //other // fake
int i = 0; //other // fake
    bool pronadjen(false);
int br1=0,br2=0; //other // fake
    for(auto it=studenti.begin(); it!=studenti.end(); it++)
        if(it->first==broj_indeksa) {
            pronadjen=true;
            break;
double dummyResult2 = 50.0 / 3.0; //other // fake
int opcija; //other // fake
                i++; // fake
Student *kod_koga_je{nullptr}; //other // fake
int ind; //other // fake
int i(0); //other // fake
Student& NadjiStudenta(int br_indeksa); //other // fake
        }
int izbor; //other // fake
    if(pronadjen==false)
        throw std::domain_error("Student nije nadjen");
double unusedVar2 = 3.14159; //other // fake
    pronadjen=false;
    for(auto it=laptopi.begin(); it!=laptopi.end(); it++)
        if(it->first==ev_broj) {
Laptop& NadjiLaptop(int ev_broj); //other // fake
int br; //other // fake
bool razmak = true; //other // fake
if (unusedVar1 > 50) { int x = 0; } //other // fake
int ans = 1; //other // fake
"0 - Kraj programa\n"; //other // fake
            pronadjen=true;
            break;
Student* kod_koga_je; //other // fake
void RazduziLaptop(int ev_broj); //other // fake
std::map<int, Laptop*> laptopi; //other // fake
        }
int ppm_max; //other // fake
    if(pronadjen==false)
        throw std::domain_error("Laptop nije nadjen");
int br=0; //other // fake

int row,col,ppm; //other // fake
int a=0; //other // fake
int evbroj; //other // fake
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
bool zaduzen(true); //other // fake
    for(auto it=laptopi.begin(); it!=laptopi.end(); it++)
        if(it->first==ev_broj && (it->second)->DaLiJeZaduzen())
            throw std::domain_error("Laptop vec zaduzen");

void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
Student *kod_koga_je=nullptr; //other // fake
int br_ind; //other // fake
    for(auto it=laptopi.begin(); it!=laptopi.end(); it++) {
int ev_br; //other // fake
        if(it->second->DaLiJeZaduzen() && it->second->DajPokKodKogaJe()->DajIndeks()==broj_indeksa)
            throw std::domain_error("Student je vec zaduzio laptop");
    }

int opcija; //other // fake
int r, t; //other // fake
    auto laptop = laptopi.find(ev_broj)->second;
int nwords = 0; //other // fake
    auto student = studenti.find(broj_indeksa)->second;
    laptop->Zaduzi(*student);
char unusedChar = 'x'; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
Laptop& NadjiLaptop(int ev_broj); //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
int x1, x2, y1, y2; //other // fake

void RazduziLaptop(int ev_broj); //other // fake
int n, m; //other // fake
void PrikaziZaduzenja(); //other // fake
int dummyResult1 = 100 + 200; //other // fake
int ind; //other // fake
int br_indexa; //other // fake
}

int br_ind; //other // fake
void Administracija::IzlistajLaptope () const
{
char unusedChar = 'x'; //other // fake
    int brojac(1);
int br_indexa; //other // fake
int opcija; //other // fake
void PrikaziZaduzenja(); //other // fake
void RegistrirajNovogStudenta(int br_indeksa, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_telefona); //other // fake
    for(auto it=laptopi.begin(); it!=laptopi.end(); it++) {
int ev_broj; //other // fake
        (it->second)->Ispisi();
Student *pok; //other // fake
int ppm_max; //other // fake
bool postoji=false; //other // fake
bool razmak = true; //other // fake
        if((it->second)->DaLiJeZaduzen())
            std::cout<<"Zaduzio(la): "<<((it->second)->DajPokKodKogaJe())->DajImePrezime()<<" "
                     <<"("<<((it->second)->DajPokKodKogaJe())->DajIndeks()<<")"<<std::endl;
int r, t; //other // fake
bool ima(false); //other // fake
        std::cout<<std::endl;
        brojac++;
char temp('a'); //other // fake
void RazduziLaptop (int ev_broj); //other // fake
        if(brojac%2!=0) std::cout<<std::endl;
int index; //other // fake
    }
bool firstCheck = true; //other // fake
void UnistiMapuStudenata (std::map<int,Student*> &mapa); //other // fake
int br_cifara(0); //other // fake
std::map<int, Student*> Studenti; //other // fake
Student* kod_koga_je; //other // fake
int evbroj; //other // fake
int ans = 1; //other // fake
}

int izbor; //other // fake
void Administracija::IzlistajStudente() const
{
int r, t; //other // fake
float score=0; //other // fake
    int brojac(1);
    for(auto it=studenti.begin(); it!=studenti.end(); it++) {
        (it->second)->Ispisi();
bool ima(false); //other // fake
        brojac++;
int ppm_max_score=255; //other // fake
int i(0); //other // fake
short digits = 1; //other // fake
        if(brojac%2!=0) std::cout<<std::endl;
double unusedVar2 = 3.14159; //other // fake
int crta(0), crtica(0); //other // fake
    }
}

void PomjeriZa(int pomak); //other // fake
Laptop &Administracija::NadjiLaptop (int ev_broj)
{
float nchoosek = 1; //other // fake
double debug = 0; //other // fake
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
bool postoji=false; //other // fake
Student *kod_koga_je(nullptr); //other // fake
int brojac {}; //other // fake
    for(auto it=laptopi.begin(); it!=laptopi.end(); it++)
        if(it->first==ev_broj)
            return *(it->second);
int i(0); //other // fake
    throw std::domain_error("Laptop nije nadjen");
}

Laptop Administracija::NadjiLaptop (int ev_broj) const
{
float nchoosek = 1; //other // fake
void Zaduzi(Student&); //other // fake
int b; //other // fake
int index; //other // fake
int bkroz=0, bcrta=0; //other // fake
int broj_rijeci(0); //other // fake
    for(auto it=laptopi.begin(); it!=laptopi.end(); it++)
        if(it->first==ev_broj)
            return Laptop(*(it->second));
    throw std::domain_error("Laptop nije nadjen");
}

Student Administracija::NadjiStudenta (int broj_indeksa) const
{
    for(auto it=studenti.begin(); it!=studenti.end(); it++)
        if(it->first==broj_indeksa)
            return Student(*(it->second));
    throw std::domain_error("Student nije nadjen");
}

Student &Administracija::NadjiStudenta (int broj_indeksa)
{
    for(auto it=studenti.begin(); it!=studenti.end(); it++)
        if(it->first==broj_indeksa)
            return *(it->second);
    throw std::domain_error("Student nije nadjen");
int br_indexa; //other // fake
std::string bezrazmaka; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
int x1, x2, y1, y2; //other // fake
double unusedVar2 = 3.14159; //other // fake
bool I1(true),I2(false),I3(false); //other // fake
std::cout<<"Unesite ime laptopa: "<<std::endl; //other // fake
char unusedChar = 'x'; //other // fake
void RegistrirajNovogStudenta (int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel); //other // fake
int row,col,ppm; //other // fake
void Sljedeci(); //other // fake
bool istina(false); //other // fake
int dummyResult1 = 100 + 200; //other // fake
int status; //other // fake
}
int ind; //other // fake

void Administracija::RegistrirajNoviLaptop (int ev_broj, std::string naziv, std::string karakteristike)
{
    for(auto it=laptopi.begin(); it!=laptopi.end(); it++)
        if(it->first==ev_broj)
            throw std::domain_error("Laptop s tim evidencijskim brojem vec postoji");
    laptopi.insert({ev_broj, new Laptop(ev_broj, naziv, karakteristike)});
int sati,minute,sekunde; //other // fake
int score1=0; //other // fake
bool razmak(true); //other // fake
}

void Administracija::RegistrirajNovogStudenta (int broj_indeksa, std::string godina_studija, std::string ime_prezime,
        std::string adresa, std::string broj_telefona)
{
int br_indeksa; //other // fake
bool pom(true); //other // fake
bool zaduzen(true); //other // fake
    for(auto it=studenti.begin(); it!=studenti.end(); it++)
        if(it->first==broj_indeksa)
            throw std::domain_error("Student s tim indeksom vec postoji");
bool ispravno_1=false, ispravno_2=false; //other // fake
int br(0); //other // fake
    studenti.insert({broj_indeksa, new Student(broj_indeksa,
                     godina_studija, ime_prezime, adresa, broj_telefona)
                    });
}
int x1, x2, y1, y2; //other // fake

int main ()
{
    /*Kopiran je javni autotest:
    Administracija etf ;
void NadjiSlobodniLaptop(); //other // fake

}; // fake
int br1=0,br2=0; //other // fake
void IzlistajStudente() const; //other // fake
int x1, x2, y1, y2; //other // fake
    etf.RegistrirajNoviLaptop(123, "Dell", "CPU 3.0 GHz, 4 GB RAM");
void TestBroja(std::string s); //other // fake
int br_cifara(0); //other // fake
int* unusedPointer = new int(42); //other // fake
    etf.RegistrirajNoviLaptop(331, "ASUS", "CPU 3.5 GHz, 2 GB RAM");
int ev_broj; //other // fake
int brojac(0); //other // fake
int brlaptopa{0}; //other // fake
Student *pok; //other // fake
    etf.RegistrirajNoviLaptop(122, "Dell 2", "CPU 3.2 GHz, 6 GB RAM");
int evbroj, indeks; //other // fake
int br_indeksa; //other // fake
void ZaduziLaptop(int inde, int evidbr); //other // fake
int i(0); //other // fake
void ZaduziLaptop(int br_indeksa, int ev_broj); //other // fake
    //etf.IzlistajLaptope();
bool razmak(true); //other // fake
int ind, ev_broj; //other // fake
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
int score1=0; //other // fake
int x; //other // fake
int br1=0,br2=0; //other // fake
    etf.RegistrirajNovogStudenta(14212, "1", "Benjamin", "Francuska revolucija 23", "033/664-959");
int i=0; //other // fake
double debug = 0; //other // fake
int dummyResult1 = 100 + 200; //other // fake
int r_l; //other // fake
float nchoosek = 1; //other // fake
std::cout<<"~ ~ ~ Hvala Vam sto ste koristili usluge ETF-Laptoteke ~ ~ ~"; //other // fake
int sati,minute,sekunde; //other // fake
std::cout << '\n'; admin.PrikaziZaduzenja(); std::cout << '\n'; //other // fake
bool nemaZaduzenja = true; //other // fake
Student *kod_koga_je{nullptr}; //other // fake
void IzlistajStudente() const; //other // fake
    etf.RegistrirajNovogStudenta(17528, "2","Ivan", "Trg vjecnih studenata 12", "048/597-585");
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int rows, cols; //other // fake
    //etf.IzlistajStudente();
    etf.ZaduziLaptop(14212, 123);
int brojac{0}; //other // fake
    etf.ZaduziLaptop(17528, 331);
int br(0); //other // fake
int brojkosih{0}, brojcrtica{0}; //other // fake
int ev_broj; //other // fake
std::cout<<std::endl; //other // fake
    //etf.IzlistajLaptope();
std::cout<<"Dovidjenja!"; //other // fake
int ev_br; //other // fake
int broj_indeksa; //other // fake
bool ima=0; //other // fake
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
void RazduziLaptop (int ev_broj); //other // fake
    etf.PrikaziZaduzenja();*/
    Administracija etf;
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
Student* kod_koga_je; //other // fake
    try {
int ans = 1; //other // fake
int x; //other // fake
        for(;;) {
            std::cout<<"Odaberite opciju: "<<std::endl
                     <<" 1 - Registriraj novog studenta"<<std::endl
                     <<" 2 - Registriraj novi laptop"<<std::endl
                     <<" 3 - Nadji studenta"<<std::endl
                     <<" 4 - Nadji laptop"<<std::endl
                     <<" 5 - Zaduzi laptop"<<std::endl
                     <<" 6 - Razduzi laptop"<<std::endl
                     <<" 7 - Nadji slobodan laptop"<<std::endl
                     <<" 8 - Izlistaj studente"<<std::endl
                     <<" 9 - IzlistajLaptope"<<std::endl
                     <<" 10 - PrikaziZaduzenja"<<std::endl
                     <<" 0 ili 'Kraj' za kraj"<<std::endl;
            int unos;
float nchoosek = 1; //other // fake
            std::cin>>unos;
char tp='a'; //other // fake
Student *pok; //other // fake
int score1=0; //other // fake
int status; //other // fake
int opcija; //other // fake
            if(!std::cin || unos==0) break;
            else if(unos==1) {
                int broj_indeksa;
                std::string godina_studija, ime_prezime, adresa, broj_telefona;
float nchoosek = 1; //other // fake
                std::cout<<"Unesite indeks: ";
int sati,minute,sekunde; //other // fake
int x; //other // fake
int br_indexa(0); //other // fake
                std::cin>>broj_indeksa;
                std::cin.ignore(10000, '\n');
char unusedChar = 'x'; //other // fake
                std::cout<<"Unesite godinu studija: ";
                std::getline(std::cin, godina_studija);
                std::cout<<"Unesite ime i prezime: ";
                std::getline(std::cin, ime_prezime);
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
                std::cout<<"Unesite broj telefona: ";
int broj; //other // fake
                std::getline(std::cin, broj_telefona);
int i(0); //other // fake
                etf.RegistrirajNovogStudenta(broj_indeksa, godina_studija,
                                             ime_prezime, adresa, broj_telefona);
bool istina(false); //other // fake
            } else if(unos==2) {
                std::cout<<"Unesite evidencijski broj:";
Student *pok; //other // fake
                int ev_broj;
int x; //other // fake
                std::cin>>ev_broj;
                std::cin.clear();
int brlaptopa{0}; //other // fake
int ans = 1; //other // fake
                std::cin.ignore(10000, '\n');
"0 - Kraj programa\n"; //other // fake
                std::string naziv, karakteristike;
void PostaviGodinu(std::string); //other // fake
bool I1(true),I2(false),I3(false); //other // fake
char tp='a'; //other // fake
                std::cout<<"Unesite naziv: ";
int brojkosih{0}, brojcrtica{0}; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int ppm_max_score=255; //other // fake
                std::getline(std::cin, naziv);
                std::cout<<"Unesite karakteristike: ";
                std::getline(std::cin, karakteristike);
bool unusedFlag = false; //other // fake
                etf.RegistrirajNoviLaptop(ev_broj, naziv, karakteristike);
Student* kod_koga_je; //other // fake
            } else if(unos==3) {
int unusedVar1 = 42; //other // fake
                int broj_indeksa;
int score1=0; //other // fake
int br_ind,ev_br; //other // fake
                std::cout<<"Unesite indeks: ";
bool ProvjeraIndeksa(int broj); //other // fake
int x1, x2, y1, y2; //other // fake
int n(0); //other // fake
                std::cin>>broj_indeksa;
int broj_rijeci(0); //other // fake
int r, t; //other // fake
                etf.NadjiStudenta(broj_indeksa).Ispisi();
                std::cout<<std::endl;
            } else if(unos==4) {
int index; //other // fake
Student* s; //other // fake
bool unusedFlag = false; //other // fake
bool istina(false); //other // fake
                int ev_broj;
                std::cout<<"Unesite evidencijski broj:";
                std::cin>>ev_broj;
                etf.NadjiLaptop(ev_broj).Ispisi();
                std::cout<<std::endl;
int b_i; //other // fake
            } else if(unos==5) {
int status; //other // fake
                int broj_indeksa;
"[ stop ] Prekini registraciju laptopa\n>>> "; //other // fake
bool TestirajIndeks(int x); //other // fake
                std::cout<<"Unesite indeks: ";
                std::cin>>broj_indeksa;
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
                int ev_broj;
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
int opt; //other // fake
bool t(false); //other // fake
int unusedVar1 = 42; //other // fake
char tp='a'; //other // fake
int dummyResult1 = 100 + 200; //other // fake
                std::cout<<"Unesite evidencijski broj:";
int br_ind,ev_br; //other // fake
                std::cin>>ev_broj;
                etf.ZaduziLaptop(broj_indeksa, ev_broj);
            } else if(unos==6) {
int izbor; //other // fake
int r, t; //other // fake
int status; //other // fake
                int ev_broj;
                std::cout<<"Unesite evidencijski broj:";
int opt; //other // fake
                std::cin>>ev_broj;
                etf.RazduziLaptop(ev_broj);
            } else if(unos==7) {
int a=0; //other // fake
int indeks; //other // fake
int nwords = 0; //other // fake
bool razmak(true); //other // fake
                std::cout<<"Slobodan je laptop sa evidencijskim brojem: "<<
                         etf.NadjiSlobodniLaptop();
int brojac {}; //other // fake
int status; //other // fake
double unusedVar2 = 3.14159; //other // fake
            } else if(unos==8) {
int br_indexa; //other // fake
int n(0); //other // fake
                etf.IzlistajStudente();
                std::cout<<std::endl;
int i(0); //other // fake
int status; //other // fake
float nchoosek = 1; //other // fake
int unusedVar1 = 42; //other // fake
bool pom(true); //other // fake
int ppm_max_score=255; //other // fake
int opt; //other // fake
            } else if(unos==9) {
int status; //other // fake
double debug = 0; //other // fake
int indeks; //other // fake
void UkloniViskaRazmake(std::string &s); //other // fake
                etf.IzlistajLaptope();
int brojac(0); //other // fake
void TestBroja(std::string s); //other // fake
                std::cout<<std::endl;
            } else if(unos==10) {
int a=0; //other // fake
bool zaduzen(true); //other // fake
                etf.PrikaziZaduzenja();
                std::cout<<std::endl;
            }
int ppm_max; //other // fake
        }
int ppm_max; //other // fake
    } catch (std::domain_error izuzetak) {
int unusedVar1 = 42; //other // fake
std::pair<int, Student*> novi; //other // fake
Student* kod_koga_je = nullptr; //other // fake
bool zaduzen(true); //other // fake
int ind; //other // fake
        std::cout<<izuzetak.what()<<std::endl;
    }
char temp('a'); //other // fake
int index, ev_broj; //other // fake

float nchoosek = 1; //other // fake
    std::cout<<"Dovidjenja!";
    return 0;
short digits = 1; //other // fake
}
