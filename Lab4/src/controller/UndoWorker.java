package controller;

import model.ImagePanel;
import model.Perspective;

import java.util.ArrayList;
import java.util.Observable;

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
    public void executeOperation(ImagePanel pane) {

    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
