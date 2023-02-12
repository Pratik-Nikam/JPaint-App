package geometricshape;

import model.interfaces.IApplicationState;
import model.interfaces.IShape;

public interface IshapeFactory {
	IShape CreateShape(shapeProperties properties, IApplicationState applicationState);
}
