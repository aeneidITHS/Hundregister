//Josef Lilja joli9146
import java.io.InputStream;
import java.util.*;

public class InputReader {
    private static final Set<InputStream> INPUT_STREAMS = Collections.synchronizedSet(new HashSet<>());
    private final Scanner scanner;
    private final InputStream inputStream;

    public InputReader(InputStream inputStream) {
        if (INPUT_STREAMS.contains(inputStream)) {
            throw new IllegalStateException("An instance already exists for this InputStream!");
        }
        this.inputStream = inputStream;
        INPUT_STREAMS.add(inputStream);
        this.scanner = new Scanner(inputStream);
        this.scanner.useLocale(Locale.getDefault());
    }

    public InputReader() {
        this(System.in);
    }

    public String readLine(String prompt) {
        System.out.print(prompt + " ?>");
        return scanner.nextLine();

    }

    public int readInt(String prompt) {
        System.out.print(prompt + " ?>");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // Rensa ogiltigt input.
        }
        int input = scanner.nextInt();
        scanner.nextLine(); //Rensa inmatningsbuffert
        return input;
    }

    public double readDouble(String prompt) {
        System.out.print(prompt + " ?>");
        while (!scanner.hasNextDouble()) {
            scanner.next(); // Rensa ogiltigt input
            System.out.print(prompt +" ?>");
        }
        double input = scanner.nextDouble();
        scanner.nextLine(); // jRensa inmatningsbuffert
        return input;
    }



    public void close() {
        synchronized (INPUT_STREAMS) {
            if (scanner != null) {
                scanner.close();
                INPUT_STREAMS.remove(this.inputStream);
            }
        }
    }



}
