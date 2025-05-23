#include <iostream>
#include <vector>
#include <cmath>
#include <initializer_list>
#include <functional>
#include <stdexcept>

using namespace std;

const double PI = atan(1) * 4;

class FurierovRed {
    double T, N;
    vector<double> a, b;

public:
    FurierovRed(double period, initializer_list<double> l1, initializer_list<double> l2)
        : T(period), a(l1.begin(), l1.end()), b(l2.begin(), l2.end()) {
        if (l1.size() == l2.size()) {
            a.push_back(0); // Resizes by adding an additional 0 if both lists are of equal size.
        } else if (l1.size() > l2.size()) {
            N = l1.size() - 1;
            b.resize(a.size(), 0); // Resizing b to match a, with default 0s.
        } else {
            N = l2.size();
            a.resize(b.size(), 0); // Resizing a to match b, with default 0s.
        }
    }
    
    FurierovRed(int count, double period, function<double(int)> f1, function<double(int)> f2) {
        if (count < 0) throw domain_error("Stepen mora biti pozitivan");
        T = period;
        this->N = count;
        for (int i = 0; i < count; ++i) {
            a.push_back(f1(i));
            if (i > 0) b.push_back(f2(i)); // Excluding the first index for b array.
        }
    }
};

int main() {
    return 0;
}