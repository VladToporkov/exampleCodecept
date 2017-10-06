package com.actionmedia.tests.services.searchserviceload;

import com.actionmedia.tests.services.searchservice.searchlaw.SearchLawBase;
import com.actionmedia.webservice.MessageElementConverter;
import com.actionmedia.webservice.NodeElement;
import com.actionmedia.webservice.ServiceResponse;
import org.apache.axis.types.UnsignedByte;
import org.joda.time.DateTime;
import org.testng.annotations.Test;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 04.02.2015
 * Time: 23:27
 */
public class SearchServiceLoadTest extends SearchLawBase {

//    private static final String SERVICE_URL = "http://search-service/SearchService.asmx";
//
//    @Test
//    public void test() {
//        DateTime currentTime = new DateTime();
//        while (currentTime.getMillis() + (1 * 10 * 1000) > new DateTime().getMillis()) {
//            DateTime startTime = new DateTime();
//            getResponse();
//            DateTime endTime = new DateTime();
//            System.out.println("Time - " + (endTime.getMillis() - startTime.getMillis()));
//        }
//    }
//
//    private void getResponse() {
//        String searchString = "текст запроса";
//        UnsignedByte pubId = new UnsignedByte(6);
//        int[] moduleIdList = new int[]{81, 97, 98, 99};
//        int[] searchTagList = new int[]{};
//        UnsignedByte sortOrder = new UnsignedByte(0);
//        int searchOptionFlags = 0;
//        int snippetSize = 25;
//        int docPosition = 1;
//        int pageSize = 50;
//        String searchType = "7422";
//        UnsignedByte statusFilter = new UnsignedByte(0);
//        int[] docRegionIdList = new int[]{};
//        int[] docTypeIdList = new int[]{};
//        int[] docLobbyIdList = new int[]{};
//        String docNumber = "1";
//        Calendar pubDateStartedOn = null;
//        Calendar pubDateEndedOn = null;
//        String[] searchPrevStringList = new String[]{};
//
//        try {
////            SearchServiceLocator locator = new SearchServiceLocator();
////            locator.setSearchServiceSoapEndpointAddress(SERVICE_URL);
////            locator.setSearchServiceSoap12EndpointAddress(SERVICE_URL);
////            SearchServiceSoap_PortType searchService = locator.getSearchServiceSoap();
////
////            SearchLawResponseSearchLawResult serviceResponse = searchService.searchLaw(searchString,
////                    pubId,
////                    moduleIdList,
////                    searchTagList,
////                    sortOrder,
////                    searchOptionFlags,
////                    snippetSize,
////                    docPosition,
////                    pageSize,
////                    searchType,
////                    statusFilter,
////                    docRegionIdList,
////                    docTypeIdList,
////                    docLobbyIdList,
////                    docNumber,
////                    pubDateStartedOn,
////                    pubDateEndedOn,
////                    searchPrevStringList);
////
////            ServiceResponse response = new MessageElementConverter(serviceResponse.get_any()[0]).getResponse();
//
//            List<NodeElement> itemFoundList = response.getNodeElementListByName("itemfound");
//            if (!itemFoundList.isEmpty()) {
//                String searchTypeAttribute = itemFoundList.get(1).getChildrenListByName("search-index").get(0).getValue();
//                System.out.println("searchType - " + searchTypeAttribute);
//            } else {
//                System.out.println("Не найдено ничего");
//            }
//        } catch (ServiceException e) {
//            logger.error("ServiceException occurs", e);
//        } catch (RemoteException e) {
//            logger.error("RemoteException occurs", e);
//        }
//    }
}
