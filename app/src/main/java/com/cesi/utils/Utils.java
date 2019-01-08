package com.cesi.utils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;

import java.io.*;

public class Utils {


    public static String copyFileToTemp(String resource, String output_file) {
        try {
            InputStream input = Utils.class.getResourceAsStream(resource);
            File temp = File.createTempFile("temp_", output_file);
            temp.deleteOnExit();

            OutputStream output = new FileOutputStream(temp);

            byte[] buffer = new byte[4096];
            int len = input.read(buffer);
            while (len != -1) {
                output.write(buffer, 0, len);
                len = input.read(buffer);
            }

            input.close();
            output.close();

            return temp.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Image loadImageFromFileInputStream(Display display, String path) {
        Image image = null;
        try {
            FileInputStream input_stream = new FileInputStream(path);
            image = new Image(display, input_stream);
            input_stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return image;
    }

    public static Image loadImageFromResources(Display display_used,
                                               String path) {
        Image image = null;
        try {
            InputStream input_stream = Utils.class.getResourceAsStream(path);
            image = new Image(display_used, input_stream);
            input_stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return image;
    }

    public static Image resizeImage(Image image,
                                    Display display_used,
                                    float ratio,
                                    int max_height) {
        try {
            Rectangle rect = image.getBounds();

            float mult = 1.f;
            int new_width = (int) (rect.width * ratio);
            int new_height = (int) (rect.height * ratio);

            if (max_height > 0 && new_height > 0 && new_height > max_height) {
                mult = max_height * 1.f / new_height;
                new_height = max_height;
                new_width *= mult;
            }

            Image scaled = new Image(display_used, new_width, new_height);
            GC gc = new GC(scaled);
            gc.setAntialias(SWT.ON);
            gc.setInterpolation(SWT.HIGH);
            gc.drawImage(image, 0, 0,
                    image.getBounds().width, image.getBounds().height,
                    0, 0, new_width, new_height);
            gc.dispose();
            image.dispose(); // don't forget about me!
            return scaled;
        } catch (Exception exception) {

        }
        return null;
    }
}
