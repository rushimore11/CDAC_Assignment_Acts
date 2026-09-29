#include "Share.h"
#include <iostream>
using namespace std;

// Default constructor
Share::Share() 
    : shareName(""), numberOfShares(0), buyingPrice(0.0), 
      dateOfPurchase("N/A"), sellingPrice(0.0), dateOfSelling("N/A") {}

// Parameterized constructor
Share::Share(string name, int numShares, double bPrice, string bDate, double sPrice, string sDate)
    : shareName(name), numberOfShares(numShares), buyingPrice(bPrice), 
      dateOfPurchase(bDate), sellingPrice(sPrice), dateOfSelling(sDate) {}

// Getters
string Share::getShareName() const { return shareName; }
int Share::getNumberOfShares() const { return numberOfShares; }
double Share::getBuyingPrice() const { return buyingPrice; }
string Share::getDateOfPurchase() const { return dateOfPurchase; }
double Share::getSellingPrice() const { return sellingPrice; }
string Share::getDateOfSelling() const { return dateOfSelling; }

// Setters
void Share::setShareName(const string& name) { shareName = name; }
void Share::setNumberOfShares(int count) { numberOfShares = count; }
void Share::setBuyingPrice(double price) { buyingPrice = price; }
void Share::setDateOfPurchase(const string& date) { dateOfPurchase = date; }

// Record sale logic
void Share::recordSale(double sellPrice, const string& sellDate) {
    sellingPrice = sellPrice;
    dateOfSelling = sellDate;
}

// Display Share Details
void Share::displayShareDetails() const {
        cout << "Share Name       : " << shareName << "\n"
              << "Quantity         : " << numberOfShares << "\n"
              << "Buying Price     : " << buyingPrice << "\n"
              << "Purchase Date    : " << dateOfPurchase << "\n"
              << "Selling Price    : " << (sellingPrice > 0.0 ? std::to_string(sellingPrice) : "Not Sold") << "\n"
              << "Selling Date     : " << dateOfSelling << "\n"
              << "----------------------------------------\n";
}