import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int totalMarks = 0;
        for (int subjectNumber = 1; subjectNumber <= numSubjects; subjectNumber++) {
            System.out.print("Enter marks obtained in subject " + subjectNumber + ": ");
            totalMarks += scanner.nextInt();
        }

        double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);

        String grade = calculateGrade(averagePercentage);

        displayResults(totalMarks, averagePercentage, grade);

        scanner.close();
    }

    private static double calculateAveragePercentage(int totalMarks, int numSubjects) {
        return (double) totalMarks / numSubjects;
    }

    private static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "O (Outstanding)";
        } else if (averagePercentage >= 80) {
            return "A (Excellent)";
        } else if (averagePercentage >= 70) {
            return "B (Good)";
        } else if (averagePercentage >= 60) {
            return "C (Satisfactory)";
        } else if (averagePercentage >= 50) {
            return "D (Pass)";
        } else {
            return "F (Fail)";
        }
    }

    private static void displayResults(int totalMarks, double averagePercentage, String grade) {
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);
    }
}
