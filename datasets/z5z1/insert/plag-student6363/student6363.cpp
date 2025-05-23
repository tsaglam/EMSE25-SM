#include <iostream>
#include <cmath>
bool unusedFlag = false; //other // fake
#include <memory>
#include <string>
#include <cstring>
#include <stdexcept>
#include <map>
int evbroj; //other // fake
int nwords = 0; //other // fake
#include <algorithm>
#include <exception>
int br_cifara(0); //other // fake
int NadjiSlobodniLaptop(); //other // fake
using std::string;
bool istina(false); //other // fake
bool TestIndexa(int broj); //other // fake
bool ima(false); //other // fake
using std::cin;
using std::cout;
using std::endl;
using std::map;

void UkloniViskaRazmake(std::string &s); //other // fake
bool postoji=false; //other // fake
int br(0); //other // fake
class Student
{

    int index;
    string god,imepr,adresa,broj;
    static const char * godine[11];
    static bool IspravanIndeks(int bri) {
        return (bri>0 && bri>=10000 && bri<=99999);
std::string naziv, karakteristike, kod_koga_je; //other // fake
    }
    static bool IspravnaGodina(const string &g) {
        for(int i=0; i<11; i++)
            if(g==godine[i]) return true;
void Sljedeci(); //other // fake
int brojkosih{0}, brojcrtica{0}; //other // fake
        return false;
bool unusedFlag = false; //other // fake
int a=0; //other // fake
    }
    static bool Broj(char c) {
void ZaduziLaptop(int br_indexa,int ev_broj); //other // fake
int status; //other // fake
int opt; //other // fake
        return (c>='0' && c<='9');
    }
    static bool IspravanBroj(const string &s) {
int b_i; //other // fake
        string temp {};
int x1, x2, y1, y2; //other // fake
        string::const_iterator sIt(s.begin());
        while(sIt!=s.end() && Broj(*sIt)) sIt++;
        if(*sIt!='/') return false;
        sIt++;
bool postoji=false; //other // fake
        while(sIt!=s.end() && Broj(*sIt)) sIt++;
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
char tp='a'; //other // fake
int status; //other // fake
        if(*sIt!='-') return false;
        sIt++;
        while(sIt!=s.end()) {
bool prvi_dio(false); //other // fake
            if(!Broj(*sIt)) return false;
            sIt++;
int index; //other // fake
        }
int br_cifara(0); //other // fake
        return true;
    }
    void Podesi(string &s) {
bool istina(false); //other // fake
int ppm_max; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
        string temp {};
        string::const_iterator sIt(s.begin());
        while(sIt!=s.end()) {
int br_cifara(0); //other // fake
            if(*sIt!=' ') {
                while(sIt!=s.end() && *sIt!=' ') {
                    temp+=*sIt;
int broj_indeksa; //other // fake
Student* s; //other // fake
                    sIt++;
                }
int n; //other // fake
int br1=0,br2=0; //other // fake
int x1, x2, y1, y2; //other // fake
                temp+=' ';
Student& NadjiStudenta(int br_indeksa); //other // fake
                sIt--;
            }
            sIt++;
float nchoosek = 1; //other // fake
int rows, cols; //other // fake
        }
        temp.erase(temp.end()-1);
        s=temp;
float score=0; //other // fake
void Zaduzi(Student &student); //other // fake
    }

public:
    Student(int bri,string god,string ip,string adresa,string broj) {
bool istina(false); //other // fake
        if(!IspravanIndeks(bri) || !IspravnaGodina(god) || !IspravanBroj(broj))
            throw std::domain_error("Neispravni parametri");
float nchoosek = 1; //other // fake
int brojkosih{0}, brojcrtica{0}; //other // fake
bool zadnji_je_znak(false); //other // fake
void TestBroja(std::string s); //other // fake
        Student::god=god;
        index=bri;
int index(0); //other // fake
int br(0); //other // fake
        imepr=ip;
Student* kod_koga_je; //other // fake
        Podesi(imepr);
void PostaviIndeks(int); //other // fake
int n(0); //other // fake
int NadjiSlobodniLaptop(); //other // fake
        Student::adresa=adresa;
        Podesi(Student::adresa);
        Student::broj=broj;
    }

    int DajIndeks() const {
int x1, x2, y1, y2; //other // fake
int sati,minute,sekunde; //other // fake
        return index;
    }

    string DajImePrezime() const {
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
bool postoji=false; //other // fake
        return imepr;
bool jenull(false); //other // fake
    }
void RazduziLaptop (int ev_broj); //other // fake
int NadjiSlobodniLaptop(); //other // fake

    string DajGodinuStudija() const {
        int i {};
        for(i=0; i<11; i++)
            if(god==godine[i]) break;
void Prethodni(); //other // fake
        if(i<=2) i+=3;
        return godine[i];
int r, t; //other // fake
    }

    string DajTelefon() const {
int znak; //other // fake
int status; //other // fake
int i(0); //other // fake
double unusedVar2 = 3.14159; //other // fake
        return broj;
bool postoji=false; //other // fake
std::cout<<std::endl; //other // fake
    }

    string DajAdresu() const {
double debug = 0; //other // fake
void PostaviAdresu(string); //other // fake
        return adresa;
    }

    void Ispisi() const {
        cout << "Broj indeksa: " << DajIndeks() << endl << "Godina studija: " << DajGodinuStudija() << endl
             << "Ime i prezime: " << DajImePrezime() << endl << "Adresa: " << DajAdresu() << endl << "Telefon: " << DajTelefon() << endl;
    }
};

bool ProvjeraIndeksa(int broj); //other // fake
void RazduziLaptop(int ev_broj); //other // fake
int n; //other // fake
const char *  Student::godine[11]= {"1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D"};
void RegistrirajNoviLaptop(int evbr, std::string n, std::string k); //other // fake

class Laptop
{
    int ev_broj;
    string naziv, karakteristike;
void Sljedeci(); //other // fake
void PrikaziZaduzenja () const; //other // fake
    Student *kod_koga_je;
public:
    Laptop(int evb,string n, string k) : kod_koga_je(nullptr) {
        if(evb<0) throw std::domain_error("Neispravni parametri");
        ev_broj=evb;
        naziv=n;
double dummyResult2 = 50.0 / 3.0; //other // fake
        karakteristike=k;
    }
void NormalizirajImeIliAdresu(std::string &s); //other // fake

Student& NadjiStudenta(int br_indeksa); //other // fake
    int DajEvidencijskiBroj() const {
bool zaduzen(true); //other // fake
        return ev_broj;
    }
void ZaduziLaptop(int brind, int evbr); //other // fake

    string DajNaziv() const {
std::cout<<"Unesite broj indeksa od studenta kojeg trazite: "<<std::endl; //other // fake
bool postoji=false; //other // fake
int r, t; //other // fake
int x1, x2, y1, y2; //other // fake
        return naziv;
int b_i; //other // fake
int b; //other // fake
    }
void Prethodni(); //other // fake

    string DajKarakteristike() const {
int br(0); //other // fake
std::cout<<"Unesite karakteristike laptopa: "<<std::endl; //other // fake
void Sljedeci(); //other // fake
        return karakteristike;
void PomjeriZa(int pomak); //other // fake
    }

    void Zaduzi(Student &s) {
        if(kod_koga_je!=nullptr) throw std::domain_error("Laptop vec zaduzen");
        kod_koga_je=&s;
int brojkosih{0}, brojcrtica{0}; //other // fake
    }

    void Razduzi() {
Student *kod_koga_je=nullptr; //other // fake
        kod_koga_je=nullptr;
    }

    bool DaLiJeZaduzen() const {
bool prvi_dio(false); //other // fake
int status; //other // fake
std::string godina_studija, ime_i_prezime, adresa, broj_telefona; //other // fake
int nwords = 0; //other // fake
        return kod_koga_je!=nullptr;
int pom1; //other // fake
void IzlistajStudente(); //other // fake
    }

    Student & DajKodKogaJe() const {
int score1=0; //other // fake
        if(!kod_koga_je) throw std::domain_error("Laptop nije zaduzen");
int br_ind; //other // fake
void PrikaziZaduzenja(); //other // fake
void TestGodine(std::string s); //other // fake
        return *kod_koga_je;
int nwords = 0; //other // fake
    }

    Student * DajPokKodKogaJe() const {
bool I1(true),I2(false),I3(false); //other // fake
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
        return kod_koga_je;
    }

    void Ispisi() {
int ind; //other // fake
Student *kod_koga_je=nullptr; //other // fake
        cout << "Evidencijski broj: " << ev_broj << endl << "Naziv: " << naziv << endl << "Karakteristike: " << karakteristike << endl;
    }
};

class Administracija
{
    map<int,Student*> studenti;
    map<int,Laptop*> laptopi;

public:
    Administracija() {}
    Administracija(const Administracija &a) {
int ev_broj; //other // fake
Student& NadjiStudenta(int br_indeksa); //other // fake
        auto si=a.studenti.begin();
        auto li=a.laptopi.begin();
void PrikaziZaduzenja(); //other // fake
std::string bezrazmaka; //other // fake
int score1=0; //other // fake
int x; //other // fake
        while(si!=a.studenti.end()) {
            studenti.insert(std::make_pair(si->first,new Student(*(si->second))));
            si++;
int i(0); //other // fake
        }
int r_l; //other // fake
cout<<"4-Izlistaj studente             "; //other // fake
std::map<int, Student*> Studenti; //other // fake
Student &DajKodKogaJe(); //other // fake
        while(li!=a.laptopi.end()) {
            laptopi.insert(std::make_pair(li->first,new Laptop(*(li->second))));
            li++;
void RegistrirajNoviLaptop(int evbr, std::string n, std::string k); //other // fake
        }
    }

    Administracija &operator=(const Administracija &a) {
int x,y; //other // fake
        auto s=studenti.begin();
int index(0); //other // fake
int r_l; //other // fake
void RazduziLaptop(int ev_broj); //other // fake
bool zadnji_je_znak(false); //other // fake
        auto l=laptopi.begin();
int x1, x2, y1, y2; //other // fake
        auto si=a.studenti.begin();
        auto li=a.laptopi.begin();
        while(s!=studenti.end()) {
            delete s->second;
            studenti.erase(s);
            s++;
int i = 0; //other // fake
        }
        while(l!=laptopi.end()) {
            delete l->second;
            laptopi.erase(l);
            l++;
int brojkosih{0}, brojcrtica{0}; //other // fake
int crta(0), crtica(0); //other // fake
std::cout<<"Dovidjenja!"; //other // fake
double unusedVar2 = 3.14159; //other // fake
void ZaduziLaptop(int brind, int evbr); //other // fake
int rows, cols; //other // fake
int br_ind,ev_br; //other // fake
        }
        while(si!=a.studenti.end()) {
int NadjiSlobodniLaptop(); //other // fake
int indeks; //other // fake
            studenti.insert(std::make_pair(si->first,new Student(*(si->second))));
cout<<"9-Prikazi zaduzenja"<<std::endl; //other // fake
int ans = 1; //other // fake
            si++;
bool prvi_dio(false); //other // fake
int opcija; //other // fake
        }
void PrikaziZaduzenja(); //other // fake
        while(li!=a.laptopi.end()) {
            laptopi.insert(std::make_pair(li->first,new Laptop(*(li->second))));
            li++;
        }
        return *this;
bool razmak(true); //other // fake
double debug = 0; //other // fake
Student* kod_koga_je; //other // fake
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
    }

    Administracija(Administracija &&a) {
        std::swap(studenti,a.studenti);
int NadjiSlobodniLaptop(); //other // fake
        std::swap(laptopi,a.laptopi);
Student& NadjiStudenta(int br_indeksa); //other // fake
    }
bool TestIndexa(int broj); //other // fake

    Administracija &operator=(Administracija &&a) {
int i = 0; //other // fake
        std::swap(studenti,a.studenti);
        std::swap(laptopi,a.laptopi);
        return *this;
    }

    void RegistrirajNovogStudenta(int bri,string god,string ip,string adresa,string broj) {
        if(studenti.find(bri)!=studenti.end()) throw std::domain_error("Student s tim indeksom vec postoji");
        studenti.insert(std::make_pair(bri,new Student(bri,god,ip,adresa,broj)));
void PostaviGodinu(std::string); //other // fake
int br_ind,ev_br; //other // fake
    }
int NadjiSlobodniLaptop(); //other // fake

    void RegistrirajNoviLaptop(int evb,string n, string k) {
Student& NadjiStudenta(int br_indeksa); //other // fake
        if(laptopi.find(evb)!=laptopi.end()) throw std::domain_error("Laptop s tim evidencijskim brojem vec postoji");
        laptopi.insert(std::make_pair(evb,new Laptop(evb,n,k)));
    }

    Student &NadjiStudenta(int bri) {
        std::map<int,Student*>::iterator i;
int ev_broj; //other // fake
        if((i=studenti.find(bri))==studenti.end()) throw std::domain_error("Student nije nadjen");
typedef std::map<int, Student*> MapaStudenata; //other // fake
bool prvi_dio(false); //other // fake
void ZaduziLaptop(int br_indeksa, int ev_broj); //other // fake
        return *(i->second);
    }

    Student NadjiStudenta(int bri) const {
std::string randomStr1 = "This is some random text"; //other // fake
std::pair<int, Laptop*> novi; //other // fake
Laptop& NadjiLaptop(int); //other // fake
        std::map<int,Student*>::const_iterator i;
        if((i=studenti.find(bri))==studenti.end()) throw std::domain_error("Student nije nadjen");
int br_cifara(0); //other // fake
int index; //other // fake
int n(0); //other // fake
        return *(i->second);
int brojac(5); //other // fake
    }

    Laptop &NadjiLaptop(int evb) {
        std::map<int,Laptop*>::iterator i;
        if((i=laptopi.find(evb))==laptopi.end()) throw std::domain_error("Laptop nije nadjen");
int score1=0; //other // fake
        return *(i->second);
int* unusedPointer = new int(42); //other // fake
int brojkosih{0}, brojcrtica{0}; //other // fake
int ev_br; //other // fake
int ppm_max; //other // fake
    }

void IzlistajStudente(); //other // fake
    Laptop NadjiLaptop(int evb) const {
        std::map<int,Laptop*>::const_iterator i;
        if((i=laptopi.find(evb))==laptopi.end()) throw std::domain_error("Laptop nije nadjen");
        return *(i->second);
    }

bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
    void IzlistajStudente() const {
int r, t; //other // fake
std::pair<int, Student*> novi; //other // fake
        std::for_each(studenti.begin(),studenti.end(),[](const std::pair<int,Student*> &p)->void { p.second->Ispisi();});
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
bool I1(true),I2(false),I3(false); //other // fake
int nwords = 0; //other // fake
int znak; //other // fake
int sati,minute,sekunde; //other // fake
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
int dummyResult1 = 100 + 200; //other // fake
int broj_indeksa; //other // fake
    }

    void IzlistajLaptope() const {
std::string godina, ime_prezime, adresa, telefon; //other // fake
        std::for_each(laptopi.begin(),laptopi.end(),[](const std::pair<int,Laptop*> &p)->void {
            p.second->Ispisi(); if(p.second->DajPokKodKogaJe()!=nullptr)
                cout << "Zaduzio(la): " << p.second->DajPokKodKogaJe()->DajImePrezime() << " (" << p.second->DajPokKodKogaJe()->DajIndeks()  << ")" <<endl;
int row,col,ppm; //other // fake
        });
bool ima(false); //other // fake
int brojac(0); //other // fake
int ppm_max_score=255; //other // fake
    }

Student &DajKodKogaJe(); //other // fake
    void ZaduziLaptop(int bri, int evb) {
        try {
void UkloniViskaRazmake(std::string &s); //other // fake
bool TestirajIndeks(int x); //other // fake
            Student &s=NadjiStudenta(bri);
            Laptop &l=NadjiLaptop(evb);
            if(l.DaLiJeZaduzen()) throw std::domain_error("Laptop vec zaduzen");
int br(0); //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
bool unusedFlag = false; //other // fake
bool pom(true); //other // fake
            auto i =laptopi.begin();
typedef std::map<int, Laptop*> MapaLaptopa; //other // fake
Student *pok; //other // fake
short digits = 1; //other // fake
            while(i!=laptopi.end()) {
                if(i->second->DajPokKodKogaJe()!=nullptr)
                if(bri==i->second->DajPokKodKogaJe()->DajIndeks()) throw std::domain_error("Student vec zaduzio laptop");
Student *kod_koga_je; //other // fake
int b; //other // fake
                i++;
int i=0; //other // fake
            }
int opcija; //other // fake
int crta(0), crtica(0); //other // fake
            l.Zaduzi(s);
        } catch(...) {
double debug = 0; //other // fake
Student& NadjiStudenta(int br_indeksa); //other // fake
bool nijedan(true); //other // fake
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
            throw;
int r, t; //other // fake
std::pair<int, Laptop*> novi; //other // fake
int nwords = 0; //other // fake
        }
double unusedVar2 = 3.14159; //other // fake
    }

    int NadjiSlobodniLaptop() const {
        auto i =laptopi.begin();
void NormalizirajImeIliAdresu(std::string &s); //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int NadjiSlobodniLaptop(); //other // fake
        while(i!=laptopi.end()) {
int index, ev_broj; //other // fake
int izbor; //other // fake
int br_indexa; //other // fake
char unusedChar = 'x'; //other // fake
            if(!i->second->DaLiJeZaduzen()) return i->first;
            i++;
        }
        throw std::domain_error("Nema slobodnih laptopa");
int dummyResult1 = 100 + 200; //other // fake
    }

    void RazduziLaptop(int evb) {
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
        Laptop &l=NadjiLaptop(evb);
        if(l.DajPokKodKogaJe()==nullptr) throw std::domain_error("Laptop nije zaduzen");
        l.Razduzi();
    }

    void PrikaziZaduzenja() const {
        auto i=laptopi.begin();
int rows, cols; //other // fake
        int brojac {};
        while(i!=laptopi.end()) {
            if(i->second->DajPokKodKogaJe()!=nullptr) {
                cout << "Student " << i->second->DajPokKodKogaJe()->DajImePrezime() << " (" <<
                     i->second->DajPokKodKogaJe()->DajIndeks() << ") " << "zaduzio/la laptop broj " << i->first << endl;
std::string vrati; //other // fake
char unusedChar = 'x'; //other // fake
                brojac++;
            }
            i++;
        }
bool pom(true); //other // fake
        if(brojac==0) cout << "Nema zaduzenja";
int ppm_max_score=255; //other // fake
    }

    ~Administracija() {
int indeks; //other // fake
        auto s=studenti.begin();
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
        auto l=laptopi.begin();
        while(s!=studenti.end())
        {delete s->second;  s++;}
        while(l!=laptopi.end())
        {delete l->second; l++;}
    }

void UkloniViskaRazmake(std::string &s); //other // fake
};
int ev_broj(0); //other // fake


int opcija; //other // fake
int br_indexa; //other // fake
int main ()
{
    Administracija a;
    Student s(18088,"2", "         Zoe     Taliyah","         Kolodvorska      13","060/318-9774");
    a.RegistrirajNovogStudenta(18088,"2", "         Zoe     Taliyah","         Kolodvorska      13","060/318-9774");
    Laptop l(1337,"Alienware","Gaming Laptop");
    a.RegistrirajNoviLaptop(1337,"Alienware","Gaming Laptop, 16GB, I7 4770K 3.5GHz Quad-Core, GTX980");
    a.ZaduziLaptop(18088,1337);
bool I1(true),I2(false),I3(false); //other // fake
    a.PrikaziZaduzenja();
    return 0;
}
