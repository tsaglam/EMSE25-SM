#include <iostream>
#include <vector>
#include <cmath>
#include <tuple>
#include <algorithm>
#include <stdexcept>

const double PI_CONSTANT = std::acos(-1);

class HarmonicSeries {
private:
    double period;
    int count;
    std::vector<double> coeffA;
    std::vector<double> coeffB;

public:
    HarmonicSeries(double per, std::initializer_list<double> initA, std::initializer_list<double> initB) : period(per) {
        coeffA = std::vector<double>(initA);
        coeffB = std::vector<double>(initB.size(), 0); // Fill with zeroes if shorter
        std::copy(initB.begin(), initB.end(), coeffB.begin());
        balanceCoefficients();
    }
    
    HarmonicSeries(int degree, double per, double (*funcA)(int), double (*funcB)(int)) {
        if (degree <= 0) throw std::domain_error("Degree must be positive");
        setupSeries(degree, per, funcA, funcB);
    }

    HarmonicSeries(int harmonicDegree, double lowerBound, double upperBound, double (*harmonicFunc)(double), int partition) {
        if (harmonicDegree <= 0 || partition <= 0 || lowerBound >= upperBound)
            throw std::invalid_argument("Invalid arguments for HarmonicSeries instantiation");
        calculateSeries(harmonicDegree, lowerBound, upperBound, harmonicFunc, partition);
    }

    std::pair<double, double> operator[](int index) const {
        if (index < 0 || index >= count) throw std::range_error("Invalid index");
        return {coeffA[index], coeffB[index]};
    }

    std::pair<double&, double&> operator[](int index) {
        if (index < 0 || index >= count) throw std::range_error("Invalid index");
        return {coeffA[index], coeffB[index]};
    }

    double operator()(double x) const {
        double result = coeffA[0] / 2.0;
        for (int i = 1; i < count; ++i) {
            result += coeffA[i] * std::cos(2 * i * PI_CONSTANT * x / period) + 
                      coeffB[i] * std::sin(2 * i * PI_CONSTANT * x / period);
        }
        return result;
    }

private:
    void balanceCoefficients() {
        count = coeffA.size();
        if (coeffB.size() > coeffA.size()) {
            coeffA.resize(coeffB.size(), 0);
            count = coeffB.size();
        }
    }

    void setupSeries(int n, double t, double (*f1)(int), double (*f2)(int)) {
        period = t;
        coeffA.resize(n);
        coeffB.resize(n, 0);
        for (int i = 0; i < n; ++i) {
            coeffA[i] = f1(i);
            coeffB[i] = f2(i);
        }
        balanceCoefficients();
    }

    void calculateSeries(int deg, double lb, double ub, double (*f)(double), int m) {
        period = ub - lb;
        coeffA.resize(deg);
        coeffB.resize(deg, 0);
        // Implementation of series calculation omitted for brevity
    }
};

int main() {
    HarmonicSeries series(2, {2, 1}, {});
    std::cout << series(5);
    return 0;
}