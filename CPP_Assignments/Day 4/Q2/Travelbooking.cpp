#include <iostream>

using namespace std;

class Booking {
private:
    int bookingId;
    char source[50];
    char destination[50];
    double distance;
    double fare;

    // Helper function to copy strings without string libraries
    void copyString(char* dest, const char* src) {
        int i = 0;
        while (src[i] != '\0') {
            dest[i] = src[i];
            i++;
        }
        dest[i] = '\0';
    }

public:
    // Parameterized constructor with default values
    Booking(int id = 0, const char* src = "Not Set", const char* dest = "Not Set", double dist = 0.0, double f = 0.0) {
        bookingId = id;
        copyString(source, src);
        copyString(destination, dest);
        distance = dist;
        fare = f;
    }

    // Copy constructor
    Booking(const Booking& other) {
        bookingId = other.bookingId;
        copyString(source, other.source);
        copyString(destination, other.destination);
        distance = other.distance;
        fare = other.fare;
    }

    // Getters
    int getBookingId() const { return bookingId; }
    const char* getSource() const { return source; }
    const char* getDestination() const { return destination; }
    double getDistance() const { return distance; }
    double getFare() const { return fare; }

    // Setters
    void setBookingId(int id) { bookingId = id; }
    void setSource(const char* src) { copyString(source, src); }
    void setDestination(const char* dest) { copyString(destination, dest); }
    void setDistance(double dist) { distance = dist; }
    void setFare(double f) { fare = f; }

    // --- Overloaded calculateFare functions ---

    // 1. Based only on distance
    double calculateFare(double ratePerKm) {
        fare = distance * ratePerKm;
        return fare;
    }

    // 2. Based on distance and vehicle type
    double calculateFare(double ratePerKm, char vehicleType) {
        double multiplier = 1.0;
        if (vehicleType == 'B' || vehicleType == 'b') {       // Bike / Auto
            multiplier = 0.8;
        } else if (vehicleType == 'C' || vehicleType == 'c') { // Sedan / Car
            multiplier = 1.2;
        } else if (vehicleType == 'S' || vehicleType == 's') { // SUV
            multiplier = 1.6;
        }
        fare = (distance * ratePerKm) * multiplier;
        return fare;
    }

    // 3. Based on distance, vehicle type, and number of passengers
    double calculateFare(double ratePerKm, char vehicleType, int passengers) {
        double baseRate = calculateFare(ratePerKm, vehicleType);
        double extraPassengerCharge = (passengers > 1) ? (passengers - 1) * 30.0 : 0.0;
        fare = baseRate + extraPassengerCharge;
        return fare;
    }

    // 4. Premium booking with additional service charges
    double calculateFare(double ratePerKm, char vehicleType, int passengers, double serviceCharge) {
        fare = calculateFare(ratePerKm, vehicleType, passengers) + serviceCharge;
        return fare;
    }

    // Menu to select calculation method for this journey
    void processFareMenu() {
        int choice;
        double rate;

        cout << "\nEnter Base Rate per Km: ";
        cin >> rate;

        do {
            cout << "\n===== FARE CALCULATION MENU =====\n";
            cout << "1. Calculate by Distance Only\n";
            cout << "2. Calculate by Distance + Vehicle Type\n";
            cout << "3. Calculate by Distance + Vehicle Type + Passengers\n";
            cout << "4. Calculate Premium Fare (with Service Charge)\n";
            cout << "5. Display Journey Summary\n";
            cout << "6. Exit to Main\n";
            cout << "Enter your choice (1-6): ";
            cin >> choice;

            switch (choice) {
                case 1: {
                    double total = calculateFare(rate);
                    cout << "Total Fare (Distance Only): " << total << "\n";
                    break;
                }
                case 2: {
                    char vType;
                    cout << "Enter Vehicle Type (B for Bike, C for Car, S for SUV): ";
                    cin >> vType;
                    double total = calculateFare(rate, vType);
                    cout << "Total Fare: " << total << "\n";
                    break;
                }
                case 3: {
                    char vType;
                    int passengers;
                    cout << "Enter Vehicle Type (B/C/S): ";
                    cin >> vType;
                    cout << "Enter Number of Passengers: ";
                    cin >> passengers;
                    double total = calculateFare(rate, vType, passengers);
                    cout << "Total Fare: " << total << "\n";
                    break;
                }
                case 4: {
                    char vType;
                    int passengers;
                    double serviceCharge;
                    cout << "Enter Vehicle Type (B/C/S): ";
                    cin >> vType;
                    cout << "Enter Number of Passengers: ";
                    cin >> passengers;
                    cout << "Enter Premium Service Charge: ";
                    cin >> serviceCharge;
                    double total = calculateFare(rate, vType, passengers, serviceCharge);
                    cout << "Total Premium Fare: " << total << "\n";
                    break;
                }
                case 5:
                    cout << "\n" << *this << "\n";
                    break;
                case 6:
                    cout << "Returning...\n";
                    break;
                default:
                    cout << "Invalid choice! Enter 1-6.\n";
            }
        } while (choice != 6);
    }

    // Stream operator overloading
    friend istream& operator>>(istream& in, Booking& b) {
        cout << "Enter Booking ID: ";
        in >> b.bookingId;
        cout << "Enter Source: ";
        in >> b.source;
        cout << "Enter Destination: ";
        in >> b.destination;
        cout << "Enter Distance (in km): ";
        in >> b.distance;
        b.fare = 0.0;
        return in;
    }

    friend ostream& operator<<(ostream& out, const Booking& b) {
        out << "Booking ID: " << b.bookingId
            << " | From: " << b.source
            << " | To: " << b.destination
            << " | Distance: " << b.distance << " km"
            << " | Current Fare: " << b.fare;
        return out;
    }
};

int main() {
    int totalBookings;
    cout << "Enter number of travel journeys to book: ";
    cin >> totalBookings;

    if (totalBookings <= 0) {
        cout << "Invalid number of journeys.\n";
        return 0;
    }

    // Dynamic array of pointers
    Booking** journeyList = new Booking*[totalBookings];

    // Accept user input for each journey using pointer arithmetic
    for (int i = 0; i < totalBookings; ++i) {
        cout << "\n--- Enter Journey Details #" << (i + 1) << " ---\n";
        *(journeyList + i) = new Booking();
        cin >> *(*(journeyList + i));
    }

    // Menu driven flow to calculate fare for journeys
    int option;
    do {
        cout << "\n================ TRAVEL BOOKING SYSTEM ================\n";
        cout << "1. Select a Journey to Calculate Fare\n";
        cout << "2. View All Journeys\n";
        cout << "3. Exit\n";
        cout << "Enter choice: ";
        cin >> option;

        if (option == 1) {
            int index;
            cout << "Select Journey index (1 to " << totalBookings << "): ";
            cin >> index;

            if (index >= 1 && index <= totalBookings) {
                (*(journeyList + (index - 1)))->processFareMenu();
            } else {
                cout << "Invalid journey index.\n";
            }
        } else if (option == 2) {
            cout << "\n--- List of All Journeys ---\n";
            for (int i = 0; i < totalBookings; ++i) {
                cout << "[" << (i + 1) << "] " << *(*(journeyList + i)) << "\n";
            }
        } else if (option == 3) {
            cout << "Exiting program...\n";
        } else {
            cout << "Invalid choice! Please select 1, 2, or 3.\n";
        }
    } while (option != 3);

    // Free allocated memory
    for (int i = 0; i < totalBookings; ++i) {
        delete *(journeyList + i);
    }
    delete[] journeyList;

    return 0;
}