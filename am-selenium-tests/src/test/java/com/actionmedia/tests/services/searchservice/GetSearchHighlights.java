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
 * Time: 16:07
 */
public class GetSearchHighlights extends AbstractServicesTest {

    @Test(groups = {search, service})
    public void getSearchHighlights_test() {
        String methodName = "GetSearchHighlights";

        UnsignedByte pubId = new UnsignedByte(6);
        String searchString = "цели";
        UnsignedByte moduleId = new UnsignedByte(99);
        int documentId = 902316088;

        try {
            report("Тест для проверки метода '" + methodName + "'");
            report("Адрес сервиса поиска: " + getSettings().getSearchServiceUrl());
            report("pubId - " + pubId);
            report("searchString - " + searchString);
            report("moduleId - " + moduleId);
            report("documentId - " + documentId);

            MessageElement search = getSearchService().getSearchHighlights(pubId, searchString, moduleId, documentId).get_any()[0];
            ServiceResponse response = new MessageElementConverter(search).getResponse();

            List<NodeElement> searchStringTagList = response.getNodeElementListByName("searchString");
            List<NodeElement> moduleIdTagList = response.getNodeElementListByName("moduleId");
            List<NodeElement> documentIdTagList = response.getNodeElementListByName("documentId");
            List<NodeElement> highlightWordsTagList = response.getNodeElementListByName("highlightWords");
            List<NodeElement> wordTagList = response.getNodeElementListByName("word");

            checkTagIsPresent(methodName, "searchString", searchStringTagList);
            checkTagIsPresent(methodName, "moduleId", moduleIdTagList);
            checkTagIsPresent(methodName, "documentId", documentIdTagList);
            checkTagIsPresent(methodName, "highlightWords", highlightWordsTagList);
            checkTagIsPresent(methodName, "word", wordTagList);

            checkValueIsNotEmpty(methodName, searchStringTagList);
            checkValueIsNotEmpty(methodName, moduleIdTagList);
            checkValueIsNotEmpty(methodName, documentIdTagList);
            checkValueIsNotEmpty(methodName, wordTagList);

        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}