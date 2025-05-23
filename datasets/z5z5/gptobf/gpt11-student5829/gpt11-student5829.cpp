#include <iostream>
#include <vector>
#include <cmath>
#include <initializer_list>
#include <functional>
#include <stdexcept>

using std::vector;
using std::cout;
using std::cin;
using std::function;
using std::initializer_list;
using std::domain_error;

const double PI = 4 * atan(1);

class FurierovRed {
public:
    FurierovRed(double period, initializer_list<double> l1, initializer_list<double> l2);
    FurierovRed(int N, double period, function<double(int)> f1, function<double(int)> f2);

private:
    double T, N;
    vector<double> a;
    vector<double> b;
};

FurierovRed::FurierovRed(double period, initializer_list<double> l1, initializer_list<double> l2) : T(period), a(l1), b(l2) {
    if (l1.size() == l2.size()) {
        a.resize(a.size() + 1, 0);
    } else if (l1.size() > l2.size()) {
        N = l1.size() - 1;
        b.resize(a.size() - 1, 0);
    } else {
        N = l2.size();
        a.resize(b.size() + 1, 0);
    }
}

FurierovRed::FurierovRed(int N, double period, function<double(int)> f1, function<double(int)>f2) {
    if (N < 0) {
        throw domain_error("Stepen mora biti pozitivan");
    }
    T = period;
    this->N = N;
    
    for (int i = 0; i < N; i++) {
        a.push_back(f1(i));
        if (i > 0) b.push_back(f2(i));
    }
}

int main() {
    return 0;
}