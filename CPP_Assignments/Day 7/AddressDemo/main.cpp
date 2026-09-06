#include <iostream>
#include "PersonService.h"
using namespace std;

int main() {
    Person* parr[100];
    int count = 0;
    int choice = 0;

    do {
        cout << "\n==============================\n";
        cout << "1. Add new Person\n";
        cout << "2. Display All Persons\n";
        cout << "3. Search by Id\n";
        cout << "4. Search by Name\n";
        cout << "5. Modify Address\n";
        cout << "6. Find Address by Id of Person\n";
        cout << "7. Display All Persons in Given City\n";
        cout << "8. Exit\n";
        cout << "==============================\n";
        cout << "Enter Choice: ";
        cin >> choice;

        switch (choice) {
            case 1:
                if (PersonService::addPerson(parr, count))
                    cout << "Person added successfully!\n";
                break;
            case 2:
                PersonService::displayAll(parr, count);
                break;
            case 3:
                PersonService::searchById(parr, count);
                break;
            case 4:
                PersonService::searchByName(parr, count);
                break;
            case 5:
                PersonService::modifyAddress(parr, count);
                break;
            case 6:
                PersonService::findAddressById(parr, count);
                break;
            case 7:
                PersonService::displayByCity(parr, count);
                break;
            case 8:
                cout << "Cleaning up memory and exiting...\n";
                for (int i = 0; i < count; i++) {
                    delete parr[i];
                }
                break;
            default:
                cout << "Invalid Choice. Try again.\n";
        }
    } while (choice != 8);

    return 0;
}