import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 7;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;

            System.out.println("I'm thinking of a number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                scanner.nextLine(); 

                if (userGuess < lowerBound || userGuess > upperBound) {
                    System.out.println("Please enter a valid guess between " + lowerBound + " and " + upperBound + ".");
                } else {
                    attempts++;

                    if (userGuess == targetNumber) {
                        System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                        score++;
                        break;
                    } else if (userGuess < targetNumber) {
                        System.out.println("Too low. Try again.");
                    } else {
                        System.out.println("Too high. Try again.");
                    }
                }
            }

            if (attempts >= maxAttempts) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("Thank you for playing! Your total score is " + score + " round(s) won.");
                break;
            }
        }

        scanner.close();
    }
}
