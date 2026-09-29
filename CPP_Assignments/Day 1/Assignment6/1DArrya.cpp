#include <iostream>

using namespace std;

// Helper: Check if a double is mathematically an integer
bool isInteger(double val) {
    return val == (long long)val;
}

// Helper: Check if a double is an even integer
bool isEven(double val) {
    if (!isInteger(val)) return false;
    long long n = (long long)val;
    return (n % 2 == 0);
}

// Helper: Check if a double is an odd integer
bool isOdd(double val) {
    if (!isInteger(val)) return false;
    long long n = (long long)val;
    return (n % 2 != 0);
}

// Helper: Check if a double is a prime number
bool isPrime(double val) {
    if (!isInteger(val)) return false;
    long long n = (long long)val;
    if (n <= 1) return false;
    for (long long i = 2; i * i <= n; ++i) {
        if (n % i == 0) return false;
    }
    return true;
}

// Pointer-based Bubble Sort (Descending order)
void sortDescendingUsingPointers(double* arr, int size) {
    for (double* i = arr; i < arr + size - 1; ++i) {
        for (double* j = arr; j < arr + size - 1 - (i - arr); ++j) {
            if (*j < *(j + 1)) {
                double temp = *j;
                *j = *(j + 1);
                *(j + 1) = temp;
            }
        }
    }
}

// 1. Accept Data
void acceptData(double* arr, int& size, int capacity) {
    cout << "Enter number of elements (max " << capacity << "): ";
    cin >> size;
    if (size < 0 || size > capacity) {
        cout << "Invalid size.\n";
        size = 0;
        return;
    }
    cout << "Enter " << size << " elements:\n";
    for (double* ptr = arr; ptr < arr + size; ++ptr) {
        cin >> *ptr;
    }
    cout << "Data accepted successfully.\n";
}

// 2. Display Data
void displayData(const double* arr, int size) {
    if (size == 0) {
        cout << "Array is empty.\n";
        return;
    }
    cout << "Array elements: [ ";
    for (const double* ptr = arr; ptr < arr + size; ++ptr) {
        cout << *ptr << " ";
    }
    cout << "]\n";
}

// 3. Modify number at a given position (1-based index)
void modifyAtPosition(double* arr, int size) {
    if (size == 0) {
        cout << "Array is empty.\n";
        return;
    }
    int pos;
    cout << "Enter position to modify (1 to " << size << "): ";
    cin >> pos;
    if (pos < 1 || pos > size) {
        cout << "Invalid position!\n";
        return;
    }
    cout << "Enter new value: ";
    cin >> *(arr + (pos - 1));
    cout << "Value updated successfully.\n";
}

// 4. Delete the given number (deletes first occurrence)
void deleteNumber(double* arr, int& size) {
    if (size == 0) {
        cout << "Array is empty.\n";
        return;
    }
    double target;
    cout << "Enter number to delete: ";
    cin >> target;

    double* targetPtr = nullptr;
    for (double* ptr = arr; ptr < arr + size; ++ptr) {
        if (*ptr == target) {
            targetPtr = ptr;
            break;
        }
    }

    if (!targetPtr) {
        cout << "Number not found in the array.\n";
        return;
    }

    // Shift elements to the left using pointers
    for (double* ptr = targetPtr; ptr < arr + size - 1; ++ptr) {
        *ptr = *(ptr + 1);
    }
    size--;
    cout << "Number deleted successfully.\n";
}

// 5. Search a number
void searchNumber(const double* arr, int size) {
    if (size == 0) {
        cout << "Array is empty.\n";
        return;
    }
    double target;
    cout << "Enter number to search: ";
    cin >> target;

    int pos = 1;
    bool found = false;
    for (const double* ptr = arr; ptr < arr + size; ++ptr, ++pos) {
        if (*ptr == target) {
            cout << "Found " << target << " at position " << pos << " (index " << (pos - 1) << ").\n";
            found = true;
            break;
        }
    }
    if (!found) {
        cout << "Number not found.\n";
    }
}

// 6. Find addition of all even numbers
void sumEvenNumbers(const double* arr, int size) {
    if (size == 0) {
        cout << "Array is empty.\n";
        return;
    }
    double sum = 0.0;
    bool found = false;
    for (const double* ptr = arr; ptr < arr + size; ++ptr) {
        if (isEven(*ptr)) {
            sum += *ptr;
            found = true;
        }
    }
    if (found) {
        cout << "Sum of even numbers: " << sum << "\n";
    } else {
        cout << "No even integers found in the array.\n";
    }
}

// 7. Display prime numbers and count
void displayPrimes(const double* arr, int size) {
    if (size == 0) {
        cout << "Array is empty.\n";
        return;
    }
    int count = 0;
    cout << "Prime numbers in array: ";
    for (const double* ptr = arr; ptr < arr + size; ++ptr) {
        if (isPrime(*ptr)) {
            cout << *ptr << " ";
            count++;
        }
    }
    cout << "\nTotal prime count: " << count << "\n";
}

// 8. Find maximum odd number
void findMaxOdd(const double* arr, int size) {
    if (size == 0) {
        cout << "Array is empty.\n";
        return;
    }
    double maxOdd = 0;
    bool found = false;

    for (const double* ptr = arr; ptr < arr + size; ++ptr) {
        if (isOdd(*ptr)) {
            if (!found || *ptr > maxOdd) {
                maxOdd = *ptr;
                found = true;
            }
        }
    }
    if (found) {
        cout << "Maximum odd number: " << maxOdd << "\n";
    } else {
        cout << "No odd integers found in the array.\n";
    }
}

// 9. Find nth maximum using pointer-based sorting on a temporary array
void findNthMaximum(const double* arr, int size) {
    if (size == 0) {
        cout << "Array is empty.\n";
        return;
    }
    int n;
    cout << "Enter n: ";
    cin >> n;

    if (n < 1 || n > size) {
        cout << "Invalid value of n. Must be between 1 and " << size << ".\n";
        return;
    }

    // Copy array using pointers to avoid altering original array order
    double tempArr[100];
    double* dest = tempArr;
    for (const double* src = arr; src < arr + size; ++src, ++dest) {
        *dest = *src;
    }

    // Sort descending using pointers
    sortDescendingUsingPointers(tempArr, size);

    cout << "The " << n << "th maximum element is: " << *(tempArr + (n - 1)) << "\n";
}

int main() {
    const int CAPACITY = 100;
    double arr[CAPACITY];
    int size = 0;
    int choice;

    do {
        cout << "\n==============================\n";
        cout << "   ARRAY OPERATIONS MENU\n";
        cout << "==============================\n";
        cout << "1. Accept Data\n";
        cout << "2. Display Data\n";
        cout << "3. Modify Number at Position\n";
        cout << "4. Delete Given Number\n";
        cout << "5. Search a Number\n";
        cout << "6. Addition of Even Numbers\n";
        cout << "7. Display Primes & Count\n";
        cout << "8. Find Maximum Odd Number\n";
        cout << "9. Find Nth Maximum Number\n";
        cout << "10. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1: acceptData(arr, size, CAPACITY); break;
            case 2: displayData(arr, size); break;
            case 3: modifyAtPosition(arr, size); break;
            case 4: deleteNumber(arr, size); break;
            case 5: searchNumber(arr, size); break;
            case 6: sumEvenNumbers(arr, size); break;
            case 7: displayPrimes(arr, size); break;
            case 8: findMaxOdd(arr, size); break;
            case 9: findNthMaximum(arr, size); break;
            case 10: cout << "Exiting program.\n"; break;
            default: cout << "Invalid choice! Please try again.\n";
        }
    } while (choice != 10);

    return 0;
}