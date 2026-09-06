#include <iostream>
using namespace std;

class Student
{
private:  
    int sid;
    string sname;
    int age;
    float m1, m2, m3;

public:
    // Default Constructor
    Student()
    {
        sid = 0;
        sname = "";
        age = 0;
        m1 = m2 = m3 = 0;
    }

    // Parameterized Constructor
    Student(int id, string name, int a, float mark1, float mark2, float mark3)
    {
        sid = id;
        sname = name;
        age = a;
        m1 = mark1;
        m2 = mark2;
        m3 = mark3;
    }

    // Setters
    void setSid(int id) { sid = id; }
    void setSname(string name) { sname = name; }
    void setAge(int a) { age = a; }
    void setM1(float mark) { m1 = mark; }
    void setM2(float mark) { m2 = mark; }
    void setM3(float mark) { m3 = mark; }

    // Getters
    int getSid() { return sid; }
    string getSname() { return sname; }
    int getAge() { return age; }
    float getM1() { return m1; }
    float getM2() { return m2; }
    float getM3() { return m3; }

    // Calculate Percentage
    float calculatePercentage()
    {
        return (m1 + m2 + m3) / 3;
    }

    // Display
    void display()
    {
        cout << "\n--- Student Details ---" << endl;
        cout << "Student ID: " << sid << endl;
        cout << "Student Name: " << sname << endl;
        cout << "Age: " << age << endl;
        cout << "Marks 1: " << m1 << endl;
        cout << "Marks 2: " << m2 << endl;
        cout << "Marks 3: " << m3 << endl;
        cout << "Percentage: " << calculatePercentage() << "%" << endl;
    }
};

int main()
{
    int id, age;
    string name;
    float mark1, mark2, mark3;

    // Taking input from user
    cout << "Enter Student ID: ";
    cin >> id;

    cout << "Enter Student Name: ";
    cin >> name;

    cout << "Enter Age: ";
    cin >> age;

    cout << "Enter Marks 1: ";
    cin >> mark1;

    cout << "Enter Marks 2: ";
    cin >> mark2;

    cout << "Enter Marks 3: ";
    cin >> mark3;

    // Create object using parameterized constructor
    Student s1(id, name, age, mark1, mark2, mark3);

    // Display details
    s1.display();

    return 0;
}