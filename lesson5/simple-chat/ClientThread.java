package exercises.lesson5;


import java.net.*;
import java.io.*;
import java.util.List;
import java.util.Objects;

public class ClientThread extends Thread {
    private ChatServer server;
    protected Socket socket;
    public int id;
    public BufferedReader in;
    public PrintWriter out;

    public ClientThread(Socket clientSocket, ChatServer server, int id) {
        this.socket = clientSocket;
        this.server = server;
        this.id = id;
    }

    public void run() {
        InputStream inp;
        try {
            inp = socket.getInputStream();
            in = new BufferedReader(new InputStreamReader(inp));
            out = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            return;
        }
        out.println("Welcome user#" + id + ". Type #quit to quit chat.");
        out.flush();
        alertNewClient();

        String line;
        try {
            while ((line = in.readLine()) != null) {
                if (line.equals("#quit")) break;
                // Message appears on server terminal
                System.out.println("Message received from user#"+ id +": " + line);
                // Message is sent to all other users
                sendMessageToAll(line);
            }
            out.println("Bye user#" + id);
            out.flush();
            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        alertDisconnect();
        server.removeClient(this);
        server = null;
    }

    // TODO add private message method
    private synchronized void sendMessageToAll(String message) {
        server.getClients().stream().filter(Objects::nonNull).forEach(client -> {
            client.out.println("User#" + id + ": " + message);
            client.out.flush();
        });
    }

    private synchronized void alertNewClient() {
        server.getClients().stream().filter(client -> client != null && client != this).forEach(client -> {
            client.out.println("The user#" + id + " has connected.");
            client.out.flush();
        });
    }

    private synchronized void alertDisconnect() {
        server.getClients().stream().filter(client -> client != null && client != this).forEach(client -> {
                client.out.println("The user#" + id + " has disconnected.");
                client.out.flush();
        });
    }
}