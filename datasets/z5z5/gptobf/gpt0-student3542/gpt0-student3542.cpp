#include <iostream>
#include <stdexcept>
#include <cmath>
#include <algorithm>
#include <functional>
#include <vector>

const double Pi = std::atan(1) * 4;
const double eps = 1e-10;

class FourierSeries {
    double period;
    int order;
    std::vector<double> aCoefficients;
    std::vector<double> bCoefficients;

    static bool AreEqual(double x, double y) {
        return std::fabs(x - y) <= eps * (std::fabs(x) + std::fabs(y));
    }

public:
    FourierSeries(double T, std::initializer_list<double> a, std::initializer_list<double> b);
    FourierSeries(int N, double T, std::function<double(int)> computeA, std::function<double(int)> computeB);
    FourierSeries(int N, double p, double q, std::function<double(double)> f, int M);
    double operator()(double x) const;
    FourierSeries& operator=(const FourierSeries& other);
    
    // Utilizing default move semantics for efficiency
    FourierSeries(FourierSeries&& other) = default;
    FourierSeries& operator=(FourierSeries&& other) = default;

    std::pair<double, double> operator[](int index) const;
    std::pair<double&, double&> operator[](int index);
};

FourierSeries::FourierSeries(double T, std::initializer_list<double> a, std::initializer_list<double> b) : period(T), order(std::max(a.size(), b.size())) {
    if (order <= 0 || period <= 0) {
        throw std::invalid_argument("Invalid parameters for Fourier series.");
    }
    aCoefficients.assign(a.begin(), a.end());
    aCoefficients.resize(order + 1, 0);
    bCoefficients.assign(b.begin(), b.end());
    bCoefficients.resize(order + 1, 0);
}

FourierSeries::FourierSeries(int N, double T, std::function<double(int)> computeA, std::function<double(int)> computeB) : period(T), order(N) {
    if (N <= 0 || T <= 0) {
        throw std::invalid_argument("Invalid parameters for Fourier series.");
    }
    aCoefficients.resize(order + 1, 0);
    bCoefficients.resize(order + 1, 0);
    for (int i = 0; i <= N; ++i) {
        aCoefficients[i] = computeA(i);
        bCoefficients[i] = computeB(i);
    }
    bCoefficients[0] = 0; // Ensuring a_0 is always zero
}

FourierSeries::FourierSeries(int N, double p, double q, std::function<double(double)> f, int M) : order(N) {
    if (N <= 0 || M <= 0 || p > q) {
        throw std::invalid_argument("Invalid parameters for Fourier series.");
    }
    period = q - p;
    aCoefficients.resize(order + 1, 0);
    bCoefficients.resize(order + 1, 0);

    for (int n = 0; n <= N; ++n) {
        for (int m = 1; m < M; ++m) {
            double factor = 2 * Pi * n / period;
            double x = p + (q - p) * m / M;
            aCoefficients[n] += std::cos(factor * x) * f(x) * 2 / M;
            bCoefficients[n] += std::sin(factor * x) * f(x) * 2 / M;
        }
    }
}

double FourierSeries::operator()(double x) const {
    double sum = aCoefficients[0] / 2;
    for (int i = 1; i <= order; ++i) {
        sum += aCoefficients[i] * std::cos(2 * i * Pi * x / period) + bCoefficients[i] * std::sin(2 * i * Pi * x / period);
    }
    return sum;
}

FourierSeries& FourierSeries::operator=(const FourierSeries& other) {
    if (this != &other) {
        period = other.period;
        order = other.order;
        aCoefficients = other.aCoefficients;
        bCoefficients = other.bCoefficients;
    }
    return *this;
}

std::pair<double, double> FourierSeries::operator[](int index) const {
    if (index < 0 || index > order) {
        throw std::out_of_range("Index out of range.");
    }
    return {aCoefficients[index], bCoefficients[index]};
}

std::pair<double&, double&> FourierSeries::operator[](int index) {
    if (index < 0 || index > order) {
        throw std::out_of_range("Index out of range.");
    }
    return {aCoefficients[index], bCoefficients[index]};
}

int main() {
    FourierSeries series(1, {1, 2, 3, 4, 5, 6}, {3, 3, 6, 7});
    return 0;
}