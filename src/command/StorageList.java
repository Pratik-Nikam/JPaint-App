 package command;


 import model.interfaces.IShape;
 import view.gui.PaintCanvas;

 import java.awt.*;
 import java.util.ArrayList;



public class StorageList implements IMainStorage {
	protected ArrayList<IShape> list;
	protected PaintCanvas canvas;
	
	public StorageList(ArrayList<IShape> list, PaintCanvas canvas) {
		super();
		this.list = list;
		this.canvas = canvas;
	}

	@Override
	public void addShape(IShape shape) {
		list.add(shape);

	}

	@Override
	public void removeShape(IShape shape) {
		list.remove(shape);

	}

	@Override
	public boolean contains(IShape shape){
		for(IShape s:list) {
			if(shape.equals(s)) {
				return true;
			}
		}
		return false;
	
	}

	@Override
	public void addToList(IMainStorage clonelist) {
		ArrayList<IShape> a=clonelist.list();
		list.clear();
		for(IShape shape:a) {
			list.add(shape);
		}

	}

	@Override
	public ArrayList<IShape> list() {
		ArrayList<IShape> copy=new ArrayList<IShape>();
		for(IShape a:list) {
			copy.add(a);
		}
		return copy;
	}

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public int size() {
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
