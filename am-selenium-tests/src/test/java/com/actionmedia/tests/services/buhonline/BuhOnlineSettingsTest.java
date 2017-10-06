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
public class BuhOnlineSettingsTest extends AbstractServicesTest {

    @Test(groups = {buhonline, service})
    public void buhonline_Settings_test() {
        String methodName = "Settings";

        report("Тест для проверки метода '" + methodName + "'");
        report("Адрес сервиса 'Программа главбух': " + getSettings().getBuhOnLineServiceUrl());
        try {
            MessageElement messageElement = getBuhOnlineService().settings().get_any()[0];
            MessageElementConverter converter = new MessageElementConverter(messageElement);
            ServiceResponse response = converter.getResponse();

            List<NodeElement> resources = response.getNodeElementListByName("resources");
            List<NodeElement> image = response.getNodeElementListByName("image");

            checkTagIsPresent(methodName, "resources", resources);
            checkTagIsPresent(methodName, "image", image);

            checkValueIsNotEmpty(methodName, image);

        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}