#include <iostream>
#include <stdexcept>
#include <cmath>
#include <algorithm>
#include <functional>
#include <vector>

const double Pi = std::atan(1)*4;
const double eps = 1e-10;

class FourierovRed {
    double T;
    int N;
    std::vector<double> redA;
    std::vector<double> redB;
    
    bool JesuLiJednaki(double x, double y) const {
        return std::fabs(x - y) <= eps * (std::fabs(x) + std::fabs(y));
    }
    
public:
    FourierovRed(double T, std::initializer_list<double> a, std::initializer_list<double> b);
    FourierovRed(int N, double T, std::function<double(int)> F1, std::function<double(int)> F2);
    FourierovRed(int N, double p, double q, std::function<double(double)> F1, int M);
    double operator()(double h) const;
    FourierovRed& operator=(const FourierovRed& F);
    FourierovRed& operator=(FourierovRed&& F) noexcept;
    
    FourierovRed(const FourierovRed& F) = default;
    FourierovRed(FourierovRed&& F) noexcept = default;

    std::pair<double&, double&> operator[](int h);
    std::pair<double, double> operator[](int h) const;
};

FourierovRed::FourierovRed(double T, std::initializer_list<double> a, std::initializer_list<double> b)
: T(T), N(std::max(a.size(), b.size())), redA(a), redB(b.size() + 1, 0.0) {
    if(N <= 0) throw std::domain_error("Stepen mora biti pozitivan");
    if(T <= 0) throw std::range_error("Neispravan interval");
    std::copy(b.begin(), b.end(), redB.begin() + 1);
}

FourierovRed::FourierovRed(int N, double T, std::function<double(int)> F1, std::function<double(int)> F2)
: N(N), T(T) {
    if(N <= 0) throw std::domain_error("Stepen mora biti pozitivan");
    if(T <= 0) throw std::range_error("Neispravan interval");

    redA.resize(N+1, 0);
    redB.resize(N+1, 0);

    for(int i = 0; i <= N; ++i) {
        redA[i] = F1(i);
        redB[i] = (i == 0 ? 0 : F2(i));
    }
}

FourierovRed::FourierovRed(int N, double p, double q, std::function<double(double)> F, int M)
: N(N), T(q - p) {
    if(N <= 0 || M <= 0 || p > q) throw std::domain_error("Invalid parameters");

    redA.resize(N+1, 0);
    redB.resize(N+1, 0);

    for(int i = 0; i <= N; ++i) {
        double sumaA = 0, sumaB = 0;
        for(int j = 1; j < M; ++j) {
            double x = p + (j*T)/M;
            sumaA += F(x) * std::cos(2*i*Pi*x/T);
            sumaB += F(x) * std::sin(2*i*Pi*x/T);
        }
        redA[i] = (F(p) + F(q)) * std::cos(i*2*Pi*p/T) / M + 2*sumaA/M;
        redB[i] = (F(p) + F(q)) * std::sin(i*2*Pi*p/T) / M + 2*sumaB/M;
    }
    redB[0] = 0.0;
}

FourierovRed& FourierovRed::operator=(const FourierovRed& F) {
    if(this != &F) {
        T = F.T;
        N = F.N;
        redA = F.redA;
        redB = F.redB;
    }
    return *this;
}

FourierovRed& FourierovRed::operator=(FourierovRed&& F) noexcept {
    if(this != &F) {
        T = std::move(F.T);
        N = std::move(F.N);
        redA = std::move(F.redA);
        redB = std::move(F.redB);
    }
    return *this;
}

double FourierovRed::operator()(double h) const {
    double sum = redA[0] / 2.0;
    for(int i = 1; i <= N; ++i) {
        sum += redA[i] * cos(2*i*Pi*h/T) + redB[i] * sin(2*i*Pi*h/T);
    }
    return sum;
}

std::pair<double&, double&> FourierovRed::operator[](int h) {
    if(h < 0 || h > N) throw std::range_error("Neispravan indeks");
    return {redA[h], redB[h]};
}

std::pair<double, double> FourierovRed::operator[](int h) const {
    if(h < 0 || h > N) throw std::range_error("Neispravan indeks");
    return {redA[h], redB[h]};
}

int main() {
    try {
        FourierovRed a(1, {1,2,3,4,5,6}, {3,3,6,7});
        std::cout << a(0.5) << std::endl;
    } catch(const std::exception& e) {
        std::cout << "Exception: " << e.what() << std::endl;
    }
    return 0;
}