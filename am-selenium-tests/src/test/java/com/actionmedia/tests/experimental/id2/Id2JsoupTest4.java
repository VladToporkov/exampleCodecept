package com.actionmedia.tests.experimental.id2;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 13.11.2014
 * Time: 22:15
 */
public class Id2JsoupTest4 extends Id2JsoupBase {

    @Test
    public void test() {
        List<Customer> customerList = getCustomerList(FILE_NAME_4);
        for (Customer customer : customerList) {
            try {
                Document document = getHtmlDocumentByUrl("https://id2-new.action-media.ru/Account/LogOn", customer.getLogin(), customer.getPassword());
                if (!document.select(".subMenu").isEmpty() && document.select(".subMenu").text().equals("Мои журналы и продукты Обо мне")) {
                    customer.setStatus(0);
                } else if (document.text().contains("Testing")) {
                    customer.setStatus(0);
                } else {
                    customer.setStatus(1);
                }
            } catch (Exception e) {
                customer.setStatus(2);
                System.out.println("Exception occurs " + e.getMessage());
            }
        }
        writeResultToFile(FILE_NAME_4, customerList);
    }

    private Document getHtmlDocumentByUrl(String pageUrl, String login, String password) throws IOException {
        return Jsoup.connect(pageUrl)
                .data("login", login)
                .data("pass", password)
                .ignoreHttpErrors(true)
                .timeout(0)
                .post();
    }
}
