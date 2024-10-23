package com.example.demo.Factory;

public class PercentageGradingStrategy implements GradingStrategy {
    @Override
    public double calculateGrade(Double score) {
        if (score == null) {
            return 0.0;
        }

        return score;
    }
}
