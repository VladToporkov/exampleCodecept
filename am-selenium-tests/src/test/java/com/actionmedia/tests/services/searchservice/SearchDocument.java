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
 * Date: 15.01.14
 * Time: 17:18
 */
public class SearchDocument extends AbstractServicesTest {

    @Test(groups = {search, service})
    public void searchDocument_test() {
        String methodName = "SearchDocument";

        String searchString = "35-ЗРТ";

        try {
            report("Тест для проверки метода '" + methodName + "'");
            report("Адрес сервиса поиска: " + getSettings().getSearchServiceUrl());
            report("searchString - " + searchString);

            MessageElement search = getSearchService().searchDocument(searchString).get_any()[0];
            ServiceResponse response = new MessageElementConverter(search).getResponse();

            List<NodeElement> inputSearchStringTagList = response.getNodeElementListByName("input_search_string");
            List<NodeElement> fixSearchStringTagList = response.getNodeElementListByName("fix_search_string");
            List<NodeElement> realSearchStringTagList = response.getNodeElementListByName("real_search_string");
            List<NodeElement> restoreStringFlagTagList = response.getNodeElementListByName("restore_string_flag");
            List<NodeElement> hashQapTagList = response.getNodeElementListByName("hash_qap");
            List<NodeElement> idListTagList = response.getNodeElementListByName("id-list");
            List<NodeElement> idListOriginalTagList = response.getNodeElementListByName("id-list_original");
            List<NodeElement> idListFuzzyTagList = response.getNodeElementListByName("id-list-fuzzy");
            List<NodeElement> hashTagList = response.getNodeElementListByName("hash");
            List<NodeElement> idfTagList = response.getNodeElementListByName("idf");
            List<NodeElement> tokenTagList = response.getNodeElementListByName("token");
            List<NodeElement> searchTagListTagList = response.getNodeElementListByName("searchTagList");
            List<NodeElement> searchTagTagList = response.getNodeElementListByName("searchTag");
            List<NodeElement> searchListTagList = response.getNodeElementListByName("searchlist");
            List<NodeElement> itemFoundTagList = response.getNodeElementListByName("itemfound");
            List<NodeElement> artNameTagList = response.getNodeElementListByName("artname");
            List<NodeElement> modIdTagList = response.getNodeElementListByName("modId");
            List<NodeElement> docIdTagList = response.getNodeElementListByName("docId");
            List<NodeElement> searchIndexTagList = response.getNodeElementListByName("search-index");
            List<NodeElement> relevanceTagList = response.getNodeElementListByName("relevance");
            List<NodeElement> legalForceTagList = response.getNodeElementListByName("legal-force");

            checkTagIsPresent(methodName, "input_search_string", inputSearchStringTagList);
            checkTagIsPresent(methodName, "fix_search_string", fixSearchStringTagList);
            checkTagIsPresent(methodName, "real_search_string", realSearchStringTagList);
            checkTagIsPresent(methodName, "restore_string_flag", restoreStringFlagTagList);
            checkTagIsPresent(methodName, "hash_qap", hashQapTagList);
            checkTagIsPresent(methodName, "id-list", idListTagList);
            checkTagIsPresent(methodName, "id-list_original", idListOriginalTagList);
            checkTagIsPresent(methodName, "id-list-fuzzy", idListFuzzyTagList);
            checkTagIsPresent(methodName, "hash", hashTagList);
            checkTagIsPresent(methodName, "idf", idfTagList);
            checkTagIsPresent(methodName, "token", tokenTagList);
            checkTagIsPresent(methodName, "searchTagList", searchTagListTagList);
            checkTagIsPresent(methodName, "searchTag", searchTagTagList);
            checkTagIsPresent(methodName, "searchlist", searchListTagList);
            checkTagIsPresent(methodName, "itemfound", itemFoundTagList);
            checkTagIsPresent(methodName, "artname", artNameTagList);
            checkTagIsPresent(methodName, "modId", modIdTagList);
            checkTagIsPresent(methodName, "docId", docIdTagList);
            checkTagIsPresent(methodName, "search-index", searchIndexTagList);
            checkTagIsPresent(methodName, "relevance", relevanceTagList);
            checkTagIsPresent(methodName, "legal-force", legalForceTagList);

            checkValueIsNotEmpty(methodName, artNameTagList);
            checkValueIsNotEmpty(methodName, modIdTagList);
            checkValueIsNotEmpty(methodName, docIdTagList);
            checkValueIsNotEmpty(methodName, searchIndexTagList);
            checkValueIsNotEmpty(methodName, relevanceTagList);
            checkValueIsNotEmpty(methodName, legalForceTagList);

        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
