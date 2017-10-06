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
 * Time: 18:23
 */
public class Rubricator extends AbstractServicesTest {

    private static final String METHOD_NAME = "Rubricator";

    @Test(groups = {glavbukh, service})
    public void rubricator_test() {
        UnsignedByte pubDivId = new UnsignedByte(7);

        report("Тест для проверки метода '" + METHOD_NAME + "'");
        report("URL: " + getSettings().getGlavbukhServiceUrl());
        report("pubDivId - " + pubDivId);

        try {
            MessageElement messageElement = getGlavbukhService().rubricator(pubDivId).get_any()[0];
            ServiceResponse response = new MessageElementConverter(messageElement).getResponse();

            checkRubricatorListTagIsPresent(response);
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }

    private void checkRubricatorListTagIsPresent(ServiceResponse response) {
        List<NodeElement> rubricatorListTagList = response.getNodeElementListByName("rubricatorList");
        if (!rubricatorListTagList.isEmpty()) {
            NodeElement rubricatorList = rubricatorListTagList.get(0);
            List<NodeElement> rubricatorTagList = rubricatorList.getChildrenListByName("rubricator");
            if (!rubricatorTagList.isEmpty()) {
                NodeElement rubricator = rubricatorTagList.get(0);
                List<NodeElement> nameTagList = rubricator.getChildrenListByName("name");
                List<NodeElement> rubricTagList = rubricator.getChildrenListByName("rubric");

                checkTagIsPresent(METHOD_NAME, "name", nameTagList);
                checkTagIsPresent(METHOD_NAME, "rubric", rubricTagList);
            } else {
                checkTagIsPresent(METHOD_NAME, "rubricator", rubricatorTagList);
            }
        } else {
            checkTagIsPresent(METHOD_NAME, "rubricatorList", rubricatorListTagList);
        }
    }
}
