package com.geometricshape;


import MoveStrategy.NegativeDisplacement;
import com.model.interfaces.IShape;
import MoveStrategy.IMoveStrategy;
import MoveStrategy.displacement;
import MoveStrategy.PositiveDisplacement;

public abstract class shape implements IShape{
	private shapeProperties properties;

	public shape(shapeProperties properties) {
		super();
		this.properties = properties;
	}

	@Override
	public void setProperties(shapeProperties properties) {
		this.properties=properties;
	}

	@Override
	public void positiveDisplacement(int dx, int dy){
		displacement move=new displacement(dx,dy,this);
		IMoveStrategy moveStrategy=new PositiveDisplacement();
		move.displace(moveStrategy);
	}

	@Override
	public void negativeDisplacement(int dx, int dy) {
		displacement move=new displacement(dx,dy,this);
		IMoveStrategy moveStrategy=new NegativeDisplacement();
		move.displace(moveStrategy);

	}
}
