#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>
#include <stdexcept>
#include <cmath>
#include <tuple>
#include <functional>
#define pi (4.*std::atan(1))

class FourierovRed {
    double t;
    int n;
    std::vector<double> a, b;

public:
    // Constructor with initializer lists
    FourierovRed(double t1, std::initializer_list<double> a1, std::initializer_list<double> b1) {
        a.resize(a1.size());
        b.resize(b1.size());
        std::copy(a1.begin(), a1.end(), a.begin());
        std::copy(b1.begin(), b1.end(), b.begin());
        t = t1;
        
        if (a.size() != b.size()) {
            if (a.size() > b.size()) {
                for (int i = b.size(); i < a.size(); i++) {
                    b.push_back(0);
                }
            } else {
                for (int i = a.size(); i < b.size(); i++) {
                    a.push_back(0);
                }
            }
        }
        n = a.size();
    }

    FourierovRed(int n1, double t1, double f1(int), double f2(int)) {
        n = n1;
        t = t1;
        if (n1 <= 0) throw std::domain_error("Stepen mora biti pozitivan");
        a.resize(n);
        b.resize(n);
        for (int i = 0; i <= n; i++) {
            a[i] = f1(i);
            b[i] = f2(i);
        }
        b[0] = 0;
        for (int i = 1; i <= n; i++) {
            b[i] = f2(i);
        }
    }

    // Constructor with function evaluation
    FourierovRed(int n1, double p, double q, double f(double), int m) {
        n = n1;
        if (n1 <= 0) throw std::domain_error("Stepen mora biti pozitivan");
        if (m <= 0) throw std::domain_error("Broj podintervala mora biti pozitivan");
        if (p > q) throw std::range_error("Neispravan interval");
        t = (q - p) / m;

        a.resize(n);
        b.resize(n);
        for (int i = 0; i < n; i++) {
            double suma = 0;
            for (int j = 1; j <= m - 1; j++) {
                suma += f(p + j * t / m) * cos(2 * i * pi * (p / t + j / m));
            }
            a[i] = ((f(p) + f(q)) / m) * cos(n * i * pi * p / t) + 2 / m * suma;
            suma = 0;
            for (int j = 1; j <= m - 1; j++) {
                suma += f(p + j * t / m) * sin(2 * i * pi * (p / t + j / m));
            }
            b[i] = ((f(p) + f(q)) / m) * sin(n * i * pi * p / t) + 2 / m * suma;
        }
    }

    std::pair<double, double> operator[](int k) const {
        if (k < 0 or k > n - 1) throw std::range_error("Neispravan indeks");
        return std::make_pair(a[k], b[k]);
    }

    std::pair<double&, double&> operator[](int k) {
        if (k < 0 or k > n - 1) throw std::range_error("Neispravan indeks");
        return std::make_pair(std::ref(a[k]), std::ref(b[k]));
    }

    int operator()(double x) {
        double f = a[0] / 2;
        for (int i = 0; i < n; i++) {
            f += a[i] * cos(2 * i * pi * x / t) + b[i] * sin(2 * i * pi * x / t);
        }
        return f;
    }

    // Unused method 1
    void unusedMethod1() {
        std::cout << "Unused 1" << std::endl;
        double unusedVar1 = 0;
    }

    // Unused method 2
    void unusedMethod2() {
        std::cout << "Unused 2" << std::endl;
        int unusedVar2 = 0;
    }

    // Unused method 3
    void unusedMethod3() {
        std::cout << "Unused 3" << std::endl;
        std::vector<int> unusedVar3;
    }
};

int main() {
    FourierovRed f(2, {2, 1}, {});
    std::cout << f(5);
    
    // Unused variables in main
    double unusedVarMain1 = 0;
    std::string unusedVarMain2 = "Unused";
    std::vector<double> unusedVarMain3;
    
    return 0;
}