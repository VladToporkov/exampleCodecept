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
 * Date: 18.03.2014
 * Time: 16:47
 */
public class PacketSearch extends AbstractServicesTest {

    private static final String METHOD_NAME = "PacketSearch";

    @Test(groups = {glavbukh, service})
    public void packetSearch_test() {
        String searchString;
        UnsignedByte pubDivId;
        int pageNumber;
        int packetId;
        if (getSettings().isRunBss()) {
            searchString = "ндс";
            pubDivId = new UnsignedByte(1);
            pageNumber = 1;
            packetId = 116;
        } else {
            searchString = "ндс";
            pubDivId = new UnsignedByte(7);
            pageNumber = 1;
            packetId = 116;
        }

        report("Тест для проверки метода '" + METHOD_NAME + "'");
        report("URL: " + getSettings().getGlavbukhServiceUrl());
        report("searchString - " + searchString);
        report("pubDivId - " + pubDivId);
        report("pageNumber - " + pageNumber);
        report("packetId - " + packetId);

        try {
            MessageElement messageElement = getGlavbukhService().packetSearch(searchString, pubDivId, pageNumber, packetId, getSettings().isRunBss()).get_any()[0];
            ServiceResponse response = new MessageElementConverter(messageElement).getResponse();
            List<NodeElement> documentList = response.getNodeElementListByName("documents");
            if (!documentList.isEmpty()) {
                NodeElement documentsNode = documentList.get(0);
                checkAttributeIsPresent("cache", documentsNode.getAttributes(), METHOD_NAME);

                List<NodeElement> lingvoNodeList = documentsNode.getChildrenListByName("lingvo_node");
                if (!lingvoNodeList.isEmpty()) {
                    NodeElement lingvoNode = lingvoNodeList.get(0);

                    List<NodeElement> searchObjectList = lingvoNode.getChildrenListByName("SearchObject");
                    if (!searchObjectList.isEmpty()) {
                        NodeElement searchObject = searchObjectList.get(0);
                        checkAttributeIsPresent("result", searchObject.getAttributes(), METHOD_NAME);
                        List<NodeElement> inputSearchStringList = searchObject.getChildrenListByName("input_search_string");
                        List<NodeElement> fixSearchStringList = searchObject.getChildrenListByName("fix_search_string");
                        List<NodeElement> realSearchStringList = searchObject.getChildrenListByName("real_search_string");
                        List<NodeElement> restoreStringFlagList = searchObject.getChildrenListByName("restore_string_flag");
                        List<NodeElement> hashQapList = searchObject.getChildrenListByName("hash_qap");
                        List<NodeElement> idListList = searchObject.getChildrenListByName("id-list");
                        List<NodeElement> idListOriginalList = searchObject.getChildrenListByName("id-list_original");
                        List<NodeElement> idListFuzzyList = searchObject.getChildrenListByName("id-list-fuzzy");

                        checkTagIsPresent(METHOD_NAME, "input_search_string", inputSearchStringList);
                        checkTagIsPresent(METHOD_NAME, "fix_search_string", fixSearchStringList);
                        checkTagIsPresent(METHOD_NAME, "real_search_string", realSearchStringList);
                        checkTagIsPresent(METHOD_NAME, "restore_string_flag", restoreStringFlagList);
                        checkTagIsPresent(METHOD_NAME, "hash_qap", hashQapList);
                        checkTagIsPresent(METHOD_NAME, "id-list", idListList);
                        checkTagIsPresent(METHOD_NAME, "id-list_original", idListOriginalList);
                        checkTagIsPresent(METHOD_NAME, "id-list-fuzzy", idListFuzzyList);

                        checkValueIsNotEmpty(METHOD_NAME, inputSearchStringList);
                        checkValueIsNotEmpty(METHOD_NAME, realSearchStringList);
                        checkValueIsNotEmpty(METHOD_NAME, restoreStringFlagList);
                        checkValueIsNotEmpty(METHOD_NAME, hashQapList);
                    } else {
                        checkTagIsPresent(METHOD_NAME, "SearchObject", searchObjectList);
                    }
                } else {
                    checkTagIsPresent(METHOD_NAME, "lingvo_node", lingvoNodeList);
                }
                List<NodeElement> headerInfoList = documentsNode.getChildrenListByName("headerinfo");
                if (!headerInfoList.isEmpty()) {
                    NodeElement headerNode = headerInfoList.get(0);
                    List<NodeElement> searchPhraseOriginalList = headerNode.getChildrenListByName("search-phrase-original");
                    List<NodeElement> searchPhraseList = headerNode.getChildrenListByName("searchphrase");
                    List<NodeElement> searchPhraseFixedList = headerNode.getChildrenListByName("search-phrase-fixed");
                    List<NodeElement> pageNumberList = headerNode.getChildrenListByName("pageNumber");
                    List<NodeElement> pageSizeList = headerNode.getChildrenListByName("pageSize");
                    List<NodeElement> snippetSizeList = headerNode.getChildrenListByName("snippetSize");
                    List<NodeElement> searchTypeList = headerNode.getChildrenListByName("search-type");
                    List<NodeElement> includeFixedQueryList = headerNode.getChildrenListByName("includeFixedQuery");
                    List<NodeElement> mixedSearchList = headerNode.getChildrenListByName("mixedSearch");
                    List<NodeElement> onlyTitleSearchList = headerNode.getChildrenListByName("onlyTitleSearch");
                    List<NodeElement> docStatusFilterList = headerNode.getChildrenListByName("DocStatusFilter");
                    List<NodeElement> sortOrderList = headerNode.getChildrenListByName("sortOrder");
                    List<NodeElement> totalDocFoundList = headerNode.getChildrenListByName("totalDocFound");
                    List<NodeElement> pubDivListList = headerNode.getChildrenListByName("pubDivList");

                    checkTagIsPresent(METHOD_NAME, "search-phrase-original", searchPhraseOriginalList);
                    checkTagIsPresent(METHOD_NAME, "searchphrase", searchPhraseList);
                    checkTagIsPresent(METHOD_NAME, "search-phrase-fixed", searchPhraseFixedList);
                    checkTagIsPresent(METHOD_NAME, "pageNumber", pageNumberList);
                    checkTagIsPresent(METHOD_NAME, "pageSize", pageSizeList);
                    checkTagIsPresent(METHOD_NAME, "snippetSize", snippetSizeList);
                    checkTagIsPresent(METHOD_NAME, "search-type", searchTypeList);
                    checkTagIsPresent(METHOD_NAME, "includeFixedQuery", includeFixedQueryList);
                    checkTagIsPresent(METHOD_NAME, "mixedSearch", mixedSearchList);
                    checkTagIsPresent(METHOD_NAME, "onlyTitleSearch", onlyTitleSearchList);
                    checkTagIsPresent(METHOD_NAME, "DocStatusFilter", docStatusFilterList);
                    checkTagIsPresent(METHOD_NAME, "sortOrder", sortOrderList);
                    checkTagIsPresent(METHOD_NAME, "totalDocFound", totalDocFoundList);

                    checkValueIsNotEmpty(METHOD_NAME, searchPhraseOriginalList);
                    checkValueIsNotEmpty(METHOD_NAME, searchPhraseList);
                    checkValueIsNotEmpty(METHOD_NAME, searchPhraseFixedList);
                    checkValueIsNotEmpty(METHOD_NAME, pageNumberList);
                    checkValueIsNotEmpty(METHOD_NAME, pageSizeList);
                    checkValueIsNotEmpty(METHOD_NAME, snippetSizeList);
                    checkValueIsNotEmpty(METHOD_NAME, searchTypeList);
                    checkValueIsNotEmpty(METHOD_NAME, includeFixedQueryList);
                    checkValueIsNotEmpty(METHOD_NAME, mixedSearchList);
                    checkValueIsNotEmpty(METHOD_NAME, onlyTitleSearchList);
                    checkValueIsNotEmpty(METHOD_NAME, docStatusFilterList);
                    checkValueIsNotEmpty(METHOD_NAME, sortOrderList);
                    checkValueIsNotEmpty(METHOD_NAME, totalDocFoundList);

                    if (!pubDivListList.isEmpty()) {
                        NodeElement pubDivListNode = pubDivListList.get(0);
                        List<NodeElement> pubDivList = pubDivListNode.getChildrenListByName("pubDiv");
                        if (!pubDivList.isEmpty()) {
                            NodeElement pubDivNode = pubDivList.get(0);
                            checkAttributeIsPresent("id", pubDivNode.getAttributes(), METHOD_NAME);
                            checkAttributeIsPresent("alias", pubDivNode.getAttributes(), METHOD_NAME);
                            List<NodeElement> nameList = pubDivNode.getChildrenListByName("name");
                            if (!nameList.isEmpty()) {
                                NodeElement nameNode = nameList.get(0);
                                checkAttributeIsPresent("forms", nameNode.getAttributes(), METHOD_NAME);
                            } else {
                                checkTagIsPresent(METHOD_NAME, "pubDiv", pubDivList);
                            }
                        } else {
                            checkTagIsPresent(METHOD_NAME, "pubDiv", pubDivList);
                        }
                    } else {
                        checkTagIsPresent(METHOD_NAME, "pubDivList", pubDivListList);
                    }
                } else {
                    checkTagIsPresent(METHOD_NAME, "headerinfo", headerInfoList);
                }

                List<NodeElement> searchInfoList = documentsNode.getChildrenListByName("search-info");
                if (!searchInfoList.isEmpty()) {
                    NodeElement searchInfoNode = searchInfoList.get(0);
                    List<NodeElement> lastPosList = searchInfoNode.getChildrenListByName("last-pos");
                    List<NodeElement> lastSearchTypeList = searchInfoNode.getChildrenListByName("last-search-type");
                    List<NodeElement> endOfSearchList = searchInfoNode.getChildrenListByName("end-of-search");

                    checkTagIsPresent(METHOD_NAME, "last-pos", lastPosList);
                    checkTagIsPresent(METHOD_NAME, "last-search-type", lastSearchTypeList);
                    checkTagIsPresent(METHOD_NAME, "end-of-search", endOfSearchList);

                    checkValueIsNotEmpty(METHOD_NAME, lastPosList);
                    checkValueIsNotEmpty(METHOD_NAME, lastSearchTypeList);
                    checkValueIsNotEmpty(METHOD_NAME, endOfSearchList);
                } else {
                    checkTagIsPresent(METHOD_NAME, "search-info", searchInfoList);
                }

                List<NodeElement> searchDebugInfoList = documentsNode.getChildrenListByName("search-debug-info");

                if (!searchDebugInfoList.isEmpty()) {
                    NodeElement searchDebugInfoNode = searchDebugInfoList.get(0);
                    List<NodeElement> normalTokenList = searchDebugInfoNode.getChildrenListByName("normal-token-list");
                    List<NodeElement> synonymTokenList = searchDebugInfoNode.getChildrenListByName("synonym-token-list");
                    List<NodeElement> searchTimeList = searchDebugInfoNode.getChildrenListByName("SearchTime");
                    List<NodeElement> koefPopularList = searchDebugInfoNode.getChildrenListByName("koef-popular");
                    List<NodeElement> koefCitationList = searchDebugInfoNode.getChildrenListByName("koef-citation");
                    List<NodeElement> koefCitationLocalList = searchDebugInfoNode.getChildrenListByName("koef-citation-local");
                    List<NodeElement> koefLingvoList = searchDebugInfoNode.getChildrenListByName("koef-lingvo");
                    List<NodeElement> koefTransitionList = searchDebugInfoNode.getChildrenListByName("koef-transition");
                    List<NodeElement> commonQuestionList = searchDebugInfoNode.getChildrenListByName("common-question");

                    checkTagIsPresent(METHOD_NAME, "normal-token-list", normalTokenList);
                    checkTagIsPresent(METHOD_NAME, "synonym-token-list", synonymTokenList);
                    checkTagIsPresent(METHOD_NAME, "SearchTime", searchTimeList);
                    checkTagIsPresent(METHOD_NAME, "koef-popular", koefPopularList);
                    checkTagIsPresent(METHOD_NAME, "koef-citation", koefCitationList);
                    checkTagIsPresent(METHOD_NAME, "koef-citation-local", koefCitationLocalList);
                    checkTagIsPresent(METHOD_NAME, "koef-lingvo", koefLingvoList);
                    checkTagIsPresent(METHOD_NAME, "koef-transition", koefTransitionList);
                    checkTagIsPresent(METHOD_NAME, "common-question", commonQuestionList);

                    checkValueIsNotEmpty(METHOD_NAME, searchTimeList);
                    checkValueIsNotEmpty(METHOD_NAME, koefPopularList);
                    checkValueIsNotEmpty(METHOD_NAME, koefCitationList);
                    checkValueIsNotEmpty(METHOD_NAME, koefCitationLocalList);
                    checkValueIsNotEmpty(METHOD_NAME, koefLingvoList);
                    checkValueIsNotEmpty(METHOD_NAME, koefTransitionList);
                    checkValueIsNotEmpty(METHOD_NAME, commonQuestionList);
                } else {
                    checkTagIsPresent(METHOD_NAME, "search-debug-info", searchDebugInfoList);
                }

                List<NodeElement> searchList = documentsNode.getChildrenListByName("searchlist");
                if (!searchList.isEmpty()) {
                    NodeElement searchListNode = searchList.get(0);
                    checkAttributeIsPresent("count", searchListNode.getAttributes(), METHOD_NAME);

                    List<NodeElement> itemFoundList = searchListNode.getChildrenListByName("itemfound");
                    if (!itemFoundList.isEmpty()) {
                        NodeElement itemFoundNode = itemFoundList.get(0);

                        List<NodeElement> artNameList = itemFoundNode.getChildrenListByName("artname");
                        List<NodeElement> modIdList = itemFoundNode.getChildrenListByName("modId");
                        List<NodeElement> docIdList = itemFoundNode.getChildrenListByName("docId");
                        List<NodeElement> searchIndexList = itemFoundNode.getChildrenListByName("search-index");
                        List<NodeElement> relevanceList = itemFoundNode.getChildrenListByName("relevance");
                        List<NodeElement> legalForceList = itemFoundNode.getChildrenListByName("legal-force");
                        List<NodeElement> docStatusList = itemFoundNode.getChildrenListByName("docStatus");
                        List<NodeElement> snippetList = itemFoundNode.getChildrenListByName("snippet");
                        List<NodeElement> snippetCaptionList = itemFoundNode.getChildrenListByName("snippetCaption");

                        checkTagIsPresent(METHOD_NAME, "artname", artNameList);
                        checkTagIsPresent(METHOD_NAME, "modId", modIdList);
                        checkTagIsPresent(METHOD_NAME, "docId", docIdList);
                        checkTagIsPresent(METHOD_NAME, "search-index", searchIndexList);
                        checkTagIsPresent(METHOD_NAME, "relevance", relevanceList);
                        checkTagIsPresent(METHOD_NAME, "legal-force", legalForceList);
                        checkTagIsPresent(METHOD_NAME, "docStatus", docStatusList);
                        checkTagIsPresent(METHOD_NAME, "snippet", snippetList);
                        checkTagIsPresent(METHOD_NAME, "snippetCaption", snippetCaptionList);

                        checkValueIsNotEmpty(METHOD_NAME, artNameList);
                        checkValueIsNotEmpty(METHOD_NAME, modIdList);
                        checkValueIsNotEmpty(METHOD_NAME, docIdList);
                        checkValueIsNotEmpty(METHOD_NAME, searchIndexList);
                        checkValueIsNotEmpty(METHOD_NAME, relevanceList);
                        checkValueIsNotEmpty(METHOD_NAME, legalForceList);
                        checkValueIsNotEmpty(METHOD_NAME, docStatusList);
                    } else {
                        checkTagIsPresent(METHOD_NAME, "itemfound", itemFoundList);
                    }
                } else {
                    checkTagIsPresent(METHOD_NAME, "searchlist", searchList);
                }
            } else {
                checkTagIsPresent(METHOD_NAME, "documents", documentList);
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
