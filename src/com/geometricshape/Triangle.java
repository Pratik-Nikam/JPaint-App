package com.geometricshape;


import java.awt.*;

import com.model.ShapeType;
import com.view.gui.PaintCanvas;

public class Triangle extends shape {
	private shapeProperties properties;
	private int[] xCoord=new int[3];
	private int[] yCoord=new int[3];
	
	public Triangle(shapeProperties properties) {
		super(properties);
		this.properties = properties;

//		startX1 - 715
//		StartY1 - 233
//		endX2 - 917
//		endY2 - 502

		int startX = properties.getX();
		int startY = properties.getY();
		int endX =properties.getX1();
		int endY = properties.getY1();
		System.out.println(startX + startY  + endX + endY + "Points ");

		int deltaX =  (startY - endY) / 2;
		int deltaY =  (endX - startX) / 2;

		xCoord[0] = endX;
		xCoord[1] = startX - deltaX;
		xCoord[2] = startX + deltaX;

		yCoord[0] = endY;
		yCoord[1] = startY - deltaY;
		yCoord[2] = startY + deltaY;
	}
	

	@Override
	public void Draw(PaintCanvas canvas) {
		Graphics2D graphics2d = canvas.getGraphics2D();
		graphics2d.setColor(Color.BLUE);
		graphics2d.fillPolygon(xCoord,yCoord,3);
	}

	@Override
	public ShapeType ShapeName() {
		// TODO Auto-generated method stub
		return ShapeType.TRIANGLE;
	}

	@Override
	public shapeProperties getProperties() {
		return properties;
	}


}

