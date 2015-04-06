package model;

import controller.CommandDelegator;
import controller.SaveWorker;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

public class Perspective extends Observable {

    private CommandDelegator save;
    private ImagePanel img;
    private JFrame holder;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private float scale;
    private String saveLocation;
    private int frameWidth = 600;
    private int frameHeight = 600;

    public Perspective(String name,ImagePanel img){
        holder = new JFrame();
        holder.setTitle(name);
        setSave(new SaveWorker());
        this.setImg(img);
        holder.setSize(img.size);
        holder.setVisible(true);
        holder.add(img);
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        holder.setJMenuBar(menuBar);
        setScale(img.getScale());
        holder.setResizable(false);
        holder.setBounds(10, 10, frameWidth, frameHeight);
        img.setBounds(0, 0, frameWidth, frameHeight);

        img.setSize(new Dimension(frameWidth, frameHeight));
        holder.setSize(new Dimension(frameWidth, frameHeight));


    }


    public CommandDelegator getSave() {
        return save;
    }

    public void setSave(CommandDelegator save) {
        this.save = save;
    }

    public ImagePanel getImg() {
        return img;
    }

    public void setImg(ImagePanel img) {
        this.img = img;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public String getSaveLocation() {
        return saveLocation;
    }

    public void setSaveLocation(String saveLocation) {
        this.saveLocation = saveLocation;
    }
}
