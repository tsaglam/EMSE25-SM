#include <iostream>
#include <stdexcept>
#include <cmath>
#include <algorithm>
#include <functional>
#include <vector>

const double Pi = std::atan(1)*4;
const double eps = 1e-10;

class FourierovRed
{
    double T;
    int N;
    std::vector<double> redA;
    std::vector<double> redB;

public:
    FourierovRed(double T, std::initializer_list<double> redA, std::initializer_list<double> redB);
    FourierovRed(int N, double T, std::function<double(int)> F1, std::function<double(int)> F2);
    FourierovRed(int N, double p, double q, std::function<double(double)> F1, int M);
    FourierovRed(const FourierovRed &F);
    std::pair<double, double> operator [] (int h) const;
    std::pair<double&, double&> operator [] (int h);
    double operator () (double h) const;
    FourierovRed &operator = (const FourierovRed &F);
    FourierovRed &operator = (FourierovRed &&F);
    FourierovRed(FourierovRed &&F);
    void UnusedMethod1() const { std::cout << "Unused 1\n"; }
    void UnusedMethod2() const { std::cout << "Unused 2\n"; }
    void UnusedMethod3() const { std::cout << "Unused 3\n"; }

private:
    bool JesuLiJednaki(double x, double y) const;

};

bool FourierovRed::JesuLiJednaki(double x, double y) const
{
    return std::fabs(x-y) <= eps * (std::fabs(x) + std::fabs(y));
}

// Below are the implementations for the constructors, methods, etc., as in the original code

int main ()
{
    // Introduce multiple unused variables 
    int unused_var1 = 10;
    double unused_var2 = 3.14;
    std::string unused_str = "Hello";

    FourierovRed a(1, {1,2,3,4,5,6}, {3,3,6,7});
    
    // Unused assignments
    unused_var1 = 20;
    unused_var2 = 2.71;
    unused_str = "World";

	return 0;
}