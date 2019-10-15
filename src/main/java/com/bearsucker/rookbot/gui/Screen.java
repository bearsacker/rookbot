package com.bearsucker.rookbot.gui;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class Screen {

    public static Screen INSTANCE = new Screen();

    private Robot robot;

    private BufferedImage image;

    private Rectangle rectangle;

    private Screen() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
    }

    public static Screen get() {
        return INSTANCE;
    }

    public void update() {
        image = robot.createScreenCapture(rectangle);
    }

    public Color getPixel(int x, int y) {
        return new Color(image.getRGB(x, y));
    }

    public int getWidth() {
        return rectangle.width;
    }

    public int getHeight() {
        return rectangle.height;
    }
}
