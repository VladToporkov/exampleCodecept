package com.actionmedia.tests.services.glavbuchservice;

import com.actionmedia.base.AbstractServicesTest;
import com.actionmedia.webservice.MessageElementConverter;
import com.actionmedia.webservice.NodeElement;
import com.actionmedia.webservice.ServiceResponse;
import org.apache.axis.message.MessageElement;
import org.apache.axis.types.UnsignedByte;
import org.testng.annotations.Test;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

import static com.actionmedia.autotest.Group.glavbukh;
import static com.actionmedia.autotest.Group.service;

/**
 * User: n.tyukavkin
 * Date: 17.03.2014
 * Time: 17:13
 */
public class PacketTab extends AbstractServicesTest {

    private static final String METHOD_NAME = "PacketTab";

    @Test(groups = {glavbukh, service})
    public void packetTab_test() {
        UnsignedByte pubDivId = new UnsignedByte(7);
        int period = 30;
        Calendar date = Calendar.getInstance();
        Integer packetId = 377;

        report("Тест для проверки метода '" + METHOD_NAME + "'");
        report("URL: " + getSettings().getGlavbukhServiceUrl());
        report("pubDivId - " + pubDivId);
        report("period - " + period);
        report("Date - " + date.getTime().toString());
        report("PacketId - " + packetId);

        try {
            MessageElement messageElement = getGlavbukhService().packetTab(pubDivId, period, date, packetId).get_any()[0];
            ServiceResponse response = new MessageElementConverter(messageElement).getResponse();

            List<NodeElement> contentNodeList = response.getNodeElementListByName("content");
            if (!contentNodeList.isEmpty()) {
                NodeElement contentNode = contentNodeList.get(contentNodeList.size() - 1);
                List<NodeElement> containerNodeList = contentNode.getChildrenListByName("container");
                if (!containerNodeList.isEmpty()) {
                    NodeElement containerNode = containerNodeList.get(0);
                    checkAttributeIsPresent("name", containerNode.getAttributes(), METHOD_NAME);

                    List<NodeElement> pubDivNodeList = containerNode.getChildrenListByName("pubDivList");
                    if (!pubDivNodeList.isEmpty()) {
                        NodeElement pubDivListNode = pubDivNodeList.get(0);
                        List<NodeElement> pubDivList = pubDivListNode.getChildrenListByName("pubDiv");
                        if (!pubDivList.isEmpty()) {
                            NodeElement pubDiv = pubDivList.get(0);
                            checkAttributeIsPresent("id", pubDiv.getAttributes(), METHOD_NAME);
                            checkAttributeIsPresent("alias", pubDiv.getAttributes(), METHOD_NAME);
                            List<NodeElement> nameNodeList = pubDiv.getChildrenListByName("name");
                            if (!nameNodeList.isEmpty()) {
                                NodeElement nameNode = nameNodeList.get(0);
                                checkAttributeIsPresent("forms", nameNode.getAttributes(), METHOD_NAME);
                                checkValueIsNotEmpty(METHOD_NAME, nameNodeList);
                            } else {
                                checkTagIsPresent(METHOD_NAME, "name", pubDivList);
                            }
                        } else {
                            checkTagIsPresent(METHOD_NAME, "pubDiv", pubDivList);
                        }
                    } else {
                        checkTagIsPresent(METHOD_NAME, "pubDivList", pubDivNodeList);
                    }
                    List<NodeElement> changeNodeList = containerNode.getChildrenListByName("changeList");
                    if (!changeNodeList.isEmpty()) {
                        NodeElement changeNode = changeNodeList.get(0);
                        checkAttributeIsPresent("dateOn", changeNode.getAttributes(), METHOD_NAME);
                        checkAttributeIsPresent("periodInDays", changeNode.getAttributes(), METHOD_NAME);
                    } else {
                        checkTagIsPresent(METHOD_NAME, "changeList", changeNodeList);
                    }
                } else {
                    checkTagIsPresent(METHOD_NAME, "container", containerNodeList);
                }

                //TODO NT: http://rm.1gl.ru/issues/72794
//                List<NodeElement> widgetListNodeList = contentNode.getChildrenListByName("widgetList");
//                if (!widgetListNodeList.isEmpty()) {
//                    NodeElement widgetListNode = widgetListNodeList.get(0);
//
//                    List<NodeElement> widgetNodeList = widgetListNode.getChildrenListByName("widget");
//                    if (!widgetNodeList.isEmpty()) {
//                        NodeElement widgetNode = widgetNodeList.get(0);
//
//                        checkAttributeIsPresent("alias", widgetNode.getAttributes(), METHOD_NAME);
//                        checkAttributeValue("alias", "popular-documents", widgetNode.getAttributes(), METHOD_NAME);
//
//                        List<NodeElement> xmlContentNodeList = widgetNode.getChildrenListByName("xmlcontent");
//                        if (!xmlContentNodeList.isEmpty()) {
//                            NodeElement xmlContentNode = xmlContentNodeList.get(0);
//                            List<NodeElement> documentList = xmlContentNode.getChildrenListByName("doc");
//                            if (!documentList.isEmpty()) {
//                                for (NodeElement documentNode : documentList) {
//                                    String moduleid = documentNode.getAttributes().get("moduleid");
//                                    String id = documentNode.getAttributes().get("id");
//                                    String popularity = documentNode.getAttributes().get("popularity");
//                                    String title = documentNode.getAttributes().get("title");
//                                    String type = documentNode.getAttributes().get("type");
//                                    postponedAssertTrue(moduleid != null && !moduleid.isEmpty(), "Неверный формат ответного xml для метода '" + METHOD_NAME + "'. Отсутствует значение для свойства 'type'.");
//                                    postponedAssertTrue(id != null && !id.isEmpty(), "Неверный формат ответного xml для метода '" + METHOD_NAME + "'. Отсутствует значение для свойства 'id'.");
//                                    postponedAssertTrue(popularity != null && !popularity.isEmpty(), "Неверный формат ответного xml для метода '" + METHOD_NAME + "'. Отсутствует значение для свойства 'popularity'.");
//                                    postponedAssertTrue(title != null, "Неверный формат ответного xml для метода '" + METHOD_NAME + "'. Отсутствует значение для свойства 'title'.");
//                                    postponedAssertTrue(type.equals("formFSS") || type.equals("formXML") || type.equals("superformXML"), "Неверный формат ответного xml для метода '" + METHOD_NAME + "'. Неверное значение для свойства 'type'. Expected:[formFSS, formXML, superformXML], Actual: [" + type + "]");
//                                }
//                            } else {
//                                checkTagIsPresent(METHOD_NAME, "doc", documentList);
//                            }
//                        } else {
//                            checkTagIsPresent(METHOD_NAME, "xmlContent", xmlContentNodeList);
//                        }
//                    } else {
//                        checkTagIsPresent(METHOD_NAME, "widget", widgetNodeList);
//                    }
//                } else {
//                    checkTagIsPresent(METHOD_NAME, "widgetList", widgetListNodeList);
//                }
            } else {
                checkTagIsPresent(METHOD_NAME, "content", contentNodeList);
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
