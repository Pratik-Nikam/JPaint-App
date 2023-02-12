package com.geometricshape;

import com.model.ShapeColor;
import com.model.ShapeType;
import com.model.setColorMap;
import com.view.gui.PaintCanvas;

import java.awt.*;
import java.util.EnumMap;

public class Ellipse extends shape {
	private shapeProperties properties;
	private setColorMap map= new setColorMap();

	public Ellipse(shapeProperties properties) {
		super(properties);
		this.properties = properties;
	}

	@Override
	public void Draw(PaintCanvas canvas) {
		Graphics2D graphics2d = canvas.getGraphics2D();
		EnumMap<ShapeColor, Color> m=map.getMap();
		graphics2d.setColor(m.get(properties.getColor()));
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