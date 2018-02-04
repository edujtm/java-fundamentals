package exercises.lesson5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Sender implements Runnable {

    private PrintWriter out;
    private BufferedReader stdIn;

    public Sender(BufferedReader input, PrintWriter serverOutput) {
        this.out = serverOutput;
        this.stdIn = input;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                while (!Receiver.response) {
                    Thread.sleep(1000);
                }
                out.println(stdIn.readLine());
                Receiver.response = false;
            }
        } catch (IOException e) {
            System.err.println("Error trying to read message from user: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Terminating sender thread.");
        }
    }
}
