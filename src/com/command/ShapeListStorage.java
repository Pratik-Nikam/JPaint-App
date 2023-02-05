package com.command;


import com.model.interfaces.IShape;
import com.view.gui.PaintCanvas;

import java.awt.*;
import java.util.ArrayList;



public class ShapeListStorage extends StorageList {
	
	
	public ShapeListStorage(ArrayList<IShape> list, PaintCanvas canvas) {
		super(list, canvas);
		// TODO Auto-generated constructor stub
	}
	
	public void addshape(IShape shape) {
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
	
	public void removeshape(IShape shape) {
		list.remove(shape);
		Graphics2D graphics2d = canvas.getGraphics2D();
		graphics2d.setColor(Color.WHITE);
        graphics2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		
		for(IShape s: list) {
			System.out.println("ssssssssssssss" + s);
			s.Draw(canvas);
		}
		System.out.println(list.size());
	}
	
}
