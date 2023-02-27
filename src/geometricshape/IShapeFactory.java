package geometricshape;

import model.ShapeType;
import model.interfaces.IApplicationState;
import model.interfaces.IShape;

public interface IShapeFactory {
	IShape CreateShape(ShapeProperties properties, IApplicationState applicationState);
	IShape CreateCopy(ShapeProperties properties, ShapeType shapeType);
}
