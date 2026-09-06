#include <iostream>

using namespace std;

// Helper function to calculate string length
int stringLength(const char* str) {
    int len = 0;
    while (str && str[len] != '\0') {
        len++;
    }
    return len;
}

// Helper function to copy characters safely
void stringCopy(char* dest, const char* src) {
    int i = 0;
    while (src && src[i] != '\0') {
        dest[i] = src[i];
        i++;
    }
    dest[i] = '\0';
}

class Student {
private:
    int sid;
    char* sname;  // Character pointer instead of std::string
    int age;
    double m1;
    double m2;
    double m3;

    // Internal helper to handle memory reallocation for sname
    void assignName(const char* name) {
        delete[] sname; // Free previous buffer
        if (name) {
            int len = stringLength(name);
            sname = new char[len + 1];
            stringCopy(sname, name);
        } else {
            sname = new char[1];
            sname[0] = '\0';
        }
    }

public:
    // Default constructor
    Student() {
        sid = 0;
        sname = nullptr;
        assignName("Unknown");
        age = 0;
        m1 = 0.0;
        m2 = 0.0;
        m3 = 0.0;
    }

    // Parameterized constructor
    Student(int id, const char* name, int a, double mark1, double mark2, double mark3) {
        sid = id;
        sname = nullptr;
        assignName(name);
        age = a;
        m1 = mark1;
        m2 = mark2;
        m3 = mark3;
    }

    // Copy Constructor (prevents shallow copy issues with pointers)
    Student(const Student& other) {
        sid = other.sid;
        age = other.age;
        m1 = other.m1;
        m2 = other.m2;
        m3 = other.m3;
        sname = nullptr;
        assignName(other.sname);
    }

    // Destructor to prevent memory leaks
    ~Student() {
        delete[] sname;
    }

    // Setter methods
    void setSid(int id) { sid = id; }
    void setSname(const char* name) { assignName(name); }
    void setAge(int a) { age = a; }
    void setM1(double mark1) { m1 = mark1; }
    void setM2(double mark2) { m2 = mark2; }
    void setM3(double mark3) { m3 = mark3; }

    // Getter methods
    int getSid() const { return sid; }
    const char* getSname() const { return sname; }
    int getAge() const { return age; }
    double getM1() const { return m1; }
    double getM2() const { return m2; }
    double getM3() const { return m3; }

    // Calculate percentage
    double calculatePercentage() const {
        return (m1 + m2 + m3) / 3.0;
    }

    // Display method
    void display() const {
        cout << "------------------------------------" << "\n";
        cout << "Student ID   : " << sid << "\n";
        cout << "Student Name : " << (sname ? sname : "") << "\n";
        cout << "Age          : " << age << "\n";
        cout << "Marks (m1)   : " << m1 << "\n";
        cout << "Marks (m2)   : " << m2 << "\n";
        cout << "Marks (m3)   : " << m3 << "\n";
        cout << "Percentage   : " << calculatePercentage() << "%" << "\n";
        cout << "------------------------------------" << "\n";
    }
};

int main() {
    // 1. Default constructor + Setters
    Student s1;
    s1.setSid(101);
    s1.setSname("John Doe");
    s1.setAge(20);
    s1.setM1(85.5);
    s1.setM2(90.0);
    s1.setM3(78.5);

    cout << "Details of Student 1 (Setters):\n";
    s1.display();

    // 2. Parameterized constructor
    Student s2(102, "Alice Smith", 21, 92.0, 88.5, 95.0);

    cout << "\nDetails of Student 2 (Parameterized Constructor):\n";
    s2.display();

    return 0;
}