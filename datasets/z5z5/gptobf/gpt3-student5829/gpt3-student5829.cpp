#include <iostream>
#include <vector>
#include <cmath>
#include <initializer_list>
#include <functional>
#include <stdexcept>

using namespace std; // Using the entire namespace to streamline code

const double PI = 4 * atan(1); // Cleaner atan() usage from cmath

class FourierSeries {
    double period{}, N{}; // Initializing with {} to explicitly denote default values
    vector<double> aCoefficients; // Renamed for clarity
    vector<double> bCoefficients; // Renamed for clarity

public:
    FourierSeries(double period, initializer_list<double> aList, initializer_list<double> bList);
    FourierSeries(int N, double period, function<double(int)> aFunc, function<double(int)> bFunc);
};

FourierSeries::FourierSeries(double period, initializer_list<double> aList, initializer_list<double> bList)
    : period(period), aCoefficients(aList), bCoefficients(bList) {
    // Adjusted condition checks and vector resizing for clarity
    if (aList.size() == bList.size()) {
        aCoefficients.resize(aCoefficients.size() + 1, 0);
    } else if (aList.size() > bList.size()) {
        N = aList.size() - 1;
        bCoefficients.resize(aCoefficients.size() - 1, 0); // Ensured correct vector is resized
    } else {
        N = bList.size();
        aCoefficients.resize(bCoefficients.size() + 1, 0);
    }
}

FourierSeries::FourierSeries(int N, double period, function<double(int)> aFunc, function<double(int)> bFunc) {
    if (N < 0) throw domain_error("Degree must be positive");
    this->period = period;  // Use of this-> for clarity
    this->N = N;
    for (int i = 0; i < N; i++) {
        aCoefficients.push_back(aFunc(i));
        if (i > 0) bCoefficients.push_back(bFunc(i));
    }
}

int main() {
    return 0;
}