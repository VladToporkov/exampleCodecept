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
public class BuhOnlineRubricatorTest extends AbstractServicesTest {

    @Test(groups = {buhonline, service})
    public void buhonline_Rubricator_test() {
        String methodName = "Rubricator";

        UnsignedByte rubricatorId = new UnsignedByte(38);

        report("Тест для проверки метода '" + methodName + "'");
        report("Адрес сервиса 'Программа главбух': " + getSettings().getBuhOnLineServiceUrl());
        report("rubricatorId - " + rubricatorId);

        try {
            MessageElement messageElement = getBuhOnlineService().rubricator(rubricatorId).get_any()[0];
            MessageElementConverter converter = new MessageElementConverter(messageElement);
            ServiceResponse response = converter.getResponse();

            List<NodeElement> rubricator = response.getNodeElementListByName("rubricator");

            if (!rubricator.isEmpty()) {
                NodeElement rubricatorNode = rubricator.get(0);
                checkAttributeIsPresent("id", rubricatorNode.getAttributes(), methodName);

                List<NodeElement> rubricTagList = rubricatorNode.getChildrenListByName("rubric");
                List<NodeElement> nameTagList = rubricatorNode.getChildrenListByName("name");
                List<NodeElement> itemTagList = rubricatorNode.getChildrenListByName("item");

                if (!rubricTagList.isEmpty()) {
                    for (NodeElement rubricNode : rubricTagList) {
                        checkAttributeIsPresent("id", rubricNode.getAttributes(), methodName);
                    }
                } else {
                    checkTagIsPresent(methodName, "rubric", rubricTagList);
                }

                if (!nameTagList.isEmpty()) {
                    checkValueIsNotEmpty(methodName, nameTagList);
                } else {
                    checkTagIsPresent(methodName, "name", nameTagList);
                }

                if (!itemTagList.isEmpty()) {
                    for (NodeElement itemNode : itemTagList) {
                        checkAttributeIsPresent("type", itemNode.getAttributes(), methodName);

                        List<NodeElement> idListTagList = itemNode.getChildrenListByName("idList");
                        if (!idListTagList.isEmpty()) {
                            NodeElement idListNode = idListTagList.get(0);
                            List<NodeElement> idTagList = idListNode.getChildrenListByName("id");
                            if (!idTagList.isEmpty()) {
                                for (NodeElement idNode : idTagList) {
                                    checkAttributeIsPresent("type", idNode.getAttributes(), methodName);
                                    checkAttributeIsPresent("value", idNode.getAttributes(), methodName);
                                }
                            } else {
                                checkTagIsPresent(methodName, "id", idTagList);
                            }
                        } else {
                            checkTagIsPresent(methodName, "idList", idListTagList);
                        }

                        List<NodeElement> titleTagList = itemNode.getChildrenListByName("title");

                        checkTagIsPresent(methodName, "title", titleTagList);
                        checkValueIsNotEmpty(methodName, titleTagList);
                    }
                } else {
                    checkTagIsPresent(methodName, "rubricator", rubricator);
                }
            } else {
                checkTagIsPresent(methodName, "rubricator", rubricator);
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
