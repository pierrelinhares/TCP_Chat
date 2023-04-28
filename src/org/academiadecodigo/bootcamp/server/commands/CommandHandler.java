package org.academiadecodigo.bootcamp.server.commands;

import org.academiadecodigo.bootcamp.server.Server;
import org.academiadecodigo.bootcamp.server.ClientConnection;

public interface CommandHandler {
    void handle(Server server, ClientConnection sender, String message);
}
