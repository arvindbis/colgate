package controller;


import model.ImagePanel;

import java.io.Serializable;
import java.util.Observable;

public class SaveWorker implements CommandDelegator, Serializable {


    @Override
    public void executeOperation(ImagePanel pane) {
        System.out.println("saved");

    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
