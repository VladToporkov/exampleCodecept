package com.actionmedia.tests.experimental;

import com.actionmedia.base.AbstractDomainTest;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.io.File.separator;

/**
 * User: n.tyukavkin
 * Date: 24.07.2014
 * Time: 21:28
 */
public class ImagesComparisonExperiment extends AbstractDomainTest {

    protected static final String FOLDER = "C:\\CompareImage";
    protected static final String BEFORE_FOLDER = "before";
    protected static final String AFTER_FOLDER = "after";
    protected static final String RESULT_FOLDER = "result";

    protected String getBeforeFolder() {
        String folder = getSettings().getFileName().split(".xls")[0];
        return FOLDER + separator + folder + separator + BEFORE_FOLDER;
    }

    protected String getAfterFolder() {
        String folder = getSettings().getFileName().split(".xls")[0];
        return FOLDER + separator + folder + separator + AFTER_FOLDER;
    }

    protected String getResultFolder() {
        String folder = getSettings().getFileName().split(".xls")[0];
        return FOLDER + separator + folder + separator + RESULT_FOLDER;
    }

    public static BufferedImage joinHorizontal(BufferedImage i1, BufferedImage i2, int mergeWidth) {
//        if (i1.getHeight() != i2.getHeight()) {
//            throw new IllegalArgumentException("Images i1 and i2 are not the same height");
//        }

        BufferedImage imgClone = new BufferedImage(mergeWidth, i2.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D cloneG = imgClone.createGraphics();
        cloneG.drawImage(i2, 0, 0, null);
        cloneG.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN, 0.6f));
        cloneG.drawImage(i2, 0, 0, null);

        BufferedImage result = new BufferedImage(i1.getWidth() + i2.getWidth() - mergeWidth, i1.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = result.createGraphics();
        g.drawImage(i1, 0, 0, null);
        g.drawImage(i2.getSubimage(mergeWidth, 0, i2.getWidth() - mergeWidth, i2.getHeight()), i1.getWidth(), 0, null);
        g.drawImage(imgClone, i1.getWidth() - mergeWidth, 0, null);

        return result;
    }

    public static BufferedImage joinVertical(BufferedImage i1, BufferedImage i2, int mergeWidth) {
//        if (i1.getWidth() != i2.getWidth()) {
//            throw new IllegalArgumentException("Images i1 and i2 are not the same width");
//        }

        BufferedImage imgClone = new BufferedImage(i2.getWidth(), mergeWidth, BufferedImage.TYPE_INT_ARGB);
        Graphics2D cloneG = imgClone.createGraphics();
        cloneG.drawImage(i2, 0, 0, null);
        cloneG.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN, 0.5f));
        cloneG.drawImage(i2, 0, 0, null);

        BufferedImage result = new BufferedImage(i1.getWidth(),
                i1.getHeight() + i2.getHeight() - mergeWidth, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = result.createGraphics();
        g.drawImage(i1, 0, 0, null);
        g.drawImage(i2.getSubimage(0, mergeWidth, i2.getWidth(),
                i2.getHeight() - mergeWidth), 0, i1.getHeight(), null);
        g.drawImage(imgClone, 0, i1.getHeight() - mergeWidth, null);

        return result;
    }

    protected List<Doc> getDocList(boolean isProduction) {
        List<Doc> docList = new ArrayList<Doc>();
        try {
            String pathname = FOLDER + separator + getSettings().getFileName();
            FileInputStream file = new FileInputStream(new File(pathname));

            if (pathname.endsWith(".xlsx")) {
                XSSFWorkbook xWorkbook = new XSSFWorkbook(file);
                XSSFSheet sheet = xWorkbook.getSheetAt(0);
                for (int rowNumber = 1; rowNumber < sheet.getPhysicalNumberOfRows(); rowNumber++) {
                    XSSFRow row = sheet.getRow(rowNumber);

                    Doc doc = new Doc(String.valueOf(row.getCell(1).getNumericCellValue()).split("\\.")[0], isProduction ? row.getCell(3).toString() : row.getCell(2).toString(), isProduction);
                    docList.add(doc);
                }
            } else {
                HSSFWorkbook workbook = new HSSFWorkbook(file);
                HSSFSheet sheet = workbook.getSheetAt(0);
                for (int rowNumber = 1; rowNumber < sheet.getPhysicalNumberOfRows(); rowNumber++) {
                    HSSFRow row = sheet.getRow(rowNumber);

                    Doc doc = new Doc(String.valueOf(row.getCell(1).getNumericCellValue()).split("\\.")[0], isProduction ? row.getCell(3).toString() : row.getCell(2).toString(), isProduction);
                    docList.add(doc);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return docList;
    }

    class Doc {
        private String docId;
        private int[] pubIdArr;
        private int[] pubProdIdArr;

        Doc(String docId, String pubIdArr, boolean isProduction) {
            this.docId = docId;
            if (isProduction) {
                this.pubProdIdArr = getIntArrFromString(pubIdArr);
            } else {
                this.pubIdArr = getIntArrFromString(pubIdArr);
            }
        }

        public String getDocId() {
            return docId;
        }

        public int[] getPubIdArr() {
            return pubIdArr;
        }

        public int[] getPubProdIdArr() {
            return pubProdIdArr;
        }

        private int[] getIntArrFromString(String text) {
            String[] textArrTemp = text.split("\\W");
            List<Integer> intArrTemp = new ArrayList<Integer>();
            for (String arr : textArrTemp) {
                try {
                    int id = Integer.parseInt(arr);
                    if (id != 0) {
                        intArrTemp.add(id);
                    }
                } catch (NumberFormatException ignored) {
                }
            }

            int[] intArr = new int[intArrTemp.size()];
            for (int i = 0; i < intArrTemp.size(); i++) {
                intArr[i] = intArrTemp.get(i);
            }

            return intArr;
        }
    }
}
