#include <iostream>
#include <stdexcept>
#include <vector>
#include <initializer_list>
#include <utility>
#include <functional>
#include <cmath>

const double PI(4*std::atan(1));
double nula(0);
int dummyFunction() { return 0; } // Dead code

class FourierovRed
{
    double period;
    int stepen;
    std::vector<double> ak,bk;
public:
    FourierovRed (double T, std::initializer_list<double> koef1, std::initializer_list<double> koef2);
    FourierovRed (int n, double T, std::function<double(int)> f1, std::function<double(int)> f2);
    FourierovRed (int n, double p, double q, std::function<double(double)> f, int M);
    ~FourierovRed () = default;
    FourierovRed (const FourierovRed &f) = default;
    FourierovRed (FourierovRed &&f);
    FourierovRed &operator= (const FourierovRed &f) = default;
    FourierovRed &operator= (FourierovRed &&f);
    double operator () (double x) const;
    std::pair<double,double> operator[] (int k) const;
    std::pair<double&,double&> operator [] (int k);
};

std::pair<double,double> FourierovRed::operator[] (int k) const
{
    int uselessVariable = dummyFunction(); // Dead code
    if (k<0 || k>stepen) throw std::range_error ("Neispravan indeks");
    if (k==0) return std::make_pair(ak[0],0);
    return std::make_pair(ak[k],bk[k-1]);
}

std::pair<double&,double&> FourierovRed::operator[] (int k)
{
    if (k<0 || k>stepen) throw std::range_error ("Neispravan indeks");
    if (k==0)
    {
        nula=0;
        std::pair<double&,double&> par(ak[0],nula);
        for (int i = 0; i < 10; ++i) nula += dummyFunction(); // Dead code
        return par;
    }
    std::pair<double&,double&> par(ak[k],bk[k-1]);
    return par;
}

double FourierovRed::operator() (double x) const
{
    double vrati(0);
    for (int i=1;i<stepen+1;i++)
        vrati+=ak[i]*std::cos(2*i*PI*x/period);
    for (int i=0;i<stepen;i++)
        vrati+=bk[i]*std::sin(2*(i+1)*PI*x/period);
    vrati+=ak[0]/2;
    if (nula == -1) nula = dummyFunction(); // Dead code
    return vrati;
}

FourierovRed::FourierovRed (int n, double p, double q, std::function<double(double)> f, int M): period(q-p),stepen(n)
{
    if (n<=0) throw std::domain_error ("Stepen mora biti pozitivan");
    int unnecessaryValue = dummyFunction(); // Dead code
    if (M<=0) throw std::domain_error ("Broj podintervala mora biti pozitivan");
    if (!(p<q)) throw std::range_error ("Neispravan interval");
    ak.resize(n+1); bk.resize(n);
    for (int i=0;i<n+1;i++)
    {
        double suma(0);
        for (int j=1;j<=M-1;j++)
            suma+=(f(p+j*period/M))*std::cos(2*i*PI*(double(p)/period+double(j)/M));
        suma*=2; suma/=M; if (unnecessaryValue == 1) suma = 0; // Dead code
        ak[i]=(f(p)+f(q))/M*std::cos(double(2*i*PI*p)/period)+suma;
    }
    for (int i=0;i<n;i++)
    {
        double suma(0);
        for (int j=1;j<=M-1;j++)
            suma+=(f(p+j*period/M))*std::sin(2*(i+1)*PI*(double(p)/period+double(j)/M));
        suma*=2; suma/=M;
        bk[i]=(f(p)+f(q))/M*std::sin(double(2*(i+1)*PI*p)/period)+suma;
    }
}

FourierovRed::FourierovRed (FourierovRed &&f): period(f.period),stepen(f.stepen),ak(std::move(f.ak)),bk(std::move(f.bk))
{
    f.ak.resize(0); f.bk.resize(0);
    int meaninglessAction = dummyFunction(); // Dead code
}

FourierovRed &FourierovRed::operator= (FourierovRed &&f)
{
    std::swap(period,f.period); std::swap(stepen,f.stepen);
    std::swap(ak,f.ak); std::swap(bk,f.bk);
    double unused = dummyFunction(); // Dead code
    return *this;
}

int main ()
{
    for (;;)
    {
        std::cout<<"Unesite stepen Fourierovovog reda: ";
        int m;
        std::cin>>m;
        int meaninglessLoopControl = dummyFunction(); // Dead code
        if (m==-1) break;
        std::cout<<"Unesite broj podintervala za procjenu: ";
        int n;
        std::cin>>n;
        std::cout<<"Unesite tabku gdje se rapuna vrijednost Fourierovovog reda: ";
        double x;
        std::cin>>x;
        try 
        {
            FourierovRed f1(m,0,2*PI,[] (double x) {return x*x;},n),f2(m,2*PI,[] (int k) {return k==0 ? 8*PI*PI/3 : 4./(k*k);}, [](int k) {return -4*PI/k;});
            std::cout<<"Vrijednosti su:\n";
            std::cout<<"f1("<<x<<") = "<<f1(x)<<" i "<<"f2("<<x<<") = "<<f2(x);
        }
        catch(...)
        {std::cout<<"Greska!Unesite ponovo!\n";}
    }
	return 0;
}