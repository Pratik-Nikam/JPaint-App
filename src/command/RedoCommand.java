package command;

import java.io.IOException;

public class RedoCommand implements ICommand {

	@Override
	public void run() throws IOException {
		CommandHistory.redoButton();
	}
	@Override
	public void undo() {
	}

	@Override
	public void redo() {
	}
}
