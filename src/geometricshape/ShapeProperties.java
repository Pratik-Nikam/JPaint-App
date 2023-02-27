package geometricshape;

import handler.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;


public class ShapeProperties {
    Point point;
    ShapeShadingType shade;
    ShapeColor shapecolor;
    ShapeType shapeType;
    private int x;
    private int y;
    private int x1;
    private int y1;
    private int width;
    private int height;

    public ShapeProperties(int x, int y, int width, int height) {
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


    public ShapeProperties(Point point, ShapeShadingType shade, ShapeColor shapecolor, ShapeType shapeType) {
        super();
        this.point = point;
        this.x = point.getStartPointX1();
        this.y = point.getStartPointY1();
        this.x1 = point.getEndPointX2();
        this.y1 = point.getEndPointY2();
        this.width = point.getWidth();
        this.height = point.getHeight();
        this.shade = shade;
        this.shapecolor = shapecolor;
        this.shapeType = shapeType;
    }

    public ShapeProperties(int x, int y, int width, int height, ShapeShadingType shade, ShapeColor shapecolor, ShapeType shapeType) {
        this.shade=shade;
        this.shapecolor=shapecolor;
        this.shapeType=shapeType;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;

    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public ShapeColor getColor() {
        return shapecolor;
    }

    public ShapeType getType() {
        return shapeType;
    }

    public ShapeShadingType getShade() {
        return shade;
    }
}
