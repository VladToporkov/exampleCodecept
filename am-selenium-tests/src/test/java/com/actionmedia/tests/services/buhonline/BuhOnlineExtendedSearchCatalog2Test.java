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
public class BuhOnlineExtendedSearchCatalog2Test extends AbstractServicesTest {

    @Test(groups = {buhonline, service})
    public void buhonline_ExtendedSearchCatalog_test() {
        String methodName = "ExtendedSearchCatalog2";

        UnsignedByte pubDivId = new UnsignedByte(13);
        String preferedRegionCode = "16";

        report("Тест для проверки метода 'ExtendedSearchCatalog'");
        report("Адрес сервиса 'Программа главбух': " + getSettings().getBuhOnLineServiceUrl());
        report("pubDivId - " + pubDivId);
        report("preferedRegionCode - " + preferedRegionCode);

        try {
            MessageElement messageElement = getBuhOnlineService().extendedSearchCatalog2(pubDivId, preferedRegionCode).get_any()[0];
            MessageElementConverter converter = new MessageElementConverter(messageElement);
            ServiceResponse response = converter.getResponse();

            List<NodeElement> docRegionListTagList = response.getNodeElementListByName("DocRegionList");
            List<NodeElement> docLobbyListTagList = response.getNodeElementListByName("DocLobbyList");
            List<NodeElement> docTypeListTagList = response.getNodeElementListByName("DocTypeList");

            if (!docRegionListTagList.isEmpty()) {
                List<NodeElement> docRegionTagList = docRegionListTagList.get(0).getChildrenListByName("DocRegion");
                if (!docRegionTagList.isEmpty()) {
                    for (NodeElement docRegion : docRegionTagList) {
                        List<NodeElement> idRegion = docRegion.getChildrenListByName("ID");
                        List<NodeElement> nameRegion = docRegion.getChildrenListByName("Name");
                        List<NodeElement> codeRegion = docRegion.getChildrenListByName("RegionCode");

                        checkTagIsPresent(methodName, "DocRegion:ID", idRegion);
                        checkTagIsPresent(methodName, "DocRegion:Name", nameRegion);
                        checkTagIsPresent(methodName, "DocRegion:RegionCode", codeRegion);

                        checkValueIsNotEmpty(methodName, idRegion);
                        checkValueIsNotEmpty(methodName, nameRegion);
                        checkValueIsNotEmpty(methodName, codeRegion);
                    }
                } else {
                    checkTagIsPresent(methodName, "DocRegion", docRegionTagList);
                }
            } else {
                checkTagIsPresent(methodName, "DocRegionList", docRegionListTagList);
            }

            if (!docLobbyListTagList.isEmpty()) {
                List<NodeElement> docLobbyTagList = docLobbyListTagList.get(0).getChildrenListByName("DocLobby");
                if (!docLobbyTagList.isEmpty()) {
                    for (NodeElement docRegion : docLobbyTagList) {
                        List<NodeElement> idLobby = docRegion.getChildrenListByName("ID");
                        List<NodeElement> nameLobby = docRegion.getChildrenListByName("Name");
                        List<NodeElement> briefNameLobby = docRegion.getChildrenListByName("BriefName");
                        List<NodeElement> keyWordsLobby = docRegion.getChildrenListByName("KeyWords");

                        checkTagIsPresent(methodName, "DocLobby:ID", idLobby);
                        checkTagIsPresent(methodName, "DocLobby:Name", nameLobby);
                        checkTagIsPresent(methodName, "DocLobby:BriefName", briefNameLobby);
                        checkTagIsPresent(methodName, "DocLobby:KeyWords", keyWordsLobby);

                        checkValueIsNotEmpty(methodName, idLobby);
                        checkValueIsNotEmpty(methodName, nameLobby);
                        checkValueIsNotEmpty(methodName, briefNameLobby);
                        checkValueIsNotEmpty(methodName, keyWordsLobby);
                    }
                } else {
                    checkTagIsPresent(methodName, "DocLobby", docLobbyTagList);
                }
            } else {
                checkTagIsPresent(methodName, "DocLobbyList", docLobbyListTagList);
            }

            if (!docTypeListTagList.isEmpty()) {
                List<NodeElement> docTypeTagList = docTypeListTagList.get(0).getChildrenListByName("DocType");
                if (!docTypeTagList.isEmpty()) {
                    for (NodeElement docRegion : docTypeTagList) {
                        List<NodeElement> idType = docRegion.getChildrenListByName("ID");
                        List<NodeElement> nameType = docRegion.getChildrenListByName("Name");

                        checkTagIsPresent(methodName, "DocType:ID", idType);
                        checkTagIsPresent(methodName, "DocType:Name", nameType);

                        checkValueIsNotEmpty(methodName, idType);
                        checkValueIsNotEmpty(methodName, nameType);
                    }
                } else {
                    checkTagIsPresent(methodName, "DocType", docTypeTagList);
                }
            } else {
                checkTagIsPresent(methodName, "DocTypeList", docTypeListTagList);
            }

        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
