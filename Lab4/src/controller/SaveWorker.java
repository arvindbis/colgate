package controller;


import model.ImagePanel;
import model.Perspective;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Observable;

public class SaveWorker implements CommandDelegator, Serializable {


    @Override
    public void executeOperation(Perspective pane) {
        if(pane != null){
            BufferedImage changedImage = pane.getImg().getImg();
            int width = pane.getImg().getWidth();
            int height = pane.getImg().getHeight();

                    BufferedImage newImage = changedImage.getSubimage(0, 0, width, height);

            File file = new File(pane.getSaveLocation()+"perspective_" + Calendar.getInstance().get(Calendar.HOUR_OF_DAY)+"_"+Calendar.getInstance().get(Calendar.MINUTE)+"_"+Calendar.getInstance().get(Calendar.SECOND) +"_"+Calendar.getInstance().get(Calendar.MILLISECOND) + ".jpg");

            try {
                ImageIO.write(newImage, "jpg", file);  // ignore returned boolean
            } catch(IOException e) {
                System.out.println("Write error for " + file.getPath() +
                        ": " + e.getMessage());
            }
            System.out.println(file.getAbsolutePath());
            System.out.println("pers is not null");
        }
        else{
            System.out.println("pers is null");
        }


    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
