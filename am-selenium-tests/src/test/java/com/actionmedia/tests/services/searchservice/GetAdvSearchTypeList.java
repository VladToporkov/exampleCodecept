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
 * Date: 14.01.14
 * Time: 18:11
 */
public class GetAdvSearchTypeList extends AbstractServicesTest {

    @Test(groups = {search, service})
    public void getAdvSearchTypeList_test() {
        String methodName = "GetAdvSearchTypeList";

        UnsignedByte pubId = new UnsignedByte(6);
        String csvRegionIDFilter = "50";
        String csvLobbyIDFilter = "367";
        String csvCategoryIDFilter = "";
        boolean isActualDocumentOnly = true;
        boolean isLucene = false;

        try {
            report("Тест для проверки метода '" + methodName + "'");
            report("Адрес сервиса поиска: " + getSettings().getSearchServiceUrl());
            report("pubId - " + pubId);
            report("csvRegionIDFilter - " + csvRegionIDFilter);
            report("csvLobbyIDFilter - " + csvLobbyIDFilter);
            report("csvCategoryIDFilter - " + csvCategoryIDFilter);
            report("isActualDocumentOnly - " + isActualDocumentOnly);
            report("isLucene - " + isLucene);

            MessageElement search = getSearchService().getAdvSearchTypeList(pubId, csvRegionIDFilter, csvLobbyIDFilter, csvCategoryIDFilter, isActualDocumentOnly, isLucene).get_any()[0];
            ServiceResponse response = new MessageElementConverter(search).getResponse();

            List<NodeElement> docTypeListTagList = response.getNodeElementListByName("DocTypeList");
            List<NodeElement> docTypeTagList = response.getNodeElementListByName("DocType");
            List<NodeElement> idTagList = response.getNodeElementListByName("ID");
            List<NodeElement> nameTagList = response.getNodeElementListByName("Name");

            checkTagIsPresent(methodName, "DocTypeList", docTypeListTagList);
            checkTagIsPresent(methodName, "DocType", docTypeTagList);
            checkTagIsPresent(methodName, "ID", idTagList);
            checkTagIsPresent(methodName, "Name", nameTagList);

            checkValueIsNotEmpty(methodName, idTagList);
            checkValueIsNotEmpty(methodName, nameTagList);

            if (docTypeListTagList != null) {
                checkAttributeIsPresent("count", docTypeListTagList.get(0).getAttributes(), methodName);
            }

        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
