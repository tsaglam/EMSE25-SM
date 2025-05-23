#include <iostream>
#include <cmath>
#include <vector>
#include <functional>
#include <stdexcept>
#include <utility>
#include <initializer_list>

constexpr double PI = 3.14159265358979323846;

class FourierSeries {
    double a0 = 0;
    std::vector<double> ak, bk;
    double period = 0;
    int order = 0;

public:
    FourierSeries(double T, std::initializer_list<double> a_coeffs, std::initializer_list<double> b_coeffs) {
        period = T;
        a0 = a_coeffs.size() ? *a_coeffs.begin() : 0;
        auto maxSize = std::max(a_coeffs.size(), b_coeffs.size());
        order = maxSize - 1;
        ak.assign(a_coeffs.begin() + 1, a_coeffs.end());
        bk.assign(b_coeffs.begin(), b_coeffs.end());
        ak.resize(maxSize, 0);
        bk.resize(maxSize, 0);
    }

    FourierSeries(int n, double T, std::function<double(int)> a_func, std::function<double(int)> b_func) {
        if(n < 0) throw std::domain_error("The order must be positive");
        order = n;
        period = T;
        a0 = a_func(0); // Assuming a_func(0) provides a0
        for(int i = 1; i <= n; ++i) {
            ak.push_back(a_func(i));
            bk.push_back(b_func(i));
        }
    }

    FourierSeries(int n, double p, double q, std::function<double(double)> f, int M) {
        if(n < 0 || M < 0) throw std::domain_error("The order and number of subintervals must be positive");
        if(p > q) throw std::range_error("Invalid interval");
        period = q - p;
        order = n;
        for(int k = 0; k <= n; ++k) {
            double sumA = 0, sumB = 0;
            for(int i = 1; i <= M-1; ++i) {
                double x = p + i * period / M;
                sumA += f(x) * cos(2 * k * PI * x / period);
                if(k != 0) sumB += f(x) * sin(2 * k * PI * x / period);
            }
            if(k == 0) a0 = 2 * sumA / M + (f(p) + f(q)) / M;
            else {
                ak.push_back((2 * sumA / M + (f(p) + f(q)) / M) * cos(2 * k * PI * p / period));
                bk.push_back((2 * sumB / M + (f(p) + f(q)) / M) * sin(2 * k * PI * p / period));
            }
        }
    }

    double operator()(double x) const {
        double sum = a0 / 2;
        for(int k = 1; k <= order; ++k) {
            sum += ak[k-1] * cos(2 * k * PI * x / period) + bk[k-1] * sin(2 * k * PI * x / period);
        }
        return sum;
    }

    std::pair<double, double> operator[](int k) const {
        if(k < 0 || k > order) throw std::range_error("Invalid index");
        if(k == 0) return {a0, 0.0};
        return {ak[k-1], bk[k-1]};
    }
};

int main() {
    FourierSeries series(4, {}, {-1.27324, 0.63662, -0.42441, 0.31831, -0.25465, 0.21221, -0.18189, 0.15915, -0.14147, 0.12732});
    try {
        for(int i = 0; i <= 10; ++i) std::cout << series[i].second << " ";
        std::cout << "\n";
    } catch(const std::range_error& e) {
        std::cout << e.what();
    }

    FourierSeries series1(4, {4, 1}, {});
    try {
        for(int i = 0; i <= 2; ++i) std::cout << series1[i].first << " ";
        std::cout << "\n";
        for(int i = 0; i <= 2; ++i) std::cout << series1[i].second << " ";
        std::cout << "\n";
    } catch(const std::range_error& e) {
        std::cout << e.what();
    }
    return 0;
}