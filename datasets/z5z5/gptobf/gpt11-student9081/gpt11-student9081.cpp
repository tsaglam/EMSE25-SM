#include <iostream>
#include <stdexcept>
#include <vector>
#include <functional>
#include <cmath>
#include <initializer_list>
#include <utility>

const double PI(4*std::atan(1));
double nula(0);

class FourierovRed
{
public:
    FourierovRed(double T, std::initializer_list<double> koef1, std::initializer_list<double> koef2);
    FourierovRed(int n, double T, std::function<double(int)> f1, std::function<double(int)> f2);
    FourierovRed(int n, double p, double q, std::function<double(double)> f, int M);
    FourierovRed(const FourierovRed &f) = default;
    FourierovRed(FourierovRed &&f);
    FourierovRed &operator=(const FourierovRed &f) = default;
    FourierovRed &operator=(FourierovRed &&f);
    ~FourierovRed() = default;
    double operator()(double x) const;
    std::pair<double, double> operator[](int k) const;
    std::pair<double&, double&> operator[](int k);

private:
    double period;
    int stepen;
    std::vector<double> ak, bk;
};

FourierovRed::FourierovRed(double T, std::initializer_list<double> koef1, std::initializer_list<double> koef2): period(T)
{
    stepen = std::max(koef1.size() - 1, koef2.size());
    ak.resize(stepen + 1);
    bk.resize(stepen);
    
    auto it1 = koef1.begin(), it2 = koef2.begin();
    
    for (int i = 0; i <= stepen; i++)
    {
        ak[i] = i < koef1.size() ? *it1++ : 0;
    }
    for (int i = 0; i < stepen; i++)
    {
        bk[i] = i < koef2.size() ? *it2++ : 0;
    }
}

FourierovRed::FourierovRed(int n, double T, std::function<double(int)> f1, std::function<double(int)> f2): period(T), stepen(n)
{
    if (n <= 0) throw std::domain_error("Stepen mora biti pozitivan");
    
    ak.resize(n + 1);
    bk.resize(n);
    
    for (int i = 0; i <= n; i++)
    {
        ak[i] = f1(i);
    }
    for (int i = 0; i < n; i++)
    {
        bk[i] = f2(i + 1);
    }
}

FourierovRed::FourierovRed(int n, double p, double q, std::function<double(double)> f, int M): period(q - p), stepen(n)
{
    if (n <= 0 || M <= 0 || p >= q) throw std::domain_error("Neispravan unos");
    
    ak.resize(n + 1);
    bk.resize(n);
    
    double coef_p = 2. * PI / period; // Used in the loop
    
    for (int i = 0; i <= n; ++i)
    {
        double suma = 0;
        for (int j = 1; j <= M - 1; ++j)
        {
            double x = p + j * period / M;
            suma += f(x) * std::cos(i * coef_p * x);
        }
        suma *= 2 / double(M);
        ak[i] = (f(p) + f(q)) / M * std::cos(i * coef_p * p) + suma;
    }
    for (int i = 0; i < n; ++i)
    {
        double suma = 0;
        for (int j = 1; j <= M - 1; ++j)
        {
            double x = p + j * period / M;
            suma += f(x) * std::sin((i + 1) * coef_p * x);
        }
        suma *= 2 / double(M);
        bk[i] = (f(p) + f(q)) / M * std::sin((i + 1) * coef_p * p) + suma;
    }
}

FourierovRed::FourierovRed(FourierovRed &&f): period(f.period), stepen(f.stepen), ak(std::move(f.ak)), bk(std::move(f.bk))
{
    f.ak.clear();
    f.bk.clear();
}

FourierovRed &FourierovRed::operator=(FourierovRed &&f)
{
    std::swap(period, f.period);
    std::swap(stepen, f.stepen);
    std::swap(ak, f.ak);
    std::swap(bk, f.bk);
    return *this;
}

double FourierovRed::operator()(double x) const
{
    double result = ak[0] / 2.0;
    for (int i = 1; i <= stepen; ++i)
    {
        result += ak[i] * std::cos(2 * i * PI * x / period) + bk[i - 1] * std::sin(2 * i * PI * x / period);
    }
    return result;
}

std::pair<double, double> FourierovRed::operator[](int k) const
{
    if (k < 0 || k > stepen) throw std::range_error("Neispravan indeks");
    if (k == 0) return std::make_pair(ak[0], 0);
    return std::make_pair(ak[k], bk[k - 1]);
}

std::pair<double&, double&> FourierovRed::operator[](int k)
{
    if (k < 0 || k > stepen) throw std::range_error("Neispravan indeks");
    if (k == 0)
    {
        nula = 0;
        return std::pair<double&, double&>(ak[0], nula);
    }
    return std::pair<double&, double&>(ak[k], bk[k - 1]);
}

int main()
{
    for (;;)
    {
        std::cout << "Unesite stepen Fourierovovog reda: ";
        int m;
        std::cin >> m;
        if (m == -1) break;

        std::cout << "Unesite broj podintervala za procjenu: ";
        int n;
        std::cin >> n;

        std::cout << "Unesite tabku gdje se rapuna vrijednost Fourierovovog reda: ";
        double x;
        std::cin >> x;

        try 
        {
            FourierovRed f1(m, 0, 2 * PI, [] (double x) { return x * x; }, n),
                         f2(m, 2 * PI, [] (int k) { return k == 0 ? 8 * PI * PI / 3 : 4. / (k * k); }, [](int k) { return -4 * PI / k; });
            std::cout << "Vrijednosti su:\n";
            std::cout << "f1(" << x << ") = " << f1(x) << " i " <<"f2(" << x << ") = " << f2(x);
        }
        catch(const std::exception& e)
        {
            std::cout << "Greska! Unesite ponovo!\n";
        }
    }
    return 0;
}