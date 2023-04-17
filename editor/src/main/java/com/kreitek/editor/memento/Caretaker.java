package com.kreitek.editor.memento;

import com.kreitek.editor.memento.Memento;

import java.util.ArrayList;
import java.util.Stack;

public class Caretaker {
    private Stack<Memento> mementos = new Stack<>();

    public void save(ArrayList<String> documentLines) {
        mementos.push(new Memento(new ArrayList<>(documentLines)));

    }

    public ArrayList<String> undo() {
        if (!mementos.isEmpty()) {
             mementos.pop();
             if (!mementos.isEmpty()) {
                 return mementos.peek().getState();
             }
        }
        return new ArrayList<>();
    }
}
