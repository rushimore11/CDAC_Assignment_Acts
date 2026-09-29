#include "BankSystem.h"
#include "SavingAccount.h"
#include "CurrentAccount.h"
#include "DematAccount.h"
#include "Share.h"
#include <iostream>
using namespace std;

BankSystem::BankSystem() : accountCount(0), accountCapacity(10), nextId(1001) {
    accounts = new Account*[accountCapacity];
}

BankSystem::~BankSystem() {
    for (int i = 0; i < accountCount; ++i) {
        delete accounts[i];
    }
    delete[] accounts;
}

void BankSystem::resizeAccountArray() {
    accountCapacity *= 2;
    Account** temp = new Account*[accountCapacity];
    for (int i = 0; i < accountCount; ++i) {
        temp[i] = accounts[i];
    }
    delete[] accounts;
    accounts = temp;
}

void BankSystem::addAccount() {
    if (accountCount == accountCapacity) {
        resizeAccountArray();
    }

    int typeChoice;
    cout << "\nChoose Account Type (1: Savings, 2: Current, 3: Demat): ";
    cin >> typeChoice;

    string fn, ln, mob, em, chq;
    int pin, txLimit;
    double initBal;

    cout << "Enter First Name: "; cin >> fn;
    cout << "Enter Last Name: "; cin >> ln;
    cout << "Enter Mobile: "; cin >> mob;
    cout << "Enter Email: "; cin >> em;
    cout << "Set 4-digit PIN: "; cin >> pin;

    if (typeChoice == 1) {
        cout << "Enter Initial Balance (Min 20,000): "; cin >> initBal;
        if (initBal < 20000.0) {
            cout << "Failed: Minimum initial deposit for Savings Account is 20,000.\n";
            return;
        }
        cout << "Enter Chequebook Number: "; cin >> chq;
        accounts[accountCount++] = new SavingAccount(nextId++, fn, ln, mob, em, pin, initBal, chq);
    } 
    else if (typeChoice == 2) {
        cout << "Enter Initial Balance (Min 1,000): "; cin >> initBal;
        if (initBal < 1000.0) {
            cout << "Failed: Minimum initial deposit for Current Account is 1,000.\n";
            return;
        }
        cout << "Enter Daily Transactions Limit: "; cin >> txLimit;
        accounts[accountCount++] = new CurrentAccount(nextId++, fn, ln, mob, em, pin, initBal, txLimit);
    } 
    else if (typeChoice == 3) {
        cout << "Enter Initial Deposit (0 if none): "; cin >> initBal;
        DematAccount* dematAcc = new DematAccount(nextId++, fn, ln, mob, em, pin, initBal);
        
        int numShares;
        cout << "Enter initial number of shares to add: "; 
        cin >> numShares;

        for (int i = 0; i < numShares; ++i) {
            string sName, bDate;
            int qty;
            double bPrice;

            cout << "\n--- Enter Share Details #" << (i + 1) << " ---\n";
            cout << "Share Name: "; cin >> sName;
            cout << "Number of Shares: "; cin >> qty;
            cout << "Buying Price: "; cin >> bPrice;
            cout << "Date of Purchase (DD/MM/YYYY): "; cin >> bDate;

            Share newShare(sName, qty, bPrice, bDate);
            dematAcc->addShare(newShare);
        }

        accounts[accountCount++] = dematAcc;
    } 
    else {
        cout << "Invalid account type selection.\n";
        return;
    }

    cout << "Account created successfully! Generated Account ID: " << (nextId - 1) << "\n";
}

void BankSystem::displayBalanceById() const {
    int id;
    cout << "Enter Account ID: "; cin >> id;
    for (int i = 0; i < accountCount; ++i) {
        if (accounts[i]->getAccountId() == id) {
            cout << "Account ID " << id << " Balance: " << accounts[i]->getBalance() << "\n";
            accounts[i]->displayDetails();
            return;
        }
    }
    cout << "Account not found.\n";
}

void BankSystem::closeAccount() {
    int id;
    cout << "Enter Account ID to close: "; cin >> id;
    for (int i = 0; i < accountCount; ++i) {
        if (accounts[i]->getAccountId() == id) {
            delete accounts[i];
            for (int j = i; j < accountCount - 1; ++j) {
                accounts[j] = accounts[j + 1];
            }
            --accountCount;
            cout << "Account " << id << " successfully closed.\n";
            return;
        }
    }
    cout << "Account not found.\n";
}

void BankSystem::countAccountType() const {
    int choice;
    cout << "Select Type to Count (1: Savings, 2: Current, 3: Demat): ";
    cin >> choice;

    AccountType targetType;
    if (choice == 1) targetType = SAVINGS;
    else if (choice == 2) targetType = CURRENT;
    else if (choice == 3) targetType = DEMAT;
    else {
        cout << "Invalid Selection.\n";
        return;
    }

    int count = 0;
    for (int i = 0; i < accountCount; ++i) {
        if (accounts[i]->getType() == targetType) {
            count++;
        }
    }
    cout << "Total accounts of selected type: " << count << "\n";
}

void BankSystem::withdrawAmount() {
    int id, pin;
    double amt;
    cout << "Enter Account ID: "; cin >> id;
    for (int i = 0; i < accountCount; ++i) {
        if (accounts[i]->getAccountId() == id) {
            cout << "Enter PIN: "; cin >> pin;
            cout << "Enter Amount to Withdraw: "; cin >> amt;
            if (accounts[i]->withdraw(amt, pin)) {
                cout << "Withdrawal Successful! Updated Balance: " << accounts[i]->getBalance() << "\n";
            }
            return;
        }
    }
    cout << "Account not found.\n";
}

void BankSystem::depositAmount() {
    int id;
    double amt;
    cout << "Enter Account ID: "; cin >> id;
    for (int i = 0; i < accountCount; ++i) {
        if (accounts[i]->getAccountId() == id) {
            cout << "Enter Amount to Deposit: "; cin >> amt;
            if (accounts[i]->deposit(amt)) {
                cout << "Deposit Successful! Updated Balance: " << accounts[i]->getBalance() << "\n";
            } else {
                cout << "Invalid deposit amount.\n";
            }
            return;
        }
    }
    cout << "Account not found.\n";
}

void BankSystem::changePin() {
    int id, oldPin, newPin;
    cout << "Enter Account ID: "; cin >> id;
    for (int i = 0; i < accountCount; ++i) {
        if (accounts[i]->getAccountId() == id) {
            cout << "Enter Old PIN: "; cin >> oldPin;
            cout << "Enter New PIN: "; cin >> newPin;
            if (accounts[i]->changePin(oldPin, newPin)) {
               cout << "PIN changed successfully.\n";
            } else {
                cout << "Incorrect Old PIN.\n";
            }
            return;
        }
    }
    cout << "Account not found.\n";
}

void BankSystem::runMenu() {
    int choice = -1;
    while (choice != 0) {
        cout << "\n================ MENU ================\n"
                  << "1. Add new account\n"
                  << "2. Display account balance by ID\n"
                  << "3. Close account\n"
                  << "4. Count a type of account\n"
                  << "5. Withdraw amount\n"
                  << "6. Deposit amount\n"
                  << "7. Change PIN\n"
                  << "0. Exit\n"
                  << "======================================\n"
                  << "Enter Choice: ";
        cin >> choice;

        switch (choice) {
            case 1: addAccount(); break;
            case 2: displayBalanceById(); break;
            case 3: closeAccount(); break;
            case 4: countAccountType(); break;
            case 5: withdrawAmount(); break;
            case 6: depositAmount(); break;
            case 7: changePin(); break;
            case 0: cout << "Exiting System.\n"; break;
            default: cout << "Invalid menu selection.\n"; break;
        }
    }
}