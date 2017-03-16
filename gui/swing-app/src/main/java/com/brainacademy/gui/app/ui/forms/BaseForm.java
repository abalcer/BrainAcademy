package com.brainacademy.gui.app.ui.forms;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;
import javax.swing.JPanel;

public abstract class BaseForm
        extends JPanel {

    protected List<Action> actions = new ArrayList<>();

    public abstract void updateData();
    protected abstract void initActions();

    public BaseForm() {
        initActions();
    }

    public List<Action> getActions() {
        return actions;
    }
}
