#ifndef VEHICLE_H
#define VEHICLE_H

#include <iostream>
#include <string>
#include <fstream>

using namespace std;

class Vehicle {
protected:
    string registrationNumber;
    string modelName;
    string manufacturer;
    int year;

    static int vehicleCount; // Static counter for vehicle records

    // Binary file helpers for strings
    static void writeString(ofstream& out, const string& str);
    static string readString(ifstream& in);

public:
    Vehicle();
    Vehicle(const string& reg, const string& model, const string& make, int yr);
    virtual ~Vehicle();

    // Pure virtual functions
    virtual void displayInfo() const = 0;
    virtual void writeToBinary(ofstream& out) const = 0;
    virtual void readFromBinary(ifstream& in) = 0;

    // Static member function
    static int getVehicleCount();
    static void incrementVehicleCount();
    static void resetVehicleCount();
};

#endif