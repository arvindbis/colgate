package model;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class ImagePanel extends JPanel implements Observer {
    private Image img;

    public ImagePanel( Image img){
        this.setImg(img);
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null)); setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(getImg(), 0, 0, null);
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
