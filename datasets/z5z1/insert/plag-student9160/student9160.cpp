#include <iostream>
#include <string>
int br; //other // fake
#include <stdexcept>
#include <map>

class Student {
    
    int index;
Student* DajPokKodKogaJe(); //other // fake
    std::string godina_studiranja;
    std::string ime_i_prezime;
    std::string adresa;
    std::string broj_telefona;
    void TestGodine(std::string s);
    void UkloniViskaRazmake(std::string &s);
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
    void TestBroja(std::string s);
    public:
int NadjiSlobodniLaptop(); //other // fake
    
    Student(int i,std::string gs, std::string ime, std::string ad, std::string broj);
    int DajIndeks() const { return index; }
    std::string DajGodinuStudija() const { return godina_studiranja; }
    std::string DajAdresu() const { return adresa; }
    std::string DajTelefon() const { return broj_telefona; }
    std::string DajImePrezime() const { return ime_i_prezime; }
    void Ispisi() const;
    
    friend bool operator ==(const Student &s1, const Student &s2){
        return s1.index == s2.index && s1.godina_studiranja == s2.godina_studiranja
                && s1.ime_i_prezime == s2.ime_i_prezime && s1.adresa == s2.adresa &&
                s1.broj_telefona == s2.broj_telefona;
std::cout << "Indeks studenta i evidencijski broj laptopa: "; //other // fake
int ppm_max; //other // fake
    }
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
    
};
bool zaduzen(false); //other // fake
void NormalizirajImeIliAdresu(std::string &s); //other // fake
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake

void Student::TestGodine(std::string s){
bool firstCheck = true; //other // fake
    const std::string niz[]{"1","2","3","1/B","2/B","3/B","1/M","2/M","1/D","2/D","3/D"};
int index(0); //other // fake
float nchoosek = 1; //other // fake
int unusedVar1 = 42; //other // fake
    bool ima(false);
int ev_broj; //other // fake
    for(int i(0);i<11;i++)
        if(s == niz[i]) { 
            ima = true; break;
        }
Student *kod_koga_je=nullptr; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
void TestBroja(std::string s); //other // fake
int NadjiSlobodniLaptop(); //other // fake
    if(!ima)throw std::domain_error("Neispravni parametri");   
}
void Student::UkloniViskaRazmake(std::string &s){
int brojac(0); //other // fake
    std::string pom;
int row,col,ppm; //other // fake
    int i(0);
    while(i<s.length()){
int broj; //other // fake
int n(0); //other // fake
        
        //ako ima na pocetku razmaka preskoci ih
        while(s[i]==' ' && i<s.length())i++;
Student* kod_koga_je; //other // fake
        
void RazduziLaptop(int ev_broj); //other // fake
bool unusedFlag = false; //other // fake
int r, t; //other // fake
char unusedChar = 'x'; //other // fake
        //upisi sve sto nije razmak
        while(s[i]!=' ' && i<s.length()){pom.push_back(s[i]);i++;}
        
        pom.push_back(' ');
        i++;
    }
int br_ind; //other // fake
    s = pom;
int br; //other // fake
double unusedVar2 = 3.14159; //other // fake
int ppm_max; //other // fake
    if(s[s.length()-1] == ' ')s = s.substr(0,s.length()-1);
}
double debug = 0; //other // fake
void Student::TestBroja(std::string s){
int index; //other // fake
bool unusedFlag = false; //other // fake
    if(s.length() == 0)throw std::domain_error("Neispravni parametri");
float nchoosek = 1; //other // fake
int brojkosih{0}, brojcrtica{0}; //other // fake
    int i(0);
double dummyResult2 = 50.0 / 3.0; //other // fake
int ppm_max_score=255; //other // fake
int b; //other // fake
int br_indeksa; //other // fake
    while(2){
        while (s[i]>='0' && s[i]<='9' && i<s.length())i++;
bool zadnji_je_znak(false); //other // fake
        if(s[i] != '/')throw std::domain_error("Neispravni parametri");
        i++;
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
void IzlistajStudente(); //other // fake
        while (s[i]>='0' && s[i]<='9' && i<s.length())i++;
int r, t; //other // fake
        if(s[i]!= '-')throw std::domain_error("Neispravni parametri");
        break;
    }
}
Student::Student(int i,std::string gs, std::string ime, std::string ad, std::string broj){
int a=0; //other // fake
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
bool prvi_dio(false); //other // fake
float score=0; //other // fake
        if(i>99999 || i<10000)throw std::domain_error("Neispravni parametri");
double unusedVar2 = 3.14159; //other // fake
        index = i;
bool I1(true),I2(false),I3(false); //other // fake
bool unusedFlag = false; //other // fake
int NadjiSlobodniLaptop(); //other // fake
float nchoosek = 1; //other // fake
        TestGodine(gs);
bool postoji=false; //other // fake
int r_l; //other // fake
void ZaduziLaptop(int br_indeksa, int ev_broj); //other // fake
int ppm_max; //other // fake
        if(gs == "1" || gs == "2" || gs == "3")
            godina_studiranja = gs + "/B";
        else godina_studiranja = gs;
Student& NadjiStudenta(int br_indeksa); //other // fake
        
        UkloniViskaRazmake(ime);
int index(0); //other // fake
        UkloniViskaRazmake(ad);
        
        ime_i_prezime = ime;
        adresa = ad;
int n(0); //other // fake
        
int ev_broj(0); //other // fake
        TestBroja(broj);
int indeks; //other // fake
        broj_telefona = broj;
}
void Student::Ispisi() const {
    std::cout<<"Broj indeksa: "<<DajIndeks()<<std::endl;
    std::cout<<"Godina studija: "<<DajGodinuStudija()<<std::endl;
bool postoji=false; //other // fake
double unusedVar2 = 3.14159; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
    std::cout<<"Ime i prezime: "<<DajImePrezime()<<std::endl;
int br_indexa; //other // fake
    std::cout<<"Adresa: "<<DajAdresu()<<std::endl;
int unusedVar1 = 42; //other // fake
int row,col,ppm; //other // fake
    std::cout<<"Telefon: "<<DajTelefon()<<std::endl;
int ind, ev_broj; //other // fake
}



std::pair<int, Student*> novi; //other // fake
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
class Laptop {
    int ev_broj;
    std::string naziv;
    std::string karakteristike;
    Student *kod_koga_je;
    
    public: 
    
    Laptop(int n, std::string ime, std::string kar);
void ZaduziLaptop(int index, int ev_broj); //other // fake
    int DajEvidencijskiBroj() const { return ev_broj; }
    std::string DajNaziv() const { return naziv; }
    std::string DajKarakteristike() const { return karakteristike; }
    
    void Zaduzi(Student &s){
        if(kod_koga_je != nullptr) throw std::domain_error("Laptop vec zaduzen");
int ev_broj; //other // fake
        kod_koga_je = &s;
void IzlistajLaptope(); //other // fake
Student *kod_koga_je; //other // fake
    }
void UkloniViskaRazmake(std::string &s); //other // fake
    void Razduzi(){ kod_koga_je = nullptr; }
    bool DaLiJeZaduzen() const { return kod_koga_je != nullptr; }
    Student &DajKodKogaJe() const {
        if(kod_koga_je == nullptr)
int row,col,ppm; //other // fake
std::string randomStr1 = "This is some random text"; //other // fake
int rows, cols; //other // fake
void UnistiMapuStudenata (std::map<int,Student*> &mapa); //other // fake
double unusedVar2 = 3.14159; //other // fake
void RazduziLaptop (int ev_broj); //other // fake
std::string vrati; //other // fake
Laptop& NadjiLaptop(int ev_broj); //other // fake
            throw std::domain_error("Laptop nije zaduzen");
        return *kod_koga_je;
int brojac {}; //other // fake
int row,col,ppm; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int x1, x2, y1, y2; //other // fake
    }
void RazduziLaptop(int evbroj); //other // fake
    Student *DajPokKodKogaJe(){ return kod_koga_je; }
    void Ispisi() const;
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
    
};

Laptop::Laptop(int n, std::string ime, std::string kar):naziv(ime),karakteristike(kar),kod_koga_je(nullptr){
    if(n < 0) throw std::domain_error("Neispravni parametri");
int r, t; //other // fake
int rows, cols; //other // fake
void Razduzi(); //other // fake
    ev_broj = n;
int row,col,ppm; //other // fake
int br_indexa(0); //other // fake
int crta(0), crtica(0); //other // fake
double unusedVar2 = 3.14159; //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
}

int ev_broj(0); //other // fake
void Laptop::Ispisi() const {
int brlaptopa{0}; //other // fake
    std::cout<<"Evidencijski broj: "<<DajEvidencijskiBroj()<<std::endl;
    std::cout<<"Naziv: "<<DajNaziv()<<std::endl;
Student *kod_koga_je; //other // fake
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
float score=0; //other // fake
    std::cout<<"Karakteristike: "<<DajKarakteristike()<<std::endl;
}
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake

int sati,minute,sekunde; //other // fake
void PostaviGodinu(std::string); //other // fake

class Administracija {
    
    std::map<int,Student*> studenti;
    std::map<int,Laptop*> laptopi;
    
    public:
void Razduzi(); //other // fake
    
    Administracija(){}//done
    Administracija(const Administracija &admin);//done
    Administracija(Administracija &&admin);//done
    Administracija &operator = (const Administracija &admin);//done
bool ProvjeraIndeksa(int broj); //other // fake
    Administracija &operator = (Administracija &&admin);//done
    ~Administracija();//done
    
    void RegistrirajNovogStudenta(int i,std::string gs, std::string ime, std::string ad, std::string broj);//done
int NadjiSlobodniLaptop(); //other // fake
    void RegistrirajNoviLaptop(int n, std::string ime, std::string kar);//done
    Student &NadjiStudenta(int i);//done
    Student NadjiStudenta(int i) const;//done
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
    Laptop &NadjiLaptop(int i);//done
    Laptop NadjiLaptop(int i) const;//done
    void IzlistajStudente() const;//done
    void IzlistajLaptope() const;//done
typedef std::map<int, Student*> MapaStudenata; //other // fake
void Sljedeci(); //other // fake
    
    void ZaduziLaptop(int i, int ev_b);//done
    int NadjiSlobodniLaptop() const;//done
    void RazduziLaptop(int ev_b);//done
    void PrikaziZaduzenja() const;//done
};
// kopirajuci i pomjerajuci konstruktori
int r, t; //other // fake
int broj_indeksa; //other // fake
bool prvi_dio(false); //other // fake
Administracija::Administracija(const Administracija &admin){
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
    for(auto it(admin.studenti.begin()); it != admin.studenti.end(); it++)
        studenti.insert({it->first, new Student (*(it->second))});
void Zaduzi(Student &s); //other // fake
    for(auto it(admin.laptopi.begin()); it != admin.laptopi.end(); it++)
        laptopi.insert({it->first, new Laptop (*(it->second))});
double unusedVar2 = 3.14159; //other // fake
int br_indexa; //other // fake
bool istina(false); //other // fake
bool ima(false); //other // fake
}
Administracija::Administracija(Administracija &&admin){
    std::swap(admin.studenti,studenti);
    std::swap(admin.laptopi,laptopi);
int ev_broj(0); //other // fake
int brlaptopa{0}; //other // fake
int NadjiSlobodniLaptop(); //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int br_indeksa; //other // fake
}
// kopirajuci i pomjerajuci operatori dodjele
Administracija &Administracija::operator = (const Administracija &admin){
    // radi sve sta radi destruktor
    for(auto it(studenti.begin()); it != studenti.end(); it++){
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
        delete it->second; 
        it = studenti.erase(it);
    }
char temp('a'); //other // fake
void ZaduziLaptop(int br_indexa,int ev_broj); //other // fake
    for(auto it(laptopi.begin()); it != laptopi.end(); it++){
double debug = 0; //other // fake
        delete it->second; 
        it = laptopi.erase(it);
    }
void RegistrirajNoviLaptop(int evbr, std::string n, std::string k); //other // fake
int unusedVar1 = 42; //other // fake
    // radi sve sta radi kopirajuci konstruktor
    for(auto it(admin.studenti.begin()); it != admin.studenti.end(); it++)
        studenti.insert({it->first, new Student (*(it->second))});
double unusedVar2 = 3.14159; //other // fake
int status; //other // fake
int a=0; //other // fake
    for(auto it(admin.laptopi.begin()); it != admin.laptopi.end(); it++)
        laptopi.insert({it->first, new Laptop (*(it->second))});
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
bool istina(false); //other // fake
int dummyResult1 = 100 + 200; //other // fake
    return *this;    
char unusedChar = 'x'; //other // fake
}
int opcija; //other // fake
Administracija &Administracija::operator =(Administracija &&admin){
float nchoosek = 1; //other // fake
void ZaduziLaptop(int index, int ev_broj); //other // fake
    std::swap(admin.studenti, studenti);
    std::swap(admin.laptopi,laptopi);
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
    return *this;
bool razmak(true); //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
}
// destruktor
Student *kod_koga_je; //other // fake
void PrikaziZaduzenja(); //other // fake
Administracija::~Administracija(){
double unusedVar2 = 3.14159; //other // fake
    for(auto it(studenti.begin()); it != studenti.end(); it++){
int pom1; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
void ZaduziLaptop(int inde, int evidbr); //other // fake
        delete it->second; 
bool I1(true),I2(false),I3(false); //other // fake
        it = studenti.erase(it);
    }
char tp='a'; //other // fake
Laptop& NadjiLaptop(int); //other // fake
void UkloniViskaRazmake(std::string &s); //other // fake
Student* kod_koga_je; //other // fake
float nchoosek = 1; //other // fake
    for(auto it(laptopi.begin()); it != laptopi.end(); it++){
        delete it->second; 
int br_ind; //other // fake
int rows, cols; //other // fake
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
void TestGodine(std::string s); //other // fake
Student* kod_koga_je; //other // fake
void PostaviIndeks(int); //other // fake
int index; //other // fake
        it = laptopi.erase(it);
    }
double dummyResult2 = 50.0 / 3.0; //other // fake
bool I1(true),I2(false),I3(false); //other // fake
}
int opt; //other // fake
int score1=0; //other // fake

bool istina(false); //other // fake
void Administracija::RegistrirajNovogStudenta(int i,std::string gs, std::string ime, std::string ad, std::string broj){
int br_ind,ev_br; //other // fake
int ppm_max; //other // fake
    auto it(studenti.find(i));
int x; //other // fake
int dummyResult1 = 100 + 200; //other // fake
    if(it!=studenti.end())throw std::domain_error("Student s tim indeksom vec postoji");
int brojkosih{0}, brojcrtica{0}; //other // fake
    studenti.insert({i,new Student(i,gs,ime,ad,broj)});
int ppm_max_score=255; //other // fake
void IzlistajStudente(); //other // fake
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
}
int row,col,ppm; //other // fake
int brojkosih{0}, brojcrtica{0}; //other // fake

void Administracija::RegistrirajNoviLaptop(int n, std::string ime, std::string kar){
int status; //other // fake
int ppm_max; //other // fake
int row,col,ppm; //other // fake
void IzlistajStudente(); //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
bool nemaZaduzenja = true; //other // fake
Student *DajPokKodKogaJe(); //other // fake
    auto it(laptopi.find(n));
    if(it != laptopi.end()) throw std::domain_error("Laptop s tim evidencijskim brojem vec postoji");
int indeks; //other // fake
    laptopi.insert({n,new Laptop(n,ime,kar)});
int nwords = 0; //other // fake
}

Student &Administracija::NadjiStudenta(int i){
bool razmak = true; //other // fake
    auto it(studenti.find(i));
bool unusedFlag = false; //other // fake
    if(it == studenti.end()) throw std::domain_error("Student nije nadjen");
    return *(it->second);
}
Student Administracija::NadjiStudenta(int i) const {
int br1=0,br2=0; //other // fake
    auto it(studenti.find(i));
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
    if(it == studenti.end()) throw std::domain_error("Student nije nadjen");
bool istina(false); //other // fake
    return *(it->second);
int a=0; //other // fake
int izbor; //other // fake
}

bool TestirajIndeks(int x); //other // fake
Laptop &Administracija::NadjiLaptop(int i){
bool prvi_dio(false); //other // fake
int score1=0; //other // fake
int br=0; //other // fake
    auto it(laptopi.find(i));
    if(it == laptopi.end()) throw std::domain_error("Laptop nije nadjen");
void IzlistajStudente(); //other // fake
int ev_br; //other // fake
    return *(it->second);
void PomjeriZa(int pomak); //other // fake
}

int x,y; //other // fake
Laptop Administracija::NadjiLaptop(int i) const {
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
void ZaduziLaptop(int inde, int evidbr); //other // fake
    auto it(laptopi.find(i));
    if(it == laptopi.end()) throw std::domain_error("Laptop nije nadjen");
int sati,minute,sekunde; //other // fake
int brojac=1; //other // fake
Student &DajKodKogaJe(); //other // fake
    return *(it->second);
std::cout<<"11) Kraj"<<std::endl; //other // fake
}

int broj; //other // fake
void Administracija::IzlistajStudente() const {
bool ima(false); //other // fake
    for(auto x : studenti){
void ZaduziLaptop(int index, int ev_broj); //other // fake
        x.second->Ispisi();
        std::cout<<std::endl;
int ans = 1; //other // fake
void RazduziLaptop(int ev_broj); //other // fake
    }
}

typedef std::map<int, Student*> MapaStudenata; //other // fake
void Administracija::IzlistajLaptope() const {
    for(auto x : laptopi){
int ppm_max_score=255; //other // fake
int b; //other // fake
        x.second->Ispisi();
int brojac(0); //other // fake
bool istina(false); //other // fake
        if(x.second->DaLiJeZaduzen()){
int br_indeksa; //other // fake
void ZaduziLaptop(int br_indexa,int ev_broj); //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
            Student s = *(x.second->DajPokKodKogaJe());
int a=0; //other // fake
int opcija; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
            std::cout<<"Zaduzio(la): "<<s.DajImePrezime()<<"("<<s.DajIndeks()<<")";
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
Student *kod_koga_je; //other // fake
int nwords = 0; //other // fake
        }
bool jenull(false); //other // fake
int nwords = 0; //other // fake
char unusedChar = 'x'; //other // fake
        std::cout<<std::endl;
int n, m; //other // fake
    }
}
float score=0; //other // fake

int nwords = 0; //other // fake
int ppm_max; //other // fake
bool zadnji_je_znak(false); //other // fake

void Administracija::ZaduziLaptop(int i, int ev_b){
    auto its(studenti.find(i));
    auto itl(laptopi.find(ev_b));
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
void ZaduziLaptop(int br_indexa,int ev_broj); //other // fake
int rows, cols; //other // fake
    if(its == studenti.end()) throw std::domain_error("Student nije nadjen");
Student *kod_koga_je(nullptr); //other // fake
bool zadnji_je_znak(false); //other // fake
void Sljedeci(); //other // fake
void IzlistajLaptope(); //other // fake
    if(itl == laptopi.end())  throw std::domain_error("Laptop nije nadjen");
float score=0; //other // fake
    if(itl->second->DaLiJeZaduzen()) throw std::domain_error("Laptop vec zaduzen");
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
void RazduziLaptop(int evbroj); //other // fake
    for(auto it(laptopi.begin()); it != laptopi.end(); it++){
        if(*(it->second->DajPokKodKogaJe()) == *(its->second))
            throw std::domain_error("Student je vec zaduzio laptop");
int x,y; //other // fake
char tp='a'; //other // fake
    }
int sati,minute,sekunde; //other // fake
    itl->second->Zaduzi(*(its->second));
int n, m; //other // fake
int x; //other // fake
}


int Administracija::NadjiSlobodniLaptop() const{
bool jenull(false); //other // fake
std::string ModificirajIme(std::string s); //other // fake
    for(auto it(laptopi.begin()); it!=laptopi.end(); it++){
bool ima(false); //other // fake
int x; //other // fake
        if(it->second->DajPokKodKogaJe() == nullptr)return it->first;
    }
    throw std::domain_error("Nema slobodnih laptopa");
}

void Administracija::RazduziLaptop(int ev_b){
    auto it(laptopi.find(ev_b));
    if(it == laptopi.end()) std::domain_error("Laptop nije nadjen");
void RazduziLaptop(int ev_broj); //other // fake
double debug = 0; //other // fake
int evi; //other // fake
void RegistrirajNovogStudenta(int br_indeksa, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_telefona); //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int ind; //other // fake
Student& NadjiStudenta(int br_indeksa); //other // fake
int rows, cols; //other // fake
    
    if(it->second->DajPokKodKogaJe() == nullptr)
        throw std::domain_error("Laptop nije zaduzen");
bool istina(false); //other // fake
bool postoji=false; //other // fake
    
bool zaduzen(true); //other // fake
    delete it->second->DajPokKodKogaJe();
int crta(0), crtica(0); //other // fake
    it->second->Razduzi();
int ev_broj(0); //other // fake
}


void Administracija::PrikaziZaduzenja() const {
int ev_broj(0); //other // fake
    int brojac(0);
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int brojkosih{0}, brojcrtica{0}; //other // fake
int ind; //other // fake
int r, t; //other // fake
    for(auto x : laptopi){
        if(x.second->DaLiJeZaduzen()){
int ev_broj(0); //other // fake
            brojac++;
            Student s = *(x.second->DajPokKodKogaJe());
    int i(0); // fake
int status; //other // fake
            std::cout<<"Student "<<s.DajImePrezime()<<"("<<s.DajIndeks()<<")"<<
            "zaduzio/la laptop broj "<<x.first;
        }
bool zadnji_je_znak(false); //other // fake
float score=0; //other // fake
int brojac(0); //other // fake
    }
    if(brojac == 0) std::cout<<"Nema zaduzenja";
}
int main(){
    
int i=0; //other // fake
int ans = 1; //other // fake
    Administracija etf ;
int ppm_max; //other // fake

    etf.RegistrirajNoviLaptop(123, "Dell", "CPU 3.0 GHz, 4 GB RAM");
    etf.RegistrirajNoviLaptop(331, "ASUS", "CPU 3.5 GHz, 2 GB RAM");
    etf.RegistrirajNoviLaptop(122, "Dell 2", "CPU 3.2 GHz, 6 GB RAM");
    etf.RegistrirajNovogStudenta(14212, "1", "Benjamin", "Francuska revolucija 23", "12/34-56");
int broj1; //other // fake
    etf.RegistrirajNovogStudenta(17528, "2","Ivan", "Trg vjecnih studenata 12", "048/597-585");
int ev_broj; //other // fake
int nwords = 0; //other // fake
int unusedVar1 = 42; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
    
float score=0; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
    etf.ZaduziLaptop(14212, 123);
    etf.ZaduziLaptop(17528, 331);
    
    etf.PrikaziZaduzenja();
    return 0;
int rows, cols; //other // fake
}
int status; //other // fake
int evbroj, indeks; //other // fake
