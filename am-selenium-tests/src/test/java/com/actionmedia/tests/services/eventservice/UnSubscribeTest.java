package com.actionmedia.tests.services.eventservice;

import com.actionmedia.components.UnSubscribeEvent;
import com.actionmedia.webservice.MessageElementConverter;
import com.actionmedia.webservice.ServiceResponse;
import com.actionmedia.webservice.eventservice.DropEventAEventParametersNode;
import com.actionmedia.webservice.eventservice.WsEventProcessorLocator;
import com.actionmedia.webservice.eventservice.WsEventProcessorSoap_PortType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
import java.util.List;

import static com.actionmedia.autotest.Group.event;
import static com.actionmedia.autotest.Group.service;

/**
 * User: n.tyukavkin
 * Date: 17.02.14
 * Time: 16:18
 */
public class UnSubscribeTest extends EventServiceBaseTest {

    @BeforeTest
    public void prepareTest() {
        if (isUnSubscribeListContainsUserToken(SUBSCRIBE_USER_TOKEN)) {
            try {
                String[] stubs = new String[]{STUB_SUBSCRIBE_KEY};
                String[] values = new String[]{SUBSCRIBE_KEY};

                String xml = makeRequest(RESET_TO_SUBSCRIBED_REQUEST_XML, stubs, values);
                WsEventProcessorLocator locator = new WsEventProcessorLocator();
                WsEventProcessorSoap_PortType service = locator.getWsEventProcessorSoap();
                DropEventAEventParametersNode dropEventParametersNode = new DropEventAEventParametersNode();
                dropEventParametersNode.set_any(convertXMLStringToMessageElement(xml));
                service.dropEvent(dropEventParametersNode);
            } catch (ServiceException e) {
                e.printStackTrace();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Test(groups = {event, service})
    public void dropEvent_Unsubscribe_success_test() {
        report("Проверяется общая структура ответного xml для метода 'DropEvent' для события Unsubscribe");

        String[] stubs = new String[]{STUB_SUBSCRIBE_KEY};
        String[] values = new String[]{SUBSCRIBE_KEY};

        String xml = makeRequest(UN_SUBSCRIBE_REQUEST_XML, stubs, values);

        report("Метод - DropEvent");
        report("Событие - Unsubscribe");
        report("SUBSCRIBE_KEY - " + SUBSCRIBE_KEY);

        try {
            WsEventProcessorLocator locator = new WsEventProcessorLocator();
            WsEventProcessorSoap_PortType service = locator.getWsEventProcessorSoap();
            DropEventAEventParametersNode dropEventAEventParametersNode = new DropEventAEventParametersNode();
            dropEventAEventParametersNode.set_any(convertXMLStringToMessageElement(xml));
            MessageElementConverter converter = new MessageElementConverter(service.dropEvent(dropEventAEventParametersNode).get_any()[0]);
            ServiceResponse response = converter.getResponse();

            checkUnSubscribeSuccessResponse(response, "Unsubscribe");
            postponedAssertTrue(isUnSubscribeListContainsUserToken(SUBSCRIBE_USER_TOKEN), "Отсутствует запись в t_queue.UNSUBSCRIBES для USER_TOKEN " + SUBSCRIBE_USER_TOKEN);
        } catch (ServiceException e) {
            fail("SOAPException occurs ", e);
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }

    @Test(groups = {event, service})
    public void dropEvent_Unsubscribe_incorrect_test() {
        report("Проверяется общая структура ответного xml для метода 'DropEvent' для события Unsubscribe. Некорректный subscribe_key");

        String subscribeKey = getRandomString(12);

        String[] stubs = new String[]{STUB_SUBSCRIBE_KEY};
        String[] values = new String[]{subscribeKey};

        String xml = makeRequest(UN_SUBSCRIBE_REQUEST_XML, stubs, values);

        report("Метод - DropEvent");
        report("Событие - Unsubscribe");
        report("SUBSCRIBE_KEY - " + subscribeKey);

        List<UnSubscribeEvent> eventList = getUnSubscribeEventList();

        try {
            WsEventProcessorLocator locator = new WsEventProcessorLocator();
            WsEventProcessorSoap_PortType service = locator.getWsEventProcessorSoap();
            DropEventAEventParametersNode dropEventAEventParametersNode = new DropEventAEventParametersNode();
            dropEventAEventParametersNode.set_any(convertXMLStringToMessageElement(xml));
            MessageElementConverter converter = new MessageElementConverter(service.dropEvent(dropEventAEventParametersNode).get_any()[0]);
            ServiceResponse response = converter.getResponse();

            checkUnSubscribeErrorResponse(response, eventList);
        } catch (ServiceException e) {
            fail("SOAPException occurs ", e);
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
