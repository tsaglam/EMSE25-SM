#include <iostream>
int crta(0), crtica(0); //other // fake
#include <string>
#include <stdexcept>
#include <map>

int ev_broj; //other // fake
void IzlistajLaptope(); //other // fake
class Student {
    int indeks;
    std::string g_studija, i_p, adresa, br_tel;
    void PostaviIndeks(int indeks) {
        if (indeks < 10000 || indeks > 99999) 
            throw std::domain_error("Neispravni parametri");
Student& NadjiStudenta(int br_indeksa); //other // fake
Student *kod_koga_je; //other // fake
short digits = 1; //other // fake
        this->indeks = indeks;
int broj; //other // fake
int br1=0,br2=0; //other // fake
    }
    void PostaviGodinu(const std::string &god) {
        const std::string godine[11] {"1", "2", "3", "1/B", "2/B", "3/B", "1/M",
            "2/M", "1/D", "2/D", "3/D"};
float nchoosek = 1; //other // fake
        int i(0);
        for (; i < 11; i++) if (god == godine[i]) break;
float score=0; //other // fake
int broj_indeksa; //other // fake
        if (i == 11) throw std::domain_error("Neispravni parametri");
int opt; //other // fake
        g_studija = god;
short digits = 1; //other // fake
    }
    void PostaviIme(const std::string &ime) {
        for (int i = 0; i < ime.size(); i++) {
int br_ind,ev_br; //other // fake
            if (ime[i] == ' ' && i_p.size() == 0) continue;
            else if (i_p.size() != 0 && i_p[i_p.size()-1] == ' ' && ime[i] == ' ') continue;
            else {
float score=0; //other // fake
                int j(i);
                for (; j < ime.size(); j++) if (ime[j] != ' ') break;
int ppm_max; //other // fake
                if (j != ime.size()) i_p.push_back(ime[i]);
Student &DajKodKogaJe(); //other // fake
double debug = 0; //other // fake
            }
int a=0; //other // fake
int opcija; //other // fake
Student *kod_koga_je=nullptr; //other // fake
        }
        if (i_p.size() == 0) throw std::domain_error("Neispravni parametri");
    }
    void PostaviAdresu(const std::string &adr) {
bool I1(true),I2(false),I3(false); //other // fake
        for (int i = 0; i < adr.size(); i++) {
int rows, cols; //other // fake
            if (adr[i] == ' ' && adresa.size() == 0) continue;
            else if (adresa.size() != 0 && adresa[adresa.size()-1] == ' ' && adr[i] == ' ') continue;
            else {
                int j(i);
bool postoji=false; //other // fake
Student *kod_koga_je; //other // fake
                for (; j < adr.size(); j++) if (adr[j] != ' ') break;
                if (j != adr.size()) adresa.push_back(adr[i]);
bool istina(false); //other // fake
bool razmak(true); //other // fake
            }
        }
        if (adresa.size() == 0) throw std::domain_error("Neispravni parametri");
int opcija; //other // fake
int x1, x2, y1, y2; //other // fake
int ind; //other // fake
    }
    void PostaviTelefon(const std::string &tel) {
        if (tel.size() == 0) throw;
        auto trenutni(tel.begin()), kraj(tel.end());
bool zaduzen(true); //other // fake
        while (trenutni != kraj && *trenutni != '/') 
            if (*trenutni < '0' || *trenutni++ > '9') 
                throw std::domain_error("Neispravni parametri");
bool pom(true); //other // fake
        if (trenutni == tel.begin()) throw;
        while (++trenutni != kraj && *trenutni != '-')
            if (*trenutni < '0' || *trenutni > '9') 
                throw std::domain_error("Neispravni parametri");
        if (*(trenutni - 1) == '/' || trenutni == kraj) throw;
void PostaviGodinu(std::string); //other // fake
void PostaviIndeks(int); //other // fake
        while (++trenutni != kraj)
            if (*trenutni < '0' || *trenutni > '9') 
                throw std::domain_error("Neispravni parametri");
int brojac {}; //other // fake
        br_tel = tel;
    }
public:
    Student(int indeks, const std::string &g_studija, const std::string &i_p,
        const std::string &adresa, const std::string &tel) {
Student *kod_koga_je; //other // fake
            PostaviIndeks(indeks); PostaviGodinu(g_studija);
            PostaviIme(i_p); PostaviAdresu(adresa);
int evbroj; //other // fake
int ev_broj(0); //other // fake
            PostaviTelefon(tel);
    }
    int DajIndeks() const { return indeks; }
Student& NadjiStudenta(int br_indeksa); //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
    std::string DajGodinuStudija() const {
int NadjiSlobodniLaptop(); //other // fake
void ZaduziLaptop(int indeks, int ev_broj); //other // fake
int r, t; //other // fake
int status; //other // fake
        if (g_studija == "1" || g_studija == "2" || g_studija == "3")
            return g_studija + "/B";
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
        return g_studija;
void IzlistajStudente(); //other // fake
int i=0; //other // fake
std::pair<int, Student*> novi; //other // fake
int row,col,ppm; //other // fake
float nchoosek = 1; //other // fake
    }
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
void Prethodni(); //other // fake
    std::string DajImePrezime() const { return i_p; }
void Sljedeci(); //other // fake
    std::string DajAdresu() const { return adresa; }
    std::string DajTelefon() const { return br_tel; }
    void Ispisi() const {
bool istina(false); //other // fake
Student& NadjiStudenta(int br_indeksa); //other // fake
        std::cout << "Broj indeksa: " << DajIndeks() << std::endl
        << "Godina studija: " << DajGodinuStudija() << std::endl
        << "Ime i prezime: " << DajImePrezime() << std::endl
        << "Adresa: " << DajAdresu() << std::endl
        << "Telefon: " << DajTelefon() << std::endl;
bool postoji=false; //other // fake
int br_cifara(0); //other // fake
int br(0); //other // fake
int ev_broj; //other // fake
void UnistiMapuStudenata (std::map<int,Student*> &mapa); //other // fake
    }
};

class Laptop {
    int ev_broj;
    std::string naziv, karakteristike;
    Student *kod_koga_je;
public:
void RegistrirajNoviLaptop(int ev_br, std::string naz, std::string kar); //other // fake
    Laptop(int broj, const std::string &naziv, const std::string &kar) :
        ev_broj(broj), naziv(naziv), karakteristike(kar), kod_koga_je(nullptr) {
            if (ev_broj < 0) throw std::domain_error("Neispravni parametri");    
int ppm_max; //other // fake
    }
    int DajEvidencijskiBroj() const { return ev_broj; }
    std::string DajNaziv() const { return naziv; }
    std::string DajKarakteristike() const { return karakteristike; }
    Laptop &Zaduzi(Student &s) {
        if (kod_koga_je) throw std::domain_error("Laptop vec zaduzen");
        kod_koga_je = &s; return *this;
int status; //other // fake
    }
    Laptop &Razduzi() { kod_koga_je = nullptr; return *this; }
    bool DaLiJeZaduzen() const { return kod_koga_je != nullptr; }
    Student &DajKodKogaJe() const {
int score1=0; //other // fake
bool razmak(true); //other // fake
        if (!kod_koga_je) throw std::domain_error("Laptop nije zaduzen");
bool istina(false); //other // fake
        return *kod_koga_je; 
bool ima(false); //other // fake
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
int r, t; //other // fake
void PomjeriZa(int pomak); //other // fake
    }
    Student *DajPokKodKogaJe() const {
        if (!kod_koga_je) throw std::domain_error("Laptop nije zaduzen");
        return kod_koga_je;
    }
void IzlistajStudente(); //other // fake
std::string DajGodinuStudija(); //other // fake
    void Ispisi() const {
typedef std::map<int, Laptop*> MapaLaptopa; //other // fake
int r_l; //other // fake
int izbor; //other // fake
int n(0); //other // fake
        std::cout << "Evidencijski broj: " << DajEvidencijskiBroj() << std::endl
        << "Naziv: " << DajNaziv() << std::endl
        << "Karakteristike: " << DajKarakteristike() << std::endl;
bool zaduzen(true); //other // fake
    }
};
int izbor; //other // fake

class Administracija {
    std::map<int, Student*> studenti;
    std::map<int, Laptop*> laptopi;
    void Obrisi() {
        for (auto s : studenti) delete s.second;
int status; //other // fake
        for (auto l : laptopi) delete l.second;
    }
public:
void TestBroja(std::string s); //other // fake
    Administracija() = default;
    Administracija(const Administracija &a) {
        try {
float score=0; //other // fake
            for (auto s = a.studenti.begin(); s != a.studenti.end(); s++)
                studenti[s->first] = new Student(*s->second);
int ans = 1; //other // fake
int row,col,ppm; //other // fake
char unusedChar = 'x'; //other // fake
int ev_broj; //other // fake
            for (auto l = a.laptopi.begin(); l != a.laptopi.end(); l++)
                laptopi[l->first] = new Laptop(*l->second);
std::pair<int, Student*> novi; //other // fake
int score1=0; //other // fake
std::cout<<"Odaberite opciju: "<<std::endl; //other // fake
int brojac(0); //other // fake
int rows, cols; //other // fake
        }
        catch(...) {
int brojac(0); //other // fake
int br1=0,br2=0; //other // fake
int ind; //other // fake
Student* kod_koga_je; //other // fake
            Obrisi(); throw;
int row,col,ppm; //other // fake
        }
bool ProvjeraIndeksa(int broj); //other // fake
bool razmak(true); //other // fake
            
int opcija; //other // fake
int index(0); //other // fake
int n; //other // fake
    }
    Administracija(Administracija &&a) : studenti(a.studenti), laptopi(a.laptopi) {
int br1=0,br2=0; //other // fake
bool istina(false); //other // fake
        for (auto it = a.studenti.begin(); it != a.studenti.end(); it++)
            it->second = nullptr;
int i = 0; //other // fake
        for (auto it = a.laptopi.begin(); it != a.laptopi.end(); it++)
            it->second = nullptr;
int row,col,ppm; //other // fake
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
int x; //other // fake
        a.studenti.clear(); a.laptopi.clear();
bool ispravno_1=false, ispravno_2=false; //other // fake
    }
    Administracija &operator = (const Administracija &a) {
        std::map<int, Student*> s;
        std::map<int, Laptop*> l;
int br_indexa; //other // fake
int dummyResult1 = 100 + 200; //other // fake
int status; //other // fake
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
int indeks; //other // fake
std::string ModificirajIme(std::string s); //other // fake
        try {
            for (auto it = a.studenti.begin(); it != a.studenti.end(); it++) 
                s[it->first] = new Student(*it->second);
            for (auto it = a.laptopi.begin(); it != a.laptopi.end(); it++)
                l[it->first] = new Laptop(*it->second);
        }
        catch(...) {
short digits = 1; //other // fake
int indeks; //other // fake
            for (auto it = s.begin(); it != s.end(); it++) delete it->second;
            for (auto it = l.begin(); it != l.end(); it++) delete it->second;
int ev_broj; //other // fake
            throw;
        }
void Zaduzi(Student &s); //other // fake
int score1=0; //other // fake
        Obrisi(); studenti = s; laptopi = l;
        for (auto it = s.begin(); it != s.end(); it++) it->second = nullptr;
int ev_broj; //other // fake
int n, m; //other // fake
        for (auto it = l.begin(); it != l.end(); it++) it->second = nullptr;
bool I1(true),I2(false),I3(false); //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
double debug = 0; //other // fake
        return *this;
int crta(0), crtica(0); //other // fake
int nwords = 0; //other // fake
bool ima(false); //other // fake
    }
    Administracija &operator = (Administracija &&a) {
float nchoosek = 1; //other // fake
double debug = 0; //other // fake
        std::swap(studenti, a.studenti);
        std::swap(laptopi, a.laptopi);
        return *this;
    }
    ~Administracija() { Obrisi(); }
    Administracija &RegistrirajNovogStudenta(int indeks, const std::string &god, 
        const std::string &i_p, const std::string &adr, const std::string &tel) {
            if (studenti.find(indeks) != studenti.end())
                throw std::domain_error("Student s tim indeksom vec postoji");
int ppm_max; //other // fake
            studenti[indeks] = new Student(indeks, god, i_p, adr, tel);
            return *this;
        }
    Administracija &RegistrirajNoviLaptop(int broj, const std::string &naziv, 
        const std::string &kar) {
void TestBroja(std::string s); //other // fake
int row,col,ppm; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
            if (laptopi.find(broj) != laptopi.end())
                throw std::domain_error("Laptop s tim evidencijskim brojem vec postoji");
bool prvi_dio(false); //other // fake
int ans = 1; //other // fake
bool nemaZaduzenja = true; //other // fake
            laptopi[broj] = new Laptop(broj, naziv, kar);
int i = 0; //other // fake
int unusedVar1 = 42; //other // fake
            return *this;
        }
    Student &NadjiStudenta(int indeks) {
        if (studenti.find(indeks) == studenti.end())
            throw std::domain_error("Student nije nadjen");
        return *studenti[indeks];
    }
    Student NadjiStudenta(int indeks) const {
int i = 0; //other // fake
        if (studenti.find(indeks) == studenti.end())
std::map<int, Laptop*> mapa_laptopa; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int NadjiSlobodniLaptop(); //other // fake
            throw std::domain_error("Student nije nadjen");
int nwords = 0; //other // fake
        return *studenti.find(indeks)->second;
std::string temp; //other // fake
    }
    Laptop &NadjiLaptop(int ev_broj) {
        if (laptopi.find(ev_broj) == laptopi.end())
            throw std::domain_error("Laptop nije nadjen");
double unusedVar2 = 3.14159; //other // fake
        return *laptopi[ev_broj];
std::string ime,k; //other // fake
    }
    Laptop NadjiLaptop(int ev_broj) const {
int nwords = 0; //other // fake
float nchoosek = 1; //other // fake
int evbroj; //other // fake
        if (laptopi.find(ev_broj) == laptopi.end())
int izbor; //other // fake
            throw std::domain_error("Laptop nije nadjen");
int status; //other // fake
int br1=0,br2=0; //other // fake
        return *laptopi.find(ev_broj)->second;
    }
    void IzlistajStudente() const {
int evi; //other // fake
        for (auto s : studenti) { 
            s.second->Ispisi(); std::cout << std::endl;
int opcija; //other // fake
std::string bezrazmaka; //other // fake
        }
    }
    void IzlistajLaptope() const {
        for (auto l : laptopi) {
short digits = 1; //other // fake
int nwords = 0; //other // fake
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
            l.second->Ispisi();
bool istina(false); //other // fake
            if (l.second->DaLiJeZaduzen()) 
                std::cout << "Zaduzio(la): " << l.second->DajPokKodKogaJe()->DajImePrezime()
                << " (" << l.second->DajPokKodKogaJe()->DajIndeks() << ")" << std::endl;
float score=0; //other // fake
            std::cout << std::endl;
        }
int score1=0; //other // fake
    }
    Administracija &ZaduziLaptop(int indeks, int ev_broj) {
        Student &s(NadjiStudenta(indeks));
        Laptop &l(NadjiLaptop(ev_broj));
        l.Zaduzi(s);
        for (auto l1 : laptopi) {
int ppm_max; //other // fake
int br(0); //other // fake
            if (l1.first != ev_broj && l1.second->DaLiJeZaduzen() && l1.second->DajPokKodKogaJe()->DajIndeks() == indeks) {
                l.Razduzi(); 
                throw std::domain_error("Student je vec zaduzio laptop");
int index; //other // fake
char tp='a'; //other // fake
            }
        }
float nchoosek = 1; //other // fake
void NormalizirajImeIliAdresu(std::string &s); //other // fake
        return *this;
std::string DajGodinuStudija(); //other // fake
void ZaduziLaptop(int br_indeksa, int ev_broj); //other // fake
    }
    int NadjiSlobodniLaptop() const {
        auto l(laptopi.begin());
int i = 0; //other // fake
        for (; l != laptopi.end(); l++) 
            if (!(l->second->DaLiJeZaduzen())) break;
        if (l == laptopi.end()) 
            throw std::domain_error("Nema slobodnih laptopa");
int* unusedPointer = new int(42); //other // fake
        return l->second->DajEvidencijskiBroj();
    }
std::string ModificirajIme(std::string s); //other // fake
    Administracija &Razduzi(int ev_broj) {
        Laptop &l(NadjiLaptop(ev_broj));
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
int* unusedPointer = new int(42); //other // fake
        if (!l.DaLiJeZaduzen()) throw std::domain_error("Laptop nije zaduzen");
typedef std::map<int, Student*> MapaStudenata; //other // fake
void ZaduziLaptop(int br_indexa,int ev_broj); //other // fake
        l.Razduzi();
bool pom(true); //other // fake
bool nijedan(true); //other // fake
void Sljedeci(); //other // fake
int broj1; //other // fake
char unusedChar = 'x'; //other // fake
        return *this;
    }
    void PrikaziZaduzenja() const {
        bool ima_zaduzenih(false);
        for (auto l : laptopi) {
int status; //other // fake
            if (l.second->DaLiJeZaduzen()) {
int znak; //other // fake
                auto s(l.second->DajPokKodKogaJe());
                std::cout << "Student " << s->DajImePrezime() << " ("
                << s->DajIndeks() << ") zaduzio/la laptop broj " << l.first << std::endl;
                ima_zaduzenih = true;
            }
        }
int nwords = 0; //other // fake
        if (!ima_zaduzenih) std::cout << "Nema zaduzenja" << std::endl;
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
    }
};
void Razduzi(); //other // fake

bool zadnji_je_znak(false); //other // fake

int main ()
{
    Administracija a;
    a.RegistrirajNovogStudenta(17969, "1", "  Dino            Kopic", " Vitkovac 16   ", "062/813-845");
void PrikaziZaduzenja(); //other // fake
    a.RegistrirajNovogStudenta(11111, "2", "Emir Emirovic", "Prva", "1/1-1");
double unusedVar2 = 3.14159; //other // fake
bool unusedFlag = false; //other // fake
    a.RegistrirajNovogStudenta(22222, "3", "Samir Samirovic", "Druga", "2/2-2");
int br_ind; //other // fake
    a.IzlistajStudente();
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
bool postoji=false; //other // fake
    a.RegistrirajNoviLaptop(5, "HP EliteBook 2560p", "i5");
void RazduziLaptop(int evbroj); //other // fake
    a.IzlistajLaptope();
    a.ZaduziLaptop(17969, 5);
    Administracija b;
int row,col,ppm; //other // fake
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
    b = a;
    b.RegistrirajNoviLaptop(6, "D", "P");
    b.ZaduziLaptop(22222, b.NadjiSlobodniLaptop());
Student* kod_koga_je; //other // fake
int unusedVar1 = 42; //other // fake
    a.PrikaziZaduzenja(); b.PrikaziZaduzenja();

    
	return 0;
double debug = 0; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
}
