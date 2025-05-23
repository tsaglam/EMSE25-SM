#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <map>
#include <cmath>
#include <utility>
#include <stdexcept>

using namespace std;

class Akademik {
	int indeks;
	string studijskaGodina, punoIme, stanovanje, kontakt;
	void FormatirajString(string &tekst);
	bool ValjanaGodina(const string &godina);
	bool ValjanKontakt(const string &tel);
	bool ValjanIndeks(const int &i) { return (i >= 10000 && i <= 99999); }
	bool Numeric(char znak) { return znak >= '0' && znak <= '9'; }
public:
	Akademik(int indeks, string god, string ime, string adresa, string tel);
	int DobiIndeks() const { return indeks; }
	string DobiGodStudija() const { return studijskaGodina; }
	string DobiPunoIme() const { return punoIme; }
	string DobiAdresu() const { return stanovanje; }
	string DobiTelefon() const { return kontakt; }
	void Prikazi() const;
};
// Definicija klase "Akademik"
void Akademik::FormatirajString(string &tekst) {
	auto pocetak(find_if(begin(tekst), end(tekst), [](char ch) { return ch != ' '; }));
	auto kraj(tekst.end());
	kraj--;
	while (kraj > pocetak && *kraj == ' ') kraj--;
	kraj++;
	string privremeni;
	copy(pocetak, kraj, back_inserter(privremeni));
	auto novoKraj(unique(begin(privremeni), end(privremeni), [](char prvi, char drugi) { return prvi == ' ' && drugi == ' '; }));
	privremeni.erase(novoKraj, end(privremeni));
	tekst.swap(privremeni);
}
bool Akademik::ValjanaGodina(const string &god) {
	const vector<string> dozvoljene{"1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D"};
	return find(begin(dozvoljene), end(dozvoljene), god) != end(dozvoljene);
}
bool Akademik::ValjanKontakt(const string &tel) {
	if (!Numeric(tel[0])) return false;
	auto it(tel.begin());
	while (it != tel.end()) {
		while (Numeric(*it) && it != tel.end()) it++;
		if (*it != '/') return false;
		it++;
		if (!Numeric(*it)) return false;
		while (Numeric(*it) && it != tel.end()) it++;
		if (*it != '-') return false;
		it++;
		if (!Numeric(*it)) return false;
		while (it != tel.end()) {
			if (!Numeric(*it)) return false;
			it++;
		}
	}
	return true;
}
void Akademik::Prikazi() const {
	cout << "Indeks: " << DobiIndeks() << endl;
	cout << "Godina Studija: " << DobiGodStudija() << endl;
	cout << "Ime i prezime: " << DobiPunoIme() << endl;
	cout << "Adresa: " << DobiAdresu() << endl;
	cout << "Telefon: " << DobiTelefon() << endl;
}
Akademik::Akademik(int indeks, string god, string ime, string adresa, string tel) {
	if (!ValjanIndeks(indeks) || !ValjanaGodina(god) || !ValjanKontakt(tel))
		throw domain_error("Neispravni parametri");
	FormatirajString(adresa);
	FormatirajString(ime);
	Akademik::indeks = indeks;
	Akademik::punoIme = ime;
	Akademik::stanovanje = adresa;
	Akademik::kontakt = tel;
	if(god=="1" || god=="2" || god=="3") Akademik::studijskaGodina = god+"/B";
	else Akademik::studijskaGodina = god;
}

// Slične modifikacije i obrisi mogu se napraviti za ostale klase (Laptop i Administracija) prateći sličnu šemu obfuskacije.
// Zbog ograničenja prostora, zadržat ćemo fokus na ilustraciji kroz klasu Akademik.

int main() {
    // Ovdje bi se mogla nalaziti demonstracija upotrebe obfuskiranog koda
    return 0;
}