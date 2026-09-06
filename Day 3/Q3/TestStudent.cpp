#include <iostream>
#include <string>
#include "Student.h"

using namespace std;

int main() {
    int maxStudents;
    cout << "Enter the maximum number of students to store: ";
    cin >> maxStudents;

    // Create a dynamic array of Student pointers
    Student** studentList = new Student*[maxStudents];
    int currentCount = 0;
    int choice;

    do {
        cout << "\n===== STUDENT MANAGEMENT MENU =====";
        cout << "\n1. Add / Display All Students";
        cout << "\n2. Search by ID";
        cout << "\n3. Search by Name";
        cout << "\n4. Calculate GPA of a student";
        cout << "\n5. Exit";
        cout << "\nEnter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1: {
                cout << "\n1. Add a new student\n2. View all existing students\nEnter choice: ";
                int subChoice;
                cin >> subChoice;

                if (subChoice == 1) {
                    if (currentCount >= maxStudents) {
                        cout << "\nDatabase Full! Cannot add more students.\n";
                    } else {
                        // Dynamically allocate memory for an individual student object
                        studentList[currentCount] = new Student();
                        studentList[currentCount]->acceptDetails();
                        currentCount++;
                        cout << "\nStudent added successfully!\n";
                    }
                } else {
                    if (currentCount == 0) {
                        cout << "\nNo student records found.\n";
                    } else {
                        cout << "\n--- Displaying All Students ---";
                        for (int i = 0; i < currentCount; i++) {
                            studentList[i]->displayDetails();
                        }
                    }
                }
                break;
            }
            case 2: {
                if (currentCount == 0) {
                    cout << "\nDatabase is empty.\n";
                    break;
                }
                int searchId;
                bool found = false;
                cout << "\nEnter ID to search: ";
                cin >> searchId;

                for (int i = 0; i < currentCount; i++) {
                    if (studentList[i]->getId() == searchId) {
                        cout << "\nStudent Record Found:";
                        studentList[i]->displayDetails();
                        found = true;
                        break;
                    }
                }
                if (!found) cout << "\nStudent with ID " << searchId << " not found.\n";
                break;
            }
            case 3: {
                if (currentCount == 0) {
                    cout << "\nDatabase is empty.\n";
                    break;
                }
                string searchName;
                bool found = false;
                cin.ignore();
                cout << "\nEnter Name to search: ";
                getline(cin, searchName);

                for (int i = 0; i < currentCount; i++) {
                    if (studentList[i]->getName() == searchName) {
                        cout << "\nStudent Record Found:";
                        studentList[i]->displayDetails();
                        found = true;
                    }
                }
                if (!found) cout << "\nStudent with Name \"" << searchName << "\" not found.\n";
                break;
            }
            case 4: {
                if (currentCount == 0) {
                    cout << "\nDatabase is empty.\n";
                    break;
                }
                int searchId;
                bool found = false;
                cout << "\nEnter Student ID to process GPA: ";
                cin >> searchId;

                for (int i = 0; i < currentCount; i++) {
                    if (studentList[i]->getId() == searchId) {
                        double freshGpa = studentList[i]->calculateGPA();
                        cout << "\nRecalculated GPA for " << studentList[i]->getName() 
                             << " is: " << freshGpa << "\n";
                        found = true;
                        break;
                    }
                }
                if (!found) cout << "\nStudent with ID " << searchId << " not found.\n";
                break;
            }
            case 5:
                cout << "\nExiting and cleaning memory. Goodbye!\n";
                break;
            default:
                cout << "\nInvalid input choice. Please retry.\n";
        }
    } while (choice != 5);

    // Freeing allocated heap memory to protect against memory leaks
    for (int i = 0; i < currentCount; i++) {
        delete studentList[i];
    }
    delete[] studentList;

    return 0;
}
