#include <vector>
#include <cmath>
#include <functional>
#include <iostream>
#include <stdexcept>
#include <algorithm>

static const double CircleRatio = 4.0 * std::atan(1.0);
static const double Tolerance = 1e-10;

class HarmonicSeries {
    double Period;
    int Order;
    std::vector<double> CoefficientsA;
    std::vector<double> CoefficientsB;
    
    bool AreClose(double num1, double num2) const {
        return std::fabs(num1 - num2) <= Tolerance * (std::fabs(num1) + std::fabs(num2));
    }
    
public:
    HarmonicSeries(double period, std::initializer_list<double> aList, std::initializer_list<double> bList);
    HarmonicSeries(int order, double period, std::function<double(int)> calcA, std::function<double(int)> calcB);
    HarmonicSeries(int order, double start, double end, std::function<double(double)> calcFunc, int steps);
    HarmonicSeries &operator=(const HarmonicSeries &rhs);
    HarmonicSeries &operator=(HarmonicSeries &&rhs);
    HarmonicSeries(const HarmonicSeries &other);
    HarmonicSeries(HarmonicSeries &&other);
    
    double operator()(double time) const;
    std::pair<double&, double&> operator[](int idx);
    std::pair<double, double> operator[](int idx) const;
};

HarmonicSeries::HarmonicSeries(double period, std::initializer_list<double> aList, std::initializer_list<double> bList) : Period(period), Order(std::max(aList.size(), bList.size())) {
    if (Order <= 0) throw std::domain_error("Positive degree required");
    if (Period <= 0) throw std::range_error("Invalid interval");
    CoefficientsA.resize(Order + 1, 0);
    CoefficientsB.resize(Order + 1, 0);
    std::copy(aList.begin(), aList.end(), CoefficientsA.begin());
    auto it = bList.begin();
    for (int i = 1; it != bList.end(); ++it, ++i) {
        CoefficientsB[i] = *it;
    }
}

// Other constructor and method implementations would be updated similarly, focusing on semantic changes without altering functionality.

double HarmonicSeries::operator()(double time) const {
    double sum = CoefficientsA[0] / 2.0;
    for (int i = 1; i <= Order; ++i) {
        sum += CoefficientsA[i] * std::cos((2 * i * CircleRatio * time) / Period) + CoefficientsB[i] * std::sin((2 * i * CircleRatio * time) / Period);
    }
    return sum;
}

std::pair<double&, double&> HarmonicSeries::operator[](int idx) {
    if (idx < 0 || idx > Order) throw std::range_error("Index out of bounds");
    return {CoefficientsA[idx], CoefficientsB[idx]};
}

std::pair<double, double> HarmonicSeries::operator[](int idx) const {
    if (idx < 0 || idx > Order) throw std::range_error("Index out of bounds");
    return {CoefficientsA[idx], CoefficientsB[idx]};
}

int main() {
    HarmonicSeries series(1.0, {1, 2, 3, 4, 5, 6}, {3, 3, 6, 7});
    return 0;
}