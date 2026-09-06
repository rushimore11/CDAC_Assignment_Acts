#include <iostream>

using namespace std;

class Employee {
private:
    int empId;
    char name[100];
    double basicSalary;

public:
    // Default constructor
    Employee() {
        empId = 0;
        name[0] = '\0';
        basicSalary = 0.0;
    }

    // Overloaded calculateSalary functions
    // 1. Using basic salary only
    double calculateSalary() const {
        return basicSalary;
    }

    // 2. Using basic salary and bonus
    double calculateSalary(double bonus) const {
        return basicSalary + bonus;
    }

    // 3. Using basic salary, bonus, and overtime amount
    double calculateSalary(double bonus, double overtimeAmount) const {
        return basicSalary + bonus + overtimeAmount;
    }

    // 4. Using hourly rate and hours worked
    double calculateSalary(double hourlyRate, int hoursWorked) const {
        return hourlyRate * hoursWorked;
    }

    // Member function to display calculation menu and compute salary
    void showSalaryMenu() {
        int choice;
        do {
            cout << "\n--- Salary Calculation Menu for " << name << " (ID: " << empId << ") ---\n";
            cout << "1. Calculate using Basic Salary\n";
            cout << "2. Calculate using Basic Salary + Bonus\n";
            cout << "3. Calculate using Basic Salary + Bonus + Overtime\n";
            cout << "4. Calculate using Hourly Rate + Hours Worked\n";
            cout << "5. Return to Main Menu\n";
            cout << "Enter your choice (1-5): ";
            cin >> choice;

            switch (choice) {
                case 1: {
                    cout << "Total Salary (Basic only): " << calculateSalary() << "\n";
                    break;
                }
                case 2: {
                    double bonus;
                    cout << "Enter Bonus: ";
                    cin >> bonus;
                    cout << "Total Salary: " << calculateSalary(bonus) << "\n";
                    break;
                }
                case 3: {
                    double bonus, ot;
                    cout << "Enter Bonus: ";
                    cin >> bonus;
                    cout << "Enter Overtime Amount: ";
                    cin >> ot;
                    cout << "Total Salary: " << calculateSalary(bonus, ot) << "\n";
                    break;
                }
                case 4: {
                    double rate;
                    int hours;
                    cout << "Enter Hourly Rate: ";
                    cin >> rate;
                    cout << "Enter Hours Worked: ";
                    cin >> hours;
                    cout << "Total Salary: " << calculateSalary(rate, hours) << "\n";
                    break;
                }
                case 5:
                    cout << "Exiting calculation menu...\n";
                    break;
                default:
                    cout << "Invalid choice! Please try again.\n";
            }
        } while (choice != 5);
    }

    // Friend stream operators
    friend istream& operator>>(istream& in, Employee& emp) {
        cout << "Enter Employee ID: ";
        in >> emp.empId;
        cout << "Enter Employee Name: ";
        in >> emp.name;
        cout << "Enter Basic Salary: ";
        in >> emp.basicSalary;
        return in;
    }

    friend ostream& operator<<(ostream& out, const Employee& emp) {
        out << "ID: " << emp.empId 
            << " | Name: " << emp.name 
            << " | Basic Salary: " << emp.basicSalary;
        return out;
    }
};

int main() {
    int totalEmployees;
    cout << "Enter total number of employees: ";
    cin >> totalEmployees;

    if (totalEmployees <= 0) {
        cout << "Invalid number of employees.\n";
        return 0;
    }

    // Dynamic array of pointers
    Employee** empList = new Employee*[totalEmployees];

    // Input employee records using array pointers
    for (int i = 0; i < totalEmployees; ++i) {
        cout << "\n--- Entering Details for Employee " << (i + 1) << " ---\n";
        *(empList + i) = new Employee();
        cin >> *(*(empList + i)); 
    }

    // Display all employees
    cout << "\n================ ALL EMPLOYEES ================\n";
    for (int i = 0; i < totalEmployees; ++i) {
        cout << *(*(empList + i)) << "\n";
    }

    // Main menu to select an employee and calculate salary
    int mainChoice;
    do {
        cout << "\n================ MAIN MENU ================\n";
        cout << "1. Select Employee to Calculate Salary\n";
        cout << "2. Display All Employees\n";
        cout << "3. Exit\n";
        cout << "Enter choice: ";
        cin >> mainChoice;

        if (mainChoice == 1) {
            int empIndex;
            cout << "Enter Employee Index (1 to " << totalEmployees << "): ";
            cin >> empIndex;

            if (empIndex >= 1 && empIndex <= totalEmployees) {
                // Access using pointer notation and run the class-internal menu
                (*(empList + (empIndex - 1)))->showSalaryMenu();
            } else {
                cout << "Invalid employee index!\n";
            }
        } else if (mainChoice == 2) {
            cout << "\n--- Employee List ---\n";
            for (int i = 0; i < totalEmployees; ++i) {
                cout << "[" << (i + 1) << "] " << *(*(empList + i)) << "\n";
            }
        } else if (mainChoice == 3) {
            cout << "Terminating program...\n";
        } else {
            cout << "Invalid choice!\n";
        }
    } while (mainChoice != 3);

    // Free allocated memory
    for (int i = 0; i < totalEmployees; ++i) {
        delete *(empList + i);
    }
    delete[] empList;

    return 0;
}