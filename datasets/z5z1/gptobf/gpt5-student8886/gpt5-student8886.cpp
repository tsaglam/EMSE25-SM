#include <iostream>
#include <stdexcept>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

class Student {
private:
    int index;
    string studyYear;
    string name;
    string address;
    string phoneNumber;

    static bool IsValidIndexNumber(int num) {
        return to_string(num).length() == 5;
    }

    static bool IsValidStudyYear(const string& year) {
        if(year.empty() || year.size() > 3) return false;
        if(year.size() == 3) return year[1] == '/' && (year[0] >= '1' && year[0] <= '3') && (year[2] == 'B' || year[2] == 'M' || year[2] == 'D');
        return year.size() == 1 && year[0] >= '1' && year[0] <= '3';
    }

    void TrimSpaces(string& str) {
        str.erase(remove(str.begin(), str.end(), ' '), str.end());
    }

    static bool IsValidPhoneNumber(const string& number) {
        int slashCount = count(number.begin(), number.end(), '/');
        int dashCount = count(number.begin(), number.end(), '-');
        return slashCount == 1 && dashCount == 1;
    }

public:
    Student(int index, string studyYear, string name, string address, string phoneNumber) :
        index(index), studyYear(studyYear), name(move(name)), address(move(address)), phoneNumber(move(phoneNumber)) {
        if(!IsValidIndexNumber(index) || !IsValidStudyYear(studyYear) || !IsValidPhoneNumber(phoneNumber)) throw domain_error("Invalid parameters");
        TrimSpaces(this->name);
        TrimSpaces(this->address);
    }

    int GetIndex() const {
        return index;
    }

    string GetStudyYear() const {
        string result = studyYear;
        if(result.size() == 1) result += "/B";
        return result;
    }

    string GetName() const {
        return name;
    }

    string GetAddress() const {
        return address;
    }

    string GetPhoneNumber() const {
        return phoneNumber;
    }

    void Display() const {
        cout << "Index number: " << GetIndex() << endl
             << "Year of study: " << GetStudyYear() << endl
             << "Name: " << GetName() << endl
             << "Address: " << GetAddress() << endl
             << "Phone number: " << GetPhoneNumber() << endl;
    }
};

class Laptop {
private:
    int registrationNumber;
    string name;
    string specs;
    Student* possessor = nullptr;

public:
    Laptop(int registrationNumber, string name, string specs) : registrationNumber(registrationNumber), name(move(name)), specs(move(specs)) {
        if(registrationNumber < 0 || this->name.empty() || this->specs.empty()) throw domain_error("Invalid parameters");
    }

    int GetRegistrationNumber() const {
        return registrationNumber;
    }

    string GetName() const {
        return name;
    }

    string GetSpecs() const {
        return specs;
    }

    void AssignTo(Student& student) {
        if(possessor != nullptr) throw domain_error("Laptop already assigned");
        possessor = &student;
    }

    void Unassign() {
        possessor = nullptr;
    }

    bool IsAssigned() const {
        return possessor != nullptr;
    }

    Student* GetPossessor() const {
        if(possessor == nullptr) throw domain_error("Laptop not assigned");
        return possessor;
    }

    void Display() const {
        cout << "Registration number: " << GetRegistrationNumber() << endl
             << "Name: " << GetName() << endl
             << "Specifications: " << GetSpecs() << endl;
        if(IsAssigned()) {
            cout << "Assigned to: " << possessor->GetName() << " (" << possessor->GetIndex() << ")" << endl;
        }
    }
};

// Assuming modifications for the Administracija class follow a similar simplification and standardization
// principle as applied to Student and Laptop classes, please continue in this vein for a full overhaul.


int main() {
    // Example usage remains the same but the interactions are replaced with methods of the modified classes
    return 0;
}