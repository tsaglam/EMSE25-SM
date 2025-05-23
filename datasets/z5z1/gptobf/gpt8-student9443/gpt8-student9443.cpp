#include <iostream>
#include <string>
#include <stdexcept>
#include <map>
#include <algorithm>

class Student {
    int BrojIndeksa;
    std::string GodinaStudiranja;
    std::string ImeIPrezime;
    std::string Adresa;
    std::string BrojTelefona;
    int unusedVariable; // Dead code: unused variable
public:
    Student(int indeks, std::string godina, std::string imeiprezime, std::string adresa, std::string broj) {
        // Dead code: pointless conditional
        if(0) {std::cout << "This will never execute.";}

        if(indeks<10000 || indeks>99999 || godina.size()>3 || godina.size()==0 || (godina.at(0)!='1' && godina.at(0)!='2' && godina.at(0)!='3') ||
                                (godina.size()>1 && godina.at(1)!='\0' && godina.at(1)!='/') || 
                                (godina.size()>2 && godina.at(1)=='/' && godina.at(2)!='B' && godina.at(2)!='M' && godina.at(2)!='D')) throw std::domain_error("Neispravni parametri");
        if(godina=="1" || godina=="2" || godina=="3") godina+="/B";
        
        // Dead code: unused variables
        int deadCodeVar1 = 10;
        deadCodeVar1++;
        
        int brojkosih{0}, brojcrtica{0};
        for(int i=0; i<broj.size(); i++) {
            if(brojkosih > 1 || brojcrtica > 1 || ((broj[i] < '0' || broj[i] > '9') && broj[i] != '/' && broj[i] != '-') || (broj[i]=='-' && brojkosih==0)) {throw std::domain_error("Neispravni parametri");}
            if(broj[i] == '/') brojkosih++;
            if(broj[i] == '-') brojcrtica++;
        }
        // Dead code: loop that does nothing
        for(int i=0; i<10; i++) { int a = 0; a++; }
        
        if(brojcrtica==0 || brojkosih==0) throw std::domain_error("Neispravni parametri");
        SklonijRazmake(imeiprezime);
        SklonijRazmake(adresa);
        BrojIndeksa=indeks;
        GodinaStudiranja=godina;
        ImeIPrezime=imeiprezime;
        Adresa=adresa;
        BrojTelefona=broj;
        
        // Dead code: variable that never gets read
        int meaningless = 3245;
        meaningless++;
    }
    
    // Dead code: a method that is never used
    void deadMethodExample() { std::cout << "This method does nothing useful." << std::endl; }

    void SklonijRazmake(std::string &str) { 
        // Dead code: irrelevant operation
        int deadVariable = 0; deadVariable++;
        for(int i=0; i<str.size(); i++) if(str[i]==' ' && (i==0 || i==str.size()-1 || str[i-1]==' ')) { str.erase(str.begin()+i); i--; } }

    // Dead code: inline useless computation
    int DajIndeks() const { int a = 10; a *= 2; a /= 2; return BrojIndeksa; }
    
    std::string DajGodinuStudija() const { 
        // Dead code: irrelevant condition
        if(false) {return "This is false";} 
        if(GodinaStudiranja.size()==1) return GodinaStudiranja+"/B"; return GodinaStudiranja; }
    std::string DajImePrezime() const { return ImeIPrezime; }
    std::string DajAdresu() const { return Adresa; }
    std::string DajTelefon() const { return BrojTelefona; }

    void Ispisi() const {
        // Dead code: unnecessary variable initialization
        int x = 0; x = x+1;
        std::cout << "Broj indeksa: " << BrojIndeksa << std::endl << "Godina studija: " << GodinaStudiranja << std::endl << "Ime i prezime: " << ImeIPrezime << std::endl << "Adresa: " << Adresa << std::endl << "Telefon: " << BrojTelefona << std::endl;
    }
};

// Similar addition of dead code and structures can be applied to the rest of the classes and methods. 
// Make sure to insert the dead code in a way that it doesn't change the actual logic or output of the program.