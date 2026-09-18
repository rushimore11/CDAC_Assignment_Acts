#include <iostream>
#include <vector>
#include <memory>
#include <limits>
#include "Vehicle.h"
#include "Car.h"
#include "Bike.h"
#include "Utility.h"

using namespace std;

const string FILE_NAME = "vehicles.dat";

void saveVehiclesToBinary(const vector<unique_ptr<Vehicle>>& vehicles) {
    ofstream outFile(FILE_NAME, ios::binary | ios::trunc);
    if (!outFile) {
        cerr << "Error opening file for writing!\n";
        return;
    }

    for (const auto& v : vehicles) {
        v->writeToBinary(outFile);
    }
    outFile.close();
}

vector<unique_ptr<Vehicle>> loadVehiclesFromBinary() {
    Vehicle::resetVehicleCount();
    vector<unique_ptr<Vehicle>> loadedVehicles;
    ifstream inFile(FILE_NAME, ios::binary);
    if (!inFile) {
        cerr << "Error opening file for reading!\n";
        return loadedVehicles;
    }

    char type;
    while (inFile.read(&type, sizeof(type))) {
        unique_ptr<Vehicle> v = nullptr;
        if (type == 'C') {
            v = make_unique<Car>();
        } else if (type == 'B') {
            v = make_unique<Bike>();
        }

        if (v) {
            v->readFromBinary(inFile);
            loadedVehicles.push_back(move(v));
            Vehicle::incrementVehicleCount();
        }
    }

    inFile.close();
    return loadedVehicles;
}

int main() {
    int n = 0;
    cout << "Enter number of vehicles: ";
    while (!(cin >> n) || n <= 0) {
        cout << "Please enter a valid positive number: ";
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
    }

    vector<unique_ptr<Vehicle>> vehicles;

    for (int i = 0; i < n; ++i) {
        bool entrySuccess = false;
        while (!entrySuccess) {
            try {
                char type;
                cout << "\nEnter type of vehicle (C for Car, B for Bike): ";
                cin >> type;
                type = toupper(type);

                if (type != 'C' && type != 'B') {
                    throw InvalidInputException("Invalid vehicle type! Must be 'C' or 'B'.");
                }

                cin.ignore(numeric_limits<streamsize>::max(), '\n');

                string regNo, model, make;
                int yr;

                cout << "Enter Registration Number: ";
                getline(cin, regNo);

                cout << "Enter Model Name: ";
                getline(cin, model);

                cout << "Enter Manufacturer: ";
                getline(cin, make);

                cout << "Enter Year: ";
                if (!(cin >> yr)) {
                    cin.clear();
                    cin.ignore(numeric_limits<streamsize>::max(), '\n');
                    throw InvalidInputException("Year must be a numeric value!");
                }
                cin.ignore(numeric_limits<streamsize>::max(), '\n');

                if (type == 'C') {
                    string fuel;
                    cout << "Enter Fuel Type: ";
                    getline(cin, fuel);
                    vehicles.push_back(make_unique<Car>(regNo, model, make, yr, fuel));
                } else {
                    string capacity;
                    cout << "Enter Engine Capacity: ";
                    getline(cin, capacity);
                    vehicles.push_back(make_unique<Bike>(regNo, model, make, yr, capacity));
                }

                entrySuccess = true;
            } catch (const InvalidInputException& ex) {
                cout << "[Input Error]: " << ex.what() << " Re-entering this record...\n";
            }
        }
    }

    // Save records to binary file
    saveVehiclesToBinary(vehicles);

    // Clear input memory
    vehicles.clear();

    // Read records back from binary file
    vector<unique_ptr<Vehicle>> readVehicles = loadVehiclesFromBinary();

    // Display expected output
    cout << "\nExpected Output (after reading from file)\n";
    for (const auto& v : readVehicles) {
        // Runtime Polymorphism via smart pointer dereferencing
        v->displayInfo();
    }

    cout << "---------------------------------------------------------------------------------------\n";
    cout << "Total Vehicles stored: " << Vehicle::getVehicleCount() << "\n";

    return 0;
}