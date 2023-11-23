import java.util.Scanner;

class rangen {
    public int generate(int max, int min) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}

public class Task1_NUMBERGAME {

    private static int generateRandomNumber(int max, int min) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalAttempts = 0;
        int wins = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I will choose a random number, and you have to guess it. Let's see how many attempts it takes!");

        while (true) {
            System.out.print("Enter the minimum number: ");
            int min = sc.nextInt();

            System.out.print("Enter the maximum number: ");
            int max = sc.nextInt();

            
            if (min >= max) {
                System.out.println("Oops! That's not a valid range. Please make sure the minimum is less than the maximum.");
                continue;
            }

            int attempts = playGame(max, min);

            totalAttempts += attempts;
            wins += (attempts > 0) ? 1 : 0;

            System.out.println("Attempts: " + attempts);
            System.out.println("Wins: " + wins);

            if (totalAttempts > 0) {
                double winRate = (double) wins / totalAttempts * 100;
                System.out.printf("Your win rate is %.2f%%\n", winRate);
            } else {
                System.out.println("Your win rate will be displayed once you've played at least one game.");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = sc.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                sc.close();
                System.out.println("Thanks for playing! See you next time.");
                System.exit(0);
            }
        }
    }

    private static int playGame(int max, int min) {
        Scanner sc = new Scanner(System.in);
        int targetNumber = generateRandomNumber(max, min);
        int attempts = 0;

        System.out.println("Let the game begin! I've picked a number between " + min + " and " + max + ". Can you guess it?");

        while (true) {
            System.out.print("Your guess: ");
            int guessedNumber;

            
            while (true) {
                if (sc.hasNextInt()) {
                    guessedNumber = sc.nextInt();
                    break;
                } else {
                    System.out.println("Oops! That's not a valid number. Try again.");
                    sc.next(); 
                    System.out.print("Your guess: ");
                }
            }

            attempts++;

            if (guessedNumber > targetNumber) {
                System.out.println("It's higher! Keep going.");
            } else if (guessedNumber < targetNumber) {
                System.out.println("It's lower! You're getting warmer.");
            } else {
                System.out.println("Congratulations! You got it right!");
                return attempts;
            }
        }
    }
}
