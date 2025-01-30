//Josef Lilja joli9146
import java.io.InputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputReader {
    private Scanner scanner;
    private static final Set<InputStream> usedStreams = Collections.synchronizedSet(new HashSet<>());

    public InputReader(InputStream inputStream) {
        if (usedStreams.contains(inputStream)) {
            throw new IllegalStateException("An instance already exists for this InputStream!");
        }
        usedStreams.add(inputStream);
        this.scanner = new Scanner(inputStream);
    }

    public InputReader() {
        this(System.in);
    }

    public int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // Clear invalid input
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        return input;
    }

    public double readDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid decimal number.");
            scanner.next(); // Clear invalid input
        }
        double input = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character
        return input;
    }

    public String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void close() {
        synchronized (usedStreams) {
            if (scanner != null) {
                scanner.close();
                usedStreams.remove(scanner.ioException());
            }
        }
    }



}
