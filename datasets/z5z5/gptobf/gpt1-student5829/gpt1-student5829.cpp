#include <iostream>
#include <vector>
#include <cmath>
#include <initializer_list>
#include <functional>
#include <stdexcept>

using namespace std;

const double PI = 4 * atan(1);

class FourierSeries {
    double period, N;
	vector<double> cosineCoefficients;
	vector<double> sineCoefficients;
	
public:
    FourierSeries(double period, initializer_list<double> cosineCoeffs, initializer_list<double> sineCoeffs);
	FourierSeries(int harmonics, double period, function<double(int)> cosineFunc, function<double(int)> sineFunc);
};

FourierSeries::FourierSeries(double period, initializer_list<double> cosineCoeffs, initializer_list<double> sineCoeffs)
	: period(period), cosineCoefficients(cosineCoeffs), sineCoefficients(sineCoeffs) {
	    if (cosineCoefficients.size() == sineCoefficients.size()) {
	        cosineCoefficients.push_back(0); // Making sure a0 is accounted for if sizes are equal initially.
	    } else if (cosineCoefficients.size() > sineCoefficients.size()) {
	        N = cosineCoefficients.size() - 1;
	        sineCoefficients.resize(cosineCoefficients.size(), 0);
	    } else {
	        N = sineCoefficients.size();
	        cosineCoefficients.resize(sineCoefficients.size() + 1, 0); // +1 to account for a0
	    }
}

FourierSeries::FourierSeries(int harmonics, double period, function<double(int)> cosineFunc, function<double(int)> sineFunc)
	: period(period) {
	    if (harmonics < 0) throw domain_error("Harmonic order must be positive");
	    N = harmonics;
	    for (int i = 0; i <= N; ++i) {
	        cosineCoefficients.push_back(cosineFunc(i));
	        if (i > 0) sineCoefficients.push_back(sineFunc(i-1));
	    }
}

int main() {
    return 0;
}