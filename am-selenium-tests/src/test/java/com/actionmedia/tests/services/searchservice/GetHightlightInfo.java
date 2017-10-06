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
 * Date: 22.11.15
 * Time: 21:48
 */
public class GetHightlightInfo extends AbstractServicesTest {

    private static final String METHOD_NAME = "GetHightlightInfo";

    @Test(groups = {search, service})
    public void getHightlightInfo_test() {
        UnsignedByte pubId = new UnsignedByte(6);
        String searchString = "123";

        try {
            report("Тест для проверки метода '" + METHOD_NAME + "'");
            report("Адрес сервиса поиска: " + getSettings().getSearchServiceUrl());
            report("pubId - " + pubId);
            report("SearchString - " + searchString);

            MessageElement search = getSearchService().getHightlightInfo(pubId, searchString).get_any()[0];
            ServiceResponse response = new MessageElementConverter(search).getResponse();

            List<NodeElement> highlightInfoTagList = response.getNodeElementListByName("highlight-info");
            if (!highlightInfoTagList.isEmpty()) {
                NodeElement highlightInfoTag = highlightInfoTagList.get(0);
                List<NodeElement> itemTagList = highlightInfoTag.getChildrenListByName("item");
                if (!itemTagList.isEmpty()) {
                    NodeElement itemTag = itemTagList.get(0);
                    List<NodeElement> wordTagList = itemTag.getChildrenListByName("word");
                    List<NodeElement> hashTagList = itemTag.getChildrenListByName("hash");

                    checkTagIsPresent(METHOD_NAME, "word", wordTagList);
                    checkTagIsPresent(METHOD_NAME, "hash", hashTagList);

                    checkValueIsNotEmpty(METHOD_NAME, wordTagList);
                    checkValueIsNotEmpty(METHOD_NAME, hashTagList);
                } else {
                    checkTagIsPresent(METHOD_NAME, "item", itemTagList);
                }
            } else {
                checkTagIsPresent(METHOD_NAME, "highlight-info", highlightInfoTagList);
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
