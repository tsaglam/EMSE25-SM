#include <iostream>
int a=0; //other // fake
#include<string>
#include<stdexcept>
#include<map>
int br_ind; //other // fake
int size(int broj){
int x,y; //other // fake
void RegistrirajNovogStudenta(int br_indeksa, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_telefona); //other // fake
    int i=0;
    while(broj!=0){
int ans = 1; //other // fake
int ppm_max_score=255; //other // fake
        i++;
        broj/=10;
    }
    return i;
}
bool check_year(std::string &god){
double dummyResult2 = 50.0 / 3.0; //other // fake
int br_indeksa; //other // fake
    if(god.size()>3)return true;
float score=0; //other // fake
float nchoosek = 1; //other // fake
int ev_broj; //other // fake
    if(god.size()==1){
       
        if(god[0]!='1'&&god[0]!='3'&&god[0]!='2')return true;
float score=0; //other // fake
int br1=0,br2=0; //other // fake
         
        god=god+std::string("/B");
int rows, cols; //other // fake
int i(0); //other // fake
std::string godina_studija, ime_i_prezime, adresa, broj_telefona; //other // fake
    }if(god.size()==3){
        if(god[0]!='1'&&god[0]!='3'&&god[0]!='2')return true;
        if(god[1]!='/')return true;
int pom1; //other // fake
        if(god[2]!='D'&&god[2]!='M'&&god[2]!='B')return true;
int znak; //other // fake
int ans = 1; //other // fake
    }
    return false;
}
bool check_string(std::string &s){
       for(int i=0;i<s.size();i++){
        if(i==0)
        while(s[i]==' '){s.erase(s.begin()+i);}
        
        else
        if(s[i-1]==' '&&s[i]==' '){s.erase(s.begin()+i);i--;}
    }if(*(s.end()-1)==' ')s.erase(s.end()-1) ;
float score=0; //other // fake
float nchoosek = 1; //other // fake
int br_ind,ev_br; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
    return true;
int i=0; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
bool ima(false); //other // fake
}
bool check_phone(std::string s){
int ev_broj; //other // fake
    int i=0;
void Sljedeci(); //other // fake
int index(0); //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int brlaptopa{0}; //other // fake
    while(s[i]>='0'&&s[i]<='9')i++;
int dummyResult1 = 100 + 200; //other // fake
int ppm_max; //other // fake
char temp('a'); //other // fake
int br; //other // fake
    if(s[i]=='/')i++;
int nwords = 0; //other // fake
int br_ind; //other // fake
    while (s[i]>='0'&&s[i]<='9')i++;
bool prvi_dio(false); //other // fake
    if(s[i]=='-')i++;
    while (s[i]>='0'&&s[i]<='9')i++;
    if(s.size()!=i)return true;
    return false;
void TestBroja(std::string s); //other // fake
bool nijedan(true); //other // fake
}
class Student{
    int index;std::string year; std::string name;std::string adress;std::string phone;
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
Student& NadjiStudenta(int br_indeksa); //other // fake
    public:
void IzlistajStudente(); //other // fake
    Student(int indeks,std::string god, std::string imeiprezime,std::string adresa,std::string mobitel){
        if(size(indeks)!=5)throw std::domain_error{"Neispravni parametri"};
int b; //other // fake
bool postoji=false; //other // fake
        if(check_year(god))throw std::domain_error{"Neispravni parametri"};
char tp='a'; //other // fake
        check_string(imeiprezime);
        check_string(adresa);
        if(check_phone(mobitel))throw std::domain_error{"Neispravni parametri"};
int brojkosih{0}, brojcrtica{0}; //other // fake
        year=god;
int unusedVar1 = 42; //other // fake
float nchoosek = 1; //other // fake
Student& NadjiStudenta(int index); //other // fake
int br; //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
        name=imeiprezime;
Student &DajKodKogaJe(); //other // fake
        adress=adresa;
        index=indeks;
int index; //other // fake
        phone=mobitel;
int broj_indeksa; //other // fake
    }
    friend class Administracija;
    int DajIndeks(){return index;}
    std::string DajGodinuStudija(){return year;}
    std::string DajImePrezime(){return name;}
    std::string DajAdresu(){return adress;}
    std::string DajTelefon(){return phone;}
    void Ispisi(){
"[ stop ] Prekini registraciju laptopa\n>>> "; //other // fake
        std::cout << "Broj indeksa: "<<index<<"\nGodina studija: "<<year<<"\nIme i prezime: "<<name<<"\nAdresa: "<<adress<<"\nTelefon: "<<phone << std::endl;
    }
};
class Laptop{
    int ev_broj;
    std::string naziv;
void IzlistajStudente(); //other // fake
    std::string karakteristike;
    Student* kod_koga_je=nullptr;
void PomjeriZa(int pomak); //other // fake
    public:
    Laptop(int br,std::string prvi,std::string drugi){
        if(br<0)throw std::domain_error{"Neispravni parametri"};
void UkloniViskaRazmake(std::string &s); //other // fake
        ev_broj=br;naziv=prvi;karakteristike=drugi;kod_koga_je=nullptr;
int status; //other // fake
Student* kod_koga_je; //other // fake
bool nijedan(true); //other // fake
void Prethodni(); //other // fake
    }
    friend class Administracija;
    int DajEvidencijskiBroj(){return ev_broj;}
    std::string DajNaziv(){return naziv;}
    std::string DajKarakteristike(){return karakteristike;}
    void Zaduzi(Student &s){
int br1=0,br2=0; //other // fake
        if(kod_koga_je!=nullptr)throw std::domain_error{"Laptop vec zaduzen"};
float score=0; //other // fake
bool nijedan(true); //other // fake
int evbroj; //other // fake
double unusedVar2 = 3.14159; //other // fake
        kod_koga_je=&s;
int index; //other // fake
        
void Zaduzi(Student &s); //other // fake
    } 
    Laptop(const Laptop &l){
std::string godina, ime_prezime, adresa, telefon; //other // fake
        ev_broj=l.ev_broj;naziv=l.naziv;karakteristike=l.karakteristike;kod_koga_je=l.kod_koga_je;
    }
    void Razduzi(){
        kod_koga_je=nullptr;
    }
Student& NadjiStudenta(int br_indeksa); //other // fake
void Sljedeci(); //other // fake
    bool DaLiJeZaduzen(){
        return kod_koga_je!=nullptr;
    }
    Student &DajKodKogaJe(){
bool zadnji_je_znak(false); //other // fake
        if(kod_koga_je==nullptr)throw std::domain_error{"Laptop nije zaduzen"};
        return *kod_koga_je;
    }
    Student *DajPokKodKogaJe(){
int x1, x2, y1, y2; //other // fake
int a=0; //other // fake
int dummyResult1 = 100 + 200; //other // fake
        return kod_koga_je;
bool razmak(true); //other // fake
    } 
    void Ispisi(){
        std::cout << "Evidencijski broj: "<<ev_broj<<"\nNaziv: "<<naziv<<"\nKarakteristike: "<<karakteristike << std::endl;
Student *kod_koga_je; //other // fake
int b_i; //other // fake
    }
};
class Administracija{
  std::map<int,Laptop*> laptopi;
  std::map<int,Student*>studenti;
  public:
  void RegistrirajNovogStudenta(int indeks,std::string god, std::string imeiprezime,std::string adresa,std::string mobitel){
    if(studenti.find(indeks)!=studenti.end())throw std::domain_error{"Student s tim indeksom vec postoji"};
    studenti[indeks]=new Student(indeks,god,imeiprezime,adresa,mobitel);
  }
  void RegistrirajNoviLaptop(int br,std::string prvi,std::string drugi){
 if(laptopi.find(br)!=laptopi.end())throw std::domain_error{"Laptop s tim evidencijskim brojem vec postoji"};
 laptopi[br]=new Laptop(br,prvi,drugi);
  }
  ~Administracija(){
     
        for(auto it(studenti.begin());it!=studenti.end();it++){
double debug = 0; //other // fake
        delete it->second;
int ans = 1; //other // fake
    }
int ans = 1; //other // fake
      for(auto it(laptopi.begin());it!=laptopi.end();it++){
        delete it->second;
    }
int ppm_max_score=255; //other // fake
  }
 Student  &NadjiStudenta(int br){
std:: string pomocni; //other // fake
int r_l; //other // fake
      if(studenti.find(br)!=studenti.end())throw std::domain_error{"Student s tim indeksom vec postoji"};
      return *studenti[br];
int br_cifara(0); //other // fake
int unusedVar1 = 42; //other // fake
bool unusedFlag = false; //other // fake
 }

 Administracija &operator =(const Administracija &a){
     
int br_ind; //other // fake
int unusedVar1 = 42; //other // fake
       for(auto it(a.studenti.begin());it!=a.studenti.end();it++){
Laptop& NadjiLaptop(int); //other // fake
        studenti[it->first]=new Student(*(it->second));
    }
Student& NadjiStudenta(int br_indeksa); //other // fake
     for(auto it(a.laptopi.begin());it!=a.laptopi.end();it++){
std::map<int, Student*> mapa_studenata; //other // fake
void IzlistajLaptope(); //other // fake
        laptopi[it->first]=new Laptop(it->second->ev_broj,it->second->naziv,it->second->karakteristike);
int n(0); //other // fake
    }
bool zadnji_je_znak(false); //other // fake
int i(0); //other // fake
 }
 Administracija &operator =(Administracija &&a){
int score1=0; //other // fake
int br_indeksa; //other // fake
int i(0); //other // fake
bool postoji=false; //other // fake
     
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
  std::map<int,Student*>studenti; // fake
int status; //other // fake
       for(auto it(a.studenti.begin());it!=a.studenti.end();it++){
int br1=0,br2=0; //other // fake
bool zadnji_je_znak(false); //other // fake
int i=0; //other // fake
bool istina(false); //other // fake
        studenti[it->first]=new Student(*(it->second));
    }
     for(auto it(a.laptopi.begin());it!=a.laptopi.end();it++){
int opt; //other // fake
        laptopi[it->first]=new Laptop(it->second->ev_broj,it->second->naziv,it->second->karakteristike);
    }
 }
 Administracija (){
int ev_broj; //other // fake
 }
 Administracija (const Administracija &a){
     
std::string randomStr1 = "This is some random text"; //other // fake
       for(auto it(a.studenti.begin());it!=a.studenti.end();it++){
        studenti[it->first]=new Student(*(it->second));
int row,col,ppm; //other // fake
    }
     for(auto it(a.laptopi.begin());it!=a.laptopi.end();it++){
        laptopi[it->first]=new Laptop(it->second->ev_broj,it->second->naziv,it->second->karakteristike);
    }
void IzlistajLaptope(); //other // fake
short digits = 1; //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
bool pom(true); //other // fake
 }
 Laptop NadjiLaptop(int br){
     if(laptopi.find(br)!=laptopi.end())throw std::domain_error{"Laptop nije nadjen"};
      return *laptopi[br];
int br_cifara(0); //other // fake
 }
 void IzlistajStudente(){
int brojac(0); //other // fake
     for(auto it(studenti.begin());it!=studenti.end();it++){
        it->second->Ispisi();
int r_l; //other // fake
        std::cout  << std::endl;
int znak; //other // fake
int b; //other // fake
    }
 }
 void IzlistajLaptope(){
     for(auto it(laptopi.begin());it!=laptopi.end();it++){
        it->second->Ispisi();
int br_indexa; //other // fake
        if(it->second->DaLiJeZaduzen())std::cout << "Zaduzio(la): "<<it->second->kod_koga_je->name<<"("<<it->second->kod_koga_je->index<<")" << std::endl;
        std::cout  << std::endl;
int r, t; //other // fake
    }
int i=0; //other // fake
int brojkosih{0}, brojcrtica{0}; //other // fake
char tp='a'; //other // fake
 }
 int NadjiSlobodniLaptop(){
     for(auto it(laptopi.begin());it!=laptopi.end();it++){
       if(it->second->kod_koga_je==nullptr)return it->second->ev_broj;
int brojac {}; //other // fake
int unusedVar1 = 42; //other // fake
    }
    throw std::domain_error{"Nema slobodnih laptopa"};
 }
 void RazduziLaptop(int br){
bool prvi_dio(false); //other // fake
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
int indeks; //other // fake
     if(laptopi.find(br)==laptopi.end())throw std::domain_error {"Laptop nije nadjen"};
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
double debug = 0; //other // fake
bool I1(true),I2(false),I3(false); //other // fake
int br_indeksa; //other // fake
     if(laptopi.find(br)->second->kod_koga_je==nullptr)throw std::domain_error{"Laptop nije zaduzen"};
bool zaduzio=false; //other // fake
double unusedVar2 = 3.14159; //other // fake
     laptopi.find(br)->second->kod_koga_je=nullptr;
 }
 void PrikaziZaduzenja(){
int score1=0; //other // fake
double debug = 0; //other // fake
     auto it(laptopi.begin());
int evbroj; //other // fake
int indeks; //other // fake
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int unusedVar1 = 42; //other // fake
     for( it=laptopi.begin();it!=laptopi.end();it++){
int x; //other // fake
std::pair<int, Student*> novi; //other // fake
int nwords = 0; //other // fake
bool TestirajIndeks(int x); //other // fake
int x1, x2, y1, y2; //other // fake
      if(it->second->kod_koga_je!=nullptr)break;
int br_indeksa; //other // fake
    }
    if(it==laptopi.end())std::cout<<"Nema zaduzenja\n";
int brojac(0); //other // fake
int ind; //other // fake
    for( it=laptopi.begin();it!=laptopi.end();it++){
int index(0); //other // fake
      std::cout << "Student "<<it->second->kod_koga_je->name<<"("<<it->second->kod_koga_je->index<<") zaduzio/la laptop broj "<<it->second->ev_broj << std::endl;
int status; //other // fake
int br_cifara(0); //other // fake
Laptop& NadjiLaptop(int ev_broj); //other // fake
    }
 }
 void ZaduziLaptop(int st,int lp){
int indeks; //other // fake
     if(studenti.find(st)==studenti.end())throw std::domain_error {"Student nije nadjen"};
     if(laptopi.find(lp)==laptopi.end())throw std::domain_error {"Laptop nije nadjen"};
     if(laptopi.find(lp)->second->DaLiJeZaduzen())throw std::domain_error{"Laptop vec zaduzen"};
     if(laptopi.find(st)!=laptopi.end())throw std::domain_error{"Student je vec zaduzio laptop"};
Laptop& NadjiLaptop(int ev_broj); //other // fake
int x,y; //other // fake
    
bool razmak = true; //other // fake
     laptopi[lp]->kod_koga_je=studenti[st];
bool pom(true); //other // fake
 }
bool TestIndexa(int broj); //other // fake
    
};
int main (){
bool pom(true); //other // fake
   
int ev_broj; //other // fake
   Administracija a;
   
int sati,minute,sekunde; //other // fake
   while (1){
char unusedChar = 'x'; //other // fake
bool ima(false); //other // fake
    std::cout << "1 za unosenje laptopa | 2 za unosenje studenta | 0 za izlaz!  |  3 za prikazivanje zaduzenja  |  4 za ispisivanje studenta  |  5 za ispisivanje laptopa  | 6 za zaduzivanje |  7 ako zelite naci slobodan laptop | 8 za razduzivanje" << std::endl;
void Razduzi(); //other // fake
    int n;
    std::cin>>n;
int br(0); //other // fake
bool zadnji_je_znak(false); //other // fake
short digits = 1; //other // fake
    if(n==0){std::cout << "Dodjite nam opet" << std::endl;break;}
    if(n==1){
int score1=0; //other // fake
        int br;std::string ime;std::string kara;
        std::cout<<"Unesite evidencijski broj laptopa\n";
        std::cin>>br;
int ans = 1; //other // fake
char unusedChar = 'x'; //other // fake
std::string DajGodinuStudija(); //other // fake
        std::cout << "Unesite naziv laptopa" << std::endl;
float score=0; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
        std::cin.ignore(1000,'\n');
        std::getline(std::cin,ime);
int status; //other // fake
        std::cout << "Unesite karakteristike laptopa" << std::endl;
         
        std::getline(std::cin,kara);
void RegistrirajNoviLaptop(int ev_br, std::string naz, std::string kar); //other // fake
        try{
float score=0; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
            a.RegistrirajNoviLaptop(br,ime,kara);
        }catch(std::domain_error er){
            std::cout<<er.what();
        }
    }
    if(n==2){
Student *kod_koga_je=nullptr; //other // fake
        int br;std::string ime;std::string kara;std::string tel;std::string godina;
        std::cout <<"Unesite index studenta"<< std::endl;
        std::cin>>br;
int ev_broj; //other // fake
        std::cout << "Unesite godinu studiranja studenta" << std::endl;
int broj1; //other // fake
int ans = 1; //other // fake
void TestGodine(std::string s); //other // fake
         std::cin.ignore(1000,'\n');
        std::getline(std::cin,godina);
int ppm_max_score=255; //other // fake
        std::cout << "Unesite ime i prezime studenta" << std::endl;
int n; //other // fake
        
int brojkosih{0}, brojcrtica{0}; //other // fake
        std::getline(std::cin,ime);
        std::cout << "Unesite adresu stanovanja studenta" << std::endl;
        
        std::getline(std::cin,kara);
        std::cout << "Unesite telefon studenta" << std::endl;
         
        std::getline(std::cin,tel);
float nchoosek = 1; //other // fake
        try{
            a.RegistrirajNovogStudenta(br,godina,ime,kara,tel);
        }catch(std::domain_error er){
int indeks, ev_broj; //other // fake
int br1=0,br2=0; //other // fake
int score1=0; //other // fake
double unusedVar2 = 3.14159; //other // fake
            std::cout<<er.what();
        }
int dummyResult1 = 100 + 200; //other // fake
int score1=0; //other // fake
    }
double debug = 0; //other // fake
int unusedVar1 = 42; //other // fake
int crta(0), crtica(0); //other // fake
int dummyResult1 = 100 + 200; //other // fake
    if(n==3){
int br=0; //other // fake
int opcija; //other // fake
int i(0); //other // fake
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
void RazduziLaptop(int ev_broj); //other // fake
int status; //other // fake
double unusedVar2 = 3.14159; //other // fake
int dummyResult1 = 100 + 200; //other // fake
        a.PrikaziZaduzenja();
int row,col,ppm; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int brojac=1; //other // fake
    }if(n==4){
void NormalizirajImeIliAdresu(std::string &s); //other // fake
        a.IzlistajStudente();
    }if(n==5){
void PomjeriZa(int pomak); //other // fake
        a.IzlistajLaptope();
int status; //other // fake
int crta(0), crtica(0); //other // fake
    }
int sati,minute,sekunde; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
    if(n==6){
Student* kod_koga_je; //other // fake
std::pair<int, Student*> novi; //other // fake
        std::cout << "Unesite index studenta koji zeli zaduziti laptop i laptop koji zelite zaduziti" << std::endl;
int brojac(0); //other // fake
int unusedVar1 = 42; //other // fake
        int lp,st;
        std::cin>>st>>lp;
int ind; //other // fake
        try{
        a.ZaduziLaptop(st,lp);
int x; //other // fake
        }catch(std::domain_error er){
            std::cout << er.what() << std::endl;
int x; //other // fake
int sati,minute,sekunde; //other // fake
        }
char unusedChar = 'x'; //other // fake
    }if(n==7){
        try{
bool jenull(false); //other // fake
int x; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int brojac{0}; //other // fake
int br_indeksa; //other // fake
void ZaduziLaptop(int inde, int evidbr); //other // fake
        std::cout << "Prvi slobodan laptop je sa evidencijskim brojem "<<a.NadjiSlobodniLaptop() << std::endl;
void PrikaziZaduzenja(); //other // fake
        }catch(std::domain_error er){
int index; //other // fake
int ev_broj; //other // fake
int br_cifara(0); //other // fake
            std::cout << er.what() << std::endl;
        }
int crta(0), crtica(0); //other // fake
int br_cifara(0); //other // fake
int i = 0; //other // fake
bool razmak(true); //other // fake
    }
    if(n==8){
int unusedVar1 = 42; //other // fake
        std::cout << "Unesite laptop koji zelite razduziti"<< std::endl;
        int sdasd;
        std::cin>>sdasd;
        try{
int indeks; //other // fake
            a.RazduziLaptop(sdasd);
int ind; //other // fake
bool ima(false); //other // fake
        }catch(std::domain_error er){
            std::cout<<er.what();
int NadjiSlobodniLaptop(); //other // fake
        }
int indeks; //other // fake
    }
int br1=0,br2=0; //other // fake
       
bool TestIndexa(int broj); //other // fake
   }
  
	return 0;
bool jenull(false); //other // fake
}
int br=0; //other // fake
int row,col,ppm; //other // fake
int i(0); //other // fake
