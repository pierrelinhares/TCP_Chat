package org.academiadecodigo.bootcamp.server.commands;

import org.academiadecodigo.bootcamp.server.Server;
import org.academiadecodigo.bootcamp.server.ClientConnection;

public class ListHandler implements CommandHandler {
    @Override
    public void handle(Server server, ClientConnection sender, String message) {
        sender.send(server.listClients());
    }
}
