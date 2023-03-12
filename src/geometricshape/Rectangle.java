package geometricshape;


import model.ShapeColor;
import model.ShapeType;
//import model.setColorMap;
import model.singleton;
import view.gui.PaintCanvas;

import java.awt.*;
import java.util.EnumMap;


public class Rectangle extends shape{

	private ShapeProperties properties;
//	private setColorMap map= new setColorMap();

	public Rectangle(ShapeProperties properties) {
		super(properties);
		this.properties = properties;
	}

	@Override
	public void Draw(PaintCanvas canvas) {
		Graphics2D graphics2d = canvas.getGraphics2D();
//		EnumMap<ShapeColor, Color> m=map.getMap();
//		graphics2d.setColor(m.get(properties.getColor()));
		graphics2d.setColor(singleton.getInstance().getColor(properties.getColor()));
		System.out.println("In rect draw method" + properties.getX() + "==" + properties.getY()+ "=="+ properties.getWidth() +"==" + properties.getHeight());
		graphics2d.fillRect(properties.getX(), properties.getY(), properties.getWidth(),properties.getHeight());
	}

	@Override
	public ShapeType ShapeName() {
		// TODO Auto-generated method stub
		return ShapeType.RECTANGLE;
	}

	@Override
	public ShapeProperties getProperties() {
		return properties;
	}
}
