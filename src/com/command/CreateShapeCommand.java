package com.command;


import com.geometricshape.CreateShapeFactory;
import com.geometricshape.IshapeFactory;
import com.geometricshape.shapeProperties;
import com.model.interfaces.IApplicationState;
import com.model.interfaces.IShape;
import com.view.gui.PaintCanvas;

import java.io.IOException;

//first
public class CreateShapeCommand implements Icommand,IUndoable{
	PaintCanvas canvas;
	IShape shape;
	IApplicationState appState;
	MainStorage shapedata;
	shapeProperties properties;

	public CreateShapeCommand(MainStorage shapedata, shapeProperties properties, IApplicationState appState) {
		super();
		this. shapedata =  shapedata;
		this.properties=properties;
		this.appState=appState;
	}

	public void run() throws IOException {
		IshapeFactory factory=new CreateShapeFactory();
		shape=factory.CreateShape(properties,appState);
		shapedata.addshape(shape);
		CommandHistory.add(this);
		System.out.println("Shape created");
	}
	@Override
	public void undo() {
		shapedata.removeshape(this.shape);
		System.out.println("undo Shape took place");
		}

	@Override
	public void redo() {
	shapedata.addshape(shape);
	System.out.println("Shape Redrawn on redo ");
	}
}
