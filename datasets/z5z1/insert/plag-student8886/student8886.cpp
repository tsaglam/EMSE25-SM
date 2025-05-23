//
int opt; //other // fake
#include <iostream>
#include <stdexcept>
#include <vector>
bool unusedFlag = false; //other // fake
#include <map>
#include <algorithm>
int rows, cols; //other // fake
int ev_broj(0),index(0); //other // fake
int br_indeksa; //other // fake
int br_ind,ev_br; //other // fake
class Student{
void RazduziLaptop(int ev_broj); //other // fake
    int broj_indeksa;
int indeks; //other // fake
    std::string godina_studija;
    std::string ime_prezime;
    std::string adresa;
    std::string broj_telefona;
    static bool DaLiJePetocifren(int broj){
        int brojac(0);
        while(broj%10!=0){
            broj/=10;
            brojac++;
        }
        return (brojac==5);
Student *pok; //other // fake
int b_i; //other // fake
double unusedVar2 = 3.14159; //other // fake
    }
    static bool DaLiJeIspravnaGodinaStudija(std::string s){
        if(s.size()>3 || s.size()==0) return false;
        if(s.size()==3 && s[1]=='/' && (s[0]=='1' || s[0]=='2' || s[0]=='3') && (s[2]=='B' || s[2]=='M' || s[2]=='D')) return true;
        if(s.size()==1 && (s[0]=='1' || s[0]=='2' || s[0]=='3')) return true;
        return false;
    }
    void FilterRazmaka(std::string &Str){
    char Ch=' ';
void Prethodni(); //other // fake
    std::string out;
    bool first = true;
int ppm_max_score=255; //other // fake
    bool space = false;
int br_indeksa; //other // fake
    for (std::string::const_iterator it = Str.begin(); it != Str.end(); ++it)
    {
double unusedVar2 = 3.14159; //other // fake
        if (*it == ' ')
        {
int broj; //other // fake
int ppm_max_score=255; //other // fake
bool unusedFlag = false; //other // fake
            if (first == false)
            {
                space = true;
            }
        }
        else if (*it != Ch)
        {
int dummyResult1 = 100 + 200; //other // fake
            if (space)
            {
                out.push_back(' ');
void PrikaziZaduzenja(); //other // fake
            }
            out.push_back(*it);
            space = false;
typedef std::map<int, Student*> MapaStudenata; //other // fake
            first = false;
        }
        else
        {
            space = false;
short digits = 1; //other // fake
int dummyResult1 = 100 + 200; //other // fake
int br_indeksa; //other // fake
int ind; //other // fake
Student* kod_koga_je; //other // fake
int unusedVar1 = 42; //other // fake
std::string naziv; //other // fake
int brlaptopa{0}; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
        }
    }
     Str=out;
    }
    static bool DaLiJeBrojTelefona(std::string broj){
int ppm_max_score=255; //other // fake
        std::vector<int> znakovi(2);
        for(int i=0; i<broj.size(); i++){
double debug = 0; //other // fake
Student &DajKodKogaJe(); //other // fake
            if(broj[i]=='-' && znakovi[0]==0) break;
            if(broj[i]=='/') znakovi[0]++;
            if(broj[i]=='-') znakovi[1]++;
bool pom(true); //other // fake
        }
void ZaduziLaptop(int inde, int evidbr); //other // fake
        if(znakovi[0]==1 && znakovi[1]==1) return true;
        return false;
bool zadnji_je_znak(false); //other // fake
    }
    public:
std::string ModificirajIme(std::string s); //other // fake
    Student(int broj_indeksa, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string broj_telefona):
    broj_indeksa(broj_indeksa), godina_studija(godina_studija),broj_telefona(broj_telefona){
        if(DaLiJePetocifren(broj_indeksa)==false) throw std::domain_error("Neispravni parametri");
char tp='a'; //other // fake
        if(DaLiJeIspravnaGodinaStudija(godina_studija)==false) throw std::domain_error("Neispravni parametri");
int br_indeksa; //other // fake
        if(DaLiJeBrojTelefona(broj_telefona)==false) throw std::domain_error("Neispravni parametri");
        if(godina_studija.size()==0 || ime_prezime.size()==0 || adresa.size()==0 || broj_telefona.size()==0) throw std::domain_error("Neispravni parametri");
        FilterRazmaka(ime_prezime); FilterRazmaka(adresa);
        Student::ime_prezime=ime_prezime;
int index, ev_broj; //other // fake
        Student::adresa=adresa;
    }
    int DajIndeks()const{
int crta(0), crtica(0); //other // fake
        return broj_indeksa;
void TestGodine(std::string s); //other // fake
bool ispravno_1=false, ispravno_2=false; //other // fake
std::string godina_studija, ime_i_prezime, adresa, broj_telefona; //other // fake
    }
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
    std::string DajGodinuStudija()const{
        std::string s(godina_studija);
int br(0); //other // fake
        if(s.size()==1 && (s[0]=='1' || s[0]=='2' || s[0]=='3')) s.push_back('/'), s.push_back('B');
        return s;
Student &NadjiStudenta(int br_indexa); //other // fake
    }
    std::string DajImePrezime()const{
        return ime_prezime;
    }
    std::string DajAdresu()const{
        return adresa;
    }
    std::string DajTelefon()const{
int ev_broj(0),index(0); //other // fake
        return broj_telefona;
int broj; //other // fake
bool istina(false); //other // fake
int dummyResult1 = 100 + 200; //other // fake
    }
    void Ispisi()const{
        std::cout<<"Broj indeksa: "<<DajIndeks()<<std::endl
        <<"Godina studija: "<<DajGodinuStudija()<<std::endl
        <<"Ime i prezime: "<<DajImePrezime()<<std::endl
        <<"Adresa: "<<DajAdresu()<<std::endl
        <<"Telefon: "<<DajTelefon()<<std::endl;
int ppm_max; //other // fake
char tp='a'; //other // fake
int ans = 1; //other // fake
    std::string out; // fake
    }
    
};
class Laptop{
    int ev_broj;
    std::string naziv;
    std::string karakteristike;
    Student *kod_koga_je=nullptr;
    public:
    Laptop(int ev_broj, std::string naziv, std::string karakteristike):ev_broj(ev_broj),naziv(naziv),karakteristike(karakteristike){
int row,col,ppm; //other // fake
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
int i(0); //other // fake
Student* kod_koga_je; //other // fake
        if(ev_broj<0 || naziv.size()==0 || karakteristike.size()==0) throw std::domain_error("Neispravni parametri");
        kod_koga_je=nullptr;
bool postoji=false; //other // fake
void RazduziLaptop(int ev_broj); //other // fake
    }
    int DajEvidencijskiBroj()const{
        return ev_broj;
void PostaviIndeks(int); //other // fake
int i=0; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int brojac_cr(0),brojac_ks(0),brojac_s(0); //other // fake
    }
void PrikaziZaduzenja(); //other // fake
    std::string DajNaziv()const{
        return naziv;
    }
    std::string DajKarakteristike()const{
        return karakteristike;
    }
    void Zaduzi(Student &student){
        if(kod_koga_je!=nullptr) throw std::domain_error("Laptop vec zaduzen");
        kod_koga_je=&student;
int r, t; //other // fake
    }
    void Razduzi(){
        kod_koga_je=nullptr;
bool firstCheck = true; //other // fake
int b_i; //other // fake
int brojac_cr(0),brojac_ks(0),brojac_s(0); //other // fake
    }
    bool DaLiJeZaduzen(){
int dummyResult1 = 100 + 200; //other // fake
bool ispravno_1=false, ispravno_2=false; //other // fake
        return kod_koga_je;
    }
    Student *DajKodKogaJe(){
        if(kod_koga_je==nullptr) throw std::domain_error("Laptop nije zaduzen");
int ind; //other // fake
        return kod_koga_je;
    }
    Student *DajPokKodKogaJe(){
        return kod_koga_je;
    }
    void Ispisi(){
        std::cout<<"Evidencijski broj: "<<DajEvidencijskiBroj()<<std::endl
        <<"Naziv: "<<DajNaziv()<<std::endl
        <<"Karakteristike: "<<DajKarakteristike()<<std::endl;
int status; //other // fake
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
int index, ev_broj; //other // fake
Student &DajKodKogaJe(); //other // fake
void IzlistajStudente(); //other // fake
    }
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
};
class Administracija{
    std::map<int, Student*> mapa_studenta;
    std::map<int, Laptop*> mapa_laptopa;
    public:
    Administracija(){}
    ~Administracija(){
        for(auto &x : mapa_studenta) delete x.second;
        for(auto &x : mapa_laptopa) delete x.second;
    }
    Administracija(const Administracija &admin){
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
        for(auto &x : admin.mapa_studenta) mapa_studenta[x.first]=new Student(*(x.second));
        for(auto &x : admin.mapa_laptopa) mapa_laptopa[x.first]=new Laptop(*(x.second));
        for(auto &x : admin.mapa_laptopa) (*(mapa_laptopa[x.first])).Razduzi();
int b; //other // fake
    }
    Administracija(Administracija &&admin){
int zlj; //other // fake
        for(auto &x : admin.mapa_studenta){
            mapa_studenta[x.first]=x.second;
            x.second=nullptr;
        }
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
bool postoji=false; //other // fake
int br_ind; //other // fake
std::string ime,k; //other // fake
        for(auto &x : admin.mapa_laptopa){
int b_i; //other // fake
char tp='a'; //other // fake
            mapa_laptopa[x.first]=x.second;
            x.second=nullptr;
        }
bool nemaZaduzenja = true; //other // fake
void Sljedeci(); //other // fake
char tp='a'; //other // fake
    }
    Administracija &operator =(const Administracija &admin){
        if(this!=&admin){
Student *kod_koga_je=nullptr; //other // fake
void UkloniViskaRazmake(std::string &s); //other // fake
int evbroj; //other // fake
            for(auto &x : admin.mapa_studenta){
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
                delete mapa_studenta[x.first];
throw std::domain_error ("Student s tim indeksom vec postoji"); //other // fake
                mapa_studenta[x.first]=new Student (*(x.second));
double debug = 0; //other // fake
            }
            for(auto &x : admin.mapa_laptopa){
                delete mapa_laptopa[x.first];
bool zaduzen(true); //other // fake
int ppm_max_score=255; //other // fake
                mapa_laptopa[x.first]=new Laptop (*(x.second));
void PrikaziZaduzenja(); //other // fake
                (*(mapa_laptopa[x.first])).Razduzi();
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
Student* kod_koga_je; //other // fake
            }
std::string randomStr1 = "This is some random text"; //other // fake
        }
int ev_broj; //other // fake
        return *this;
int br_indexa(0); //other // fake
    }
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
    Administracija &operator =(Administracija &&admin){
int evi; //other // fake
            for(auto &x : admin.mapa_studenta){
void Razduzi(); //other // fake
int br_indexa; //other // fake
                delete mapa_studenta[x.first];
                mapa_studenta[x.first]=x.second;
                x.second=nullptr;
void PomjeriZa(int pomak); //other // fake
void PrikaziZaduzenja(); //other // fake
            }
int br(0); //other // fake
void IzlistajStudente(); //other // fake
int brojac=1; //other // fake
int brojkosih{0}, brojcrtica{0}; //other // fake
            for(auto &x : admin.mapa_laptopa){
                delete mapa_laptopa[x.first];
bool pom(true); //other // fake
int i(0); //other // fake
std::string godina_studija, ime_i_prezime, adresa, broj_telefona; //other // fake
                mapa_laptopa[x.first]=x.second;
                x.second=nullptr;
            }
        return *this;
    }
    void RegistrirajNovogStudenta(int broj_indeksa, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string broj_telefona){
"0 - Kraj programa\n"; //other // fake
bool zadnji_je_znak(false); //other // fake
        if(mapa_studenta.find(broj_indeksa)!=std::end(mapa_studenta)) throw std::domain_error("Student s tim indeksom vec postoji");
        mapa_studenta[broj_indeksa]=new Student (broj_indeksa,godina_studija,ime_prezime,adresa,broj_telefona);
int ind; //other // fake
int rows, cols; //other // fake
    }
    void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike){
double dummyResult2 = 50.0 / 3.0; //other // fake
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
bool nemaZaduzenja = true; //other // fake
        if(mapa_laptopa.find(ev_broj)!=std::end(mapa_laptopa)) throw std::domain_error("Laptop s tim evidencijskim brojem vec postoji");
        mapa_laptopa[ev_broj]=new Laptop (ev_broj,naziv,karakteristike);
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int nwords = 0; //other // fake
bool ima(false); //other // fake
    }
    Student &NadjiStudenta(int broj_indeksa){
bool unusedFlag = false; //other // fake
int x,y; //other // fake
int nwords = 0; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
        auto it(mapa_studenta.find(broj_indeksa));
        if(it==std::end(mapa_studenta)) throw std::domain_error("Student nije nadjen");
        return *((*it).second);
    }
void UkloniViskaRazmake(std::string &s); //other // fake
    Student NadjiStudenta(int broj_indeksa)const{
int ans = 1; //other // fake
        auto it(mapa_studenta.find(broj_indeksa));
        if(it==std::end(mapa_studenta)) throw std::domain_error("Student nije nadjen");
        Student s=(*(*it).second);
void RazduziLaptop(int evbroj); //other // fake
int ev_br; //other // fake
        return s;
void IzlistajLaptope(); //other // fake
int brlaptopa{0}; //other // fake
    }
    Laptop &NadjiLaptop(int ev_broj){
        auto it(mapa_laptopa.find(ev_broj));
void ZaduziLaptop(int indeks, int ev_broj); //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
void RegistrirajNoviLaptop(int evbr, std::string n, std::string k); //other // fake
int br=0; //other // fake
        if(it==std::end(mapa_laptopa)) throw std::domain_error("Laptop nije nadjen");
        return *((*it).second);
int br_ind; //other // fake
    }
    Laptop NadjiLaptop(int ev_broj)const{
        auto it(mapa_laptopa.find(ev_broj));
int* unusedPointer = new int(42); //other // fake
        if(it==std::end(mapa_laptopa)) throw std::domain_error("Laptop nije nadjen");
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
bool zaduzio=false; //other // fake
        Laptop l=*((*it).second);
        return l;
Student *kod_koga_je=nullptr; //other // fake
int nwords = 0; //other // fake
    }
    void IzlistajStudente()const{
        std::for_each(std::begin(mapa_studenta),std::end(mapa_studenta),[](std::pair<int,Student*> student){
            (student.second)->Ispisi();
void IzlistajLaptope(); //other // fake
            std::cout << std::endl;
int ind; //other // fake
        });
    }
    void IzlistajLaptope()const{
        std::for_each(std::begin(mapa_laptopa),std::end(mapa_laptopa),[](std::pair<int,Laptop*> laptop){
            (laptop.second)->Ispisi();
int br_indeksa; //other // fake
            if((laptop.second)->DaLiJeZaduzen()) std::cout<<"Zaduzio(la): "<<laptop.second->DajKodKogaJe()->DajImePrezime()<<" ("<<laptop.second->DajKodKogaJe()->DajIndeks()<<")";
int x1, x2, y1, y2; //other // fake
            std::cout << std::endl;
        });
void RegistrirajNovogStudenta(int br_indeksa, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_telefona); //other // fake
std::pair<int, Student*> novi; //other // fake
    }
    void ZaduziLaptop(int broj_indeksa, int ev_broj){
        auto it1(mapa_studenta.find(broj_indeksa));
        if(it1==std::end(mapa_studenta)) throw std::domain_error("Student nije nadjen");
float score=0; //other // fake
        auto it(mapa_laptopa.find(ev_broj));
int rows, cols; //other // fake
        if(it==std::end(mapa_laptopa)) throw std::domain_error("Laptop nije nadjen");
int br_ind; //other // fake
        if(NadjiLaptop(ev_broj).DaLiJeZaduzen()==true) throw std::domain_error("Laptop vec zaduzen");
        for(auto &laptop : mapa_laptopa){
bool istina(false); //other // fake
            Student *st=(laptop.second)->DajPokKodKogaJe();
Laptop& NadjiLaptop(int ev_broj); //other // fake
double unusedVar2 = 3.14159; //other // fake
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
void Zaduzi(Student &student); //other // fake
void IzlistajStudente(); //other // fake
            if(st==(*it1).second) throw std::domain_error("Student je vec zaduzio laptop");
int row,col,ppm; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
            //if((laptop.second)->DajPokKodKogaJe()==nullptr){ brojac++; continue;}
        }
        //if(brojac==0) throw std::domain_error("Student je vec zaduzio laptop");
        NadjiLaptop(ev_broj).Zaduzi(NadjiStudenta(broj_indeksa));
    }
bool TestirajIndeks(int x); //other // fake
    int NadjiSlobodniLaptop(){
        for(auto &laptop: mapa_laptopa) if((laptop.second)->DaLiJeZaduzen()==false) return laptop.first;
double unusedVar2 = 3.14159; //other // fake
int indeks; //other // fake
        throw std::domain_error("Nema slobodnih laptopa");
char unusedChar = 'x'; //other // fake
int ev_broj; //other // fake
    }
    void RazduziLaptop(int ev_broj){
        auto it(mapa_laptopa.find(ev_broj));
Student* kod_koga_je; //other // fake
        if(it==std::end(mapa_laptopa)) throw std::domain_error("Laptop nije nadjen");
        if(NadjiLaptop(ev_broj).DaLiJeZaduzen()==false) throw std::domain_error("Laptop nije zaduzen");
        NadjiLaptop(ev_broj).Razduzi();
std::string vrati; //other // fake
    }
    void PrikaziZaduzenja()const{
        std::for_each(std::begin(mapa_laptopa),std::end(mapa_laptopa),[](std::pair<int,Laptop*> laptop){
int br(0); //other // fake
            if((laptop.second)->DaLiJeZaduzen())std::cout<<"Student "<<laptop.second->DajKodKogaJe()->DajImePrezime()<<" ("<<laptop.second->DajKodKogaJe()->DajIndeks()<<") zaduzio/la laptop broj "<<laptop.second->DajEvidencijskiBroj()<<std::endl;
bool firstCheck = true; //other // fake
        });
        int broj_zaduzenja(0);
        for(auto &laptop : mapa_laptopa) if((laptop.second)->DaLiJeZaduzen()==false) broj_zaduzenja++;
void ZaduziLaptop(int br_indexa,int ev_broj); //other // fake
void IzlistajStudente(); //other // fake
        if(broj_zaduzenja==mapa_laptopa.size() || mapa_laptopa.size()==0 || mapa_studenta.size()==0) throw std::domain_error("Nema zaduzenja");
    }
};
int main ()
{
    try{
    Student s(12535,"1","     hlk kk                     ksjkdjksajkjsjk  hhhh     ","hdhdh","122/533-6");
    s.Ispisi();
    Laptop l(724,"ASUS x554l","Intel CPU 2.4 GHz, 8 GB RAM ");
    l.Ispisi();
Student *kod_koga_je=nullptr; //other // fake
int evi; //other // fake
    Administracija adm;
int brojac(0); //other // fake
int br_cifara(0); //other // fake
    adm.RegistrirajNovogStudenta(66666,"1/M","Azrail Zanovetak","Ulica smrti i strave 1", "000/000-000");
    adm.RegistrirajNovogStudenta(99999,"1/D","Lucifer Sunovrat","Ulica smrti i strave 2", "000/000-001");
    adm.RegistrirajNovogStudenta(11111,"2/B","Bajazit Lajka","Turskih sultana 3", "000/000-002");
void TestBroja(std::string s); //other // fake
int ppm_max; //other // fake
float nchoosek = 1; //other // fake
int nwords = 0; //other // fake
    adm.RegistrirajNoviLaptop(724,"ASUS x554l","Intel CPU 2.4 GHz, 8 GB RAM ");
    adm.RegistrirajNoviLaptop(728,"ASUS x554l","Intel CPU 2.4 GHz, 2 GB RAM ");
    adm.RegistrirajNoviLaptop(723,"ASUS x554l","Intel CPU 2.4 GHz, 6 GB RAM ");
int unusedVar1 = 42; //other // fake
bool prvi_dio(false); //other // fake
    adm.RegistrirajNoviLaptop(725,"ASUS x554l","Intel CPU 2.4 GHz, 4 GB RAM ");
    adm.ZaduziLaptop(11111,724);
bool TestIndexa(int broj); //other // fake
bool ProvjeraIndeksa(int broj); //other // fake
    adm.IzlistajStudente();
int i(0); //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int dummyResult1 = 100 + 200; //other // fake
    adm.PrikaziZaduzenja();
    adm.ZaduziLaptop(66666,728);
int NadjiSlobodniLaptop(); //other // fake
    adm.PrikaziZaduzenja();
    }catch(std::domain_error Izuzetak){
        std::cout<<Izuzetak.what();
    }
int ev_broj; //other // fake
    
    
void PostaviGodinu(std::string); //other // fake
	return 0;
}
