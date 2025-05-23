#include <iostream>
#include <string>
#include <stdexcept>
#include <map>
#include <vector>

struct Scholar {
    int IndexNumber;
    std::string StudyYear;
    std::string FullName;
    std::string Address;
    std::string PhoneNumber;

    Scholar(int index, std::string year, std::string name, std::string addr, std::string phone) {
        if(index < 10000 || index > 99999) throw std::domain_error("Invalid parameters");
        auto valid_year = year.length() <= 3 && year.length() > 0 && (year[0] == '1' || year[0] == '2' || year[0] == '3') && 
                         (year.length() == 1 || (year[1] == '/' && (year[2] == 'B' || year[2] == 'M' || year[2] == 'D')));
        if (!valid_year) throw std::domain_error("Invalid parameters");
        if(year == "1" || year == "2" || year == "3") year += "/B";
        CorrectSpaces(name);
        CorrectSpaces(addr);
        ValidatePhone(phone);
        IndexNumber = index;
        StudyYear = year;
        FullName = name;
        Address = addr;
        PhoneNumber = phone;
    }

    void ValidatePhone(std::string &phone) {
        int slashes = std::count(phone.begin(), phone.end(), '/');
        int dashes = std::count(phone.begin(), phone.end(), '-');
        if(slashes > 1 || dashes > 1) throw std::domain_error("Invalid parameters");
        for (char c : phone) 
            if (!isdigit(c) && c != '/' && c != '-') 
                throw std::domain_error("Invalid parameters");
        if(dashes == 0 || slashes == 0) throw std::domain_error("Invalid parameters");
    }

    void CorrectSpaces(std::string &str) {
        str.erase(std::remove_if(str.begin(), str.end(), [](unsigned char x){ return std::isspace(x); }), str.end());
    }
    
    int GetIndex() const { return IndexNumber; }
    std::string GetStudyYear() const { return StudyYear; }
    std::string GetName() const { return FullName; }
    std::string GetAddress() const { return Address; }
    std::string GetPhone() const { return PhoneNumber; }
    
    void Print() const {
        std::cout << "Index Number: " << IndexNumber << "\n" << "Study Year: " << StudyYear << "\n" << "Name: " << FullName << "\n" << "Address: " <<
                                                                                  Address << "\n" << "Phone: " << PhoneNumber << std::endl;
    }
};

class Device {
    int SerialNumber;
    std::string Model;
    std::string Specs;
    Scholar *Holder = nullptr;

    public:
    Device(int serial, std::string model, std::string specs) {
        if(serial < 0) throw std::domain_error("Invalid parameters");
        SerialNumber = serial;
        Model = model;
        Specs = specs;
    }

    int GetSerial() const { return SerialNumber; }
    std::string GetModel() const { return Model; }
    std::string GetSpecs() const { return Specs; }
    void AssignTo(Scholar &stud) {
        if(Holder != nullptr) throw std::domain_error("Device already assigned");
        Holder = &stud;
    }
    bool IsAssigned() const { return Holder != nullptr; }
    Scholar &CurrentHolder() const {
        if(Holder == nullptr) throw std::domain_error("Device not assigned");
        return *Holder;
    }
    void Release() { Holder = nullptr; }
    
    void Display() const {
        std::cout << "Serial Number: " << SerialNumber << "\n" << "Model: " << Model << "\n" << "Specs: " << Specs << std::endl;
        if(IsAssigned())
            std::cout << "Assigned to: " << CurrentHolder().GetName() << " (" << CurrentHolder().GetIndex() << ")\n";
    }
};

// Remaining classes (Administration, etc.) and main function would follow a similar pattern of obfuscation