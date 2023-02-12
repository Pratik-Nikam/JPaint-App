package MoveStrategy;


import geometricshape.shapeProperties;
import model.interfaces.IShape;

public class PositiveDisplacement implements IMoveStrategy {

	@Override
	public void displace(IShape shape, int dx, int dy) {
		// TODO Auto-generated method stub

		shapeProperties properties=shape.getProperties();

		// TODO Auto-generated method stub
		int x=properties.getX()+dx;
		int y=properties.getY()+dy;
		
		properties.setX(x);
		properties.setY(y);
		
		shape.setProperties(properties);
		System.out.println("Positive Displacemt ");
		
	}

	

}
