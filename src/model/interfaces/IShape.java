package model.interfaces;

import geometricshape.shapeProperties;
import model.ShapeType;
import view.gui.PaintCanvas;

public interface IShape {
    public void Draw(PaintCanvas canvas);
    public ShapeType ShapeName();
    public shapeProperties getProperties();

    void setProperties(shapeProperties properties);

    void positiveDisplacement(int dx, int dy);

    void negativeDisplacement(int dx, int dy);
}
