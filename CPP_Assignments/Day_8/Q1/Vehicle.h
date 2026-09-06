#ifndef VEHICLE_H
#define VEHICLE_H

#include <iostream>
#include <string>
using namespace std;

class Vehicle {
protected:
    double hours;
    static int receiptCount; // Static counter for receipts

public:
    Vehicle(double h);
    virtual ~Vehicle();

    // Pure virtual function for runtime polymorphism
    virtual void calculateCharge() = 0;

    // Static member function to get receipt count
    static int getReceiptCount();
    static void incrementReceipt();
};

#endif