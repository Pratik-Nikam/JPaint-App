package command;


import geometricshape.shapeGroup;
import model.interfaces.IShape;
import view.gui.PaintCanvas;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class UngroupShapes implements ICommand, IUndoable {
	
	ArrayList<IShape> clipboard;
	PaintCanvas canvas;
	IMainStorage shapedata;
	IMainStorage selectshapedata;

	public UngroupShapes(IMainStorage shapedata,
						 IMainStorage selectshapedata, PaintCanvas canvas) {
		super();
		clipboard=new ArrayList<IShape>();
		this.shapedata = shapedata;
		this.selectshapedata = selectshapedata;
		this.canvas=canvas;
	}

	@Override
	public void undo() {
		for(IShape shape:clipboard) {
			shapeGroup s=(shapeGroup)shape;
			for(IShape a:s.getGroup()) {
				shapedata.removeShape(a);
			}
			addGroup(shape, shapedata);
		}
	}


	@Override
	public void redo() {
		for(IShape shapes:clipboard) {
			shapes.unGrouping(shapes,shapedata,clipboard);
		}
	}

	@Override
	public void run() throws IOException {
		for(IShape shapes:selectshapedata.list()) {
			shapes.unGrouping(shapes, shapedata,clipboard);
		}
		CommandHistory.add(this);
	}
	
	public void addGroup(IShape shape,IMainStorage shapedata) {
		Graphics2D graphics2d = canvas.getGraphics2D();
		graphics2d.setColor(Color.WHITE);
        graphics2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        shapedata.addShape(shape);
		shape.Draw(canvas);
		
	}
}
