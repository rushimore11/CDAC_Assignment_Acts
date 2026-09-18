#ifndef PERSONSERVICE_H
#define PERSONSERVICE_H

#include "person.h"

class PersonService {
public:
    static bool addPerson(Person** parr, int &count);
    static void displayAll(Person** parr, int count);
    static void searchById(Person** parr, int count);
    static void searchByName(Person** parr, int count);
    static void modifyAddress(Person** parr, int count);
    static void findAddressById(Person** parr, int count);
    static void displayByCity(Person** parr, int count);
};

#endif