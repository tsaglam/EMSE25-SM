#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <stdexcept>
#include <algorithm>

struct Scholar {
    int indexNum;
    std::string yearOfStudy, fullName, address, phoneNumber;
    
    static bool isFiveDigits(int num) {
        return std::to_string(num).length() == 5;
    }
    
    static bool validStudyYear(const std::string& year) {
        const std::vector<std::string> validYears = {"1", "2", "3", "1/B", "2/M", "3/D"};
        return std::find(validYears.begin(), validYears.end(), year) != validYears.end();
    }
    
    static void removeExtraSpaces(std::string& str) {
        str.erase(std::unique(str.begin(), str.end(), [](char lhs, char rhs) { 
            return (lhs == rhs) && (lhs == ' '); 
        }), str.end());
        if (str.front() == ' ') str.erase(str.begin());
        if (str.back() == ' ') str.pop_back();
    }
    
    static bool validPhoneNumber(const std::string& num) {
        int dash = num.find('-'), slash = num.find('/');
        return (dash != std::string::npos) && (slash != std::string::npos);
    }
    
public:
    Scholar(int idx, std::string year, std::string name, std::string addr, std::string phone) : indexNum(idx), yearOfStudy(year), fullName(name), address(addr), phoneNumber(phone) {
        if (!isFiveDigits(idx) || !validStudyYear(year) || !validPhoneNumber(phone) || name.empty() || addr.empty() || phone.empty())
            throw std::domain_error("Invalid parameters");
        removeExtraSpaces(fullName);
        removeExtraSpaces(address);
    }
    
    void display() const {
        std::cout << "Index Number: " << indexNum << "\nYear of Study: " << yearOfStudy << "\nFull Name: " << fullName << "\nAddress: " << address << "\nPhone Number: " << phoneNumber << std::endl;
    }
};

int main() {
    try {
        Scholar scholar(12345, "2/B", "John Doe", "123 Main St", "123/456-789");
        scholar.display();
    } catch (std::domain_error& e) {
        std::cout << e.what() << std::endl;
    }
    return 0;
}