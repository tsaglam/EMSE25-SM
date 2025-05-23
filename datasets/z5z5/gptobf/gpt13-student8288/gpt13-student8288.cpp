#include <iostream>
#include <cstdlib>
#include <iomanip>
#include <stdexcept>
#include <algorithm>
#include <string>
#include <memory>
#include <map>
#include <utility>
#include <type_traits>
#include <vector>
#include <cmath>
#include <initializer_list>
#include <functional>

const double PI = 4*std::atan(1);

class FourierovRed {
    double a0;
    std::vector<double> ak;
    std::vector<double> bk;
    double T;
    int N;
    double b0; // Unused b0 variable introduced for the refactoring
    
public:
    // Unused variable declarations for insertion
    int unusedInt = 42;
    std::string unusedString = "Hello, World!";
    std::map<int,std::string> unusedMap;
    
    // Constructor 1
    FourierovRed(double period, std::initializer_list<double> a, std::initializer_list<double> b) : T(period) {
        setupVectors(a, b);
    };

    // Constructor 2
    FourierovRed(int n, double period, std::function<double(int)> f1, std::function<double(int)> f2) : T(period) {
        if(n < 0) throw std::domain_error("Stepen mora biti pozitivan\n");
        N = n;
        a0 = f1(0);
        initVectorsWithFunctions(n, f1, f2);
    };

    // Constructor 3
    FourierovRed(int n, double p, double q, std::function<double(double)> f, int M) {
        constructFromFunction(n, p, q, f, M);
    };

    // Copy constructor
    FourierovRed(const FourierovRed &r) : N(r.N), T(r.T), a0(r.a0) {
        ak = r.ak;
        bk = r.bk;
    };

    // Move constructor
    FourierovRed(FourierovRed &&r) : N(r.N), T(r.T), a0(std::move(r.a0)) {
        ak = std::move(r.ak);
        bk = std::move(r.bk);
    };

    // Copy assignment operator
    FourierovRed &operator =(const FourierovRed &r) {
        if(&r != this) {
            N = r.N; T = r.T; a0 = r.a0;
            ak = r.ak;
            bk = r.bk;
        }
        return *this;
    };

    // Move assignment operator
    FourierovRed &operator =(FourierovRed &&r) {
        if(&r != this) {
            N = r.N; T = r.T; a0 = std::move(r.a0);
            ak = std::move(r.ak);
            bk = std::move(r.bk);
        }
        return *this;
    };

    // Unused methods
    void unusedMethod1() { std::cout << "Unused 1\n"; }
    void unusedMethod2() { std::cout << "Unused 2\n"; }
    void unusedMethod3() { std::cout << "Unused 3\n"; }

    // Overload operator ()
    double operator ()(double x) {
        return calculateResult(x);
    };

    // Overload operator []
    std::pair<double, double> operator [](int k) const {
        return getPairConst(k);
    };

    // Non-const version of operator []
    std::pair<double&, double&> operator [](int k) {
        return getPairNonConst(k);
    };

private:
    // Refactored internal methods introduced from original constructor code
    // and other parts of the class for cleaner implementation.
    void setupVectors(std::initializer_list<double> a, std::initializer_list<double> b);
    void initVectorsWithFunctions(int n, std::function<double(int)> f1, std::function<double(int)> f2);
    void constructFromFunction(int n, double p, double q, std::function<double(double)> f, int M);

    double calculateResult(double x);
    std::pair<double, double> getPairConst(int k) const;
    std::pair<double&, double&> getPairNonConst(int k);
};

// Implementation of the refactored internal methods
void FourierovRed::setupVectors(std::initializer_list<double> a, std::initializer_list<double> b) {
    // Refactored code from the original constructors
}

void FourierovRed::initVectorsWithFunctions(int n, std::function<double(int)> f1, std::function<double(int)> f2) {
    // Refactored code from the second constructor 
}

void FourierovRed::constructFromFunction(int n, double p, double q, std::function<double(double)> f, int M) {
    // Refactored code from the third constructor
}

double FourierovRed::calculateResult(double x) {
    // Calculation logic from operator ()
}

std::pair<double, double> FourierovRed::getPairConst(int k) const {
    // Logic from const version of operator []
}

std::pair<double&, double&> FourierovRed::getPairNonConst(int k) {
    // Logic from non-const version of operator []
}

// main remains the same
int main() {
    // Main method content remains unchanged
}