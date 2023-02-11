package com.geometricshape;

import com.model.ShapeType;
import com.view.gui.PaintCanvas;

import java.awt.*;

public class Ellipse extends shape {
	private shapeProperties properties;

	public Ellipse(shapeProperties properties) {
		super(properties);
		this.properties = properties;
	}

	@Override
	public void Draw(PaintCanvas canvas) {
		Graphics2D graphics2d = canvas.getGraphics2D();
		graphics2d.setColor(Color.BLUE);
		graphics2d.fillOval(properties.getX(), properties.getY(), properties.getWidth(), properties.getHeight());

	}

	@Override
	public ShapeType ShapeName() {
		return ShapeType.ELLIPSE;
	}

	@Override
	public shapeProperties getProperties() {
		return properties;
	}

}