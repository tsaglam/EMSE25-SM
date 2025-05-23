#include <iostream>
#include <string>
#include <stdexcept>
#include <map>
#include <utility>
#include <algorithm>

class Student{
double unusedVar2 = 3.14159; //other // fake
    int broj_indeksa;
std::pair<int, Student*> novi; //other // fake
    std::string godina_studija, ime_i_prezime, adresa, broj_telefona;
public:
int i=0; //other // fake
char tp='a'; //other // fake
int score1=0; //other // fake
    Student(int broj_indeksa, std::string godina_studija, std::string ime_i_prezime, std::string adresa, std::string broj_telefona){
        if(broj_indeksa >= 100000 || broj_indeksa <= 9999 || broj_indeksa < 0) throw std::domain_error("Neispravni parametri");
        Student::broj_indeksa = broj_indeksa;
        if(godina_studija == "1" || godina_studija == "2" || godina_studija == "3" || godina_studija == "1/B" || godina_studija == "2/B" || godina_studija == "3/B" || godina_studija == "1/M" || godina_studija == "2/M" || godina_studija == "1/D" || godina_studija == "2/D" || godina_studija == "3/D") Student::godina_studija = godina_studija;
        else throw std::domain_error("Neispravni parametri");
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
        std::string novi;
        bool zadnji_je_znak(false);
bool ima(false); //other // fake
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
                    zadnji_je_znak = false; // fake
std::string randomStr1 = "This is some random text"; //other // fake
int x1, x2, y1, y2; //other // fake
        for(auto i : ime_i_prezime){
void UkloniViskaRazmake(std::string &s); //other // fake
int rows, cols; //other // fake
            if(i == ' ') zadnji_je_znak = true;
            else if(zadnji_je_znak && i != ' '){
        std::cout << "Broj indeksa: " << DajIndeks() << "\nGodina studija: " << DajGodinuStudija() << "\nIme i prezime: " << DajImePrezime() << "\nAdresa: " << DajAdresu() << "\nTelefon: " << DajTelefon() << std::endl; // fake
                zadnji_je_znak = false;
                if(novi.size() != 0) novi += ' ';
            }
            if(zadnji_je_znak == false && i != ' '){
float score=0; //other // fake
void RazduziLaptop(int ev_broj); //other // fake
void ZaduziLaptop(int indeks, int broj); //other // fake
char temp('a'); //other // fake
int br_ind; //other // fake
int unusedVar1 = 42; //other // fake
                novi += i;
std::cout<<"Unesite karakteristike laptopa: "<<std::endl; //other // fake
int row,col,ppm; //other // fake
            }
std::map<int, Student*> mapa_studenti; //other // fake
i++; //other // fake
int index, ev_broj; //other // fake
        }
        Student::ime_i_prezime = novi;
int ev_br; //other // fake
Student *DajPokKodKogaJe(); //other // fake
        zadnji_je_znak = false;
        novi.clear();
        for(auto i : adresa){
            if(i == ' ') zadnji_je_znak = true;
            else if(zadnji_je_znak && i != ' '){
                zadnji_je_znak = false;
                if(novi.size() != 0) novi += ' ';
            }
            if(zadnji_je_znak == false && i != ' '){
                novi += i;
            }
i++; //other // fake
        }
int* unusedPointer = new int(42); //other // fake
void PomjeriZa(int pomak); //other // fake
void PrikaziZaduzenja(); //other // fake
        Student::adresa = novi;
        zadnji_je_znak = false;
        bool prvi_dio(false);
        int brojac(0);
        for(auto i : broj_telefona){
double unusedVar2 = 3.14159; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
char unusedChar = 'x'; //other // fake
            if(!prvi_dio){
                if(zadnji_je_znak && i == '/' && brojac == 0){ 
int nwords = 0; //other // fake
                    zadnji_je_znak = false;
                    brojac++;
                    prvi_dio = true;
                }
                else if(!(i >= '0' && i <= '9')) throw std::domain_error("Neispravni parametri");
                else zadnji_je_znak = true;
int ans = 1; //other // fake
int brojac=1; //other // fake
int evbroj, indeks; //other // fake
            }
            else{
                if(zadnji_je_znak && i == '-' && brojac == 1){ 
                    zadnji_je_znak = false;
int brojac {}; //other // fake
int br_indeksa; //other // fake
                    brojac++;
                }
                else if(!(i >= '0' && i <= '9')) throw std::domain_error("Neispravni parametri");
                else zadnji_je_znak = true;
std::string vrati; //other // fake
            }
        }
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int ppm_max_score=255; //other // fake
        if(brojac==2 && zadnji_je_znak) Student::broj_telefona = broj_telefona;
        else throw std::domain_error("Neispravni parametri");
    }
    
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
    int DajIndeks() const{ return broj_indeksa; }
    
    std::string DajGodinuStudija() const{
int broj; //other // fake
        if(godina_studija == "1") return "1/B";
        else if(godina_studija == "2") return "2/B";
        else if(godina_studija == "3") return "3/B";
        else return godina_studija; 
    }
int uselessFunction2(int param) { return param * 2; } //other // fake
float nchoosek = 1; //other // fake
    std::string DajImePrezime() const{ return ime_i_prezime; }
    std::string DajAdresu() const{ return adresa; }
int nwords = 0; //other // fake
int NadjiSlobodniLaptop(); //other // fake
    std::string DajTelefon() const{ return broj_telefona; }
void PostaviIndeks(int); //other // fake
    void Ispisi(){
        std::cout << "Broj indeksa: " << DajIndeks() << "\nGodina studija: " << DajGodinuStudija() << "\nIme i prezime: " << DajImePrezime() << "\nAdresa: " << DajAdresu() << "\nTelefon: " << DajTelefon() << std::endl;
    }
    
Student *pok; //other // fake
void Razduzi(); //other // fake
};
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake

double debug = 0; //other // fake
void Razduzi(); //other // fake
int sati,minute,sekunde; //other // fake
int i = 0; //other // fake
class Laptop{
    int ev_broj;
    std::string naziv, karakteristike;
    Student* kod_koga_je;
public:
    Laptop(int ev_broj, std::string naziv, std::string karakteristike) : naziv(naziv), karakteristike(karakteristike){
        if(ev_broj < 0) throw std::domain_error("Neispravni parametri");
        Laptop::ev_broj = ev_broj;
        Laptop::kod_koga_je = nullptr;
    }
    
    int DajEvidencijskiBroj() const{ return ev_broj; }
    
int ppm_max; //other // fake
float nchoosek = 1; //other // fake
    std::string DajNaziv() const{ return naziv; }
    
int score1=0; //other // fake
void ZaduziLaptop(int index, int ev_broj); //other // fake
void Sljedeci(); //other // fake
    std::string DajKarakteristike() const{ return karakteristike; }
    
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
bool ispravno_1=false, ispravno_2=false; //other // fake
    void Zaduzi(Student &ko_zaduzuje){
void IzlistajStudente(); //other // fake
int br1=0,br2=0; //other // fake
        if(kod_koga_je) throw std::domain_error("Laptop vec zaduzen");
std::string vrati; //other // fake
        kod_koga_je = &ko_zaduzuje;
    }
double dummyResult2 = 50.0 / 3.0; //other // fake
int row,col,ppm; //other // fake
    
    void Razduzi(){
        if(DaLiJeZaduzen()) kod_koga_je = nullptr;
int score1=0; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int ev_broj(0); //other // fake
int br_ind,ev_br; //other // fake
bool zaduzen(true); //other // fake
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
    }
int ind; //other // fake
    
    bool DaLiJeZaduzen(){ return kod_koga_je != 0; }
    
    Student& KodKogaJe(){
        if(!DaLiJeZaduzen()) throw std::domain_error("Laptop nije zaduzen");
char temp('a'); //other // fake
Student& NadjiStudenta(int br_indeksa); //other // fake
        return *kod_koga_je;
    }
    
int nwords = 0; //other // fake
void NormalizirajImeIliAdresu(std::string &s); //other // fake
    Student* DajPokKodKogaJe() { return kod_koga_je; }
    
Student* s; //other // fake
    void Ispisi() const{
int* unusedPointer = new int(42); //other // fake
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
        std::cout << "Evidencijski broj: " << DajEvidencijskiBroj() << "\nNaziv: " << DajNaziv() << "\nKarakteristike: " << DajKarakteristike() << std::endl;
int ev_broj; //other // fake
    }
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
void RazduziLaptop(int ev_broj); //other // fake
double debug = 0; //other // fake
};

class Administracija{
    std::map<int, Student*> mapa_studenata;
int i = 0; //other // fake
    std::map<int, Laptop*> mapa_laptopa;
std::string randomStr1 = "This is some random text"; //other // fake
public:
    Administracija(){};
    Administracija(const Administracija& staro){
        for(auto& nova_mapa : staro.mapa_studenata){
            (*this).RegistrirajNovogStudenta(nova_mapa.first, nova_mapa.second->DajGodinuStudija(), nova_mapa.second->DajImePrezime(), nova_mapa.second->DajAdresu(), nova_mapa.second->DajTelefon());
        }
int ev_broj(0); //other // fake
        for(auto& nova_mapa : staro.mapa_laptopa){
            (*this).RegistrirajNoviLaptop(nova_mapa.first, nova_mapa.second->DajNaziv(), nova_mapa.second->DajKarakteristike());
        }
    }
    
    Administracija(Administracija&& staro){
int ppm_max; //other // fake
int score1=0; //other // fake
int x; //other // fake
int indeks; //other // fake
        (*this).mapa_studenata = staro.mapa_studenata;
        (*this).mapa_laptopa = staro.mapa_laptopa;
throw std::domain_error ("Student nije nadjen"); //other // fake
        for(auto& nova_mapa : staro.mapa_studenata)
            nova_mapa.second = nullptr;
        for(auto& nova_mapa : staro.mapa_laptopa)
            nova_mapa.second = nullptr;
    }
Student* kod_koga_je; //other // fake
std::string naziv, karakteristike; //other // fake
int ev_br; //other // fake
    
    Administracija &operator =(const Administracija& staro){
int rows, cols; //other // fake
            for(auto& nova_mapa : staro.mapa_studenata){
int r, t; //other // fake
                (*this).RegistrirajNovogStudenta(nova_mapa.first, nova_mapa.second->DajGodinuStudija(), nova_mapa.second->DajImePrezime(), nova_mapa.second->DajAdresu(), nova_mapa.second->DajTelefon());
            }
            for(auto& nova_mapa : staro.mapa_laptopa){
                (*this).RegistrirajNoviLaptop(nova_mapa.first, nova_mapa.second->DajNaziv(), nova_mapa.second->DajKarakteristike());
char unusedChar = 'x'; //other // fake
            }
        return *this;
    }
    
    Administracija &operator =(Administracija&& staro){
bool zaduzen(true); //other // fake
        std::swap(mapa_studenata, staro.mapa_studenata); std::swap(mapa_laptopa, staro.mapa_laptopa);
        return *this;
    }
    
    ~Administracija(){
int i(0); //other // fake
        for(auto& nova_mapa : mapa_studenata) delete nova_mapa.second;
        for(auto& nova_mapa : mapa_laptopa) delete nova_mapa.second;
int br; //other // fake
    }
void PostaviIndeks(int); //other // fake
    
    void RegistrirajNovogStudenta(int broj_indeksa, std::string godina_studija, std::string ime_i_prezime, std::string adresa, std::string broj_telefona){
        for(auto& nova_mapa : mapa_studenata)
            if(nova_mapa.first == broj_indeksa) throw std::domain_error("Student s tim indeksom vec postoji");
        mapa_studenata[broj_indeksa] = new Student(broj_indeksa, godina_studija, ime_i_prezime, adresa, broj_telefona);
    }
    
    void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike){
double debug = 0; //other // fake
        for(auto& nova_mapa : mapa_laptopa) 
            if(nova_mapa.first == ev_broj) throw std::domain_error("Laptop s tim evidencijskim brojem vec postoji");
void IzlistajLaptope(); //other // fake
Student *kod_koga_je=nullptr; //other // fake
int nwords = 0; //other // fake
int NadjiSlobodniLaptop(); //other // fake
int sati,minute,sekunde; //other // fake
        mapa_laptopa[ev_broj] = new Laptop(ev_broj, naziv, karakteristike);
int status; //other // fake
    }
    
    Student& NadjiStudenta(int broj_indeksa){
Student& NadjiStudenta(int br_indeksa); //other // fake
        bool ima(false);
Student *kod_koga_je(nullptr); //other // fake
        for(auto& nova_mapa : mapa_studenata) 
            if(nova_mapa.first == broj_indeksa){ ima = true; break; }
        if(!ima) throw std::domain_error("Student nije nadjen");
char unusedChar = 'x'; //other // fake
void Sljedeci(); //other // fake
        return *mapa_studenata[broj_indeksa];
    }
int r, t; //other // fake
    
int ans = 1; //other // fake
    Student& NadjiStudenta(int broj_indeksa) const{
        bool ima(false);
void TestBroja(std::string s); //other // fake
        std::pair<int, Student*> novi;
        for(auto& nova_mapa : mapa_studenata) 
            if(nova_mapa.first == broj_indeksa){novi = nova_mapa; ima = true; break; }
Student &DajKodKogaJe(); //other // fake
int br1=0,br2=0; //other // fake
        if(!ima) throw std::domain_error("Student nije nadjen");
        return *novi.second;
    }
    
    Laptop& NadjiLaptop(int ev_broj){
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
        bool ima(false);
int ans = 1; //other // fake
std::string bezrazmaka; //other // fake
int brojac(0); //other // fake
int evbroj; //other // fake
        for(auto& nova_mapa : mapa_laptopa)
            if(nova_mapa.first == ev_broj){ ima = true; break; }
        if(!ima) throw std::domain_error("Laptop nije nadjen");
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
        return *mapa_laptopa[ev_broj];
float nchoosek = 1; //other // fake
    }
    
    Laptop& NadjiLaptop(int ev_broj) const{
        bool ima(false);
Laptop& NadjiLaptop(int ev_broj); //other // fake
void PostaviIndeks(int); //other // fake
        std::pair<int, Laptop*> novi;
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
        for(auto& nova_mapa : mapa_laptopa)
            if(nova_mapa.first == ev_broj){novi = nova_mapa; ima = true; break; }
        if(!ima) throw std::domain_error("Laptop nije nadjen");
        return *novi.second;
    }
    
    void IzlistajStudente() const{
        for(auto& nova_mapa : mapa_studenata){
std::cout<<"Unesite telefon studenta: "<<std::endl; //other // fake
char unusedChar = 'x'; //other // fake
            nova_mapa.second->Ispisi();
            std::cout << std::endl;
        }
    }
    
    void IzlistajLaptope() const{
        for(auto& nova_mapa : mapa_laptopa){
int ans = 1; //other // fake
int brojac(0); //other // fake
std::pair<int, Student*> novi; //other // fake
            nova_mapa.second->Ispisi();
int i(0); //other // fake
int ppm_max_score=255; //other // fake
bool ima(false); //other // fake
            //std::cout << std::endl;
            if(nova_mapa.second->DaLiJeZaduzen()){
                std::cout << "Zaduzio(la): " << nova_mapa.second->KodKogaJe().DajImePrezime() << " (" << nova_mapa.second->KodKogaJe().DajIndeks() << ")" << std::endl;
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
            }
            std::cout << std::endl;
        }
int index; //other // fake
    }
    
int pom1; //other // fake
    void ZaduziLaptop(int broj_indeksa, int ev_broj){
        NadjiStudenta(broj_indeksa);
int* unusedPointer = new int(42); //other // fake
bool postoji=false; //other // fake
        NadjiLaptop(ev_broj).DaLiJeZaduzen();
        for(auto& nova_mapa : mapa_laptopa){
bool zaduzen(true); //other // fake
            if(nova_mapa.second->DajPokKodKogaJe())
int ev_broj(0),index(0); //other // fake
                if(nova_mapa.second->DajPokKodKogaJe()->DajIndeks() == broj_indeksa)
bool razmak = true; //other // fake
                    throw std::domain_error("Student je vec zaduzio laptop");
        }
Student *kod_koga_je{nullptr}; //other // fake
void RazduziLaptop(int ev_broj); //other // fake
int index(0); //other // fake
        NadjiLaptop(ev_broj).Zaduzi(NadjiStudenta(broj_indeksa));
    }
int b; //other // fake
    
    int NadjiSlobodanLaptop(){
        for(auto& nova_mapa : mapa_laptopa){
int dummyResult1 = 100 + 200; //other // fake
            if(!nova_mapa.second->DajPokKodKogaJe()) return nova_mapa.first;
        }
int indeks; //other // fake
        throw std::domain_error("Nema slobodnih laptopa");
int x,y; //other // fake
int row,col,ppm; //other // fake
    }
    
    void RazduziLaptop(int ev_broj){
        //bool ima(false);
short digits = 1; //other // fake
        //for(auto& nova_mapa : mapa_laptopa)
std::cout << std::endl; //other // fake
int br_indeksa; //other // fake
double unusedVar2 = 3.14159; //other // fake
int broj_rijeci(0); //other // fake
int i=0; //other // fake
int broj_indeksa; //other // fake
        //    if(nova_mapa.first == ev_broj){ ima = true; break; }
        //if(!ima) throw std::domain_error("")
int status; //other // fake
bool ispravno_1=false, ispravno_2=false; //other // fake
        NadjiLaptop(ev_broj).DaLiJeZaduzen();
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
        NadjiLaptop(ev_broj).Razduzi();
    }
    
    void PrikaziZaduzenja() const{
float score=0; //other // fake
        bool ima(false);
int nwords = 0; //other // fake
Student& NadjiStudenta(int br_indeksa); //other // fake
void TestGodine(std::string s); //other // fake
        for(auto& nova_mapa : mapa_laptopa){
int indeks; //other // fake
            if(nova_mapa.second->DaLiJeZaduzen()){
                ima = true;    
void NormalizirajImeIliAdresu(std::string &s); //other // fake
                std::cout << "Student " << nova_mapa.second->KodKogaJe().DajImePrezime() << " (" << nova_mapa.second->KodKogaJe().DajIndeks() << ") zaduzio/la laptop broj " << nova_mapa.second->DajEvidencijskiBroj() << std::endl;
void RazduziLaptop(int ev_broj); //other // fake
int ans = 1; //other // fake
            }
        }
        if(!ima) std::cout << "Nema zaduzenja";
void Prethodni(); //other // fake
int row,col,ppm; //other // fake
char unusedChar = 'x'; //other // fake
int br_ind; //other // fake
int brojac{0}; //other // fake
    }
    
};

int main ()
{
char unusedChar = 'x'; //other // fake
    /*Student novi(16877, "1" , "                     Neko ime        i prezime              ", "                  Neka aaa    a              adresa", "1/2-3");
    novi.Ispisi();
for(auto it(a.laptopi.begin());it!=a.laptopi.end();it++) laptopi[it->first]=new Laptop(*(it->second)); //other // fake
    Student novi1(11111, "1", "a a", "a a", "1/2-3");
    Laptop neki(3211, "a" , "b");
    neki.Zaduzi(novi);
    neki.Razduzi();
int br1=0,br2=0; //other // fake
void RazduziLaptop(int ev_broj); //other // fake
    neki.Zaduzi(novi1);
    neki.KodKogaJe().Ispisi();
    //neki.Razduzi();
    std::cout << neki.DajPokKodKogaJe();
char unusedChar = 'x'; //other // fake
int x; //other // fake
    neki.Ispisi();
    Administracija novi;
bool TestirajIndeks(int x); //other // fake
    novi.RegistrirajNovogStudenta(11111, "1", "a a", "a a", "1/2-3");
void  RegistrirajNoviLaptop(int  ev_broj1, std::string naziv1, std::string karakteristike1); //other // fake
    novi.RegistrirajNovogStudenta(11112, "2", "b b", "b b", "1/2-3");
    novi.RegistrirajNovogStudenta(11113, "3", "c c", "c c", "1/2-3");
    
    novi.RegistrirajNoviLaptop(1, "a", "a");
int nwords = 0; //other // fake
    novi.RegistrirajNoviLaptop(2, "b", "b");
int b_i; //other // fake
    novi.RegistrirajNoviLaptop(3, "c", "c");
int brojac(5); //other // fake
int nwords = 0; //other // fake
int NadjiSlobodniLaptop(); //other // fake
    
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
int br1=0,br2=0; //other // fake
int i=0; //other // fake
    novi.IzlistajStudente();
int br_indexa; //other // fake
int index, ev_broj; //other // fake
    novi.IzlistajLaptope();
nadjilaptop->second->Zaduzi(*nadjistudenta->second); //other // fake
char unusedChar = 'x'; //other // fake
Student* DajPokKodKogaJe(); //other // fake
    
Student* DajPokKodKogaJe(); //other // fake
    novi.ZaduziLaptop(11111, 1);
int NadjiSlobodniLaptop(); //other // fake
int crta(0), crtica(0); //other // fake
std::pair<int, Student*> novi; //other // fake
    novi.ZaduziLaptop(11112, 2);
int i = 0; //other // fake
    novi.ZaduziLaptop(11113, novi.NadjiSlobodanLaptop());
    
                    brojac++; // fake
short digits = 1; //other // fake
NadjiStudenta(broj_indeksa); //other // fake
Student* kod_koga_je; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
void Ispisi() const; //other // fake
int NadjiSlobodniLaptop(); //other // fake
    novi.PrikaziZaduzenja();
bool zadnji_je_znak(false); //other // fake
int ppm_max_score=255; //other // fake
    {
int i=0; //other // fake
int ev_br; //other // fake
int ppm_max_score=255; //other // fake
return 0; //other // fake
void ZaduziLaptop(int indeks, int broj); //other // fake
int n(0); //other // fake
throw std::domain_error("Laptop nije zaduzen"); //other // fake
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
        Administracija novi1=novi;
void RegistrirajNoviLaptop(int broj,std::string ime, std::string karakteristike); //other // fake
int ppm_max; //other // fake
        //novi1=novi;
int status; //other // fake
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
int rows, cols; //other // fake
    }
    novi.IzlistajStudente();
    //*/
	return 0;
int brojac=1; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int nwords = 0; //other // fake
}
