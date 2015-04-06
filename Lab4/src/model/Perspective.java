package model;

import controller.CommandDelegator;
import controller.SaveWorker;

import javax.swing.*;
import java.util.Observable;

public class Perspective extends Observable {

    private CommandDelegator save;
    private ImagePanel img;
    private JFrame holder;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private float scale;

    public Perspective(String name,ImagePanel img){
        holder = new JFrame();
        holder.setTitle(name);
        save = new SaveWorker();
        this.img = img;
        holder.setSize(img.size);
        holder.setVisible(true);
        holder.add(img);
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        holder.setJMenuBar(menuBar);
        scale = img.getScale();

    }


}
