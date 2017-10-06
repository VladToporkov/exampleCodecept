package com.actionmedia.components;

/**
 * User: n.tyukavkin
 * Date: 23.09.13
 * Time: 12:23
 */
public class Size {

    public Size(String width, String height) {
        this.width = Integer.parseInt(width.split("px")[0]);
        this.height = Integer.parseInt(height.split("px")[0]);
    }

    private int width;
    private int height;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
