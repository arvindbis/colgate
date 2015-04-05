package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;


public class ImagePanel extends JPanel implements Observer {
    private BufferedImage img;
    private Point start;

    public ImagePanel( BufferedImage img){
        this.setImg(img);
        Dimension size = new Dimension(img.getWidth(), img.getHeight()); setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(new FlowLayout());
    }

    public void paintComponent(Graphics g) {
        g.drawImage(getImg(),0, 0, null);
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    @Override
    public void update(Observable o, Object arg) {

    }


    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }
}
