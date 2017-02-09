package com.brainacademy.gui.db.utils;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.*;

public class Resource {
    private static Resource resource = null;
    private final ResourceBundle resourceBundle;

    private Resource() {
        resourceBundle = ResourceBundle.getBundle("i18n.Bundle");
    }

    public static void init() {
        resource = new Resource();
    }

    public static String getString(String name) {
        String value = resource.resourceBundle.getString(name);
        //return new String(value.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        return value;
    }

    public static Icon getSmallIcon(String name) {
        URL imageUrl = Resource.class.getClassLoader().getResource("assets/16x16/" + name + ".png");
        return new ImageIcon(imageUrl);
    }
}
