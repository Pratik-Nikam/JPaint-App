package command;

public class DeleteCommandBuilder {
    private IMainStorage shapedata;
    private IMainStorage shapeselectdata;

    public DeleteCommandBuilder setShapedata(IMainStorage shapedata) {
        this.shapedata = shapedata;
        return this;
    }

    public DeleteCommandBuilder setShapeselectdata(IMainStorage shapeselectdata) {
        this.shapeselectdata = shapeselectdata;
        return this;
    }

    public DeleteCommand createDeleteCommand() {
        return new DeleteCommand(shapedata, shapeselectdata);
    }
}