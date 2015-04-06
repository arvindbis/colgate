package model;

import java.awt.*;

public class UndoData extends Perspective {

    boolean isDrag;
    Point oldOffset;
    Point newOffset;


    public UndoData(String name, ImagePanel img) {
        super(name, img);

    }
}
