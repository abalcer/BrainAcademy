package com.brainacademy.gui.db.action;

import javax.swing.*;

import com.brainacademy.gui.db.utils.Resource;

public abstract class MenuItemAction extends AbstractAction {
    protected final MenuActionListener listener;

    public MenuItemAction(String textResKey, String iconResKey, MenuActionListener listener) {
        super(Resource.getString(textResKey), Resource.getSmallIcon(iconResKey));
        this.listener = listener;
    }

}
