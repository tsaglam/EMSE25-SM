#include <iostream>
#include <vector>
#include <cmath>
#include <stdexcept>
#include <tuple>
#include <functional>

constexpr double PI = 3.14159265358979323846;

class FourierSeries {
private:
    double period;
    int degree;
    std::vector<double> coefficientsA;
    std::vector<double> coefficientsB;

public:
    FourierSeries(double t, std::initializer_list<double> a1, std::initializer_list<double> b1) 
        : period(t), coefficientsA(a1), coefficientsB(b1) {
        auto maxSize = std::max(coefficientsA.size(), coefficientsB.size());
        coefficientsA.resize(maxSize, 0.0);
        coefficientsB.resize(maxSize, 0.0);
        degree = coefficientsA.size();
    }

    FourierSeries(int n1, double t1, double f1(int), double f2(int)) {
        if (n1 <= 0) throw std::domain_error("Degree must be positive");
        degree = n1;
        period = t1;
        coefficientsA = std::vector<double>(n1);
        coefficientsB = std::vector<double>(n1, 0); // Initialize all with 0;

        for (int i = 0; i <= n1; ++i) {
            coefficientsA[i] = f1(i);
            coefficientsB[i] = f2(i);
        }
    }

    FourierSeries(int n1, double p, double q, double f(double), int m) {
        if (n1 <= 0 || m <= 0) throw std::domain_error("Degree and subinterval count must be positive");
        if (p > q) throw std::range_error("Invalid interval");
        degree = n1;
        coefficientsA.resize(n1);
        coefficientsB.resize(n1);

        for (int i = 0; i < n1; ++i) {
            double sumA = 0.0, sumB = 0.0;
            for (int j = 1; j <= m - 1; ++j) {
                sumA += f(p + j * period / m) * std::cos(2 * i * PI * (p / period + j / m));
                sumB += f(p + j * period / m) * std::sin(2 * i * PI * (p / period + j / m));
            }
            coefficientsA[i] = ((f(p) + f(q)) / m) * std::cos(i * PI * p / period) + 2 / m * sumA;
            coefficientsB[i] = ((f(p) + f(q)) / m) * std::sin(i * PI * p / period) + 2 / m * sumB;
        }
    }

    std::pair<double, double> operator[](int k) const {
        if (k < 0 || k >= degree) throw std::range_error("Invalid index");
        return {coefficientsA[k], coefficientsB[k]};
    }

    std::pair<double&, double&> operator[](int k) {
        if (k < 0 || k >= degree) throw std::range_error("Invalid index");
        return {coefficientsA[k], coefficientsB[k]};
    }

    double operator()(double x) const {
        double result = coefficientsA[0] / 2.0;
        for (int i = 1; i < degree; ++i) {
            result += coefficientsA[i] * std::cos(2 * i * PI * x / period) + coefficientsB[i] * std::sin(2 * i * PI * x / period);
        }
        return result;
    }
};

int main() {
    FourierSeries f(2, {2, 1}, {});
    std::cout << f(5);

    return 0;
}