
package com.cdac.models;

import com.cdac.enums.Grade;
import java.time.LocalDate;

public class Result {
    private static int idCounter = 1000; // Starting point for unique ID generation
    
    private final int studentId;
    private String studentName;
    private String subjectName;
    private int marksObtained;
    private Grade grade;
    private LocalDate examDate;

    public Result(String studentName, String subjectName, int marksObtained, LocalDate examDate) {
        this.studentId = ++idCounter;
        this.studentName = studentName;
        this.subjectName = subjectName;
        this.marksObtained = marksObtained;
        this.grade = Grade.calculateGrade(marksObtained);
        this.examDate = examDate;
    }

    // Getters and Setters
    public int getStudentId() { return studentId; }
    public String getStudentName() { return studentName; }
    public String getSubjectName() { return subjectName; }
    public int getMarksObtained() { return marksObtained; }
    public Grade getGrade() { return grade; }
    public LocalDate getExamDate() { return examDate; }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %-15s | Subject: %-10s | Marks: %3d | Grade: %-12s | Date: %s",
                studentId, studentName, subjectName, marksObtained, grade, examDate);
    }
}
