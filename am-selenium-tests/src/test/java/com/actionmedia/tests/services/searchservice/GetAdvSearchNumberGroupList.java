package com.actionmedia.tests.services.searchservice;

import com.actionmedia.base.AbstractServicesTest;
import com.actionmedia.webservice.MessageElementConverter;
import com.actionmedia.webservice.NodeElement;
import com.actionmedia.webservice.ServiceResponse;
import org.apache.axis.message.MessageElement;
import org.apache.axis.types.UnsignedByte;
import org.testng.annotations.Test;

import java.rmi.RemoteException;
import java.util.List;

import static com.actionmedia.autotest.Group.search;
import static com.actionmedia.autotest.Group.service;

/**
 * User: n.tyukavkin
 * Date: 22.11.15
 * Time: 21:48
 */
public class GetAdvSearchNumberGroupList extends AbstractServicesTest {

    private static final String METHOD_NAME = "GetAdvSearchNumberGroupList";

    @Test(groups = {search, service})
    public void getAdvSearchNumberGroupList_test() {
        UnsignedByte pubId = new UnsignedByte(6);
        UnsignedByte moduleID = new UnsignedByte(98);
        int id = 6549665;
        boolean isLucene = true;

        try {
            report("Тест для проверки метода '" + METHOD_NAME + "'");
            report("Адрес сервиса поиска: " + getSettings().getSearchServiceUrl());
            report("pubId - " + pubId);
            report("moduleID - " + moduleID);
            report("id - " + id);
            report("isLucene - " + isLucene);

            MessageElement search = getSearchService().getAdvSearchNumberGroupList(pubId, moduleID, id, isLucene).get_any()[0];
            ServiceResponse response = new MessageElementConverter(search).getResponse();


            List<NodeElement> numberListTagList = response.getNodeElementListByName("numberList");
            if (!numberListTagList.isEmpty()) {
                NodeElement numberListTag = numberListTagList.get(0);
                List<NodeElement> numberTagList = numberListTag.getChildrenListByName("number");
                if (!numberTagList.isEmpty()) {
                    checkAttributeIsPresent("value", numberTagList.get(0).getAttributes(), METHOD_NAME);
                } else {
                    checkTagIsPresent(METHOD_NAME, "number", numberTagList);
                }
            } else {
                checkTagIsPresent(METHOD_NAME, "numberList", numberListTagList);
            }

            List<NodeElement> docListTagList = response.getNodeElementListByName("docList");
            if (!docListTagList.isEmpty()) {
                NodeElement docListTag = docListTagList.get(0);
                List<NodeElement> docTagList = docListTag.getChildrenListByName("doc");
                if (!docTagList.isEmpty()) {
                    NodeElement docTag = docTagList.get(0);
                    List<NodeElement> titleTagList = docTag.getChildrenListByName("title");
                    List<NodeElement> snippetTagList = docTag.getChildrenListByName("snippet");

                    checkTagIsPresent(METHOD_NAME, "numberList", titleTagList);
                    checkTagIsPresent(METHOD_NAME, "numberList", snippetTagList);

                    checkValueIsNotEmpty(METHOD_NAME, titleTagList);
                    checkValueIsNotEmpty(METHOD_NAME, snippetTagList);

                    checkAttributeIsPresent("modID", docTag.getAttributes(), METHOD_NAME);
                    checkAttributeIsPresent("docID", docTag.getAttributes(), METHOD_NAME);
                    checkAttributeIsPresent("number", docTag.getAttributes(), METHOD_NAME);
                } else {
                    checkTagIsPresent(METHOD_NAME, "doc", docTagList);
                }
            } else {
                checkTagIsPresent(METHOD_NAME, "docList", docListTagList);
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
