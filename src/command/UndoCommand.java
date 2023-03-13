package command;

import java.io.IOException;

public class UndoCommand implements ICommand {
	//take shape list
	
	@Override
	public void run() throws IOException {
		CommandHistory.undoButton();
	}

	@Override
	public void undo() {

	}

	@Override
	public void redo() {

	}
}
