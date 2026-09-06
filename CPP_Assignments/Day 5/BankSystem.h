#ifndef BANKSYSTEM_H
#define BANKSYSTEM_H

#include "Account.h"

class BankSystem {
private:
    Account** accounts;
    int accountCount;
    int accountCapacity;
    int nextId;

    void resizeAccountArray();

public:
    BankSystem();
    ~BankSystem();

    void addAccount();
    void displayBalanceById() const;
    void closeAccount();
    void countAccountType() const;
    void withdrawAmount();
    void depositAmount();
    void changePin();
    void runMenu();
};

#endif