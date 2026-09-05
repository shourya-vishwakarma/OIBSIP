import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;

            int attempts = 0;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("\n==============================");
            System.out.println("     NUMBER GUESSING GAME");
            System.out.println("==============================");
            System.out.println("I have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    scanner.next();
                    continue;
                }

                int guess = scanner.nextInt();
                attempts++;

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                if (guess == numberToGuess) {

                    guessedCorrectly = true;
                    int score = (maxAttempts - attempts + 1) * 10;
                    totalScore += score;

                    System.out.println("\n🎉 Congratulations!");
                    System.out.println("You guessed the correct number!");
                    System.out.println("Number: " + numberToGuess);
                    System.out.println("Attempts used: " + attempts);
                    System.out.println("Score for this round: " + score);

                    break;

                } else if (guess < numberToGuess) {

                    System.out.println("Too low! Try a higher number.");

                } else {

                    System.out.println("Too high! Try a lower number.");
                }

                System.out.println("Attempts remaining: "
                        + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {

                System.out.println("\n❌ You have used all your attempts.");
                System.out.println("The correct number was: " + numberToGuess);
                System.out.println("Score for this round: 0");
            }

            System.out.println("\nYour total score: " + totalScore);

            System.out.print("\nDo you want to play again? (yes/no): ");
            String answer = scanner.next();

            if (!answer.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\n==============================");
        System.out.println("       GAME OVER");
        System.out.println("==============================");
        System.out.println("Final Score: " + totalScore);
        System.out.println("Thank you for playing!");

        scanner.close();
    }
}