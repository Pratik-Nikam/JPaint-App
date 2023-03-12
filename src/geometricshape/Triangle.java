package geometricshape;


import java.awt.*;
import java.util.ArrayList;

import command.IMainStorage;
import model.ShapeType;

import model.interfaces.IShape;
import model.ColorMapSingleton;
import view.gui.PaintCanvas;


public class Triangle extends shape {
	private ShapeProperties properties;

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
		graphics2d.setColor(ColorMapSingleton.getInstance().getColor(properties.getColor()));
		graphics2d.fillPolygon(xCoord,yCoord,3);
	}

	@Override
	public ShapeType ShapeName() {
		return ShapeType.TRIANGLE;
	}

	@Override
	public ShapeProperties getProperties() {
		return properties;
	}

	@Override
	public void setProperties(ShapeProperties properties) {
		this.properties=properties;
		DrawOutlineForShapes.TraingleLogic(properties, xCoord, yCoord);

	}

	@Override
	public void unGrouping(IShape shape, IMainStorage shapedata, ArrayList<IShape> clipboard) {
	}

}

