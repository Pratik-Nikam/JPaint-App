package geometricshape;

import model.interfaces.IShape;
import view.gui.PaintCanvas;

public abstract class DrawOutline implements IShape {
	protected IShape outline;
	
	public DrawOutline(IShape outline) {
		super();
		this.outline = outline;
	}

	@Override
	public void Draw(PaintCanvas canvas) {
	}

	

}
