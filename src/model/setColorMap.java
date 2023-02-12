package model;

import java.awt.*;
import java.util.EnumMap;

public class setColorMap {
	EnumMap<ShapeColor, Color> map =new EnumMap<>(ShapeColor.class);

	public setColorMap() {
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

	public EnumMap<ShapeColor, Color> getMap() {
		return map;
	}

	
	
	
	
	
}
