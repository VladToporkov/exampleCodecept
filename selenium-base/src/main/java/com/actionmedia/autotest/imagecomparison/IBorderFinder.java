package com.actionmedia.autotest.imagecomparison;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Collection;

/**
 * User: n.tyukavkin
 * Date: 24.07.2014
 * Time: 21:26
 */
public interface IBorderFinder {

    Collection<IContour> find(BufferedImage image);

    Collection<Rectangle> unionRectangles(Collection<Rectangle> rectangles, final int accuracy);
}
