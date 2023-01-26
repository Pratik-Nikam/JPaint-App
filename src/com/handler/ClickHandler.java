package com.handler;

import view.gui.PaintCanvas;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ClickHandler extends MouseAdapter {
    //    CoOrdinatesPoints startPoint;
//    CoOrdinatesPoints endPoint;
    PaintCanvas canvas;
    Point point = new Point();

    List<Integer> coordinates = new ArrayList<>();



    static Graphics2D graphics2d;

    public ClickHandler(PaintCanvas canvas)
    {
        this.canvas = canvas;
    }

    public void DrawShape(PaintCanvas canvas) {
        //graphics2d = canvas.getGraphics2D();
    }

    public void mousePressed(MouseEvent e) {
        point.setStartPointX1(e.getX());
        point.setStartPointY1(e.getY());

        coordinates.add(e.getX());
        coordinates.add(e.getY());

        System.out.print("presses   " + point.getStartPointX1() + "  " + point.getStartPointY1()) ;
    }

    public void mouseReleased(MouseEvent e) {
        point.setEndPointX2(e.getX());
        point.setEndPointY2(e.getY());
        coordinates.add(e.getX());
        coordinates.add(e.getY());
        int width = Math.abs(coordinates.get(0) - coordinates.get(2));
        int height = Math.abs(coordinates.get(1) - coordinates.get(3));

        System.out.print("  Height" + height + "\n");

        System.out.print("   width" + width + "\n");


//        PaintCanvas canvas = new PaintCanvas();
        System.out.println("***********"+canvas.getGraphics2d());

        //canvas.drawRectangleShape(startPoint.X, startPoint.Y, width,height);

//        PaintCanvas canvas = new PaintCanvas();
          canvas.getGraphics().drawRect(coordinates.get(0),coordinates.get(1),width,height);

        //new Graphics().drawRect();




        //graphics2d.drawRect(7, 8, 210, 410);


    }

    public void drawRectangles (Graphics g){
        Graphics2D g2d = (Graphics2D) g;
       // g2d.drawLine(startPoint.X, startPoint.Y);

    }

    /*public void DrawShape(PaintCanvas canvas) {
      Graphics graphics2d = canvas.getGraphics();
        graphics2d.drawRect();
    }*/



public class CoOrdinatesPoints {

    public int X;
    public int Y;

    public CoOrdinatesPoints()
    {}
//    public CoOrdinatesPoints(int X, int Y) {
//        this.X = X;
//        this.Y = Y;
//    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public String toString() {
        return (X + ", " + Y);
    }
}

}
