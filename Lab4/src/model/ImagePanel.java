package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;


public class ImagePanel extends JPanel {
    private BufferedImage img;
    private Point start;
    public Dimension size;
    private float scale = 1;


    public ImagePanel( BufferedImage img){
        this.setImg(img);
        size = new Dimension(img.getWidth(), img.getHeight());
       setPreferredSize(size);
     setMinimumSize(size);
       setMaximumSize(size);
        setSize(size);
       setLayout(new FlowLayout());
        addMouseWheelListener(new MouseAdapter() {

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                System.out.println("ImagePanel");
                double delta = 0.05f * e.getPreciseWheelRotation();
                scale += delta;
                revalidate();
                repaint();
            }

        });

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            AffineTransform at = new AffineTransform();
            at.scale(scale, scale);
            g2d.drawImage(img, at, this);
            g2d.dispose();
        }
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension size = new Dimension(200, 200);
        if (img != null) {
            size.width = Math.round(img.getWidth() * getScale());
            size.height = Math.round(img.getHeight() * getScale());
        }
        return size;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

}
