package com.actionmedia.tests.services.searchservice;

import com.actionmedia.base.AbstractServicesTest;
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
 * Date: 14.01.14
 * Time: 17:59
 */
public class GetAdvSearchSmartNumberList extends AbstractServicesTest {

    @Test(groups = {search, service})
    public void getAdvSearchSmartNumberList_test() {
        String methodName = "GetAdvSearchSmartNumberList";

        UnsignedByte pubId = new UnsignedByte(6);
        String pattern = "123";
        int listLength = 10;
        boolean isLucene = false;

        try {
            report("Тест для проверки метода '" + methodName + "'");
            report("Адрес сервиса поиска: " + getSettings().getSearchServiceUrl());
            report("pubId - " + pubId);
            report("pattern - " + pattern);
            report("listLength - " + listLength);
            report("isLucene - " + isLucene);

            MessageElement search = getSearchService().getAdvSearchSmartNumberList(pubId, pattern, listLength, isLucene).get_any()[0];
            ServiceResponse response = new MessageElementConverter(search).getResponse();

            List<NodeElement> docNumberListTagList = response.getNodeElementListByName("DocNumberList");
            List<NodeElement> docNumberTagList = response.getNodeElementListByName("DocNumber");

            checkTagIsPresent(methodName, "DocNumberList", docNumberListTagList);
            checkTagIsPresent(methodName, "DocNumber", docNumberTagList);

            checkValueIsNotEmpty(methodName, docNumberTagList);

        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
