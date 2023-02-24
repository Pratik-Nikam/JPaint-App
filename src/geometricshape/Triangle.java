package geometricshape;


import java.awt.*;
import java.util.EnumMap;

import model.ShapeColor;
import model.ShapeType;
import model.setColorMap;
import view.gui.PaintCanvas;

public class Triangle extends shape {
	private ShapeProperties properties;
	private setColorMap map= new setColorMap();
	private int[] xCoord=new int[3];
	private int[] yCoord=new int[3];
	
	public Triangle(ShapeProperties properties) {
		super(properties);
		this.properties = properties;

		xCoord[0]=properties.getX();
		xCoord[1]=properties.getX()+properties.getWidth();
		xCoord[2]=properties.getX();
		yCoord[0]=properties.getY();
		yCoord[1]=properties.getY()+properties.getHeight();
		yCoord[2]=properties.getY()+properties.getHeight();
	}
	

	@Override
	public void Draw(PaintCanvas canvas) {
		Graphics2D graphics2d = canvas.getGraphics2D();
		EnumMap<ShapeColor, Color> m=map.getMap();
		graphics2d.setColor(m.get(properties.getColor()));
		graphics2d.fillPolygon(xCoord,yCoord,3);
	}

	@Override
	public ShapeType ShapeName() {
		// TODO Auto-generated method stub
		return ShapeType.TRIANGLE;
	}

	@Override
	public ShapeProperties getProperties() {
		return properties;
	}

	@Override
	public void setProperties(ShapeProperties properties) {
		// TODO Auto-generated method stub
		this.properties=properties;
		DrawOutlineForShapes.TraingleLogic(properties, xCoord, yCoord);

	}

}

