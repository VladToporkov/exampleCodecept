package com.actionmedia.tests.functional.loadtests;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.joda.time.DateTime;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

public class LoadTestsBase {

    private static final String FILE_NAME = "stats.xls";
    private Map<String, List<RunResult>> mapStat = new HashMap<String, List<RunResult>>();
    protected DateTime startTime;

    protected void writeToFile(int count) {
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
            HSSFSheet sheet = workbook.createSheet(startTime.toString("yyy-MM-dd HH-mm-ss"));

            HSSFFont font = workbook.createFont();
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            HSSFCellStyle style = workbook.createCellStyle();
            style.setFont(font);

            HSSFRow firstRow = sheet.createRow(0);

            Cell cell = firstRow.createCell(0);
            cell.setCellStyle(style);
            cell.setCellValue("URL");

            for (int i = 1; i <= count; i++) {
                Cell cellCount = firstRow.createCell(i);
                cellCount.setCellStyle(style);
                cellCount.setCellValue(i);
            }

            cell = firstRow.createCell(count + 1);
            cell.setCellStyle(style);
            cell.setCellValue("Среднее");

            int rowCount = 1;
            for (Map.Entry<String, List<RunResult>> entry : mapStat.entrySet()) {
                String url = entry.getKey();
                List<RunResult> runResultList = entry.getValue();

                HSSFRow urlRow = sheet.createRow(rowCount);

                Cell urlCell = urlRow.createCell(0);
                urlCell.setCellValue(url);

                double avgTime = 0;
                for (int i = 1; i <= runResultList.size(); i++) {
                    RunResult runResult = runResultList.get(i - 1);

                    double time = runResult.getTime();
                    Cell cellCount = urlRow.createCell(i);
                    if (runResult.getErrorMessage() != null) {
                        cellCount.setCellValue(runResult.getErrorMessage());
                    } else {
                        cellCount.setCellValue(time);
                    }
                    avgTime += time;
                }

                Cell avgCell = urlRow.createCell(count + 1);
                avgCell.setCellValue(avgTime / runResultList.size());
                rowCount++;
            }

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

    protected boolean waitForLoad(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 120);
        return webDriverWait.until(isPageReloaded());
    }

    private ExpectedCondition<Boolean> isPageReloaded() {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(@Nullable WebDriver driver) {
                return (Boolean) ((JavascriptExecutor) driver).executeScript("return $.active==0");
            }
        };
    }

    protected void setRunResult(String url, RunResult runResult) {
        if (mapStat.containsKey(url)) {
            mapStat.get(url).add(runResult);
        } else {
            List<RunResult> runResultList = new ArrayList<RunResult>();
            runResultList.add(runResult);
            mapStat.put(url, runResultList);
        }
    }

    protected int getNumberOfRun(List<String> runUrlList, String runUrl) {
        int numberOfRun = 0;
        for (String url : runUrlList) {
            if (url.equals(runUrl)) {
                numberOfRun++;
            }
        }
        return numberOfRun;
    }

    protected WebDriver firefox() {
        final FirefoxProfile profile;
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        profile = new FirefoxProfile();
        profile.setPreference("dom.max_chrome_script_run_time", 999);
        profile.setPreference("dom.max_script_run_time", 999);
        profile.setPreference("network.cookie.cookieBehavior", 0);
        profile.setPreference("dom.ipc.plugins.enabled", false);
        profile.setPreference("browser.cache.disk.enable", false);
        profile.setPreference("browser.cache.memory.enable", false);
        profile.setPreference("browser.cache.offline.enable", false);
        profile.setPreference("network.http.use-cache", false);

        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(true);

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);

        return new FirefoxDriver(new FirefoxBinary(), profile, capabilities);
    }

    class RunResult {

        private int numberOfRun;
        private DateTime startTime;
        private DateTime endTime;
        private double time;
        private String errorMessage;

        public RunResult(int numberOfRun, DateTime startTime, DateTime endTime, String errorMessage) {
            this.numberOfRun = numberOfRun;
            this.startTime = startTime;
            this.endTime = endTime;
            this.time = (double) (endTime.getMillis() - startTime.getMillis()) / 1000;
            this.errorMessage = errorMessage;
        }

        public int getNumberOfRun() {
            return numberOfRun;
        }

        public double getTime() {
            return time;
        }

        public DateTime getStartTime() {
            return startTime;
        }

        public DateTime getEndTime() {
            return endTime;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }
}
