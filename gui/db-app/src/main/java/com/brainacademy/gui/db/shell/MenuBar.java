package com.brainacademy.gui.db.shell;

import javax.swing.*;

import com.brainacademy.gui.db.action.MenuActions;
import com.brainacademy.gui.db.control.ToolBarButton;

public class MenuBar extends JToolBar {

    private final MenuActions actions;

    private ToolBarButton showUsersButton;
    private ToolBarButton addUserButton;
    private ToolBarButton editUserButton;
    private ToolBarButton deleteUserButton;

    public MenuBar(MenuActions actions) {
        super();
        this.actions = actions;
        initComponents();
    }

    private void initComponents() {
        this.setFloatable(false);

        showUsersButton = new ToolBarButton(actions.getShowUsersAction(), "action.users.show.tooltip");
        addUserButton = new ToolBarButton(actions.getAddUsersAction(), "action.users.add.tooltip");
        editUserButton = new ToolBarButton(actions.getEditUsersAction(), "action.users.edit.tooltip");
        deleteUserButton = new ToolBarButton(actions.getDeleteUsersAction(), "action.users.delete.tooltip");

        this.add(showUsersButton);
        this.addSeparator();
        this.add(editUserButton);
        this.add(addUserButton);
        this.add(deleteUserButton);
    }
}
