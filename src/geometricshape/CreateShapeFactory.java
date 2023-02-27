package geometricshape;


import model.ShapeType;
import model.interfaces.IApplicationState;
import model.interfaces.IShape;

public class CreateShapeFactory implements IShapeFactory {

	public IShape CreateShape(ShapeProperties properties, IApplicationState appState) {
		IShape shape = null;
		ShapeType shapeType=appState.getActiveShapeType();
		
		if(shapeType.equals(ShapeType.RECTANGLE)) {
			shape=new Rectangle(properties);
			System.out.println(" Rectangle Drawn ");
		}else if(shapeType.equals(ShapeType.TRIANGLE)) {
			shape=new Triangle(properties);
			System.out.println(" Triangle Drawn");
		}else if(shapeType.equals(ShapeType.ELLIPSE)) {
			shape=new Ellipse(properties);
			System.out.println(" Elipse Drawn");
		}

		return shape;
	}
	@Override
	public IShape CreateCopy(ShapeProperties properties, ShapeType shapeType) {
		IShape shape = null;

		if(shapeType.equals(ShapeType.RECTANGLE)) {
			shape=new Rectangle(properties);
		}else if(shapeType.equals(ShapeType.TRIANGLE)) {
			shape=new Triangle(properties);
		}else if(shapeType.equals(ShapeType.ELLIPSE)){
			shape=new  Ellipse(properties);
		}
		return shape;
	}
}
