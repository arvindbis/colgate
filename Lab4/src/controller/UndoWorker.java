package controller;

/**
 * Singleton Undo operation
 */
public class UndoWorker implements CommandDelegator {
    private static UndoWorker ourInstance = new UndoWorker();

    public static UndoWorker getInstance() {
        return ourInstance;
    }

    private UndoWorker() {
    }

    @Override
    public void executeOperation() {

    }

    @Override
    public boolean performUndo() {
        return false;
    }

    @Override
    public boolean performRedo() {
        return false;
    }

    @Override
    public boolean performCopy() {
        return false;
    }

    @Override
    public boolean performPaste() {
        return false;
    }
}
