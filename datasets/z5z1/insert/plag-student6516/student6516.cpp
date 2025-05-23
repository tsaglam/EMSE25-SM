#include <iostream>
int opt; //other // fake
#include <stdexcept>
void RegistrirajNovogStudenta (int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel); //other // fake
#include <string>
#include <cstring>
int br_cifara(0); //other // fake
#include <map>


class Student
{
void RegistrirajNoviLaptop(int evbr, std::string n, std::string k); //other // fake
bool TestIndexa(int broj); //other // fake
void Sljedeci(); //other // fake
    
void RegistrirajNovogStudenta(int br_indeksa, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_telefona); //other // fake
    int index;
    std::string god;
    std::string ime;
    std::string stanovanje;
bool TestirajIndeks(int x); //other // fake
    std::string telefon;

public:
    Student (int br_indexa,std::string godina,std::string ime_pr, std::string adresa,std::string broj):index(br_indexa),
    god(godina),ime(ime_pr),stanovanje(adresa),telefon(broj){
        
        int k=0;
int brojac {}; //other // fake
void RazduziLaptop(int evbroj); //other // fake
int rows, cols; //other // fake
float nchoosek = 1; //other // fake

        int proba=index;
        while(proba!=0) {
            proba=proba/10;
            k++;
int broj; //other // fake
double unusedVar2 = 3.14159; //other // fake
        }
        if(k!=5 ) throw std::domain_error("Neispravni parametri");

int ev_br; //other // fake
        std::string s("1/B");
void Zaduzi(Student&); //other // fake
int x1, x2, y1, y2; //other // fake
float score=0; //other // fake
int x,y; //other // fake
        std::string s1("2/B");
        std::string s2("3/B");
int broj_rijeci(0); //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
        if(god.size()==1 &&(god[0]=='1' || god[0]=='2'|| god[0]=='3')){
int crta(0), crtica(0); //other // fake
Student &DajKodKogaJe(); //other // fake
bool t(false); //other // fake
            if(god[0]=='1') god=s;
            if(god[0]=='2') god=s1;
            if(god[0]=='3') god=s2;
int dummyResult1 = 100 + 200; //other // fake
        }
        else {
int znak; //other // fake
void IzlistajStudente(); //other // fake
            int a=0;
        if((god[0]=='1' || god[0]=='2'|| god[0]=='3')&&(god[1]=='/') && (god[2]=='M' || god[2]=='B' || god[2]=='D')) a=1;
        else throw std::domain_error("Neispravni parametri");
int x,y; //other // fake
int row,col,ppm; //other // fake
        }
        
bool razmak(true); //other // fake
int broj_indeksa; //other // fake
Student* kod_koga_je; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
        bool a,b;
bool prvi_dio(false); //other // fake
        for(int i=0; i<ime.size(); i++) {
            a=true;
            if(i!=0){
void RegistrirajNovogStudenta (int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel); //other // fake
            if(((ime[i+1]>='A' && ime[i+1]<='Z') || (ime[i+1]>='a' && ime[i+1]<='z'))&&((ime[i-1]>='A' && ime[i-1]<='Z') || (ime[i-1]>='a' && ime[i-1]<='z')))a=false;
int br_ind; //other // fake
            }
            
int status; //other // fake
float score=0; //other // fake
int nwords = 0; //other // fake
                if(ime[i]==' '&& a==true ){
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
                     for(int j=i; j<ime.size(); j++) {
                         ime[j]=ime[j+1];
            }i--;
int znak; //other // fake
                    
bool razmak(true), pocetak(true); //other // fake
int ans = 1; //other // fake
                    ime.resize(ime.size()-1);
                }
        }
        int m;
        for(m=0; m<telefon.size(); m++) {
            if(telefon[m]=='/' || telefon[m]=='-' || (telefon[m]>='0' && telefon[m]<='9')) continue;
            else break;
        }
int br(0); //other // fake
int br1=0,br2=0; //other // fake
        if(m!=telefon.size()) throw std::domain_error("Neispravni parametri");
int ppm_max; //other // fake
      
    }
    int DajIndeks() {
        return index;
double unusedVar2 = 3.14159; //other // fake
bool I1(true),I2(false),I3(false); //other // fake
    }
    std::string DajGodinuStudija() {
char temp('a'); //other // fake
int r, t; //other // fake
        return god;
    }
    std::string DajImePrezime() {
bool prvi_dio(false); //other // fake
int br_ind,ev_br; //other // fake
int i(0); //other // fake
Student* kod_koga_je; //other // fake
        return ime;
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
void PrikaziZaduzenja(); //other // fake
int znak; //other // fake
bool razmak = true; //other // fake
    }
void ZaduziLaptop(int indeks, int ev_broj); //other // fake
void Ispisi() const; //other // fake
    std::string DajAdresu() {
        return stanovanje;
int izbor; //other // fake
    }
    std::string DajTelefon() {
        return telefon;
int brojac {}; //other // fake
    }
    void Ispisi() {
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
bool TestIndexa(int broj); //other // fake
bool razmak = true; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int rows, cols; //other // fake
        std::cout<<"Broj indeksa: "<<DajIndeks() << std::endl<<
                 "Godina studija: "<<DajGodinuStudija()<<std::endl<<"Ime i prezime: "<<DajImePrezime()<<
                 std::endl<<"Adresa: "<<DajAdresu()<<std::endl<<"Telefon: "<<DajTelefon()<<std::endl;
int i=0; //other // fake
int score1=0; //other // fake
void RegistrirajNovogStudenta (int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel); //other // fake
Student& NadjiStudenta(int index); //other // fake
    }

};
class Laptop
{
    int ev_broj;
    std::string naziv;
    std::string karakteristike;
    Student *kod_koga_je;
public:
    Laptop(int broj,std::string ime,std::string kar): naziv(ime),karakteristike(kar), kod_koga_je(nullptr) {
        if(broj<0) throw std::domain_error("Neispravni parametri");
int ans = 1; //other // fake
Student *kod_koga_je; //other // fake
        ev_broj=broj;
    }

    int DajEvidencijskiBroj() {
int brojkosih{0}, brojcrtica{0}; //other // fake
bool TestirajIndeks(int x); //other // fake
int i(0); //other // fake
kod_koga_je=nullptr; //other // fake
bool zadnji_je_znak(false); //other // fake
Student* s; //other // fake
        return ev_broj;
    }
    std::string DajNaziv() {
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
int brojac {}; //other // fake
double unusedVar2 = 3.14159; //other // fake
        return naziv;
    }
    std::string DajKarakteristike() {
bool ima(false); //other // fake
        return karakteristike;
    }
    void Zaduzi(Student &s) {
std::pair<int, Laptop*> novi; //other // fake
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
        if(kod_koga_je!=nullptr) throw std::domain_error("Laptop vec zaduzen") ;
void Zaduzi(Student &student); //other // fake
int ev_broj(0); //other // fake
int crta(0), crtica(0); //other // fake
int status; //other // fake
        kod_koga_je=&s;
int ans = 1; //other // fake
int izbor; //other // fake
bool unusedFlag = false; //other // fake
int unusedVar1 = 42; //other // fake
int row,col,ppm; //other // fake
int ppm_max; //other // fake
int n(0); //other // fake
bool zaduzen(true); //other // fake

    }
    void Razduzi() {
        if(kod_koga_je!=nullptr) kod_koga_je=nullptr;
int evi; //other // fake
    }
    bool DaLiJeZaduzen() {
int pom1; //other // fake
        return !(kod_koga_je==nullptr);
int ev_broj; //other // fake
int nwords = 0; //other // fake
int x1, x2, y1, y2; //other // fake
        
    }
Student &DajKodKogaJe(){
    if(kod_koga_je==nullptr) throw std::domain_error("Laptop nije zaduzen") ;
    return *kod_koga_je;
bool postoji(false); //other // fake
int br1=0,br2=0; //other // fake
}
    Student *DajPokKodKogaJe() {
        return kod_koga_je;
int x,y; //other // fake
    }
    void Ispisi() {
std::string bezrazmaka; //other // fake
int NadjiSlobodniLaptop(); //other // fake
std::string rezultat(""); //other // fake
        std::cout<<"Evidencijski broj: "<<DajEvidencijskiBroj()<<std::endl<<
                 "Naziv: "<<DajNaziv()<<std::endl<<"Karakteristike: "<<DajKarakteristike();
    }

void RazduziLaptop(int ev_broj); //other // fake
};
class Administracija
{

    std::map<int,Laptop*> laptopi;
    std::map<int,Student*> studenti;
public:
Administracija(){}
bool ProvjeraIndeksa(int broj); //other // fake
~Administracija(){
    for(auto it=laptopi.begin();it!=laptopi.end();it++){
        delete laptopi[it->first];
    }
    for(auto it=studenti.begin();it!=studenti.end();it++){
double debug = 0; //other // fake
int ev_broj; //other // fake
int n(0); //other // fake
        delete studenti[it->first];
std::string DajGodinuStudija(); //other // fake
Student *kod_koga_je; //other // fake
    }
}
Administracija (const Administracija &a);
Administracija(Administracija &&a):laptopi(a.laptopi),studenti(a.studenti){}
Administracija &operator = (const Administracija &a);
Administracija &operator =(Administracija &&a);
Student &DajKodKogaJe(); //other // fake
void RegistrirajNovogStudenta(int br_indexa,std::string godina,std::string ime_pr, std::string adresa,std::string broj);
void RegistrirajNoviLaptop(int broj,std::string ime,std::string kar);
Student &NadjiStudenta(int br);
Laptop &NadjiLaptop(int br2);
void IzlistajStudente() const;
void IzlistajLaptope() const;
void ZaduziLaptop( int in,int ev);
void RazduziLaptop(int ev);
void PomjeriZa(int pomak); //other // fake
void PrikaziZaduzenja()const;

bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake

};
float score=0; //other // fake
int ind; //other // fake

Administracija::Administracija (const Administracija &a){
void Prethodni(); //other // fake
    for(auto it=a.laptopi.begin();it!=a.laptopi.end();it++){
int score1=0; //other // fake
        laptopi[it->first]=new Laptop (*(it->second));
    }
    for(auto it=a.studenti.begin();it!=a.studenti.end();it++){
int evbroj; //other // fake
int br_indeksa; //other // fake
float score=0; //other // fake
        studenti[it->first]=new Student (*(it->second));
    }
int index; //other // fake
    
}
Administracija &Administracija::operator = (const Administracija &a){
    for(auto it=a.laptopi.begin();it!=a.laptopi.end();it++){
typedef std::map<int, Laptop*> MapaLaptopa; //other // fake
        laptopi[it->first]=new Laptop (*(it->second));
int sati,minute,sekunde; //other // fake
void TestBroja(std::string s); //other // fake
int ev_broj(0); //other // fake
bool postoji=false; //other // fake
    }
    for(auto it=a.studenti.begin();it!=a.studenti.end();it++){
float nchoosek = 1; //other // fake
bool unusedFlag = false; //other // fake
bool TestirajTelefon(std::string s); //other // fake
bool postoji=false; //other // fake
        studenti[it->first]=new Student (*(it->second));
bool nemaZaduzenja = true; //other // fake
    }
int brojac {}; //other // fake
    return *this;
}
Administracija &Administracija::operator =(Administracija &&a){
Student &DajKodKogaJe(); //other // fake
int ppm_max; //other // fake
int brojac_cr(0),brojac_ks(0),brojac_s(0); //other // fake
    laptopi=a.laptopi;
    studenti=a.studenti;
std::pair<int, Laptop*> novi; //other // fake
    return *this;
}
Student* s; //other // fake
void Administracija::RegistrirajNovogStudenta(int br_indexa,std::string godina,std::string ime_pr, std::string adresa,std::string broj){
int znak; //other // fake
    if(studenti.count(br_indexa)) throw std::domain_error("Student s tim indeksom vec postoji");
    Student s(br_indexa,godina,ime_pr,adresa,broj);
void TestGodine(std::string s); //other // fake
    s.DajGodinuStudija()=godina;
    s.DajImePrezime()=ime_pr;
float score=0; //other // fake
Student& NadjiStudenta(int br_indeksa); //other // fake
bool I1(true),I2(false),I3(false); //other // fake
    s.DajAdresu()=adresa;
int opcija; //other // fake
    s.DajTelefon()=broj;
typedef std::map<int, Student*> MapaStudenata; //other // fake
    studenti[br_indexa]=new Student(s);
}
int br_indexa; //other // fake
int br_indeksa; //other // fake
void Administracija::RegistrirajNoviLaptop(int broj,std::string ime,std::string kar){
    if(laptopi.count(broj)) throw std::domain_error("Laptop s tim evidencijskim brojem vec postoji");
    laptopi[broj]=new Laptop(broj,ime,kar);
int evbroj, indeks; //other // fake
void RazduziLaptop(int evbroj); //other // fake
    
Student *pok; //other // fake
bool postoji=false; //other // fake
}
Student &Administracija::NadjiStudenta(int br){
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int score1=0; //other // fake
bool prvi_dio(false); //other // fake
    if(!studenti.count(br)) throw std::domain_error("Student nije nadjen");
int sati,minute,sekunde; //other // fake
    return *studenti[br];
}
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
bool unusedFlag = false; //other // fake
Laptop &Administracija::NadjiLaptop(int br2){
int ev_broj; //other // fake
    if(!laptopi.count(br2)) throw std::domain_error("Laptop nije nadjen");
    return *laptopi[br2];
Student& NadjiStudenta(int br_indeksa); //other // fake
}
int status; //other // fake
void UkloniViskaRazmake(std::string &s); //other // fake
void ZaduziLaptop(int br_indeksa, int ev_broj); //other // fake
void Administracija::IzlistajStudente() const{//JEL TREBASSS SVE ISPISATII!!!!!!!
int row,col,ppm; //other // fake
int i(0); //other // fake

    for(auto it=studenti.begin();it!=studenti.end();it++){
       std::cout<<"Broj indeksa: "<<it->first<< std::endl<<
                 "Godina studija: "<<(it->second)->DajGodinuStudija()<<std::endl<<"Ime i prezime: "<<(it->second)->DajImePrezime()<<
                 std::endl<<"Adresa: "<<(it->second)->DajAdresu()<<std::endl<<"Telefon: "<<(it->second)->DajTelefon()<<std::endl<<std::endl;
    }
int brojac(0); //other // fake
}
void Administracija::IzlistajLaptope() const{//JEL TREBASSS SVE ISPISATII!!!!!!!
bool a=true;
std::string ModificirajIme(std::string s); //other // fake
int br_ind,ev_br; //other // fake
    for(auto it=laptopi.begin();it!=laptopi.end();it++){
       
       
bool postoji=false; //other // fake
void RazduziLaptop(int evbroj); //other // fake
float nchoosek = 1; //other // fake
int ev_broj; //other // fake
        std::cout<<"Evidencijski broj: "<<it->first<<std::endl<<
                 "Naziv: "<<(it->second)->DajNaziv()<<std::endl<<"Karakteristike: "<<(it->second)->DajKarakteristike()<<std::endl;
       if((it->second)->DaLiJeZaduzen()){
           Student s((it->second)->DajKodKogaJe());
Student* DajPokKodKogaJe(); //other // fake
int brojkosih{0}, brojcrtica{0}; //other // fake
int x1, x2, y1, y2; //other // fake
           std::cout<<"Zaduzio(la): "<<s.DajImePrezime()<<" ("<<s.DajIndeks()<<")"<<std::endl<<std::endl;
          a =false;
int ppm_max_score=255; //other // fake
       }
int rows, cols; //other // fake
char unusedChar = 'x'; //other // fake
int brojac(0); //other // fake
       if(a==true) std::cout<<std::endl;
double debug = 0; //other // fake
    }
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
bool t(false); //other // fake
}
int row,col,ppm; //other // fake
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
void Administracija::ZaduziLaptop( int in,int ev){
    if(!laptopi.count(ev)) throw std::domain_error("Laptop nije nadjen");
int score1=0; //other // fake
void NormalizirajImeIliAdresu(std::string &s); //other // fake
    if(!studenti.count(in)) throw std::domain_error("Student nije nadjen");
    if(laptopi[ev]->DaLiJeZaduzen()) throw std::domain_error("Laptop vec zaduzen");
    //fali jos jedan izuzetak
bool zadnji_je_znak(false); //other // fake
void ZaduziLaptop(int inde, int evidbr); //other // fake
    
    laptopi[ev]->Zaduzi(*studenti[in]);
}
void Administracija::RazduziLaptop(int ev){
Student *pok; //other // fake
    if(!laptopi.count(ev)) throw std::domain_error("Laptop nije nadjen");
    if(!laptopi[ev]->DaLiJeZaduzen()) throw std::domain_error("Laptop nije zaduzen");
int r_l; //other // fake
Student *kod_koga_je=nullptr; //other // fake
    laptopi[ev]->Razduzi();
void IzlistajStudente(); //other // fake
int evi; //other // fake
void UnistiMapuStudenata (std::map<int,Student*> &mapa); //other // fake
bool I1(true),I2(false),I3(false); //other // fake
}
bool zadnji_je_znak(false); //other // fake
void Administracija::PrikaziZaduzenja()const{
    int i=0;
    for(auto it=laptopi.begin();it!=laptopi.end();it++){
int pom1; //other // fake
int br(0); //other // fake
       
        if((it->second)->DaLiJeZaduzen()){
             Student s((it->second)->DajKodKogaJe());
void PostaviIndeks(int); //other // fake
int n(0); //other // fake
double unusedVar2 = 3.14159; //other // fake
int unusedVar1 = 42; //other // fake
void PomjeriZa(int pomak); //other // fake
void RazduziLaptop(int ev_broj); //other // fake
            std::cout<<"Student "<<s.DajImePrezime()<<" ("<<s.DajIndeks()<<") zaduzio/la laptop broj "<<it->first<<std::endl;
            i++;
        }
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
short digits = 1; //other // fake
void RegistrirajNovogStudenta (int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel); //other // fake
    }
double debug = 0; //other // fake
    if(i==0) std::cout<<"Nema zaduzenja";
int ev_broj; //other // fake
}


int znak; //other // fake
int main ()
{
try{
    Administracija a;
    a.RegistrirajNovogStudenta(12345,"1/B","Azra Ka","Josipa","062/330-987");
int br_indeksa; //other // fake
    a.RegistrirajNoviLaptop(2,"Je","d569");
bool zaduzen(true); //other // fake
    a.ZaduziLaptop(12345,2);
bool razmak(true); //other // fake
    a.IzlistajLaptope();
int r, t; //other // fake
Student *kod_koga_je{nullptr}; //other // fake
    a.IzlistajStudente();
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
    
}
catch(std::domain_error iu){
    std::cout << iu.what();
bool ispravno_1=false, ispravno_2=false; //other // fake
bool zaduzen(true); //other // fake
int ind; //other // fake
}

    return 0;
int status; //other // fake
}
