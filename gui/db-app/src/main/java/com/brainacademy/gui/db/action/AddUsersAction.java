package com.brainacademy.gui.db.action;

import java.awt.event.ActionEvent;

public class AddUsersAction extends MenuItemAction {
    public static final String TEXT_KEY = "action.users.add";
    public static final String ICON_KEY = "user-plus";

    public AddUsersAction(MenuActionListener listener) {
        super(TEXT_KEY, ICON_KEY, listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(listener != null) {
            listener.onAddUserAction(e);
        }
    }
}
