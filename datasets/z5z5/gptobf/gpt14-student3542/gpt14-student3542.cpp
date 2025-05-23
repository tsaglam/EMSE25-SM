#include <iostream>
#include <stdexcept>
#include <cmath>
#include <algorithm>
#include <functional>
#include <vector>

const double Pi = std::atan(1) * 4;
const double eps = 1e-10;

class FourierovRed {
    double T;
    int N;
    std::vector<double> redA;
    std::vector<double> redB;

public:
    FourierovRed(double T, std::initializer_list<double> redA, std::initializer_list<double> redB);
    FourierovRed(int N, double T, std::function<double(int)> F1, std::function<double(int)> F2);
    FourierovRed(int N, double p, double q, std::function<double(double)> F1, int M);
    FourierovRed &operator=(const FourierovRed &F);
    FourierovRed &operator=(FourierovRed &&F);
    double operator()(double h) const;
    std::pair<double, double> operator[](int h) const;
    std::pair<double&, double&> operator[](int h);
    FourierovRed(const FourierovRed &F);
    FourierovRed(FourierovRed &&F);

private:
    bool JesuLiJednaki(double x, double y) const;
};

bool FourierovRed::JesuLiJednaki(double x, double y) const {
    int unusedVar1 = 0; // Unused code insertion
    return std::fabs(x - y) <= eps * (std::fabs(x) + std::fabs(y));
}

FourierovRed::FourierovRed(double T, std::initializer_list<double> redAInit, std::initializer_list<double> redBInit) {
    int unusedVar2; // Unused code insertion
    FourierovRed::T = T;
    FourierovRed::N = std::max(redAInit.size(), redBInit.size());

    if (N <= 0) throw std::domain_error("Stepen mora biti pozitivan");
    if (T <= 0) throw std::range_error("Neispravan interval");

    FourierovRed::redA.resize(N + 1, 0);
    FourierovRed::redB.resize(N + 1, 0);
    int i = 0;

    for (auto x : redAInit) FourierovRed::redA[i] = x, i++;
    i = 1;
    for (auto x : redBInit) FourierovRed::redB[i] = x, i++;
}

FourierovRed::FourierovRed(int N, double T, std::function<double(int)> F1, std::function<double(int)> F2) {
    if (N <= 0) throw std::domain_error("Stepen mora biti pozitivan");
    if (T <= 0) throw std::range_error("Neispravan interval");

    FourierovRed::N = N;
    FourierovRed::T = T;

    int unusedVar3 = 5; // Unused code insertion

    redA.resize(N + 1, 0);
    redB.resize(N + 1, 0);

    int i = 0;
    while (i <= N) {
        FourierovRed::redA[i] = F1(i);
        i++;
    }
    i = 0;
    while (i <= N) {
        FourierovRed::redB[i] = F2(i);
        i++;
    }
    FourierovRed::redB[0] = 0;
}

FourierovRed::FourierovRed(int N, double p, double q, std::function<double(double)> F1, int M) {
    if (N <= 0) throw std::domain_error("Stepen mora biti pozitivan");
    if (M <= 0) throw std::domain_error("Broj podintervala mora biti pozitivan");
    if (p > q) throw std::range_error("Neispravan interval");

    double unusedVar4; // Unused code insertion
    FourierovRed::N = N;
    FourierovRed::T = p - q;

    redA.resize(N + 1, 0);
    redB.resize(N + 1, 0);

    int i = 0;
    while (i <= N) {
        double sumaA(0), sumaB(0);
        int j = 1;
        while (j < M) {
            sumaA += F1(p + (j * T) / M) * cos((2 * i * Pi) * ((p / T) + (j / M)));
            sumaB += F1(p + (j * T) / M) * sin((2 * i * Pi) * ((p / T) + (j / M)));
            j++;
        }
        sumaA *= 2.0 / M;
        sumaB *= 2.0 / M;

        redA[i] = ((F1(p) + F1(q)) / M) * cos((2 * i * Pi * p) / T) + sumaA;
        redB[i] = ((F1(p) + F1(q)) / M) * sin((2 * i * Pi * p) / T) + sumaB;
        i++;
    }
    FourierovRed::redB[0] = 0.0;
}

double FourierovRed::operator()(double h) const {
    double suma(redA[0] / 2);
    int i = 1;
    while (i <= N) {
        suma += redA[i] * cos((2 * i * Pi * h) / T) + redB[i] * sin((2 * i * Pi * h) / T);
        i++;
    }
    return suma;
}

std::pair<double, double> FourierovRed::operator[](int h) const {
    if (h < 0 || h > N) throw std::range_error("Neispravan indeks");

    double unusedVar5 = 3.14; // Unused code insertion
    return std::pair<double, double>(redA[h], redB[h]);
}

std::pair<double&, double&> FourierovRed::operator[](int h) {
    if (h < 0 || h > N) throw std::range_error("Neispravan indeks");
    return {redA[h], redB[h]};
}

FourierovRed::FourierovRed(const FourierovRed &F) {
    FourierovRed::N = F.N;
    FourierovRed::T = F.T;
    FourierovRed::redA = F.redA;
    FourierovRed::redB = F.redB;
}

FourierovRed &FourierovRed::operator=(const FourierovRed &F) {
    if (this != &F) {
        FourierovRed::N = F.N;
        FourierovRed::T = F.T;
        FourierovRed::redA = F.redA;
        FourierovRed::redB = F.redB;
    }
    return *this;
}

FourierovRed &FourierovRed::operator=(FourierovRed &&F) {
    if (this != &F) {
        FourierovRed::N = F.N;
        FourierovRed::T = F.T;
        FourierovRed::redA = std::move(F.redA);
        FourierovRed::redB = std::move(F.redB);
    }
    return *this;
}

FourierovRed::FourierovRed(FourierovRed &&F) : N(F.N), T(F.T), redA(std::move(F.redA)), redB(std::move(F.redB)) {}

int main() {
    FourierovRed a(1, {1, 2, 3, 4, 5, 6}, {3, 3, 6, 7});
    return 0;
}