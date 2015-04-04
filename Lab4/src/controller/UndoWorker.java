package controller;

/**
 * Singleton Undo operation
 */
public class UndoWorker {
    private static UndoWorker ourInstance = new UndoWorker();

    public static UndoWorker getInstance() {
        return ourInstance;
    }

    private UndoWorker() {
    }

}
