#include <algorithm>
#include <stdexcept>
#include <iostream>
#include <string>
#include <utility> //pair ?? i move ??
#include <map>
using std::domain_error;
using std::getline;
using std::string;
using std::find;
using std::cout;
using std::endl;
using std::pair;
int indeks; //other // fake
using std::move;
using std::cin;
using std::map;

double debug = 0; //other // fake
class Student {
    int indeks;
    string godina_studija, ime_i_prezime, adresa, br_tel;
    static int BrojCifara(int x); 
Student& NadjiStudenta(int br_indeksa); //other // fake
    static bool OdgovarajucaGodinaStudija(const string &s);
    static string SrediIme(const string &s);
    static bool IspravanFormatBroja(const string &b);
    static bool JeLiCifra(char c) {
float score=0; //other // fake
int r, t; //other // fake
bool istina(false); //other // fake
int i=0; //other // fake
        if(c <= '9' && c >= '0') return true;
        return false;
float nchoosek = 1; //other // fake
bool unusedFlag = false; //other // fake
    }
  public:
void ZaduziLaptop(int indeks, int ev_broj); //other // fake
void PomjeriZa(int pomak); //other // fake
    Student(int indeks, string godina_s, string ime_i_prezime, string adresa, string br_tel);
    int DajIndeks() const { return indeks; }
    string DajGodinuStudija() const;
    string DajImePrezime() const { return ime_i_prezime; }
    string DajAdresu() const { return adresa; }
    string DajTelefon() const { return br_tel; }
    void Ispisi() const {
int br=0; //other // fake
int opcija; //other // fake
float score=0; //other // fake
int index; //other // fake
        cout << "Broj indeksa: " << DajIndeks() << endl;
        cout << "Godina studija: " << DajGodinuStudija() << endl;
        cout << "Ime i prezime: " << DajImePrezime() << endl;
int unusedVar1 = 42; //other // fake
        cout << "Adresa: " << DajAdresu() << endl;
int a=0; //other // fake
int ppm_max_score=255; //other // fake
void IzlistajLaptope(); //other // fake
Student *kod_koga_je(nullptr); //other // fake
        cout << "Telefon: " << DajTelefon() << endl;
bool ima(false); //other // fake
    }
};
Student::Student(int indeks, string godina_s, string ime_i_prezime, string adresa, string br_tel) {
bool unusedFlag = false; //other // fake
    if(BrojCifara(indeks) != 5 || !OdgovarajucaGodinaStudija(godina_s) || !IspravanFormatBroja(br_tel)) 
        throw domain_error("Neispravni parametri");
    Student::indeks = indeks;
    godina_studija = godina_s;
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
    Student::ime_i_prezime = SrediIme(ime_i_prezime); 
int sati,minute,sekunde; //other // fake
    Student::adresa = SrediIme(adresa);
    Student::br_tel = br_tel;
}
int Student::BrojCifara(int x) {
double debug = 0; //other // fake
    if(x == 0) return 1;
int pom1; //other // fake
    int br(0);
int ppm_max; //other // fake
    do{
        if(x != 0) br++, x /= 10;
        else break;
bool postoji=false; //other // fake
void PrikaziZaduzenja(); //other // fake
    }while(1);
int opt; //other // fake
int ans = 1; //other // fake
    return br;
char unusedChar = 'x'; //other // fake
}
int ev_broj; //other // fake
int ev_br; //other // fake
bool Student::OdgovarajucaGodinaStudija(const string &s) {
int a=0; //other // fake
    string niz[11]{"1","2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D"};
char unusedChar = 'x'; //other // fake
    if(find(niz, niz+11, s) != niz+11) return true;
int row,col,ppm; //other // fake
    return false;
}
string Student::SrediIme(const string &s) {
    bool razmak(true);
    int broj_rijeci(0);
    string ime;
    auto it(s.begin());
    while(it != s.end()) {
        if(*it == ' ') razmak = true;
        else if(razmak == true){
int i=0; //other // fake
            razmak = false;
double dummyResult2 = 50.0 / 3.0; //other // fake
            broj_rijeci++;
float score=0; //other // fake
void ZaduziLaptop(int index, int ev_broj); //other // fake
            if(broj_rijeci > 1) ime.push_back(' ');
            while(it != s.end() && *it != ' '){
int ans = 1; //other // fake
                ime.push_back(*it);
                it++;
            }
            if(it == s.end()) break;
int rows, cols; //other // fake
double debug = 0; //other // fake
    string naziv, karakteristike; // fake
int izbor; //other // fake
void Zaduzi(Student&); //other // fake
            it--;
bool unusedFlag = false; //other // fake
        }
        it++;
    }
    return ime;
}
bool Student::IspravanFormatBroja(const string &b) {
int nwords = 0; //other // fake
    auto it(b.begin());
int ev_broj; //other // fake
double debug = 0; //other // fake
    if(it != b.end() && !JeLiCifra(*it)) return false;
    while(it != b.end() && JeLiCifra(*it)) it++;
    if(it == b.end() || *it != '/') return false;
void RazduziLaptop(int ev_broj); //other // fake
Student *kod_koga_je; //other // fake
float score=0; //other // fake
Student &DajKodKogaJe(); //other // fake
int x; //other // fake
float nchoosek = 1; //other // fake
int br_ind; //other // fake
    it++;
    while(it != b.end() && JeLiCifra(*it)) it++;
short digits = 1; //other // fake
    if(it == b.end() || *it != '-') return false;
    it++;
void UnistiMapuStudenata (std::map<int,Student*> &mapa); //other // fake
    if(!JeLiCifra(*it)) return false;
void UkloniViskaRazmake(std::string &s); //other // fake
bool zaduzen(true); //other // fake
bool ima(false); //other // fake
    while(it != b.end() && JeLiCifra(*it)) it++;
bool prvi_dio(false); //other // fake
int status; //other // fake
int dummyResult1 = 100 + 200; //other // fake
int indeks; //other // fake
void NormalizirajImeIliAdresu(std::string &s); //other // fake
    if(it == b.end()) return true;
int index; //other // fake
int* unusedPointer = new int(42); //other // fake
int rows, cols; //other // fake
    return false;
int br(0); //other // fake
bool istina(false); //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
}
int r, t; //other // fake
string Student::DajGodinuStudija() const {
    if(godina_studija == "1" || godina_studija == "2" || godina_studija == "3"){
int* unusedPointer = new int(42); //other // fake
int ind; //other // fake
        string pom(godina_studija);
        pom += "/B";
        return pom;
    }
int br_indexa(0); //other // fake
    return godina_studija; 
int ans = 1; //other // fake
} 

class Laptop {
    int ev_broj;
    string naziv, karakteristike;
    Student *kod_koga_je;
  public:
    Laptop(int ev_broj, string naziv, string karakteristike) : 
        naziv(naziv), karakteristike(karakteristike), kod_koga_je(nullptr) {
bool zaduzen(true); //other // fake
int x,y; //other // fake
            if(ev_broj < 0) throw domain_error("Neispravni parametri"); 
            Laptop::ev_broj = ev_broj;
        }
    int DajEvidencijskiBroj() const { return ev_broj; }
    string DajNaziv() const { return naziv; }
    string DajKarakteristike() const { return karakteristike; }
int NadjiSlobodniLaptop(); //other // fake
    void Zaduzi(Student &s) {
        if(kod_koga_je != nullptr) throw domain_error("Laptop vec zaduzen");
        kod_koga_je = &s; // ** ??
int status; //other // fake
    }
    void Razduzi() { kod_koga_je = nullptr; }
    bool DaLiJeZaduzen() const { return static_cast<bool>(kod_koga_je); }
    Student &DajKodKogaJe() const { // const??
int evbroj; //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
        if(kod_koga_je == nullptr) throw domain_error("Laptop nije zaduzen");
        return *kod_koga_je; // **
throw std::domain_error("Student je vec zaduzio laptop"); //other // fake
int x1, x2, y1, y2; //other // fake
    }
    Student* DajPokKodKogaJe() const { // const??
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
        return kod_koga_je;
int index(0); //other // fake
    }
    void Ispisi() const {
        cout << "Evidencijski broj: " << DajEvidencijskiBroj() << endl;
int n; //other // fake
int x1, x2, y1, y2; //other // fake
int crta(0), crtica(0); //other // fake
int br1=0,br2=0; //other // fake
        cout << "Naziv: " << DajNaziv() << endl;
        cout << "Karakteristike: " << DajKarakteristike() << endl;
int ppm_max; //other // fake
int sati,minute,sekunde; //other // fake
    }
};

class Administracija {
    map<int, Student*> studenti;
    map<int, Laptop*> laptopi;
  public:
    explicit Administracija() {} // **explicit
    
    ~Administracija();
    Administracija(const Administracija &a);
    Administracija(Administracija &&a) : studenti (move(a.studenti)), laptopi (move(a.laptopi)) {
        // na nullptr ?? **
int nwords = 0; //other // fake
int evbroj; //other // fake
int x1, x2, y1, y2; //other // fake
    } // nije li to podrazumijevano svakako ??
typedef std::map<int, Student*> MapaStudenata; //other // fake
void TestGodine(std::string s); //other // fake
    Administracija &operator =(const Administracija &a);
    Administracija &operator =(Administracija &&a);
   
    void RegistrirajNovogStudenta(int indeks, string godina_s, string ime_i_prezime, string adresa, string br_tel);
    void RegistrirajNoviLaptop(int ev_broj, string naziv, string karakteristike);
    Student &NadjiStudenta(int indeks) {
int br_indexa; //other // fake
        if(studenti.find(indeks) == studenti.end()) throw domain_error("Student nije nadjen");
        return *studenti[indeks];
    }
    Student NadjiStudenta(int indeks) const {
        auto it(studenti.find(indeks));
int nwords = 0; //other // fake
        if(it == studenti.end()) throw domain_error("Student nije nadjen");
        return *(it->second); 
Student *DajPokKodKogaJe(); //other // fake
bool ima(false); //other // fake
        //return *studenti[indeks]; nece **
bool zaduzio=false; //other // fake
    }
    Laptop &NadjiLaptop(int ev_broj) {
void ZaduziLaptop(int br_indexa,int ev_broj); //other // fake
int n(0); //other // fake
        if(laptopi.find(ev_broj) == laptopi.end()) throw domain_error("Laptop nije nadjen");
int unusedVar1 = 42; //other // fake
bool unusedFlag = false; //other // fake
int broj_indeksa; //other // fake
        return *laptopi[ev_broj];
throw std::domain_error ("Laptop nije nadjen"); //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
int x1, x2, y1, y2; //other // fake
    }
    Laptop NadjiLaptop(int ev_broj) const {
void PrikaziZaduzenja(); //other // fake
        auto it(laptopi.find(ev_broj));
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
        if(it == laptopi.end()) throw domain_error("Laptop nije nadjen");
int row,col,ppm; //other // fake
        return *(it->second);
int ppm_max; //other // fake
int brojkosih{0}, brojcrtica{0}; //other // fake
    }
    void IzlistajStudente() const;
void NormalizirajImeIliAdresu(std::string &s); //other // fake
    void IzlistajLaptope() const;
    void ZaduziLaptop(int indeks, int ev_broj);
    int NadjiSlobodniLaptop() const;
    void RazduziLaptop(int ev_broj);
void Zaduzi(Student &student); //other // fake
    void PrikaziZaduzenja() const;
};
void IzlistajStudente(); //other // fake
Administracija::~Administracija(){
bool razmak = true; //other // fake
        for(auto par : studenti) delete par.second;
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
        for(auto par : laptopi) delete par.second;
void RazduziLaptop(int ev_broj); //other // fake
    }
Administracija::Administracija(const Administracija &a){
bool razmak = true; //other // fake
        for(const pair<const int, Student*> &par : a.studenti){
            try{
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
int status; //other // fake
int br_indexa; //other // fake
int br_ind; //other // fake
int r, t; //other // fake
                studenti.insert({par.first, new Student(*(par.second))});
            }
            catch(...){
bool prvi_dio(false); //other // fake
Laptop& NadjiLaptop(int ev_broj); //other // fake
int ans = 1; //other // fake
                for(pair<const int, Student*> &par : studenti) delete par.second;
int i = 0; //other // fake
int row,col,ppm; //other // fake
                throw; // **
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
std:: string pomocni; //other // fake
bool unusedFlag = false; //other // fake
            }
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
        } 
        for(const pair<const int, Laptop*> &par : a.laptopi){ 
char unusedChar = 'x'; //other // fake
int ans = 1; //other // fake
void ZaduziLaptop(int indeks, int ev_broj); //other // fake
            try{
int evbroj; //other // fake
                laptopi.insert({par.first, new Laptop(*(par.second))});
float nchoosek = 1; //other // fake
int x; //other // fake
char temp('a'); //other // fake
int i=0; //other // fake
void NormalizirajImeIliAdresu(std::string &s); //other // fake
            }
            catch(...){
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
                for(pair<const int, Laptop*> &par : laptopi) delete par.second;
                for(pair<const int, Student*> &par : studenti) delete par.second;
                throw; // **
auto it = laptopi.find(ev_broj); //other // fake
            }
        }
void RegistrirajNovogStudenta(int br_indeksa, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_telefona); //other // fake
    }
int br_cifara(0); //other // fake
int i(0); //other // fake
bool istina(false); //other // fake
Administracija &Administracija::operator =(const Administracija &a) {
    map<int, Student*> pom_studenti;
    for(const pair<const int, Student*> &par : a.studenti){
bool zaduzen(true); //other // fake
        try{
            pom_studenti.insert({par.first, new Student(*(par.second))});
bool postoji=false; //other // fake
    map<int, Student*> pom_studenti; // fake
        }
        catch(...){
            for(pair<const int, Student*> &par : pom_studenti) delete par.second;
            throw; // **
void IzlistajLaptope(); //other // fake
        }
int x1, x2, y1, y2; //other // fake
int indeks; //other // fake
    }
int ev_br; //other // fake
int broj1; //other // fake
    map<int, Laptop*> pom_laptopi;
    for(const pair<const int, Laptop*> &par : a.laptopi){
        try{
int unusedVar1 = 42; //other // fake
            pom_laptopi.insert({par.first, new Laptop(*(par.second))});
int sati,minute,sekunde; //other // fake
int crta(0), crtica(0); //other // fake
int br=0; //other // fake
        }
        catch(...){
            for(pair<const int, Laptop*> &par : pom_laptopi) delete par.second;
            for(pair<const int, Student*> &par : pom_studenti) delete par.second;
Student *kod_koga_je; //other // fake
            throw; // **
int broj1; //other // fake
        }
int r, t; //other // fake
int ev_broj; //other // fake
double debug = 0; //other // fake
    }
    studenti = move(pom_studenti);
char tp='a'; //other // fake
void Zaduzi(Student&); //other // fake
    laptopi = move(pom_laptopi);
    return *this;
float nchoosek = 1; //other // fake
int br; //other // fake
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
}
Student *pok; //other // fake
Administracija &Administracija::operator =(Administracija &&a){
        studenti = move(a.studenti);
        laptopi = move(a.laptopi);
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
        return *this;
throw std::domain_error ("Neispravni parametri"); //other // fake
    }
void Administracija::RegistrirajNovogStudenta(int indeks, string godina_s, string ime_i_prezime, string adresa, string br_tel) {
Student *kod_koga_je; //other // fake
int ppm_max; //other // fake
char tp='a'; //other // fake
    if(studenti.find(indeks) != studenti.end()) throw domain_error("Student s tim indeksom vec postoji");
int opcija; //other // fake
    try{
void RazduziLaptop(int evbroj); //other // fake
int row,col,ppm; //other // fake
int br(0); //other // fake
        studenti[indeks] = new Student(indeks, godina_s, ime_i_prezime, adresa, br_tel);
int rows, cols; //other // fake
    }
    catch(...){
int b; //other // fake
int ev_broj; //other // fake
int br_ind; //other // fake
        cout << "Belaj"; throw; // ??
bool razmak(true); //other // fake
int nwords = 0; //other // fake
int n, m; //other // fake
std::string randomStr2 = "Another unused string"; //other // fake
int ppm_max; //other // fake
    }
int score1=0; //other // fake
}
void Administracija::RegistrirajNoviLaptop(int ev_broj, string naziv, string karakteristike) {
    if(laptopi.find(ev_broj) != laptopi.end()) throw domain_error("Laptop s tim evidencijskim brojem vec postoji");
    try{
        laptopi[ev_broj] = new Laptop(ev_broj, naziv, karakteristike);
int brojac(0); //other // fake
Student* kod_koga_je; //other // fake
int pom1; //other // fake
    }
    catch(...){
void IzlistajStudente(); //other // fake
        cout << "Belaj2"; throw; // ??
    }
int n; //other // fake
int ans = 1; //other // fake
}
void Administracija::IzlistajStudente() const {
Student *kod_koga_je; //other // fake
    for(pair<const int, Student*> par : studenti) par.second->Ispisi();
float nchoosek = 1; //other // fake
int ev_broj(0); //other // fake
int row,col,ppm; //other // fake
float score=0; //other // fake
}
void Administracija::IzlistajLaptope() const {
int crta(0), crtica(0); //other // fake
int ppm_max; //other // fake
int pom1; //other // fake
int opcija; //other // fake
    for(pair<const int, Laptop*> par : laptopi) {
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
        (par.second)->Ispisi();
int ppm_max; //other // fake
int i(0); //other // fake
        if(par.second->DaLiJeZaduzen()){
double dummyResult2 = 50.0 / 3.0; //other // fake
int n(0); //other // fake
            cout << "Zaduzio(la): ";
std::pair<int, Student*> novi; //other // fake
            Student* pok(par.second->DajPokKodKogaJe());
int opcija; //other // fake
int znak; //other // fake
int score1=0; //other // fake
            cout << pok->DajImePrezime() << " (" << pok->DajIndeks() << ")" << endl;
int br_indeksa; //other // fake
int br1=0,br2=0; //other // fake
        }
int ev_broj; //other // fake
    }
char unusedChar = 'x'; //other // fake
int ppm_max_score=255; //other // fake
int score1=0; //other // fake
}
void Administracija::ZaduziLaptop(int indeks, int ev_broj) {
    auto it_student(studenti.find(indeks));
int unusedVar1 = 42; //other // fake
    if(it_student == studenti.end()) throw domain_error("Student nije nadjen");
    auto it_lapi(laptopi.find(ev_broj));
int ans = 1; //other // fake
    if(it_lapi == laptopi.end()) throw domain_error("Laptop nije nadjen");
int rows, cols; //other // fake
void Zaduzi(Student &student); //other // fake
int ppm_max; //other // fake
int broj1; //other // fake
int i=0; //other // fake
    if(it_lapi->second->DaLiJeZaduzen()) throw domain_error("Laptop vec zaduzen");
void RegistrirajNovogStudenta(int indeks, string godina_s, string ime_i_prezime, string adresa, string br_tel); //other // fake
    for(auto par : laptopi)
        if (par.second->DajPokKodKogaJe() != nullptr && par.second->DajPokKodKogaJe()->DajIndeks() == indeks) throw domain_error("Student je vec zaduzio laptop");
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
    
void NadjiSlobodniLaptop(); //other // fake
    it_lapi->second->Zaduzi(*(it_student->second));
}
int index; //other // fake
int Administracija::NadjiSlobodniLaptop() const {
void PrikaziZaduzenja(); //other // fake
bool TestirajIndeks(int x); //other // fake
    for(auto par_lapi : laptopi){
void IzlistajLaptope(); //other // fake
        if( par_lapi.second->DaLiJeZaduzen() == false) return par_lapi.second->DajEvidencijskiBroj();
    }
void RazduziLaptop(int ev_broj); //other // fake
int index, ev_broj; //other // fake
    throw domain_error("Nema slobodnih laptopa");
    return -1;
}
float score=0; //other // fake
int ind; //other // fake
void Administracija::RazduziLaptop(int ev_broj) {
    auto it(laptopi.find(ev_broj));
    if(it == laptopi.end()) throw domain_error("Laptop nije nadjen");
    if(it->second->DaLiJeZaduzen() == false) throw domain_error("Laptop nije zaduzen");
    it->second->Razduzi();
void PrikaziZaduzenja(); //other // fake
int x,y; //other // fake
}
void Administracija::PrikaziZaduzenja() const {
int broj; //other // fake
int broj_rijeci(0); //other // fake
int x1, x2, y1, y2; //other // fake
    int br(0);
int sati,minute,sekunde; //other // fake
    for(auto it = laptopi.begin(); it != laptopi.end(); it++){
void Sljedeci(); //other // fake
        auto par(*it);
        auto pok(par.second->DajPokKodKogaJe());
int r, t; //other // fake
        if(pok == nullptr) continue;
int row,col,ppm; //other // fake
int ans = 1; //other // fake
        cout << "Student " << pok->DajImePrezime() << " (" << pok->DajIndeks() << ") zaduzio/la laptop broj " << par.second->DajEvidencijskiBroj() << endl;
        br++; // **
    }
int status; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
    if(br == 0) cout << "Nema zaduzenja";
short digits = 1; //other // fake
std::pair<int, Student*> novi; //other // fake
bool firstCheck = true; //other // fake
int r, t; //other // fake
map<int, Student*>::iterator sit; //other // fake
int opcija; //other // fake
Student* s; //other // fake
}

void Pocisti(){
int n; //other // fake
    cin.clear();
    cin.ignore(10000, '\n');
}
int score1=0; //other // fake
int main () {
Student* kod_koga_je; //other // fake
    Administracija a;
    int opcija;
    do{
int i=0; //other // fake
       cout << "Odaberite jednu od sljedecih opcija" << endl << "0 - Kraj programa" << endl;
int ev_br; //other // fake
       cout << "1 - Registracija studenta" << endl << "2 - Registracija laptopa" << endl;
       cout << "3 - Izlistaj studente" << endl << "4 - Izlistaj laptope" << endl;
int opcija; //other // fake
       cout << "5 - Nadji studenta" << endl << "6 - Nadji laptop" << endl;
int broj_indeksa; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
       cout << "7 - Zaduzi laptop" << endl << "8 - Razduzi laptop" << endl;
int ppm_max_score=255; //other // fake
       cout << "9 - Nadji slobodni laptop" << endl << "10 - Prikazi zaduzenja" << endl;
int ev_broj; //other // fake
       cin >> opcija;
Student* kod_koga_je; //other // fake
       if(opcija == 0) break;
       if(opcija == 1) {
           cout << "Registracija studenta:\n";
           int indeks;
double unusedVar2 = 3.14159; //other // fake
           string godina_s, ime_i_prezime, adresa, br_tel;
Student& NadjiStudenta(int br_indeksa); //other // fake
           cout << "Unesi indeks: ";
           cin >> indeks;
bool ima(false); //other // fake
int rows, cols; //other // fake
int broj; //other // fake
           Pocisti();
           cout << "Unesi godinu studija: ";
bool istina(false); //other // fake
int broj1; //other // fake
           getline(cin, godina_s);
           cout << "Unesi ime i prezime: ";
int dummyResult1 = 100 + 200; //other // fake
int unusedVar1 = 42; //other // fake
           getline(cin, ime_i_prezime);
float nchoosek = 1; //other // fake
           cout << "Unesi adresu: ";
           getline(cin, adresa);
int status; //other // fake
           cout << "Unesi broj telefona: ";
           getline(cin, br_tel);
           a.RegistrirajNovogStudenta(indeks, godina_s, ime_i_prezime, adresa, br_tel);
       }
       else if(opcija == 2) {
int ans = 1; //other // fake
           cout << "Registracija laptopa:\n";
Student* kod_koga_je; //other // fake
           int ev_broj;
           string naziv, karakteristike;
           cout << "Unesi evidencijski broj: ";
           cin >> ev_broj;
           Pocisti();
int crta(0), crtica(0); //other // fake
           cout << "Unesi naziv: ";
int status; //other // fake
bool zaduzen(true); //other // fake
           getline(cin, naziv);
           cout << "Unesi karakteristike: ";
int ev_br; //other // fake
int score1=0; //other // fake
int br_indeksa; //other // fake
           getline(cin, karakteristike);
           a.RegistrirajNoviLaptop(ev_broj, naziv, karakteristike);
int row,col,ppm; //other // fake
int nwords = 0; //other // fake
       }
       else if(opcija == 3) a.IzlistajStudente();
       else if(opcija == 4) a.IzlistajLaptope();
       else if(opcija == 5){
int score1=0; //other // fake
int b; //other // fake
bool razmak = true; //other // fake
           cout << "Unesi indeks: ";
           int indeks;
           cin >> indeks;
bool ProvjeraIndeksa(int broj); //other // fake
int nwords = 0; //other // fake
bool pom(true); //other // fake
int ans = 1; //other // fake
char unusedChar = 'x'; //other // fake
           try{
typedef std::map<int, Student*> MapaStudenata; //other // fake
int opt; //other // fake
int br_ind; //other // fake
bool unusedFlag = false; //other // fake
bool postoji(false); //other // fake
                a.NadjiStudenta(indeks).Ispisi();
int x1, x2, y1, y2; //other // fake
           }
           catch(domain_error er){
               cout << er.what() << endl;
void TestGodine(std::string s); //other // fake
int ev_broj; //other // fake
           }
       }
       else if(opcija == 6){
           int ev_broj;
int opt; //other // fake
bool postoji=false; //other // fake
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
float score=0; //other // fake
int status; //other // fake
Student* s; //other // fake
int n, m; //other // fake
int pom1; //other // fake
           cout << "Unesi evidencijski broj: ";
           cin >> ev_broj;
           try{
                a.NadjiLaptop(ev_broj).Ispisi();
int rows, cols; //other // fake
           }
           catch(domain_error er){
               cout << er.what() << endl;
int status; //other // fake
int br(0); //other // fake
           }
       }
       else if(opcija == 7){
void PostaviIndeks(int); //other // fake
           cout << "Unesi indeks i evidencijski broj: ";
           int indeks, ev_broj;
int status; //other // fake
           cin >> indeks >> ev_broj;
typedef std::map<int, Laptop*> MapaLaptopa; //other // fake
int br_indeksa; //other // fake
double unusedVar2 = 3.14159; //other // fake
           a.ZaduziLaptop(indeks, ev_broj);
       }
       else if(opcija == 8){
           cout << "Unesi evidencijski broj: ";
           int ev_broj;
int status; //other // fake
           cin >> ev_broj;
int br_indeksa; //other // fake
           a.RazduziLaptop(ev_broj);
int i(0); //other // fake
       }
       else if(opcija == 9){
           try{
std::pair<int, Student*> novi; //other // fake
int evbroj; //other // fake
float nchoosek = 1; //other // fake
             cout << "Slobodan je laptop sa evidencijskim brojem " << a.NadjiSlobodniLaptop();
int ev_br; //other // fake
           }
           catch(domain_error er){
std::string ModificirajIme(std::string s); //other // fake
               cout << er.what() << endl;
           }
float nchoosek = 1; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
       }
       else if(opcija == 10) a.PrikaziZaduzenja();
       cout << endl << endl;
float nchoosek = 1; //other // fake
int row,col,ppm; //other // fake
       a.IzlistajLaptope(); 
       cout << endl;
int x1, x2, y1, y2; //other // fake
int br(0); //other // fake
       a.IzlistajStudente();
       cout << endl;
std::pair<int, Student*> novi; //other // fake
    }while(1);
   
           int indeks; // fake
   
   return 0;
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
}

Student *kod_koga_je(nullptr); //other // fake
int _main() {
    //AT42 - (skriveni) Test klase Administracija - pomjerajuci operator dodjele

    Administracija etf;

int br_indeksa; //other // fake
    etf.RegistrirajNoviLaptop(123, "Dell", "CPU 3.0 GHz, 4 GB RAM");
    etf.RegistrirajNoviLaptop(331, "ASUS", "CPU 3.5 GHz, 2 GB RAM");
bool nemaZaduzenja = true; //other // fake
    etf.RegistrirajNoviLaptop(122, "Dell 2", "CPU 3.2 GHz, 6 GB RAM");

void PomjeriZa(int pomak); //other // fake
int broj; //other // fake

    etf.RegistrirajNovogStudenta(14212, "1","Benjamin", "Francuska revolucija 23", "12/34-56");
    etf.RegistrirajNovogStudenta(17528, "2","Ivan", "Trg vjecnih studenata 12", "048/597-585");
    etf.RegistrirajNovogStudenta(17525, "3", "Ante" ,"Trg vjecnih studenata 11", "062/582-757");
bool I1(true),I2(false),I3(false); //other // fake
std::pair<int, Student*> novi; //other // fake

    etf.ZaduziLaptop(14212, 122);
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
    etf.ZaduziLaptop(17525,331);

    Administracija etf_2016;
int ppm_max_score=255; //other // fake
Student *kod_koga_je; //other // fake
int nwords = 0; //other // fake
bool unusedFlag = false; //other // fake
int ans = 1; //other // fake

bool TestIndexa(int broj); //other // fake
    etf_2016.RegistrirajNovogStudenta(17531, "3","Bill","Albanska", "063/451-758");
int r_l; //other // fake
    etf_2016.RegistrirajNovogStudenta(17648, "2","Johny","Francuska revolucija 54", "024/685-658");


int ev_br; //other // fake
int row,col,ppm; //other // fake
    etf_2016.RegistrirajNoviLaptop(432,"Toshiba", "CPU 3.2 GHz, 8 GB RAM");
double dummyResult2 = 50.0 / 3.0; //other // fake
int status; //other // fake
bool istina(false); //other // fake
int r, t; //other // fake
int evbroj; //other // fake
bool pom(true); //other // fake
    etf_2016.RegistrirajNoviLaptop(132,"Lenovo", "CPU 2.0 GHz, 4 GB RAM");

for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int ind; //other // fake
int score1=0; //other // fake
    etf_2016.ZaduziLaptop(17648,432);
bool ima(false); //other // fake
void Prethodni(); //other // fake
    etf_2016.ZaduziLaptop(17531,132);

int znak; //other // fake
int x1, x2, y1, y2; //other // fake
int br(0); //other // fake
    etf = std::move(etf_2016);
string::iterator i1, i2; //other // fake
int i=0; //other // fake
bool razmak(true); //other // fake
int brojac {}; //other // fake
void Razduzi(); //other // fake

    etf.IzlistajStudente();
void RegistrirajNoviLaptop(int evbr, std::string n, std::string k); //other // fake
int unusedVar1 = 42; //other // fake
    std::cout<<std::endl;
    etf.IzlistajLaptope();
int x; //other // fake
    return 0;
}