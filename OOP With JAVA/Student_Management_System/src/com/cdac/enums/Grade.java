package com.cdac.enums;

public enum Grade {
	DISTINCTION, FIRST_CLASS, SECOND_CLASS, PASS, FAIL;

    public static Grade calculateGrade(int marks) {
        if (marks >= 75) return DISTINCTION;
        if (marks >= 60) return FIRST_CLASS;
        if (marks >= 50) return SECOND_CLASS;
        if (marks >= 40) return PASS;
        return FAIL;
    }
}
