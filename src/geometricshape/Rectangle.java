package geometricshape;


import command.IMainStorage;
import model.ShapeType;
import model.interfaces.IShape;
import model.ColorMapSingleton;
import view.gui.PaintCanvas;

import java.awt.*;
import java.util.ArrayList;


public class Rectangle extends shape{

	private ShapeProperties properties;

	public Rectangle(ShapeProperties properties) {
		super(properties);
		this.properties = properties;
	}

	@Override
	public void Draw(PaintCanvas canvas) {
		Graphics2D graphics2d = canvas.getGraphics2D();
		graphics2d.setColor(ColorMapSingleton.getInstance().getColor(properties.getColor()));
		System.out.println("In rect draw method" + properties.getX() + "==" + properties.getY()+ "=="+ properties.getWidth() +"==" + properties.getHeight());
		graphics2d.fillRect(properties.getX(), properties.getY(), properties.getWidth(),properties.getHeight());
	}

	@Override
	public ShapeType ShapeName() {
		return ShapeType.RECTANGLE;
	}

	@Override
	public ShapeProperties getProperties() {
		return properties;
	}

	@Override
	public void unGrouping(IShape shape, IMainStorage shapedata, ArrayList<IShape> clipboard) {

	}
}
