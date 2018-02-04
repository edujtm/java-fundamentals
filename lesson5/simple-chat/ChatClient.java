package exercises.lesson5;

import java.io.*;
import java.net.*;

public class ChatClient {
    private String hostName;
    private int portNumber;
    private Socket clientSocket;

    public ChatClient(String hostName,int portNumber) {
        this.hostName = hostName;
        this.portNumber = portNumber;
        try {
            clientSocket = new Socket(hostName,portNumber);
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch(IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName + ":" + portNumber + ". Check that the server is running.");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void start() {
        PrintWriter out = null;
        BufferedReader in = null;
        BufferedReader stdIn = null;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            stdIn = new BufferedReader(new InputStreamReader(System.in));

        } catch(IOException e) {
            System.err.println("I/O Exception");
            e.printStackTrace();
            System.exit(1);
        }

        try {
            Thread listener = new Thread(new Receiver(in));
            Thread sender = new Thread(new Sender(stdIn, out));
            listener.start();
            sender.start();

            try {
                listener.join();
            } catch (InterruptedException e) {
                System.err.println("Error: Main thread interrupted: " + e.getMessage());
            }
            sender.interrupt();

            out.close();
            in.close();
            clientSocket.close();
        } catch (IOException e) {
            System.err.println("Error trying to send text to server" + e.getMessage());
        }
    }

    public static void main(String args[]) {
        String hostName = "127.0.1.1";
        int port = 8081;
        ChatClient chatClient = new ChatClient(hostName,port);
        chatClient.start();
    }

}
