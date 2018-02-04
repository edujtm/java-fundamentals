package exercises.lesson5;

import java.io.BufferedReader;
import java.io.IOException;

public class Receiver implements Runnable {

    private BufferedReader in;
    public static volatile boolean response = false;

    public Receiver(BufferedReader serverInput) {
        this.in = serverInput;
    }

    @Override
    public void run() {
        String responseLine;
        try {
            while ((responseLine = in.readLine()) != null) {
                System.out.println(responseLine);

                response = true;
                if (responseLine.contains("Bye")) {
                    response = false;
                    break;
                }
            }
        } catch (IOException e) {
                System.err.println("Error receiving message from server: " + e.getMessage());
        }
    }

}
