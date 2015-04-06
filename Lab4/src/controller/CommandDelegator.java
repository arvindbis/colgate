package controller;


import model.ImagePanel;
import model.Perspective;

import java.util.Observer;

public interface CommandDelegator extends Observer{
    void executeOperation(Perspective pane);
}
