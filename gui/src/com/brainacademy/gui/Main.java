package com.brainacademy.gui;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;

import javax.swing.*;

public class Main  {


    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
//        UIManager.setLookAndFeel(
//                UIManager.getCrossPlatformLookAndFeelClassName());
//
//        UIManager.setLookAndFeel(
//                UIManager.getSystemLookAndFeelClassName());

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("HelloWorldSwing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JLabel label = new JLabel("Find What:");;
                JTextField textField = new JTextField();
                JCheckBox caseCheckBox = new JCheckBox("Match Case");
                JCheckBox wrapCheckBox = new JCheckBox("Wrap Around");
                JCheckBox wholeCheckBox = new JCheckBox("Whole Words");
                JCheckBox backCheckBox = new JCheckBox("Search Backwards");
                JButton findButton = new JButton("Find");
                JButton cancelButton = new JButton("Cancel");

                // remove redundant default border of check boxes - they would hinder
                // correct spacing and aligning (maybe not needed on some look and feels)
                caseCheckBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                wrapCheckBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                wholeCheckBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                backCheckBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

                GroupLayout layout = new GroupLayout(frame.getContentPane());
                frame.getContentPane().setLayout(layout);
                layout.setAutoCreateGaps(true);
                layout.setAutoCreateContainerGaps(true);

                layout.setHorizontalGroup(layout.createSequentialGroup()
                        .addComponent(label)
                        .addGroup(layout.createParallelGroup(LEADING)
                                .addComponent(textField)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(LEADING)
                                                .addComponent(caseCheckBox)
                                                .addComponent(wholeCheckBox))
                                        .addGroup(layout.createParallelGroup(LEADING)
                                                .addComponent(wrapCheckBox)
                                                .addComponent(backCheckBox))))
                        .addGroup(layout.createParallelGroup(LEADING)
                                .addComponent(findButton)
                                .addComponent(cancelButton))
                );

                layout.linkSize(SwingConstants.HORIZONTAL, findButton, cancelButton);

                layout.setVerticalGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(BASELINE)
                                .addComponent(label)
                                .addComponent(textField)
                                .addComponent(findButton))
                        .addGroup(layout.createParallelGroup(LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(BASELINE)
                                                .addComponent(caseCheckBox)
                                                .addComponent(wrapCheckBox))
                                        .addGroup(layout.createParallelGroup(BASELINE)
                                                .addComponent(wholeCheckBox)
                                                .addComponent(backCheckBox)))
                                .addComponent(cancelButton))
                );

                //Display the window.
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
