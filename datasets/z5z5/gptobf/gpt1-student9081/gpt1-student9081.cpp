#include <iostream>
#include <stdexcept>
#include <vector>
#include <functional>
#include <cmath>

const double PI = 4 * atan(1.0);

class FourierSeries {
    double period;
    int degree;
    std::vector<double> aCoeffs, bCoeffs;

    void checkIndex(int k) const {
        if (k < 0 || k > degree)
            throw std::range_error("Invalid index");
    }

    static double integrate(std::function<double(double)> f, double a, double b, int n) {
        double h = (b - a) / n;
        double sum = 0.5 * (f(a) + f(b));
        for (int i = 1; i < n; ++i) {
            sum += f(a + i * h);
        }
        return sum * h;
    }

public:
    FourierSeries(double T, std::initializer_list<double> a, std::initializer_list<double> b);
    FourierSeries(int n, double T, std::function<double(int)> aFunc, std::function<double(int)> bFunc);
    FourierSeries(int n, double p, double q, std::function<double(double)> f, int M);
    FourierSeries(const FourierSeries&) = default;
    FourierSeries(FourierSeries&&) = default;
    FourierSeries& operator= (const FourierSeries&) = default;
    FourierSeries& operator= (FourierSeries&&) = default;

    double operator()(double x) const;
    std::pair<double, double> operator[](int k) const;
};

FourierSeries::FourierSeries(double T, std::initializer_list<double> a, std::initializer_list<double> b)
    : period(T), degree(std::max(a.size() - 1, b.size())), aCoeffs(a), bCoeffs(b) {
    aCoeffs.resize(degree + 1, 0);
    bCoeffs.resize(degree, 0);
}

FourierSeries::FourierSeries(int n, double T, std::function<double(int)> aFunc, std::function<double(int)> bFunc)
    : period(T), degree(n), aCoeffs(n + 1), bCoeffs(n) {
    if (n <= 0) throw std::domain_error("Degree must be positive");
    for (int i = 0; i <= n; ++i) {
        aCoeffs[i] = aFunc(i);
    }
    for (int i = 0; i < n; ++i) {
        bCoeffs[i] = bFunc(i + 1);
    }
}

FourierSeries::FourierSeries(int n, double p, double q, std::function<double(double)> f, int M)
    : period(q - p), degree(n) {
    if (n <= 0 || M <= 0 || !(p < q))
        throw std::domain_error("Invalid parameters for Fourier Series");
    aCoeffs.resize(n + 1);
    bCoeffs.resize(n);

    for (int i = 0; i <= n; ++i) {
        aCoeffs[i] = integrate([&](double x) { return f(x) * cos(i * 2 * PI * x / period); }, p, q, M) * 2 / period;
    }
    for (int i = 1; i <= n; ++i) {
        bCoeffs[i - 1] = integrate([&](double x) { return f(x) * sin(i * 2 * PI * x / period); }, p, q, M) * 2 / period;
    }
}

double FourierSeries::operator()(double x) const {
    double result = aCoeffs[0] / 2.0;
    for (int i = 1; i <= degree; ++i) {
        result += aCoeffs[i] * cos(i * 2 * PI * x / period);
        if (i <= degree) result += bCoeffs[i - 1] * sin(i * 2 * PI * x / period);
    }
    return result;
}

std::pair<double, double> FourierSeries::operator[](int k) const {
    checkIndex(k);
    if (k == 0) return {aCoeffs[0], 0};
    return {aCoeffs[k], bCoeffs[k-1]};
}

// Simplify main to demonstrate the revised FourierSeries class
int main () {
    try {
        FourierSeries f1(2, 0, 2 * PI, [](double x) { return x * x; }, 100);
        FourierSeries f2(2, 2 * PI, [](int k) { return k == 0 ? 8 * PI * PI / 3 : 4.0 / (k * k); }, 
                                  [](int k) { return -4 * PI / k; });

        double x = PI / 4; // Example calculation point
        std::cout << "f1(" << x << ") = " << f1(x) << "\n";
        std::cout << "f2(" << x << ") = " << f2(x) << "\n";
    } catch(const std::exception& e) {
        std::cerr << "Error: " << e.what() << '\n';
    }
    return 0;
}