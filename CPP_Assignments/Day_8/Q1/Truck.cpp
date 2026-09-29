#include "Truck.h"
#include "Utility.h"
#include <iostream>
using namespace std;

Truck::Truck(double h, const string& code) : Vehicle(h), discountCode(code) {}

void Truck::calculateCharge() {
    double baseCharge = 200.0;
    double extraHours = (hours > 2.0) ? (hours - 2.0) : 0.0;
    double extraCharge = computeExtraCharge(extraHours, 50.0);
    double totalCharge = baseCharge + extraCharge;

    // Use function template to validate code
    bool isDiscounted = validateDiscount<string>(discountCode, "TRUCK50");
    if (isDiscounted) {
        totalCharge -= 50.0;
    }

    incrementReceipt();

    cout << "Vehicle type = Truck\n";
    cout << "Extra charge = Rs. " << extraCharge << "\n";
    if (isDiscounted) {
        cout << "Total Charge after discount = Rs. " << totalCharge << "\n";
    } else {
        cout << "Total Parking Charge = Rs. " << totalCharge << "\n";
    }
    cout << "Receipts generated so far: " << getReceiptCount() << "\n";
}