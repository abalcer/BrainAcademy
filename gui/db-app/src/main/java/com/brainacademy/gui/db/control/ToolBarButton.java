package com.brainacademy.gui.db.control;

import javax.swing.*;

import com.brainacademy.gui.db.utils.Resource;

public class ToolBarButton extends JButton {
    public ToolBarButton(Action action, String toolTip) {
        super(action);

        this.setHideActionText(true);
        this.setToolTipText(Resource.getString(toolTip));
    }
}
