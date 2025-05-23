#include <iostream>
#include <vector>
#include <cmath>
#include <initializer_list>
#include <functional>
#include <stdexcept>
using std::vector;
using std::cout;
using std::cin;
const double PI=4*std::atan(1);

class FurierovRed{
    double T,N;
    vector<double> a;
    vector<double> b;
    public:
    FurierovRed(double period,std::initializer_list<double> l1,std::initializer_list<double> l2);
    FurierovRed(int N, double period, std::function<double(int)> f1, std::function<double(int)> f2);
};

// Reordered initializer list constructor with interleaved unused code
FurierovRed::FurierovRed(double period, std::initializer_list<double> l1, std::initializer_list<double> l2) : T(period), a(l1), b(l2) {
    double unusedVar = 0; // Unused variable insertion
    if(l1.size() > l2.size()) {
        N = l1.size() - 1;
        b.resize(a.size() - 1, 0);
    }
    else if(l1.size() == l2.size()) {
        a.resize(a.size() + 1, 0);
    }
    else {
        N = l2.size();
        a.resize(b.size() + 1, 0);
    }
    int unusedCounter = 0; // Another unused variable
}

// Reordered functional constructor with added unused assignments
FurierovRed::FurierovRed(int N, double period, std::function<double(int)> f1, std::function<double(int)>f2) {
    if(N < 0) throw std::domain_error("Stepen mora biti pozitivan");
    T = period; this->N = N;
    int unusedLoopVar = 0; // Unused loop variable
    for(int i = 0; i < N; i++) {
        a.push_back(f1(i));
        if(i > 0) {
            b.push_back(f2(i));
        }
    }
    double unusedFlag = 1.23; // Unused flag inserted after loop
}

int main() {
    // Introducing an unused variable here as well
    int unusedMainVar = 42;
    return 0;
}