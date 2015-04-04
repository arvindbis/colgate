package controller;


public abstract class CommandDelegator {
    protected abstract void executeOperation();
    protected abstract boolean performUndo();
    protected abstract boolean performRedo();
    protected abstract boolean performCopy();
    protected abstract boolean performPaste();
}
