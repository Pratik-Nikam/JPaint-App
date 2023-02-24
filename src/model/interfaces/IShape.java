package model.interfaces;

import geometricshape.ShapeProperties;
import model.ShapeType;
import view.gui.PaintCanvas;

public interface IShape {
    public void Draw(PaintCanvas canvas);
    public ShapeType ShapeName();
    public ShapeProperties getProperties();

    void setProperties(ShapeProperties properties);

    void positiveDisplacement(int dx, int dy);

    void negativeDisplacement(int dx, int dy);
}
