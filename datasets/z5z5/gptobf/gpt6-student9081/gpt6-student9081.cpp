#include <iostream>
#include <vector>
#include <cmath>
#include <stdexcept>
#include <functional>
#include <initializer_list>
#include <utility>

const double PI = 3.14159265358979323846;

class FourierSeries {
    std::vector<double> aCoeffs, bCoeffs;
    double period;
    size_t degree;

public:
    FourierSeries(double T, std::initializer_list<double> a, std::initializer_list<double> b);
    FourierSeries(size_t n, double T, std::function<double(int)> calcA, std::function<double(int)> calcB);
    FourierSeries(size_t n, double a, double b, std::function<double(double)> func, int M);
    double evaluate(double x) const;
    std::pair<double, double> getCoefficients(int k) const;
};

FourierSeries::FourierSeries(double T, std::initializer_list<double> a, std::initializer_list<double> b) 
    : period(T), degree(std::max(a.size(), b.size())), aCoeffs(a), bCoeffs(b) {
    aCoeffs.resize(degree, 0);
    bCoeffs.resize(degree, 0);
}

FourierSeries::FourierSeries(size_t n, double T, std::function<double(int)> calcA, std::function<double(int)> calcB) 
    : period(T), degree(n), aCoeffs(n+1), bCoeffs(n) {
    for(int i = 0; i <= n; ++i) aCoeffs[i] = calcA(i);
    for(int i = 1; i <= n; ++i) bCoeffs[i-1] = calcB(i);
}

FourierSeries::FourierSeries(size_t n, double a, double b, std::function<double(double)> func, int M) 
    : period(b - a), degree(n), aCoeffs(n+1), bCoeffs(n) {
    for(size_t i = 0; i <= n; ++i) {
        aCoeffs[i] = bCoeffs[i] = 0;
        for(int j = 1; j <= M; ++j) {
            double x = a + j * (b - a) / M;
            aCoeffs[i] += func(x) * cos(i * 2 * PI * x / period);
            if(i > 0) bCoeffs[i - 1] += func(x) * sin(i * 2 * PI * x / period);
        }
        aCoeffs[i] *= 2.0 / M;
        if(i > 0) bCoeffs[i - 1] *= 2.0 / M;
    }
}

double FourierSeries::evaluate(double x) const {
    double sum = aCoeffs[0] / 2;
    for(size_t i = 1; i <= degree; ++i) {
        sum += aCoeffs[i] * cos(i * 2 * PI * x / period);
        if(i < degree) sum += bCoeffs[i] * sin(i * 2 * PI * x / period);
    }
    return sum;
}

std::pair<double, double> FourierSeries::getCoefficients(int k) const {
    if(k < 0 || static_cast<size_t>(k) > degree)
        throw std::out_of_range("Invalid index for coefficients");
    return { aCoeffs[k], k > 0 ? bCoeffs[k-1] : 0.0 };
}

int main() {
    // Use FourierSeries class as you did with FourierovRed in your code.
    return 0;
}