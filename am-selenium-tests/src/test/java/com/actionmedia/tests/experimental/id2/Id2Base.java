package com.actionmedia.tests.experimental.id2;

import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.tests.functional.loadtests.LoadMainPageTest;
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
public class Id2Base extends AbstractDomainTest {

    protected static final String FILE_NAME = "C:\\id2\\50lp.xlsx";
    protected static final String FILE_NAME_1000 = "C:\\id2\\50lp_1000.xlsx";
    protected static final String URL = "https://id2-new.action-media.ru/";

    protected List<Customer> customerList1 = new ArrayList<Customer>();
    protected List<Customer> customerList2 = new ArrayList<Customer>();
    protected List<Customer> customerList3 = new ArrayList<Customer>();
    protected List<Customer> customerList4 = new ArrayList<Customer>();
    protected List<Customer> customerList5 = new ArrayList<Customer>();
    protected List<Customer> customerList6 = new ArrayList<Customer>();
    protected List<Customer> customerList7 = new ArrayList<Customer>();
    protected List<Customer> customerList8 = new ArrayList<Customer>();
    protected List<Customer> customerList9 = new ArrayList<Customer>();
    protected List<Customer> customerList10 = new ArrayList<Customer>();

    public void preconditions() {
        List<Customer> allCustomerList = getCustomerList(FILE_NAME);
        int countForOne = allCustomerList.size() / 10;

        customerList1.addAll(allCustomerList.subList(0, countForOne));
        customerList2.addAll(allCustomerList.subList(countForOne + 1, countForOne * 2));
        customerList3.addAll(allCustomerList.subList(countForOne * 2 + 1, countForOne * 3));
        customerList4.addAll(allCustomerList.subList(countForOne * 3 + 1, countForOne * 4));
        customerList5.addAll(allCustomerList.subList(countForOne * 4 + 1, countForOne * 5));
        customerList6.addAll(allCustomerList.subList(countForOne * 5 + 1, countForOne * 6));
        customerList7.addAll(allCustomerList.subList(countForOne * 6 + 1, countForOne * 7));
        customerList8.addAll(allCustomerList.subList(countForOne * 7 + 1, countForOne * 8));
        customerList9.addAll(allCustomerList.subList(countForOne * 8 + 1, countForOne * 9));
        customerList10.addAll(allCustomerList.subList(countForOne * 9 + 1, allCustomerList.size() - 1));
    }

    public void writeResults() {
        writeResultToFile(FILE_NAME, customerList1);
        writeResultToFile(FILE_NAME, customerList2);
        writeResultToFile(FILE_NAME, customerList3);
        writeResultToFile(FILE_NAME, customerList4);
        writeResultToFile(FILE_NAME, customerList5);
        writeResultToFile(FILE_NAME, customerList6);
        writeResultToFile(FILE_NAME, customerList7);
        writeResultToFile(FILE_NAME, customerList8);
        writeResultToFile(FILE_NAME, customerList9);
        writeResultToFile(FILE_NAME, customerList10);
    }

    protected List<Customer> getCustomerList(String fileName) {
        List<Customer> customerList = new ArrayList<Customer>();
        try {
            FileInputStream file = new FileInputStream(new File(fileName));
            XSSFWorkbook xWorkbook = new XSSFWorkbook(file);
            XSSFSheet sheet = xWorkbook.getSheetAt(0);
            for (int rowNumber = 1; rowNumber < sheet.getPhysicalNumberOfRows(); rowNumber++) {
                XSSFRow row = sheet.getRow(rowNumber);
                String login = row.getCell(0).getStringCellValue();
                String password = row.getCell(1).getCellType() == 0 ? String.valueOf((long) row.getCell(1).getNumericCellValue()) : row.getCell(1).getStringCellValue();

                Customer customer = new Customer(login, password);
                customerList.add(customer);
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

    protected void writeResultToFile(String fileName, List<Customer> customerList) {
        try {
            FileInputStream file = new FileInputStream(new File(fileName));
            XSSFWorkbook xWorkbook = new XSSFWorkbook(file);
            XSSFSheet sheet = xWorkbook.getSheetAt(0);
            for (int rowNumber = 1; rowNumber < sheet.getPhysicalNumberOfRows(); rowNumber++) {
                XSSFRow row = sheet.getRow(rowNumber);
                String login = row.getCell(0).getStringCellValue();

                int status = getCustomerByLogin(customerList, login).getStatus();
                row.createCell(2).setCellValue(status);
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

    protected void writeResultToFileWithBitrixIdAndLogin(String fileName, List<Customer> customerList) {
        try {
            FileInputStream file = new FileInputStream(new File(fileName));
            XSSFWorkbook xWorkbook = new XSSFWorkbook(file);
            XSSFSheet sheet = xWorkbook.getSheetAt(0);
            for (int rowNumber = 1; rowNumber < sheet.getPhysicalNumberOfRows(); rowNumber++) {
                XSSFRow row = sheet.getRow(rowNumber);
                String email = row.getCell(0).getStringCellValue();

                Customer customer = getCustomerByLogin(customerList, email);
                row.createCell(3).setCellValue(customer.getLogin());
                row.createCell(4).setCellValue(customer.getBitrixId());
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

    protected Customer getCustomerByLogin(List<Customer> customerList, String email) {
        for (Customer customer : customerList) {
            if (customer.getEmail().equals(email)) {
                return customer;
            }
        }
        return null;
    }

    protected Customer getCustomerByLoginAndByIndex(List<Customer> customerList, String login, long index) {
        for (Customer customer : customerList) {
            if (customer.getEmail().equals(login) && customer.getIndex() == index) {
                return customer;
            }
        }
        return null;
    }

    class Customer {
        String email;
        String password;
        String login;
        String bitrixId;
        int status;
        long index;
        Long userId;

        public Customer(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public Customer(String email, String password, long index) {
            this.email = email;
            this.password = password;
            this.index = index;
        }

        public String getEmail() {
            return email;
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

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getBitrixId() {
            return bitrixId;
        }

        public void setBitrixId(String bitrixId) {
            this.bitrixId = bitrixId;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }
    }
}
