package com.actionmedia.tests.experimental.loadsitetests;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 07.12.2014
 * Time: 19:16
 */
public class Utils {

    private Utils() {
    }

    private static final String FILE_NAME = "load_site_results.xlsx";

    public static void writeToFile(List<RunResult> runResultList) {
        try {
            File tempFile = new File(FILE_NAME);
            if (!tempFile.exists()) {
                FileOutputStream tempOut = new FileOutputStream(new File(FILE_NAME));
                XSSFWorkbook workbook = new XSSFWorkbook();
                workbook.write(tempOut);
                tempOut.close();
            }
            FileInputStream file = new FileInputStream(new File(FILE_NAME));
            XSSFWorkbook xWorkbook = new XSSFWorkbook(file);

            XSSFSheet sheet;
            String sheetName = new DateTime().toString("yyy-MM-dd");
            if (xWorkbook.getSheet(sheetName) != null) {
                sheet = xWorkbook.getSheet(sheetName);
            } else {
                sheet = xWorkbook.createSheet(sheetName);
                XSSFRow firstRow = sheet.createRow(0);

                XSSFFont font = xWorkbook.createFont();
                font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
                XSSFCellStyle style = xWorkbook.createCellStyle();
                style.setFont(font);

                Cell urlCell = firstRow.createCell(0);
                urlCell.setCellStyle(style);
                urlCell.setCellValue("Урл");

                Cell startTimeCell = firstRow.createCell(1);
                startTimeCell.setCellStyle(style);
                startTimeCell.setCellValue("Время старта");

                Cell timeCell = firstRow.createCell(2);
                timeCell.setCellStyle(style);
                timeCell.setCellValue("Время отклика, c");
            }

            int i = sheet.getPhysicalNumberOfRows() + 1;
            for (int index = 0; index < runResultList.size(); index++) {
                try {
                    RunResult runResult = runResultList.get(index);
                    XSSFRow row = sheet.createRow(index + i);
                    row.createCell(0).setCellValue(runResult.getUrl());
                    row.createCell(1).setCellValue(runResult.getStartTime().toString(DateTimeFormat.forPattern("HH:mm:ss")));
                    row.createCell(2).setCellValue(runResult.getTime());
                    if (runResult.getErrorMessage() != null && !runResult.getErrorMessage().isEmpty()) {
                        row.createCell(2).setCellValue(runResult.getErrorMessage());
                    }
                } catch (Throwable ignored) {
                    report("Ошибка при записи файла - " + FILE_NAME + ", строка - " + (index + 1) + ", текст ошибки: " + ignored.getMessage());
                    continue;
                }
            }
            XSSFRow row = sheet.createRow(sheet.getPhysicalNumberOfRows() + 1);
            row.createCell(0).setCellValue("");
            file.close();
            FileOutputStream outFile = new FileOutputStream(new File(FILE_NAME));
            xWorkbook.write(outFile);
            outFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void report(String report) {
        System.out.println(report);
    }
}
