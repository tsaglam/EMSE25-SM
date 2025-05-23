#include <iostream>
#include <stdexcept>
#include <cmath>
#include <algorithm>
#include <vector>
#include <functional>

const double Pi = std::atan(1) * 4;
const double eps = 1e-10;

class FourierSeries {
    double period;
    int degree;
    std::vector<double> aCoeff;
    std::vector<double> bCoeff;
    
    bool areEqual(double x, double y) const {
        return std::fabs(x - y) <= eps * (std::fabs(x) + std::fabs(y));
    }

public:
    FourierSeries(double T, std::initializer_list<double> a, std::initializer_list<double> b);
    FourierSeries(int N, double T, std::function<double(int)> F1, std::function<double(int)> F2);
    FourierSeries(int N, double p, double q, std::function<double(double)> F, int M);
    FourierSeries(const FourierSeries &F);
    FourierSeries(FourierSeries &&F) noexcept;

    FourierSeries& operator=(const FourierSeries &F);
    FourierSeries& operator=(FourierSeries &&F) noexcept;

    double operator()(double h) const;
    std::pair<double, double> operator[](int h) const;
    std::pair<double&, double&> operator[](int h);

    ~FourierSeries() = default;
};

FourierSeries::FourierSeries(double T, std::initializer_list<double> a, std::initializer_list<double> b)
    : period(T), degree(std::max(a.size(), b.size())), aCoeff(a), bCoeff{0}
{
    if(degree <= 0) throw std::domain_error("Degree must be positive");
    if(period <= 0) throw std::range_error("Invalid interval");

    bCoeff.insert(bCoeff.end(), b.begin(), b.end());
    bCoeff.resize(degree + 1, 0);
}

FourierSeries::FourierSeries(int N, double T, std::function<double(int)> F1, std::function<double(int)> F2)
    : period(T), degree(N), aCoeff(N + 1), bCoeff(N + 1, 0)
{
    if(N <= 0) throw std::domain_error("Degree must be positive");
    if(T <= 0) throw std::range_error("Invalid interval");

    for(int i = 0; i <= N; ++i) {
        aCoeff[i] = F1(i);
        bCoeff[i] = F2(i);
    }
    bCoeff[0] = 0;
}

FourierSeries::FourierSeries(int N, double p, double q, std::function<double(double)> F, int M)
    : degree(N)
{
    if(N <= 0 || M <= 0) throw std::domain_error("Degree and number of subintervals must be positive");
    if(p > q) throw std::range_error("Invalid interval");
    
    period = q - p;
    aCoeff.resize(N + 1, 0);
    bCoeff.resize(N + 1, 0);

    for(int i = 0; i <= N; ++i) {
        double sumA = 0, sumB = 0;
        for(int j = 1; j < M; ++j) {
            double x = p + j * period / M;
            sumA += F(x) * std::cos(2 * i * Pi * x / period);
            sumB += F(x) * std::sin(2 * i * Pi * x / period);
        }
        aCoeff[i] = 2.0 / M * sumA;
        bCoeff[i] = 2.0 / M * sumB;
    }
    bCoeff[0] = 0.0;
}

// Copy and Move Constructors, Assignment operators, operator(), and operator[] implementations go here
// Omitted for brevity. Maintain logic and perform similar optimizations as shown above.

int main() {
    FourierSeries a(1, {1, 2, 3, 4, 5, 6}, {3, 3, 6, 7});
    return 0;
}