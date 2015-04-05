package controller;

import model.Perspective;

import java.util.ArrayList;

/**
 * Singleton Undo operation
 */
public class UndoWorker implements CommandDelegator {
    private static UndoWorker ourInstance = new UndoWorker();

    public static UndoWorker getInstance() {
        return ourInstance;
    }

    private ArrayList<Perspective> events;

    private UndoWorker() {
        events = new ArrayList<Perspective>();
    }

    @Override
    public void executeOperation() {

    }

}
