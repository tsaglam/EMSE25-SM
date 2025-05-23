#include <iostream>
#include <vector>
#include <cmath>
#include <initializer_list>
#include <functional>
#include <stdexcept>

using namespace std;

static const double PI_CONSTANT = atan(1) * 4;

class FourierSeries {
    double period, elementCount;
    vector<double> coefficientsA;
    vector<double> coefficientsB;
public:
    FourierSeries(double tempPeriod, initializer_list<double> initList1, initializer_list<double> initList2);
    FourierSeries(int elementNum, double tempPeriod, function<double(int)> func1, function<double(int)> func2);
};

FourierSeries::FourierSeries(double tempPeriod, initializer_list<double> initList1, initializer_list<double> initList2)
: period(tempPeriod), coefficientsA(initList1), coefficientsB(initList2) {
    // Adjust vectors based on their sizes to maintain symmetry
    if (initList1.size() == initList2.size()) coefficientsA.resize(coefficientsA.size() + 1, 0.0);
    else if (initList1.size() > initList2.size()) {
        elementCount = initList1.size() - 1;
        coefficientsB.resize(coefficientsA.size() - 1, 0.0);
    } else {
        elementCount = initList2.size();
        coefficientsA.resize(coefficientsB.size() + 1, 0.0);
    }
}

FourierSeries::FourierSeries(int elementNum, double tempPeriod, function<double(int)> func1, function<double(int)> func2) {
    if(elementNum < 0) throw domain_error("Degree must be positive");
    period = tempPeriod; FourierSeries::elementCount = elementNum;
    for (int i(0); i < elementNum; i++) {
        coefficientsA.push_back(func1(i));
        if (i > 0) coefficientsB.push_back(func2(i));
    }
}

int main() {
    return 0;
}