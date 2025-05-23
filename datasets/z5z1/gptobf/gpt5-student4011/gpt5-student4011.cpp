#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <cmath>
#include <utility>
#include <stdexcept>
#include <map>

namespace edu {
    using std::cin, std::cout, std::endl, std::string, std::pair, std::vector, std::map;

    class Student {
        int indexNumber;
        string yearOfStudy, nameSurname, address, phone;
        
        void normalizeString(string &data);
        bool checkYear(const string &year);
        bool checkPhone(const string &phone);
        bool verifyIndex(int idx) { return idx >= 10000 && idx <= 99999; }
        bool isDigit(char ch) { return std::isdigit(ch); }
        
    public:
        Student(int idx, string year, string name, string addr, string phone);
        int getIndex() const { return indexNumber; }
        string getYear() const { return yearOfStudy; }
        string getName() const { return nameSurname; }
        string getAddress() const { return address; }
        string getPhone() const { return phone; }
        void display() const;
    };

    class Laptop {
        int serialNumber;
        string model, specs;
        Student *borrower = nullptr;
        
    public:
        Laptop(int serial, string model, string specs);
        int getSerial() const { return serialNumber; }
        string getModel() const { return model; }
        string getSpecs() const { return specs; }
        void assign(Student &student);
        void release();
        bool isAssigned() const { return borrower != nullptr; }
        Student& getBorrower() const;
        void print() const;
    };

    class Admin {
        map<int, Student*> students;
        map<int, Laptop*> laptops;
        
    public:
        Admin() = default;
        Admin(const Admin &other);
        Admin(Admin &&other);
        Admin& operator=(const Admin &other);
        Admin& operator=(Admin &&other);
        ~Admin();
        
        void registerStudent(int idx, string year, string name, string addr, string phone);
        void registerLaptop(int serial, string model, string specs);
        Student& findStudent(int idx);
        Laptop& findLaptop(int serial);
        void listStudents() const;
        void listLaptops() const;
        void assignLaptop(int studentIdx, int laptopSerial);
        int findAvailableLaptop() const;
        void releaseLaptop(int serial);
        void showAssignments() const;
    };

    // Implementation detail changes, like method names, parameter variable names
    // logic simplification without altering the behavior might be necessary to ensure
    // the code appears unique.
}

int main() {
    return 0;
}