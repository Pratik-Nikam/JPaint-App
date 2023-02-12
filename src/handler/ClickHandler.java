package handler;

import command.*;
import geometricshape.shapeProperties;
import model.MouseMode;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IApplicationState;
import view.gui.PaintCanvas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClickHandler extends MouseAdapter {

    PaintCanvas canvas;
    Point point = new Point();
    IApplicationState appState;
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
        point.setStartPointX1(e.getX());
        point.setStartPointY1(e.getY());
        System.out.print("start point X1, Y1   " + point.getStartPointX1() + "  " + point.getStartPointY1() + " ");
    }

    public void mouseReleased(MouseEvent e) {
        point.setEndPointX2(e.getX());
        point.setEndPointY2(e.getY());

        System.out.print("presses ending  " + point.getEndPointX2() + "  " + point.getEndPointY2());
        System.out.println("--------------BEFORE CALCULATION -------");

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



