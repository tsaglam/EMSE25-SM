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
        return std::fabs(x-y) <= eps * (std::fabs(x) + std::fabs(y));
    }

public:
    FourierovRed(double T, std::initializer_list<double> redA, std::initializer_list<double> redB);
    FourierovRed(int N, double T, std::function<double(int)> F1, std::function<double(int)> F2);
    FourierovRed(int N, double p, double q, std::function<double(double)> F1, int M);
    double operator() (double h) const;
    FourierovRed& operator=(const FourierovRed &F);
    FourierovRed& operator=(FourierovRed &&F);
    FourierovRed(const FourierovRed &F);
    FourierovRed(FourierovRed &&F);
    std::pair<double, double> operator[](int h) const;
    std::pair<double&, double&> operator[](int h);
};

FourierovRed::FourierovRed(double T, std::initializer_list<double> redA, std::initializer_list<double> redB) : T(T), N(std::max(redA.size(), redB.size())) {
    if (N <= 0 || T <= 0) {
        if (N <= 0) throw std::domain_error("Stepen mora biti pozitivan");
        else throw std::range_error("Neispravan interval");
    }
    this->redA.resize(N+1, 0);
    this->redB.resize(N+1, 0);
    std::copy(redA.begin(), redA.end(), this->redA.begin());
    std::copy(redB.begin(), redB.end(), this->redB.begin() + 1);
}

FourierovRed::FourierovRed(int N, double T, std::function<double(int)> F1, std::function<double(int)> F2) : N(N), T(T) {
    if (N <= 0 || T <= 0) {
        if (N <= 0) throw std::domain_error("Stepen mora biti pozitivan");
        else throw std::range_error("Neispravan interval");
    }
    redA.resize(N+1);
    redB.resize(N+1);
    redB[0] = 0;
    for (int i = 0; i <= N; i++) {
        redA[i] = F1(i);
        redB[i] = i ? F2(i) : 0;
    }
}

FourierovRed::FourierovRed(int N, double p, double q, std::function<double(double)> F, int M) : N(N), T(q - p) {
    if(N <= 0 || M <= 0 || p > q) {
        if (N <= 0 || M <= 0) throw std::domain_error("Stepen i broj podintervala moraju biti pozitivni");
        else throw std::range_error("Neispravan interval");
    }
    redA.resize(N+1, 0);
    redB.resize(N+1, 0);
    for(int i = 0; i <= N; i++) {
        double sumaA = 0, sumaB = 0;
        for(int j = 1; j < M; j++) {
            double x = p + j*T/M;
            sumaA += F(x) * cos(2*i*Pi*x/T);
            sumaB += F(x) * sin(2*i*Pi*x/T);
        }
        redA[i] = 2.0/M * (F(p)/2.0 + sumaA + F(q)/2.0);
        redB[i] = 2.0/M * sumaB;
    }
    redB[0] = 0;
}

FourierovRed::FourierovRed(const FourierovRed &F) : N(F.N), T(F.T), redA(F.redA), redB(F.redB) {}

FourierovRed::FourierovRed(FourierovRed &&F) : N(F.N), T(F.T), redA(std::move(F.redA)), redB(std::move(F.redB)) {}

FourierovRed& FourierovRed::operator=(const FourierovRed &F) {
    if(this != &F) {
        N = F.N;
        T = F.T;
        redA = F.redA;
        redB = F.redB;
    }
    return *this;
}

FourierovRed& FourierovRed::operator=(FourierovRed &&F) {
    if(this != &F) {
        N = F.N;
        T = F.T;
        redA = std::move(F.redA);
        redB = std::move(F.redB);
    }
    return *this;
}

double FourierovRed::operator()(double h) const {
    double suma = redA[0] / 2;
    for (int i = 1; i <= N; i++) {
        suma += redA[i] * std::cos((2*i*Pi*h)/T) + redB[i] * std::sin((2*i*Pi*h)/T);
    }
    return suma;
}

std::pair<double&, double&> FourierovRed::operator[](int h) {
    if(h < 0 || h > N || (h == N && JesuLiJednaki(redA[N], 0) && JesuLiJednaki(redB[N], 0))) throw std::range_error("Neispravan indeks");
    return {redA[h], redB[h]};
}

std::pair<double, double> FourierovRed::operator[](int h) const {
    if(h < 0 || h > N || (h == N && JesuLiJednaki(redA[N], 0) && JesuLiJednaki(redB[N], 0))) throw std::range_error("Neispravan indeks");
    return {redA[h], redB[h]};
}

int main() {
    FourierovRed a(1, {1, 2, 3, 4, 5, 6}, {3, 3, 6, 7});
    return 0;
}