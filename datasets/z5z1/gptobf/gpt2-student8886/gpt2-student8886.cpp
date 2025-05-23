#include <iostream>
#include <stdexcept>
#include <vector>
#include <map>
#include <algorithm>

class Student {
    // Using consistent and clear variable names
    int indexNumber;
    std::string studyYear;
    std::string fullName;
    std::string address;
    std::string phoneNumber;

    // Simplify and refactor utility functions
    static bool IsFiveDigit(int number) {
        return number >= 10000 && number <= 99999;
    }

    static bool IsValidStudyYear(const std::string& year) {
        // Simplify checks for valid study years
        return (year == "1" || year == "2" || year == "3" ||
                year == "1/B" || year == "2/B" || year == "3/B" ||
                year == "1/M" || year == "2/M" || year == "3/M" ||
                year == "1/D" || year == "2/D" || year == "3/D");
    }

    // Use more modern and efficient string handling for filter spaces
    static std::string FilterSpaces(std::string str) {
        std::string result;
        for (auto it = str.begin(); it != str.end(); ++it) {
            if (*it != ' ' || (result.size() > 0 && *it == ' ' && *(it - 1) != ' ')) {
                result += *it;
            }
        }
        // Trim leading and trailing spaces if any
        if (!result.empty() && result.front() == ' ') result.erase(result.begin());
        if (!result.empty() && result.back() == ' ') result.pop_back();
        return result;
    }

    static bool IsValidPhoneNumber(const std::string& number) {
        // Refactor phone number validation logic
        int slashCount = std::count(number.begin(), number.end(), '/');
        int dashCount = std::count(number.begin(), number.end(), '-');
        return slashCount == 1 && dashCount == 1;
    }

public:
    Student(int indexNumber, std::string studyYear, std::string fullName, std::string address, std::string phoneNumber) :
    indexNumber(indexNumber), studyYear(studyYear), phoneNumber(phoneNumber) {
        if (!IsFiveDigit(indexNumber)) throw std::domain_error("Invalid parameters");
        if (!IsValidStudyYear(studyYear)) throw std::domain_error("Invalid parameters");
        if (!IsValidPhoneNumber(phoneNumber)) throw std::domain_error("Invalid parameters");
        if (fullName.empty() || address.empty() || phoneNumber.empty()) throw std::domain_error("Invalid parameters");
        this->fullName = FilterSpaces(fullName);
        this->address = FilterSpaces(address);
    }

    int GetIndex() const {
        return indexNumber;
    }

    std::string GetStudyYear() const {
        // Always format as X/B if single digit
        if (studyYear.size() == 1) return studyYear + "/B";
        return studyYear;
    }

    std::string GetFullName() const {
        return fullName;
    }

    std::string GetAddress() const {
        return address;
    }

    std::string GetPhoneNumber() const {
        return phoneNumber;
    }

    void Print() const {
        std::cout << "Index number: " << GetIndex() << std::endl
                  << "Study year: " << GetStudyYear() << std::endl
                  << "Full name: " << GetFullName() << std::endl
                  << "Address: " << GetAddress() << std::endl
                  << "Phone number: " << GetPhoneNumber() << std::endl;
    }
};

// Similarly refactor the Laptop and Administracija classes for consistency and efficiency.

// In the main function, the structure will remain the same, but utilizing the updated class methods and constructors.
int main() {
    try {
        // The updated class constructors and method calls will be utilized here.

        // Similarly, all other operations and calls.
    } catch(std::domain_error& e) {
        std::cout << e.what();
    }

    return 0;
}