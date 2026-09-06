#include "address.h"
#include <iostream>
#include <cstring>
using namespace std;

Address::Address() : street(nullptr), city(nullptr), state(nullptr), pin(0) {}

Address::Address(const char* street, const char* city, const char* state, int pin) {
    this->street = new char[strlen(street) + 1];
    strcpy(this->street, street);

    this->city = new char[strlen(city) + 1];
    strcpy(this->city, city);

    this->state = new char[strlen(state) + 1];
    strcpy(this->state, state);

    this->pin = pin;
}

Address::~Address() {
    delete[] street;
    delete[] city;
    delete[] state;
}

const char* Address::getCity() const {
    return this->city;
}

void Address::update(const char* street, const char* city, const char* state, int pin) {
    delete[] this->street;
    delete[] this->city;
    delete[] this->state;

    this->street = new char[strlen(street) + 1];
    strcpy(this->street, street);

    this->city = new char[strlen(city) + 1];
    strcpy(this->city, city);

    this->state = new char[strlen(state) + 1];
    strcpy(this->state, state);

    this->pin = pin;
}

void Address::display() const {
    cout << "Street: " << (street ? street : "") 
         << ", City: " << (city ? city : "") 
         << ", State: " << (state ? state : "") 
         << ", PIN: " << pin << endl;
}