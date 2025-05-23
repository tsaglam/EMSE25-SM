#include <iostream>
#include <map>
#include <stdexcept>
#include <string>

class Scholar {
    int id;
    std::string studyYear;
    std::string fullName;
    std::string address;
    std::string phone;

public:
    Scholar(int id, std::string studyYear, std::string fullName, std::string address, std::string phone) : 
    id(id), studyYear(studyYear), fullName(fullName), address(address), phone(phone) {
        if (id < 10000 || id > 99999)
            throw std::domain_error("Invalid parameters for student");
    }

    int GetId() const { return id; }
    std::string GetStudyYear() const { return studyYear; }
    std::string GetName() const { return fullName; }
    std::string GetAddress() const { return address; }
    std::string GetPhone() const { return phone; }

    void Display() const {
        std::cout << "Index number: " << id << std::endl;
        std::cout << "Year of study: " << GetStudyYear() << std::endl;
        std::cout << "Name: " << GetName() << std::endl;
        std::cout << "Address: " << GetAddress() << std::endl;
        std::cout << "Phone number: " << GetPhone() << std::endl;
    }
};

class Computer {
    int serialNumber;
    std::string model;
    std::string specs;
    Scholar *possessor = nullptr;

public:
    Computer(int serialNumber, std::string model, std::string specs) :
    serialNumber(serialNumber), model(model), specs(specs) {
        if (serialNumber < 0)
            throw std::domain_error("Invalid parameters for computer");
    }

    int GetSerialNumber() const { return serialNumber; }
    std::string GetModel() const { return model; }
    std::string GetSpecs() const { return specs; }

    void AssignTo(Scholar &scholar) {
        if(possessor != nullptr)
            throw std::domain_error("Computer already assigned");
        possessor = &scholar;
    }

    void Unassign() {
        if(possessor != nullptr)
            possessor = nullptr;
    }

    bool IsAssigned() const {
        return possessor != nullptr;
    }

    Scholar &AssignedScholar() const {
        if (!IsAssigned())
            throw std::domain_error("Computer not assigned");
        return *possessor;
    }

    void Display() const {
        std::cout << "Serial Number: " << GetSerialNumber() << std::endl;
        std::cout << "Model: " << GetModel() << std::endl;
        std::cout << "Specifications: " << GetSpecs() << std::endl;
    }
};

class Administration {
    std::map<int, Scholar *> scholars;
    std::map<int, Computer *> computers;

public:
    void RegisterNewScholar(int id, std::string studyYear, std::string fullName, std::string address, std::string phone) {
        // Implementation for registering a new scholar
    }
};

int main() {
    return 0;
}