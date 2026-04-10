# Student Management System

A robust console-based Java application designed to manage student records efficiently. It allows users to add, remove, search, display, and edit student details with a complete file-based storage implementation. It is Task 5 of the internship.

## Features
- **Add a New Student:** Create a new student record by entering their name, roll number, grade, and email. Assures no duplicated roll numbers.
- **Remove a Student:** Delete a student record securely by searching their unique roll number.
- **Search a Student:** Look up students precisely by using their roll numbers.
- **Display All Students:** Quickly glance at all the available records in a neatly formatted table.
- **Edit Information:** Select and update any specific field on a student's profile such as their name, grade, or email.
- **Persistent Storage:** Ensures data isn't lost upon closing. All student info is safely stored in `students_data.dat` and reloads automatically upon launch.
- **Input Validation:** Required fields cannot be empty.

## Prerequisites
- **Java Development Kit (JDK):** Version 8 or higher.

## How to Run

1. Open your terminal or command prompt and navigate to the project directory:
   ```bash
   cd "C:\Users\Basudev\Desktop\CodeWithTaslim\CODSOFT\Task5_StudentManagementSystem"
   ```

2. Compile the Java files:
   ```bash
   javac *.java
   ```

3. Run the main class (**Note the capital 'M' in Main!**):
   ```bash
   java Main
   ```

## Project Structure
- `Student.java` — Core model to represent individual students containing attributes like `name`, `rollNumber`, `grade`, and `email`. Implements `Serializable`.
- `StudentManagementSystem.java` — Primary controller managing the collection, search algorithms, and file reading/writing logic.
- `Main.java` — Interactive console UI to receive inputs and handle logic flows securely.

## Note
Ensure the terminal has read/write permissions for the application folder to allow saving and modifying `students_data.dat`.
