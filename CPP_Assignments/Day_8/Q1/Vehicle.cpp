#include "Vehicle.h"

// Definition of static data member
int Vehicle::receiptCount = 0;

Vehicle::Vehicle(double h) : hours(h) {}

Vehicle::~Vehicle() {}

int Vehicle::getReceiptCount() {
    return receiptCount;
}

void Vehicle::incrementReceipt() {
    receiptCount++;
}