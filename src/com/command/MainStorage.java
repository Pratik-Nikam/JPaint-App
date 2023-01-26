package com.command;


import com.model.interfaces.IShape;

import java.util.ArrayList;


public interface MainStorage {
	public void addshape(IShape shape);
	public void removeshape(IShape shape);
	public boolean contains(IShape shape);
	public void addlist(MainStorage list);
	public ArrayList<IShape> list();
	public void clear();
	public int size();
	public void redraw();

}
