#ifndef TRUCK_H
#define TRUCK_H

#include "Vehicle.h"
#include <string>
using namespace std;

class Truck : public Vehicle {
private:
    string discountCode;

public:
    Truck(double h, const string& code = "");
    void calculateCharge() override;
};

#endif