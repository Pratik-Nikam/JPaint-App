package geometricshape;

import model.ShapeColor;
import model.ShapeType;
//import model.setColorMap;
import model.singleton;
import view.gui.PaintCanvas;

import java.awt.*;
import java.util.EnumMap;

public class Ellipse extends shape {
	private ShapeProperties properties;
//	private setColorMap map= new setColorMap();

	public Ellipse(ShapeProperties properties) {
		super(properties);
		this.properties = properties;
	}

	@Override
	public void Draw(PaintCanvas canvas) {
		Graphics2D graphics2d = canvas.getGraphics2D();
//		EnumMap<ShapeColor, Color> m=map.getMap();
//		graphics2d.setColor(m.get(properties.getColor()));
		graphics2d.setColor(singleton.getInstance().getColor(properties.getColor()));
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

}