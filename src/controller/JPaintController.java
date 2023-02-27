package controller;

import command.*;
import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.IUiModule;

import java.io.IOException;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    IMainStorage shapeselectdata;
    IMainStorage copyshapedata;
    IMainStorage shapedata;
    public JPaintController(IUiModule uiModule, IApplicationState applicationState, IMainStorage shapedata,IMainStorage shapeselectdata,IMainStorage copyshapedata) {

        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.shapeselectdata= shapeselectdata;
        this.copyshapedata= copyshapedata;
        this.shapedata = shapedata;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.UNDO,()->{
            try {
                new UndoCommand().run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        uiModule.addEvent(EventName.REDO,()->{
            try {
                new RedoCommand().run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        uiModule.addEvent(EventName.COPY,()->{
            try {
                new CopyCommand(shapeselectdata, copyshapedata).run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        uiModule.addEvent(EventName.PASTE,()->{
            try {
                new PasteCommand(applicationState, shapedata, copyshapedata).run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        uiModule.addEvent(EventName.DELETE,()->{
            try {
                new DeleteCommand(shapedata, shapeselectdata).run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
