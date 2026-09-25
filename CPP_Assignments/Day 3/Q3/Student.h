#ifndef STUDENT_H
#define STUDENT_H

#include <string>
using namespace std;

class Student {
private:
    int id;
    string name;
    double m1, m2, m3;
    double gpa;

public:
    // Constructor
    Student();

    // Member functions
    void acceptDetails();
    void displayDetails() const;
    double calculateGPA();

    // Getters
    int getId() const;
    string getName() const;
    double getGPA() const;
};

#endif
