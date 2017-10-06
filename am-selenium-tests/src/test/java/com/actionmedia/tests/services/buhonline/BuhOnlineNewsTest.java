package com.actionmedia.tests.services.buhonline;

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

import static com.actionmedia.autotest.Group.buhonline;
import static com.actionmedia.autotest.Group.service;

/**
 * User: n.tyukavkin
 * Date: 23.05.2014
 * Time: 12:21
 */
public class BuhOnlineNewsTest extends AbstractServicesTest {

    @Test(groups = {buhonline, service})
    public void buhonline_News_test() {
        String methodName = "News";

        UnsignedByte pubDivId = new UnsignedByte(1);
        int period = 1;
        Calendar dateOn = getCalendarByDateString("2017-01-15", "yyyy-MM-dd");

        report("Тест для проверки метода '" + methodName + "'");
        report("Адрес сервиса 'Программа главбух': " + getSettings().getBuhOnLineServiceUrl());
        report("pubDivId - " + pubDivId);
        report("period - " + period);
        report("dateOn - " + dateOn.getTime().toString());

        try {
            MessageElement messageElement = getBuhOnlineService().news(pubDivId, period, dateOn).get_any()[0];
            MessageElementConverter converter = new MessageElementConverter(messageElement);
            ServiceResponse response = converter.getResponse();

            List<NodeElement> pubDivListTagList = response.getNodeElementListByName("pubDivList");
            if (!pubDivListTagList.isEmpty()) {
                List<NodeElement> pubDivTagList = pubDivListTagList.get(0).getChildrenListByName("pubDiv");
                if (!pubDivTagList.isEmpty()) {
                    for (NodeElement pubDiv : pubDivTagList) {
                        checkAttributeIsPresent("id", pubDiv.getAttributes(), methodName);
                        checkAttributeIsPresent("alias", pubDiv.getAttributes(), methodName);
                        checkAttributeIsPresent("flags", pubDiv.getAttributes(), methodName);
                        if (!pubDiv.getAttributes().get("id").equals("10")) {
                            checkAttributeIsPresent("itemTypes", pubDiv.getAttributes(), methodName);
                        }
                    }
                } else {
                    checkTagIsPresent(methodName, "pubDiv", pubDivTagList);
                }
            } else {
                checkTagIsPresent(methodName, "pubDivList", pubDivListTagList);
            }

            List<NodeElement> changeListTagList = response.getNodeElementListByName("changeList");
            if (!changeListTagList.isEmpty()) {
                NodeElement changeNode = changeListTagList.get(0);
                checkAttributeIsPresent("dateOn", changeNode.getAttributes(), methodName);
                checkAttributeIsPresent("periodInDays", changeNode.getAttributes(), methodName);
                checkAttributeIsPresent("packetId", changeNode.getAttributes(), methodName);

                List<NodeElement> itemTagList = changeNode.getChildrenListByName("item");
                if (!itemTagList.isEmpty()) {
                    for (NodeElement itemNode : itemTagList) {
                        checkAttributeIsPresent("type", itemNode.getAttributes(), methodName);
                        checkAttributeIsPresent("pubDiv", itemNode.getAttributes(), methodName);
                        checkAttributeIsPresent("dateOn", itemNode.getAttributes(), methodName);

                        List<NodeElement> modId = itemNode.getChildrenListByName("ModID");
                        List<NodeElement> docId = itemNode.getChildrenListByName("DocID");
                        List<NodeElement> anchorTo = itemNode.getChildrenListByName("AnchorTo");
                        List<NodeElement> name = itemNode.getChildrenListByName("Name");
                        List<NodeElement> comment = itemNode.getChildrenListByName("Comment");
                        List<NodeElement> docName = itemNode.getChildrenListByName("DocName");
                        List<NodeElement> lawModID = itemNode.getChildrenListByName("LawModID");
                        List<NodeElement> lawDocID = itemNode.getChildrenListByName("LawDocID");
                        List<NodeElement> lawName = itemNode.getChildrenListByName("LawName");
                        List<NodeElement> author = itemNode.getChildrenListByName("Author");

                        checkTagIsPresent(methodName, "item:ModID", modId);
                        checkTagIsPresent(methodName, "item:DocID", docId);
                        checkTagIsPresent(methodName, "item:AnchorTo", anchorTo);
                        checkTagIsPresent(methodName, "item:Name", name);
                        checkTagIsPresent(methodName, "item:Comment", comment);
                        checkTagIsPresent(methodName, "item:DocName", docName);
                        checkTagIsPresent(methodName, "item:LawModID", lawModID);
                        checkTagIsPresent(methodName, "item:LawDocID", lawDocID);
                        checkTagIsPresent(methodName, "item:LawName", lawName);

                        if (!author.isEmpty()) {
                            NodeElement authorNode = author.get(0);

                            List<NodeElement> fullName = authorNode.getChildrenListByName("FullName");
                            List<NodeElement> lastName = authorNode.getChildrenListByName("LastName");
                            List<NodeElement> firstName = authorNode.getChildrenListByName("FirstName");
                            List<NodeElement> secondName = authorNode.getChildrenListByName("SecondName");
                            List<NodeElement> post = authorNode.getChildrenListByName("Post");
                            List<NodeElement> imageID = authorNode.getChildrenListByName("ImageID");

                            checkTagIsPresent(methodName, "item:Author:FullName", fullName);
                            checkTagIsPresent(methodName, "item:Author:LastName", lastName);
                            checkTagIsPresent(methodName, "item:Author:FirstName", firstName);
                            checkTagIsPresent(methodName, "item:Author:SecondName", secondName);
                            checkTagIsPresent(methodName, "item:Author:Post", post);
                            checkTagIsPresent(methodName, "item:Author:ImageID", imageID);

                            checkValueIsNotEmpty(methodName, fullName);
                            checkValueIsNotEmpty(methodName, lastName);
                            checkValueIsNotEmpty(methodName, firstName);
                            checkValueIsNotEmpty(methodName, secondName);
                            checkValueIsNotEmpty(methodName, post);
                            checkValueIsNotEmpty(methodName, imageID);
                        } else {
                            checkTagIsPresent(methodName, "item:ModID", author);
                        }
                    }
                } else {
                    checkTagIsPresent(methodName, "item", itemTagList);
                }
            } else {
                checkTagIsPresent(methodName, "changeList", changeListTagList);
            }

        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
