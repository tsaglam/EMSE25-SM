#include <iostream>
int index, ev_broj; //other // fake
int x,y; //other // fake
#include <string>
#include <stdexcept>
#include <memory>
#include <vector>
void Prethodni(); //other // fake
class Student{
     int index;
void UkloniViskaRazmake(std::string &s); //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
     std::string ime, adresa, telefon, godina_studija;
     public:
     bool ProvjeraIndexa(int indeks){
          if(indeks<10000) return false;
          return true;
bool postoji=false; //other // fake
     }
     bool ProvjeraStudGodine(std::string god_stud){
          if(god_stud.length()>3 || god_stud.length()==2 || god_stud.length()==0) return false;
char temp('a'); //other // fake
int nwords = 0; //other // fake
    if(god_stud.length()==1 && god_stud[0]!='1' && god_stud[0]!='2' && god_stud[0]!='3') return false;
    if(godina_studija.length()==3) {
Student* kod_koga_je; //other // fake
    for(int i(0);i<3;i++) {
        if(god_stud[0]!='1' && god_stud[0]!='2' && god_stud[0]!='3') return false;
int NadjiSlobodniLaptop(); //other // fake
int izbor; //other // fake
        if(god_stud[1]!='/') return false;
        if(god_stud[2]!='B' && god_stud[2]!='M' && god_stud[2]!='D') return false;
short digits = 1; //other // fake
Student *kod_koga_je(nullptr); //other // fake
        if(god_stud[0]=='3' && god_stud[2]=='M') return false;
    }
    }
    return true;
int x1, x2, y1, y2; //other // fake
int sati,minute,sekunde; //other // fake
     }
     bool ProvjeraBrojaTelefona(std::string br_tel){
int ppm_max; //other // fake
int ev_br; //other // fake
          if(br_tel.length()<5) return false;
          for(int i=0;i<br_tel.length();i++) {
        if(br_tel[0]<'0' || br_tel[0]>'9')
            return false;
        if(br_tel[i]!='/' && br_tel[i]!='-' && (br_tel[i]<'0' || br_tel[i]>'9'))
            return false;
int br_ind,ev_br; //other // fake
        if(br_tel[br_tel.length()-1]=='-' || br_tel[br_tel.length()-1]=='/')
            return false;
    }
    int br1=0,br2=0;
void Sljedeci(); //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
    for(int i=0;i<br_tel.length();i++) {
        if(br_tel[i]=='/') {
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
float score=0; //other // fake
int b; //other // fake
            br1++;
            if(br1>1) return false;
void PostaviIndeks(int); //other // fake
        }
        if(br_tel[i]=='-') {
            br2++;
            if(br2>1) return false;
        }
bool ima(false); //other // fake
    }
int broj; //other // fake
    if(br1==0 || br2==0) return false;
    
    for(int i=0;i<br_tel.length();i++) {
char unusedChar = 'x'; //other // fake
        if(br_tel[i]=='/' && (br_tel[i-1]=='-' || br_tel[i+1]=='-')) 
            return false;
int ppm_max_score=255; //other // fake
bool zadnji_je_znak(false); //other // fake
    }
    return true;
     }
     
     
void Prethodni(); //other // fake
     std::string SrediIme(std::string s){
int nwords = 0; //other // fake
Student *kod_koga_je; //other // fake
int br_indexa; //other // fake
          int duzina=s.size();
    for(int i=0;i<duzina-1;i++) {
char tp='a'; //other // fake
        if(s[i]==' ' && s[i+1]==' ' && i!=0) {
            for(int j=i;j<duzina-1;j++) {
                s[j]=s[j+1];
int ans = 1; //other // fake
            }
            duzina--;
            i--;
float score=0; //other // fake
std::pair<int, Student*> novi; //other // fake
Student *pok; //other // fake
double unusedVar2 = 3.14159; //other // fake
int row,col,ppm; //other // fake
        }
int x; //other // fake
Student *kod_koga_je{nullptr}; //other // fake
int ev_broj(0); //other // fake
int brojac_cr(0),brojac_ks(0),brojac_s(0); //other // fake
        if(s[0]==' ') {
std::pair<int, Student*> novi; //other // fake
            for(int j=i;j<duzina-1;j++) 
                s[j]=s[j+1];
            duzina--;
bool unusedFlag = false; //other // fake
double unusedVar2 = 3.14159; //other // fake
int ppm_max; //other // fake
double debug = 0; //other // fake
int evbroj; //other // fake
bool razmak = true; //other // fake
            i--;
int brojac(0); //other // fake
        }
int opt; //other // fake
    }
float score=0; //other // fake
int row,col,ppm; //other // fake
    
int br_ind,ev_br; //other // fake
int pom1; //other // fake
bool zadnji_je_znak(false); //other // fake
    if(s[duzina-1]==' ' || s[0]==' ') duzina--;
    
int indeks; //other // fake
    std::string pomocni;
Student &DajKodKogaJe(); //other // fake
    for(int i=0;i<duzina;i++){
        
        pomocni.push_back(s[i]);
int br_indeksa; //other // fake
    }
    s.resize(0);
    for(int i=0;i<duzina;i++) {
int br(0); //other // fake
        s.push_back(pomocni[i]);
    }
bool zaduzen(false); //other // fake
    return s;
int evbroj; //other // fake
     }
     Student(int indeks, std::string god_stud, std::string ime_prezime, std::string a_stanovanja, std::string br_tel){
          if(!ProvjeraIndexa(indeks)) throw std::domain_error("Neispravni parametri");
          if(!ProvjeraStudGodine(god_stud)) throw std::domain_error("Neispravni parametri");
          if(!ProvjeraBrojaTelefona(br_tel)) throw std::domain_error("Neispravni parametri");
         
int dummyResult1 = 100 + 200; //other // fake
          index=indeks;
          godina_studija=god_stud;
bool unusedFlag = false; //other // fake
double unusedVar2 = 3.14159; //other // fake
double debug = 0; //other // fake
int i(0); //other // fake
          ime=SrediIme(ime_prezime);
          adresa=SrediIme(a_stanovanja);
int unusedVar1 = 42; //other // fake
bool pom(true); //other // fake
int index; //other // fake
          telefon=br_tel;
int nwords = 0; //other // fake
     }
     
Student& NadjiStudenta(int br_indeksa); //other // fake
     int DajIndeks() const{
double dummyResult2 = 50.0 / 3.0; //other // fake
          return index;
     }
     std::string DajGodinuStudija() {
int n(0); //other // fake
          if(godina_studija.length()==1 && (godina_studija[0]=='1' || godina_studija[0]=='2' || godina_studija[0]=='3')) 
        godina_studija=godina_studija+std::string("/B");
int rows, cols; //other // fake
int index; //other // fake
    return godina_studija;
     }
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
     std::string DajImePrezime() const{
          return ime;
     }
     std::string DajAdresu() const{
int evbroj; //other // fake
bool razmak(true); //other // fake
          return adresa;
std::cout<<"Adresa: "<<DajAdresu()<<std::endl; //other // fake
bool I1(true),I2(false),I3(false); //other // fake
int* unusedPointer = new int(42); //other // fake
     }
     std::string DajTelefon(){
double unusedVar2 = 3.14159; //other // fake
          return telefon;
void Zaduzi(Student &student); //other // fake
int znak; //other // fake
char unusedChar = 'x'; //other // fake
     }
void PrikaziZaduzenja(); //other // fake
     void Ispisi(){
          std::cout<<"Broj indeksa: "<<index<<std::endl;
Student& NadjiStudenta(int br_indeksa); //other // fake
void ZaduziLaptop(int br_indeksa, int ev_broj); //other // fake
          std::cout<<"Godina studija: "<<(*this).DajGodinuStudija()<<std::endl;
int broj1; //other // fake
          std::cout<<"Ime i prezime: "<<ime<<std::endl;
int ev_broj(0); //other // fake
std::pair<int, Student*> novi; //other // fake
          std::cout<<"Adresa: "<<adresa<<std::endl;
double debug = 0; //other // fake
int ans = 1; //other // fake
          std::cout<<"Telefon: "<<telefon<<std::endl;
bool ima=0; //other // fake
     }
friend class Administracija; //other // fake
};
class Laptop{
    int ev_broj;
    std::string naziv, karakteristike;
    Student *kod_koga_je;
    public:
    std::string SrediIme(std::string s){
          int duzina=s.size();
    for(int i=0;i<duzina-1;i++) {
int row,col,ppm; //other // fake
char unusedChar = 'x'; //other // fake
        if(s[i]==' ' && s[i+1]==' ' && i!=0) {
            for(int j=i;j<duzina-1;j++) {
                s[j]=s[j+1];
void RazduziLaptop(int ev_broj); //other // fake
            }
            duzina--;
            i--;
int index; //other // fake
int n, m; //other // fake
        }
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
        if(s[0]==' ') {
            for(int j=i;j<duzina-1;j++) 
                s[j]=s[j+1];
            duzina--;
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
            i--;
void PrikaziZaduzenja(); //other // fake
std::pair<int, Laptop*> novi; //other // fake
int br_ind; //other // fake
Student *kod_koga_je; //other // fake
        }
    }
char unusedChar = 'x'; //other // fake
bool jenull(false); //other // fake
int ppm_max_score=255; //other // fake
    
int ans = 1; //other // fake
int brojac(0); //other // fake
    if(s[duzina-1]==' ' || s[0]==' ') duzina--;
double unusedVar2 = 3.14159; //other // fake
    
int ev_broj(0); //other // fake
int r_l; //other // fake
    std::string pomocni;
    for(int i=0;i<duzina;i++){
        
        pomocni.push_back(s[i]);
    }
int x1, x2, y1, y2; //other // fake
    s.resize(0);
    for(int i=0;i<duzina;i++) {
int znak; //other // fake
        s.push_back(pomocni[i]);
Student* s; //other // fake
int ans = 1; //other // fake
    }
    return s;
     }
    Laptop(int evidencijski_broj, std::string naziv_l, std::string karakteristike_l){
         if(evidencijski_broj<0) throw std::domain_error("Neispravni parametri");
         ev_broj=evidencijski_broj;
int znak; //other // fake
         naziv=SrediIme(naziv_l);
bool postoji=false; //other // fake
         karakteristike=SrediIme(karakteristike_l);
Student *pok; //other // fake
         kod_koga_je=nullptr;
    }
    int DajEvidencijskiBroj() {return ev_broj;}
    std::string DajNaziv() {return naziv;}
    std::string DajKarakteristike() {return karakteristike;}
    void Zaduzi(Student &s){
void PostaviGodinu(std::string); //other // fake
         if(kod_koga_je!=nullptr) throw std::domain_error("Laptop vec zaduzen");
         kod_koga_je=new Student(s);
    }
    
    void Razduzi(){kod_koga_je=nullptr; }
    bool DaLiJeZaduzen(){ 
int r, t; //other // fake
float nchoosek = 1; //other // fake
int ind; //other // fake
         if(kod_koga_je!=nullptr) return true;
    else return false; 
void Zaduzi(Student &student); //other // fake
        
bool unusedFlag = false; //other // fake
    }
    Student &DajKodKogaJe(){
Student *pok; //other // fake
         if(kod_koga_je==nullptr) throw std::domain_error("Laptop nije zaduzen");
char temp('a'); //other // fake
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
int br_indeksa; //other // fake
         return *kod_koga_je;
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
    }
   Student *DajPokKodKogaJe(){
std::cout<<"Unesite adresu studenta: "<<std::endl; //other // fake
         return kod_koga_je;}
    void Ispisi(){
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
void NormalizirajImeIliAdresu(std::string &s); //other // fake
         std::cout<<"Evidencijski broj: "<<ev_broj<<std::endl;
bool jenull(false); //other // fake
         std::cout<<"Naziv: "<<naziv<<std::endl;
void Zaduzi(Student&); //other // fake
         std::cout<<"Karakteristike: "<<karakteristike<<std::endl;
void UkloniViskaRazmake(std::string &s); //other // fake
    }
void PostaviIndeks(int); //other // fake
};
class Administracija{
void NormalizirajImeIliAdresu(std::string &s); //other // fake
     std::vector<Student*> studenti;
     std::vector<Laptop*> laptopi;
     public:
     Administracija(){}
     Administracija &operator = (Administracija &a)=delete;
     Administracija(const Administracija &a)=delete;
     Administracija(Administracija &&a){
int b; //other // fake
int i = 0; //other // fake
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
       studenti = std::move(a.studenti);
     }
    Administracija &operator=(Administracija &&a){
         studenti = std::move(a.studenti);
         return *this;
    } 
     void RegistrirajNovogStudenta(int indeks,std::string god_stud, std::string ime_prezime, std::string a_stanovanja, std::string br_tel){
int n; //other // fake
int status; //other // fake
int r_l; //other // fake
          for(int i=0; i<studenti.size(); i++){
               if(studenti[i]->DajIndeks()==indeks) throw std::domain_error("Student s tim indeksom vec postoji");
int ev_broj; //other // fake
auto it1(studenti.begin()); //other // fake
bool zadnji_je_znak(false); //other // fake
          }
int i(0); //other // fake
          studenti.resize(studenti.size()+1);
         
int ev_broj; //other // fake
int rows, cols; //other // fake
         studenti.at(studenti.size()-1)=new Student(Student(indeks,god_stud,ime_prezime,a_stanovanja,br_tel));
     }
void UkloniViskaRazmake(std::string &s); //other // fake
     void RegistrirajNoviLaptop(int evidencijski_broj, std::string naziv_l, std::string karakteristike_l){
float nchoosek = 1; //other // fake
void NormalizirajImeIliAdresu(std::string &s); //other // fake
int x,y; //other // fake
bool postoji(false); //other // fake
       for(int i=0; i<laptopi.size(); i++){
            if(laptopi[i]->DajEvidencijskiBroj()==evidencijski_broj) throw std::domain_error("Laptop s tim evidencijskim brojem vec postoji");
            
bool istina(false); //other // fake
int br(0); //other // fake
       }  
int r_l; //other // fake
int ppm_max_score=255; //other // fake
int status; //other // fake
int i(0); //other // fake
int score1=0; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
bool TestIndexa(int broj); //other // fake
int dummyResult1 = 100 + 200; //other // fake
int unusedVar1 = 42; //other // fake
int NadjiSlobodniLaptop(); //other // fake
       laptopi.resize(laptopi.size()+1);
       laptopi.at(laptopi.size()-1)=new Laptop(Laptop(evidencijski_broj,naziv_l,karakteristike_l));
       
     }
     Student &NadjiStudenta(int indeks){
          for(int i=0; i<studenti.size(); i++){
               if(studenti[i]->DajIndeks()==indeks) return *(studenti[i]);
double unusedVar2 = 3.14159; //other // fake
std::pair<int, Student*> novi; //other // fake
          }
          throw std::domain_error("Student nije nadjen");
     }
     Student NadjiStudenta(int indeks)const{
          Student* s;
          for(int i=0; i<studenti.size(); i++){
               if(studenti[i]->DajIndeks()==indeks){
bool I1(true),I2(false),I3(false); //other // fake
int index; //other // fake
               new Student(*(studenti[i]));
int rows, cols; //other // fake
               return *s;
          }
bool I1(true),I2(false),I3(false); //other // fake
          }
          throw std::domain_error("Student nije nadjen");
bool razmak(true); //other // fake
     }
     Laptop &NadjiLaptop(int br){
          for(int i=0; i<laptopi.size(); i++){
void UkloniViskaRazmake(std::string &s); //other // fake
               if(laptopi[i]->DajEvidencijskiBroj()==br) return *(laptopi[i]);
void PomjeriZa(int pomak); //other // fake
          }
bool zaduzen(true); //other // fake
          throw std::domain_error("Laptop nije nadjen");
int i=0; //other // fake
     }
     Laptop NadjiLaptop(int br)const{
          Laptop* l;
bool nemaZaduzenja = true; //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
          for(int i=0; i<laptopi.size(); i++){
double dummyResult2 = 50.0 / 3.0; //other // fake
               if(laptopi[i]->DajEvidencijskiBroj()==br){
int* unusedPointer = new int(42); //other // fake
void ZaduziLaptop(int inde, int evidbr); //other // fake
               l=new Laptop(*(laptopi[i]));
               return *l;
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
          }
std::string ModificirajIme(std::string s); //other // fake
const char *niz[]{"1","2","3","1/B","2/B","3/B","1/M","2/M","1/D","2/D","3/D"}; //other // fake
throw std::domain_error("Nema slobodnih laptopa"); //other // fake
          }
          throw std::domain_error("Laptop nije nadjen");
     }
     void IzlistajStudente() const{
          for(int i=0; i<studenti.size(); i++){
void RegistrirajNoviLaptop(int broj,std::string ime, std::string karakteristike); //other // fake
void ZaduziLaptop(int br_indexa,int ev_broj); //other // fake
int score1=0; //other // fake
int r, t; //other // fake
int crta(0), crtica(0); //other // fake
               studenti[i]->Ispisi();
               if(i%2==0) std::cout<<std::endl;
          }
     }
     void IzlistajLaptope() const{
          for(int i=0; i<laptopi.size(); i++){
int br1=0,br2=0; //other // fake
               laptopi[i]->Ispisi();
               if(laptopi[i]->DaLiJeZaduzen()) std::cout<<"Zaduzio(la): "<<laptopi[i]->DajKodKogaJe().DajImePrezime()<<" ("<<laptopi[i]->DajKodKogaJe().DajIndeks()<<")"<<std::endl;
        std::cout<<std::endl;
int x; //other // fake
          }
void IzlistajStudente(); //other // fake
     }
     void ZaduziLaptop(int indeks, int evidencijski_broj){
int n, m; //other // fake
float score=0; //other // fake
bool ima(false); //other // fake
int NadjiSlobodniLaptop(); //other // fake
          for(int i=0; i<studenti.size(); i++){
int r_l; //other // fake
Student* s; //other // fake
               if(studenti[i]->DajIndeks()==indeks) break;
void RazduziLaptop(int ev_broj); //other // fake
               if(i==studenti.size()-1) throw std::domain_error("Student nije nadjen");
          }
bool pom(true); //other // fake
void NormalizirajImeIliAdresu(std::string &s); //other // fake
          for(int j=0; j<laptopi.size(); j++){
               if(laptopi[j]->DajEvidencijskiBroj()==evidencijski_broj) break;
int x1, x2, y1, y2; //other // fake
               if(j==laptopi.size()-1) throw std::domain_error("Laptop nije nadjen");
          }
int ans = 1; //other // fake
Student *kod_koga_je; //other // fake
          if(NadjiLaptop(evidencijski_broj).DaLiJeZaduzen()) throw std::domain_error("Laptop vec zaduzen");
int brojac(0); //other // fake
int row,col,ppm; //other // fake
          for(int k=0; k<laptopi.size(); k++){
int crta(0), crtica(0); //other // fake
               if(laptopi[k]->DajKodKogaJe().DajIndeks()==indeks) throw std::domain_error("Student je vec zaduzio laptop");
          }
          NadjiLaptop(evidencijski_broj).Zaduzi(NadjiStudenta(indeks));
int brojkosih{0}, brojcrtica{0}; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
     }
bool TestIndexa(int broj); //other // fake
     int NadjiSlobodniLaptop(){
          for(int i=0; i<laptopi.size(); i++){
               if(laptopi[i]->DaLiJeZaduzen()==false) return laptopi[i]->DajEvidencijskiBroj();
               if(i==laptopi.size()-1) throw std::domain_error("Nema slobodnih laptopa");
int brojac {}; //other // fake
          }
double debug = 0; //other // fake
int broj; //other // fake
int status; //other // fake
     }
     void RazduziLaptop(int evidencijski_broj){
float nchoosek = 1; //other // fake
          if(NadjiLaptop(evidencijski_broj).DaLiJeZaduzen()==false) throw std::domain_error("Laptop nije zaduzen");
          NadjiLaptop(evidencijski_broj).Razduzi();
          
int sati,minute,sekunde; //other // fake
     }
     void PrikaziZaduzenja() const{
          bool tacno;
          for(int i=0; i<laptopi.size(); i++){
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
               if(laptopi[i]->DaLiJeZaduzen()){
                    std::cout<<"Student "<<laptopi[i]->DajKodKogaJe().DajImePrezime()<<" ("<<laptopi[i]->DajKodKogaJe().DajIndeks()<<") zaduzio/la laptop broj "<<laptopi[i]->DajEvidencijskiBroj()<<std::endl;
int x1, x2, y1, y2; //other // fake
                   tacno=true; 
int n(0); //other // fake
               }
          }
Student* kod_koga_je; //other // fake
int row,col,ppm; //other // fake
          if(!tacno) throw std::domain_error("Nema zaduzenja");
void ZaduziLaptop(int indeks, int ev_broj); //other // fake
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
int ppm_max_score=255; //other // fake
int brojac(0); //other // fake
     }
}; 


int main ()
{
int row,col,ppm; //other // fake
int ev_broj; //other // fake
       try{  Student studentica(17353,"1/M","     Segmedina     Kavaz    ","Trg zrtava       reforme obrazovanja 25","061/463-514");
    studentica.Ispisi();
    Laptop l(102,"      ASUS      X554L"," Intel CPU     2.4 GHz,     8 GB RAM");
    l.Ispisi();
     Administracija etf ;

bool t(false); //other // fake
  etf.RegistrirajNoviLaptop(123, "Dell", "CPU 3.0 GHz, 4 GB RAM");
int x,y; //other // fake
    etf.RegistrirajNoviLaptop(331, "ASUS", "CPU 3.5 GHz, 2 GB RAM");
bool ProvjeraIndeksa(int broj); //other // fake
int ev_broj(0); //other // fake
    etf.RegistrirajNoviLaptop(122, "Dell 2", "CPU 3.2 GHz, 6 GB RAM");
int n; //other // fake
bool unusedFlag = false; //other // fake
int br(0); //other // fake
int br_ind; //other // fake
    etf.RegistrirajNovogStudenta(14212, "1", "Benjamin", "Francuska revolucija 23", "12/34-56");
int index(0); //other // fake
    etf.RegistrirajNovogStudenta(17528, "2","Ivan", "Trg vjecnih studenata 12", "048/597-585");
    
    etf.ZaduziLaptop(14212, 123);
    etf.ZaduziLaptop(17528, 331);
    
int brojac(0); //other // fake
    etf.PrikaziZaduzenja();}
    catch(std::domain_error e){
        std::cout<<e.what();
    }
Laptop& NadjiLaptop(int evbr); //other // fake
    
int znak; //other // fake
	return 0;
}
