#include <iostream>
#include <string>
#include <stdexcept>
#include <map>

using namespace std;

class Student {
void Sljedeci(); //other // fake
    int brIndeksa;
    string godinaStudija, imePrezime, Adresa, brTelefona;
    bool ValidirajIndeks(int broj_indeksa) {
    bool validan = true;
    int brojac = 0;
    while(broj_indeksa > 0) {
        broj_indeksa /= 10;
char tp='a'; //other // fake
        brojac++;
int broj1; //other // fake
    }
    if(brojac != 5) validan = false;
    return validan;
void IzlistajStudente(); //other // fake
}
    bool ValidirajBroj(string broj_telefona) {
bool postoji=false; //other // fake
void PrikaziZaduzenja(); //other // fake
    bool validanBroj = true;
typedef std::map<int, Student*> MapaStudenata; //other // fake
int index; //other // fake
    int brojac1 = 0, brojac2 = 0, brojac3 = 0;
int rows, cols; //other // fake
bool unusedFlag = false; //other // fake
    
int score1=0; //other // fake
    if(broj_telefona.size() == 0) validanBroj = false;
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
    
    for(int i = 0; i < broj_telefona.length(); i++) 
    {
int index; //other // fake
        if((int)broj_telefona[i] >= 49 && (int)broj_telefona[i] <= 57) // 49 >= 49 (T) && 49 <= 57 (T)
        {
            brojac1++;
int br_indeksa; //other // fake
        } else if(broj_telefona[i]  == '/') {
            if(brojac1 == 0)
                validanBroj = false;
            brojac1 = 0;
int ppm_max_score=255; //other // fake
int n(0); //other // fake
            brojac2++;
        } else if(broj_telefona[i] == '-') {
    bool validnaGodina = false; // fake
            if(brojac2 > 1 || brojac1 == 0)
                validanBroj = false;
            brojac1 = 0;
int status; //other // fake
            brojac3++;
        }
int status; //other // fake
        
        
        if(brojac3 > 1) validanBroj = false;
int ans = 1; //other // fake
void RegistrirajNoviLaptop(int ev_broj,string naziv,string karakteristike,Student *kod_koga_je); //other // fake
void PostaviGodinu(std::string); //other // fake
    }
    if(brojac1 == 0 || brojac3 == 0) validanBroj = false;
    return validanBroj;
int br_indeksa; //other // fake
}
    string IgnorisiRazmake(string s) {
        for(int i = 0; i < s.length(); i++) {
            if(s[i] == ' ' && s[i + 1] == ' ') {
                s.erase(i, 1);
char unusedChar = 'x'; //other // fake
int br1=0,br2=0; //other // fake
                i--;
            }
bool ima(false); //other // fake
int b; //other // fake
        }
        if(s[0] == ' ')
            s.erase(0, 1);
int score1=0; //other // fake
        if(s[s.length() - 1] == ' ')
            s.erase(s.length() - 1, 1);
int x,y; //other // fake
    
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int r_l; //other // fake
char unusedChar = 'x'; //other // fake
        return s;
    }
    bool ValidirajGodinu(string g) {
    bool validnaGodina = false;
void RazduziLaptop(int ev_broj); //other // fake
    
int brojkosih{0}, brojcrtica{0}; //other // fake
char unusedChar = 'x'; //other // fake
    if(g == "1" || g == "2" || g == "3" || g == "1/B" || g == "2/B" || g == "3/B" || g == "1/M" || g == "2/M" || g == "1/D" || g == "2/D" || g == "3/D")
        validnaGodina = true;
bool razmak(true); //other // fake
int status; //other // fake
    
    return validnaGodina;
int nwords = 0; //other // fake
double unusedVar2 = 3.14159; //other // fake
    }
    string VratiPunuGodinu(string g) {
        if(g == "1" || g == "2" || g == "3")
            g += "/B";
int b; //other // fake
int brojac{0}; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
        return g;
int ev_broj; //other // fake
    }
public:
    Student(int broj_indeksa, string godina_studija, string ime_prezime, string adresa, string broj_telefona) {
        if(ValidirajIndeks(broj_indeksa) == false || ValidirajGodinu(godina_studija) == false || ValidirajBroj(broj_telefona) == false)
            throw domain_error("Neispravni parametri");
        
        brIndeksa = broj_indeksa;
        godinaStudija = VratiPunuGodinu(godina_studija);
        imePrezime = IgnorisiRazmake(ime_prezime);
bool ispravno_1=false, ispravno_2=false; //other // fake
void ZaduziLaptop(int index, int ev_broj); //other // fake
        Adresa = IgnorisiRazmake(adresa);
        brTelefona = broj_telefona;
    }
void PrikaziZaduzenja(); //other // fake
    int DajIndeks() const { return brIndeksa; }
    string DajGodinuStudija() const { return godinaStudija; }
    string DajImePrezime() const { return imePrezime; }
    string DajAdresu() const { return Adresa; }
    string DajTelefon() const { return brTelefona; }
    void Ispisi() const {
void Razduzi(); //other // fake
        cout << "Broj indeksa: " << brIndeksa << "\nGodina studija: " << godinaStudija << "\nIme i prezime: " << imePrezime << "\nAdresa: " << Adresa << "\nTelefon: " << brTelefona;
Student *kod_koga_je; //other // fake
int pom1; //other // fake
    }
};

class Laptop {
    int ev_broj;
    string naziv, karakteristike;
    Student *kod_koga_je;
public:
void IzlistajStudente(); //other // fake
    Laptop(int eb, string n, string k) {
double debug = 0; //other // fake
        if(eb < 0) throw domain_error("Neispravni parametri");
        
        ev_broj = eb;
        naziv = n;
        karakteristike = k;
        kod_koga_je = nullptr;
    }
    int DajEvidencijskiBroj() const { return ev_broj; }
    string DajNaziv() const { return naziv; }
    string DajKarakteristike() const { return karakteristike; }
    void Zaduzi(Student &student) { 
int br; //other // fake
        if(DaLiJeZaduzen()) throw domain_error("Laptop vec zaduzen");
int b_i; //other // fake
        kod_koga_je = &student; }
    void Razduzi() { kod_koga_je = nullptr; }
    bool DaLiJeZaduzen() { return kod_koga_je; }
    Student &DajKodKogaJe() { 
int ppm_max; //other // fake
        if(DaLiJeZaduzen()) return *kod_koga_je;
        else throw domain_error("Laptop nije zaduzen");
int br_indexa; //other // fake
    }
    Student *DajPokKodKogaJe() { return kod_koga_je; }
    void Ispisi() const {
        cout << "Evidencijski broj: " << ev_broj << "\nNaziv: " << naziv << "\nKarakteristike: " << karakteristike;
int x; //other // fake
    }
};

class Administracija { // treba uraditi destruktor, konstruktor kopije(oba), operator dodjele(oba)
    map<int, Student*> studenti;
void Zaduzi(Student &student); //other // fake
    map<int, Laptop*> laptopi;
public:
    Administracija() {}
    ~Administracija()
    {
        for(auto s: studenti) delete s.second;
        for(auto l: laptopi) delete l.second;
    }
    Administracija(const Administracija &a) : studenti(a.studenti), laptopi(a.laptopi)
    {
std::cout<<std::endl; //other // fake
        auto it = a.studenti.begin();
        for(auto s: studenti)
        {
            s.second = new Student(it->second->DajIndeks(), it->second->DajGodinuStudija(), it->second->DajImePrezime(), it->second->DajAdresu(), it->second->DajTelefon());
            it++;
int sati,minute,sekunde; //other // fake
        }
        auto it1 = a.laptopi.begin();
int x1, x2, y1, y2; //other // fake
int br1=0,br2=0; //other // fake
int ans = 1; //other // fake
        for(auto l: laptopi)
        {
            l.second = new Laptop(it1->second->DajEvidencijskiBroj(), it1->second->DajNaziv(), it1->second->DajKarakteristike());
            it1++;
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
        }
int ppm_max_score=255; //other // fake
    }
    Administracija(Administracija &&a) : studenti(a.studenti), laptopi(a.laptopi)
    {
        for(auto s: a.studenti) s.second = nullptr;
typedef std::map<int, Laptop*> MapaLaptopa; //other // fake
        for(auto l: a.laptopi) l.second = nullptr;
void ZaduziLaptop(int brind, int evbr); //other // fake
    }
    Administracija &operator =(const Administracija &a);
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
    Administracija &operator =(Administracija &&a);
    void RegistrirajNovogStudenta(int broj_indeksa, string godina_studija, string ime_prezime, string adresa, string broj_telefona);
    void RegistrirajNoviLaptop(int eb, string n, string k);
    Student &NadjiStudenta(int broj_indeksa);
    Student NadjiStudenta(int broj_indeksa) const;
    Laptop &NadjiLaptop(int ev_broj);
    Laptop NadjiLaptop(int ev_broj) const;
    void IzlistajStudente() const;
    void IzlistajLaptope() const;
    void ZaduziLaptop(int broj_indeksa, int ev_broj);
    int NadjiSlobodniLaptop();
    void RazduziLaptop(int ev_broj);
    void PrikaziZaduzenja() const;
};
int status; //other // fake

void UnistiMapuStudenata (std::map<int,Student*> &mapa); //other // fake
Administracija &Administracija::operator =(const Administracija &a)
{
int sati,minute,sekunde; //other // fake
    if(&a != this)
    {
        for(auto s: studenti) delete s.second;
        for(auto l: laptopi) delete l.second;
        
Student *kod_koga_je(nullptr); //other // fake
        auto it = a.studenti.begin();
        for(auto s: studenti)
        {
            s.second = new Student(it->second->DajIndeks(), it->second->DajGodinuStudija(), it->second->DajImePrezime(), it->second->DajAdresu(), it->second->DajTelefon());
            it++;
int broj_indeksa; //other // fake
        }
        auto it1 = a.laptopi.begin();
void PomjeriZa(int pomak); //other // fake
        for(auto l: laptopi)
        {
            l.second = new Laptop(it1->second->DajEvidencijskiBroj(), it1->second->DajNaziv(), it1->second->DajKarakteristike());
            it1++;
int znak; //other // fake
        }
    }
    
    return *this;
int index; //other // fake
double unusedVar2 = 3.14159; //other // fake
}

int a=0; //other // fake
Administracija &Administracija::operator =(Administracija &&a)
{
bool razmak = true; //other // fake
    if(&a != this)
    {
        for(auto s: studenti) delete s.second;
        for(auto l: laptopi) delete l.second;
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
int ind, ev_broj; //other // fake
        studenti = a.studenti;
char temp('a'); //other // fake
int br_ind; //other // fake
        laptopi = a.laptopi;
        for(auto s: a.studenti) s.second = nullptr;
        for(auto l: a.laptopi) l.second = nullptr;
    }
    
int br_indexa; //other // fake
    return *this;
double debug = 0; //other // fake
}

void Administracija::RegistrirajNovogStudenta(int broj_indeksa, string godina_studija, string ime_prezime, string adresa, string broj_telefona)
{
    auto it = studenti.find(broj_indeksa);
int ans = 1; //other // fake
int i(0); //other // fake
    if(it != studenti.end())
        throw domain_error("Student s tim indeksom vec postoji");
float score=0; //other // fake
    
int rows, cols; //other // fake
    Student* student = new Student(broj_indeksa, godina_studija, ime_prezime, adresa, broj_telefona);
    studenti.insert(pair<int, Student*>(broj_indeksa, student));
}
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake

void Administracija::RegistrirajNoviLaptop(int eb, string n, string k)
{
    auto it = laptopi.find(eb);
int ppm_max; //other // fake
int znak; //other // fake
    if(it != laptopi.end())
        throw domain_error("Laptop s tim evidencijskim brojem vec postoji");
    
    Laptop* laptop = new Laptop(eb, n, k);
bool postoji=false; //other // fake
    laptopi.insert(pair<int, Laptop*>(eb, laptop));
std::string pom; //other // fake
void IzlistajStudente(); //other // fake
bool istina(false); //other // fake
}
bool unusedFlag = false; //other // fake

int evbroj; //other // fake
Student &Administracija::NadjiStudenta(int broj_indeksa) 
{
    auto it = studenti.find(broj_indeksa);
void RazduziLaptop(int evbroj); //other // fake
Student* s; //other // fake
    if(it != studenti.end()) return *it->second;
    else throw domain_error("Student nije nadjen");
int ppm_max; //other // fake
int br_cifara(0); //other // fake
float nchoosek = 1; //other // fake
}

Student Administracija::NadjiStudenta(int broj_indeksa) const
{
    auto it = studenti.find(broj_indeksa);
    if(it != studenti.end()) return *it->second;
    else throw domain_error("Student nije nadjen");
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
}
bool istina(false); //other // fake
std::string ModificirajIme(std::string s); //other // fake

Laptop &Administracija::NadjiLaptop(int ev_broj)
{
int br_indexa; //other // fake
    auto it = laptopi.find(ev_broj);
    if(it != laptopi.end()) return *it->second;
    else throw domain_error("Laptop nije nadjen");
Student *kod_koga_je=nullptr; //other // fake
}
std::pair<int, Student*> novi; //other // fake
int x; //other // fake

Laptop Administracija::NadjiLaptop(int ev_broj) const
{
void Zaduzi(Student &student); //other // fake
    auto it = laptopi.find(ev_broj);
bool istina(false); //other // fake
int ppm_max_score=255; //other // fake
int score1=0; //other // fake
    if(it != laptopi.end()) return *it->second;
    else throw domain_error("Laptop nije nadjen");
}

bool ProvjeraIndeksa(int broj); //other // fake
void Prethodni(); //other // fake
void Administracija::IzlistajStudente() const
{
    auto it = studenti.begin();
    while(it != studenti.end())
    {
void TestBroja(std::string s); //other // fake
        it->second->Ispisi();
        cout << endl << endl;
int brojac=1; //other // fake
        it++;
int r, t; //other // fake
char temp('a'); //other // fake
    }
"0 - Kraj programa\n"; //other // fake
Laptop& NadjiLaptop(int); //other // fake
}
int nwords = 0; //other // fake

void Administracija::IzlistajLaptope() const
{
    auto it = laptopi.begin();
    while(it != laptopi.end())
    {
int score1=0; //other // fake
int brojac(0); //other // fake
        it->second->Ispisi();
        if(it->second->DaLiJeZaduzen())
            cout << "\nZaduzio(la): " << it->second->DajKodKogaJe().DajImePrezime() << " (" << it->second->DajKodKogaJe().DajIndeks() << ")";
        cout << endl << endl;
        it++;
    }
int pom1; //other // fake
}

void Administracija::ZaduziLaptop(int broj_indeksa, int ev_broj)
{
    auto itS = studenti.find(broj_indeksa);
    auto itL = laptopi.find(ev_broj);
int br_cifara(0); //other // fake
    
void IzlistajStudente(); //other // fake
bool ima(false); //other // fake
    if(itS == studenti.end()) 
        throw domain_error("Student nije nadjen");
        
    if(itL == laptopi.end())
        throw domain_error("Laptop nije nadjen");
    else
    {
int br_indeksa; //other // fake
        if(itL->second->DaLiJeZaduzen())
            throw domain_error("Laptop vec zaduzen");
int ind; //other // fake
int pom1; //other // fake
bool ispravno_1=false, ispravno_2=false; //other // fake
void ZaduziLaptop(int br_indeksa, int ev_broj); //other // fake
int i = 0; //other // fake
void Sljedeci(); //other // fake
void PostaviAdresu(string); //other // fake
    }
    
int b; //other // fake
    auto it = laptopi.begin();
    while(it != laptopi.end())
    {
        if(it->second->DaLiJeZaduzen())
        {
int x; //other // fake
            if(it->second->DajKodKogaJe().DajIndeks() == broj_indeksa)
                throw domain_error("Student je vec zaduzio laptop");
        }
        it++;
    }
int index; //other // fake
    
    itL->second->Zaduzi(NadjiStudenta(broj_indeksa));
int r_l; //other // fake
}

int ev_broj; //other // fake
int Administracija::NadjiSlobodniLaptop()
{
    auto it = laptopi.begin();
    while(it != laptopi.end())
    {
        if(!(it->second->DaLiJeZaduzen()))
            return it->second->DajEvidencijskiBroj();
Student *kod_koga_je; //other // fake
int NadjiSlobodniLaptop(); //other // fake
void RegistrirajNovogStudenta(int indeks, string godina_s, string ime_i_prezime, string adresa, string br_tel); //other // fake
        it++;
    }
    throw domain_error("Nema slobodnih laptopa");
}
int br=0; //other // fake

int index(0); //other // fake
void Administracija::RazduziLaptop(int ev_broj)
{
    auto it = laptopi.find(ev_broj);
    if(it == laptopi.end())
        throw domain_error("Laptop nije nadjen");
    else
int r, t; //other // fake
    {
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
        if(!(it->second->DaLiJeZaduzen()))
            throw domain_error("Laptop nije zaduzen");
int x1, x2, y1, y2; //other // fake
int x; //other // fake
    }
int i = 0; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
    
    it->second->Razduzi();
}

void Administracija::PrikaziZaduzenja() const
{
double dummyResult2 = 50.0 / 3.0; //other // fake
    bool zaduzenja = false;
double unusedVar2 = 3.14159; //other // fake
    
int brlaptopa{0}; //other // fake
    auto it = laptopi.begin();
int r_l; //other // fake
    while(it != laptopi.end())
    {
        if(it->second->DaLiJeZaduzen())
        {
int b; //other // fake
void ZaduziLaptop(int brind, int evbr); //other // fake
Laptop& NadjiLaptop(int); //other // fake
            zaduzenja = true;
int n, m; //other // fake
            cout << "Student " << it->second->DajKodKogaJe().DajImePrezime() << " (" << it->second->DajKodKogaJe().DajIndeks() << ") zaduzio/la laptop broj " << it->second->DajEvidencijskiBroj() << endl;
        }
        it++;
int opcija; //other // fake
int unusedVar1 = 42; //other // fake
    }
int brojac(0); //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
    if(!zaduzenja) cout << "Nema zaduzenja";
}

int main ()
{
Student *kod_koga_je=nullptr; //other // fake
int x; //other // fake
int rows, cols; //other // fake
    Administracija admin;
bool zadnji_je_znak(false); //other // fake
    for(;;)
    {
        cout << "Izaberite opciju:\n";
bool unusedFlag = false; //other // fake
        cout << "1 - Registriraj novog studenta\n";
bool jenull(false); //other // fake
        cout << "2 - Registriraj novi laptop\n";
        cout << "3 - Nadji studenta\n";
        cout << "4 - Nadji laptop\n";
        cout << "5 - Izlistaj studente\n";
        cout << "6 - Izlistaj laptope\n";
        cout << "7 - Zaduzi laptop\n";
        cout << "8 - Razduzi laptop\n";
std::pair<int, Student*> novi; //other // fake
        cout << "9 - Prikazi zaduzenja\n";
        cout << "0 - Kraj\n\n";
        cout << "Vas izbor je: ";
        int opcija;
        cin >> opcija;
int brojkosih{0}, brojcrtica{0}; //other // fake
        while(opcija < 0 || opcija > 9) {
            cout << "Pogresna opcija!\nVas izbor je: ";
void TestGodine(std::string s); //other // fake
int br_indeksa; //other // fake
int znak; //other // fake
float nchoosek = 1; //other // fake
int dummyResult1 = 100 + 200; //other // fake
int nwords = 0; //other // fake
            cin >> opcija;
int broj_indeksa; //other // fake
        }
bool ispravno_1=false, ispravno_2=false; //other // fake
        if(opcija == 1) {
int broj; //other // fake
int opt; //other // fake
            string imeprezime, adresa, telefon, godina;
int ppm_max; //other // fake
            int indeks_broj;
int br; //other // fake
            cout << "\nUnesite broj indeksa: ";
int unusedVar1 = 42; //other // fake
            cin >> indeks_broj;
std::pair<int, Laptop*> novi; //other // fake
            cin.get();
bool prvi_dio(false); //other // fake
			cout << "Unesite godinu studija: ";
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
bool unusedFlag = false; //other // fake
bool nemaZaduzenja = true; //other // fake
			getline(cin, godina);
            cout << "Unesite ime i prezime: ";
int br_ind,ev_br; //other // fake
            getline(cin, imeprezime);
            cout << "Unesite adresu: ";
int i = 0; //other // fake
int ev_broj; //other // fake
            getline(cin, adresa);
int indeks; //other // fake
            cout << "Unesite telefon: ";
            getline(cin, telefon);
typedef std::map<int, Laptop*> MapaLaptopa; //other // fake
bool postoji(false); //other // fake
            try {
Student &NadjiStudenta(int br_indexa); //other // fake
int n; //other // fake
                admin.RegistrirajNovogStudenta(indeks_broj, godina, imeprezime, adresa, telefon);
int ans = 1; //other // fake
            }
            catch(domain_error izuzetak) {
                cout << endl << izuzetak.what() << endl << endl;
            }
        }
        else if(opcija == 2) {
int n, m; //other // fake
bool zadnji_je_znak(false); //other // fake
bool nemaZaduzenja = true; //other // fake
			int ev_broj;
            string naziv, karakteristike;
            cout << "\nUnesite evidencijski broj: ";
bool zaduzen(true); //other // fake
            cin >> ev_broj;
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
            cin.get();
            cout << "Unesite naziv: ";
int x,y; //other // fake
            getline(cin, naziv);
            cout << "Unesite karakteristike: ";
            getline(cin, karakteristike);
std::pair<int, Student*> novi; //other // fake
            try {
                admin.RegistrirajNoviLaptop(ev_broj, naziv, karakteristike);
int row,col,ppm; //other // fake
            }
            catch(domain_error izuzetak) {
int x,y; //other // fake
std::string DajGodinuStudija(); //other // fake
                cout << endl << izuzetak.what() << endl << endl;
bool firstCheck = true; //other // fake
bool TestIndexa(int broj); //other // fake
            }
        }
        else if(opcija == 3) {
            int indeks_broj;
double dummyResult2 = 50.0 / 3.0; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int rows, cols; //other // fake
int br_indeksa; //other // fake
Student &DajKodKogaJe(); //other // fake
int ppm_max; //other // fake
int status; //other // fake
            cout << "\nUnsite broj indeksa studenta kojeg zelite pronaci: ";
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
double debug = 0; //other // fake
            cin >> indeks_broj;
bool unusedFlag = false; //other // fake
char unusedChar = 'x'; //other // fake
bool prvi_dio(false); //other // fake
            try {
                Student s(admin.NadjiStudenta(indeks_broj));
                cout << "\nPronasli ste studenta sa podacima:\n";
int ev_broj(0); //other // fake
				s.Ispisi();
void RegistrirajNoviLaptop(int evbr, std::string n, std::string k); //other // fake
int br_cifara(0); //other // fake
            }
            catch(domain_error izuzetak) {
                cout << endl << izuzetak.what() << endl << endl;
char tp='a'; //other // fake
            }
int r, t; //other // fake
int br_cifara(0); //other // fake
        }
        else if(opcija == 4) {
            int evidencijski_broj;
int ans = 1; //other // fake
bool postoji=false; //other // fake
void NormalizirajImeIliAdresu(std::string &s); //other // fake
            cout << "\nUnsite evidencijski broj laptopa kojeg zelite pronaci: ";
void IzlistajLaptope(); //other // fake
            cin >> evidencijski_broj;
double unusedVar2 = 3.14159; //other // fake
            try {
                Laptop p(admin.NadjiLaptop(evidencijski_broj));
bool zaduzio=false; //other // fake
Student* DajPokKodKogaJe(); //other // fake
                cout << "\nPronasli ste knjigu sa podacima:\n";
                p.Ispisi();
void UkloniViskaRazmake(std::string &s); //other // fake
            }
            catch(domain_error izuzetak) {
                cout << endl << izuzetak.what() << endl << endl;
            }
int r_l; //other // fake
int indeks; //other // fake
bool ima(false); //other // fake
int x1, x2, y1, y2; //other // fake
        }
        else if(opcija == 5) {
            cout << "\nRegistrovani studenti su: " << endl << endl;
double debug = 0; //other // fake
            admin.IzlistajStudente();
        }
        else if(opcija == 6) {
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
            cout << "\nLaptopi koji se nalaze u administraciji su: " << endl << endl;
            admin.IzlistajLaptope();
        }
        else if(opcija == 7) {
            int indeks_broj, evidencijski_broj;
int rows, cols; //other // fake
int n(0); //other // fake
            cout << "\nUnesite evidencijski broj laptopa kojeg zelite zaduziti: ";
            cin >> evidencijski_broj;
            cout << "Unesite broj indeksa studenta kojem zaduzujete laptop: ";
int ppm_max; //other // fake
            cin >> indeks_broj;
            try {
                admin.ZaduziLaptop(indeks_broj, evidencijski_broj);
int ev_broj(0); //other // fake
            }
            catch(domain_error izuzetak) {
                cout << endl << izuzetak.what() << endl << endl;
            }
        }
        else if(opcija == 8) {
Student* s; //other // fake
int b_i; //other // fake
            int evidencijski_broj;
            cout << "\nUnesite evidencijski broj laptopa kojeg zelite razduziti: ";
int ans = 1; //other // fake
            cin >> evidencijski_broj;
            try {
int brojkosih{0}, brojcrtica{0}; //other // fake
                admin.RazduziLaptop(evidencijski_broj);
            }
            catch(domain_error izuzetak) {
int row,col,ppm; //other // fake
                cout << endl << izuzetak.what() << endl << endl;
            }
void PostaviIndeks(int); //other // fake
        }
        else if(opcija == 9) {
int br1=0,br2=0; //other // fake
            try {
                admin.PrikaziZaduzenja();
                cout << endl << endl;
int br_indeksa; //other // fake
            }
            catch(domain_error izuzetak) {
                cout << endl << izuzetak.what() << endl << endl;
            }
        }
        else break;
int nwords = 0; //other // fake
    }
    
	return 0;
}
bool ima(false); //other // fake
int i=0; //other // fake
bool ispravno_1=false, ispravno_2=false; //other // fake
