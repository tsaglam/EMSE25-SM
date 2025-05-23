#include <iostream>
#include <vector>
#include <cmath>
#include <functional>
#include <stdexcept>

// Using directives limited to function scope to avoid potential global namespace pollution.
const double PI = 4 * atan(1); // Simplified the use of std::atan by directly using atan after ensuring no namespace conflicts.

class FourierSeries {
    double period, N;
    std::vector<double> a_coeffs, b_coeffs;
public:
    FourierSeries(double period, std::initializer_list<double> a, std::initializer_list<double> b);
    FourierSeries(size_t N, double period, const std::function<double(size_t)>& f1, const std::function<double(size_t)>& f2);
};

// Constructor with initializer lists
FourierSeries::FourierSeries(double period, std::initializer_list<double> a, std::initializer_list<double> b)
    : period(period), a_coeffs(a), b_coeffs(b) {
    if (a.size() == b.size()) a_coeffs.push_back(0); // Making sure a has n+1 elements if a and b are of the same size
    else if (a.size() > b.size()) {
        N = a.size() - 1;
        b_coeffs.resize(a_coeffs.size(), 0); // Ensuring b has the same number of coefficients as a, adding zeroes where necessary.
    } else {
        N = b.size();
        a_coeffs.resize(b_coeffs.size() + 1, 0); // Ensuring a has one more coefficient than b, adding a zero if necessary.
    }
}

// Constructor with function parameters
FourierSeries::FourierSeries(size_t N, double period, const std::function<double(size_t)>& f1, const std::function<double(size_t)>& f2)
    : period(period), N(N) {
    if (N < 0) throw std::domain_error("Degree must be positive");
    for (size_t i = 0; i < N; ++i) {
        a_coeffs.push_back(f1(i));
        if (i > 0) b_coeffs.push_back(f2(i)); // Avoiding b[0] since it is typically not used in Fourier series.
    }
}

int main() {
    // Your main application logic here. For now, it's empty as the focus is on the FourierSeries class.
    return 0;
}