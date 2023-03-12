package model;

import java.awt.*;
import java.util.EnumMap;

// Here have used Singleton pattern to handle colors.
public class ColorMapSingleton {
	private static EnumMap<ShapeColor, Color> map =new EnumMap<>(ShapeColor.class);
	private static ColorMapSingleton instance ;

	// below is the private constructor, so that object is not created from outside this class.
	private ColorMapSingleton() {
		super();
		// here assigning the values to the map, when the object is created.
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

	public Color getColor(ShapeColor color) {
		return map.get(color);
	}

	//here is the static method which when called will return this class's object.
	// when this class is instantiated for the first time, instance of this class is returned,
	// and when called again, the reference to the previous object is returned instead of new object.
	public static ColorMapSingleton getInstance() {
		// condition to handle that the instance for this class is created just once.
		if(instance == null)
		{
			instance = new ColorMapSingleton();
		}
		return instance;
	}
}
