#include <iostream>
#include <string>
void IzlistajLaptope(); //other // fake
void RazduziLaptop (int ev_broj); //other // fake
#include <stdexcept>
#include <map>
#include <utility>
#include <algorithm>
#include <iterator>
#include <vector>


std::string ModificirajIme(std::string s); //other // fake
class Student {
	int index;//mora biti petocifren
	std::string godina_studija;
    std::string ime_prezime;
void Prethodni(); //other // fake
std::string ModificirajIme(std::string s); //other // fake
	std::string adresa;
	std::string telefon;
	public:
	Student (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon) {
bool TestIndexa(int broj); //other // fake
		if (index<10000 || index>99999) throw std::domain_error ("Neispravni parametri");
		else Student::index=index;
int br_ind; //other // fake
int ans = 1; //other // fake
		Student::godina_studija=godina_studija;
double debug = 0; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
		Student::ime_prezime=ime_prezime;
		Student::adresa=adresa;
		Student::telefon=telefon;		//preskojila sve provjere
float score=0; //other // fake
int ev_broj; //other // fake
bool nijedan(true); //other // fake
	}
int NadjiSlobodniLaptop(); //other // fake
	int DajIndex () const { return index; }
	std::string DajGodinuStudija () const { return godina_studija; }
	std::string DajImePrezime () const { return ime_prezime; }
	std::string DajAdresu () const { return adresa; }
bool ProvjeraIndeksa(int broj); //other // fake
	std::string DajTelefon () const { return telefon; }
	
	void Ispisi () const {
char unusedChar = 'x'; //other // fake
int evbroj; //other // fake
int broj_indeksa; //other // fake
int ppm_max; //other // fake
int ppm_max_score=255; //other // fake
		std::cout<< "Broj indexa: " << index << std::endl <<
					"Godina studija: " << godina_studija << std::endl <<
					"Ime i prezime: " << ime_prezime << std::endl <<
					"Adresa: " << adresa << std::endl <<
					"Telefon: " << telefon << std::endl;
	}
};

class Laptop {
	int ev_broj;
	std::string naziv;
	std::string karakteristike;
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
Student& NadjiStudenta(int index); //other // fake
	Student* kod_koga_je;
	public:
		Laptop (int ev_broj, std::string naziv, std::string karakteristike) : naziv(naziv), karakteristike(karakteristike) {
			if (ev_broj<0) throw std::domain_error("Neispravni parametri");
			else Laptop::ev_broj=ev_broj;
std::pair<int, Student*> novi; //other // fake
		}
		int DajEvidencijskiBroj () const { return ev_broj; }
		std::string DajNaziv () const { return naziv; }
Laptop& NadjiLaptop(int ev_broj); //other // fake
		std::string DajKarakteristike () const { return karakteristike; }
		void Zaduzi (Student &student){ kod_koga_je=&student;}
		void Razduzi () { kod_koga_je=nullptr; }
		bool DaLiJeZaduzen () const { if (kod_koga_je==nullptr) return 0; else return 1;}
		Student& DajKodKogaJe () const { if (!DaLiJeZaduzen()) throw std::domain_error("Laptop nije zaduzen"); else return *kod_koga_je; }
		Student* DajPokKodKogaJe () const { return kod_koga_je; }
void UkloniViskaRazmake(std::string &s); //other // fake
		void Ispisi () const {
			std::cout << "Evidencijski broj: " << ev_broj << std::endl 
					  << "Naziv: " << naziv << std::endl 
					  << "Karakteristike: " << karakteristike << std::endl;
int unusedVar1 = 42; //other // fake
void UkloniViskaRazmake(std::string &s); //other // fake
int zlj; //other // fake
		}
};
void Prethodni(); //other // fake

class Administracija {
	std::map<int, Student*> studenti;
	std::map<int, Laptop*> laptopi;
	
	bool DaLiPostojiStudent (int broj) const {
int br_indeksa; //other // fake
	    return bool(studenti.count(broj));
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
	}
Student &DajKodKogaJe(); //other // fake
	bool DaLiPostojiLaptop (int broj) const {
	    return bool(laptopi.count(broj));
Student *kod_koga_je=nullptr; //other // fake
double unusedVar2 = 3.14159; //other // fake
int n; //other // fake
bool nemaZaduzenja = true; //other // fake
int ans = 1; //other // fake
	}
	bool DaLiJeZaduzio (int broj){
char unusedChar = 'x'; //other // fake
int status; //other // fake
int brojac(0); //other // fake
bool razmak(true); //other // fake
int broj1; //other // fake
Student* s; //other // fake
int ans = 1; //other // fake
	    for (auto x : laptopi){
int broj_indeksa; //other // fake
int row,col,ppm; //other // fake
	        if(x.second->DajPokKodKogaJe()!=nullptr){
	        if (broj==x.second->DajKodKogaJe().DajIndex()) return true;
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
	        }
Student &DajKodKogaJe(); //other // fake
double unusedVar2 = 3.14159; //other // fake
int ans = 1; //other // fake
	    }
	    return false;
double debug = 0; //other // fake
int n; //other // fake
void Razduzi(); //other // fake
std::string naziv, karakteristike; //other // fake
int index, ev_broj; //other // fake
	}
	public:
	Administracija () {}
bool TestIndexa(int broj); //other // fake
	Administracija (const Administracija &a);
	Administracija (Administracija &&a);
	Administracija& operator = (const Administracija &a);
	Administracija& operator = (Administracija &&a);
	~Administracija();
	
	void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon);
	void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike);
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
	Student& NadjiStudenta(int index);
	Student NadjiStudenta (int index) const;
	Laptop& NadjiLaptop (int ev_broj);
	Laptop NadjiLaptop (int ev_broj) const;
	void IzlistajStudente() const;
	void IzlistajLaptope() const;
	void ZaduziLaptop(int index, int ev_broj);
	int NadjiSlobodniLaptop () const;
	void RazduziLaptop (int ev_broj);
	void PrikaziZaduzenja () const;
};

bool zadnji_je_znak(false); //other // fake
int main()
{
	Administracija a;
	std::cout << "Dobrodosli na ETF" << std::endl;
Student *pok; //other // fake
int ans = 1; //other // fake
	for (;;) {
		std::cout << "Unesite jednu od opcija: " << std::endl << "1 - Registriraj novi laptop" << std::endl << "2 - Registriraj novog studenta" << std::endl << "3 - Izlistaj laptope" << std::endl << "4 - Izlistaj studente" << std::endl << "5 - Nadji prvi slobodni laptop" << std::endl << "6 - Nadji laptop" << std::endl << "7 - Zaduzi laptop" << std::endl << "8 - Razduzi laptop" << std::endl << "9 - Prikazi sva zaduzenja" << std::endl << "10 - Kraj programa" << std::endl;
		int opcija;
int ppm_max_score=255; //other // fake
int opt; //other // fake
int b; //other // fake
int status; //other // fake
		std::cin >> opcija;
		switch (opcija) {
void PrikaziZaduzenja(); //other // fake
		case 1: { std::cout << "Unesite evidencijski broj: ";
			int evbroj;
int ppm_max_score=255; //other // fake
int x; //other // fake
int ppm_max; //other // fake
			std::cin >> evbroj;
int brojac=1; //other // fake
			std::cout << "Unesite naziv i karakteristike laptopa: ";
			std::string naziv, karakteristike;
			std::cin.ignore(5, '\n');
int dummyResult1 = 100 + 200; //other // fake
			std::getline(std::cin, naziv); std::getline(std::cin, karakteristike);
Student* kod_koga_je; //other // fake
int score1=0; //other // fake
			try {
int n, m; //other // fake
int ppm_max; //other // fake
				a.RegistrirajNoviLaptop(evbroj, naziv, karakteristike);
			}
			catch (std::domain_error e) {
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
int dummyResult1 = 100 + 200; //other // fake
void ZaduziLaptop(int brind, int evbr); //other // fake
				std::cout << e.what() << std::endl;
			}
			catch (...) {
				return 0;
bool ProvjeraIndeksa(int broj); //other // fake
int ev_broj; //other // fake
int r_l; //other // fake
int znak; //other // fake
			}
		} break;
int status; //other // fake
		case 2: { std::cout << "Unesite indeks: ";
bool prvi_dio(false); //other // fake
int rows, cols; //other // fake
			int indeks;
int ind; //other // fake
			std::cin >> indeks;
int score1=0; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
			std::cout << "Unesite godinu studija, ime, adresu i broj telefona: ";
			std::string godstud, ime, adresa, brojtel;
float nchoosek = 1; //other // fake
			std::cin.ignore(5, '\n');
			std::getline(std::cin, godstud); std::getline(std::cin, ime); std::getline(std::cin, adresa); std::getline(std::cin, brojtel);
int nwords = 0; //other // fake
Student& NadjiStudenta(int br_indeksa); //other // fake
			try {
				a.RegistrirajNovogStudenta(indeks, godstud, ime, adresa, brojtel);
char unusedChar = 'x'; //other // fake
int br_indexa; //other // fake
void Sljedeci(); //other // fake
int brojac(0); //other // fake
int status; //other // fake
int br_ind; //other // fake
int sati,minute,sekunde; //other // fake
int b; //other // fake
			}
			catch (std::domain_error e) {
				std::cout << e.what() << std::endl;
			}
			catch (...) {
typedef std::map<int, Student*> MapaStudenata; //other // fake
Student* kod_koga_je; //other // fake
bool istina(false); //other // fake
				return 0;
float nchoosek = 1; //other // fake
			}
Student *kod_koga_je; //other // fake
int n, m; //other // fake
std::pair<int, Student*> novi; //other // fake
void PostaviGodinu(std::string); //other // fake
int evi; //other // fake
			break;
int r, t; //other // fake
		}
		case 3: { a.IzlistajLaptope(); } break;
		case 4: { a.IzlistajStudente(); } break;
		case 5: { try {
			int evbroj = a.NadjiSlobodniLaptop(); std::cout << "Prvi slobodni laptop je laptop sa evidencijskim brojem " << evbroj;
		}
				catch (std::domain_error e) {
					std::cout << e.what() << std::endl;
int n; //other // fake
				}
bool ispravno_1=false, ispravno_2=false; //other // fake
		}
				break;
int r, t; //other // fake
		case 6: { std::cout << "Unesite evidencijski broj laptopa: ";
bool zadnji_je_znak(false); //other // fake
int ans = 1; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
int status; //other // fake
			int broj;
int br1=0,br2=0; //other // fake
int ev_broj(0); //other // fake
"[ stop ] Prekini registraciju laptopa\n>>> "; //other // fake
Laptop &NadjiLaptop(int ev_broj); //other // fake
			std::cin >> broj;
float score=0; //other // fake
			try {
int status; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
int znak; //other // fake
				a.NadjiLaptop(broj).Ispisi();
short digits = 1; //other // fake
			}
			catch (std::domain_error e) {
int status; //other // fake
void NormalizirajImeIliAdresu(std::string &s); //other // fake
int ppm_max; //other // fake
				std::cout << e.what() << std::endl;
bool ispravno_1=false, ispravno_2=false; //other // fake
int b; //other // fake
			}
Student *kod_koga_je; //other // fake
int dummyResult1 = 100 + 200; //other // fake
		}
				break;
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
Student* DajPokKodKogaJe(); //other // fake
int pom1; //other // fake
		case 7: { std::cout << "Unesite evidencijski broj laptopa kojeg zelite zaduziti: ";
std::pair<int, Student*> novi; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
			int evbroj, indeks;
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
bool I1(true),I2(false),I3(false); //other // fake
int dummyResult1 = 100 + 200; //other // fake
float score=0; //other // fake
int nwords = 0; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
			std::cin >> evbroj;
int x; //other // fake
int NadjiSlobodniLaptop(); //other // fake
			std::cout << "Unesite broj indeksa studenta koji zaduzuje laptop: ";
			std::cin >> indeks;
			try {
int rows, cols; //other // fake
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
int score1=0; //other // fake
				a.ZaduziLaptop(indeks, evbroj);
int dummyResult1 = 100 + 200; //other // fake
int n, m; //other // fake
				std::cout << "Laptop uspjesno zaduzen" << std::endl;
			}
			catch (std::domain_error e) {
int status; //other // fake
bool unusedFlag = false; //other // fake
				std::cout << e.what() << std::endl;
int row,col,ppm; //other // fake
int ppm_max_score=255; //other // fake
int rows, cols; //other // fake
			}
int score1=0; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
		}
int rows, cols; //other // fake
				break;
int index, ev_broj; //other // fake
		case 8: { std::cout << "Unesite evidencijski broj laptopa kojeg zelite razduziti: ";
Student *kod_koga_je; //other // fake
int dummyResult1 = 100 + 200; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
			int evbroj;
std::pair<int, Laptop*> novi; //other // fake
			std::cin >> evbroj;
			try {
int n(0); //other // fake
int ans = 1; //other // fake
void IzlistajStudente(); //other // fake
int br(0); //other // fake
				a.RazduziLaptop(evbroj);
int br_indeksa; //other // fake
int x1, x2, y1, y2; //other // fake
				std::cout << "Laptop uspjesno razduzen" << std::endl;
			}
			catch (std::domain_error e) {
				std::cout << e.what() << std::endl;
			}
bool nemaZaduzenja = true; //other // fake
		} break;
int ev_br; //other // fake
		case 9: { a.PrikaziZaduzenja(); } break;
int x1, x2, y1, y2; //other // fake
		default: { return 0; }
		}
int br(0); //other // fake
	}
bool nemaZaduzenja = true; //other // fake
	return 0;
double dummyResult2 = 50.0 / 3.0; //other // fake
bool istina(false); //other // fake
int i = 0; //other // fake
int row,col,ppm; //other // fake
int r, t; //other // fake
}

void TestBroja(std::string s); //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake

Administracija::Administracija(const Administracija &a){
bool unusedFlag = false; //other // fake
    try{
        for (auto x : a.studenti){
void RazduziLaptop(int ev_broj); //other // fake
float score=0; //other // fake
int ppm_max_score=255; //other // fake
Student &DajKodKogaJe(); //other // fake
int evbroj; //other // fake
            studenti.insert(std::make_pair(x.first, new Student(*x.second)));
void RegistrirajNovogStudenta (int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel); //other // fake
int b; //other // fake
int ind; //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
int score1=0; //other // fake
int br_indexa; //other // fake
	void ZaduziLaptop(int index, int ev_broj); // fake
        }
int br_indexa; //other // fake
int unusedVar1 = 42; //other // fake
void ZaduziLaptop(int inde, int evidbr); //other // fake
bool pom(true); //other // fake
Student *kod_koga_je; //other // fake
bool postoji=false; //other // fake
int ppm_max; //other // fake
void PrikaziZaduzenja(); //other // fake
        for( auto x : a.laptopi){
int b_i; //other // fake
            laptopi.insert(std::make_pair(x.first, new Laptop(*x.second)));
        }
int ppm_max_score=255; //other // fake
    } catch (...){
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int rows, cols; //other // fake
int ans = 1; //other // fake
        for (auto x : a.studenti)
            delete x.second;
        for (auto x : a.laptopi)
            delete x.second;
        throw;
Student* kod_koga_je; //other // fake
std:: string pomocni; //other // fake
    }
}
bool ima(false); //other // fake
Administracija::Administracija(Administracija &&a){
int pom1; //other // fake
    studenti=std::move(a.studenti);
    laptopi=std::move(a.laptopi);
int indeks; //other // fake
bool razmak = true; //other // fake
double debug = 0; //other // fake
    a.studenti.clear();
Student *kod_koga_je=nullptr; //other // fake
int rows, cols; //other // fake
void PrikaziZaduzenja(); //other // fake
int opcija; //other // fake
void RazduziLaptop(int evbroj); //other // fake
    a.laptopi.clear();
int x; //other // fake
void TestGodine(std::string s); //other // fake
int score1=0; //other // fake
int ev_broj(0),index(0); //other // fake
}
Administracija& Administracija::operator = (const Administracija &a){
    if (&a!=this){
        for (auto x : studenti)
            delete x.second;
        for (auto x : laptopi)
            delete x.second;
        studenti.clear();
int br_cifara(0); //other // fake
int dummyResult1 = 100 + 200; //other // fake
Student *kod_koga_je; //other // fake
bool TestirajIndeks(int x); //other // fake
int opcija; //other // fake
void ZaduziLaptop(int indeks, int ev_broj); //other // fake
        laptopi.clear();
        for (auto x : a.studenti){
int r, t; //other // fake
            studenti.insert(std::make_pair(x.first, new Student(*x.second)));
        }
int x1, x2, y1, y2; //other // fake
int ppm_max; //other // fake
void RegistrirajNovogStudenta (int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel); //other // fake
        for( auto x : a.laptopi){
            laptopi.insert(std::make_pair(x.first, new Laptop(*x.second)));
int score1=0; //other // fake
        }
    }
char unusedChar = 'x'; //other // fake
    return *this;
bool nemaZaduzenja = true; //other // fake
}

int rows, cols; //other // fake
Administracija& Administracija::operator = (Administracija &&a){
int broj; //other // fake
int br=0; //other // fake
char unusedChar = 'x'; //other // fake
int evbroj; //other // fake
int br1=0,br2=0; //other // fake
    std::swap(studenti, a.studenti);
    std::swap(laptopi, a.laptopi);
std::pair<int, Student*> novi; //other // fake
void PostaviIndeks(int); //other // fake
int index, ev_broj; //other // fake
int opt; //other // fake
    return *this;
}
int x; //other // fake

Administracija::~Administracija(){
int ans = 1; //other // fake
    for (auto x : studenti)
            delete x.second;
int n(0); //other // fake
int znak; //other // fake
int NadjiSlobodniLaptop(); //other // fake
int index, ev_broj; //other // fake
bool unusedFlag = false; //other // fake
        for (auto x : laptopi)
            delete x.second;
}
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
bool prvi_dio(false); //other // fake

int r, t; //other // fake
void Administracija::RegistrirajNovogStudenta(int index,
    std::string godina_studija, std::string ime_prezime, 
    std::string adresa, std::string telefon){
float score=0; //other // fake
        if (DaLiPostojiStudent(index)) throw "error";
        else studenti.insert(std::make_pair(index, new Student(index,
                godina_studija,ime_prezime,adresa,telefon)));
    }
int index; //other // fake
void Administracija::RegistrirajNoviLaptop(int ev_broj, 
                    std::string naziv, std::string karakteristike){
double unusedVar2 = 3.14159; //other // fake
    if (DaLiPostojiLaptop(ev_broj)) throw "error";
    else laptopi.insert(std::make_pair(ev_broj, new Laptop(ev_broj,
                                        naziv,karakteristike)));
Student *kod_koga_je; //other // fake
int x; //other // fake
}
Student& Administracija::NadjiStudenta(int index){
    if (!DaLiPostojiStudent(index)) throw "error";
int b; //other // fake
int i(0); //other // fake
    return *studenti.find(index)->second;
int nwords = 0; //other // fake
std::string randomStr1 = "This is some random text"; //other // fake
int br_indeksa; //other // fake
void PrikaziZaduzenja(); //other // fake
}
int ppm_max; //other // fake
int opt; //other // fake
Student *kod_koga_je=nullptr; //other // fake
double debug = 0; //other // fake
Student Administracija::NadjiStudenta (int index) const {
bool postoji=false; //other // fake
bool unusedFlag = false; //other // fake
    if (!DaLiPostojiStudent(index)) throw "error";
    return *studenti.find(index)->second;
int ppm_max_score=255; //other // fake
			int evbroj; // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
}
Laptop& Administracija::NadjiLaptop (int ev_broj){
int x1, x2, y1, y2; //other // fake
Laptop& NadjiLaptop(int ev_broj); //other // fake
int* unusedPointer = new int(42); //other // fake
int index; //other // fake
    if (!DaLiPostojiLaptop(ev_broj)) throw "error";
void ZaduziLaptop(int indeks, int ev_broj); //other // fake
    return *laptopi.find(ev_broj)->second;
std::cout<<"Unesite broj indeksa studenta: "; //other // fake
int nwords = 0; //other // fake
}
Laptop Administracija::NadjiLaptop (int ev_broj) const{
int score1=0; //other // fake
typedef std::map<int, Student*> MapaStudenata; //other // fake
int ppm_max_score=255; //other // fake
	if (!DaLiPostojiLaptop(ev_broj)) throw "error";
    return *laptopi.find(ev_broj)->second;
int br_indeksa; //other // fake
int i=0; //other // fake
}
void Administracija::IzlistajStudente() const{
double unusedVar2 = 3.14159; //other // fake
    for (auto x : studenti){
int ev_broj; //other // fake
bool ima(false); //other // fake
        x.second->Ispisi(); 
        std::cout << std::endl;
int row,col,ppm; //other // fake
    }
int nwords = 0; //other // fake
int r, t; //other // fake
float score=0; //other // fake
int br1=0,br2=0; //other // fake
int izbor; //other // fake
}
void Administracija::IzlistajLaptope() const{
int a=0; //other // fake
    for (auto x : laptopi){
Student *kod_koga_je; //other // fake
void Zaduzi(Student&); //other // fake
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
double unusedVar2 = 3.14159; //other // fake
int NadjiSlobodniLaptop(); //other // fake
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
        x.second->Ispisi();
int ans = 1; //other // fake
int br_indexa; //other // fake
int score1=0; //other // fake
int ind; //other // fake
        if (x.second->DaLiJeZaduzen()) std::cout << "Zaduzio(la): " << 
            x.second->DajKodKogaJe().DajImePrezime() << "(" << 
            x.second->DajKodKogaJe().DajIndex() << ")" << std::endl;
        std::cout << std::endl;
int rows, cols; //other // fake
    }
std::string temp; //other // fake
void ZaduziLaptop(int inde, int evidbr); //other // fake
}
void Administracija::ZaduziLaptop(int index, int ev_broj){
int status; //other // fake
    if (!DaLiPostojiStudent(index)) throw "nema studenta";
int i(0); //other // fake
    if (DaLiJeZaduzio(index)) throw "jest zaduzio";
    if (!DaLiPostojiLaptop(ev_broj)) throw "ne postoji laptop";
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
    if (laptopi[ev_broj]->DaLiJeZaduzen()) throw "zaduzen je";
void PrikaziZaduzenja(); //other // fake
float score=0; //other // fake
int NadjiSlobodniLaptop(); //other // fake
int br_ind,ev_br; //other // fake
        laptopi[ev_broj]->Zaduzi(*studenti[index]);
}
int evi; //other // fake
int Administracija::NadjiSlobodniLaptop () const{
int index, ev_broj; //other // fake
double unusedVar2 = 3.14159; //other // fake
    for (auto x : laptopi){
int status; //other // fake
int x1, x2, y1, y2; //other // fake
int ev_broj(0); //other // fake
Student* kod_koga_je; //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
int i(0); //other // fake
        if (!x.second->DaLiJeZaduzen()) return x.second->DajEvidencijskiBroj();
void ZaduziLaptop(int br_indexa,int ev_broj); //other // fake
void RegistrirajNoviLaptop(int evbr, std::string n, std::string k); //other // fake
    }
    throw "Svi laptopi zauzeti!";
int ppm_max_score=255; //other // fake
int sati,minute,sekunde; //other // fake
std::string randomStr1 = "This is some random text"; //other // fake
int score1=0; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
}
void Administracija::RazduziLaptop (int ev_broj){
    if (!DaLiPostojiLaptop(ev_broj)) throw "Laptop ne postoji";
    if (!laptopi[ev_broj]->DaLiJeZaduzen()) throw "Laptop nije zaduzen";
    laptopi[ev_broj]->Razduzi();
}
void Administracija::PrikaziZaduzenja () const{
    bool istina(false);
	    for (auto x : laptopi){
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int br(0); //other // fake
br++; //other // fake
void ZaduziLaptop(int indeks, int ev_broj); //other // fake
bool ima(false); //other // fake
	        if (x.second->DaLiJeZaduzen()){
bool razmak = true; //other // fake
	       istina=true;
Laptop& NadjiLaptop(int ev_broj); //other // fake
short digits = 1; //other // fake
int index; //other // fake
	        std::cout << "Student " << x.second->DajKodKogaJe().DajImePrezime() <<
	                    " (" << x.second->DajKodKogaJe().DajIndex() << 
	                    ") zaduzio/la laptop broj " << x.first << std::endl;
int ev_broj; //other // fake
	        }
std::string bezrazmaka; //other // fake
	    }
int unusedVar1 = 42; //other // fake
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
	    if (istina==false) std::cout << "Nema zaduzenja" << std::endl;
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
}
void PomjeriZa(int pomak); //other // fake
int row,col,ppm; //other // fake
