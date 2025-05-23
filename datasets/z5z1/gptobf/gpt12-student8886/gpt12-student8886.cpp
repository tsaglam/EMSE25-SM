#include <iostream>
#include <stdexcept>
#include <vector>
#include <map>
#include <algorithm>

class Student{
public:
    Student(int broj_indeksa, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string broj_telefona):
    broj_indeksa(broj_indeksa), godina_studija(godina_studija),broj_telefona(broj_telefona){
        if(godina_studija.size()==0 || ime_prezime.size()==0 || adresa.size()==0 || broj_telefona.size()==0 || DaLiJePetocifren(broj_indeksa)==false || DaLiJeIspravnaGodinaStudija(godina_studija)==false || DaLiJeBrojTelefona(broj_telefona)==false) 
            throw std::domain_error("Neispravni parametri");
        FilterRazmaka(ime_prezime);
        FilterRazmaka(adresa);
        Student::ime_prezime=ime_prezime;
        Student::adresa=adresa;
    }
    
    std::string DajImePrezime()const{
        return ime_prezime;
    }
    
    int DajIndeks()const{
        return broj_indeksa;
    }
    
    std::string DajGodinuStudija()const{
        std::string s(godina_studija);
        if(s.size()==1 && (s[0]=='1' || s[0]=='2' || s[0]=='3')) s.push_back('/'), s.push_back('B');
        return s;
    }
    
    std::string DajAdresu()const{
        return adresa;
    }
    
    std::string DajTelefon()const{
        return broj_telefona;
    }
    
    void Ispisi()const{
        std::cout<<"Broj indeksa: "<<DajIndeks()<<std::endl
        <<"Godina studija: "<<DajGodinuStudija()<<std::endl
        <<"Ime i prezime: "<<DajImePrezime()<<std::endl
        <<"Adresa: "<<DajAdresu()<<std::endl
        <<"Telefon: "<<DajTelefon()<<std::endl;
    }
    
    void UnusedMethod() const {
        std::cout << "This is an unused method." << std::endl;
    }

private:
    int broj_indeksa;
    std::string godina_studija;
    std::string ime_prezime;
    std::string adresa;
    std::string broj_telefona;
    static bool DaLiJePetocifren(int broj){
        int brojac(0);
        while(broj%10!=0){
            broj/=10;
            brojac++;
        }
        return (brojac==5);
    }
    static bool DaLiJeIspravnaGodinaStudija(std::string s){
        if(s.size()>3 || s.size()==0) return false;
        if(s.size()==3 && s[1]=='/' && (s[0]=='1' || s[0]=='2' || s[0]=='3') && (s[2]=='B' || s[2]=='M' || s[2]=='D')) return true;
        if(s.size()==1 && (s[0]=='1' || s[0]=='2' || s[0]=='3')) return true;
        return false;
    }
    
    static bool DaLiJeBrojTelefona(std::string broj){
        std::vector<int> znakovi(2);
        for(int i=0; i<broj.size(); i++){
            if(broj[i]=='-' && znakovi[0]==0) break;
            if(broj[i]=='/') znakovi[0]++;
            if(broj[i]=='-') znakovi[1]++;
        }
        if(znakovi[0]==1 && znakovi[1]==1) return true;
        return false;
    }
    void FilterRazmaka(std::string &Str){
        char Ch=' ';
        std::string out;
        bool first = true;
        bool space = false;
        for (std::string::const_iterator it = Str.begin(); it != Str.end(); ++it)
        {
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
};