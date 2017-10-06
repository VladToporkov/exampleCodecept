package com.actionmedia.autotest.imagecomparison;

import java.awt.image.BufferedImage;

/**
 * User: n.tyukavkin
 * Date: 24.07.2014
 * Time: 21:26
 */
public interface IImageMerger {

    ComparativeImage compare(BufferedImage image1, BufferedImage image2);
}
