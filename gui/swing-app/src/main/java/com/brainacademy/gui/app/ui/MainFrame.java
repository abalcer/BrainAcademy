package com.brainacademy.gui.app.ui;

import com.brainacademy.gui.app.ui.forms.RoutesForm;

import org.springframework.stereotype.Component;

import javax.swing.JFrame;

@Component
public class MainFrame
        extends JFrame {

    public MainFrame() {
        setContentPane(new RoutesForm());
        this.pack();
    }

}
