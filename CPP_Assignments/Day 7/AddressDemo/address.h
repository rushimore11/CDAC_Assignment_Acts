#ifndef ADDRESS_H
#define ADDRESS_H

class Address {
private:
    char* street;
    char* city;
    char* state;
    int pin;

public:
    Address();
    Address(const char* street, const char* city, const char* state, int pin);
    ~Address();

    // Getters and Setters
    const char* getCity() const;
    void update(const char* street, const char* city, const char* state, int pin);
    void display() const;
};

#endif