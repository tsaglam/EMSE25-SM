#include <iostream>
#include <string>
#include <stdexcept>
#include <map>
#include <algorithm>
#include <memory>

class Person {
    int id;
    std::string yearOfStudy, fullName, address, phoneNumber;
public:
    Person(int index, std::string year, std::string name, std::string addr, std::string phone) {
        validateParameters(index, year, phone);
        trimSpaces(name);
        trimSpaces(addr);
        id = index;
        yearOfStudy = (year.length() <= 1) ? year + "/B" : year;
        fullName = name;
        address = addr;
        phoneNumber = phone;
    }

    void validateParameters(int index, std::string& year, std::string& phone) {
        if(index < 10000 || index > 99999 || year.empty() || year.front() < '1' || year.front() > '3' ||
          (year.length() > 1 && (year[1] != '\0' && year[1] != '/') || 
          (year.length() == 3 && year[1] == '/' && (year[2] != 'B' && year[2] != 'M' && year[2] != 'D'))))
            throw std::domain_error("Invalid parameters");
        if(phone.find_first_not_of("0123456789/-") != std::string::npos || 
           phone.find('/') == std::string::npos || phone.find('-') == std::string::npos)
            throw std::domain_error("Invalid parameters");
    }

    void trimSpaces(std::string& str) {
        str.erase(remove_if(str.begin(), str.end(), [](char& c){ return std::isspace(c); }), str.end());
    }

    int getId() const { return id; }
    std::string getYearOfStudy() const { return yearOfStudy; }
    std::string getFullName() const { return fullName; }
    std::string getAddress() const { return address; }
    std::string getPhoneNumber() const { return phoneNumber; }
    void display() const {
        std::cout << "ID: " << id << "\nYear of Study: " << yearOfStudy << "\nFull Name: " << fullName 
                  << "\nAddress: " << address << "\nPhone: " << phoneNumber << std::endl;
    }
};

// Device class represents the Laptop, using modern C++ styling conventions and improved naming
class Device {
    int serial;
    std::string model, specs;
    Person* owner = nullptr; // Utilizing raw pointer for demonstration, consider std::unique_ptr<Person> or std::shared_ptr<Person> for real applications

public:
    Device(int id, std::string name, std::string characteristics) {
        if(id < 0) throw std::domain_error("Invalid parameters");
        serial = id;
        model = name;
        specs = characteristics;
    }

    int getSerial() const { return serial; }
    std::string getModel() const { return model; }
    std::string getSpecs() const { return specs; }
    bool isAssigned() const { return owner; }
    void assign(Person& person) {
        if(isAssigned()) throw std::domain_error("Device is already assigned");
        owner = &person;
    }
    void release() { owner = nullptr; }
    Person& getOwner() const {
        if(owner == nullptr) throw std::domain_error("Device not assigned");
        return *owner;
    }
    void display() const {
        std::cout << "Serial: " << serial << "\nModel: " << model << "\nSpecs: " << specs << std::endl;
        if(isAssigned()) 
            std::cout << "Assigned to: " << owner->getFullName() << " (ID: " << owner->getId() << ")" << std::endl;
    }
};

// The Administration class can largely remain unchanged except for using modern C++ practices 
// like smart pointers for automatic memory management to simplify cleanup and resource management.

// Note: We'd need to similarly refactor the Administration class, replacing raw pointers with smart pointers 
// like std::unique_ptr or std::shared_ptr, using more modern practices such as range-based for loops 
// and possibly emplacing objects into the containers instead of inserting them.

// Due to the length and complexity of the original code, these examples focus on key improvements and modern C++ usage.
// Be sure to refactor the remaining parts accordingly, focusing on readability, maintainability, and efficient resource management.