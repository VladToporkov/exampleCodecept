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
 * Time: 16:51
 */
public class GetAdvSearchLobbyList extends AbstractServicesTest {

    private static final String METHOD_NAME = "GetAdvSearchLobbyList";

    @Test(groups = {search, service})
    public void getAdvSearchLobbyList_test() {
        UnsignedByte pubId = new UnsignedByte(6);
        String csvTypeIDFilter = "1,2,3";
        String csvRegionIDFilter = "11,12,13";
        String csvCategoryIDFilter = "";
        boolean isActualDocumentOnly = true;
        boolean isLucene = false;

        try {
            report("Тест для проверки метода '" + METHOD_NAME + "'");
            report("Адрес сервиса поиска: " + getSettings().getSearchServiceUrl());
            report("pubId - " + pubId);
            report("csvTypeIDFilter - " + csvTypeIDFilter);
            report("csvRegionIDFilter - " + csvRegionIDFilter);
            report("csvCategoryIDFilter - " + csvCategoryIDFilter);
            report("isActualDocumentOnly - " + isActualDocumentOnly);
            report("isLucene - " + isLucene);

            MessageElement search = getSearchService().getAdvSearchLobbyList(pubId, csvTypeIDFilter, csvRegionIDFilter, csvCategoryIDFilter, isActualDocumentOnly, isLucene).get_any()[0];
            ServiceResponse response = new MessageElementConverter(search).getResponse();

            List<NodeElement> docLobbyListTagList = response.getNodeElementListByName("DocLobbyList");
            List<NodeElement> docLobbyTagList = response.getNodeElementListByName("DocLobby");
            List<NodeElement> idTagList = response.getNodeElementListByName("ID");
            List<NodeElement> nameTagList = response.getNodeElementListByName("Name");
            List<NodeElement> briefNameTagList = response.getNodeElementListByName("BriefName");
            List<NodeElement> keyWordsTagList = response.getNodeElementListByName("KeyWords");

            checkTagIsPresent(METHOD_NAME, "DocLobbyList", docLobbyListTagList);
            checkTagIsPresent(METHOD_NAME, "DocLobby", docLobbyTagList);
            checkTagIsPresent(METHOD_NAME, "ID", idTagList);
            checkTagIsPresent(METHOD_NAME, "Name", nameTagList);
            checkTagIsPresent(METHOD_NAME, "BriefName", briefNameTagList);
            checkTagIsPresent(METHOD_NAME, "KeyWords", keyWordsTagList);

            checkValueIsNotEmpty(METHOD_NAME, idTagList);
            checkValueIsNotEmpty(METHOD_NAME, nameTagList);
            checkValueIsNotEmpty(METHOD_NAME, briefNameTagList);
            checkValueIsNotEmpty(METHOD_NAME, keyWordsTagList);

            if (docLobbyListTagList != null) {
                checkAttributeIsPresent("count", docLobbyListTagList.get(0).getAttributes(), METHOD_NAME);
            }

        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
