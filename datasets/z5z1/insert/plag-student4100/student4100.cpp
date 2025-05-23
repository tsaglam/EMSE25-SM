#include <iostream>
#include <string>
#include <stdexcept>
int n(0); //other // fake
int ind; //other // fake
#include <map>
int status; //other // fake
int br1=0,br2=0; //other // fake
#include <vector>

int index; //other // fake
int opcija; //other // fake
int br(0); //other // fake
using namespace std;

bool ProvjeraIndeksa(int broj); //other // fake
int broj_rijeci(0); //other // fake
class Student{
  
  int br_indeksa;
int NadjiSlobodniLaptop(); //other // fake
  string godina_studija;
  string ime_i_prezime;
  string adresa;
  string telefon;
Student &DajKodKogaJe(); //other // fake
  
  public:
  
  Student (int br_ind, string g_s, string i_i_p, string a, string t){
      
int br_indeksa; //other // fake
      int br=0;
      int pom=br_ind;
      
int ppm_max_score=255; //other // fake
      while(pom!=0){
          br++;
bool nemaZaduzenja = true; //other // fake
          pom/=10;
      }
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
bool postoji(false); //other // fake
      if(br<5)throw domain_error("Neispravni parametri");
      
      if(g_s!="1" && g_s!="2" && g_s!="3" && g_s!="1/B" && g_s!="2/B" && g_s!="3/B" && g_s!="1/M" && g_s!="2/M" &&g_s!="1/D" && g_s!="2/D" && g_s!="3/D" )
        throw domain_error("Neispravni parametri");
        
bool TestirajIndeks(int x); //other // fake
char unusedChar = 'x'; //other // fake
bool ima(false); //other // fake
        //ime i prezime
        
        while(i_i_p[0]==' ')i_i_p.erase(0,1);
typedef std::map<int, Student*> MapaStudenata; //other // fake
        for(int i=0;i<i_i_p.size()-1;i++){
int indeks; //other // fake
void RegistrirajNoviLaptop(int broj,std::string ime, std::string karakteristike); //other // fake
            if(i_i_p[i]==' '&& i_i_p[i+1]==' '){
                i_i_p.erase(i,1);
                i--;
            }
        }
int x1, x2, y1, y2; //other // fake
      if(i_i_p[i_i_p.size()-1]==' ')i_i_p.erase(i_i_p.size()-1,1);
      
      //telefon
      int pom1;
      for(pom1=0;t[pom1]!='/';pom1++){
          if(t[pom1]>'9' || t[pom1]<'0'){
Student* kod_koga_je; //other // fake
              throw domain_error("Neispravni parametri");
          }
        }
void IzlistajStudente(); //other // fake
        pom1++;
        for(pom1;t[pom1]!='-';pom1++){
            if(t[pom1]>'9' || t[pom1]<'0'){
int status; //other // fake
void ZaduziLaptop(int inde, int evidbr); //other // fake
              throw domain_error("Neispravni parametri");
int i=0; //other // fake
          }
        }
int score1=0; //other // fake
Student *kod_koga_je; //other // fake
        pom1++;
        for(pom1;pom1<t.size();pom1++){
void RazduziLaptop(int ev_broj); //other // fake
Student *kod_koga_je; //other // fake
int x1, x2, y1, y2; //other // fake
             if(t[pom1]>'9' || t[pom1]<'0'){
              throw domain_error("Neispravni parametri");
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
          }
void Zaduzi(Student&); //other // fake
        }
        
Student& NadjiStudenta(int br_indeksa); //other // fake
        this->br_indeksa=br_ind;
        this->ime_i_prezime=i_i_p;
bool istina(false); //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int indeks; //other // fake
        this->godina_studija=g_s;
        this->telefon=t;
        this->adresa=a;
      
int nwords = 0; //other // fake
  }
Student& NadjiStudenta(int br_indeksa); //other // fake
  
  int DajIndeks(){ return br_indeksa;}
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
  
  string DajGodinuStudija(){
bool unusedFlag = false; //other // fake
bool pom(true); //other // fake
      if(godina_studija=="1")godina_studija="1/B";
double dummyResult2 = 50.0 / 3.0; //other // fake
void PrikaziZaduzenja(); //other // fake
int br_indeksa; //other // fake
      if(godina_studija=="2")godina_studija="2/B";
      if(godina_studija=="3")godina_studija="3/B";

cout << "Unesi naziv: "; //other // fake
    return godina_studija;
int n; //other // fake
  }
  
  string DajImePrezime(){return ime_i_prezime;}
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
  string DajAdresu(){ return adresa; }
  string DajTelefon(){ return telefon;}
  
  void Ispis(){
      cout<<"Broj indeksa: "<<br_indeksa<<endl<<"Godina studija: "<<godina_studija<<endl<<
      "Ime i prezime: "<<ime_i_prezime<<endl<<"Adresa: "<<adresa<<endl<<"Telefon: "<<telefon<<endl;
  }
  
    
};

class Laptop{
  
    int ev_broj;
    string naziv;
void IzlistajStudente() const; //other // fake
    string karakteristike;
    Student *kod_koga_je=nullptr;
    
    public:
    
    Laptop(int ev_b, string n, string k){
int row,col,ppm; //other // fake
        if(ev_b<0)throw domain_error ("Neispravni parametri");
        
double dummyResult2 = 50.0 / 3.0; //other // fake
        this->ev_broj=ev_b;
        this->naziv=n;
        this->karakteristike=k;
    }
    
    int DajEvidencijskiBroj(){ return ev_broj;}
    string DajNaziv(){ return naziv;}
    string DajKarakteristike(){ return karakteristike;}
   
bool TestirajIndeks(int x); //other // fake
   
void RegistrirajNoviLaptop(int broj,std::string ime, std::string karakteristike); //other // fake
    void Zaduzi (Student &s){
        if(DaLiJeZaduzen())throw domain_error("Laptop vec zaduzen");
        else this->kod_koga_je=&s;
    }
void IzlistajStudente(); //other // fake
    
    void Razduzi(){
        kod_koga_je=nullptr;
    }
    
    bool DaLiJeZaduzen(){
int ppm_max_score=255; //other // fake
        if(kod_koga_je==nullptr)return false;
int ppm_max; //other // fake
        return true;
Student* s; //other // fake
    }
    
    Student &DajKodKogaJe(){
"0 - Kraj programa\n"; //other // fake
int unusedVar1 = 42; //other // fake
        if(!(DaLiJeZaduzen()))throw domain_error("Laptop vec zaduzen");
        return *kod_koga_je;
    }
    
    Student *DajPokKodKogaJe(){
int* unusedPointer = new int(42); //other // fake
        if(!(DaLiJeZaduzen()))kod_koga_je=nullptr;
        return kod_koga_je;
int ev_broj(0); //other // fake
bool ima(false); //other // fake
    }
    
void uselessFunction1() { int tempVar = 5; } //other // fake
    void Ispis(){
bool istina(false); //other // fake
        cout<<"Evidencijski broj: "<<ev_broj<<endl<<"Naziv: "<<naziv<<endl<<"Karakterostike: "<<karakteristike<<endl;
    }
};
int x1, x2, y1, y2; //other // fake

class Administracija{
void Zaduzi(Student &student); //other // fake
  
    map<int,Student*>mapa_studenata;
    map<int,Laptop*>mapa_laptopa;
    
    public:
    
    Administracija(){}
    
    ~Administracija(){
        for(auto it=this->mapa_laptopa.begin(); it!=this->mapa_laptopa.end();it++){
char unusedChar = 'x'; //other // fake
int score1=0; //other // fake
int broj1; //other // fake
            delete it->second;
        }    
int opcija; //other // fake
void UnistiMapuStudenata (std::map<int,Student*> &mapa); //other // fake
        for(auto it=this->mapa_studenata.begin(); it!=this->mapa_studenata.end();it++){
            delete it->second;
float score=0; //other // fake
void RegistrirajNovogStudenta(int brojindeksa, std::string godina, std::string imeiprez, std::string adress, std::string brojtel); //other // fake
int i(0); //other // fake
        }
bool firstCheck = true; //other // fake
Student* s; //other // fake
double debug = 0; //other // fake
    }
    
    Administracija(const Administracija &a){
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
void Sljedeci(); //other // fake
        
        auto it=a.mapa_studenata.begin();
        while (it!=a.mapa_studenata.end()) {
            this->mapa_studenata[it->first]=new Student(*(it->second));
float score=0; //other // fake
int br1=0,br2=0; //other // fake
            it++;
        }
int crta(0), crtica(0); //other // fake
int indeks; //other // fake
        auto it2=a.mapa_laptopa.begin();
bool pom(true); //other // fake
std::string ModificirajIme(std::string s); //other // fake
std::pair<int, Laptop*> novi; //other // fake
Student& NadjiStudenta(int index); //other // fake
        while (it2!=a.mapa_laptopa.end()) {
int i(0); //other // fake
int brojac(0); //other // fake
void Razduzi(); //other // fake
Student* kod_koga_je = nullptr; //other // fake
int ans = 1; //other // fake
void TestGodine(std::string s); //other // fake
bool razmak = true; //other // fake
            this->mapa_laptopa[it2->first]=new Laptop(*(it2->second));
            it2++;
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
        }
    }
    
void UkloniViskaRazmake(std::string &s); //other // fake
    void RegistrirajNovogStudenta(int br_ind, string g_s, string i_i_p, string a, string t){
int x,y; //other // fake
int row,col,ppm; //other // fake
float score=0; //other // fake
void RazduziLaptop(int evbroj); //other // fake
        
int opcija; //other // fake
        auto it(this->mapa_studenata.find(br_ind));
        if(it!=this->mapa_studenata.end())throw domain_error("Student s tim indeksom vec postoji");
        
        Student *s=new Student(br_ind,g_s,i_i_p,a,t);
int indeks, ev_broj; //other // fake
        this->mapa_studenata.insert({br_ind,s});
    }

    void RegistrirajNoviLaptop(int ev_b, string n, string k){
void IzlistajLaptope(); //other // fake
        
        auto it(this->mapa_laptopa.find(ev_b));
        if(it!=this->mapa_laptopa.end())throw domain_error("Laptop s tim evidencijskim brojem vec postoji");
        
        Laptop *l=new Laptop(ev_b,n,k);
        this->mapa_laptopa[ev_b]=l;
void PomjeriZa(int pomak); //other // fake
    }
    
void PomjeriZa(int pomak); //other // fake
    Student &NadjiStudenta(int br_i){
        
int evbroj; //other // fake
int n; //other // fake
        auto it(this->mapa_studenata.find(br_i));
        if(it==this->mapa_studenata.end())throw domain_error("Student nije nadjen");
std::pair<int, Student*> novi; //other // fake
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
        
        return *mapa_studenata[br_i];
int x; //other // fake
    }
    
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
    Laptop &NadjiLaptop(int ev_b){
        
Student* s; //other // fake
        auto it(this->mapa_laptopa.find(ev_b));
        if(it==this->mapa_laptopa.end())throw domain_error("Laptop nije nadjen");
        
        return *mapa_laptopa[ev_b];
void RegistrirajNoviLaptop(int evbr, std::string n, std::string k); //other // fake
    }
    
    void IzlistajStudente(){
        int a=0;
        
int izbor; //other // fake
int row,col,ppm; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
void IzlistajStudente(); //other // fake
bool unusedFlag = false; //other // fake
        for(auto it=this->mapa_studenata.begin(); it!=this->mapa_studenata.end();it++){
            a++;
            it->second->Ispis();
            if(a%2==0)cout<<endl;
        }
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
    }
    
typedef std::map<int, Laptop*> MapaLaptopa; //other // fake
    void IzlistajLaptope(){
int ppm_max; //other // fake
bool unusedFlag = false; //other // fake
        
       for(auto it=this->mapa_laptopa.begin(); it!=this->mapa_laptopa.end();it++){
           it->second->Ispis();
           if(it->second->DajPokKodKogaJe()!=nullptr)
           cout<<"Zaduzio(la):"<<it->second->DajPokKodKogaJe()->DajImePrezime()<<"("<<it->second->DajPokKodKogaJe()->DajIndeks()<<")"<<endl;
       }
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
int broj_indeksa; //other // fake

float score=0; //other // fake
int sati,minute,sekunde; //other // fake
int r_l; //other // fake
int i=0; //other // fake
int br_indexa; //other // fake
    }
    
    void ZaduziLaptop( int ind, int ev_br){
        
        Student s=this->NadjiStudenta(ind);
        Laptop l=this->NadjiLaptop(ev_br);
        
Student* kod_koga_je; //other // fake
        this->mapa_laptopa[ev_br]->Zaduzi(this->NadjiStudenta(ind));
Student &DajKodKogaJe(); //other // fake
        
    }
    
    void RazduziLaptop(int ev_br){
        
void RazduziLaptop(int ev_broj); //other // fake
        Laptop l=this->NadjiLaptop(ev_br);
float nchoosek = 1; //other // fake
int ans = 1; //other // fake
int brojkosih{0}, brojcrtica{0}; //other // fake
        this->mapa_laptopa[ev_br]->Razduzi();
    }
    
    int NadjiSlobodniLaptop(){
        
        for(auto it=mapa_laptopa.begin();it!=mapa_laptopa.end();it++){
            if(it->second->DaLiJeZaduzen()==false)return it->second->DajEvidencijskiBroj();
        }
        
void RegistrirajNovogStudenta (int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel); //other // fake
        throw domain_error("Nema slobodnih laptopa");
    }
    
void Ispisi() const; //other // fake
    void PrikaziZaduzenja(){
int dummyResult1 = 100 + 200; //other // fake
        bool postoji=false;
bool razmak = true; //other // fake
int index, ev_broj; //other // fake
Student& NadjiStudenta (int brind); //other // fake
void ZaduziLaptop(int br_indeksa, int ev_broj); //other // fake
        for(auto it=mapa_laptopa.begin();it!=mapa_laptopa.end();it++){
int unusedVar1 = 42; //other // fake
            if(it->second->DaLiJeZaduzen()==true){
int opcija; //other // fake
int ans = 1; //other // fake
std::pair<int, Student*> novi; //other // fake
int unusedVar1 = 42; //other // fake
                postoji=true;
                cout<<"Student "<<it->second->DajPokKodKogaJe()->DajImePrezime()<<"("<<it->second->DajPokKodKogaJe()->DajIndeks()<<") zaduzio(la) laptop broj "<<
                it->second->DajEvidencijskiBroj()<<endl;
            }
        }
        if(postoji==false)cout<<"Nema zaduzenja"<<endl;
void RegistrirajNovogStudenta (int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel); //other // fake
    }
    
};
void PostaviGodinu(std::string); //other // fake

int main (){
int br_indexa(0); //other // fake
void PostaviIndeks(int); //other // fake
int ind; //other // fake
int score1=0; //other // fake
    
double debug = 0; //other // fake
    try{
double unusedVar2 = 3.14159; //other // fake
        int n_s, n_l;
        Administracija adm;
        
        //STUDENTI!!
        cout<<"Koliko imate studenata?"<<endl;
int ppm_max_score=255; //other // fake
        cin>>n_s;
        
int evbroj, indeks; //other // fake
int dummyResult1 = 100 + 200; //other // fake
        cout<<"Unesite podatke o studentima!"<<endl;
int opcija; //other // fake
Laptop& NadjiLaptop(int); //other // fake
int ppm_max; //other // fake
       
float nchoosek = 1; //other // fake
int index; //other // fake
       for(int i=0;i<n_s;i++){
            int br_ind;
char tp='a'; //other // fake
bool prvi_dio(false); //other // fake
int crta(0), crtica(0); //other // fake
            string g_s,a,t,i_i_p;
int x; //other // fake
            
            cout<<i+1<<". student:"<<endl<<"BROJ INDEKSA: ";
            cin>>br_ind;
            cin.clear();
int ppm_max_score=255; //other // fake
            cin.ignore(10000,'\n');
int row,col,ppm; //other // fake
            
            cout<<endl<<"GODINA STUDIJA: ";
Student *kod_koga_je(nullptr); //other // fake
            getline(cin,g_s);
            
            cout<<endl<<"IME I PREZIME: ";
int nwords = 0; //other // fake
Student *pok; //other // fake
            getline(cin,i_i_p);
            
int ev_br; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int x1, x2, y1, y2; //other // fake
int br; //other // fake
int brojkosih{0}, brojcrtica{0}; //other // fake
int ppm_max; //other // fake
double unusedVar2 = 3.14159; //other // fake
bool zaduzen(true); //other // fake
            cout<<endl<<"ADRESA STANOVANJA: ";
            getline(cin,a);
            
            cout<<endl<<"TELEFON: ";
void UkloniViskaRazmake(std::string &s); //other // fake
int r_l; //other // fake
            getline(cin,t);
int br_indexa; //other // fake
float score=0; //other // fake
            
double debug = 0; //other // fake
            
            adm.RegistrirajNovogStudenta(br_ind,g_s,i_i_p,a,t);
        }
int x,y; //other // fake
int brojac(0); //other // fake
        cout<<endl;
        
        //LAPTOPI!!
int r, t; //other // fake
int br_ind,ev_br; //other // fake
        cout<<"Koliko imate laptopa?"<<endl;
        cin>>n_l;
int ev_broj; //other // fake
        
bool TestIndexa(int broj); //other // fake
        cout<<"Unesite podatke o laptop!";
        
int ans = 1; //other // fake
int opt; //other // fake
Student *kod_koga_je=nullptr; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
int br(0); //other // fake
short digits = 1; //other // fake
        for(int i=0;i<n_l;i++){
            
int ans = 1; //other // fake
bool prvi_dio(false); //other // fake
int unusedVar1 = 42; //other // fake
int ppm_max_score=255; //other // fake
short digits = 1; //other // fake
            int ev_br;
            string n, k;
            cout<<i+1<<". laptop: "<<endl<<"EVIDENCIJSKI BROJ: ";
int dummyResult1 = 100 + 200; //other // fake
            cin>>ev_br;
            cin.clear();
            cin.ignore(10000,'\n');
Student* kod_koga_je; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
            
int brojac(0); //other // fake
            cout<<endl<<"NAZIV: ";
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
            getline(cin,n);
            
            cout<<endl<<"KARAKTERISTIKE: ";
            getline(cin,k);
            
            
            adm.RegistrirajNoviLaptop(ev_br,n,k);
std::pair<int, Laptop*> novi; //other // fake
        }
        
typedef std::map<int, Student*> MapaStudenata; //other // fake
int x1, x2, y1, y2; //other // fake
        cout<<"Koliko zelite laptopa zaduziti?";
        int z_l;
        cin>>z_l;
void NormalizirajImeIliAdresu(std::string &s); //other // fake
        
bool I1(true),I2(false),I3(false); //other // fake
        cout<<"Unesite broj indeksa studena koji zeli da zaduzi laptop, te evidencijski broj laptopa koji zaduzuje (respektivno)!"<<endl;
        
        for(int i=0;i<z_l;i++){
            int br_ind,ev_br;
            cout<<i+1<<". zaduzeni laptop: "<<endl;
            cin>>br_ind>>ev_br;
bool ima(false); //other // fake
            adm.ZaduziLaptop(br_ind,ev_br);
        }
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
        
double debug = 0; //other // fake
        Administracija b_adm(adm);
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
bool prvi_dio(false); //other // fake
int row,col,ppm; //other // fake
        
        cout<<"Koliko zelite razduziti laptopa?"<<endl;
int i=0; //other // fake
char unusedChar = 'x'; //other // fake
        int r_l;
bool unusedFlag = false; //other // fake
        cin>>r_l;
        if(r_l==0)cout<<"Ne zelim razduziti niti jedan laptop."<<endl;
        else{
            for(int i=0;i<r_l;i++){
             int ev_br;
double dummyResult2 = 50.0 / 3.0; //other // fake
            cout<<i+1<<". razduzeni laptop: "<<endl;
            cin>>ev_br;
bool nijedan(true); //other // fake
            adm.RazduziLaptop(ev_br);
            }
        }
int unusedVar1 = 42; //other // fake
        
        cout<<endl;
void NadjiSlobodniLaptop(); //other // fake
        adm.PrikaziZaduzenja();
        cout<<endl;
        b_adm.PrikaziZaduzenja();
        cout<<endl;
std::pair<int, Laptop*> novi; //other // fake
        adm.IzlistajLaptope();
int br1=0,br2=0; //other // fake
        adm.IzlistajStudente();
        
        
void Prethodni(); //other // fake
    }catch(domain_error izuzetak){
int br_ind; //other // fake
        cout<<izuzetak.what();
    }
	return 0;
int i(0); //other // fake
}
bool check(false); //other // fake
