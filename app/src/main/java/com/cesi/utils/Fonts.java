package com.cesi.utils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;

import java.util.HashMap;

public class Fonts {
    private final static Fonts INSTANCE = new Fonts();

    private Display _display;
    private HashMap<String, Font> _fonts;

    public static Fonts getInstance() {
        return INSTANCE;
    }

    private Fonts() {
        _fonts = new HashMap<>();
    }

    public Fonts init(Display display) {
        _display = display;

        return this;
    }

    public boolean loadFont(String path, String local_name) {
        String output = Utils.copyFileToTemp(path, local_name);
        System.out.println(output);
        return output != null && _display.loadFont(output);
    }

    public Font getFont(String name, int size) {
        String key = size + "_" + name;
        Font font = _fonts.get(key);

        if (font == null) {
            font = new Font(_display, name, size, SWT.NORMAL);
            System.out.println("font ");
            _fonts.put(key, font);
        }
        return font;
    }

    public void displayAllLoadedFonts() {
        // display all scalable fonts in the system
        FontData[] fd = _display.getFontList(null, true);
        for( int i = 0; i < fd.length; i++ ) {
            System.out.println(fd[i].getName());
        }
        // and the non-scalable ones
        fd = _display.getFontList(null, false);
        for( int i = 0; i < fd.length; i++ ) {
            System.out.println(fd[i].getName());
        }
    }
}
