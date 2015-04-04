package controller;


public interface CommandDelegator {
    void executeOperation();
    boolean performUndo();
    boolean performRedo();
    boolean performCopy();
    boolean performPaste();

}
