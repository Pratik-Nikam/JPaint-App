package com.geometricshape;

import com.model.interfaces.IApplicationState;
import com.model.interfaces.IShape;

public interface IshapeFactory {
	IShape CreateShape(shapeProperties properties, IApplicationState applicationState);
}
