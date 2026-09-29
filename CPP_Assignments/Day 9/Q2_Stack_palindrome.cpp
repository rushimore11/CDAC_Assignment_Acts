#include <iostream>
#include <string>
#include <stack>

using namespace std;

bool isBalanced(const string& expr) {
    stack<char> s;

    for (char ch : expr) {
        // Push opening brackets onto the stack
        if (ch == '(' || ch == '{' || ch == '[') {
            s.push(ch);
        } 
        // Handle closing brackets
        else if (ch == ')' || ch == '}' || ch == ']') {
            // Stack cannot be empty when encountering a closing bracket
            if (s.empty()) {
                return false;
            }

            char top = s.top();
            // Check if the current closing bracket matches the top opening bracket
            if ((ch == ')' && top == '(') ||
                (ch == '}' && top == '{') ||
                (ch == ']' && top == '[')) {
                s.pop();
            } else {
                return false; // Mismatched pair
            }
        }
    }

    // Balanced only if no unmatched opening brackets remain
    return s.empty();
}

int main() {
    string test1 = "{{[]()()[]}}";
    string test2 = "{{(()}}";

    cout << test1 << " -> " << (isBalanced(test1) ? "Balanced" : "Not Balanced") << endl;
    cout << test2 << " -> " << (isBalanced(test2) ? "Balanced" : "Not Balanced") << endl;

    return 0;
}