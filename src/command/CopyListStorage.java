package command;


import model.interfaces.IShape;
import view.gui.PaintCanvas;

import java.util.ArrayList;

public class CopyListStorage extends StorageList {

	public CopyListStorage(ArrayList<IShape> list, PaintCanvas canvas) {
		super(list, canvas);
	}
}
