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
 * Time: 17:50
 */
public class SpellText extends AbstractServicesTest {

    @Test(groups = {search, service})
    public void spellText_test() {
        String methodName = "SpellText";

        UnsignedByte pubId = new UnsignedByte(6);
        String searchString = "rjltrx";

        try {
            report("Тест для проверки метода '" + methodName + "'");
            report("Адрес сервиса поиска: " + getSettings().getSearchServiceUrl());
            report("pubId - " + pubId);
            report("searchString - " + searchString);

            MessageElement search = getSearchService().spellText(pubId, searchString).get_any()[0];
            ServiceResponse response = new MessageElementConverter(search).getResponse();

            List<NodeElement> inputSearchStringTagList = response.getNodeElementListByName("input_search_string");
            List<NodeElement> fixSearchStringTagList = response.getNodeElementListByName("fix_search_string");
            List<NodeElement> realSearchStringTagList = response.getNodeElementListByName("real_search_string");
            List<NodeElement> restoreStringFlagTagList = response.getNodeElementListByName("restore_string_flag");
            List<NodeElement> errorTagList = response.getNodeElementListByName("error");
            List<NodeElement> wordTagList = response.getNodeElementListByName("word");
            List<NodeElement> suggestTagList = response.getNodeElementListByName("suggest");
            List<NodeElement> idListFuzzyTagList = response.getNodeElementListByName("id-list-fuzzy");
            List<NodeElement> itemTagList = response.getNodeElementListByName("item");
            List<NodeElement> hashTagList = response.getNodeElementListByName("hash");
            List<NodeElement> idfTagList = response.getNodeElementListByName("idf");
            List<NodeElement> tokenTagList = response.getNodeElementListByName("token");

            checkTagIsPresent(methodName, "input_search_string", inputSearchStringTagList);
            checkTagIsPresent(methodName, "fix_search_string", fixSearchStringTagList);
            checkTagIsPresent(methodName, "real_search_string", realSearchStringTagList);
            checkTagIsPresent(methodName, "restore_string_flag", restoreStringFlagTagList);
            checkTagIsPresent(methodName, "error", errorTagList);
            checkTagIsPresent(methodName, "word", wordTagList);
            checkTagIsPresent(methodName, "suggest", suggestTagList);
            checkTagIsPresent(methodName, "id-list-fuzzy", idListFuzzyTagList);
            checkTagIsPresent(methodName, "hash", itemTagList);
            checkTagIsPresent(methodName, "hash", hashTagList);
            checkTagIsPresent(methodName, "idf", idfTagList);
            checkTagIsPresent(methodName, "token", tokenTagList);

            checkValueIsNotEmpty(methodName, inputSearchStringTagList);
            checkValueIsNotEmpty(methodName, fixSearchStringTagList);
            checkValueIsNotEmpty(methodName, realSearchStringTagList);
            checkValueIsNotEmpty(methodName, restoreStringFlagTagList);
            checkValueIsNotEmpty(methodName, wordTagList);
            checkValueIsNotEmpty(methodName, suggestTagList);
            checkValueIsNotEmpty(methodName, hashTagList);
            checkValueIsNotEmpty(methodName, idfTagList);
            checkValueIsNotEmpty(methodName, tokenTagList);

        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
