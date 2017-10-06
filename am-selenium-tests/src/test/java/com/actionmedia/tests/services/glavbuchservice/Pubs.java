package com.actionmedia.tests.services.glavbuchservice;

import com.actionmedia.base.AbstractServicesTest;
import com.actionmedia.webservice.MessageElementConverter;
import com.actionmedia.webservice.NodeElement;
import com.actionmedia.webservice.ServiceResponse;
import org.testng.annotations.Test;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import static com.actionmedia.autotest.Group.glavbukh;
import static com.actionmedia.autotest.Group.service;

/**
 * User: n.tyukavkin
 * Date: 21.01.14
 * Time: 16:30
 */
public class Pubs extends AbstractServicesTest {

    @Test(groups = {glavbukh, service})
    public void pubs_test() {
        String methodName = "Pubs";

        report("Тест для проверки метода '" + methodName + "'");
        report("URL: " + getSettings().getGlavbukhServiceUrl());
        try {
            MessageElementConverter converter = new MessageElementConverter(getGlavbukhService().pubs().get_any()[0]);
            ServiceResponse response = converter.getResponse();

            List<NodeElement> pubsTagList = response.getNodeElementListByName("pubs");
            List<NodeElement> pubTagList = response.getNodeElementListByName("pub");

            checkTagIsPresent(methodName, "pubs", pubsTagList);
            checkTagIsPresent(methodName, "pub", pubTagList);

            for (NodeElement nodeElement : pubTagList) {
                Map<String, String> pubAttributes = nodeElement.getAttributes();
                String id = pubAttributes.get("id");
                String alias = pubAttributes.get("alias");
                assertNotNull(id, "Неправильный формат ответного xml для метода '" + methodName + "'. Свойство id не найдено");
                assertNotNull(alias, "Неправильный формат ответного xml для метода '" + methodName + "'. Свойство alias не найдено");
                postponedAssertFalse(id.isEmpty(), "Неправильный формат ответного xml для метода '" + methodName + "'. Значение свойства id пустое");
                postponedAssertFalse(alias.isEmpty(), "Неправильный формат ответного xml для метода '" + methodName + "'.Значение свойства alias пустое");

                List<NodeElement> siteTagList = nodeElement.getChildrenListByName("site");
                checkTagIsPresent(methodName, "site", siteTagList);
                Map<String, String> siteAttributes = siteTagList.get(0).getAttributes();
                String host = siteAttributes.get("host");
                assertNotNull(host, "Неправильный формат ответного xml для метода ' + methodName + '. Свойство id не найдено");
                postponedAssertFalse(host.isEmpty(), "Неправильный формат ответного xml для метода '" + methodName + "'. Значение свойства host пустое");
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
