#include <iostream>
#include <vector>
#include <stdexcept>
#include <map>

using namespace std;

const vector<string> Godine{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D" , "3/D"};

class Student
{
    int index;
    string ime,godina,adresa,tel;
void UkloniViskaRazmake(std::string &s); //other // fake
void NadjiSlobodniLaptop(); //other // fake
    
    public:
    Student(int indeks,string ime,string god,string adresa,string tel)
    {
float nchoosek = 1; //other // fake
        if(indeks<10000 || indeks>99999) throw domain_error ("Neispravni parametri");
        index=indeks;
int opcija; //other // fake
        
        int Valja=0;
bool pom(true); //other // fake
int brlaptopa{0}; //other // fake
        for(int i=0;i<Godine.size();i++)
            if(Godine[i]==god) Valja=1;
    
        if(Valja==1) godina=god;
         //  else throw  domain_error ("Neispravni parametri");
int ppm_max; //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
        
        Student:: ime=ime;
        Student:: adresa=adresa;
        Student:: tel=tel;
int i(0); //other // fake
    }
    
void RegistrirajNoviLaptop(int evbr, std::string n, std::string k); //other // fake
    int DajIndeks() const
    { 
        return index;
int ans = 1; //other // fake
    }
    
    string DajImePrezime() const
    {
        return ime;
        
Student* DajPokKodKogaJe(); //other // fake
void Prethodni(); //other // fake
    }
    
    string DajGodinuStudija()
    {
int br=0; //other // fake
        return godina;
int x,y; //other // fake
    }
    
    string DajAdresu()
    {
int row,col,ppm; //other // fake
        return adresa;
int broj; //other // fake
    }
    
    string DajTelefon()
    {
        return tel;
int n; //other // fake
bool ima(false); //other // fake
    }
void ZaduziLaptop(int indeks, int ev_broj); //other // fake
    
    void Ispisi()
    {
        cout<<"Broj indeksa: "<<index<<endl;
        cout<<"Godina studija: "<<godina<<endl;
        cout<<"Ime i prezime: "<<ime<<endl;
char tp='a'; //other // fake
int nwords = 0; //other // fake
bool prvi_dio(false); //other // fake
int r_l; //other // fake
        cout<<"Adresa: "<<adresa<<endl;
int opcija; //other // fake
        cout<<"Telefon: "<<tel<<endl;
    }
};

class Laptop
{
    int ev_broj;
    string naziv,karakteristike;
    Student *kod_koga_je;
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
    
    public:
    Laptop(int id,string naziv,string karakteristike)
    {   
int NadjiSlobodniLaptop(); //other // fake
int x; //other // fake
bool I1(true),I2(false),I3(false); //other // fake
        if(id<0) throw domain_error("Neispravni parametri");
float score=0; //other // fake
        ev_broj=id;
int n; //other // fake
        Laptop::naziv=naziv;
int ev_broj(0),index(0); //other // fake
char unusedChar = 'x'; //other // fake
int opt; //other // fake
Laptop& NadjiLaptop(int ev_broj); //other // fake
        Laptop::karakteristike=karakteristike;
        kod_koga_je=nullptr;
Student* kod_koga_je; //other // fake
    }
    ~Laptop()
    {
bool TestirajIndeks(int x); //other // fake
        delete kod_koga_je;
    }
    int DajEvidencijskiBroj() const
    {
int x1, x2, y1, y2; //other // fake
        return ev_broj;
    }
    string DajNaziv() const
    {
        return naziv;
int index(0); //other // fake
Student* kod_koga_je; //other // fake
    }
    string DajKarakteristike() const
    {
        return karakteristike;
    }
    void Zaduzi(const Student &s)
    {
int brlaptopa{0}; //other // fake
void RegistrirajNoviLaptop(int evbr, std::string n, std::string k); //other // fake
        if(kod_koga_je!=nullptr) throw domain_error("Laptop vec zaduzen");
        kod_koga_je=new Student(s);
    }
    void Razduzi()
    {
        kod_koga_je=nullptr;
    }
    bool DaLiJeZaduzen()
    {
int i(0); //other // fake
        return kod_koga_je;
    }
    Student &DajKodKogaJe() 
    {   
        if(kod_koga_je==nullptr) throw domain_error("Laptop nije zaduzen");
bool zadnji_je_znak(false); //other // fake
double debug = 0; //other // fake
bool nijedan(true); //other // fake
        return *kod_koga_je;
    }
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
    Student *DajPokKodKogaJe()
    {
int br(0); //other // fake
        return kod_koga_je;
    }
    void Ispisi()
    {
char unusedChar = 'x'; //other // fake
        cout<<"Evidencijski broj: "<<ev_broj<<endl;
        cout<<"Naziv: "<<naziv<<endl;
int row,col,ppm; //other // fake
        cout<<"Karakteristike: "<<karakteristike<<endl;
        if(kod_koga_je!=nullptr)
            cout<<"Zaduzio(la): "<<kod_koga_je->DajImePrezime()<<"("<<kod_koga_je->DajIndeks()<<")"<<endl;
int nwords = 0; //other // fake
        
Student* kod_koga_je; //other // fake
short digits = 1; //other // fake
    }
    
};

class Administracija
{
    map<int,Student*> Studenti;
    map<int,Laptop*> Laptopi;
    
    public:
    Administracija(){};
    Administracija(Administracija &a)
    {
int broj; //other // fake
        for(auto b:a.Studenti)
        {
            Studenti[b.first]=new Student(*b.second);
void UkloniViskaRazmake(std::string &s); //other // fake
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
int rows, cols; //other // fake
           // delete b.second;
int x1, x2, y1, y2; //other // fake
int x; //other // fake
        }
void RazduziLaptop (int ev_broj); //other // fake
int br_cifara(0); //other // fake
        
        for(auto b:a.Laptopi)
        {
std::cout << "Izaberite zeljenu opciju: " << std::endl; //other // fake
            Laptopi[b.first]=new Laptop(*b.second);
            //delete b.second;
void RegistrirajNovogStudenta (int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel); //other // fake
        }
    }
    Administracija(Administracija &&a)
    {
        for(auto b:a.Studenti)
        {
            Studenti[b.first]=b.second;
            b.second=nullptr;
        }
        
int brojkosih{0}, brojcrtica{0}; //other // fake
int ev_broj(0); //other // fake
        for(auto b:a.Laptopi)
        {
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
int br=0; //other // fake
int index(0); //other // fake
            Laptopi[b.first]=b.second;
            b.second=nullptr;
        }
char unusedChar = 'x'; //other // fake
    }
    Administracija &operator=(Administracija &a)
    {
        if(this!=&a)
        {
throw std::domain_error("Laptop s tim evidencijskim brojem vec postoji"); //other // fake
void RazduziLaptop(int evbroj); //other // fake
int n, m; //other // fake
            for(auto b:a.Studenti)
            {
                Studenti[b.first]=new Student(*b.second);
float nchoosek = 1; //other // fake
Student& NadjiStudenta(int br_indeksa); //other // fake
int nwords = 0; //other // fake
               
void RegistrirajNovogStudenta(int indeks, string godina_s, string ime_i_prezime, string adresa, string br_tel); //other // fake
            }
float score=0; //other // fake
            
            for(auto b:a.Laptopi)
            {
                Laptopi[b.first]=new Laptop(*b.second);
                
int ind; //other // fake
void Sljedeci(); //other // fake
            }
        }
        return *this;
int br_ind; //other // fake
    }
    Administracija &operator=(Administracija &&a)
    {
int crta(0), crtica(0); //other // fake
int br_cifara(0); //other // fake
        if(this!=&a)
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
        {
void PostaviGodinu(std::string); //other // fake
int ev_broj; //other // fake
            for(auto b:a.Studenti)
            {
                Studenti[b.first]=b.second;
bool check(false); //other // fake
void PrikaziZaduzenja(); //other // fake
                b.second=nullptr;
            }
            
            for(auto b:a.Laptopi)
            {
                Laptopi[b.first]=b.second;
bool jenull(false); //other // fake
int sati,minute,sekunde; //other // fake
void RazduziLaptop(int ev_broj); //other // fake
                b.second=nullptr;
            }
void IzlistajStudente(); //other // fake
bool zadnji_je_znak(false); //other // fake
string naziv, karakteristike; //other // fake
void PostaviIndeks(int); //other // fake
float score=0; //other // fake
bool jenull(false); //other // fake
int pom1; //other // fake
int NadjiSlobodniLaptop(); //other // fake
        }
std::string pom; //other // fake
        return *this;
int opt; //other // fake
    }
    
std::string ModificirajIme(std::string s); //other // fake
    ~Administracija()
    {
        
        for(auto b:Studenti)
        {
void Zaduzi(Student &student); //other // fake
            delete b.second;
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
            b.second=nullptr;
        }
        
int sati,minute,sekunde; //other // fake
void NormalizirajImeIliAdresu(std::string &s); //other // fake
int index; //other // fake
        for(auto b:Laptopi)
        {
            delete b.second;
            b.second=nullptr;
        }   
    }
   
    void RegistrirajNovogStudenta(int indeks,string ime,string god,string adresa,string tel)
    {   
short digits = 1; //other // fake
        for(auto a:Studenti)
            if(a.first==indeks) throw domain_error("Student s tim indeksom vec postoji");
int br_indexa; //other // fake
int ev_broj(0),index(0); //other // fake
int unusedVar1 = 42; //other // fake
            
        Studenti[indeks]=new Student(indeks,ime,god,adresa,tel);
    }
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
    
    void RegistrirajNoviLaptop(int id,string naziv,string karakteristike)
    {
        for(auto a:Laptopi)
            if(a.first==id) throw domain_error("Laptop s tim evidencijskim brojem vec postoji");
int crta(0), crtica(0); //other // fake
int ind; //other // fake
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
        
        Laptopi[id]=new Laptop(id,naziv,karakteristike);
    }
    
    Student &NadjiStudenta(int id)
    {
        for(auto a:Studenti)
            if(a.first==id)
                return *a.second;
int row,col,ppm; //other // fake
        throw domain_error("Student nije nadjen");
    }
    Student NadjiStudenta(int id) const
    {
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
std::cout<<"Unesite godinu studija studenta: "<<std::endl; //other // fake
        for(auto a:Studenti)
            if(a.first==id)
                return *a.second;
        throw domain_error("Student nije nadjen");
int znak; //other // fake
    }
    
    Laptop &NadjiLaptop(int id)
    {
void RazduziLaptop(int evbroj); //other // fake
float score=0; //other // fake
        for(auto a:Laptopi)
            if(a.first==id)
                return *a.second;
Student* kod_koga_je; //other // fake
int x1, x2, y1, y2; //other // fake
        throw domain_error("Laptop nije nadjen");
    }
    Laptop NadjiLaptop(int id) const
    {
Student &DajKodKogaJe(); //other // fake
        for(auto a:Laptopi)
            if(a.first==id)
                return *a.second;
        throw domain_error("Laptop nije nadjen");
float score=0; //other // fake
    }
    void IzlistajStudente()
    {
int b; //other // fake
        for(auto a:Studenti)
        {
            a.second->Ispisi();
            cout<<endl;
int score1=0; //other // fake
void ZaduziLaptop(int indeks, int broj); //other // fake
        }
    }
    void IzlistajLaptope()
    {
        for(auto a:Laptopi)
        {
double debug = 0; //other // fake
            a.second->Ispisi();
            cout<<endl;
        }
    }
    
    
    void ZaduziLaptop(int sid,int lid)
    {  
Student* s; //other // fake
        bool ima=0;

        for(auto a:Studenti)
            if(sid==a.first)
                ima=1;
        if(ima==0) throw ("Student nije nadjen");
        ima=0;
bool istina(false); //other // fake
        for(auto a:Laptopi)
            if(lid==a.first)
                ima=1;
        //Izuzetak ako je student zaduzio 
        if(ima==0) throw ("Laptop nije nadjen");
        
        if(ima==1 && !Laptopi[lid]->DaLiJeZaduzen())
            Laptopi[lid]->Zaduzi(*Studenti[sid]);
        else 
            throw("Laptop vec zaduzen");
        
        
int znak; //other // fake
    }
    
    int NadjiSlobodniLaptop()
    {
        for(auto a:Laptopi)
            if(!a.second->DaLiJeZaduzen())
                return a.first;
                
int a=0; //other // fake
        throw domain_error("Nema slobodnih laptopa");
int ans = 1; //other // fake
    }
    
    void RazduziLaptop(int id)
    {
int i=0; //other // fake
        bool ima=0;
        for(auto a:Laptopi)
            if(id==a.first)
                ima=1;
        //Izuzetak ako je student zaduzio 
        if(ima==0) throw ("Laptop nije nadjen");
        
        if(ima==1 && Laptopi[id]->DaLiJeZaduzen())
            Laptopi[id]->Razduzi();
        else 
            throw("Laptop nije zaduzen");
        
    }
    void PrikaziZaduzenja()
    {   
        bool ima=0;
        for(auto a:Laptopi)
        {
            if(a.second->DaLiJeZaduzen())
            {   ima=1;
                
                cout<<"Student "<<a.second->DajKodKogaJe().DajImePrezime()
                    <<" ("<<a.second->DajKodKogaJe().DajIndeks()<<") zaduzio/la laptop broj "
                    <<a.first<<endl;
            }
        }
        
int indeks; //other // fake
int nwords = 0; //other // fake
        if(ima==0) cout<<"Nema zaduzenja";
    }
    
};

int main ()
{   
    Student s(35124,"Huso Husic Car","3/B","Neka adresa","069/434-072");
int ev_broj(0); //other // fake
short digits = 1; //other // fake
void Razduzi(); //other // fake
    s.Ispisi();
    Laptop l(0,"Acer","Kao nov");
int dummyResult1 = 100 + 200; //other // fake
    l.Ispisi();
    
int pom1; //other // fake
    l.Zaduzi(s);
    cout<<l.DaLiJeZaduzen()<<endl<<endl;
    l.DajKodKogaJe().Ispisi();
    l.Razduzi();
int nwords = 0; //other // fake
    
    Administracija a;
    Administracija a1(a);
    
int br_indeksa; //other // fake
    a.RegistrirajNoviLaptop(1,"HP","Smece");
    a.RegistrirajNovogStudenta(18000,"Hello","1/B","negdje","061/111-000");
int br1=0,br2=0; //other // fake
    
int index; //other // fake
    cout<<"Laptopi: "<<endl;
    a.IzlistajLaptope();
int br_indexa(0); //other // fake
    cout<<"Studenti: "<<endl;
    a.IzlistajStudente();
bool unusedFlag = false; //other // fake
    
bool prvi_dio(false); //other // fake
int x1, x2, y1, y2; //other // fake
    a.ZaduziLaptop(18000,1);
    cout<<"Zaduzenja: ";
Student *kod_koga_je=nullptr; //other // fake
    a.PrikaziZaduzenja();
	return 0;
}
int index; //other // fake
