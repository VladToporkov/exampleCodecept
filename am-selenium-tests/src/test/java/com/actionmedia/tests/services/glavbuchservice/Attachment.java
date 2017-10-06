package com.actionmedia.tests.services.glavbuchservice;

import com.actionmedia.base.AbstractServicesTest;
import com.actionmedia.webservice.MessageElementConverter;
import com.actionmedia.webservice.NodeElement;
import com.actionmedia.webservice.ServiceResponse;
import org.apache.axis.message.MessageElement;
import org.apache.axis.types.UnsignedByte;
import org.testng.annotations.Test;

import java.rmi.RemoteException;
import java.util.List;

import static com.actionmedia.autotest.Group.glavbukh;
import static com.actionmedia.autotest.Group.service;

/**
 * User: n.tyukavkin
 * Date: 21.01.14
 * Time: 17:17
 */
public class Attachment extends AbstractServicesTest {

    @Test(groups = {glavbukh, service})
    public void attachment_test() {
        String methodName = "Attachment";

        UnsignedByte moduleId;
        int attachId;

        if (getSettings().isRunUss()) {
            moduleId = new UnsignedByte(118);
            attachId = -34863;
        } else if (getSettings().isRunFss()) {
            moduleId = new UnsignedByte(160);
            attachId = -35428;
        } else if (getSettings().isRunKss()) {
            moduleId = new UnsignedByte(118);
            attachId = -26354;
        } else {
            moduleId = new UnsignedByte(118);
            attachId = -54957;
        }

        report("Тест для проверки метода '" + methodName + "'");
        report("URL: " + getSettings().getGlavbukhServiceUrl());
        report("moduleId - " + moduleId);
        report("attachId - " + attachId);

        try {
            MessageElement messageElement = getGlavbukhService().attachment(moduleId, attachId).get_any()[0];
            MessageElementConverter converter = new MessageElementConverter(messageElement);
            ServiceResponse response = converter.getResponse();

            List<NodeElement> authorizationTagList = response.getNodeElementListByName("authorization");
            if (!authorizationTagList.isEmpty()) {
                NodeElement authorization = authorizationTagList.get(0);

                checkAttributeIsPresent("cache", authorization.getAttributes(), methodName);

                List<NodeElement> typeTagList = authorization.getChildrenListByName("type");
                List<NodeElement> resultTagList = authorization.getChildrenListByName("result");

                checkTagIsPresent(methodName, "type", typeTagList);
                checkTagIsPresent(methodName, "result", resultTagList);

                checkValueIsNotEmpty(methodName, typeTagList);
                checkValueIsNotEmpty(methodName, resultTagList);
            } else {
                checkTagIsPresent(methodName, "authorization", authorizationTagList);
            }

            List<NodeElement> resultTagList = response.getNodeElementListByName("Result");
            if (!resultTagList.isEmpty()) {
                NodeElement result = resultTagList.get(0);
                List<NodeElement> contentTypeTagList = result.getChildrenListByName("ContentType");
                List<NodeElement> contentFileNameTagList = result.getChildrenListByName("ContentFileName");
                List<NodeElement> contentTagList = result.getChildrenListByName("Content");

                checkTagIsPresent(methodName, "ContentType", contentTypeTagList);
                checkTagIsPresent(methodName, "ContentFileName", contentFileNameTagList);
                checkTagIsPresent(methodName, "Content", contentTagList);

                checkValueIsNotEmpty(methodName, contentTypeTagList);
                checkValueIsNotEmpty(methodName, contentFileNameTagList);
                checkValueIsNotEmpty(methodName, contentTagList);
            } else {
                checkTagIsPresent(methodName, "Result", resultTagList);
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
