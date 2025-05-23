#include <iostream>
#include <string>
#include <map>
#include <vector>
#include <algorithm>

using namespace std;

class Student {
    int index;
    string studyYear, name, address, phone;
public:
    Student(int idx, const string& year, const string& fullName, const string& addr, const string& phoneNumber);
    string GetStudyYear() const { return studyYear; }
    void Print() const;
    // Other necessary member functions not detailed for brevity.
};

// Constructor and member functions definitions
Student::Student(int idx, const string& year, const string& fullName, const string& addr, const string& phoneNumber)
    : index(idx), studyYear(year), name(fullName), address(addr), phone(phoneNumber) {
    // Validation and normalization logic here (simplified for clarity)
}

void Student::Print() const {
    cout << "Index: " << index << ", Year: " << studyYear << ", Name: " << name << ", Address: " << address << ", Phone: " << phone << endl;
}

class Laptop {
    int serial;
    string name, specs;
    const Student* possessedBy = nullptr;
public:
    Laptop(int no, const string& name, const string& specs);
    void AssignToStudent(const Student& student);
    void Release();
    void Print() const;
    // Other necessary member functions not detailed for brevity.
};

// Constructor and member functions definitions
Laptop::Laptop(int no, const string& name, const string& specs)
    : serial(no), name(name), specs(specs) { }

void Laptop::AssignToStudent(const Student& student) {
    possessedBy = &student;
}

void Laptop::Release() {
    possessedBy = nullptr;
}

void Laptop::Print() const {
    cout << "Serial: " << serial << ", Name: " << name << ", Specs: " << specs;
    if (possessedBy != nullptr) {
        cout << ", Possessed by: " << possessedBy->GetStudyYear();
    }
    cout << endl;
}

class Administration {
    map<int, Student> students;
    map<int, Laptop> laptops;
public:
    void RegisterStudent(int index, const Student& student);
    void RegisterLaptop(int serial, const Laptop& laptop);
    void AssignLaptopToStudent(int serial, int index);
    void ReleaseLaptop(int serial);
    // Additional functionality
    // Implementations not detailed for brevity.
};

// Main function remains empty as per the original.
int main() {
    return 0;
}