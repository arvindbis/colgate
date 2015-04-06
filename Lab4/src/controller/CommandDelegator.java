package controller;


import model.ImagePanel;
import java.util.Observer;

public interface CommandDelegator extends Observer{
    void executeOperation(ImagePanel pane);
}
