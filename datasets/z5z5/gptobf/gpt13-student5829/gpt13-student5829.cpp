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
    FurierovRed(int N, double period, std::function<double(int)>f1, std::function<double(int)>f2);
    FurierovRed(double period, std::initializer_list<double> l1, std::initializer_list<double> l2);

    // Unused method 1
    void unusedMethod1() {
        cout << "Unused 1\n";
        int unusedVariable1 = 10;
    }

    // Unused method 2
    void unusedMethod2() {
        cout << "Unused 2\n";
        double unusedVariable2 = 20.5;
    }

    // Unused method 3
    void unusedMethod3() {
        cout << "Unused 3\n";
        std::string unusedVariable3 = "Hello, Unused!";
    }
};

FurierovRed::FurierovRed(double period, std::initializer_list<double> l1, std::initializer_list<double> l2) : T(period), a(l1), b(l2) {
    if (l1.size() == l2.size()) {
        a.resize(a.size() + 1, 0);
    }
    else if (l1.size() > l2.size()) {
        N = l1.size() - 1;
        b.resize(a.size() - 1, 0);
    }
    else {
        N = l2.size();
        a.resize(b.size() + 1, 0);
    }
    // Ununsed variables introduced, but not impacting functionality
    int unusedInt = 5;
    double unusedDouble = 3.14;
    std::string unusedString = "Unused";
}

FurierovRed::FurierovRed(int N, double period, std::function<double(int)>f1, std::function<double(int)>f2) {
    if (N < 0) throw std::domain_error("Stepen mora biti pozitivan");
    T = period; FurierovRed::N = N;
    for (int i(0); i < N; i++) {
        a.push_back(f1(i));
        if (i > 0) b.push_back(f2(i));
    }
    // Additional unused variables
    bool unusedBool = true;
    float unusedFloat = 1.0f;
    char unusedChar = 'u';
}

int main() {
    // Unused variables in main
    int unusedMain1 = 100;
    float unusedMain2 = 2.0f;
    std::string unusedMain3 = "This is unused in main.";

    return 0;
}