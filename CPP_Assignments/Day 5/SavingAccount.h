#ifndef SAVINGACCOUNT_H
#define SAVINGACCOUNT_H

#include "Account.h"
using namespace std;

class SavingAccount : public Account {
private:
    string chequebookNumber;

public:
    SavingAccount(int id, string fn, string ln, string mob, string em, int p, double bal, string chqNo);
    ~SavingAccount() override {}

    AccountType getType() const override;
    string getChequebookNumber() const;
    void setChequebookNumber(const string& chqNo);
    void displayDetails() const override;
};

#endif