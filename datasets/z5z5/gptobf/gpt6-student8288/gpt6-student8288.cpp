#include <iostream>
#include <vector>
#include <cmath>
#include <functional>
#include <stdexcept>
#include <utility>

const double PI = std::atan(1) * 4;

class FourierSeries {
    std::vector<double> aCoeffs, bCoeffs;
    double a0;
    double period;
    
public:
    FourierSeries(double T, std::initializer_list<double> aCoeffList, std::initializer_list<double> bCoeffList) 
    : aCoeffs(aCoeffList), bCoeffs(bCoeffList), period(T) {
        if (!aCoeffs.empty()) {
            a0 = aCoeffs[0];
            aCoeffs.erase(aCoeffs.begin());
        } else {
            a0 = 0;
        }
        // Ensure both coefficient lists have the same size by padding with zeros
        while (aCoeffs.size() < bCoeffs.size()) aCoeffs.push_back(0);
        while (bCoeffs.size() < aCoeffs.size()) bCoeffs.push_back(0);
    }

    FourierSeries(int n, double T, std::function<double(int)> aFunc, std::function<double(int)> bFunc) : period(T), a0(aFunc(0)) {
        if (n < 0) throw std::domain_error("Degree must be positive");
        for (int i = 1; i <= n; ++i) {
            aCoeffs.push_back(aFunc(i));
            bCoeffs.push_back(bFunc(i));
        }
    }

    FourierSeries(int n, double from, double to, std::function<double(double)> func, int subdivisions) {
        if (n < 0 || subdivisions <= 0 || from >= to) throw std::domain_error("Invalid parameters");
        period = to - from;
        double delta = period / subdivisions;
        a0 = integrate(func, from, to, subdivisions, 0, delta, true);
        for (int k = 1; k <= n; ++k) {
            aCoeffs.push_back(integrate(func, from, to, subdivisions, k, delta, true));
            bCoeffs.push_back(integrate(func, from, to, subdivisions, k, delta, false));
        }
    }

    double operator()(double x) const {
        double sum = a0 / 2.0;
        for (size_t i = 0; i < aCoeffs.size(); ++i) {
            sum += aCoeffs[i] * cos(2 * PI * (i+1) * x / period) + bCoeffs[i] * sin(2 * PI * (i+1) * x / period);
        }
        return sum;
    }

    std::pair<double, double> operator[](int k) const {
        if (k < 0 || k > static_cast<int>(aCoeffs.size())) throw std::range_error("Invalid index");
        if (k == 0) return {a0, 0};
        return {aCoeffs[k-1], bCoeffs[k-1]};
    }

private:
    double integrate(std::function<double(double)> f, double a, double b, int n, int k, double delta, bool isCos) const {
        double sum = 0.0;
        for (int i = 1; i <= n; ++i) {
            double x = a + i * delta;
            double cosFactor = cos(2 * PI * k * x / period);
            double sinFactor = sin(2 * PI * k * x / period);
            sum += f(x) * (isCos ? cosFactor : sinFactor);
        }
        return (2.0 / n) * sum;
    }
};

int main() {
    // Example usage similar to the original provided code
    FourierSeries series(2 * PI, {0, 1, 2}, {0, -1, -2});
    std::cout << series(PI / 4) << std::endl;

    try {
        for (int i = 0; i <= 3; ++i) {
            auto coeffs = series[i];
            std::cout << "a" << i << ": " << coeffs.first << ", b" << i << ": " << coeffs.second << std::endl;
        }
    } catch (std::range_error& e) {
        std::cout << e.what() << std::endl;
    }

    return 0;
}