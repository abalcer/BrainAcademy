package com.brainacademy.gui.app.ui;

import com.brainacademy.gui.app.ui.forms.BaseForm;
import com.brainacademy.gui.app.ui.forms.RoutesForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;

@Component
public class MainFrame
        extends JFrame {

    @Autowired
    private RoutesForm routesForm;

    private JToolBar toolBar;

    private JButton showRoutesButton;
    private JButton showAirlinesButton;
    private JButton showAirportButton;

    private JScrollPane controlPanel;

    private BaseForm activeForm;
    private JToolBar childToolBar;

    public MainFrame() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(500, 600));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        initComponents();
    }

    public void showForm() {
        this.setVisible(true);
    }

    private void initComponents() {
        controlPanel = new JScrollPane();

        showRoutesButton = new JButton("Routes");
        showRoutesButton.addActionListener(this::showRoutesAction);

        showAirlinesButton = new JButton("Airlines");
        showAirlinesButton.addActionListener(this::showAirlinesAction);

        showAirportButton = new JButton("Airports");
        showAirportButton.addActionListener(this::showAirportAction);

        childToolBar = new JToolBar();
        childToolBar.setVisible(false);

        toolBar = new JToolBar();
        toolBar.setFloatable(false);

        toolBar.add(showRoutesButton);
        toolBar.add(showAirlinesButton);
        toolBar.add(showAirportButton);
        toolBar.addSeparator();
        toolBar.add(childToolBar);

        this.add(toolBar, BorderLayout.PAGE_START);
        this.add(controlPanel);
    }

    private void showAirlinesAction(ActionEvent actionEvent) {

    }

    private void showAirportAction(ActionEvent actionEvent) {

    }

    private void showRoutesAction(ActionEvent actionEvent) {
        updateUi(routesForm);
    }

    private void updateUi(RoutesForm form) {
        if (!form.equals(activeForm)) {
            childToolBar.removeAll();
            activeForm = form;
        } else {
            return;
        }

        activeForm.getActions().forEach(childToolBar::add);
        childToolBar.setVisible(childToolBar.getComponentCount() > 0);
        controlPanel.setViewportView(activeForm);

        activeForm.updateData();
    }
}
