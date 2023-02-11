package com.command;


import com.model.interfaces.IShape;
import com.view.gui.PaintCanvas;

import java.awt.*;
import java.util.ArrayList;



public class ShapeListStorage extends StorageList {

	public ShapeListStorage(ArrayList<IShape> list, PaintCanvas canvas) {
		super(list, canvas);
	}
	
	public void addShape(IShape shape) {
		if(!contains(shape)) {
			Graphics2D graphics2d = canvas.getGraphics2D();
			graphics2d.setColor(Color.WHITE);
	        graphics2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

	        list.add(shape);
			for(IShape s: list) {
				System.out.println("Inside List Loop " );
				s.Draw(canvas);
			}
			System.out.println("LIST SIZE  : "+list.size());
		}
    }
	
	public void removeShape(IShape shape) {
		list.remove(shape);
		Graphics2D graphics2d = canvas.getGraphics2D();
		graphics2d.setColor(Color.WHITE);
        graphics2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

		for(IShape s: list) {
			s.Draw(canvas);
		}
		System.out.println(list.size());
	}

	@Override
	public boolean contains(IShape shape){
		// TODO Auto-generated method stub
		for(IShape s:list) {
			if(shape.equals(s)) {
				return true;
			}
		}
		return false;
	}
}
