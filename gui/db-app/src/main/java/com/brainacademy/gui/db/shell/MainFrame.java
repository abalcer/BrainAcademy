package com.brainacademy.gui.db.shell;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

import com.brainacademy.gui.db.action.MenuActionListener;
import com.brainacademy.gui.db.action.MenuActions;
import com.brainacademy.gui.db.forms.UserEdit;
import com.brainacademy.gui.db.forms.listener.UserEditListener;
import com.brainacademy.gui.db.forms.listener.UserSelectedListener;
import com.brainacademy.gui.db.forms.UsersForm;
import com.brainacademy.gui.db.model.User;
import com.brainacademy.gui.db.service.UserService;
import com.brainacademy.gui.db.utils.Resource;


public class MainFrame extends JFrame
        implements MenuActionListener,
        UserSelectedListener,
        UserEditListener {

    private static final int MIN_WIDTH = 600;
    private static final int MIN_HEIGHT = 400;

    private MenuActions menuActions;
    private Container contentPane;
    private User currentUser;

    private UserService userService = UserService.getInstance();

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
        showEditForm(null);
    }

    @Override
    public void onDeleteUserAction(ActionEvent e) {
        int res = JOptionPane.showConfirmDialog(this,
                Resource.getString("user.delete.message"),
                Resource.getString("user.delete.title"),
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (res == JOptionPane.YES_OPTION) {
            userService.delete(currentUser);
            showAllUsers();
        }
    }

    @Override
    public void onShowUserAction(ActionEvent e) {
        showAllUsers();
    }

    @Override
    public void onEditUserAction(ActionEvent e) {
        showEditForm(currentUser);
    }

    @Override
    public void userSelected(User user) {
        currentUser = user;
        menuActions.getDeleteUsersAction().setEnabled(true);
        menuActions.getEditUsersAction().setEnabled(true);
    }

    @Override
    public void userAction(User user) {
        userSelected(user);
        showEditForm(user);
    }

    @Override
    public void cancel() {
        showAllUsers();
    }

    @Override
    public void success(User user) {
        currentUser = user;
        showAllUsers();
    }

    private void showEditForm(User user) {
        if (contentPane.getComponentCount() > 1) {
            contentPane.remove(1);
        }

        UserEdit userEdit = new UserEdit(this);
        userEdit.setUser(user);

        contentPane.add(userEdit.getRootPanel(), BorderLayout.CENTER);
        pack();
    }

    private void showAllUsers() {
        if (contentPane.getComponentCount() > 1) {
            contentPane.remove(1);
        }

        currentUser = null;

        UsersForm usersForm = new UsersForm(this);
        menuActions.getShowUsersAction().setEnabled(false);
        contentPane.add(usersForm.getUsersPanel(), BorderLayout.CENTER);
        pack();
    }
}
