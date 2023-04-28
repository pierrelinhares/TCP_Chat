package org.academiadecodigo.bootcamp.server;

import org.academiadecodigo.bootcamp.server.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientConnection implements Runnable {

    private Socket socket;
    private Server server;
    private String name;
    private PrintWriter out;

    public ClientConnection(Socket socket, Server server, String name) {
        this.socket = socket;
        this.server = server;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = openStreams();

            send(Messages.WELCOME);

            if (!server.addClient(this)) {
                send(Messages.SERVER_FULL);
                close();
            }

            while (!socket.isClosed()) {
                listen(in);
            }

        } catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
        }
    }

    private void listen(BufferedReader in) throws IOException {
        String message = in.readLine();
        Command.getFromString(message).getHandler().handle(server, this, message);
    }

    private BufferedReader openStreams() throws IOException {
        out = new PrintWriter(socket.getOutputStream(), true);
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            System.err.println("Error closing client socket: " + e.getMessage());
        }
    }

    public void send(String message) {
        out.println(message);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
