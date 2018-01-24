package exercises.lesson5;

import java.io.BufferedReader;
import java.io.IOException;

public class Receiver implements Runnable {

    private BufferedReader in;

    public Receiver(BufferedReader serverInput) {
        this.in = serverInput;
    }

    @Override
    public void run() {
        String responseLine;
        try {
            while ((responseLine = in.readLine()) != null) {
                System.out.println(responseLine);

                if (responseLine.contains("Bye")) break;
            }
        } catch (IOException e) {
                System.err.println("Erro ao receber mensagem do servidor: " + e.getMessage());
        }
    }
}
