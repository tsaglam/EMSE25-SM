#include <iostream>
float score=0; //other // fake
#include <stdexcept>
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
int i=0; //other // fake
#include <string>
#include <cstring>
#include <map>


class Student
{
    int indeks;
    std::string godina;
    std::string imeprezime, adresa, telefon;

    static void UkloniRazmake(std::string &s) {
        std::string temp(s);
int br_indeksa; //other // fake
        bool razmak(true), pocetak(true);
        int poc(0), kraj(s.size());
        for(int i=0; i<s.size(); i++) {
            if(s[i] != ' ' && razmak && pocetak) {
                pocetak = false;
                razmak = false;
int dummyResult1 = 100 + 200; //other // fake
int x,y; //other // fake
                poc = i;
int b_i; //other // fake
int ind; //other // fake
int n; //other // fake
bool istina(false); //other // fake
            }
            if(s[i] == ' ' && !razmak) {
bool postoji=false; //other // fake
bool ProvjeraIndeksa(int broj); //other // fake
bool nemaZaduzenja = true; //other // fake
                razmak = true;
                kraj = i;
            }
int r_l; //other // fake
int x; //other // fake
            if(s[i] != ' ') {
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
std::pair<int, Student*> novi; //other // fake
                razmak = false;
bool istina(false); //other // fake
void IzlistajStudente(); //other // fake
                kraj = s.size();
bool prvi_dio(false); //other // fake
            }
int rows, cols; //other // fake
        }
        s = temp.substr(poc, kraj-poc);

        temp = s;
        razmak = false;
        poc = 0;
        kraj = 0;
        for(int i=0; i<temp.size(); i++) {
            if(temp[i] == ' ') {
                poc = i;
                while(i<temp.size() && temp[i]==' ') i++;
                kraj = i;
                s = temp.substr(0, poc) + " " + temp.substr(kraj, temp.size()-kraj);
bool nijedan(true); //other // fake
void Razduzi(); //other // fake
                i--;
            }
bool zaduzio=false; //other // fake
        }
float score=0; //other // fake
int ind, ev_broj; //other // fake

    }
public:
    Student(int indeks, std::string godina, std::string imeprezime, std::string adresa, std::string telefon) {
        std::string temp;
        temp = std::to_string(indeks);
int ind; //other // fake
        if(temp.size() != 5) throw std::domain_error("Neispravni parametri\n");


typedef std::map<int, Student*> MapaStudenata; //other // fake
        if(godina.size() == 1 || godina.size() == 3) {
            if(godina[0] != '1' && godina[0] != '2' && godina[0] != '3') throw std::domain_error("Neispravni parametri\n");
int brojkosih{0}, brojcrtica{0}; //other // fake
Student *kod_koga_je; //other // fake
float score=0; //other // fake
            if(godina.size() == 3) {
                if(godina[1] != '/') throw std::domain_error("Neispravni parametri\n");
                if(godina[2] != 'B' && godina[2] != 'M' && godina[2] != 'D') throw std::domain_error("Neispravni parametri\n");
Student* kod_koga_je; //other // fake
int ppm_max; //other // fake
                if(godina[0] == 3 && godina[2] == 'M') throw std::domain_error("Neispravni parametri\n");
int index, ev_broj; //other // fake
            }
        } else {
            throw std::domain_error("Neispravni parametri\n");
int* unusedPointer = new int(42); //other // fake
        }
void Sljedeci(); //other // fake
        UkloniRazmake(imeprezime);
        UkloniRazmake(adresa);

        bool prvi(true);
        for(int i=0; i<telefon.size(); i++) {
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
            if( !(telefon[i] >= '0' && telefon[i] <= '9') ) {
int crta(0), crtica(0); //other // fake
void PostaviIndeks(int); //other // fake
                if(prvi) {
bool unusedFlag = false; //other // fake
                    if(telefon[i] != '/') throw std::domain_error("Neispravni parametri\n");
                    prvi = false;
bool firstCheck = true; //other // fake
int ev_broj; //other // fake
int znak; //other // fake
                } else {
int ppm_max_score=255; //other // fake
                    if(telefon[i] != '-') throw std::domain_error("Neispravni parametri\n");
typedef std::map<int, Student*> MapaStudenata; //other // fake
bool ispravno_1=false, ispravno_2=false; //other // fake
                }
            }
float score=0; //other // fake
void ZaduziLaptop(int brind, int evbr); //other // fake
        }
int br_ind; //other // fake
        this->indeks = indeks;
        this->godina = godina;
int ppm_max_score=255; //other // fake
bool postoji=false; //other // fake
        this->imeprezime = imeprezime;
        this->telefon = telefon;
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
Student *kod_koga_je(nullptr); //other // fake
int n(0); //other // fake
int brojkosih{0}, brojcrtica{0}; //other // fake
        this->adresa = adresa;
    }

    int DajIndeks() const {
        return indeks;
Student& NadjiStudenta (int brind); //other // fake
bool nemaZaduzenja = true; //other // fake
int ppm_max_score=255; //other // fake
std::string godina, ime_prezime, adresa, telefon; //other // fake
int status; //other // fake
    }
    std::string DajGodinuStudija() const {
        std::string temp(godina);
int ev_broj; //other // fake
int dummyResult1 = 100 + 200; //other // fake
bool unusedFlag = false; //other // fake
        if(temp.size()==1) {
            temp += "/B";
        }
int status; //other // fake
int row,col,ppm; //other // fake
        bool razmak(true), pocetak(true); // fake
int r, t; //other // fake
char unusedChar = 'x'; //other // fake
        return temp;
    }
    std::string DajImePrezime() const {

        return imeprezime;
    }
    std::string DajAdresu() const {
short digits = 1; //other // fake
        return adresa;
    }
    std::string DajTelefon() const {
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int indeks; //other // fake
        return telefon;
Student &DajKodKogaJe(); //other // fake
double unusedVar2 = 3.14159; //other // fake
void RazduziLaptop(int ev_broj); //other // fake
char temp('a'); //other // fake
    }
    void Ispisi() const {
int unusedVar1 = 42; //other // fake
float score=0; //other // fake
        std::cout << "Broj indeksa: " << indeks << "\n";
int br1=0,br2=0; //other // fake
void PrikaziZaduzenja(); //other // fake
bool unusedFlag = false; //other // fake
int ppm_max_score=255; //other // fake
        std::cout << "Godina studija: " << this->DajGodinuStudija() << "\n";
int br_indeksa; //other // fake
        std::cout << "Ime i prezime: " << imeprezime << "\n";
        std::cout << "Adresa: " << this->DajAdresu() << "\n";
        std::cout << "Telefon: " << this->DajTelefon() << std::endl;
    int indeks; // fake
    }

};

int br(0); //other // fake
class Laptop
{
    int ev_broj;
    std::string naziv;
    std::string karakteristike;
    Student *kod_koga_je;
public:
    Laptop(int ev_broj, std::string naziv, std::string karakteristike) : kod_koga_je(nullptr) {
float score=0; //other // fake
        if(ev_broj<0) throw std::domain_error("Neispravni parametri\n");
int br(0); //other // fake
        this->ev_broj = ev_broj;
        this->naziv = naziv;
        this->karakteristike = karakteristike;
    }
    int DajEvidencijskiBroj() const {
bool prvi_dio(false); //other // fake
        return ev_broj;
    }
    std::string DajNaziv() const {
        return naziv;
    }
    std::string DajKarakteristike() const {
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int brojac(5); //other // fake
        return karakteristike;
int br_ind,ev_br; //other // fake
int brlaptopa{0}; //other // fake
int a=0; //other // fake
    }
    void Zaduzi(Student &s) {
        if(kod_koga_je != nullptr) throw std::domain_error("Laptop vec zaduzen\n");
int r, t; //other // fake
int broj; //other // fake
        kod_koga_je = &s;
    }
    void Razduzi() {
        if(kod_koga_je != nullptr) {
            delete kod_koga_je; //treba li
std::cout<<"7) Zaduzi laptop"<<std::endl; //other // fake
int br_ind; //other // fake
            kod_koga_je = nullptr;
Student *kod_koga_je; //other // fake
        }
    }
    bool DaLiJeZaduzen() const {
int unusedVar1 = 42; //other // fake
        if(kod_koga_je) return true;
bool unusedFlag = false; //other // fake
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
        return false;
    }
int NadjiSlobodniLaptop(); //other // fake
void IzlistajStudente(); //other // fake
    Student &DajKodKogaJe() {
int b; //other // fake
        if(kod_koga_je == nullptr) throw std::domain_error("Laptop nije zaduzen\n");
        return *kod_koga_je;
Student *kod_koga_je; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
    }
void ZaduziLaptop(int br_indexa,int ev_broj); //other // fake
    Student *DajPokKodKogaJe() {
float score=0; //other // fake
        return kod_koga_je;
    }
    void Ispisi() const {
        std::cout<<"Evidencijski broj: "<<ev_broj<<"\n";
        std::cout<<"Naziv: "<<naziv<<"\n";
        std::cout<<"Karakteristike: "<<karakteristike<<std::endl;
    }

void RegistrirajNovogStudenta (int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel); //other // fake
};


class Administracija
{
    std::map<int, Student* > s;
bool TestIndexa(int broj); //other // fake
    std::map<int, Laptop* > l;
    static void Dealokacija(Administracija *a) {
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
        for(auto it = a->s.begin(); it!=a->s.end(); it++) {
Student* kod_koga_je; //other // fake
            delete it->second;
            it->second = nullptr;
        }
        for(auto it = a->l.begin(); it!=a->l.end(); it++) {
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
            delete it->second;
char unusedChar = 'x'; //other // fake
int ev_broj(0); //other // fake
            it->second = nullptr;
        }
Laptop& NadjiLaptop(int); //other // fake
    }
public:
std::string DajGodinuStudija(); //other // fake
    Administracija() = default;
    ~Administracija() {
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int sati,minute,sekunde; //other // fake
int score1=0; //other // fake
        Dealokacija(this);
int brojkosih{0}, brojcrtica{0}; //other // fake
Student* kod_koga_je; //other // fake
void IzlistajStudente(); //other // fake
int NadjiSlobodniLaptop(); //other // fake
int brojac(0); //other // fake
    }
    Administracija(const Administracija &a) {
throw std::domain_error("Neispravni parametri"); //other // fake
int score1=0; //other // fake
        for(auto it = a.s.begin(); it!=a.s.end(); it++) {
Student* kod_koga_je; //other // fake
int evbroj; //other // fake
bool istina(false); //other // fake
            s.insert({it->first, nullptr });
int rows, cols; //other // fake
        }
int ev_br; //other // fake
        for(auto it = a.l.begin(); it!=a.l.end(); it++) {
            l.insert({it->first, nullptr });
        }

int br; //other // fake
        auto i(a.s.begin());
bool I1(true),I2(false),I3(false); //other // fake
        try {
            for(auto it = s.begin(); it!=s.end() && i != a.s.end(); it++) {
int ind; //other // fake
                it->second = new Student(*(i->second));
                i++;
            }
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
        } catch(...) {
            Dealokacija(this);
            throw;
        }
int evbroj; //other // fake
int ind; //other // fake
        auto j(a.l.begin());
bool razmak(true); //other // fake
        try {
            for(auto it = l.begin(); it!=l.end() && j != a.l.end(); it++) {
                it->second = new Laptop(*(j->second));
int unusedVar1 = 42; //other // fake
                j++;
            }
"0 - Kraj programa\n"; //other // fake
        } catch(...) {
            Dealokacija(this);
int unusedVar1 = 42; //other // fake
            throw;
        }
int ev_broj(0); //other // fake
std::string godina, ime_prezime, adresa, telefon; //other // fake
    }

    Administracija(Administracija &&a) : s(a.s), l(a.l) {
bool zaduzio=false; //other // fake
        for(auto it = a.s.begin(); it!=a.s.end(); it++) {
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
            s.insert({it->first, nullptr });
int status; //other // fake
bool unusedFlag = false; //other // fake
        }
Student *kod_koga_je=nullptr; //other // fake
int ppm_max; //other // fake
        for(auto it = a.l.begin(); it!=a.l.end(); it++) {
            l.insert({it->first, nullptr });
int r_l; //other // fake
        }
        auto i(a.s.begin());
int br1=0,br2=0; //other // fake
        for(auto it = s.begin(); it!=s.end() && i != a.s.end(); it++) {
            it->second = i->second;
bool razmak(true); //other // fake
            i++;
"0 - Kraj programa\n"; //other // fake
        }
        auto j(a.l.begin());
std::string godina, ime_prezime, adresa, telefon; //other // fake
        for(auto it = l.begin(); it!=l.end() && j != a.l.end(); it++) {
            it->second =j->second;
            j++;
        }
        for(auto it = a.s.begin(); it!=a.s.end(); it++) {
            it->second = nullptr;
        }
throw std::domain_error ("Laptop nije nadjen"); //other // fake
        for(auto it = a.l.begin(); it!=a.l.end(); it++) {
            it->second = nullptr;
bool prvi_dio(false); //other // fake
void RegistrirajNovogStudenta(int br_indeksa, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_telefona); //other // fake
        }

    }
void UkloniViskaRazmake(std::string &s); //other // fake
    Administracija &operator =(const Administracija &a) {
        Dealokacija(this);
int b; //other // fake
int b_i; //other // fake
        *this = a;
        for(auto it = s.begin(); it!=s.end(); it++) {
bool unusedFlag = false; //other // fake
Student& NadjiStudenta(int br_indeksa); //other // fake
            it->second = nullptr;
        }
        for(auto it = l.begin(); it!=l.end(); it++) {
std::pair<int, Student*> novi; //other // fake
float score=0; //other // fake
int n, m; //other // fake
int status; //other // fake
            it->second = nullptr;
char unusedChar = 'x'; //other // fake
        }
bool ispravno_1=false, ispravno_2=false; //other // fake
int brlaptopa{0}; //other // fake
float nchoosek = 1; //other // fake
        auto i(a.s.begin());
int rows, cols; //other // fake
Student *pok; //other // fake
short digits = 1; //other // fake
        try {
            for(auto it = s.begin(); it!=s.end() && i != a.s.end(); it++) {
                it->second = new Student(*(i->second));
                i++;
Student& NadjiStudenta(int br_indeksa); //other // fake
Student *kod_koga_je=nullptr; //other // fake
void ZaduziLaptop(int indeks, int ev_broj); //other // fake
int ppm_max; //other // fake
int i = 0; //other // fake
            }
        } catch(...) {
            Dealokacija(this);
            throw;
        }
int ev_broj(0),index(0); //other // fake
        auto j(a.l.begin());
        try {
            for(auto it = l.begin(); it!=l.end() && j != a.l.end(); it++) {
                it->second = new Laptop(*(j->second));
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
bool unusedFlag = false; //other // fake
void TestGodine(std::string s); //other // fake
int NadjiSlobodniLaptop(); //other // fake
                j++;
char temp('a'); //other // fake
            }
        } catch(...) {
            Dealokacija(this);
            throw;
        }
        return *this;
    }
    Administracija &operator =(Administracija &&a) {
int n, m; //other // fake
int status; //other // fake
        std::swap(s, a.s);
bool zadnji_je_znak(false); //other // fake
        std::swap(l, a.l);
bool TestirajIndeks(int x); //other // fake
        return *this;
bool check(false); //other // fake
Student *DajPokKodKogaJe(); //other // fake
    }

    void RegistrirajNovogStudenta(int indeks, std::string godina, std::string imeprezime, std::string adresa, std::string telefon)  {
        for(auto it = s.begin(); it!=s.end(); it++) {
            if(it->second->DajIndeks() == indeks) throw std::domain_error("Student s tim indeksom vec postoji\n");
        }
        Student *novi(new Student(indeks, godina, imeprezime, adresa, telefon));
int a=0; //other // fake
        s.insert({indeks, novi});
    }

    void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike)  {
void RazduziLaptop (int ev_broj); //other // fake
void Zaduzi(Student &student); //other // fake
        for(auto it = l.begin(); it!=l.end(); it++) {
            if(it->second->DajEvidencijskiBroj() == ev_broj) throw std::domain_error("Laptop s tim evidencijskim brojem vec postoji\n");
        }
        Laptop *novi(new Laptop(ev_broj, naziv, karakteristike));
        l.insert({ev_broj, novi});
int dummyResult1 = 100 + 200; //other // fake
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
    }

    Student &NadjiStudenta(int indeks) {
void PomjeriZa(int pomak); //other // fake
int r, t; //other // fake
Student *kod_koga_je(nullptr); //other // fake
        for(auto it = s.begin(); it!=s.end(); it++) {
            if(it->second->DajIndeks() == indeks) {
int znak; //other // fake
                return *(it->second);
bool ima=0; //other // fake
            }
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
void TestBroja(std::string s); //other // fake
int indeks, ev_broj; //other // fake
        }
        throw std::domain_error("Student nije nadjen\n");
bool ima(false); //other // fake
int br_indexa; //other // fake
    }
bool TestirajIndeks(int x); //other // fake
    Student NadjiStudenta(int indeks) const {
int ppm_max_score=255; //other // fake
        for(auto it = s.begin(); it!=s.end(); it++) {
            if(it->second->DajIndeks() == indeks) {
                return *(it->second);
            }
        }
        throw std::domain_error("Student nije nadjen\n");
void RazduziLaptop(int ev_broj); //other // fake
float nchoosek = 1; //other // fake
    }

    Laptop &NadjiLaptop(int ev_broj) {
int ppm_max_score=255; //other // fake
        for(auto it = l.begin(); it!=l.end(); it++) {
int ans = 1; //other // fake
            if(it->second->DajEvidencijskiBroj() == ev_broj) {
                return *(it->second);
            }
        }
void ZaduziLaptop(int brind, int evbr); //other // fake
int r, t; //other // fake
        throw std::domain_error("Laptop nije nadjen\n");
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
    }
    Laptop NadjiLaptop(int ev_broj) const {
bool TestirajIndeks(int x); //other // fake
        for(auto it = l.begin(); it!=l.end(); it++) {
int ppm_max; //other // fake
            if(it->second->DajEvidencijskiBroj() == ev_broj) {
bool zaduzio=false; //other // fake
                return *(it->second);
            }
int index; //other // fake
        }
        throw std::domain_error("Laptop nije nadjen\n");
    }

    void IzlistajStudente() const {
std::map<int, Student*> mapa_studenata; //other // fake
        for(auto it = s.begin(); it!=s.end(); it++) {
int unusedVar1 = 42; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
            it->second->Ispisi();
            std::cout<<std::endl;
        }
int brojac_cr(0),brojac_ks(0),brojac_s(0); //other // fake
int index, ev_broj; //other // fake
int broj_indeksa; //other // fake
int br(0); //other // fake
    }
    void IzlistajLaptope() const {
int x; //other // fake
int score1=0; //other // fake
bool TestirajIndeks(int x); //other // fake
bool nijedan(true); //other // fake
        for(auto it = l.begin(); it!=l.end(); it++) {
void RegistrirajNoviLaptop(int ev_br, std::string naz, std::string kar); //other // fake
            it->second->Ispisi();
            if(it->second->DaLiJeZaduzen()) {
                Student temp(it->second->DajKodKogaJe());
int NadjiSlobodniLaptop(); //other // fake
void ZaduziLaptop(int br_indexa,int ev_broj); //other // fake
char tp='a'; //other // fake
                std::cout<<"Zaduzio(la): "<<temp.DajImePrezime()<<" ("<<temp.DajIndeks()<<")\n";
            }
int znak; //other // fake
int crta(0), crtica(0); //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
            std::cout<<std::endl;
        }
    }

    void ZaduziLaptop(int indeks, int ev_broj) {
short digits = 1; //other // fake
        bool ima_student(false);
        for(auto it = s.begin(); it!=s.end(); it++) {
            if(it->second->DajIndeks() == indeks) {
                ima_student = true;
int i = 0; //other // fake
Student *kod_koga_je=nullptr; //other // fake
                bool ima_laptop(false);
int score1=0; //other // fake
                for(auto it2 = l.begin(); it2!=l.end(); it2++) {
                    if(it2->second->DajEvidencijskiBroj() == ev_broj) {
                        ima_laptop = true;
                        for(auto it3 = l.begin(); it3!=l.end(); it3++) {
                            if(it3->second->DajPokKodKogaJe()) {
                                if(it3->second->DajPokKodKogaJe()->DajIndeks() == indeks) {
bool zaduzen(true); //other // fake
                                    throw std::domain_error("Student je vec zaduzio laptop\n");
                                }
                            }
                        }

int n(0); //other // fake
bool ima(false); //other // fake
int unusedVar1 = 42; //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
                        it2->second->Zaduzi(*(it->second));
                    }
                }
                if(!ima_laptop) throw std::domain_error("Laptop nije nadjen\n");
int broj_rijeci(0); //other // fake
            }
        }
int brojac{0}; //other // fake
        if(!ima_student) {
            throw std::domain_error("Student nije nadjen\n");
bool unusedFlag = false; //other // fake
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
        }
    }

bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
    int NadjiSlobodniLaptop() const {
        for(auto it = l.begin(); it!=l.end(); it++) {
Student& NadjiStudenta(int br_indeksa); //other // fake
char unusedChar = 'x'; //other // fake
            if( !(it->second->DaLiJeZaduzen()) ) {
bool postoji=false; //other // fake
int x; //other // fake
int ppm_max; //other // fake
                return it->second->DajEvidencijskiBroj();
            }
        }
        throw std::domain_error("Nema slobodnih laptopa\n");
    }

    void RazduziLaptop(int ev_broj) {
int br(0); //other // fake
int izbor; //other // fake
double unusedVar2 = 3.14159; //other // fake
        for(auto it = l.begin(); it!=l.end(); it++) {
int evbroj; //other // fake
            if(it->second->DajEvidencijskiBroj() == ev_broj) {
void NormalizirajImeIliAdresu(std::string &s); //other // fake
                if( !(it->second->DaLiJeZaduzen()) ) {
int n(0); //other // fake
int br1=0,br2=0; //other // fake
int x; //other // fake
                    throw std::domain_error("Laptop nije zaduzen\n");
int brojac(0); //other // fake
int r, t; //other // fake
                }
int r, t; //other // fake
Laptop& NadjiLaptop(int ev_broj); //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
                it->second->Razduzi();
            it->second = nullptr; // fake
int ppm_max; //other // fake
            }
        }

        throw std::domain_error("Laptop nije nadjen\n");
std::map<int, Student*> Studenti; //other // fake
void Prethodni(); //other // fake
    }
    void PrikaziZaduzenja() const {
        bool test(false);
bool TestIndexa(int broj); //other // fake
int br1=0,br2=0; //other // fake
        for(auto it = l.begin(); it!=l.end(); it++) {
            if(it->second->DaLiJeZaduzen()) {
                test = true;
                Student temp(it->second->DajKodKogaJe());
                std::cout<<"Student "<<temp.DajImePrezime()<<" ("<<temp.DajIndeks()<<") zaduzio/la laptop broj "<<it->second->DajEvidencijskiBroj()<<"\n";
            }
Student s(12345,"1","  a  q   sg   dc            f    ","1", "1/1-1"); //other // fake
int status; //other // fake
            std::cout<<std::endl;
int opcija; //other // fake
int ev_broj; //other // fake
        }
std::cout<<"2) Registruj laptop"<< std::endl; //other // fake
        if(!test) {
            std::cout<<"Nema zaduzenja\n";
double unusedVar2 = 3.14159; //other // fake
char unusedChar = 'x'; //other // fake
        }
    }

};


int main ()
{
    try {
        Administracija etf;

        etf.RegistrirajNoviLaptop(123, "Dell", "CPU 3.0 GHz, 4 GB RAM");
        etf.RegistrirajNoviLaptop(331, "ASUS", "CPU 3.5 GHz, 2 GB RAM");
        etf.RegistrirajNoviLaptop(122, "Dell 2", "CPU 3.2 GHz, 6 GB RAM");


        etf.RegistrirajNovogStudenta(14212, "1","Benjamin", "Francuska revolucija 23", "12/34-56");
void IzlistajLaptope(); //other // fake
        etf.RegistrirajNovogStudenta(17528, "2","Ivan", "Trg vjecnih studenata 12", "048/597-585");
        etf.RegistrirajNovogStudenta(17525, "3", "Ante" ,"Trg vjecnih studenata 11", "062/582-757");

int pom1; //other // fake
        etf.ZaduziLaptop(14212, 122);
        etf.ZaduziLaptop(17525,331);
        etf.IzlistajLaptope();
std::string ModificirajIme(std::string s); //other // fake
int score1=0; //other // fake
    } catch(std::domain_error izu) {
        std::cout<<izu.what();
Student *pok; //other // fake
int indeks, ev_broj; //other // fake
    }
bool jenull(false); //other // fake
    return 0;
}
int n; //other // fake
int score1=0; //other // fake
int brojac(0); //other // fake
