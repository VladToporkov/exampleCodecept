package com.actionmedia.autotest.imagecomparison;

import java.awt.*;
import java.awt.image.BufferedImage;

import static java.awt.Color.BLACK;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;
import static java.lang.Math.*;

/**
 * User: n.tyukavkin
 * Date: 24.07.2014
 * Time: 21:25
 */
public class ImageMerger implements IImageMerger {

    private static final int DIFF_BRIGHTNESS_THRESHOLD = 250;

    @Override
    public ComparativeImage compare(BufferedImage image1, BufferedImage image2) {

//        if (image1.getHeight() > image2.getHeight()) {
//            image1 = image1.getSubimage(0, image1.getHeight() - image2.getHeight(), image2.getWidth(), image2.getHeight());
//        }
//
//        if (image2.getHeight() > image1.getHeight()) {
//            image1 = image1.getSubimage(0, image2.getHeight() - image1.getHeight(), image1.getWidth(), image1.getHeight());
//        }

        return calcContradictions(image1, image2);
    }

    private void assertImageSizes(final BufferedImage image1, final BufferedImage image2) {
        assert (image1.getWidth() == image2.getWidth());
        assert (image1.getHeight() == image2.getHeight());
    }

    private ComparativeImage calcContradictions(final BufferedImage image1, final BufferedImage image2) {
        final int width = image1.getWidth();
        final int height = image1.getHeight();
        final ComparativeImage result = new ComparativeImage();
        final BufferedImage maskImage = emptyImage(width, height);
        int differentPixelsCount = 0;
        for (int y = 0; y < height; y++) {

            for (int x = 0; x < width; x++) {
                try {
                    if (abs(image1.getRGB(x, y) - image2.getRGB(x, y)) > 0) {
                        final Color firstPointColor = new Color(image1.getRGB(x, y));
                        final Color secondPointColor = new Color(image2.getRGB(x, y));
                        final int diffRed = abs(firstPointColor.getRed() - secondPointColor.getRed());
                        final int diffGreen = abs(firstPointColor.getGreen() - secondPointColor.getGreen());
                        final int diffBlue = abs(firstPointColor.getBlue() - secondPointColor.getBlue());
                        final double diff = sqrt(pow(diffRed, 2) + pow(diffGreen, 2) + pow(diffBlue, 2));

                        final double diffDegreeRB = asin(diffRed / (sqrt(pow(diffRed, 2) + pow(diffBlue, 2)))) * (180 / PI);
                        final double diffDegreeRG = asin(diffRed / (sqrt(pow(diffRed, 2) + pow(diffGreen, 2)))) * (180 / PI);

                        if (diff > DIFF_BRIGHTNESS_THRESHOLD || abs(diffDegreeRB - 45) > 1 || abs(diffDegreeRG - 45) > 1) {
                            differentPixelsCount++;
                            maskImage.setRGB(x, y, BLACK.getRGB());
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) {
                    break;
                } catch (NullPointerException ignored) {
                    break;
                }
            }

        }

        double pixelContradictions = 0.0;
        double areaContradictions = 0.0;
        if (differentPixelsCount > 0) {
            final int imgArea = width * height;
            pixelContradictions = round(((double) differentPixelsCount / imgArea) * 100);
            areaContradictions = Math.round((MergeUtils.getDiffArea(maskImage) / imgArea) * 100);
        }

        result.setPixelContradictions(pixelContradictions);
        result.setAreaContradictions(areaContradictions);
        result.setMaskImage(maskImage);
        return result;
    }

    private BufferedImage emptyImage(final int width, final int height) {
        final BufferedImage maskImage = new BufferedImage(width, height, TYPE_INT_RGB);
        final Graphics2D graphics = maskImage.createGraphics();
        graphics.setBackground(Color.WHITE);
        graphics.clearRect(0, 0, width, height);
        return maskImage;
    }

}
