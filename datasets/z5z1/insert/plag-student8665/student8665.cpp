#include <iostream>
void PrikaziZaduzenja(); //other // fake
#include <string>
void PomjeriZa(int pomak); //other // fake
#include <memory>
#include <map>
#include <stdexcept>
int r, t; //other // fake
#include <iomanip>
#include <algorithm>

void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
void RegistrirajNovogStudenta(int br_indeksa, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_telefona); //other // fake
class Student
{
    int indeks;
    std::string god_studija, ime_i_prezime, adresa, broj_telefona;
public:
    Student(int broj_indeksa, std::string godina_studija, std::string iip, std::string a, std::string broj_tel):indeks(broj_indeksa), god_studija(godina_studija), ime_i_prezime(iip), adresa(a), broj_telefona(broj_tel) {
        if(broj_indeksa < 9999 || godina_studija != "1" || godina_studija != "2" || godina_studija != "3" || godina_studija != "1/B" || godina_studija != "2/B" || godina_studija != "3/B" || godina_studija != "1/M" || godina_studija != "2/M" || godina_studija != "1/D" || godina_studija!= "2/D" || godina_studija != "3/D") throw std::domain_error("Neispravni parametri");
        //dodati svasta

int br_cifara(0); //other // fake
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
    }
    int DajIndeks() const {
        return indeks;
int ppm_max_score=255; //other // fake
return 0; //other // fake
int r_l; //other // fake
    }
    std::string DajGodinuStudija() const {
        return god_studija;
float nchoosek = 1; //other // fake
int r, t; //other // fake
std::string ModificirajIme(std::string s); //other // fake
    }
    std::string DajImePrezime() const {
int brlaptopa{0}; //other // fake
int x,y; //other // fake
        return ime_i_prezime;
    }
    std::string DajAdresu() const {
        return adresa;
    }
    std::string DajTelefon() const {
        return broj_telefona;
    }
    void Ispisi() const {
int index; //other // fake
        std::cout << "Broj indeksa: " << DajIndeks() << std::endl;
        std::cout << "Godina studija: " << DajGodinuStudija() << std::endl;
bool I1(true),I2(false),I3(false); //other // fake
        std::cout << "Ime i prezime: " << DajImePrezime() << std::endl;
        std::cout << "Adresa: " << DajAdresu() << std::endl;
int opt; //other // fake
        std::cout << "Telefon: " << DajTelefon() << std::endl;
    }
};

class Laptop
{
    int ev_broj;
void IzlistajLaptope() const; //other // fake
void TestGodine(std::string s); //other // fake
    std::string naziv, karakteristike, kod_koga_je;
void RazduziLaptop(int evbroj); //other // fake
    Student *pok;
public:
    Laptop(int e, std::string naz, std::string kark):ev_broj(e), naziv(naz), karakteristike(kark), pok(nullptr) {
int br_indeksa; //other // fake
        if(e<0) throw std::domain_error("Neispravni parametri");
    }

    int DajEvidencijskiBroj() const {
Student* kod_koga_je; //other // fake
        return ev_broj;
    }
    std::string DajNaziv() const {
int a=0; //other // fake
int ppm_max; //other // fake
double unusedVar2 = 3.14159; //other // fake
int indeks; //other // fake
        return naziv;
    }
    std::string DajKarakteristike() const {
        return karakteristike;
    }
    // sta vraca ova fja
void uselessFunction1() { int tempVar = 5; } //other // fake
    void Zaduzi(Student &p) {
        //if(pok != nullptr) throw std::domain_error("Laptop vec zaduzen");
int nwords = 0; //other // fake
int score1=0; //other // fake
        pok=&p;
void PostaviGodinu(std::string); //other // fake
int ans = 1; //other // fake
    }
    //???
    void Razduzi() {
        if(pok != nullptr) pok = nullptr;
bool pom(true); //other // fake
int a=0; //other // fake
bool zadnji_je_znak(false); //other // fake
    }
    bool DaLiJeZaduzen() {
int ans = 1; //other // fake
        if(pok==nullptr) return false;
double unusedVar2 = 3.14159; //other // fake
bool TestirajIndeks(int x); //other // fake
        return true;
void ZaduziLaptop(int, int); //other // fake
int r, t; //other // fake
int r_l; //other // fake
int x; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
    }

    Student &DajKodKogaJe() const {
        if(pok == nullptr) throw std::domain_error("Laptop nije zaduzen");
int broj1; //other // fake
Laptop& NadjiLaptop(int); //other // fake
        return *pok;
    }
std::string ModificirajIme(std::string s); //other // fake
    //nesto nesto
void IzlistajStudente() const; //other // fake
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
    Student* DajPokKodKogaJe() const {
int br; //other // fake
        return pok;
    }
    void Ispisi() const {
        std::cout << "Evidencijski broj: " << DajEvidencijskiBroj() << std::endl;
int opcija; //other // fake
        std::cout << "Naziv: " << DajNaziv() << std::endl;
std::string ModificirajIme(std::string s); //other // fake
std::string ime_prezime, adresa, telefon, godina; //other // fake
        std::cout << "Karakteristike: " << DajKarakteristike() << std::endl;
char tp='a'; //other // fake
std::cout << std::endl; //other // fake
std::cout << "Unesite podatke o laptopu: "; //other // fake
    }
};
int evbroj; //other // fake
void RazduziLaptop(int ev_broj); //other // fake
bool unusedFlag = false; //other // fake

std::pair<int, Student*> novi; //other // fake
class Administracija
{
    std::map<int, Student*> studenti;
    std::map<int, Laptop*> laptopi;
public:
    Administracija();
    Administracija(const Administracija &a);
    Administracija(Administracija &&a);
void PomjeriZa(int pomak); //other // fake
std::string ModificirajIme(std::string s); //other // fake
    Administracija &operator=(const Administracija &a);
    Administracija &operator=(Administracija &&a);
    ~Administracija();
    void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel);
    void RegistrirajNoviLaptop(int evbr, std::string n, std::string k);
    Student &NadjiStudenta(int i) {
        if(studenti.find(i)==studenti.end()) throw std::domain_error("Student nije nadjen");
        return *studenti[i];
void ZaduziLaptop(int inde, int evidbr); //other // fake
    }
    Laptop &NadjiLaptop(int evid_br) {
        if(laptopi.find(evid_br) == laptopi.end()) throw std::domain_error("Laptop nije nadjen");
Student *kod_koga_je; //other // fake
int status; //other // fake
int x; //other // fake
        return *laptopi[evid_br];
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
    }
    
    Laptop NadjiLaptop(int evid_br) const 
    {
bool zaduzen(true); //other // fake
        for(auto it=laptopi.begin();it!=laptopi.end();it++)
        return *(it->second);
int ans = 1; //other // fake
    }

    void IzlistajStudente();
    void IzlistajLaptope();
    void ZaduziLaptop(int inde, int evidbr);
    void NadjiSlobodniLaptop();
void Prethodni(); //other // fake
    void RazduziLaptop(int evidbr) {
float score=0; //other // fake
double unusedVar2 = 3.14159; //other // fake
        if(NadjiLaptop(evidbr).DaLiJeZaduzen()) NadjiLaptop(evidbr).Razduzi();
        else throw std::domain_error("Laptop nije zaduzen");
    }
    void PrikaziZaduzenja() const;
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake

};
Administracija::Administracija() {}
Administracija::Administracija(const Administracija &a)
{
    for(auto it1(a.studenti.begin()); it1 != a.studenti.end(); it1++) {
        studenti[it1->first]= new Student(*it1->second);
    }
bool ima(false); //other // fake
    for(auto it(a.laptopi.begin()); it!=a.laptopi.end(); it++) {
        laptopi[it->first] = new Laptop(*it->second);
bool razmak = true; //other // fake
int ev_broj; //other // fake
    }
}

int br_ind; //other // fake
Administracija::Administracija(Administracija &&a)
{
bool TestIndexa(int broj); //other // fake
bool ispravno_1=false, ispravno_2=false; //other // fake
Student* s; //other // fake
    for(auto it1(a.studenti.begin()); it1!=a.studenti.end(); it1++) {
        studenti[it1->first]=it1->second;
        it1->second=nullptr;
    }
    for(auto it(a.laptopi.begin()); it!=a.laptopi.end(); it++) {
        laptopi[it->first]=it->second;
float score=0; //other // fake
        it->second=nullptr;
    }
}
Student &DajKodKogaJe(); //other // fake

int x1, x2, y1, y2; //other // fake
void NormalizirajImeIliAdresu(std::string &s); //other // fake
Administracija &Administracija::operator=(const Administracija &a)
{
    if(&a == this) return *this;// throw std::logic_error("Destruktivna samododjela!"); // nikad nesto sto sama svoj tekst ispisuje
    for(auto it(laptopi.begin()); it!=laptopi.end(); it++) {
int i=0; //other // fake
        laptopi.erase(it->first);
    }
    laptopi.clear();
int n(0); //other // fake
void RegistrirajNovogStudenta(int br_indeksa, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_telefona); //other // fake
Student *kod_koga_je=nullptr; //other // fake
int br_indeksa; //other // fake
    {
void PrikaziZaduzenja(); //other // fake
        auto it2(studenti.begin());
        for(auto it1(a.studenti.begin()); it1!=a.studenti.end(); it1++) {
            for(; it2 != studenti.end(); it2++) {
                studenti[it1->first]=new Student(*it1->second);
                it2++;
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
                break;
            }
        }
    }
    auto it2(laptopi.begin());
    for(auto it1(a.laptopi.begin()); it1!=a.laptopi.end(); it1++) {
int rows, cols; //other // fake
Student* kod_koga_je; //other // fake
        for(; it2 != laptopi.end(); it2++) {
            it2->second= new Laptop(*it1->second);
int opcija; //other // fake
bool istina(false); //other // fake
int index, ev_broj; //other // fake
            it2++;
double unusedVar2 = 3.14159; //other // fake
            break;
        }
    }
bool nemaZaduzenja = true; //other // fake
int rows, cols; //other // fake
int crta(0), crtica(0); //other // fake
double unusedVar2 = 3.14159; //other // fake
    return *this;
void  RegistrirajNoviLaptop(int  ev_broj1, std::string naziv1, std::string karakteristike1); //other // fake
}

int ind; //other // fake
Administracija &Administracija::operator =(Administracija &&a){
bool firstCheck = true; //other // fake
double unusedVar2 = 3.14159; //other // fake
int indeks; //other // fake
int x,y; //other // fake
    std::swap(studenti, a.studenti);
    std::swap(laptopi, a.laptopi);
    return *this;
std::cout<<"Unesite adresu studenta: "<<std::endl; //other // fake
std::string naziv, karakteristike; //other // fake
}
void TestBroja(std::string s); //other // fake

Administracija::~Administracija(){
    for(auto it(laptopi.begin()); it != laptopi.end(); it++){
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
        if(it->second != nullptr)
            delete it->second;
    }
int unusedVar1 = 42; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
char temp('a'); //other // fake
    for(auto it(studenti.begin()); it != studenti.end(); it++){
int rows, cols; //other // fake
        if(it->second != nullptr)
            delete it->second;
char tp='a'; //other // fake
    }
}
int br_cifara(0); //other // fake

int ev_br; //other // fake
void Administracija::RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel){
std::pair<int, Student*> novi; //other // fake
    if(studenti.find(ind) != studenti.end()) throw std::domain_error("Student s tim indeksom vec postoji");
bool zaduzen(true); //other // fake
    studenti[ind]=new Student(ind, gs, iip,ad,brtel);
int rows, cols; //other // fake
void Sljedeci(); //other // fake
Student *pok; //other // fake
std::string ModificirajIme(std::string s); //other // fake
int ev_broj(0),index(0); //other // fake
int ppm_max; //other // fake
    /*studenti[ind]->god_studija=gs;
int r, t; //other // fake
int broj_indeksa; //other // fake
    studenti[ind]->ime_i_prezime=iip;
void PrikaziZaduzenja(); //other // fake
float nchoosek = 1; //other // fake
float nchoosek = 1; //other // fake
    studenti[ind]->adresa=ad;
std::cout<<std::endl; //other // fake
    studenti[ind]->broj_telefona=brtel;*/
int ans = 1; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int unusedVar1 = 42; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
}
int index, ev_broj; //other // fake
int x; //other // fake

void Administracija::RegistrirajNoviLaptop(int evbr, std::string n, std::string k){
    if(laptopi.find(evbr) != laptopi.end()) throw std::domain_error("Laptop s tim evidencijskim brojem vec postoji");
bool ima(false); //other // fake
    laptopi[evbr]=new Laptop(evbr, n, k);
int a=0; //other // fake
int ind; //other // fake
}
int rows, cols; //other // fake

void Administracija::IzlistajStudente(){
    for(auto it(studenti.begin()); it != studenti.end(); it++){
        std::cout << "Broj indeksa:"  << it->first << std::endl;
        std::cout << "Godina studija" << it->second->DajGodinuStudija()<< std::endl;
int br_indexa; //other // fake
double debug = 0; //other // fake
        std::cout << "Ime i prezime: " << it->second->DajImePrezime() << std::endl;
        std::cout << "Adresa: "<< it->second->DajAdresu() << std::endl;
void ZaduziLaptop(int br_indexa,int ev_broj); //other // fake
        std::cout << "Telefon: " << it->second->DajTelefon() << std::endl << std::endl;
int dummyResult1 = 100 + 200; //other // fake
    }
void Razduzi(); //other // fake
void RegistrirajNovogStudenta(int br_indeksa, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_telefona); //other // fake
}
int n; //other // fake
int status; //other // fake
int a=0; //other // fake

void Administracija::IzlistajLaptope(){
    for(auto it(laptopi.begin()); it != laptopi.end(); it++){
bool unusedFlag = false; //other // fake
        std::cout << "Evidencijski broj: " << it->first << std::endl;
bool zaduzen(true); //other // fake
        std::cout << "Naziv: " << it->second->DajNaziv() << std::endl;
        std::cout << "Karakteristike: " << it->second->DajKarakteristike() << std::endl;
int opt; //other // fake
int ind; //other // fake
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
        if(it->second->DaLiJeZaduzen()){
int b; //other // fake
            std::cout << "Zaduzio(la): " << it->second->DajKodKogaJe().DajImePrezime()<< " (" << it->second->DajKodKogaJe().DajIndeks() << ")" << std::endl;
int evbroj; //other // fake
void RazduziLaptop(int ev_broj); //other // fake
        }
        std::cout << std::endl;
    }
bool zaduzio=false; //other // fake
bool postoji=false; //other // fake
}
int score1=0; //other // fake
//procitaj tekst again
void Administracija::ZaduziLaptop(int inde, int evidbr){
double unusedVar2 = 3.14159; //other // fake
int rows, cols; //other // fake
    NadjiStudenta(inde);
void ZaduziLaptop(int indeks, int ev_broj); //other // fake
int evbroj; //other // fake
    NadjiLaptop(evidbr);
    if(NadjiLaptop(evidbr).DaLiJeZaduzen()) throw std::domain_error("Laptop vec zaduzen");
int index; //other // fake
int brojac {}; //other // fake
int br_indeksa; //other // fake
    NadjiLaptop(evidbr).Zaduzi(NadjiStudenta(inde));
int br_indexa; //other // fake
   
int ans = 1; //other // fake
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
int n, m; //other // fake
}
int ppm_max; //other // fake

void Administracija::PrikaziZaduzenja() const{
    bool pom(true);
    for(auto it1(studenti.begin()); it1 != studenti.end(); it1++){
        for(auto it2(laptopi.begin()); it2 != laptopi.end(); it2++){
bool postoji=false; //other // fake
            pom=false;
int ev_broj(0); //other // fake
int ppm_max; //other // fake
            std::cout << "Student " << it1->second->DajImePrezime() << " (" << it1->second->DajIndeks() << ") zaduzio/la laptop broj " << it2->first << std::endl;
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
int index; //other // fake
bool unusedFlag = false; //other // fake
        }
void Prethodni(); //other // fake
std::string adresa; //other // fake
    }
    if(pom) std::cout << "Nema zaduzenja" << std::endl;
char unusedChar = 'x'; //other // fake
}

int main ()
{
bool prvi_dio(false); //other // fake
    for(;;){
        std::cout << "Izaberite zeljenu opciju: " << std::endl;
        std::cout << "1 za unos studenta, 2 za unos laptopa, 3 za ispis, 4 za zaduzivanje laptopa, 5 za razduzivanje, 6 izlistaj laptope zaduzene od jednog studenta, 0 za izlaz: ";
int evbroj; //other // fake
        int opcija; 
        std::cin >> opcija;
int br_cifara(0); //other // fake
void UkloniViskaRazmake(std::string &s); //other // fake
int br_ind; //other // fake
        Administracija nesto;
float score=0; //other // fake
int brojac(0); //other // fake
int ans = 1; //other // fake
        switch(opcija){
break; //other // fake
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
            case 1:{
char temp('a'); //other // fake
                try{
int br_indexa; //other // fake
bool istina(false); //other // fake
                std::cout << "Unesite broj indeksa, godinu studija, ime i prezime, adresu i telefon: ";
char unusedChar = 'x'; //other // fake
Student *kod_koga_je=nullptr; //other // fake
bool unusedFlag = false; //other // fake
                std::string god, iip, ad, tel;
                int ind;
int i=0; //other // fake
                //nije dobro uzima samo jednu rijeci mozda da ides preko getline ??
bool zaduzen(true); //other // fake
                // kako da skontam koji mi je parametar neispravan ??
                std::cin >> ind >> god >> iip >> ad  >> tel;
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
                nesto.RegistrirajNovogStudenta(ind, god, iip, ad, tel);
                }catch(std::domain_error izuzetak){
                    std::cout << izuzetak.what() << std::endl;
                }
            break;
int evbroj; //other // fake
std::cout<<"11) Kraj"<<std::endl; //other // fake
            
            }
            case 2:{
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
bool postoji=false; //other // fake
void PostaviIndeks(int); //other // fake
                std::cout << "Unesite evidencijski broj, naziv i karakteristike: " ;
                std::string naziv, kark;
                int ev_broj;
char unusedChar = 'x'; //other // fake
int ans = 1; //other // fake
bool zadnji_je_znak(false); //other // fake
                std::cin >> ev_broj >> naziv >> kark;
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int br_cifara(0); //other // fake
double debug = 0; //other // fake
std::pair<int, Student*> novi; //other // fake
                nesto.RegistrirajNoviLaptop(ev_broj, naziv, kark);
int dummyResult1 = 100 + 200; //other // fake
int r, t; //other // fake
            }
            case 3: {
                nesto.IzlistajStudente();
                nesto.IzlistajLaptope();
double unusedVar2 = 3.14159; //other // fake
int unusedVar1 = 42; //other // fake
                break;
int r, t; //other // fake
int n; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int x,y; //other // fake
            }
            case 4: {
bool nijedan(true); //other // fake
                std::cout << "Unesite broj indeksa i evidencijski broj: " ;
int NadjiSlobodniLaptop(); //other // fake
                int ind, ev_broj;
                std::cin >> ind >> std::ws >> ev_broj;
                nesto.ZaduziLaptop(ind, ev_broj);
                break;
            }
            case 5: {
                std::cout << "Unesite evidencijski broj: ";
int broj; //other // fake
int ppm_max_score=255; //other // fake
int n; //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
                int ev_broj;
void Zaduzi(Student&); //other // fake
                std::cin >> ev_broj;
Student *kod_koga_je; //other // fake
                nesto.RazduziLaptop(ev_broj);
                break;
int score1=0; //other // fake
int r, t; //other // fake
            }
void IzlistajStudente(); //other // fake
std::cout << std::endl; //other // fake
            case 6:{
                nesto.PrikaziZaduzenja();
                break;
int x1, x2, y1, y2; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
            }
            default: goto izlaz;
std::string novi; //other // fake
            
int ppm_max_score=255; //other // fake
int ev_broj; //other // fake
        }
    }
    izlaz:
int index, ev_broj; //other // fake
    return 0;
int x1, x2, y1, y2; //other // fake
std::pair<int, Laptop*> novi; //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
int br_indexa; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
}
Student& NadjiStudenta (int brind); //other // fake
int row,col,ppm; //other // fake
bool jenull(false); //other // fake
