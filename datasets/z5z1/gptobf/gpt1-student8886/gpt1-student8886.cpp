#include <iostream>
#include <stdexcept>
#include <vector>
#include <map>
#include <algorithm>
#include <memory> // For smart pointers

// Utility namespace for common functionalities
namespace util {
    bool isFiveDigit(int number) {
        return number >= 10000 && number <= 99999;
    }

    bool isValidYear(const std::string& year) {
        if(year.empty() || year.size() > 3) return false;
        if(year.size() == 3) {
            return (year[1] == '/' && std::string("123").find(year[0]) != std::string::npos && 
                    std::string("BMD").find(year[2]) != std::string::npos);
        }
        return (year.size() == 1 && std::string("123").find(year[0]) != std::string::npos);
    }

    bool isValidPhoneNumber(const std::string& number) {
        size_t slashPos = number.find('/');
        size_t dashPos = number.find('-');
        return slashPos != std::string::npos && dashPos != std::string::npos && slashPos < dashPos;
    }

    std::string filterWhitespace(const std::string& str) {
        std::string result;
        std::unique_copy(str.begin(), str.end(), std::back_inserter(result), 
                         [](char lhs, char rhs){ return std::isspace(lhs) && std::isspace(rhs); });
        return result;
    }    
}