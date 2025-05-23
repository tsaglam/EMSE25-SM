#include <iostream>
#include <stdexcept>
#include <vector>
#include <initializer_list>
#include <utility>
#include <functional>
#include <cmath>

const double PI_VAL(3.14159265358979323846);
double zeroValue(0);

class HarmonicSeries
{
    double cycle;
    int degree;
    std::vector<double> aCoeff, bCoeff;
public:
    HarmonicSeries(double Period, std::initializer_list<double> a, std::initializer_list<double> b);
    HarmonicSeries(int Degree, double Period, std::function<double(int)> aFunc, std::function<double(int)> bFunc);
    HarmonicSeries(int Degree, double start, double end, std::function<double(double)> func, int samples);
    ~HarmonicSeries() = default;
    HarmonicSeries(const HarmonicSeries& hs) = default;
    HarmonicSeries(HarmonicSeries&& hs);
    HarmonicSeries& operator=(const HarmonicSeries& hs) = default;
    HarmonicSeries& operator=(HarmonicSeries&& hs);
    double operator()(double x) const;
    std::pair<double, double> operator[](int k) const;
    std::pair<double&, double&> operator[](int k);
};

std::pair<double, double> HarmonicSeries::operator[](int k) const
{
    if (k < 0 || k > degree) throw std::range_error("Invalid index");
    if (k == 0) return std::make_pair(aCoeff[0], 0);
    return std::make_pair(aCoeff[k], bCoeff[k - 1]);
}

std::pair<double&, double&> HarmonicSeries::operator[](int k)
{
    if (k < 0 || k > degree) throw std::range_error("Invalid index");
    if (k == 0)
    {
        zeroValue = 0;
        std::pair<double&, double&> result(aCoeff[0], zeroValue);
        return result;
    }
    std::pair<double&, double&> result(aCoeff[k], bCoeff[k - 1]);
    return result;
}

double HarmonicSeries::operator()(double x) const
{
    double sum(0);
    for (int i = 1; i < degree + 1; i++)
        sum += aCoeff[i] * std::cos(2 * i * PI_VAL * x / cycle);
    for (int i = 0; i < degree; i++)
        sum += bCoeff[i] * std::sin(2 * (i + 1) * PI_VAL * x / cycle);
    sum += aCoeff[0] / 2;
    return sum;
}

HarmonicSeries::HarmonicSeries(int Degree, double start, double end, std::function<double(double)> func, int samples): cycle(end - start), degree(Degree)
{
    if (Degree <= 0) throw std::domain_error("Degree must be positive");
    if (samples <= 0) throw std::domain_error("Sample count must be positive");
    if (!(start < end)) throw std::range_error("Invalid interval");
    aCoeff.resize(Degree + 1); bCoeff.resize(Degree);
    for (int i = 0; i < Degree + 1; i++)
    {
        double total(0);
        for (int j = 1; j <= samples - 1; j++)
            total += (func(start + j * cycle / samples)) * std::cos(2 * i * PI_VAL * (double(start) / cycle + double(j) / samples));
        total *= 2; total /= samples;
        aCoeff[i] = (func(start) + func(end)) / samples * std::cos(double(2 * i * PI_VAL * start) / cycle) + total;
    }
    for (int i = 0; i < Degree; i++)
    {
        double total(0);
        for (int j = 1; j <= samples - 1; j++)
            total += (func(start + j * cycle / samples)) * std::sin(2 * (i + 1) * PI_VAL * (double(start) / cycle + double(j) / samples));
        total *= 2; total /= samples;
        bCoeff[i] = (func(start) + func(end)) / samples * std::sin(double(2 * (i + 1) * PI_VAL * start) / cycle) + total;
    }
}

HarmonicSeries::HarmonicSeries(int Degree, double Period, std::function<double(int)> aFunc, std::function<double(int)> bFunc) : cycle(Period), degree(Degree)
{
    if (Degree <= 0) throw std::domain_error("Degree must be positive");
    aCoeff.resize(Degree + 1); bCoeff.resize(Degree);
    for (int i = 0; i < Degree + 1; i++)
        aCoeff[i] = aFunc(i);
    for (int i = 0; i < Degree; i++)
        bCoeff[i] = bFunc(i + 1);
}

HarmonicSeries::HarmonicSeries(double Period, std::initializer_list<double> a, std::initializer_list<double> b) : cycle(Period)
{
    int size = b.size();
    if (a.size() - 1 > b.size()) size = a.size() - 1;
    degree = size;
    aCoeff.resize(degree + 1); bCoeff.resize(degree);
    auto it_a = a.begin(), it_b = b.begin();
    for (int i = 0; i < size + 1; i++)
    {
        if (i < a.size())
        {
            aCoeff[i] = *it_a;
            ++it_a;
        }
        else aCoeff[i] = 0;
    }
    for (int i = 0; i < size; i++)
    {
        if (i < b.size())
        {
            bCoeff[i] = *it_b;
            ++it_b;
        }
        else bCoeff[i] = 0;
    }
}

HarmonicSeries::HarmonicSeries(HarmonicSeries&& hs) : cycle(hs.cycle), degree(hs.degree), aCoeff(std::move(hs.aCoeff)), bCoeff(std::move(hs.bCoeff))
{
    hs.aCoeff.clear();
    hs.bCoeff.clear();
}

HarmonicSeries& HarmonicSeries::operator=(HarmonicSeries&& hs)
{
    std::swap(cycle, hs.cycle); std::swap(degree, hs.degree);
    std::swap(aCoeff, hs.aCoeff); std::swap(bCoeff, hs.bCoeff);
    return *this;
}

int main()
{
    for (;;)
    {
        std::cout << "Enter the degree of Fourier series: ";
        int deg;
        std::cin >> deg;
        if (deg == -1) break;
        std::cout << "Enter the number of subintervals for estimation: ";
        int intervals;
        std::cin >> intervals;
        std::cout << "Enter the point to compute the Fourier series value: ";
        double point;
        std::cin >> point;
        try
        {
            HarmonicSeries hs1(deg, 0, 2 * PI_VAL, [](double x) { return x * x; }, intervals), hs2(deg, 2 * PI_VAL, [](int k) { return k == 0 ? 8 * PI_VAL * PI_VAL / 3 : 4. / (k * k); }, [](int k) { return -4 * PI_VAL / k; });
            std::cout << "Values are:\n";
            std::cout << "hs1(" << point << ") = " << hs1(point) << " and " << "hs2(" << point << ") = " << hs2(point);
        }
        catch (...)
        { std::cout << "An error occurred! Please try again.\n"; }
    }
    return 0;
}