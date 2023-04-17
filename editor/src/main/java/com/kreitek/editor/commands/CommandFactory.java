package com.kreitek.editor.commands;

import com.kreitek.editor.*;
import com.kreitek.editor.memento.Caretaker;

import java.util.ArrayList;

public class CommandFactory {
    private final Caretaker caretaker;
    private final CommandParser commandParser = new CommandParser();

    public CommandFactory(Caretaker caretaker) {
        this.caretaker = caretaker;
    }



    public Command getCommand(String commandLine, ArrayList<String> documentLines) throws BadCommandException, ExitException {
        String[] args = commandParser.parse(commandLine);
        return switch (args[0]) {
            case "a" -> createAppendCommand(args[1]);
            case "u" -> createUpdateCommand(args[1], args[2]);
            case "d" -> createDeleteCommand(args[1]);
            case "undo" -> createUndoCommand(documentLines);
            default -> throw new ExitException();
        };
    }


    // TODO create undo command
    private Command createUndoCommand(ArrayList<String> documentLines) {
        return new UndoCommand(caretaker, documentLines);


    }

    private Command createDeleteCommand(String lineNumber) {
        int number = Integer.parseInt(lineNumber);
        return new DeleteCommand(number);
    }

    private Command createUpdateCommand(String lineNumber, String text) {
        int number = Integer.parseInt(lineNumber);
        return new UpdateCommand(text, number);
    }

    private Command createAppendCommand(String text) {
        return new AppendCommand(text);
    }

}
