#ifndef UTILITY_H
#define UTILITY_H

#include <iostream>
#include <string>
#include <sstream>
#include <stdexcept>
#include <ctime>

using namespace std;

// Custom exceptions
class InvalidInputException : public runtime_error {
public:
    explicit InvalidInputException(const string& msg) : runtime_error(msg) {}
};

// Template function to validate range (e.g., Year between minVal and current year)
template <typename T>
bool validateRange(const T& value, const T& minVal, const T& maxVal) {
    return (value >= minVal && value <= maxVal);
}

// Inline function to format the common vehicle details
inline string formatBaseInfo(const string& regNo, const string& model, const string& make, int year) {
    stringstream ss;
    ss << "RegNo: " << regNo 
       << ", Model: " << model 
       << ", Manufacturer: " << make 
       << ", Year: " << year;
    return ss.str();
}

// Helper to fetch current year dynamically
inline int getCurrentYear() {
    time_t t = time(nullptr);
    tm* timePtr = localtime(&t);
    return 1900 + timePtr->tm_year;
}

#endif