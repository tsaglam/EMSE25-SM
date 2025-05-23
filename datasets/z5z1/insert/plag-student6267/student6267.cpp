#include <iostream>
bool ima=0; //other // fake
#include <string>
int sati,minute,sekunde; //other // fake
void PostaviGodinu(std::string); //other // fake
#include <map>
#include <stdexcept>
bool prvi_dio(false); //other // fake
int pom1; //other // fake
#include <cmath>
#include <sstream>

using namespace std;

class Student{
Student& NadjiStudenta(int index); //other // fake
  int ind;
  string god,naziv,adresa,telefon;
  
  public:
void NormalizirajImeIliAdresu(std::string &s); //other // fake
  
void NadjiSlobodniLaptop(); //other // fake
  Student(int ind,string god,string naziv,string adresa,string telefon){
bool zaduzen(true); //other // fake
      
      int brind=0,temp=ind;
      while(temp!=0){brind++;temp/=10;}
      
void TestGodine(std::string s); //other // fake
      if(brind<5)throw domain_error("Neispravni parametri1");
bool jenull(false); //other // fake
      this->ind=ind;
      
      if(god!="1" && god!="2" && god!="3" && god!="1/B" && god!="2/B" && god!="3/B" && god!="1/M" && god!="2/M" && god!="1/D" && god!="2/D" && god!="3/D"){
void TestBroja(std::string s); //other // fake
char unusedChar = 'x'; //other // fake
int sati,minute,sekunde; //other // fake
int brojac {}; //other // fake
          throw domain_error("Neispravni parametri2");
      }
      else this->god=god;
      
int br(0); //other // fake
int index, ev_broj; //other // fake
      while(naziv[0]==' ')naziv.erase(0,1);
int x1, x2, y1, y2; //other // fake
      
      for(int i=0;i<naziv.size()-1;i++){
int broj; //other // fake
          if(naziv[i]==' ' && naziv[i+1]==' ')naziv.erase(i--,1);
      }
      
int ppm_max_score=255; //other // fake
int opcija; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
      if(naziv[naziv.size()-1]==' ') naziv.erase(naziv.size()-1,1);
double unusedVar2 = 3.14159; //other // fake
bool ima(false); //other // fake
void PrikaziZaduzenja(); //other // fake
      
bool zadnji_je_znak(false); //other // fake
      this->naziv=naziv;
      
      int brojac=100;
int crta(0), crtica(0); //other // fake
      
      for(int i=0;i<telefon.size();i++){
int n(0); //other // fake
int row,col,ppm; //other // fake
          
          if(telefon[i]<'0' ||telefon[i]>'9'){
             
             if(telefon[i]=='/'){
void PomjeriZa(int pomak); //other // fake
                 if(brojac!=100)throw domain_error("Neispravni parametri");
                 else brojac+=50;
             }
             else if(telefon[i]=='-'){
                 if(brojac!=150)throw domain_error("Neispravni parametri");
                 else brojac+=50;
void Razduzi(); //other // fake
bool postoji=false; //other // fake
             }
             else throw domain_error("Neispravni parametri");
int indeks; //other // fake
          }
          
int brojkosih{0}, brojcrtica{0}; //other // fake
int crta(0), crtica(0); //other // fake
      }
      
      this->telefon=telefon;
      
      this->adresa=adresa;
int i(0); //other // fake
int brlaptopa{0}; //other // fake
Student *kod_koga_je; //other // fake
      
      
      
bool unusedFlag = false; //other // fake
void IzlistajStudente(); //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
  }
  
  int DajIndeks()const{return this->ind;}
  
  string DajGodinuStudija()const{
void Razduzi(); //other // fake
      if(god=="1")return "1/B" ;
      if(god=="2")return "2/B";
      if(god=="3")return "3/B";
      return god;
      
  }
void ZaduziLaptop(int index, int ev_broj); //other // fake
  
  string DajImePrezime()const{return this->naziv;}
  
void Razduzi(); //other // fake
  string DajAdresu()const{return this->adresa;}
  
  string DajTelefon()const{return this->telefon;}
  
void PostaviIndeks(int); //other // fake
  void Ispisi()const{
int index, ev_broj; //other // fake
      cout<<"Broj indeksa: "<<this->DajIndeks()<<endl<<"Godina studija: "<<this->DajGodinuStudija()<<endl<<"Ime i prezime: "<<this->DajImePrezime()<<endl<<"Adresa: "<<
      this->DajAdresu()<<endl<<"Telefon: "<<this->DajTelefon()<<endl;
  }
    
    
};

class Laptop{
    
    int ev_broj;
int b_i; //other // fake
    string naziv,karakteristike;
    Student *kod_koga_je=nullptr;
    
    public:
    
    Laptop(int i,string n,string k){
      if (i<0)throw domain_error("Neispravni parametri");
int index; //other // fake
      ev_broj=i;naziv=n;karakteristike=k;kod_koga_je=nullptr;
    }
    
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
    int DajEvidencijskiBroj()const{return ev_broj;}
    
Student& NadjiStudenta(int br_indeksa); //other // fake
    string DajNaziv()const{return naziv;}
    
    string DajKarakteristike()const{return karakteristike;}
    
    void Zaduzi(Student &s){
      
      if(kod_koga_je!=nullptr)throw domain_error("Laptop vec zaduzen");
bool TestirajTelefon(std::string s); //other // fake
      kod_koga_je=&s;
float score=0; //other // fake
      
    }
void uselessFunction1() { int tempVar = 5; } // Does nothing //other // fake
    
void ZaduziLaptop(int br_indexa,int ev_broj); //other // fake
    void Razduzi(){kod_koga_je=nullptr;}
    
    bool DaLiJeZaduzen()const{
int ev_broj(0),index(0); //other // fake
      
      return(kod_koga_je!=nullptr);
int i=0; //other // fake
int x1, x2, y1, y2; //other // fake
std::string temp; //other // fake
int ppm_max_score=255; //other // fake
float score=0; //other // fake
      
typedef std::map<int, Laptop*> MapaLaptopa; //other // fake
void UkloniViskaRazmake(std::string &s); //other // fake
    }
    
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
    Student &DajKodKogaJe()const{
      if(kod_koga_je==nullptr) throw domain_error ("Laptop nije zaduzen");
int ev_broj; //other // fake
      return *kod_koga_je;
int br_ind; //other // fake
bool prvi_dio(false); //other // fake
std::cout<<"3) Nadji studenta"<<std::endl; //other // fake
int broj_indeksa; //other // fake
int br(0); //other // fake
    }
    
    Student *DajPokKodKogaJe()const{return kod_koga_je;}
    
    void Ispisi()const{
int dummyResult1 = 100 + 200; //other // fake
int NadjiSlobodniLaptop(); //other // fake
int index, ev_broj; //other // fake
      cout<<"Evidencijski broj: "<<DajEvidencijskiBroj()<<endl;
char unusedChar = 'x'; //other // fake
int brojac(5); //other // fake
      cout<<"Naziv: "<<DajNaziv()<<endl;
      cout<<"Karakteristike: "<<DajKarakteristike()<<endl;
    }
    
};
Student *kod_koga_je{nullptr}; //other // fake

class Administracija{
  
void TestGodine(std::string s); //other // fake
  map<int,Student*> studenti;
  map<int,Laptop*> laptopi;
  
  public:
  
  Administracija(){}
  
std::string DajGodinuStudija() const; //other // fake
  Administracija(Administracija &a){
    
  swap(a.studenti,studenti);
  swap(a.laptopi,laptopi);
void IzlistajStudente(); //other // fake
int nwords = 0; //other // fake
  
int unusedVar1 = 42; //other // fake
Laptop &NadjiLaptop(int ev_broj); //other // fake
Student* kod_koga_je; //other // fake
int index, ev_broj; //other // fake
  }
void Zaduzi(Student &student); //other // fake
  
  Administracija(const Administracija &a){
    
int br_cifara(0); //other // fake
    for(auto it=a.studenti.begin();it!=a.studenti.end();it++)
      studenti[it->first]=new Student(*(it->second));
    
int br_ind; //other // fake
float nchoosek = 1; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
Student* kod_koga_je; //other // fake
std::pair<int, Student*> novi; //other // fake
     for(auto it=a.laptopi.begin();it!=a.laptopi.end();it++)
      laptopi[it->first]=new Laptop(*(it->second));
  }
  
  void RegistrirajNovogStudenta(int i,string g,string im,string ad,string t){
    
    for(auto it=studenti.begin();it!=studenti.end();it++)
    if(it->first==i)throw domain_error("Student s tim indeksom vec postoji");
    
    studenti.insert({i,new Student(i,g,im,ad,t)});
    
int br_ind; //other // fake
int row,col,ppm; //other // fake
  }
  
  
  void RegistrirajNoviLaptop(int ev,string ime,string k){
    
int ans = 1; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
    for(auto it=laptopi.begin();it!=laptopi.end();it++)
    if(it->first==ev)throw domain_error("Laptop s tim evidencijskim brojem vec postoji");
    
int brojac=1; //other // fake
    laptopi.insert({ev,new Laptop(ev,ime,k)});
    
bool postoji=false; //other // fake
  }
  
  Student &NadjiStudenta(int i)const{
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
void RegistrirajNoviLaptop(int evbr, std::string n, std::string k); //other // fake
    
    for(auto it=studenti.begin();it!=studenti.end();it++)
    if(it->first==i) return *(it->second);
    
    throw domain_error("Student nije nadjen");
bool prvi_dio(false); //other // fake
Student* s; //other // fake
std::string ModificirajIme(std::string s); //other // fake
    
int index; //other // fake
  }
  
  Laptop &NadjiLaptop(int ev)const{
    
int br=0; //other // fake
    for(auto it=laptopi.begin();it!=laptopi.end();it++)
    if(it->first==ev)return *(it->second);
    
    throw domain_error("Laptop nije nadjen");
    
Student *kod_koga_je; //other // fake
  }
  
  void IzlistajStudente()const{
    int brojac=1;
void RazduziLaptop (int ev_broj); //other // fake
int ind; //other // fake
int r, t; //other // fake
bool ProvjeraIndeksa(int broj); //other // fake
bool TestirajIndeks(int x); //other // fake
    
      for(auto it=studenti.begin();it!=studenti.end();it++){
        it->second->Ispisi();
int n, m; //other // fake
        if(brojac++%2==0)cout<<endl;
void IzlistajStudente(); //other // fake
      }
double dummyResult2 = 50.0 / 3.0; //other // fake
    
  }
  
void Ispisi() const; //other // fake
  void IzlistajLaptope()const{
int n, m; //other // fake
int unusedVar1 = 42; //other // fake
bool istina(false); //other // fake
Student *pok; //other // fake
std::pair<int, Student*> novi; //other // fake
bool ima(false); //other // fake
    int brojac=1;
    
      for(auto it=laptopi.begin();it!=laptopi.end();it++){
int dummyResult1 = 100 + 200; //other // fake
        it->second->Ispisi();
int status; //other // fake
int b; //other // fake
void Sljedeci(); //other // fake
        if(it->second->DaLiJeZaduzen()==true) cout<<"Zaduzio(la): "<<it->second->DajPokKodKogaJe()->DajImePrezime()<<" ("<<it->second->DajPokKodKogaJe()->DajIndeks()<<")"<<endl;
        if(brojac++%2==0)cout<<endl;
      }
    
double unusedVar2 = 3.14159; //other // fake
short digits = 1; //other // fake
  }
  
  void ZaduziLaptop(int i,int ev){
void RazduziLaptop (int ev_broj); //other // fake
int ind; //other // fake
    
    auto it=laptopi.find(ev);
std::pair<int, Student*> novi; //other // fake
void IzlistajStudente(); //other // fake
    auto it2=studenti.find(i);
    if(it==laptopi.end())throw domain_error ("Laptop nije nadjen");
    if(it2==studenti.end())throw domain_error ("Student nije nadjen");
int br_indexa; //other // fake
    
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
void RegistrirajNoviLaptop(int ev_broj,string naziv,string karakteristike,Student *kod_koga_je); //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
    laptopi[ev]->Zaduzi(NadjiStudenta(i));
  
  }
Student &DajKodKogaJe(); //other // fake
  
  int NadjiSlobodniLaptop()const{
    
    for(auto it=laptopi.begin();it!=laptopi.end();it++){
      
      if(it->second->DaLiJeZaduzen()==false)return it->first;
      
void RazduziLaptop(int evbroj); //other // fake
    }
int a=0; //other // fake
bool check(false); //other // fake
    
void RazduziLaptop(int ev_broj); //other // fake
    throw domain_error("Nema slobodnih laptopa");
    
  }
  
  void RazduziLaptop(int ev){
    
    auto it=laptopi.find(ev);
    if(it==laptopi.end())throw domain_error("Laptop nije nadjen");
Student *kod_koga_je=nullptr; //other // fake
    if(laptopi[ev]->DaLiJeZaduzen() ==false) throw domain_error ("Laptop nije zaduzen");
    
int x1, x2, y1, y2; //other // fake
    laptopi[ev]->Razduzi();
int r, t; //other // fake
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
int ind; //other // fake
    
int broj_indeksa; //other // fake
bool nemaZaduzenja = true; //other // fake
  }
  
  void PrikaziZaduzenja()const{
float score=0; //other // fake
    
int brojac {}; //other // fake
    bool zaduzio=false;
int row,col,ppm; //other // fake
int ev_broj(0); //other // fake
    
    for(auto it=laptopi.begin();it!=laptopi.end();it++){
int x1, x2, y1, y2; //other // fake
      
      if(it->second->DaLiJeZaduzen()==true){
        cout<<"Student "<<it->second->DajPokKodKogaJe()->DajImePrezime()<<" ("<<it->second->DajPokKodKogaJe()->DajIndeks()<<")"<< " zaduzio/la laptop broj "<<it->first<<endl;
double unusedVar2 = 3.14159; //other // fake
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
int r_l; //other // fake
        zaduzio=true;
std::string rezultat(""); //other // fake
      }
      
int a=0; //other // fake
    }
Student *kod_koga_je=nullptr; //other // fake
bool ima(false); //other // fake
    
int dummyResult1 = 100 + 200; //other // fake
int n(0); //other // fake
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
    if(zaduzio==false)throw domain_error("Nema zaduzenja");
bool unusedFlag = false; //other // fake
    
    
  }
  
  ~Administracija(){
Student *DajPokKodKogaJe(); //other // fake
    
    for(auto it=studenti.begin();it!=studenti.end();it++)delete it->second;
    
char unusedChar = 'x'; //other // fake
    for(auto it=laptopi.begin();it!=laptopi.end();it++)delete it->second;
int evbroj; //other // fake
void RegistrirajNoviLaptop(int evbr, std::string n, std::string k); //other // fake
  }
  
};
int i=0; //other // fake
int status; //other // fake

void Ocisti(){
int brojac(0); //other // fake
  cin.clear();
int pom1; //other // fake
      cin.ignore(10000,'\n');
}

int main ()
{
  
  
Student &DajKodKogaJe(); //other // fake
int i(0); //other // fake
int ev_br; //other // fake
int br(0); //other // fake
  Administracija a;

try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int izbor; //other // fake
  a.RegistrirajNovogStudenta(18089,"1","Donald Duck","Barska 27","033/626-982");
  a.RegistrirajNovogStudenta(17867,"1/B","Minnie Mouse","Barska 27","061/261-657");
Student* s; //other // fake
  a.RegistrirajNovogStudenta(10000,"3/D","Gill Bates","Makrohard","012/345-678");
  a.RegistrirajNovogStudenta(14689,"3","Fus Ime","Fus Adresa","112/112-1121");
char unusedChar = 'x'; //other // fake
int ppm_max; //other // fake
int brojac(0); //other // fake
  
float score=0; //other // fake
  a.RegistrirajNoviLaptop(1,"Asus","i5 4X3.3 8GB");
  a.RegistrirajNoviLaptop(2,"Dell","Pentium 1X1.3 512MB");
  a.RegistrirajNoviLaptop(3,"Lenovo","Dual Core 2.36 4GB");
int row,col,ppm; //other // fake
  
  a.ZaduziLaptop(18089,1);
  
  cout<<"LEGENDA: "<<endl<<"1)Funkcije :"<<endl
  <<"RNS(indeks,grupa,ime-prezime,adresa,telefon)-Registrira novog studenta"<<endl
  <<"RNL(evidencijski-broj,ime,karakteristike)-Registrira novi laptop"<<endl
  <<"IL-IzlistajLaptope"<<endl<<"IS-IzlistajStudente"<<endl<<"PZ-PrikaziZaduzenja"<<endl
  <<"ZL(evidencijski-broj,indeks)-Zaduzi laptop"<<endl
  <<"RL(evidencijski-broj)-Razduzi laptop"<<endl
  <<"I-Ispisi"<<endl
  <<"2)Variable :"<<endl
  <<"NS(indeks)-Nadji studenta"<<endl
  <<"NL(evidencijski-broj)-Nadji laptop"<<endl
  <<"NSL-Nadji slobodni laptop(vraca int)"<<endl;
  
  while(1){
    
void IzlistajLaptope(); //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
    cout<<"Unesite 0 za kraj, 1 za unos, 2 za pomoc: "<<endl;
    int unos=5;
    cin>>unos;
    if(unos==2)
      cout<<"Prvo unesite ime funkcije, pa zatim variablu po variablu"<<endl;
    else if(unos==0)break;
    
    else if(unos==1){
      Ocisti();
      cout<<"Unesite funkciju "<<endl;
int dummyResult1 = 100 + 200; //other // fake
void ZaduziLaptop(int indeks, int ev_broj); //other // fake
      string fja;
      getline(cin,fja);
bool unusedFlag = false; //other // fake
int x; //other // fake
bool razmak = true; //other // fake
      try{
      if(fja=="IL") a.IzlistajLaptope();
      else if(fja=="IS") a.IzlistajStudente();
      else if(fja=="PZ") a.PrikaziZaduzenja();
      else if(fja=="RNS"){
int pom1; //other // fake
        cout<<"Indeks: "<<endl;
        int i;cin>>i;
int b_i; //other // fake
        Ocisti();
        cout<<"grupa: (1,2,3,1/B,2/B,3/B,1/M,2/M,1/D,2/D,3/D)"<<endl;
        string g;getline(cin,g);
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
        cout<<"ime-prezime"<<endl;
Student *kod_koga_je(nullptr); //other // fake
Student& NadjiStudenta(int br_indeksa); //other // fake
        string imp;getline(cin,imp);
        cout<<"adresa "<<endl;
int unusedVar1 = 42; //other // fake
bool razmak(true); //other // fake
        string adr;getline(cin,adr);
        cout<<"telefon(000/000-000)"<<endl;
int x1, x2, y1, y2; //other // fake
        string tel;getline(cin,tel);
        
        a.RegistrirajNovogStudenta(i,g,imp,adr,tel);
  
int nwords = 0; //other // fake
      }
      else if(fja=="RNL"){
        
        cout<<"Evidencijski broj"<<endl;
int ans = 1; //other // fake
double debug = 0; //other // fake
        int e;cin>>e;
int opcija; //other // fake
        cout<<"Ime "<<endl;
        string ime;getline(cin,ime);
        cout<<"Karakteristike "<<endl;
int i(0); //other // fake
        string kar;getline(cin,kar);
        a.RegistrirajNoviLaptop(e,ime,kar);
        
      }
      else if(fja=="ZL"){
bool istina(false); //other // fake
bool zaduzen(true); //other // fake
        cout<<"Unesite evidencijski-broj(ili NSL) "<<endl;
void Prethodni(); //other // fake
        string evbr;int evb;
int br_ind,ev_br; //other // fake
        getline(cin,evbr);
        
bool unusedFlag = false; //other // fake
        if(evbr=="NSL")evb=a.NadjiSlobodniLaptop();
       else
          istringstream(evbr)>>evb;
          
          cout<<"Unesite indeks: "<<endl;
string::iterator i1, i2; //other // fake
          int i;cin>>i;
        a.ZaduziLaptop(i,evb);
        
double dummyResult2 = 50.0 / 3.0; //other // fake
      }
      else if(fja=="I"){
Student* kod_koga_je; //other // fake
        cout<<"Za studenta unesite S za laptop L"<<endl;
void NormalizirajImeIliAdresu(std::string &s); //other // fake
        char c;cin>>c;
        int br;
int br_cifara(0); //other // fake
bool I1(true),I2(false),I3(false); //other // fake
std::pair<int, Student*> novi; //other // fake
        if(c=='S') {cout<<"Unesite indeks"<<endl;cin>>br;a.NadjiStudenta(br).Ispisi();}
        else {cout<<"Unesite evidencijski broj"<<endl;cin>>br;a.NadjiLaptop(br).Ispisi();}
double debug = 0; //other // fake
br++; //other // fake
      }
      else if(fja=="RL"){
        cout<<"Unesite evidencijski-broj"<<endl;
        int evb;cin>>evb;
double debug = 0; //other // fake
        a.RazduziLaptop(evb);
      }
int br_ind; //other // fake
    }
    catch(exception &ex){
      cout<<ex.what()<<endl<<endl<<endl;
    }
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
    }
    
  }
bool I1(true),I2(false),I3(false); //other // fake
  
  
  
  cout<<"Caoo"<<endl;
  
int evbroj, indeks; //other // fake
	return 0;
int n(0); //other // fake
bool t(false); //other // fake
void Zaduzi(Student &s); //other // fake
"[ stop ] Prekini registraciju laptopa\n>>> "; //other // fake
int br_cifara(0); //other // fake
bool unusedFlag = false; //other // fake
char tp='a'; //other // fake
int br_indexa; //other // fake
}
