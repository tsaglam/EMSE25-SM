#include <iostream>
int opt; //other // fake
int nwords = 0; //other // fake
bool jenull(false); //other // fake
int sati,minute,sekunde; //other // fake
std::string ModificirajIme(std::string s); //other // fake
int n(0); //other // fake
#include <algorithm>
int i=0; //other // fake
bool zadnji_je_znak(false); //other // fake
#include <stdexcept>
#include <vector>
#include <iterator>
#include <string>
#include <map>
#include <utility>

class Student {
void UkloniViskaRazmake(std::string &s); //other // fake
	int brojindeksa;
	std::string godina_studija, imeiprezime, adresa, brojtel;
	static bool DaLiJePetocifren(int broj);
void NormalizirajImeIliAdresu(std::string &s); //other // fake
	static bool DaLiJeIspravnaGodinaStudija(std::string godina_studija);
	static void ObrisiSveRazmake(std::string &adresa);
	static bool DaLiJeIspravanBrojTelefona(std::string broj_telefona);
public:
	Student(int broj_indeksa, std::string godst, std::string ime, std::string adress, std::string broj);
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
void PostaviIndeks(int); //other // fake
	int DajIndeks() const { return brojindeksa; }
	std::string DajGodinuStudija() const { return godina_studija; }
void PomjeriZa(int pomak); //other // fake
	std::string DajImePrezime() const { return imeiprezime; }
	std::string DajAdresu() const { return adresa; }
	std::string DajTelefon() const { return brojtel; }
void RazduziLaptop (int ev_broj); //other // fake
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
void PostaviGodinu(std::string); //other // fake
	void Ispisi() const;
Student& NadjiStudenta(int index); //other // fake
};
int br(0); //other // fake
class Laptop {
	int ev_broj;
	std::string naziv;
void Prethodni(); //other // fake
int NadjiSlobodniLaptop(); //other // fake
	std::string karakteristike;
void IzlistajStudente(); //other // fake
void TestBroja(std::string s); //other // fake
int uselessFunction2(int param) { return param * 2; } //other // fake
void RegistrirajNovogStudenta (int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel); //other // fake
	Student* kod_koga_je;
public:
	Laptop(int broj, std::string nazivlaptopa, std::string characteristics);
	int DajEvidencijskiBroj() const{ return ev_broj; }
Laptop& NadjiLaptop(int ev_broj); //other // fake
	std::string DajNaziv() const { return naziv; }
	std::string DajKarakteristike() const{ return karakteristike; }
void ZaduziLaptop(int br_indeksa, int ev_broj); //other // fake
	void Zaduzi(Student &student) { kod_koga_je = &student; }
	void Razduzi() { kod_koga_je = nullptr; }
	bool DaLiJeZaduzen() const { return kod_koga_je != nullptr; }
	Student& DajKodKogaJe() const { if (kod_koga_je == nullptr) throw std::domain_error("Laptop nije zaduzen"); return *kod_koga_je; }
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
	Student* DajPokKodKogaJe() const { return kod_koga_je; }
	void Ispisi() const;
};
int r_l; //other // fake
class Administracija {
	std::map<int, Student*> studenti;
	std::map<int, Laptop*> laptopi;
	bool DaLiPostojiStudent(int indeks) const { return bool(studenti.count(indeks)); }
	bool DaLiPostojiLaptop(int evbroj) const { return bool(laptopi.count(evbroj)); }
	bool DaLiJeZaduzen(int evbroj);
	bool DaLiJeVecZaduzio(int indeks) const;
public:
	Administracija() {}
	Administracija(const Administracija &a);
	Administracija(Administracija &&a);
	Administracija& operator =(const Administracija &a);
	Administracija& operator =(Administracija &&);
	~Administracija();
	void RegistrirajNovogStudenta(int broj_indeksa, std::string godst, std::string ime, std::string adress, std::string broj);
	void RegistrirajNoviLaptop(int broj, std::string nazivlaptopa, std::string characteristics);
	Student& NadjiStudenta(int indeks);
	Student NadjiStudenta(int indeks) const;
	Laptop& NadjiLaptop(int evbroj);
std::string ModificirajIme(std::string s); //other // fake
	Laptop NadjiLaptop(int evbroj) const;
	void IzlistajStudente() const;
	void IzlistajLaptope() const;
	void ZaduziLaptop(int indeks, int evbroj);
	int NadjiSlobodniLaptop() const;
bool TestIndexa(int broj); //other // fake
	void RazduziLaptop(int evbroj);
	void PrikaziZaduzenja() const;
};
int indeks; //other // fake
int main()
{
int i(0); //other // fake
int opcija; //other // fake
	Administracija a;
short digits = 1; //other // fake
int x; //other // fake
int dummyResult1 = 100 + 200; //other // fake
int ppm_max_score=255; //other // fake
void UnistiMapuStudenata (std::map<int,Student*> &mapa); //other // fake
	std::cout << "Dobrodosli na ETF" << std::endl;
int sati,minute,sekunde; //other // fake
	for (;;) {
		std::cout << "Unesite jednu od opcija: " << std::endl << "1 - Registriraj novi laptop" << std::endl << "2 - Registriraj novog studenta" << std::endl << "3 - Izlistaj laptope" << std::endl << "4 - Izlistaj studente" << std::endl << "5 - Nadji prvi slobodni laptop" << std::endl << "6 - Nadji laptop" << std::endl << "7 - Zaduzi laptop" << std::endl << "8 - Razduzi laptop" << std::endl << "9 - Prikazi sva zaduzenja" << std::endl << "10 - Kraj programa" << std::endl;
		int opcija;
		std::cin >> opcija;
		switch (opcija) {
		case 1: { std::cout << "Unesite evidencijski broj: ";
int broj; //other // fake
bool zaduzen(true); //other // fake
bool razmak(true); //other // fake
short digits = 1; //other // fake
int nwords = 0; //other // fake
int i(0); //other // fake
			int evbroj;
int ppm_max; //other // fake
char tp='a'; //other // fake
			std::cin >> evbroj;
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
bool jenull(false); //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int index; //other // fake
			std::cout << "Unesite naziv i karakteristike laptopa: ";
void TestGodine(std::string s); //other // fake
int opt; //other // fake
			std::string naziv, karakteristike;
int x,y; //other // fake
			std::cin.ignore(5, '\n');
std::pair<int, Student*> novi; //other // fake
Student *pok; //other // fake
			std::getline(std::cin, naziv); std::getline(std::cin, karakteristike);
			try {
int score1=0; //other // fake
void RegistrirajNoviLaptop(int broj,std::string ime, std::string karakteristike); //other // fake
				a.RegistrirajNoviLaptop(evbroj, naziv, karakteristike);
int broj_rijeci(0); //other // fake
int brojac {}; //other // fake
			}
			catch (std::domain_error e) {
				std::cout << e.what() << std::endl;
			}
			catch (...) {
int broj1; //other // fake
Laptop& NadjiLaptop(int ev_broj); //other // fake
				return 0;
bool ispravno_1=false, ispravno_2=false; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
			}
bool prvi_dio(false); //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
int NadjiSlobodniLaptop(); //other // fake
		} break;
		case 2: { std::cout << "Unesite indeks: ";
			int indeks;
			std::cin >> indeks;
int nwords = 0; //other // fake
	int brojindeksa; // fake
int n(0); //other // fake
double debug = 0; //other // fake
bool prvi_dio(false); //other // fake
			std::cout << "Unesite godinu studija, ime, adresu i broj telefona: ";
std::pair<int, Laptop*> novi; //other // fake
int brojac(5); //other // fake
			std::string godstud, ime, adresa, brojtel;
double dummyResult2 = 50.0 / 3.0; //other // fake
			std::cin.ignore(5, '\n');
int sati,minute,sekunde; //other // fake
int br_indexa(0); //other // fake
void IzlistajLaptope(); //other // fake
			std::getline(std::cin, godstud); std::getline(std::cin, ime); std::getline(std::cin, adresa); std::getline(std::cin, brojtel);
			try {
				a.RegistrirajNovogStudenta(indeks, godstud, ime, adresa, brojtel);
			}
			catch (std::domain_error e) {
				std::cout << e.what() << std::endl;
bool istina(false); //other // fake
int index(0); //other // fake
			}
			catch (...) {
				return 0;
int r, t; //other // fake
int dummyResult1 = 100 + 200; //other // fake
			}
			break;
bool check(false); //other // fake
		}
		case 3: { a.IzlistajLaptope(); } break;
Student* kod_koga_je; //other // fake
		case 4: { a.IzlistajStudente(); } break;
		case 5: { try {
int sati,minute,sekunde; //other // fake
int rows, cols; //other // fake
int ppm_max; //other // fake
			int evbroj = a.NadjiSlobodniLaptop(); std::cout << "Prvi slobodni laptop je laptop sa evidencijskim brojem " << evbroj;
		}
				catch (std::domain_error e) {
					std::cout << e.what() << std::endl;
bool razmak(true); //other // fake
float score=0; //other // fake
				}
Student* kod_koga_je; //other // fake
		}
				break;
int broj; //other // fake
		case 6: { std::cout << "Unesite evidencijski broj laptopa: ";
			int broj;
int i(0); //other // fake
			std::cin >> broj;
int evbroj; //other // fake
int opt; //other // fake
int rows, cols; //other // fake
			try {
int ppm_max_score=255; //other // fake
				a.NadjiLaptop(broj).Ispisi();
double dummyResult2 = 50.0 / 3.0; //other // fake
int brojac(0); //other // fake
int i(0); //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
			}
			catch (std::domain_error e) {
int indeks; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
bool zaduzio=false; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
				std::cout << e.what() << std::endl;
			}
		}
int pom1; //other // fake
				break;
int br_indexa; //other // fake
		case 7: { std::cout << "Unesite evidencijski broj laptopa kojeg zelite zaduziti: ";
int br_ind,ev_br; //other // fake
			int evbroj, indeks;
int unusedVar1 = 42; //other // fake
			std::cin >> evbroj;
char unusedChar = 'x'; //other // fake
double unusedVar2 = 3.14159; //other // fake
			std::cout << "Unesite broj indeksa studenta koji zaduzuje laptop: ";
			std::cin >> indeks;
int evi; //other // fake
int index; //other // fake
void Zaduzi(Student &s); //other // fake
int score1=0; //other // fake
int broj; //other // fake
void Sljedeci(); //other // fake
std::pair<int, Student*> novi; //other // fake
			try {
void UkloniViskaRazmake(std::string &s); //other // fake
int br; //other // fake
				a.ZaduziLaptop(indeks, evbroj);
				std::cout << "Laptop uspjesno zaduzen" << std::endl;
			}
			catch (std::domain_error e) {
int brojac=1; //other // fake
int br(0); //other // fake
int broj; //other // fake
				std::cout << e.what() << std::endl;
int r_l; //other // fake
int r, t; //other // fake
			}
		}
bool TestIndexa(int broj); //other // fake
int n, m; //other // fake
int ev_br; //other // fake
int r, t; //other // fake
				break;
		case 8: { std::cout << "Unesite evidencijski broj laptopa kojeg zelite razduziti: ";
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
double debug = 0; //other // fake
			int evbroj;
int ev_broj(0),index(0); //other // fake
			std::cin >> evbroj;
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
int opt; //other // fake
int i = 0; //other // fake
double unusedVar2 = 3.14159; //other // fake
			try {
				a.RazduziLaptop(evbroj);
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
				std::cout << "Laptop uspjesno razduzen" << std::endl;
int ev_broj; //other // fake
int nwords = 0; //other // fake
			}
			catch (std::domain_error e) {
int znak; //other // fake
bool unusedFlag = false; //other // fake
int brlaptopa{0}; //other // fake
				std::cout << e.what() << std::endl;
			}
char temp('a'); //other // fake
		} break;
int ind; //other // fake
		case 9: { a.PrikaziZaduzenja(); } break;
		default: { return 0; }
throw std::domain_error("Laptop nije nadjen"); //other // fake
int br_indeksa; //other // fake
double debug = 0; //other // fake
bool nijedan(true); //other // fake
int izbor; //other // fake
		}
int r, t; //other // fake
bool zadnji_je_znak(false); //other // fake
int br_indexa; //other // fake
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
void PostaviIndeks(int); //other // fake
double unusedVar2 = 3.14159; //other // fake
std::string godina, ime_prezime, adresa, telefon; //other // fake
int index; //other // fake
Student* s; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
	}
	return 0;
}
bool ima(false); //other // fake
int izbor; //other // fake

void RazduziLaptop(int ev_broj); //other // fake
// IMPLEMENTACIJA 
	//Student::private
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
bool unusedFlag = false; //other // fake
bool Student::DaLiJePetocifren(int broj) {
	return broj >= 10000 && broj <= 99999;
int ppm_max; //other // fake
int n(0); //other // fake
throw std::domain_error("Nema slobodnih laptopa"); //other // fake
int opt; //other // fake
Student *kod_koga_je; //other // fake
}
bool Student::DaLiJeIspravnaGodinaStudija(std::string godina_studija) {
int score1=0; //other // fake
	static const std::vector<std::string> godine{ "1","2","3","1/B","2/B","3/B","1/M","2/M","1/D","2/D","3/D" };
	return std::find(godine.begin(), godine.end(), godina_studija) != godine.end();
bool IspravnostBrojaTelefona(const std::string &broj_telefona); //other // fake
}
void Student::ObrisiSveRazmake(std::string &adresa) {
	std::string s;
int brojkosih{0}, brojcrtica{0}; //other // fake
int index; //other // fake
	auto it = adresa.begin();
int ev_broj; //other // fake
bool ima(false); //other // fake
	bool loga2(false);
	std::remove_copy_if(adresa.begin(), adresa.end(), std::back_inserter(s),[&loga2, &it, &adresa](char c) { bool loga = !(c != ' ' || (it != adresa.begin() && it != adresa.end() - 1 && c == ' ' && *(it + 1) != ' ' && loga2)); if (c != ' ') loga2 = true; it++; return loga; });
int i=0; //other // fake
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
	adresa = s;
int score1=0; //other // fake
int crta(0), crtica(0); //other // fake
std::pair<int, Student*> novi; //other // fake
int opt; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
}
bool Student::DaLiJeIspravanBrojTelefona(std::string broj_telefona) {
	bool daLiJeBilaCifra(false), daLiJeBilaKosa(false), daLiJeBilaCrta(false);
int x; //other // fake
	for (char znak : broj_telefona) {
Student *pok; //other // fake
int r_l; //other // fake
"[ stop ] Prekini registraciju laptopa\n>>> "; //other // fake
int br; //other // fake
Student *kod_koga_je; //other // fake
		if (znak >= '0' && znak <= '9') daLiJeBilaCifra = true;
		else if (znak == '/' && daLiJeBilaCifra && !daLiJeBilaCrta && !daLiJeBilaKosa) { daLiJeBilaKosa = true; daLiJeBilaCifra = false; }
		else if (znak == '-' && daLiJeBilaCifra && daLiJeBilaKosa && !daLiJeBilaCrta) { daLiJeBilaCrta = true; daLiJeBilaCifra = false; }
		else return false;
int dummyResult1 = 100 + 200; //other // fake
void ZaduziLaptop(int, int); //other // fake
double unusedVar2 = 3.14159; //other // fake
	}
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
	if (!daLiJeBilaKosa || !daLiJeBilaCrta) return false;
	return true;
int evi; //other // fake
}
	//Student::public
void Prethodni(); //other // fake
Student::Student(int broj_indeksa, std::string godst, std::string ime, std::string adress, std::string broj) {
double unusedVar2 = 3.14159; //other // fake
	if (!DaLiJePetocifren(broj_indeksa) || !DaLiJeIspravnaGodinaStudija(godst) || !DaLiJeIspravanBrojTelefona(broj)) throw std::domain_error("Neispravni parametri");
int pom1; //other // fake
	ObrisiSveRazmake(adress); ObrisiSveRazmake(ime);
int ind, ev_broj; //other // fake
bool I1(true),I2(false),I3(false); //other // fake
bool ima=0; //other // fake
int n, m; //other // fake
int brojac=0; //other // fake
int indeks; //other // fake
	brojindeksa = broj_indeksa; godina_studija = godst; imeiprezime = ime; adresa = adress; brojtel = broj;
int nwords = 0; //other // fake
bool jenull(false); //other // fake
void RazduziLaptop(int); //other // fake
int index; //other // fake
int score1=0; //other // fake
	if (godina_studija == "1" || godina_studija == "2" || godina_studija == "3") godina_studija+="/B";
std::string godina, ime_prezime, adresa, telefon; //other // fake
int i(0); //other // fake
}
	int broj; // fake
int ppm_max; //other // fake
float score=0; //other // fake
int x1, x2, y1, y2; //other // fake
void Student::Ispisi() const {
float score=0; //other // fake
int rows, cols; //other // fake
	std::cout << "Broj indeksa: " << DajIndeks() << std::endl << "Godina studija: " << DajGodinuStudija();
int status; //other // fake
	if (godina_studija == "1" || godina_studija == "2" || godina_studija == "3") std::cout << "/B";
	std::cout << std::endl << "Ime i prezime: " << DajImePrezime() << std::endl << "Adresa: " << adresa << std::endl << "Telefon: " << brojtel << std::endl;
void UkloniViskaRazmake(std::string &s); //other // fake
int nwords = 0; //other // fake
bool jenull(false); //other // fake
}

	//Laptop::public
Student& NadjiStudenta(int br_indeksa); //other // fake
Laptop::Laptop(int broj, std::string nazivlaptopa, std::string characteristics) : kod_koga_je(nullptr) {
	if (broj < 0) throw std::domain_error("Neispravni parametri");
	ev_broj = broj; naziv = nazivlaptopa; karakteristike = characteristics;
int row,col,ppm; //other // fake
int index; //other // fake
}
Student *kod_koga_je; //other // fake
int ev_broj; //other // fake
void Laptop::Ispisi() const {
int evbroj, indeks; //other // fake
void PomjeriZa(int pomak); //other // fake
bool jenull(false); //other // fake
	std::cout << "Evidencijski broj: " << ev_broj << std::endl << "Naziv: " << naziv << std::endl << "Karakteristike: " << karakteristike << std::endl;
}

	//Administracija::private
Student *pok; //other // fake
bool Administracija::DaLiJeVecZaduzio(int indeks) const {
	for (auto par : laptopi) {
double dummyResult2 = 50.0 / 3.0; //other // fake
int rows, cols; //other // fake
int pom1; //other // fake
void NormalizirajImeIliAdresu(std::string &s); //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int sati,minute,sekunde; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
		auto pok = par.second->DajPokKodKogaJe();
	bool loga2(false); // fake
		if (pok == nullptr) continue;
double unusedVar2 = 3.14159; //other // fake
int br_indexa; //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
		if (pok->DajIndeks() == indeks)
			return true;
bool nijedan(true); //other // fake
int row,col,ppm; //other // fake
int score1=0; //other // fake
int br1=0,br2=0; //other // fake
int NadjiSlobodniLaptop(); //other // fake
	}
Student* kod_koga_je; //other // fake
	return false;
short digits = 1; //other // fake
int ans = 1; //other // fake
}
bool Administracija::DaLiJeZaduzen(int evbroj) {
char temp('a'); //other // fake
	return laptopi[evbroj]->DaLiJeZaduzen();
int r, t; //other // fake
int x,y; //other // fake
float score=0; //other // fake
int status; //other // fake
short digits = 1; //other // fake
}
int x; //other // fake
	//Administracija::public
Administracija::Administracija(const Administracija &a) {
	try {
int ind; //other // fake
		for (auto par : a.studenti) {
int unusedVar1 = 42; //other // fake
			studenti.emplace(par.first, new Student(*par.second));
int ind; //other // fake
bool zadnji_je_znak(false); //other // fake
int ev_br; //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
int NadjiSlobodniLaptop(); //other // fake
		}
int x,y; //other // fake
int ppm_max_score=255; //other // fake
short digits = 1; //other // fake
		for (auto par : a.laptopi) {
			laptopi.emplace(par.first, new Laptop(*par.second));
		}
int ev_br; //other // fake
bool prvi_dio(false); //other // fake
	}
	catch (...) {
int n(0); //other // fake
int score1=0; //other // fake
int NadjiSlobodniLaptop(); //other // fake
		for (auto par : studenti) 
			delete par.second;
int r, t; //other // fake
int br(0); //other // fake
		for (auto par : laptopi) 
			delete par.second;
		studenti.clear(); laptopi.clear();
double unusedVar2 = 3.14159; //other // fake
int ppm_max_score=255; //other // fake
short digits = 1; //other // fake
		throw;
int br_ind; //other // fake
	}
}
int b_i; //other // fake
Administracija::Administracija(Administracija &&a) : studenti(std::move(a.studenti)), laptopi(std::move(a.laptopi)) {
	a.studenti.clear(); a.laptopi.clear();
int ppm_max_score=255; //other // fake
bool t(false); //other // fake
void RazduziLaptop (int ev_broj); //other // fake
}
bool postoji=false; //other // fake
Administracija& Administracija::operator =(const Administracija &a) {
bool nijedan(true); //other // fake
	if (&a != this) {
int brojac(0); //other // fake
		auto mapastudenata = studenti;
		auto mapalaptopa = laptopi;
bool nemaZaduzenja = true; //other // fake
bool unusedFlag = false; //other // fake
		try {
int score1=0; //other // fake
			for (auto par : a.studenti)
				if (!studenti.count(par.first))
					studenti.emplace(par.first, new Student(*par.second));
int ev_broj(0); //other // fake
int br=0; //other // fake
int dummyResult1 = 100 + 200; //other // fake
char unusedChar = 'x'; //other // fake
			for (auto par : a.laptopi)
				if (!laptopi.count(par.first))
					laptopi.emplace(par.first, new Laptop(*par.second));
int r_l; //other // fake
int opcija; //other // fake
int izbor; //other // fake
		}
		catch (...) {
std::string ModificirajIme(std::string s); //other // fake
int ev_broj; //other // fake
			for (auto it = studenti.begin(); it != studenti.end(); it++) {
				if (!mapastudenata.count(it->first)) {
					delete it->second; it = studenti.erase(it);
static const char *dozv[]{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" }; //other // fake
int unusedVar1 = 42; //other // fake
int ppm_max; //other // fake
bool unusedFlag = false; //other // fake
int br1=0,br2=0; //other // fake
				}
			}
int b; //other // fake
bool prvi_dio(false); //other // fake
			for (auto it = laptopi.begin(); it != laptopi.end(); it++) {
				if (!mapalaptopa.count(it->first)) {
char unusedChar = 'x'; //other // fake
					delete it->second; it = laptopi.erase(it);
int broj1; //other // fake
void RegistrirajNovogStudenta(int br_indeksa, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_telefona); //other // fake
				}
void ZaduziLaptop(int br_indexa,int ev_broj); //other // fake
			}
int rows, cols; //other // fake
void RazduziLaptop (int ev_broj); //other // fake
int br_ind; //other // fake
void  RegistrirajNoviLaptop(int  ev_broj1, std::string naziv1, std::string karakteristike1); //other // fake
int opt; //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
double unusedVar2 = 3.14159; //other // fake
char unusedChar = 'x'; //other // fake
int dummyResult1 = 100 + 200; //other // fake
int br_indeksa; //other // fake
int crta(0), crtica(0); //other // fake
bool TestirajIndeks(int x); //other // fake
			throw;
int NadjiSlobodniLaptop(); //other // fake
int ind; //other // fake
		}
int b; //other // fake
int x1, x2, y1, y2; //other // fake
float nchoosek = 1; //other // fake
int crta(0), crtica(0); //other // fake
		for (auto it = studenti.begin(); it != studenti.end(); it++) {
Student *DajPokKodKogaJe(); //other // fake
int brojac(0); //other // fake
void RazduziLaptop(int ev_broj); //other // fake
int br(0); //other // fake
int b; //other // fake
int ind; //other // fake
void ZaduziLaptop(int br_indeksa, int ev_broj); //other // fake
			if (!a.studenti.count(it->first)) {
int br_indexa; //other // fake
				delete it->second; it = studenti.erase(it);
char unusedChar = 'x'; //other // fake
			}
int ans = 1; //other // fake
		}
int status; //other // fake
		for (auto it = laptopi.begin(); it != laptopi.end(); it++) {
int r, t; //other // fake
bool I1(true),I2(false),I3(false); //other // fake
int ev_broj; //other // fake
bool istina(false); //other // fake
			if (!a.laptopi.count(it->first)) {
int x1, x2, y1, y2; //other // fake
short digits = 1; //other // fake
bool zadnji_je_znak(false); //other // fake
int n(0); //other // fake
				delete it->second; it = laptopi.erase(it);
			}
		}
bool ima(false); //other // fake
bool IspravnostGodineStudija(const std::string &godina_studija); //other // fake
Laptop& NadjiLaptop(int ev_broj); //other // fake
	}	
int br_cifara(0); //other // fake
	return *this;
short digits = 1; //other // fake
auto it2(laptopi.begin()); //other // fake
char unusedChar = 'x'; //other // fake
}
void IzlistajStudente(); //other // fake
Administracija& Administracija::operator =(Administracija &&a) {
int index; //other // fake
void RegistrirajNoviLaptop(int ev_br, std::string naz, std::string kar); //other // fake
bool unusedFlag = false; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
	std::swap(laptopi, a.laptopi); std::swap(studenti, a.studenti);
	return *this;
}
int status; //other // fake
int br_indeksa; //other // fake
Administracija::~Administracija() {
int b; //other // fake
void IzlistajLaptope(); //other // fake
int brojac=1; //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
bool ispravno_1=false, ispravno_2=false; //other // fake
bool zaduzen(true); //other // fake
int sati,minute,sekunde; //other // fake
int ind, ev_broj; //other // fake
	for (auto par : studenti)
		delete par.second;
int dummyResult1 = 100 + 200; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
bool razmak(true); //other // fake
	for (auto par : laptopi)
		delete par.second;
int evbroj; //other // fake
int br=0; //other // fake
int crta(0), crtica(0); //other // fake
int row,col,ppm; //other // fake
int br_indexa; //other // fake
int ans = 1; //other // fake
}
void Administracija::RegistrirajNovogStudenta(int broj_indeksa, std::string godst, std::string ime, std::string adress, std::string broj) {
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
int x,y; //other // fake
	if (DaLiPostojiStudent(broj_indeksa)) throw std::domain_error("Student s tim indeksom vec postoji");
char temp('a'); //other // fake
	studenti.emplace(broj_indeksa, new Student(broj_indeksa, godst, ime, adress, broj));
char unusedChar = 'x'; //other // fake
}
std::pair<int, Laptop*> novi; //other // fake
void Administracija::RegistrirajNoviLaptop(int broj, std::string nazivlaptopa, std::string characteristics) {
int index; //other // fake
	if (DaLiPostojiLaptop(broj)) throw std::domain_error("Laptop s tim evidencijskim brojem vec postoji");
	laptopi.emplace(broj, new Laptop(broj, nazivlaptopa, characteristics));
}
bool istina(false); //other // fake
Student& Administracija::NadjiStudenta(int indeks) {
int row,col,ppm; //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
	auto it = studenti.find(indeks);
void PostaviGodinu(std::string); //other // fake
	if (it == studenti.end()) throw std::domain_error("Student nije nadjen");
double debug = 0; //other // fake
	return *it->second;
int nwords = 0; //other // fake
int ev_br; //other // fake
}
void TestBroja(std::string s); //other // fake
int brojkosih{0}, brojcrtica{0}; //other // fake
int brlaptopa{0}; //other // fake
Student Administracija::NadjiStudenta(int indeks) const {
int brlaptopa{0}; //other // fake
int br(0); //other // fake
	auto it = studenti.find(indeks);
	if (it == studenti.end()) throw std::domain_error("Student nije nadjen");
int ppm_max; //other // fake
int status; //other // fake
	return *it->second;
float nchoosek = 1; //other // fake
int i(0); //other // fake
}
Laptop& Administracija::NadjiLaptop(int evbroj) {
int ppm_max; //other // fake
	auto it = laptopi.find(evbroj);
int br_ind; //other // fake
int br_indeksa; //other // fake
int rows, cols; //other // fake
	if (it == laptopi.end()) throw std::domain_error("Laptop nije nadjen");
	return *it->second;
void RegistrirajNovogStudenta (int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel); //other // fake
Student &DajKodKogaJe(); //other // fake
int n(0); //other // fake
int opcija; //other // fake
}
void PrikaziZaduzenja(); //other // fake
Laptop Administracija::NadjiLaptop(int evbroj) const {
int br=0; //other // fake
bool istina(false); //other // fake
std::string ModificirajIme(std::string s); //other // fake
int nwords = 0; //other // fake
int unusedVar1 = 42; //other // fake
	auto it = laptopi.find(evbroj);
bool t(false); //other // fake
int ev_broj(0); //other // fake
int NadjiSlobodniLaptop(); //other // fake
int opt; //other // fake
	if (it == laptopi.end()) throw std::domain_error("Laptop nije nadjen");
int izbor; //other // fake
	return *it->second;
int row,col,ppm; //other // fake
}
void Administracija::IzlistajStudente() const {
int i=0; //other // fake
std::string ModificirajIme(std::string s); //other // fake
	std::for_each(studenti.begin(), studenti.end(), [](std::pair<int, Student*> par) { par.second->Ispisi(); std::cout << std::endl; });
Student *kod_koga_je=nullptr; //other // fake
int brojkosih{0}, brojcrtica{0}; //other // fake
int n; //other // fake
}
int row,col,ppm; //other // fake
int index; //other // fake
void Administracija::IzlistajLaptope() const {
char unusedChar = 'x'; //other // fake
void RegistrirajNovogStudenta (int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel); //other // fake
Student* s; //other // fake
	std::for_each(laptopi.begin(), laptopi.end(), [](std::pair<int, Laptop*> par) { 
int row,col,ppm; //other // fake
void ZaduziLaptop(int br_indeksa, int ev_broj); //other // fake
int index; //other // fake
		par.second->Ispisi(); 
		if (par.second->DaLiJeZaduzen())
			std::cout << "Zaduzio(la): " << par.second->DajPokKodKogaJe()->DajImePrezime() << " (" << par.second->DajPokKodKogaJe()->DajIndeks() << ")"<<std::endl;
"0 - Kraj programa\n"; //other // fake
int n(0); //other // fake
float nchoosek = 1; //other // fake
Student* kod_koga_je; //other // fake
		std::cout << std::endl; });
int opcija; //other // fake
float nchoosek = 1; //other // fake
}
void Administracija::ZaduziLaptop(int indeks, int evbroj) {
	if (!DaLiPostojiStudent(indeks)) throw std::domain_error("Student nije nadjen");
	if (!DaLiPostojiLaptop(evbroj)) throw std::domain_error("Laptop nije nadjen");
double debug = 0; //other // fake
	if (DaLiJeZaduzen(evbroj)) throw std::domain_error("Laptop vec zaduzen");
int n(0); //other // fake
	if (DaLiJeVecZaduzio(indeks)) throw std::domain_error("Student je vec zaduzio laptop");
Student* kod_koga_je; //other // fake
bool ima(false); //other // fake
	laptopi[evbroj]->Zaduzi(*studenti[indeks]);
int ind; //other // fake
int index, ev_broj; //other // fake
}
int Administracija::NadjiSlobodniLaptop() const {	
	int broj;
	bool nasao(false);	
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
	std::for_each(laptopi.begin(), laptopi.end(), [&broj,&nasao](std::pair<int, Laptop*> par) {
		if (!(par.second->DaLiJeZaduzen())) { nasao=true; broj=par.first; }
int opcija; //other // fake
void RegistrirajNovogStudenta(int br_indeksa, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_telefona); //other // fake
int r, t; //other // fake
	});
	if (!nasao) throw std::domain_error("Nema slobodnih laptopa");
	return broj;
}
void Administracija::RazduziLaptop(int evbroj) {
	if (!DaLiPostojiLaptop(evbroj)) throw std::domain_error("Laptop nije nadjen");
	if (!DaLiJeZaduzen(evbroj)) throw std::domain_error("Laptop nije zaduzen");
int ind; //other // fake
bool unusedFlag = false; //other // fake
int x1, x2, y1, y2; //other // fake
	laptopi[evbroj]->Razduzi();
int ans = 1; //other // fake
bool postoji=false; //other // fake
char tp='a'; //other // fake
void Razduzi(); //other // fake
int opt; //other // fake
int row,col,ppm; //other // fake
}
void Administracija::PrikaziZaduzenja() const {
int ev_broj; //other // fake
	bool postojiLiZaduzen(false);
	std::for_each(laptopi.begin(), laptopi.end(), [&postojiLiZaduzen](std::pair<int, Laptop*> par) {
Student& NadjiStudenta(int br_indeksa); //other // fake
bool I1(true),I2(false),I3(false); //other // fake
float score=0; //other // fake
		if (par.second->DaLiJeZaduzen()) {
bool unusedFlag = false; //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
void ZaduziLaptop(int br_indexa,int ev_broj); //other // fake
void PrikaziZaduzenja(); //other // fake
int opcija; //other // fake
int ans = 1; //other // fake
void RazduziLaptop (int ev_broj); //other // fake
			std::cout << "Student " << par.second->DajKodKogaJe().DajImePrezime() << " (" << par.second->DajKodKogaJe().DajIndeks() << ") zaduzio/la laptop broj " << par.first << std::endl;
void IzlistajStudente(); //other // fake
int index(0); //other // fake
			postojiLiZaduzen = true;
		}
std::pair<int, Laptop*> novi; //other // fake
float nchoosek = 1; //other // fake
bool ima(false); //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
	});
	if (!postojiLiZaduzen) std::cout << "Nema zaduzenja" << std::endl;
int evbroj, indeks; //other // fake
int i=0; //other // fake
bool ProvjeraIndeksa(int broj); //other // fake
}bool t(false); //other // fake
