package com.brainacademy.gui.db.forms.listener;

import com.brainacademy.gui.db.model.User;

public interface UserEditListener {
    void cancel();
    void success(User user);
}
