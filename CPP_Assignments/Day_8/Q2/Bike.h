#ifndef BIKE_H
#define BIKE_H

#include "Vehicle.h"

class Bike : public Vehicle {
private:
    string engineCapacity;

public:
    Bike();
    Bike(const string& reg, const string& model, const string& make, int yr, const string& capacity);

    void displayInfo() const override;
    void writeToBinary(ofstream& out) const override;
    void readFromBinary(ifstream& in) override;
};

#endif