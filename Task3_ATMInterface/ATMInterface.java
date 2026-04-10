import java.util.Scanner;

// 4. Create a class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    // 3. Implement methods for each option: deposit
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    // 3. Implement methods for each option: withdraw
    // 6. Validate user input to ensure it is within acceptable limits (sufficient balance)
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

// 1. Create a class to represent the ATM machine
class ATM {
    private BankAccount account;
    private Scanner scanner;

    // 5. Connect the ATM class with the user's bank account class
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean exit = false;
        System.out.println("🏧 Welcome to the ATM System! 🏧");

        // 2. Design the user interface for the ATM
        while (!exit) {
            System.out.println("\n=========== ATM Menu ===========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("================================");
            System.out.print("Please select an option (1-4): ");

            // Validate that the user enters a number
            if (!scanner.hasNextInt()) {
                System.out.println("❌ Invalid input! Please enter a number.");
                scanner.next(); // Clear invalid input
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("🙏 Thank you for using the ATM. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("❌ Invalid option. Please select a valid number between 1 and 4.");
            }
        }
    }

    // 3. Implement method: checkBalance()
    private void checkBalance() {
        // 7. Display appropriate messages
        System.out.printf("📄 Your current balance is: Rs. %.2f\n", account.getBalance());
    }

    // 3. Implement method: deposit()
    private void deposit() {
        System.out.print("Enter amount to deposit: Rs. ");
        
        // Input validation
        if (!scanner.hasNextDouble()) {
            System.out.println("❌ Invalid amount. Please try again.");
            scanner.next();
            return;
        }
        double amount = scanner.nextDouble();
        
        // 7. Display appropriate messages (Success / Failure based on BankAccount method return)
        if (account.deposit(amount)) {
            System.out.printf("✅ Successfully deposited Rs. %.2f. New balance: Rs. %.2f\n", amount, account.getBalance());
        } else {
            System.out.println("❌ Deposit failed. Please enter a valid positive amount.");
        }
    }

    // 3. Implement method: withdraw()
    private void withdraw() {
        System.out.print("Enter amount to withdraw: Rs. ");
        
        // Input validation
        if (!scanner.hasNextDouble()) {
            System.out.println("❌ Invalid amount. Please try again.");
            scanner.next();
            return;
        }
        double amount = scanner.nextDouble();
        
        // 7. Display appropriate messages (Success / Failure based on BankAccount method return)
        if (amount <= 0) {
            System.out.println("❌ Withdrawal failed. Please enter a valid positive amount.");
        } else if (account.withdraw(amount)) {
            System.out.printf("✅ Successfully withdrew Rs. %.2f. Remaining balance: Rs. %.2f\n", amount, account.getBalance());
        } else {
            System.out.println("❌ Withdrawal failed. Insufficient funds in your account.");
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        // Initialize an account with a starting balance of Rs. 1000
        BankAccount userAccount = new BankAccount(1000.00); 
        
        // Create an ATM instance, passing the connected userAccount
        ATM atm = new ATM(userAccount);
        
        // Start the machine interface loop
        atm.start();
    }
}
