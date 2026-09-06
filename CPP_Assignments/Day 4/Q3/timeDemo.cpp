#include <iostream>

using namespace std;

class Time {
private:
    int hours;
    int minutes;

    // Helper method to keep minutes within [0, 59] and hours non-negative
    void normalize() {
        if (minutes >= 60) {
            hours += minutes / 60;
            minutes = minutes % 60;
        } else if (minutes < 0) {
            int borrowedHours = ((-minutes) + 59) / 60;
            hours -= borrowedHours;
            minutes += borrowedHours * 60;
        }

        // Prevent negative time durations
        if (hours < 0) {
            hours = 0;
            minutes = 0;
        }
    }

public:
    // 1. Default Constructor
    Time() : hours(0), minutes(0) {}

    // 2. Parameterized Constructor
    Time(int h, int m) : hours(h), minutes(m) {
        normalize();
    }

    // 3. Copy Constructor
    Time(const Time& other) : hours(other.hours), minutes(other.minutes) {}

    // Stream Insertion Operator (<<)
    friend ostream& operator<<(ostream& out, const Time& t) {
        out << t.hours << " hours ";
        if (t.minutes < 10) {
            out << "0";
        }
        out << t.minutes << " minutes";
        return out;
    }

    // Stream Extraction Operator (>>)
    friend istream& operator>>(istream& in, Time& t) {
        cout << "Enter Hours: ";
        in >> t.hours;
        cout << "Enter Minutes: ";
        in >> t.minutes;
        t.normalize();
        return in;
    }

    // Binary Addition (+) Operator
    Time operator+(const Time& other) const {
        return Time(this->hours + other.hours, this->minutes + other.minutes);
    }

    // Binary Subtraction (-) Operator
    Time operator-(const Time& other) const {
        int h = this->hours - other.hours;
        int m = this->minutes - other.minutes;

        // Borrow 1 hour if minutes difference is negative
        if (m < 0) {
            m += 60;
            h -= 1;
        }

        if (h < 0) {
            cout << "\n[Notice: Resulting duration is negative; capped to 0 hours 00 minutes]\n";
            return Time(0, 0);
        }

        return Time(h, m);
    }

    // Assignment (=) Operator
    Time& operator=(const Time& other) {
        if (this != &other) { // Protect against self-assignment
            this->hours = other.hours;
            this->minutes = other.minutes;
        }
        return *this; // Return reference for chaining
    }

    // Prefix Increment (++t)
    Time& operator++() {
        this->minutes++;
        this->normalize();
        return *this;
    }

    // Postfix Increment (t++)
    Time operator++(int) {
        Time temp = *this;
        this->minutes++;
        this->normalize();
        return temp;
    }

    // Prefix Decrement (--t)
    Time& operator--() {
        if (this->hours > 0 || this->minutes > 0) {
            this->minutes--;
            this->normalize();
        }
        return *this;
    }

    // Postfix Decrement (t--)
    Time operator--(int) {
        Time temp = *this;
        if (this->hours > 0 || this->minutes > 0) {
            this->minutes--;
            this->normalize();
        }
        return temp;
    }
};

class TestTime {
public:
    static void runTests() {
        // Requirement 1 & 2: Constructors and initialization
        cout << "================ 1. CONSTRUCTORS & I/O ================\n";
        Time t1;                                // Default Constructor
        Time t2(2, 30);                         // Parameterized Constructor
        Time t3(1, 45);                         // Parameterized Constructor
        Time tCopy(t2);                         // Copy Constructor

        cout << "Default Constructor (t1): " << t1 << "\n";
        cout << "Parameterized Constructor (t2): " << t2 << "\n";
        cout << "Parameterized Constructor (t3): " << t3 << "\n";
        cout << "Copy Constructor (tCopy from t2): " << tCopy << "\n";

        // Testing >> stream operator
        Time tInput;
        cout << "\nEnter time details for tInput:\n";
        cin >> tInput;
        cout << "You entered (tInput): " << tInput << "\n";

        // Requirement 3: Binary Addition (+)
        cout << "\n================ 2. ADDITION (+) OPERATOR ================\n";
        Time sum1 = t2 + t3;
        cout << t2 << " + " << t3 << " = " << sum1 << "\n";

        Time addA(10, 50), addB(2, 30);
        Time sum2 = addA + addB;
        cout << addA << " + " << addB << " = " << sum2 << "\n";

        // Requirement 4: Binary Subtraction (-)
        cout << "\n================ 3. SUBTRACTION (-) OPERATOR ================\n";
        Time subA(5, 30), subB(2, 45);
        Time diff1 = subA - subB;
        cout << subA << " - " << subB << " = " << diff1 << "\n";

        Time subC(10, 15), subD(2, 30);
        Time diff2 = subC - subD;
        cout << subC << " - " << subD << " = " << diff2 << "\n";

        // Requirement 5 & 6: Assignment (=) and Chained Assignment
        cout << "\n================ 4. ASSIGNMENT (=) OPERATOR ================\n";
        Time assignA(6, 40), assignB, assignC;
        cout << "Initial assignA: " << assignA << "\n";
        cout << "Initial assignB: " << assignB << "\n";
        cout << "Initial assignC: " << assignC << "\n";

        // Chained assignment
        assignC = assignB = assignA;
        cout << "\nAfter chained assignment (assignC = assignB = assignA):\n";
        cout << "assignA: " << assignA << "\n";
        cout << "assignB: " << assignB << "\n";
        cout << "assignC: " << assignC << "\n";

        // Self-assignment
        assignA = assignA;
        cout << "After self-assignment (assignA = assignA): " << assignA << "\n";

        // Requirement 7: Prefix Increment (++t)
        cout << "\n================ 5. PREFIX INCREMENT (++t) ================\n";
        Time preInc(10, 59);
        cout << "Initial value:        " << preInc << "\n";
        Time preIncResult = ++preInc;
        cout << "Returned value:       " << preIncResult << "\n";
        cout << "Value after ++preInc: " << preInc << "\n";

        // Requirement 8: Postfix Increment (t++)
        cout << "\n================ 6. POSTFIX INCREMENT (t++) ================\n";
        Time postInc(10, 59);
        cout << "Initial value:         " << postInc << "\n";
        Time postIncOld = postInc++;
        cout << "Old returned value:    " << postIncOld << "\n";
        cout << "Value after postInc++: " << postInc << "\n";

        // Requirement 9: Prefix Decrement (--t)
        cout << "\n================ 7. PREFIX DECREMENT (--t) ================\n";
        Time preDec(11, 0);
        cout << "Initial value:        " << preDec << "\n";
        Time preDecResult = --preDec;
        cout << "Returned value:       " << preDecResult << "\n";
        cout << "Value after --preDec: " << preDec << "\n";

        // Requirement 10 & 11: Postfix Decrement (t--)
        cout << "\n================ 8. POSTFIX DECREMENT (t--) ================\n";
        Time postDec(11, 0);
        cout << "Initial value:         " << postDec << "\n";
        Time postDecOld = postDec--;
        cout << "Old returned value:    " << postDecOld << "\n";
        cout << "Value after postDec--: " << postDec << "\n";
    }
};

int main() {
    TestTime::runTests();
    return 0;
}