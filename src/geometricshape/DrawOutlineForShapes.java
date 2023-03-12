package geometricshape;

import command.IMainStorage;
import model.ShapeType;
import model.interfaces.IShape;
import view.gui.PaintCanvas;


import java.awt.*;
import java.util.ArrayList;

public class DrawOutlineForShapes extends DrawOutline {

	public DrawOutlineForShapes(IShape outline) {
		super(outline);
	}

	@Override
	public void Draw(PaintCanvas canvas) {
		
		ShapeProperties properties=getOutline();
		Graphics2D graphics2d = canvas.getGraphics2D();
		Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
		graphics2d.setStroke(dashed);
		
		if(outline.ShapeName().equals(ShapeType.RECTANGLE)) {
		    graphics2d.drawRect(properties.getX(), properties.getY(), properties.getWidth(), properties.getHeight());
		}else if(outline.ShapeName().equals(ShapeType.ELLIPSE)){
		graphics2d.drawOval(properties.getX(), properties.getY(), properties.getWidth(), properties.getHeight());
		}
		else if(outline.ShapeName().equals(ShapeType.TRIANGLE)){
			int xCoord[]=new int[3];
			int yCoord[]=new int[3];
			TraingleLogic(properties, xCoord, yCoord);
			graphics2d.drawPolygon(xCoord, yCoord, 3);
		}
	}

	static void TraingleLogic(ShapeProperties properties, int[] xCoord, int[] yCoord) {
		xCoord[0]=properties.getX();
		xCoord[1]=properties.getX()+properties.getWidth();
		xCoord[2]=properties.getX();
		yCoord[0]=properties.getY();
		yCoord[1]=properties.getY()+properties.getHeight();
		yCoord[2]=properties.getY()+properties.getHeight();
	}

	public ShapeProperties getOutline(){
		ShapeProperties coord=outline.getProperties();
		int x=coord.getX()-15;
		int y=coord.getY()-15;
		int width=coord.getWidth()+25;
		int height=coord.getHeight()+25;
		ShapeProperties properties=new ShapeProperties(x, y,width,height, null, null, coord.getType());
		return properties;
	}

	@Override
	public ShapeType ShapeName() {
		return null;
	}

	@Override
	public ShapeProperties getProperties() {
		return null;
	}

	@Override
	public void setProperties(ShapeProperties properties) {

	}

	@Override
	public void positiveDisplacement(int dx, int dy) {

	}

	@Override
	public void negativeDisplacement(int dx, int dy) {

	}

	@Override
	public IShape copy(IShape shape) {
		return null;
	}

	@Override
	public void addtolist(IShape shape, IMainStorage shapedata) {

	}

	@Override
	public void delete(IShape shape, IMainStorage shapedata) {

	}

	@Override
	public void unGrouping(IShape shape, IMainStorage shapedata, ArrayList<IShape> clipboard) {

	}
}

