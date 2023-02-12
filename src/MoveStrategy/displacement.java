package MoveStrategy;


import model.interfaces.IShape;

public class displacement {
	int dx;
	int dy;
	IShape shape;
	
	public displacement(int dx, int dy, IShape shape) {
		super();
		this.dx = dx;
		this.dy = dy;
		this.shape=shape;
		
	}
	public void displace(IMoveStrategy move) {
		move.displace(shape, dx, dy);
	}

}
