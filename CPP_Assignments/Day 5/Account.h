#ifndef ACCOUNT_H
#define ACCOUNT_H

#include <string>
using namespace std;

enum AccountType { SAVINGS, CURRENT, DEMAT };

class Account {
protected:
    int accountId;
    string fname;
    string lname;
    string mobile;
    string email;
    int pin;
    double balance;
    double interestRate ;
    double minBalance;

public:
    Account(int id, string fn, string ln, string mob, string em, int p, double bal, double ir, double mb);
    virtual ~Account() {}

    int getAccountId() const { return accountId; }
    double getBalance() const { return balance; }
    virtual AccountType getType() const = 0;

    bool verifyPin(int inputPin) const;
    bool changePin(int oldPin, int newPin);
    
    virtual bool deposit(double amount);
    virtual bool withdraw(double amount, int inputPin);
    virtual void displayDetails() const;
};

#endif