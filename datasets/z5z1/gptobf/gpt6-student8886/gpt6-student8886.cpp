#include <iostream>
#include <string>
#include <map>
#include <vector>
#include <algorithm>

class Person {
protected:
    std::string trimAndReduceSpaces(const std::string& str) {
        std::string result;
        bool inSpace = false;
        for (auto ch : str) {
            if (ch != ' ') {
                if (inSpace && !result.empty()) result += ' ';
                result += ch;
                inSpace = false;
            } else {
                inSpace = true;
            }
        }
        return result;
    }
};

class Student: public Person {
    int indexNumber;
    std::string yearOfStudy, name, address, phoneNumber;

public:
    Student(int index, std::string year, std::string name, std::string address, std::string phone)
    : indexNumber(index), yearOfStudy(std::move(year)), name(trimAndReduceSpaces(name)), 
      address(trimAndReduceSpaces(address)), phoneNumber(std::move(phone)) {
        if (index < 10000 || index > 99999) throw std::domain_error("Invalid index number");
        if (!isValidYear(yearOfStudy) || !isValidPhone(phoneNumber)) throw std::domain_error("Invalid parameters");
    }

    static bool isValidYear(const std::string& year) {
        return year == "1" || year == "2" || year == "3" || year == "1/B" || year == "1/M" || year == "1/D" || 
               year == "2/B" || year == "2/M" || year == "2/D" || year == "3/B" || year == "3/M" || year == "3/D";
    }

    static bool isValidPhone(const std::string& phone) {
        return phone.find('/') != std::string::npos && phone.find('-') != std::string::npos;
    }

    // Accessors 
    int getIndex() const { return indexNumber; }
    std::string getYear() const { return yearOfStudy.size() == 1 ? yearOfStudy + "/B" : yearOfStudy; }
    std::string getName() const { return name; }
    std::string getAddress() const { return address; }
    std::string getPhone() const { return phoneNumber; }

    void display() const {
        std::cout << "Index: " << indexNumber << std::endl
                  << "Year: " << getYear() << std::endl
                  << "Name: " << name << std::endl
                  << "Address: " << address << std::endl
                  << "Phone: " << phoneNumber << std::endl;
    }
};

class Laptop {
    int inventoryNumber;
    std::string name, specs;
    const Student* possessor = nullptr;

public:
    Laptop(int inventory, std::string name, std::string specs)
    : inventoryNumber(inventory), name(std::move(name)), specs(std::move(specs)) {
        if (inventoryNumber < 0) throw std::domain_error("Invalid inventory number");
    }

    void assignTo(const Student& student) {
        if (possessor) throw std::domain_error("Already assigned");
        possessor = &student;
    }

    void release() { possessor = nullptr; }
    bool isAssigned() const { return possessor != nullptr; }

    void display() const {
        std::cout << "Inventory #: " << inventoryNumber << std::endl
                  << "Name: " << name << std::endl
                  << "Specs: " << specs << std::endl;
        if (possessor) {
            std::cout << "Assigned to: " << possessor->getName() << " (" << possessor->getIndex() << ")" << std::endl;
        }
    }
};

class Administration {
    std::map<int, Student*> students;
    std::map<int, Laptop*> laptops;

public:
    ~Administration() {
        for (auto& [_, student]: students) delete student;
        for (auto& [_, laptop]: laptops) delete laptop;
    }

    // Similar functionalities for registering, finding, listing, etc. as in the original code
};

int main() {
    // Example usage based on your original main function, adapted for the new implementation.
}