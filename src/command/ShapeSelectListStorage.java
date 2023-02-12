package command;


import model.interfaces.IShape;
import view.gui.PaintCanvas;

import java.util.ArrayList;


public class ShapeSelectListStorage extends StorageList {

	public ShapeSelectListStorage(ArrayList<IShape> list, PaintCanvas canvas) {
		super(list, canvas);

	}
}
