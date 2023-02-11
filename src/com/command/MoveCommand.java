package com.command;


import com.model.interfaces.IShape;

import java.io.IOException;
import java.util.ArrayList;


public class MoveCommand implements ICommand, IUndoable {

    ArrayList<IShape> clipboard;
    int dx;
    int dy;
    IMainStorage shapedata;
    IMainStorage shapeselectdata;


    public MoveCommand(int dx, int dy, IMainStorage shapedata, IMainStorage shapeselectdata) {
        super();

        this.dx = dx;
        this.dy = dy;
        clipboard = new ArrayList<>();
        this.shapedata = shapedata;
        this.shapeselectdata = shapeselectdata;
    }


    @Override
    public void undo() {
        for (IShape shape : clipboard) {
            shape.negativeDisplacement(dx, dy);
        }
        shapedata.redraw();
    }

    @Override
    public void redo() {
        for (IShape shape : clipboard) {
            shape.positiveDisplacement(dx, dy);
        }
        shapedata.redraw();
    }

    @Override
    public void run() throws IOException {
        for (IShape shape : shapedata.list()) {
            if (shapeselectdata.contains(shape)) {
                shape.positiveDisplacement(dx, dy);
                clipboard.add(shape);
            }
        }
        shapedata.redraw();
        CommandHistory.add(this);
    }
}

