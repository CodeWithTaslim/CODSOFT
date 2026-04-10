# 🎓 Student Grade Calculator - Project Explanation

This Java console application implements the **Student Grade Calculator** internship task. It satisfies all the required steps provided in your task instructions.

## 🚀 How to Run the Calculator
1. Open your terminal or command prompt in the project folder: 
   ```bash
   cd "C:\Users\Basudev\Desktop\CodeWithTaslim\CODSOFT\Task2_StudentGradeCalculator"
   ```
2. Compile the code:
   ```bash
   javac StudentGradeCalculator.java
   ```
3. Run the compiled application:
   ```bash
   java StudentGradeCalculator
   ```

---

## ✅ Task Requirements Implemented

1. **Input (Take marks obtained out of 100 in each subject)**:
   - Uses `java.util.Scanner` to ask the user for the number of subjects first.
   - Uses a `for` loop to sequentially ask for the marks obtained in each specific subject.
   - Includes full input validation: ensure inputs are whole numbers and specifically between `0` and `100`.

2. **Calculate Total Marks**:
   - Variables are set up to sum all the collected marks inside the loop with `totalMarks += marks`.

3. **Calculate Average Percentage**:
   - Calculates the average with precision by casting the total into a double: `(double) totalMarks / numSubjects`.

4. **Grade Calculation**:
   - Uses an standard `if-else if` block to check the percentage thresholds:
     - 🎓 **A+** : 90% - 100%
     - 🌟 **A** : 80% - 89%
     - ✨ **B** : 70% - 79%
     - 👍 **C** : 60% - 69%
     - ⚠️ **D** : 50% - 59%
     - ❌ **F** : Below 50%

5. **Display Results**:
   - Prints a formatted, clean output displaying the `Total Marks`, the `Average Percentage` (rounded to 2 decimal places using `System.out.printf`), and the calculated `Overall Grade`.
