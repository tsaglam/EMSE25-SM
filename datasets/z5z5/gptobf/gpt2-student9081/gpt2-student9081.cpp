#include <iostream>
#include <stdexcept>
#include <vector>
#include <initializer_list>
#include <utility>
#include <functional>
#include <cmath>

const double PI = 4.0 * std::atan(1.0);

class FourierSeries {
    double period;
    int degree;
    std::vector<double> a_coeffs, b_coeffs;

public:
    FourierSeries(double T, std::initializer_list<double> a, std::initializer_list<double> b);
    FourierSeries(int n, double T, std::function<double(int)> a, std::function<double(int)> b);
    FourierSeries(int n, double p, double q, std::function<double(double)> f, int M);
    FourierSeries(const FourierSeries&) = default;
    FourierSeries(FourierSeries&&) noexcept = default;
    FourierSeries& operator=(const FourierSeries&) = default;
    FourierSeries& operator=(FourierSeries&&) noexcept = default;
    ~FourierSeries() = default;

    double operator()(double x) const;
    std::pair<double, double> operator[](int k) const;
    std::pair<double&, double&> operator[](int k);
};

FourierSeries::FourierSeries(double T, std::initializer_list<double> a, std::initializer_list<double> b)
    : period(T), degree(std::max(a.size() - 1, b.size())), a_coeffs(a), b_coeffs(b) {
    a_coeffs.resize(degree + 1, 0);
    b_coeffs.resize(degree, 0);
}

FourierSeries::FourierSeries(int n, double T, std::function<double(int)> a, std::function<double(int)> b)
    : period(T), degree(n), a_coeffs(n + 1), b_coeffs(n) {
    if (n <= 0) throw std::domain_error("Degree must be positive");

    for (int i = 0; i <= n; i++)
        a_coeffs[i] = a(i);
    for (int i = 1; i <= n; i++)
        b_coeffs[i - 1] = b(i);
}

FourierSeries::FourierSeries(int n, double p, double q, std::function<double(double)> f, int M)
    : period(q - p), degree(n) {
    if (n <= 0 || M <= 0 || !(p < q))
        throw std::domain_error("Invalid parameters");

    a_coeffs.resize(n + 1);
    b_coeffs.resize(n);

    for (int i = 0; i <= n; i++) {
        double sum = 0;
        for (int j = 1; j < M; j++)
            sum += f(p + j * period / M) * std::cos(2 * i * PI * (p / period + double(j) / M));
        a_coeffs[i] = ((f(p) + f(q)) * std::cos(2 * i * PI * p / period) + 2 * sum) / M;
    }

    for (int i = 0; i < n; i++) {
        double sum = 0;
        for (int j = 1; j < M; j++)
            sum += f(p + j * period / M) * std::sin(2 * (i + 1) * PI * (p / period + double(j) / M));
        b_coeffs[i] = ((f(p) + f(q)) * std::sin(2 * (i + 1) * PI * p / period) + 2 * sum) / M;
    }
}

double FourierSeries::operator()(double x) const {
    double sum = a_coeffs[0] / 2.0;
    for (int i = 1; i <= degree; i++)
        sum += a_coeffs[i] * std::cos(2 * i * PI * x / period) + b_coeffs[i - 1] * std::sin(2 * i * PI * x / period);
    return sum;
}

std::pair<double, double> FourierSeries::operator[](int k) const {
    if (k < 0 || k > degree) throw std::range_error("Invalid index");
    double a = k <= degree ? a_coeffs[k] : 0;
    double b = (k > 0 && k <= degree) ? b_coeffs[k - 1] : 0;
    return {a, b};
}

std::pair<double&, double&> FourierSeries::operator[](int k) {
    static double nullValue = 0; // Used to maintain reference to a double when needed
    if (k < 0 || k > degree) throw std::range_error("Invalid index");
    if (k == 0) return {a_coeffs[0], nullValue};
    return {a_coeffs[k], b_coeffs[k - 1]};
}

int main() {
    // Your existing main function with appropriate object name changes
}