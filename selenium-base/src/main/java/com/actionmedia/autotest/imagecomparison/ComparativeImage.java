package com.actionmedia.autotest.imagecomparison;

import java.awt.image.BufferedImage;

/**
 * User: n.tyukavkin
 * Date: 24.07.2014
 * Time: 21:25
 */
public class ComparativeImage {

    private double pixelContradictions;

    private double areaContradictions;

    public void setMaskImage(final BufferedImage maskImage) {
        this.maskImage = maskImage;
    }

    private BufferedImage maskImage;

    public void setPixelContradictions(final double pixelContradictions) {
        this.pixelContradictions = pixelContradictions;
    }

    public double getPixelContradictions() {
        return pixelContradictions;
    }

    public BufferedImage getMaskImage() {
        return maskImage;
    }

    public void setAreaContradictions(final double areaContradictions) {
        this.areaContradictions = areaContradictions;
    }

    public double getAreaContradictions() {
        return areaContradictions;
    }
}
