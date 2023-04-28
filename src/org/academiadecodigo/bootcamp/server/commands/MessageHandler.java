package org.academiadecodigo.bootcamp.server.commands;

import org.academiadecodigo.bootcamp.server.Server;
import org.academiadecodigo.bootcamp.server.ClientConnection;

public class MessageHandler implements CommandHandler{

    @Override
    public void handle(Server server, ClientConnection sender, String message) {

        if (!isValid(message)) {
            return;
        }

        server.broadcast(sender.getName() + ": " + message);
    }

    private boolean isValid(String message) {
        return !message.trim().isEmpty();
    }
}