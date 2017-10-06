package com.actionmedia.tests.experimental.id2;

import com.actionmedia.autotest.selenium.SeleniumHolder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * User: n.tyukavkin
 * Date: 27.11.2014
 * Time: 20:39
 */
public class SGCRM extends Id2Base {

    private static final String FILE_NAME = "C:\\id2\\login_error.xlsx";
    private static final String LOGIN = "ntyukavkin";
    private static final String PASSWORD = "12345";
    private static final String URL = "http://web13-sgcrm.actiondigital.ru/login.aspx";
    private WebDriver driver;

    @Test
    public void sgcrm() {
        List<Customer> customerList = getCustomerList(FILE_NAME);
        openToId2SiteByUrl(URL);
        driver = SeleniumHolder.getWebDriver();

        driver.findElement(By.name("login")).sendKeys(LOGIN);
        driver.findElement(By.name("pass")).sendKeys(PASSWORD);
        driver.findElement(By.cssSelector("[type='submit']")).click();

        for (Customer customer : customerList) {
            try {
                Document document = postHtmlDocumentByUrl("http://web13-sgcrm.actiondigital.ru/default.aspx", customer.getEmail());
                String userId = document.select(".active td").get(0).text();
                customer.setUserId(Long.parseLong(userId));
            } catch (IOException e) {
                System.out.println("IOException occurs. " + e.getMessage());
            } catch (IndexOutOfBoundsException e) {
                System.out.println("IndexOutOfBoundsException occurs. email - " + customer.getEmail());
            }
        }

        for (Customer customer : customerList) {
            try {
                if (customer.getUserId() == null) {
                    continue;
                }
                Document document = getHtmlDocumentByUrl("http://web13-sgcrm.actiondigital.ru/user-info.aspx?userid=" + customer.getUserId());
                String login = document.select(".step-ten tr td").get(1).text();
                String bitrixId = document.select(".id2content tr td").get(1).text();
                customer.setLogin(login);
                customer.setBitrixId(bitrixId);
            } catch (IOException e) {
                System.out.println("IOException occurs. " + e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("NullPointerException occurs. email - " + customer.getEmail());
            } catch (IndexOutOfBoundsException e) {
                System.out.println("IndexOutOfBoundsException occurs. email - " + customer.getEmail());
            }
        }

        writeResultToFileWithBitrixIdAndLogin(FILE_NAME, customerList);
    }

    private Map<String, String> getCookies() {
        Map<String, String> cookies = new HashMap<String, String>();
        Iterator iterator = driver.manage().getCookies().iterator();
        while (iterator.hasNext()) {
            Cookie cookie = (Cookie) iterator.next();
            cookies.put(cookie.getName(), cookie.getValue());
        }
        return cookies;
    }

    private Document getHtmlDocumentByUrl(String pageUrl) throws IOException {
        return Jsoup.connect(pageUrl)
                .cookies(getCookies())
                .timeout(600000)
                .get();
    }

    private Document postHtmlDocumentByUrl(String pageUrl, String email) throws IOException {
        return Jsoup.connect(pageUrl)
                .cookies(getCookies())
                .data("email", email)
                .ignoreHttpErrors(true)
                .timeout(0)
                .post();
    }
}
