package com.handler;

import com.command.CreateShapeCommand;
import com.command.Icommand;
import com.command.MainStorage;
import com.geometricshape.shapeProperties;
import com.model.ShapeColor;
import com.model.ShapeShadingType;
import com.model.ShapeType;
import com.model.interfaces.IApplicationState;
import com.view.gui.PaintCanvas;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClickHandler extends MouseAdapter {

    PaintCanvas canvas;
    Point point = new Point();
    IApplicationState appState;
    List<Integer> coordinates = new ArrayList<>();
    MainStorage shapedata;

    public ClickHandler(PaintCanvas canvas,IApplicationState appState, MainStorage shapedata)
    {
        super();
        this.canvas = canvas;
        this.appState = appState;
        this.shapedata = shapedata;
    }

    public void mousePressed(MouseEvent e) {
        point.setStartPointX1(e.getX());
        point.setStartPointY1(e.getY());
        if(coordinates.size() == 0 )
        {coordinates.add(e.getX());
        coordinates.add(e.getY());}
        else {
            if(coordinates.get(0) != null && coordinates.get(1) != null)
            {coordinates.set(0, e.getX());
            coordinates.set(1,e.getY());}
        }

        System.out.print("presses   " + point.getStartPointX1() + "  " + point.getStartPointY1()) ;
    }

    public void mouseReleased(MouseEvent e) {
        point.setEndPointX2(e.getX());
        point.setEndPointY2(e.getY());
        if(coordinates.size() == 2){
            coordinates.add(e.getX());
            coordinates.add(e.getY());}
        else {
            if(coordinates.get(2) != null && coordinates.get(3) != null)
            {coordinates.set(2, e.getX());
            coordinates.set(3,e.getY());

            }
        }

        if (coordinates.get(2) < coordinates.get(0)){
            int t = coordinates.get(0);
            coordinates.set(0, coordinates.get(2));
            coordinates.set(2, t);
            point.setStartPointX1(coordinates.get(2));
            point.setEndPointX2(coordinates.get(0));
        }

        if (coordinates.get(3) < coordinates.get(1)){
            int t = coordinates.get(1);
            coordinates.set(1, coordinates.get(3));
            coordinates.set(3,t);
            point.setStartPointY1(coordinates.get(3));
            point.setEndPointY2(coordinates.get(1));
        }
        System.out.println(coordinates + "========================");
        int width = Math.abs(coordinates.get(0) - coordinates.get(2));
        point.setWidth(width);
        int height = Math.abs(coordinates.get(1) - coordinates.get(3));
        point.setHeight(height);
        System.out.print("  Height" + height + "\n");

        System.out.print("   width" + width + "\n");
        ShapeShadingType shade=appState.getActiveShapeShadingType();
        ShapeColor shapeColor=appState.getActivePrimaryColor();
        ShapeType shapetype=appState.getActiveShapeType();
        shapeProperties properties=new shapeProperties(point,shade,shapeColor,shapetype);
        Icommand C= new CreateShapeCommand(shapedata, properties, appState);
        try {
            C.run();
        } catch (IOException e1) {
            e1.printStackTrace();
        }}
    }

