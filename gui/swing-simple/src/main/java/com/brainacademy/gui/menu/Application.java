package com.brainacademy.gui.menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setMinimumSize(new Dimension(400, 300));
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


                JMenu menu1 = new JMenu("Menu 1");
                JMenu menu2 = new JMenu("Menu 2");
                JMenu menu3 = new JMenu("Menu 3");

                JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem("Checkbox item 1");
                checkBoxMenuItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(frame, "Checkbox checked " + checkBoxMenuItem.getState());
                    }
                });

                ActionListener radioButtonActionListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JRadioButtonMenuItem source = (JRadioButtonMenuItem) e.getSource();
                        JOptionPane.showMessageDialog(frame, source.getText() + " state changed " + source.isSelected());
                    }
                };

                JRadioButtonMenuItem radioButtonMenuItem1 = new JRadioButtonMenuItem("RadioButton 1");
                radioButtonMenuItem1.addActionListener(radioButtonActionListener);

                JRadioButtonMenuItem radioButtonMenuItem2 = new JRadioButtonMenuItem("RadioButton 2");
                radioButtonMenuItem2.addActionListener(radioButtonActionListener);

                JRadioButtonMenuItem radioButtonMenuItem3 = new JRadioButtonMenuItem("RadioButton 3");
                radioButtonMenuItem3.addActionListener(radioButtonActionListener);

                //Объеденяем radio button в группу.
                ButtonGroup group = new ButtonGroup();
                group.add(radioButtonMenuItem1);
                group.add(radioButtonMenuItem2);
                group.add(radioButtonMenuItem3);


                JMenuItem item1 = new JMenuItem("Submenu item 1");
                item1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(frame, "Submenu item 1 selected");
                    }
                });
                JMenuItem item2 = new JMenuItem("Submenu item 2");
                JMenuItem item3 = new JMenuItem("Submenu item 3");
                JMenuItem item4 = new JMenuItem("Submenu item 4");


                Action action1 = new AbstractAction("Action 1") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(frame, "Action 1 selected");
                    }
                };

                Action action2 = new AbstractAction("Action 2") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(frame, "Action 2 selected");
                    }
                };

                Action action3 = new AbstractAction("Action 3") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(frame, "Action 2 selected");
                    }
                };


                menu1.add(checkBoxMenuItem);
                menu1.addSeparator();
                menu1.add(radioButtonMenuItem1);
                menu1.add(radioButtonMenuItem2);
                menu1.add(radioButtonMenuItem3);

                menu2.add(item1);
                menu2.add(item2);
                menu2.add(item3);
                menu2.add(item4);


                menu3.add(action1);
                menu3.add(action2);
                menu3.add(action3);

                JMenuBar menuBar = new JMenuBar();
                menuBar.add(menu1);
                menuBar.add(menu2);
                menuBar.add(menu3);

                frame.setJMenuBar(menuBar);

                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
