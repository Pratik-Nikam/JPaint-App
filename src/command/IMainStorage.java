package command;


import model.interfaces.IShape;

import java.util.ArrayList;


public interface IMainStorage {
	public void addShape(IShape shape);
	public void removeShape(IShape shape);
	public boolean contains(IShape shape);
	public void addToList(IMainStorage list);
	public ArrayList<IShape> list();
	public void clear();
	public int size();
	public void redraw();

}
