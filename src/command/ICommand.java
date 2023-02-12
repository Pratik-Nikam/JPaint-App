package command;

import java.io.IOException;

public interface ICommand {
	void run() throws IOException;
	void undo();
	void redo();
}
