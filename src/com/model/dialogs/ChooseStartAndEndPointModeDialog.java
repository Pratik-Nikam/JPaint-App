package com.model.dialogs;

import com.model.interfaces.IApplicationState;
import com.model.MouseMode;
import com.view.interfaces.IDialogChoice;

public class ChooseStartAndEndPointModeDialog implements IDialogChoice<MouseMode> {
    private final IApplicationState applicationState;

    public ChooseStartAndEndPointModeDialog(IApplicationState applicationState) {

        this.applicationState = applicationState;
    }

    @Override
    public String getDialogTitle() {
        return "Start and End Point Mode";
    }

    @Override
    public String getDialogText() {
        return "Select a shading type from the menu below:";
    }

    @Override
    public MouseMode[] getDialogOptions() {
        return MouseMode.values();
    }

    @Override
    public MouseMode getCurrentSelection() {
        return applicationState.getActiveMouseMode();
    }
}
