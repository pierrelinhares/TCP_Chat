package org.academiadecodigo.bootcamp.server.commands;

import org.academiadecodigo.bootcamp.server.Messages;
import org.academiadecodigo.bootcamp.server.Server;
import org.academiadecodigo.bootcamp.server.ClientConnection;

public class QuitHandler implements CommandHandler{

    @Override
    public void handle(Server server, ClientConnection sender, String message) {
        server.remove(sender);
        server.broadcast(sender.getName() + " " + Messages.LEAVE);
        sender.close();
    }
}
