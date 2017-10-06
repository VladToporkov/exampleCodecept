package com.actionmedia.tests.services.glavbuchservice;

import com.actionmedia.base.AbstractServicesTest;
import com.actionmedia.webservice.MessageElementConverter;
import com.actionmedia.webservice.NodeElement;
import com.actionmedia.webservice.ServiceResponse;
import org.apache.axis.message.MessageElement;
import org.testng.annotations.Test;

import java.rmi.RemoteException;
import java.util.List;

import static com.actionmedia.autotest.Group.glavbukh;
import static com.actionmedia.autotest.Group.service;

/**
 * User: n.tyukavkin
 * Date: 21.01.14
 * Time: 18:23
 */
public class Settings extends AbstractServicesTest {

    private static final String METHOD_NAME = "Settings";

    @Test(groups = {glavbukh, service})
    public void settings_test() {
        report("Тест для проверки метода '" + METHOD_NAME + "'");
        report("URL: " + getSettings().getGlavbukhServiceUrl());

        try {
            MessageElement messageElement = getGlavbukhService().settings().get_any()[0];
            ServiceResponse response = new MessageElementConverter(messageElement).getResponse();

            List<NodeElement> settingsTagList = response.getNodeElementListByName("settings");
            if (!settingsTagList.isEmpty()) {
                NodeElement settings = settingsTagList.get(0);
                List<NodeElement> imageTagList = settings.getChildrenListByName("image");

                checkTagIsPresent(METHOD_NAME, "image", imageTagList);
                checkValueIsNotEmpty(METHOD_NAME, imageTagList);
            } else {
                checkTagIsPresent(METHOD_NAME, "settings", settingsTagList);
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
