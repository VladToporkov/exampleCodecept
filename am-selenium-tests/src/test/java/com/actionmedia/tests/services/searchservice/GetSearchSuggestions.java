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
 * Date: 15.01.14
 * Time: 16:56
 */
public class GetSearchSuggestions extends AbstractServicesTest {

    @Test(groups = {search, service})
    public void getSearchSuggestions_test() {
        String methodName = "GetSearchSuggestions";

        UnsignedByte pubId = new UnsignedByte(6);
        UnsignedByte pubDivId = new UnsignedByte(1);
        String mask = "1";

        try {
            report("Тест для проверки метода '" + methodName + "'");
            report("Адрес сервиса поиска: " + getSettings().getSearchServiceUrl());
            report("pubId - " + pubId);
            report("pubDivId - " + pubDivId);
            report("mask - " + mask);

            MessageElement search = getSearchService().getSearchSuggestions(pubId, pubDivId, mask).get_any()[0];
            ServiceResponse response = new MessageElementConverter(search).getResponse();

            List<NodeElement> listTagList = response.getNodeElementListByName("list");
            List<NodeElement> itemTagList = response.getNodeElementListByName("item");

            checkTagIsPresent(methodName, "list", listTagList);
            checkTagIsPresent(methodName, "item", itemTagList);

            checkValueIsNotEmpty(methodName, itemTagList);

            assertNotNull(listTagList.get(0).getAttributes().get("type"), "Неправильный формат ответного xml для метода '" + methodName + "'. Отсутствует свойство 'type' для тэга 'list'");
            assertNotNull(listTagList.get(0).getAttributes().get("mask"), "Неправильный формат ответного xml для метода '" + methodName + "'. Отсутствует свойство 'mask' для тэга 'list'");

            postponedAssertFalse(listTagList.get(0).getAttributes().get("type").isEmpty(), "Неправильный формат ответного xml для метода '" + methodName + "'. Свойство 'type' для тэга 'list' пустое");
            postponedAssertFalse(listTagList.get(0).getAttributes().get("mask").isEmpty(), "Неправильный формат ответного xml для метода '" + methodName + "'. Свойство 'mask' для тэга 'list' пустое");

            for (NodeElement itemTag : itemTagList) {
                String typeAttr = itemTag.getAttributes().get("type");
                assertNotNull(itemTag.getAttributes().get("type"), "Неправильный формат ответного xml для метода '" + methodName + "'. Отсутствует свойство 'type' для тэга 'item'");

                if (typeAttr != null && typeAttr.equals("link")) {
                    assertNotNull(itemTag.getAttributes().get("weight"), "Неправильный формат ответного xml для метода '" + methodName + "'. Отсутствует свойство 'weight' для тэга 'item'");
                    assertNotNull(itemTag.getAttributes().get("modID"), "Неправильный формат ответного xml для метода '" + methodName + "'. Отсутствует свойство 'modID' для тэга 'item'");
                    assertNotNull(itemTag.getAttributes().get("docID"), "Неправильный формат ответного xml для метода '" + methodName + "'. Отсутствует свойство 'docID' для тэга 'item'");
                    assertNotNull(itemTag.getAttributes().get("anchor"), "Неправильный формат ответного xml для метода '" + methodName + "'. Отсутствует свойство 'anchor' для тэга 'item'");
                    assertNotNull(itemTag.getAttributes().get("actual"), "Неправильный формат ответного xml для метода '" + methodName + "'. Отсутствует свойство 'actual' для тэга 'item'");

                    postponedAssertFalse(itemTag.getAttributes().get("type").isEmpty(), "Неправильный формат ответного xml для метода '" + methodName + "'. Свойство 'type' для тэга 'item' пустое");
                    postponedAssertFalse(itemTag.getAttributes().get("weight").isEmpty(), "Неправильный формат ответного xml для метода '" + methodName + "'. Свойство 'weight' для тэга 'item' пустое");
                    postponedAssertFalse(itemTag.getAttributes().get("modID").isEmpty(), "Неправильный формат ответного xml для метода '" + methodName + "'. Свойство 'modID' для тэга 'item' пустое");
                    postponedAssertFalse(itemTag.getAttributes().get("docID").isEmpty(), "Неправильный формат ответного xml для метода '" + methodName + "'. Свойство 'docID' для тэга 'item' пустое");
                    postponedAssertFalse(itemTag.getAttributes().get("anchor").isEmpty(), "Неправильный формат ответного xml для метода '" + methodName + "'. Свойство 'anchor' для тэга 'item' пустое");
                    postponedAssertFalse(itemTag.getAttributes().get("actual").isEmpty(), "Неправильный формат ответного xml для метода '" + methodName + "'. Свойство 'actual' для тэга 'item' пустое");
                }

                if (typeAttr != null && typeAttr.equals("searchNearby")) {
                    assertNotNull(itemTag.getAttributes().get("weight"), "Неправильный формат ответного xml для метода '" + methodName + "'. Отсутствует свойство 'weight' для тэга 'item'");
                    assertNotNull(itemTag.getAttributes().get("pubdivid"), "Неправильный формат ответного xml для метода '" + methodName + "'. Отсутствует свойство 'pubdivid' для тэга 'item'");

                    postponedAssertFalse(itemTag.getAttributes().get("type").isEmpty(), "Неправильный формат ответного xml для метода '" + methodName + "'. Свойство 'type' для тэга 'item' пустое");
                    postponedAssertFalse(itemTag.getAttributes().get("weight").isEmpty(), "Неправильный формат ответного xml для метода '" + methodName + "'. Свойство 'weight' для тэга 'item' пустое");
                    postponedAssertFalse(itemTag.getAttributes().get("pubdivid").isEmpty(), "Неправильный формат ответного xml для метода '" + methodName + "'. Свойство 'pubdivid' для тэга 'item' пустое");
                }

                if (typeAttr != null && typeAttr.equals("search")) {
                    assertNotNull(itemTag.getAttributes().get("weight"), "Неправильный формат ответного xml для метода '" + methodName + "'. Отсутствует свойство 'weight' для тэга 'item'");

                    postponedAssertFalse(itemTag.getAttributes().get("type").isEmpty(), "Неправильный формат ответного xml для метода '" + methodName + "'. Свойство 'type' для тэга 'item' пустое");
                }
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
