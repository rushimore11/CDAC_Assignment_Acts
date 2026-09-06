#include "CurrentAccount.h"
#include <iostream>
using namespace std;

CurrentAccount::CurrentAccount(int id, string fn, string ln, string mob, string em, int p, double bal, int txLimit)
    : Account(id, fn, ln, mob, em, p, bal, 1.0, 1000.0), maxTxPerDay(txLimit) {}

AccountType CurrentAccount::getType() const {
    return CURRENT;
}

int CurrentAccount::getMaxTxPerDay() const {
    return maxTxPerDay;
}

void CurrentAccount::setDailyTxLimit(int newLimit) {
    if (newLimit >= 0) {
        maxTxPerDay = newLimit;
    }
}

void CurrentAccount::displayDetails() const {
    Account::displayDetails();
    cout << " | Max Tx/Day: " << maxTxPerDay << "\n";
}