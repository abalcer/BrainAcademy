package com.brainacademy.gui.app.ui;

import com.brainacademy.gui.app.ui.forms.RoutesForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

@Component
public class MainFrame
        extends JFrame {

    @Autowired
    RoutesForm routesForm;

    public MainFrame() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(500, 600));
        this.setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                setContentPane(routesForm);
                routesForm.updateData(null, true);
            }
        });
        this.pack();
    }
}
