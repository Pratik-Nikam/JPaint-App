package com.geometricshape;


import com.model.ShapeColor;
import com.model.ShapeType;
import com.model.interfaces.IApplicationState;
import com.model.persistence.ApplicationState;
import com.model.setColorMap;
import com.view.gui.PaintCanvas;

import java.awt.*;
import java.util.EnumMap;


public class Rectangle extends shape{

	private shapeProperties properties;
	private setColorMap map= new setColorMap();

	public Rectangle(shapeProperties properties) {
		super(properties);
		this.properties = properties;
	}

	@Override
	public void Draw(PaintCanvas canvas) {
		Graphics2D graphics2d = canvas.getGraphics2D();
		EnumMap<ShapeColor, Color> m=map.getMap();
		graphics2d.setColor(m.get(properties.getColor()));
		System.out.println("In rect draw method" + properties.getX() + "==" + properties.getY()+ "=="+ properties.getWidth() +"==" + properties.getHeight());
		graphics2d.fillRect(properties.getX(), properties.getY(), properties.getWidth(),properties.getHeight());
	}

	@Override
	public ShapeType ShapeName() {
		// TODO Auto-generated method stub
		return ShapeType.RECTANGLE;
	}

	@Override
	public shapeProperties getProperties() {
		return properties;
	}
}
