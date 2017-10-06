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
public class BuhOnlineDocumentPartTest extends AbstractServicesTest {

    @Test(groups = {buhonline, service})
    public void buhonline_DocumentPart_test() {
        String methodName = "DocumentPart";

        UnsignedByte moduleId = new UnsignedByte(99);
        int id = 901765862;
        short partId = 2;

        report("Тест для проверки метода '" + methodName + "'");
        report("Адрес сервиса 'Программа главбух': " + getSettings().getBuhOnLineServiceUrl());
        report("moduleId - " + moduleId);
        report("attachId - " + id);
        report("partId - " + partId);

        try {
            MessageElement messageElement = getBuhOnlineService().documentPart(moduleId, id, partId).get_any()[0];
            MessageElementConverter converter = new MessageElementConverter(messageElement);
            ServiceResponse response = converter.getResponse();

            List<NodeElement> content = response.getNodeElementListByName("content");
            List<NodeElement> container = response.getNodeElementListByName("container");
            List<NodeElement> headerinfo = response.getNodeElementListByName("headerinfo");
            List<NodeElement> docinfo = response.getNodeElementListByName("docinfo");

            checkTagIsPresent(methodName, "content", content);
            checkTagIsPresent(methodName, "container", container);
            checkTagIsPresent(methodName, "headerinfo", headerinfo);
            checkTagIsPresent(methodName, "docinfo", docinfo);

            String[] headerNodeNameArr = new String[]{"PubID", "PubDivID", "document_id", "modul_id", "part-id"};
            for (String tagName : headerNodeNameArr) {
                List<NodeElement> tagNode = headerinfo.get(0).getChildrenListByName(tagName);
                checkTagIsPresent(methodName, tagName, tagNode);
                checkValueIsNotEmpty(methodName, tagNode);
            }

            List<NodeElement> partIdDocInfoNode = docinfo.get(0).getChildrenListByName("part-id");
            List<NodeElement> partCountDocInfoNode = docinfo.get(0).getChildrenListByName("part-count");
            checkTagIsPresent(methodName, "docinfo:part-id", partIdDocInfoNode);
            checkTagIsPresent(methodName, "docinfo:part-count", partCountDocInfoNode);
            checkValueIsNotEmpty(methodName, partIdDocInfoNode);
            checkValueIsNotEmpty(methodName, partCountDocInfoNode);

            List<NodeElement> artbody = docinfo.get(0).getChildrenListByName("artbody");

            checkTagIsPresent(methodName, "docinfo:artbody", artbody);
            checkValueIsNotEmpty(methodName, artbody);
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
