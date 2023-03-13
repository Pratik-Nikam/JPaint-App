package command;

import java.util.Stack;

public class CommandHistory {
	private static final Stack<IUndoable> stackForUndo = new Stack<IUndoable>();
	private static final Stack<IUndoable> redoStack = new Stack<IUndoable>();
	

	public static void add(IUndoable cmd) {
		stackForUndo.push(cmd);
		redoStack.clear();
	}
	
	public static boolean undoButton() {
		boolean isEmpty = !stackForUndo.empty();
		if (isEmpty) {
			IUndoable undo = stackForUndo.pop();
			redoStack.push(undo);
			undo.undo();
		}
		return isEmpty;
	}

	public static boolean redoButton() {
		boolean isEmpty = !redoStack.empty();
		if (isEmpty) {
			IUndoable redo = redoStack.pop();
			stackForUndo.push(redo);
			redo.redo();
		}
		return isEmpty;
	}
}
