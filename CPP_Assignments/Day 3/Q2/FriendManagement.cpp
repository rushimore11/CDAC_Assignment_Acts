
// Q2. Write a C++ program to store information of your friends
// id,name,hobbies,mobno,email,bdate,address
// note: hobbies- a friend may have multiple hobbies, a friend may have many mobile numbers
// Accept all friends details and store it in an array
// And do the following.
// 1. Display All Friend
// 2. Search by id
// 3. Search by name
// 4. Display all friend with a particular hobby    
// 5. Exit


#include <iostream>
#include <string>
using namespace std;

// Maximum limits for arrays
const int MAX_FRIENDS = 100;
const int MAX_HOBBIES = 10;
const int MAX_MOB_NOS = 5;

class Friend {
private:
    int id;
    string name;
    string hobbies[MAX_HOBBIES];
    int hobbyCount;
    string mobno[MAX_MOB_NOS];
    int mobCount;
    string email;
    string bdate;
    string address;

public:
    Friend() {
        id = 0;
        hobbyCount = 0;
        mobCount = 0;
    }

    // Function to accept friend details
    void acceptDetails() {
        cout << "\nEnter ID: ";
        cin >> id;
        cin.ignore(); // Clear newline character from buffer

        cout << "Enter Name: ";
        getline(cin, name);

        // Accept multiple hobbies
        cout << "How many hobbies does this friend have? (Max " << MAX_HOBBIES << "): ";
        cin >> hobbyCount;
        cin.ignore();
        if (hobbyCount > MAX_HOBBIES) hobbyCount = MAX_HOBBIES;
        for (int i = 0; i < hobbyCount; i++) {
            cout << "  Enter Hobby " << i + 1 << ": ";
            getline(cin, hobbies[i]);
        }

        // Accept multiple mobile numbers
        cout << "How many mobile numbers does this friend have? (Max " << MAX_MOB_NOS << "): ";
        cin >> mobCount;
        cin.ignore();
        if (mobCount > MAX_MOB_NOS) mobCount = MAX_MOB_NOS;
        for (int i = 0; i < mobCount; i++) {
            cout << "  Enter Mobile No " << i + 1 << ": ";
            getline(cin, mobno[i]);
        }

        cout << "Enter Email: ";
        getline(cin, email);

        cout << "Enter Birthdate (DD/MM/YYYY): ";
        getline(cin, bdate);

        cout << "Enter Address: ";
        getline(cin, address);
    }

    // Function to display friend details
    void displayDetails() const {
        
        cout << "\nID            : " << id;
        cout << "\nName          : " << name;
        
        cout << "\nHobbies       : ";
        for (int i = 0; i < hobbyCount; i++) {
            cout << hobbies[i] << (i < hobbyCount - 1 ? ", " : "");
        }
        
        cout << "\nMobile Nos    : ";
        for (int i = 0; i < mobCount; i++) {
            cout << mobno[i] << (i < mobCount - 1 ? ", " : "");
        }
        
        cout << "\nEmail         : " << email;
        cout << "\nBirthdate     : " << bdate;
        cout << "\nAddress       : " << address;
    }

    // Getters for searching
    int getId() const { return id; }
    string getName() const { return name; }
    
    // Check if the friend has a specific hobby
    bool hasHobby(const string& searchHobby) const {
        for (int i = 0; i < hobbyCount; i++) {
            if (hobbies[i] == searchHobby) {
                return true;
            }
        }
        return false;
    }
};

int main() {
    Friend friendsArray[MAX_FRIENDS];
    Friend* ptr = friendsArray; // Pointer pointing to the array of friends
    int friendCount = 0;
    int choice;

    cout << "How many friends do you want to add initially? (Max " << MAX_FRIENDS << "): ";
    cin >> friendCount;
    if (friendCount > MAX_FRIENDS) friendCount = MAX_FRIENDS;

    for (int i = 0; i < friendCount; i++) {
        cout << "\nEnter details for Friend " << i + 1 << ":";
        (ptr + i)->acceptDetails(); // Accessing array elements using pointer arithmetic
    }

    do {
        cout << "\nMENU";
        cout << "\n1. Display All Friends";
        cout << "\n2. Search by ID";
        cout << "\n3. Search by Name";
        cout << "\n4. Display Friends with a Particular Hobby";
        cout << "\n5. Exit";
        cout << "\nEnter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1: {
                if (friendCount == 0) {
                    cout << "\nNo friends stored yet!\n";
                } else {
                    cout << "\n--- Displaying All Friends ---";
                    for (int i = 0; i < friendCount; i++) {
                        (ptr + i)->displayDetails();
                    }
                }
                break;
            }
            case 2: {
                int searchId;
                bool found = false;
                cout << "\nEnter ID to search: ";
                cin >> searchId;

                for (int i = 0; i < friendCount; i++) {
                    if ((ptr + i)->getId() == searchId) {
                        cout << "\nFriend Found!";
                        (ptr + i)->displayDetails();
                        found = true;
                        break;
                    }
                }
                if (!found) cout << "\nFriend with ID " << searchId << " not found.\n";
                break;
            }
            case 3: {
                string searchName;
                bool found = false;
                cin.ignore();
                cout << "\nEnter Name to search: ";
                getline(cin, searchName);

                for (int i = 0; i < friendCount; i++) {
                    if ((ptr + i)->getName() == searchName) {
                        cout << "\nFriend Found!";
                        (ptr + i)->displayDetails();
                        found = true;
                    }
                }
                if (!found) cout << "\nFriend with Name \"" << searchName << "\" not found.\n";
                break;
            }
            case 4: {
                string searchHobby;
                bool found = false;
                cin.ignore();
                cout << "\nEnter Hobby to search: ";
                getline(cin, searchHobby);

                cout << "\n--- Friends who match the hobby \"" << searchHobby << "\" ---";
                for (int i = 0; i < friendCount; i++) {
                    if ((ptr + i)->hasHobby(searchHobby)) {
                        (ptr + i)->displayDetails();
                        found = true;
                    }
                }
                if (!found) cout << "\nNo friends found with this hobby.\n";
                break;
            }
            case 5:
                cout << "\nExiting Program. Goodbye!\n";
                break;
            default:
                cout << "\nInvalid choice! Please try again.\n";
        }
    } while (choice != 5);

    return 0;
}
