package com.command;


import com.model.interfaces.IShape;
import com.view.gui.PaintCanvas;

import java.awt.*;
import java.util.ArrayList;


public class ShapeSelectListStorage extends StorageList {

	public ShapeSelectListStorage(ArrayList<IShape> list, PaintCanvas canvas) {
		super(list, canvas);

	}
}
