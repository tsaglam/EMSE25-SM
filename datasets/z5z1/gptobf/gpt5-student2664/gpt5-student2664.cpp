#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <stdexcept>
#include <algorithm>

using namespace std;

struct PhoneNumberFormatError : domain_error {
    PhoneNumberFormatError(const string& msg) : domain_error(msg) {}
};

class Person {
private:
    int index;
    string studyYear, fullName, address, phoneNumber;

    static int CountDigits(int number);
    static bool IsValidStudyYear(const string& year);
    static string NormalizeName(const string& name);
    static bool IsValidPhoneNumber(const string& number);
    static bool IsDigit(char c) {
        return c >= '0' && c <= '9';
    }

public:
    Person(int index, string year, string name, string address, string phone);
    int GetIndex() const { return index; }
    string GetStudyYear() const;
    string GetName() const { return fullName; }
    string GetAddress() const { return address; }
    string GetPhone() const { return phoneNumber; }
    void Print() const;
};

Person::Person(int idx, string year, string name, string addr, string phone) : index(idx), studyYear(std::move(year)), 
fullName(NormalizeName(std::move(name))), address(NormalizeName(std::move(addr))), phoneNumber(std::move(phone)) {
    if(CountDigits(idx) != 5 || !IsValidStudyYear(studyYear) || !IsValidPhoneNumber(phoneNumber)) 
        throw PhoneNumberFormatError("Invalid parameters");
}

int Person::CountDigits(int num) {
    int totalDigits = 0;
    while(num != 0) {
        totalDigits++;
        num /= 10;
    }
    return totalDigits ? totalDigits : 1;
}

bool Person::IsValidStudyYear(const string& year) {
    const string validYears[] = {"1", "2", "3", "1/B", "2/B", "3/B", "1/M", "2/M", "1/D", "2/D", "3/D"};
    return find(begin(validYears), end(validYears), year) != end(validYears);
}

string Person::NormalizeName(const string& name) {
    string result;
    bool newWord = true;
    for(auto ch : name) {
        if(ch == ' ') {
            newWord = true;
        } else if(newWord) {
            newWord = false;
            if(!result.empty()) result += ' ';
            result += ch;
        } else {
            result += ch;
        }
    }
    return result;
}

bool Person::IsValidPhoneNumber(const string& number) {
    string expectedFormat = "XXX/XX-XX";
    auto isFormat = [](char ch, char format) {
        if(format == 'X') return IsDigit(ch);
        return ch == format;
    };
    return number.size() == expectedFormat.size() && equal(number.begin(), number.end(), expectedFormat.begin(), isFormat);
}

string Person::GetStudyYear() const {
    if(studyYear == "1" || studyYear == "2" || studyYear == "3"){
        return studyYear + "/B";
    }
    return studyYear;
}

void Person::Print() const {
    cout << "Index number: " << GetIndex() << "\nStudy year: " << GetStudyYear() << "\nName: " << GetName() << "\nAddress: " << GetAddress() << "\nPhone: " << GetPhone() << endl;
}

// Implementation for Laptop and Administration classes would similarly follow, using a style consistent with the provided Person class.