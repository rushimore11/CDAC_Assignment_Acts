package com.cdac.test;

import com.cdac.custom_exceptions.InsufficientFundsException;
import com.cdac.custom_exceptions.InvalidAccountException;
import com.cdac.enums.AccountType;
import com.cdac.models.Account;
import com.cdac.models.CurrentAccount;
import com.cdac.models.SavingsAccount;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BankingTester {
    public static void main(String[] args) {
        List<Account> accountList = new ArrayList<>();
        
        // Seeding initial polymorphic entries
        accountList.add(new SavingsAccount("Rahul Roy", 5000.0, LocalDate.now()));
        accountList.add(new CurrentAccount("Biz Corp", 15000.0, LocalDate.now()));
        accountList.add(new SavingsAccount("Anjali Shah", 1200.0, LocalDate.now()));

        try (Scanner sc = new Scanner(System.in)) {
            boolean exit = false;
            while (!exit) {
                System.out.println("\n--- Banking Account Management System ---");
                System.out.println("1. Create Account");
                System.out.println("2. Deposit Amount");
                System.out.println("3. Withdraw Amount");
                System.out.println("4. Display All Accounts Sorted by Balance (Desc)");
                System.out.println("5. Display Account Summary by Type");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");

                try {
                    int choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1: // Create account with exception rules
                            System.out.print("Enter Account Holder Name: ");
                            String name = sc.nextLine().trim();
                            if (name.isEmpty()) throw new InvalidAccountException("Account holder name cannot be empty!");

                            System.out.print("Enter Account Type (SAVINGS / CURRENT): ");
                            AccountType type = AccountType.valueOf(sc.nextLine().toUpperCase().trim());

                            System.out.print("Enter Initial Deposit Balance: ");
                            double initialBalance = Double.parseDouble(sc.nextLine());

                            Account newAcc;
                            if (type == AccountType.SAVINGS) {
                                if (initialBalance < SavingsAccount.MIN_BALANCE) {
                                    throw new InvalidAccountException("Savings Account creation failed! Initial deposit minimum required: ₹" + SavingsAccount.MIN_BALANCE);
                                }
                                newAcc = new SavingsAccount(name, initialBalance, LocalDate.now());
                            } else {
                                newAcc = new CurrentAccount(name, initialBalance, LocalDate.now());
                            }
                            
                            accountList.add(newAcc);
                            System.out.println("Account Created Successfully! " + newAcc);
                            break;

                        case 2: // Polymorphic deposit
                            System.out.print("Enter Account Number: ");
                            int depAccNo = Integer.parseInt(sc.nextLine());
                            
                            Account depAcc = accountList.stream()
                                    .filter(acc -> acc.getAccountNumber() == depAccNo)
                                    .findFirst()
                                    .orElseThrow(() -> new InvalidAccountException("Account Number not found!"));

                            System.out.print("Enter Amount to Deposit: ");
                            double depAmt = Double.parseDouble(sc.nextLine());
                            if (depAmt <= 0) throw new InvalidAccountException("Deposit amount must be positive!");
                            
                            depAcc.deposit(depAmt); // Polymorphic call
                            break;

                        case 3: // Polymorphic withdraw
                            System.out.print("Enter Account Number: ");
                            int witAccNo = Integer.parseInt(sc.nextLine());

                            Account witAcc = accountList.stream()
                                    .filter(acc -> acc.getAccountNumber() == witAccNo)
                                    .findFirst()
                                    .orElseThrow(() -> new InvalidAccountException("Account Number not found!"));

                            System.out.print("Enter Amount to Withdraw: ");
                            double witAmt = Double.parseDouble(sc.nextLine());
                            if (witAmt <= 0) throw new InvalidAccountException("Withdrawal amount must be positive!");

                            witAcc.withdraw(witAmt); // Polymorphic call
                            break;

                        case 4: // Sort using Stream API + Comparator
                            System.out.println("\n--- All Accounts Sorted By Balance Descending ---");
                            accountList.stream()
                                    .sorted((a1, a2) -> Double.compare(a2.getBalance(), a1.getBalance()))
                                    .forEach(System.out::println);
                            break;

                        case 5: // Complex summary grouping using Stream API Collector mapping
                            System.out.println("\n--- Account Summary By Type ---");
                            Map<AccountType, List<Account>> grouped = accountList.stream()
                                    .collect(Collectors.groupingBy(Account::getAccountType));

                            for (AccountType t : AccountType.values()) {
                                List<Account> subList = grouped.getOrDefault(t, new ArrayList<>());
                                long count = subList.size();
                                double totalBal = subList.stream().mapToDouble(Account::getBalance).sum();
                                
                                System.out.printf("Type: %-8s | Total Accounts: %d | Combined Balance: ₹%.2f\n", 
                                        t, count, totalBal);
                            }
                            break;

                        case 6:
                            exit = true;
                            System.out.println("Thank you for banking with us!");
                            break;

                        default:
                            System.out.println("Invalid Menu Option! Please select between 1-6.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input Error: Please pass numerical values correctly.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Input Error: Invalid Account Type Enum input.");
                } catch (InvalidAccountException | InsufficientFundsException e) {
                    System.out.println("Business Rule Violation: " + e.getMessage());
                }
            }
        }
    }
}
