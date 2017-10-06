package com.actionmedia.tests.services.searchservice;

import com.actionmedia.base.AbstractServicesTest;
import com.actionmedia.webservice.MessageElementConverter;
import com.actionmedia.webservice.NodeElement;
import com.actionmedia.webservice.ServiceResponse;
import org.apache.axis.message.MessageElement;
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
public class SearchCode extends AbstractServicesTest {

    private static final String METHOD_NAME = "SearchCode";

    @Test(groups = {search, service})
    public void searchCode_test() {
        String codeTypeAlias = "okpd";
        String searchString = "конфеты шоколадные";

        try {
            report("Тест для проверки метода '" + METHOD_NAME + "'");
            report("Адрес сервиса поиска: " + getSettings().getSearchServiceUrl());
            report("pubId - " + codeTypeAlias);
            report("SearchString - " + searchString);

            MessageElement search = getSearchService().searchCode(codeTypeAlias, searchString).get_any()[0];
            ServiceResponse response = new MessageElementConverter(search).getResponse();

            List<NodeElement> searchStringTagList = response.getNodeElementListByName("searchString");
            List<NodeElement> codeTypeAliasTagList = response.getNodeElementListByName("codeTypeAlias");
            List<NodeElement> codeListTagList = response.getNodeElementListByName("codeList");
            List<NodeElement> highlightWordsTagList = response.getNodeElementListByName("highlightWords");

            checkTagIsPresent(METHOD_NAME, "searchString", searchStringTagList);
            checkTagIsPresent(METHOD_NAME, "codeTypeAlias", codeTypeAliasTagList);

            checkValueIsNotEmpty(METHOD_NAME, searchStringTagList);
            checkValueIsNotEmpty(METHOD_NAME, codeTypeAliasTagList);

            if (!codeListTagList.isEmpty()) {
                NodeElement codeListTag = codeListTagList.get(0);
                List<NodeElement> codeList = codeListTag.getChildrenListByName("code");
                checkTagIsPresent(METHOD_NAME, "code", codeList);
                checkValueIsNotEmpty(METHOD_NAME, codeList);
            } else {
                checkTagIsPresent(METHOD_NAME, "codeList", codeListTagList);
            }

            if (!highlightWordsTagList.isEmpty()) {
                NodeElement highlightWordsTag = highlightWordsTagList.get(0);
                List<NodeElement> wordTagList = highlightWordsTag.getChildrenListByName("word");
                checkTagIsPresent(METHOD_NAME, "word", wordTagList);
                checkValueIsNotEmpty(METHOD_NAME, wordTagList);
            } else {
                checkTagIsPresent(METHOD_NAME, "highlightWords", highlightWordsTagList);
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
