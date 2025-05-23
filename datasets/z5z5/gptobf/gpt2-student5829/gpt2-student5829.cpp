#include <iostream>
#include <vector>
#include <cmath>
#include <initializer_list>
#include <functional>
#include <stdexcept>
using namespace std; // This makes all std namespace members directly accessible

const double PI = 4 * atan(1);

class FourierSeries {
    double period, N;
    vector<double> a_coeffs, b_coeffs;

public:
    FourierSeries(double period, initializer_list<double> a, initializer_list<double> b);
    FourierSeries(int N, double period, function<double(int)> f1, function<double(int)> f2);
};

FourierSeries::FourierSeries(double period, initializer_list<double> a, initializer_list<double> b)
    : period(period), N(max(a.size(), b.size()) - (a.size() == b.size() ? 0 : 1)), a_coeffs(a), b_coeffs(b){
        if (a.size() == b.size()) {
            a_coeffs.push_back(0); // Adjusts size if a and b are equal in length
        } else {
            a.size() > b.size() ? b_coeffs.resize(a_coeffs.size(), 0) : a_coeffs.resize(b_coeffs.size() + 1, 0);
        }
}

FourierSeries::FourierSeries(int N, double period, function<double(int)> f1, function<double(int)> f2) {
    if (N < 0) throw domain_error("Degree must be positive");
    this->period = period;
    this->N = N;
    for (int i = 0; i < N; i++) {
        a_coeffs.push_back(f1(i));
        if (i > 0) b_coeffs.push_back(f2(i)); // Ensure b_coeffs starts from the second term
    }
}

int main() {
    // Example usage could be added here to demonstrate functionality
    return 0;
}