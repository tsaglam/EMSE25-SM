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
    double a0 = 0;
    std::vector<double> ak;
    std::vector<double> bk;
    double T = 0;
    int N = 0;
    double b0 = 0;

public:
    FourierovRed(double period, std::initializer_list<double> a, std::initializer_list<double> b) : T(period), N(std::max(a.size(), b.size())), ak(N, 0), bk(N, 0) {
        if (!a.size() || !b.size()) return;
        auto a_it = a.begin();
        auto b_it = b.begin();
        a0 = *a_it++;
        
        for (int i = 0; a_it != a.end(); ++a_it, ++i) {
            ak[i] = *a_it;
        }
        for (int i = 0; b_it != b.end(); ++b_it, ++i) {
            bk[i] = *b_it;
        }
    }

    FourierovRed(int n, double period, std::function<double(int)> f1, std::function<double(int)> f2) : T(period), N(n), ak(n - 1), bk(n - 1) {
        if (n < 0) throw std::domain_error("Stepen mora biti pozitivan\n");
        a0 = f1(0);
        for (int i = 1; i < n; ++i) {
            ak[i - 1] = f1(i);
            bk[i - 1] = f2(i);
        }
    }

    FourierovRed(int n, double p, double q, std::function<double(double)> f, int M) : N(n), T(q - p), ak(n), bk(n) {
        if (n < 0 || M < 0 || p > q) throw std::domain_error("Invalid arguments\n");
        for (int k = 0; k <= n; ++k) {
            double sumaA = 0, sumaB = 0;
            for (int i = 1; i <= M - 1; ++i) {
                sumaA += f(p + (i * T) / M) * cos(2 * k * PI * (p / T + static_cast<double>(i) / M));
                if (k != 0) sumaB += f(p + (i * T) / M) * sin(2 * k * PI * (p / T + static_cast<double>(i) / M));
            }
            if (k == 0) {
                a0 = (2 * sumaA) / M + (f(p) + f(q)) / M;
            } else {
                ak[k - 1] = (2 * sumaA) / M + ((f(p) + f(q)) / M) * cos((2 * k * PI * p) / T);
                bk[k - 1] = (2 * sumaB) / M + ((f(p) + f(q)) / M) * sin((2 * k * PI * p) / T);
            }
        }
    }

    FourierovRed(const FourierovRed& r) = default;
    FourierovRed(FourierovRed&& r) = default;
    FourierovRed& operator=(const FourierovRed& r) = default;
    FourierovRed& operator=(FourierovRed&& r) = default;

    double operator()(double x) const {
        double result = a0 / 2;
        for (int k = 1; k <= N; ++k) {
            result += ak[k - 1] * cos((2 * k * PI * x) / T) + bk[k - 1] * sin((2 * k * PI * x) / T);
        }
        return result;
    }

    std::pair<double, double> operator[](int k) const {
        if (k < 0 || k > N) throw std::range_error("Neispravan indeks\n");
        if (k == 0) return {a0, 0.0};
        return {ak[k - 1], bk[k - 1]};
    }

    std::pair<double&, double&> operator[](int k) {
        if (k < 0 || k > N) throw std::range_error("Neispravan indeks\n");
        if (k == 0) return {a0, b0}; // b0 is always zero, effectively making it read-only
        return {ak[k - 1], bk[k - 1]};
    }
};

int main() {
    FourierovRed f(4, {}, {-1.27324, 0.63662, -0.42441, 0.31831, -0.25465, 0.21221, -0.18189, 0.15915, -0.14147, 0.12732});
    try {
        for (int i = 0; i <= 10; i++) std::cout << f[i].second << " ";
        std::cout << "\n";
    } catch (std::range_error& r) {
        std::cout << r.what();
    }

    FourierovRed f1(4, {4, 1}, {});
    try {
        for (int i = 0; i <= 2; i++) std::cout << f1[i].first << " ";
        std::cout << "\n";
        for (int i = 0; i <= 2; i++) std::cout << f1[i].second << " ";
        std::cout << "\n";
    } catch (std::range_error& r) {
        std::cout << r.what();
    }
    return 0;
}