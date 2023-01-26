package com.model.interfaces;

import com.model.ShapeType;
import com.view.gui.PaintCanvas;

public interface IShape {

    public void Draw(PaintCanvas canvas);
    public ShapeType ShapeName();

}
