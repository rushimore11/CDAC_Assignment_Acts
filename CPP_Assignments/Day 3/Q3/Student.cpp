#include "Student.h"
#include <iostream>

using namespace std;

// Constructor
Student::Student() {
    id = 0;
    m1 = m2 = m3 = gpa = 0.0;
    name = "";
}

// Accept student input
void Student::acceptDetails() {
    cout << "Enter Student ID: ";
    cin >> id;
    cin.ignore(); // Clear buffer

    cout << "Enter Student Name: ";
    getline(cin, name);

    cout << "Enter Marks for Subject 1 (m1): ";
    cin >> m1;
    cout << "Enter Marks for Subject 2 (m2): ";
    cin >> m2;
    cout << "Enter Marks for Subject 3 (m3): ";
    cin >> m3;
    
    // Automatically calculate GPA upon data entry
    calculateGPA();
}

// Calculate GPA based on the formula
double Student::calculateGPA() {
    gpa = (1.0 / 3.0) * m1 + (1.0 / 2.0) * m2 + (1.0 / 4.0) * m3;
    return gpa;
}

// Display student properties
void Student::displayDetails() const {
    cout << "\nID        : " << id;
    cout << "\nName      : " << name;
    cout << "\nMarks     : m1=" << m1 << ", m2=" << m2 << ", m3=" << m3;
    cout << "\nCalculated GPA: " << gpa;
    
}
// Getters
int Student::getId() const { return id; }
string Student::getName() const { return name; }
double Student::getGPA() const { return gpa; }
