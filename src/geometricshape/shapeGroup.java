package geometricshape;


import command.IMainStorage;
import model.ShapeType;
import model.interfaces.IShape;
import view.gui.PaintCanvas;


import java.util.ArrayList;
import java.util.UUID;

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

	public void boundary() {
		int boundary[]=new int[4];
		int sz=group.size();
		int x1[]=new int[sz];
		int x2[]=new int[sz];
		int[] y1=new int[sz];
		int[] y2=new int[sz];
		
		int i=0;
		for(IShape shape:group) {
			x1[i]=shape.getProperties().getX();
			
			x2[i]=shape.getProperties().getX()+shape.getProperties().getWidth();
			
			y1[i]=shape.getProperties().getY();
			
			y2[i]=shape.getProperties().getY()+shape.getProperties().getHeight();
			
			i=i+1;
		}
		
		 int minx1 = getMinValue(x1);
		 int maxx2= getMaxValue(x2);
		 int miny1 = getMinValue(y1);
		 int maxy2= getMaxValue(y2);
		 
		 int array[]=new int[4];
		 array[0]=minx1;
		 array[1]=maxx2;
		 array[2]=miny1;
		 array[3]=maxy2;

		 ShapeProperties properties=new ShapeProperties(minx1,miny1,maxx2-minx1,maxy2-miny1);
		 setProperties(properties);
	}

	public int getMaxValue(int[] numbers){
		  int maxValue = numbers[0];
		  for(int i=1;i < numbers.length;i++){
		    if(numbers[i] > maxValue){
		      maxValue = numbers[i];
		    }
		  }
		  return maxValue;
		}

		public int getMinValue(int[] numbers){
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
		for(IShape sh:group) {
			IShape s=sh.copy(sh);
			list.add(s);
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
			for(IShape sh:group) {
				IShape s=sh.copy(sh);
				list.add(s);
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

		

	

}
