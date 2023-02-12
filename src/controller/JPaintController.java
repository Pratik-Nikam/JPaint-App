package controller;

import command.RedoCommand;
import command.UndoCommand;
import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.IUiModule;

import java.io.IOException;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
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
    }
}
