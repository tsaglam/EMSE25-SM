#include <iostream>
#include <stdexcept>
#include <vector>
#include <map>
#include <algorithm>

class Student{
    std::string ime_prezime, adresa, godina_studija, broj_telefona;
    int broj_indeksa;
public:
    Student(int broj_indeksa, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string broj_telefona);
    int DajIndeks()const;
    std::string DajGodinuStudija()const;
    std::string DajImePrezime()const;
    std::string DajAdresu()const;
    std::string DajTelefon()const;
    void Ispisi()const;
private:
    void FilterRazmaka(std::string &Str);
    static bool DaLiJePetocifren(int broj);
    static bool DaLiJeBrojTelefona(std::string broj);
    static bool DaLiJeIspravnaGodinaStudija(std::string s);
};

class Laptop{
    int ev_broj;
    std::string naziv, karakteristike;
    Student *kod_koga_je = nullptr;
public:
    Laptop(int ev_broj, std::string naziv, std::string karakteristike);
    int DajEvidencijskiBroj()const;
    std::string DajNaziv()const;
    std::string DajKarakteristike()const;
    void Zaduzi(Student &student);
    void Razduzi();
    bool DaLiJeZaduzen();
    Student *DajKodKogaJe();
    Student *DajPokKodKogaJe();
    void Ispisi();
};

class Administracija{
    std::map<int, Student*> mapa_studenta;
    std::map<int, Laptop*> mapa_laptopa;
public:
    Administracija();
    ~Administracija();
    Administracija(const Administracija &admin);
    Administracija(Administracija &&admin);
    Administracija &operator=(const Administracija &admin);
    Administracija &operator=(Administracija &&admin);
    void RegistrirajNovogStudenta(int broj_indeksa, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string broj_telefona);
    void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike);
    Student &NadjiStudenta(int broj_indeksa);
    Student NadjiStudenta(int broj_indeksa) const;
    Laptop &NadjiLaptop(int ev_broj);
    Laptop NadjiLaptop(int ev_broj) const;
    void IzlistajStudente() const;
    void IzlistajLaptope() const;
    void ZaduziLaptop(int broj_indeksa, int ev_broj);
    int NadjiSlobodniLaptop();
    void RazduziLaptop(int ev_broj);
    void PrikaziZaduzenja() const;
};

int main() {
    try {
        Administracija adm;
        adm.RegistrirajNovogStudenta(12535, "1", "hlk kk ksjkdjksajkjsjk  hhhh", "hdhdh", "122/533-6");
        adm.RegistrirajNoviLaptop(724, "ASUS x554l", "Intel CPU 2.4 GHz, 8 GB RAM");
        adm.RegistrirajNovogStudenta(66666, "1/M", "Azrail Zanovetak", "Ulica smrti i strave 1", "000/000-000");
        adm.RegistrirajNovogStudenta(99999, "1/D", "Lucifer Sunovrat", "Ulica smrti i strave 2", "000/000-001");
        adm.RegistrirajNovogStudenta(11111, "2/B", "Bajazit Lajka", "Turskih sultana 3", "000/000-002");
        adm.RegistrirajNoviLaptop(728, "ASUS x554l", "Intel CPU 2.4 GHz, 2 GB RAM");
        adm.RegistrirajNoviLaptop(723, "ASUS x554l", "Intel CPU 2.4 GHz, 6 GB RAM");
        adm.RegistrirajNoviLaptop(725, "ASUS x554l", "Intel CPU 2.4 GHz, 4 GB RAM");
        adm.ZaduziLaptop(11111, 724);
        adm.IzlistajStudente();
        adm.PrikaziZaduzenja();
        adm.ZaduziLaptop(66666, 728);
        adm.PrikaziZaduzenja();
    } catch (std::domain_error &Izuzetak) {
        std::cout << Izuzetak.what();
    }

    return 0;
}

// Definitions for member functions of Student and Laptop omitted for brevity. Assume they are implemented as needed, following the original provided functionality.