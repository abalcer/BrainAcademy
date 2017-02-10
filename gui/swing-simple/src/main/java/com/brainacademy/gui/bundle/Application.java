package com.brainacademy.gui.bundle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.*;

public class Application {

    private static class MainFrame extends JFrame {
        private JButton button1;
        private JButton button2;
        private JLabel label;

        public MainFrame() {
            super();

            setMinimumSize(new Dimension(400, 300));
            setLocationRelativeTo(null);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            initComponents();
        }

        private void initComponents() {
            getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));

            button1 = new JButton();
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Locale.setDefault(new Locale("en", "EN"));
                    updateTextMessage();

                }
            });
            button2 = new JButton();
            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Locale.setDefault(new Locale("ru", "RU"));
                    updateTextMessage();
                }
            });

            label = new JLabel();

            getContentPane().add(label);
            getContentPane().add(button1);
            getContentPane().add(button2);

            updateTextMessage();

            pack();
        }

        private void updateTextMessage() {
            ResourceBundle bundle = ResourceBundle.getBundle("i18n.Bundle");
            setTitle(bundle.getString("frame.title"));
            button1.setText(bundle.getString("button.en.text"));
            button2.setText(bundle.getString("button.ru.text"));
            label.setText(bundle.getString("label.text"));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Locale.setDefault(new Locale("ru", "RU"));

                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            }
        });
    }
}
