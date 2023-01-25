package main;

import com.handler.ClickHandler;
import controller.IJPaintController;
import controller.JPaintController;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

public class Main  {
    public static void main(String[] args){
        PaintCanvas paintCanvas = new PaintCanvas();


        paintCanvas.addMouseListener(new ClickHandler(paintCanvas));
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);

        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);

        controller.setup();
    }
}
