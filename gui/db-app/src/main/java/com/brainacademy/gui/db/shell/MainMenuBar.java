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

        JMenu themeMenu = new JMenu(Resource.getString("menu.settings.themes"));
        themeMenu.add(actions.getMetalLookAndFeelAction());
        themeMenu.add(actions.getSystemLookAndFeelAction());
        themeMenu.add(actions.getMotifLookAndFeelAction());

        JMenu settingsMenu = new JMenu(Resource.getString("menu.settings"));
        settingsMenu.add(themeMenu);

        this.add(userMenu);
        this.add(settingsMenu);
    }
}
