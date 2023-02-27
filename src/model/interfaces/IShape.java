package model.interfaces;

import command.IMainStorage;
import geometricshape.ShapeProperties;
import model.ShapeType;
import view.gui.PaintCanvas;

public interface IShape {
    void Draw(PaintCanvas canvas);
    ShapeType ShapeName();
    ShapeProperties getProperties();

    void setProperties(ShapeProperties properties);

    void positiveDisplacement(int dx, int dy);

    void negativeDisplacement(int dx, int dy);
    IShape copy(IShape shape);
    void addtolist(IShape shape, IMainStorage shapedata);

    void delete(IShape shape, IMainStorage shapedata);
}
