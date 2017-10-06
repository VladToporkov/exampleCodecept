package com.actionmedia.tests.services.eventservice;

import com.actionmedia.components.EventTask;
import com.actionmedia.webservice.MessageElementConverter;
import com.actionmedia.webservice.ServiceResponse;
import com.actionmedia.webservice.eventservice.DropEventAEventParametersNode;
import com.actionmedia.webservice.eventservice.WsEventProcessorLocator;
import com.actionmedia.webservice.eventservice.WsEventProcessorSoap_PortType;
import org.testng.annotations.Test;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
import java.util.List;

import static com.actionmedia.autotest.Group.event;
import static com.actionmedia.autotest.Group.service;

/**
 * User: n.tyukavkin
 * Date: 23.01.14
 * Time: 15:49
 */
public class EventServiceTest extends EventServiceBaseTest {

    @Test(groups = {event, service})
    public void getEventTypeList_test() {
        report("Проверяется общая структура ответного xml для метода 'GetEventTypeList'");

        try {
            WsEventProcessorLocator locator = new WsEventProcessorLocator();
            WsEventProcessorSoap_PortType service = locator.getWsEventProcessorSoap();
            String[] typeArray = service.getEventTypeList();

            postponedAssertTrue(typeArray.length == 6, "Неправильный ответ для метода 'GetEventTypeList'. Размер списка доступных типов не равен 5.");
            postponedAssertTrue(isContains(typeArray, "AccessActivation"), "Неправильный ответ для метода 'GetEventTypeList'. Отсутствует тип 'AccessActivation'");
            postponedAssertTrue(isContains(typeArray, "PaiedCustomerAuth"), "Неправильный ответ для метода 'GetEventTypeList'. Отсутствует тип 'PaiedCustomerAuth'");
            postponedAssertTrue(isContains(typeArray, "LetterSent"), "Неправильный ответ для метода 'GetEventTypeList'. Отсутствует тип 'LetterSent'");
            postponedAssertTrue(isContains(typeArray, "Unsubscribe"), "Неправильный ответ для метода 'GetEventTypeList'. Отсутствует тип 'Unsubscribe'");
            postponedAssertTrue(isContains(typeArray, "ResetToSubscribed"), "Неправильный ответ для метода 'GetEventTypeList'. Отсутствует тип 'ResetToSubscribed'");
            postponedAssertTrue(isContains(typeArray, "DemoAccessActivation"), "Неправильный ответ для метода 'GetEventTypeList'. Отсутствует тип 'DemoAccessActivation'");
        } catch (ServiceException e) {
            fail("SOAPException occurs ", e);
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }

    @Test(groups = {event, service})
    public void dropEvent_AccessActivation_success_test() {
        report("Проверяется общая структура ответного xml для метода 'DropEvent' для события AccessActivation");

        String[] stubs = new String[]{STUB_USER_TOKEN, STUB_DATE, STUB_PUB_ID, STUB_CRM_CARD};
        String[] values = new String[]{USER_TOKEN, DATE, PUB_ID, CRM_CARD};

        String xml = makeRequest(ACCESS_ACTIVATION_REQUEST_XML, stubs, values);

        report("Метод - DropEvent");
        report("Событие - AccessActivation");
        report("USER_TOKEN - " + USER_TOKEN);
        report("DATE - " + DATE);
        report("PUB_ID - " + PUB_ID);
        report("CRM_CARD - " + CRM_CARD);

        try {
            WsEventProcessorLocator locator = new WsEventProcessorLocator();
            WsEventProcessorSoap_PortType service = locator.getWsEventProcessorSoap();
            DropEventAEventParametersNode dropEventAEventParametersNode = new DropEventAEventParametersNode();
            dropEventAEventParametersNode.set_any(convertXMLStringToMessageElement(xml));
            MessageElementConverter converter = new MessageElementConverter(service.dropEvent(dropEventAEventParametersNode).get_any()[0]);
            ServiceResponse response = converter.getResponse();

            checkSuccessResponse(response);
        } catch (ServiceException e) {
            fail("SOAPException occurs ", e);
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }

    @Test(groups = {event, service})
    public void dropEvent_AccessActivation_incorrectUserToken_test() {
        report("Проверяется общая структура ответного xml для метода 'DropEvent' для события AccessActivation. Некорректный USER_TOKEN.");

        String incorrectUserToken = getRandomString(5);
        String[] stubs = new String[]{STUB_USER_TOKEN, STUB_DATE, STUB_PUB_ID, STUB_CRM_CARD};
        String[] values = new String[]{incorrectUserToken, DATE, PUB_ID, CRM_CARD};
        String xml = makeRequest(ACCESS_ACTIVATION_REQUEST_XML, stubs, values);

        report("Метод - DropEvent");
        report("Событие - AccessActivation");
        report("USER_TOKEN - " + incorrectUserToken);
        report("DATE - " + DATE);
        report("PUB_ID - " + PUB_ID);
        report("CRM_CARD - " + CRM_CARD);

        incorrectAccessActivationTest(xml);
    }

    @Test(groups = {event, service})
    public void dropEvent_AccessActivation_incorrectDate_test() {
        report("Проверяется общая структура ответного xml для метода 'DropEvent' для события AccessActivation. Некорректный DATE.");

        String incorrectDate = getRandomString(5);
        String[] stubs = new String[]{STUB_USER_TOKEN, STUB_DATE, STUB_PUB_ID, STUB_CRM_CARD};
        String[] values = new String[]{USER_TOKEN, incorrectDate, PUB_ID, CRM_CARD};
        String xml = makeRequest(ACCESS_ACTIVATION_REQUEST_XML, stubs, values);

        report("Метод - DropEvent");
        report("Событие - AccessActivation");
        report("USER_TOKEN - " + USER_TOKEN);
        report("DATE - " + incorrectDate);
        report("PUB_ID - " + PUB_ID);
        report("CRM_CARD - " + CRM_CARD);

        incorrectAccessActivationTest(xml);
    }

    @Test(groups = {event, service})
    public void dropEvent_AccessActivation_incorrectPubId_test() {
        report("Проверяется общая структура ответного xml для метода 'DropEvent' для события AccessActivation. Некорректный PUB_ID.");

        String incorrectPubId = getRandomString(5);
        String[] stubs = new String[]{STUB_USER_TOKEN, STUB_DATE, STUB_PUB_ID, STUB_CRM_CARD};
        String[] values = new String[]{USER_TOKEN, DATE, incorrectPubId, CRM_CARD};
        String xml = makeRequest(ACCESS_ACTIVATION_REQUEST_XML, stubs, values);

        report("Метод - DropEvent");
        report("Событие - AccessActivation");
        report("USER_TOKEN - " + USER_TOKEN);
        report("DATE - " + DATE);
        report("PUB_ID - " + incorrectPubId);
        report("CRM_CARD - " + CRM_CARD);

        incorrectAccessActivationTest(xml);
    }

    @Test(groups = {event, service})
    public void dropEvent_PaiedCustomerAuth_success_test() {
        report("Проверяется общая структура ответного xml для метода 'DropEvent' для события PaiedCustomerAuth");

        String[] stubs = new String[]{STUB_USER_TOKEN, STUB_DATE, STUB_PUB_ID};
        String[] values = new String[]{USER_TOKEN, DATE, PUB_ID};

        String xml = makeRequest(PAYED_REQUEST_XML, stubs, values);

        report("Метод - DropEvent");
        report("Событие - PaiedCustomerAuth");
        report("USER_TOKEN - " + USER_TOKEN);
        report("DATE - " + DATE);
        report("PUB_ID - " + PUB_ID);

        try {
            WsEventProcessorLocator locator = new WsEventProcessorLocator();
            WsEventProcessorSoap_PortType service = locator.getWsEventProcessorSoap();
            DropEventAEventParametersNode dropEventAEventParametersNode = new DropEventAEventParametersNode();
            dropEventAEventParametersNode.set_any(convertXMLStringToMessageElement(xml));
            MessageElementConverter converter = new MessageElementConverter(service.dropEvent(dropEventAEventParametersNode).get_any()[0]);
            ServiceResponse response = converter.getResponse();

            checkSuccessResponse(response);
        } catch (ServiceException e) {
            fail("SOAPException occurs ", e);
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }

    @Test(groups = {event, service})
    public void dropEvent_PaiedCustomerAuth_incorrectUserToken_test() {
        report("Проверяется общая структура ответного xml для метода 'DropEvent' для события PaiedCustomerAuth. Некорректный USER_TOKEN.");

        String incorrectUserToken = getRandomString(5);
        String[] stubs = new String[]{STUB_USER_TOKEN, STUB_DATE, STUB_PUB_ID};
        String[] values = new String[]{incorrectUserToken, DATE, PUB_ID};
        String xml = makeRequest(PAYED_REQUEST_XML, stubs, values);

        report("Метод - DropEvent");
        report("Событие - PaiedCustomerAuth");
        report("USER_TOKEN - " + incorrectUserToken);
        report("DATE - " + DATE);
        report("PUB_ID - " + PUB_ID);

        incorrectPaiedCustomerAuthTest(xml);
    }

    @Test(groups = {event, service})
    public void dropEvent_PaiedCustomerAuth_incorrectDate_test() {
        report("Проверяется общая структура ответного xml для метода 'DropEvent' для события PaiedCustomerAuth. Некорректный DATE.");

        String incorrectDate = getRandomString(5);
        String[] stubs = new String[]{STUB_USER_TOKEN, STUB_DATE, STUB_PUB_ID};
        String[] values = new String[]{USER_TOKEN, incorrectDate, PUB_ID};
        String xml = makeRequest(PAYED_REQUEST_XML, stubs, values);

        report("Метод - DropEvent");
        report("Событие - PaiedCustomerAuth");
        report("USER_TOKEN - " + USER_TOKEN);
        report("DATE - " + incorrectDate);
        report("PUB_ID - " + PUB_ID);

        incorrectPaiedCustomerAuthTest(xml);
    }

    @Test(groups = {event, service})
    public void dropEvent_PaiedCustomerAuth_incorrectPubId_test() {
        report("Проверяется общая структура ответного xml для метода 'DropEvent' для события PaiedCustomerAuth. Некорректный PUB_ID.");

        String incorrectPubId = getRandomString(5);
        String[] stubs = new String[]{STUB_USER_TOKEN, STUB_DATE, STUB_PUB_ID};
        String[] values = new String[]{USER_TOKEN, DATE, incorrectPubId};
        String xml = makeRequest(PAYED_REQUEST_XML, stubs, values);

        report("Метод - DropEvent");
        report("Событие - PaiedCustomerAuth");
        report("USER_TOKEN - " + USER_TOKEN);
        report("DATE - " + DATE);
        report("PUB_ID - " + incorrectPubId);

        incorrectPaiedCustomerAuthTest(xml);
    }

    @Test(groups = {event, service})
    public void dropEvent_LetterSent_success_test() {
        report("Проверяется общая структура ответного xml для метода 'DropEvent' для события LetterSent");

        String[] stubs = new String[]{STUB_USER_TOKEN, STUB_DATE, STUB_PUB_ID, STUB_THEME_ID, STUB_LETTER_NUMBER};
        String[] values = new String[]{USER_TOKEN, DATE, PUB_ID, THEME_ID, LETTER_NUMBER};

        String xml = makeRequest(LETTER_SEND_REQUEST_XML, stubs, values);

        report("Метод - DropEvent");
        report("Событие - LetterSent");
        report("USER_TOKEN - " + USER_TOKEN);
        report("DATE - " + DATE);
        report("PUB_ID - " + PUB_ID);
        report("THEME_ID - " + THEME_ID);
        report("LETTER_NUMBER - " + LETTER_NUMBER);

        try {
            WsEventProcessorLocator locator = new WsEventProcessorLocator();
            WsEventProcessorSoap_PortType service = locator.getWsEventProcessorSoap();
            DropEventAEventParametersNode dropEventAEventParametersNode = new DropEventAEventParametersNode();
            dropEventAEventParametersNode.set_any(convertXMLStringToMessageElement(xml));
            MessageElementConverter converter = new MessageElementConverter(service.dropEvent(dropEventAEventParametersNode).get_any()[0]);
            ServiceResponse response = converter.getResponse();

            checkSuccessResponse(response);
        } catch (ServiceException e) {
            fail("SOAPException occurs ", e);
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }

    @Test(groups = {event, service})
    public void dropEvent_LetterSent_incorrect_token_test() {
        report("Проверяется общая структура ответного xml для метода 'DropEvent' для события LetterSent. Некорректный USER_TOKEN.");

        String incorrectUserToken = getRandomString(5);
        String[] stubs = new String[]{STUB_USER_TOKEN, STUB_DATE, STUB_PUB_ID, STUB_THEME_ID, STUB_LETTER_NUMBER};
        String[] values = new String[]{incorrectUserToken, DATE, PUB_ID, THEME_ID, LETTER_NUMBER};
        String xml = makeRequest(LETTER_SEND_REQUEST_XML, stubs, values);

        report("Метод - DropEvent");
        report("Событие - LetterSent");
        report("USER_TOKEN - " + incorrectUserToken);
        report("DATE - " + DATE);
        report("PUB_ID - " + PUB_ID);
        report("THEME_ID - " + THEME_ID);
        report("LETTER_NUMBER - " + LETTER_NUMBER);

        incorrectLetterSentTest(xml);
    }

    @Test(groups = {event, service})
    public void dropEvent_LetterSent_incorrect_date_test() {
        report("Проверяется общая структура ответного xml для метода 'DropEvent' для события LetterSent. Некорректный DATE.");

        String incorrectDate = getRandomString(5);
        String[] stubs = new String[]{STUB_USER_TOKEN, STUB_DATE, STUB_PUB_ID, STUB_THEME_ID, STUB_LETTER_NUMBER};
        String[] values = new String[]{USER_TOKEN, incorrectDate, PUB_ID, THEME_ID, LETTER_NUMBER};
        String xml = makeRequest(LETTER_SEND_REQUEST_XML, stubs, values);

        report("Метод - DropEvent");
        report("Событие - LetterSent");
        report("USER_TOKEN - " + USER_TOKEN);
        report("DATE - " + incorrectDate);
        report("PUB_ID - " + PUB_ID);
        report("THEME_ID - " + THEME_ID);
        report("LETTER_NUMBER - " + LETTER_NUMBER);

        incorrectLetterSentTest(xml);
    }

    @Test(groups = {event, service})
    public void dropEvent_LetterSent_incorrect_pubId_test() {
        report("Проверяется общая структура ответного xml для метода 'DropEvent' для события LetterSent. Некорректный PUB_ID.");

        String incorrectPubId = getRandomString(5);
        String[] stubs = new String[]{STUB_USER_TOKEN, STUB_DATE, STUB_PUB_ID, STUB_THEME_ID, STUB_LETTER_NUMBER};
        String[] values = new String[]{USER_TOKEN, DATE, incorrectPubId, THEME_ID, LETTER_NUMBER};
        String xml = makeRequest(LETTER_SEND_REQUEST_XML, stubs, values);

        report("Метод - DropEvent");
        report("Событие - LetterSent");
        report("USER_TOKEN - " + USER_TOKEN);
        report("DATE - " + DATE);
        report("PUB_ID - " + incorrectPubId);
        report("THEME_ID - " + THEME_ID);
        report("LETTER_NUMBER - " + LETTER_NUMBER);

        incorrectLetterSentTest(xml);
    }

    @Test(groups = {event, service})
    public void dropEvent_LetterSent_incorrect_themeID_test() {
        report("Проверяется общая структура ответного xml для метода 'DropEvent' для события LetterSent. Некорректный THEME_ID.");

        String incorrectThemeId = getRandomString(5);
        String[] stubs = new String[]{STUB_USER_TOKEN, STUB_DATE, STUB_PUB_ID, STUB_THEME_ID, STUB_LETTER_NUMBER};
        String[] values = new String[]{USER_TOKEN, DATE, PUB_ID, incorrectThemeId, LETTER_NUMBER};
        String xml = makeRequest(LETTER_SEND_REQUEST_XML, stubs, values);

        report("Метод - DropEvent");
        report("Событие - LetterSent");
        report("USER_TOKEN - " + USER_TOKEN);
        report("DATE - " + DATE);
        report("PUB_ID - " + PUB_ID);
        report("THEME_ID - " + incorrectThemeId);
        report("LETTER_NUMBER - " + LETTER_NUMBER);

        incorrectLetterSentTest(xml);
    }

    @Test(groups = {event, service})
    public void dropEvent_LetterSent_incorrect_letterNumber_test() {
        report("Проверяется общая структура ответного xml для метода 'DropEvent' для события LetterSent. Некорректный LETTER_NUMBER.");

        String incorrectLetterNumber = getRandomString(5);
        String[] stubs = new String[]{STUB_USER_TOKEN, STUB_DATE, STUB_PUB_ID, STUB_THEME_ID, STUB_LETTER_NUMBER};
        String[] values = new String[]{USER_TOKEN, DATE, PUB_ID, THEME_ID, incorrectLetterNumber};
        String xml = makeRequest(LETTER_SEND_REQUEST_XML, stubs, values);

        report("Метод - DropEvent");
        report("Событие - LetterSent");
        report("USER_TOKEN - " + USER_TOKEN);
        report("DATE - " + DATE);
        report("PUB_ID - " + PUB_ID);
        report("THEME_ID - " + THEME_ID);
        report("LETTER_NUMBER - " + incorrectLetterNumber);

        incorrectLetterSentTest(xml);
    }

    @Test(groups = {event, service})
    public void dropEvent_DemoAccessActivation_success_test() {
        report("Проверяется общая структура ответного xml для метода 'DropEvent' для события DemoAccessActivation");

        String[] stubs = new String[]{STUB_USER_TOKEN, STUB_DATE, STUB_PUB_ID};
        String[] values = new String[]{DEMO_USER_TOKEN, DATE, PUB_ID};

        String xml = makeRequest(DEMO_ACCESS_ACTIVATION_REQUEST_XML, stubs, values);

        report("Метод - DropEvent");
        report("Событие - DemoAccessActivation");
        report("USER_TOKEN - " + USER_TOKEN);
        report("DATE - " + DATE);
        report("PUB_ID - " + PUB_ID);

        try {
            WsEventProcessorLocator locator = new WsEventProcessorLocator();
            WsEventProcessorSoap_PortType service = locator.getWsEventProcessorSoap();
            DropEventAEventParametersNode dropEventAEventParametersNode = new DropEventAEventParametersNode();
            dropEventAEventParametersNode.set_any(convertXMLStringToMessageElement(xml));
            MessageElementConverter converter = new MessageElementConverter(service.dropEvent(dropEventAEventParametersNode).get_any()[0]);
            ServiceResponse response = converter.getResponse();

            checkSuccessResponse(response);
        } catch (ServiceException e) {
            fail("SOAPException occurs ", e);
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }

    private void incorrectAccessActivationTest(String xmlString) {
        List<EventTask> beforeEvenTaskList = getEventTaskList();
        try {
            WsEventProcessorLocator locator = new WsEventProcessorLocator();
            WsEventProcessorSoap_PortType service = locator.getWsEventProcessorSoap();
            DropEventAEventParametersNode dropEventAEventParametersNode = new DropEventAEventParametersNode();
            dropEventAEventParametersNode.set_any(convertXMLStringToMessageElement(xmlString));
            MessageElementConverter converter = new MessageElementConverter(service.dropEvent(dropEventAEventParametersNode).get_any()[0]);
            ServiceResponse response = converter.getResponse();

            checkErrorResponse(response, beforeEvenTaskList);
        } catch (ServiceException e) {
            fail("SOAPException occurs ", e);
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }

    private void incorrectPaiedCustomerAuthTest(String xmlString) {
        List<EventTask> beforeEvenTaskList = getEventTaskList();
        try {
            WsEventProcessorLocator locator = new WsEventProcessorLocator();
            WsEventProcessorSoap_PortType service = locator.getWsEventProcessorSoap();
            DropEventAEventParametersNode dropEventAEventParametersNode = new DropEventAEventParametersNode();
            dropEventAEventParametersNode.set_any(convertXMLStringToMessageElement(xmlString));
            MessageElementConverter converter = new MessageElementConverter(service.dropEvent(dropEventAEventParametersNode).get_any()[0]);
            ServiceResponse response = converter.getResponse();

            checkErrorResponse(response, beforeEvenTaskList);
        } catch (ServiceException e) {
            fail("SOAPException occurs ", e);
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }

    private void incorrectLetterSentTest(String xmlString) {
        List<EventTask> beforeEvenTaskList = getEventTaskList();
        try {
            WsEventProcessorLocator locator = new WsEventProcessorLocator();
            WsEventProcessorSoap_PortType service = locator.getWsEventProcessorSoap();
            DropEventAEventParametersNode dropEventAEventParametersNode = new DropEventAEventParametersNode();
            dropEventAEventParametersNode.set_any(convertXMLStringToMessageElement(xmlString));
            MessageElementConverter converter = new MessageElementConverter(service.dropEvent(dropEventAEventParametersNode).get_any()[0]);
            ServiceResponse response = converter.getResponse();

            checkErrorResponse(response, beforeEvenTaskList);
        } catch (ServiceException e) {
            fail("SOAPException occurs ", e);
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
