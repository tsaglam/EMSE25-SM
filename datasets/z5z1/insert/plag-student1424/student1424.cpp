#include <iostream>
#include <string>
#include <stdexcept>
bool TestirajIndeks(int x); //other // fake
#include <map>

std::string Postavi (const std::string& ime_i_prezime)
{
    std::string novi;
int ev_broj; //other // fake
    for(int i=0; i<ime_i_prezime.length(); i++) {

        int j=i;
        while(j<ime_i_prezime.length() && ime_i_prezime[j]==' ') j++;
        if(i!=0 && j!=ime_i_prezime.length()) novi.push_back(ime_i_prezime[i]);
        if(j!=ime_i_prezime.length() && ( i!=j || i==0)) novi.push_back(ime_i_prezime[j]);
        i=j;
int score1=0; //other // fake
int ev_broj; //other // fake
    }
    return novi;

}

std::string Studiji[] {"1", "2", "3", "1/B", "2/B", "3/B","1/M", "2/M", "3/M","1/D", "2/D", "3/D"};
class Student
{
    int broj_indeksa;
    std::string godina_studija, ime_i_prezime, adresa,  broj_telefona;

Student& NadjiStudenta(int br_indeksa); //other // fake
public:

void Razduzi(); //other // fake
    Student (int broj_indeksa, std::string godina_studija, std::string ime_i_prezime, std::string adresa,
             std::string telefon)   {
        Student::broj_indeksa=broj_indeksa;
        {
bool postoji(false); //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
char tp='a'; //other // fake
            int i(0);
float score=0; //other // fake
            for( i=0; i<12; i++) {
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
                if(godina_studija==Studiji[i]) {
                    Student::godina_studija=Studiji[i];
int broj_indeksa; //other // fake
Student *kod_koga_je=nullptr; //other // fake
int brojac(0); //other // fake
                    break;
                }
            }
int znak; //other // fake
            if(i==12) throw std::domain_error("Neispravni parametri");
int ind; //other // fake
int br1=0,br2=0; //other // fake
short digits = 1; //other // fake
bool I1(true),I2(false),I3(false); //other // fake
        }
bool postoji=false; //other // fake
        Student::ime_i_prezime=Postavi(ime_i_prezime);
void Zaduzi(Student &student); //other // fake
        Student::adresa=Postavi(adresa);


        int i=0;
int dummyResult1 = 100 + 200; //other // fake

short digits = 1; //other // fake
        while(i<telefon.length() && (telefon[i]<='9' && telefon[i]>='0')  ) i++;
int ev_broj; //other // fake
int row,col,ppm; //other // fake
        if(i==0 || i==telefon.length() || telefon[i]!='/') {
            throw std::domain_error("Neispravni parametri");
        }
int ppm_max_score=255; //other // fake
        i++;
        while(i<telefon.length() && telefon[i]<='9' && telefon[i]>='0'  )i++;
        if(i==telefon.length() || telefon[i]!='-')throw std::domain_error("Neispravni parametri");
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
float nchoosek = 1; //other // fake
char unusedChar = 'x'; //other // fake
        i++;
        while(i<telefon.length() && telefon[i]<='9' && telefon[i]>='0'  )i++;
void RazduziLaptop (int ev_broj); //other // fake
        if(i!=telefon.length())throw std::domain_error("Neispravni parametri");
        broj_telefona=telefon;
int br=0; //other // fake
    }
    std::string DajImePrezime() const {
float nchoosek = 1; //other // fake
        return ime_i_prezime;
    }
void RegistrirajNovogStudenta(int br_indeksa, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_telefona); //other // fake
    std::string DajAdresu() const {
        return adresa;
    }
    std::string DajTelefon() const {
        return broj_telefona;
double debug = 0; //other // fake
int indeks; //other // fake
bool ima(false); //other // fake
    }
    int DajIndeks() const {
int opt; //other // fake
int i(0); //other // fake
        return broj_indeksa;
    }
    std::string DajGodinuStudija() const {

int indeks; //other // fake
int dummyResult1 = 100 + 200; //other // fake
        if(godina_studija.size()==1 && godina_studija[0]-'0'<4) return Studiji[godina_studija[0]-'0'+2];
void NormalizirajImeIliAdresu(std::string &s); //other // fake
        return godina_studija;
    }
    void Ispisi() const {
        std::cout<<"Broj indeksa: "<<broj_indeksa<<std::endl
                 <<"Godina studija: "<<DajGodinuStudija()<<std::endl
                 <<"Ime i prezime: "<<ime_i_prezime<<std::endl
                 <<"Adresa: "<<adresa<<std::endl
                 <<"Telefon: "<<broj_telefona<<std::endl;
    }
};

int br(0); //other // fake
class Laptop
{
    int ev_broj;
    std::string naziv;
void TestGodine(std::string s); //other // fake
void PomjeriZa(int pomak); //other // fake
Student *DajPokKodKogaJe(); //other // fake
    std::string karakteristike;
    Student* kod_koga_je;
public:
    Laptop(int ev_broj, std::string naziv, std::string karakteristike):  naziv(naziv),
        karakteristike(karakteristike) {
int brojac=1; //other // fake
        if(ev_broj<0) throw std::domain_error("Neispravni parametri");
std::string ime_i_prezime; //other // fake
        Laptop::ev_broj=ev_broj;
        kod_koga_je=nullptr;
int x1, x2, y1, y2; //other // fake
std::string ime, adresa, telefon, godina_studija; //other // fake
    }
    int DajEvidencijskiBroj() const {
throw std::domain_error("Student je vec zaduzio laptop"); //other // fake
Student *pok; //other // fake
        return ev_broj;
int status; //other // fake
int br; //other // fake
int dummyResult1 = 100 + 200; //other // fake
    }
    std::string DajNaziv() const {
        return naziv;
void PomjeriZa(int pomak); //other // fake
bool ima=0; //other // fake
int dummyResult1 = 100 + 200; //other // fake
void ZaduziLaptop(int index, int ev_broj); //other // fake
int br_indeksa; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
    }
    std::string DajKarakteristike() const {
        return karakteristike;
    }
    void Zaduzi(Student& a) {
        if(kod_koga_je!=nullptr) throw std::domain_error("Laptop vec zaduzen");
int b_i; //other // fake
        kod_koga_je=&a;
int score1=0; //other // fake
    }
    void Razduzi() {
std::string naziv; //other // fake
        if(kod_koga_je!=nullptr) kod_koga_je=nullptr;
    }
    bool DaLiJeZaduzen() const {
int unusedVar1 = 42; //other // fake
void IzlistajStudente(); //other // fake
int br(0); //other // fake
int i=0; //other // fake
double debug = 0; //other // fake
        return kod_koga_je!=nullptr;
    }
    Student& DajKodKogaJe() const {
        if(kod_koga_je==nullptr) throw std::domain_error("Laptop nije zaduzen");
        return *kod_koga_je;
int evbroj; //other // fake
    }
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
    Student* DajPokKodKogaJe() const {
Student *kod_koga_je; //other // fake
float nchoosek = 1; //other // fake
int r, t; //other // fake
        return kod_koga_je;
Student novi1(11111, "1", "a a", "a a", "1/2-3"); //other // fake
    }
    void Ispisi() const {
        std::cout<<"Evidencijski broj: "<<ev_broj<<std::endl
                 <<"Naziv: "<<naziv<<std::endl
                 <<"Karakteristike: "<<karakteristike<<std::endl;

int index(0); //other // fake
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
        //provjeriti je l treba novi red
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
    }
};

typedef std::map<int, Student*> MapaStudenata; //other // fake
class Administracija
{
    std::map<int, Student*> studenti;
    std::map<int, Laptop*>laptopi;
public:
    Administracija()=default; // provjeriti je li dafult
    Administracija(const Administracija& v) {
std::pair<int, Student*> novi; //other // fake
bool istina(false); //other // fake
        try {
int ans = 1; //other // fake

void IzlistajStudente(); //other // fake
            for(auto it=v.studenti.begin(); it!=v.studenti.end(); it++) {
                studenti.emplace(std::make_pair((it->first), new Student(*(it->second))));}
char unusedChar = 'x'; //other // fake
throw std::domain_error ( "Laptop nije nadjen" ); //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
bool zaduzio=false; //other // fake
            }
            catch(std::bad_alloc) {
int brojkosih{0}, brojcrtica{0}; //other // fake

int br_cifara(0); //other // fake
float nchoosek = 1; //other // fake
int row,col,ppm; //other // fake
                for(auto it=studenti.begin(); it!=studenti.end(); it++) {
                    delete it->second;
std::string ModificirajIme(std::string s); //other // fake
                }
                studenti.clear();
                throw;
float score=0; //other // fake
bool ProvjeraIndeksa(int broj); //other // fake
Student *kod_koga_je=nullptr; //other // fake
bool ispravno_1=false, ispravno_2=false; //other // fake
            }
            try {

                for(auto it=v.laptopi.begin(); it!=v.laptopi.end(); it++) {
bool zadnji_je_znak(false); //other // fake
                    laptopi.emplace(it->first, new Laptop(*(it->second)));
throw std::domain_error ("Laptop nije zaduzen"); //other // fake
                }}
                catch(std::bad_alloc) {
bool pom(true); //other // fake

                    for(auto it=laptopi.begin(); it!=laptopi.end(); it++) {
void UkloniViskaRazmake(std::string &s); //other // fake
std::map<int, Laptop*> laptopi; //other // fake
int unusedVar1 = 42; //other // fake
bool istina(false); //other // fake
                        delete it->second;
                    }
                    laptopi.clear();
                    throw;
std::cout<<"~  Dobro dosli na ETF-Laptoteku  ~\n"; //other // fake
int score1=0; //other // fake
                }
            }
Administracija(Administracija&& v){
int broj1; //other // fake
    if(&v!=this){
    studenti=v.studenti; laptopi=v.laptopi;
   for( auto it=v.laptopi.begin(); it!=v.laptopi.end(); it++) it->second=nullptr;
std::cout << std::endl; //other // fake
 for(auto it=v.studenti.begin(); it!=v.studenti.end(); it++) it->second=nullptr;
    } 
void Razduzi(); //other // fake
int b_i; //other // fake
bool prvi_dio(false); //other // fake
}
Administracija& operator =( Administracija v){
int ev_broj(0),index(0); //other // fake
     std::swap(studenti, v.studenti); std::swap(laptopi, v.laptopi);
Student *kod_koga_je=nullptr; //other // fake
    return *this;   
        
int opcija; //other // fake
void RazduziLaptop(int evbroj); //other // fake
int rows, cols; //other // fake
bool zaduzen(true); //other // fake
    }
Administracija&operator=(Administracija&& v){
bool zaduzio=false; //other // fake
int n(0); //other // fake
    if(&v!=this){
int br_indexa; //other // fake
int br1=0,br2=0; //other // fake
    studenti=v.studenti; laptopi=v.laptopi;
int dummyResult1 = 100 + 200; //other // fake
     for( auto it=v.laptopi.begin(); it!=v.laptopi.end(); it++) it->second=nullptr;
char unusedChar = 'x'; //other // fake
 for(auto it=v.studenti.begin(); it!=v.studenti.end(); it++) it->second=nullptr;}
 return *this;
typedef std::map<int, Student*> MapaStudenata; //other // fake
}
void RegistrirajNovogStudenta(int broj_indeksa, std::string godina_studija, std::string ime_i_prezime, std::string adresa,
             std::string telefon){
                 if(studenti.count(broj_indeksa)) throw std::domain_error("Student s tim indeksom vec postoji");
                 studenti.emplace(broj_indeksa, new Student(broj_indeksa, godina_studija, ime_i_prezime, adresa, telefon));
Student &DajKodKogaJe(); //other // fake
void IzlistajStudente(); //other // fake
             }
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike){
    if(laptopi.count(ev_broj)) throw std::domain_error("Laptop s tim evidencijskim brojem vec postoji");
    laptopi.emplace(ev_broj, new Laptop(ev_broj, naziv, karakteristike));
std::string godina_studija, ime_i_prezime, adresa, broj_telefona; //other // fake
int br1=0,br2=0; //other // fake
void TestBroja(std::string s); //other // fake
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
Student *kod_koga_je; //other // fake
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
}
Student & NadjiStudenta(int broj_indeksa){
int r, t; //other // fake
    if(!studenti.count(broj_indeksa)) throw std::domain_error("Student nije nadjen");
void TestGodine(std::string s); //other // fake
void RegistrirajNovogStudenta (int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel); //other // fake
    return *(studenti[broj_indeksa]);
}
Student  NadjiStudenta( int broj_indeksa) const {
bool zaduzio=false; //other // fake
bool prvi_dio(false); //other // fake
    if(!studenti.count(broj_indeksa)) throw std::domain_error("Student nije nadjen");
    auto it=studenti.find(broj_indeksa);
    return *(it->second);
int ev_broj; //other // fake
}
Laptop & NadjiLaptop(int ev_broj){
    if(!laptopi.count(ev_broj)) throw std::domain_error("Laptop nije nadjen");
    return *(laptopi[ev_broj]);
float nchoosek = 1; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
void IzlistajStudente(); //other // fake
int ppm_max_score=255; //other // fake
}
Laptop  NadjiLaptop( int ev_broj) const {
    if(!laptopi.count(ev_broj)) throw std::domain_error("Laptop nije nadjen");
int broj_indeksa; //other // fake
    auto it=laptopi.find(ev_broj);
double dummyResult2 = 50.0 / 3.0; //other // fake
    return *(it->second);
void ZaduziLaptop(int br_indeksa, int ev_broj); //other // fake
int ev_br; //other // fake
std::string godina_studija, ime_i_prezime, adresa, broj_telefona; //other // fake
int evi; //other // fake
void IzlistajStudente(); //other // fake
void PrikaziZaduzenja(); //other // fake
bool razmak(true); //other // fake
int r, t; //other // fake
}
void TestBroja(std::string s); //other // fake
void IzlistajStudente() const {
    for(auto it=studenti.begin(); it!=studenti.end(); it++){
       (*(it->second)).Ispisi(); std::cout<<std::endl<<std::endl;
void Prethodni(); //other // fake
int index(0); //other // fake
bool ima=0; //other // fake
int br_cifara(0); //other // fake
    }
int dummyResult1 = 100 + 200; //other // fake
char unusedChar = 'x'; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
}
void IzlistajLaptope() const {
    for(auto it=laptopi.begin(); it!=laptopi.end(); it++){
       (*(it->second)).Ispisi();
Student *kod_koga_je; //other // fake
std::map<int,Laptop*> StvoriMapu (const std::map<int,Laptop*> &mapa); //other // fake
void RegistrirajNovogStudenta (int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel); //other // fake
double unusedVar2 = 3.14159; //other // fake
        if((*(it->second)).DaLiJeZaduzen()){
int rows, cols; //other // fake
            std::cout<<std::endl<<"Zaduzio(la): "<<(((it->second)->DajKodKogaJe())).DajImePrezime()<<" ("<<
            (((it->second)->DajKodKogaJe())).DajIndeks()<<")";
char unusedChar = 'x'; //other // fake
        }
int ppm_max; //other // fake
void ZaduziLaptop(int inde, int evidbr); //other // fake
        std::cout<<std::endl<<std::endl;
    }
int brojkosih{0}, brojcrtica{0}; //other // fake
int* unusedPointer = new int(42); //other // fake
void RazduziLaptop(int ev_broj); //other // fake
std::string pom; //other // fake
}

void ZaduziLaptop(int broj_indeksa, int ev_broj){
    if(!studenti.count(broj_indeksa)) throw std::domain_error("Student nije nadjen");
int a=0; //other // fake
bool postoji=false; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
      if(!laptopi.count(ev_broj)) throw std::domain_error("Laptop nije nadjen");
int n; //other // fake
int brlaptopa{0}; //other // fake
      if(laptopi[ev_broj]->DaLiJeZaduzen()) throw std::domain_error("Laptop vec zaduzen");
      for( auto it=laptopi.begin(); it!=laptopi.end(); it++) if(((it->second)->DaLiJeZaduzen()) &&
      ((it->second)->DajKodKogaJe()).DajIndeks()==broj_indeksa)
      throw std::domain_error("Student je vec zaduzio laptop");
auto it(studenti.begin()),kraj(studenti.end()); //other // fake
      NadjiLaptop(ev_broj).Zaduzi(NadjiStudenta(broj_indeksa));
double dummyResult2 = 50.0 / 3.0; //other // fake
int ppm_max; //other // fake
int r_l; //other // fake
    
}
void Ispisi() const; //other // fake
int NadjiSlobodanLaptop(){
       bool nadjen(false); int broj;
     for( auto it=laptopi.begin(); it!=laptopi.end(); it++) {
  if(!((it->second)->DaLiJeZaduzen())) {nadjen=true; broj=it->first; break;}}
     if(!nadjen) throw std::domain_error("Nema slobodnih laptopa");
int br(0); //other // fake
    return broj;
int i(0); //other // fake
}
void RazduziLaptop(int ev_broj){
int indeks; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
    if(!laptopi.count(ev_broj)) throw std::domain_error("Laptop nije nadjen");
std::cout<<std::endl; //other // fake
int b; //other // fake
    if(!(laptopi[ev_broj]->DaLiJeZaduzen())) throw std::domain_error("Laptop nije zaduzen");
    laptopi[ev_broj]->Razduzi();
}

Student *DajPokKodKogaJe(); //other // fake
void PrikaziZaduzenja() const {
double unusedVar2 = 3.14159; //other // fake
bool zadnji_je_znak(false); //other // fake
float score=0; //other // fake
std::pair<int, Student*> novi; //other // fake
    bool zaduzeni(false);
for( auto it=laptopi.begin(); it!=laptopi.end(); it++) {
float score=0; //other // fake
    
  if(((it->second)->DaLiJeZaduzen())){
bool zadnji_je_znak(false); //other // fake
int broj; //other // fake
      std::cout<<"Student "<<(((it->second)->DajKodKogaJe())).DajImePrezime()<<" ("<<
            (((it->second)->DajKodKogaJe())).DajIndeks()<<") zaduzio/la laptop broj "<<it->first<<std::endl;
            //provjeriti novi red
            zaduzeni=true;
void UnistiMapuStudenata (std::map<int,Student*> &mapa); //other // fake
int ev_br; //other // fake
  }}
int n; //other // fake
  if(!zaduzeni) std::cout<<"Nema zaduzenja";
int br_indeksa; //other // fake
bool nijedan(true); //other // fake
int br_ind; //other // fake
Student *pok; //other // fake
MapaStudenata::const_iterator it(studenti.begin()); //other // fake
int evbroj; //other // fake
}
~Administracija(){
    for( auto it=laptopi.begin(); it!=laptopi.end(); it++) { delete it->second; it->second=nullptr;}
    for( auto it=studenti.begin(); it!=studenti.end(); it++) { delete it->second; it->second=nullptr;}
std::string pom; //other // fake
int index(0); //other // fake
int unusedVar1 = 42; //other // fake
    
int* unusedPointer = new int(42); //other // fake
bool zadnji_je_znak(false); //other // fake
int ev_broj(0); //other // fake
}
        };

//Laptop::kod_koga_je=nullptr;
int x1, x2, y1, y2; //other // fake


        int main () {
            try {
float nchoosek = 1; //other // fake
int rows, cols; //other // fake
int row,col,ppm; //other // fake
Administracija a;
int opcija; do{
              std::cout<<"Unesite neku od zeljenih opcija: "<<std::endl
              <<"1: Registriraj Novi Laptop"<<std::endl
              <<"2: Registriraj Novog Studenta"<<std::endl
              <<"3: Izlistaj Laptope"<<std::endl
              <<"4: IzlistajStudente"<<std::endl
              <<"5: Zaduzi Laptop"<<std::endl
              <<"6: PrikaziZaduzenja"<<std::endl
              <<"7: Nadji slobodan laptop"<<std::endl
              <<"8: Zavrsi"<<std::endl;
              std::cin>>opcija;
              switch(opcija){
                  case 8: 
int opcija; //other // fake
                  break;
                  case 1:
                  std::cout<<"Unesite evidencijski broj, naziv i karakteristike: ";
                  try{
                      
                  
void PostaviGodinu(std::string); //other // fake
                  int broj;
int i=0; //other // fake
int znak; //other // fake
double unusedVar2 = 3.14159; //other // fake
int indeks; //other // fake
                  std::string m,b;
                  std::cin>>broj;
Student* DajPokKodKogaJe(); //other // fake
int opcija; //other // fake
                  std::cin.clear();
bool zaduzen(true); //other // fake
bool zadnji_je_znak(false); //other // fake
                  std::cin.ignore(1000,'\n');
                  std::getline(std::cin, m);
                  std::getline(std::cin, b);
                   a.RegistrirajNoviLaptop(broj, m, b);
                  } catch(...){}
                  break;
int ev_broj; //other // fake
                  case 2: 
                  std::cout<<"Unesite  broj indeksa, godinu studija ime i prezime, adresu i telefon: ";
                  try{
                      
                  
                  int broj1;
                  std::string naz0, kar0,naz1,naz3;
                  std::cin>>broj1;
double dummyResult2 = 50.0 / 3.0; //other // fake
int crta(0), crtica(0); //other // fake
int n(0); //other // fake
char temp('a'); //other // fake
int rows, cols; //other // fake
void PostaviIndeks(int); //other // fake
int row,col,ppm; //other // fake
Laptop& NadjiLaptop(int ev_broj); //other // fake
                  std::cin.clear();
                  std::cin.ignore(1000,'\n');
                  std::getline(std::cin, naz0);
                  std::getline(std::cin, kar0);
                   std::getline(std::cin, naz1);
int br_indexa; //other // fake
int ppm_max; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
                    std::getline(std::cin, naz3);
double unusedVar2 = 3.14159; //other // fake
int ans = 1; //other // fake
char tp='a'; //other // fake
                    a.RegistrirajNovogStudenta(broj1,naz0,kar0,naz1,naz3);
                  
              } catch(std::domain_error iz ){
                  std::cout<<iz.what();
              }
              break;
int x; //other // fake
              case 3:
              a.IzlistajLaptope();
              break;
"0 - Kraj programa\n"; //other // fake
              case 4:
int x1, x2, y1, y2; //other // fake
              a.IzlistajStudente();
              case 5:
              try{
                  std::cout<<"Unesire evidencijski broj laptopa i broj indeksa studenta";
float score=0; //other // fake
                  int indeks, ev;
                  std::cin>>ev>>indeks;
int NadjiSlobodniLaptop(); //other // fake
int evbroj; //other // fake
                  a.ZaduziLaptop(indeks,ev);
int brojac(0); //other // fake
              }
              catch(std::domain_error iz ){
                  std::cout<<iz.what();
              }
              break;
              case 6:
              a.PrikaziZaduzenja();
              case 7:
Student &NadjiStudenta(int indeks); //other // fake
              try{ int brojz=a.NadjiSlobodanLaptop();
int r_l; //other // fake
char tp='a'; //other // fake
void RegistrirajNoviLaptop(int ev_br, std::string naz, std::string kar); //other // fake
                  std::cout<<"Slobodan laptop ima broj: "<<brojz;
              }
              catch(std::domain_error iz ){
int br1=0,br2=0; //other // fake
                  std::cout<<iz.what();
int index, ev_broj; //other // fake
Student* kod_koga_je; //other // fake
int row,col,ppm; //other // fake
              }
              break;
              
int ev_br; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
              
   } } while(opcija!=8);
            }
   catch(std::domain_error iz) {
                std::cout<<iz.what();
            }
            return 0;
std::string vrati; //other // fake
int ev_broj; //other // fake
        }
