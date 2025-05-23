#include <iostream>
#include <stdexcept>
#include <vector>
#include <initializer_list>
#include <utility>
#include <functional>
#include <cmath>

class FourierovRed {
    double period;
    int stepen;
    std::vector<double> ak, bk;

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
};

std::pair<double, double> FourierovRed::operator[](int k) const {
    if (k < 0 || k > stepen) throw std::range_error("Neispravan indeks");
    if (k == 0) return {ak[0], 0.0};
    return {ak[k], bk[k-1]};
}

std::pair<double&, double&> FourierovRed::operator[](int k) {
    static double nula = 0.0; // Better handled within function scope
    if (k < 0 || k > stepen) throw std::range_error("Neispravan indeks");
    if (k == 0) return {ak[0], nula};
    return {ak[k], bk[k-1]};
}

double FourierovRed::operator()(double x) const {
    double vrati = ak[0] / 2.0;
    for (int i = 1; i <= stepen; ++i)
        vrati += ak[i] * cos(2 * i * M_PI * x / period);
    for (int i = 0; i < stepen; ++i)
        vrati += bk[i] * sin(2 * (i + 1) * M_PI * x / period);
    return vrati;
}

// Constructors' and other members' implementations are omitted for brevity
// but should follow similar efficiency and style updates as shown above

int main() {
    // Main logic remains the same. Aim to use clear and concise I/O operations.
    // Make sure to handle exceptions and edge cases as before.
    return 0;
}