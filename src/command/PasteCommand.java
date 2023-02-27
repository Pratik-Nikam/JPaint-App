package command;


import model.interfaces.IApplicationState;
import model.interfaces.IShape;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PasteCommand implements ICommand, IUndoable {
	
	List<IShape> copylist;
	IApplicationState applicationState;
	IMainStorage shapedata;
	IMainStorage copyshapedata;

	public PasteCommand(IApplicationState applicationState, IMainStorage shapedata, IMainStorage copyshapedata) {
		super();
		copylist =new ArrayList<>();
		this.applicationState=applicationState;
		this.shapedata=shapedata;
		this.copyshapedata=copyshapedata;
	}

	@Override
	public void undo() {
		for(IShape shape : copylist) {
			if(shapedata.contains(shape)) {
				shapedata.removeShape(shape);
			}
		}
		shapedata.redraw();
	}

	@Override
	public void redo() {
		for(IShape shape: copylist) {
			shapedata.addShape(shape);
		}
		shapedata.redraw();
	}

	@Override
	public void run() throws IOException {
		System.out.println(copyshapedata.list() + "inside copy data execution");
		for(IShape shape:copyshapedata.list()) {
			IShape copy=shape.copy(shape);
			copylist.add(copy);
			shapedata.addShape(copy);
			}
		System.out.println(shapedata.list());
		CommandHistory.add(this);
	}
}

