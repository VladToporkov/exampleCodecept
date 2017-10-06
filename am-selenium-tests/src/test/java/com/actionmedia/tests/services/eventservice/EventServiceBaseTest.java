package com.actionmedia.tests.services.eventservice;

import com.actionmedia.base.AbstractServicesTest;
import com.actionmedia.components.EventTask;
import com.actionmedia.components.UnSubscribeEvent;
import com.actionmedia.util.DBUtils;
import com.actionmedia.webservice.NodeElement;
import com.actionmedia.webservice.ServiceResponse;
import org.apache.axis.message.MessageElement;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 24.01.14
 * Time: 16:29
 */
public class EventServiceBaseTest extends AbstractServicesTest {

    public static final String STUB_USER_TOKEN = "STUB_USER_TOKEN";
    public static final String STUB_DATE = "STUB_DATE";
    public static final String STUB_PUB_ID = "STUB_PUB_ID";
    public static final String STUB_CRM_CARD = "STUB_CRM_CARD";
    public static final String STUB_THEME_ID = "STUB_THEME_ID";
    public static final String STUB_LETTER_NUMBER = "STUB_LETTER_NUMBER";
    public static final String STUB_SUBSCRIBE_KEY = "STUB_SUBSCRIBE_KEY";
    public static final String USER_TOKEN = "0f43a25c-4f98-49e3-841b-a4250ac6e7b1";
    public static final String DEMO_USER_TOKEN = "2d0c1633-a371-447a-8cd3-4f27f52d25ec";
    public static final String SUBSCRIBE_USER_TOKEN = "BB26D422-ED38-4FCA-AC80-90E8F3EC1FEA";
    public static final String DATE = "2013-12-09 15:11:08";
    public static final String PUB_ID = "10";
    public static final String CRM_CARD = "1232-1232-1234-1234";
    public static final String THEME_ID = "008CB3B0-230F-47F0-B0B9-8A4DD7FA242E";
    public static final String LETTER_NUMBER = "1";
    public static final String SUBSCRIBE_KEY = "A08B32D3E9B54770438E0DC17061A4E5";
    public static final String PAYED_REQUEST_XML = "payed_request.xml";
    public static final String ACCESS_ACTIVATION_REQUEST_XML = "access_activation_request.xml";
    public static final String DEMO_ACCESS_ACTIVATION_REQUEST_XML = "demo_access_activation_request.xml";
    public static final String LETTER_SEND_REQUEST_XML = "letter_send_request.xml";
    public static final String UN_SUBSCRIBE_REQUEST_XML = "unsubscribe_request.xml";
    public static final String RESET_TO_SUBSCRIBED_REQUEST_XML = "reset_to_subscribed_request.xml";
    public static final String RESOURCES = "/service/";

    public MessageElement[] convertXMLStringToMessageElement(String xmlString) {
        MessageElement[] m = new MessageElement[1];
        try {
            Document XMLDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(xmlString)));
            Element element = XMLDoc.getDocumentElement();
            m[0] = new MessageElement(element);
        } catch (SAXException e) {
            logger.error("SAXException occurs", e);
        } catch (IOException e) {
            logger.error("IOException occurs", e);
        } catch (ParserConfigurationException e) {
            logger.error("ParserConfigurationException occurs", e);
        }
        return m;
    }

    public String makeRequest(String fileName, String[] stubs, String[] values) {
        String requestString = "";
        try {
            InputStream reqStream = EventServiceBaseTest.class.getClass().getResourceAsStream(RESOURCES + fileName);
            String requestXML = IOUtils.toString(reqStream);
            for (int i = 0; i < stubs.length; i++) {
                requestXML = requestXML.replace(stubs[i], values[i]);
            }
            requestString = requestXML;
        } catch (IOException e) {
            logger.error("IOException occurs", e);
        }
        return requestString;
    }

    public void checkSuccessResponse(ServiceResponse response) {
        checkResponse(response);

        NodeElement isOkNode = response.getNodeElementByName("IsOk");
        NodeElement typeNode = response.getNodeElementByName("Type");
        NodeElement categoryNode = response.getNodeElementByName("Category");

        postponedAssertEquals(isOkNode.getValue(), "True", "Неправильный формат ответного xml для метода 'DropEvent'. Неправильное значения для тэга 'IsOk'");
        postponedAssertEquals(typeNode.getValue(), "Success", "Неправильный формат ответного xml для метода 'DropEvent'. Неправильное значения для тэга 'Type'");
        postponedAssertEquals(categoryNode.getValue(), "CreateTaskQueueElement", "Неправильный формат ответного xml для метода 'DropEvent'. Неправильное значения для тэга 'Category'");

        int taskId = getTaskId(response);
        report("Проверяется что в БД появилась запись с id=" + taskId);
        EventTask eventTask = getEventTaskById(taskId);
        if (eventTask != null) {
            report("Запись с id " + taskId + " присутсвует в БД");
        } else {
            setPostponedTestFail("Отсутствует запись в БД с id=" + taskId);
        }
    }

    public void checkUnSubscribeSuccessResponse(ServiceResponse response, String category) {
        checkResponse(response);

        NodeElement isOkNode = response.getNodeElementByName("IsOk");
        NodeElement typeNode = response.getNodeElementByName("Type");
        NodeElement categoryNode = response.getNodeElementByName("Category");

        postponedAssertEquals(isOkNode.getValue(), "True", "Неправильный формат ответного xml для метода 'DropEvent'. Неправильное значения для тэга 'IsOk'");
        postponedAssertEquals(typeNode.getValue(), "Success", "Неправильный формат ответного xml для метода 'DropEvent'. Неправильное значения для тэга 'Type'");
        postponedAssertEquals(categoryNode.getValue(), category, "Неправильный формат ответного xml для метода 'DropEvent'. Неправильное значения для тэга 'Category'");
    }

    public void checkWarningResponse(ServiceResponse response) {
        checkResponse(response);

        NodeElement isOkNode = response.getNodeElementByName("IsOk");
        NodeElement typeNode = response.getNodeElementByName("Type");
        NodeElement categoryNode = response.getNodeElementByName("Category");

        postponedAssertEquals(isOkNode.getValue(), "False", "Неправильный формат ответного xml для метода 'DropEvent'. Неправильное значения для тэга 'IsOk'");
        postponedAssertEquals(typeNode.getValue(), "Warning", "Неправильный формат ответного xml для метода 'DropEvent'. Неправильное значения для тэга 'Type'");
        postponedAssertEquals(categoryNode.getValue(), "Validation", "Неправильный формат ответного xml для метода 'DropEvent'. Неправильное значения для тэга 'Category'");
    }

    public void checkErrorResponse(ServiceResponse response, List<EventTask> beforeEvenTaskList) {
        checkResponse(response);

        NodeElement isOkNode = response.getNodeElementByName("IsOk");
        NodeElement typeNode = response.getNodeElementByName("Type");
        NodeElement categoryNode = response.getNodeElementByName("Category");

        postponedAssertEquals(isOkNode.getValue(), "False", "Неправильный формат ответного xml для метода 'DropEvent'. Неправильное значения для тэга 'IsOk'");
        postponedAssertEquals(typeNode.getValue(), "Error", "Неправильный формат ответного xml для метода 'DropEvent'. Неправильное значения для тэга 'Type'");
        postponedAssertEquals(categoryNode.getValue(), "Validation", "Неправильный формат ответного xml для метода 'DropEvent'. Неправильное значения для тэга 'Category'");

        List<EventTask> afterEvenTaskList = getEventTaskList();
        postponedAssertTrue(beforeEvenTaskList.size() == afterEvenTaskList.size(), "Количество записей в БД изменилось после запроса с неправильными данными");
    }

    public void checkUnSubscribeErrorResponse(ServiceResponse response, List<UnSubscribeEvent> beforeEvenTaskList) {
        checkResponse(response);

        NodeElement isOkNode = response.getNodeElementByName("IsOk");
        NodeElement typeNode = response.getNodeElementByName("Type");
        NodeElement categoryNode = response.getNodeElementByName("Category");
        NodeElement textNode = response.getNodeElementByName("Text");

        postponedAssertEquals(isOkNode.getValue(), "False", "Неправильный формат ответного xml для метода 'DropEvent'. Неправильное значения для тэга 'IsOk'");
        postponedAssertEquals(typeNode.getValue(), "Error", "Неправильный формат ответного xml для метода 'DropEvent'. Неправильное значения для тэга 'Type'");
        postponedAssertEquals(categoryNode.getValue(), "Validation", "Неправильный формат ответного xml для метода 'DropEvent'. Неправильное значения для тэга 'Category'");
        postponedAssertEquals(textNode.getValue(), "Неверный формат subscribe_key (ожидается 32 16-ричных цифры).", "Неправильный формат ответного xml для метода 'DropEvent'. Неправильное значения для тэга 'Text'");

        List<UnSubscribeEvent> afterEvenTaskList = getUnSubscribeEventList();
        postponedAssertTrue(beforeEvenTaskList.size() == afterEvenTaskList.size(), "Количество записей в БД изменилось после запроса с неправильными данными");
    }

    private void checkResponse(ServiceResponse response) {
        NodeElement isOkNode = response.getNodeElementByName("IsOk");
        NodeElement messageListNode = response.getNodeElementByName("MessageList");
        NodeElement messageNode = response.getNodeElementByName("Message");
        NodeElement typeNode = response.getNodeElementByName("Type");
        NodeElement categoryNode = response.getNodeElementByName("Category");
        NodeElement textNode = response.getNodeElementByName("Text");

        assertNotNull(isOkNode, "Неправильный формат ответного xml для метода 'DropEvent'. Отсутствует тэг 'IsOk'");
        assertNotNull(messageListNode, "Неправильный формат ответного xml для метода 'DropEvent'. Отсутствует тэг 'MessageList'");
        assertNotNull(messageNode, "Неправильный формат ответного xml для метода 'DropEvent'. Отсутствует тэг 'Message'");
        assertNotNull(typeNode, "Неправильный формат ответного xml для метода 'DropEvent'. Отсутствует тэг 'Type'");
        assertNotNull(categoryNode, "Неправильный формат ответного xml для метода 'DropEvent'. Отсутствует тэг 'Category'");
        assertNotNull(textNode, "Неправильный формат ответного xml для метода 'DropEvent'. Отсутствует тэг 'Text'");

        postponedAssertFalse(isOkNode.getValue().isEmpty(), "Неправильный формат ответного xml для метода 'DropEvent'. Отсутствует значения для тэга 'IsOk'");
        postponedAssertFalse(typeNode.getValue().isEmpty(), "Неправильный формат ответного xml для метода 'DropEvent'. Отсутствует значения для тэга 'Type'");
        postponedAssertFalse(categoryNode.getValue().isEmpty(), "Неправильный формат ответного xml для метода 'DropEvent'. Отсутствует значения для тэга 'Category'");
        postponedAssertFalse(textNode.getValue().isEmpty(), "Неправильный формат ответного xml для метода 'DropEvent'. Отсутствует значения для тэга 'Text'");
    }

    public boolean isContains(String[] typeArray, String type) {
        for (String typeFromArr : typeArray) {
            if (typeFromArr.equals(type)) {
                return true;
            }
        }
        return false;
    }

    public boolean isUnSubscribeListContainsUserToken(String userToken) {
        List<UnSubscribeEvent> eventTaskList = getUnSubscribeEventList();

        if (eventTaskList.isEmpty()) {
            return false;
        }

        for (UnSubscribeEvent event : eventTaskList) {
            if (event.getUserToken().equals(userToken)) {
                return true;
            }
        }
        return false;
    }

    public Integer getTaskId(ServiceResponse response) {
        NodeElement node = response.getNodeElementByName("Text");
        if (node != null) {
            String idString = node.getValue().split("TaskId=")[1];
            return Integer.parseInt(idString);
        }
        return null;
    }

    public String getRandomString(int count) {
        return RandomStringUtils.randomAlphabetic(count);
    }

    public EventTask getEventTaskById(int id) {
        for (EventTask eventTask : getEventTaskList()) {
            if (eventTask.getId() == id) {
                return eventTask;
            }
        }
        return null;
    }

    public List<EventTask> getEventTaskList() {
        return DBUtils.getEventTask();
    }

    public List<UnSubscribeEvent> getUnSubscribeEventList() {
        return DBUtils.getUnSubscribeEventList();
    }
}
