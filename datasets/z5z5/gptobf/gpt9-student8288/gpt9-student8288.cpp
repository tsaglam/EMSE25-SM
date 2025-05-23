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

const double PI_VAL = 4 * std::atan(1.0);

struct HarmonicSeries
{
    double a0_coeff;
    std::vector<double> cosine_coeffs;
    std::vector<double> sine_coeffs;
    double period;
    int term_count;
    
    HarmonicSeries(double cycle_time, std::initializer_list<double> cosine_inputs, std::initializer_list<double> sine_inputs) : period(cycle_time)
    {
        if(cosine_inputs.size() == sine_inputs.size())
        {
            a0_coeff = *cosine_inputs.begin(); // initial term
            term_count = cosine_inputs.size();
            cosine_coeffs.resize(term_count); sine_coeffs.resize(term_count);
            size_t idx = 0;
            for(auto iter = std::next(cosine_inputs.begin()); iter != cosine_inputs.end(); ++iter)
            {
                cosine_coeffs[idx++] = *iter;
            }
            std::copy(sine_inputs.begin(), sine_inputs.end(), sine_coeffs.begin());
        }
        else
        {
            bool isCosineBigger = cosine_inputs.size() > sine_inputs.size();
            a0_coeff = *cosine_inputs.begin();
            term_count = isCosineBigger ? cosine_inputs.size() : sine_inputs.size();
            cosine_coeffs.resize(term_count, 0); sine_coeffs.resize(term_count, 0);
            
            if(isCosineBigger)
            {
                std::copy(cosine_inputs.begin(), cosine_inputs.end(), cosine_coeffs.begin());
                std::copy(sine_inputs.begin(), sine_inputs.end(), sine_coeffs.begin());
            }
            else
            {
                std::copy(sine_inputs.begin(), sine_inputs.end(), sine_coeffs.begin());
                std::copy(cosine_inputs.begin(), cosine_inputs.end(), cosine_coeffs.begin());
            }
        }
    };
    
    double computeValue(double x)
    {
        double sum = a0_coeff / 2.0;
        for(int n = 1; n <= term_count; ++n)
        {
            sum += cosine_coeffs[n-1] * std::cos((2 * n * PI_VAL * x) / period) + sine_coeffs[n-1] * std::sin((2 * n * PI_VAL * x) / period);
        }
        return sum;
    };

    std::pair<double, double> getCoefficients(int n) const
    {
        if(n < 0 || n > term_count) throw std::range_error("Invalid index\n");
        if(n == 0) return {a0_coeff, 0.0};
        return {cosine_coeffs[n-1], sine_coeffs[n-1]};
    };

    std::pair<double&, double&> getCoefficientsRef(int n)
    {
        static double dummy = 0.0; // Used for reference binding to zero
        if(n < 0 || n > term_count) throw std::range_error("Invalid index\n");
        if(n == 0) return {a0_coeff, dummy};
        return {cosine_coeffs[n-1], sine_coeffs[n-1]};
    };
};

int main()
{
    HarmonicSeries harmonic(4, {}, {-1.27324, 0.63662, -0.42441, 0.31831, -0.25465, 0.21221, -0.18189, 0.15915, -0.14147, 0.12732});
    try {
        for(int i = 0; i <= 10; ++i) std::cout << harmonic.getCoefficients(i).second << " ";
        std::cout << "\n";
    } catch(const std::range_error& e) {
        std::cout << e.what();
    }
    HarmonicSeries harmonic2(4, {4, 1}, {});
    try {
        for(int i = 0; i <= 2; ++i) std::cout << harmonic2.getCoefficients(i).first << " ";
        std::cout << "\n";
        for(int i = 0; i <= 2; ++i) std::cout << harmonic2.getCoefficients(i).second << " ";
        std::cout << "\n";
    } catch(const std::range_error& e) {
        std::cout << e.what();
    }
    return 0;
}