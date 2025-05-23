#include <iostream>
#include <vector>
#include <functional>
#include <stdexcept>
#include <initializer_list>
#include <cmath>

const double PI = 4*std::atan(1);

class FourierovRed {
    std::vector<double> ak, bk;
    double a0, T;
    int N;
    double b0;

public:
    FourierovRed(double period, std::initializer_list<double> a, std::initializer_list<double> b) : T(period) {
        a0 = *(a.begin());
        auto it2(a.begin());
        if(a.size() == b.size()) {
            N = a.size();
            ak.resize(N); bk.resize(N);
            int i(0); auto it(a.begin()); it++;
            for(; it != a.end(); it++) {
                ak[i] = *it; i++;
            }
            ak[i+1] = 0; int j(0);
            for(auto it1(b.begin()); it1 != b.end(); it1++) {
                bk[j] = *it1; j++;
            }
        }
        if(a.size() < b.size()) {
            N = b.size();
            ak.resize(N); bk.resize(N); int i(0), j(0);
            for(auto it(b.begin()); it != b.end(); it++) {
                bk[i] = *it; i++;
            }
            if(it2 != a.end()) { it2++;
                for(; it2 != a.end(); it2++) {
                    ak[j] = *it2; j++;
                }
            }
            for(int k(j); k < N; k++) {
                ak[k] = 0;
            }
        }
        if(a.size() > b.size()) {
            N = a.size();
            ak.resize(N); bk.resize(N); int i(0), j(0);
            auto it(a.begin()); it++;
            for(; it != a.end(); it++) {
                 ak[i] = *it; i++;
            }
            for(auto it1(b.begin()); it1 != b.end(); it1++) {
                bk[j] = *it1; j++;
            }
            for(int k(j); k < i; k++) {
                bk[k] = 0;
            }
        }
    }
    
    FourierovRed(int n, double period, std::function<double(int)> f1, std::function<double(int)> f2) : T(period), N(n) {
        if(n < 0) throw std::domain_error("Stepen mora biti pozitivan\n");
        ak.resize(N); bk.resize(N);
        a0 = f1(0);
        for(int i(1); i < n; i++) {
            ak[i-1] = f1(i);
            bk[i-1] = f2(i);
        }
    }
    
    FourierovRed(int n, double p, double q, std::function<double(double)> f, int M) {
        if(n < 0 || M < 0 || p > q) {
            throw std::domain_error("Pogresan parametar\n");
        }
        N = n; T = q - p;
        ak.resize(N); bk.resize(N);
        for(int k(0); k <= n; k++) {
            double sumaA(0), sumaB(0);
            for(int i(1); i <= M-1; i++) {
                sumaA += f(p + (i*T)/M)*std::cos(2*k*PI*(p/T + i/M));
                if(k != 0) sumaB += f(p + (i*T)/M)*std::sin(2*k*PI*(p/T + i/M));
            }
            if(k == 0) a0 = (2*sumaA)/M + ((f(p) + f(q))/M);
            if(k != 0) {
                ak[k-1] = (2*sumaA)/M + ((f(p) + f(q))/M)*std::cos((2*k*PI*p)/T);
                bk[k-1] = (2*sumaB)/M + ((f(p) + f(q))/M)*std::sin((2*k*PI*p)/T);
            }
        }
    }
    
    FourierovRed(const FourierovRed &r) : ak(r.ak), bk(r.bk), N(r.N), T(r.T), a0(r.a0) {}

    FourierovRed(FourierovRed &&r) : ak(std::move(r.ak)), bk(std::move(r.bk)), N(r.N), T(r.T), a0(r.a0) {}

    FourierovRed &operator =(const FourierovRed &r) {
        if(this == &r) return *this;
        ak = r.ak; bk = r.bk; N = r.N; T = r.T; a0 = r.a0;
        return *this;
    }

    FourierovRed &operator =(FourierovRed &&r) {
        if(this == &r) return *this;
        ak = std::move(r.ak); bk = std::move(r.bk); N = r.N; T = r.T; a0 = r.a0;
        return *this;
    }

    double operator()(double x) {
        double rezultat(a0/2);
        for(int k(1); k <= N; k++) {
            rezultat += ak[k-1]*cos((2*k*PI*x)/T) + bk[k-1]*sin((2*k*PI*x)/T);
        }
        return rezultat;
    }

    std::pair<double, double> operator [](int k) const {
        if(k < 0 || k > N) throw std::range_error("Neispravan indeks\n");
        return k == 0 ? std::pair<double, double>(a0, 0.) : std::pair<double, double>(ak[k-1], bk[k-1]);
    }

    std::pair<double&, double&> operator [](int k) {
        if(k < 0 || k > N) throw std::range_error("Neispravan indeks\n");
        return k == 0 ? std::pair<double&, double&>(a0, b0 = 0) : std::pair<double&, double&>(ak[k-1], bk[k-1]);
    }
};

int main() {
    FourierovRed f(4, {}, {-1.27324, 0.63662, -0.42441, 0.31831, -0.25465, 0.21221, -0.18189, 0.15915, -0.14147, 0.12732});
    try {
        for(int i = 0; i <= 10; i++) std::cout << f[i].second << " ";
        std::cout << "\n";
    } catch(const std::range_error& e) {
        std::cout << e.what();
    }

    FourierovRed f1(4, {4, 1}, {});
    try {
        for(int i = 0; i <= 2; i++) std::cout << f1[i].first << " ";
        std::cout << "\n";
        for(int i = 0; i <= 2; i++) std::cout << f1[i].second << " ";
        std::cout << "\n";
    } catch(const std::range_error& e) {
        std::cout << e.what();
    }
    return 0;
}