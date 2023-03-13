package geometricshape;

import command.IMainStorage;
import model.ShapeType;
import model.interfaces.IShape;
import model.ColorMapSingleton;
import view.gui.PaintCanvas;

import java.awt.*;
import java.util.ArrayList;

// this class is called when action related to Ellipse shape takes place on the UI
public class Ellipse extends shape {
	private ShapeProperties properties;

	public Ellipse(ShapeProperties properties) {
		super(properties);
		this.properties = properties;
	}

	@Override
	public void Draw(PaintCanvas canvas) {
		Graphics2D graphics2d = canvas.getGraphics2D();
		graphics2d.setColor(ColorMapSingleton.getInstance().getColor(properties.getColor()));
		graphics2d.fillOval(properties.getX(), properties.getY(), properties.getWidth(), properties.getHeight());

	}

	@Override
	public ShapeType ShapeName() {
		return ShapeType.ELLIPSE;
	}

	@Override
	public ShapeProperties getProperties() {
		return properties;
	}

	@Override
	public void unGrouping(IShape shape, IMainStorage shapedata, ArrayList<IShape> clipboard) {

	}

}