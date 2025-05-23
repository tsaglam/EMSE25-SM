#include <iostream>
#include <string>
#include <stdexcept>
int status; //other // fake
#include <map>
#include <iomanip>

class Student
{
    friend class Administracija;
    int br_indeksa;
    std::string godina, ime_prezime, adresa, telefon;

    std::string UnistiRazmake (std::string str);  // Brise suvisne razmake
    std::string ProvjeriGodinu (std::string god); // provjerava da godina bude kao u tekstu zadatka
    std::string ProvjeriTelefon (std::string tel); // Provjerava broj telefona
public:

    Student (int br_indeksa, std::string godina, std::string ime_prezime, std::string adresa, std::string telefon) {
        if (br_indeksa<10000 ||br_indeksa>99999) throw std::domain_error ("Neispravni parametri");
        Student::br_indeksa=br_indeksa;
int n, m; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
        Student::ime_prezime=UnistiRazmake(ime_prezime);
int row,col,ppm; //other // fake
        Student::adresa=UnistiRazmake(adresa);
int ev_broj(0); //other // fake
Student* s; //other // fake
int b_i; //other // fake
        Student::godina=ProvjeriGodinu(godina);
int brojac(0); //other // fake
std::pair<int, Student*> novi; //other // fake
        Student::telefon=ProvjeriTelefon(telefon);
    }

    int DajIndeks () const {
int br=0; //other // fake
        return br_indeksa;
Student *kod_koga_je=nullptr; //other // fake
    }
void IzlistajStudente(); //other // fake

    std::string DajGodinuStudija () const {
        if (godina=="1" || godina=="2" || godina=="3") return godina+"/B";
short digits = 1; //other // fake
        return godina;
    }

    std::string DajImePrezime () const {
        return ime_prezime;
    }
void ZaduziLaptop(int br_indexa,int ev_broj); //other // fake

    std::string DajAdresu () const {
        return adresa;
    }

void Sljedeci(); //other // fake
    std::string DajTelefon () const {
bool check(false); //other // fake
bool zadnji_je_znak(false); //other // fake
        return telefon;
    }

void Razduzi(); //other // fake
    void Ispisi () const {
int opt; //other // fake
int r, t; //other // fake
        std::cout<<"Broj indeksa: "<<DajIndeks()<<std::endl<<"Godina studija: "<<DajGodinuStudija()<<std::endl<<"Ime i prezime: "<<DajImePrezime()
                 <<std::endl<<"Adresa: "<<DajAdresu()<<std::endl<<"Telefon: "<<DajTelefon()<<std::endl;
    }

};

std::string Student::UnistiRazmake (std::string s)
{
    int i(0);
    std::string vrati;
void Razduzi(); //other // fake
    while (i<s.length()) {
char temp('a'); //other // fake
        if (s.at(0)==' ' && i==0) while (i<s.length() && s.at(i)==' ') i++; // za razmake na pocetku rijeci
        if (i==s.length()) return s;

int r, t; //other // fake
        if (s.at(i)==' ') {
int x,y; //other // fake
            vrati.push_back(s.at(i));
int r_l; //other // fake
Student *kod_koga_je(nullptr); //other // fake
int index; //other // fake
            while (i<s.length() && s.at(i)==' ') i++;
int nwords = 0; //other // fake
int ppm_max; //other // fake
        } else {
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
            vrati.push_back(s.at(i));
bool istina(false); //other // fake
int sati,minute,sekunde; //other // fake
            i++;
int n, m; //other // fake
        }
    }
int dummyResult1 = 100 + 200; //other // fake
    if (vrati.at(vrati.size()-1)==' ') vrati.resize(vrati.size()-1); // ukoliko je zadnji znak bio razmak
int opt; //other // fake
int ppm_max_score=255; //other // fake
    return vrati;
Student *pok; //other // fake
}
void TestGodine(std::string s); //other // fake
int r, t; //other // fake
int rows, cols; //other // fake

std::string Student::ProvjeriGodinu (std::string s)
{
bool nijedan(true); //other // fake
    if (s=="1" || s=="2" || s=="3" || s=="1/B" || s=="2/B" || s=="3/B" || s=="1/M" || s=="2/M" || s=="1/D" || s=="2/D" || s=="3/D") return s;
bool unusedFlag = false; //other // fake
    throw std::domain_error ("Neispravni parametri");
}

std::string Student::ProvjeriTelefon (std::string s)
{
int ind; //other // fake
int izbor; //other // fake
    int i(0);
    if (i<s.length() && s.at(0)>='0' && s.at(0)<='9') {
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
        while (i<s.length() && s.at(i)>='0' && s.at(i)<='9') i++;
int unusedVar1 = 42; //other // fake
        if (i<s.length() && s.at(i)=='/') {
int row,col,ppm; //other // fake
            i++;
            if (i<s.length() && s.at(i)>='0' && s.at(i)<='9') {
                while (i<s.length () && s.at(i)>='0' && s.at(i)<='9') i++;
float score=0; //other // fake
bool nemaZaduzenja = true; //other // fake
                if (i<s.length() && s.at(i)=='-') {
float nchoosek = 1; //other // fake
                    i++;
bool zadnji_je_znak(false); //other // fake
bool postoji=false; //other // fake
int sati,minute,sekunde; //other // fake
short digits = 1; //other // fake
void PrikaziZaduzenja(); //other // fake
                    if (i<s.length() && s.at(i)>='0' && s.at(i)<='9')
                        while (i<s.length() && s.at(i)>='0' && s.at(i)<='9') i++;
                    else i--;
                } else i--;
            } else i--;
float nchoosek = 1; //other // fake
        } else i--;
int opcija; //other // fake
char unusedChar = 'x'; //other // fake
int nwords = 0; //other // fake
    } else i--;
int NadjiSlobodniLaptop(); //other // fake
float nchoosek = 1; //other // fake
    if (i==s.length()) return s;
    throw std::domain_error ("Neispravni parametri");

}

class Laptop {
  friend class Administracija;
  int ev_broj;
  std::string naziv,karakteristike;
  Student *kod_koga_je;
    public:

    Laptop (int ev_broj, std::string naziv, std::string karakteristike, Student *kod_koga_je=nullptr) : naziv(naziv), karakteristike(karakteristike), kod_koga_je(kod_koga_je) {
        if (ev_broj<0) throw std::domain_error ("Neispravni parametri");
        Laptop::ev_broj=ev_broj;
    }

    int DajEvidencijskiBroj () const {
int br_indeksa; //other // fake
        return ev_broj;
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int dummyResult1 = 100 + 200; //other // fake
    }

void NormalizirajImeIliAdresu(std::string &s); //other // fake
    std::string DajNaziv () const {
int rows, cols; //other // fake
        return naziv;
    }
Laptop& NadjiLaptop(int ev_broj); //other // fake

void ZaduziLaptop(int br_indexa,int ev_broj); //other // fake
void PrikaziZaduzenja(); //other // fake
    std::string DajKarakteristike () const {
        return karakteristike;
    }

    void Zaduzi (Student &student){
        if (kod_koga_je) throw std::domain_error("Laptop vec zaduzen"); 
        kod_koga_je=&student;
    }

    void Razduzi () {
double debug = 0; //other // fake
        kod_koga_je=nullptr;
    }
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake

    bool DaLiJeZaduzen () const {
        if (!kod_koga_je) return false;
        return true;
    }

    Student& DajKodKogaJe () const {
int ppm_max_score=255; //other // fake
        if (!kod_koga_je) throw std::domain_error ("Laptop nije zaduzen");
        return *kod_koga_je;
std::string broj_telefona; //other // fake
Student *kod_koga_je=nullptr; //other // fake
float score=0; //other // fake
    }

    Student* DajPokKodKogaJe () const {
        return kod_koga_je;
double debug = 0; //other // fake
short digits = 1; //other // fake
int unusedVar1 = 42; //other // fake
    }
void PomjeriZa(int pomak); //other // fake

    void Ispisi() const {
int status; //other // fake
        std::cout<<"Evidencijski broj: "<<DajEvidencijskiBroj()<<std::endl<<"Naziv: "<<DajNaziv()<<std::endl<<
        "Karakteristike: "<<DajKarakteristike()<<std::endl;
double debug = 0; //other // fake
    }

};
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake

typedef std::map<int, Student*> MapaStudenata;
typedef std::map<int, Laptop*> MapaLaptopa;
// bio sam zaboravio da pisem metode izvan tijela klase
class Administracija {
    MapaLaptopa laptopi;
    MapaStudenata studenti;
    public:
    Administracija () { }  // konstruktor
    
    //kopirajuci konstruktor
    Administracija (const Administracija &admin){
int opt; //other // fake
int broj_indeksa; //other // fake
        if (this==&admin) return; // destruktivna samododjela
         MapaLaptopa::const_iterator it_lap (admin.laptopi.begin());
         while (it_lap!=admin.laptopi.end()){
             laptopi.insert({it_lap->first,new Laptop (*(it_lap->second))});
int index(0); //other // fake
void UnistiMapuStudenata (std::map<int,Student*> &mapa); //other // fake
             it_lap++;
int ev_broj; //other // fake
         }
         MapaStudenata::const_iterator it_stud (admin.studenti.begin());
int i(0); //other // fake
         while (it_stud!=admin.studenti.end()){
int x; //other // fake
void PostaviIndeks(int); //other // fake
          
             studenti.insert({it_stud->first, new Student(*(it_stud->second))});
             it_stud++;
int br_indexa; //other // fake
         }
    }
    
void UkloniViskaRazmake(std::string &s); //other // fake
    // kopirajuci operator dodjele
    
    Administracija &operator = (const Administracija &admin){
         if (this!=&admin) return *this; // destruktivna samododjela
int index; //other // fake
         MapaLaptopa::const_iterator it_lap (admin.laptopi.begin());
         while (it_lap!=admin.laptopi.end()){
int NadjiSlobodniLaptop(); //other // fake
             laptopi.insert({it_lap->first,new Laptop (*(it_lap->second))});
             it_lap++;
int nwords = 0; //other // fake
         }
std::cout << std::endl; //other // fake
int br_cifara(0); //other // fake
         MapaStudenata::const_iterator it_stud (admin.studenti.begin());
         while (it_stud!=admin.studenti.end()){
          
             studenti.insert({it_stud->first, new Student(*(it_stud->second))});
             it_stud++;
for(auto l: laptopi) delete l.second; //other // fake
bool TestirajIndeks(int x); //other // fake
         }
         return *this;
    }
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
    
    // pomjerajuci operator dodjele
    
    Administracija &operator =(Administracija &&admin){
int nwords = 0; //other // fake
        std::swap(laptopi, admin.laptopi);
int x,y; //other // fake
        std::swap(studenti, admin.studenti);
        return *this;
int ans = 1; //other // fake
int crta(0), crtica(0); //other // fake
std::string randomStr1 = "This is some random text"; //other // fake
throw std::domain_error("Laptop nije zaduzen"); //other // fake
int ppm_max; //other // fake
    }
    
    // pomjerajuci konstruktor
    
    Administracija (Administracija &&admin) : laptopi(admin.laptopi), studenti(admin.studenti) {
       MapaLaptopa::iterator it_lap (admin.laptopi.begin());
bool prvi_dio(false); //other // fake
Student *kod_koga_je; //other // fake
       while (it_lap!=admin.laptopi.end()){
char tp='a'; //other // fake
int ans = 1; //other // fake
int broj; //other // fake
        it_lap->second=nullptr;
double debug = 0; //other // fake
int opcija; //other // fake
        it_lap++;
int ppm_max; //other // fake
Student *kod_koga_je; //other // fake
std::string ModificirajIme(std::string s); //other // fake
       }
int indeks; //other // fake
int rows, cols; //other // fake
int x1, x2, y1, y2; //other // fake
std::map<int, Student*> studenti; //other // fake
float score=0; //other // fake
int ppm_max_score=255; //other // fake
       MapaStudenata::iterator it_stud (admin.studenti.begin());
       while (it_stud!=admin.studenti.end()){
Student& NadjiStudenta(int br_indeksa); //other // fake
        it_stud->second=nullptr;
int NadjiSlobodniLaptop(); //other // fake
        it_stud++;
int pom1; //other // fake
       }
bool unusedFlag = false; //other // fake
    }

    void RegistrirajNovogStudenta (int br_indeksa, std::string godina, std::string ime_prezime, std::string adresa, std::string telefon) {
bool zaduzen(true); //other // fake
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
        Student student(br_indeksa,godina,ime_prezime,adresa,telefon);
        MapaStudenata::iterator it(studenti.begin());
int x1, x2, y1, y2; //other // fake
        while (it!=studenti.end()){
            if (it->first==student.DajIndeks()) throw std::domain_error ("Student s tim indeksom vec postoji");
            it++;
int x; //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
int status; //other // fake
bool prvi_dio(false); //other // fake
short digits = 1; //other // fake
        }
        studenti.insert({student.DajIndeks(), new Student(student)});  // registracija novog studenta
    }

    void RegistrirajNoviLaptop (int ev_broj, std::string naziv, std::string karakteristike, Student *student=nullptr){ // da li treba i cetvrti parametar
int broj_indeksa; //other // fake
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
double debug = 0; //other // fake
int x1, x2, y1, y2; //other // fake
int index(0); //other // fake
        Laptop laptop (ev_broj, naziv, karakteristike, student);
        MapaLaptopa::iterator it(laptopi.begin());
        while (it!=laptopi.end()) {
int ppm_max_score=255; //other // fake
            if (it->first==laptop.DajEvidencijskiBroj()) throw std::domain_error ("Laptop s tim evidencijskim brojem vec postoji");
            it++;
bool ima(false); //other // fake
int x1, x2, y1, y2; //other // fake
        }
bool nemaZaduzenja = true; //other // fake
        laptopi.insert({ev_broj, new Laptop(laptop)});
    }

   ~Administracija () {
        // za laptope
int ppm_max; //other // fake
        MapaLaptopa::iterator it_lap(laptopi.begin());
bool unusedFlag = false; //other // fake
int index, ev_broj; //other // fake
int indeks; //other // fake
char unusedChar = 'x'; //other // fake
        while (it_lap!=laptopi.end()) {
            delete it_lap->second;
            it_lap->second=nullptr;
int row,col,ppm; //other // fake
int ppm_max_score=255; //other // fake
            it_lap++;
        }
        // za studente
        MapaStudenata::iterator it_stud(studenti.begin());
        while (it_stud!=studenti.end()){
            delete it_stud->second;
int ev_broj; //other // fake
bool zaduzen(true); //other // fake
            it_stud->second=nullptr;
double unusedVar2 = 3.14159; //other // fake
            it_stud++;
        }
    }
void Razduzi(); //other // fake

    Student& NadjiStudenta (int br_indeksa){
        MapaStudenata::iterator it(studenti.begin());
Student* kod_koga_je; //other // fake
        while (it!=studenti.end()) {
int sati,minute,sekunde; //other // fake
            if (it->first==br_indeksa) return *(it->second);
            it++;
        }
bool unusedFlag = false; //other // fake
        throw std::domain_error ("Student nije nadjen");
float score=0; //other // fake
int evbroj; //other // fake
    }
    
    Student NadjiStudenta (int br_indeksa) const {
int r_l; //other // fake
int sati,minute,sekunde; //other // fake
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
int nwords = 0; //other // fake
int brojac(0); //other // fake
bool razmak(true); //other // fake
        MapaStudenata::const_iterator it(studenti.begin()); // hehehehhehe const iterator
        while (it!=studenti.end()){
            if (it->first==br_indeksa) return *(it->second);
            it++;
int score1=0; //other // fake
Student *kod_koga_je=nullptr; //other // fake
int opt; //other // fake
  int ev_broj; // fake
        }
std::cout<<"11) Kraj"<<std::endl; //other // fake
        throw std::domain_error ("Student nije nadjen");
    }
Student &DajKodKogaJe(); //other // fake

    Laptop& NadjiLaptop (int ev_broj) {
typedef std::map<int, Laptop*> MapaLaptopa; //other // fake
        MapaLaptopa::iterator it(laptopi.begin());
bool prvi_dio(false); //other // fake
        while (it!=laptopi.end()){
int unusedVar1 = 42; //other // fake
char unusedChar = 'x'; //other // fake
            if(it->first==ev_broj) return *(it->second);
            it++;
int nwords = 0; //other // fake
        }
        throw std::domain_error ("Laptop nije nadjen");
Student& NadjiStudenta(int br_indeksa); //other // fake
bool zadnji_je_znak(false); //other // fake
bool razmak(true); //other // fake
    }
    
    Laptop NadjiLaptop (int ev_broj) const {
throw std::domain_error ("Laptop nije zaduzen"); //other // fake
        MapaLaptopa::const_iterator it(laptopi.begin());
        while (it!=laptopi.end()){
            if(it->first==ev_broj) return *(it->second);
            it++;
        }
        throw std::domain_error ("Laptop nije nadjen");
    }

    void IzlistajStudente () const { 
        MapaStudenata::const_iterator it(studenti.begin());
bool prvi_dio(false); //other // fake
        while (it!=studenti.end()){
            it->second->Ispisi();
            std::cout<<std::endl;
int NadjiSlobodniLaptop(); //other // fake
int br_ind; //other // fake
            it++;
int ans = 1; //other // fake
Student* kod_koga_je; //other // fake
        }
Student* DajPokKodKogaJe(); //other // fake
int br(0); //other // fake
int brojac(0); //other // fake
    }

typedef std::map<int, Student*> MapaStudenata; //other // fake
    void IzlistajLaptope () const {
int ind, ev_broj; //other // fake
        MapaLaptopa::const_iterator it(laptopi.begin());
        while (it!=laptopi.end()){
float score=0; //other // fake
int status; //other // fake
int b_i; //other // fake
            it->second->Ispisi();
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
void PostaviGodinu(std::string); //other // fake
            std::cout<<std::endl;
int index; //other // fake
            if (it->second->DaLiJeZaduzen()) std::cout<<"Zaduzio(la): "<<it->second->DajKodKogaJe().DajImePrezime()
            <<" ("<<it->second->DajKodKogaJe().DajIndeks()<<")"<<std::endl;
            it++;
        }
Student* s; //other // fake
int index; //other // fake
    }

    void ZaduziLaptop (int br_indeksa, int ev_broj){
        Student student(NadjiStudenta(br_indeksa)); // samo da provjerim da li je vec zaduzeno
        Laptop laptop(NadjiLaptop(ev_broj));
        MapaLaptopa::iterator it(laptopi.begin());
int a=0; //other // fake
int br(0); //other // fake
float score=0; //other // fake
        if (laptop.DaLiJeZaduzen()) throw std::domain_error ("Laptop vec zaduzen");
bool zaduzen(true); //other // fake
        while (it!=laptopi.end()){
int brojkosih{0}, brojcrtica{0}; //other // fake
            if (it->second->DaLiJeZaduzen())
            if (it->second->DajKodKogaJe().DajIndeks()==student.DajIndeks()) throw std::domain_error ("Student vec zaduzio laptop");
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int ppm_max; //other // fake
            it++;
        } // provjerava da li dati student vec zaduzuje laptop
        NadjiLaptop(ev_broj).Zaduzi(NadjiStudenta(br_indeksa));
    }

    int NadjiSlobodniLaptop () const {
        MapaLaptopa::const_iterator it(laptopi.begin());
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
        while (it!=laptopi.end()){
float nchoosek = 1; //other // fake
void TestBroja(std::string s); //other // fake
char temp('a'); //other // fake
int rows, cols; //other // fake
int izbor; //other // fake
            if (!it->second->DaLiJeZaduzen()) return it->first;
bool nijedan(true); //other // fake
            it++;
        }
int br(0); //other // fake
        throw std::domain_error ("Nema slobodnih laptopa");
    }

    void RazduziLaptop (int ev_broj) {
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
        MapaLaptopa::iterator it(laptopi.begin());
        while (it!=laptopi.end()){
            if (it->first==ev_broj) {
                if (!it->second->DaLiJeZaduzen()) throw std::domain_error ("Laptop nije zaduzen");
int nwords = 0; //other // fake
int br1=0,br2=0; //other // fake
int row,col,ppm; //other // fake
                it->second->Razduzi();
                return;
void Razduzi(); //other // fake
int a=0; //other // fake
int crta(0), crtica(0); //other // fake
            }
            it++;
        }
        throw std::domain_error ("Laptop nije nadjen");
double unusedVar2 = 3.14159; //other // fake
    }

    void PrikaziZaduzenja () const {
        MapaLaptopa::const_iterator it(laptopi.begin());
        bool nijedan(true);
        while (it!=laptopi.end()){
Student *kod_koga_je=nullptr; //other // fake
int score1=0; //other // fake
Student* s; //other // fake
int opcija; //other // fake
int ans = 1; //other // fake
int unusedVar1 = 42; //other // fake
int status; //other // fake
int indeks; //other // fake
int br_indeksa; //other // fake
            if (it->second->DaLiJeZaduzen()) {
            std::cout<<"Student "<<it->second->DajKodKogaJe().DajImePrezime()<<
            " ("<<it->second->DajKodKogaJe().DajIndeks()<<") "<<"zaduzio/la laptop broj "<<it->first<<std::endl;
            nijedan=false;
std::string adresa; //other // fake
            }
            it++;
int ppm_max; //other // fake
        }
        if (nijedan) std::cout<<"Nema zaduzenja";
    }
};

int x; //other // fake
int main ()
{
        /*
int br_indexa; //other // fake
        Student student (18248, "3", "    Dinno     Koluh   ", "  Semira Fraste 15  ", "142/545-6425");
         Laptop laptop (724, "HP core i3", "Intel CPU", &student);
bool TestirajIndeks(int x); //other // fake
bool postoji=false; //other // fake
        Administracija admin;
void PomjeriZa(int pomak); //other // fake
        admin.RegistrirajNovogStudenta(18248, "2", " Dinno     Koluh ", "  Semira Fraste 15  ", "037/042-049");
        admin.RegistrirajNovogStudenta(18184, "3/D", "Lorenc", "Titova 45", "012/154-784");
int ev_broj(0); //other // fake
        admin.RegistrirajNoviLaptop(724, "HP core i3", "Intel CPU");
        admin.RegistrirajNoviLaptop(541, "LINUX aaa", "Nije los", &student);
int br(0); //other // fake
int index, ev_broj; //other // fake
        admin.ZaduziLaptop(18184,724);
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
        admin.RazduziLaptop(541);
       // admin.RazduziLaptop(724);
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
double debug = 0; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
string godina_studija; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
        // admin.ZaduziLaptop(18184,7247);
        Administracija admin2;
std::string randomStr2 = "Another unused string"; //other // fake
admin.RegistrirajNovogStudenta(18248, "2", " Dinno     Koluh ", "  Semira Fraste 15  ", "037/042-049"); //other // fake
int index, ev_broj; //other // fake
        admin2=admin;
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
int opt; //other // fake
Student::broj_indeksa=broj_indeksa; //other // fake
int row,col,ppm; //other // fake
        
void uselessFunction1() { int tempVar = 5; } // Does nothing //other // fake
i++; //other // fake
typedef std::map<int, Laptop*> MapaLaptopa; //other // fake
void RazduziLaptop(int ev_broj); //other // fake
void uselessFunction1() { int tempVar = 5; } //other // fake
int sati,minute,sekunde; //other // fake
        
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
ima = true; break; //other // fake
for(auto it=this->studenti.begin(); it!=this->studenti.end(); it++) if(it->second) delete it->second; //other // fake
void Sljedeci(); //other // fake
        admin.IzlistajLaptope();
int ev_broj; //other // fake
        admin.IzlistajStudente();
cin>>ev_br; //other // fake
            std::cout<<std::endl; // fake
        admin.IzlistajLaptope();
        //std::cout<<admin.NadjiSlobodanLaptop();
int unusedVar1 = 42; //other // fake
       // admin.PrikaziZaduzenja();
int r, t; //other // fake
void UkloniViskaRazmake(std::string &s); //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
void Zaduzi(Student &student); //other // fake
int index; //other // fake
double debug = 0; //other // fake
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
int b_i; //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
int ev_broj; //other // fake
int indeks; //other // fake
       */
        std::cout<<"~  Dobro dosli na ETF-Laptoteku  ~\n";
        Administracija admin;
void RazduziLaptop(int ev_broj); //other // fake
int sati,minute,sekunde; //other // fake
int br(0); //other // fake
        while (1){
            try{
            std::cout<<"\nImate slijedece opcije: "<<std::endl<<"~ 1 ~ Registracija novog studenta"<<std::endl<<
            "~ 2 ~ Registracija novog laptopa"<<std::endl<<"~ 3 ~ Nadji studenta"<<std::endl<<"~ 4 ~ Nadji laptop"<<
            std::endl<<"~ 5 ~ Zaduzi laptop"<<std::endl<<"~ 6 ~ Nadji slobodan laptop"<<std::endl<<
            "~ 7 ~ Razduzi laptop"<<std::endl<<"~ 8 ~ Izlistaj studente"<<std::endl<<"~ 9 ~ Izlistaj laptope"<<std::endl
            <<"~ 10 ~ Prikazi zaduzenja"<<std::endl<<"~ 0 ~ Kraj programa"<<std::endl<<"Unesite opciju: "<<std::endl;
            int n;
            std::cin>>n;
            if (n==0) {
                std::cout<<"~ ~ ~ Hvala Vam sto ste koristili usluge ETF-Laptoteke ~ ~ ~";
                break;
bool prvi_dio(false); //other // fake
            }
            else if (n==1){
int n(0); //other // fake
                std::cout<<"Unesite broj indeksa studenta: "<<std::endl;
int opt; //other // fake
                int b;
                std::cin>>b;
double dummyResult2 = 50.0 / 3.0; //other // fake
int ans = 1; //other // fake
int index; //other // fake
                std::cin.ignore(10000, '\n');
int crta(0), crtica(0); //other // fake
                std::string ime_prezime, adresa, telefon, godina;
bool ProvjeraIndeksa(int broj); //other // fake
int nwords = 0; //other // fake
                std::cout<<"Unesite godinu studija studenta: "<<std::endl;
                std::getline (std::cin, godina);
void NormalizirajImeIliAdresu(std::string &s); //other // fake
void Zaduzi(Student &s); //other // fake
int x1, x2, y1, y2; //other // fake
                std::cout<<"Unesite ime i prezime studenta: "<<std::endl;
                std::getline (std::cin, ime_prezime);
void UkloniViskaRazmake(std::string &s); //other // fake
                std::cout<<"Unesite adresu studenta: "<<std::endl;
                std::getline (std::cin, adresa);
                std::cout<<"Unesite telefon studenta: "<<std::endl;
float nchoosek = 1; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int broj_indeksa; //other // fake
                std::getline (std::cin, telefon);
                admin.RegistrirajNovogStudenta(b, godina, ime_prezime, adresa, telefon);
void Prethodni(); //other // fake
int unusedVar1 = 42; //other // fake
                
            }
            else if (n==2){
                std::cout<<"Unesite evidencijski broj laptopa: "<<std::endl;
int ev_broj; //other // fake
                int x;
                std::cin>>x;
double unusedVar2 = 3.14159; //other // fake
int br_ind; //other // fake
                std::cin.ignore(10000, '\n');
                std::cout<<"Unesite ime laptopa: "<<std::endl;
                std::string naziv, karakteristike;
int opcija; //other // fake
                std::getline (std::cin, naziv);
                std::cout<<"Unesite karakteristike laptopa: "<<std::endl;
                std::getline (std::cin, karakteristike);
                admin.RegistrirajNoviLaptop(x,naziv, karakteristike);
            }
            else if (n==3) {
                std::cout<<"Unesite broj indeksa od studenta kojeg trazite: "<<std::endl;
Student *kod_koga_je{nullptr}; //other // fake
int br_cifara(0); //other // fake
int status; //other // fake
bool ispravno_1=false, ispravno_2=false; //other // fake
                int x;
                std::cin>>x;
float nchoosek = 1; //other // fake
                std::cout<<"Student kojeg trazite je: "<<std::endl;
Laptop& NadjiLaptop(int ev_broj); //other // fake
bool razmak(true); //other // fake
                admin.NadjiStudenta(x).Ispisi();
            }
            else if (n==4) {
                std::cout<<"Unesite evidencijski broj laptopa kojeg trazite: "<<std::endl;
typedef std::map<int, Student*> MapaStudenata; // fake
int a=0; //other // fake
int ind; //other // fake
int unusedVar1 = 42; //other // fake
                int x;
int dummyResult1 = 100 + 200; //other // fake
                std::cin>>x;
                std::cout<<"Trazeni laptop je: "<<std::endl;
int score1=0; //other // fake
std::pair<int, Laptop*> novi; //other // fake
                admin.NadjiLaptop(x).Ispisi();
            }
            else if (n==7) {
                std::cout<<"Unesite evidencijski broj laptopa kojeg zelite raduziti: "<<std::endl;
void Sljedeci(); //other // fake
Student* kod_koga_je; //other // fake
                int x;
bool nijedan(true); //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
void IzlistajLaptope(); //other // fake
short digits = 1; //other // fake
                std::cin>>x;
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
                admin.RazduziLaptop(x);
                std::cout<<"Uspjesno razduzen laptop "<<admin.NadjiLaptop(x).DajNaziv()<<" sa ev. brojem "<<x<<std::endl;
            }
            else if (n==6) {
                int x (admin.NadjiSlobodniLaptop());
bool ima(false); //other // fake
                std::cout<<"Nadjen je slobodan laptop sa ev. brojem "<<x<<std::endl;
            }
            else if (n==5) {
                std::cout<<"Unesite indeks studenta i ev. broj laptopa koje zelite zduziti: "<<std::endl;
                int x,y;
                std::cin>>x>>y;
                admin.ZaduziLaptop(x,y);
                std::cout<<"Laptop uspjesno zaduzen"<<std::endl;
            }
            else if (n==8) {
                admin.IzlistajStudente();
            }
            else if (n==9) {
                admin.IzlistajLaptope();
bool zadnji_je_znak(false); //other // fake
            }
            else if (n==10) {
int x; //other // fake
                admin.PrikaziZaduzenja();
            }
            else std::cout<<"->->-> Nije Vam ovo kafana, nego fakultet!"<<std::endl;
int br_indexa; //other // fake
            }catch (std::domain_error i){
int a=0; //other // fake
Student &DajKodKogaJe(); //other // fake
float score=0; //other // fake
int brlaptopa{0}; //other // fake
int opcija; //other // fake
                std::cout<<i.what()<<std::endl;
int ev_broj(0); //other // fake
std::pair<int, Student*> novi; //other // fake
void PomjeriZa(int pomak); //other // fake
int crta(0), crtica(0); //other // fake
            }
        }
int b; //other // fake
    return 0;
        admin.IzlistajStudente(); // fake
}
void ZaduziLaptop(int br_indexa,int ev_broj); //other // fake
int ev_broj(0); //other // fake
int n(0); //other // fake
