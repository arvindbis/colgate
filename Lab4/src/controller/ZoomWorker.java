package controller;

public class ZoomWorker implements CommandDelegator {
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
