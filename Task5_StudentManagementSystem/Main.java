import java.util.List;
import java.util.Scanner;

public class Main {
    private static StudentManagementSystem sms = new StudentManagementSystem();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        System.out.println("==================================================");
        System.out.println("       Welcome to Student Management System       ");
        System.out.println("==================================================");

        while (!exit) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Add a new student");
            System.out.println("2. Remove a student");
            System.out.println("3. Search for a student");
            System.out.println("4. Display all students");
            System.out.println("5. Edit a student's information");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    removeStudent();
                    break;
                case "3":
                    searchStudent();
                    break;
                case "4":
                    displayAllStudents();
                    break;
                case "5":
                    editStudent();
                    break;
                case "6":
                    System.out.println("Exiting the application. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
        scanner.close();
    }

    private static void addStudent() {
        System.out.println("\n--- Add New Student ---");
        
        String name = getValidInput("Enter Student Name: ", false);
        String rollNumber = getValidInput("Enter Roll Number: ", false);
        
        if (sms.searchStudent(rollNumber) != null) {
            System.out.println("Error: A student with this roll number already exists!");
            return;
        }

        String grade = getValidInput("Enter Grade: ", false);
        String email = getValidInput("Enter Email Address: ", false);

        Student newStudent = new Student(name, rollNumber, grade, email);
        sms.addStudent(newStudent);
        System.out.println("Student added successfully!");
    }

    private static void removeStudent() {
        System.out.println("\n--- Remove Student ---");
        String rollNumber = getValidInput("Enter Roll Number of the student to remove: ", false);
        
        if (sms.removeStudent(rollNumber)) {
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void searchStudent() {
        System.out.println("\n--- Search Student ---");
        String rollNumber = getValidInput("Enter Roll Number to search: ", false);
        
        Student student = sms.searchStudent(rollNumber);
        if (student != null) {
            System.out.println("\nStudent Found:");
            System.out.println("--------------------------------------------------------------------------------------------------");
            System.out.println(student);
            System.out.println("--------------------------------------------------------------------------------------------------");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void displayAllStudents() {
        System.out.println("\n--- All Students ---");
        List<Student> students = sms.getAllStudents();
        
        if (students.isEmpty()) {
            System.out.println("No students found in the system.");
        } else {
            System.out.println("--------------------------------------------------------------------------------------------------");
            System.out.printf("%-15s | %-25s | %-5s | %s%n", "Roll No", "Name", "Grade", "Email");
            System.out.println("--------------------------------------------------------------------------------------------------");
            for (Student student : students) {
                System.out.printf("%-15s | %-25s | %-5s | %s%n", student.getRollNumber(), student.getName(), student.getGrade(), student.getEmail());
            }
            System.out.println("--------------------------------------------------------------------------------------------------");
        }
    }

    private static void editStudent() {
        System.out.println("\n--- Edit Student Information ---");
        String rollNumber = getValidInput("Enter Roll Number of the student to edit: ", false);
        
        Student student = sms.searchStudent(rollNumber);
        
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        
        System.out.println("Current details:");
        System.out.println(student);
        System.out.println("\nEnter new details (press Enter to keep current value):");
        
        System.out.print("New Name [" + student.getName() + "]: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) name = student.getName();
        
        System.out.print("New Grade [" + student.getGrade() + "]: ");
        String grade = scanner.nextLine().trim();
        if (grade.isEmpty()) grade = student.getGrade();
        
        System.out.print("New Email [" + student.getEmail() + "]: ");
        String email = scanner.nextLine().trim();
        if (email.isEmpty()) email = student.getEmail();
        
        if (sms.updateStudent(rollNumber, name, grade, email)) {
            System.out.println("Student information updated successfully!");
        } else {
            System.out.println("Failed to update student information.");
        }
    }

    private static String getValidInput(String prompt, boolean allowEmpty) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            
            if (!allowEmpty && input.isEmpty()) {
                System.out.println("Error: This field cannot be empty. Please try again.");
            } else {
                break;
            }
        }
        return input;
    }
}
