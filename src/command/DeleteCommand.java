package command;

import model.interfaces.IShape;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DeleteCommand implements ICommand, IUndoable {
	
	List<IShape> copylist;
	IMainStorage shapedata;
	IMainStorage shapeselectdata;

	public DeleteCommand(IMainStorage shapedata, IMainStorage shapeselectdata) {
		super();
		copylist =new ArrayList<>();
		this.shapedata=shapedata;
		this.shapeselectdata=shapeselectdata;
	}

	@Override
	public void undo() {
		for(IShape shape: copylist) {
			shape.addtolist(shape, shapedata);
		}
	}

	@Override
	public void redo() {
		for(IShape shape: copylist) {
			shape.delete(shape, shapedata);
		}
	}

	@Override
	public void run() throws IOException {
		for(IShape shape:shapeselectdata.list()) {
			copylist.add(shape);
			shape.delete(shape, shapedata);
		}
		CommandHistory.add(this);
	}
}
