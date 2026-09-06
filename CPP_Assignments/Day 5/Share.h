#ifndef SHARE_H
#define SHARE_H

#include <string>
using namespace std;

class Share {
private:
    string shareName;
    int numberOfShares;
    double buyingPrice;
    string dateOfPurchase;
    double sellingPrice;
    string dateOfSelling;

public:
    // Constructors
    Share();
    Share(string name, int numShares, double bPrice, string bDate, double sPrice = 0.0, string sDate = "N/A");

    // Getters
    string getShareName() const;
    int getNumberOfShares() const;
    double getBuyingPrice() const;
    string getDateOfPurchase() const;
    double getSellingPrice() const;
    string getDateOfSelling() const;

    // Setters
    void setShareName(const string& name);
    void setNumberOfShares(int count);
    void setBuyingPrice(double price);
    void setDateOfPurchase(const string& date);

    // Business Logic
    void recordSale(double sellPrice, const string& sellDate);
    void displayShareDetails() const;
};

#endif