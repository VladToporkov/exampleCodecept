package com.actionmedia.tests.experimental;

import com.actionmedia.autotest.imagecomparison.ComparativeImage;
import com.actionmedia.autotest.imagecomparison.IImageMerger;
import com.actionmedia.autotest.imagecomparison.ImageMerger;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.io.File.separator;
import static java.lang.String.format;
import static javax.imageio.ImageIO.write;
import static org.testng.Assert.assertNotNull;

/**
 * User: n.tyukavkin
 * Date: 17.08.2014
 * Time: 17:30
 */
public class CompareImagesTest extends ImagesComparisonExperiment {

    @Test
    public void testCompareImages() throws IOException {
        File resultFolder = new File(getResultFolder());
        resultFolder.mkdir();

        File beforeFolder = new File(getBeforeFolder());
        File[] beforeImages = beforeFolder.listFiles();

        assertNotNull(beforeImages, "Can't find png files in " + getBeforeFolder() + " folder");

        for (File beforeImage : beforeImages) {
            if (!beforeImage.getAbsolutePath().endsWith(".png")) {
                continue;
            }

            String imageName = beforeImage.getName();
            BufferedImage imageBefore = null;
            BufferedImage imageAfter = null;
            try {
                imageBefore = ImageIO.read(beforeImage);
                imageAfter = ImageIO.read(new File(getAfterFolder() + "\\" + imageName));
            } catch (IOException ignored) {
            }

            IImageMerger imageMerger = new ImageMerger();
            final ComparativeImage comparativeImage = imageMerger.compare(imageBefore, imageAfter);
            if (comparativeImage.getPixelContradictions() > 0 || comparativeImage.getAreaContradictions() > 0) {

                write(comparativeImage.getMaskImage(), "PNG", new File(format("%s.png", getResultFolder() + separator + imageName + "_mask")));

                BufferedImage mergeHorizontal = joinHorizontal(imageBefore, imageAfter, 10);
                write(mergeHorizontal, "PNG", new File(format("%s.png", getResultFolder() + separator + imageName + "_merge")));

                BufferedImage mergeVertical = joinHorizontal(imageBefore, imageAfter, imageBefore.getWidth() - 1);
                write(mergeVertical, "PNG", new File(format("%s.png", getResultFolder() + separator + imageName + "_diff")));
            }
        }
    }
}
