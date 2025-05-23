#include <iostream>
#include <string>
#include <map>
#include <vector>
#include <algorithm>
#include <stdexcept>

using namespace std;

class Person {
public:
    string name, address, phone;
    Person(string name, string address, string phone): name(name), address(address), phone(phone) {}
};

class Student: public Person {
    int id;
    string yearOfStudy;
public:
    Student(int id, string yearOfStudy, string name, string address, string phone)
    : Person(name, address, phone), id(id), yearOfStudy(move(yearOfStudy)) {
        if (!isValidPhone(phone)) throw invalid_argument("Invalid phone format");
        if (yearOfStudy != "1" && yearOfStudy != "2" && yearOfStudy != "3" && 
            yearOfStudy != "1/B" && yearOfStudy != "2/B" && yearOfStudy != "3/B" &&
            yearOfStudy != "1/M" && yearOfStudy != "2/M" && yearOfStudy != "1/D" &&
            yearOfStudy != "2/D" && yearOfStudy != "3/D") throw invalid_argument("Invalid year of study");
    }
    int getId() const { return id; }
    string getYearOfStudy() const { return yearOfStudy; }
    void print() const {
        cout << "ID: " << id << ", Year of Study: " << yearOfStudy << ", Name: " << name
             << ", Address: " << address << ", Phone: " << phone << endl;
    }
private:
    static bool isValidPhone(const string& phone) {
        // Simple phone validation: must contain '/' and '-'
        return phone.find('/') != string::npos && phone.find('-') != string::npos;
    }
};

class Laptop {
    int inventoryNumber;
    string model, specs;
    const Student* assignedTo = nullptr;
public:
    Laptop(int inventoryNumber, string model, string specs)
    : inventoryNumber(inventoryNumber), model(move(model)), specs(move(specs)) {}
    void assign(const Student& student) {
        if (isAssigned()) throw runtime_error("Already assigned");
        assignedTo = &student;
    }
    void unassign() {
        assignedTo = nullptr;
    }
    bool isAssigned() const {
        return assignedTo != nullptr;
    }
    void print() const {
        cout << "Inventory No: " << inventoryNumber << ", Model: " << model 
             << ", Specs: " << specs << ", Assigned to: ";
        if (isAssigned()) cout << assignedTo->name << " (" << assignedTo->getId() << ")";
        else cout << "No one";
        cout << endl;
    }
};

class UniversityAdministration {
    map<int, Student> students;
    map<int, Laptop> laptops;
public:
    void registerStudent(int id, const string& yearOfStudy, const string& name, const string& address, const string& phone) {
        students.insert({id, {id, yearOfStudy, name, address, phone}});
    }
    void registerLaptop(int inventoryNumber, const string& model, const string& specs) {
        laptops.insert({inventoryNumber, {inventoryNumber, model, specs}});
    }
    void assignLaptopToStudent(int studentId, int inventoryNumber) {
        auto& student = students.at(studentId); // Throws out_of_range if not found
        auto& laptop = laptops.at(inventoryNumber); // Throws out_of_range if not found
        laptop.assign(student);
    }
    void printStudents() const {
        for (const auto& pair : students) {
            pair.second.print();
        }
    }
    void printLaptops() const {
        for (const auto& pair : laptops) {
            pair.second.print();
        }
    }
    void unassignLaptop(int inventoryNumber) {
        laptops.at(inventoryNumber).unassign();
    }
};

int main() {
    // Example usage
    UniversityAdministration admin;

    // Assuming proper exception handling here for simplicity
    
    admin.registerStudent(1001, "1/B", "John Doe", "123 Main St", "123/456-789");
    admin.registerLaptop(101, "Dell XPS", "16GB RAM, 1TB SSD");

    admin.assignLaptopToStudent(1001, 101);

    admin.printStudents();
    admin.printLaptops();

    return 0;
}