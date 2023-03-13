package command;


import model.interfaces.IShape;
import view.gui.PaintCanvas;

import java.awt.*;
import java.util.ArrayList;


// here is the class where we are storing the shape object in a list after we add or remove a shape on the UI.
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
			for(IShape ishape : list) {
				System.out.println(" Inside List Loop " );
				ishape.Draw(canvas);
			}
			System.out.println("LIST SIZE  : "+list.size());
		}
    }
	
	public void removeShape(IShape shape) {
		list.remove(shape);
		Graphics2D graphics2d = canvas.getGraphics2D();
		graphics2d.setColor(Color.WHITE);
        graphics2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

		for(IShape ishape: list) {
			ishape.Draw(canvas);
		}
		System.out.println(list.size());
	}

	@Override
	public boolean contains(IShape shape){
		for(IShape ishape : list) {
			if(shape.equals(ishape)) {
				return true;
			}
		}
		return false;
	}
}
