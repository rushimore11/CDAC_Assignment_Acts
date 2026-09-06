#include "Car.h"
#include "Utility.h"
#include <iostream>
using namespace std;

Car::Car(double h) : Vehicle(h) {}

void Car::calculateCharge() {
    double baseCharge = 100.0;
    double extraHours = (hours > 3.0) ? (hours - 3.0) : 0.0;
    double extraCharge = computeExtraCharge(extraHours, 30.0);
    double totalCharge = baseCharge + extraCharge;

    incrementReceipt();

    cout << "Vehicle type = Car\n";
    cout << "Extra charge = Rs. " << extraCharge << "\n";
    cout << "Total Parking Charge = Rs. " << totalCharge << "\n";
    cout << "Receipts generated so far: " << getReceiptCount() << "\n";
}