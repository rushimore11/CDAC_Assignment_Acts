#include <iostream>

using namespace std;

// Function to dynamically allocate 2D array
int** allocateArray(int rows, int cols) {
    int** arr = new int*[rows];
    for (int i = 0; i < rows; i++) {
        arr[i] = new int[cols];
    }
    return arr;
}

// Function to free allocated memory
void freeArray(int** arr, int rows) {
    for (int i = 0; i < rows; i++) {
        delete[] arr[i];
    }
    delete[] arr;
}

// 1. Accept data
void acceptData(int** arr, int rows, int cols) {
    cout << "Enter elements for " << rows << "x" << cols << " array:\n";
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            cout << "arr[" << i << "][" << j << "]: ";
            cin >> arr[i][j];
        }
    }
}

// 2. Display data
void displayData(int** arr, int rows, int cols) {
    cout << "\nMatrix elements:\n";
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            cout << arr[i][j] << "\t";
        }
        cout << "\n";
    }
}

// 3. Find maximum number
int findMax(int** arr, int rows, int cols) {
    int maxVal = arr[0][0];
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (arr[i][j] > maxVal) {
                maxVal = arr[i][j];
            }
        }
    }
    return maxVal;
}

// 4. Find minimum number
int findMin(int** arr, int rows, int cols) {
    int minVal = arr[0][0];
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (arr[i][j] < minVal) {
                minVal = arr[i][j];
            }
        }
    }
    return minVal;
}

// 5. Find addition of all numbers
int findSumAll(int** arr, int rows, int cols) {
    int sum = 0;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            sum += arr[i][j];
        }
    }
    return sum;
}

// 6. Find sum of each row
void sumOfEachRow(int** arr, int rows, int cols) {
    for (int i = 0; i < rows; i++) {
        int rowSum = 0;
        for (int j = 0; j < cols; j++) {
            rowSum += arr[i][j];
        }
        cout << "Sum of Row " << (i + 1) << ": " << rowSum << "\n";
    }
}

// 7. Find sum of each column
void sumOfEachCol(int** arr, int rows, int cols) {
    for (int j = 0; j < cols; j++) {
        int colSum = 0;
        for (int i = 0; i < rows; i++) {
            colSum += arr[i][j];
        }
        cout << "Sum of Column " << (j + 1) << ": " << colSum << "\n";
    }
}

// 8. Find row-wise maximum
void rowWiseMax(int** arr, int rows, int cols) {
    for (int i = 0; i < rows; i++) {
        int rowMax = arr[i][0];
        for (int j = 1; j < cols; j++) {
            if (arr[i][j] > rowMax) {
                rowMax = arr[i][j];
            }
        }
        cout << "Maximum of Row " << (i + 1) << ": " << rowMax << "\n";
    }
}

// 9. Find column-wise maximum
void colWiseMax(int** arr, int rows, int cols) {
    for (int j = 0; j < cols; j++) {
        int colMax = arr[0][j];
        for (int i = 1; i < rows; i++) {
            if (arr[i][j] > colMax) {
                colMax = arr[i][j];
            }
        }
        cout << "Maximum of Column " << (j + 1) << ": " << colMax << "\n";
    }
}

int main() {
    int rows = 0, cols = 0;
    cout << "Enter number of rows: ";
    cin >> rows;
    cout << "Enter number of columns: ";
    cin >> cols;

    if (rows <= 0 || cols <= 0) {
        cout << "Invalid dimensions.\n";
        return 1;
    }

    int** arr = allocateArray(rows, cols);
    bool dataEntered = false;
    int choice = 0;

    do {
        cout << "\n================ MENU ================\n";
        cout << "1. Accept data\n";
        cout << "2. Display data\n";
        cout << "3. Find maximum number\n";
        cout << "4. Find minimum number\n";
        cout << "5. Find addition of all numbers\n";
        cout << "6. Find sum of each row\n";
        cout << "7. Find sum of each column\n";
        cout << "8. Find row-wise maximum\n";
        cout << "9. Find column-wise maximum\n";
        cout << "10. Exit\n";
        cout << "Enter your choice (1-10): ";
        cin >> choice;

        if (choice >= 2 && choice <= 9 && !dataEntered) {
            cout << "Please accept data first (Choice 1).\n";
            continue;
        }

        switch (choice) {
            case 1:
                acceptData(arr, rows, cols);
                dataEntered = true;
                break;
            case 2:
                displayData(arr, rows, cols);
                break;
            case 3:
                cout << "Maximum number: " << findMax(arr, rows, cols) << "\n";
                break;
            case 4:
                cout << "Minimum number: " << findMin(arr, rows, cols) << "\n";
                break;
            case 5:
                cout << "Sum of all numbers: " << findSumAll(arr, rows, cols) << "\n";
                break;
            case 6:
                sumOfEachRow(arr, rows, cols);
                break;
            case 7:
                sumOfEachCol(arr, rows, cols);
                break;
            case 8:
                rowWiseMax(arr, rows, cols);
                break;
            case 9:
                colWiseMax(arr, rows, cols);
                break;
            case 10:
                cout << "Exiting...\n";
                break;
            default:
                cout << "Invalid choice. Please select from 1 to 10.\n";
        }
    } while (choice != 10);

    freeArray(arr, rows);
    return 0;
}