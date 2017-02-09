package com.brainacademy.gui.db.action;

import java.awt.event.ActionEvent;

public class EditUsersAction extends MenuItemAction {
    public static final String TEXT_KEY = "action.users.edit";
    public static final String ICON_KEY = "pencil";

    public EditUsersAction(MenuActionListener listener) {
        super(TEXT_KEY, ICON_KEY, listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (listener != null) {
            listener.onEditUserAction(e);
        }
    }
}
