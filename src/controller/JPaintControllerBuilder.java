package controller;

import command.IMainStorage;
import model.interfaces.IApplicationState;
import view.gui.PaintCanvas;
import view.interfaces.IUiModule;

public class JPaintControllerBuilder {
    private IUiModule uiModule;
    private IApplicationState applicationState;
    private IMainStorage shapedata;
    private IMainStorage shapeselectdata;
    private IMainStorage copyshapedata;
    private PaintCanvas canvas;

    public JPaintControllerBuilder setUiModule(IUiModule uiModule) {
        this.uiModule = uiModule;
        return this;
    }

    public JPaintControllerBuilder setApplicationState(IApplicationState applicationState) {
        this.applicationState = applicationState;
        return this;
    }

    public JPaintControllerBuilder setShapedata(IMainStorage shapedata) {
        this.shapedata = shapedata;
        return this;
    }

    public JPaintControllerBuilder setShapeselectdata(IMainStorage shapeselectdata) {
        this.shapeselectdata = shapeselectdata;
        return this;
    }

    public JPaintControllerBuilder setCopyshapedata(IMainStorage copyshapedata) {
        this.copyshapedata = copyshapedata;
        return this;
    }

    public JPaintController createJPaintController() {
        return new JPaintController(uiModule, applicationState, shapedata, shapeselectdata, copyshapedata, canvas);
    }

    public JPaintControllerBuilder setPaintCanvas(PaintCanvas canvas) {
        this.canvas = canvas;
        return this;
    }
}