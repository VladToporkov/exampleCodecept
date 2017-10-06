package com.actionmedia.tests.experimental.id2;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 13.11.2014
 * Time: 1:35
 */
public class Id2JsoupBase {

    protected static final String FILE_NAME = "C:\\id2\\50lp.xlsx";
    protected static final String FILE_NAME_JSOUP = "C:\\id2\\50lp_jsoup.xlsx";
    protected static final String FILE_NAME_1 = "C:\\id2\\01-auth-test.xlsx";
    protected static final String FILE_NAME_2 = "C:\\id2\\02-auth-test.xlsx";
    protected static final String FILE_NAME_3 = "C:\\id2\\03-auth-test.xlsx";
    protected static final String FILE_NAME_4 = "C:\\id2\\04-auth-test.xlsx";
    protected static final String FILE_NAME_5 = "C:\\id2\\05-auth-test.xlsx";
    protected static final String FILE_NAME_6 = "C:\\id2\\06-auth-test.xlsx";
    protected static final String FILE_NAME_7 = "C:\\id2\\07-auth-test.xlsx";
    protected static final String FILE_NAME_8 = "C:\\id2\\08-auth-test.xlsx";
    protected static final String FILE_NAME_9 = "C:\\id2\\09-auth-test.xlsx";
    protected static final String FILE_NAME_10 = "C:\\id2\\10-auth-test.xlsx";
    protected static final String URL = "https://id2-new.action-media.ru/";

    protected synchronized List<Customer> getCustomerList(String fileName) {
        List<Customer> customerList = new ArrayList<Customer>();
        try {
            FileInputStream file = new FileInputStream(new File(fileName));
            XSSFWorkbook xWorkbook = new XSSFWorkbook(file);
            XSSFSheet sheet = xWorkbook.getSheetAt(0);
            for (int rowNumber = 1; rowNumber < sheet.getPhysicalNumberOfRows(); rowNumber++) {
                try {
                    XSSFRow row = sheet.getRow(rowNumber);
                    String login = row.getCell(0).getStringCellValue();
                    String password = row.getCell(1).getCellType() == 0 ? String.valueOf((long) row.getCell(1).getNumericCellValue()) : row.getCell(1).getStringCellValue();

                    Customer customer = new Customer(login, password);
                    customerList.add(customer);
                } catch (NullPointerException ignored) {
                    System.out.println("NPE: file - " + fileName + ", rowNumber - " + rowNumber + " err: " + ignored.getMessage());
                    continue;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    protected List<Customer> getCustomerListWithIndex(String fileName) {
        List<Customer> customerList = new ArrayList<Customer>();
        try {
            FileInputStream file = new FileInputStream(new File(fileName));
            XSSFWorkbook xWorkbook = new XSSFWorkbook(file);
            XSSFSheet sheet = xWorkbook.getSheetAt(0);
            for (int rowNumber = 1; rowNumber < sheet.getPhysicalNumberOfRows(); rowNumber++) {
                XSSFRow row = sheet.getRow(rowNumber);
                String login = row.getCell(0).getStringCellValue();
                String password = row.getCell(1).getCellType() == 0 ? String.valueOf((long) row.getCell(1).getNumericCellValue()) : row.getCell(1).getStringCellValue();
                Long index = (long) row.getCell(2).getNumericCellValue();

                Customer customer = new Customer(login, password, index);
                customerList.add(customer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    protected synchronized void writeResultToFile(String fileName, List<Customer> customerList) {
        try {
            FileInputStream file = new FileInputStream(new File(fileName));
            XSSFWorkbook xWorkbook = new XSSFWorkbook(file);
            XSSFSheet sheet = xWorkbook.getSheetAt(0);
            for (int rowNumber = 1; rowNumber < sheet.getPhysicalNumberOfRows(); rowNumber++) {
                try {
                    XSSFRow row = sheet.getRow(rowNumber);
                    String login = row.getCell(0).getStringCellValue();

                    int status = getCustomerByLogin(customerList, login).getStatus();
                    row.createCell(2).setCellValue(status);
                } catch (NullPointerException ignored) {
                    System.out.println("NPE: file - " + fileName + ", rowNumber - " + rowNumber + " err: " + ignored.getMessage());
                    continue;
                }
            }
            file.close();
            FileOutputStream outFile = new FileOutputStream(new File(fileName));
            xWorkbook.write(outFile);
            outFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void writeResultToFileWithIndex(String fileName, List<Customer> customerList) {
        try {
            FileInputStream file = new FileInputStream(new File(fileName));
            XSSFWorkbook xWorkbook = new XSSFWorkbook(file);
            XSSFSheet sheet = xWorkbook.getSheetAt(0);
            for (int rowNumber = 1; rowNumber < sheet.getPhysicalNumberOfRows(); rowNumber++) {
                XSSFRow row = sheet.getRow(rowNumber);
                String login = row.getCell(0).getStringCellValue();
                Long index = (long) row.getCell(2).getNumericCellValue();

                int status = getCustomerByLoginAndByIndex(customerList, login, index).getStatus();
                row.createCell(3).setCellValue(status);
            }
            file.close();
            FileOutputStream outFile = new FileOutputStream(new File(fileName));
            xWorkbook.write(outFile);
            outFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected Customer getCustomerByLogin(List<Customer> customerList, String login) {
        for (Customer customer : customerList) {
            if (customer.getLogin().equals(login)) {
                return customer;
            }
        }
        return null;
    }

    protected Customer getCustomerByLoginAndByIndex(List<Customer> customerList, String login, long index) {
        for (Customer customer : customerList) {
            if (customer.getLogin().equals(login) && customer.getIndex() == index) {
                return customer;
            }
        }
        return null;
    }

    class Customer {
        String login;
        String password;
        int status;
        long index;

        public Customer(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public Customer(String login, String password, long index) {
            this.login = login;
            this.password = password;
            this.index = index;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public long getIndex() {
            return index;
        }
    }
}
