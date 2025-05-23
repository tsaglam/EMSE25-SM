#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <cmath>
#include <utility>
#include <stdexcept>
#include <stdio.h>
#include <map>
using std::cin;
using std::cout;
using std::endl;
using std::pair;
class Student {
	int br_ind;
	std::string god_studija, ime_prezime, adresa, br_tel;
	bool IspravnostBrojaIndeksa(const int &bi) { return (bi >= 10000 && bi <= 99999); }
	bool IspravnostGodineStudija(const std::string &godina_studija);
	bool IspravnostBrojaTelefona(const std::string &broj_telefona);
	bool Broj(const char &znak) { return znak >= '0' && znak <= '9'; }
	void NormalizirajImeIliAdresu(std::string &s);
public:
	Student(int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel);
	int DajIndeks() const { return br_ind; }
	std::string DajGodinuStudija() const { return god_studija; }
	std::string DajImePrezime() const { return ime_prezime; }
	std::string DajAdresu() const { return adresa; }
	std::string DajTelefon() const { return br_tel; }
	void Ispisi() const;
	friend class Laptop;
	friend class Administracija;
};
Student::Student(int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel) {
	if (!IspravnostBrojaIndeksa(br_ind)) throw std::domain_error("Neispravni parametri");  
	if (!IspravnostGodineStudija(god_studija)) throw std::domain_error("Neispravni parametri");
	if (!IspravnostBrojaTelefona(br_tel)) throw std::domain_error("Neispravni parametri");
	NormalizirajImeIliAdresu(adresa);
	NormalizirajImeIliAdresu(ime_prezime);
	Student::br_ind = br_ind; Student::ime_prezime = ime_prezime; Student::adresa = adresa; Student::br_tel = br_tel;
	if(god_studija=="1" || god_studija=="2" || god_studija=="3") Student::god_studija = god_studija+"/B";
	else Student::god_studija = god_studija;
}
void Student::NormalizirajImeIliAdresu(std::string &s) {
	auto Pocetak(std::find_if(s.begin(), s.end(), [](const char &znak) { return znak != ' '; }));
	auto Kraj(s.end());
	Kraj--;
	while (Kraj != Pocetak) {
		if (*Kraj != ' ')
			break;
		Kraj--;
	}
	Kraj++;
	std::string Pomocni;
	std::copy(Pocetak, Kraj, back_inserter(Pomocni));
	auto novi_kraj(std::unique(Pomocni.begin(), Pomocni.end(), [](char l, char d) { return (l == d) && (l == ' '); }));
	Pomocni.erase(novi_kraj, Pomocni.end());
	s = Pomocni;
}
bool Student::IspravnostGodineStudija(const std::string &godina_studija) {
	static const std::vector<std::string> ValidneGS{ "1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D" };
	if (std::count(ValidneGS.begin(), ValidneGS.end(), godina_studija)) return true; return false;
}
bool Student::IspravnostBrojaTelefona(const std::string &broj_telefona) {
	if (!Broj(broj_telefona[0])) return false;
	auto klizeci(broj_telefona.begin());
	while (klizeci != broj_telefona.end()) {
		while (Broj(*klizeci) && klizeci!=broj_telefona.end()) klizeci++;
		if (*klizeci != '/') return false;
		klizeci++;
		if (!Broj(*klizeci)) return false;
		while (Broj(*klizeci) && klizeci != broj_telefona.end()) klizeci++;
		if (*klizeci != '-') return false;
		klizeci++;
		if (!Broj(*klizeci)) return false;
		while (klizeci != broj_telefona.end()) {
			if (!Broj(*klizeci)) return false;
			klizeci++;
		}
	}
	return true;
}
void Student::Ispisi() const {
	cout << "Broj indeksa: " << DajIndeks() << endl;
	cout << "Godina studija: " << DajGodinuStudija();
	if (DajGodinuStudija() == "1" || DajGodinuStudija() == "2" || DajGodinuStudija() == "3") cout << "/B" << endl;
	else cout << endl; 
	cout << "Ime i prezime: " << DajImePrezime() << endl;
	cout << "Adresa: " << DajAdresu() << endl; 
	cout << "Telefon: " << DajTelefon() << endl; 
}
class Laptop {
	int ev_broj;
	std::string naziv, karakteristike;
	Student *kod_koga_je;
public:
	Laptop(int ev_broj, std::string naziv, std::string karakteristike);
	int DajEvidencijskiBroj() const { return ev_broj; }
	std::string DajNaziv() const { return naziv; }
	std::string DajKarakteristike() const { return karakteristike; }
	void Zaduzi(Student &stud) { if (kod_koga_je != nullptr) throw std::domain_error("Laptop vec zaduzen"); kod_koga_je = &stud; }
	void Razduzi() { kod_koga_je = nullptr; }
	bool DaLiJeZaduzen() { if (kod_koga_je == nullptr) return false; return true; }
	Student& DajKodKogaJe() { if (kod_koga_je == nullptr) throw std::domain_error("Laptop nije zaduzen"); return *kod_koga_je; }
	Student* DajPokKodKogaJe() { return kod_koga_je; }
	void Ispisi() const;
};
Laptop::Laptop(int ev_broj, std::string naziv, std::string karakteristike) {
	if (ev_broj<0) throw std::domain_error("Neispravni parametri");
	Laptop::ev_broj = ev_broj; Laptop::naziv = naziv; Laptop::karakteristike = karakteristike; kod_koga_je = nullptr;
}
void Laptop::Ispisi() const {
	cout << "Evidencijski broj: " << DajEvidencijskiBroj() << endl << "Naziv: " << DajNaziv() << endl << "Karakteristike: " << DajKarakteristike() << endl;
	if (kod_koga_je != nullptr) 
		cout << "Zaduzio(la): " << kod_koga_je->DajImePrezime() << " (" << kod_koga_je->DajIndeks() << ")" << endl;
}
class Administracija {
	std::map<int, Student*> Studenti;
	std::map<int, Laptop*> Laptopi;
public:
	Administracija () {}
	Administracija (const Administracija &a);
	Administracija (Administracija &&a);
	Administracija &operator =(const Administracija &a);
	Administracija &operator =(Administracija &&a);
	~Administracija() { for (auto stud : Studenti) delete stud.second; for (auto lapas : Laptopi) delete lapas.second; }
	void RegistrirajNovogStudenta (int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel);
	void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike);
	Student& NadjiStudenta (int brind);
	Student NadjiStudenta(int brind) const;
	Laptop& NadjiLaptop(int evbr);
	Laptop NadjiLaptop(int evbr) const;
	void IzlistajStudente () const;
	void IzlistajLaptope () const;
	void ZaduziLaptop(int brind, int evbr);
	int NadjiSlobodniLaptop();
	void RazduziLaptop(int evbroj);
	void PrikaziZaduzenja() const;
};
Administracija::Administracija(const Administracija &a) {
	for (auto its(a.Studenti.begin()); its != a.Studenti.end(); its++) 
		Studenti.emplace(its->first, its->second);
	for (auto itl(a.Laptopi.begin()); itl != a.Laptopi.end(); itl++)
		Laptopi.emplace(itl->first, itl->second);
}
Administracija::Administracija(Administracija &&a) {
	Administracija::Studenti = std::move(a.Studenti);
	Administracija::Laptopi = std::move(a.Laptopi);
	a.Studenti.clear(); a.Laptopi.clear();
}
Administracija &Administracija::operator =(const Administracija &a) {
	if (&a != this) {
		for (auto Studl : Studenti)
			delete Studl.second;
		Studenti.clear();
		for (auto Lapl : Laptopi)
			delete Lapl.second;
		Laptopi.clear();
		for (auto it : a.Studenti) 
			Studenti.emplace(it.first, new Student(*it.second)); 
		for (auto it_lap : a.Laptopi) 
			Laptopi.emplace(it_lap.first, new Laptop(*it_lap.second));
	}
	return *this;
}
Administracija &Administracija::operator =(Administracija &&a) {
	std::swap(Studenti, a.Studenti);
	std::swap(Laptopi, a.Laptopi);
	return *this;
}
void Administracija::RegistrirajNovogStudenta(int br_ind, std::string god_studija, std::string ime_prezime, std::string adresa, std::string br_tel) {
	if (Studenti.find(br_ind) != Studenti.end()) throw std::domain_error("Student s tim indeksom vec postoji");
	Studenti[br_ind] = new Student(br_ind, god_studija, ime_prezime, adresa, br_tel);
}
void Administracija::RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike) {
	if (Laptopi.find(ev_broj) != Laptopi.end()) throw std::domain_error("Laptop s tim evidencijskim brojem vec postoji");
	Laptopi[ev_broj] = new Laptop(ev_broj, naziv, karakteristike);
}
Student& Administracija::NadjiStudenta(int brind) {
	if (Studenti.find(brind) == Studenti.end()) throw std::domain_error("Student nije nadjen");
	return *Studenti[brind];
}
Student Administracija::NadjiStudenta(int brind) const {
	if (Studenti.find(brind) == Studenti.end()) throw std::domain_error("Student nije nadjen");
	return *Studenti.at(brind);
}
Laptop& Administracija::NadjiLaptop(int evbr) {
	if (Laptopi.find(evbr) == Laptopi.end()) throw std::domain_error("Laptop nije nadjen");
	return *Laptopi[evbr];
}
Laptop Administracija::NadjiLaptop(int evbr) const {
	if (Laptopi.find(evbr) == Laptopi.end()) throw std::domain_error("Laptop nije nadjen");
	return *Laptopi.at(evbr);
}
void Administracija::IzlistajStudente() const {
	for (const auto &stud : Studenti) {
		stud.second->Ispisi();
		cout << endl;
	}
}
void Administracija::IzlistajLaptope() const {
	for (const auto &lap : Laptopi) {
		lap.second->Ispisi();
	}
}
void Administracija::ZaduziLaptop(int brind, int evbr) {
	if (Studenti.find(brind) == Studenti.end()) throw std::domain_error("Student nije nadjen");
	if (Laptopi.find(evbr) == Laptopi.end()) throw std::domain_error("Laptop nije nadjen");
	if (Laptopi[evbr]->DaLiJeZaduzen()) throw std::domain_error("Laptop vec zaduzen");
	for (const auto &lap : Laptopi) {
		if (lap.second->DajPokKodKogaJe() && lap.second->DajPokKodKogaJe()->DajIndeks() == brind)
			throw std::domain_error("Student je vec zaduzio laptop");
	}
	Laptopi[evbr]->Zaduzi(*Studenti[brind]);
}
int Administracija::NadjiSlobodniLaptop() {
	for (const auto &lap : Laptopi) {
		if (!lap.second->DaLiJeZaduzen()) return lap.first;
	}
	throw std::domain_error("Nema slobodnih laptopa");
}
void Administracija::RazduziLaptop(int evbroj) {
	if (Laptopi.find(evbroj) == Laptopi.end()) throw std::domain_error("Laptop nije nadjen");
	if (!Laptopi[evbroj]->DaLiJeZaduzen()) throw std::domain_error("Laptop nije zaduzen");
	Laptopi[evbroj]->Razduzi();
}
void Administracija::PrikaziZaduzenja() const {
	bool imaZaduzenja = false;
	for (const auto &lap : Laptopi) {
		if (lap.second->DaLiJeZaduzen()) {
			imaZaduzenja = true;
			cout << "Student " << lap.second->DajKodKogaJe().DajImePrezime() << " (" << lap.second->DajKodKogaJe().DajIndeks() << ") zaduzio/la laptop broj " << lap.first << endl;
		}
	}
	if (!imaZaduzenja) cout << "Nema zaduzenja" << endl;
}



int main () {
    return 0;
}