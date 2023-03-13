package command;

// uses command pattern here
public class CopyCommandBuilder {
    private IMainStorage shapeselectdata;
    private IMainStorage copyshapedata;

    public CopyCommandBuilder setShapeselectdata(IMainStorage shapeselectdata) {
        this.shapeselectdata = shapeselectdata;
        return this;
    }

    public CopyCommandBuilder setCopyshapedata(IMainStorage copyshapedata) {
        this.copyshapedata = copyshapedata;
        return this;
    }

    public CopyCommand createCopyCommand() {
        return new CopyCommand(shapeselectdata, copyshapedata);
    }
}