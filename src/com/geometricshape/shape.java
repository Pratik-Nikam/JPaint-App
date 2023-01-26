package com.geometricshape;


import com.model.interfaces.IShape;

public abstract class shape implements IShape{
	private shapeProperties properties;


	public shape(shapeProperties properties) {
		super();
		this.properties = properties;
	}
}
