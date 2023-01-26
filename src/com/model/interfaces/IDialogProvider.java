package com.model.interfaces;

import com.model.ShapeShadingType;
import com.model.ShapeColor;
import com.model.ShapeType;
import com.model.MouseMode;
import com.view.interfaces.IDialogChoice;

public interface IDialogProvider {

    IDialogChoice<ShapeType> getChooseShapeDialog();

    IDialogChoice<ShapeColor> getChoosePrimaryColorDialog();

    IDialogChoice<ShapeColor> getChooseSecondaryColorDialog();

    IDialogChoice<ShapeShadingType> getChooseShadingTypeDialog();

    IDialogChoice<MouseMode> getChooseStartAndEndPointModeDialog();
}
