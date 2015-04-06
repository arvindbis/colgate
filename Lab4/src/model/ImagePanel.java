package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
        addMouseWheelListener(new MouseWheelListener() {
            /*private Point startPoint;

            @Override
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
                startPoint.x -= start.x;
                startPoint.y -= start.y;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                startPoint = null;
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                Point p = e.getPoint();
                int x = p.x - startPoint.x;
                int y = p.y - startPoint.x;
                start = new Point(x, y);
                repaint();
                System.out.println("drag");

            }*/
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                double delta = 0.05f * e.getPreciseWheelRotation();
                scale += delta;
                revalidate();
                repaint();
            }

        });
        addMouseMotionListener(new MouseMotionListener() {
            Point location;
            MouseEvent pressed;
            @Override
            public void mouseDragged(MouseEvent e) {
                /*System.out.println("drag");
                e.translatePoint(e.getComponent().getLocation().x, e.getComponent().getLocation().y);
                ((ImagePanel)e.getSource()).setLocation(e.getX(), e.getY());*/
                Component component = e.getComponent();
                location = component.getLocation(location);
                int x = location.x - pressed.getX() + e.getX();
                int y = location.y - pressed.getY() + e.getY();
                component.setLocation(x, y);
            }

            @Override
            public void mouseMoved(MouseEvent e) {

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
