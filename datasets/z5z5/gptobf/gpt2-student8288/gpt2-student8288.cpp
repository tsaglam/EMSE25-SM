#include <iostream>
#include <vector>
#include <cmath>
#include <functional>
#include <stdexcept>
#include <utility>

const double PI = 4 * std::atan(1);

class FourierovRed {
    double a0 = 0;
    std::vector<double> ak, bk;
    double T;
    int N;

  public:
    FourierovRed(double period, std::initializer_list<double> a, std::initializer_list<double> b)
    : T(period), N(std::max(a.size(), b.size())) {
        a0 = a.size() > 0 ? *a.begin() : 0;
        ak.assign(a.begin()+1, a.end());
        ak.resize(N, 0); // Ensures ak has size N, filling with 0s if needed
        bk.assign(b.begin(), b.end());
        bk.resize(N, 0); // Ensures bk has size N, filling with 0s if needed
    }

    FourierovRed(int n, double period, std::function<double(int)> f1, std::function<double(int)> f2)
    : a0(f1(0)), T(period), N(n) {
        if (n < 0) throw std::domain_error("Stepen mora biti pozitivan");
        for (int i = 1; i <= n; ++i) {
            ak.push_back(f1(i));
            bk.push_back(f2(i));
        }
    }

    // Constructor for generating a Fourier series from a function over an interval with M divisions
    FourierovRed(int n, double p, double q, std::function<double(double)> f, int M)
    : N(n), T(q - p) {
        if (n < 0 || M < 0 || p > q) throw std::logic_error("Invalid arguments");
        for (int k = 0; k <= n; ++k) {
            double sumaA = 0, sumaB = 0;
            for (int i = 1; i <= M - 1; ++i) {
                double x = p + (i * T) / M;
                sumaA += f(x) * cos(2 * k * PI * x / T);
                if (k != 0) sumaB += f(x) * sin(2 * k * PI * x / T);
            }
            if (k == 0) a0 = (2 * sumaA) / M + (f(p) + f(q)) / M;
            else {
                ak.push_back((2 * sumaA) / M + ((f(p) + f(q)) / M) * cos(2 * k * PI * p / T));
                bk.push_back((2 * sumaB) / M + ((f(p) + f(q)) / M) * sin(2 * k * PI * p / T));
            }
        }
    }

    double operator()(double x) {
        double result = a0 / 2;
        for (int k = 1; k <= N; ++k) {
            result += ak[k - 1] * std::cos((2 * k * PI * x) / T) + bk[k - 1] * std::sin((2 * k * PI * x) / T);
        }
        return result;
    }

    std::pair<double, double> operator[](int k) const {
        if (k < 0 || k > N) throw std::range_error("Neispravan indeks");
        return k == 0 ? std::make_pair(a0, 0.0) : std::make_pair(ak[k - 1], bk[k - 1]);
    }
};

int main() {
    FourierovRed f(4, {}, {-1.27324, 0.63662, -0.42441, 0.31831, -0.25465, 0.21221, -0.18189, 0.15915, -0.14147, 0.12732});
    try {
        for (int i = 0; i <= 10; ++i) {
            std::cout << f[i].second << " ";
        }
        std::cout << "\n";
    } catch (const std::exception& e) {
        std::cout << e.what() << "\n";
    }
    
    FourierovRed f1(4, {4, 1}, {});
    try {
        for (int i = 0; i <= 2; ++i) {
            std::cout << f1[i].first << " ";
        }
        std::cout << "\n";
        for (int i = 0; i <= 2; ++i) {
            std::cout << f1[i].second << " ";
        }
        std::cout << "\n";
    } catch (const std::exception& e) {
        std::cout << e.what() << "\n";
    }
    return 0;
}