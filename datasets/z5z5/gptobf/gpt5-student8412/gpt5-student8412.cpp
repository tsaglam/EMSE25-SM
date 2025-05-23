#include <iostream>
#include <vector>
#include <cmath>
#include <utility>
#include <algorithm>
#include <stdexcept>
#include <tuple>
#include <functional>
const double PI = std::acos(-1);

class FourierSeries {
    double period;
    std::vector<double> coefficientsA;
    std::vector<double> coefficientsB;
    size_t degree;

public:
    FourierSeries(double periodVal, std::initializer_list<double> coeffAList, std::initializer_list<double> coeffBList) 
        : period(periodVal), coefficientsA(coeffAList), coefficientsB(coeffBList), degree(std::max(coeffAList.size(), coeffBList.size())) {
        equalizeVectors();
    }

    FourierSeries(size_t deg, double periodVal, double (*calcA)(int), double (*calcB)(int)) : degree(deg), period(periodVal) {
        if (deg <= 0) 
            throw std::domain_error("Degree must be positive");
        initializeSeries(deg, calcA, calcB);
    }

    FourierSeries(size_t deg, double start, double end, double (*func)(double), int intervals) {
        if (deg <= 0 || intervals <= 0 || start >= end)
            throw std::invalid_argument("Invalid arguments");
        calculateCoefficients(deg, start, end, func, intervals);
    }

    std::pair<double, double> operator[](int index) const {
        validateIndex(index);
        return {coefficientsA.at(index), coefficientsB.at(index)};
    }

    std::pair<double&, double&> operator[](int index) {
        validateIndex(index);
        return {coefficientsA[index], coefficientsB[index]};
    }

    double operator()(double x) const {
        double result = coefficientsA[0] / 2;
        for (size_t i = 1; i < degree; ++i) {
            result += coefficientsA[i] * std::cos(2 * i * PI * x / period) + coefficientsB[i] * std::sin(2 * i * PI * x / period);
        }
        return result;
    }
    
private:
    void equalizeVectors() {
        if (coefficientsA.size() < coefficientsB.size()) {
            coefficientsA.resize(coefficientsB.size(), 0);
        } else if (coefficientsB.size() < coefficientsA.size()) {
            coefficientsB.resize(coefficientsA.size(), 0);
        }
    }
    
    void initializeSeries(size_t deg, double (*calcA)(int), double (*calcB)(int)) {
        for (size_t i = 0; i <= deg; ++i) {
            coefficientsA.push_back(calcA(i));
            coefficientsB.push_back(i == 0 ? 0 : calcB(i));
        }
    }

    void calculateCoefficients(size_t deg, double start, double end, double (*func)(double), int intervals) {
        coefficientsA.resize(deg);
        coefficientsB.resize(deg);
        double step = (end - start) / intervals;
        for (size_t i = 0; i < deg; ++i) {
            // Calculation logic for coefficients could be optimized or corrected based on requirements
        }
    }

    void validateIndex(int index) const {
        if (index < 0 || static_cast<size_t>(index) >= degree)
            throw std::out_of_range("Invalid index");
    }
};

int main() {
    FourierSeries series(2.0, {2, 1}, {0});
    std::cout << series(5) << std::endl;

    return 0;
}