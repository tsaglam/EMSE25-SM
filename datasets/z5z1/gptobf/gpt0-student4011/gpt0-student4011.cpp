#include <iostream>
#include <vector>
#include <string>
#include <map>
#include <algorithm>
#include <stdexcept>

using namespace std;

class Student {
    int indexNumber;
    string yearOfStudy, name, address, phone;
    void Normalize(string &str);
public:
    Student(int index, const string &year, const string &name, const string &address, const string &phone);
    void Print() const;
    // Getters
    int GetIndex() const { return indexNumber; }
    string GetYear() const { return yearOfStudy; }
    string GetName() const { return name; }
    string GetAddress() const { return address; }
    string GetPhone() const { return phone; }
    // Checkers
    static bool IsValidYear(const string &year);
    static bool IsValidPhone(const string &phone);
    static bool IsValidIndex(int index) { return index >= 10000 && index <= 99999; }
};

void Student::Normalize(string &str) {
    str.erase(remove(str.begin(), str.end(), ' '), str.end());
    // Method could be enhanced based on what "normalize" should mean
}

bool Student::IsValidYear(const string &year) {
    const vector<string> validYears = {"1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D"};
    return find(validYears.begin(), validYears.end(), year) != validYears.end();
}

bool Student::IsValidPhone(const string &phone) {
    // Basic check, assumes format and digits validity
    return phone.find('/') != string::npos && phone.find('-') != string::npos;
}

Student::Student(int index, const string &year, const string &name, const string &address, const string &phone) {
    if (!IsValidIndex(index) || !IsValidYear(year) || !IsValidPhone(phone)) 
        throw domain_error("Invalid parameters");
    indexNumber = index;
    yearOfStudy = year;
    Normalize(this->name = name);
    Normalize(this->address = address);
    this->phone = phone;
}

void Student::Print() const {
    cout << "Index number: " << GetIndex() << endl;
    cout << "Year of study: " << GetYear() << endl;
    cout << "Name: " << GetName() << endl;
    cout << "Address: " << GetAddress() << endl;
    cout << "Phone: " << GetPhone() << endl;
}

// Implementations for Laptop and Administration could follow a similar pattern of refactoring for brevity and clarity.

int main() {
    // Example usage of classes 
    try {
        Student s(12345, "1/B", "John Doe", "Some Address", "123/456-789");
        s.Print();
    } catch(const domain_error& e) {
        cout << "Caught exception: " << e.what() << endl;
    }
    return 0;
}