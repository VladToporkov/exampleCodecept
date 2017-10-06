package com.actionmedia.tests.services.searchservice.searchlaw;

import com.actionmedia.base.AbstractServicesTest;
import com.actionmedia.webservice.MessageElementConverter;
import com.actionmedia.webservice.NodeElement;
import com.actionmedia.webservice.ServiceResponse;
import org.apache.axis.message.MessageElement;
import org.apache.axis.types.UnsignedByte;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 16.01.14
 * Time: 12:06
 */
public class SearchLawBase extends AbstractServicesTest {

    public static final String METHOD_NAME = "SearchLaw";

    public ServiceResponse getSearchLawResponse(String searchString, UnsignedByte pubId, UnsignedByte pubDivId, int[] excludedModules, int[] searchTagList, UnsignedByte sortOrder, int searchOptionFlags, int snippetSize, int docPosition, int pageSize, String searchType, UnsignedByte statusFilter, int[] docRegionIdList, int[] docTypeIdList, int[] docLobbyIdList, String docNumber, Calendar pubDateStartedOn, Calendar pubDateEndedOn, String[] searchPrevStringList) {
        int[] dogCategoryIdList = new int[]{};
        UnsignedByte moduleIdBackLink = null;
        Integer idBackLink = null;
        Integer phraseIdBackLink = null;
        String userRegionCode = "";
        int pageCount = 1;
        int[] areaId = new int[]{};

        report("Адрес сервиса поиска: " + getSettings().getSearchServiceUrl());
        report("searchString - " + searchString);
        report("pubId - " + pubId);
        report("pubDivId - " + pubDivId);
        report("excludedModules - " + convertArrayToString(excludedModules));
        report("searchTagList - " + convertArrayToString(searchTagList));
        report("sortOrder - " + sortOrder);
        report("searchOptionFlag - " + searchOptionFlags);
        report("snippetSize - " + snippetSize);
        report("docPosition - " + docPosition);
        report("pageSize - " + pageSize);
        report("searchType - " + searchType);
        report("statusFilter - " + statusFilter);
        report("searchType - " + searchType);
        report("docRegionIdList - " + convertArrayToString(docRegionIdList));
        report("docTypeIdList - " + convertArrayToString(docTypeIdList));
        report("docLobbyIdList - " + convertArrayToString(docLobbyIdList));
        report("docNumber - " + docNumber);
        report("areaId - " + convertArrayToString(areaId));

        if (pubDateStartedOn != null) {
            report("pubDateStartedOn - " + pubDateStartedOn.getTime().toString());
        }
        if (pubDateEndedOn != null) {
            report("pubDateEndedOn - " + pubDateEndedOn.getTime().toString());
        }

        report("searchPrevStringList - " + convertArrayToString(searchPrevStringList));
        report("dogCategoryIdList - " + convertArrayToString(dogCategoryIdList));
        report("moduleIdBacklink - " + moduleIdBackLink);
        report("idBacklink - " + idBackLink);
        report("phraseIdBacklink - " + phraseIdBackLink);
        report("userRegionCode - " + userRegionCode);
        report("pageCount - " + pageCount);

        try {
            MessageElement search = getSearchService().searchLaw(searchString, pubId, pubDivId, excludedModules, searchTagList, sortOrder, searchOptionFlags, snippetSize, docPosition, pageSize, searchType, statusFilter, docRegionIdList, docTypeIdList, docLobbyIdList, dogCategoryIdList, docNumber, pubDateStartedOn, pubDateEndedOn, searchPrevStringList, moduleIdBackLink, idBackLink, phraseIdBackLink, userRegionCode, pageCount, areaId).get_any()[0];
            return new MessageElementConverter(search).getResponse();
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
        return null;
    }

    public void checkLingvoNode(ServiceResponse response, boolean isEmptySearchString) {
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

    public void checkOldLingvoNode(ServiceResponse response, boolean isEmptySearchString) {
        List<NodeElement> oldLingvoNodeTagList = response.getNodeElementListByName("old-lingvo-node");
        if (!oldLingvoNodeTagList.isEmpty()) {
            NodeElement lingvoNode = oldLingvoNodeTagList.get(0);
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
            }
            checkValueIsNotEmpty(METHOD_NAME, restoreStringFlagTagList);
            checkValueIsNotEmpty(METHOD_NAME, hashQapTagList);
        } else {
            checkTagIsPresent(METHOD_NAME, "old-lingvo-node", oldLingvoNodeTagList);
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

    public void checkHeaderInfo(ServiceResponse response, boolean isEmptySearchString) {
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

    public void checkAdvancedSearchFilters(ServiceResponse response) {
        List<NodeElement> headerInfoTagList = response.getNodeElementListByName("headerinfo");
        if (!headerInfoTagList.isEmpty()) {
            NodeElement headerInfo = headerInfoTagList.get(0);
            List<NodeElement> advancedSearchFiltersTagList = headerInfo.getChildrenListByName("AdvancedSearchFilters");

            if (!advancedSearchFiltersTagList.isEmpty()) {
                NodeElement advancedSearchFilters = advancedSearchFiltersTagList.get(0);
                List<NodeElement> advancedSearchFiltersItemsTagList = advancedSearchFilters.getChildren();
                //TODO: add report
                postponedAssertFalse(advancedSearchFiltersItemsTagList.isEmpty(), "Неправильный формат ответного xml. Отсутствует тэг 'advancedSearchFiltersItemsTagList'");
            } else {
                checkTagIsPresent(METHOD_NAME, "AdvancedSearchFilters", advancedSearchFiltersTagList);
            }
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
                List<NodeElement> snippetTagList = itemFound.getChildrenListByName("snippet");
                List<NodeElement> snippetCaptionTagList = itemFound.getChildrenListByName("snippetCaption");

                checkTagIsPresent(METHOD_NAME, "artname", artNameTagList);
                checkTagIsPresent(METHOD_NAME, "modId", modIdTagList);
                checkTagIsPresent(METHOD_NAME, "docId", docIdTagList);
                checkTagIsPresent(METHOD_NAME, "search-index", searchIndexTagList);
                checkTagIsPresent(METHOD_NAME, "relevance", relevanceTagList);
                checkTagIsPresent(METHOD_NAME, "legal-force", legalForceTagList);
                checkTagIsPresent(METHOD_NAME, "snippet", snippetTagList);
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

    public void checkFoundedItemNameByNumber(ServiceResponse response, String itemName, int itemNumber) {
        List<NodeElement> foundedItemList = response.getNodeElementListByName("itemfound");
        if (foundedItemList.size() > itemNumber) {
            NodeElement foundedItemByNumber;
            if (foundedItemList.get(0).getChildrenListByName("artname").get(0).getValue() != null) {
                foundedItemByNumber = foundedItemList.get(itemNumber).getChildren().get(0);
            } else {
                foundedItemByNumber = foundedItemList.get(itemNumber + 1).getChildren().get(0);
            }
            postponedAssertEquals(foundedItemByNumber.getValue(), itemName, "Неправильный заголовок для " + (itemNumber + 1) + " найденного элемента");
        } else {
            setPostponedTestFail("Количество найденных элементов меньше " + (itemNumber + 1));
        }
    }

    public void checkNumberOfFoundedItems(ServiceResponse response, int numberOfItems) {
        List<NodeElement> foundedItemList = response.getNodeElementListByName("itemfound");
        postponedAssertEquals(foundedItemList.size(), numberOfItems, "Неправильное количество найденных документов");
    }

    public void checkItemFoundByDocIdIsPresent(ServiceResponse response, String docId) {
        boolean isDocumentPresent = false;
        List<NodeElement> foundedItemList = response.getNodeElementListByName("itemfound");
        for (NodeElement nodeElement : foundedItemList) {
            if (nodeElement.getChildrenListByName("docId").get(0).getValue().equals(docId)) {
                isDocumentPresent = true;
                break;
            }
        }
        postponedAssertTrue(isDocumentPresent, "Документ с ид - " + docId + " Отсутствует в поисковой выдаче");
    }

    public void checkItemFoundByDocIdIsNotPresent(ServiceResponse response, String docId) {
        boolean isDocumentPresent = false;
        List<NodeElement> foundedItemList = response.getNodeElementListByName("itemfound");
        for (NodeElement nodeElement : foundedItemList) {
            if (nodeElement.getChildrenListByName("docId").get(0).getValue().equals(docId)) {
                isDocumentPresent = true;
                break;
            }
        }
        postponedAssertFalse(isDocumentPresent, "Документ с ид - " + docId + " присутсвует в поисковой выдаче");
    }
}
