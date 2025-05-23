#include <iostream>
#include <stdexcept>
#include <cmath>
#include <vector>
#include <functional>
#include <algorithm>

const double Pi = std::atan(1) * 4;
const double eps = 1e-10;

class FourierSeries
{
private:
    int N;
    double T;
    std::vector<double> aCoefficients, bCoefficients;
    
public:
    FourierSeries(double T, std::initializer_list<double> aCoeffs, std::initializer_list<double> bCoeffs)
        : T(T), N(std::max(aCoeffs.size(), bCoeffs.size()))
    {
        if (N <= 0) throw std::domain_error("Degree must be positive");
        if (T <= 0) throw std::range_error("Invalid interval");
        aCoefficients.assign(aCoeffs);
        bCoefficients.assign(bCoeffs);
        aCoefficients.resize(N + 1, 0);
        bCoefficients.resize(N + 1, 0);
    }
    
    FourierSeries(int N, double T, std::function<double(int)> aFunc, std::function<double(int)> bFunc)
        : N(N), T(T)
    {
        if (N <= 0 || T <= 0) throw std::domain_error("Positive degree and valid interval are required");
        initializeFromFunctions(std::move(aFunc), std::move(bFunc));
    }
    
    FourierSeries(int N, double p, double q, std::function<double(double)> F, int M)
        : N(N), T(q - p)
    {
        if (N <= 0 || M <= 0 || p >= q) throw std::domain_error("Positive degree, positive number of subintervals, and valid interval are required");
        computeCoefficients(p, q, std::move(F), M);
    }
    
    double operator() (double h) const
    {
        double sum = aCoefficients[0] / 2;
        for (int i = 1; i <= N; ++i)
        {
            sum += aCoefficients[i] * std::cos((2 * i * Pi * h) / T)
                 + bCoefficients[i] * std::sin((2 * i * Pi * h) / T);
        }
        return sum;
    }

    std::pair<double&, double&> operator[] (int h)
    {
        validateIndex(h);
        return {aCoefficients[h], bCoefficients[h]};
    }
    
    std::pair<double, double> operator[] (int h) const
    {
        validateIndex(h);
        return {aCoefficients[h], bCoefficients[h]};
    }
    
private:
    void validateIndex(int h) const
    {
        if (h < 0 || h > N) throw std::range_error("Invalid index");
    }

    void initializeFromFunctions(std::function<double(int)> aFunc, std::function<double(int)> bFunc)
    {
        aCoefficients.resize(N + 1);
        bCoefficients.resize(N + 1);
        for (int i = 0; i <= N; ++i)
        {
            aCoefficients[i] = aFunc(i);
            bCoefficients[i] = (i == 0 ? 0 : bFunc(i));
        }
    }

    void computeCoefficients(double p, double q, std::function<double(double)> F, int M)
    {
        aCoefficients.resize(N + 1, 0);
        bCoefficients.resize(N + 1, 0);
        double step = T / M;
        for (int i = 0; i <= N; ++i)
        {
            for (int j = 1; j < M; ++j)
            {
                double x = p + j * step;
                double cosPart = std::cos(2 * i * Pi * x / T);
                double sinPart = std::sin(2 * i * Pi * x / T);
                aCoefficients[i] += F(x) * cosPart;
                bCoefficients[i] += F(x) * sinPart;
            }
            aCoefficients[i] *= 2.0 / M;
            bCoefficients[i] *= 2.0 / M;
        }
        bCoefficients[0] = 0.0; // Ensure b0 is always zero as per Fourier series definition
    }
};

int main()
{
    try {
        FourierSeries series(6.28, {1, 2, 3, 4, 5, 6}, {3, 3, 6, 7});
        std::cout << "Series computation for 1.0: " << series(1.0) << std::endl;
    }
    catch (const std::exception& e) {
        std::cerr << "An error occurred: " << e.what() << std::endl;
    }
    return 0;
}