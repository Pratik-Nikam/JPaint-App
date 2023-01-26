package com.geometricshape;


import com.model.ShapeType;
import com.model.persistence.ApplicationState;
import com.view.gui.PaintCanvas;

import java.awt.*;



public class Rectangle extends shape{

	ApplicationState appState;
	private shapeProperties properties;


	public Rectangle(shapeProperties properties) {
		super(properties);
		this.properties = properties;
	}

	@Override
	public void Draw(PaintCanvas canvas) {
		Graphics2D graphics2d = canvas.getGraphics2D();
		graphics2d.setColor(Color.BLUE);
		graphics2d.fillRect(properties.getX(), properties.getY(), properties.getWidth(),properties.getHeight());
	}

	@Override
	public ShapeType ShapeName() {
		// TODO Auto-generated method stub
		return ShapeType.RECTANGLE;
	}
}
