package main;

import command.CopyListStorage;
import command.ShapeSelectListStorage;
import handler.ClickHandler;
import command.IMainStorage;
import command.ShapeListStorage;
import controller.IJPaintController;
import controller.JPaintController;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

import java.util.ArrayList;

public class Main  {
    public static void main(String[] args){
        PaintCanvas paintCanvas = new PaintCanvas();
        IMainStorage shapedata= new ShapeListStorage(new ArrayList<IShape>(), paintCanvas);
        IMainStorage shapeselectdata = new ShapeSelectListStorage(new ArrayList<IShape>(), paintCanvas);
        IMainStorage copyshapedata = new CopyListStorage(new ArrayList<IShape>(), paintCanvas);
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState,shapeselectdata, copyshapedata);
        paintCanvas.addMouseListener(new ClickHandler(paintCanvas, appState,shapedata,shapeselectdata));
        controller.setup();
    }
}
