#include <iostream>
#include <string>
#include <stack>

using namespace std;

bool isPalindrome(const string& str) {
    stack<char> s;

    // Push all characters onto the stack
    for (char ch : str) {
        s.push(ch);
    }

    // Compare characters from the stack (reversed) with the original string
    for (char ch : str) {
        if (s.top() != ch) {
            return false; // Mismatch found
        }
        s.pop();
    }

    return true;
}

int main() {
    string input;
    cout << "Enter a string: ";
    cin >> input;

    if (isPalindrome(input)) {
        cout << "\"" << input << "\" is a palindrome." << endl;
    } else {
        cout << "\"" << input << "\" is not a palindrome." << endl;
    }

    return 0;
}
