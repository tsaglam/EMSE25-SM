#include <iostream>
#include <stdexcept>
#include <cmath>
#include <algorithm>
#include <functional>
#include <vector>

const double Pi = std::atan(1)*4;
const double eps = 1e-10;

class FourierovRed {
    double T;
    int N;
    std::vector<double> redA;
    std::vector<double> redB;
    
    bool JesuLiJednaki(double x, double y) const {
        return std::fabs(x - y) <= eps * (std::fabs(x) + std::fabs(y));
    }
    
public:
    FourierovRed(double T, std::initializer_list<double> redA, std::initializer_list<double> redB);
    FourierovRed(int N, double T, std::function<double(int)> F1, std::function<double(int)> F2);
    FourierovRed(int N, double p, double q, std::function<double(double)> F1, int M);
    double operator () (double h) const;
    FourierovRed &operator = (const FourierovRed &F);
    FourierovRed &operator = (FourierovRed &&F);
    FourierovRed(const FourierovRed &F);
    FourierovRed(FourierovRed &&F);
    
    std::pair<double, double> operator [] (int h) const;
    std::pair<double&, double&> operator [] (int h);
    
};

FourierovRed::FourierovRed(double T, std::initializer_list<double> redAInit, std::initializer_list<double> redBInit)
: T(T), N(std::max(redAInit.size(), redBInit.size())) {
    if(N <= 0) throw std::domain_error("Stepen mora biti pozitivan");
    if(T <= 0) throw std::range_error("Neispravan interval");
    
    redA.resize(N+1, 0);
    std::copy(redAInit.begin(), redAInit.end(), redA.begin());
    
    redB.resize(N+1, 0);
    auto it = redB.begin() + 1; // skip first element
    std::copy(redBInit.begin(), redBInit.end(), it);
}

FourierovRed::FourierovRed(int N, double T, std::function<double (int)> F1, std::function<double (int)> F2)
: N(N), T(T) {
    if(N <= 0) throw std::domain_error("Stepen mora biti pozitivan");
    if(T <= 0) throw std::range_error("Neispravan interval");
    
    redA.resize(N+1, 0);
    redB.resize(N+1, 0);
    for(int i = 0; i <= N; ++i) {
        redA[i] = F1(i);
        redB[i] = i == 0 ? 0 : F2(i);
    }
}

// Other constructors and methods remain logically unchanged but can be modified in a similar manner 
// for consistency and potential optimization as mentioned.

int main() {
    FourierovRed a(1,{1,2,3,4,5,6}, {3,3,6,7});
    return 0;
}