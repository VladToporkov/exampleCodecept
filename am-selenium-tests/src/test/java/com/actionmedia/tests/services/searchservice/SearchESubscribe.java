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
 * Date: 23.03.16
 * Time: 22:24
 */
public class SearchESubscribe extends AbstractServicesTest {

    private static final String METHOD_NAME = "SearchESubscribe";

    @Test(groups = {search, service})
    public void searchESubscribe_test() {
        String searchString = "медикаменты";
        int[] issueIdList = new int[]{290};
        Integer pageNumber = 1;
        Integer pageSize = 20;
        Integer searchFlag = 32;
        Integer lingvoFlag = 0;
        int[] searchTagList = new int[]{10004};

        try {
            report("Тест для проверки метода '" + METHOD_NAME + "'");
            report("Адрес сервиса поиска: " + getSettings().getSearchServiceUrl());
            report("searchString - " + searchString);
            report("issueIdList - " + convertArrayToString(issueIdList));
            report("pageNumber - " + pageNumber);
            report("pageSize - " + pageSize);
            report("searchFlag - " + searchFlag);
            report("lingvoFlag - " + lingvoFlag);
            report("searchTagList - " + convertArrayToString(searchTagList));

            MessageElement search = getSearchService().searchESubscribe(searchString, issueIdList, pageNumber, pageSize, searchFlag, lingvoFlag, searchTagList).get_any()[0];
            ServiceResponse response = new MessageElementConverter(search).getResponse();

            checkLingvoNode(response, false);
            checkHeaderInfo(response, false);
            checkSearchList(response);

        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }

    private void checkLingvoNode(ServiceResponse response, boolean isEmptySearchString) {
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

            if (!isEmptySearchString) {
                checkValueIsNotEmpty(METHOD_NAME, inputSearchStringTagList);
                checkValueIsNotEmpty(METHOD_NAME, realSearchStringTagList);

                checkIdListItem(idListTagList, "id-list");
                checkIdListItem(idListOriginalTagList, "id-list_original");
                checkIdListItem(idListFuzzyTagList, "id-list-fuzzy");
            }
            checkValueIsNotEmpty(METHOD_NAME, restoreStringFlagTagList);
            checkValueIsNotEmpty(METHOD_NAME, hashQapTagList);
        } else {
            checkTagIsPresent(METHOD_NAME, "lingvo_node", lingvoNodeTagList);
        }
    }

    private void checkHeaderInfo(ServiceResponse response, boolean isEmptySearchString) {
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
            List<NodeElement> searchTagListTagList = headerInfo.getChildrenListByName("searchTagList");

            if (!isEmptySearchString) {
                checkTagIsPresent(METHOD_NAME, "search-phrase-original", searchPhraseOriginalTagList);
                checkValueIsNotEmpty(METHOD_NAME, searchPhraseOriginalTagList);
                checkValueIsNotEmpty(METHOD_NAME, searchPhraseTagList);
                checkValueIsNotEmpty(METHOD_NAME, searchPhraseFixedTagList);
            }

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
            checkTagIsPresent(METHOD_NAME, "searchTagList", searchTagListTagList);

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

            if (!searchTagListTagList.isEmpty()) {
                NodeElement searchTag = searchTagListTagList.get(0);
                List<NodeElement> searchTagTagList = headerInfo.getChildrenListByName("searchTag");
                if (!searchTagTagList.isEmpty()) {
                    List<NodeElement> idTagList = searchTag.getChildrenListByName("id");
                    List<NodeElement> nameTagList = searchTag.getChildrenListByName("name");

                    checkTagIsPresent(METHOD_NAME, "id", idTagList);
                    checkTagIsPresent(METHOD_NAME, "name", nameTagList);
                } else {
                    checkTagIsPresent(METHOD_NAME, "searchTag", searchTagTagList);
                }
            } else {
                checkTagIsPresent(METHOD_NAME, "searchTagList", searchTagListTagList);
            }
        } else {
            checkTagIsPresent(METHOD_NAME, "headerinfo", headerInfoTagList);
        }
    }

    private void checkSearchList(ServiceResponse response) {
        List<NodeElement> searchListTagList = response.getNodeElementListByName("searchlist");
        if (!searchListTagList.isEmpty()) {
            NodeElement searchList = searchListTagList.get(0);
            List<NodeElement> itemFoundTagList = searchList.getChildrenListByName("itemfound");
            if (!itemFoundTagList.isEmpty()) {
                NodeElement itemFound;
                if (itemFoundTagList.get(0).getChildrenListByName("artname").get(0).getValue() != null) {
                    itemFound = itemFoundTagList.get(0);
                } else {
                    itemFound = itemFoundTagList.get(1);
                }

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
}
