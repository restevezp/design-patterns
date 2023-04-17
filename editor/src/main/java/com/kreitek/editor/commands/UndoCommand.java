package com.kreitek.editor.commands;

import com.kreitek.editor.memento.Caretaker;
import com.kreitek.editor.Command;

import java.util.ArrayList;

public class UndoCommand implements Command {
    private final Caretaker caretaker;
    private ArrayList<String> documentLines;

    public UndoCommand(Caretaker caretaker, ArrayList<String> documentLines) {
        this.caretaker = caretaker;
        this.documentLines = documentLines;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
            documentLines.clear();
            documentLines.addAll(caretaker.undo());
        }



}
