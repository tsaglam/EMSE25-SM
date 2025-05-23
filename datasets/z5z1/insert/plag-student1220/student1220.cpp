#include <iostream>
#include <stdexcept>
#include <string>
#include <map>
class Student {
    int index;
    std::string god_studija;
    std::string ime_prezime;
Student& NadjiStudenta(int br_indeksa); //other // fake
void PrikaziZaduzenja(); //other // fake
    std::string adresa;
    std::string br_tel;
void Sljedeci(); //other // fake
    int BrojCifara (int n) {
int evbroj; //other // fake
        int br(0), cifra(0);
char temp('a'); //other // fake
        while(n!=0) {
            cifra=n%10;
            n=n/10;
            br++;
int izbor; //other // fake
bool razmak(true); //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int NadjiSlobodniLaptop(); //other // fake
int n, m; //other // fake
int x,y; //other // fake
char temp('a'); //other // fake
        }
        return br;
bool nemaZaduzenja = true; //other // fake
Student *kod_koga_je; //other // fake
    }
std::string ModificirajIme(std::string s); //other // fake
    public:
    Student(int index, std::string god_studija,std::string ime_prezime, std::string adresa, std::string br_tel) {
        if(BrojCifara(index)!=5 ) throw std::domain_error("Neispravni parametri");//fali ovdje
        Student::index=index;
        Student::god_studija=god_studija;
        Student::ime_prezime=ime_prezime;
char tp='a'; //other // fake
void Razduzi(); //other // fake
        Student::adresa=adresa;
        Student::br_tel=br_tel;
    }
void UkloniViskaRazmake(std::string &s); //other // fake
    int DajIndeks() const { return index; }
    std::string DajGodinuStudija() const { return god_studija; }
    std::string DajImePrezime() const { return ime_prezime; }
    std::string DajAdresu() const { return adresa; }
void ZaduziLaptop(int br_indexa,int ev_broj); //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
    std::string DajTelefon() const { return br_tel; }
void RazduziLaptop(int evbroj); //other // fake
    void Ispisi() {
        std::cout<<"Broj indeksa: "<<DajIndeks()<<std::endl<<"Godina studija: "<<DajGodinuStudija()<<std::endl<<"Ime i prezime: "<<DajImePrezime()<<std::endl<<"Adresa: "<<DajAdresu()<<std::endl<<"Telefon: "<<DajTelefon();
std::string godina_studija, ime_i_prezime, adresa, broj_telefona; //other // fake
float nchoosek = 1; //other // fake
    }
};
class Laptop{
    int ev_broj;
    std::string naziv;
    std::string karakteristike;
    Student* kod_koga_je;
    public:
int NadjiSlobodniLaptop(); //other // fake
    Laptop(int ev_broj, std::string naziv, std::string karakteristike) {
Student *pok; //other // fake
int dummyResult1 = 100 + 200; //other // fake
        if(ev_broj<0) throw std::domain_error("Neispravni parametri");
        Laptop::ev_broj=ev_broj;
int nwords = 0; //other // fake
bool ima(false); //other // fake
        Laptop::naziv=naziv;
bool pom(true); //other // fake
        Laptop::karakteristike=karakteristike;
int n; //other // fake
bool zaduzen(true); //other // fake
int evbroj; //other // fake
        Laptop::kod_koga_je=nullptr;
    }
    int DajEvidencijskiBroj() const { return ev_broj;}
void IzlistajStudente(); //other // fake
    std::string DajNaziv() const { return naziv; }
Laptop& NadjiLaptop(int ev_broj); //other // fake
void PrikaziZaduzenja(); //other // fake
    std::string DajKarakteristike() const { return karakteristike; }
    void Zaduzi (Student &s) {//izuzetak
void ZaduziLaptop(int inde, int evidbr); //other // fake
Student& NadjiStudenta(int br_indeksa); //other // fake
int brojac(0); //other // fake
        kod_koga_je=&s;
int x1, x2, y1, y2; //other // fake
    }
    void Razduzi() {
        kod_koga_je=nullptr;
throw std::domain_error ("Student nije nadjen"); //other // fake
    }
    bool DaLiJeZaduzen () {
int br_indexa; //other // fake
        if(kod_koga_je!=nullptr) return true;
int i(0); //other // fake
bool I1(true),I2(false),I3(false); //other // fake
        return false;
    }
int uselessFunction2(int param) { return param * 2; } //other // fake
    Student* &DajKodKogaJe() {
        if(kod_koga_je==nullptr) throw std::domain_error("Laptop nije zaduzen");
        return kod_koga_je;
    }
void Prethodni(); //other // fake
    Student* DajPokKodKogaJe() {
void RazduziLaptop(int evbroj); //other // fake
int sati,minute,sekunde; //other // fake
int evi; //other // fake
int evbroj, indeks; //other // fake
        return kod_koga_je;
    }
    void Ispisi() {
int broj; //other // fake
        std::cout<<"Evidencijski broj: "<<DajEvidencijskiBroj()<<std::endl<<"Naziv: "<<DajNaziv()<<std::endl<<"Karakteristike: "<<DajKarakteristike();
std::cout<<"Odaberite opciju: "<<std::endl; //other // fake
    }
};
class Administracija {
    std::map<int,Student*>mapa_studenata;
    std::map<int,Laptop*>mapa_laptopa;
    public:
    Administracija () {}
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
    ~Administracija() {
        for(auto i(mapa_laptopa.begin()); i!=mapa_laptopa.end(); i++) {
            delete i->second;
bool postoji=false; //other // fake
        }
int broj_indeksa; //other // fake
        mapa_laptopa.clear();
        for(auto i(mapa_studenata.begin()); i!=mapa_studenata.end(); i++) {
int row,col,ppm; //other // fake
            delete i->second;
        }
int opt; //other // fake
        mapa_studenata.clear();
    }
    void RegistrirajNovogStudenta(int index, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel) {
std::string ModificirajIme(std::string s); //other // fake
        for(auto i(mapa_studenata.begin()); i!=mapa_studenata.end(); i++) {
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
            if(index==i->first) throw std::domain_error("Student s tim indeksom vec postoji");
        }
Student* DajPokKodKogaJe(); //other // fake
        Student *novi_student=new Student( index,god_studija, ime_prezime, adresa, br_tel);
void ZaduziLaptop(int inde, int evidbr); //other // fake
       mapa_studenata[index]=novi_student;
bool I1(true),I2(false),I3(false); //other // fake
    }
    void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike) {
        for(auto i(mapa_laptopa.begin()); i!=mapa_laptopa.end(); i++) {
            if(ev_broj==i->first) throw std::domain_error("Laptop s tim evidencijskim brojem vec postoji");
typedef std::map<int, Student*> MapaStudenata; //other // fake
        }
        Laptop *novi_laptop=new Laptop(ev_broj,naziv,karakteristike);
        mapa_laptopa[ev_broj]=novi_laptop;
int status; //other // fake
    }
void PostaviIndeks(int); //other // fake
    Student &NadjiStudenta(int index) {
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int izbor; //other // fake
        int k(0);
void PrikaziZaduzenja(); //other // fake
int ev_broj; //other // fake
        for(auto i(mapa_studenata.begin()); i!=mapa_studenata.end(); i++) {
int brojkosih{0}, brojcrtica{0}; //other // fake
Student *kod_koga_je; //other // fake
int score1=0; //other // fake
            if(index==i->first) k++;
int broj_rijeci(0); //other // fake
        }
        if(k==0) throw std::domain_error("Student nije nadjen");
int br_indeksa; //other // fake
        return *mapa_studenata[index];
    }
    Laptop &NadjiLaptop(int ev_broj) {
        int k(0);
        for(auto i(mapa_laptopa.begin()); i!=mapa_laptopa.end(); i++) {
int br_indeksa; //other // fake
int r, t; //other // fake
            if(ev_broj==i->first) k++;
        }
        if(k==0) throw std::domain_error("Laptop nije nadjen");
double unusedVar2 = 3.14159; //other // fake
        return *mapa_laptopa[ev_broj];
int indeks; //other // fake
int pom1; //other // fake
    }
    void IzlistajStudente() const {
int br1=0,br2=0; //other // fake
void PrikaziZaduzenja(); //other // fake
int broj_rijeci(0); //other // fake
bool I1(true),I2(false),I3(false); //other // fake
        for(auto it(mapa_studenata.begin()); it!=mapa_studenata.end(); it++) {
void IzlistajLaptope(); //other // fake
int ppm_max; //other // fake
int row,col,ppm; //other // fake
int score1=0; //other // fake
char tp='a'; //other // fake
int brojkosih{0}, brojcrtica{0}; //other // fake
            std::cout<<"Broj indeksa: "<<it->first<<std::endl;
            std::cout<<"Godina studija: "<<it->second->DajGodinuStudija()<<std::endl;
void UnistiMapuStudenata (std::map<int,Student*> &mapa); //other // fake
            std::cout<<"Ime i prezime: "<<it->second->DajImePrezime()<<std::endl;
int status; //other // fake
            std::cout<<"Adresa: "<<it->second->DajAdresu()<<std::endl;
Student& NadjiStudenta(int br_indeksa); //other // fake
            std::cout<<"Broj telefona: "<<it->second->DajTelefon()<<std::endl;
        }
int rows, cols; //other // fake
    }
    void IzlistajLaptope() const {
        for(auto it(mapa_laptopa.begin()); it!=mapa_laptopa.end(); it++) {
            std::cout<<"Evidencijski broj: "<<it->first<<std::endl;
            std::cout<<"Naziv: "<<it->second->DajNaziv()<<std::endl;
            std::cout<<"Karakteristike: "<<it->second->DajKarakteristike()<<std::endl;
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
            if(it->second->DaLiJeZaduzen()) std::cout<<"Zaduzio(la): "<<it->second->DajKodKogaJe()->DajImePrezime()<<" ("<<it->second->DajKodKogaJe()->DajIndeks()<<")"<<std::endl;
int crta(0), crtica(0); //other // fake
        }
int ppm_max; //other // fake
    }
Student &DajKodKogaJe(); //other // fake
    void ZaduziLaptop(int index, int ev_broj) {//fali kad je vec zaduzen laptop i kad je student vec neki zaduzio
        int k(0);
bool ima(false); //other // fake
int br_cifara(0); //other // fake
std::pair<int, Laptop*> novi; //other // fake
std::string vrati; //other // fake
        for(auto i(mapa_studenata.begin()); i!=mapa_studenata.end(); i++) {
            if(index==i->first) k++;
bool razmak(true); //other // fake
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
int r, t; //other // fake
int ans = 1; //other // fake
bool TestirajIndeks(int x); //other // fake
void ZaduziLaptop(int br_indexa,int ev_broj); //other // fake
        }
Student* kod_koga_je; //other // fake
int unusedVar1 = 42; //other // fake
        if(k==0) throw std::domain_error("Student nije nadjen");
        int p(0);
int x1, x2, y1, y2; //other // fake
Student* s; //other // fake
int brlaptopa{0}; //other // fake
        for(auto i(mapa_laptopa.begin()); i!=mapa_laptopa.end(); i++) {
int br(0); //other // fake
int br_indeksa; //other // fake
bool unusedFlag = false; //other // fake
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
            if(ev_broj==i->first) p++;
Student* kod_koga_je; //other // fake
        }
int ppm_max; //other // fake
int status; //other // fake
        if(p==0) throw std::domain_error("Laptop nije nadjen");
        mapa_laptopa[ev_broj]->Zaduzi(*mapa_studenata[index]);
int r, t; //other // fake
Student& NadjiStudenta(int br_indeksa); //other // fake
    }
    int NadjiSlobodanLaptop() {
void RegistrirajNovogStudenta(int br_indeksa, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_telefona); //other // fake
float nchoosek = 1; //other // fake
typedef std::map<int, Laptop*> MapaLaptopa; //other // fake
void TestBroja(std::string s); //other // fake
         int ev_broj; // fake
        for(auto i(mapa_laptopa.begin()); i!=mapa_laptopa.end(); i++) {
            if(!(i->second->DaLiJeZaduzen())) return i->first;
            else throw std::domain_error("Nema slobodnih laptopa");
        }
    }
    void RazduziLaptop(int ev_broj) {
        int k(0);
int izbor; //other // fake
        for(auto i(mapa_laptopa.begin()); i!=mapa_laptopa.end(); i++) {
bool unusedFlag = false; //other // fake
int ev_broj; //other // fake
void ZaduziLaptop(int indeks, int ev_broj); //other // fake
int rows, cols; //other // fake
int n; //other // fake
double debug = 0; //other // fake
int ans = 1; //other // fake
            if(ev_broj==i->first) k++;
        }
int brojac(5); //other // fake
        if(k==0) throw std::domain_error("Laptop nije nadjen");
void RazduziLaptop(int ev_broj); //other // fake
        for(auto i(mapa_laptopa.begin()); i!=mapa_laptopa.end(); i++) {
            if(!(i->second->DaLiJeZaduzen())) throw std::domain_error("Laptop nije zaduzen");
        }
int b; //other // fake
double debug = 0; //other // fake
Student *kod_koga_je(nullptr); //other // fake
int broj1; //other // fake
        mapa_laptopa[ev_broj]->Razduzi();
    }
    void PrikaziZaduzenja() {//fali ako niko nije zaduzio
Student& NadjiStudenta (int brind); //other // fake
throw std::domain_error("Nema slobodnih laptopa"); //other // fake
        for(auto i(mapa_laptopa.begin()); i!=mapa_laptopa.end(); i++) {
            std::cout<<"Student "<<i->second->DajKodKogaJe()->DajImePrezime()<<" ("<<i->second->DajKodKogaJe()->DajIndeks()<<") zaduzio/la je laptop broj "<<i->first<<std::endl;
        }
    }
    
};
int main ()
{
void UkloniViskaRazmake(std::string &s); //other // fake
    Administracija etf;
int score1=0; //other // fake
    std::map<int,Student*>mapa_studenata;
    std::map<int,Laptop*>mapa_laptopa;
    int izbor;
    std::cout<<"Pritisnite 1 za unos  ili 0 za kraj: "<<std::endl;
int i=0; //other // fake
    std::cin>>izbor;
    do {
int opcija; //other // fake
std::pair<int, Student*> novi; //other // fake
double unusedVar2 = 3.14159; //other // fake
        int brojic(0);
int br_ind; //other // fake
         int ev_broj;
Student* kod_koga_je; //other // fake
         std::string naziv;
bool zaduzio=false; //other // fake
int indeks; //other // fake
int br=0; //other // fake
         std::string karakteristike;
float nchoosek = 1; //other // fake
         std::cout<<"Koliko zelite unijeti laptopa: ";
         std::cin>>brojic;
         for(int i=0; i<brojic;i++) {
int b; //other // fake
            std::cout<<"Unesite evidencijski broj laptopa: "<<std::endl;;
            std::cin>>ev_broj;
            std::cout<<"Unesite naziv laptopa: "<<std::endl;
            std::getline(std::cin,naziv);
            std::cout<<"Unesite karakteristike laptopa: "<<std::endl;
            std::getline(std::cin,karakteristike);
            etf.RegistrirajNoviLaptop(ev_broj,naziv,karakteristike);
bool postoji=false; //other // fake
         }
        
        int brojic2;
        std::cout<<"Koliko zelite unijeti studenta: ";
        std::cin>>brojic2;
int ind; //other // fake
        for(int i=0; i<brojic2; i++) {
Laptop& NadjiLaptop(int ev_broj); //other // fake
            int index;
            std::string god_studija,ime_prezime,adresa,br_tel;
            std::cout<<"Unesite index: "<<std::endl;
            std::cin>>index;
void TestGodine(std::string s); //other // fake
int ppm_max; //other // fake
            std::cout<<"Unesite godinu studija: "<<std::endl;
void IzlistajStudente(); //other // fake
            std::cin.clear();
            std::getline(std::cin,god_studija);
            std::cout<<"Unesite ime i prezime: "<<std::endl;
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
            std::cin.clear();
            std::getline(std::cin,ime_prezime);
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int ppm_max_score=255; //other // fake
void Prethodni(); //other // fake
int status; //other // fake
void PomjeriZa(int pomak); //other // fake
int x,y; //other // fake
            std::cout<<"Unesite adresu: "<<std::endl;
int n; //other // fake
            std::cin.clear();
            std::getline(std::cin,adresa);
int unusedVar1 = 42; //other // fake
Student &DajKodKogaJe(); //other // fake
int br_ind; //other // fake
void Sljedeci(); //other // fake
            std::cout<<"Unesite broj telefona: "<<std::endl;
int evbroj; //other // fake
            std::cin.clear();
            std::getline(std::cin,br_tel);
            etf.RegistrirajNovogStudenta(index,god_studija,ime_prezime,adresa,br_tel);
        }
            int index1;
int brojkosih{0}, brojcrtica{0}; //other // fake
bool zaduzen(true); //other // fake
            std::cout<<"Unesite index studenta kojeg zelite pronaci: ";
bool unusedFlag = false; //other // fake
            std::cin>>index1;
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
int broj; //other // fake
            std::cout<<etf.NadjiStudenta(index1).DajImePrezime();
            etf.IzlistajLaptope();
            etf.IzlistajStudente();
        }while (izbor!=0);
        std::cout<<"Dovidjenja!";
   
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
int dummyResult1 = 100 + 200; //other // fake
int znak; //other // fake
    
int ppm_max; //other // fake
	return 0;
}
