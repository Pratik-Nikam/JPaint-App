package command;


import geometricshape.shapeGroup;
import model.interfaces.IShape;
import view.gui.PaintCanvas;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class GroupShapes implements IUndoable, ICommand {

	ArrayList<IShape> mainlistforshapes;
	IShape shapeGrouping;
	PaintCanvas canvas;
	IMainStorage shapedata;
	IMainStorage selectshapedata;

	public GroupShapes(IMainStorage shapedata, IMainStorage selectshapedata, PaintCanvas canvas) {
		super();
		mainlistforshapes =new ArrayList<IShape>();
		this.canvas=canvas;
		this.shapedata=shapedata;
		this.selectshapedata=selectshapedata;
	}

	@Override
	public void run() throws IOException {
		for(IShape shape:selectshapedata.list()) {
			mainlistforshapes.add(shape);
			shapedata.removeShape(shape);
		}
		shapeGrouping =new shapeGroup(mainlistforshapes);
		createShapeGroup(shapeGrouping,shapedata);
		shapedata.redraw();
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		unSet();
		shapedata.removeShape(shapeGrouping);
	}

	@Override
	public void redo() {
		for(IShape shape: mainlistforshapes) {
			shapedata.removeShape(shape);
		}
		createShapeGroup(shapeGrouping,shapedata);
		shapedata.redraw();
	}
	
	public void createShapeGroup(IShape shape, IMainStorage shaperepository) {
		Graphics2D graphics2d = canvas.getGraphics2D();
		graphics2d.setColor(Color.WHITE);
        graphics2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        shaperepository.addShape(shape);
		shape.Draw(canvas);
	}

	public void unSet() {
		for(IShape shape: mainlistforshapes) {
			shapedata.addShape(shape);
		}

	if(!mainlistforshapes.contains(shapeGrouping)) {
		mainlistforshapes.add(shapeGrouping);}
		shapedata.removeShape(shapeGrouping);
	}
}
