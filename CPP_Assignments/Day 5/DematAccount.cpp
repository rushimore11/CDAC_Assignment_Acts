#include "DematAccount.h"
#include <iostream>

DematAccount::DematAccount(int id, string fn, string ln, string mob, string em, int p, double bal)
    : Account(id, fn, ln, mob, em, p, bal, 0.0, 0.0), shareCount(0), shareCapacity(5) {
    shareList = new Share[shareCapacity];
}

DematAccount::~DematAccount() {
    delete[] shareList;
}

void DematAccount::resizeShareArray() {
    shareCapacity *= 2;
    Share* temp = new Share[shareCapacity];
    for (int i = 0; i < shareCount; ++i) {
        temp[i] = shareList[i];
    }
    delete[] shareList;
    shareList = temp;
}

AccountType DematAccount::getType() const {
    return DEMAT;
}

void DematAccount::addShare(const Share& s) {
    if (shareCount == shareCapacity) {
        resizeShareArray();
    }
    shareList[shareCount++] = s;
}

void DematAccount::displayDetails() const {
    Account::displayDetails();
    cout << "\n--- Portfolio Holdings (" << shareCount << " shares) ---\n";
    if (shareCount == 0) {
        cout << "No shares currently held.\n";
    } else {
        for (int i = 0; i < shareCount; ++i) {
            shareList[i].displayShareDetails();
        }
    }
}