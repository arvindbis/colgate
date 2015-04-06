package controller;

import model.ImagePanel;
import model.Perspective;

import javax.swing.undo.AbstractUndoableEdit;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Queue;
import java.util.Stack;

/**
 * Singleton Undo operation
 */

public class UndoWorker implements CommandDelegator {
    private static UndoWorker ourInstance = new UndoWorker();

    public static UndoWorker getInstance() {
        return ourInstance;
    }

    private Stack<Perspective> events;

    private UndoWorker() {
        events = new Stack<Perspective>();
    }

    @Override
    public void executeOperation(Perspective pane) {
         events.pop();
        System.out.println("did undo");
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
