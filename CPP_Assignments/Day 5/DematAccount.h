#ifndef DEMATACCOUNT_H
#define DEMATACCOUNT_H

#include "Account.h"
#include "Share.h"
using namespace std;

class DematAccount : public Account {
private:
    Share* shareList;
    int shareCount;
    int shareCapacity;

    void resizeShareArray();

public:
    DematAccount(int id, string fn, string ln, string mob, string em, int p, double bal = 0.0);
    ~DematAccount() override;

    AccountType getType() const override;
    void addShare(const Share& s);
    void displayDetails() const override;
};

#endif