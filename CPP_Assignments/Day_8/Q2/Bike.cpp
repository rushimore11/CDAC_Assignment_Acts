#include "Bike.h"
#include "Utility.h"

Bike::Bike() : Vehicle(), engineCapacity("") {}

Bike::Bike(const string& reg, const string& model, const string& make, int yr, const string& capacity)
    : Vehicle(reg, model, make, yr), engineCapacity(capacity) {
    if (capacity.empty()) {
        throw InvalidInputException("Engine capacity cannot be empty!");
    }
}

void Bike::displayInfo() const {
    cout << formatBaseInfo(registrationNumber, modelName, manufacturer, year)
         << ", EngineCapacity: " << engineCapacity << "\n";
}

void Bike::writeToBinary(ofstream& out) const {
    char type = 'B';
    out.write(&type, sizeof(type));
    writeString(out, registrationNumber);
    writeString(out, modelName);
    writeString(out, manufacturer);
    out.write(reinterpret_cast<const char*>(&year), sizeof(year));
    writeString(out, engineCapacity);
}

void Bike::readFromBinary(ifstream& in) {
    registrationNumber = readString(in);
    modelName = readString(in);
    manufacturer = readString(in);
    in.read(reinterpret_cast<char*>(&year), sizeof(year));
    engineCapacity = readString(in);
}