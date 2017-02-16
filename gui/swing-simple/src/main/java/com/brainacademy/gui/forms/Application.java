package com.brainacademy.gui.forms;

import java.util.Locale;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Locale.setDefault(new Locale("ru", "RU"));

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                frame.setContentPane(new MainForm().getRootPanel());

                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
