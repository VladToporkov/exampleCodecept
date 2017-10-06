package com.actionmedia.tests.functional.bss.kbk;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.components.KbkTable;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 18.08.2014
 * Time: 21:43
 */
public class KBKBaseTest extends AbstractDomainTest {

    @Test
    @LoginAs(key = "bss.user.commercial")
    public void test() {
        List<KbkTable> kbkList = getKbkList();

        loginBss()
                .navigateToDictionaryPage()
                .clickKBKService()
                .checkKBK(kbkList)
                .logout();
    }

    private List<KbkTable> getKbkList() {
        List<KbkTable> kbkList = new ArrayList<KbkTable>();

        String fileName = "C:\\kbk.xlsx";

        try {
            FileInputStream file = new FileInputStream(new File(fileName));

            if (fileName.endsWith(".xlsx")) {
                XSSFWorkbook xWorkbook = new XSSFWorkbook(file);
                XSSFSheet sheet = xWorkbook.getSheetAt(0);
                for (int rowNumber = 1; rowNumber < sheet.getPhysicalNumberOfRows(); rowNumber++) {
                    XSSFRow row = sheet.getRow(rowNumber);

                    String code = row.getCell(1).getStringCellValue();
                    Double idPayment = row.getCell(2).getNumericCellValue();
                    boolean isTax = row.getCell(3).getNumericCellValue() == 1.0;
                    boolean isPenalties = row.getCell(4).getNumericCellValue() == 1.0;
                    boolean isFine = row.getCell(5).getNumericCellValue() == 1.0;

                    KbkTable kbk = new KbkTable(code, idPayment.intValue(), isTax, isPenalties, isFine);
                    kbkList.add(kbk);
                }
            } else {
                HSSFWorkbook workbook = new HSSFWorkbook(file);
                HSSFSheet sheet = workbook.getSheetAt(0);
                for (int rowNumber = 1; rowNumber < sheet.getPhysicalNumberOfRows(); rowNumber++) {
                    HSSFRow row = sheet.getRow(rowNumber);

                    String code = row.getCell(1).getStringCellValue();
                    Double idPayment = row.getCell(2).getNumericCellValue();
                    boolean isTax = row.getCell(3).getNumericCellValue() == 1.0;
                    boolean isPenalties = row.getCell(4).getNumericCellValue() == 1.0;
                    boolean isFine = row.getCell(5).getNumericCellValue() == 1.0;

                    KbkTable kbk = new KbkTable(code, idPayment.intValue(), isTax, isPenalties, isFine);
                    kbkList.add(kbk);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return kbkList;
    }
}
