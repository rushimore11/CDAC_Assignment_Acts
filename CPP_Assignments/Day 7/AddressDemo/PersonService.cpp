#include "PersonService.h"
#include <iostream>
#include <cstring>
using namespace std;

bool PersonService::addPerson(Person** parr, int &count) {
    char name[100], street[100], city[100], state[100];
    int pin;

    cout << "Enter Name: ";
    cin >> ws;
    cin.getline(name, 100);

    cout << "Enter Street: ";
    cin.getline(street, 100);

    cout << "Enter City: ";
    cin.getline(city, 100);

    cout << "Enter State: ";
    cin.getline(state, 100);

    cout << "Enter PIN: ";
    cin >> pin;

    Address* address = new Address(street, city, state, pin);
    parr[count++] = new Person(name, address);
    return true;
}

void PersonService::displayAll(Person** parr, int count) {
    if (count == 0) {
        cout << "No records found.\n";
        return;
    }
    for (int i = 0; i < count; i++) {
        parr[i]->display();
    }
}

void PersonService::searchById(Person** parr, int count) {
    int id;
    cout << "Enter Person ID to search: ";
    cin >> id;

    for (int i = 0; i < count; i++) {
        if (parr[i]->getId() == id) {
            cout << "Record Found:\n";
            parr[i]->display();
            return;
        }
    }
    cout << "Person with ID " << id << " not found.\n";
}

void PersonService::searchByName(Person** parr, int count) {
    char name[100];
    cout << "Enter Name to search: ";
    cin >> ws;
    cin.getline(name, 100);

    bool found = false;
    for (int i = 0; i < count; i++) {
        if (strcmp(parr[i]->getName(), name) == 0) {
            parr[i]->display();
            found = true;
        }
    }
    if (!found) cout << "No person found with name: " << name << endl;
}

void PersonService::modifyAddress(Person** parr, int count) {
    int id;
    cout << "Enter Person ID to modify address: ";
    cin >> id;

    for (int i = 0; i < count; i++) {
        if (parr[i]->getId() == id) {
            char street[100], city[100], state[100];
            int pin;

            cout << "Enter New Street: ";
            cin >> ws;
            cin.getline(street, 100);
            cout << "Enter New City: ";
            cin.getline(city, 100);
            cout << "Enter New State: ";
            cin.getline(state, 100);
            cout << "Enter New PIN: ";
            cin >> pin;

            parr[i]->getAddress()->update(street, city, state, pin);
            cout << "Address updated successfully.\n";
            return;
        }
    }
    cout << "Person with ID " << id << " not found.\n";
}

void PersonService::findAddressById(Person** parr, int count) {
    int id;
    cout << "Enter Person ID: ";
    cin >> id;

    for (int i = 0; i < count; i++) {
        if (parr[i]->getId() == id) {
            cout << "Address for ID " << id << ":\n";
            parr[i]->getAddress()->display();
            return;
        }
    }
    cout << "Person with ID " << id << " not found.\n";
}

void PersonService::displayByCity(Person** parr, int count) {
    char city[100];
    cout << "Enter City: ";
    cin >> ws;
    cin.getline(city, 100);

    bool found = false;
    for (int i = 0; i < count; i++) {
        if (strcmp(parr[i]->getAddress()->getCity(), city) == 0) {
            parr[i]->display();
            found = true;
        }
    }
    if (!found) cout << "No person found staying in " << city << ".\n";
}