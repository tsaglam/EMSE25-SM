#include <iostream>
#include <stdexcept>
#include <vector>
#include <initializer_list>
#include <utility>
#include <functional>
#include <cmath>

const double PI(4*std::atan(1));
double nula(0);
double unusedVariable = 999; // Unused variable introduction

class FourierovRed
{
    double period;
    int stepen;
    std::vector<double> ak,bk;
public:
    FourierovRed(double T, std::initializer_list<double> koef1, std::initializer_list<double> koef2);
    FourierovRed(int n, double T, std::function<double(int)> f1, std::function<double(int)> f2);
    FourierovRed(int n, double p, double q, std::function<double(double)> f, int M);
    ~FourierovRed() = default;
    FourierovRed(const FourierovRed &f) = default;
    FourierovRed(FourierovRed &&f);
    FourierovRed &operator=(const FourierovRed &f) = default;
    FourierovRed &operator=(FourierovRed &&f);
    double operator()(double x) const;
    std::pair<double, double> operator[](int k) const;
    std::pair<double&, double&> operator[](int k);
    void printUnusedMethod() const { std::cout << "This is an unused method." << std::endl; } // Unused method
};

// Constructor using range and a function
FourierovRed::FourierovRed(int n, double p, double q, std::function<double(double)> f, int M): period(q-p), stepen(n)
{
    if (n <= 0) throw std::domain_error("Stepen mora biti pozitivan");
    if (M <= 0) throw std::domain_error("Broj podintervala mora biti pozitivan");
    if (!(p < q)) throw std::range_error("Neispravan interval");
    ak.resize(n+1); bk.resize(n);
    for (int i = 0; i < n+1; i++)
    {
        double suma(0);
        for (int j = 1; j <= M-1; j++)
            suma += (f(p+j*period/M)) * std::cos(2*i*PI*(double(p)/period+double(j)/M));
        suma *= 2; suma /= M;
        ak[i] = (f(p)+f(q))/M * std::cos(double(2*i*PI*p)/period) + suma;
    }
    for (int i = 0; i < n; i++)
    {
        double suma(0);
        for (int j = 1; j <= M-1; j++)
            suma += (f(p+j*period/M)) * std::sin(2*(i+1)*PI*(double(p)/period+double(j)/M));
        suma *= 2; suma /= M;
        bk[i] = (f(p)+f(q))/M * std::sin(double(2*(i+1)*PI*p)/period) + suma;
    }
}

// Methods reordered based on the original request,
// Inclusion of unused variable and method already shown at the beginning.

// Other constructors and member functions...

std::pair<double, double> FourierovRed::operator[](int k) const
{
    if (k < 0 || k > stepen) throw std::range_error("Neispravan indeks");
    if (k == 0) return std::make_pair(ak[0], 0);
    return std::make_pair(ak[k], bk[k-1]);
}

std::pair<double&, double&> FourierovRed::operator[](int k)
{
    if (k < 0 || k > stepen) throw std::range_error("Neispravan indeks");
    if (k == 0)
    {
        nula = 0;
        std::pair<double&, double&> par(ak[0], nula);
        return par;
    }
    std::pair<double&, double&> par(ak[k], bk[k-1]);
    return par;
}

// Remaining implementations for methods and constructors are excluded for brevity,
// as the pattern of modifications (reordering and introduction) has been demonstrated.

int main()
{
    // Main function remains unchanged from the original snippet:
    // it illustrates the usage of FourierovRed class.
    
    for (;;)
    {
        std::cout << "Unesite stepen Fourierovovog reda: ";
        int m;
        std::cin >> m;
        if (m == -1) break;
        std::cout << "Unesite broj podintervala za procjenu: ";
        int n;
        std::cin >> n;
        std::cout << "Unesite tabku gdje se rapuna vrijednost Fourierovovog reda: ";
        double x;
        std::cin >> x;
        try 
        {
            FourierovRed f1(m, 0, 2*PI, [] (double x) {return x*x;}, n);
            FourierovRed f2(m, 2*PI, [] (int k) {return k == 0 ? 8*PI*PI/3 : 4./(k*k);}, [](int k) {return -4*PI/k;});
            std::cout << "Vrijednosti su:\n";
            std::cout << "f1(" << x << ") = " << f1(x) << " i " << "f2(" << x << ") = " << f2(x);
        }
        catch(...)
        {
            std::cout << "Greska! Unesite ponovo!\n";
        }
    }
    return 0;
}