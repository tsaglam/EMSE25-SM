#include <iostream>
#include <string>
#include <map>
#include <algorithm>
#include <stdexcept>
#include <vector>

using namespace std;

class Student {
    int indeks;
    string godina_studija, ime_i_prezime, adresa, br_tel;

public:
    Student(int indeks, const string& godina_s, const string& ime_i_prezime, const string& adresa, const string& br_tel);
    int DajIndeks() const { return indeks; }
    string DajGodinuStudija() const;
    string DajImePrezime() const { return ime_i_prezime; }
    string DajAdresu() const { return adresa; }
    string DajTelefon() const { return br_tel; }
    void Ispisi() const;
    
private:
    static int BrojCifara(int x); 
    static bool OdgovarajucaGodinaStudija(const string& s);
    static string SrediIme(const string& s);
    static bool IspravanFormatBroja(const string& b);
    static bool JeLiCifra(char c) { return c >= '0' && c <= '9'; }
};

Student::Student(int indeks, const string& godina_s, const string& ime_i_prezime, const string& adresa, const string& br_tel) : ime_i_prezime(SrediIme(ime_i_prezime)), adresa(SrediIme(adresa)), godina_studija(godina_s), indeks(indeks), br_tel(br_tel) {
    if (BrojCifara(indeks) != 5 || !OdgovarajucaGodinaStudija(godina_s) || !IspravanFormatBroja(br_tel))
        throw domain_error("Neispravni parametri");
}

// Implement other Student methods as before...

class Laptop {
    int ev_broj;
    string naziv, karakteristike;
    Student* kod_koga_je = nullptr;
  
public:
    Laptop(int ev_broj, const string& naziv, const string& karakteristike);
    // Implement other Laptop methods as before...
};

// Implement Laptop member functions as shown in your original code

class Administracija {
    map<int, unique_ptr<Student>> studenti;
    map<int, unique_ptr<Laptop>> laptopi;

public:
    // Rewrite constructors, assignment operators and methods to manage resources properly with smart pointers
    // Remember to delete the manually defined destructor, copy constructor, and copy assignment operator
    // Implement other methods as before...
};

// Implement all member functions of Administracija as required, adjusting for smart pointer usage

int main() {
    // Your main function approach can remain the same,
    // remember to consider any changes made to classes when invoking their members.
}

// Note: Detailed implementations of the Student, Laptop, and Administracija class methods need to be adjusted 
// according to the changes (e.g., smart pointers, constructor initializers) without changing their behaviors.