package com.brainacademy.gui.db;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.*;

import com.brainacademy.gui.db.shell.MainFrame;
import com.brainacademy.gui.db.utils.Resource;

import lombok.Getter;

public class Application {
    @Getter
    private static Application application = null;

    private MainFrame mainFrame;

    private Application() {
        changeLocale("ru", "RU");
        Resource.init();
    }

    private void run() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainFrame = new MainFrame();
                mainFrame.setVisible(true);
            }
        });

    }

    public static void changeLocale(String lang, String country) {
        Locale locale = new Locale("ru", "RU");
        Locale.setDefault(locale);
        ResourceBundle.clearCache();
    }

    public static void changeTheme(String lookAndFeel) {
        try {
            UIManager.setLookAndFeel(lookAndFeel);
            SwingUtilities.updateComponentTreeUI(application.mainFrame);
        } catch (Exception ex) {
            System.err.println("Could not change theme: ");
        }
    }

    public static void main(String[] args) {
        application = new Application();
        application.run();
    }
}
