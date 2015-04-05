package view;

import controller.SelectWorker;
import model.ImagePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;


public class Luncher extends JFrame {
    private JFrame mainFrame;
    private JPanel perspectiveHolder, imageHolder;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem save;
    private ImagePanel img;
    private JFileChooser opener,saver;
    JSplitPane containerSeperator,subContainerSeperator;

    public Luncher(String name) {
        initalizeView(name);
    }

    private void initalizeView(String name) {
        mainFrame = new JFrame();
        mainFrame.setTitle(name);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setSize(800, 600);
        mainFrame.setLocationRelativeTo(null);
        perspectiveHolder = new JPanel();
        imageHolder = new JPanel();
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        mainFrame.setJMenuBar(menuBar);
        save = new JMenuItem("Open");
        save.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openPerspectives(e);
            }
        });
        fileMenu.add(save);
        save = new JMenuItem("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePerspectives(evt);
            }
        });
        containerSeperator = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        containerSeperator.setResizeWeight(0.6);
        containerSeperator.setEnabled(false);
        containerSeperator.setDividerSize(0);
        containerSeperator.add(imageHolder);
        containerSeperator.add(perspectiveHolder);
        fileMenu.add(save);
        mainFrame.add(containerSeperator);

    }

    private void savePerspectives(ActionEvent evt) {
        if(saver == null) {
            saver = new JFileChooser();
            saver.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        }
        saver.showOpenDialog(null);
    }

    private void openPerspectives(ActionEvent evt) {
        if(opener == null) {
            opener = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "JPG & GIF Images", "jpg", "gif");
            opener.setFileFilter(filter);
        }
        int selection = opener.showOpenDialog(null);
        if(selection == JFileChooser.APPROVE_OPTION)
        if (opener.getSelectedFile().getPath() != null && opener.getSelectedFile().getPath().endsWith(".jpg") || opener.getSelectedFile().getPath().endsWith(".jpeg") || opener.getSelectedFile().getPath().endsWith(".png")) {
            if(img != null) {
                imageHolder.remove(img);
                imageHolder.invalidate();
            }
            try {
                if(img == null)
                    img = new ImagePanel(ImageIO.read(new File(opener.getSelectedFile().getAbsolutePath())));
                else
                    img.setImg(ImageIO.read(new File(opener.getSelectedFile().getAbsolutePath())));
            } catch (IOException e) {
                e.printStackTrace();
            }
            img.paintComponent(img.getImg().getGraphics());
            img.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {
                    System.out.println("pressed");
                   img.setStart(e.getPoint());

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    int startX = (int) Math.min(img.getStart().getX(),e.getX());
                    int startY = (int) Math.min(img.getStart().getY(),e.getY());
                    int width =  ((int) Math.max(img.getStart().getX(),e.getX())- startX);
                    int height = ((int) Math.max(img.getStart().getY(),e.getY())- startY);
                    perspectiveHolder.add(new ImagePanel(img.getImg().getSubimage(startX,startY,width,height)));
                    perspectiveHolder.repaint();

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }

            });
           /* img.addMouseMotionListener(new MouseMotionListener() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    System.out.println("Dragged");
                }

                @Override
                public void mouseMoved(MouseEvent e) {
                    System.out.println("Moved");
                }
            });*/
            imageHolder.add(img);
            imageHolder.validate();
            imageHolder.repaint();
        } else {
            JOptionPane.showMessageDialog(imageHolder, "This is not a valid Image File Format", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

