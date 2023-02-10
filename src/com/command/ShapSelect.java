package com.command;

import com.geometricshape.shapeProperties;
import com.handler.Point;
import com.model.interfaces.IApplicationState;
import com.model.interfaces.IShape;
import com.view.gui.PaintCanvas;

import java.io.IOException;

public class ShapSelect implements Icommand {
    IShape shape;
    MainStorage shapedata;
    MainStorage shapeselectdata;
    Point point;

    public ShapSelect(MainStorage shapedata, Point point, MainStorage shapeselectdata) {
        super();

        this. shapedata =  shapedata;
        this.shapeselectdata = shapeselectdata;
        this.point = point;
    }
    public void run() throws IOException {
        shapeselectdata.clear();
        int start_pointX=point.getStartPointX1();
        int end_pointX=point.getStartPointX1() + point.getWidth();
        int start_pointY=point.getStartPointY1();
        int end_pointY=point.getEndPointY2()+point.getHeight();
        System.out.println("AX1 " + start_pointX + " AX2 " + end_pointX + "AY1" + start_pointY+ " AY2" +  end_pointY );
        for(IShape shape:shapedata.list()) {
            shapeProperties properties = shape.getProperties();
            System.out.println("=======STARDED SHAPE SELECTION ====");
            System.out.println("getX1 " + properties.getX1() + " " + properties.getWidth());
            System.out.println(" getX" + properties.getX() + " " + properties.getWidth());
            System.out.println(" getY1" + properties.getY1() + " " + properties.getHeight());
            System.out.println(" getY" + properties.getY() + " " + properties.getHeight());

            if(start_pointX<properties.getX()+ properties.getWidth()&&end_pointX>properties.getX()&&start_pointY<properties.getY()+properties.getHeight()&&end_pointY>properties.getY()) {
                if(!shapeselectdata.contains(shape)) {
                    shapeselectdata.addshape(shape);
                }
            }
        }


        System.out.println("Number of selected shapes  "+shapeselectdata.size());




    }



    @Override
    public void undo() {
        shapedata.removeshape(this.shape);
        System.out.println("undo Shape took place");

    }
    @Override
    public void redo() {

        shapedata.addshape(shape);
        System.out.println("Shape Redrawn on redo ");


    }



}

