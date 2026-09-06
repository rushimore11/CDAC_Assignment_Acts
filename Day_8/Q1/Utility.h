#ifndef UTILITY_H
#define UTILITY_H

#include <iostream>
#include <string>
using namespace std;

// Inline function to calculate extra parking charges
inline double computeExtraCharge(double extraHours, double ratePerHour) {
    return (extraHours > 0) ? (extraHours * ratePerHour) : 0.0;
}

// Function template to validate discount codes
template <typename T>
bool validateDiscount(const T& enteredCode, const T& validCode) {
    return enteredCode == validCode;
}

#endif