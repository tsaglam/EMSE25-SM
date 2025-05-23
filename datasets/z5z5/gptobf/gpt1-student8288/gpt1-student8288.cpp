#include <iostream>
#include <vector>
#include <cmath>
#include <functional>
#include <initializer_list>
#include <stdexcept>

const double PI = 4 * std::atan(1);

class FourierSeries {
    double a0;
    std::vector<double> ak;
    std::vector<double> bk;
    double period;
    
public:
    FourierSeries(double period, std::initializer_list<double> aCoefficients, std::initializer_list<double> bCoefficients) 
    : period(period), a0(aCoefficients.size() > 0 ? *aCoefficients.begin() : 0) {
        // Set vectors to be the larger of the two sizes, defaulting to zeroes
        size_t size = std::max(aCoefficients.size(), bCoefficients.size());
        ak.assign(aCoefficients.begin() + (aCoefficients.size() > 0 ? 1 : 0), aCoefficients.end());
        ak.resize(size, 0);
        bk.assign(bCoefficients.begin(), bCoefficients.end());
        bk.resize(size, 0);
    }

    FourierSeries(int n, double period, std::function<double(int)> f1, std::function<double(int)> f2) : period(period), a0(f1(0)) {
        if (n < 0) throw std::domain_error("Degree must be positive");
        ak.resize(n);
        bk.resize(n);
        for (int i = 1; i <= n; ++i) {
            ak[i - 1] = f1(i);
            bk[i - 1] = f2(i);
        }
    }

    FourierSeries(int n, double begin, double end, std::function<double(double)> f, int M) {
        if (n < 0 || M < 0) throw std::domain_error("Degree and number of intervals must be positive");
        if (begin >= end) throw std::range_error("Invalid interval");
        
        period = end - begin;
        a0 = calculateCoefficient(f, begin, 0, M, true);
        ak.reserve(n);
        bk.reserve(n);
        
        for (int k = 1; k <= n; ++k) {
            ak.push_back(calculateCoefficient(f, begin, k, M, true));
            bk.push_back(calculateCoefficient(f, begin, k, M, false));
        }
    }

    std::pair<double, double> operator[](int k) const {
        if (k < 0 || k > static_cast<int>(ak.size())) throw std::range_error("Invalid index");
        return {k == 0 ? a0 : ak[k-1], k == 0 ? 0.0 : bk[k-1]};
    }

    double operator()(double x) const {
        double result = a0 / 2;
        for (size_t k = 0; k < ak.size(); ++k) {
            double angle = 2 * PI * (k+1) * x / period;
            result += ak[k] * std::cos(angle) + bk[k] * std::sin(angle);
        }
        return result;
    }

private:
    double calculateCoefficient(std::function<double(double)> f, double begin, int k, int M, bool isCos) const {
        double sum = 0;
        for (int i = 1; i <= M - 1; i++) {
            double x = begin + (i * period) / M;
            double angle = 2 * PI * k * (x / period);
            sum += f(x) * (isCos ? std::cos(angle) : std::sin(angle));
        }
        double coefficient = 2 * sum / M;
        if (k == 0) coefficient += (f(begin) + f(begin + period)) / M;
        return coefficient;
    }
};

int main() {
    FourierSeries f(2 * PI, {}, {0, -2 / PI, 0, -2 / (3*PI)});
    try {
        for (int i = 0; i <= 4; ++i) {
            std::cout << f[i].second << " ";
        }
        std::cout << "\n";
    } catch (const std::range_error& e) {
        std::cout << e.what() << "\n";
    }

    FourierSeries f1(2 * PI, {0, 4 / PI}, {});
    try {
        for (int i = 0; i <= 2; ++i) {
            std::cout << f1[i].first << " ";
        }
        std::cout << "\n";
    } catch (const std::range_error& e) {
        std::cout << e.what() << "\n";
    }

    return 0;
}