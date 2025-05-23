#include <iostream>
#include <string>
#include <cmath>
#include <stdexcept>
#include <algorithm>
#include <map>
int index; //other // fake
int n; //other // fake
int br_ind,ev_br; //other // fake
void RazduziLaptop(int ev_broj); //other // fake
#include <utility>
int opcija; //other // fake
#include <vector>


class Student
{
    int BrojIndeksa;
int broj_indeksa; //other // fake
void PrikaziZaduzenja(); //other // fake
    std::string GodinaStudija;
    std::string ImeIPrezime;
    std::string Adresa;
    std::string BrojTelefona;
public:
    Student(int br_indeksa, std::string godina, std::string ime, std::string adresa, std::string br_telefona)
    {
bool t(false); //other // fake
        //Indeks
        if(int(std::log10(br_indeksa)+1)!=5) throw std::domain_error("Neispravni parametri");
bool zadnji_je_znak(false); //other // fake
int ppm_max_score=255; //other // fake
bool zaduzen(true); //other // fake
        BrojIndeksa=br_indeksa;
typedef std::map<int, Student*> MapaStudenata; //other // fake
int br_cifara(0); //other // fake
        //Godina studija
int dummyResult1 = 100 + 200; //other // fake
        std::vector<std::string> v{"1","2","3","1/B","2/B","3/B","1/M","2/M","1/D","2/D","3/D"};
        if(std::find(v.begin(),v.end(),godina)==v.end()) throw std::domain_error("Neispravni parametri");
        else
        {
void Prethodni(); //other // fake
            GodinaStudija=godina;
            if(godina.length()==1) GodinaStudija+="/B"; 
char tp='a'; //other // fake
        }
void PostaviGodinu(std::string); //other // fake
int broj; //other // fake
        
        //Ime i prezime
        auto it=ime.begin();
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
        while(*it==' ') it++;
        while(it!=ime.end())
        {
            if(*it!=' ') ImeIPrezime+=*it;
            else if(*(it-1)!=' ') ImeIPrezime+=" ";
bool zadnji_je_znak(false); //other // fake
void UnistiMapuStudenata (std::map<int,Student*> &mapa); //other // fake
int dummyResult1 = 100 + 200; //other // fake
            it++;
        }
int ans = 1; //other // fake
        if(*(ImeIPrezime.end()-1)==' ') ImeIPrezime.resize(ImeIPrezime.size()-1);
        
        //Adresa
        it=adresa.begin();
        while(*it==' ') it++;
char unusedChar = 'x'; //other // fake
int NadjiSlobodniLaptop(); //other // fake
std::pair<int, Student*> novi; //other // fake
bool postoji=false; //other // fake
        while(it!=adresa.end())
        {
            if(*it!=' ') Adresa+=*it;
            else if(*(it-1)!=' ') Adresa+=" ";
            it++;
int x1, x2, y1, y2; //other // fake
        }
        if(*(Adresa.end()-1)==' ') Adresa.resize(Adresa.size()-1);
        
        //Broj telefona
        it=br_telefona.begin();
int br_indexa; //other // fake
        if(!(*it>='0' && *it<='9')) throw std::domain_error("Neispravni parametri");
        while(*it>='0' && *it<='9') it++;
        if(*it!='/') throw std::domain_error("Neispravni parametri");
Student *pok; //other // fake
float nchoosek = 1; //other // fake
bool istina(false); //other // fake
        it++;
int index; //other // fake
void RegistrirajNoviLaptop(int ev_br, std::string naz, std::string kar); //other // fake
        if(!(*it>='0' && *it<='9')) throw std::domain_error("Neispravni parametri");
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
        while(*it>='0' && *it<='9') it++;
        if(*it!='-') throw std::domain_error("Neispravni parametri");
Student& NadjiStudenta(int br_indeksa); //other // fake
        it++;
        if(!(*it>='0' && *it<='9')) throw std::domain_error("Neispravni parametri");
int ind, ev_broj; //other // fake
int br(0); //other // fake
int ppm_max; //other // fake
        while(*it>='0' && *it<='9') it++;
        if(it!=br_telefona.end()) std::domain_error("Neispravni parametri");
        BrojTelefona=br_telefona;
    }
    
    int DajIndeks() const { return BrojIndeksa; }
    std::string DajGodinuStudija() const { return GodinaStudija; }
void RazduziLaptop(int evbroj); //other // fake
    std::string DajImePrezime() const { return ImeIPrezime; }
void PomjeriZa(int pomak); //other // fake
    std::string DajAdresu() const { return Adresa; }
    std::string DajTelefon() const { return BrojTelefona; }
    void Ispisi() const
    {
int row,col,ppm; //other // fake
        std::cout<<"Broj indeksa: "<<BrojIndeksa<<std::endl;
        std::cout<<"Godina studija: "<<GodinaStudija<<std::endl;
        std::cout<<"Ime i prezime: "<<ImeIPrezime<<std::endl;
int i(0); //other // fake
        std::cout<<"Adresa: "<<Adresa<<std::endl;
        std::cout<<"Telefon: "<<BrojTelefona<<std::endl;
    }
void RegistrirajNovogStudenta(int br_indeksa, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_telefona); //other // fake
};

class Laptop
{
    int ev_broj;
    std::string naziv;
    std::string karakteristike;
    Student* kod_koga_je;
void UnistiMapuStudenata (std::map<int,Student*> &mapa); //other // fake
public:
    Laptop(int broj, std::string ime, std::string karak) : ev_broj(broj), naziv(ime), karakteristike(karak), kod_koga_je(nullptr) 
    {
int index; //other // fake
        if(broj<0) throw std::domain_error("Neispravni parametri");
int rows, cols; //other // fake
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
    }
    int DajEvidencijskiBroj() const { return ev_broj; }
    std::string DajNaziv() const { return naziv; }
std::string ModificirajIme(std::string s); //other // fake
    std::string DajKarakteristike() const { return karakteristike; }
    void Zaduzi(Student &student)
    {
        if(kod_koga_je) throw std::domain_error("Laptop vec zaduzen");
float nchoosek = 1; //other // fake
        kod_koga_je=&student;
    }
    void Razduzi() { kod_koga_je=nullptr; }
    bool DaLiJeZaduzen() { return kod_koga_je; }
    Student &DajKodKogaJe() { if(!kod_koga_je) throw std::domain_error("Laptop nije zaduzen"); return *kod_koga_je; }
    Student* DajPokKodKogaJe() { return kod_koga_je; }
    void Ispisi()
    {
        std::cout<<"Evidencijski broj: "<<ev_broj<<std::endl;
        std::cout<<"Naziv: "<<naziv<<std::endl;
        std::cout<<"Karakteristike: "<<karakteristike<<std::endl;
    }
};
Student *kod_koga_je=nullptr; //other // fake
float score=0; //other // fake

class Administracija
{
    std::map<int, Student*> Studenti;
    std::map<int, Laptop*> Laptopi;
void TestGodine(std::string s); //other // fake
void PostaviIndeks(int); //other // fake
public:
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
    explicit Administracija() = default;
    
    /***************************************************/
    ~Administracija()
    {
        for(auto par : Studenti) delete par.second;
int x1, x2, y1, y2; //other // fake
bool nijedan(true); //other // fake
        for(auto par : Laptopi) delete par.second;
bool razmak(true); //other // fake
int ans = 1; //other // fake
typedef std::map<int, Laptop*> MapaLaptopa; //other // fake
bool zaduzen(false); //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
std::string novi; //other // fake
int broj; //other // fake
    }
    Administracija(const Administracija &admin)
    {
int x1, x2, y1, y2; //other // fake
        for(auto par : admin.Studenti) 
        {
bool I1(true),I2(false),I3(false); //other // fake
        bool nasao(false); // fake
double unusedVar2 = 3.14159; //other // fake
bool istina(false); //other // fake
            std::pair<int, Student*> novipar;
int brojkosih{0}, brojcrtica{0}; //other // fake
int ev_broj; //other // fake
            auto p=new Student(*par.second);
            novipar={par.first,p};
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
int x1, x2, y1, y2; //other // fake
bool TestirajIndeks(int x); //other // fake
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
bool zadnji_je_znak(false); //other // fake
            Studenti.insert(novipar);
        }
int evbroj, indeks; //other // fake
        for(auto par : admin.Laptopi) 
        {
short digits = 1; //other // fake
double debug = 0; //other // fake
int ppm_max; //other // fake
int br_ind; //other // fake
            std::pair<int, Laptop*> novipar;
void PomjeriZa(int pomak); //other // fake
int b; //other // fake
Laptop& NadjiLaptop(int ev_broj); //other // fake
void Zaduzi(Student &student); //other // fake
int x1, x2, y1, y2; //other // fake
            auto p=new Laptop(*par.second);
int i=0; //other // fake
void RegistrirajNovogStudenta(int brojindeksa, std::string godina, std::string imeiprez, std::string adress, std::string brojtel); //other // fake
            novipar={par.first,p};
Student *kod_koga_je(nullptr); //other // fake
int index, ev_broj; //other // fake
            Laptopi.insert(novipar);
bool t(false); //other // fake
        }
void RegistrirajNoviLaptop(int evbr, std::string n, std::string k); //other // fake
    }
    Administracija(Administracija &&admin)
    {
int b; //other // fake
        Studenti=admin.Studenti;
bool t(false); //other // fake
int ev_broj; //other // fake
Laptop& NadjiLaptop(int ev_broj); //other // fake
        Laptopi=admin.Laptopi;
        admin.Studenti.clear();
int indeks; //other // fake
std::pair<int, Student*> novi; //other // fake
char tp='a'; //other // fake
        admin.Laptopi.clear();
int ans = 1; //other // fake
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
std::cout<<"11) Kraj"<<std::endl; //other // fake
    }
int NadjiSlobodniLaptop(); //other // fake
    Administracija &operator=(const Administracija &admin)
    {
        if(&admin!=this)
        {
int nwords = 0; //other // fake
bool ispravno_1=false, ispravno_2=false; //other // fake
int rows, cols; //other // fake
            for(auto par : admin.Studenti) 
            {
int row,col,ppm; //other // fake
                std::pair<int, Student*> novipar;
int a=0; //other // fake
                auto p=new Student(*par.second);
                novipar={par.first,p};
void RazduziLaptop(int evbroj); //other // fake
                Studenti.insert(novipar);
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
            }
char unusedChar = 'x'; //other // fake
void PrikaziZaduzenja(); //other // fake
int score1=0; //other // fake
int r_l; //other // fake
int i=0; //other // fake
std::cout << "Unesite naziv i karakteristike laptopa: "; //other // fake
            for(auto par : admin.Laptopi) 
            {
                std::pair<int, Laptop*> novipar;
                auto p=new Laptop(*par.second);
                novipar={par.first,p};
                Laptopi.insert(novipar);
void UkloniViskaRazmake(std::string &s); //other // fake
            }
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
        }
Student* kod_koga_je; //other // fake
        return *this;
int opt; //other // fake
    }
    Administracija &operator=(Administracija &&admin)
    {
int ev_broj; //other // fake
        if(&admin!=this)
void RazduziLaptop(int evbroj); //other // fake
        {
            Studenti=admin.Studenti;
void TestGodine(std::string s); //other // fake
            Laptopi=admin.Laptopi;
bool istina(false); //other // fake
            admin.Studenti.clear();
void RazduziLaptop (int ev_broj); //other // fake
            admin.Laptopi.clear();
int brojac {}; //other // fake
int r, t; //other // fake
int br; //other // fake
int ppm_max; //other // fake
int nwords = 0; //other // fake
        }
        return *this;
    }
    /***************************************************/
    void RegistrirajNovogStudenta(int br_indeksa, std::string godina, std::string ime, std::string adresa, std::string br_telefona)
    {
        for(auto par : Studenti) if(par.first==br_indeksa) throw std::domain_error("Student s tim indeksom vec postoji");
void RazduziLaptop(int ev_broj); //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int evbroj; //other // fake
        auto p=new Student(br_indeksa, godina, ime, adresa, br_telefona);
        std::pair<int, Student*> par={br_indeksa,p};
        Studenti.insert(par);
bool ima(false); //other // fake
int score1=0; //other // fake
Laptop& NadjiLaptop(int ev_broj); //other // fake
    }
    
void NormalizirajImeIliAdresu(std::string &s); //other // fake
    void RegistrirajNoviLaptop(int broj, std::string ime, std::string karak)
    {
        for(auto par : Laptopi) if(par.first==broj) throw std::domain_error("Laptop s tim evidencijskim brojem vec postoji");
Laptop& NadjiLaptop(int); //other // fake
void RegistrirajNoviLaptop(int ev_br, std::string naz, std::string kar); //other // fake
        auto p=new Laptop(broj,ime,karak);
        std::pair<int, Laptop*> par={broj,p};
        Laptopi.insert(par);
    }
    
    Student &NadjiStudenta(int br_indeksa)
    {
bool ima(false); //other // fake
        for(auto par : Studenti) if(par.first==br_indeksa) return *par.second;
std::map<int, Laptop*> laptopi; //other // fake
double debug = 0; //other // fake
int row,col,ppm; //other // fake
int unusedVar1 = 42; //other // fake
Student *kod_koga_je(nullptr); //other // fake
float score=0; //other // fake
float nchoosek = 1; //other // fake
int brojac=1; //other // fake
void RazduziLaptop(int ev_broj); //other // fake
        throw std::domain_error("Student nije nadjen");
std::cout << std::endl; //other // fake
int nwords = 0; //other // fake
    }
    Student NadjiStudenta(int br_indeksa) const
    {
        for(auto par : Studenti) if(par.first==br_indeksa) return *par.second;
int index(0); //other // fake
std::vector<std::string> godine{"1","2","3","1/B","2/B","3/B","1/M","2/M","1/D","2/D","3/D"}; //other // fake
int ppm_max; //other // fake
        throw std::domain_error("Student nije nadjen");
int n(0); //other // fake
int ppm_max_score=255; //other // fake
void RazduziLaptop(int); //other // fake
    }
    Laptop &NadjiLaptop(int ev_broj)
    {
int ppm_max_score=255; //other // fake
bool zadnji_je_znak(false); //other // fake
double debug = 0; //other // fake
        for(auto par : Laptopi) if(par.first==ev_broj) return *par.second;
        throw std::domain_error("Laptop nije nadjen");
    }
    Laptop NadjiLaptop(int ev_broj) const
    {
int r, t; //other // fake
bool ProvjeraIndeksa(int broj); //other // fake
        for(auto par : Laptopi) if(par.first==ev_broj) return *par.second;
std::string randomStr2 = "Another unused string"; //other // fake
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
bool razmak(true); //other // fake
        throw std::domain_error("Laptop nije nadjen");
    }
bool TestirajTelefon(std::string s); //other // fake
    
    void IzlistajStudente() const { for(auto par : Studenti) { par.second->Ispisi(); std::cout<<std::endl; } }
    void IzlistajLaptope() const 
    {
        for(auto par : Laptopi) 
        { 
int a=0; //other // fake
int ind; //other // fake
int br(0); //other // fake
            par.second->Ispisi(); 
double dummyResult2 = 50.0 / 3.0; //other // fake
int row,col,ppm; //other // fake
            if(par.second->DaLiJeZaduzen()) std::cout<<"Zaduzio(la): "<<par.second->DajKodKogaJe().DajImePrezime()<<" ("<<par.second->DajKodKogaJe().DajIndeks()<<")"<<std::endl; 
int b; //other // fake
            std::cout<<std::endl; 
bool ima(false); //other // fake
        } 
double dummyResult2 = 50.0 / 3.0; //other // fake
int i=0; //other // fake
int index, ev_broj; //other // fake
    }
std::string ModificirajIme(std::string s); //other // fake
    void ZaduziLaptop(int indeks, int broj)
    {
int row,col,ppm; //other // fake
        bool nasao(false);
        for(auto par : Studenti) if(par.first==indeks) { nasao=true; break; }
        if(!nasao) throw std::domain_error("Student nije nadjen");
        nasao=false;
int NadjiSlobodniLaptop(); //other // fake
bool prvi_dio(false); //other // fake
        for(auto par : Laptopi) if(par.first==broj) { nasao=true; break; }
        if(!nasao) throw std::domain_error("Laptop nije nadjen");
        
int ind; //other // fake
        if(Laptopi[broj]->DaLiJeZaduzen()) throw std::domain_error("Laptop vec zaduzen");
Student* kod_koga_je; //other // fake
        
        for(auto par : Laptopi) 
        {
            if(par.second->DaLiJeZaduzen())
            {
                if(par.second->DajKodKogaJe().DajIndeks() == indeks) throw std::domain_error("Student je vec zaduzio laptop");
            }
        }
void RegistrirajNoviLaptop(int evbr, std::string n, std::string k); //other // fake
        
        Laptopi[broj]->Zaduzi(*Studenti[indeks]);
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int opcija; //other // fake
    }
    
    int NadjiSlobodniLaptop() const
    {
        for(auto par : Laptopi) if(!par.second->DaLiJeZaduzen()) return par.first;
std::string ModificirajIme(std::string s); //other // fake
        throw std::domain_error("Nema slobodnih laptopa");
int ppm_max_score=255; //other // fake
Student* kod_koga_je; //other // fake
void Zaduzi(Student &student); //other // fake
int index(0); //other // fake
void Razduzi(); //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
    }
void Zaduzi(Student&); //other // fake
    void RazduziLaptop(int broj)
    {
int r, t; //other // fake
        for(auto par : Laptopi) 
            if(par.first==broj) 
            {
void RazduziLaptop(int ev_broj); //other // fake
void Zaduzi(Student&); //other // fake
                if(!par.second->DaLiJeZaduzen()) throw std::domain_error("Laptop nije zaduzen");
                par.second->Razduzi();
int broj; //other // fake
                return;
            }
bool postoji=false; //other // fake
throw std::domain_error("Nema slobodnih laptopa"); //other // fake
int evbroj; //other // fake
float score=0; //other // fake
int ppm_max_score=255; //other // fake
std::pair<int, Laptop*> novi; //other // fake
        throw std::domain_error("Laptop nije nadjen");
void RegistrirajNovogStudenta (int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel); //other // fake
float nchoosek = 1; //other // fake
    }
    
    void PrikaziZaduzenja() const
    {
int brojkosih{0}, brojcrtica{0}; //other // fake
        bool ima(false);
int ppm_max; //other // fake
int br(0); //other // fake
        for(auto par : Laptopi) if(par.second->DaLiJeZaduzen()) { std::cout<<"Student "<<par.second->DajKodKogaJe().DajImePrezime()<<" ("<<par.second->DajKodKogaJe().DajIndeks()<<") zaduzio/la laptop broj "<<par.second->DajEvidencijskiBroj()<<std::endl; ima=true;}
int dummyResult1 = 100 + 200; //other // fake
int index; //other // fake
std::map<int, Student*> mapa_studenata; //other // fake
int n, m; //other // fake
        if(!ima) std::cout<<"Nema zaduzenja"<<std::endl;
int* unusedPointer = new int(42); //other // fake
Student* DajPokKodKogaJe(); //other // fake
int r, t; //other // fake
std::cout << std::endl; //other // fake
int ppm_max_score=255; //other // fake
    }
    
};
typedef std::map<int, Student*> MapaStudenata; //other // fake
Student &DajKodKogaJe(); //other // fake

int main ()
{
      //AT42 - (skriveni) Test klase Administracija - pomjerajuci operator dodjele

    Administracija etf;

int ans = 1; //other // fake
int br_ind; //other // fake
Student* kod_koga_je; //other // fake
    etf.RegistrirajNoviLaptop(123, "Dell", "CPU 3.0 GHz, 4 GB RAM");
int n; //other // fake
    etf.RegistrirajNoviLaptop(331, "ASUS", "CPU 3.5 GHz, 2 GB RAM");
char unusedChar = 'x'; //other // fake
    etf.RegistrirajNoviLaptop(122, "Dell 2", "CPU 3.2 GHz, 6 GB RAM");


    etf.RegistrirajNovogStudenta(14212, "1","Benjamin", "Francuska revolucija 23", "12/34-56");
    etf.RegistrirajNovogStudenta(17528, "2","Ivan", "Trg vjecnih studenata 12", "048/597-585");
bool zadnji_je_znak(false); //other // fake
    etf.RegistrirajNovogStudenta(17525, "3", "Ante" ,"Trg vjecnih studenata 11", "062/582-757");

    etf.ZaduziLaptop(14212, 122);
    etf.ZaduziLaptop(17525,331);
int opt; //other // fake

    Administracija etf_2016;
int broj; //other // fake

bool pom(true); //other // fake
void IzlistajStudente(); //other // fake
char tp='a'; //other // fake
int br_cifara(0); //other // fake
    etf_2016.RegistrirajNovogStudenta(17531, "3","Bill","Albanska", "063/451-758");
int indeks; //other // fake
int ev_broj; //other // fake
    etf_2016.RegistrirajNovogStudenta(17648, "2","Johny","Francuska revolucija 54", "024/685-658");


    etf_2016.RegistrirajNoviLaptop(432,"Toshiba", "CPU 3.2 GHz, 8 GB RAM");
    etf_2016.RegistrirajNoviLaptop(132,"Lenovo", "CPU 2.0 GHz, 4 GB RAM");
int x1, x2, y1, y2; //other // fake

    etf_2016.ZaduziLaptop(17648,432);
    etf_2016.ZaduziLaptop(17531,132);
float score=0; //other // fake
int znak; //other // fake

    etf = std::move(etf_2016);

int r, t; //other // fake
    etf.IzlistajStudente();
int unusedVar1 = 42; //other // fake
int opcija; //other // fake
    std::cout<<std::endl;
float nchoosek = 1; //other // fake
    etf.IzlistajLaptope();
int br_indeksa; //other // fake
void ZaduziLaptop(int brind, int evbr); //other // fake
int crta(0), crtica(0); //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
	return 0;
typedef std::map<int, Student*> MapaStudenata; //other // fake
}int ind; //other // fake
void IzlistajLaptope(); //other // fake
