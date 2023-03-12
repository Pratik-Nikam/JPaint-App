package model;

import java.awt.*;
import java.util.EnumMap;

public class singleton {
	private static EnumMap<ShapeColor, Color> map =new EnumMap<>(ShapeColor.class);
	private static singleton instance ;

	public singleton() {
		super();
		map.put(ShapeColor.BLACK, Color.black);
		map.put(ShapeColor.BLUE, Color.BLUE);
		map.put(ShapeColor.RED, Color.RED);
		map.put(ShapeColor.CYAN, Color.CYAN);
		map.put(ShapeColor.YELLOW, Color.YELLOW);
		map.put(ShapeColor.GREEN, Color.GREEN);
		map.put(ShapeColor.GRAY, Color.GRAY);
		map.put(ShapeColor.LIGHT_GRAY, Color.LIGHT_GRAY);
		map.put(ShapeColor.MAGENTA, Color.MAGENTA);
		map.put(ShapeColor.ORANGE, Color.ORANGE);
		map.put(ShapeColor.ORANGE, Color.ORANGE);
		map.put(ShapeColor.PINK, Color.PINK);
		
		}

//	public EnumMap<ShapeColor, Color> getMap() {
//		return map;
//	}


	public Color getColor(ShapeColor color) {
		return map.get(color);
	}

	public static singleton getInstance() {
		if(instance == null)
		{
			instance = new singleton();
		}
		return instance;
	}
}
