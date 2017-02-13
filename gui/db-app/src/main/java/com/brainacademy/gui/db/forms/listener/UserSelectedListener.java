package com.brainacademy.gui.db.forms.listener;

import com.brainacademy.gui.db.model.User;

public interface UserSelectedListener {
    void userSelected(User user);
    void userAction(User user);
}
