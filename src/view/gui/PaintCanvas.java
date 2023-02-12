package view.gui;

import javax.swing.JComponent;
import java.awt.*;

public class PaintCanvas extends JComponent {

    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }



    /*public Graphics2D getGraphics2d() {
        return graphics2d;
    }

    public void setGraphics2d(Graphics2D graphics2d) {
        this.graphics2d = graphics2d;
    }

    Graphics2D graphics2d;*/
/*
    @Override
    public void paint(Graphics g) {
        PaintCanvas p = new PaintCanvas();
        graphics2d = (Graphics2D)g;

        // For example purposes only; remove all lines below from your final project.
        // Draw all shapes here

        graphics2d.setColor(Color.GREEN);
        p.setGraphics2d(graphics2d);
        graphics2d.fillRect(12, 13, 200, 400);

        // Outlined rectangle
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(Color.BLUE);
        graphics2d.drawRect(12, 13, 200, 400);

        // Selected Shape
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2d.setStroke(stroke);
        graphics2d.setColor(Color.BLACK);
        graphics2d.drawRect(7, 8, 210, 410);
    }
*/

    /*public void drawRectangleShape(int X, int Y, int width, int height)
    {

    }*/
}
