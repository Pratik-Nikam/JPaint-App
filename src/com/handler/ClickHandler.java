package com.handler;

import com.command.*;
import com.geometricshape.shapeProperties;
import com.model.MouseMode;
import com.model.ShapeColor;
import com.model.ShapeShadingType;
import com.model.ShapeType;
import com.model.interfaces.IApplicationState;
import com.view.gui.PaintCanvas;

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
    IMainStorage shapedata;
    IMainStorage shapeselectdata;

    public ClickHandler(PaintCanvas canvas, IApplicationState appState, IMainStorage shapedata, IMainStorage shapeselectdata) {
        super();
        this.canvas = canvas;
        this.appState = appState;
        this.shapedata = shapedata;
        this.shapeselectdata = shapeselectdata;
    }

    public void mousePressed(MouseEvent e) {
//        System.out.println(e.getX() + " " +  e.getY() + "  points initial");

        point.setStartPointX1(e.getX());
        point.setStartPointY1(e.getY());
//        if(coordinates.size() == 0 )
//        {coordinates.add(e.getX());
//        coordinates.add(e.getY());}
//        else {
//            if(coordinates.get(0) != null && coordinates.get(1) != null)
//            {coordinates.set(0, e.getX());
//            coordinates.set(1,e.getY());}
//        }

        System.out.print("start point X1, Y1   " + point.getStartPointX1() + "  " + point.getStartPointY1() + " ");
    }

    public void mouseReleased(MouseEvent e) {
        point.setEndPointX2(e.getX());
        point.setEndPointY2(e.getY());

        System.out.print("presses ending  " + point.getEndPointX2() + "  " + point.getEndPointY2());
        System.out.println("--------------BEFORE CALCULATION -------");
        /*int startX = Math.min(point.getStartPointX1(), point.getEndPointX2());
        int endX = Math.max(point.getStartPointX1(), point.getEndPointX2());
        int startY = Math.min(point.getStartPointY1(), point.getEndPointY2());
        int endY = Math.max(point.getStartPointY1(), point.getEndPointY2());

        int width = endX - startX;
        int height = endY - startY;
        point.setStartPointX1(startX);
        point.setStartPointY1(startY);
        point.setEndPointX2(endX);
        point.setEndPointY2(endY);*/


//        if(coordinates.size() == 2){
//            coordinates.add(e.getX());
//            coordinates.add(e.getY());}
//        else {
//            if(coordinates.get(2) != null && coordinates.get(3) != null)
//            {coordinates.set(2, e.getX());
//            coordinates.set(3,e.getY());
//
//            }
//        }
//
//        if (coordinates.get(2) < coordinates.get(0)){
//            int t = coordinates.get(0);
//            coordinates.set(0, coordinates.get(2));
//            coordinates.set(2, t);
//            point.setStartPointX1(coordinates.get(2));
//            point.setEndPointX2(coordinates.get(0));
//        }
//
//        if (coordinates.get(3) < coordinates.get(1)){
//            int t = coordinates.get(1);
//            coordinates.set(1, coordinates.get(3));
//            coordinates.set(3,t);
//            point.setStartPointY1(coordinates.get(3));
//            point.setEndPointY2(coordinates.get(1));
//        }
//        System.out.println(coordinates + "========================");
//        int width = Math.abs(coordinates.get(0) - coordinates.get(2));

        if (appState.getActiveMouseMode().equals(MouseMode.DRAW)) {
            Point point = getPoints();

            ShapeShadingType shade = appState.getActiveShapeShadingType();
            ShapeColor shapeColor = appState.getActivePrimaryColor();
            ShapeType shapetype = appState.getActiveShapeType();
            shapeProperties properties = new shapeProperties(point, shade, shapeColor, shapetype);
            ICommand C = new CreateShapeCommand(shapedata, properties, appState);

            try {
                C.run();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if ((appState.getActiveMouseMode().equals(MouseMode.SELECT))) {

            Point point = getPoints();

            ICommand C = new ShapSelect(shapedata, point, shapeselectdata);

            try {
                C.run();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        } else if (appState.getActiveMouseMode().equals(MouseMode.MOVE)) {

            int dx = point.getEndPointX2() - point.getStartPointX1();
            int dy = point.getEndPointY2() - point.getStartPointY1();
            System.out.println("displacement" + dx + " ---" + dy);

            ICommand C1 = new MoveCommand(dx, dy, shapedata, shapeselectdata);
            try {
                C1.run();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }

    }


    public Point getPoints() {
        int startX = Math.min(point.getStartPointX1(), point.getEndPointX2());
        int endX = Math.max(point.getStartPointX1(), point.getEndPointX2());
        int startY = Math.min(point.getStartPointY1(), point.getEndPointY2());
        int endY = Math.max(point.getStartPointY1(), point.getEndPointY2());

        int width = endX - startX;
        int height = endY - startY;
        point.setStartPointX1(startX);
        point.setStartPointY1(startY);
        point.setEndPointX2(endX);
        point.setEndPointY2(endY);
        point.setWidth(width);
        point.setHeight(height);
        System.out.print("  Height" + height + "\n");

        System.out.print("   width" + width + "\n");
        System.out.println("--------------AFTER CALCULATION -------");
        System.out.print("start point   " + point.getStartPointX1() + "  " + point.getStartPointY1());
        System.out.print("end point   " + point.getEndPointX2() + "  " + point.getEndPointY2());
        return point;
    }


}



