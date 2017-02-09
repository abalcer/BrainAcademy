package com.brainacademy.gui.db.action;

import java.awt.event.ActionEvent;

public interface MenuActionListener {

    void onAddUserAction(ActionEvent e);

    void onDeleteUserAction(ActionEvent e);

    void onShowUserAction(ActionEvent e);

    void onEditUserAction(ActionEvent e);

    void onSetSystemLookAndFeel(ActionEvent e);

    void onSetMetalLookAndFeel(ActionEvent e);

    void onSetMotifLookAndFeel(ActionEvent e);
}
