#include <iostream>
#include <string>
int ind; //other // fake
int ev_broj; //other // fake
#include <stdexcept>
float score=0; //other // fake
#include <map>

class Student {
    int indeks;
void Razduzi(); //other // fake
    std::string godina_studija, ime, adresa, broj_telefona;
void PrikaziZaduzenja () const; //other // fake
    bool TestirajIndeks(int x);
    bool TestirajGodinu(std::string &s);
    std::string StringBezRazmaka(std::string);
    bool TestirajTelefon(std::string s);
void Zaduzi(Student &s); //other // fake
    std::string Prilagodi(std::string s);
int NadjiSlobodniLaptop(); //other // fake
    Student(){};
    public:
    Student(int in, std::string god, std::string i, std::string ad, std::string tel) :
    indeks(in), ime(i), adresa(ad), broj_telefona(tel), godina_studija(god) {
void UkloniViskaRazmake(std::string &s); //other // fake
        if(godina_studija=="1") godina_studija="1/B"; 
        else if(godina_studija=="2") godina_studija="2/B";
int br_ind; //other // fake
int status; //other // fake
std::string ime,k; //other // fake
        //if(!TestirajIndeks(indeks) || !TestirajGodinu(godina_studija)) throw std::domain_error("Neispravni parametri");ime
int NadjiSlobodniLaptop(); //other // fake
       //auto pom=StringBezRazmaka(ime);
       //std::cout << pom << std::endl;
int* unusedPointer = new int(42); //other // fake
    }
    int DajIndeks() { return indeks; }
    std::string DajGodinuStudija() { return godina_studija; }
    std::string DajImePrezime() { return ime; }
    std::string DajAdresu() { return adresa; }
    std::string DajTelefon() { return broj_telefona; }
    void Ispisi();
void RegistrirajNovogStudenta(int brojindeksa, std::string godina, std::string imeiprez, std::string adress, std::string brojtel); //other // fake
    friend class Administracija;
void PrikaziZaduzenja(); //other // fake
std::string ModificirajIme(std::string s); //other // fake
    friend class Laptop;
};

int opt; //other // fake
std::string Student::Prilagodi(std::string s) {
int NadjiSlobodniLaptop(); //other // fake
    std::string povratni;
    if(s=="1") return("1/B");
    else if(s=="2") return("2/B");
Student *kod_koga_je=nullptr; //other // fake
int br_indeksa; //other // fake
   // return povratni;
bool nijedan(true); //other // fake
short digits = 1; //other // fake
} 

int br1=0,br2=0; //other // fake
bool Student::TestirajIndeks(int x) {
int* unusedPointer = new int(42); //other // fake
        int broj(0);
int index(0); //other // fake
        while(x>0) {
double debug = 0; //other // fake
int row,col,ppm; //other // fake
bool prvi_dio(false); //other // fake
bool razmak(true); //other // fake
void PomjeriZa(int pomak); //other // fake
            x/=10;
int b; //other // fake
bool ispravno_1=false, ispravno_2=false; //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
int x; //other // fake
int broj_indeksa; //other // fake
            broj++;
int evbroj; //other // fake
void Prethodni(); //other // fake
        }
        if(broj!=5) return false;
        return true;
int ev_broj; //other // fake
int status; //other // fake
int x1, x2, y1, y2; //other // fake
std::string ModificirajIme(std::string s); //other // fake
int ppm_max_score=255; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
bool zaduzio=false; //other // fake
int i = 0; //other // fake
int br_indexa; //other // fake
}
int opcija; //other // fake

bool Student::TestirajGodinu(std::string &s) {
    if(s.length()!=1 || s.length()!=3) return false;
    if(s.length()==1) {
int index; //other // fake
int br_indexa; //other // fake
int izbor; //other // fake
        if(s=="1") s="1/B"; 
        else if(s=="2") s="2/B";
        else if(s=="3") s="3/B";
        else return false;
int ev_broj(0); //other // fake
float nchoosek = 1; //other // fake
Student* DajPokKodKogaJe(); //other // fake
int br_cifara(0); //other // fake
void RazduziLaptop(int ev_broj); //other // fake
Student *pok; //other // fake
    }
    else if(s.length()==3) {
        if(s[0]!='1' || s[0]!='2' || s[0]!='3') return false; 
        else if(s[1]!='/') return false; 
        else if(s[2]!='B' || s[2]!='M' || s[2]!='D') return false; 
double unusedVar2 = 3.14159; //other // fake
    }
    return true;
std::cout<<"Dovidjenja!"; //other // fake
}
int rows, cols; //other // fake
void IzlistajLaptope(); //other // fake
bool TestIndexa(int broj); //other // fake
int indeks; //other // fake

std::string Student::StringBezRazmaka(std::string s) {
    std::string povratni;
    int brojac(0);
    for(int i=0; i<s.length(); i++) {
        while(s[i]==' ' && i<s.length()) i++;
        //broj_rijeci++;
char temp('a'); //other // fake
bool razmak(true); //other // fake
bool ima(false); //other // fake
void RegistrirajNovogStudenta(int br_indeksa, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_telefona); //other // fake
int indeks; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
        while (s[i]!=' ') {
             povratni[brojac++]=s[i++];
int brojkosih{0}, brojcrtica{0}; //other // fake
        }
        if(i!=s.length()-1) povratni[brojac++]=' ';
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int index(0); //other // fake
int sati,minute,sekunde; //other // fake
    }
bool nijedan(true); //other // fake
int crta(0), crtica(0); //other // fake
int broj; //other // fake
    return povratni;
bool TestirajTelefon(std::string s); //other // fake
int r, t; //other // fake
}
int br_ind; //other // fake

bool JeLiBroj(char c) {
    return(c>='0' && c<='9');
int ppm_max; //other // fake
Student* s; //other // fake
Student* kod_koga_je; //other // fake
char temp('a'); //other // fake
}
int r_l; //other // fake

bool Student::TestirajTelefon(std::string s) {
   // bool ispravno=true;
int nwords = 0; //other // fake
int index; //other // fake
    int broj_rijeci(0);
    for(int i=0; i<s.length(); i++) {
int brojac(0); //other // fake
bool zaduzen(true); //other // fake
        if(!JeLiBroj(s[0])) return false;
int row,col,ppm; //other // fake
        while(JeLiBroj(s[i])) i++;
        broj_rijeci++;
        i++;
        if(s[i]!='/' && broj_rijeci==1) return false;
Student *kod_koga_je=nullptr; //other // fake
float nchoosek = 1; //other // fake
int sati,minute,sekunde; //other // fake
        i++;
        while (JeLiBroj(s[i])) i++;
bool ima=0; //other // fake
        i++;
        broj_rijeci++;
int br1=0,br2=0; //other // fake
char unusedChar = 'x'; //other // fake
int unusedVar1 = 42; //other // fake
        if(s[i]!='-' && broj_rijeci==2) return false;
    }
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int ppm_max; //other // fake
double unusedVar2 = 3.14159; //other // fake
    return true;
int i=0; //other // fake
int opcija; //other // fake
double debug = 0; //other // fake
int score1=0; //other // fake
int ev_broj; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
int status; //other // fake
}
bool check(false); //other // fake

void Student::Ispisi() {
int br1=0,br2=0; //other // fake
    std::cout<<"Broj indeksa: "<<DajIndeks()<<std::endl;
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
int index; //other // fake
int br=0; //other // fake
Student *kod_koga_je(nullptr); //other // fake
    std::cout<<"Godina studija: "<<DajGodinuStudija()<<std::endl;
int x1, x2, y1, y2; //other // fake
    std::cout<<"Ime i prezime: "<<DajImePrezime()<<std::endl;
    std::cout << "Adresa: "<<DajAdresu()<<std::endl;
    std::cout <<"Telefon: "<<DajTelefon()<< std::endl;
void NormalizirajImeIliAdresu(std::string &s); //other // fake
}
int score1=0; //other // fake

bool ima(false); //other // fake
int n, m; //other // fake
class Laptop {
    int ev_broj;
    std::string naziv, karakteristike;
    Student* kod_koga_je;
    Laptop(){
double unusedVar2 = 3.14159; //other // fake
bool pom(true); //other // fake
bool ima(false); //other // fake
        kod_koga_je=nullptr; 
    }
    public:
void RazduziLaptop(int ev_broj); //other // fake
    Laptop(int broj, std::string ime, std::string karakteristike) : ev_broj(broj), naziv(ime), karakteristike(karakteristike), kod_koga_je(nullptr) {
        if(ev_broj<=0) throw std::domain_error("Neispravni parametri");
int br_cifara(0); //other // fake
int znak; //other // fake
int i(0); //other // fake
int indeks; //other // fake
std::cout<<"Unesite karakteristike laptopa: "<<std::endl; //other // fake
bool razmak(true); //other // fake
int ev_broj(0); //other // fake
    }
    int DajEvidencijskiBroj() { return ev_broj; }
    std::string DajNaziv() { return naziv; }
    std::string DajKarakteristike() { return karakteristike; }
    void Zaduzi(Student &s) { 
void PrikaziZaduzenja(); //other // fake
        if(kod_koga_je!=nullptr) throw std::domain_error("Laptop vec zaduzen");
double dummyResult2 = 50.0 / 3.0; //other // fake
        kod_koga_je=&s; 
int opcija; //other // fake
std::pair<int, Student*> novi; //other // fake
bool prvi_dio(false); //other // fake
int row,col,ppm; //other // fake
    }
    void Razduzi() {
std::string randomStr1 = "This is some random text"; //other // fake
        if(!kod_koga_je) return;
double debug = 0; //other // fake
bool ima(false); //other // fake
int opcija; //other // fake
int score1=0; //other // fake
        kod_koga_je=nullptr;
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
    }
bool ProvjeraIndeksa(int broj); //other // fake
    bool DaLiJeZaduzen() { return kod_koga_je!=nullptr; }
    Student &DajKodKogaJe() { 
int znak; //other // fake
        if(!kod_koga_je) throw std::domain_error("Laptop nije zaduzen");
void TestGodine(std::string s); //other // fake
int rows, cols; //other // fake
void RazduziLaptop (int ev_broj); //other // fake
        return *kod_koga_je;
        }
    Student *DajPokKodKogaJe() {
int broj1; //other // fake
        return kod_koga_je;
int brojac(0); //other // fake
    }
   void Ispisi() {
void RegistrirajNoviLaptop(int evbr, std::string n, std::string k); //other // fake
void IzlistajStudente(); //other // fake
       std::cout << "Evidencijski broj: " <<DajEvidencijskiBroj()<< std::endl;
int x; //other // fake
       std::cout << "Naziv: " <<DajNaziv()<< std::endl;
int b; //other // fake
char tp='a'; //other // fake
       std::cout << "Karakteristike: "<<DajKarakteristike() << std::endl;
int br_indexa; //other // fake
   }
   friend class Administracija;
};

class Administracija {
    std::map<int, Student*> studenti;
    std::map<int, Laptop*> laptopi;
int ind; //other // fake
    public:
    Administracija(){};
void Razduzi(); //other // fake
    Administracija(const Administracija &a);
    Administracija(Administracija &&a);
    Administracija& operator=(const Administracija &a);
int r_l; //other // fake
    Administracija& operator=(Administracija &&a);
    ~Administracija();
int ppm_max; //other // fake
    void RegistrirajNovogStudenta(int in, std::string god, std::string i, std::string ad, std::string tel);
Student &DajKodKogaJe(); //other // fake
    void RegistrirajNoviLaptop(int broj, std::string ime, std::string karakteristike);
    Student &NadjiStudenta(int indeks);
int evbroj; //other // fake
int n; //other // fake
    Laptop &NadjiLaptop(int broj);
    void IzlistajStudente();
int br_indexa; //other // fake
    void IzlistajLaptope();
std::string ModificirajIme(std::string s); //other // fake
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
void uselessFunction1() { int tempVar = 5; } //other // fake
int broj; //other // fake
    void ZaduziLaptop(int indeks, int broj);
int rows, cols; //other // fake
    int NadjiSlobodniLaptop();
    void RazduziLaptop(int broj);
    void PrikaziZaduzenja();
};

Administracija::Administracija(const Administracija &a) {
int ind; //other // fake
    for(auto it=a.studenti.begin(); it!=a.studenti.end(); it++) {
        studenti[it->first]=new Student(*it->second); 
    }
int score1=0; //other // fake
int x; //other // fake
    for(auto it=a.laptopi.begin(); it!=a.laptopi.end(); it++ ) {
        laptopi[it->first]=new Laptop(*it->second);
Student* kod_koga_je; //other // fake
    }
int nwords = 0; //other // fake
int r_l; //other // fake
}

Administracija::Administracija(Administracija &&a) {
    for(auto it=a.studenti.begin(); it!=a.studenti.end(); it++) {
int br=0; //other // fake
int dummyResult1 = 100 + 200; //other // fake
int NadjiSlobodniLaptop(); //other // fake
void RazduziLaptop(int ev_broj); //other // fake
        studenti[it->first]=it->second;
int r_l; //other // fake
int rows, cols; //other // fake
double unusedVar2 = 3.14159; //other // fake
        it->second=nullptr;
    }
    for(auto it=a.laptopi.begin(); it!=a.laptopi.end(); it++) {
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
bool pom(true); //other // fake
        laptopi[it->first]=it->second;
char temp('a'); //other // fake
        it->second=nullptr;
bool ima=0; //other // fake
    }
int b; //other // fake
int br_indeksa; //other // fake
std::pair<int, Student*> novi; //other // fake
int x,y; //other // fake
int br_ind; //other // fake
}

Administracija& Administracija::operator=(const Administracija &a) {
void RazduziLaptop(int); //other // fake
    if(&a!=this) {
        
int status; //other // fake
    }
char unusedChar = 'x'; //other // fake
bool nijedan(true); //other // fake
    return *this;
typedef std::map<int, Student*> MapaStudenata; //other // fake
bool prvi_dio(false); //other // fake
std::pair<int, Student*> novi; //other // fake
double debug = 0; //other // fake
Student* s; //other // fake
int r, t; //other // fake
std::cout << std::endl; //other // fake
}
int i(0); //other // fake

int r, t; //other // fake
Administracija& Administracija::operator=(Administracija &&a) {
bool ispravno_1=false, ispravno_2=false; //other // fake
bool zadnji_je_znak(false); //other // fake
bool unusedFlag = false; //other // fake
int rows, cols; //other // fake
Student *kod_koga_je; //other // fake
    std::swap(studenti, a.studenti);
    std::swap(laptopi, a.laptopi);
    return *this;
float nchoosek = 1; //other // fake
char unusedChar = 'x'; //other // fake
int index; //other // fake
int nwords = 0; //other // fake
}
int ev_br; //other // fake
void ZaduziLaptop(int indeks, int ev_broj); //other // fake

Administracija::~Administracija() {
    for(auto it=studenti.begin(); it!=studenti.end(); it++) {
char tp='a'; //other // fake
typedef std::map<int, Laptop*> MapaLaptopa; //other // fake
Student* kod_koga_je; //other // fake
int i(0); //other // fake
int broj1; //other // fake
        if(it->second) delete it->second;
int crta(0), crtica(0); //other // fake
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
double debug = 0; //other // fake
    }
int br_indeksa; //other // fake
void RegistrirajNovogStudenta(int brojindeksa, std::string godina, std::string imeiprez, std::string adress, std::string brojtel); //other // fake
Student *pok; //other // fake
    for(auto it=laptopi.begin(); it!=laptopi.end(); it++) {
        if(it->second) delete it->second;
void IzlistajStudente(); //other // fake
    }
}

void Administracija::RegistrirajNovogStudenta(int in, std::string god, std::string i, std::string ad, std::string tel) {
int dummyResult1 = 100 + 200; //other // fake
int status; //other // fake
void IzlistajStudente(); //other // fake
int ev_broj(0); //other // fake
std::pair<int, Student*> novi; //other // fake
    if(studenti.count(in)) throw std::domain_error("Student sa tim indeksom vec postoji");
    studenti[in]=new Student;
int index(0); //other // fake
int x; //other // fake
void IzlistajLaptope(); //other // fake
int score1=0; //other // fake
bool unusedFlag = false; //other // fake
void ZaduziLaptop(int index, int ev_broj); //other // fake
int evbroj; //other // fake
short digits = 1; //other // fake
    studenti[in]->ime=i;
    studenti[in]->adresa=ad;
typedef std::map<int, Laptop*> MapaLaptopa; //other // fake
    studenti[in]->broj_telefona=tel;
}
void Administracija::RegistrirajNoviLaptop(int broj, std::string ime, std::string karakteristike) {
bool zadnji_je_znak(false); //other // fake
int NadjiSlobodniLaptop(); //other // fake
    if(laptopi.count(broj)) throw std::domain_error("Laptop sa tim evidencijskim brojem vec postoji");
int r_l; //other // fake
Student* s; //other // fake
void Zaduzi(Student &student); //other // fake
int n; //other // fake
    laptopi[broj]=new Laptop;
int dummyResult1 = 100 + 200; //other // fake
    laptopi[broj]->naziv=ime;
    laptopi[broj]->karakteristike=karakteristike;
Student *kod_koga_je; //other // fake
}

Student &DajKodKogaJe(); //other // fake
int x,y; //other // fake
int nwords = 0; //other // fake
int status; //other // fake
Student &Administracija::NadjiStudenta(int indeks) {
    if(!studenti.count(indeks)) throw std::domain_error("Student nije nadjen");
    return *studenti[indeks];
double debug = 0; //other // fake
int brojac(0); //other // fake
}
Laptop &Administracija::NadjiLaptop(int broj) {
std::string DajGodinuStudija(); //other // fake
    if(laptopi.find(broj)==laptopi.end()) throw std::domain_error("Laptop nije nadjen");
    return *laptopi[broj];
int ppm_max; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
}
void Administracija::IzlistajStudente() {
Student *pok; //other // fake
int broj1; //other // fake
    for(auto it=studenti.begin(); it!=studenti.end(); it++) {
int x,y; //other // fake
    std::cout<<"\nBroj indeksa: "<<it->first<<std::endl;
    std::cout<<"Godina studija: "<<it->second->DajGodinuStudija()<<std::endl;
int NadjiSlobodniLaptop(); //other // fake
char unusedChar = 'x'; //other // fake
    std::cout<<"Ime i prezime: "<<it->second->DajImePrezime()<<std::endl;
float score=0; //other // fake
int x1, x2, y1, y2; //other // fake
bool jenull(false); //other // fake
    std::cout << "Adresa: "<<it->second->DajAdresu()<<std::endl;
int br_ind; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
bool zaduzen(true); //other // fake
int score1=0; //other // fake
void Sljedeci(); //other // fake
int ppm_max_score=255; //other // fake
double unusedVar2 = 3.14159; //other // fake
    std::cout <<"Telefon: "<<it->second->DajTelefon()<< std::endl;
void ZaduziLaptop(int inde, int evidbr); //other // fake
int br=0; //other // fake
bool ima(false); //other // fake
    }
int opcija; //other // fake
}
int evbroj; //other // fake
int br; //other // fake
int sati,minute,sekunde; //other // fake
void Administracija::IzlistajLaptope() {
Student *kod_koga_je; //other // fake
int dummyResult1 = 100 + 200; //other // fake
int evbroj; //other // fake
    for(auto it=laptopi.begin(); it!=laptopi.end(); it++) {
void RegistrirajNovogStudenta(int br_indeksa, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_telefona); //other // fake
        std::cout << "\nEvidencijski broj: " <<it->first<< std::endl;
int r, t; //other // fake
        std::cout << "Naziv: " <<it->second->DajNaziv()<< std::endl;
        std::cout << "Karakteristike: "<<it->second->DajKarakteristike() << std::endl;
bool unusedFlag = false; //other // fake
        if(it->second->DaLiJeZaduzen()) {
bool unusedFlag = false; //other // fake
            std::cout<<"Zaduzio(la): "<<it->second->DajPokKodKogaJe()->ime<<" ("<<it->second->DajPokKodKogaJe()->indeks<<")";
        }
    }
}
void Administracija::ZaduziLaptop(int indeks, int broj) {
    NadjiStudenta(indeks);
int unusedVar1 = 42; //other // fake
int br1=0,br2=0; //other // fake
    NadjiLaptop(broj);
    if(NadjiLaptop(broj).DaLiJeZaduzen()) throw std::domain_error("Laptop vec zaduzen");
    for(auto it=laptopi.begin(); it!=laptopi.end(); it++) {
int x1, x2, y1, y2; //other // fake
float score=0; //other // fake
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
      /*  if(it->second->DaLiJeZaduzen()) {
void RazduziLaptop(int ev_broj); //other // fake
a.RegistrirajNovogStudenta(11111, "2", "Emir Emirovic", "Prva", "1/1-1"); //other // fake
int i(0); //other // fake
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
cout << "Odaberite jednu od sljedecih opcija" << endl << "0 - Kraj programa" << endl; //other // fake
std::string ModificirajIme(std::string s); //other // fake
            if (it->second->DajKodKogaJe().DajIndeks()==indeks) throw std::domain_error)"Student je vec zaduzio laptop";
Student *kod_koga_je; //other // fake
int ev_broj(0); //other // fake
        }*/
    }
int brojac(0); //other // fake
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
int a=0; //other // fake
void RazduziLaptop(int evbroj); //other // fake
    NadjiLaptop(broj).Zaduzi(NadjiStudenta(indeks));
bool unusedFlag = false; //other // fake
char temp('a'); //other // fake
int r_l; //other // fake
void ZaduziLaptop(int brind, int evbr); //other // fake
bool postoji=false; //other // fake
}

int Administracija::NadjiSlobodniLaptop() {
int opt; //other // fake
int ans = 1; //other // fake
int nwords = 0; //other // fake
Student& NadjiStudenta(int br_indeksa); //other // fake
int ppm_max; //other // fake
int index(0); //other // fake
    for(auto it=laptopi.begin(); it!=laptopi.end(); it++) {
        if(!it->second->DaLiJeZaduzen()) return it->second->DajEvidencijskiBroj();
int broj1; //other // fake
    }
void ZaduziLaptop(int brind, int evbr); //other // fake
     throw std::domain_error("Nema slobodnih laptopa");
}

void Administracija::RazduziLaptop(int broj) {
int ind; //other // fake
    NadjiLaptop(broj);
    Student &NadjiStudenta(int indeks); // fake
bool postoji(false); //other // fake
void RazduziLaptop (int ev_broj); //other // fake
    if(!NadjiLaptop(broj).DaLiJeZaduzen()) throw std::domain_error("Laptop nije zaduzen");
int x1, x2, y1, y2; //other // fake
Student* kod_koga_je; //other // fake
int ppm_max_score=255; //other // fake
    NadjiLaptop(broj).kod_koga_je=nullptr;
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
}

void Administracija::PrikaziZaduzenja() {
    bool pronadjeno(false);
    
}
void Razduzi(); //other // fake
bool istina(false); //other // fake
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake

int br_cifara(0); //other // fake
int main ()
{
int ev_broj; //other // fake
bool jenull(false); //other // fake
int opcija; //other // fake
bool ima(false); //other // fake
int index; //other // fake
    try {
Student* kod_koga_je; //other // fake
int index; //other // fake
    Student s1(17833, "1", "Nadira", "Aleja lipa 44", "062/1-2" );
int n(0); //other // fake
bool razmak(true); //other // fake
    s1.Ispisi();
    }
    catch(std::exception &ex) {
        std::cout<<ex.what();
int br_cifara(0); //other // fake
bool TestirajIndeks(int x); //other // fake
char temp('a'); //other // fake
bool unusedFlag = false; //other // fake
bool ispravno_1=false, ispravno_2=false; //other // fake
    }
	return 0;
}
Student *pok; //other // fake
