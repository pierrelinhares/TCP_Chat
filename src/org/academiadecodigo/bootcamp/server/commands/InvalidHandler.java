package org.academiadecodigo.bootcamp.server.commands;

import org.academiadecodigo.bootcamp.server.ClientConnection;
import org.academiadecodigo.bootcamp.server.Messages;
import org.academiadecodigo.bootcamp.server.Server;

public class InvalidHandler implements CommandHandler{

    @Override
    public void handle(Server server, ClientConnection sender, String message) {
        sender.send(Messages.ERROR + ": " + (message.startsWith(Messages.COMMAND_IDENTIFIER) ? Messages.INVALID_COMMAND : message));
    }
}
