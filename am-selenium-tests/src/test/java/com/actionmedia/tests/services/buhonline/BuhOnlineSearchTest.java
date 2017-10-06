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
public class BuhOnlineSearchTest extends AbstractServicesTest {

    @Test(groups = {buhonline, service})
    public void buhonline_Search_test() {
        String methodName = "Search";

        UnsignedByte pubDivId = new UnsignedByte(7);
        String searchString = "ведомость на отпуск";
        int pageNumber = 1;
        int pageSize = 50;

        report("Тест для проверки метода '" + methodName + "'");
        report("Адрес сервиса 'Программа главбух': " + getSettings().getBuhOnLineServiceUrl());
        report("pubDivId - " + pubDivId);
        report("searchString - " + searchString);
        report("pageNumber - " + pageNumber);
        report("pageSize - " + pageSize);

        try {
            MessageElement messageElement = getBuhOnlineService().search(pubDivId, searchString, pageNumber, pageSize).get_any()[0];
            MessageElementConverter converter = new MessageElementConverter(messageElement);
            ServiceResponse response = converter.getResponse();

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

                checkTagIsPresent(methodName, "input_search_string", inputSearchStringTagList);
                checkTagIsPresent(methodName, "fix_search_string", fixSearchStringTagList);
                checkTagIsPresent(methodName, "real_search_string", realSearchStringTagList);
                checkTagIsPresent(methodName, "restore_string_flag", restoreStringFlagTagList);
                checkTagIsPresent(methodName, "hash_qap", hashQapTagList);
                checkTagIsPresent(methodName, "id-list", idListTagList);
                checkTagIsPresent(methodName, "id-list_original", idListOriginalTagList);
                checkTagIsPresent(methodName, "id-list-fuzzy", idListFuzzyTagList);

                checkValueIsNotEmpty(methodName, restoreStringFlagTagList);
                checkValueIsNotEmpty(methodName, hashQapTagList);
            } else {
                checkTagIsPresent(methodName, "lingvo_node", lingvoNodeTagList);
            }

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
                List<NodeElement> exactSearchTagList = headerInfo.getChildrenListByName("exactSearch");
                List<NodeElement> sortOrderTagList = headerInfo.getChildrenListByName("sortOrder");
                List<NodeElement> totalDocFoundTagList = headerInfo.getChildrenListByName("totalDocFound");

                checkTagIsPresent(methodName, "search-phrase-original", searchPhraseOriginalTagList);
                checkTagIsPresent(methodName, "searchphrase", searchPhraseTagList);
                checkTagIsPresent(methodName, "search-phrase-fixed", searchPhraseFixedTagList);
                checkTagIsPresent(methodName, "pageNumber", pageNumberTagList);
                checkTagIsPresent(methodName, "pageSize", pageSizeTagList);
                checkTagIsPresent(methodName, "snippetSize", snippetSizeTagList);
                checkTagIsPresent(methodName, "search-type", searchTypeTagList);
                checkTagIsPresent(methodName, "includeFixedQuery", includeFixedQueryTagList);
                checkTagIsPresent(methodName, "mixedSearch", mixedSearchTagList);
                checkTagIsPresent(methodName, "onlyTitleSearch", onlyTitleSearchTagList);
                checkTagIsPresent(methodName, "DocStatusFilter", docStatusFilterTagList);
                checkTagIsPresent(methodName, "exactSearch", exactSearchTagList);
                checkTagIsPresent(methodName, "sortOrder", sortOrderTagList);
                checkTagIsPresent(methodName, "totalDocFound", totalDocFoundTagList);

                checkValueIsNotEmpty(methodName, pageNumberTagList);
                checkValueIsNotEmpty(methodName, pageSizeTagList);
                checkValueIsNotEmpty(methodName, snippetSizeTagList);
                checkValueIsNotEmpty(methodName, searchTypeTagList);
                checkValueIsNotEmpty(methodName, includeFixedQueryTagList);
                checkValueIsNotEmpty(methodName, mixedSearchTagList);
                checkValueIsNotEmpty(methodName, onlyTitleSearchTagList);
                checkValueIsNotEmpty(methodName, docStatusFilterTagList);
                checkValueIsNotEmpty(methodName, exactSearchTagList);
                checkValueIsNotEmpty(methodName, sortOrderTagList);
                checkValueIsNotEmpty(methodName, totalDocFoundTagList);

                List<NodeElement> pubDivListTagList = headerInfo.getChildrenListByName("pubDivList");
                if (!pubDivListTagList.isEmpty()) {
                    List<NodeElement> pubDivTagList = pubDivListTagList.get(0).getChildrenListByName("pubDiv");
                    if (!pubDivTagList.isEmpty()) {
                        for (NodeElement pubDiv : pubDivTagList) {
                            checkAttributeIsPresent("id", pubDiv.getAttributes(), methodName);
                            checkAttributeIsPresent("alias", pubDiv.getAttributes(), methodName);
                            checkAttributeIsPresent("flags", pubDiv.getAttributes(), methodName);
                            if (!pubDiv.getAttributes().get("id").equals("10")) {
                                checkAttributeIsPresent("itemTypes", pubDiv.getAttributes(), methodName);
                            }
                        }
                    } else {
                        checkTagIsPresent(methodName, "pubDiv", pubDivTagList);
                    }
                } else {
                    checkTagIsPresent(methodName, "pubDivList", pubDivListTagList);
                }
            } else {
                checkTagIsPresent(methodName, "headerinfo", headerInfoTagList);
            }

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
                    List<NodeElement> snippetTagList = itemFound.getChildrenListByName("snippet");
                    List<NodeElement> snippetCaptionTagList = itemFound.getChildrenListByName("snippetCaption");

                    checkTagIsPresent(methodName, "artname", artNameTagList);
                    checkTagIsPresent(methodName, "modId", modIdTagList);
                    checkTagIsPresent(methodName, "docId", docIdTagList);
                    checkTagIsPresent(methodName, "search-index", searchIndexTagList);
                    checkTagIsPresent(methodName, "relevance", relevanceTagList);
                    checkTagIsPresent(methodName, "legal-force", legalForceTagList);
                    checkTagIsPresent(methodName, "snippet", snippetTagList);
                    checkTagIsPresent(methodName, "snippetCaption", snippetCaptionTagList);

                    checkValueIsNotEmpty(methodName, artNameTagList);
                    checkValueIsNotEmpty(methodName, modIdTagList);
                    checkValueIsNotEmpty(methodName, docIdTagList);
                    checkValueIsNotEmpty(methodName, searchIndexTagList);
                    checkValueIsNotEmpty(methodName, relevanceTagList);
                    checkValueIsNotEmpty(methodName, legalForceTagList);
                } else {
                    checkTagIsPresent(methodName, "itemfound", itemFoundTagList);
                }
            } else {
                checkTagIsPresent(methodName, "searchlist", searchListTagList);
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
