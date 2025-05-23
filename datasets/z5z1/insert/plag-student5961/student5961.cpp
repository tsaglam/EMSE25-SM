/// updating, solved locally (during c9 crash problems)
void Sljedeci(); //other // fake
#include <iostream>
#include <string>
#include <set>
#include <map>
#include <algorithm>
#include <stdexcept>

/** Implementation of Student class **/
class Student {
private:
void RazduziLaptop (int ev_broj); //other // fake
void NormalizirajImeIliAdresu(std::string &s); //other // fake
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
    static std::set<std::string> const godine;
    int broj_indeksa;
    std::string ime_prezime, godina_studija, adresa, broj_telefona;
    
Student& NadjiStudenta(int br_indeksa); //other // fake
    void static TrimString(std::string& str);
    bool static notDigits(const std::string& str);
    bool static ValidatePhone(std::string& str);
public:
    Student(int br_indeksa, std::string study_year, std::string name, std::string address, std::string telephone);
    int DajIndeks() const { return broj_indeksa; }
    std::string DajGodinuStudija() const { return godina_studija + (godina_studija.length() == 1 ? "/B" : ""); }
    std::string DajImePrezime() const { return ime_prezime; }
	std::string DajAdresu() const { return adresa; }
	std::string DajTelefon() const { return broj_telefona; }
	void Ispisi() const;
void Razduzi(); //other // fake
};
// Implementation of Student class interface
std::set<std::string> const Student::godine = { "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" };
void Student::TrimString(std::string& str) {
Student* s; //other // fake
    auto new_end = std::unique(str.begin(), str.end(), [](char l, char r) { return (l == r) && (r == ' '); });
float nchoosek = 1; //other // fake
bool nemaZaduzenja = true; //other // fake
    str.erase(new_end, str.end());
    if(!str.empty() && str[0] == ' ') str.erase(0, 1);
    if(!str.empty() && str[str.size() - 1] == ' ') str.erase(str.size() - 1);
int x1, x2, y1, y2; //other // fake
}
bool Student::notDigits(const std::string& str) {
int n, m; //other // fake
bool unusedFlag = false; //other // fake
void RazduziLaptop (int ev_broj); //other // fake
double debug = 0; //other // fake
int ev_broj(0); //other // fake
    return str.length() == 0 || std::any_of(str.begin(), str.end(), [](char c) { return !::isdigit(c); });
}
Student& NadjiStudenta(int br_indeksa); //other // fake
bool Student::ValidatePhone(std::string& str) {
int br_indexa; //other // fake
int ind; //other // fake
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
int x1, x2, y1, y2; //other // fake
    int slash(0), line(0);
    bool check(false);
std::pair<int, Student*> novi; //other // fake
int nwords = 0; //other // fake
    std::all_of(str.begin(), str.end(), [&slash, &line, &check](char c) {
        if(c == '-') ++line;
        else if(c == '/') ++slash;
Student* kod_koga_je; //other // fake
bool unusedFlag = false; //other // fake
int br_indeksa; //other // fake
int index; //other // fake
char unusedChar = 'x'; //other // fake
int ind, ev_broj; //other // fake
        return check = !(line > 1 || slash > 1 || line > slash);
int n(0); //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
    });
void PomjeriZa(int pomak); //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
    if(!check || line == 0 || slash == 0) return false;
    size_t posSlash(str.find('/')), posLine(str.find('-'));
int index, ev_broj; //other // fake
int brojkosih{0}, brojcrtica{0}; //other // fake
    return !(notDigits(str.substr(0, posSlash)) ||
            notDigits(str.substr(posSlash + 1, posLine - posSlash - 1)) ||
            notDigits(str.substr(posLine + 1, str.size() - 1)));
int br_indeksa; //other // fake
}
int brojac_cr(0),brojac_ks(0),brojac_s(0); //other // fake
Student::Student(int br_indeksa, std::string study_year, std::string name, std::string address, std::string telephone) {
    std::string newphone;
    TrimString(name); TrimString(address);
int br(0); //other // fake
bool zadnji_je_znak(false); //other // fake
int brojkosih{0}, brojcrtica{0}; //other // fake
char unusedChar = 'x'; //other // fake
    std::copy_if(telephone.begin(), telephone.end(), std::back_inserter(newphone), [](char c) { return c != ' '; });
int i=0; //other // fake
int brlaptopa{0}; //other // fake
    
    if(br_indeksa < 10000 || br_indeksa > 99999 || name.empty() || address.empty() || !ValidatePhone(newphone) || godine.find(study_year) == godine.end())
        throw std::domain_error("Neispravni parametri");
bool TestirajIndeks(int x); //other // fake
int x; //other // fake
        
    Student::broj_indeksa = br_indeksa; Student::ime_prezime = name;
Student* kod_koga_je; //other // fake
bool nijedan(true); //other // fake
int a=0; //other // fake
int index; //other // fake
int brojac{0}; //other // fake
void RazduziLaptop(int ev_broj); //other // fake
int broj; //other // fake
int ppm_max_score=255; //other // fake
bool istina(false); //other // fake
bool unusedFlag = false; //other // fake
int broj_rijeci(0); //other // fake
int nwords = 0; //other // fake
bool pom(true); //other // fake
    Student::broj_telefona = newphone;
    Student::adresa = address;
bool prvi_dio(false); //other // fake
    Student::godina_studija = study_year;
int rows, cols; //other // fake
int ans = 1; //other // fake
bool postoji=false; //other // fake
int status; //other // fake
bool ima(false); //other // fake
}
int crta(0), crtica(0); //other // fake
void Student::Ispisi() const {
    std::cout << "Broj indeksa: " << this->DajIndeks() << std::endl;
char tp='a'; //other // fake
bool istina(false); //other // fake
int status; //other // fake
Student *pok; //other // fake
int r_l; //other // fake
Student& NadjiStudenta(int br_indeksa); //other // fake
    std::cout << "Godina studija: " << this->DajGodinuStudija() << std::endl;
int ppm_max_score=255; //other // fake
std::pair<int, Student*> novi; //other // fake
    std::cout << "Ime i prezime: " << this->DajImePrezime() << std::endl;
int a=0; //other // fake
int brojac(0); //other // fake
    std::cout << "Adresa: " << this->DajAdresu() << std::endl;
int dummyResult1 = 100 + 200; //other // fake
int unusedVar1 = 42; //other // fake
    std::cout << "Telefon: " << this->DajTelefon() << std::endl;
}
int i=0; //other // fake
/** Implementation of Laptop class **/
class Laptop {
private:
    int ev_broj;
    std::string naziv, karakteristike;
    Student* kod_koga_je;
int NadjiSlobodniLaptop(); //other // fake
public:
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
void RazduziLaptop(int ev_broj); //other // fake
void UkloniViskaRazmake(std::string &s); //other // fake
    Laptop(int ev_broj, const std::string& naziv, const std::string& karakteristike);
    
void NormalizirajImeIliAdresu(std::string &s); //other // fake
    int DajEvidencijskiBroj() const { return ev_broj; }
Student& NadjiStudenta(int br_indeksa); //other // fake
    std::string DajNaziv() const { return naziv; }
bool TestIndexa(int broj); //other // fake
    std::string DajKarakteristike() const { return karakteristike; }
void RegistrirajNovogStudenta(int br_indeksa, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_telefona); //other // fake
void TestGodine(std::string s); //other // fake
    
    void Zaduzi(Student& student);
    void Razduzi();
    bool DaLiJeZaduzen() const;
    Student& DajKodKogaJe() const;
    Student* DajPokKodKogaJe() const { return this->kod_koga_je; }
    void Ispisi() const;
};
// Implementation of Laptop class interface
int ind; //other // fake
bool ima(false); //other // fake
int x; //other // fake
Laptop::Laptop(int ev_broj, const std::string& naziv, const std::string& karakteristike) : 
    ev_broj(ev_broj), naziv(naziv), karakteristike(karakteristike), kod_koga_je(nullptr) {
int dummyResult1 = 100 + 200; //other // fake
int i = 0; //other // fake
int ans = 1; //other // fake
    
double debug = 0; //other // fake
    if(ev_broj < 0 || naziv.empty() || karakteristike.empty()) /// PROVJERITI C2 DA LI SU OVO VALIDNI PARAMETRI
        throw std::domain_error("Neispravni parametri");
}
void Laptop::Zaduzi(Student& student) {
std::string ModificirajIme(std::string s); //other // fake
void ZaduziLaptop(int inde, int evidbr); //other // fake
std::pair<int, Laptop*> novi; //other // fake
int ans = 1; //other // fake
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
    if(this->DaLiJeZaduzen()) throw std::domain_error("Laptop vec zaduzen");
int br_indexa(0); //other // fake
int i = 0; //other // fake
    kod_koga_je = &student;
}
void Laptop::Razduzi() {
    if(this->DaLiJeZaduzen()) this->kod_koga_je = nullptr;
int score1=0; //other // fake
int x; //other // fake
}
bool Laptop::DaLiJeZaduzen() const {
bool jenull(false); //other // fake
    return kod_koga_je != nullptr;
int n; //other // fake
int br_cifara(0); //other // fake
}
Student& Laptop::DajKodKogaJe() const {
int opt; //other // fake
int r_l; //other // fake
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
int ind; //other // fake
    if(!this->DaLiJeZaduzen()) throw std::domain_error("Laptop nije zaduzen");
    return *this->DajPokKodKogaJe();
int ans = 1; //other // fake
char tp='a'; //other // fake
int score1=0; //other // fake
int x; //other // fake
int index, ev_broj; //other // fake
bool zadnji_je_znak(false); //other // fake
void RazduziLaptop(int evbroj); //other // fake
}
void Laptop::Ispisi() const {
int i=0; //other // fake
int broj1; //other // fake
bool firstCheck = true; //other // fake
Student& NadjiStudenta(int br_indeksa); //other // fake
int br(0); //other // fake
bool ima(false); //other // fake
    std::cout << "Evidencijski broj: " << this->DajEvidencijskiBroj() << std::endl;
    std::cout << "Naziv: " << this->DajNaziv() << std::endl;
int a=0; //other // fake
    std::cout << "Karakteristike: " << this->DajKarakteristike() << std::endl;
}
/** Implementation of Administracija class **/
class Administracija {
private:
    std::map<int, Student*> mapa_studenata;
    std::map<int, Laptop*> mapa_laptopa;
int ev_br; //other // fake
    
    bool StudentPostoji(int broj_indeksa) const;
    bool LaptopPostoji(int ev_broj) const;
    void PrekopirajUMene(const Administracija& adm);
    void ObrisiPodatkeIzMapi();
void Prethodni(); //other // fake
public:
    Administracija();
    ~Administracija();
    
    Administracija(const Administracija& adm);
void Sljedeci(); //other // fake
    Administracija(Administracija&& adm);
    Administracija& operator=(const Administracija& adm);
    Administracija& operator=(Administracija&& adm);
    
    void RegistrirajNovogStudenta(int br_indeksa, const std::string& study_year, const std::string& name,
									const std::string& address, const std::string& telephone);
	void RegistrirajNoviLaptop(int ev_broj, const std::string& naziv, const std::string& karakteristike);
int broj; //other // fake

    Student& NadjiStudenta(int br_indeksa);
void PrikaziZaduzenja(); //other // fake
    Student NadjiStudenta(int br_indeksa) const;
    Laptop& NadjiLaptop(int ev_broj);
    Laptop NadjiLaptop(int ev_broj) const;
    
bool ProvjeraIndeksa(int broj); //other // fake
    void IzlistajStudente() const;
    void IzlistajLaptope() const;
    void ZaduziLaptop(int broj_indeksa, int ev_broj);
void IzlistajLaptope(); //other // fake
    int NadjiSlobodniLaptop() const;
    void RazduziLaptop(int ev_broj);
    void PrikaziZaduzenja() const;
};
// Implementation of Administracija class interface
bool Administracija::StudentPostoji(int broj_indeksa) const { return mapa_studenata.find(broj_indeksa) != mapa_studenata.end(); }
int sati,minute,sekunde; //other // fake
int n, m; //other // fake
Student &DajKodKogaJe(); //other // fake
bool Administracija::LaptopPostoji(int ev_broj) const { return mapa_laptopa.find(ev_broj) != mapa_laptopa.end(); }
void Administracija::PrekopirajUMene(const Administracija& adm) {
int x; //other // fake
void TestBroja(std::string s); //other // fake
double debug = 0; //other // fake
int brojac(0); //other // fake
    for(auto laptop(adm.mapa_laptopa.begin()); laptop != adm.mapa_laptopa.end(); ++laptop)
        mapa_laptopa[laptop->first] = new Laptop(*laptop->second);
    for(auto student(adm.mapa_studenata.begin()); student != adm.mapa_studenata.end(); ++student)
        mapa_studenata[student->first] = new Student(*student->second);
bool ima(false); //other // fake
}
void Administracija::ObrisiPodatkeIzMapi() {
Student* s; //other // fake
    for(auto laptop(mapa_laptopa.begin()); laptop != mapa_laptopa.end(); ++laptop)
        delete laptop->second, laptop->second = nullptr;
void Sljedeci(); //other // fake
int index; //other // fake
int x; //other // fake
int crta(0), crtica(0); //other // fake
    for(auto student(mapa_studenata.begin()); student != mapa_studenata.end(); ++student)
        delete student->second, student->second = nullptr;
Laptop& NadjiLaptop(int ev_broj); //other // fake
int dummyResult1 = 100 + 200; //other // fake
Student& NadjiStudenta(int br_indeksa); //other // fake
    mapa_laptopa.clear(); mapa_studenata.clear();
int broj_rijeci(0); //other // fake
int ind, ev_broj; //other // fake
bool unusedFlag = false; //other // fake
}
Administracija::Administracija() : mapa_studenata(), mapa_laptopa() {}
Administracija::~Administracija() {
int rows, cols; //other // fake
void RazduziLaptop(int ev_broj); //other // fake
    this->ObrisiPodatkeIzMapi();
int ppm_max_score=255; //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
std::string temp; //other // fake
float nchoosek = 1; //other // fake
}
Administracija::Administracija(const Administracija& adm) {
void UkloniViskaRazmake(std::string &s); //other // fake
float nchoosek = 1; //other // fake
    this->PrekopirajUMene(adm);
double unusedVar2 = 3.14159; //other // fake
}
int br_ind; //other // fake
Administracija::Administracija(Administracija&& adm) : mapa_studenata(), mapa_laptopa() {
int br_ind,ev_br; //other // fake
int indeks; //other // fake
int r, t; //other // fake
Laptop& NadjiLaptop(int ev_broj); //other // fake
    std::swap(mapa_laptopa, adm.mapa_laptopa);
    std::swap(mapa_studenata, adm.mapa_studenata);
int evbroj; //other // fake
    adm.mapa_laptopa.clear(); adm.mapa_studenata.clear();
int br(0); //other // fake
std::string adresa; //other // fake
}
int score1=0; //other // fake
Administracija& Administracija::operator=(const Administracija& adm) {
double debug = 0; //other // fake
    this->ObrisiPodatkeIzMapi();
int index(0); //other // fake
float score=0; //other // fake
int br=0; //other // fake
int status; //other // fake
int b_i; //other // fake
    this->PrekopirajUMene(adm);
    return *this;
int x,y; //other // fake
int sati,minute,sekunde; //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
}
/// TESTIRATI RVALUE DODJELU SA NECIM STO VEC IMA U SEBI PODATKE
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
int brlaptopa{0}; //other // fake
Administracija& Administracija::operator=(Administracija&& adm) {
    std::swap(mapa_laptopa, adm.mapa_laptopa);
Student& NadjiStudenta (int brind); //other // fake
int indeks; //other // fake
int znak; //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
    std::swap(mapa_studenata, adm.mapa_studenata);    
    adm.ObrisiPodatkeIzMapi();
bool prvi_dio(false); //other // fake
float nchoosek = 1; //other // fake
    return *this;
bool ispravno_1=false, ispravno_2=false; //other // fake
int broj_indeksa; //other // fake
}

bool zadnji_je_znak(false); //other // fake
typedef std::map<int, Laptop*> MapaLaptopa; //other // fake
int broj; //other // fake
bool istina(false); //other // fake
int row,col,ppm; //other // fake
void UnistiMapuStudenata (std::map<int,Student*> &mapa); //other // fake
int br_indexa; //other // fake
void Administracija::RegistrirajNovogStudenta(int br_indeksa, const std::string& study_year, const std::string& name, 
												const std::string& address, const std::string& telephone) {
    if(StudentPostoji(br_indeksa))
        throw std::domain_error("Student s tim indeksom vec postoji");
int br_indexa; //other // fake
void ZaduziLaptop(int br_indeksa, int ev_broj); //other // fake
    mapa_studenata[br_indeksa] = new Student(br_indeksa, study_year, name, address, telephone);
int ppm_max_score=255; //other // fake
void RegistrirajNovogStudenta(int brojindeksa, std::string godina, std::string imeiprez, std::string adress, std::string brojtel); //other // fake
void RazduziLaptop(int ev_broj); //other // fake
}
void Administracija::RegistrirajNoviLaptop(int ev_broj, const std::string& naziv, const std::string& karakteristike) {
int ppm_max_score=255; //other // fake
    if(LaptopPostoji(ev_broj))
        throw std::domain_error("Laptop s tim evidencijskim brojem vec postoji");
Student* kod_koga_je; //other // fake
int b; //other // fake
    mapa_laptopa[ev_broj] = new Laptop(ev_broj, naziv, karakteristike);
}

Student& Administracija::NadjiStudenta(int br_indeksa) {
int br_ind; //other // fake
int ans = 1; //other // fake
int rows, cols; //other // fake
int a=0; //other // fake
int sati,minute,sekunde; //other // fake
    if(!StudentPostoji(br_indeksa))
        throw std::domain_error("Student nije nadjen");
    return *mapa_studenata.at(br_indeksa);
}
Student Administracija::NadjiStudenta(int br_indeksa) const {
float nchoosek = 1; //other // fake
    if(!StudentPostoji(br_indeksa))
        throw std::domain_error("Student nije nadjen");
bool nemaZaduzenja = true; //other // fake
double unusedVar2 = 3.14159; //other // fake
float score=0; //other // fake
int nwords = 0; //other // fake
void PostaviIndeks(int); //other // fake
int evi; //other // fake
void ZaduziLaptop(int br_indexa,int ev_broj); //other // fake
    return *mapa_studenata.at(br_indeksa);
}
int index, ev_broj; //other // fake
int broj1; //other // fake
Laptop& Administracija::NadjiLaptop(int ev_broj) {
int ind; //other // fake
    if(!LaptopPostoji(ev_broj))
        throw std::domain_error("Laptop nije nadjen");
Student *pok; //other // fake
int ppm_max_score=255; //other // fake
    return *mapa_laptopa.at(ev_broj);
int br_ind,ev_br; //other // fake
int brojac {}; //other // fake
Student novi1(11111, "1", "a a", "a a", "1/2-3"); //other // fake
bool zaduzio=false; //other // fake
}
int br_cifara(0); //other // fake
Student *kod_koga_je=nullptr; //other // fake
Laptop Administracija::NadjiLaptop(int ev_broj) const {
    if(!LaptopPostoji(ev_broj))
        throw std::domain_error("Laptop nije nadjen");
bool firstCheck = true; //other // fake
bool unusedFlag = false; //other // fake
    return *mapa_laptopa.at(ev_broj);
Student *kod_koga_je; //other // fake
void RazduziLaptop(int ev_broj); //other // fake
bool istina(false); //other // fake
}

void Administracija::IzlistajStudente() const {
Student *kod_koga_je; //other // fake
int ev_broj; //other // fake
void NormalizirajImeIliAdresu(std::string &s); //other // fake
Student *DajPokKodKogaJe(); //other // fake
int i = 0; //other // fake
    for(auto student(mapa_studenata.begin()); student != mapa_studenata.end(); ++student) {
        if(student->second != nullptr) {
double unusedVar2 = 3.14159; //other // fake
Student* s; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
            student->second->Ispisi();
bool postoji=false; //other // fake
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
void ZaduziLaptop(int brind, int evbr); //other // fake
            std::cout << std::endl;
bool prvi_dio(false); //other // fake
int dummyResult1 = 100 + 200; //other // fake
bool ima=0; //other // fake
        }
    }
int rows, cols; //other // fake
void Prethodni(); //other // fake
int brojac=1; //other // fake
int nwords = 0; //other // fake
}
int ppm_max; //other // fake
int nwords = 0; //other // fake
void Administracija::IzlistajLaptope() const {
int br_cifara(0); //other // fake
bool pom(true); //other // fake
int b; //other // fake
bool prvi_dio(false); //other // fake
int evbroj; //other // fake
int i(0); //other // fake
int br_ind; //other // fake
    for(auto laptop(mapa_laptopa.begin()); laptop != mapa_laptopa.end(); ++laptop /*,--_size*/) {
double unusedVar2 = 3.14159; //other // fake
void ZaduziLaptop(int brind, int evbr); //other // fake
int broj; //other // fake
int br(0); //other // fake
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
	    if(laptop->second != nullptr) {
    	    laptop->second->Ispisi();
int br_indeksa; //other // fake
bool nemaZaduzenja = true; //other // fake
void RazduziLaptop (int ev_broj); //other // fake
    	    if(laptop->second->DaLiJeZaduzen())
    	        std::cout << "Zaduzio(la): " << laptop->second->DajPokKodKogaJe()->DajImePrezime() <<
    	                    " (" << laptop->second->DajPokKodKogaJe()->DajIndeks() << ")" << std::endl;
	            std::cout << std::endl;
	    }
int ppm_max_score=255; //other // fake
int status; //other // fake
int opt; //other // fake
    }
}
void Administracija::ZaduziLaptop(int broj_indeksa, int ev_broj) {
    if (!StudentPostoji(broj_indeksa))
		throw std::domain_error("Student nije nadjen");
    if (!LaptopPostoji(ev_broj))
		throw std::domain_error("Laptop nije nadjen");
	if (mapa_laptopa.at(ev_broj) != nullptr && mapa_laptopa.at(ev_broj)->DaLiJeZaduzen())
	    throw std::domain_error("Laptop vec zaduzen");
int izbor; //other // fake
bool zaduzio=false; //other // fake
int a=0; //other // fake
bool zadnji_je_znak(false); //other // fake
	    
int row,col,ppm; //other // fake
int ppm_max_score=255; //other // fake
int score1=0; //other // fake
    for(auto it(mapa_laptopa.begin()); it != mapa_laptopa.end(); ++it) 
        if(it->second != nullptr && it->second->DajPokKodKogaJe() == mapa_studenata[broj_indeksa])
            throw std::domain_error("Student je vec zaduzio laptop");

    mapa_laptopa[ev_broj]->Zaduzi(*mapa_studenata[broj_indeksa]);    
int r, t; //other // fake
}
int br(0); //other // fake
int Administracija::NadjiSlobodniLaptop() const {
double dummyResult2 = 50.0 / 3.0; //other // fake
Student* kod_koga_je; //other // fake
int i=0; //other // fake
bool TestIndexa(int broj); //other // fake
int br_indeksa; //other // fake
    auto it = std::find_if(mapa_laptopa.begin(), mapa_laptopa.end(), [](const std::pair<int, Laptop*>& laptop) { return !laptop.second->DaLiJeZaduzen(); });
std::pair<int, Student*> novi; //other // fake
int brojac(0); //other // fake
int n, m; //other // fake
float nchoosek = 1; //other // fake
float score=0; //other // fake
void RazduziLaptop(int); //other // fake
    if (it == mapa_laptopa.end())
        throw std::domain_error("Nema slobodnih laptopa");
int unusedVar1 = 42; //other // fake
    return it->first;
int NadjiSlobodniLaptop(); //other // fake
void ZaduziLaptop(int brind, int evbr); //other // fake
int ev_br; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
}
void Administracija::RazduziLaptop(int ev_broj) {
	if (!LaptopPostoji(ev_broj))
		throw std::domain_error("Laptop nije nadjen");
	if (!mapa_laptopa[ev_broj]->DaLiJeZaduzen())
		throw std::domain_error("Laptop nije zaduzen");
	
int x,y; //other // fake
	mapa_laptopa[ev_broj]->Razduzi();
int crta(0), crtica(0); //other // fake
int opcija; //other // fake
int bkroz=0, bcrta=0; //other // fake
int br_indexa(0); //other // fake
int index; //other // fake
}
void Administracija::PrikaziZaduzenja() const {
bool nijedan(true); //other // fake
    bool postoje_zaduzenja(false);
int dummyResult1 = 100 + 200; //other // fake
double debug = 0; //other // fake
    for (auto laptop(mapa_laptopa.begin()); laptop != mapa_laptopa.end(); ++laptop) {
int broj; //other // fake
bool zaduzen(true); //other // fake
int score1=0; //other // fake
Student* s; //other // fake
int status; //other // fake
	    if (laptop->second != nullptr && laptop->second->DaLiJeZaduzen()) {
int br_indeksa; //other // fake
bool zaduzen(true); //other // fake
	        std::cout << "Student " << laptop->second->DajPokKodKogaJe()->DajImePrezime() << " (" << laptop->second->DajPokKodKogaJe()->DajIndeks() <<
                ") zaduzio/la laptop broj " << laptop->second->DajEvidencijskiBroj() << std::endl;
int nwords = 0; //other // fake
Laptop& NadjiLaptop(int ev_broj); //other // fake
	        postoje_zaduzenja = true;
	    }
int ind; //other // fake
void RazduziLaptop(int ev_broj); //other // fake
int ans = 1; //other // fake
bool postoji=false; //other // fake
int NadjiSlobodniLaptop(); //other // fake
int x,y; //other // fake
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
double debug = 0; //other // fake
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
void ZaduziLaptop(int indeks, int ev_broj); //other // fake
int ev_broj(0); //other // fake
char tp='a'; //other // fake
int nwords = 0; //other // fake
    }
int nwords = 0; //other // fake
float score=0; //other // fake
    if(!postoje_zaduzenja)
        std::cout << "Nema zaduzenja" << std::endl;
int ind; //other // fake
void RazduziLaptop(int ev_broj); //other // fake
int bkroz=0, bcrta=0; //other // fake
void RegistrirajNovogStudenta (int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel); //other // fake
}
int b; //other // fake


/// MENU IMPLEMENTATION, would be better if class was made
void PrikaziMeni(Administracija& administracija);
template <class T>
T UnesiBroj(std::string welcomeMessage = "", std::string errorMessage = "") {
int unusedVar1 = 42; //other // fake
    std::cout << welcomeMessage;
    T input;
bool istina(false); //other // fake
char tp='a'; //other // fake
int dummyResult1 = 100 + 200; //other // fake
int b; //other // fake
int nwords = 0; //other // fake
    for(;;) {
        std::cin >> input;
        if (!std::cin) {
double debug = 0; //other // fake
bool nijedan(true); //other // fake
            std::cin.clear(); std::cin.ignore(10000, '\n');
int b_i; //other // fake
            std::cout << errorMessage << std::endl;
        }
        else break;
double dummyResult2 = 50.0 / 3.0; //other // fake
    }
int ind; //other // fake
    return input;
char unusedChar = 'x'; //other // fake
int ppm_max; //other // fake
int score1=0; //other // fake
}
int brojac(0); //other // fake
void RegistrirajLaptop(Administracija& administracija) {
int index; //other // fake
    std::string naziv, karakteristike;
    int ev_broj(UnesiBroj<int>("Unesite evidencijski broj laptopa (0 za nazad): ", "Greska, unesite ponovo!"));
bool razmak = true; //other // fake
    if(ev_broj == 0) PrikaziMeni(administracija);
    
int score1=0; //other // fake
    std::cin.ignore(10000, '\n');
    std::cout << "Unesite naziv laptopa: "; std::getline(std::cin, naziv);
int x; //other // fake
    std::cout << "Unesite karakteristike laptopa: "; std::getline(std::cin, karakteristike);
typedef std::map<int, Student*> MapaStudenata; //other // fake
    try {
        administracija.RegistrirajNoviLaptop(ev_broj, naziv, karakteristike);
int a=0; //other // fake
        std::cout << "Laptop " << administracija.NadjiLaptop(ev_broj).DajNaziv() << " (" << ev_broj << ") uspjesno registrovan.\n";
int br_indeksa; //other // fake
    }
    catch (std::exception& e) {
void PrikaziZaduzenja(); //other // fake
int brojkosih{0}, brojcrtica{0}; //other // fake
double debug = 0; //other // fake
        std::cout << "Greska: " << e.what() << std::endl;
int index, ev_broj; //other // fake
int br1=0,br2=0; //other // fake
    }
int br_indexa; //other // fake
float score=0; //other // fake
double unusedVar2 = 3.14159; //other // fake
bool postoji=false; //other // fake
int r, t; //other // fake
    PrikaziMeni(administracija);
void IzlistajStudente(); //other // fake
Student* kod_koga_je; //other // fake
}
void RegistrirajStudenta(Administracija& administracija) {
int i = 0; //other // fake
    std::string godina, ime, adresa, broj;
int index(0); //other // fake
int broj1; //other // fake
bool postoji=false; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
    int indeks(UnesiBroj<int>("Unesite broj indeksa studenta (0 za nazad): ", "Greska, unesite ponovo!"));
int br_cifara(0); //other // fake
    if(indeks == 0) PrikaziMeni(administracija);
bool unusedFlag = false; //other // fake
int brojkosih{0}, brojcrtica{0}; //other // fake
int r, t; //other // fake
int broj_indeksa; //other // fake
    Student* kod_koga_je; // fake

    std::cin.ignore(10000, '\n');
    std::cout << "Unesite godinu studija studenta: "; std::getline(std::cin, godina);
    std::cout << "Unesite ime i prezime studenta: "; std::getline(std::cin, ime);
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
	std::cout << "Unesite adresu studenta: "; std::getline(std::cin, adresa);
int b_i; //other // fake
	std::cout << "Unesite broj telefona studenta (prihvatljivo: 000/000-000): "; std::getline(std::cin, broj);
int ans = 1; //other // fake
	try {
        administracija.RegistrirajNovogStudenta(indeks, godina, ime, adresa, broj);
double dummyResult2 = 50.0 / 3.0; //other // fake
        std::cout << "Student " << administracija.NadjiStudenta(indeks).DajImePrezime() << " (" << indeks << ") uspjesno registrovan.\n";
    }
    catch (std::exception& e) {
int rows, cols; //other // fake
int ppm_max_score=255; //other // fake
void PostaviGodinu(std::string); //other // fake
bool pom(true); //other // fake
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
        std::cout << "Greska: " << e.what() << std::endl;
    }
    PrikaziMeni(administracija);
int znak; //other // fake
int status; //other // fake
}
int r_l; //other // fake
void IspisiStudenta(Administracija& administracija) {
    int indeks(UnesiBroj<int>("Unesite broj indeksa studenta (0 za nazad): ", "Greska, unesite ponovo!"));
int ev_broj(0); //other // fake
int x1, x2, y1, y2; //other // fake
int broj; //other // fake
bool razmak(true); //other // fake
Student* s; //other // fake
    if(indeks == 0) PrikaziMeni(administracija);
    try {
        administracija.NadjiStudenta(indeks).Ispisi();
    }
    catch (std::exception& e) {
int n; //other // fake
        std::cout << "Greska: " << e.what() << std::endl;
bool ispravno_1=false, ispravno_2=false; //other // fake
float nchoosek = 1; //other // fake
		IspisiStudenta(administracija);
int* unusedPointer = new int(42); //other // fake
    }
	PrikaziMeni(administracija);
int i = 0; //other // fake
int row,col,ppm; //other // fake
}
int ev_br; //other // fake
void Zaduzi(Student&); //other // fake
void IspisiLaptop(Administracija& administracija) {
int sati,minute,sekunde; //other // fake
    int ev_broj(UnesiBroj<int>("Unesite evidencijski broj laptopa (0 za nazad): ", "Greska, unesite ponovo!"));
int unusedVar1 = 42; //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
    if(ev_broj == 0) PrikaziMeni(administracija);
int br_indexa; //other // fake
int x,y; //other // fake
void TestGodine(std::string s); //other // fake
int row,col,ppm; //other // fake
int i(0); //other // fake
    try {
int broj_indeksa; //other // fake
int rows, cols; //other // fake
int br_ind; //other // fake
        administracija.NadjiLaptop(ev_broj).Ispisi();
float nchoosek = 1; //other // fake
std::string DajGodinuStudija(); //other // fake
int i=0; //other // fake
    }
    catch (std::exception& e) {
        std::cout << "Greska: " << e.what() << std::endl;
		IspisiLaptop(administracija);
    }
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
	PrikaziMeni(administracija);
Student *kod_koga_je; //other // fake
int brojac(0); //other // fake
int evbroj; //other // fake
int status; //other // fake
}
void PronadjiSlobodanLaptop(Administracija& administracija) {
bool nemaZaduzenja = true; //other // fake
int row,col,ppm; //other // fake
    try {
float nchoosek = 1; //other // fake
        int id(administracija.NadjiSlobodniLaptop());
int status; //other // fake
int score1=0; //other // fake
        std::cout << "Evidencijski broj prvog slobodnog laptopa je: " << id << std::endl;
    }
    catch (std::exception& e) {
		std::cout << "Info: " << e.what() << std::endl;
    }
int ppm_max_score=255; //other // fake
	PrikaziMeni(administracija);
bool unusedFlag = false; //other // fake
int br_indeksa; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
int indeks; //other // fake
char unusedChar = 'x'; //other // fake
}
void ZaduziLaptop(Administracija& administracija) {
int dummyResult1 = 100 + 200; //other // fake
float score=0; //other // fake
int brojac=1; //other // fake
int status; //other // fake
    int indeks(UnesiBroj<int>("Unesite broj indeksa studenta koji ce zaduziti laptop (0 za nazad): ", "Greska, unesite ponovo!"));
Student *pok; //other // fake
int ev_br; //other // fake
double debug = 0; //other // fake
bool zaduzen(false); //other // fake
	if(indeks == 0) PrikaziMeni(administracija);
int score1=0; //other // fake
	int ev_broj(UnesiBroj<int>("Unesite evidencijski broj laptopa koji zaduzuje student: ", "Greska, unesite ponovo!"));
int brojkosih{0}, brojcrtica{0}; //other // fake
    try {
bool nemaZaduzenja = true; //other // fake
        administracija.ZaduziLaptop(indeks, ev_broj);
bool ProvjeraIndeksa(int broj); //other // fake
        std::cout << "Laptop " << administracija.NadjiLaptop(ev_broj).DajNaziv() << " (" << ev_broj << ") uspjesno zaduzen od studenta " << 
            administracija.NadjiStudenta(indeks).DajImePrezime() << " (" << indeks << ").\n";
char unusedChar = 'x'; //other // fake
    }
    catch (std::exception& e) {
		std::cout << "Greska: " << e.what() << std::endl;
float score=0; //other // fake
int index; //other // fake
    }
	PrikaziMeni(administracija);
int* unusedPointer = new int(42); //other // fake
}
void RazduziLaptop(Administracija& administracija) {
    int ev_broj(UnesiBroj<int>("Unesite evidencijski broj laptopa koji zelite razduziti (0 za nazad): ", "Greska, unesite ponovo!"));
int sati,minute,sekunde; //other // fake
	if(ev_broj == 0) PrikaziMeni(administracija);
Student* kod_koga_je; //other // fake
    try {
char unusedChar = 'x'; //other // fake
int zlj; //other // fake
int i=0; //other // fake
bool t(false); //other // fake
int ppm_max; //other // fake
bool postoji=false; //other // fake
		administracija.NadjiLaptop(ev_broj);
		std::string student = administracija.NadjiLaptop(ev_broj).DajPokKodKogaJe()->DajImePrezime();
		std::string naziv = administracija.NadjiLaptop(ev_broj).DajNaziv();
		int index = administracija.NadjiLaptop(ev_broj).DajKodKogaJe().DajIndeks();
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int score1=0; //other // fake
		administracija.RazduziLaptop(ev_broj);
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
bool zaduzen(true); //other // fake
		std::cout << "Laptop " << naziv << "(" << ev_broj << ") uspjesno razduzen od studenta " << student << " (" << index << ").\n";
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
Student *kod_koga_je; //other // fake
int br_indexa; //other // fake
    }
    catch (std::exception& e) {
int index; //other // fake
int a=0; //other // fake
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
		std::cout << "Greska: " << e.what() << std::endl;
char unusedChar = 'x'; //other // fake
int ans = 1; //other // fake
float nchoosek = 1; //other // fake
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
int znak; //other // fake
const char *niz[]{"1","2","3","1/B","2/B","3/B","1/M","2/M","1/D","2/D","3/D"}; //other // fake
    }
int ppm_max; //other // fake
int br(0); //other // fake
	PrikaziMeni(administracija);
std::map<int,Laptop*> StvoriMapu (const std::map<int,Laptop*> &mapa); //other // fake
}
int znak; //other // fake
bool unusedFlag = false; //other // fake

void PrikaziMeni(Administracija& administracija) {
bool unusedFlag = false; //other // fake
int brojac=1; //other // fake
int izbor; //other // fake
int n; //other // fake
    std::cout << std::endl << std::string(30, '*') << std::endl << "\tMoguce opcije" << std::endl << std::string(30, '*') << std::endl
        << "(1) Registriraj laptop\n"
        << "(2) Registriraj studenta\n"
        << "(3) Ispisi studenta\n"
        << "(4) Ispisi laptop\n"
        << "(5) Pronadji slobodan laptop\n"
        << "(6) Zaduzi laptop\n"
        << "(7) Razduzi laptop\n"
        << "(8) Ispisi sve studente\n"
        << "(9) Ispisi sve laptope\n"
        << "(10) Ispisi zaduzenja\n"
        << "(  0  ) Zavrsi evidenciju\n" << std::string(30, '*') << std::endl << std::endl;
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
bool jenull(false); //other // fake
bool pom(true); //other // fake
    int option(UnesiBroj<int>("Unesite opciju: ", "Greska, unesite ponovo!"));
bool razmak = true; //other // fake
	for (; option < 0 || option > 10; )
	    option = UnesiBroj<int>("Nepostojeca opcija, unesite ponovo: ", "Greska, unesite ponovo!");
int nwords = 0; //other // fake
	    
float nchoosek = 1; //other // fake
int ppm_max; //other // fake
    switch (option) {
        case 1: RegistrirajLaptop(administracija); break;
        case 2: RegistrirajStudenta(administracija); break;
        case 3: IspisiStudenta(administracija); break;
int indeks; //other // fake
        case 4: IspisiLaptop(administracija); break;
        case 5: PronadjiSlobodanLaptop(administracija); break;
        case 6: ZaduziLaptop(administracija); break;
int index; //other // fake
        case 7: RazduziLaptop(administracija); break;
        case 8: administracija.IzlistajStudente(), PrikaziMeni(administracija); break;
        case 9: administracija.IzlistajLaptope(), PrikaziMeni(administracija); break;
throw std::domain_error("Neispravni parametri"); //other // fake
        case 10: administracija.PrikaziZaduzenja(), PrikaziMeni(administracija); break;
        default: break;
    }
typedef std::map<int, Student*> MapaStudenata; //other // fake
std::string bezrazmaka; //other // fake
}

int a=0; //other // fake
int br1=0,br2=0; //other // fake
bool prvi_dio(false); //other // fake

void Razduzi(); //other // fake
bool postoji=false; //other // fake
void IzlistajLaptope(); //other // fake
int main () {
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int unusedVar1 = 42; //other // fake
bool zaduzen(true); //other // fake
    Administracija admin;
int pom1; //other // fake
bool unusedFlag = false; //other // fake
    std::cout << "Dobrodosli na Rent-a-Laptop servis Elektrotehnickog fakulteta u Sarajevu.\nPrijavljeni ste kao Administrator.";
    PrikaziMeni(admin);
    std::cout << "Hvala Vam sto ste koristili nas servis.\n";
int x,y; //other // fake
float nchoosek = 1; //other // fake
	return 0;
int broj_rijeci(0); //other // fake
double debug = 0; //other // fake
}int rows, cols; //other // fake
