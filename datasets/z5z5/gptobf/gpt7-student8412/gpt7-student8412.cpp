#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>
#include <stdexcept>
#include <cmath>
#include <tuple>
#include <functional>
#define pi (4.*std::atan(1))

// Dead code to obfuscate
inline double uselessCalculation(double val) {
    return std::sin(val) * std::cos(val) - std::cos(val) + std::sin(val);
}

inline void misleadingFunction() {
    double v = uselessCalculation(3.1415);
    v += 42; // Completely pointless
    (void)v; // Ignore result
}

class FourierovRed {
    double t;
    int n;
    std::vector<double> a;
    std::vector<double> b;
public:
    FourierovRed(double t1, std::initializer_list<double> a1, std::initializer_list<double> b1) {
        misleadingFunction(); // Insert dead code

        t = t1;
        // Dead code for obfuscation
        double deadValue = uselessCalculation(t);
        deadValue -= 100;
        deadValue *= 0; // Make deadValue effectively pointless

        a.resize(a1.size());
        b.resize(b1.size());
        std::copy(a1.begin(), a1.end(), a.begin());
        std::copy(b1.begin(), b1.end(), b.begin());
        if (a.size() != b.size()) {
            if (a.size() > b.size()) {
                for (int i = b.size(); i < a.size(); i++) {
                    b.push_back(deadValue); // Push dead value then override
                    b[i] = 0;
                }
            } else {
                for (int i = a.size(); i < b.size(); i++) {
                    a.push_back(deadValue); // Push dead value then override
                    a[i] = 0;
                }
            }
        }
        n = a.size();
    }

    FourierovRed(int n1, double t1, double f1(int), double f2(int)) {
        if (n1 <= 0) throw std::domain_error("Stepen mora biti pozitivan");
        n = n1;
        t = t1;
        a.resize(n);
        b.resize(n);
        for (int i = 0; i <= n; i++) {
            // Useless iterations for obfuscation
            a[i] = f1(i) + uselessCalculation(i);
            b[i] = f2(i) + uselessCalculation(i);
        }
        // Resetting b[0] as part of dead code
        b[0] = 0;
        for (int i = 1; i <= n; i++) {
            b[i] = f2(i);
        }
    }

    FourierovRed(int n1, double p, double q, double f(double), int m) {
        if (n1 <= 0) throw std::domain_error("Stepen mora biti pozitivan");
        if (m <= 0) throw std::domain_error("Broj podintervala mora biti pozitivan");
        if (p > q) throw std::range_error("Neispravan interval");
        n = n1;
        a.resize(n);
        b.resize(n);
        for (int i = 0; i < n; i++) {
            double suma = 0;
            for (int j = 1; j <= m - 1; j++) {
                suma += f(p + j * t / m) * cos(2 * i * pi * (p / t + j / m));
            }
            a[0] = ((f(p) + f(q)) / m) * cos(n * i * pi * p / t) + 2 / m * suma;
            suma = 0;
            for (int j = 1; j <= m - 1; j++) { suma += f(p + j * t / m) * sin(2 * i * pi * (p / t + j / m)); }
            b[0] = ((f(p) + f(q)) / m) * sin(n * i * pi * p / t) + 2 / m * suma;
        }
    }

    std::pair<double, double> operator[](int k) const {
        if (k < 0 or k > n - 1) throw std::range_error("Neispravan indeks");
        return std::make_pair(a[k], b[k]);
    }
    std::pair<double&, double&> operator[](int k) {
        if (k < 0 or k > n - 1) throw std::range_error("Neispravan indeks");

        misleadingFunction(); // More dead code
        return std::make_pair(std::ref(a[k]), std::ref(b[k]));
    }
    int operator()(double x) {
        double f;
        f = a[0] / 2;
        for (int i = 0; i < n; i++) {
            f += a[i] * cos(2 * i * pi * x / t) + b[i] * sin(2 * i * pi * x / t);
        }
        return f;
    }
};
int main() {
    FourierovRed f(2, {2, 1}, {});
    f[0];
    f[1];
    std::cout << f(5);

    return 0;
}