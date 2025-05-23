#include <iostream>
#include <vector>
#include <cmath>
#include <functional>

const double PI = 3.14159265358979323846;

class FourierSeries {
    double T; // Period
    int N; // Number of coefficients
    std::vector<double> aCoefficients;
    std::vector<double> bCoefficients;

public:
    // Constructor using initializer lists for coefficients
    FourierSeries(double period, std::initializer_list<double> aC, std::initializer_list<double> bC) : T(period), N(std::max(aC.size(), bC.size() - 1)) {
        aCoefficients.assign(aC);
        bCoefficients.assign(bC);
        adjustCoefficientSizes();
    }

    // Constructor using functions to generate coefficients
    FourierSeries(int terms, double period, std::function<double(int)> generateA, std::function<double(int)> generateB) : T(period), N(terms) {
        if (terms < 0) throw std::invalid_argument("Number of terms must be non-negative");
        generateCoefficients(generateA, generateB);
    }

private:
    // Adjusts the sizes of coefficient vectors to match N, filling with zeros as needed
    void adjustCoefficientSizes() {
        if(aCoefficients.size() < N + 1) aCoefficients.resize(N + 1, 0.0);
        if(bCoefficients.size() < N) bCoefficients.resize(N, 0.0);
    }

    // Generates coefficients using the provided functions
    void generateCoefficients(std::function<double(int)> genA, std::function<double(int)> genB) {
        for(int i = 0; i <= N; ++i) {
            aCoefficients.push_back(genA(i));
            if(i > 0) bCoefficients.push_back(genB(i)); // b[0] is not used, so start from 1
        }
    }
};

int main() {
    // Example usage of the FourierSeries class
    FourierSeries series1(2.0, {0, 1, 2, 3}, {0, -1, -2});
    FourierSeries series2(10, 3, [](int n) { return std::cos(n * PI / 4); }, [](int n) { return std::sin(n * PI / 4); });

    return 0;
}