#include <iostream>
#include <string>
#include <stdexcept>
#include <map>
#include <vector>

using namespace std;

struct Person {
    int indexNo;
    string studyYear;
    string fullName;
    string address;
    string phoneNumber;

    static void trimSpaces(string& s) {
        s.erase(remove_if(s.begin(), s.end(), [](char ch) { return isspace(ch); }), s.end());
    }

public:
    Person(int idx, string year, string name, string addr, string phone) {
        if(idx < 10000 || idx > 99999 || year.empty() || year.size() > 3 || !(year.front() == '1' || year.front() == '2' || year.front() == '3') || 
           (year.size() > 1 && year[1] != '/' && year[1] != '\0') || 
           (year.size() > 2 && year[1] == '/' && year[2] != 'B' && year[2] != 'M' && year[2] != 'D'))
            throw domain_error("Invalid parameters");

        if(find_if_not(phone.begin(), phone.end(), [](char c) { return isdigit(c) || c == '/' || c == '-'; }) != phone.end())
            throw domain_error("Invalid parameters");

        if(year == "1" || year == "2" || year == "3") studyYear = year + "/B";
        else studyYear = year;

        trimSpaces(name);
        trimSpaces(addr);

        indexNo = idx;
        fullName = name;
        address = addr;
        phoneNumber = phone;
    }

    int getIndex() const { return indexNo; }
    string getYear() const { return studyYear; }
    string getName() const { return fullName; }
    string getAddress() const { return address; }
    string getPhone() const { return phoneNumber; }

    void display() const {
        cout << "Index number: " << indexNo << endl << "Study year: " << studyYear << endl << "Full name: " << fullName << endl
             << "Address: " << address << endl << "Phone: " << phoneNumber << endl;
    }
};

struct Computer {
    int serialNumber;
    string model;
    string specs;
    Person* currentUser = nullptr;

public:
    Computer(int serial, string modelN, string spec) : serialNumber(serial), model(modelN), specs(spec) {
        if(serial < 0) throw domain_error("Invalid parameters");
    }

    int getSerial() const { return serialNumber; }
    string getModel() const { return model; }
    string getSpecs() const { return specs; }

    void assign(Person& person) {
        if(currentUser != nullptr) throw domain_error("Computer already assigned");
        currentUser = &person;
    }

    void release() { currentUser = nullptr; }

    bool isAssigned() const { return currentUser != nullptr; }
    Person& getAssignee() const {
        if(currentUser == nullptr) throw domain_error("Computer is not assigned");
        return *currentUser;
    }

    void display() const {
        cout << "Serial number: " << serialNumber << endl << "Model: " << model << endl << "Specs: " << specs << endl;
        if(isAssigned())
            cout << "Assigned to: " << getAssignee().getName() << " (" << getAssignee().getIndex() << ")" << endl;
    }
};

class Admin {
    map<int, Person*> registry;
    map<int, Computer*> computers;

public:
    ~Admin() {
        for (auto &pair : registry) delete pair.second;
        for (auto &pair : computers) delete pair.second;
    }

    void addPerson(int idx, string year, string name, string addr, string phone) {
        if(registry.count(idx)) throw domain_error("Person already exists");
        registry[idx] = new Person(idx, year, name, addr, phone);
    }

    void addComputer(int serial, string modelName, string spec) {
        if(computers.count(serial)) throw domain_error("Computer already exists");
        computers[serial] = new Computer(serial, modelName, spec);
    }

    Person& findPerson(int idx) const {
        auto it = registry.find(idx);
        if(it == registry.end()) throw domain_error("Person not found");
        return *(it->second);
    }

    Computer& findComputer(int serial) const {
        auto it = computers.find(serial);
        if(it == computers.end()) throw domain_error("Computer not found");
        return *(it->second);
    }

    void listPeople() const {
        for(const auto &pair : registry) pair.second->display();
    }

    void listComputers() const {
        for(const auto &pair : computers) pair.second->display();
    }

    void assignComputer(int idx, int serial) {
        Person& person = findPerson(idx);
        Computer& comp = findComputer(serial);
        if(comp.isAssigned()) throw domain_error("Computer already assigned");
        comp.assign(person);
    }

    // Implement other member functions as needed...
};

int main() {
    // Due to the extensive changes, the main function primarily structuring would remain similar,
    // adapting variable names and method calls to the ones used in the modified classes.
}