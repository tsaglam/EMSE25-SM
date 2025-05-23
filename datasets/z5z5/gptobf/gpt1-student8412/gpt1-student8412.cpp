#include <iostream>
#include <vector>
#include <cmath>
#include <stdexcept>

#define PI 3.14159265358979323846

class FourierSeries {
    double period_;
    std::vector<double> a_coeffs_;
    std::vector<double> b_coeffs_;

public:
    // Constructor using initializers for a and b coefficients
    FourierSeries(double period, std::initializer_list<double> a_coeffs, std::initializer_list<double> b_coeffs)
        : period_(period), a_coeffs_(a_coeffs), b_coeffs_(b_coeffs.size() ? b_coeffs : std::vector<double>(a_coeffs.size(), 0.0)) {
        // Ensure a_coeffs_ and b_coeffs_ have the same size by padding with zeros
        if(a_coeffs_.size() > b_coeffs_.size()) {
            b_coeffs_.resize(a_coeffs_.size(), 0.0);
        } else {
            a_coeffs_.resize(b_coeffs_.size(), 0.0);
        }
    }

    // Constructor with function pointers for computing coefficients
    FourierSeries(int n, double period, double (*f1)(int), double (*f2)(int)) {
        if(n <= 0) throw std::domain_error("Order must be positive");
        
        period_ = period;
        a_coeffs_.resize(n + 1);
        b_coeffs_.resize(n + 1);

        for(int i = 0; i <= n; ++i) {
            a_coeffs_[i] = f1(i);
            b_coeffs_[i] = i == 0 ? 0.0 : f2(i); // Ensure b[0] is always 0
        }
    }

    // Constructor using integral approximation for coefficients
    FourierSeries(int n, double p, double q, double (*f)(double), int m) {
        if(n <= 0 || m <= 0) {
            throw std::domain_error("n and m must be positive");
        }
        if(p > q) {
            throw std::range_error("Invalid interval");
        }

        period_ = q - p;
        a_coeffs_.resize(n);
        b_coeffs_.resize(n);

        double step = (q - p) / m;
        for(int i = 0; i < n; ++i) {
            double suma_cos = 0, suma_sin = 0;
            for(int j = 1; j <= m - 1; ++j) {
                double x = p + j * step;
                suma_cos += f(x) * cos(2 * PI * i * x / period_);
                suma_sin += f(x) * sin(2 * PI * i * x / period_);
            }
            a_coeffs_[i] = (f(p) + f(q)) * cos(2 * PI * i * p / period_) / m + 2 * suma_cos / m;
            b_coeffs_[i] = (f(p) + f(q)) * sin(2 * PI * i * p / period_) / m + 2 * suma_sin / m;
        }
    }

    // Accessing coefficients
    std::pair<double, double> operator[](int k) const {
        if (k < 0 || k >= a_coeffs_.size()) {
            throw std::range_error("Invalid index");
        }
        return {a_coeffs_[k], b_coeffs_[k]};
    }

    // Evaluate the Fourier series at x
    double operator()(double x) const {
        double sum = a_coeffs_[0] / 2.0;
        for(int i = 1; i < a_coeffs_.size(); ++i) {
            sum += a_coeffs_[i] * std::cos(2 * i * PI * x / period_) +
                   b_coeffs_[i] * std::sin(2 * i * PI * x / period_);
        }
        return sum;
    }
};

int main() {
    FourierSeries f(2, {2, 1}, {});
    std::cout << f(5) << std::endl;
    return 0;
}