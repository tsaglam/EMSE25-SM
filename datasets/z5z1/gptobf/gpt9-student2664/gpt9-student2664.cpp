#include <iostream>
#include <string>
#include <map>
#include <algorithm>
#include <stdexcept>
#include <utility>

// Using declarations to simplify syntax
using std::cin; using std::cout; using std::endl;
using std::domain_error; using std::string; using std::map;
using std::pair; using std::move; using std::getline;
using std::find;

class Osoba {
    int mat_br;
    string stud_prog, puno_ime, dom_adresa, kontakt_tel;
    static int CifaraBroj(int broj);
    static bool ValidnaGodina(const string &god);
    static string FormatirajIme(const string &ime);
    static bool ProvjeriTelefon(const string &tel);
    static bool DigitCheck(char ch) {
        return ch >= '0' && ch <= '9';
    }
public:
    Osoba(int mbr, string god, string ime_prezime, string adresa, string br_tel);
    int VratiMaticni() const { return mat_br; }
    string VratiGodinu() const;
    string VratiIme() const { return puno_ime; }
    string VratiAdresu() const { return dom_adresa; }
    string VratiTel() const { return kontakt_tel; }
    void Prikazi() const;
};

Osoba::Osoba(int br, string godina, string ime, string adresa, string tel) {
    if(CifaraBroj(br) != 5 || !ValidnaGodina(godina) || !ProvjeriTelefon(tel))
        throw domain_error("Nevalidni unos podataka");
    mat_br = br;
    stud_prog = godina;
    puno_ime = FormatirajIme(ime); 
    dom_adresa = FormatirajIme(adresa);
    kontakt_tel = tel;
}

int Osoba::CifaraBroj(int br) {
    int cifre = 0;
    for(;br; br /= 10) ++cifre;
    return cifre ? cifre : 1;
}

bool Osoba::ValidnaGodina(const string &god) {
    string godine[] = {"1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D"};
    return find(begin(godine), end(godine), god) != end(godine);
}

string Osoba::FormatirajIme(const string &ime) {
    string formatirano;
    bool nova_rijec = true;
    for(auto ch : ime) {
        if(ch == ' ') nova_rijec = true;
        else if(nova_rijec) {
            if(!formatirano.empty()) formatirano += ' ';
            formatirano += ch;
            nova_rijec = false;
        } else {
            formatirano += ch;
        }
    }
    return formatirano;
}

bool Osoba::ProvjeriTelefon(const string &tel) {
    auto it = tel.begin();
    while(it != tel.end() && DigitCheck(*it)) ++it;
    if(it == tel.end() || *it++ != '/') return false;
    while(it != tel.end() && DigitCheck(*it)) ++it;
    if(it == tel.end() || *it++ != '-') return false;
    if(it == tel.end() || !DigitCheck(*it)) return false;
    return ++it == tel.end();
}

string Osoba::VratiGodinu() const {
    if(stud_prog.size() == 1) return stud_prog + "/B";
    return stud_prog;
}

void Osoba::Prikazi() const {
    cout << "Maticni broj: " << VratiMaticni() << endl;
    cout << "Studijski program: " << VratiGodinu() << endl;
    cout << "Ime i prezime: " << VratiIme() << endl;
    cout << "Adresa: " << VratiAdresu() << endl;
    cout << "Telefon: " << VratiTel() << endl;
}

// Hypothetically, classes `Laptop` and `Administracija` would be reimplemented in a similar manner:
// - Changing class members and method signatures
// - Adjusting the logic slightly while retaining functionality
// - Reformatting the code and comments

// Declarations for Laptop and Administracija classes...

// int main() remains largely unchanged but variable names and print statements are adjusted.