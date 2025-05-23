#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <map>
#include <stdexcept>

using namespace std;

class Student {
private:
    int indexNumber;
    string yearOfStudy, name, address, phoneNumber;

    void NormalizeString(string& str);
    bool IsValidYearOfStudy(const string& year) const;
    bool IsValidPhoneNumber(const string& number) const;
    bool IsValidIndexNumber(int index) const { return index >= 10000 && index <= 99999; }
    static bool IsDigit(char c) { return c >= '0' && c <= '9'; }

public:
    Student(int index, string year, string name, string address, string phoneNumber);
    void Print() const;

    // Accessors
    int GetIndex() const { return indexNumber; }
    string GetYearOfStudy() const { return yearOfStudy; }
    string GetName() const { return name; }
    string GetAddres() const { return address; }
    string GetPhoneNumber() const { return phoneNumber; }
};

Student::Student(int index, string year, string name, string address, string phone) : indexNumber(index), yearOfStudy(move(year)), name(move(name)), address(move(address)), phoneNumber(move(phone)) {
    if (!IsValidIndexNumber(index) || !IsValidYearOfStudy(yearOfStudy) || !IsValidPhoneNumber(phoneNumber)) {
        throw domain_error("Invalid student parameters");
    }
    NormalizeString(this->address);
    NormalizeString(this->name);
}

void Student::NormalizeString(string& str) {
    str.erase(0, str.find_first_not_of(' '));
    str.erase(str.find_last_not_of(' ') + 1);
    
    auto newEnd = unique(str.begin(), str.end(), [](char lhs, char rhs) { return lhs == ' ' && rhs == ' '; });
    str.erase(newEnd, str.end());
}

bool Student::IsValidYearOfStudy(const string& year) const {
    static const vector<string> validYears = {"1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D"};
    return find(validYears.begin(), validYears.end(), year) != validYears.end();
}

bool Student::IsValidPhoneNumber(const string& number) const {
    if (number.empty() || !IsDigit(number[0])) {
        return false;
    }

    string allowedChars = "0123456789/-";
    for (char c : number) {
        if (allowedChars.find(c) == string::npos) {
            return false;
        }
    }

    size_t slashPos = number.find('/');
    size_t dashPos = number.find('-');
    if (slashPos == string::npos || dashPos == string::npos || slashPos > dashPos) {
        return false;
    }

    return true;
}

void Student::Print() const {
    cout << "Index number: " << GetIndex() << endl;
    cout << "Year of study: " << GetYearOfStudy() << endl;
    cout << "Name: " << GetName() << endl;
    cout << "Address: " << GetAddres() << endl;
    cout << "Phone number: " << GetPhoneNumber() << endl;
}