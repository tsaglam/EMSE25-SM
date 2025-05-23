#include <iostream>
#include <cmath>
#include <vector>
#include <functional>
#include <stdexcept>
#include <utility>
#include <initializer_list>

const double PI = 4 * std::atan(1.0);

class FourierovRed {
    double a0;
    std::vector<double> ak, bk;
    double T;
    int N;

public:
    FourierovRed(double period, std::initializer_list<double> a, std::initializer_list<double> b) : T(period), N(std::max(a.size(), b.size())) {
        if (!a.size() && !b.size()) throw std::range_error("Lists cannot both be empty.");
        a0 = *(a.begin());
        ak = std::vector<double>(a.begin() + 1, a.end());
        ak.resize(N - 1, 0.0); // Ensure proper size
        bk = std::vector<double>(b.begin(), b.end());
        bk.resize(N - 1, 0.0); // Ensure proper size
    }

    FourierovRed(int n, double period, std::function<double(int)> f1, std::function<double(int)> f2) : T(period), N(n) {
        if (n < 0) throw std::domain_error("Degree must be positive.");
        a0 = f1(0);
        for (int i = 1; i <= n; ++i) {
            ak.push_back(f1(i));
            bk.push_back(f2(i));
        }
    }

    FourierovRed(int n, double p, double q, std::function<double(double)> f, int M) {
        if(n < 0 || M <= 0 || p > q) throw std::domain_error("Invalid input parameters.");
        T = q - p;
        N = n;
        a0 = calculateCoefficient(f, p, M, 0, true);
        for (int k = 1; k <= n; ++k) {
            ak.push_back(calculateCoefficient(f, p, M, k, true));
            bk.push_back(calculateCoefficient(f, p, M, k, false));
        }
    }

    // Copy constructor
    FourierovRed(const FourierovRed& r) = default;

    // Move constructor
    FourierovRed(FourierovRed&& r) = default;
    
    // Copy assignment
    FourierovRed& operator=(const FourierovRed& r) = default;

    // Move assignment
    FourierovRed& operator=(FourierovRed&& r) = default;

    double operator()(double x) const {
        double result = a0 / 2.0;
        for (int i = 0; i < N - 1; ++i) {
            result += ak[i] * std::cos((2 * (i+1) * PI * x) / T) + bk[i] * std::sin((2 * (i+1) * PI * x) / T);
        }
        return result;
    }

    std::pair<double, double> operator[](int k) const {
        if(k < 0 || k > N) throw std::range_error("Invalid index.");
        if(k == 0) return std::make_pair(a0, 0.0);
        return {ak[k-1], bk[k-1]};
    }

private:
    double calculateCoefficient(std::function<double(double)> f, double p, int M, int k, bool isCosine) {
        double sum = 0.0;
        double delta = T / M;

        for (int i = 1; i < M; ++i) {
            double x = p + i * delta;
            sum += f(x) * (isCosine ? std::cos(2 * k * PI * x / T) : std::sin(2 * k * PI * x / T));
        }

        sum *= 2.0 / M;
        sum += (f(p) + f(p + T)) * delta / 2.0; // Trapezoidal rule for the first and last terms

        return sum;
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