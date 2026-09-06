#ifndef CURRENTACCOUNT_H
#define CURRENTACCOUNT_H

#include "Account.h"

class CurrentAccount : public Account {
private:
    int maxTxPerDay;

public:
    CurrentAccount(int id, string fn, string ln, string mob, string em, int p, double bal, int txLimit);
    ~CurrentAccount() override {}

    AccountType getType() const override;
    int getMaxTxPerDay() const;
    void setDailyTxLimit(int newLimit);
    void displayDetails() const override;
};

#endif