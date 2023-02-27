package geometricshape;


import MoveStrategy.NegativeDisplacement;
import command.IMainStorage;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IShape;
import MoveStrategy.IMoveStrategy;
import MoveStrategy.displacement;
import MoveStrategy.PositiveDisplacement;

public abstract class shape implements IShape{
	private ShapeProperties properties;

	public shape(ShapeProperties properties) {
		super();
		this.properties = properties;
	}

	@Override
	public void setProperties(ShapeProperties properties) {
		this.properties=properties;
	}

	@Override
	public void positiveDisplacement(int dx, int dy){
		displacement move=new displacement(dx,dy,this);
		IMoveStrategy moveStrategy=new PositiveDisplacement();
		move.displace(moveStrategy);
	}

	@Override
	public void negativeDisplacement(int dx, int dy) {
		displacement move=new displacement(dx,dy,this);
		IMoveStrategy moveStrategy=new NegativeDisplacement();
		move.displace(moveStrategy);
	}

	@Override
	public IShape copy(IShape shape) {
		ShapeProperties prop=shape.getProperties();
		int startX=prop.getX() - prop.getX() + 20; //Added 20 to display the outline for copied shaped if selected
		int startY=prop.getY()-prop.getY() + 20;
		int width=prop.getWidth();
		int height=prop.getHeight();
		ShapeShadingType shade=prop.getShade();
		ShapeType shapetype=prop.getType();
		ShapeColor shapecolor=prop.getColor();

		ShapeProperties prop2=new ShapeProperties(startX, startY, width, height, shade, shapecolor, shapetype);
		IShapeFactory factory=new CreateShapeFactory();
		IShape copy=factory.CreateCopy(prop2,shapetype);
		return copy;
	}

	@Override
	public void delete(IShape shape, IMainStorage shapedata) {
		shapedata.removeShape(shape);
	}

	@Override
	public void addtolist(IShape shape, IMainStorage shapedata) {
		shapedata.addShape(shape);
	}

}
