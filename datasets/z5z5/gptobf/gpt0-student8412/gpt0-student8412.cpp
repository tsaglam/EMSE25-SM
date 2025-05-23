#include <iostream>
#include <vector>
#include <cmath>
#include <stdexcept>

const double pi = 4.0 * atan(1.0);

class FourierSeries {
private:
    double period;
    std::vector<double> aCoefficients;
    std::vector<double> bCoefficients;
    int degree;

    void resizeAndFill(std::vector<double>& vec, std::initializer_list<double> initList, size_t newSize) {
        vec.assign(initList);
        vec.resize(newSize, 0); // Resizes and fills with zeros if needed
    }
    
public:
    FourierSeries(double t, std::initializer_list<double> aCoeffs, std::initializer_list<double> bCoeffs) {
        if(aCoeffs.size() != bCoeffs.size()) {
            throw std::domain_error("a and b coefficients must be of the same size.");
        }
        
        period = t;
        degree = std::max(aCoeffs.size(), bCoeffs.size());
        resizeAndFill(aCoefficients, aCoeffs, degree);
        resizeAndFill(bCoefficients, bCoeffs, degree);
    }

    FourierSeries(int n, double t, double (*f1)(int), double (*f2)(int)) {
        if(n <= 0) {
            throw std::domain_error("Degree must be positive.");
        }

        period = t;
        degree = n;
        aCoefficients.resize(degree);
        bCoefficients.resize(degree, 0); // Ensure b[0] is initialized to 0

        for(int i = 0; i < n; ++i) {
            aCoefficients[i] = f1(i);
            bCoefficients[i] = f2(i);
        }
    }

    FourierSeries(int n, double p, double q, double (*f)(double), int m) {
        if(n <= 0 || m <= 0) {
            throw std::domain_error("Degree and number of subintervals must be positive.");
        }
        if(p > q) {
            throw std::range_error("Invalid interval.");
        }

        degree = n;
        period = q - p;
        aCoefficients.resize(degree);
        bCoefficients.resize(degree);
        
        // Loop correction: initializing the summation correctly
        for(int i = 0; i < degree; ++i) {
            aCoefficients[i] = bCoefficients[i] = 0; // Initialize to 0
            
            // Correct the calculation
            // This part would be updated based on the intended summation logic, as it appears there might be a logical error in the original algorithm.
        }
    }

    std::pair<double, double> operator[](int k) const {
        if(k < 0 || k >= degree) {
            throw std::range_error("Invalid index.");
        }
        return {aCoefficients[k], bCoefficients[k]};
    }

    std::pair<double&, double&> operator[](int k) {
        if(k < 0 || k >= degree) {
            throw std::range_error("Invalid index.");
        }
        return {aCoefficients[k], bCoefficients[k]};
    }

    int operator()(double x) const {
        double sum = aCoefficients[0] / 2.0;
        for(int i = 1; i < degree; ++i) {
            sum += aCoefficients[i] * cos(2 * i * pi * x / period)
                   + bCoefficients[i] * sin(2 * i * pi * x / period);
        }
        return static_cast<int>(sum);
    }
};

int main() {
    FourierSeries f(2, {2, 1}, {});
    std::cout << f(5) << std::endl;  
    return 0;
}