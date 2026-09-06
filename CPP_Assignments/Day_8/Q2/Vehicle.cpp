#include "Vehicle.h"
#include "Utility.h"

int Vehicle::vehicleCount = 0;

Vehicle::Vehicle() : registrationNumber(""), modelName(""), manufacturer(""), year(0) {}

Vehicle::Vehicle(const string& reg, const string& model, const string& make, int yr)
    : registrationNumber(reg), modelName(model), manufacturer(make), year(yr) {
    
    if (reg.empty()) {
        throw InvalidInputException("Registration Number cannot be empty!");
    }

    if (!validateRange<int>(yr, 2000, getCurrentYear())) {
        throw InvalidInputException("Year must be between 2000 and " + to_string(getCurrentYear()) + "!");
    }

    vehicleCount++;
}

Vehicle::~Vehicle() {}

int Vehicle::getVehicleCount() {
    return vehicleCount;
}
void Vehicle::incrementVehicleCount() {
    vehicleCount++;
}

void Vehicle::resetVehicleCount() {
    vehicleCount = 0;
}

void Vehicle::writeString(ofstream& out, const string& str) {
    size_t len = str.size();
    out.write(reinterpret_cast<const char*>(&len), sizeof(len));
    if (len > 0) {
        out.write(str.data(), len);
    }
}

string Vehicle::readString(ifstream& in) {
    size_t len = 0;
    out_of_range err("Unexpected end of file while reading data");
    if (!in.read(reinterpret_cast<char*>(&len), sizeof(len))) {
        return "";
    }
    string str(len, '\0');
    if (len > 0) {
        in.read(&str[0], len);
    }
    return str;
}