package com.brainacademy.gui.db.action;

import java.awt.event.ActionEvent;

public class DeleteUsersAction extends MenuItemAction {
    public static final String TEXT_KEY = "action.users.delete";
    public static final String ICON_KEY = "user-minus";

    public DeleteUsersAction(MenuActionListener listener) {
        super(TEXT_KEY, ICON_KEY, listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (listener != null) {
            listener.onDeleteUserAction(e);
        }
    }
}
