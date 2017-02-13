package com.brainacademy.gui.db.action;


import javax.swing.*;

import lombok.Getter;

public class MenuActions {
    @Getter
    private final Action showUsersAction;

    @Getter
    private final Action addUsersAction;

    @Getter
    private final Action deleteUsersAction;

    @Getter
    private final Action editUsersAction;

    public MenuActions(MenuActionListener listener) {
        showUsersAction = new ShowUsersAction(listener);

        addUsersAction = new AddUsersAction(listener);

        deleteUsersAction = new DeleteUsersAction(listener);
        deleteUsersAction.setEnabled(false);

        editUsersAction = new EditUsersAction(listener);
        editUsersAction.setEnabled(false);
    }
}
