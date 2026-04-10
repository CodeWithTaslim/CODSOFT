# 🏧 ATM Interface - Project Explanation

This Java console application implements the **ATM Interface** internship task. It satisfies all 7 required steps provided in your task instructions.

## 🚀 How to Run the ATM
1. Open your terminal or command prompt in the project folder: 
   ```bash
   cd "C:\Users\Basudev\Desktop\CodeWithTaslim\CODSOFT\Task3_ATMInterface"
   ```
2. Compile the code:
   ```bash
   javac ATMInterface.java
   ```
3. Run the compiled application:
   ```bash
   java ATMInterface
   ```

---

## ✅ Task Requirements Implemented

1. **Create a class to represent the ATM machine**:
   - `class ATM` acts as the ATM Machine itself. It sets up the UI, handles inputs, processes standard ATM menu options, and catches errors.

2. **Design the ATM User Interface**:
   - The UI runs inside the `atm.start()` while-loop, showing a graphical text menu and asking for numeric inputs (Options 1 to 4) to navigate withdrawing, depositing, or checking the balance. 

3. **Implement methods for each option**:
   - Methods like `.checkBalance()`, `.deposit()`, and `.withdraw()` are created inside the `ATM` class and securely linked to identical logic methods inside the `BankAccount` class.

4. **Create a class to represent the User's Bank Account**:
   - `class BankAccount` securely encapsulates the user's `balance` making sure that other classes cannot directly edit the value. Money can only be changed by properly invoking its safe `.deposit(amount)` or `.withdraw(amount)` methods.

5. **Connect the ATM class with the User's Bank Account class**:
   - A `BankAccount` object is passed directly into the `ATM` using inheritance by constructing `new ATM(userAccount)`. The machine can then directly transact on that account instance.

6. **Validate User Input**:
   - Standard text inputs vs decimal mismatches (`String` instead of `Double`) are protected by `scanner.hasNextDouble()` checkpoints preventing code crashes.
   - Core financial limits are verified inside `BankAccount` class (e.g., verifying `balance >= amount` and `amount > 0` before making a transaction).

7. **Display appropriate messages**:
   - The UI correctly displays "✅ Successfully withdrew", or errors out explicitly displaying things like "❌ Withdrawal failed. Insufficient funds in your account" based on the `true`/`false` boolean responses dynamically produced by the `BankAccount` validation checks.
