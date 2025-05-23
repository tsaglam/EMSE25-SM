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
public:
    void SklonijRazmake(std::string &str) { 
        for(int i = 0; i < str.size(); i++) 
            if(str[i] == ' ' && (i == 0 || i == str.size() - 1 || str[i - 1] == ' ')) { 
                str.erase(str.begin() + i); i--; 
            } 
    }
    Student(int indeks, std::string godina, std::string imeiprezime, std::string adresa, std::string broj) {
        //Validation for the index and study year
        if(indeks < 10000 || indeks > 99999 || godina.empty() || godina.size() > 3 || 
          (godina.at(0) != '1' && godina.at(0) != '2' && godina.at(0) != '3') || 
          (godina.size() > 1 && godina.at(1) != '\0' && godina.at(1) != '/') ||
          (godina.size() > 2 && godina.at(1) == '/' && godina.at(2) != 'B' && godina.at(2) != 'M' && godina.at(2) != 'D'))
            throw std::domain_error("Neispravni parametri");
        if(godina == "1" || godina == "2" || godina == "3") godina += "/B";

        //Validation for the phone number
        int brojkosih{0}, brojcrtica{0};
        for(int i = 0; i < broj.size(); i++) {
            if(brojkosih > 1 || brojcrtica > 1 || ((broj[i] < '0' || broj[i] > '9') && broj[i] != '/' && broj[i] != '-') || (broj[i]=='-' && brojkosih==0))
                throw std::domain_error("Neispravni parametri");
            if(broj[i] == '/') brojkosih++;
            if(broj[i] == '-') brojcrtica++;
        }
        
        if(brojcrtica == 0 || brojkosih == 0)
            throw std::domain_error("Neispravni parametri");

        SklonijRazmake(imeiprezime);
        SklonijRazmake(adresa);
        BrojIndeksa = indeks;
        GodinaStudiranja = godina;
        ImeIPrezime = imeiprezime;
        Adresa = adresa;
        BrojTelefona = broj;
    }

    int DajIndeks() const { return BrojIndeksa; }
    std::string DajGodinuStudija() const { return GodinaStudiranja.size() == 1 ? GodinaStudiranja + "/B" : GodinaStudiranja; }
    std::string DajImePrezime() const { return ImeIPrezime; }
    std::string DajAdresu() const { return Adresa; }
    std::string DajTelefon() const { return BrojTelefona; }
    void Ispisi() const {
        std::cout << "Broj indeksa: " << BrojIndeksa << std::endl << "Godina studija: " << GodinaStudiranja << std::endl << "Ime i prezime: " << ImeIPrezime << std::endl << "Adresa: " <<
        Adresa << std::endl << "Telefon: " << BrojTelefona << std::endl;
    }
};

class Laptop {
    int ev_broj;
    std::string naziv;
    std::string karakteristike;
    Student *kod_koga_je;
public:
    Laptop(int evidencijski, std::string nazif, std::string karak) : ev_broj(evidencijski), naziv(nazif), karakteristike(karak), kod_koga_je(nullptr) {
        if(evidencijski < 0) throw std::domain_error("Neispravni parametri");
    }

    int DajEvidencijskiBroj() const { return ev_broj; }
    std::string DajNaziv() const { return naziv; }
    std::string DajKarakteristike() const { return karakteristike; }
    void Zaduzi(Student &zaduzuje) { 
        if(kod_koga_je != nullptr) throw std::domain_error("Laptop vec zauzet"); kod_koga_je = &zaduzuje; 
    }
    void Razduzi() { kod_koga_je = nullptr; }
    bool DaLiJeZaduzen() const { return kod_koga_je != nullptr; }
    Student &DajKodKogaJe() const { 
        if(kod_koga_je == nullptr) throw std::domain_error("Laptop nije zaduzen"); 
        return *kod_koga_je; 
    }
    Student* DajPokKodKogaJe() const { return kod_koga_je; }
    void Ispisi() const { 
        std::cout << "Evidencijski broj: " << ev_broj << std::endl << "Naziv: " << naziv << std::endl << "Karakteristike: " << karakteristike << std::endl; 
    }
};

// Class Administracija would come next, its definition remains unchanged 

// main function remains unchanged as well