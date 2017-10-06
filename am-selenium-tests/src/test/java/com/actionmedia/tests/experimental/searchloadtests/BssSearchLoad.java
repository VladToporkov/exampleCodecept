package com.actionmedia.tests.experimental.searchloadtests;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.bss.BssBasePage;
import com.actionmedia.pages.konsultantplus.KonsultantPlusBasePage;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.joda.time.DateTime;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 07.09.2014
 * Time: 18:21
 */
public class BssSearchLoad extends AbstractDomainTest {

    private static final String FILE_NAME = "searchStats.xls";
    private static final int ITERATION = 10;
    private DateTime bssStartTime;
    private DateTime bssEndTime;
    private static final String[] searchQueryArray = new String[]{
            "амортизационные групп основных средств",
            "вычет ндс",
            "единовременное пособие при рождении ребенка",
            "кбк 2014",
            "классификация основных средств, включаемых в амортизационные группы",
            "налоговый кодекс",
            "ндс",
            "оквэд",
            "пбу",
            "предельная величина базы для начисления страховых взносов",
            "производственный календарь 2014",
            "размер штрафа за несвоевременную сдачу отчетности",
            "расписка о получении тк",
            "расчет компенсация за неиспользованный отпуск при увольнении",
            "сведения о среднесписочной численности сотрудников",
            "сообщение об открытии (закрытии) расчетного счета",
            "среднесписочная численность сотрудников",
            "транспортный налог",
            "учетная политика для целей налогообложения",
            "учетная политика на 2014 год"
    };

    private List<SearchResult> recomendSearchResultList = new ArrayList<SearchResult>();
    private List<SearchResult> lawBaseSearchResultList = new ArrayList<SearchResult>();

    private List<SearchResult> konsultantSearchResultList = new ArrayList<SearchResult>();
    private List<SearchResult> konsultantFullSearchResultList = new ArrayList<SearchResult>();

    @Test(priority = 0)
    public void konsultant_test() {
        KonsultantPlusBasePage konsultant = loginToKonsultantPlus("https://online.consultant.ru/", "750526", "VS50SaJm");
        for (int count = 1; count <= ITERATION; count++) {
            for (String query : searchQueryArray) {

                konsultant
                        .clickQuickSearchButton()
                        .inputTextInSearchFieldInKonsultant(query);

                bssStartTime = new DateTime();

                konsultant
                        .clickSearchButtonInKonsultant()
                        .waitForSearchResult();

                bssEndTime = new DateTime();

                SearchResult searchResult = new SearchResult(query, bssStartTime, bssEndTime, count);
                konsultantSearchResultList.add(searchResult);

                bssStartTime = new DateTime();

                konsultant
                        .clickFullSearchButton()
                        .waitForFullSearchResult();

                bssEndTime = new DateTime();

                SearchResult fullSearchResult = new SearchResult(query, bssStartTime, bssEndTime, count);
                konsultantFullSearchResultList.add(fullSearchResult);
            }
        }
    }

    @Test(priority = 1)
    @LoginAs(key = "bss.user.commercial")
    public void bss_test() {
        BssBasePage basePage = loginBss();

        for (int count = 1; count <= ITERATION; count++) {
            for (String query : searchQueryArray) {
                basePage
                        .navigateToRecomendPage()
                        .inputTextInSearchBox(query);

                bssStartTime = new DateTime();

                basePage
                        .clickSearchButtonAndNavigateToSearchResultPage()
                        .waitForSearchResult();

                bssEndTime = new DateTime();

                SearchResult searchResult = new SearchResult(query, bssStartTime, bssEndTime, count);
                recomendSearchResultList.add(searchResult);
            }
        }

        for (int count = 1; count <= ITERATION; count++) {
            for (String query : searchQueryArray) {
                basePage
                        .navigateToLawBasePage()
                        .inputTextInSearchBox(query);

                bssStartTime = new DateTime();

                basePage
                        .clickSearchButtonAndNavigateToSearchResultPage()
                        .waitForSearchResult();

                bssEndTime = new DateTime();

                SearchResult searchResult = new SearchResult(query, bssStartTime, bssEndTime, count);
                lawBaseSearchResultList.add(searchResult);
            }
        }
    }

    @AfterSuite
    public void writeResult() {
        writeToFile();
    }

    protected void writeToFile() {
        File tempFile = new File(FILE_NAME);
        try {
            if (!tempFile.exists()) {
                FileOutputStream tempOut = new FileOutputStream(new File(FILE_NAME));
                HSSFWorkbook workbook = new HSSFWorkbook();
                workbook.write(tempOut);
                tempOut.close();
            }
            FileInputStream file = new FileInputStream(new File(FILE_NAME));

            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFSheet sheet = workbook.createSheet(new DateTime().toString("yyy-MM-dd HH-mm-ss"));

            HSSFFont font = workbook.createFont();
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            HSSFCellStyle style = workbook.createCellStyle();
            style.setFont(font);

            HSSFRow firstRow = sheet.createRow(0);
            Cell cell = firstRow.createCell(0);
            cell.setCellStyle(style);
            cell.setCellValue("Запрос");

            for (int i = 1; i <= ITERATION; i++) {
                Cell cellCount = firstRow.createCell(i);
                cellCount.setCellStyle(style);
                cellCount.setCellValue(i);
            }

            cell = firstRow.createCell(ITERATION + 1);
            cell.setCellStyle(style);
            cell.setCellValue("Среднее");

            cell = firstRow.createCell(ITERATION + 2);
            cell.setCellStyle(style);
            cell.setCellValue("Min");

            cell = firstRow.createCell(ITERATION + 3);
            cell.setCellStyle(style);
            cell.setCellValue("Max");

            writeForSection(sheet, style, recomendSearchResultList, 1, "БСС КУ: Рекомендации");

            writeForSection(sheet, style, lawBaseSearchResultList, searchQueryArray.length + 4, "БСС КУ: Правовая База");

            writeForSection(sheet, style, konsultantSearchResultList, (searchQueryArray.length + 4) * 2, "Онлайн-версия системы КонсультантПлюс - 'быстрый поиск'");

            writeForSection(sheet, style, konsultantFullSearchResultList, (searchQueryArray.length + 4) * 3, "Онлайн-версия системы КонсультантПлюс - 'построить полный список'");

            file.close();
            FileOutputStream outFile = new FileOutputStream(new File(FILE_NAME));
            workbook.write(outFile);
            outFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeForSection(HSSFSheet sheet, HSSFCellStyle style, List<SearchResult> expectedResultList, int firstRowIndex, String resultName) {
        HSSFRow recomendRow = sheet.createRow(firstRowIndex);
        Cell recomendСell = recomendRow.createCell(0);
        recomendСell.setCellStyle(style);
        recomendСell.setCellValue(resultName);

        for (int i = 0; i < searchQueryArray.length; i++) {
            String query = searchQueryArray[i];

            HSSFRow queryRow = sheet.createRow(i + firstRowIndex + 1);
            Cell queryCell = queryRow.createCell(0);
            queryCell.setCellValue(query);

            List<SearchResult> searchResultList = getSearchResultListByQuery(query, expectedResultList);

            double avgTime = 0;
            double minTime = searchResultList.get(0).getTime();
            double maxTime = searchResultList.get(0).getTime();
            for (SearchResult searchResult : searchResultList) {
                double time = searchResult.getTime();
                avgTime += time;

                if (time < minTime) {
                    minTime = time;
                }

                if (time > maxTime) {
                    maxTime = time;
                }

                Cell iterationResultCell = queryRow.createCell(searchResult.getIteration());
                iterationResultCell.setCellValue(time);
            }

            Cell avgCell = queryRow.createCell(ITERATION + 1);
            avgCell.setCellValue(avgTime / searchResultList.size());

            Cell minCell = queryRow.createCell(ITERATION + 2);
            minCell.setCellValue(minTime);

            Cell maxCell = queryRow.createCell(ITERATION + 3);
            maxCell.setCellValue(maxTime);
        }
    }

    private List<SearchResult> getSearchResultListByQuery(String query, List<SearchResult> searchResultList) {
        List<SearchResult> resultList = new ArrayList<SearchResult>();
        for (SearchResult searchResult : searchResultList) {
            if (searchResult.getQuery().equals(query)) {
                resultList.add(searchResult);
            }
        }
        return resultList;
    }

    private class SearchResult {
        String query;
        DateTime startTime;
        DateTime endTime;
        int iteration;
        private double time;

        public SearchResult(String query, DateTime startTime, DateTime endTime, int iteration) {
            this.query = query;
            this.startTime = startTime;
            this.endTime = endTime;
            this.iteration = iteration;
            this.time = (double) (endTime.getMillis() - startTime.getMillis()) / 1000;
        }

        public String getQuery() {
            return query;
        }

        public int getIteration() {
            return iteration;
        }

        public double getTime() {
            return time;
        }
    }
}
