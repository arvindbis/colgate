package view;

import model.ImagePanel;
import model.Perspective;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.io.File;
import java.io.IOException;


    public class Luncher extends JFrame {
    private JFrame mainFrame;
        Perspective perspective1, perspective2;
    private JPanel imageHolder;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem save;
    private ImagePanel img;
    private JFileChooser opener,saver;

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
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        mainFrame.setJMenuBar(menuBar);
        menuBar.add(fileMenu);
            this.imageHolder = new JPanel();
            save = new JMenuItem("Open");
            fileMenu.add(save);
            save.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    openPerspectives(e);
                }
            });


        save = new JMenuItem("Save");
        fileMenu.add(save);
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePerspectives(evt);
            }
        });

        fileMenu.add(save);
        mainFrame.add(this.imageHolder);

    }

    private void savePerspectives(ActionEvent evt) {
        if(saver == null) {
            saver = new JFileChooser();
            saver.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        }
        int selection = saver.showOpenDialog(null);
        if(selection == JFileChooser.APPROVE_OPTION) {
            String path = saver.getSelectedFile().getAbsolutePath();
            perspective1.setSaveLocation(path);
            perspective2.setSaveLocation(path);
            perspective1.getSave().executeOperation(perspective1);
            perspective2.getSave().executeOperation(perspective2);
        }
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

           /* img.paintComponent(img.getImg().getGraphics());*/
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
                    int startX = (int) Math.min(img.getStart().getX(), e.getX());
                    int startY = (int) Math.min(img.getStart().getY(), e.getY());
                    int width = ((int) Math.max(img.getStart().getX(), e.getX()) - startX);
                    int height = ((int) Math.max(img.getStart().getY(), e.getY()) - startY);

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }

            });

            imageHolder.add(img);
            imageHolder.validate();
            imageHolder.repaint();
             perspective1 =   new Perspective("Perspective 1",new ImagePanel(ImageIO.read(new File(opener.getSelectedFile().getAbsolutePath()))));
            /*perspective1.setVisible(true);*/
                perspective2 =new Perspective("Perspective 2",new ImagePanel(ImageIO.read(new File(opener.getSelectedFile().getAbsolutePath()))));
            /*perspective2.setVisible(true);*/
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(imageHolder, "This is not a valid Image File Format", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

