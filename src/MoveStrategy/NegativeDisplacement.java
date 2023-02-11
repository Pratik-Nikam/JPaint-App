package MoveStrategy;

import com.geometricshape.shapeProperties;
import com.model.interfaces.IShape;

public class NegativeDisplacement implements IMoveStrategy {

	@Override
	public void displace(IShape shape, int dx, int dy) {
		shapeProperties properties=shape.getProperties();
		int x=properties.getX()-dx;
		int y=properties.getY()-dy;
		properties.setX(x);
		properties.setY(y);
		System.out.println("Negative displacement");
		shape.setProperties(properties);
	}
}
