#include <iostream>
#include <cmath>
#include <vector>
#include <functional>

const double PI = acos(-1);
const double EPSILON = 1e-10;

class FourierSeries {
    double period;
    int degree;
    std::vector<double> aCoefficients;
    std::vector<double> bCoefficients;

    static bool approximatelyEqual(double a, double b) {
        return std::fabs(a - b) <= EPSILON * std::fabs(a + b);
    }

public:
    FourierSeries(double T, std::initializer_list<double> aList, std::initializer_list<double> bList)
        : period(T), degree(std::max(aList.size(), bList.size())), aCoefficients(aList), bCoefficients(bList.size()+1, 0.0) {
            if (T <= 0) throw std::range_error("Invalid period");
            if (degree <= 0) throw std::domain_error("Degree must be positive");
            std::copy(bList.begin(), bList.end(), bCoefficients.begin() + 1);
    }
    
    FourierSeries(int N, double T, std::function<double(int)> aFunc, std::function<double(int)> bFunc)
        : period(T), degree(N), aCoefficients(N + 1), bCoefficients(N + 1, 0.0) {
            if (T <= 0) throw std::range_error("Invalid period");
            if (N <= 0) throw std::domain_error("Degree must be positive");
            for (int i = 0; i <= N; ++i) {
                aCoefficients[i] = aFunc(i);
                bCoefficients[i] = (i == 0) ? 0 : bFunc(i);
            }
    }

    FourierSeries(int N, double p, double q, std::function<double(double)> func, int M)
        : period(q - p), degree(N), aCoefficients(N + 1), bCoefficients(N + 1, 0.0) {
            if (N <= 0 || M <= 0) throw std::domain_error("Degree and subinterval count must be positive");
            if (q <= p) throw std::range_error("Invalid interval");
            for (int n = 0; n <= N; ++n) {
                double sumA = 0, sumB = 0;
                for (int j = 1; j < M; ++j) {
                    double x = p + j * (period / M);
                    double cosTerm = std::cos(2 * PI * n * x / period);
                    double sinTerm = std::sin(2 * PI * n * x / period);
                    sumA += func(x) * cosTerm;
                    sumB += func(x) * sinTerm;
                }
                aCoefficients[n] = 2 * sumA / M;
                bCoefficients[n] = (n == 0) ? 0 : 2 * sumB / M;
            }
    }

    double operator()(double x) const {
        double result = aCoefficients[0] / 2;
        for (int i = 1; i <= degree; ++i) {
            result += aCoefficients[i] * std::cos(2 * PI * i * x / period) + bCoefficients[i] * std::sin(2 * PI * i * x / period);
        }
        return result;
    }

    std::pair<double, double> operator[](int index) const {
        if ((index < 0) || (index > degree) || (approximatelyEqual(aCoefficients[index], 0.0) && approximatelyEqual(bCoefficients[index], 0.0))) {
            throw std::range_error("Invalid index");
        }
        return {aCoefficients[index], bCoefficients[index]};
    }

    // Overloads of assignment operators and copy/move constructors are omitted for brevity but should follow a similar pattern to provided code.
};

int main() {
    FourierSeries series(1, {1, 2, 3, 4, 5, 6}, {3, 3, 6, 7});
    return 0;
}