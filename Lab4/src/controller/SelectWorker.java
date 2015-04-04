package controller;

/**
 * Responsible for selection of section and crop the selected image.
 */
public class SelectWorker extends CommandDelegator {
    @Override
    protected void executeOperation() {

    }

    @Override
    protected boolean performUndo() {
        return false;
    }

    @Override
    protected boolean performRedo() {
        return false;
    }

    @Override
    protected boolean performCopy() {
        return false;
    }

    @Override
    protected boolean performPaste() {
        return false;
    }
}
