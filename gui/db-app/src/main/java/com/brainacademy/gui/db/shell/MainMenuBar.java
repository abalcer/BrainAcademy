package com.brainacademy.gui.db.shell;

import javax.swing.*;

import com.brainacademy.gui.db.action.MenuActions;
import com.brainacademy.gui.db.utils.Resource;

public class MainMenuBar extends JMenuBar {
    public MainMenuBar(MenuActions actions) {
        super();

        JMenu userMenu = new JMenu(Resource.getString("menu.user"));
        userMenu.add(actions.getShowUsersAction());
        userMenu.addSeparator();
        userMenu.add(actions.getAddUsersAction());
        userMenu.add(actions.getEditUsersAction());
        userMenu.add(actions.getDeleteUsersAction());

        JMenu settingsMenu = new JMenu(Resource.getString("menu.settings"));

        this.add(userMenu);
        this.add(settingsMenu);
    }
}
