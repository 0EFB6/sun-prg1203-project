import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;

        while (!isExit) {
            System.out.println();
            System.out.println("Welcome to Pokemon Ga-Ole!");
            System.out.println("1. Start Game");
            System.out.println("2. View Leaderboard");
            System.out.println("3. List all Pokemons");
            System.out.println("4. Exit");
            System.out.print("Enter your choice [1-4]: ");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        GameUtil.clearTerminal();
                        GameOperation.startGame(scanner);
                        break;
                    case 2:
                        GameUtil.clearTerminal();
                        GameUtil.viewLeaderboard();
                        break;
                    case 3:
                        GameUtil.clearTerminal();
                        GameUtil.listAllPokemons();
                        break;
                    case 4:
                        System.out.println("Thank you for playing Pokemon Ga-Ole!");
                        isExit = true;
                        break;
                    default:
                        System.out.println("Invalid number. Please enter 1, 2, 3, or 4.\n");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number ranging from 1 to 4.\n");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}