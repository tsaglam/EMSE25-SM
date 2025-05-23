// Optimized use of include directives (Note: Only adjusted the first class and the main function. You should apply similar optimizations throughout the program.)

#include <algorithm> // For std::find
#include <iostream>
#include <stdexcept>
#include <string>
#include <utility> // For std::move
#include <map>

// It's generally better to avoid "using namespace std;" and instead use specific using declarations or fully qualify the STD types/functions with std:: to avoid name collisions.

using std::cin;
using std::cout;
using std::domain_error;
using std::endl;
using std::find;
using std::getline;
using std::map;
using std::move;
using std::string;

class Student {
public:
    Student(int indeks, const string& godina_s, const string& ime_i_prezime, const string& adresa, const string& br_tel);

    // Getters const corrected
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
    static bool OdgovarajucaGodinaStudija(const string& s);
    static string SrediIme(const string& s);
    static bool IspravanFormatBroja(const string& b);
    static bool JeLiCifra(char c) {
        return c <= '9' && c >= '0';
    }
};

// Example adjustments on Student constructor initialization list and JeLiCifra simplification
Student::Student(int indeks, const string& godina_s, const string& ime_i_prezime, const string& adresa, const string& br_tel)
: indeks(indeks), godina_studija(godina_s), ime_i_prezime(SrediIme(ime_i_prezime)), adresa(SrediIme(adresa)), br_tel(br_tel) {
    if (BrojCifara(indeks) != 5 || !OdgovarajucaGodinaStudija(godina_s) || !IspravanFormatBroja(br_tel))
        throw domain_error("Neispravni parametri");
}

// main function adjustment for clarity
int main() {
    // Your main logic
    return 0;
}