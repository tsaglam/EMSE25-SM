#include <iostream>
#include <vector>
#include <stdexcept>
#include <cmath>
#include <utility>

#define PI 3.14159265358979323846

class FourierSeries {
private:
    std::vector<double> aCoefficients;
    std::vector<double> bCoefficients;
    double period;

public:
    FourierSeries(double P, std::initializer_list<double> a, std::initializer_list<double> b)
    : period(P) {
        // Initializer with lists for a and b coefficients
        aCoefficients.assign(a);
        bCoefficients.assign(b);
        
        // Ensure both vectors are of equal size by appending zeros to the shorter one
        while(aCoefficients.size() < bCoefficients.size()) aCoefficients.push_back(0.0);
        while(bCoefficients.size() < aCoefficients.size()) bCoefficients.push_back(0.0);
    }

    FourierSeries(int N, double P, double (*f1)(int), double (*f2)(int)) : period(P) {
        if(N <= 0) throw std::domain_error("Degree must be positive");

        // Initializing the coefficients based on provided functions f1 and f2
        for(int i = 0; i <= N; ++i) {
            aCoefficients.push_back(f1(i));
            bCoefficients.push_back(f2(i));
        }
        bCoefficients[0] = 0; // Ensuring the b0 coefficient is zero
    }

    FourierSeries(int N, double P, double Q, double (*f)(double), int M) : period(P) {
        if(N <= 0) throw std::domain_error("Degree must be positive");
        if(M <= 0) throw std::domain_error("Number of subintervals must be positive");
        if(P > Q) throw std::range_error("Invalid interval");

        double interval = (Q - P) / M;

        // Calculating coefficients using the trapezoidal rule approximation
        for(int n = 0; n <= N; ++n) {
            double aSum = 0.0, bSum = 0.0;
            for(int i = 1; i < M; ++i) {
                double x = P + i * interval;
                aSum += f(x) * std::cos(2 * n * PI * x / period);
                bSum += f(x) * std::sin(2 * n * PI * x / period);
            }
            double scaleFactor = 2.0 / M;
            aCoefficients.push_back(scaleFactor * aSum);
            bCoefficients.push_back(scaleFactor * bSum);
        }
    }

    std::pair<double, double> operator[](int k) const {
        if(k < 0 || k >= aCoefficients.size()) throw std::range_error("Invalid index");
        return {aCoefficients[k], bCoefficients[k]};
    }

    double operator()(double x) const {
        double sum = aCoefficients[0] / 2.0; // Start with a0/2
        for(size_t i = 1; i < aCoefficients.size(); ++i) {
            sum += aCoefficients[i] * std::cos(2 * i * PI * x / period) +
                   bCoefficients[i] * std::sin(2 * i * PI * x / period);
        }
        return sum;
    }
};

double cosFunction(int n) {
    // Example coefficient generator function using cosine
    return std::cos(n);
}

double sinFunction(int n) {
    // Example coefficient generator function using sine
    return std::sin(n);
}

int main() {
    FourierSeries f(2, {1, 2}, {0, 0.5});
    auto coefs = f[1]; // Example of accessing coefficients
    std::cout << "a1: " << coefs.first << ", b1: " << coefs.second << std::endl;

    std::cout << "Value at x=5: " << f(5) << std::endl;

    return 0;
}