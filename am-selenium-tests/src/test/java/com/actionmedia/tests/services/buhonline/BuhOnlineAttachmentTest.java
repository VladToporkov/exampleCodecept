package com.actionmedia.tests.services.buhonline;

import com.actionmedia.base.AbstractServicesTest;
import com.actionmedia.webservice.MessageElementConverter;
import com.actionmedia.webservice.NodeElement;
import com.actionmedia.webservice.ServiceResponse;
import org.apache.axis.message.MessageElement;
import org.apache.axis.types.UnsignedByte;
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
public class BuhOnlineAttachmentTest extends AbstractServicesTest {

    @Test(groups = {buhonline, service})
    public void buhonline_Attachment_test() {
        String methodName = "Attachment";

        UnsignedByte moduleId = new UnsignedByte(118);
        int attachId = -18137;

        report("Тест для проверки метода '" + methodName + "'");
        report("Адрес сервиса 'Программа главбух': " + getSettings().getBuhOnLineServiceUrl());
        report("moduleId - " + moduleId);
        report("attachId - " + attachId);

        try {
            MessageElement messageElement = getBuhOnlineService().attachment(moduleId, attachId).get_any()[0];
            MessageElementConverter converter = new MessageElementConverter(messageElement);
            ServiceResponse response = converter.getResponse();

            List<NodeElement> content = response.getNodeElementListByName("content");
            List<NodeElement> container = response.getNodeElementListByName("container");
            List<NodeElement> name = response.getNodeElementListByName("name");
            List<NodeElement> fileName = response.getNodeElementListByName("fileName");
            List<NodeElement> binaryContent = response.getNodeElementListByName("binaryContent");

            checkTagIsPresent(methodName, "content", content);
            checkTagIsPresent(methodName, "container", container);
            checkTagIsPresent(methodName, "name", name);
            checkTagIsPresent(methodName, "fileName", fileName);
            checkTagIsPresent(methodName, "binaryContent", binaryContent);

            checkValueIsNotEmpty(methodName, name);
            checkValueIsNotEmpty(methodName, fileName);
            checkValueIsNotEmpty(methodName, binaryContent);

            checkAttributeIsPresent("mimeType", fileName.get(0).getAttributes(), methodName);

        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
