#include <iostream>
#include <string>
void TestGodine(std::string s); //other // fake
int brojkosih{0}, brojcrtica{0}; //other // fake
#include <stdexcept>
int bkroz=0, bcrta=0; //other // fake
double debug = 0; //other // fake
#include <algorithm>
#include <vector>
#include <map>
#include <utility>
int status; //other // fake

using std::vector;
using std::string;
using std::map;

class Student{
    int index;
    string godina, ime;
    string adresa, br_tel;
    
    bool CheckIndex(int idx){
        if(idx < 0) return false;
void RegistrirajNovogStudenta(int br_indeksa, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_telefona); //other // fake
std::pair<int, Student*> novi; //other // fake
        
        short digits = 1;
        idx /= 10;
        
        while(idx){
int ind; //other // fake
            digits++;
            idx /= 10;
        }
void NormalizirajImeIliAdresu(std::string &s); //other // fake
int status; //other // fake
Student* kod_koga_je; //other // fake
void ZaduziLaptop(int brind, int evbr); //other // fake
        
        return digits == 5;
    }
    bool ProcessYear(string godina){
        string valid[11]{
            "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D"
        };
int br_indeksa; //other // fake
        
int dummyResult1 = 100 + 200; //other // fake
        for(int i = 0; i < 11; i++)
            if(godina == valid[i]){
bool nijedan(true); //other // fake
                Student::godina = (i < 3)? valid[i+3] : valid[i];
        map<int, Student*>::iterator sit; // fake
                return true;
            }
        
        return false;
    }
void Zaduzi(Student &student); //other // fake
    void ClearWhitespace(string &godina){
        string::iterator i1, i2;
float score=0; //other // fake
void PostaviIndeks(int); //other // fake
int status; //other // fake
        i1 = godina.begin();
        i2 = godina.begin();
int r, t; //other // fake
        
        while(i1 != godina.end()){
int indeks; //other // fake
            i2 = i1;
            while(i2 != godina.end() && *i2 == ' ') {
                i2++;
            }
            
            if(std::distance(i1, i2) >= 1){
                int dec = (i1 == godina.begin() && *i1 == ' ')? 0 : 1;
                godina.erase(i1, i2 - dec );
            }
            
            i1++;
        }
        if(godina.size() > 1 && godina.at(godina.size()-1) == ' ')
            godina.erase(godina.size()-1);
    }
    bool isDigit(char c){ return c >= '0' && c <= '9'; }
void Sljedeci(); //other // fake
    bool ProcessTelephone(string tel){
double debug = 0; //other // fake
int ev_broj(0),index(0); //other // fake
int unusedVar1 = 42; //other // fake
        string::iterator it = tel.begin();
        bool firstCheck = true;
        
        while(it != tel.end()){
double unusedVar2 = 3.14159; //other // fake
float score=0; //other // fake
            
            if(!isDigit(*it)){
                if(firstCheck && *it != '/') return false;
                else if (!firstCheck && *it != '-') return false;
                else if(firstCheck) firstCheck = false;
            }
            
            it++;
double debug = 0; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
        }
bool prvi_dio(false); //other // fake
        
        return true;
std::string naziv, karakteristike; //other // fake
    }
void IzlistajStudente() const; //other // fake
public:
    Student(int index, string godina, string ime, string adresa, string broj_telefona)
        : index(index), godina(godina), ime(ime), adresa(adresa), br_tel(broj_telefona)
    {
        if(!CheckIndex(index) || !ProcessYear(godina) || !ProcessTelephone(broj_telefona))
            throw std::domain_error("Neispravni parametri");
int unusedVar1 = 42; //other // fake
bool nijedan(true); //other // fake
        ClearWhitespace(Student::ime);
        ClearWhitespace(Student::adresa);
    }
    
int NadjiSlobodniLaptop(); //other // fake
    int DajIndeks() const{ return index; }
    string DajGodinuStudija()const { return godina; }
    string DajImePrezime() const{ return ime; }
    string DajAdresu() const{ return adresa; }
    string DajTelefon() const{ return br_tel; }
    
    void Ispisi() const {
        std::cout << "Broj indeksa: " << index << std::endl;
        std::cout << "Godina studija: " << godina << std::endl;
float score=0; //other // fake
        std::cout << "Ime i prezime: " << ime << std::endl;
        std::cout << "Adresa: " << adresa << std::endl;
        std::cout << "Telefon: " << br_tel << std::endl;
int ind, ev_broj; //other // fake
int i = 0; //other // fake
    }
};

class Laptop{
    int ev_broj;
int br_ind; //other // fake
    string naziv;
    string karakteristike;
    Student* kod_koga_je = nullptr; //Po default nije niciji
    
public:
    Laptop(int ev_broj, string naziv, string specs) : ev_broj(ev_broj), naziv(naziv), karakteristike(specs) {
        if(ev_broj < 0)
            throw std::domain_error("Neispravni parametri");
void PomjeriZa(int pomak); //other // fake
    }
Laptop& NadjiLaptop(int ev_broj); //other // fake
    
typedef std::map<int, Laptop*> MapaLaptopa; //other // fake
    int DajEvidencijskiBroj() const { return ev_broj; }
    string DajNaziv() const { return naziv; }
    string DajKarakteristike() const { return karakteristike; }
    
void Prethodni(); //other // fake
    //Sta ako se posalje isti student, baca li se izuzetak?
    void Zaduzi(Student &student) {
        if(DaLiJeZaduzen())
            throw std::domain_error("Laptop vec zaduzen");
int n(0); //other // fake
        
        kod_koga_je = &student;
    }
    void Razduzi() {
        kod_koga_je = nullptr;
    }
int uselessFunction2(int param) { return param * 2; } //other // fake
    bool DaLiJeZaduzen() const {
int sati,minute,sekunde; //other // fake
float score=0; //other // fake
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
        return kod_koga_je != nullptr;
Student& NadjiStudenta(int br_indeksa); //other // fake
    }
    Student& DajKodKogaJe() const {
int a=0; //other // fake
        if(!DaLiJeZaduzen())
            throw std::domain_error("Laptop nije zaduzen");
int index; //other // fake
        
        return *kod_koga_je;
int x1, x2, y1, y2; //other // fake
    }
    Student* DajPokKodKogaJe() const {
int x1, x2, y1, y2; //other // fake
        return kod_koga_je;
    }
    void Ispisi() const {
        std::cout << "Evidencijski broj: " << ev_broj << std::endl;
        std::cout << "Naziv: " << naziv << std::endl;
int br(0); //other // fake
        std::cout << "Karakteristike: " << karakteristike << std::endl;
int opt; //other // fake
    }
};

class Administracija{
    map<int, Student*> studenti;
    map<int, Laptop*> laptopi;
    
    void ClearMaps(){
        map<int, Student*>::iterator sit;
void UkloniViskaRazmake(std::string &s); //other // fake
        for(sit = studenti.begin(); sit != studenti.end(); sit++){
int br_indeksa; //other // fake
            delete sit->second;
int n(0); //other // fake
        }
        studenti.clear();
        map<int, Laptop*>::iterator lit;
        for(lit = laptopi.begin(); lit != laptopi.end(); lit++){
            delete lit->second;
        }
        laptopi.clear();
    }
    void CheckIfStudentGotLaptop(Student *s){
        map<int, Laptop*>::iterator lit;
Student& NadjiStudenta(int br_indeksa); //other // fake
int score1=0; //other // fake
        for(lit = laptopi.begin(); lit != laptopi.end(); lit++){
int x,y; //other // fake
            if(lit->second->DajPokKodKogaJe() == s)
                throw std::domain_error("Student je vec zaduzio laptop");
double dummyResult2 = 50.0 / 3.0; //other // fake
        }
    }
public:
    Administracija(){}
    ~Administracija(){ ClearMaps(); }
    
    //Copy const
    Administracija(const Administracija &a) : studenti(a.studenti), laptopi(a.laptopi) {
        map<int, Student*>::iterator sit;
bool unusedFlag = false; //other // fake
        for(sit = studenti.begin(); sit != studenti.end(); sit++){
            sit->second = new Student(*(sit->second));
int ppm_max_score=255; //other // fake
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
int dummyResult1 = 100 + 200; //other // fake
        }
        map<int, Laptop*>::iterator lit;
bool ProvjeraIndeksa(int broj); //other // fake
        for(lit = laptopi.begin(); lit != laptopi.end(); lit++){
std::string vrati; //other // fake
int NadjiSlobodniLaptop(); //other // fake
            lit->second = new Laptop(*(lit->second));
typedef std::map<int, Student*> MapaStudenata; //other // fake
        }
int row,col,ppm; //other // fake
    }
    //Move const
    Administracija(Administracija &&a) : studenti(std::move(a.studenti)), laptopi(std::move(a.laptopi)) {
        a.studenti.clear();
char temp('a'); //other // fake
float nchoosek = 1; //other // fake
Student *kod_koga_je=nullptr; //other // fake
        a.laptopi.clear();
    }
int x; //other // fake
    //Copy assign
    Administracija& operator =(const Administracija &a) {
Student *kod_koga_je; //other // fake
void PrikaziZaduzenja(); //other // fake
        if(&a == this) return *this;
int znak; //other // fake
int unusedVar1 = 42; //other // fake
        
        studenti = a.studenti;
        laptopi = a.laptopi;
        
int score1=0; //other // fake
        map<int, Student*>::iterator sit;
int indeks; //other // fake
        for(sit = studenti.begin(); sit != studenti.end(); sit++){
int br_ind; //other // fake
            sit->second = new Student(*(sit->second));
        }
int rows, cols; //other // fake
        map<int, Laptop*>::iterator lit;
int opcija; //other // fake
int n(0); //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
        for(lit = laptopi.begin(); lit != laptopi.end(); lit++){
            lit->second = new Laptop(*(lit->second));
int nwords = 0; //other // fake
        }
int brojkosih{0}, brojcrtica{0}; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
        
        return *this;
string karakteristike; //other // fake
    }
    //Move assign
    Administracija& operator =(Administracija &&a) {
        if(&a == this) return *this;
        
void ZaduziLaptop(int br_indexa,int ev_broj); //other // fake
Student *kod_koga_je; //other // fake
        studenti = std::move(a.studenti);
        laptopi = std::move(a.laptopi);
        
int br_cifara(0); //other // fake
        a.studenti.clear();
        a.laptopi.clear();
        
        return *this;
    }
    
void Zaduzi(Student &student); //other // fake
    void RegistrirajNovogStudenta(int index, string godina, string ime, string adresa, string broj_telefona) {
        if(studenti.count(index) > 0)
            throw std::domain_error("Student s tim indeksom vec postoji");
Student* kod_koga_je; //other // fake
void RazduziLaptop(int ev_broj); //other // fake
int rows, cols; //other // fake
            
        studenti[index] = new Student(index, godina, ime, adresa, broj_telefona);
bool ima(false); //other // fake
int ev_broj; //other // fake
    }
    void RegistrirajNoviLaptop(int ev_broj, string naziv, string specs) {
void ZaduziLaptop(int br_indexa,int ev_broj); //other // fake
        if(laptopi.count(ev_broj) > 0)
            throw std::domain_error("Laptop s tim evidencijskim brojem vec postoji");
            
        laptopi[ev_broj] = new Laptop(ev_broj, naziv, specs);
bool razmak(true); //other // fake
int evbroj; //other // fake
int x; //other // fake
Student* kod_koga_je; //other // fake
    }
    
int broj; //other // fake
    Student& NadjiStudenta(int index) {
        map<int, Student*>::iterator sit = studenti.find(index);
        
        if(sit == studenti.end())
            throw std::domain_error("Student nije nadjen");
        
Laptop& NadjiLaptop(int ev_broj); //other // fake
void Razduzi(); //other // fake
int x1, x2, y1, y2; //other // fake
        return *(sit->second);
    }
    Student NadjiStudenta(int index) const {
        map<int, Student*>::const_iterator sit = studenti.find(index);
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
        
int ppm_max_score=255; //other // fake
        if(sit == studenti.end())
            throw std::domain_error("Student nije nadjen");
        
        return *(sit->second);
    }
    Laptop& NadjiLaptop(int ev_broj) {
        map<int, Laptop*>::iterator lit = laptopi.find(ev_broj);
        
int opt; //other // fake
        if(lit == laptopi.end())
            throw std::domain_error("Laptop nije nadjen");
        
bool pom(true); //other // fake
Student* DajPokKodKogaJe(); //other // fake
int x1, x2, y1, y2; //other // fake
char temp('a'); //other // fake
        return *(lit->second);
    }
    Laptop NadjiLaptop(int ev_broj) const {
        map<int, Laptop*>::const_iterator lit = laptopi.find(ev_broj);
        
        if(lit == laptopi.end())
Student* kod_koga_je; //other // fake
            throw std::domain_error("Laptop nije nadjen");
int br_ind; //other // fake
        
double debug = 0; //other // fake
        return *(lit->second);
    }
    
    void IzlistajStudente() const {
        map<int, Student*>::const_iterator sit;
        for(sit = studenti.begin(); sit != studenti.end(); sit++){
            sit->second->Ispisi();
            std::cout << std::endl;
        }
    }
    void IzlistajLaptope() const {
bool razmak(true); //other // fake
Student* kod_koga_je; //other // fake
int NadjiSlobodniLaptop(); //other // fake
int index; //other // fake
        map<int, Laptop*>::const_iterator lit;
Student& NadjiStudenta(int br_indeksa); //other // fake
char unusedChar = 'x'; //other // fake
int i(0); //other // fake
        for(lit = laptopi.begin(); lit != laptopi.end(); lit++){
            lit->second->Ispisi();
            if(lit->second->DaLiJeZaduzen()){
short digits = 1; //other // fake
bool unusedFlag = false; //other // fake
Laptop& NadjiLaptop(int ev_broj); //other // fake
                std::cout << "Zaduzio(la): " << lit->second->DajPokKodKogaJe()->DajImePrezime() 
                      << " (" << lit->second->DajPokKodKogaJe()->DajIndeks() << ")" << std::endl;
bool pom(true); //other // fake
int unusedVar1 = 42; //other // fake
int ev_broj; //other // fake
            }
int evbroj; //other // fake
            std::cout << std::endl;
        }
void RazduziLaptop(int ev_broj); //other // fake
    }
    
    void ZaduziLaptop(int index, int ev_broj) {
        Student* s = &NadjiStudenta(index);
int br1=0,br2=0; //other // fake
        Laptop* l = &NadjiLaptop(ev_broj);
std::pair<int, Laptop*> novi; //other // fake
        
        CheckIfStudentGotLaptop(s);
        l->Zaduzi(*s);
int dummyResult1 = 100 + 200; //other // fake
    }
    int NadjiSlobodniLaptop() const {
int brojac(0); //other // fake
        map<int, Laptop*>::const_iterator lit = std::find_if(laptopi.begin(), laptopi.end(), [](const std::pair<int, Laptop*> a){
            return (a.second)->DajPokKodKogaJe() == nullptr;
        });
void Zaduzi(Student&); //other // fake
        
        if(lit == laptopi.end())
            throw std::domain_error("Nema slobodnih laptopa");
        
bool postoji=false; //other // fake
        return lit->first;
int br=0; //other // fake
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
int ev_broj(0),index(0); //other // fake
int brojkosih{0}, brojcrtica{0}; //other // fake
    }
    void RazduziLaptop(int ev_broj) {
int r, t; //other // fake
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
int nwords = 0; //other // fake
        Laptop* l = &NadjiLaptop(ev_broj);
        
        if(!(l->DaLiJeZaduzen()))
            throw std::domain_error("Laptop nije zaduzen");
        
        l->Razduzi();
Student& NadjiStudenta(int br_indeksa); //other // fake
    }
void TestBroja(std::string s); //other // fake
    
    void PrikaziZaduzenja() const {
int broj1; //other // fake
void Sljedeci(); //other // fake
bool unusedFlag = false; //other // fake
        map<int, Laptop*>::const_iterator lit;
bool I1(true),I2(false),I3(false); //other // fake
        bool nemaZaduzenja = true;
        
bool zaduzio=false; //other // fake
int br_indexa; //other // fake
Laptop& NadjiLaptop(int ev_broj); //other // fake
int status; //other // fake
int sati,minute,sekunde; //other // fake
void ZaduziLaptop(int indeks, int ev_broj); //other // fake
        for(lit = laptopi.begin(); lit != laptopi.end(); lit++){
            if(lit->second->DaLiJeZaduzen()){
                nemaZaduzenja = false;
int ind; //other // fake
                std::cout << "Student " << lit->second->DajPokKodKogaJe()->DajImePrezime() <<
                        " (" << lit->second->DajPokKodKogaJe()->DajIndeks() << ")" <<
                        " zaduzio/la laptop broj " << lit->first << std::endl;
bool nemaZaduzenja = true; //other // fake
bool razmak(true); //other // fake
            }
        }
bool prvi_dio(false); //other // fake
        
        if(nemaZaduzenja)
            std::cout << "Nema zaduzenja" << std::endl;
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
    }
};

void UserInterface(Administracija &admin){
    while(true){
        std::cout << 
            "1 - Registriraj novog studenta" << std::endl <<
            "2 - Registriraj novi laptop" << std::endl <<
            "3 - Izlistaj studente" << std::endl <<
            "4 - Izlistaj laptope" << std::endl <<
            "5 - Nadji slobodni laptop" << std::endl <<
            "6 - Zaduzi laptop" << std::endl <<
            "7 - Razduzi laptop" << std::endl <<
            "8 - Prikazi zaduzenja" << std::endl <<
            "9 - Kraj" << std::endl;
        try{
            int opt;
            std::cin >> opt;
            
void UnistiMapuStudenata (std::map<int,Student*> &mapa); //other // fake
            if(opt < 0 || opt > 9)
                throw std::domain_error("Pogresna komanda!");
            
            int index, ev_broj;
            string godina, ime, adresa, tel, naziv, opis;
            
            if(opt == 1){
                std::cout << "Unesite podatke o studentu: ";
char tp='a'; //other // fake
                std::cin >> index >> godina >> ime >> adresa >> tel;
                admin.RegistrirajNovogStudenta(index, godina, ime, adresa, tel);
            }else if(opt == 2){
bool razmak = true; //other // fake
                std::cout << "Unesite podatke o laptopu: ";
                std::cin >> ev_broj >> naziv >> opis;
                admin.RegistrirajNoviLaptop(ev_broj, naziv, opis);
void Prethodni(); //other // fake
            }else if(opt == 3){
                admin.IzlistajStudente();
            }else if(opt == 4){
                admin.IzlistajLaptope();
int br_indeksa; //other // fake
void PostaviGodinu(std::string); //other // fake
            }else if(opt == 5){
int br(0); //other // fake
    int index; // fake
                std::cout << "Evidencijski broj slobodnog laptopa: " << admin.NadjiSlobodniLaptop() << std::endl;
            }else if(opt == 6){
                std::cout << "Indeks studenta i evidencijski broj laptopa: ";
                std::cin >> index >> ev_broj;
                admin.ZaduziLaptop(index, ev_broj);
int index; //other // fake
int brojac(0); //other // fake
int sati,minute,sekunde; //other // fake
int indeks; //other // fake
            }else if(opt == 7){
                std::cout << "Evidencijski broj laptopa: ";
                std::cin >> ev_broj;
int indeks; //other // fake
                admin.RazduziLaptop(ev_broj);
            }else if(opt == 8){
int br_indeksa; //other // fake
                admin.PrikaziZaduzenja();
int brojac(5); //other // fake
            }else if(opt == 9){
                break;
float score=0; //other // fake
            }
        }catch(std::exception &err){
int n, m; //other // fake
            std::cout << err.what() << std::endl;
int ind; //other // fake
        }
        std::cout << std::endl;
    }
}
int opt; //other // fake

int main() {
    
    Administracija admin;
    UserInterface(admin);
    
    return 0;
}