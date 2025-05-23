#include <iostream>
#include <vector>
#include <cmath>
#include <initializer_list>
#include <functional>
#include <stdexcept>

// Use explicit namespaces instead of "using" for the entire namespace
const double PI = 4 * atan(1.0);

class FourierSeries {
    double period, numberOfTerms;
    std::vector<double> coefficientsA;
    std::vector<double> coefficientsB;

    public:
    FourierSeries(double T, std::initializer_list<double> alpha, std::initializer_list<double> beta);
    FourierSeries(int termCount, double T, std::function<double(int)> calcA, std::function<double(int)> calcB);
};

FourierSeries::FourierSeries(double T, std::initializer_list<double> alpha, std::initializer_list<double> beta) : period(T), coefficientsA(alpha), coefficientsB(beta) {
    if (alpha.size() == beta.size()) coefficientsA.emplace_back(0.0);
    else if (alpha.size() > beta.size()) {
        numberOfTerms = alpha.size() - 1;
        coefficientsB.resize(coefficientsA.size() - 1, 0.0);
    } else {
        numberOfTerms = beta.size();
        coefficientsA.resize(coefficientsB.size() + 1, 0.0);
    }
    // Uncomment below for debugging
    // for (const auto& value : coefficientsA) std::cout << value << " ";
    // std::cout << "\n";
    // for (const auto& value : coefficientsB) std::cout << value << " ";
}

FourierSeries::FourierSeries(int termCount, double T, std::function<double(int)> calcA, std::function<double(int)> calcB) {
    if (termCount < 0) throw std::domain_error("Term count must be positive");
    period = T; this->numberOfTerms = termCount;
    for (int i = 0; i < termCount; ++i) {
        coefficientsA.push_back(calcA(i));
        if (i > 0) coefficientsB.push_back(calcB(i));
    }
}

int main() {
    // Implement your functionality or leave empty for lib-like usage
    return 0;
}