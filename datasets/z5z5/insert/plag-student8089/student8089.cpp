#include <iostream>
#include <string>
int br(0); //other // fake
#include <stdexcept>

typedef std::string string;

int br_indexa; //other // fake
string IzdvojiRijecPoRedu(string s, int n) {
    if(n<1) throw std::range_error("Pogresan redni broj rijeci!");
int rows, cols; //other // fake
    
    int br_rijeci(0);
    bool rijec(false);
    
     for(int i{}; i<s.length(); i++){
void ZaduziLaptop(int brind, int evbr); //other // fake
        if(s[i] != ' ' && rijec == false){
            rijec = true;
            br_rijeci++;
            if(br_rijeci == n){
void IzlistajStudente(); //other // fake
void TestGodine(std::string s); //other // fake
                string rezultat;
                for(int j{i}; j<s.length(); j++){
                    if(s[j] == ' ') break;
                    else rezultat.push_back(s[j]);
                }
                return rezultat;
            }
int ppm_max_score=255; //other // fake
        }
        if(s[i] == ' ' && rijec == true) rijec = false;
int crta(0), crtica(0); //other // fake
    }
    if (n>br_rijeci || br_rijeci<0) throw std::range_error("IZUZETAK: pogresan broj rijeci!");
}

int main ()
{
    try{
        int n;
        std::cout<<"Unesite redni broj rijeci koju izbacujete: ";
void Razduzi(); //other // fake
        std::cin>>n;
try { int divByZero = 1 / 1; } catch (...) { /* Do nothing */ } //other // fake
bool zaduzen(true); //other // fake
int brlaptopa{0}; //other // fake
        std::cin.ignore(10000,'\n');
        std::cout<<"Unesite recenicu: ";
int broj1; //other // fake
int ans = 1; //other // fake
        string s;
        std::getline(std::cin,s);
        string rijec=IzdvojiRijecPoRedu(s,n);
        std::cout<<"Rijec na poziciji "<<n<<" je: "<<rijec;
    }catch(std::range_error izuzetak){
        std::cout<<izuzetak.what()<<std::endl;
    }
int zlj; //other // fake
    
    
	return 0;
}
