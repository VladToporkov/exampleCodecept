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
public class GetAdvSearchCategoryList extends AbstractServicesTest {

    private static final String METHOD_NAME = "GetAdvSearchCategoryList";

    @Test(groups = {search, service})
    public void getAdvSearchCategoryList_test() {
        UnsignedByte pubId = new UnsignedByte(6);
        String csvTypeIDFilter = "21";
        String csvLobbyIDFilter = "";
        boolean isActualDocumentOnly = true;
        boolean isLucene = true;

        try {
            report("Тест для проверки метода '" + METHOD_NAME + "'");
            report("Адрес сервиса поиска: " + getSettings().getSearchServiceUrl());
            report("pubId - " + pubId);
            report("csvTypeIDFilter - " + csvTypeIDFilter);
            report("csvLobbyIDFilter - " + csvLobbyIDFilter);
            report("isActualDocumentOnly - " + isActualDocumentOnly);
            report("isLucene - " + isLucene);

            MessageElement search = getSearchService().getAdvSearchCategoryList(pubId, csvTypeIDFilter, csvLobbyIDFilter, isActualDocumentOnly, isLucene).get_any()[0];
            ServiceResponse response = new MessageElementConverter(search).getResponse();

            List<NodeElement> docCategoryListTagList = response.getNodeElementListByName("DocCategoryList");
            if (!docCategoryListTagList.isEmpty()) {
                NodeElement docCategoryListTag = docCategoryListTagList.get(0);
                List<NodeElement> docCategoryTagList = docCategoryListTag.getChildrenListByName("DocCategory");
                if (!docCategoryTagList.isEmpty()) {
                    NodeElement docCategoryTag = docCategoryTagList.get(0);
                    List<NodeElement> idTagList = docCategoryTag.getChildrenListByName("ID");
                    List<NodeElement> nameTagList = docCategoryTag.getChildrenListByName("Name");
                    List<NodeElement> sortNumTagList = docCategoryTag.getChildrenListByName("SortNum");

                    checkTagIsPresent(METHOD_NAME, "ID", idTagList);
                    checkTagIsPresent(METHOD_NAME, "Name", nameTagList);
                    checkTagIsPresent(METHOD_NAME, "SortNum", sortNumTagList);

                    checkValueIsNotEmpty(METHOD_NAME, idTagList);
                    checkValueIsNotEmpty(METHOD_NAME, nameTagList);
                    checkValueIsNotEmpty(METHOD_NAME, sortNumTagList);
                } else {
                    checkTagIsPresent(METHOD_NAME, "DocCategory", docCategoryTagList);
                }
            } else {
                checkTagIsPresent(METHOD_NAME, "DocCategoryList", docCategoryListTagList);
            }

            if (docCategoryListTagList != null) {
                checkAttributeIsPresent("count", docCategoryListTagList.get(0).getAttributes(), METHOD_NAME);
                checkAttributeIsPresent("actual-document-filter", docCategoryListTagList.get(0).getAttributes(), METHOD_NAME);
            }

        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
