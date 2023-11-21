import java.util.Random;
import java.util.Scanner;

public class NumbersGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.println("Hello, human. I am thinking of a number between 0 and 10.");
            System.out.println("*********************************************************");
            System.out.println("Can you guess the number? You have 3 attempts.");
            System.out.println("If you are not up to the task, you can always type 'q' to quit.");

            int answer = random.nextInt(11);
            int attempts = 0;

            while (attempts < 3) {
                System.out.print("Your guess: ");
                String input = scanner.nextLine();

                if (input.equals("q")) {
                    System.out.println("I knew you didn't have it in you.");
                    System.out.println("Shutting down...");
                    return;
                }

                try {
                    int guess = Integer.parseInt(input);

                    if (guess < 0 || guess > 10) {
                        System.out.println("Your guess must be between 0 and 10.");
                        continue;
                    }

                    if (guess == answer) {
                        System.out.println("Lucky guess! But can you do it again?");
                        break;
                    } else {
                        System.out.println("Swing and a miss! Keep trying...");
                        attempts++;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }

            if (attempts == 3) {
                System.out.println("Out of attempts! The number was " + answer + ".");
            }

            System.out.println("Do you want to play again? (yes/no)");
            if (!scanner.nextLine().equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Game over. Shutting down...");
        scanner.close();
    }
}
