//Josef Lilja joli9146
import java.util.Scanner;

public class DogRegister {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the dog register");

        while (running) {
            System.out.print("Command?>");
            String command = scanner.nextLine().trim();

            switch (command.toLowerCase()) {
                case "exit":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Error: Unknown command");
                    break;
            }
        }

        scanner.close();


    }
    }
