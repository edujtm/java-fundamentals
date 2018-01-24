package exercises.lesson5;

import java.net.*;
import java.io.*;
import java.util.*;

public class ChatServer {
    public int port;
    private int IDs;
    private List<ClientThread> clients;
    private ServerSocket serverSocket = null;

    public ChatServer(int port) {
        this.port = port;
        IDs = 1;
        clients = new ArrayList<>();
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
        start() method responsible for listening to new socket connections and
        creating new threads for each client.
     */
    public void start() {
        Socket socket = null;
        ClientThread newClient = null;
        System.out.println("Waiting for clients to connect...");
        while (true) {
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                System.out.println("I/O error: " + e);
            }
            // new thread for a client
            System.out.println("User#" + IDs + " connected.");
            newClient = new ClientThread(socket, this, IDs++);
            newClient.start();
            clients.add(newClient);
            newClient = null;
        }
    }

    /*
        removeClient() method removes the client from the clients list
        and sends a message to all other users
        It's synchronized to avoid removing a client while another method may
        be sending a message to all users
    */
    public synchronized void removeClient(ClientThread clientClosed) {
        clients.remove(clientClosed);
        System.out.println("User#" + clientClosed.id + " disconnected.");
    }

    public List<ClientThread> getClients() {
        return clients;
    }

    public static void main(String args[]) {
        try {
            System.out.println("Server IP: " + InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("UnknownHostException: " + e);
        }
        int port = 8081;
        ChatServer chatServer = new ChatServer(port);
        chatServer.start();
    }
}