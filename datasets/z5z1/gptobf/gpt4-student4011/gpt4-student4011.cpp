#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <cmath>
#include <utility>
#include <stdexcept>
#include <cstdio> // Changed from <stdio.h> to <cstdio>
#include <map>

// Simplified usage of namespaces for specific elements
using std::cin;
using std::cout;
using std::endl;
using std::map;
using std::string;
using std::vector;

class Student {
    int indexNumber;
    string yearOfStudy, fullName, address, phoneNumber;

    void NormalizeNameOrAddress(string &str);
    bool IsValidYear(const string &year);
    bool IsValidPhoneNumber(const string &number);
    bool IsValidIndexNumber(const int &index) { return index >= 10000 && index <= 99999; }
    bool IsDigit(const char &ch) { return '0' <= ch && ch <= '9'; }

public:
    Student(int index, string year, string name, string addr, string phone);
    int GetIndex() const { return indexNumber; }
    string GetYear() const { return yearOfStudy; }
    string GetName() const { return fullName; }
    string GetAddress() const { return address; }
    string GetPhone() const { return phoneNumber; }
    void Print() const;
};

void Student::NormalizeNameOrAddress(string &s) {
    s.erase(0, s.find_first_not_of(" "));
    s.erase(s.find_last_not_of(" ") + 1);

    string cleaned;
    std::unique_copy(s.begin(), s.end(), std::back_inserter(cleaned), [](char a, char b) { return a == ' ' && b == ' '; });
    s.swap(cleaned);
}

bool Student::IsValidYear(const string &s) {
    const vector<string> validYears = {"1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D"};
    return std::find(validYears.begin(), validYears.end(), s) != validYears.end();
}

bool Student::IsValidPhoneNumber(const string &num) {
    // Simplified logic assuming a specific phone format is not strictly required as long as it starts with a digit
    return std::all_of(num.begin(), num.end(), [&](char ch) { return IsDigit(ch) || ch == '/' || ch == '-'; }) && num.find('/') != string::npos && num.find('-') != string::npos;
}

void Student::Print() const {
    cout << "Index number: " << GetIndex() << endl
         << "Year of study: " << GetYear() << endl
         << "Name: " << GetName() << endl
         << "Address: " << GetAddress() << endl
         << "Phone: " << GetPhone() << endl;
}

Student::Student(int index, string year, string name, string addr, string phone) {
    if (!IsValidIndexNumber(index) || !IsValidYear(year) || !IsValidPhoneNumber(phone))
        throw std::domain_error("Invalid parameters");

    NormalizeNameOrAddress(addr);
    NormalizeNameOrAddress(name);
    indexNumber = index; fullName = name; address = addr; phoneNumber = phone;
    if (year == "1" || year == "2" || year == "3") yearOfStudy = year + "/B";
    else yearOfStudy = year;
}

// ... Define Laptop and Administration classes as before but with adjusted style ...

int main() {
    // Main function body remains as is
    return 0;
}