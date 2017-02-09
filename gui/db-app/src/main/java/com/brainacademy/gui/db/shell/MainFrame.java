package com.brainacademy.gui.db.shell;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

import com.brainacademy.gui.db.Application;
import com.brainacademy.gui.db.action.MenuActionListener;
import com.brainacademy.gui.db.action.MenuActions;
import com.brainacademy.gui.db.forms.UsersForm;
import com.brainacademy.gui.db.utils.Resource;


public class MainFrame extends JFrame
        implements MenuActionListener {

    private static final int MIN_WIDTH = 600;
    private static final int MIN_HEIGHT = 400;
    
    private MenuActions menuActions;
    private Container contentPane;

    @Override
    protected void frameInit() {
        super.frameInit();

        this.setTitle(Resource.getString("main.title"));

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(MIN_WIDTH, MIN_HEIGHT));
        this.setLocationRelativeTo(null);

        contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());

        menuActions = new MenuActions(this);
        contentPane.add(new MenuBar(menuActions), BorderLayout.PAGE_START);

        this.setJMenuBar(new MainMenuBar(menuActions));
    }

    @Override
    public void onAddUserAction(ActionEvent e) {

    }

    @Override
    public void onDeleteUserAction(ActionEvent e) {

    }

    @Override
    public void onShowUserAction(ActionEvent e) {
        UsersForm usersForm = new UsersForm();
        if(contentPane.getComponentCount() > 1) {
            contentPane.remove(1);
        }
        menuActions.getShowUsersAction().setEnabled(false);
        contentPane.add(usersForm.getUsersPanel(), BorderLayout.CENTER);
        pack();
    }

    @Override
    public void onEditUserAction(ActionEvent e) {

    }

    @Override
    public void onSetSystemLookAndFeel(ActionEvent e) {
        Application.changeTheme(UIManager.getSystemLookAndFeelClassName());
    }

    @Override
    public void onSetMetalLookAndFeel(ActionEvent e) {
        Application.changeTheme("javax.swing.plaf.metal.MetalLookAndFeel");
    }

    @Override
    public void onSetMotifLookAndFeel(ActionEvent e) {
        Application.changeTheme("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
    }
}
