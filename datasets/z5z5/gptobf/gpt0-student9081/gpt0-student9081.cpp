#include <iostream>
#include <stdexcept>
#include <vector>
#include <initializer_list>
#include <utility>
#include <functional>
#include <cmath>

const double PI = std::acos(-1);
double zero = 0.0;

class FourierSeries {
    double P; // Period
    std::vector<double> aCoeffs, bCoeffs; // Fourier coefficients
    int degree;

public:
    FourierSeries(double period, std::initializer_list<double> a, std::initializer_list<double> b);
    FourierSeries(int d, double period, std::function<double(int)> fA, std::function<double(int)> fB);
    FourierSeries(int d, double start, double end, std::function<double(double)> f, int intervals);
    ~FourierSeries() = default;
    FourierSeries(const FourierSeries& other) = default;
    FourierSeries(FourierSeries&& other) noexcept;
    FourierSeries& operator= (const FourierSeries& other) = default;
    FourierSeries& operator= (FourierSeries&& other) noexcept;
    
    double operator() (double x) const;
    std::pair<double, double> operator[] (int index) const;
    std::pair<double&, double&> operator[] (int index);
};

FourierSeries::FourierSeries(double period, std::initializer_list<double> a, std::initializer_list<double> b): P(period), degree(std::max(a.size(), b.size()) - 1) {
    aCoeffs.assign(a.begin(), a.end());
    bCoeffs.assign(b.begin(), b.end());
    aCoeffs.resize(degree + 1, 0);
    bCoeffs.resize(degree, 0);
}

FourierSeries::FourierSeries(int d, double period, std::function<double(int)> fA, std::function<double(int)> fB): P(period), degree(d) {
    for (int i = 0; i <= d; ++i) aCoeffs.push_back(fA(i));
    for (int i = 1; i <= d; ++i) bCoeffs.push_back(fB(i));
}

FourierSeries::FourierSeries(int d, double start, double end, std::function<double(double)> func, int intervals): degree(d), P(end - start) {
    if (d <= 0 || intervals <= 0 || start >= end) throw std::domain_error("Invalid input parameters.");
    // Setup coeffs
    for (int i = 0; i <= d; ++i) {
        double sum = 0.0;
        for (int j = 1; j < intervals; ++j) {
            double x = start + j * (P / intervals);
            sum += func(x) * std::cos(2 * PI * i * x / P);
        }
        sum += (func(start) + func(end)) / 2;
        sum *= 2.0 / intervals;
        aCoeffs.push_back(sum);
    }
    for (int i = 0; i < d; ++i) {
        double sum = 0.0;
        for (int j = 1; j < intervals; ++j) {
            double x = start + j * (P / intervals);
            sum += func(x) * std::sin(2 * PI * (i + 1) * x / P);
        }
        sum += (func(start) + func(end)) / 2;
        sum *= 2.0 / intervals;
        bCoeffs.push_back(sum);
    }
}

FourierSeries::FourierSeries(FourierSeries&& other) noexcept: P(other.P), degree(other.degree), aCoeffs(std::move(other.aCoeffs)), bCoeffs(std::move(other.bCoeffs)) {
}

FourierSeries& FourierSeries::operator= (FourierSeries&& other) noexcept {
    if (this != &other) {
        P = other.P;
        degree = other.degree;
        aCoeffs = std::move(other.aCoeffs);
        bCoeffs = std::move(other.bCoeffs);
    }
    return *this;
}

std::pair<double, double> FourierSeries::operator[](int index) const {
    if (index < 0 || index > degree) throw std::range_error("Invalid index");
    double a = index < aCoeffs.size() ? aCoeffs[index] : 0;
    double b = index > 0 && index <= bCoeffs.size() ? bCoeffs[index - 1] : 0;
    return {a, b};
}

std::pair<double&, double&> FourierSeries::operator[](int index) {
    if (index < 0 || index > degree) throw std::range_error("Invalid index");
    if (index == 0) {
        zero = 0;
        return {aCoeffs[0], zero};
    }
    return {aCoeffs[index], bCoeffs[index - 1]};
}

double FourierSeries::operator()(double x) const {
    double sum = aCoeffs[0] / 2.0;
    for (int i = 1; i <= degree; ++i) sum += aCoeffs[i] * std::cos(2 * PI * i * x / P);
    for (int i = 0; i < degree; ++i) sum += bCoeffs[i] * std::sin(2 * PI * (i + 1) * x / P);
    return sum;
}

int main() {
    for (;;) {
        std::cout << "Enter the degree of Fourier series: ";
        int degree;
        std::cin >> degree;
        if (degree == -1) break;

        std::cout << "Enter number of intervals for approximation: ";
        int intervals;
        std::cin >> intervals;

        std::cout << "Enter value to compute the Fourier series at: ";
        double x;
        std::cin >> x;

        try {
            FourierSeries f1(degree, 0, 2 * PI, [](double x) { return x * x; }, intervals),
                f2(degree, 2 * PI, [](int k) { return k == 0 ? 8 * PI * PI / 3 : 4. / (k * k); },
                [](int k) { return -4 * PI / k; });
            std::cout << "Values are:\n";
            std::cout << "f1(" << x << ") = " << f1(x) << " and " << "f2(" << x << ") = " << f2(x) << std::endl;
        } catch (...) {
            std::cout << "An error occurred! Try again.\n";
        }
    }
    return 0;
}