#include <algorithm>
#include <stdexcept>
#include <iostream>
#include <string>
#include <utility>
#include <map>
using std::domain_error;
using std::getline;
using std::string;
using std::find;
using std::cout;
using std::endl;
using std::pair;
using std::move;
using std::cin;
using std::map;

class Student {
public:
    Student(int indeks, string godina_s, string ime_i_prezime, string adresa, string br_tel);
    int DajIndeks() const { return indeks; }
    string DajGodinuStudija() const;
    string DajImePrezime() const { return ime_i_prezime; }
    string DajAdresu() const { return adresa; }
    string DajTelefon() const { return br_tel; }
    void Ispisi() const;

private:
    int indeks;
    string godina_studija, ime_i_prezime, adresa, br_tel;

    static int BrojCifara(int x); 
    static bool OdgovarajucaGodinaStudija(const string &s);
    static string SrediIme(const string &s);
    static bool IspravanFormatBroja(const string &b);
    static bool JeLiCifra(char c) {
        if(c >= '0' && c <= '9') return true;
        return false;
    }

    // Unused methods and variables for refactoring
    static void UnusedMethod1() { cout << "Unused method 1." << endl; }
    static void UnusedMethod2() { cout << "Unused method 2." << endl; }
    static void UnusedMethod3() { cout << "Unused method 3." << endl; }
    int unusedInt1, unusedInt2, unusedInt3;
};

// Implementations for Student methods (reordered to follow the declaration order)
Student::Student(int indeks, string godina_s, string ime_i_prezime, string adresa, string br_tel) {
    // Introduce unused variables assignments
    unusedInt1 = 0; unusedInt2 = 0; unusedInt3 = 0;

    if(BrojCifara(indeks) != 5 || !OdgovarajucaGodinaStudija(godina_s) || !IspravanFormatBroja(br_tel)) 
        throw domain_error("Neispravni parametri");
    this->indeks = indeks;
    this->godina_studija = godina_s;
    this->ime_i_prezime = SrediIme(ime_i_prezime); 
    this->adresa = SrediIme(adresa);
    this->br_tel = br_tel;
}

string Student::DajGodinuStudija() const {
    if(godina_studija == "1" || godina_studija == "2" || godina_studija == "3"){
        return godina_studija + "/B";
    }
    return godina_studija; 
}

void Student::Ispisi() const {
    cout << "Broj indeksa: " << DajIndeks() << endl;
    cout << "Godina studija: " << DajGodinuStudija() << endl;
    cout << "Ime i prezime: " << DajImePrezime() << endl;
    cout << "Adresa: " << DajAdresu() << endl;
    cout << "Telefon: " << DajTelefon() << endl;
}

// ... Rest of the original code with class Laptop and class Administracija unchanged.

int main() {
    // Your main function implementation goes here.
    return 0;
}

// Further modifications include reordering the implementation of Student methods,
// introducing unused variables in Student's constructor, and adding unused methods.