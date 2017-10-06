package com.actionmedia.tests.services.searchindexes;

import com.actionmedia.base.AbstractServicesTest;
import com.actionmedia.components.SearchIndexDocument;
import com.actionmedia.util.DBUtils;
import com.actionmedia.webservice.MessageElementConverter;
import com.actionmedia.webservice.NodeElement;
import com.actionmedia.webservice.ServiceResponse;
import org.apache.axis.message.MessageElement;
import org.apache.axis.types.UnsignedByte;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.rmi.RemoteException;
import java.util.List;

import static com.actionmedia.autotest.Group.index;
import static com.actionmedia.autotest.Group.search;

/**
 * User: n.tyukavkin
 * Date: 05.08.2014
 * Time: 22:
 *
 * Задача теста - проверить, что в поиске участвуют все ModuleId, которые должны искаться.
 * Данный автотест предназначен не для проверки качества поиска, а для установления факта,
 * ищутся ли в принципе документы отдельных модулей.
 */
public class SearchIndexBaseTest extends AbstractServicesTest {

    /* Данные для провайдера берутся из таблицы KLM_2.dbo.TestAutoModuleSearch на srv12 (60.22) */
    @DataProvider(name = "provider")
    public Object[][] dataProvider() {
        List<SearchIndexDocument> searchIndexDocumentList = DBUtils.getSearchIndexDocumentList();
        Object[][] data = new Object[searchIndexDocumentList.size()][1];
        for (int i = 0; i < searchIndexDocumentList.size(); i++) {
            data[i][0] = searchIndexDocumentList.get(i);
        }
        return data;
    }

    @Test(groups = {search, index}, dataProvider = "provider")
    public void searchDocumentTest(SearchIndexDocument document) {
        try {
            String searchString = document.getRequest();
            UnsignedByte pubId = new UnsignedByte(document.getPubId());
            UnsignedByte pubDivId = new UnsignedByte(document.getPubDivId());
            int[] excludedModules = new int[]{};
            int[] searchTagListId = document.getSearchTagList();
            UnsignedByte sortOrder = new UnsignedByte(0);
            int searchOptionFlag = 32;
            int snippetSize = 25;
            int docPosition = 1;
            int pageSize = 200;
            String searchType = "";
            int pageCount = 1;
            int[] areaId = new int[]{};

            report("searchString - " + searchString);
            report("pubId - " + pubId);
            report("pubDivId - " + pubDivId);
            report("excludedModules - " + convertArrayToString(excludedModules));
            report("searchTagListId - " + convertArrayToString(searchTagListId));
            report("sortOrder - " + sortOrder);
            report("searchOptionFlag - " + searchOptionFlag);
            report("snippetSize - " + snippetSize);
            report("docPosition - " + docPosition);
            report("pageSize - " + pageSize);
            report("searchType - " + searchType);
            report("areaId - " + convertArrayToString(areaId));

            MessageElement search = getSearchService().searchActionDigital(
                    searchString,
                    pubId,
                    pubDivId,
                    excludedModules,
                    searchTagListId,
                    sortOrder,
                    searchOptionFlag,
                    snippetSize,
                    docPosition,
                    pageSize,
                    searchType,
                    pageCount,
                    areaId
            ).get_any()[0];

            ServiceResponse response = new MessageElementConverter(search).getResponse();

            List<NodeElement> foundedItemList = response.getNodeElementListByName("itemfound");

            int documentIndex = -1;
            for (int i = 0; i < foundedItemList.size(); i++) {
                NodeElement foundedItemByNumber = foundedItemList.get(i);
                if (foundedItemByNumber.getChildren().get(0).getValue().equalsIgnoreCase(document.getRequest())) {
                    documentIndex = i;
                    break;
                }
                if (foundedItemByNumber.getChildren().get(2).getValue().equals(String.valueOf(document.getId()))) {
                    documentIndex = i;
                    break;
                }
            }

            if (documentIndex != -1) {
                report("Документ '" + document.getRequest() + "' найден");
                report("Позиция документа '" + document.getRequest() + "' в выдаче - " + (documentIndex + 1));
            } else {
                fail("Документ '" + document.getRequest() + "' не найден");
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
