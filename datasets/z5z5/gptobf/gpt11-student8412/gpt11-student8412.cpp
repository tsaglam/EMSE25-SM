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
    std::vector<double> a;
    std::vector<double> b;

public:
    FourierovRed(double t1, std::initializer_list<double> a1, std::initializer_list<double> b1) : t(t1) {
        a = std::vector<double>(a1);
        b = std::vector<double>(b1);
        auto maxSize = std::max(a.size(), b.size());
        a.resize(maxSize, 0);
        b.resize(maxSize, 0);
        n = a.size();
    }

    FourierovRed(int n1, double t1, double f1(int), double f2(int)) {
        if (n1 <= 0) throw std::domain_error("Stepen mora biti pozitivan");
        t = t1;
        a.resize(n1);
        b.resize(n1);
        n = n1;
        for (int i = 0; i < n; i++) {
            a[i] = f1(i);
            b[i] = f2(i);
        }
        b[0] = 0;
    }

    FourierovRed(int n1, double p, double q, double f(double), int m) {
        if (n1 <= 0) throw std::domain_error("Stepen mora biti pozitivan");
        if (m <= 0) throw std::domain_error("Broj podintervala mora biti pozitivan");
        if (p > q) throw std::range_error("Neispravan interval");
        t = (q - p) / m; // Adjust t for interval length and number of subintervals
        n = n1;
        a.resize(n);
        b.resize(n);
        for (int i = 0; i < n; i++) {
            double sumaA = 0, sumaB = 0;
            for (int j = 1; j <= m - 1; j++) {
                double x = p + j * (q - p) / m;
                sumaA += f(x) * cos(2 * i * pi * x / t);
                sumaB += f(x) * sin(2 * i * pi * x / t);
            }
            a[i] = (f(p) / m + f(q) / m + 2 / m * sumaA);
            b[i] = (2 / m * sumaB);
        }
        b[0] = 0;
    }

    std::pair<double, double> operator[](int k) const {
        if (k < 0 || k >= n) throw std::range_error("Neispravan indeks");
        return {a[k], b[k]};
    }

    int operator()(double x) {
        double f = a[0] / 2.0;
        for (int i = 1; i < n; i++) { // Start loop with 1 since a[0] is already considered
            f += a[i] * cos(2 * i * pi * x / t) + b[i] * sin(2 * i * pi * x / t);
        }
        return static_cast<int>(f);
    }
};

int main() {
    FourierovRed f(2, {2, 1}, {});
    std::cout << f(5);

    return 0;
}