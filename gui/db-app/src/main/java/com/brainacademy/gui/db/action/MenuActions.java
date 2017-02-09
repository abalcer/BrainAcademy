package com.brainacademy.gui.db.action;


import java.awt.event.ActionEvent;

import javax.swing.*;

import com.brainacademy.gui.db.utils.Resource;

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

    @Getter
    private final Action metalLookAndFeelAction;

    @Getter
    private final Action systemLookAndFeelAction;

    @Getter
    private final Action motifLookAndFeelAction;


    public MenuActions(MenuActionListener listener) {
        showUsersAction = new ShowUsersAction(listener);

        addUsersAction = new AddUsersAction(listener);
        addUsersAction.setEnabled(false);

        deleteUsersAction = new DeleteUsersAction(listener);
        deleteUsersAction.setEnabled(false);

        editUsersAction = new EditUsersAction(listener);
        editUsersAction.setEnabled(false);

        metalLookAndFeelAction = new AbstractAction(Resource.getString("action.themes.metal")) {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(listener != null) {
                    listener.onSetMetalLookAndFeel(e);
                }
            }
        };
        systemLookAndFeelAction = new AbstractAction(Resource.getString("action.themes.system")) {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(listener != null) {
                    listener.onSetSystemLookAndFeel(e);
                }
            }
        };

        motifLookAndFeelAction = new AbstractAction(Resource.getString("action.themes.motif")) {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(listener != null) {
                    listener.onSetMotifLookAndFeel(e);
                }
            }
        };
    }
}
