#include <iostream>
#include <string>
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
#include <stdexcept>
#include <map>
int r_l; //other // fake
float score=0; //other // fake
void PostaviIndeks(int); //other // fake
#include <algorithm>

int br_ind; //other // fake
int x,y; //other // fake
using namespace std;

class Student {
int r, t; //other // fake
    int index;
    string imePrezime;
double unusedVar2 = 3.14159; //other // fake
    string adresa;
char unusedChar = 'x'; //other // fake
std::map<int, Student*> mapa_studenata; //other // fake
    string telefon;
    string godinaStudija;
    static string DajBezExtraSpejsova(const string &input) {
        string vrati;
bool zadnji_je_znak(false); //other // fake
int nwords = 0; //other // fake
        unique_copy(input.begin(), input.end(), back_inserter<string>(vrati),[](char a, char b) {
string godina_studija; //other // fake
            return(a==' ' && b==' ');});
void ZaduziLaptop(int br_indexa,int ev_broj); //other // fake
int row,col,ppm; //other // fake
int b; //other // fake
int rows, cols; //other // fake
        if(vrati[0]==' ') vrati.erase(vrati.begin());
int br_ind; //other // fake
std::cout<<std::endl; //other // fake
int opcija; //other // fake
        return vrati;
    }
void ZaduziLaptop(int, int); //other // fake
    static bool ValidirajTelefon (string telefon) {
        if(telefon[0]<'0' or telefon[0]>'9') return false;
float score=0; //other // fake
std::getline (std::cin, telefon); //other // fake
        int i(0);
        while(i<telefon.length() and telefon[i]>='0' and telefon[i]<='9') i++;
double unusedVar2 = 3.14159; //other // fake
Student *kod_koga_je; //other // fake
int r, t; //other // fake
bool ProvjeraIndeksa(int broj); //other // fake
bool TestirajTelefon(std::string s); //other // fake
bool unusedFlag = false; //other // fake
int brojkosih{0}, brojcrtica{0}; //other // fake
int r_l; //other // fake
int br_indexa; //other // fake
        if(i==telefon.length() or telefon[i]!='/') return false;
        i++;
int* unusedPointer = new int(42); //other // fake
int b; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
double debug = 0; //other // fake
int ppm_max_score=255; //other // fake
        while(i<telefon.length() and telefon[i]>='0' and telefon[i]<='9') i++;
std::string ModificirajIme(std::string s); //other // fake
        if(i==telefon.length() and telefon[i]!='-') return false;
        i++;
void IzlistajLaptope(); //other // fake
        while(i<telefon.length() and telefon[i]>='0' and telefon[i]<='9') i++;
void PostaviGodinu(std::string); //other // fake
Student &NadjiStudenta(int br_indexa); //other // fake
int br1=0,br2=0; //other // fake
        if(i!=telefon.length()) return false;
        else return true;
    }
    public:
bool unusedFlag = false; //other // fake
int indeks; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
    Student(int index, string godinaStudija, string imePrezime, string adresa, string telefon) {
        if(index<10000 or index> 99999) throw domain_error("Neispravni parametri");
        else this->index=index;
Student &DajKodKogaJe(); //other // fake
        this->imePrezime=Student::DajBezExtraSpejsova(imePrezime);
        this->adresa=Student::DajBezExtraSpejsova(adresa);
        if(godinaStudija.length()==1) {
std::pair<int, Student*> novi; //other // fake
            if(godinaStudija[0]>='1' or godinaStudija[0]<='3') this->godinaStudija=godinaStudija;
            else throw domain_error("Neispravni parametri");
        }
        else if(godinaStudija.length()==3) {
            if(godinaStudija[0]<'1' or godinaStudija[0]>'3') throw domain_error("Neispravni parametri");
int nwords = 0; //other // fake
            if(godinaStudija[1]!='/') throw domain_error("Neispravni parametri");
            if(godinaStudija[2]!='B' and godinaStudija[2]!='M' and godinaStudija[2]!='D') throw domain_error("Neispravni parametri");
int ev_broj; //other // fake
            this->godinaStudija=godinaStudija;
        }
        else throw domain_error("Neispravni parametri");
        if(ValidirajTelefon(telefon)) this->telefon=telefon;
        else throw domain_error("Neispravni parametri");
    }
bool TestIndexa(int broj); //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
    int DajIndeks() const  {return index;}
    string DajGodinuStudija() const {
        if(godinaStudija.length()!=1) return godinaStudija;
        else return godinaStudija+"/B";
bool razmak(true); //other // fake
    }
void UkloniViskaRazmake(std::string &s); //other // fake
    string DajImePrezime() const {return imePrezime;}
    string DajAdresu() const {return adresa;}
void PrikaziZaduzenja(); //other // fake
void TestGodine(std::string s); //other // fake
    string DajTelefon() const {return telefon;}
    
    void Ispisi() const {
void RazduziLaptop(int evbroj); //other // fake
std::cout << "Unesite jednu od opcija: " << std::endl << "1 - Registriraj novi laptop" << std::endl << "2 - Registriraj novog studenta" << std::endl << "3 - Izlistaj laptope" << std::endl << "4 - Izlistaj studente" << std::endl << "5 - Nadji prvi slobodni laptop" << std::endl << "6 - Nadji laptop" << std::endl << "7 - Zaduzi laptop" << std::endl << "8 - Razduzi laptop" << std::endl << "9 - Prikazi sva zaduzenja" << std::endl << "10 - Kraj programa" << std::endl; //other // fake
int unusedVar1 = 42; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
        cout<<"Broj indeksa: "<<DajIndeks()<<endl;
        cout<<"Godina studija: "<<DajGodinuStudija()<<endl;
int brojac{0}; //other // fake
        cout<<"Ime i prezime: "<<DajImePrezime()<<endl;
int a=0; //other // fake
string karakteristike; //other // fake
int nwords = 0; //other // fake
double unusedVar2 = 3.14159; //other // fake
        cout<<"Adresa: "<<DajAdresu()<<endl;
        cout<<"Telefon: "<<DajTelefon()<<endl;
int opcija; //other // fake
    }
};
void UkloniViskaRazmake(std::string &s); //other // fake

class Laptop {
std:: string pomocni; //other // fake
    int ev_broj;
int ev_br; //other // fake
    string naziv;
    string karakteristike;
    Student* kod_koga_je;
    public:
int b; //other // fake
int evbroj; //other // fake
    Laptop (int ev, string name, string kar) {
        if(ev<0) throw domain_error("Neispravni parametri");
        ev_broj=ev;
int NadjiSlobodniLaptop(); //other // fake
        naziv=name;
        karakteristike=kar;
bool jenull(false); //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
        kod_koga_je=nullptr;
    }
void TestBroja(std::string s); //other // fake
double debug = 0; //other // fake
int uselessFunction2(int param) { return param * 2; } //other // fake
    int DajEvidencijskiBroj() const {return ev_broj;}
int br1=0,br2=0; //other // fake
    string DajNaziv() const {return naziv;}
    string DajKarakteristike() const {return karakteristike;}
    void Zaduzi(Student &s) {
bool razmak = true; //other // fake
int unusedVar1 = 42; //other // fake
        if(DaLiJeZaduzen()) throw domain_error("Laptop vec zaduzen");
        kod_koga_je=&s;
int ev_broj(0); //other // fake
int a=0; //other // fake
std::pair<int, Student*> novi; //other // fake
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
int status; //other // fake
    }
    void Razduzi() {
Student student (18248, "3", "    Dinno     Koluh   ", "  Semira Fraste 15  ", "142/545-6425"); //other // fake
if(kod_koga_je != nullptr) throw domain_error("Laptop vec zaduzen"); //other // fake
int broj_rijeci(0); //other // fake
        kod_koga_je=nullptr;
int brojac {}; //other // fake
char unusedChar = 'x'; //other // fake
int rows, cols; //other // fake
    }
    bool DaLiJeZaduzen() const {
        if(kod_koga_je==nullptr) return false;
        else return true;
int status; //other // fake
    }
    Student DajKodKogaJe() const {
        if(DaLiJeZaduzen()) return *kod_koga_je;
        else throw domain_error("Laptop nije zaduzen");
    }
    Student *DajPokKodKogaJe() const {return kod_koga_je;}
    void Ispisi() const {
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int ppm_max; //other // fake
throw std::domain_error ("Laptop nije nadjen"); //other // fake
char temp('a'); //other // fake
double debug = 0; //other // fake
        cout<<"Evidencijski broj: "<<DajEvidencijskiBroj()<<endl;
int sati,minute,sekunde; //other // fake
bool prvi_dio(false); //other // fake
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
        cout<<"Naziv: "<<DajNaziv()<<endl;
        cout<<"Karakteristike: "<<DajKarakteristike()<<endl; 
float nchoosek = 1; //other // fake
    }
};
int n; //other // fake

class Administracija {
    map<int,Student*> studenti;
    map<int,Laptop*> laptopi;
    public:
    Administracija() {}
int x; //other // fake
void PostaviGodinu(std::string); //other // fake
    Administracija &operator=(const Administracija &adm) {
int i=0; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
bool t(false); //other // fake
int ppm_max_score=255; //other // fake
int n(0); //other // fake
std::string naziv, karakteristike; //other // fake
void PrikaziZaduzenja(); //other // fake
int x1, x2, y1, y2; //other // fake
bool zadnji_je_znak(false); //other // fake
int ev_broj; //other // fake
int index; //other // fake
int broj_indeksa; //other // fake
        if(this!=&adm) {
            for(auto it=studenti.begin();it!=studenti.end();it++) delete it->second;
            for(auto it=laptopi.begin();it!=laptopi.end();it++) delete it->second;
            studenti=adm.studenti;
int ind; //other // fake
int br_ind; //other // fake
            laptopi=adm.laptopi;
int crta(0), crtica(0); //other // fake
bool istina(false); //other // fake
int i(0); //other // fake
            for(auto it=studenti.begin();it!=studenti.end();it++) it->second=nullptr;
cout<<"10-Zavrsi sa radom"<<std::endl; //other // fake
int n; //other // fake
bool zaduzen(true); //other // fake
int r_l; //other // fake
Laptop& NadjiLaptop(int evbr); //other // fake
Student* DajPokKodKogaJe(); //other // fake
void ZaduziLaptop(int indeks, int ev_broj); //other // fake
int NadjiSlobodniLaptop(); //other // fake
int br1=0,br2=0; //other // fake
short digits = 1; //other // fake
int index(0); //other // fake
Student *kod_koga_je{nullptr}; //other // fake
bool prvi_dio(false); //other // fake
int x; //other // fake
            for(auto it=laptopi.begin();it!=laptopi.end();it++) it->second=nullptr;
            try {
double unusedVar2 = 3.14159; //other // fake
                for(auto it=adm.studenti.begin();it!=adm.studenti.end();it++) studenti[it->first]=new Student(*(it->second));
                for(auto it=adm.laptopi.begin();it!=adm.laptopi.end();it++) laptopi[it->first]=new Laptop(*(it->second));
bool zaduzen(true); //other // fake
int r, t; //other // fake
std::cout<<"Unesite ime laptopa: "<<std::endl; //other // fake
i++; //other // fake
                
bool TestirajIndeks(int x); //other // fake
                for(auto it=adm.laptopi.begin();it!=adm.laptopi.end();it++) {
                    Student *kodKoga=laptopi[it->first]->DajPokKodKogaJe();
                    if(kodKoga!=nullptr) {
bool razmak = true; //other // fake
int row,col,ppm; //other // fake
std::string godina_studija; //other // fake
void IzlistajLaptope(); //other // fake
bool pom(true); //other // fake
                        laptopi[it->first]->Razduzi();
int crta(0), crtica(0); //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
                        laptopi[it->first]->Zaduzi(*studenti[kodKoga->DajIndeks()]);
int br_indexa; //other // fake
                    }
int ind; //other // fake
                }
            }
            catch(...) {
                for(auto it=adm.studenti.begin();it!=adm.studenti.end();it++) delete studenti[it->first];
int ind; //other // fake
                for(auto it=adm.laptopi.begin();it!=adm.laptopi.end();it++) delete laptopi[it->first];
double debug = 0; //other // fake
int b_i; //other // fake
int broj_indeksa; //other // fake
int r_l; //other // fake
int nwords = 0; //other // fake
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
            }
        }
Student* s; //other // fake
        return *this;
    }
int pom1; //other // fake
    Administracija (const Administracija &adm) {
        laptopi=adm.laptopi;
        for(auto it=studenti.begin();it!=studenti.end();it++) it->second=nullptr;
int score1=0; //other // fake
            for(auto it=laptopi.begin();it!=laptopi.end();it++) it->second=nullptr;
            studenti=adm.studenti;
            laptopi=adm.laptopi;
int dummyResult1 = 100 + 200; //other // fake
void Zaduzi(Student &student); //other // fake
int broj1; //other // fake
            for(auto it=studenti.begin();it!=studenti.end();it++) it->second=nullptr;
bool unusedFlag = false; //other // fake
            for(auto it=laptopi.begin();it!=laptopi.end();it++) it->second=nullptr;
            try {
int ppm_max_score=255; //other // fake
int status; //other // fake
bool istina(false); //other // fake
void PrikaziZaduzenja(); //other // fake
                for(auto it=adm.studenti.begin();it!=adm.studenti.end();it++) studenti[it->first]=new Student(*(it->second));
                for(auto it=adm.laptopi.begin();it!=adm.laptopi.end();it++) laptopi[it->first]=new Laptop(*(it->second));
bool unusedFlag = false; //other // fake
int ev_broj(0); //other // fake
                
bool nemaZaduzenja = true; //other // fake
                for(auto it=adm.laptopi.begin();it!=adm.laptopi.end();it++) {
float nchoosek = 1; //other // fake
int i(0); //other // fake
throw std::domain_error ("Neispravni parametri"); //other // fake
                    Student *kodKoga=laptopi[it->first]->DajPokKodKogaJe();
                    if(kodKoga!=nullptr) {
int NadjiSlobodniLaptop(); //other // fake
int ans = 1; //other // fake
short digits = 1; //other // fake
int ppm_max_score=255; //other // fake
                        laptopi[it->first]->Razduzi();
                        laptopi[it->first]->Zaduzi(*studenti[kodKoga->DajIndeks()]);
                    }
void IzlistajLaptope(); //other // fake
void RazduziLaptop(int ev_broj); //other // fake
                }
int indeks; //other // fake
void ZaduziLaptop(int brind, int evbr); //other // fake
int br_indexa; //other // fake
            }
            catch(...) {
float nchoosek = 1; //other // fake
                for(auto it=adm.studenti.begin();it!=adm.studenti.end();it++) delete studenti[it->first];
bool prvi_dio(false); //other // fake
int row,col,ppm; //other // fake
                for(auto it=adm.laptopi.begin();it!=adm.laptopi.end();it++) delete laptopi[it->first];
int br_indexa; //other // fake
int brojkosih{0}, brojcrtica{0}; //other // fake
            }
int index, ev_broj; //other // fake
    }
    Administracija (Administracija &&adm) {
        studenti=adm.studenti;
        laptopi=adm.laptopi;
        for(auto it=adm.studenti.begin();it!=adm.studenti.end();it++) it->second=nullptr;
        for(auto it=adm.laptopi.begin();it!=adm.laptopi.end();it++) it->second=nullptr;
int ppm_max; //other // fake
int indeks; //other // fake
Student &NadjiStudenta(int br_indexa); //other // fake
char temp('a'); //other // fake
int x; //other // fake
Student *kod_koga_je=nullptr; //other // fake
    }
    Administracija &operator=(Administracija &&adm) {
        if(this!=&adm) {
            for(auto it=studenti.begin();it!=studenti.end();it++) delete it->second;
            for(auto it=laptopi.begin();it!=laptopi.end();it++) delete it->second;
int rows, cols; //other // fake
int NadjiSlobodniLaptop(); //other // fake
int r, t; //other // fake
            studenti=adm.studenti;
            laptopi=adm.laptopi;
            for(auto it=adm.studenti.begin();it!=adm.studenti.end();it++) it->second=nullptr;
int x1, x2, y1, y2; //other // fake
            for(auto it=adm.laptopi.begin();it!=adm.laptopi.end();it++) it->second=nullptr;
int br(0); //other // fake
        }
        return *this;
    }
int score1=0; //other // fake
void PrikaziZaduzenja(); //other // fake
    ~Administracija() {
int score1=0; //other // fake
        for(auto it=studenti.begin();it!=studenti.end();it++) it->second;
int brlaptopa{0}; //other // fake
int ans = 1; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
void ZaduziLaptop(int brind, int evbr); //other // fake
        for(auto it=laptopi.begin();it!=laptopi.end();it++) it->second;
int row,col,ppm; //other // fake
int br(0); //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
int ev_broj; //other // fake
    }
double debug = 0; //other // fake
    void RegistrirajNovogStudenta(int index, string godinaStudija, string imePrezime, string adresa, string telefon) {
int nwords = 0; //other // fake
        if(studenti.count(index)==0) {
            studenti[index]=new Student(index,godinaStudija,imePrezime,adresa,telefon);
int index; //other // fake
        }
        else throw domain_error("Student s tim indeksom vec postoji");
    }
int row,col,ppm; //other // fake
    void RegistrirajNoviLaptop(int ev, string name, string kar) {
        if(laptopi.count(ev)==0) {
            laptopi[ev]=new Laptop(ev,name,kar);
int opcija; //other // fake
int br_indexa; //other // fake
void PrikaziZaduzenja(); //other // fake
throw std::domain_error("Laptop nije zaduzen"); //other // fake
std::string pomocni; //other // fake
        }
        else throw domain_error("Laptop s tim evidencijskim brojem vec postoji");
int br_indexa; //other // fake
    }
    Student &NadjiStudenta(int index) {
int NadjiSlobodniLaptop(); //other // fake
        if(studenti.count(index)!=0) return *studenti[index];
        else throw domain_error("Student nije nadjen");
void TestGodine(std::string s); //other // fake
int x1, x2, y1, y2; //other // fake
void Prethodni(); //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int ans = 1; //other // fake
    }
    Student NadjiStudenta(int index) const {
int br_indexa; //other // fake
        bool ima=false;
        for(auto it=studenti.begin();it!=studenti.end();it++) {
short digits = 1; //other // fake
bool t(false); //other // fake
            if(it->first==index) {
int sati,minute,sekunde; //other // fake
bool zadnji_je_znak(false); //other // fake
int ppm_max_score=255; //other // fake
bool postoji=false; //other // fake
void RegistrirajNovogStudenta(int br_indeksa, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_telefona); //other // fake
char tp='a'; //other // fake
int i(0); //other // fake
                ima=true;
std::cout<<std::endl; //other // fake
bool jenull(false); //other // fake
int row,col,ppm; //other // fake
Student* kod_koga_je; //other // fake
                return *(it->second);
            }
int ev_broj; //other // fake
        }
        if(!ima) throw domain_error("Student nije nadjen");
    }
double dummyResult2 = 50.0 / 3.0; //other // fake
    Laptop &NadjiLaptop(int ev) {
int ans = 1; //other // fake
        if(laptopi.count(ev)!=0) return *laptopi[ev];
        else throw domain_error("Laptop nije nadjen");
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
bool istina(false); //other // fake
Student *kod_koga_je; //other // fake
    }
    Laptop NadjiLaptop(int ev) const {
        bool ima=false;
int broj; //other // fake
cout << "9 - Nadji slobodni laptop" << endl << "10 - Prikazi zaduzenja" << endl; //other // fake
        string vrati; // fake
int ans = 1; //other // fake
throw domain_error("Nema slobodnih laptopa"); //other // fake
        for(auto it=laptopi.begin();it!=laptopi.end();it++) {
            if(it->first==ev) {
int ev_broj(0),index(0); //other // fake
bool t(false); //other // fake
                ima=true;
                return *(it->second);
            }
        }
int evbroj; //other // fake
        if(!ima) throw domain_error("Laptop nije nadjen");
    }
int* unusedPointer = new int(42); //other // fake
int ans = 1; //other // fake
int NadjiSlobodniLaptop(); //other // fake
    void IzlistajStudente() const {
int brojkosih{0}, brojcrtica{0}; //other // fake
Laptop& NadjiLaptop(int); //other // fake
        for(auto it=studenti.begin();it!=studenti.end();it++) {
int sati,minute,sekunde; //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
int ans = 1; //other // fake
int x1, x2, y1, y2; //other // fake
int row,col,ppm; //other // fake
            it->second->Ispisi();
            cout<<endl;
int opt; //other // fake
        }
    }
    void IzlistajLaptope() const {
        for(auto it=laptopi.begin();it!=laptopi.end();it++) {
int br_ind; //other // fake
            it->second->Ispisi();
std::map<int, Student*> mapa_studenti; //other // fake
void Sljedeci(); //other // fake
            Student *tmp=it->second->DajPokKodKogaJe();
            if(tmp!=nullptr) {
Laptop& NadjiLaptop(int ev_broj); //other // fake
int ppm_max; //other // fake
                cout<<"Zaduzio(la): "<<tmp->DajImePrezime()<<" ("<<tmp->DajIndeks()<<") \n";
            }
            cout<<endl;
double debug = 0; //other // fake
void NormalizirajImeIliAdresu(std::string &s); //other // fake
        }
auto it2(laptopi.begin()); //other // fake
bool prvi_dio(false); //other // fake
int n; //other // fake
std::string vrati; //other // fake
int r, t; //other // fake
    }
int nwords = 0; //other // fake
    void ZaduziLaptop(int index, int ev) {
int br_ind; //other // fake
        if(studenti.count(index)==0) throw domain_error("Student nije nadjen");
bool jenull(false); //other // fake
int NadjiSlobodniLaptop(); //other // fake
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
int opcija; //other // fake
        if(laptopi.count(ev)==0) throw domain_error("Laptop nije nadjen");
void PrikaziZaduzenja(); //other // fake
Student *kod_koga_je; //other // fake
        if(laptopi[ev]->DaLiJeZaduzen()==true) throw domain_error("Laptop vec zaduzen");
int opt; //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
int status; //other // fake
typedef std::map<int, Laptop*> MapaLaptopa; //other // fake
bool postoji=false; //other // fake
        Student *tmp=studenti[index];
        for(auto it=laptopi.begin();it!=laptopi.end();it++) {
            if(it->second->DajPokKodKogaJe()==tmp) throw domain_error("Student je vec zaduzio laptop");
        }
void PomjeriZa(int pomak); //other // fake
        laptopi[ev]->Zaduzi(*tmp);
    }
int dummyResult1 = 100 + 200; //other // fake
    int NadjiSlobodniLaptop() const {
        for(auto it=laptopi.begin();it!=laptopi.end();it++) {
            if(it->second->DajPokKodKogaJe()==nullptr) return it->first;
int brojac(0); //other // fake
double debug = 0; //other // fake
int ev_br; //other // fake
        }
void ZaduziLaptop(int brind, int evbr); //other // fake
int index; //other // fake
int score1=0; //other // fake
int ans = 1; //other // fake
Student &NadjiStudenta(int br_indexa); //other // fake
        throw domain_error("Nema slobodnih laptopa");
int izbor; //other // fake
int br_ind,ev_br; //other // fake
float score=0; //other // fake
    }
int evbroj; //other // fake
int brojac=1; //other // fake
int sati,minute,sekunde; //other // fake
int n; //other // fake
void uselessFunction1() { int tempVar = 5; } //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
float nchoosek = 1; //other // fake
int unusedVar1 = 42; //other // fake
bool ispravno_1=false, ispravno_2=false; //other // fake
    void RazduziLaptop(int ev) {
        if(laptopi.count(ev)==0) throw domain_error("Laptop nije nadjen");
        if(laptopi[ev]->DaLiJeZaduzen()==false) throw domain_error("Laptop nije zaduzen");
        else laptopi[ev]->Razduzi();
    }
    void PrikaziZaduzenja() const {
Student *kod_koga_je; //other // fake
double debug = 0; //other // fake
void Razduzi(); //other // fake
        bool imaZaduzenja=false;
int pom1; //other // fake
int ev_broj; //other // fake
        for(auto it=laptopi.begin();it!=laptopi.end();it++) {
cout << "Unesi godinu studija: "; //other // fake
            Student *kodKoga=it->second->DajPokKodKogaJe();
int ppm_max_score=255; //other // fake
bool unusedFlag = false; //other // fake
std::string ime_prezime; //other // fake
int dummyResult1 = 100 + 200; //other // fake
int brlaptopa{0}; //other // fake
            if(kodKoga!=nullptr) {
                imaZaduzenja=true;
                cout<<"Student "<<kodKoga->DajImePrezime()<<" ("<<kodKoga->DajIndeks()<<") zaduzio/la laptop broj"<<it->first<<endl;
char unusedChar = 'x'; //other // fake
float nchoosek = 1; //other // fake
Student *kod_koga_je=nullptr; //other // fake
int br_ind; //other // fake
int index; //other // fake
            }
float nchoosek = 1; //other // fake
int pom1; //other // fake
        }
Laptop& NadjiLaptop(int ev_broj); //other // fake
int evbroj, indeks; //other // fake
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
int br_ind; //other // fake
        if(imaZaduzenja==false) cout<<"Nema zaduzenja";
int i = 0; //other // fake
    }
double unusedVar2 = 3.14159; //other // fake
};
int main ()
{
bool unusedFlag = false; //other // fake
bool nijedan(true); //other // fake
	return 0;
int row,col,ppm; //other // fake
int x1, x2, y1, y2; //other // fake
int crta(0), crtica(0); //other // fake
int opt; //other // fake
int evi; //other // fake
int* unusedPointer = new int(42); //other // fake
}
int ev_br; //other // fake
int indeks; //other // fake
