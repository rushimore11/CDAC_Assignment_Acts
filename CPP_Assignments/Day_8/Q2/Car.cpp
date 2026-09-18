#include "Car.h"
#include "Utility.h"

Car::Car() : Vehicle(), fuelType("") {}

Car::Car(const string& reg, const string& model, const string& make, int yr, const string& fuel)
    : Vehicle(reg, model, make, yr), fuelType(fuel) {
    if (fuel.empty()) {
        throw InvalidInputException("Fuel type cannot be empty!");
    }
}

void Car::displayInfo() const {
    cout << formatBaseInfo(registrationNumber, modelName, manufacturer, year)
         << ", FuelType: " << fuelType << "\n";
}

void Car::writeToBinary(ofstream& out) const {
    char type = 'C';
    out.write(&type, sizeof(type));
    writeString(out, registrationNumber);
    writeString(out, modelName);
    writeString(out, manufacturer);
    out.write(reinterpret_cast<const char*>(&year), sizeof(year));
    writeString(out, fuelType);
}

void Car::readFromBinary(ifstream& in) {
    registrationNumber = readString(in);
    modelName = readString(in);
    manufacturer = readString(in);
    in.read(reinterpret_cast<char*>(&year), sizeof(year));
    fuelType = readString(in);
}