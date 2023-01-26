package com.command;

import java.io.IOException;

public class UndoCommand implements Icommand {
	//take shape list
	
	@Override
	public void run() throws IOException {
		CommandHistory.undo();
	}
}
