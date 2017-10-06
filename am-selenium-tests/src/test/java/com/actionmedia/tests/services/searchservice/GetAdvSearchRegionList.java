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
public class GetAdvSearchRegionList extends AbstractServicesTest {

    private static final String METHOD_NAME = "GetAdvSearchRegionList";

    @Test(groups = {search, service})
    public void getAdvSearchRegionList_EmptyField_test() {
        UnsignedByte pubId = new UnsignedByte(6);
        String prefferedRegionCode = "";
        String csvTypeIDFilter = "1,2,3";
        String csvLobbyIDFilter = "367";
        boolean isActualDocumentOnly = true;
        boolean isLucene = false;

        try {
            report("Тест для проверки метода '" + METHOD_NAME + "'");
            report("Адрес сервиса поиска: " + getSettings().getSearchServiceUrl());
            report("pubId - " + pubId);
            report("prefferedRegionCode - " + prefferedRegionCode);
            report("csvTypeIDFilter - " + csvTypeIDFilter);
            report("csvLobbyIDFilter - " + csvLobbyIDFilter);
            report("isActualDocumentOnly - " + isActualDocumentOnly);
            report("isLucene - " + isLucene);

            MessageElement search = getSearchService().getAdvSearchRegionList(pubId, prefferedRegionCode, csvTypeIDFilter, csvLobbyIDFilter, isActualDocumentOnly, isLucene).get_any()[0];
            ServiceResponse response = new MessageElementConverter(search).getResponse();

            List<NodeElement> docRegionListTagList = response.getNodeElementListByName("DocRegionList");
            List<NodeElement> docRegionList = response.getNodeElementListByName("DocRegion");
            List<NodeElement> idTagList = response.getNodeElementListByName("ID");
            List<NodeElement> nameTagList = response.getNodeElementListByName("Name");
            List<NodeElement> regionCodeTagList = response.getNodeElementListByName("RegionCode");

            checkTagIsPresent(METHOD_NAME, "DocRegionList", docRegionListTagList);
            checkTagIsPresent(METHOD_NAME, "DocRegion", docRegionList);
            checkTagIsPresent(METHOD_NAME, "ID", idTagList);
            checkTagIsPresent(METHOD_NAME, "Name", nameTagList);
            checkTagIsPresent(METHOD_NAME, "RegionCode", regionCodeTagList);

            checkValueIsNotEmpty(METHOD_NAME, idTagList);
            checkValueIsNotEmpty(METHOD_NAME, nameTagList);
            checkValueIsNotEmpty(METHOD_NAME, regionCodeTagList);

            if (docRegionListTagList != null) {
                checkAttributeIsPresent("count", docRegionListTagList.get(0).getAttributes(), METHOD_NAME);
            }

        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
