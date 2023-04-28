package org.academiadecodigo.bootcamp.server;

import java.io.IOException;

public class ServerLauncher {

    private static final int DEFAULT_PORT = 8000;

    public static void main(String[] args) {

        try {
            Server server = new Server(args.length > 0 ? Integer.valueOf(args[0]) : DEFAULT_PORT);
            server.start();

        } catch (IOException e) {
            System.err.println("Error opening server socket: " + e.getMessage());

        } catch (NumberFormatException e) {
            System.err.println("Error port must be a valid number: " + args[0]);
        }
    }
}
