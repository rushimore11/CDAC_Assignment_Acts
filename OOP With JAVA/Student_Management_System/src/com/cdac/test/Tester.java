package com.cdac.test;

import com.cdac.custom_exceptions.InvalidInputException;
import com.cdac.enums.Grade;
import com.cdac.models.Result;
import com.cdac.utils.Util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.function.Predicate;

public class Tester {
    public static void main(String[] args) {
        // Initializing collection with helper dummy data population
        List<Result> resultList = Util.populate();
        
        try (Scanner sc = new Scanner(System.in)) {
            boolean exit = false;
            while (!exit) {
                System.out.println("\n--- Student Result Management System ---");
                System.out.println("1. Add a New Result Entry");
                System.out.println("2. Display Results for a Specific Grade");
                System.out.println("3. Calculate Average Marks by Subject");
                System.out.println("4. Find Top Scorer");
                System.out.println("5. Display All Sorted by Marks (Descending)");
                System.out.println("6. Display All Results");
                System.out.println("7. Exit");
                System.out.print("Choose an option: ");
                
                try {
                    int choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1: // Add student result
                            System.out.print("Enter Student Name: ");
                            String name = sc.nextLine();
                            System.out.print("Enter Subject Name: ");
                            String subject = sc.nextLine();
                            System.out.print("Enter Marks Obtained (0-100): ");
                            int marks = Integer.parseInt(sc.nextLine());
                            System.out.print("Enter Exam Date (YYYY-MM-DD) [Leave empty for today]: ");
                            String dateStr = sc.nextLine();
                            
                            LocalDate examDate = dateStr.trim().isEmpty() ? LocalDate.now() : LocalDate.parse(dateStr);
                            
                            // Validations
                            Util.validateInputs(name, subject, marks);
                            
                            Result newResult = new Result(name, subject, marks, examDate);
                            resultList.add(newResult);
                            System.out.println("Result Added Successfully! " + newResult);
                            break;

                        case 2: // Filter by Grade using Predicate and Stream
                            System.out.print("Enter Grade (DISTINCTION, FIRST_CLASS, SECOND_CLASS, PASS, FAIL): ");
                            String gradeInput = sc.nextLine().toUpperCase();
                            Grade filterGrade = Grade.valueOf(gradeInput);
                            
                            // Reusable Predicate encapsulated
                            Predicate<Result> byGrade = result -> result.getGrade() == filterGrade;
                            
                            System.out.println("\n--- Results for Grade: " + filterGrade + " ---");
                            long count = resultList.stream().filter(byGrade).peek(System.out::println).count();
                            if (count == 0) System.out.println("No matching records found.");
                            break;

                        case 3: // Average marks by Subject using Predicate
                            System.out.print("Enter Subject Name: ");
                            String subInput = sc.nextLine().trim();
                            
                            // Reusable Predicate encapsulated
                            Predicate<Result> bySubject = result -> result.getSubjectName().equalsIgnoreCase(subInput);
                            
                            OptionalDouble avg = resultList.stream()
                                    .filter(bySubject)
                                    .mapToInt(Result::getMarksObtained)
                                    .average();
                                    
                            if (avg.isPresent()) {
                                System.out.printf("Average Marks for %s: %.2f\n", subInput, avg.getAsDouble());
                            } else {
                                System.out.println("No records found for subject: " + subInput);
                            }
                            break;

                        case 4: // Find Top Scorer
                            Optional<Result> topScorer = resultList.stream()
                                    .max((r1, r2) -> Integer.compare(r1.getMarksObtained(), r2.getMarksObtained()));
                                    
                            if (topScorer.isPresent()) {
                                System.out.println("🎉 Top Scorer Details: " + topScorer.get());
                            } else {
                                System.out.println("No student records exist.");
                            }
                            break;

                        case 5: // Sort by Marks Descending using Comparator
                            System.out.println("\n--- Results Sorted by Marks (Descending) ---");
                            resultList.stream()
                                    .sorted((r1, r2) -> Integer.compare(r2.getMarksObtained(), r1.getMarksObtained()))
                                    .forEach(System.out::println);
                            break;
                            
                        case 6: // Display all
                            System.out.println("\n--- All Current Results ---");
                            resultList.forEach(System.out::println);
                            break;

                        case 7:
                            exit = true;
                            System.out.println("Exiting System... Thank you!");
                            break;

                        default:
                            System.out.println("Invalid Menu Option! Please select between 1-7.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input Error: Please enter numerical values where requested.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Input Error: Invalid Choice or Enum value provided.");
                } catch (DateTimeParseException e) {
                    System.out.println("Input Error: Invalid Date Format! Please use YYYY-MM-DD.");
                } catch (InvalidInputException e) {
                    System.out.println("Validation Failure: " + e.getMessage());
                }
            }
        }
    }
}
