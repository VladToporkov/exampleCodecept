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

import static com.actionmedia.autotest.Group.*;

/**
 * User: n.tyukavkin
 * Date: 17.03.2014
 * Time: 16:03
 */
public class PacketRubricator extends AbstractServicesTest {

    private static final String METHOD_NAME = "PacketRubricator";

    @Test(groups = {glavbukh, service})
    public void packetRubricator_test() {
        UnsignedByte pubDivId = new UnsignedByte(7);
        int packetId = 245;

        report("Тест для проверки метода '" + METHOD_NAME + "'");
        report("URL: " + getSettings().getGlavbukhServiceUrl());
        report("pubDivId - " + pubDivId);
        report("packetId - " + packetId);

        try {
            MessageElement messageElement = getGlavbukhService().packetRubricator(pubDivId, packetId).get_any()[0];
            ServiceResponse response = new MessageElementConverter(messageElement).getResponse();

            List<NodeElement> contentNodeElementList = response.getNodeElementListByName("content");
            if (!contentNodeElementList.isEmpty()) {
                checkAttributeIsPresent("cache", contentNodeElementList.get(0).getAttributes(), METHOD_NAME);
            } else {
                checkTagIsPresent(METHOD_NAME, "content", contentNodeElementList);
            }

            List<NodeElement> containerNodeList = response.getNodeElementListByName("container");
            if (!containerNodeList.isEmpty()) {
                NodeElement containerNode = containerNodeList.get(0);
                checkAttributeIsPresent("name", containerNode.getAttributes(), METHOD_NAME);
                checkAttributeIsPresent("status", containerNode.getAttributes(), METHOD_NAME);

                List<NodeElement> rubricatorNodeList = containerNode.getChildrenListByName("rubricator");
                if (!rubricatorNodeList.isEmpty()) {
                    NodeElement rubricatorNode = rubricatorNodeList.get(0);
                    checkAttributeIsPresent("id", rubricatorNode.getAttributes(), METHOD_NAME);

                    List<NodeElement> nameNodeList = rubricatorNode.getChildrenListByName("name");
                    checkTagIsPresent(METHOD_NAME, "name", nameNodeList);
                    checkValueIsNotEmpty(METHOD_NAME, nameNodeList);

                    List<NodeElement> rubricNodeList = rubricatorNode.getChildrenListByName("rubric");
                    if (!rubricNodeList.isEmpty()) {
                        NodeElement rubricNode = rubricNodeList.get(0);
                        checkAttributeIsPresent("id", rubricNode.getAttributes(), METHOD_NAME);

                        List<NodeElement> nameElementList = rubricNode.getChildrenListByName("name");
                        checkTagIsPresent(METHOD_NAME, "name", nameElementList);
                        checkValueIsNotEmpty(METHOD_NAME, nameElementList);

                        List<NodeElement> itemElementList = rubricNode.getChildrenListByName("item");
                        if (!itemElementList.isEmpty()) {
                            NodeElement itemNode = itemElementList.get(0);

                            List<NodeElement> idListElementList = itemNode.getChildrenListByName("idList");
                            if (!idListElementList.isEmpty()) {
                                NodeElement idListNode = idListElementList.get(0);
                                List<NodeElement> idElementList = idListNode.getChildrenListByName("id");
                                checkTagIsPresent(METHOD_NAME, "id", idElementList);
                                checkAttributeIsPresent("type", idElementList.get(0).getAttributes(), METHOD_NAME);
                                checkAttributeIsPresent("value", idElementList.get(0).getAttributes(), METHOD_NAME);
                            } else {
                                checkTagIsPresent(METHOD_NAME, "idList", idListElementList);
                            }
                            List<NodeElement> titleElementList = itemNode.getChildrenListByName("title");
                            checkTagIsPresent(METHOD_NAME, "title", titleElementList);
                            checkValueIsNotEmpty(METHOD_NAME, titleElementList);
                        } else {
                            checkTagIsPresent(METHOD_NAME, "item", itemElementList);
                        }
                    } else {
                        checkTagIsPresent(METHOD_NAME, "rubric", contentNodeElementList);
                    }
                } else {
                    checkTagIsPresent(METHOD_NAME, "rubricator", contentNodeElementList);
                }

            } else {
                checkTagIsPresent(METHOD_NAME, "container", contentNodeElementList);
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
