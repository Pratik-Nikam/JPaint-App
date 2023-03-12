package handler;

import command.*;
import geometricshape.DrawOutlineForShapes;
import geometricshape.ShapeProperties;
import model.MouseMode;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.interfaces.IShape;
import view.gui.PaintCanvas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

// this class is used to capture the x and y points on the canvas on mouse click.
public class ClickHandler extends MouseAdapter {

    PaintCanvas canvas;
    Point point = new Point();
    IApplicationState appState;
    IMainStorage shapedata; // main storage to store shapes
    IMainStorage shapeselectdata; //main storage to store the selected shapes

    public ClickHandler(PaintCanvas canvas, IApplicationState appState, IMainStorage shapedata, IMainStorage shapeselectdata) {
        super();
        this.canvas = canvas;
        this.appState = appState;
        this.shapedata = shapedata;
        this.shapeselectdata = shapeselectdata;
    }

    // when we click on the canvas, we capture the starting coordinates here.
    public void mousePressed(MouseEvent e) {
        point.setStartPointX1(e.getX());
        point.setStartPointY1(e.getY());
        System.out.print("start point X1, Y1   " + point.getStartPointX1() + "  " + point.getStartPointY1() + " ");
    }

    // when the mouse click is released, we capture the release points here.
    // after we know the points we take action based on the mouse mode.
    public void mouseReleased(MouseEvent e) {
        point.setEndPointX2(e.getX());
        point.setEndPointY2(e.getY());

        System.out.print("presses ending  " + point.getEndPointX2() + "  " + point.getEndPointY2());
        System.out.println("--------------BEFORE CALCULATION -------");

        // condition to handle, when mouse mode is DRAW.
        if (appState.getActiveMouseMode().equals(MouseMode.DRAW)) {
            Point point = getPoints();

            ShapeShadingType shade = appState.getActiveShapeShadingType();
            ShapeColor shapeColor = appState.getActivePrimaryColor();
            ShapeType shapetype = appState.getActiveShapeType();
            ShapeProperties properties = new ShapeProperties(point, shade, shapeColor, shapetype);
            ICommand command = new CreateShapeCommand(shapedata, properties, appState);

            try {
                command.run();
            } catch (IOException ioexception) {
                ioexception.printStackTrace();
            }
        } else if ((appState.getActiveMouseMode().equals(MouseMode.SELECT))) { // executes when mouse mode is selected to be SELECT.
            shapedata.redraw();
            Point point = getPoints();

            ICommand command = new ShapSelect(shapedata, point, shapeselectdata);
            shapeselectdata.clear();
            try {
                command.run();
                for(IShape shape:shapeselectdata.list()) {
                    IShape outlinshape=new DrawOutlineForShapes(shape);
                    outlinshape.Draw(canvas);
                }
            } catch (IOException ioexception) {
                ioexception.printStackTrace();
            }

        } else if (appState.getActiveMouseMode().equals(MouseMode.MOVE)) { // this condition is executed when, mouse mode is MOVE.

            int dx = point.getEndPointX2() - point.getStartPointX1();
            int dy = point.getEndPointY2() - point.getStartPointY1();
            System.out.println("displacement" + dx + " ---" + dy);

            ICommand command = new MoveCommand(dx, dy, shapedata, shapeselectdata);
            try {
                command.run();
            } catch (IOException ioexception) {

                ioexception.printStackTrace();
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



