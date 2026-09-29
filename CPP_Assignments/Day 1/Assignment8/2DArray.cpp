#include <iostream>

using namespace std;

// Function to free dynamically allocated memory
void freeMatrix(int**& matrix, int rows) {
    if (matrix != nullptr) {
        for (int i = 0; i < rows; ++i) {
            delete[] matrix[i];
        }
        delete[] matrix;
        matrix = nullptr;
    }
}

// 1. Accept Data
void acceptData(int**& matrix, int& rows, int& cols) {
    // Clean up previous allocation if any
    freeMatrix(matrix, rows);

    cout << "Enter number of rows: ";
    cin >> rows;
    cout << "Enter number of columns: ";
    cin >> cols;

    if (rows <= 0 || cols <= 0) {
        cout << "Invalid dimensions. Rows and columns must be positive.\n";
        rows = 0;
        cols = 0;
        return;
    }

    // Dynamic allocation of 2D array
    matrix = new int*[rows];
    for (int i = 0; i < rows; ++i) {
        matrix[i] = new int[cols];
    }

    cout << "Enter elements for a " << rows << "x" << cols << " matrix:\n";
    for (int i = 0; i < rows; ++i) {
        for (int j = 0; j < cols; ++j) {
            cout << "Element [" << i << "][" << j << "]: ";
            cin >> matrix[i][j];
        }
    }
    cout << "Data entered successfully.\n";
}

// 2. Display Data
void displayData(int** matrix, int rows, int cols) {
    if (matrix == nullptr || rows == 0 || cols == 0) {
        cout << "Matrix is empty. Please enter data first.\n";
        return;
    }

    cout << "\nMatrix (" << rows << "x" << cols << "):\n";
    for (int i = 0; i < rows; ++i) {
        for (int j = 0; j < cols; ++j) {
            cout << matrix[i][j] << "\t";
        }
        cout << "\n";
    }
}

// 3. Find Maximum Number
void findMax(int** matrix, int rows, int cols) {
    if (matrix == nullptr || rows == 0 || cols == 0) {
        cout << "Matrix is empty.\n";
        return;
    }

    int maxVal = matrix[0][0];
    for (int i = 0; i < rows; ++i) {
        for (int j = 0; j < cols; ++j) {
            if (matrix[i][j] > maxVal) {
                maxVal = matrix[i][j];
            }
        }
    }
    cout << "Overall Maximum Number: " << maxVal << "\n";
}

// 4. Find Minimum Number
void findMin(int** matrix, int rows, int cols) {
    if (matrix == nullptr || rows == 0 || cols == 0) {
        cout << "Matrix is empty.\n";
        return;
    }

    int minVal = matrix[0][0];
    for (int i = 0; i < rows; ++i) {
        for (int j = 0; j < cols; ++j) {
            if (matrix[i][j] < minVal) {
                minVal = matrix[i][j];
            }
        }
    }
    cout << "Overall Minimum Number: " << minVal << "\n";
}

// 5. Find Addition of All Numbers
void sumAll(int** matrix, int rows, int cols) {
    if (matrix == nullptr || rows == 0 || cols == 0) {
        cout << "Matrix is empty.\n";
        return;
    }

    long long totalSum = 0;
    for (int i = 0; i < rows; ++i) {
        for (int j = 0; j < cols; ++j) {
            totalSum += matrix[i][j];
        }
    }
    cout << "Sum of all numbers in the matrix: " << totalSum << "\n";
}

// 6. Find Sum of Each Row
void sumEachRow(int** matrix, int rows, int cols) {
    if (matrix == nullptr || rows == 0 || cols == 0) {
        cout << "Matrix is empty.\n";
        return;
    }

    cout << "\nSum of each row:\n";
    for (int i = 0; i < rows; ++i) {
        long long rowSum = 0;
        for (int j = 0; j < cols; ++j) {
            rowSum += matrix[i][j];
        }
        cout << "Row " << (i + 1) << " sum: " << rowSum << "\n";
    }
}

// 7. Find Sum of Each Column
void sumEachCol(int** matrix, int rows, int cols) {
    if (matrix == nullptr || rows == 0 || cols == 0) {
        cout << "Matrix is empty.\n";
        return;
    }

    cout << "\nSum of each column:\n";
    for (int j = 0; j < cols; ++j) {
        long long colSum = 0;
        for (int i = 0; i < rows; ++i) {
            colSum += matrix[i][j];
        }
        cout << "Column " << (j + 1) << " sum: " << colSum << "\n";
    }
}

// 8. Find Row-wise Maximum
void rowWiseMax(int** matrix, int rows, int cols) {
    if (matrix == nullptr || rows == 0 || cols == 0) {
        cout << "Matrix is empty.\n";
        return;
    }

    cout << "\nRow-wise Maximum:\n";
    for (int i = 0; i < rows; ++i) {
        int maxVal = matrix[i][0];
        for (int j = 1; j < cols; ++j) {
            if (matrix[i][j] > maxVal) {
                maxVal = matrix[i][j];
            }
        }
        cout << "Row " << (i + 1) << " maximum: " << maxVal << "\n";
    }
}

// 9. Find Column-wise Maximum
void colWiseMax(int** matrix, int rows, int cols) {
    if (matrix == nullptr || rows == 0 || cols == 0) {
        cout << "Matrix is empty.\n";
        return;
    }

    cout << "\nColumn-wise Maximum:\n";
    for (int j = 0; j < cols; ++j) {
        int maxVal = matrix[0][j];
        for (int i = 1; i < rows; ++i) {
            if (matrix[i][j] > maxVal) {
                maxVal = matrix[i][j];
            }
        }
        cout << "Column " << (j + 1) << " maximum: " << maxVal << "\n";
    }
}

int main() {
    int** matrix = nullptr;
    int rows = 0, cols = 0;
    int choice;

    do {
        cout << "\n=========================================\n";
        cout << "       2D DYNAMIC ARRAY OPERATIONS       \n";
        cout << "=========================================\n";
        cout << "1. Accept Data\n";
        cout << "2. Display Data\n";
        cout << "3. Find Maximum Number\n";
        cout << "4. Find Minimum Number\n";
        cout << "5. Find Addition of All Numbers\n";
        cout << "6. Find Sum of Each Row\n";
        cout << "7. Find Sum of Each Column\n";
        cout << "8. Find Row-wise Maximum\n";
        cout << "9. Find Column-wise Maximum\n";
        cout << "10. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1: acceptData(matrix, rows, cols); break;
            case 2: displayData(matrix, rows, cols); break;
            case 3: findMax(matrix, rows, cols); break;
            case 4: findMin(matrix, rows, cols); break;
            case 5: sumAll(matrix, rows, cols); break;
            case 6: sumEachRow(matrix, rows, cols); break;
            case 7: sumEachCol(matrix, rows, cols); break;
            case 8: rowWiseMax(matrix, rows, cols); break;
            case 9: colWiseMax(matrix, rows, cols); break;
            case 10: cout << "Exiting program. Freeing memory...\n"; break;
            default: cout << "Invalid choice! Please select between 1 and 10.\n";
        }
    } while (choice != 10);

    // Free dynamically allocated memory before program termination
    freeMatrix(matrix, rows);

    return 0;
}