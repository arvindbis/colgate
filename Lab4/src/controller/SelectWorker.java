package controller;

/**
 * Responsible for selection of section and crop the selected image.
 */
public class SelectWorker implements CommandDelegator {
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
