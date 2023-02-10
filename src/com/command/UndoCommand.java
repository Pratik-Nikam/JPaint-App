package com.command;

import java.io.IOException;

public class UndoCommand implements Icommand {
	//take shape list
	
	@Override
	public void run() throws IOException {
		CommandHistory.undo();
	}

	@Override
	public void undo() {

	}

	@Override
	public void redo() {

	}
}
