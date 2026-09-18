#ifndef PERSON_H
#define PERSON_H

#include "address.h"

class Person {
private:
    int id;
    char* name;
    Address* address;
    static int personCount;

public:
    Person(const char* name, Address* address);
    ~Person();

    int getId() const;
    const char* getName() const;
    Address* getAddress() const;
    void display() const;
};

#endif