package geometricshape;


import command.IMainStorage;
import model.ShapeType;
import model.interfaces.IShape;
import view.gui.PaintCanvas;


import java.util.ArrayList;
import java.util.UUID;

// defined below class to handle shapes that are to be part of a group.
public class shapeGroup implements IShape {
	ArrayList<IShape> group=new ArrayList<>();
	private  UUID uuid=UUID.randomUUID();
	private  String Id=uuid.toString();
	ShapeProperties properties;

	public shapeGroup(ArrayList<IShape> clipboard) {
		for(IShape shape:clipboard) {
			group.add(shape);
		}
		System.out.println(group.size());
		boundary();
	}

	@Override
	public void Draw(PaintCanvas canvas) {
		
		for(IShape shape:group) {
			shape.Draw(canvas);
		}

	}
	@Override
	public ShapeType ShapeName() {
		return ShapeType.RECTANGLE;
	}

	@Override
	public ShapeProperties getProperties() {
		return this.properties;
	}

	@Override
	public void setProperties(ShapeProperties properties) {
		this.properties=properties;

	}

	// this calculates the border for the shapes selected for grouping.
	public void boundary() {
		int outerline=group.size();
		int startX[]=new int[outerline];
		int endX[]=new int[outerline];
		int[] startY=new int[outerline];
		int[] endY=new int[outerline];
		
		int i=0;
		for(IShape shape:group) {
			startX[i]=shape.getProperties().getX();
			
			endX[i]=shape.getProperties().getX()+shape.getProperties().getWidth();
			
			startY[i]=shape.getProperties().getY();
			
			endY[i]=shape.getProperties().getY()+shape.getProperties().getHeight();
			
			i=i+1;
		}
		
		 int minx1 = getMinimumVal(startX);
		 int maxx2= getMaximumVal(endX);
		 int miny1 = getMinimumVal(startY);
		 int maxy2= getMaximumVal(endY);
		 
		 int array[]=new int[4];
		 array[0]=minx1;
		 array[1]=maxx2;
		 array[2]=miny1;
		 array[3]=maxy2;

		 ShapeProperties properties=new ShapeProperties(minx1,miny1,maxx2-minx1,maxy2-miny1);
		 setProperties(properties);
	}

	public int getMaximumVal(int[] numbers){
		  int maxValue = numbers[0];
		  for(int i=1;i < numbers.length;i++){
		    if(numbers[i] > maxValue){
		      maxValue = numbers[i];

		    }
		  }
		  return maxValue;
		}

		public int getMinimumVal(int[] numbers){
		  int minValue = numbers[0];
		  for(int i=1;i<numbers.length;i++){
		    if(numbers[i] < minValue){
		      minValue = numbers[i];
		    }
		  }
		  return minValue;
		}

		public void negativeDisplacement(int dx, int dy) {
			for(IShape shape:group) {
				shape.negativeDisplacement(dx, dy);
			}
			boundary();
			
		}

	@Override
	public IShape copy(IShape shape) {

		ArrayList<IShape> list=new ArrayList<IShape>();
		for(IShape iShape:group) {
			IShape copiedShape = iShape.copy(iShape);
			list.add(copiedShape);
		}
		return new shapeGroup(list);
	}

	public void positiveDisplacement(int dx, int dy) {
			for(IShape shape:group) {
				shape.positiveDisplacement(dx, dy);
			}
			boundary();
		}

		public shapeGroup IShape() {
			ArrayList<IShape> list=new ArrayList<IShape>();
			for(IShape iShape:group) {
				IShape shape=iShape.copy(iShape);
				list.add(shape);
			}
			return new shapeGroup(list);
		}

		@Override
		public void delete(IShape shape, IMainStorage shaperepository) {
			shaperepository.removeShape(shape);
			
		}

		@Override
		public void addtolist(IShape shape, IMainStorage shaperepository) {
			shaperepository.addShape(shape);
			
		}

	public ArrayList<IShape> getGroup() {
		return group;
	}
	@Override
	public void unGrouping(IShape shape, IMainStorage shapedata , ArrayList<IShape> clipboard) {
		group.forEach(shapedata::addShape);

		if(!clipboard.contains(shape)) {
			clipboard.add(shape);}
		shapedata.removeShape(shape);
	}
	

}
