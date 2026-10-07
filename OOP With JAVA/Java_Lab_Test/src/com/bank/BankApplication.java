package com.bank;

import com.bank.exception.InvalidAccountException;
import com.bank.exception.InsufficientFundsException;
import com.bank.model.*;

import java.util.*;
import java.util.stream.Collectors;

public class BankApplication {
    private static final List<Account> accounts = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Pre-populating sample accounts for initial testing
        accounts.add(new SavingsAccount("Anand", 5000));
        accounts.add(new CurrentAccount("Rambabu", 12000));
        accounts.add(new SavingsAccount("Kavitha", 7500));

        while (true) {
            System.out.println("\n========= Bank Account Management System =========");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Display All Accounts (Sorted by Balance Descending)");
            System.out.println("5. Display Account Summary by Type");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the input buffer

            try {
                switch (choice) {
                    case 1 -> createAccount();
                    case 2 -> depositAmount();
                    case 3 -> withdrawAmount();
                    case 4 -> displayAllAccounts();
                    case 5 -> displaySummaryByType();
                    case 6 -> {
                        System.out.println("Thank you for using our banking services!");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice! Please try again.");
                }
            } catch (Exception e) {
                System.err.println("Error: " + e.getLocalizedMessage());
            }
        }
    }

    private static void createAccount() throws InvalidAccountException {
        System.out.print("Account Holder Name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) throw new InvalidAccountException("Account holder name cannot be empty!");

        System.out.print("Account Type (1. SAVINGS, 2. CURRENT): ");
        int typeChoice = scanner.nextInt();
        System.out.print("Initial Deposit Amount: ");
        double initialDeposit = scanner.nextDouble();

        if (typeChoice == 1) {
            if (initialDeposit < SavingsAccount.MIN_BALANCE) {
                throw new InvalidAccountException("Savings account requires a minimum initial deposit of $" + SavingsAccount.MIN_BALANCE);
            }
            accounts.add(new SavingsAccount(name, initialDeposit));
            System.out.println("Savings Account created successfully!");
        } else if (typeChoice == 2) {
            if (initialDeposit < 0) {
                throw new InvalidAccountException("Initial deposit cannot be negative!");
            }
            accounts.add(new CurrentAccount(name, initialDeposit));
            System.out.println("Current Account created successfully!");
        } else {
            throw new InvalidAccountException("Invalid account type selection!");
        }
    }

    private static void depositAmount() {
        System.out.print("Enter Account Number (e.g., ACC1001): ");
        String accNum = scanner.nextLine().trim();
        Account account = findAccount(accNum);

        if (account != null) {
            System.out.print("Enter Deposit Amount: ");
            double amount = scanner.nextDouble();
            account.deposit(amount); // Polymorphic call resolved at runtime
        } else {
            System.out.println("Account number not found!");
        }
    }

    private static void withdrawAmount() throws InsufficientFundsException {
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine().trim();
        Account account = findAccount(accNum);

        if (account != null) {
            System.out.print("Enter Withdrawal Amount: $");
            double amount = scanner.nextDouble();
            account.withdraw(amount); // Polymorphic call resolved at runtime
        } else {
            System.out.println("Account number not found!");
        }
    }

    private static void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available!");
            return;
        }
        System.out.println("\n--- Accounts Sorted by Balance (Descending) ---");
        // Using Stream API and Comparator to sort and print accounts dynamically
        accounts.stream()
                .sorted(Comparator.comparingDouble(Account::getBalance).reversed())
                .forEach(System.out::println);
    }

    private static void displaySummaryByType() {
        System.out.println("\n--- Account Summary by Type (Stream API) ---");
        
        // Grouping accounts by their Enum type using Stream API collectors
        Map<AccountType, List<Account>> grouped = accounts.stream()
                .collect(Collectors.groupingBy(Account::getAccountType));

        for (AccountType type : AccountType.values()) {
            List<Account> typeList = grouped.getOrDefault(type, Collections.emptyList());
            long count = typeList.size();
            double totalBalance = typeList.stream().mapToDouble(Account::getBalance).sum();

            System.out.printf("Type: %-7s | Total Accounts: %d | Combined Balance: $%,.2f%n", 
                    type, count, totalBalance);
        }
    }

    private static Account findAccount(String accountNumber) {
        return accounts.stream()
                .filter(acc -> acc.getAccountNumber().equalsIgnoreCase(accountNumber))
                .findFirst()
                .orElse(null);
    }
}
