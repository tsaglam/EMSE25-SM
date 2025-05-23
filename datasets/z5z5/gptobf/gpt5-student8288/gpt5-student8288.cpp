#include <iostream>
#include <cstdlib>
#include <iomanip>
#include <stdexcept>
#include <algorithm>
#include <string>
#include <memory>
#include <map>
#include <utility>
#include <type_traits>
#include <vector>
#include <cmath>
#include <initializer_list>
#include <functional>

constexpr double PI = 3.14159265358979323846;

class FourierSeries
{
    std::map<int, std::pair<double, double>> coefficients;
    double period;
    double constantTerm = 0;
    size_t termCount = 0;

public:
    FourierSeries(double T, std::initializer_list<double> aCoeffs, std::initializer_list<double> bCoeffs) : period(T) {
        auto aIt = aCoeffs.begin();
        auto bIt = bCoeffs.begin();
        constantTerm = *aIt++;
        termCount = std::max(aCoeffs.size(), bCoeffs.size()) - 1;
        
        for(size_t i = 0; aIt != aCoeffs.end() && bIt != bCoeffs.end(); ++aIt, ++bIt, ++i) {
            coefficients[i] = {*aIt, *bIt};
        }

        if(aCoeffs.size() > bCoeffs.size()) {
            std::for_each(bIt, bCoeffs.end(), [&](double val){
                coefficients[termCount++] = {val, 0};
            });
        } else {
            std::for_each(aIt, aCoeffs.end(), [&](double val){
                coefficients[termCount++] = {0, val};
            });
        }
    }
    
    FourierSeries(size_t n, double T, std::function<double(int)> aFunc, std::function<double(int)> bFunc) : period(T), termCount(n) {
        if(n < 0) throw std::domain_error("Degree must be positive.");
        constantTerm = aFunc(0);
        for(int i = 1; i <= n; ++i) {
            coefficients[i-1] = {aFunc(i), bFunc(i)};
        }
    }
    
    double getValue(double x) const {
        double sum = constantTerm / 2;
        for(auto &coeff: coefficients) {
            sum += coeff.second.first * cos((2 * coeff.first * PI * x) / period) + coeff.second.second * sin((2 * coeff.first * PI * x) / period);
        }
        return sum;
    }
    
    std::pair<double, double> getCoefficient(int n) const {
        if(n < 0 || n > termCount) throw std::range_error("Invalid index.");
        if(n == 0) return {constantTerm, 0.0};
        auto it = coefficients.find(n - 1);
        if(it != coefficients.end()) {
            return it->second;
        }
        return {0.0, 0.0};
    }
};

int main() {
    FourierSeries series(2.0, {0, 2.5, 1.3}, {0, -1.2, 0.5});
    try {
        for(int i = 0; i <= 3; i++) {
            auto coeff = series.getCoefficient(i);
            std::cout << "a" << i << ": " << coeff.first << ", b" << i << ": " << coeff.second << std::endl;
        }
    } catch (const std::range_error& err) {
        std::cout << err.what() << std::endl;
    }

    return 0;
}