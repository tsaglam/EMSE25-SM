#include <iostream>
#include <string>
#include <stdexcept>
#include <map>

class S
{
    int i;
    std::string y, nm, add, ph;
    public:
    S(int i, std::string y, std::string nm, std::string add, std::string ph) : i(i), y(y), nm(nm), add(add), ph(ph)
    {
        if(i < 10000 || i > 99999) throw std::domain_error("Faulty Params");
    }
    int GetI() const {return i;}
    std::string GetY() const {return y;}
    std::string GetNm() const {return nm;}
    std::string GetAdd() const {return add;}
    std::string GetPh() const {return ph;}
    void Print() const
    {
        std::cout << "Index Num: " << i << "\nYear: " << GetY() << "\nName: " << GetNm() << "\nAddress: " << GetAdd() << "\nPhone: " << GetPh() << std::endl;
    }
};

class L
{
    int ev; 
    std::string name, specs; 
    S *who;
    public:
    L(int ev, std::string name, std::string specs) : ev(ev), name(name), specs(specs), who(nullptr)
    {
        if(ev < 0) throw std::domain_error("Faulty Params");
    }
    void AssignTo(S& s)
    {
        if(who != nullptr) throw std::domain_error("Already assigned");
        who = &s;
    }
    void Unassign()
    {
        if(who != nullptr) who = nullptr;
    }
    bool IsAssigned() const {return who != nullptr;}
    S& Whos() const
    {
        if(!IsAssigned()) throw std::domain_error("Not assigned");
        return *who;
    }
    void Print() const
    {
        std::cout << "EV: " << ev << "\nName: " << name << "\nSpecs: " << specs << std::endl;
    }
};

class A
{
    std::map<int, S*> s_map;
    std::map<int, L*> l_map;
};

int main()
{
    return 0;
}