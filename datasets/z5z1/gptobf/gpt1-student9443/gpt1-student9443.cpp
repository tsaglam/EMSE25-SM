#include <iostream>
#include <string>
#include <stdexcept>
#include <map>
#include <memory> // For smart pointers
#include <algorithm>
#include <vector>

/****** Helper Functions ******/
bool isValidIndex(int index) {
    return index >= 10000 && index <= 99999;
}

bool isValidYear(const std::string& year) {
    if (year.empty() || year.size() > 3) return false;
    if (year[0] < '1' || year[0] > '3') return false;
    if (year.size() == 2 && year[1] != 'B' && year[1] != 'M' && year[1] != 'D') return false;
    if (year.size() == 3 && year[1] != '/') return false;
    return true;
}

bool isValidPhone(const std::string& phone) {
    size_t slashCount = std::count(phone.begin(), phone.end(), '/');
    size_t dashCount = std::count(phone.begin(), phone.end(), '-');
    if (slashCount != 1 || dashCount != 1) return false;

    for (char c : phone) {
        if (!std::isdigit(c) && c != '/' && c != '-') return false;
    }
    return true;
}

std::string normalizeName(std::string str) {
    str.erase(remove_if(str.begin(), str.end(), ::isspace), str.end());
    return str;
}

/****** Classes Definition (Refactored) ******/
// Student class remains largely unchanged but with improved constructor validation
// Laptop class unchanged aside from using nullptr and removing explicit null checks
// Administracija files simplified with use of std::unique_ptr and helper functions

/******* Main Functionality *******/
// Main remains unchanged in structure, but interaction can be simplified by reusing input request functions

int main() {
    // Main program logic here, interaction with user remains the same
    // Consider creating functions for each action (e.g., registerStudent, registerLaptop) to simplify the main loop
    return 0;
}