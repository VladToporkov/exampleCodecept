package com.actionmedia.tests.services.buhonline;

import com.actionmedia.base.AbstractServicesTest;
import com.actionmedia.webservice.MessageElementConverter;
import com.actionmedia.webservice.NodeElement;
import com.actionmedia.webservice.ServiceResponse;
import org.apache.axis.message.MessageElement;
import org.testng.annotations.Test;

import java.rmi.RemoteException;
import java.util.List;

import static com.actionmedia.autotest.Group.buhonline;
import static com.actionmedia.autotest.Group.service;

/**
 * User: n.tyukavkin
 * Date: 23.05.2014
 * Time: 12:21
 */
public class BuhOnlineExtendedSearchNumbersTest extends AbstractServicesTest {

    @Test(groups = {buhonline, service})
    public void buhonline_ExtendedSearchNumbers_test() {
        String methodName = "ExtendedSearchNumbers";

        String pattern = "111";

        report("Тест для проверки метода '" + methodName + "'");
        report("Адрес сервиса 'Программа главбух': " + getSettings().getBuhOnLineServiceUrl());
        report("pattern - " + pattern);

        try {
            MessageElement messageElement = getBuhOnlineService().extendedSearchNumbers(pattern).get_any()[0];
            MessageElementConverter converter = new MessageElementConverter(messageElement);
            ServiceResponse response = converter.getResponse();

            List<NodeElement> docNumberList = response.getNodeElementListByName("DocNumberList");
            List<NodeElement> docNumber = response.getNodeElementListByName("DocNumber");

            checkTagIsPresent(methodName, "DocNumberList", docNumberList);
            checkTagIsPresent(methodName, "DocNumber", docNumber);

            checkValueIsNotEmpty(methodName, docNumber);
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
