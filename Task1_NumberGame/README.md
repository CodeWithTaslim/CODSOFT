# 🎯 Number Game - Project Explanation

This Java console application implements the **Number Game** internship task. It covers all **Core Requirements** and all **Advanced Features** mentioned in your task description.

## 🚀 How to Run the Game
1. Open your terminal or command prompt in the project folder: 
   ```bash
   cd "C:\Users\Basudev\Desktop\CodeWithTaslim\CODSOFT\Task1_NumberGame"
   ```
2. Compile the code:
   ```bash
   javac NumberGame.java
   ```
3. Run the compiled application:
   ```bash
   java NumberGame
   ```

---

## ✅ Core Requirements Implemented

1. **Random Number Generation**: 
   - Used `java.util.Random` to generate a random integer between 1 and 100.
   - Code: `int targetNumber = random.nextInt(100) + 1;`
   
2. **User Guess Input**:
   - Used `java.util.Scanner` to read user input from the console.
   
3. **Comparison & Feedback**:
   - Compares user input with the `targetNumber`.
   - Returns clear outputs: `✅ Correct`, `🔼 Too High`, or `🔽 Too Low`.
   
4. **Repeat Until Correct (or out of attempts)**:
   - Contains a `while` loop that continues until the user either guesses correctly or runs out of their maximum attempts.

---

## ⭐ Advanced Features Implemented

1. **Limit Attempts (5 chances allowed)**:
   - Added `maxAttempts = 5`. The `while` loop condition checks `attempts < maxAttempts`, breaking the round and displaying a "Game Over" message if they fail to guess it in 5 tries.

2. **Multiple Rounds**:
   - Wrapped the entire game logic in an outer `while (playAgain)` loop. 
   - After a round ends (whether won or lost), it asks: "Do you want to play again? (yes/no)". It validates the input and loops or exits accordingly.

3. **Scoring System**:
   - Implemented the exact scoring formula specified: `Score = 100 - (attempts * 10)`.
   - The game tracks your **Round Score** as well as your **Total Score** across multiple rounds.

4. **Input Validation**:
   - **Text instead of number**: Before reading an integer, it checks `scanner.hasNextInt()`. If the user types a word (like "hello"), it catches the error, clears the input, and politely asks for a valid number without crashing or counting it as a failed attempt.
   - **Out of bounds**: If the user enters `150` or `-5`, it warns them to guess between 1 and 100, without consuming an attempt.
