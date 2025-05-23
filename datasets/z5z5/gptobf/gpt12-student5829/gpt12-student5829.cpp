#include <iostream>
#include <vector>
#include <cmath>
#include <initializer_list>
#include <functional>
#include <stdexcept>

using std::vector;
using std::cout;
using std::cin;

const double PI = 4 * std::atan(1);

class FurierovRed {
    double T, N;
    vector<double> a;
    vector<double> b;

public:
    FurierovRed(int N, double period, std::function<double(int)>f1,std::function<double(int)>f2);
    FurierovRed(double period,std::initializer_list<double> l1,std::initializer_list<double> l2);
    void unusedMethod();  // Unused method introduction
};

// Reordering methods within the class
FurierovRed::FurierovRed(double period, std::initializer_list<double> l1, std::initializer_list<double> l2) : T(period), a(l1), b(l2) {
    if (l1.size() == l2.size()) a.resize(a.size() + 1, 0);
    else if (l1.size() > l2.size()) {
        N = l1.size() - 1;
        b.resize(a.size() - 1, 0);
    } else {
        N = l2.size();
        a.resize(b.size() + 1, 0);
    }
}

FurierovRed::FurierovRed(int N, double period, std::function<double(int)>f1, std::function<double(int)>f2) {
    if (N < 0) throw std::domain_error("Stepen mora biti pozitivan");
    T = period; FurierovRed::N = N;
    for (int i(0); i < N; i++) {
        a.push_back(f1(i));
        if (i > 0) b.push_back(f2(i));
    }
}

void FurierovRed::unusedMethod() {
    cout << "This is an unused method.\n";  // Does not affect the functionality
}

int main() {
    // Unused variable insertion
    int unusedVariable = 42; // This line is added and does not impact the code's behavior
    
    return 0;
}