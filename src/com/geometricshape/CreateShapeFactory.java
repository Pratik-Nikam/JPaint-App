package com.geometricshape;


import com.model.ShapeType;
import com.model.interfaces.IApplicationState;
import com.model.interfaces.IShape;

public class CreateShapeFactory implements IshapeFactory {

	public IShape CreateShape(shapeProperties properties,IApplicationState appState) {
		IShape shape=null;
		ShapeType shapeType=appState.getActiveShapeType();
		
		if(shapeType.equals(ShapeType.RECTANGLE)) {
			shape=new Rectangle(properties);
			System.out.println(" Rectangle Drawn ");
		}
		return shape;
	}
}
