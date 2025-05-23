#include <iostream>
#include <stdexcept>
#include <vector>
#include <cmath>
#include <functional>
#include <algorithm>

const double PI = 4 * atan(1.0);
const double DELTA = 1e-10;

class HarmonicSeries {
    double period;
    int order;
    std::vector<double> coefficientsA;
    std::vector<double> coefficientsB;

    bool NearlyEqual(double a, double b) const {
        return std::fabs(a - b) <= DELTA * (std::fabs(a) + std::fabs(b));
    }

public:
    HarmonicSeries(double _period, std::initializer_list<double> a, std::initializer_list<double> b);
    HarmonicSeries(int _order, double _period, std::function<double(int)> calcA, std::function<double(int)> calcB);
    HarmonicSeries(int _order, double start, double end, std::function<double(double)> func, int segments);
    double Evaluate(double x) const;
    HarmonicSeries& operator=(const HarmonicSeries& other);
    HarmonicSeries& operator=(HarmonicSeries&& other) noexcept;

    HarmonicSeries(const HarmonicSeries& other);
    HarmonicSeries(HarmonicSeries&& other) noexcept;

    std::pair<double&, double&> operator[](int index);
    std::pair<double, double> operator[](int index) const;
};

HarmonicSeries::HarmonicSeries(double _period, std::initializer_list<double> a, std::initializer_list<double> b) : period(_period) {
    order = std::max(a.size(), b.size());

    if (order <= 0) throw std::domain_error("Order must be positive");
    if (period <= 0) throw std::range_error("Invalid period");

    coefficientsA.resize(order + 1, 0);
    coefficientsB.resize(order + 1, 0);

    std::copy(a.begin(), a.end(), coefficientsA.begin());
    std::copy(b.begin(), b.end(), coefficientsB.begin() + 1);
}

HarmonicSeries::HarmonicSeries(int _order, double _period, std::function<double(int)> calcA, std::function<double(int)> calcB) : order(_order), period(_period) {
    if (order <= 0 || period <= 0) throw std::invalid_argument("Invalid arguments");

    coefficientsA.assign(order + 1, 0);
    coefficientsB.assign(order + 1, 0);

    for (int i = 0; i <= order; ++i) {
        coefficientsA[i] = calcA(i);
        coefficientsB[i] = i == 0 ? 0 : calcB(i);
    }
}

HarmonicSeries::HarmonicSeries(int _order, double start, double end, std::function<double(double)> func, int segments) : order(_order) {
    if (_order <= 0 || segments <= 0 || start > end) throw std::invalid_argument("Invalid arguments");

    period = end - start;
    coefficientsA.resize(order + 1);
    coefficientsB.resize(order + 1);

    for (int i = 0; i <= order; ++i) {
        double sumA = 0.0, sumB = 0.0;
        for (int j = 1; j < segments; ++j) {
            double x = start + j * period / segments;
            sumA += func(x) * cos(2 * i * PI * x / period);
            sumB += func(x) * sin(2 * i * PI * x / period);
        }

        sumA *= 2.0 / segments;
        sumB *= 2.0 / segments;
        coefficientsA[i] = sumA;
        coefficientsB[i] = i == 0 ? 0.0 : sumB;
    }
}

double HarmonicSeries::Evaluate(double x) const {
    double sum = coefficientsA[0] / 2.0;
    for (int i = 1; i <= order; ++i) {
        sum += coefficientsA[i] * cos(2 * i * PI * x / period) + coefficientsB[i] * sin(2 * i * PI * x / period);
    }
    return sum;
}

std::pair<double, double> HarmonicSeries::operator[](int index) const {
    if (index < 0 || index > order) throw std::out_of_range("Invalid index");
    return {coefficientsA[index], coefficientsB[index]};
}

// Other member functions definitions are omitted for brevity but would follow the same naming and coding styles as shown above.

int main() {
    HarmonicSeries series(1, {1.0, 2.0, 3.0, 4.0, 5.0, 6.0}, {3.0, 3.0, 6.0, 7.0});
    return 0;
}