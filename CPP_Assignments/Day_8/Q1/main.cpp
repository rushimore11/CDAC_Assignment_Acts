#include <iostream>
#include <string>
#include <limits>
#include "Vehicle.h"
#include "Car.h"
#include "Truck.h"

using namespace std;

int main() {
    char choice = ' ';
    while (true) {
        char type;
        cout << "Enter type of Vehicle (C for Car, T for Truck): ";
        cin >> type;
        type = toupper(type);

        // Validation for vehicle type
        if (type != 'C' && type != 'T') {
            cout << "Invalid vehicle type! Please enter C or T.\n";
            continue;
        }

        double hours;
        while (true) {
            cout << "Enter parking hours: ";
            if (cin >> hours && hours > 0) {
                break;
            }
            cout << "Invalid hours. Hours must be positive.\n";
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
        }

        cin.ignore(numeric_limits<streamsize>::max(), '\n'); // clear buffer

        // Runtime Polymorphism via base class pointer
        Vehicle* v = nullptr;

        if (type == 'C') {
            v = new Car(hours);
        } else {
            string code;
            cout << "Enter discount code if available (or press Enter to skip): ";
            getline(cin, code);
            v = new Truck(hours, code);
        }

        // Virtual call resolved at runtime
        v->calculateCharge();

        delete v;

        cout << "\nDo you want to process another vehicle? (y/n): ";
        cin >> choice;
        if (choice != 'y' && choice != 'Y') {
            break;
        }
        cout << "\n";
    }

    return 0;
}