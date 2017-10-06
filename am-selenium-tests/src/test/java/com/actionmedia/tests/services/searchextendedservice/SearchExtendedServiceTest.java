package com.actionmedia.tests.services.searchextendedservice;

import com.actionmedia.base.AbstractServicesTest;
import com.actionmedia.webservice.MessageElementConverter;
import com.actionmedia.webservice.NodeElement;
import com.actionmedia.webservice.ServiceResponse;
import com.actionmedia.webservice.searchextendedservice.SearchExtendedSoap_PortType;
import org.apache.axis.message.MessageElement;
import org.apache.axis.types.UnsignedByte;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.rmi.RemoteException;
import java.util.List;

import static com.actionmedia.autotest.Group.*;

/**
 * User: n.tyukavkin
 * Date: 17.08.2014
 * Time: 21:40
 */
public class SearchExtendedServiceTest extends AbstractServicesTest {

    @Test(groups = {searchExtended, search, service})
    @Parameters("system")
    public void catalog_test(String system) {
        String methodName = "Catalog";
        String preferedRegionCode = "77";

        report("Тест для проверки метода '" + methodName + "'");
        report("Адрес сервиса поиска: " + getSettings().getSearchExtendedServiceUrl(system));
        report("PreferedRegionCode - " + preferedRegionCode);

        try {
            SearchExtendedSoap_PortType service = getSearchExtendedService(system);
            MessageElement search = service.catalog(preferedRegionCode).get_any()[0];
            ServiceResponse response = new MessageElementConverter(search).getResponse();

            List<NodeElement> docRegionListNode = response.getNodeElementListByName("DocRegionList");
            List<NodeElement> docLobbyListNode = response.getNodeElementListByName("DocLobbyList");
            List<NodeElement> docTypeListNode = response.getNodeElementListByName("DocTypeList");

            checkTagIsPresent(methodName, "DocRegionList", docRegionListNode);
            checkTagIsPresent(methodName, "DocLobbyList", docLobbyListNode);
            checkTagIsPresent(methodName, "DocTypeList", docTypeListNode);

            List<NodeElement> docRegionNodeList = response.getNodeElementListByName("DocRegion");
            List<NodeElement> docLobbyNodeList = response.getNodeElementListByName("DocLobby");
            List<NodeElement> docTypeNodeList = response.getNodeElementListByName("DocType");

            checkTagIsPresent(methodName, "DocRegion", docRegionNodeList);
            checkTagIsPresent(methodName, "DocLobby", docLobbyNodeList);
            checkTagIsPresent(methodName, "DocType", docTypeNodeList);

            for (NodeElement docRegionNode : docRegionNodeList) {
                List<NodeElement> idNode = docRegionNode.getChildrenListByName("ID");
                List<NodeElement> nameNode = docRegionNode.getChildrenListByName("Name");
                List<NodeElement> regionCodeNode = docRegionNode.getChildrenListByName("RegionCode");

                checkTagIsPresent(methodName, "DocRegion >> ID", idNode);
                checkTagIsPresent(methodName, "DocRegion >> Name", nameNode);
                checkTagIsPresent(methodName, "DocRegion >> RegionCode", regionCodeNode);

                checkValueIsNotEmpty(methodName, idNode);
                checkValueIsNotEmpty(methodName, nameNode);
                checkValueIsNotEmpty(methodName, regionCodeNode);
            }

            for (NodeElement docLobbyNode : docLobbyNodeList) {
                List<NodeElement> idNode = docLobbyNode.getChildrenListByName("ID");
                List<NodeElement> nameNode = docLobbyNode.getChildrenListByName("Name");
                List<NodeElement> briefNameNode = docLobbyNode.getChildrenListByName("BriefName");
                List<NodeElement> keyWordsNode = docLobbyNode.getChildrenListByName("KeyWords");

                checkTagIsPresent(methodName, "DocLobby >> ID", idNode);
                checkTagIsPresent(methodName, "DocLobby >> Name", nameNode);
                checkTagIsPresent(methodName, "DocLobby >> BriefName", briefNameNode);
                checkTagIsPresent(methodName, "DocLobby >> KeyWords", keyWordsNode);

                checkValueIsNotEmpty(methodName, idNode);
                checkValueIsNotEmpty(methodName, nameNode);
                checkValueIsNotEmpty(methodName, briefNameNode);
                checkValueIsNotEmpty(methodName, keyWordsNode);
            }

            for (NodeElement docTypeNode : docTypeNodeList) {
                List<NodeElement> idNode = docTypeNode.getChildrenListByName("ID");
                List<NodeElement> nameNode = docTypeNode.getChildrenListByName("Name");

                checkTagIsPresent(methodName, "DocType >> ID", idNode);
                checkTagIsPresent(methodName, "DocType >> Name", nameNode);

                checkValueIsNotEmpty(methodName, idNode);
                checkValueIsNotEmpty(methodName, nameNode);
            }
        } catch (RemoteException e) {
            fail("RemoteException occurs ", e);
        }
    }

    @Test(groups = {searchExtended, search, service})
    @Parameters("system")
    public void catalog2_test(String system) {
        String methodName = "Catalog2";

        UnsignedByte pubDivId = new UnsignedByte(13);
        String preferedRegionCode = "77";

        report("Тест для проверки метода '" + methodName + "'");
        report("Адрес сервиса поиска: " + getSettings().getSearchExtendedServiceUrl(system));
        report("pubDivId - " + pubDivId);
        report("PreferedRegionCode - " + preferedRegionCode);

        try {
            SearchExtendedSoap_PortType service = getSearchExtendedService(system);
            MessageElement search = service.catalog2(pubDivId, preferedRegionCode).get_any()[0];
            ServiceResponse response = new MessageElementConverter(search).getResponse();

            List<NodeElement> docRegionListNode = response.getNodeElementListByName("DocRegionList");
            List<NodeElement> docLobbyListNode = response.getNodeElementListByName("DocLobbyList");
            List<NodeElement> docTypeListNode = response.getNodeElementListByName("DocTypeList");

            checkTagIsPresent(methodName, "DocRegionList", docRegionListNode);
            checkTagIsPresent(methodName, "DocLobbyList", docLobbyListNode);
            checkTagIsPresent(methodName, "DocTypeList", docTypeListNode);

            List<NodeElement> docRegionNodeList = response.getNodeElementListByName("DocRegion");
            List<NodeElement> docLobbyNodeList = response.getNodeElementListByName("DocLobby");
            List<NodeElement> docTypeNodeList = response.getNodeElementListByName("DocType");

            checkTagIsPresent(methodName, "DocRegion", docRegionNodeList);
            checkTagIsPresent(methodName, "DocLobby", docLobbyNodeList);
            checkTagIsPresent(methodName, "DocType", docTypeNodeList);

            for (NodeElement docRegionNode : docRegionNodeList) {
                List<NodeElement> idNode = docRegionNode.getChildrenListByName("ID");
                List<NodeElement> nameNode = docRegionNode.getChildrenListByName("Name");
                List<NodeElement> regionCodeNode = docRegionNode.getChildrenListByName("RegionCode");

                checkTagIsPresent(methodName, "DocRegion >> ID", idNode);
                checkTagIsPresent(methodName, "DocRegion >> Name", nameNode);
                checkTagIsPresent(methodName, "DocRegion >> RegionCode", regionCodeNode);

                checkValueIsNotEmpty(methodName, idNode);
                checkValueIsNotEmpty(methodName, nameNode);
                checkValueIsNotEmpty(methodName, regionCodeNode);
            }

            for (NodeElement docLobbyNode : docLobbyNodeList) {
                List<NodeElement> idNode = docLobbyNode.getChildrenListByName("ID");
                List<NodeElement> nameNode = docLobbyNode.getChildrenListByName("Name");
                List<NodeElement> briefNameNode = docLobbyNode.getChildrenListByName("BriefName");
                List<NodeElement> keyWordsNode = docLobbyNode.getChildrenListByName("KeyWords");

                checkTagIsPresent(methodName, "DocLobby >> ID", idNode);
                checkTagIsPresent(methodName, "DocLobby >> Name", nameNode);
                checkTagIsPresent(methodName, "DocLobby >> BriefName", briefNameNode);
                checkTagIsPresent(methodName, "DocLobby >> KeyWords", keyWordsNode);

                checkValueIsNotEmpty(methodName, idNode);
                checkValueIsNotEmpty(methodName, nameNode);
                checkValueIsNotEmpty(methodName, briefNameNode);
                checkValueIsNotEmpty(methodName, keyWordsNode);
            }

            for (NodeElement docTypeNode : docTypeNodeList) {
                List<NodeElement> idNode = docTypeNode.getChildrenListByName("ID");
                List<NodeElement> nameNode = docTypeNode.getChildrenListByName("Name");

                checkTagIsPresent(methodName, "DocType >> ID", idNode);
                checkTagIsPresent(methodName, "DocType >> Name", nameNode);

                checkValueIsNotEmpty(methodName, idNode);
                checkValueIsNotEmpty(methodName, nameNode);
            }
        } catch (RemoteException e) {
            fail("RemoteException occurs ", e);
        }
    }

    @Test(groups = {searchExtended, search, service})
    @Parameters("system")
    public void numbers_test(String system) {
        String methodName = "Numbers";
        String pattern = "111";

        report("Тест для проверки метода '" + methodName + "'");
        report("Адрес сервиса поиска: " + getSettings().getSearchExtendedServiceUrl(system));
        report("Pattern - " + pattern);

        try {
            SearchExtendedSoap_PortType service = getSearchExtendedService(system);
            MessageElement search = service.numbers(pattern).get_any()[0];
            ServiceResponse response = new MessageElementConverter(search).getResponse();

            List<NodeElement> docNumberListNode = response.getNodeElementListByName("DocNumberList");
            if (!docNumberListNode.isEmpty()) {
                List<NodeElement> docNumberNodeList = docNumberListNode.get(0).getChildrenListByName("DocNumber");

                checkTagIsPresent(methodName, "DocNumber", docNumberNodeList);
                checkValueIsNotEmpty(methodName, docNumberNodeList);
            } else {
                checkTagIsPresent(methodName, "DocNumberList", docNumberListNode);
            }
        } catch (RemoteException e) {
            fail("RemoteException occurs ", e);
        }
    }

    @Test(groups = {searchExtended, search, service})
    @Parameters("system")
    public void numbers2_test(String system) {
        String methodName = "Numbers2";

        UnsignedByte pubDivId = new UnsignedByte(13);
        String pattern = "111";

        report("Тест для проверки метода '" + methodName + "'");
        report("Адрес сервиса поиска: " + getSettings().getSearchExtendedServiceUrl(system));
        report("pubDivId - " + pubDivId);
        report("Pattern - " + pattern);

        try {
            SearchExtendedSoap_PortType service = getSearchExtendedService(system);
            MessageElement search = service.numbers2(pubDivId, pattern).get_any()[0];
            ServiceResponse response = new MessageElementConverter(search).getResponse();

            List<NodeElement> docNumberListNode = response.getNodeElementListByName("DocNumberList");
            if (!docNumberListNode.isEmpty()) {
                List<NodeElement> docNumberNodeList = docNumberListNode.get(0).getChildrenListByName("DocNumber");

                checkTagIsPresent(methodName, "DocNumber", docNumberNodeList);
                checkValueIsNotEmpty(methodName, docNumberNodeList);
            } else {
                checkTagIsPresent(methodName, "DocNumberList", docNumberListNode);
            }
        } catch (RemoteException e) {
            fail("RemoteException occurs ", e);
        }
    }

    @Test(groups = {searchExtended, search, service})
    @Parameters("system")
    public void filter_test(String system) {
        String methodName = "Filter";
        String preferedRegionCode = "";
        String listType = "Lobby";
        String lobbyIDs = "";
        String regionIDs = "50";
        String typeIDs = "11";
        boolean isActual = true;

        report("Тест для проверки метода '" + methodName + "'");
        report("Адрес сервиса поиска: " + getSettings().getSearchExtendedServiceUrl(system));
        report("PreferedRegionCode - " + preferedRegionCode);
        report("ListType - " + listType);
        report("LobbyIDs - " + lobbyIDs);
        report("RegionIDs - " + regionIDs);
        report("TypeIDs - " + typeIDs);
        report("IsActual - " + isActual);

        try {
            SearchExtendedSoap_PortType service = getSearchExtendedService(system);
            MessageElement search = service.filter(preferedRegionCode, listType, lobbyIDs, regionIDs, typeIDs, isActual).get_any()[0];
            ServiceResponse response = new MessageElementConverter(search).getResponse();

            List<NodeElement> docLobbyListNode = response.getNodeElementListByName("DocLobbyList");

            checkTagIsPresent(methodName, "DocLobbyList", docLobbyListNode);

            List<NodeElement> docLobbyNodeList = response.getNodeElementListByName("DocLobby");

            checkTagIsPresent(methodName, "DocLobby", docLobbyNodeList);

            for (NodeElement docLobbyNode : docLobbyNodeList) {
                List<NodeElement> idNode = docLobbyNode.getChildrenListByName("ID");
                List<NodeElement> nameNode = docLobbyNode.getChildrenListByName("Name");
                List<NodeElement> briefNameNode = docLobbyNode.getChildrenListByName("BriefName");
                List<NodeElement> keyWordsNode = docLobbyNode.getChildrenListByName("KeyWords");

                checkTagIsPresent(methodName, "DocLobby >> ID", idNode);
                checkTagIsPresent(methodName, "DocLobby >> Name", nameNode);
                checkTagIsPresent(methodName, "DocLobby >> BriefName", briefNameNode);
                checkTagIsPresent(methodName, "DocLobby >> KeyWords", keyWordsNode);

                checkValueIsNotEmpty(methodName, idNode);
                checkValueIsNotEmpty(methodName, nameNode);
                checkValueIsNotEmpty(methodName, briefNameNode);
                checkValueIsNotEmpty(methodName, keyWordsNode);
            }
        } catch (RemoteException e) {
            fail("RemoteException occurs ", e);
        }
    }

    @Test(groups = {searchExtended, search, service})
    @Parameters("system")
    public void filter2_test(String system) {
        String methodName = "Filter2";
        UnsignedByte pubDivId = new UnsignedByte(13);
        String preferedRegionCode = "50";
        String listType = "Lobby";
        String lobbyIDs = "575";
        String regionIDs = "77";
        String typeIDs = "2";
        boolean isActual = true;

        report("Тест для проверки метода '" + methodName + "'");
        report("Адрес сервиса поиска: " + getSettings().getSearchExtendedServiceUrl(system));
        report("pubDivId - " + pubDivId);
        report("PreferedRegionCode - " + preferedRegionCode);
        report("ListType - " + listType);
        report("LobbyIDs - " + lobbyIDs);
        report("RegionIDs - " + regionIDs);
        report("TypeIDs - " + typeIDs);
        report("IsActual - " + isActual);

        try {
            SearchExtendedSoap_PortType service = getSearchExtendedService(system);
            MessageElement search = service.filter2(pubDivId, preferedRegionCode, listType, lobbyIDs, regionIDs, typeIDs, isActual).get_any()[0];
            ServiceResponse response = new MessageElementConverter(search).getResponse();

            List<NodeElement> docLobbyListNode = response.getNodeElementListByName("DocLobbyList");

            checkTagIsPresent(methodName, "DocLobbyList", docLobbyListNode);

            List<NodeElement> docLobbyNodeList = response.getNodeElementListByName("DocLobby");

            checkTagIsPresent(methodName, "DocLobby", docLobbyNodeList);

            for (NodeElement docLobbyNode : docLobbyNodeList) {
                List<NodeElement> idNode = docLobbyNode.getChildrenListByName("ID");
                List<NodeElement> nameNode = docLobbyNode.getChildrenListByName("Name");
                List<NodeElement> briefNameNode = docLobbyNode.getChildrenListByName("BriefName");
                List<NodeElement> keyWordsNode = docLobbyNode.getChildrenListByName("KeyWords");

                checkTagIsPresent(methodName, "DocLobby >> ID", idNode);
                checkTagIsPresent(methodName, "DocLobby >> Name", nameNode);
                checkTagIsPresent(methodName, "DocLobby >> BriefName", briefNameNode);
                checkTagIsPresent(methodName, "DocLobby >> KeyWords", keyWordsNode);

                checkValueIsNotEmpty(methodName, idNode);
                checkValueIsNotEmpty(methodName, nameNode);
                checkValueIsNotEmpty(methodName, briefNameNode);
                checkValueIsNotEmpty(methodName, keyWordsNode);
            }
        } catch (RemoteException e) {
            fail("RemoteException occurs ", e);
        }
    }

    @Test(groups = {searchExtended, search, service})
    @Parameters("system")
    public void search_test(String system) {
        String methodName = "Search";
        String searchString = "ндс";
        String docRegionIDList = "50";
        String docTypeIDList = "13";
        String docLobbyIDList = "367";
        String docNumber = "50/2014-ОЗ";
        String pubDateStartedOn = "2014-05-05";
        String pubDateEndedOn = "2014-08-06";
        boolean isActual = true;
        boolean isExtended = true;

        report("Тест для проверки метода '" + methodName + "'");
        report("Адрес сервиса поиска: " + getSettings().getSearchExtendedServiceUrl(system));
        report("SearchString - " + searchString);
        report("DocRegionIDList - " + docRegionIDList);
        report("DocTypeIDList - " + docTypeIDList);
        report("DocLobbyIDList - " + docLobbyIDList);
        report("DocNumber - " + docNumber);
        report("PubDateStartedOn - " + pubDateStartedOn);
        report("pubDateEndedOn - " + pubDateEndedOn);
        report("IsActual - " + isActual);
        report("IsExtended - " + isExtended);

        try {
            SearchExtendedSoap_PortType service = getSearchExtendedService(system);
            MessageElement search = service.search(searchString, docRegionIDList, docTypeIDList, docLobbyIDList, docNumber, pubDateStartedOn, pubDateEndedOn, isActual, isExtended).get_any()[0];
            ServiceResponse response = new MessageElementConverter(search).getResponse();

            checkLingvoNode(response, methodName);
            checkHeaderInfo(response, methodName);
            checkSearchList(response, methodName);
        } catch (RemoteException e) {
            fail("RemoteException occurs ", e);
        }
    }

    @Test(groups = {searchExtended, search, service})
    @Parameters("system")
    public void search2_test(String system) {
        String methodName = "Search2";
        UnsignedByte pubDivId = new UnsignedByte(13);
        String searchString = "ответственность";
        String docRegionIDList = "50";
        String docTypeIDList = "2";
        String docLobbyIDList = "575";
        String docNumber = "ф05-10960/2012";
        String pubDateStartedOn = "2011-01-02";
        String pubDateEndedOn = "2015-10-13";
        boolean isActual = true;
        boolean isExtended = true;

        report("Тест для проверки метода '" + methodName + "'");
        report("Адрес сервиса поиска: " + getSettings().getSearchExtendedServiceUrl(system));
        report("pubDivId - " + pubDivId);
        report("SearchString - " + searchString);
        report("DocRegionIDList - " + docRegionIDList);
        report("DocTypeIDList - " + docTypeIDList);
        report("DocLobbyIDList - " + docLobbyIDList);
        report("DocNumber - " + docNumber);
        report("PubDateStartedOn - " + pubDateStartedOn);
        report("pubDateEndedOn - " + pubDateEndedOn);
        report("IsActual - " + isActual);
        report("IsExtended - " + isExtended);

        try {
            SearchExtendedSoap_PortType service = getSearchExtendedService(system);
            MessageElement search = service.search2(pubDivId, searchString, docRegionIDList, docTypeIDList, docLobbyIDList, docNumber, pubDateStartedOn, pubDateEndedOn, isActual, isExtended).get_any()[0];
            ServiceResponse response = new MessageElementConverter(search).getResponse();

            checkLingvoNode(response, methodName);
            checkHeaderInfo(response, methodName);
            checkSearchList(response, methodName);
        } catch (RemoteException e) {
            fail("RemoteException occurs ", e);
        }
    }

    public void checkLingvoNode(ServiceResponse response, String methodName) {
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

            checkValueIsNotEmpty(methodName, inputSearchStringTagList);
            checkValueIsNotEmpty(methodName, realSearchStringTagList);
            checkValueIsNotEmpty(methodName, restoreStringFlagTagList);
            checkValueIsNotEmpty(methodName, hashQapTagList);

            checkIdListItem(idListTagList, "id-list", methodName);
            checkIdListItem(idListOriginalTagList, "id-list_original", methodName);
            checkIdListItem(idListFuzzyTagList, "id-list-fuzzy", methodName);
        } else {
            checkTagIsPresent(methodName, "lingvo_node", lingvoNodeTagList);
        }
    }

    public void checkHeaderInfo(ServiceResponse response, String methodName) {
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
            checkTagIsPresent(methodName, "sortOrder", sortOrderTagList);
            checkTagIsPresent(methodName, "totalDocFound", totalDocFoundTagList);

            checkValueIsNotEmpty(methodName, searchPhraseOriginalTagList);
            checkValueIsNotEmpty(methodName, searchPhraseTagList);
            checkValueIsNotEmpty(methodName, searchPhraseFixedTagList);
            checkValueIsNotEmpty(methodName, pageNumberTagList);
            checkValueIsNotEmpty(methodName, pageSizeTagList);
            checkValueIsNotEmpty(methodName, snippetSizeTagList);
            checkValueIsNotEmpty(methodName, searchTypeTagList);
            checkValueIsNotEmpty(methodName, includeFixedQueryTagList);
            checkValueIsNotEmpty(methodName, mixedSearchTagList);
            checkValueIsNotEmpty(methodName, onlyTitleSearchTagList);
            checkValueIsNotEmpty(methodName, docStatusFilterTagList);
            checkValueIsNotEmpty(methodName, sortOrderTagList);
            checkValueIsNotEmpty(methodName, totalDocFoundTagList);
        } else {
            checkTagIsPresent(methodName, "headerinfo", headerInfoTagList);
        }
    }

    public void checkSearchList(ServiceResponse response, String methodName) {
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
            } else {
                checkTagIsPresent(methodName, "itemfound", itemFoundTagList);
            }
        } else {
            checkTagIsPresent(methodName, "searchlist", searchListTagList);
        }
    }

    private void checkIdListItem(List<NodeElement> idListTagList, String nodeName, String methodName) {
        if (!idListTagList.isEmpty()) {
            NodeElement idList = idListTagList.get(0);
            List<NodeElement> hashTagList = idList.getChildrenListByName("hash");
            List<NodeElement> idfTagList = idList.getChildrenListByName("idf");
            List<NodeElement> tokenTagList = idList.getChildrenListByName("token");

            checkTagIsPresent(methodName, "hash", hashTagList);
            checkTagIsPresent(methodName, "idf", idfTagList);
            checkTagIsPresent(methodName, "token", tokenTagList);

            checkValueIsNotEmpty(methodName, hashTagList);
            checkValueIsNotEmpty(methodName, idfTagList);
            checkValueIsNotEmpty(methodName, tokenTagList);
        } else {
            checkTagIsPresent(methodName, nodeName, idListTagList);
        }
    }
}
