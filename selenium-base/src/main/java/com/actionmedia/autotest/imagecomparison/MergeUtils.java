package com.actionmedia.autotest.imagecomparison;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;

import javax.annotation.Nullable;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

import static java.io.File.separator;
import static java.lang.String.format;
import static javax.imageio.ImageIO.write;

/**
 * User: n.tyukavkin
 * Date: 24.07.2014
 * Time: 21:25
 */
public class MergeUtils {

    private static final int ACCURACY = 10;
    private static final float WIDTH = 2F;

    public static void writeDiff(final String directory, final String name, final BufferedImage actualImage, final ComparativeImage comparativeImage) {
        final String pathName = directory + separator + name;
//        writePng(actualImage, pathName);

        final Graphics2D graphics = actualImage.createGraphics();
        final BufferedImage maskImage = comparativeImage.getMaskImage();

        final Collection<Rectangle> unionRectangles = getUnionRectangles(maskImage);
        for (final Rectangle rectangle : unionRectangles) {
            graphics.setColor(Color.RED);
            graphics.setStroke(new BasicStroke(WIDTH));
            graphics.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        }

        writePng(actualImage, pathName + "_diff");

        writePng(comparativeImage.getMaskImage(), pathName + "_mask");
    }

    private static Collection<Rectangle> getUnionRectangles(final BufferedImage maskImage) {
        final BorderFinder borderFinder = new BorderFinder();

        final Collection<IContour> contours = borderFinder.find(maskImage);

        final Collection<Rectangle> rectangles = Collections2.transform(contours, new Function<IContour, Rectangle>() {
            @Override
            @Nullable
            public Rectangle apply(@Nullable final IContour contour) {
                assert contour != null;
                return contour.getRectangle();

            }
        });

        return borderFinder.unionRectangles(rectangles, ACCURACY);
    }

    public static double getDiffArea(final BufferedImage maskImage) {
        double diffArea = 0.0;
        for (final Rectangle rectangle : getUnionRectangles(maskImage)) {
            diffArea += rectangle.getHeight() * rectangle.getWidth();
        }

        return diffArea;
    }

    public static void writePng(final BufferedImage image, final String pathName) {
        try {
            write(image, "PNG", new File(format("%s.png", pathName)));
        } catch (IOException ignored) {
        }
    }
}
