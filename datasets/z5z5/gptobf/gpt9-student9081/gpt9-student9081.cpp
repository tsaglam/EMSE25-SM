#include <iostream>
#include <stdexcept>
#include <vector>
#include <cmath>
#include <functional>

constexpr double PI_VAL = 3.14159265358979323846;
double zeroVal = 0.0;

class HarmonicSeries {
    double cycleLength;
    int power;
    std::vector<double> coefficientsA, coefficientsB;

public:
    HarmonicSeries(double Period, std::initializer_list<double> aList, std::initializer_list<double> bList);
    HarmonicSeries(int degree, double Period, std::function<double(int)> func1, std::function<double(int)> func2);
    HarmonicSeries(int degree, double startPoint, double endPoint, std::function<double(double)> func, int intervals);
    ~HarmonicSeries() = default;
    HarmonicSeries(const HarmonicSeries&) = default;
    HarmonicSeries(HarmonicSeries&&) noexcept;
    HarmonicSeries& operator=(const HarmonicSeries&) = default;
    HarmonicSeries& operator=(HarmonicSeries&&) noexcept;
    double getValueAt(double x) const;
    std::pair<double, double> getCoefficients(int index) const;
    std::pair<double&, double&> getCoefficients(int index);
};

// Constructors and member functions implementation

// Example modification of method implementation
double HarmonicSeries::getValueAt(double x) const {
    double result = 0.0;
    for (int i = 1; i <= power; ++i) {
        result += coefficientsA[i] * cos(2 * i * PI_VAL * x / cycleLength);
    }
    for (int i = 0; i < power; ++i) {
        result += coefficientsB[i] * sin(2 * (i + 1) * PI_VAL * x / cycleLength);
    }
    result += coefficientsA[0] / 2;
    return result;
}

// Modified main function with different variable and print statement styles
int main() {
    while (true) {
        std::cout << "Enter the degree of Fourier series: ";
        int degree;
        std::cin >> degree;
        if (degree == -1) break;
        std::cout << "Enter the number of subintervals for estimation: ";
        int subIntervals;
        std::cin >> subIntervals;
        std::cout << "Enter the value to compute Fourier series at: ";
        double value;
        std::cin >> value;

        try {
            HarmonicSeries series1(degree, 0, 2 * PI_VAL, [](double x) { return x * x; }, subIntervals);
            HarmonicSeries series2(degree, 2 * PI_VAL, [](int k) { return k == 0 ? 8 * PI_VAL * PI_VAL / 3 : 4. / (k * k); }, 
                [](int k) { return -4 * PI_VAL / k; });
            std::cout << "Computed values are:\n";
            std::cout << "series1("<< value <<") = "<< series1.getValueAt(value) <<" and "<<"series2("<< value <<") = "<< series2.getValueAt(value) << std::endl;
        } catch(...) {
            std::cout << "An error occurred! Please try again.\n";
        }
    }
    return 0;
}