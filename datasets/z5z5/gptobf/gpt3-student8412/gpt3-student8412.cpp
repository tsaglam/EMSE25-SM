#include <iostream>
#include <vector>
#include <utility>
#include <cmath>
#include <stdexcept> // Reordered includes for clarity, removed unused includes

const double pi = 4.0 * atan(1.0); // Using a const variable instead of define

class FourierovRed {
private: // Explicitly declaring private section for clarity
    double t;
    int n;
    std::vector<double> a, b; // Combining declaration of a and b

public:
    FourierovRed(double t1, std::initializer_list<double> a1, std::initializer_list<double> b1)
        : t(t1), a(a1), b(b1) { // Using member initializer list
        // Resize b vector to match a if necessary, filling with zeroes
        b.resize(a.size(), 0);
        // Resize a vector to match b if necessary, filling with zeroes
        a.resize(b.size(), 0);
        n = a.size();
    }

    FourierovRed(int n1, double t1, double (*f1)(int), double (*f2)(int)) {
        if (n1 <= 0) throw std::domain_error("Stepen mora biti pozitivan");
        n = n1;
        t = t1;
        a.resize(n);
        b.resize(n);
        for (int i = 0; i < n; ++i) { // Adjusting loop to 0-based index
            a[i] = f1(i);
            b[i] = f2(i);
        }
        b[0] = 0; // This seems redundant as b[i] is assigned in the loop
    }

    FourierovRed(int n1, double p, double q, double (*f)(double), int m) {
        if (n1 <= 0 || m <= 0) throw std::domain_error("Stepen i broj podintervala moraju biti pozitivni");
        if (p > q) throw std::range_error("Neispravan interval");
        n = n1;
        t = q - p; // Assuming t should be the length of the interval
        a.resize(n);
        b.resize(n);
        for (int i = 0; i < n; ++i) {
            double suma_cos = 0, suma_sin = 0;
            for (int j = 1; j <= m - 1; ++j) {
                double x = p + j * t / m;
                suma_cos += f(x) * cos(2 * i * pi * x / t);
                suma_sin += f(x) * sin(2 * i * pi * x / t);
            }
            a[i] = ((f(p) + f(q)) / m) * cos(i * pi) + 2 / m * suma_cos;
            b[i] = ((f(p) + f(q)) / m) * sin(i * pi) + 2 / m * suma_sin;
        }
    }

    std::pair<double, double> operator[](int k) const {
        if (k < 0 || k >= n) throw std::range_error("Neispravan indeks");
        return {a[k], b[k]};
    }

    std::pair<double&, double&> operator[](int k) {
        if (k < 0 || k >= n) throw std::range_error("Neispravan indeks");
        return {a[k], b[k]};
    }

    double operator()(double x) const {
        double f = a[0] / 2.0;
        for (int i = 1; i < n; ++i) { // Start from 1 as the 0th term is already considered
            f += a[i] * cos(2 * i * pi * x / t) + b[i] * sin(2 * i * pi * x / t);
        }
        return f;
    }
};

int main() {
    FourierovRed f(2, {2, 1}, {});
    // Removed unused [] operator calls
    std::cout << f(5) << std::endl;

    return 0;
}