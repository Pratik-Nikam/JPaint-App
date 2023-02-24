package command;


import geometricshape.CreateShapeFactory;
import geometricshape.IshapeFactory;
import geometricshape.ShapeProperties;
import model.interfaces.IApplicationState;
import model.interfaces.IShape;

import java.io.IOException;


public class CreateShapeCommand implements ICommand, IUndoable {

    IShape shape;
    IApplicationState appState;
    IMainStorage shapedata;
    ShapeProperties properties;

    public CreateShapeCommand(IMainStorage shapedata, ShapeProperties properties, IApplicationState appState) {
        super();

        this.shapedata = shapedata;
        this.properties = properties;
        this.appState = appState;
    }

    public void run() throws IOException {
        IshapeFactory factory = new CreateShapeFactory();
        shape = factory.CreateShape(properties, appState);
        shapedata.addShape(shape);
        CommandHistory.add(this);
        System.out.println("Shape created");
    }

    @Override
    public void undo() {
        shapedata.removeShape(this.shape);
        System.out.println("shape undo");
    }

    @Override
    public void redo() {
        shapedata.addShape(shape);
        System.out.println("Shape redo");
    }
}
