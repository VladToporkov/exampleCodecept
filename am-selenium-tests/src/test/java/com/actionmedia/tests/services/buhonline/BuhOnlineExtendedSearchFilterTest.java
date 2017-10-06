package com.actionmedia.tests.services.buhonline;

import com.actionmedia.base.AbstractServicesTest;
import com.actionmedia.webservice.MessageElementConverter;
import com.actionmedia.webservice.NodeElement;
import com.actionmedia.webservice.ServiceResponse;
import com.actionmedia.webservice.buhonline.FilterType;
import org.apache.axis.message.MessageElement;
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
public class BuhOnlineExtendedSearchFilterTest extends AbstractServicesTest {

    @Test(groups = {buhonline, service})
    public void buhonline_ExtendedSearchFilter_test() {
        String methodName = "ExtendedSearchFilter";

        FilterType variableAttribute = FilterType.Lobby;
        int regionId = 50;
        int typeId = 11;
        int lobbyId = 1;
        boolean isActual = true;
        String preferedRegionCode = "77";

        report("Тест для проверки метода '" + methodName + "'");
        report("Адрес сервиса 'Программа главбух': " + getSettings().getBuhOnLineServiceUrl());
        report("variableAttribute - " + variableAttribute.getValue());
        report("regionId - " + regionId);
        report("typeId - " + typeId);
        report("lobbyId - " + lobbyId);
        report("isActual - " + isActual);
        report("preferedRegionCode - " + preferedRegionCode);

        try {
            MessageElement messageElement = getBuhOnlineService().extendedSearchFilter(variableAttribute, regionId, typeId, lobbyId, isActual, preferedRegionCode).get_any()[0];
            MessageElementConverter converter = new MessageElementConverter(messageElement);
            ServiceResponse response = converter.getResponse();

            List<NodeElement> docLobbyList = response.getNodeElementListByName("DocLobbyList");
            List<NodeElement> docLobby = response.getNodeElementListByName("DocLobby");
            List<NodeElement> id = response.getNodeElementListByName("ID");
            List<NodeElement> name = response.getNodeElementListByName("Name");
            List<NodeElement> briefName = response.getNodeElementListByName("BriefName");
            List<NodeElement> keyWords = response.getNodeElementListByName("KeyWords");

            checkTagIsPresent(methodName, "DocLobbyList", docLobbyList);
            checkTagIsPresent(methodName, "DocLobby", docLobby);
            checkTagIsPresent(methodName, "ID", id);
            checkTagIsPresent(methodName, "Name", name);
            checkTagIsPresent(methodName, "BriefName", briefName);
            checkTagIsPresent(methodName, "KeyWords", keyWords);

            checkValueIsNotEmpty(methodName, id);
            checkValueIsNotEmpty(methodName, name);
            checkValueIsNotEmpty(methodName, briefName);
            checkValueIsNotEmpty(methodName, keyWords);

            checkAttributeIsPresent("count", docLobbyList.get(0).getAttributes(), methodName);
            checkAttributeIsPresent("actual-document-filter", docLobbyList.get(0).getAttributes(), methodName);

        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
