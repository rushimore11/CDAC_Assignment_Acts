#include "Account.h"
#include <iostream>
using namespace std;

Account::Account(int id, string fn, string ln, string mob, string em, int p, double bal, double ir, double mb)
    : accountId(id), fname(fn), lname(ln), mobile(mob), email(em), pin(p), balance(bal), interestRate(ir), minBalance(mb) {}

bool Account::verifyPin(int inputPin) const {
    return pin == inputPin;
}

bool Account::changePin(int oldPin, int newPin) {
    if (verifyPin(oldPin)) {
        pin = newPin;
        return true;
    }
    return false;
}

bool Account::deposit(double amount) {
    if (amount > 0) {
        balance += amount;
        return true;
    }
    return false;
}
#ifndef CURRENTACCOUNT_H
#define CURRENTACCOUNT_H

#include "Account.h"

class CurrentAccount : public Account {
private:
    int maxTxPerDay;

public:
    CurrentAccount(int id, std::string fn, std::string ln, std::string mob, std::string em, int p, double bal, int txLimit);
    ~CurrentAccount() override {}

    AccountType getType() const override;
    int getMaxTxPerDay() const;
    void setDailyTxLimit(int newLimit);
    void displayDetails() const override;
};

#endif
bool Account::withdraw(double amount, int inputPin) {
    if (!verifyPin(inputPin)) {
        std::cout << "Error: Incorrect PIN entered.\n";
        return false;
    }
    if ((balance - amount) < minBalance) {
        std::cout << "Error: Transaction declined. Minimum balance requirement (" << minBalance << ") violated.\n";
        return false;
    }
    balance -= amount;
    return true;
}

void Account::displayDetails() const {
    std::cout << "ID: " << accountId 
              << " | Name: " << fname << " " << lname 
              << " | Mobile: " << mobile 
              << " | Email: " << email 
              << " | Balance: " << balance 
              << " | Interest Rate: " << interestRate << "%"
              << " | Min Balance: " << minBalance;
}