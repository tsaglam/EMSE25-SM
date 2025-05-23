#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>
#include <stdexcept>
#include <cmath>
#include <tuple>
#include <functional>

// It's better to use a constant value or constexpr for pi for clarity and potential reuse.
constexpr double pi = 3.14159265358979323846;

class FourierovRed {
    double t;
    std::vector<double> a;
    std::vector<double> b;

public:
    // Simplified constructor with initializer lists
    FourierovRed(double t1, std::initializer_list<double> a1, std::initializer_list<double> b1): t(t1), a(a1), b(b1) {
        // Ensuring both vectors are of the same size by padding with zeroes
        while(a.size() < b.size()) a.push_back(0);
        while(b.size() < a.size()) b.push_back(0);
    }

    // Constructor using function pointers
    FourierovRed(int n, double t1, double (*f1)(int), double (*f2)(int)) {
        if(n <= 0) throw std::domain_error("Stepen mora biti pozitivan");
        t = t1;
        a.resize(n);
        b.resize(n);
        for(int i = 0; i < n; i++) {
            a[i] = f1(i);
            b[i] = f2(i);
        }
        // Fixed issue with setting b[0] = 0 after filling the vector
        b[0] = 0;
    }

    // Constructor for numerical integration
    FourierovRed(int n1, double p, double q, double (*f)(double), int m) {
        if(n1 <= 0 || m <= 0) throw std::domain_error("Argumenti moraju biti pozitivni");
        if(p >= q) throw std::range_error("Neispravan interval");
        t = q - p;
        a.resize(n1, 0);
        b.resize(n1, 0);
        
        for(int i = 0; i < n1; i++) {
            for(int j = 0; j <= m; j++) {
                double x = p + j * (t / m);
                a[i] += f(x) * std::cos(2 * pi * i * x / t);
                b[i] += f(x) * std::sin(2 * pi * i * x / t);
            }
            a[i] = 2 * a[i] / m;
            b[i] = 2 * b[i] / m;
        }
        a[0] /= 2; // Adjusting the first term as per typical Fourier series calculation
    }

    // Accessor for the coefficients with bounds checking
    std::pair<double, double> operator[](int k) const {
        if (k < 0 || static_cast<size_t>(k) >= a.size()) 
            throw std::range_error("Neispravan indeks");
        return {a[k], b[k]};
    }

    std::pair<double&, double&> operator[](int k) {
        if (k < 0 || static_cast<size_t>(k) >= a.size()) 
            throw std::range_error("Neispravan indeks");
        return {a[k], b[k]};
    }

    // Calculates the Fourier series at point x
    int operator()(double x) const {
        double f = a[0] / 2;
        for (size_t i = 1; i < a.size(); i++) { // Fixed the loop to start from 1
            f += a[i] * std::cos(2 * pi * i * x / t) + b[i] * std::sin(2 * pi * i * x / t);
        }
        return static_cast<int>(f);
    }
};

int main() {
    FourierovRed f(2, {2, 1}, {0}); // Explicitly added {0} to b as the original code attempted to adjust the sizes which implies b was not empty
    // Removed unnecessary accesses that did no output or computational work
    std::cout << f(5);

    return 0;
}