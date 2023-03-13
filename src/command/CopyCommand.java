package command;


import java.io.IOException;

public class CopyCommand implements ICommand, IUndoable {

	IMainStorage shapeselectdata;
	IMainStorage copyshapedata;

	public CopyCommand(IMainStorage shapeselectdata, IMainStorage copyshapedata) {
		super();
		this.shapeselectdata=shapeselectdata;
		this.copyshapedata=copyshapedata;
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		copyshapedata.clear();
	}

	@Override
	public void redo() {
		try {
			run();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	@Override
	public void run() throws IOException {
		copyshapedata.addToList(shapeselectdata);
		System.out.println("List of Copied Shape and size" + copyshapedata.list()  +  copyshapedata.size());
	}

}
