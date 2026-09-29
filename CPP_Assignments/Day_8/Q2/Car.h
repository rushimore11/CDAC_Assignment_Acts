#ifndef CAR_H
#define CAR_H

#include "Vehicle.h"

class Car : public Vehicle {
private:
    string fuelType;

public:
    Car();
    Car(const string& reg, const string& model, const string& make, int yr, const string& fuel);

    void displayInfo() const override;
    void writeToBinary(ofstream& out) const override;
    void readFromBinary(ifstream& in) override;
};

#endif