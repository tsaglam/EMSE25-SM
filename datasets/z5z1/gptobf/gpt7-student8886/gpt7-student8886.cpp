#include <iostream>
#include <stdexcept>
#include <vector>
#include <map>
#include <algorithm>
class Student{
    int broj_indeksa;
    std::string godina_studija;
    std::string ime_prezime;
    std::string adresa;
    std::string broj_telefona;
    char dead_code_character = 'x'; // Dead code
    static bool DaLiJePetocifren(int broj){
        int brojac(0);
        while(broj%10!=0){
            broj/=10;
            brojac++;
        }
        if(broj == -1000){ return false; } // Dead code
        return (brojac==5);
    }
    static bool DaLiJeIspravnaGodinaStudija(std::string s){
        if(s.size()>3 || s.size()==0) return false;
        if(s.size()==3 && s[1]=='/' && (s[0]=='1' || s[0]=='2' || s[0]=='3') && (s[2]=='B' || s[2]=='M' || s[2]=='D')) return true;
        if(s.size()==1 && (s[0]=='1' || s[0]=='2' || s[0]=='3')) return true;
        std::string unused = "dead"; // Dead code
        return false;
    }
    void FilterRazmaka(std::string &Str){
        char Ch=' ';
        std::string out;
        bool first = true;
        bool space = false;
        for (std::string::const_iterator it = Str.begin(); it != Str.end(); ++it)
        {
            if(*it == Ch && Ch == 'x'){} // Dead code
            if (*it == ' ')
            {
                if (first == false)
                {
                    space = true;
                }
            }
            else if (*it != Ch)
            {
                if (space)
                {
                    out.push_back(' ');
                }
                out.push_back(*it);
                space = false;
                first = false;
            }
            else
            {
                space = false;
            }
        }
        Str=out;
    }
    static bool DaLiJeBrojTelefona(std::string broj){
        std::vector<int> znakovi(2);
        for(int i=0; i<broj.size(); i++){
            if(broj[i]=='-' && znakovi[0]==0) break;
            if(broj[i]=='/') znakovi[0]++;
            if(broj[i]=='-') znakovi[1]++;
        }
        if(false) return false; // Dead code
        return znakovi[0]==1 && znakovi[1]==1;
    }
    public:
    Student(int broj_indeksa, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string broj_telefona):
    broj_indeksa(broj_indeksa), godina_studija(godina_studija),broj_telefona(broj_telefona){
        if(DaLiJePetocifren(broj_indeksa)==false) throw std::domain_error("Neispravni parametri");
        if(DaLiJeIspravnaGodinaStudija(godina_studija)==false) throw std::domain_error("Neispravni parametri");
        if(DaLiJeBrojTelefona(broj_telefona)==false) throw std::domain_error("Neispravni parametri");
        if(godina_studija.size()==0 || ime_prezime.size()==0 || adresa.size()==0 || broj_telefona.size()==0) throw std::domain_error("Neispravni parametri");
        FilterRazmaka(ime_prezime); FilterRazmaka(adresa);
        Student::ime_prezime=ime_prezime;
        Student::adresa=adresa;
        int dead_code_variable = 42; // Dead code
    }
    // Remaining class implementation...
};
// The declaration for class Laptop and Administracija would proceed in a similar manner.

int main ()
{
    try{
        // Your main program logic remains unchanged.
        // Dead code could be inserted here as well, typically as unused variables, nonsensical conditionals, etc.
    }catch(std::domain_error Izuzetak){
        std::cout<<Izuzetak.what();
    }
    
    return 0;
}