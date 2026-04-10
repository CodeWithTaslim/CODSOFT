import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int roundsPlayed = 0;
        
        System.out.println("🎯 Welcome to the NUMBER GAME! 🎯");
        System.out.println("I will generate a random number between 1 and 100.");
        System.out.println("You have 5 attempts to guess it correctly.");
        
        while (playAgain) {
            int targetNumber = random.nextInt(100) + 1;
            int maxAttempts = 5;
            int attempts = 0;
            boolean guessedCorrectly = false;
            roundsPlayed++;
            
            System.out.println("\n========================================");
            System.out.println("🎲 Round " + roundsPlayed + " has started! 🎲");
            System.out.println("========================================");
            
            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                
                // Input validation: Handle wrong input (like text instead of number)
                if (!scanner.hasNextInt()) {
                    System.out.println("❌ Invalid input! Please enter a valid number.");
                    scanner.next(); // Clear the invalid input from the scanner
                    continue; // Do not count this as an attempt
                }
                
                int guess = scanner.nextInt();
                
                // Optional: Check if the number is within the valid range
                if (guess < 1 || guess > 100) {
                    System.out.println("⚠️ Please guess a number between 1 and 100.");
                    continue; // Do not count this as an attempt
                }
                
                attempts++;
                
                // Compare guess with target
                if (guess == targetNumber) {
                    System.out.println("✅ Correct! You guessed the number!");
                    guessedCorrectly = true;
                } else if (guess > targetNumber) {
                    System.out.println("🔼 Too High");
                } else {
                    System.out.println("🔽 Too Low");
                }
                
                // Display remaining attempts if not guessed correctly
                if (!guessedCorrectly && attempts < maxAttempts) {
                    System.out.println("Attempts remaining: " + (maxAttempts - attempts));
                }
            }
            
            // Round Summary and Scoring
            if (guessedCorrectly) {
                // Score calculation: Example given was 100 - (attempts * 10)
                int roundScore = 100 - (attempts * 10);
                totalScore += roundScore;
                System.out.println("\n🎉 Congratulations! You won this round.");
                System.out.println("It took you " + attempts + " attempt(s).");
                System.out.println("Round Score: " + roundScore);
            } else {
                System.out.println("\n💀 Game Over! You've used all your " + maxAttempts + " attempts.");
                System.out.println("The correct number was: " + targetNumber);
            }
            
            System.out.println("Total Score so far: " + totalScore);
            
            // Multiple Rounds: Ask to play again
            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            
            // Validate play again input
            while (!response.equals("yes") && !response.equals("no") && !response.equals("y") && !response.equals("n")) {
                System.out.print("Invalid input. Please enter 'yes' or 'no': ");
                response = scanner.next().toLowerCase();
            }
            
            if (response.equals("no") || response.equals("n")) {
                playAgain = false;
                System.out.println("\n========================================");
                System.out.println("Thank you for playing the Number Game!");
                System.out.println("Rounds Played: " + roundsPlayed);
                System.out.println("Final Total Score: " + totalScore);
                System.out.println("Goodbye! 👋");
                System.out.println("========================================");
            }
        }
        
        scanner.close();
    }
}
