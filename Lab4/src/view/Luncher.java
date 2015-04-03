package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * Created by QP-DEV on 4/3/2015.
 */
public class Luncher extends JFrame {

    private JPanel imageHolder,perspectiveHolder1,getPerspectiveHolder2;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem save;
    public Luncher(String name){
        initalizeView(name);
    }

    private void initalizeView(String name){
        new JFrame();
        this.setTitle(name);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);
        save = new JMenuItem("Open");
        save.addActionListener(new java.awt.event.ActionListener(){
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
        System.out.println("Save Button is pressed");
        JFileChooser openFile = new JFileChooser();
        openFile.showOpenDialog(null);
        System.out.println(openFile.getSelectedFile().getPath());
        File image = openFile.getSelectedFile();

    }
    private void openPerspectives(ActionEvent evt){
        System.out.println("Open Button is pressed");
    }

}
