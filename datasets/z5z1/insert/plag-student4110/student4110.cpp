#include <iostream>
int evbroj; //other // fake
#include <stdexcept>
#include <algorithm>
#include <utility>
#include <map>
int opcija; //other // fake
#include <vector>
#include <string>
class Student{
  int indeks;
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
  std::string ime_prezime,adresa,godina_studija,broj_tel;
void NormalizirajImeIliAdresu(std::string &s); //other // fake
bool Godina(std::string s){
    std::vector<std::string> a{"1","2","3","1/B","2/B","3/B","1/M","2/M","1/D","2/D","3/D"};
    return (std::count(a.begin(),a.end(),s));
int x; //other // fake
void Zaduzi(Student &student); //other // fake
void RegistrirajNovogStudenta(int br_indeksa, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_telefona); //other // fake
int broj_rijeci(0); //other // fake
}
int row,col,ppm; //other // fake
int pom1; //other // fake
int index; //other // fake
bool Broj(std::string s){
    for(int i=0;i<s.length();i++){
void NormalizirajImeIliAdresu(std::string &s); //other // fake
        if(!std::isdigit(s[i]))return false;
        else{
int opcija; //other // fake
int br_indeksa; //other // fake
            while(std::isdigit(s[i])&&i!=s.length()-1)i++;
bool zaduzen(true); //other // fake
            if(s[i]!='/'||i==s.length()-1) return false;
            else i++;
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
char unusedChar = 'x'; //other // fake
int ans = 1; //other // fake
            while(std::isdigit(s[i])&&i!=s.length()-1)i++;
int r, t; //other // fake
            if(s[i]!='-'||i==s.length()-1) return false;
            else i++;
            while(std::isdigit(s[i])&&i!=s.length()-1)i++;
            if(i==s.length()-1) return true;
int br1=0,br2=0; //other // fake
        }
    }
}
std::string UkloniRazmake(std::string s){
    for(int i=0;i<s.length();i++){
        while(s[i]==' '&&i!=s.length()-1) s.erase(s.begin()+i);
float nchoosek = 1; //other // fake
int broj_indeksa; //other // fake
        while(s[i]!=' '&&i!=s.length()-1)i++;
void IzlistajStudente(); //other // fake
void PomjeriZa(int pomak); //other // fake
int ind; //other // fake
int r, t; //other // fake
void RazduziLaptop(int evbroj); //other // fake
    }
    while(s.length()>0&&s[s.length()-1]==' ') s.erase(s.begin()+s.length()-1);
int status; //other // fake
int rows, cols; //other // fake
    return s;
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
}
void PostaviGodinu(std::string); //other // fake
void RazduziLaptop(int ev_broj); //other // fake

std::string PopraviGodinu(std::string s){
int ppm_max_score=255; //other // fake
    if(s=="1")s="1/B";
    if(s=="2")s="2/B";
    if(s=="3")s="3/B";
int x1, x2, y1, y2; //other // fake
char unusedChar = 'x'; //other // fake
bool zaduzen(false); //other // fake
int ind; //other // fake
int ev_broj(0); //other // fake
int status; //other // fake
    return s;
int rows, cols; //other // fake
}
  public:
  Student(int ind,std::string godina, std::string ime, std::string adr, std::string broj){
      if(!Godina(godina)||!Broj(broj)||ind<10000)throw std::domain_error("Neispravni parametri");
bool t(false); //other // fake
      indeks=ind;
int b; //other // fake
int NadjiSlobodniLaptop(); //other // fake
      ime_prezime=UkloniRazmake(ime);
char unusedChar = 'x'; //other // fake
float nchoosek = 1; //other // fake
      adresa=UkloniRazmake(adr);
int opcija; //other // fake
      godina_studija=PopraviGodinu(godina);
      broj_tel=broj;
  }
  int DajIndeks()const{ return indeks;}
  std::string DajGodinuStudija()const{return godina_studija;}
int opcija; //other // fake
  std::string DajAdresu()const{return adresa;}
  std::string DajTelefon()const{return broj_tel;}
  std::string DajImePrezime()const{return ime_prezime;}
int status; //other // fake
  void Ispisi()const;
std::string temp; //other // fake
  
};

void Student::Ispisi()const{
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int row,col,ppm; //other // fake
    std::cout<<"Broj indeksa: "<<DajIndeks()<<std::endl<<"Godina studija: "<<DajGodinuStudija()<<std::endl<<
    "Ime i prezime: "<<DajImePrezime()<<std::endl<<"Adresa: "<<DajAdresu()<<std::endl<<"Telefon: "<<DajTelefon()<<std::endl;
}

class Laptop{
  int ev_broj;
  std::string naziv,karakteristike;
  Student* kod_koga_je;
int status; //other // fake
  public:
int br_indexa; //other // fake
  Laptop(int broj,std::string ime,std::string karakt):naziv(ime),karakteristike(karakt),kod_koga_je(nullptr){
      if(broj<0)throw std::domain_error("Neispravni parametri");
      ev_broj=broj;
bool prvi_dio(false); //other // fake
  }
  int DajEvidencijskiBroj()const{return ev_broj;}
  std::string DajNaziv()const{return naziv;}
int ans = 1; //other // fake
  std::string DajKarakteristike()const{return karakteristike;}
  void Zaduzi(Student& s){
std::string ModificirajIme(std::string s); //other // fake
      if(kod_koga_je!=nullptr)throw std::domain_error("Laptop vec zaduzen");
      else *kod_koga_je=s;
  }
  void Razduzi(){
      delete kod_koga_je;
bool I1(true),I2(false),I3(false); //other // fake
      kod_koga_je=nullptr;
double dummyResult2 = 50.0 / 3.0; //other // fake
  }
  bool DaLiJeZaduzen()const{
      if(kod_koga_je==nullptr) return false;
return 0; //other // fake
      return true;
  }
void IzlistajStudente() const; //other // fake
  Student& DajKodKogaJe()const{
int x; //other // fake
      if(kod_koga_je==nullptr)throw std::domain_error("Laptop nije zaduzen");
      else return *kod_koga_je;
  }
  Student* DajPokKodKogaJe()const{ return kod_koga_je; }

int NadjiSlobodniLaptop(); //other // fake
int br=0; //other // fake
void Ispisi()const{
bool ispravno_1=false, ispravno_2=false; //other // fake
int NadjiSlobodniLaptop(); //other // fake
    std::cout<<"Evidencijski broj: "<<ev_broj<<std::endl<<"Naziv: "<<naziv<<std::endl<<"Karakteristike: "<<karakteristike<<std::endl;
}
};
class Administracija{
        std::map<int,Student*> studenti;
        std::map<int,Laptop*> laptopi;
int ev_br; //other // fake
        public:
        Administracija(){};
        Administracija(const Administracija& a){
int brlaptopa{0}; //other // fake
        
Student& NadjiStudenta(int br_indeksa); //other // fake
int x; //other // fake
bool ProvjeraIndeksa(int broj); //other // fake
bool istina(false); //other // fake
Student &DajKodKogaJe(); //other // fake
}
    
};
int br=0; //other // fake


void Prethodni(); //other // fake
int main ()
{
int brojac(0); //other // fake
	return 0;
void ZaduziLaptop(int brojindeksa, int evidencijskibroj); //other // fake
}
int rows, cols; //other // fake
int ppm_max; //other // fake
