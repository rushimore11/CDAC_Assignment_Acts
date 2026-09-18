#include "SavingAccount.h"
#include <iostream>

SavingAccount::SavingAccount(int id, string fn, string ln, string mob, string em, int p, double bal, string chqNo)
    : Account(id, fn, ln, mob, em, p, bal, 4.0, 20000.0), chequebookNumber(chqNo) {}

AccountType SavingAccount::getType() const {
    return SAVINGS;
}

string SavingAccount::getChequebookNumber() const {
    return chequebookNumber;
}

void SavingAccount::setChequebookNumber(const string& chqNo) {
    chequebookNumber = chqNo;
}

void SavingAccount::displayDetails() const {
    Account::displayDetails();
    cout << " | Chequebook No: " << chequebookNumber << "\n";
}