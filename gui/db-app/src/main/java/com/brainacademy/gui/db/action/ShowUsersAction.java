package com.brainacademy.gui.db.action;

import java.awt.event.ActionEvent;


public class ShowUsersAction extends MenuItemAction {
    public static final String TEXT_KEY = "action.users.show";
    public static final String ICON_KEY = "users";

    public ShowUsersAction(MenuActionListener listener) {
        super(TEXT_KEY, ICON_KEY, listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (listener != null) {
            listener.onShowUserAction(e);
        }
    }
}
