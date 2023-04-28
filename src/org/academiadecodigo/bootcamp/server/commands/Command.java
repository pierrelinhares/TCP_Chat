package org.academiadecodigo.bootcamp.server.commands;

import org.academiadecodigo.bootcamp.server.Messages;

public enum Command {
    INVALID("", new InvalidHandler()),
    MESSAGE("", new MessageHandler()),
    QUIT("", new QuitHandler()),
    NAME("name", new NameHandler()),
    LIST("list", new ListHandler()),
    WHISPER("whisper", new WhisperHandler());

    private String commandMessage;
    private CommandHandler handler;

    Command(String commandMessage, CommandHandler handler) {
        this.commandMessage = Messages.COMMAND_IDENTIFIER + commandMessage;
        this.handler = handler;
    }

    public static Command getFromString(String message) {

        if (message == null) {
            return QUIT;
        }

        if (!message.startsWith(Messages.COMMAND_IDENTIFIER)) {
            return MESSAGE;
        }

        String userCommand = message.split(" ")[0];

        for (Command command : values()) {
            if (userCommand.equals(command.commandMessage)) {
                return command;
            }
        }

        return INVALID;
    }

    public CommandHandler getHandler() {
        return handler;
    }
}