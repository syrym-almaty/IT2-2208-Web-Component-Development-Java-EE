package Factory;

public interface GradingStrategy {
    String calculateGrade(Double score);
}

class LetterGradingStrategy implements GradingStrategy {
    @Override
    public String calculateGrade(Double score) {
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

public class PercentageGradingStrategy implements GradingStrategy {
    @Override
    public String calculateGrade(Double score) {
        if (score == null) {
            return String.valueOf(0.0);
        }

        return String.valueOf(score);
    }
}

