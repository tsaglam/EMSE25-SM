#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <cmath>
#include <utility>
#include <stdexcept>
#include <map>

using std::cin;
using std::cout;
using std::endl;
using std::pair;
using std::string;
using std::map;

class Student {
	int br_ind;
	string god_studija, ime_prezime, adresa, br_tel;
	void NormalizirajImeIliAdresu(string &s);
	bool IspravnostGodineStudija(const string &godina_studija);
	bool IspravnostBrojaTelefona(const string &broj_telefona);
	bool IspravnostBrojaIndeksa(const int &bi) const { return bi >= 10000 && bi <= 99999; }
	bool Broj(const char &znak) { return znak >= '0' && znak <= '9'; }
public:
	Student(int br_ind, string god_studija, string ime_prezime, string adresa, string br_tel);
	int DajIndeks() const { return br_ind; }
	string DajGodinuStudija() const { return god_studija; }
	string DajImePrezime() const { return ime_prezime; }
	string DajAdresu() const { return adresa; }
	string DajTelefon() const { return br_tel; }
	void Ispisi() const;
};

void Student::NormalizirajImeIliAdresu(string &s) {
	auto Pocetak = std::find_if_not(s.begin(), s.end(), [](char znak) { return znak == ' '; });
	auto Kraj = std::find_if_not(s.rbegin(), s.rend(), [](char znak) { return znak == ' '; }).base();
	
	string Pomocni(Pocetak, Kraj);
	Pomocni.erase(std::unique(Pomocni.begin(), Pomocni.end(), [](char l, char d) { return l == ' ' && d == ' '; }), Pomocni.end());
	s.swap(Pomocni);
}

// Other member functions implementations remain unchanged...

class Laptop {
	// Implementation remains largely unchanged, consider using std::move for efficiency in constructor...
};

class Administracija {
	// Use range-based for loops for cleaner syntax, std::move in constructors/operators for efficiency...
};

int main() {
    // Your main function remains unchanged, as it doesn't contain operational logic in this context.
    return 0;
}