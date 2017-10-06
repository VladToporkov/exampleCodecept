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
 * Date: 01.06.17
 * Time: 22:07
 */
public class GetPacketSearchSuggestions extends AbstractServicesTest {

    private static final String METHOD_NAME = "GetPacketSearchSuggestions";

    @Test(groups = {search, service})
    public void getPacketSearchSuggestions_packet1091_test() {
        UnsignedByte pubId = new UnsignedByte(57);
        UnsignedByte pubDivId = new UnsignedByte(7);
        String mask = "акт";
        int packetId = 1091;

        try {
            report("Тест для проверки метода '" + METHOD_NAME + "'. Пакет 1091");
            report("Адрес сервиса поиска: " + getSettings().getSearchServiceUrl());
            report("pubId - " + pubId);
            report("pubDivId - " + pubDivId);
            report("mask - " + mask);
            report("packetId - " + packetId);

            MessageElement search = getSearchService().getPacketSearchSuggestions(pubId, pubDivId, mask, packetId).get_any()[0];
            ServiceResponse response = new MessageElementConverter(search).getResponse();

            List<NodeElement> itemTagList = response.getNodeElementListByName("item");
            if (!itemTagList.isEmpty()) {
                NodeElement itemTag = itemTagList.get(0);

                checkAttributeIsPresent("type", itemTag.getAttributes(), METHOD_NAME);
                checkAttributeValue("type", "link", itemTag.getAttributes(), METHOD_NAME);

                checkAttributeIsPresent("modID", itemTag.getAttributes(), METHOD_NAME);
                checkAttributeValue("modID", "118", itemTag.getAttributes(), METHOD_NAME);

                checkAttributeIsPresent("docID", itemTag.getAttributes(), METHOD_NAME);
                checkAttributeValue("docID", "50271", itemTag.getAttributes(), METHOD_NAME);

                postponedAssertEquals(itemTag.getValue(), "Акт об установленном расхождении в количестве и качестве при приемке товара (для аптек) (форма)", "Неправильный формат ответного xml для метода '" + METHOD_NAME + "'. Неправильное значение для тэга 'item'");
            } else {
                checkTagIsPresent(METHOD_NAME, "item", itemTagList);
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }

    @Test(groups = {search, service})
    public void getPacketSearchSuggestions_packet1159_test() {
        UnsignedByte pubId = new UnsignedByte(54);
        UnsignedByte pubDivId = new UnsignedByte(7);
        String mask = "пол";
        int packetId = 1159;

        try {
            report("Тест для проверки метода '" + METHOD_NAME + "'. Пакет 1159");
            report("Адрес сервиса поиска: " + getSettings().getSearchServiceUrl());
            report("pubId - " + pubId);
            report("pubDivId - " + pubDivId);
            report("mask - " + mask);
            report("packetId - " + packetId);

            MessageElement search = getSearchService().getPacketSearchSuggestions(pubId, pubDivId, mask, packetId).get_any()[0];
            ServiceResponse response = new MessageElementConverter(search).getResponse();

            List<NodeElement> itemTagList = response.getNodeElementListByName("item");
            if (!itemTagList.isEmpty()) {
                NodeElement itemTag = itemTagList.get(0);

                checkAttributeIsPresent("type", itemTag.getAttributes(), METHOD_NAME);
                checkAttributeValue("type", "link", itemTag.getAttributes(), METHOD_NAME);

                checkAttributeIsPresent("modID", itemTag.getAttributes(), METHOD_NAME);
                checkAttributeValue("modID", "118", itemTag.getAttributes(), METHOD_NAME);

                checkAttributeIsPresent("docID", itemTag.getAttributes(), METHOD_NAME);
                checkAttributeValue("docID", "50936", itemTag.getAttributes(), METHOD_NAME);

                postponedAssertEquals(itemTag.getValue(), "Положение об использовании Интернета на рабочем месте (форма)", "Неправильный формат ответного xml для метода '" + METHOD_NAME + "'. Неправильное значение для тэга 'item'");
            } else {
                checkTagIsPresent(METHOD_NAME, "item", itemTagList);
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
