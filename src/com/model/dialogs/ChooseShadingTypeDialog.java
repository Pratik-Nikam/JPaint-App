package com.model.dialogs;

import com.model.ShapeShadingType;
import com.model.interfaces.IApplicationState;
import com.view.interfaces.IDialogChoice;

public class ChooseShadingTypeDialog implements IDialogChoice<ShapeShadingType> {
    private final IApplicationState applicationState;

    public ChooseShadingTypeDialog(IApplicationState applicationState) {

        this.applicationState = applicationState;
    }

    @Override
    public String getDialogTitle() {
        return "Shading Type";
    }

    @Override
    public String getDialogText() {
        return "Select a shading type from the menu below:";
    }

    @Override
    public ShapeShadingType[] getDialogOptions() {
        return ShapeShadingType.values();
    }

    @Override
    public ShapeShadingType getCurrentSelection() {
        return applicationState.getActiveShapeShadingType();
    }
}
