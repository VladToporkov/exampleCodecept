package com.actionmedia.tests.services.contentservice;

import com.actionmedia.base.AbstractServicesTest;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

import static com.actionmedia.autotest.Group.contentService;
import static com.actionmedia.autotest.Group.service;

/**
 * User: n.tyukavkin
 * Date: 27.07.2014
 * Time: 14:05
 */
public class ContentServiceTest extends AbstractServicesTest {

    @Test(groups = {contentService, service})
    public void content_test() {
        for (String url : getUrl()) {
            test(url);
        }
    }

    private void test(String url) {
        String newsId = "18183";
        String host = "1gl.ru";

        report("Тест для проверки метода 'Получение новостей' сервиса контента Главбух.ру");
        report("Адрес сервиса: " + url);
        report("id - " + newsId);
        report("host - " + host);

        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(UriBuilder.fromUri(url + "api/news/?id=" + newsId + "&host=" + host).build());
        String response = service.accept(MediaType.APPLICATION_XML).get(String.class);

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(response)));

            NodeList mainNodeList = document.getChildNodes();
            assertTrue(mainNodeList.getLength() > 0, "Неправильный формат ответного xml, пустой документ");

            NodeList title = document.getElementsByTagName("title");
            NodeList id = document.getElementsByTagName("id");
            NodeList date = document.getElementsByTagName("date");
            NodeList link = document.getElementsByTagName("link");
            NodeList text = document.getElementsByTagName("text");

            assertTrue(document.getElementsByTagName("NewsList").getLength() > 0, "Неправильный формат ответного xml Отсутствует тэг 'NewsList'");
            assertTrue(document.getElementsByTagName("ArticleItem").getLength() > 0, "Неправильный формат ответного xml Отсутствует тэг 'ArticleItem'");
            assertTrue(title.getLength() > 0, "Неправильный формат ответного xml Отсутствует тэг 'title'");
            assertTrue(id.getLength() > 0, "Неправильный формат ответного xml Отсутствует тэг 'id'");
            assertTrue(date.getLength() > 0, "Неправильный формат ответного xml Отсутствует тэг 'date'");
            assertTrue(link.getLength() > 0, "Неправильный формат ответного xml Отсутствует тэг 'link'");
            assertTrue(text.getLength() > 0, "Неправильный формат ответного xml Отсутствует тэг 'text'");

            postponedAssertFalse(title.item(0).getTextContent().isEmpty(), "Неправильный формат ответного xml Отсутствует текст в тэге 'title'");
            postponedAssertFalse(id.item(0).getTextContent().isEmpty(), "Неправильный формат ответного xml Отсутствует текст в тэге 'id'");
            postponedAssertFalse(date.item(0).getTextContent().isEmpty(), "Неправильный формат ответного xml Отсутствует текст в тэге 'date'");
            postponedAssertFalse(link.item(0).getTextContent().isEmpty(), "Неправильный формат ответного xml Отсутствует текст в тэге 'link'");
            postponedAssertFalse(text.item(0).getTextContent().isEmpty(), "Неправильный формат ответного xml Отсутствует текст в тэге 'text'");

        } catch (ParserConfigurationException e) {
            fail("ParserConfigurationException occurs", e);
        } catch (SAXException e) {
            fail("SAXException occurs", e);
        } catch (IOException e) {
            fail("IOException occurs", e);
        }
    }

    private String[] getUrl() {
        if (getSettings().isRunProk1()) {
            return new String[]{"http://glavbukh-service.prok.1glp.ru/"};
        } else if (getSettings().isRunRT()) {
            return new String[]{"http://glavbukh-service.rt.1glp.ru/"};
        } else if (getSettings().isRunTbd()) {
            return new String[]{"http://glavbukh-service.pro.1glp.ru/"};
        } else {
            return new String[]{"http://glavbukh-service.web11.1glp.ru/", "http://glavbukh-service.web12.1glp.ru/", "http://glavbukh-service.web13.1glp.ru/"};
        }
    }
}
