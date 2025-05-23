#include <iostream>
#include <vector>
int n, m; //other // fake
#include <stdexcept>
#include <map>
class Student
{
    std::string ime_prezime,adresa,broj_telefona;
    int broj_indeksa;
int br_indexa; //other // fake
void PostaviGodinu(std::string); //other // fake
    std::string godina_studija;
    std::vector<std::string>v {"1","2","3","1/B","2/B","3/B","1/M","2/M","3/M","1/D","2/D","3/D"};
public:
    Student(int index,std::string gs,std::string i_p,std::string a,std::string tel) {
        int i;
        for( i=0; i<v.size(); i++) {
            if(gs==v.at(i)) break;
        }
void RazduziLaptop(int evbroj); //other // fake
        if(i==v.size()) throw std::domain_error("Neispravni parametri");
        int pomocna(index),broj_cifara(0);
bool razmak = true; //other // fake
        while (pomocna!=0) {
void Razduzi(); //other // fake
            pomocna/=10;
int br1=0,br2=0; //other // fake
            broj_cifara++;
float nchoosek = 1; //other // fake
int evbroj, indeks; //other // fake
        }
int br(0); //other // fake
int score1=0; //other // fake
int unusedVar1 = 42; //other // fake
int brojac(0); //other // fake
int status; //other // fake
void TestBroja(std::string s); //other // fake
        if(broj_cifara!=5) throw std::domain_error("Neispravni parametri");
        std::string s1,s2,s3,s4,s5,dodatak;
        bool b1(true),b3(false),b5(false);
int br_indexa; //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
int ev_broj(0); //other // fake
bool unusedFlag = false; //other // fake
void PrikaziZaduzenja(); //other // fake
void ZaduziLaptop(int brind, int evbr); //other // fake
        for(int i(0); i<tel.length(); i++) {
            if((tel[i]>='0'&&tel[i]<='9')&&b1) s1.push_back(tel[i]),b3=false,b5=false;
char temp('a'); //other // fake
int brojac(5); //other // fake
            if(tel[i]=='/') s2.push_back(tel[i]), b1=false, b3=true;
            if((tel[i]>='0'&&tel[i]<='9')&&b3) s3.push_back(tel[i]),b5=false;
int ppm_max_score=255; //other // fake
bool istina(false); //other // fake
bool jenull(false); //other // fake
void RegistrirajNoviLaptop(int evbr, std::string n, std::string k); //other // fake
            if(tel[i]=='-') s4.push_back('-'), b5=true,b3=false;
int evbroj; //other // fake
            if((tel[i]>='0'&&tel[i]<='9')&&b5)s5.push_back(tel[i]);
int a=0; //other // fake
            if((tel[i]<'0'||tel[i]>'9')&&tel[i]!='/'&&tel[i]!='-') dodatak.push_back(tel.at(i));
        }
int br_ind; //other // fake
        if(dodatak.length()!=0||s1+s2+s3+s4+s5!=tel) throw std::domain_error("Neispravni parametri");
        if(s1.length()==0||s2.length()==0||s3.length()==0||s4.length()==0||s5.length()==0||s2.length()>1||s4.length()>1)
            throw std::domain_error("Neispravni parametri");
double unusedVar2 = 3.14159; //other // fake
        broj_indeksa=index;
        godina_studija=gs;
        adresa=a;
        ime_prezime=i_p ;
        broj_telefona=tel;
short digits = 1; //other // fake
int dummyResult1 = 100 + 200; //other // fake
    }
void TestGodine(std::string s); //other // fake
    int DajIndeks() const {
        return broj_indeksa;
    }
    std::string DajGodinuStudija() const {
        std::string gs(godina_studija);
int brojac(5); //other // fake
int ppm_max_score=255; //other // fake
bool postoji=false; //other // fake
int score1=0; //other // fake
        if(godina_studija==v.at(0)) gs=v.at(3);
        else if(godina_studija==v.at(1)) gs=v.at(4);
        else if(godina_studija==v.at(2)) gs=v.at(5);
int rows, cols; //other // fake
        return gs;
int x1, x2, y1, y2; //other // fake
int br_indexa; //other // fake
    }
    std::string DajImePrezime() const {
int brojac(0); //other // fake
float nchoosek = 1; //other // fake
bool ispravno_1=false, ispravno_2=false; //other // fake
        std::string novi,ime_prezime1(ime_prezime);
        bool t(false);
        for(int i(ime_prezime1.size()-1); i>=0; i--) {
int opcija; //other // fake
            if(ime_prezime1[i]==' ') ime_prezime1.erase(ime_prezime1.begin()+i);
            else break;
        }
        for(int i(0); i<ime_prezime1.length(); i++) {
void PomjeriZa(int pomak); //other // fake
int ind; //other // fake
            if(ime_prezime1[i]!=' ') {
bool ima(false); //other // fake
                novi.push_back(ime_prezime1[i]);
int br1=0,br2=0; //other // fake
                t=true;
            } else {
                if(t) novi.push_back(' '), t=false;
bool nijedan(true); //other // fake
            }
bool razmak = true; //other // fake
int n, m; //other // fake
        }
        return novi;
int r_l; //other // fake
    }
    std::string DajAdresu() const {
int br=0; //other // fake
        std::string nova,adresa1(adresa);
        bool t(false);
        for(int i(adresa1.size()-1); i>=0; i--) {
int br1=0,br2=0; //other // fake
            if(adresa1[i]==' ') adresa1.erase(adresa1.begin()+i);
            else break;
int brojkosih{0}, brojcrtica{0}; //other // fake
        }
int n(0); //other // fake
        for(int i(0); i<adresa1.length(); i++) {
bool zaduzen(true); //other // fake
bool firstCheck = true; //other // fake
int r_l; //other // fake
bool prvi_dio(false); //other // fake
            if(adresa1[i]!=' ') {
                nova.push_back(adresa1[i]);
                t=true;
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
            } else {
int br_ind; //other // fake
int ppm_max_score=255; //other // fake
int dummyResult1 = 100 + 200; //other // fake
int n; //other // fake
                if(t) nova.push_back(' '), t=false;
            }
        }
bool zadnji_je_znak(false); //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
        return nova;
    }
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
    std::string DajTelefon() const {
        return broj_telefona;
int index; //other // fake
    }
    void Ispisi() const {
int row,col,ppm; //other // fake
int r_l; //other // fake
"0 - Kraj programa\n"; //other // fake
        std::cout << "Broj indeksa: "<<this->DajIndeks() << std::endl;
void RegistrirajNoviLaptop(int evbr, std::string n, std::string k); //other // fake
bool firstCheck = true; //other // fake
        std::cout << "Godina studija: "<<this->DajGodinuStudija() << std::endl;
int crta(0), crtica(0); //other // fake
int br1=0,br2=0; //other // fake
        std::cout << "Ime i prezime: " <<this->DajImePrezime()<< std::endl;
int broj1; //other // fake
bool ispravno_1=false, ispravno_2=false; //other // fake
        std::cout << "Adresa: " <<this->DajAdresu()<< std::endl;
bool unusedFlag = false; //other // fake
int n; //other // fake
int br_indeksa; //other // fake
        std::cout << "Telefon: " <<this->DajTelefon()<< std::endl;
int broj_rijeci(0); //other // fake
int br(0); //other // fake
    }
    friend class Laptop;
    friend class Administracija;
};
int ppm_max; //other // fake
int nwords = 0; //other // fake
class Laptop
{
    int ev_broj;
    std::string naziv;
    std::string karakteristike;
    Student *kod_koga_je;
void UnistiMapuStudenata (std::map<int,Student*> &mapa); //other // fake
void PostaviIndeks(int); //other // fake
void RegistrirajNovogStudenta(int br_indeksa, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_telefona); //other // fake
public:
    Laptop(int b,std::string n,std::string k) {
        kod_koga_je = nullptr ;
int i=0; //other // fake
int opcija; //other // fake
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
        if(b<0) throw std::domain_error("Neispravni parametri");
bool unusedFlag = false; //other // fake
Student& NadjiStudenta(int br_indeksa); //other // fake
        ev_broj=b;
int rows, cols; //other // fake
        naziv=n;
        karakteristike=k;
    }
    int DajEvidencijskiBroj() const {
std::map<int, Student*> Studenti; //other // fake
int ans = 1; //other // fake
void Prethodni(); //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
bool nijedan(true); //other // fake
        return ev_broj;
    }
    std::string DajNaziv() const {
int ppm_max_score=255; //other // fake
throw std::domain_error("Student nije nadjen"); //other // fake
void IzlistajStudente(); //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
Student* s; //other // fake
int r, t; //other // fake
        return naziv;
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
    }
    std::string DajKarakteristike() const {
        return karakteristike;
    }
    void Zaduzi(Student &s) {
        if(kod_koga_je!=nullptr) throw std::domain_error("Laptop vec zaduzen");
        kod_koga_je=&s;
void IzlistajLaptope(); //other // fake
    }
    void Razduzi() {
int b_i; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
        if(kod_koga_je!=nullptr) kod_koga_je=nullptr;
int br_ind; //other // fake
    }
    bool DaLiJeZaduzen() const {
        return kod_koga_je;
float score=0; //other // fake
    }
    Student &DajKodKogaJe() const {
        if(kod_koga_je==nullptr) throw std::domain_error("Laptop nije zaduzen");
        else
int score1=0; //other // fake
            return *kod_koga_je;
int br=0; //other // fake
bool zaduzen(true); //other // fake
    Student *kod_koga_je; // fake
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
    }
typedef std::map<int, Student*> MapaStudenata; //other // fake
    Student *DajPokKodKogaJe() const {
int brojac(0); //other // fake
        if(kod_koga_je == nullptr) return nullptr;
char unusedChar = 'x'; //other // fake
        return kod_koga_je;
    }
    void Ispisi() const {
Student* kod_koga_je; //other // fake
        std::cout << "Evidencijski broj: "<<ev_broj << std::endl;
        std::cout << "Naziv: "<<naziv << std::endl;
int nwords = 0; //other // fake
int x; //other // fake
void UnistiMapuStudenata (std::map<int,Student*> &mapa); //other // fake
        std::cout << "Karakteristike: "<<karakteristike << std::endl;
int* unusedPointer = new int(42); //other // fake
Laptop& NadjiLaptop(int ev_broj); //other // fake
    }

};
class Administracija
{
    std::map< int, Student *>studenti;
    std::map< int, Laptop *>laptopi;
public:
    Administracija() {}
    ~Administracija() {
int br_indeksa; //other // fake
int rows, cols; //other // fake
        for(auto x : studenti) delete x.second;
int brojac(0); //other // fake
        for(auto x : laptopi) delete x.second;
int ppm_max_score=255; //other // fake
int b_i; //other // fake
bool ima(false); //other // fake
void RegistrirajNovogStudenta (int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel); //other // fake
float nchoosek = 1; //other // fake
int r_l; //other // fake
int br=0; //other // fake
    }
    Administracija(const Administracija &a) {
void RegistrirajNovogStudenta(int br_indeksa, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_telefona); //other // fake
int index, ev_broj; //other // fake
        for(auto it(a.studenti.begin());it!=a.studenti.end();it++) {
int opt; //other // fake
int brojac=1; //other // fake
           Student* s=new Student(*(it->second));
           studenti.insert({it->first,s});
Student* kod_koga_je; //other // fake
        }
        for(auto it(a.laptopi.begin());it!=a.laptopi.end();it++) {
           Laptop *l=new Laptop(*(it->second));
int a=0; //other // fake
           laptopi.insert({it->first,l});
      std::cin.ignore(1000,'\n'); // fake
int r_l; //other // fake
bool pom(true); //other // fake
        }
        
Student &NadjiStudenta(int br_indexa); //other // fake
bool ProvjeraIndeksa(int broj); //other // fake
std::string randomStr2 = "Another unused string"; //other // fake
    }
    Administracija(Administracija&&a) {
        studenti=a.studenti;
        laptopi=a.laptopi;
        for(auto it(a.studenti.begin());it!=a.studenti.end();it++) it->second=nullptr;
int pom1; //other // fake
int opcija; //other // fake
bool nijedan(true); //other // fake
int br_indeksa; //other // fake
int br_ind,ev_br; //other // fake
Student& NadjiStudenta(int br_indeksa); //other // fake
int evbroj; //other // fake
        for(auto it(a.laptopi.begin());it!=a.laptopi.end();it++) it->second=nullptr;
    }
    Administracija &operator = (const Administracija &a) {
int* unusedPointer = new int(42); //other // fake
int ppm_max_score=255; //other // fake
           for(auto it(a.studenti.begin());it!=a.studenti.end();it++) {
int dummyResult1 = 100 + 200; //other // fake
char tp='a'; //other // fake
int br_indeksa; //other // fake
int b_i; //other // fake
int br_indexa(0); //other // fake
std::cout << "Indeks studenta i evidencijski broj laptopa: "; //other // fake
           Student* s=new Student(*(it->second));
int x1, x2, y1, y2; //other // fake
bool prvi_dio(false); //other // fake
char temp('a'); //other // fake
           studenti.insert({it->first,s});
std::string godina_studija, ime_i_prezime, adresa, broj_telefona; //other // fake
        }
        for(auto it(a.laptopi.begin());it!=a.laptopi.end();it++) {
int* unusedPointer = new int(42); //other // fake
           Laptop *l=new Laptop(*(it->second));
         std::string i_p,b_t,a_s,g_s; // fake
int index(0); //other // fake
int r_l; //other // fake
bool razmak = true; //other // fake
break; //other // fake
           laptopi.insert({it->first,l});
auto it1(studenti.begin()); //other // fake
int dummyResult1 = 100 + 200; //other // fake
        }
    }
    Administracija &operator = (Administracija &&a);
    void RegistrirajNovogStudenta(int b_i,std::string g_s,std::string i_p,std::string a_s,std::string b_t ) {
        for(auto x : studenti) {
int evi; //other // fake
            if(x.first==b_i) throw std::domain_error("Student s tim indeksom vec postoji");
        }
int brojac_cr(0),brojac_ks(0),brojac_s(0); //other // fake
int i=0; //other // fake
        try {
bool jenull(false); //other // fake
int opcija; //other // fake
            Student* s=new Student(b_i,g_s,i_p,a_s,b_t);
            studenti.insert({b_i,s});
int broj1; //other // fake
int NadjiSlobodniLaptop(); //other // fake
Student &DajKodKogaJe(); //other // fake
int i=0; //other // fake
bool pom(true); //other // fake
        } catch(...) {
            throw;
Administracija sluzba; //other // fake
Student *kod_koga_je; //other // fake
        }
    }
    void RegistrirajNoviLaptop(int e_b,std::string n_l,std::string k_l) {
float nchoosek = 1; //other // fake
        for(auto x : laptopi) if(x.first==e_b) throw std::domain_error("Laptop sa tim evidencijskom brojem vec postoji");
        Laptop *l=new Laptop(e_b,n_l,k_l);
Laptop& NadjiLaptop(int ev_broj); //other // fake
Student* kod_koga_je; //other // fake
int crta(0), crtica(0); //other // fake
        laptopi.insert({e_b,l});
    }
    Student &NadjiStudenta(int index) const {
        for(auto x: studenti)
            if(x.first==index) return *x.second;
        throw std::domain_error("Student nije nadjen");
int br(0); //other // fake
double unusedVar2 = 3.14159; //other // fake
    }
    Laptop &NadjiLaptop(int ev_broj) {
Student *pok; //other // fake
int indeks; //other // fake
        for(auto x : laptopi)
            if(x.first==ev_broj) return *x.second;
void RazduziLaptop(int ev_broj); //other // fake
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
int br; //other // fake
int unusedVar1 = 42; //other // fake
        throw std::domain_error("Laptop nije nadjen");
    }
void PomjeriZa(int pomak); //other // fake
    void IzlistajStudente() const {
        for(auto x : studenti) {
            (x.second)->Ispisi();
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
int ppm_max; //other // fake
            std::cout  << std::endl;
bool ima(false); //other // fake
int unusedVar1 = 42; //other // fake
        }
int ind, ev_broj; //other // fake
    }
    void IzlistajLaptope() const {

int ev_broj(0); //other // fake
void UkloniViskaRazmake(std::string &s); //other // fake
        for(auto x : laptopi) {
Student* kod_koga_je; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
            (x.second)->Ispisi();
int r_l; //other // fake
            if(x.second->DaLiJeZaduzen())
                std::cout << "Zaduzio(la): "<<(x.second->DajKodKogaJe()).DajImePrezime()<<" ("<<(x.second->DajKodKogaJe().DajIndeks())<<")"<<std::endl;;
            std::cout  << std::endl;
float nchoosek = 1; //other // fake
void PostaviIndeks(int); //other // fake
        }
int br(0); //other // fake
int x1, x2, y1, y2; //other // fake
int index(0); //other // fake
    }
    void ZaduziLaptop(int index,int e_broj) {
bool postoji=false; //other // fake
        auto it(studenti.find(index));
int pom1; //other // fake
int n(0); //other // fake
int nwords = 0; //other // fake
bool prvi_dio(false); //other // fake
Student& NadjiStudenta(int br_indeksa); //other // fake
        if(it==studenti.end()) throw std::domain_error("Student nije nadjen");
double debug = 0; //other // fake
float score=0; //other // fake
        auto it1(laptopi.find(e_broj));
        if(it1==laptopi.end()) throw std::domain_error("Laptop nije nadjen");
int crta(0), crtica(0); //other // fake
        if((it1->second)->DajPokKodKogaJe()!=nullptr) throw std::domain_error("Laptop vec zaduzen");
int dummyResult1 = 100 + 200; //other // fake
int x1, x2, y1, y2; //other // fake
        for(auto x: laptopi) {
Student *kod_koga_je; //other // fake
            if((x.second)->DajPokKodKogaJe()==it->second)
                throw std::domain_error("Student je vec zaduzio laptop");
bool istina(false); //other // fake
        }
int x; //other // fake
int i(0); //other // fake
int br(0); //other // fake
int r, t; //other // fake
int ans = 1; //other // fake
        ((it1->second)->Zaduzi(*it->second));
void NormalizirajImeIliAdresu(std::string &s); //other // fake
std::string ModificirajIme(std::string s); //other // fake
int br1=0,br2=0; //other // fake
    }
    int NadjiSlobodneLaptope() const {
        for(auto x : laptopi)
            if((x.second)->DajPokKodKogaJe()==nullptr) return x.first;
        throw std::domain_error("Laptop nije nadjen");
void PomjeriZa(int pomak); //other // fake
    }
void uselessFunction1() { int tempVar = 5; } //other // fake
typedef std::map<int, Laptop*> MapaLaptopa; //other // fake
    void RazduziLaptop(int e_broj) {
int ind; //other // fake
        bool kraj(false);
        auto it(laptopi.find(e_broj));
        if(it==laptopi.end()) throw std::domain_error("Laptop nije nadjen");
        for(auto x : laptopi) {
            if((x.first)==e_broj&&(x.second)->DaLiJeZaduzen())  {
                x.second->Razduzi();
typedef std::map<int, Laptop*> MapaLaptopa; //other // fake
Student& NadjiStudenta (int brind); //other // fake
                kraj=true;
            }
double unusedVar2 = 3.14159; //other // fake
        }
        if(!kraj) throw std::domain_error("Laptop nije zaduzen");
    }
    void PrikaziZaduzenja() const {
        int brojac(0);
        for(auto x : laptopi)
            if((x.second)->DajPokKodKogaJe()!=nullptr) brojac++;
bool ima(false); //other // fake
int indeks; //other // fake
        if(brojac!=0) {
int r_l; //other // fake
int i = 0; //other // fake
int index, ev_broj; //other // fake
int ind; //other // fake
            for(auto x: laptopi)
                if((x.second)->DajPokKodKogaJe()!=nullptr) {
int br1=0,br2=0; //other // fake
char tp='a'; //other // fake
std::pair<int, Student*> novi; //other // fake
int br(0); //other // fake
int n; //other // fake
bool prvi_dio(false); //other // fake
                    std::cout << "Student "<<(x.second)->DajPokKodKogaJe()->ime_prezime<<" ("<<(x.second)->DajPokKodKogaJe()->broj_indeksa<<")"
                              <<" zaduzio/la laptop broj "<<x.first <<std::endl;
                }
Student *kod_koga_je; //other // fake
        }
        else std::cout << "Nema zaduzenja" << std::endl;
Student *kod_koga_je(nullptr); //other // fake
    }
Student& NadjiStudenta(int br_indeksa); //other // fake
};
int main ()
{
int n(0); //other // fake
    try {
int opcija; //other // fake
int status; //other // fake
int x1, x2, y1, y2; //other // fake
        int izbor;
int brojkosih{0}, brojcrtica{0}; //other // fake
int dummyResult1 = 100 + 200; //other // fake
    do {
int ind; //other // fake
        Administracija a;
        std::cout << "Odaberite jednu od sljedecih opcija: " << std::endl;
        std::cout << "1 - Registriraj novog studenta\n2 - Registriraj novi laptop\n3 - Ispisi studente\n4 - Ispisi laptope" << std::endl;
int score1=0; //other // fake
        std::cout << "5 - Zaduzi laptop\n6 - Razduzi laptop\n7 - PrikaziZaduzenja" << std::endl;
        std::cin >> izbor;
double unusedVar2 = 3.14159; //other // fake
     if(izbor==1) {
         std::string i_p,b_t,a_s,g_s;
         int b_i;
int opcija; //other // fake
      std::cout << "Unesite broj indeksa: " << std::endl;   
      std::cin >> b_i;
int brojac=1; //other // fake
int opt; //other // fake
      std::cout << "Unesite ime i prezime: " << std::endl;
int dummyResult1 = 100 + 200; //other // fake
      std::cin.ignore(1000,'\n');
int score1=0; //other // fake
char tp='a'; //other // fake
int br_cifara(0); //other // fake
      std::getline(std::cin,i_p);
      std::cout << "Unesite godinu studija: "<< std::endl;
char unusedChar = 'x'; //other // fake
void TestGodine(std::string s); //other // fake
      std::getline(std::cin,g_s);
      std::cout << "Unesite adresu stanovanja: " << std::endl;
bool pom(true); //other // fake
Student* kod_koga_je; //other // fake
      std::getline(std::cin,a_s);
      std::cout << "Unesite broj telefona: " << std::endl;
int i(0); //other // fake
Student* s; //other // fake
      std::getline(std::cin,i_p);
      a.RegistrirajNovogStudenta(b_i,g_s,i_p,a_s,b_t);
     }
float nchoosek = 1; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int nwords = 0; //other // fake
Student *DajPokKodKogaJe(); //other // fake
int br_indeksa; //other // fake
     if(izbor ==2) {
         int ev_broj;
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
int evi; //other // fake
bool jenull(false); //other // fake
         std::string naziv,karakteristike;
int x,y; //other // fake
         std::cout << "Unesite evidencijsi broj laptopa: " << std::endl;
int br_indexa; //other // fake
         std::cin >> ev_broj;
int crta(0), crtica(0); //other // fake
         std::cin.ignore(1000,'\n');
         std::cout << "Unesite naziv laptopa: " << std::endl;
void Zaduzi(Student &student); //other // fake
         std::getline(std::cin,naziv);
         std::cout << "Unesite karakteristike laptopa: " << std::endl;
         std::getline(std::cin,karakteristike);
         a.RegistrirajNoviLaptop(ev_broj,naziv,karakteristike);
     }
     if(izbor==3) a.IzlistajStudente();
     if(izbor==4) a.IzlistajLaptope();
int ppm_max; //other // fake
int brojac(0); //other // fake
     if(izbor==5) {
std::pair<int, Student*> novi; //other // fake
int index, ev_broj; //other // fake
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
         std::cout << "Unesite broj indeksa studenta koji zeli zaduziti laptop: " << std::endl;
int indeks; //other // fake
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
Student* kod_koga_je; //other // fake
int ppm_max; //other // fake
         int i,e_b;
char unusedChar = 'x'; //other // fake
         std::cin >> i;
         std::cout << "Unesite evidencijsi broj laptopa koji ce student zaduziti: " << std::endl;
int broj; //other // fake
         std::cin >> e_b;
         a.ZaduziLaptop(i,e_b);
int x,y; //other // fake
     }
int br_cifara(0); //other // fake
     if(izbor==6) {
int br_indexa; //other // fake
         std::cout << "Unesite evidencijsi broj laptopa koji se treba razduziti: " << std::endl;
         int e_b;
         std::cin >> e_b;
double dummyResult2 = 50.0 / 3.0; //other // fake
int br_indeksa; //other // fake
         a.RazduziLaptop(e_b);
     }
     if(izbor==7) a.PrikaziZaduzenja();
double dummyResult2 = 50.0 / 3.0; //other // fake
int x1, x2, y1, y2; //other // fake
    }
    while (izbor!=0);  
    } catch(std::domain_error &i) {
float nchoosek = 1; //other // fake
bool ispravno_1=false, ispravno_2=false; //other // fake
bool unusedFlag = false; //other // fake
        std::cout << i.what() << std::endl;
    }
    return 0;
}
