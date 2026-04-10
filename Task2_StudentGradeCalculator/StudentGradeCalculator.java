import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("🎓 Welcome to the STUDENT GRADE CALCULATOR 🎓");
        
        // Input: Total number of subjects
        System.out.print("Enter the total number of subjects: ");
        int numSubjects = 0;
        
        // Handle invalid input for number of subjects
        while (true) {
            if (scanner.hasNextInt()) {
                numSubjects = scanner.nextInt();
                if (numSubjects > 0) {
                    break;
                } else {
                    System.out.print("Number of subjects must be greater than 0. Try again: ");
                }
            } else {
                System.out.print("Invalid input! Please enter a valid whole number: ");
                scanner.next(); // Clear invalid input
            }
        }
        
        // Input: Marks obtained in each subject
        int totalMarks = 0;
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks obtained in Subject " + i + " (out of 100): ");
            int marks = -1;
            
            // Validate marks (must be between 0 and 100)
            while (true) {
                if (scanner.hasNextInt()) {
                    marks = scanner.nextInt();
                    if (marks >= 0 && marks <= 100) {
                        break;
                    } else {
                        System.out.print("Marks must be between 0 and 100. Try again for Subject " + i + ": ");
                    }
                } else {
                    System.out.print("Invalid input! Please enter a valid number for Subject " + i + ": ");
                    scanner.next(); // Clear invalid input
                }
            }
            totalMarks += marks;
        }
        
        // Calculate Average Percentage
        double averagePercentage = (double) totalMarks / numSubjects;
        
        // Grade Calculation
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }
        
        // Display Results
        System.out.println("\n==========================================");
        System.out.println("📊 RESULT SUMMARY 📊");
        System.out.println("==========================================");
        System.out.println("Total Marks Obtained: " + totalMarks + " / " + (numSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Overall Grade: " + grade);
        System.out.println("==========================================");
        
        scanner.close();
    }
}
