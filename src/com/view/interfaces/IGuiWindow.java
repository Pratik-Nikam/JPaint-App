package com.view.interfaces;

import com.view.EventName;

import javax.swing.*;

public interface IGuiWindow {
    JButton getButton(EventName eventName);
}
