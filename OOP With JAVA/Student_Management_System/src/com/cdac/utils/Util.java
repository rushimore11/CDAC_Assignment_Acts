
package com.cdac.utils;

import com.cdac.models.Result;
import com.cdac.custom_exceptions.InvalidInputException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Util {
    // Reusable validation method
    public static void validateInputs(String name, String subject, int marks) throws InvalidInputException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidInputException("Student name cannot be empty!");
        }
        if (subject == null || subject.trim().isEmpty()) {
            throw new InvalidInputException("Subject name cannot be empty!");
        }
        if (marks < 0 || marks > 100) {
            throw new InvalidInputException("Marks must be between 0 and 100 inclusive!");
        }
    }

    // Populate method for dummy/sample data testing
    public static List<Result> populate() {
        List<Result> dummyList = new ArrayList<>();
        dummyList.add(new Result("Amit Kumar", "Java", 85, LocalDate.of(2026, 3, 15)));
        dummyList.add(new Result("Neha Sharma", "Java", 72, LocalDate.of(2026, 3, 15)));
        dummyList.add(new Result("Rahul Verma", "Python", 45, LocalDate.of(2026, 3, 16)));
        dummyList.add(new Result("Pooja Patel", "Java", 35, LocalDate.of(2026, 3, 15)));
        dummyList.add(new Result("Vikram Singh", "Python", 92, LocalDate.of(2026, 3, 16)));
        return dummyList;
    }
}
