package com.actionmedia.tests.experimental.id2;

import com.actionmedia.pages.id2.Id2BasePage;
import org.testng.annotations.Test;

import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 11.11.2014
 * Time: 1:18
 */
public class Id2Test1 extends Id2Base {

    @Test
    public void test() {
        preconditions();
        List<Customer> customerList = customerList1;
        for (Customer customer : customerList) {
            try {
                Id2BasePage id2BasePage = openToId2SiteByUrl(URL)
                        .inputLogin(customer.getEmail())
                        .inputPassword(customer.getPassword())
                        .clickLogin();
                if (id2BasePage.isLoginErrorPresent()) {
                    customer.setStatus(1);
                } else if (id2BasePage.isAboutMeLinkPresent()) {
                    customer.setStatus(0);
                } else {
                    customer.setStatus(2);
                }
            } catch (Exception e) {
                customer.setStatus(2);
            }
        }
        writeResults();
    }
}
