package com.example.demo.Factory;

public class LetterGradingStrategy implements GradingStrategy {
    @Override
    public double calculateGrade(Double score) {
        if (score == null) {
            return "N/A";
        }

        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
