package com.brainacademy.gui.db.action;

import java.awt.event.ActionEvent;

public interface MenuActionListener {

    void onAddUserAction(ActionEvent e);

    void onDeleteUserAction(ActionEvent e);

    void onShowUserAction(ActionEvent e);

    void onEditUserAction(ActionEvent e);
}
