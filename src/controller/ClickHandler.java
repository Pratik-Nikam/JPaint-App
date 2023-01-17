package controller;

import view.gui.PaintCanvas;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickHandler extends MouseAdapter {
    CoOrdinatesPoints startPoint;
    CoOrdinatesPoints endPoint;

    public void mousePressed(MouseEvent e) {
        startPoint = new CoOrdinatesPoints();
        startPoint.X = e.getX();
        startPoint.Y = e.getY();
        System.out.print("presses   " + startPoint.X + "  " + startPoint.Y) ;
    }

    public void mouseReleased(MouseEvent e) {
        endPoint = new CoOrdinatesPoints();

        endPoint.X = e.getX();
        endPoint.Y = e.getY();

        System.out.print("  released" + endPoint.X + "  " + endPoint.Y);

        System.out.print("   presses" + startPoint.X + "  " + startPoint.Y) ;

        int width = Math.abs(startPoint.X - endPoint.X);
        int height = Math.abs(startPoint.Y - endPoint.Y);

        System.out.print("  Height" + height);

        System.out.print("   width" + width );


//        PaintCanvas canvas = new PaintCanvas();
//        canvas.getGraphics().drawRect(startPoint.X,startPoint.Y,width,height);

        //new Graphics().drawRect();




        //graphics2d.drawRect(7, 8, 210, 410);


    }

    void drawRectangles (Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(startPoint.X, startPoint.Y, endPoint.X, endPoint.Y);

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
