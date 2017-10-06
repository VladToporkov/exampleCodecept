package com.actionmedia.tests.services.comparesearchresults;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.*;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.events.TestCaseEvent;
import ru.yandex.qatools.allure.model.Label;
import ru.yandex.qatools.allure.model.LabelName;
import ru.yandex.qatools.allure.model.TestCaseResult;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 08.06.2014
 * Time: 12:55
 */
public class AllureAnnotationsListener implements ITestListener {

    private Allure lifecycle = Allure.LIFECYCLE;

    @Override
    public void onTestStart(ITestResult result) {
        final List<Label> labelList = new ArrayList<Label>();

        Object[] parameters = result.getParameters();

        labelList.add(new Label().withName(LabelName.STORY.value()).withValue(String.valueOf(parameters[0])));

        String methodName = result.getName();

        if (methodName.toLowerCase().contains("itemfound")) {
            labelList.add(new Label().withName(LabelName.FEATURE.value()).withValue("Результаты выдачи - количество и содержание"));
        }

        if (methodName.contains("checkFirst10Relevance")) {
            labelList.add(new Label().withName(LabelName.FEATURE.value()).withValue("Релевантность найденных результатов"));
        }

        if (methodName.equals("wizards")) {
            labelList.add(new Label().withName(LabelName.FEATURE.value()).withValue("Колдунщики - количество и содержание"));
        }

        if (methodName.equals("wizardsCount")) {
            labelList.add(new Label().withName(LabelName.FEATURE.value()).withValue("Колдунщики - количество документов"));
        }

        if (methodName.equals("wizardsType")) {
            labelList.add(new Label().withName(LabelName.FEATURE.value()).withValue("Колдунщики - тип"));
        }

        if (methodName.equals("factoid")) {
            labelList.add(new Label().withName(LabelName.FEATURE.value()).withValue("Фактоиды - количество и содержание"));
        }

        if (methodName.equals("yellowDieTag")) {
            labelList.add(new Label().withName(LabelName.FEATURE.value()).withValue("Зелёный шильдик популярного"));
        }

        if (methodName.equals("lowRelevance")) {
            labelList.add(new Label().withName(LabelName.FEATURE.value()).withValue("Обрезание поисковой выдачи"));
        }

        if (methodName.equals("searchTag")) {
            labelList.add(new Label().withName(LabelName.FEATURE.value()).withValue("Теги"));
        }

        lifecycle.fire(new TestCaseEvent() {
            @Override
            public void process(TestCaseResult testCaseResult) {
                testCaseResult.setLabels(labelList);
            }
        });
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    }

    @Override
    public void onTestFailure(ITestResult result) {
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
        try {
            XSSFWorkbook xWorkbook = new XSSFWorkbook();

            XSSFCellStyle style = xWorkbook.createCellStyle();
            XSSFFont font = xWorkbook.createFont();
            font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
            style.setFont(font);
            style.setAlignment(CellStyle.ALIGN_CENTER);

            XSSFSheet paramsSheet = xWorkbook.createSheet("Параметры");

            XSSFRow standardUrlRow = paramsSheet.createRow(0);
            XSSFCell standardUrlCell = standardUrlRow.createCell(0);
            standardUrlCell.setCellStyle(style);
            standardUrlCell.setCellValue("STANDARD_URL");
            XSSFCell standardUrlValueCell = standardUrlRow.createCell(1);
            standardUrlValueCell.setCellStyle(style);
            standardUrlValueCell.setCellValue(System.getenv("STANDARD_URL"));

            XSSFRow testUrlRow = paramsSheet.createRow(1);
            XSSFCell testUrlCell = testUrlRow.createCell(0);
            testUrlCell.setCellStyle(style);
            testUrlCell.setCellValue("TEST_URL");
            XSSFCell testUrlValueCell = testUrlRow.createCell(1);
            testUrlValueCell.setCellStyle(style);
            testUrlValueCell.setCellValue(System.getenv("TEST_URL"));

            XSSFRow pubIdRow = paramsSheet.createRow(2);
            XSSFCell pubIdCell = pubIdRow.createCell(0);
            pubIdCell.setCellStyle(style);
            pubIdCell.setCellValue("PUB_ID");
            XSSFCell pubIdValueCell = pubIdRow.createCell(1);
            pubIdValueCell.setCellStyle(style);
            pubIdValueCell.setCellValue(System.getenv("PUB_ID"));

            XSSFRow allTestRow = paramsSheet.createRow(3);
            XSSFCell allTestCell = allTestRow.createCell(0);
            allTestCell.setCellStyle(style);
            allTestCell.setCellValue("Количество всех тестов");
            XSSFCell allTestValueCell = allTestRow.createCell(1);
            allTestValueCell.setCellStyle(style);
            allTestValueCell.setCellValue((context.getPassedTests().size() + context.getFailedTests().size()));

            XSSFRow passTestRow = paramsSheet.createRow(4);
            XSSFCell passTestCell = passTestRow.createCell(0);
            passTestCell.setCellStyle(style);
            passTestCell.setCellValue("Количество пройденных тестов");
            XSSFCell passTestValueCell = passTestRow.createCell(1);
            passTestValueCell.setCellStyle(style);
            passTestValueCell.setCellValue(context.getPassedTests().size());

            XSSFRow failTestRow = paramsSheet.createRow(5);
            XSSFCell failTestCell = failTestRow.createCell(0);
            failTestCell.setCellStyle(style);
            failTestCell.setCellValue("Количество упавших тестов");
            XSSFCell failTestValueCell = failTestRow.createCell(1);
            failTestValueCell.setCellStyle(style);
            failTestValueCell.setCellValue(context.getFailedTests().size());

            XSSFSheet testsSheet = xWorkbook.createSheet("Тесты");
            XSSFRow firstRow = testsSheet.createRow(0);

            XSSFCell queryCellTitle = firstRow.createCell(0);
            queryCellTitle.setCellStyle(style);
            queryCellTitle.setCellValue("Поисковый запрос");

            XSSFCell nameCellTitle = firstRow.createCell(1);
            nameCellTitle.setCellStyle(style);
            nameCellTitle.setCellValue("Название теста");

            XSSFCell resultCellTitle = firstRow.createCell(2);
            resultCellTitle.setCellStyle(style);
            resultCellTitle.setCellValue("Результат проверки");

            int indexRow = 1;
            for (ITestResult testResult : context.getPassedTests().getAllResults()) {
                String methodName = testResult.getMethod().getMethodName();
                Object[] parameters = testResult.getParameters();
                String query = String.valueOf(parameters[0]);
                XSSFRow row = testsSheet.createRow(indexRow);

                row.createCell(0).setCellValue(query);
                row.createCell(1).setCellValue(getCheckNameByMethodName(methodName));
                row.createCell(2).setCellValue(1);
                indexRow++;
            }

            for (ITestResult testResult : context.getFailedTests().getAllResults()) {
                String methodName = testResult.getMethod().getMethodName();
                Object[] parameters = testResult.getParameters();
                String query = String.valueOf(parameters[0]);
                XSSFRow row = testsSheet.createRow(indexRow);

                row.createCell(0).setCellValue(query);
                row.createCell(1).setCellValue(getCheckNameByMethodName(methodName));
                row.createCell(2).setCellValue(0);
                indexRow++;
            }

            String path = "C:\\Jenkins\\userContent\\";
            DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("YYYY_MM_dd_HH_mm_ss");
            String dateString = new DateTime().toString(dateTimeFormatter);
            String fileName = "build_" + System.getenv("BUILD_ID") + "_" + dateString + ".xlsx";
            String filePath = path + fileName;

            FileOutputStream outFile = new FileOutputStream(new File(filePath));
            xWorkbook.write(outFile);
            outFile.close();

            createAllureEnvironmentFile(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createAllureEnvironmentFile(String fileName) {
        try {
            String path = "C:\\Jenkins\\jobs\\compare_search_services\\workspace\\am-selenium-tests\\target\\allure-results\\environment.properties";
            File propertiesFile = new File(path);
            if (!propertiesFile.exists()) {
                propertiesFile.createNewFile();
            }
            PrintWriter writer = new PrintWriter(path, "UTF-8");
            writer.println("REPORT_FILE_URL=" + System.getenv("JENKINS_URL") + "userContent/" + fileName);
            writer.close();
        } catch (IOException e) {
            System.out.println("***IOException***" + e.getMessage());
        }
    }

    private String getCheckNameByMethodName(String methodName) {
        if (methodName.toLowerCase().contains("itemfound")) {
            return "Результаты выдачи - количество и содержание";
        }

        if (methodName.contains("checkFirst10Relevance")) {
            return "Релевантность найденных результатов";
        }

        if (methodName.equals("wizards")) {
            return "Колдунщики - количество и содержание";
        }

        if (methodName.equals("wizardsCount")) {
            return "Колдунщики - количество документов";
        }

        if (methodName.equals("wizardsType")) {
            return "Колдунщики - тип";
        }

        if (methodName.equals("factoid")) {
            return "Фактоиды - количество и содержание";
        }

        if (methodName.equals("yellowDieTag")) {
            return "Зелёный шильдик популярного";
        }

        if (methodName.equals("lowRelevance")) {
            return "Обрезание поисковой выдачи";
        }

        if (methodName.equals("searchTag")) {
            return "Теги";
        }

        return "undefined";
    }
}
