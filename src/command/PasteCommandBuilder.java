package command;

import model.interfaces.IApplicationState;

public class PasteCommandBuilder {
    private IApplicationState applicationState;
    private IMainStorage shapedata;
    private IMainStorage copyshapedata;

    public PasteCommandBuilder setApplicationState(IApplicationState applicationState) {
        this.applicationState = applicationState;
        return this;
    }

    public PasteCommandBuilder setShapedata(IMainStorage shapedata) {
        this.shapedata = shapedata;
        return this;
    }

    public PasteCommandBuilder setCopyshapedata(IMainStorage copyshapedata) {
        this.copyshapedata = copyshapedata;
        return this;
    }

    public PasteCommand createPasteCommand() {
        return new PasteCommand(applicationState, shapedata, copyshapedata);
    }
}