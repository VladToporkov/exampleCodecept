package com.actionmedia.tests.services.glavbuchservice;

import com.actionmedia.base.AbstractServicesTest;
import com.actionmedia.webservice.MessageElementConverter;
import com.actionmedia.webservice.NodeElement;
import com.actionmedia.webservice.ServiceResponse;
import org.apache.axis.message.MessageElement;
import org.apache.axis.types.UnsignedByte;
import org.testng.annotations.Test;

import java.rmi.RemoteException;
import java.util.List;

import static com.actionmedia.autotest.Group.glavbukh;
import static com.actionmedia.autotest.Group.service;

/**
 * User: n.tyukavkin
 * Date: 21.01.14
 * Time: 18:23
 */
public class Search extends AbstractServicesTest {

    private static final String METHOD_NAME = "Search";

    @Test(groups = {glavbukh, service})
    public void search_test() {
        String searchString = "форма";
        UnsignedByte pubDivId = new UnsignedByte(7);
        int pageNumber = 1;

        report("Тест для проверки метода '" + METHOD_NAME + "'");
        report("URL: " + getSettings().getGlavbukhServiceUrl());
        report("searchString - " + searchString);
        report("pubDivId - " + pubDivId);
        report("pageNumber - " + pageNumber);

        try {
            MessageElement messageElement = getGlavbukhService().search(searchString, pubDivId, pageNumber).get_any()[0];
            ServiceResponse response = new MessageElementConverter(messageElement).getResponse();
            checkLingvoNode(response);
            checkHeaderInfo(response);
            checkSearchList(response);
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }

    public void checkLingvoNode(ServiceResponse response) {
        List<NodeElement> lingvoNodeTagList = response.getNodeElementListByName("lingvo_node");
        if (!lingvoNodeTagList.isEmpty()) {
            NodeElement lingvoNode = lingvoNodeTagList.get(0);
            List<NodeElement> inputSearchStringTagList = lingvoNode.getChildrenListByName("input_search_string");
            List<NodeElement> fixSearchStringTagList = lingvoNode.getChildrenListByName("fix_search_string");
            List<NodeElement> realSearchStringTagList = lingvoNode.getChildrenListByName("real_search_string");
            List<NodeElement> restoreStringFlagTagList = lingvoNode.getChildrenListByName("restore_string_flag");
            List<NodeElement> hashQapTagList = lingvoNode.getChildrenListByName("hash_qap");
            List<NodeElement> idListTagList = lingvoNode.getChildrenListByName("id-list");
            List<NodeElement> idListOriginalTagList = lingvoNode.getChildrenListByName("id-list_original");
            List<NodeElement> idListFuzzyTagList = lingvoNode.getChildrenListByName("id-list-fuzzy");

            checkTagIsPresent(METHOD_NAME, "input_search_string", inputSearchStringTagList);
            checkTagIsPresent(METHOD_NAME, "fix_search_string", fixSearchStringTagList);
            checkTagIsPresent(METHOD_NAME, "real_search_string", realSearchStringTagList);
            checkTagIsPresent(METHOD_NAME, "restore_string_flag", restoreStringFlagTagList);
            checkTagIsPresent(METHOD_NAME, "hash_qap", hashQapTagList);
            checkTagIsPresent(METHOD_NAME, "id-list", idListTagList);
            checkTagIsPresent(METHOD_NAME, "id-list_original", idListOriginalTagList);
            checkTagIsPresent(METHOD_NAME, "id-list-fuzzy", idListFuzzyTagList);

            checkValueIsNotEmpty(METHOD_NAME, inputSearchStringTagList);
            checkValueIsNotEmpty(METHOD_NAME, realSearchStringTagList);
            checkValueIsNotEmpty(METHOD_NAME, restoreStringFlagTagList);
            checkValueIsNotEmpty(METHOD_NAME, hashQapTagList);

            checkIdListItem(idListTagList, "id-list");
            checkIdListItem(idListOriginalTagList, "id-list_original");
            checkIdListItem(idListFuzzyTagList, "id-list-fuzzy");
        } else {
            checkTagIsPresent(METHOD_NAME, "lingvo_node", lingvoNodeTagList);
        }
    }

    private void checkIdListItem(List<NodeElement> idListTagList, String nodeName) {
        if (!idListTagList.isEmpty()) {
            NodeElement idList = idListTagList.get(0);
            List<NodeElement> hashTagList = idList.getChildrenListByName("hash");
            List<NodeElement> idfTagList = idList.getChildrenListByName("idf");
            List<NodeElement> tokenTagList = idList.getChildrenListByName("token");

            checkTagIsPresent(METHOD_NAME, "hash", hashTagList);
            checkTagIsPresent(METHOD_NAME, "idf", idfTagList);
            checkTagIsPresent(METHOD_NAME, "token", tokenTagList);

            checkValueIsNotEmpty(METHOD_NAME, hashTagList);
            checkValueIsNotEmpty(METHOD_NAME, idfTagList);
            checkValueIsNotEmpty(METHOD_NAME, tokenTagList);
        } else {
            checkTagIsPresent(METHOD_NAME, nodeName, idListTagList);
        }
    }

    public void checkHeaderInfo(ServiceResponse response) {
        List<NodeElement> headerInfoTagList = response.getNodeElementListByName("headerinfo");
        if (!headerInfoTagList.isEmpty()) {
            NodeElement headerInfo = headerInfoTagList.get(0);
            List<NodeElement> searchPhraseOriginalTagList = headerInfo.getChildrenListByName("search-phrase-original");
            List<NodeElement> searchPhraseTagList = headerInfo.getChildrenListByName("searchphrase");
            List<NodeElement> searchPhraseFixedTagList = headerInfo.getChildrenListByName("search-phrase-fixed");
            List<NodeElement> pageNumberTagList = headerInfo.getChildrenListByName("pageNumber");
            List<NodeElement> pageSizeTagList = headerInfo.getChildrenListByName("pageSize");
            List<NodeElement> snippetSizeTagList = headerInfo.getChildrenListByName("snippetSize");
            List<NodeElement> searchTypeTagList = headerInfo.getChildrenListByName("search-type");
            List<NodeElement> includeFixedQueryTagList = headerInfo.getChildrenListByName("includeFixedQuery");
            List<NodeElement> mixedSearchTagList = headerInfo.getChildrenListByName("mixedSearch");
            List<NodeElement> onlyTitleSearchTagList = headerInfo.getChildrenListByName("onlyTitleSearch");
            List<NodeElement> docStatusFilterTagList = headerInfo.getChildrenListByName("DocStatusFilter");
            List<NodeElement> sortOrderTagList = headerInfo.getChildrenListByName("sortOrder");
            List<NodeElement> totalDocFoundTagList = headerInfo.getChildrenListByName("totalDocFound");
            List<NodeElement> pubDivListTagList = headerInfo.getChildrenListByName("pubDivList");
            List<NodeElement> pubDivTagTagList = headerInfo.getChildrenListByName("pubDiv");

            checkTagIsPresent(METHOD_NAME, "search-phrase-original", searchPhraseOriginalTagList);
            checkTagIsPresent(METHOD_NAME, "searchphrase", searchPhraseTagList);
            checkTagIsPresent(METHOD_NAME, "search-phrase-fixed", searchPhraseFixedTagList);
            checkTagIsPresent(METHOD_NAME, "pageNumber", pageNumberTagList);
            checkTagIsPresent(METHOD_NAME, "pageSize", pageSizeTagList);
            checkTagIsPresent(METHOD_NAME, "snippetSize", snippetSizeTagList);
            checkTagIsPresent(METHOD_NAME, "search-type", searchTypeTagList);
            checkTagIsPresent(METHOD_NAME, "includeFixedQuery", includeFixedQueryTagList);
            checkTagIsPresent(METHOD_NAME, "mixedSearch", mixedSearchTagList);
            checkTagIsPresent(METHOD_NAME, "onlyTitleSearch", onlyTitleSearchTagList);
            checkTagIsPresent(METHOD_NAME, "DocStatusFilter", docStatusFilterTagList);
            checkTagIsPresent(METHOD_NAME, "sortOrder", sortOrderTagList);
            checkTagIsPresent(METHOD_NAME, "totalDocFound", totalDocFoundTagList);
            checkTagIsPresent(METHOD_NAME, "pubDivList", pubDivListTagList);
            checkTagIsPresent(METHOD_NAME, "pubDiv", pubDivTagTagList);

            checkValueIsNotEmpty(METHOD_NAME, searchPhraseOriginalTagList);
            checkValueIsNotEmpty(METHOD_NAME, searchPhraseTagList);
            checkValueIsNotEmpty(METHOD_NAME, searchPhraseFixedTagList);
            checkValueIsNotEmpty(METHOD_NAME, pageNumberTagList);
            checkValueIsNotEmpty(METHOD_NAME, pageSizeTagList);
            checkValueIsNotEmpty(METHOD_NAME, snippetSizeTagList);
            checkValueIsNotEmpty(METHOD_NAME, searchTypeTagList);
            checkValueIsNotEmpty(METHOD_NAME, includeFixedQueryTagList);
            checkValueIsNotEmpty(METHOD_NAME, mixedSearchTagList);
            checkValueIsNotEmpty(METHOD_NAME, onlyTitleSearchTagList);
            checkValueIsNotEmpty(METHOD_NAME, docStatusFilterTagList);
            checkValueIsNotEmpty(METHOD_NAME, sortOrderTagList);
            checkValueIsNotEmpty(METHOD_NAME, totalDocFoundTagList);
            checkTagIsPresent(METHOD_NAME, "pubDiv", pubDivTagTagList);
        } else {
            checkTagIsPresent(METHOD_NAME, "headerinfo", headerInfoTagList);
        }
    }

    public void checkSearchList(ServiceResponse response) {
        List<NodeElement> searchListTagList = response.getNodeElementListByName("searchlist");
        if (!searchListTagList.isEmpty()) {
            NodeElement searchList = searchListTagList.get(0);
            List<NodeElement> itemFoundTagList = searchList.getChildrenListByName("itemfound");
            if (!itemFoundTagList.isEmpty()) {
                NodeElement itemFound = itemFoundTagList.get(0);

                List<NodeElement> artNameTagList = itemFound.getChildrenListByName("artname");
                List<NodeElement> modIdTagList = itemFound.getChildrenListByName("modId");
                List<NodeElement> docIdTagList = itemFound.getChildrenListByName("docId");
                List<NodeElement> searchIndexTagList = itemFound.getChildrenListByName("search-index");
                List<NodeElement> relevanceTagList = itemFound.getChildrenListByName("relevance");
                List<NodeElement> legalForceTagList = itemFound.getChildrenListByName("legal-force");
                List<NodeElement> snippetCaptionTagList = itemFound.getChildrenListByName("snippetCaption");

                checkTagIsPresent(METHOD_NAME, "artname", artNameTagList);
                checkTagIsPresent(METHOD_NAME, "modId", modIdTagList);
                checkTagIsPresent(METHOD_NAME, "docId", docIdTagList);
                checkTagIsPresent(METHOD_NAME, "search-index", searchIndexTagList);
                checkTagIsPresent(METHOD_NAME, "relevance", relevanceTagList);
                checkTagIsPresent(METHOD_NAME, "legal-force", legalForceTagList);
                checkTagIsPresent(METHOD_NAME, "snippetCaption", snippetCaptionTagList);

                checkValueIsNotEmpty(METHOD_NAME, artNameTagList);
                checkValueIsNotEmpty(METHOD_NAME, modIdTagList);
                checkValueIsNotEmpty(METHOD_NAME, docIdTagList);
                checkValueIsNotEmpty(METHOD_NAME, searchIndexTagList);
                checkValueIsNotEmpty(METHOD_NAME, relevanceTagList);
                checkValueIsNotEmpty(METHOD_NAME, legalForceTagList);
            } else {
                checkTagIsPresent(METHOD_NAME, "itemfound", itemFoundTagList);
            }
        } else {
            checkTagIsPresent(METHOD_NAME, "searchlist", searchListTagList);
        }
    }
}
