package com.command;

import java.io.IOException;

public class RedoCommand implements Icommand{

	@Override
	public void run() throws IOException {

		CommandHistory.redo();
		
	}

}
