package view;

import model.ImagePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;


public class Luncher extends JFrame {
    private JFrame mainFrame;
    private JPanel perspectiveHolder1, getPerspectiveHolder2;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem save;
    private JLabel errorLabel;
    private ImagePanel img;

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
        fileMenu.add(save);
    }

    private void savePerspectives(ActionEvent evt) {

    }

    private void openPerspectives(ActionEvent evt) {
        JFileChooser openFile = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF Images", "jpg", "gif");
        openFile.setFileFilter(filter);
        openFile.showOpenDialog(null);

        if (openFile.getSelectedFile().getPath().endsWith(".jpg") || openFile.getSelectedFile().getPath().endsWith(".jpeg") || openFile.getSelectedFile().getPath().endsWith(".png")) {
            if(img != null) {
                mainFrame.getContentPane().remove(img);
                mainFrame.invalidate();
            }
            try {

                img = new ImagePanel(ImageIO.read(new File(openFile.getSelectedFile().getAbsolutePath())));
            } catch (IOException e) {
                e.printStackTrace();
            }
            img.paintComponent(img.getImg().getGraphics());
            mainFrame.add(img);
            mainFrame.validate();
            mainFrame.repaint();
        } else {
            if (errorLabel == null)
                errorLabel = new JLabel();
            errorLabel.setText("Selected File is not a Image.");
            mainFrame.add(errorLabel);
        }
    }
}

