#include <iostream>
struct Kalamuta {
bool TestIndexa(int broj); //other // fake
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
virtual int foo() const { return 5;}
long int bar () { return 4;}
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
virtual int baz() const { return 3;}
virtual ~Kalamuta() {}
void ZaduziLaptop(int brojindeksa, int evidencijskibroj); //other // fake
};
struct Cincozna : public Kalamuta {
int foo() const { return 6;}
long bar () { return 8;}
bool ProvjeraBrojaTelefona(std::string brojtel); //other // fake
virtual int baz() { return 12;}
};
int main() {
int x,y; //other // fake
bool prvi_dio(false); //other // fake
Kalamuta *pk = new Kalamuta, *ck = new Cincozna;
int br1=0,br2=0; //other // fake
Cincozna *cc = new Cincozna;
std::cout << pk->foo() << " " << pk->bar() << " " << pk->baz() << std::endl;
void PostaviGodinu(std::string); //other // fake
std::cout << ck->foo() << " " << ck->bar() << " " << ck->baz() << std::endl;
std::cout << cc->foo() << " " << cc->bar() << " " << cc->baz() << std::endl;
delete pk; delete cc; delete ck;
return 0;
}void NadjiSlobodniLaptop(); //other // fake
