 package com.command;


 import com.model.interfaces.IShape;
 import com.view.gui.PaintCanvas;

 import java.awt.*;
 import java.util.ArrayList;



public class StorageList implements MainStorage {
	protected ArrayList<IShape> list;
	protected PaintCanvas canvas;
	
	public StorageList(ArrayList<IShape> list, PaintCanvas canvas) {
		super();
		this.list = list;
		this.canvas = canvas;
	}

	

	@Override
	public void addshape(IShape shape) {
		// TODO Auto-generated method stub
		list.add(shape);

	}

	@Override
	public void removeshape(IShape shape) {
		// TODO Auto-generated method stub
		list.remove(shape);

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

	@Override
	public void addlist(MainStorage clonelist) {
		// TODO Auto-generated method stub
		ArrayList<IShape> a=clonelist.list();
		list.clear();
		for(IShape shape:a) {
			list.add(shape);
		}

	}

	@Override
	public ArrayList<IShape> list() {
		// TODO Auto-generated method stub
		ArrayList<IShape> copy=new ArrayList<IShape>();
		for(IShape a:list) {
			copy.add(a);
		}
		return copy;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		list.clear();
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public void redraw() {
		Graphics2D graphics2d = canvas.getGraphics2D();
		graphics2d.setColor(Color.WHITE);
        graphics2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        for(IShape s: list) {
			s.Draw(canvas);
		}
	}
}
