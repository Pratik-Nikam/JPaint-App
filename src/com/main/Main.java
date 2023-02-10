package com.main;

import com.command.ShapeSelectListStorage;
import com.handler.ClickHandler;
import com.command.MainStorage;
import com.command.ShapeListStorage;
import com.controller.IJPaintController;
import com.controller.JPaintController;
import com.model.interfaces.IShape;
import com.model.persistence.ApplicationState;
import com.view.gui.Gui;
import com.view.gui.GuiWindow;
import com.view.gui.PaintCanvas;
import com.view.interfaces.IGuiWindow;
import com.view.interfaces.IUiModule;

import java.util.ArrayList;

public class Main  {
    public static void main(String[] args){
        PaintCanvas paintCanvas = new PaintCanvas();
        MainStorage shapedata= new ShapeListStorage(new ArrayList<IShape>(), paintCanvas);
        MainStorage shapeselectdata = new ShapeSelectListStorage(new ArrayList<IShape>(), paintCanvas);
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        paintCanvas.addMouseListener(new ClickHandler(paintCanvas, appState,shapedata,shapeselectdata));

        controller.setup();
    }
}
