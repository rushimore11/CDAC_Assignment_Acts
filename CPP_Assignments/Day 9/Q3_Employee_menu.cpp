#include <iostream>
#include <string>
#include <map>

using namespace std;

class Employee {
private:
    int id;
    string name;

public:
    Employee() : id(0), name("") {}
    Employee(int empId, const string& empName) : id(empId), name(empName) {}

    int getId() const { return id; }
    string getName() const { return name; }

    void display() const {
        cout << "ID: " << id << " | Name: " << name << endl;
    }
};

int main() {
    map<int, Employee> empMap;
    int choice;

    do {
        cout << "\n--- Employee Management System ---\n";
        cout << "1. Add a new employee\n";
        cout << "2. Delete employee by ID\n";
        cout << "3. Display all\n";
        cout << "4. Display by ID\n";
        cout << "5. Display by Name\n";
        cout << "6. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1: {
                int id;
                string name;
                cout << "Enter Employee ID: ";
                cin >> id;

                if (empMap.find(id) != empMap.end()) {
                    cout << "Error: Employee with ID " << id << " already exists!\n";
                    break;
                }

                cout << "Enter Employee Name: ";
                cin.ignore();
                getline(cin, name);

                empMap[id] = Employee(id, name);
                cout << "Employee added successfully.\n";
                break;
            }

            case 2: {
                int id;
                cout << "Enter ID to delete: ";
                cin >> id;

                if (empMap.erase(id)) {
                    cout << "Employee with ID " << id << " deleted successfully.\n";
                } else {
                    cout << "Employee ID not found.\n";
                }
                break;
            }

            case 3: {
                if (empMap.empty()) {
                    cout << "No employees found.\n";
                } else {
                    cout << "\n--- All Employees ---\n";
                    for (const auto& pair : empMap) {
                        pair.second.display();
                    }
                }
                break;
            }

            case 4: {
                int id;
                cout << "Enter ID to search: ";
                cin >> id;

                auto it = empMap.find(id);
                if (it != empMap.end()) {
                    cout << "Employee found: ";
                    it->second.display();
                } else {
                    cout << "Employee ID not found.\n";
                }
                break;
            }

            case 5: {
                string searchName;
                cout << "Enter Name to search: ";
                cin.ignore();
                getline(cin, searchName);

                bool found = false;
                for (const auto& pair : empMap) {
                    if (pair.second.getName() == searchName) {
                        pair.second.display();
                        found = true;
                    }
                }

                if (!found) {
                    cout << "No employee found with name \"" << searchName << "\".\n";
                }
                break;
            }

            case 6:
                cout << "Exiting...\n";
                break;

            default:
                cout << "Invalid choice! Please try again.\n";
        }
    } while (choice != 6);

    return 0;
}