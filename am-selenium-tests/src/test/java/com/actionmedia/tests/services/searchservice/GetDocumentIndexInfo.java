package com.actionmedia.tests.services.searchservice;

import com.actionmedia.base.AbstractServicesTest;
import com.actionmedia.components.Document;
import com.actionmedia.util.DBUtils;
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
 * Time: 15:27
 */
public class GetDocumentIndexInfo extends AbstractServicesTest {

    @Test(groups = {search, service})
    public void getDocumentIndexInfo_test() {
        int moduleDocId = 11;
        int docId = 15943;

        Document actualRedactionForDocument = DBUtils.getActualRedactionForDocument(moduleDocId, docId);
        assertNotNull(actualRedactionForDocument, "Не найдена актуальная редакция для документа " + moduleDocId + "/" + docId);

        String methodName = "GetDocumentIndexInfo";

        UnsignedByte pubId = new UnsignedByte(6);
        UnsignedByte moduleID = new UnsignedByte(actualRedactionForDocument.getModuleId());
        int documentID = actualRedactionForDocument.getDocumentId();

        try {
            report("Тест для проверки метода '" + methodName + "'");
            report("Адрес сервиса поиска: " + getSettings().getSearchServiceUrl());
            report("pubId - " + pubId);
            report("pubId - " + pubId);
            report("pubId - " + pubId);
            report("moduleID - " + moduleID);
            report("documentID - " + documentID);

            MessageElement search = getSearchService().getDocumentIndexInfo(pubId, moduleID, documentID).get_any()[0];
            ServiceResponse response = new MessageElementConverter(search).getResponse();

            List<NodeElement> findInTextTagList = response.getNodeElementListByName("findInText");

            checkTagIsPresent(methodName, "findInText", findInTextTagList);
            assertNotNull(findInTextTagList.get(0).getAttributes().get("enabled"), "Неправильный формат ответного xml для метода '" + methodName + "'. Отсутствует свойство 'enabled' для тэга 'findInText'");
            postponedAssertFalse(findInTextTagList.get(0).getAttributes().get("enabled").isEmpty(), "Неправильный формат ответного xml для метода '" + methodName + "'. Отсутствует значение свойства 'enabled' для тэга 'findInText'");

        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
