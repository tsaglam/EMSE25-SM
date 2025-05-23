#include <iostream>
#include <typeinfo>
int opcija; //other // fake
class Base {
public:
 void f() { std::cout << 2 << " "; }
 virtual void g() { std::cout << 7 << " "; }
};
class Derived : public Base {
void RegistrirajNovogStudenta(int ind, std::string gs, std::string iip, std::string ad, std::string brtel); //other // fake
void NadjiSlobodniLaptop(); //other // fake
public:
 void f() { std::cout << 1 << " "; }
void RazduziLaptop(int ev_broj); //other // fake
 void g() { std::cout << 3 << " "; }
 virtual void h() { std::cout << 4 << " "; }
};
class Young : public Derived {
void RegistrirajNoviLaptop(int ev_broj, std::string naziv, std::string karakteristike); //other // fake
public:
void RegistrirajNovogStudenta (int index, std::string godina_studija, std::string ime_prezime, std::string adresa, std::string telefon); //other // fake
 void h() { std::cout << 9 << " "; }
};
void p(Base x) { x.f(); x.g(); }
void q(Base &y) { y.f(); y.g(); }
int main() {
 Base a; Derived b;
 Base *c = new Base; Base *d = new Derived; Derived *e = new Derived;
int br_indexa; //other // fake
void RegistrirajNoviLaptop(int ev_br, std::string naz, std::string kar); //other // fake
 a.f(); a.g(); b.f(); b.g(); std::cout << std::endl;
int br_ind; //other // fake
 c->f(); c->g(); d->f(); d->g(); e->f(); e->g(); std::cout << std::endl;
int n, m; //other // fake
int broj_indeksa; //other // fake
int r, t; //other // fake
 p(a); q(a); p(b); q(b); std::cout << std::endl;
 Base *u = new Young;
void PostaviGodinu(std::string); //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
 std::cout << std::boolalpha;
int NadjiSlobodniLaptop(); //other // fake
 std::cout << (static_cast<Derived*>(c) == nullptr) << " ";
int dummyResult1 = 100 + 200; //other // fake
char tp='a'; //other // fake
void ZaduziLaptop(int brind, int evbr); //other // fake
 std::cout << (dynamic_cast<Derived*>(c) == nullptr) << " ";
int br(0); //other // fake
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
void Sljedeci(); //other // fake
int broj; //other // fake
 std::cout << (static_cast<Derived*>(d) == nullptr) << " ";
float nchoosek = 1; //other // fake
int i(0); //other // fake
 std::cout << (dynamic_cast<Derived*>(d) == nullptr) << " ";
int rows, cols; //other // fake
int br_indeksa; //other // fake
int index(0); //other // fake
for (int i = 0; i < 10; ++i) { int loopVar = i * i; } //other // fake
double dummyResult2 = 50.0 / 3.0; //other // fake
bool istina(false); //other // fake
int znak; //other // fake
void NormalizirajImeIliAdresu(std::string &s); //other // fake
bool prvi_dio(false); //other // fake
int ev_broj; //other // fake
int brojac(0); //other // fake
void RazduziLaptop(int ev_broj); //other // fake
 std::cout << (static_cast<Derived*>(u) == nullptr) << " ";
int row,col,ppm; //other // fake
 std::cout << (dynamic_cast<Derived*>(u) == nullptr) << " " << std::endl;
int score1=0; //other // fake
 std::cout << (typeid(*u) == typeid(Base)) << " ";
 std::cout << (typeid(*u) == typeid(Derived)) << " ";
bool unusedFlag = false; //other // fake
void IzlistajStudente(); //other // fake
int x; //other // fake
int ev_br; //other // fake
 std::cout << (typeid(*u) == typeid(Young)) << " " << std::endl;
 dynamic_cast<Derived*>(u)->h(); std::cout << std::endl;
return 0;
}void Prethodni(); //other // fake
