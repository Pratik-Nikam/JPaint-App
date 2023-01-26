package com.view.interfaces;

import com.view.EventName;

public interface IUiModule {
    void addEvent(EventName eventName, IEventCallback command);
    <T> T getDialogResponse(IDialogChoice dialogChoice);
}
