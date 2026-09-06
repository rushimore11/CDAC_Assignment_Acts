#include "person.h"
#include <iostream>
#include <cstring>
using namespace std;

int Person::personCount = 100; // Auto-generated ID starting base

Person::Person(const char* name, Address* address) {
    this->id = ++Person::personCount;
    this->name = new char[strlen(name) + 1];
    strcpy(this->name, name);
    this->address = address;
}

Person::~Person() {
    delete[] name;
    delete address;
}

int Person::getId() const {
    return this->id;
}

const char* Person::getName() const {
    return this->name;
}

Address* Person::getAddress() const {
    return this->address;
}

void Person::display() const {
    cout << "ID: " << id << " | Name: " << name << " | Address -> ";
    if (address) {
        address->display();
    } else {
        cout << "No Address Recorded\n";
    }
}