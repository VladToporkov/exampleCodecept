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
public class BuhOnlineDocumentTest extends AbstractServicesTest {

    @Test(groups = {buhonline, service})
    public void buhonline_Document_test() {
        String methodName = "Document";

        UnsignedByte moduleId = new UnsignedByte(140);
        int id = 14288;
        String anchor = "";
        boolean isActual = true;

        report("Тест для проверки метода '" + methodName + "'");
        report("Адрес сервиса 'Программа главбух': " + getSettings().getBuhOnLineServiceUrl());
        report("id - " + moduleId);
        report("attachId - " + id);
        report("anchor - " + anchor);
        report("isActual - " + isActual);

        try {
            MessageElement messageElement = getBuhOnlineService().document(moduleId, id, anchor, isActual).get_any()[0];
            MessageElementConverter converter = new MessageElementConverter(messageElement);
            ServiceResponse response = converter.getResponse();

            List<NodeElement> content = response.getNodeElementListByName("content");
            List<NodeElement> container = response.getNodeElementListByName("container");
            List<NodeElement> headerinfo = response.getNodeElementListByName("headerinfo");
            List<NodeElement> pubDivList = response.getNodeElementListByName("pubDivList");
            List<NodeElement> docinfo = response.getNodeElementListByName("docinfo");
            List<NodeElement> breadcrumbsList = response.getNodeElementListByName("BreadcrumbsList");
            List<NodeElement> revisionList = response.getNodeElementListByName("revisionList");

            checkTagIsPresent(methodName, "content", content);
            checkTagIsPresent(methodName, "container", container);
            checkTagIsPresent(methodName, "headerinfo", headerinfo);
            checkTagIsPresent(methodName, "pubDivList", pubDivList);
            checkTagIsPresent(methodName, "docinfo", docinfo);
            checkTagIsPresent(methodName, "breadcrumbsList", breadcrumbsList);
            checkTagIsPresent(methodName, "revisionList", revisionList);

            String[] headerNodeNameArr = new String[]{"PubID", "PubDivID", "HostUrl", "document_id", "modul_id", "AncorTo"};
            String[] headerNodeValueArr = new String[]{"PubID", "PubDivID", "document_id", "modul_id"};
            for (String tagName : headerNodeNameArr) {
                List<NodeElement> tagNode = headerinfo.get(0).getChildrenListByName(tagName);
                checkTagIsPresent(methodName, tagName, tagNode);
            }
            for (String tagName : headerNodeValueArr) {
                List<NodeElement> tagNode = headerinfo.get(0).getChildrenListByName(tagName);
                checkValueIsNotEmpty(methodName, tagNode);
            }

            List<NodeElement> pubDivNodeList = pubDivList.get(0).getChildrenListByName("pubDiv");
            checkTagIsPresent(methodName, "pubDiv", pubDivNodeList);
            for (NodeElement pubDiv : pubDivNodeList){
                checkAttributeIsPresent("id", pubDiv.getAttributes(), methodName);
                checkAttributeIsPresent("alias", pubDiv.getAttributes(), methodName);
                checkAttributeIsPresent("flags", pubDiv.getAttributes(), methodName);
                if (!pubDiv.getAttributes().get("id").equals("10")){
                    checkAttributeIsPresent("itemTypes", pubDiv.getAttributes(), methodName);
                }
            }

            checkAttributeIsPresent("type", docinfo.get(0).getAttributes(), methodName);
            checkAttributeIsPresent("status", docinfo.get(0).getAttributes(), methodName);
            checkAttributeIsPresent("begDate", docinfo.get(0).getAttributes(), methodName);

            List<NodeElement> idDocInfoNode = docinfo.get(0).getChildrenListByName("id");
            checkTagIsPresent(methodName, "docinfo:id", idDocInfoNode);
            checkAttributeIsPresent("type", idDocInfoNode.get(0).getAttributes(), methodName);
            checkAttributeIsPresent("value", idDocInfoNode.get(0).getAttributes(), methodName);
            String[] breadcrumNodeName = new String[]{"Number", "RubricatorID", "ID", "Name"};
            for (String tagName : breadcrumNodeName) {
                List<NodeElement> tagNode = breadcrumbsList.get(0).getChildrenListByName(tagName);
                checkTagIsPresent(methodName, tagName, tagNode);
                checkValueIsNotEmpty(methodName, tagNode);
            }
            List<NodeElement> exportFileName = docinfo.get(0).getChildrenListByName("ExportFileName");
            checkTagIsPresent(methodName, "ExportFileName", exportFileName);
            checkValueIsNotEmpty(methodName, exportFileName);

            List<NodeElement> revisionRevisionList = revisionList.get(0).getChildrenListByName("revision");
            List<NodeElement> idListRevisionList = revisionList.get(0).getChildrenListByName("idList");
            List<NodeElement> idRevisionList = revisionList.get(0).getChildrenListByName("id");
            checkTagIsPresent(methodName, "revisionList:revision", revisionRevisionList);
            checkTagIsPresent(methodName, "revisionList:idList", idListRevisionList);
            checkTagIsPresent(methodName, "revisionList:id", idRevisionList);
            checkAttributeIsPresent("startDate", revisionRevisionList.get(0).getAttributes(), methodName);
            checkAttributeIsPresent("status", revisionRevisionList.get(0).getAttributes(), methodName);
            checkAttributeIsPresent("type", idRevisionList.get(0).getAttributes(), methodName);
            checkAttributeIsPresent("value", idRevisionList.get(0).getAttributes(), methodName);
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
