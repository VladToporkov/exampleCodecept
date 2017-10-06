package com.actionmedia.tests.services.exportnpdservice;

import com.actionmedia.base.AbstractServicesTest;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.*;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.actionmedia.autotest.Group.*;

public class ExportNPDServiceAttachesTests extends AbstractServicesTest {

    @Test(groups = {service, npd})
    public void getDocAttributes_ru_attach_test() {
        String moduleId = "81";
        String id = "184";
        String serviceUrl = getSettings().getExportNPDServiceUrl();

        getDocAttributesTest(moduleId, id, serviceUrl, "ru");
    }

    @Test(groups = {service, npd})
    public void getDocAttributes_ua_attach_test() {
        String moduleId = "94";
        String id = "21207";
        String serviceUrl = getSettings().getExportNPDServiceUrl().replace("BssExportService.asmx", "BssExportServiceua.asmx");

        getDocAttributesTest(moduleId, id, serviceUrl, "ua");
    }

    @Test(groups = {service, npd})
    public void getDocAttributes_kz_attach_test() {
        String moduleId = "93";
        String id = "3077";
        String serviceUrl = getSettings().getExportNPDServiceUrl().replace("BssExportService.asmx", "BssExportServicekz.asmx");

        getDocAttributesTest(moduleId, id, serviceUrl, "kz");
    }

    @Test(groups = {service, npd})
    public void getDocAttributes_ru_image_test() {
        String moduleId = "97";
        String id = "272560";
        String partId = "1";
        String serviceUrl = getSettings().getExportNPDServiceUrl();

        getDocumentPartByIdImageTest(moduleId, id, partId, serviceUrl, "ru");
    }

    @Test(groups = {service, npd})
    public void getDocAttributes_ua_image_test() {
        String moduleId = "94";
        String id = "35027";
        String partId = "1";
        String serviceUrl = getSettings().getExportNPDServiceUrl().replace("BssExportService.asmx", "BssExportServiceua.asmx");

        getDocumentPartByIdImageTest(moduleId, id, partId, serviceUrl, "ua");
    }

    @Test(groups = {service, npd})
    public void getDocAttributes_kz_image_test() {
        String moduleId = "93";
        String id = "3406";
        String partId = "1";
        String serviceUrl = getSettings().getExportNPDServiceUrl().replace("BssExportService.asmx", "BssExportServicekz.asmx");

        getDocumentPartByIdImageTest(moduleId, id, partId, serviceUrl, "kz");
    }

    @Test(groups = {service, npd})
    public void getDocAttributes_ru_external_test() {
        String moduleId = "99";
        String id = "537972147";
        String partId = "1";
        String serviceUrl = getSettings().getExportNPDServiceUrl();

        getDocumentPartByIdExternalTest(moduleId, id, partId, serviceUrl, "ru");
    }

    @Test(groups = {service, npd})
    public void getDocAttributes_ua_external_test() {
        String moduleId = "94";
        String id = "15046";
        String partId = "1";
        String serviceUrl = getSettings().getExportNPDServiceUrl().replace("BssExportService.asmx", "BssExportServiceua.asmx");

        getDocumentPartByIdExternalTest(moduleId, id, partId, serviceUrl, "ua");
    }

    private void getDocAttributesTest(String moduleId, String id, String serviceUrl, final String aliasLanguage) {
        report("Тест для проверки формата ссылки на аттачмент для метода 'GetDocAttributes'");
        report("Адрес сервиса - " + serviceUrl);
        report("ModuleId - " + moduleId);
        report("DocId - " + id);

        try {
            String response = getResponse(serviceUrl, createGetDocAttributesRequest(moduleId, id));
            Document xmlDocument = getXmlDocument(response);

            assertNotNull(xmlDocument, "SOAPException occurs. Response is null");
            assertTrue(xmlDocument.getElementsByTagName("AttachmentList").getLength() > 0, "Отсутствует тэг 'AttachmentList'");

            for (int i = 0; i < xmlDocument.getElementsByTagName("AttachmentList").getLength(); i++) {
                Node attachmentListNode = xmlDocument.getElementsByTagName("AttachmentList").item(i);

                NodeList artUrlNode = ((Element) attachmentListNode).getElementsByTagName("ArtUrl");
                postponedAssertTrue(artUrlNode.getLength() > 0, "Отсутсвует тэг 'AttachmentList >> ArtUrl'");
                if (artUrlNode.getLength() > 0) {
                    NodeList childNodes = artUrlNode.item(0).getChildNodes();
                    postponedAssertTrue(childNodes.getLength() > 0, "Тэг 'AttachmentList >> ArtUrl' пустой");
                    if (childNodes.getLength() > 0) {
                        String artUrl = childNodes.item(0).getTextContent();
                        Pattern pattern = Pattern.compile("^http://[a-zA-Z0-9._-]+/api/attachment/" + aliasLanguage + "/(-|)\\d+/");
                        Matcher matcher = pattern.matcher(artUrl);
                        postponedAssertTrue(matcher.matches(), "Ссылка на аттачмент не соответствует формату '<хост сервиса>/api/attachment/{алиас языка}/{id аттачмента}/'. ArtUrl - '" + artUrl + "'");
                    }
                }
            }
        } catch (Exception e) {
            fail("SOAPException occurs ", e);
        }
    }

    private void getDocumentPartByIdImageTest(String moduleId, String id, String partId, String serviceUrl, final String aliasLanguage) {
        report("Тест для проверки формата ссылки на картинку для метода 'GetDocumentPartById'");
        report("Адрес сервиса - " + serviceUrl);
        report("ModuleId - " + moduleId);
        report("DocId - " + id);
        report("PartID - " + partId);

        try {
            String response = getResponse(serviceUrl, createGetDocumentPartById(moduleId, id, partId));
            Document xmlDocument = getXmlDocument(response);

            assertNotNull(xmlDocument, "SOAPException occurs. Response is null");
            assertTrue(xmlDocument.getElementsByTagName("Content").getLength() > 0, "Отсутствует тэг 'Content'");

            for (int i = 0; i < xmlDocument.getElementsByTagName("Content").getLength(); i++) {
                Node contentNode = xmlDocument.getElementsByTagName("Content").item(i);
                String content = contentNode.getTextContent();
                postponedAssertFalse(content.isEmpty(), "Тэг 'Content' пустой");
                if (!content.isEmpty()) {
                    List<String> srcList = new ArrayList<String>();

                    String regexForExtractSrc = "src=\"[^\"]*";
                    Pattern patternForExtractSrc = Pattern.compile(regexForExtractSrc);
                    Matcher matcherForExtractSrc = patternForExtractSrc.matcher(content);
                    while (matcherForExtractSrc.find()) {
                        srcList.add(matcherForExtractSrc.group());
                    }

                    postponedAssertFalse(srcList.isEmpty(), "Отсутствуют тэги 'src'");

                    for (String src : srcList) {
                        Pattern pattern = Pattern.compile("^src=\"http://[a-zA-Z0-9._-]+/api/image/" + aliasLanguage + "/(-|)\\d+/");
                        Matcher matcher = pattern.matcher(src);
                        postponedAssertTrue(matcher.matches(), "Ссылка на картинку не соответствует формату '<хост сервиса>/api/image/{алиас языка}/{id картинки}/'. src - '" + src + "'");
                    }
                }
            }
        } catch (Exception e) {
            fail("SOAPException occurs ", e);
        }
    }

    private void getDocumentPartByIdExternalTest(String moduleId, String id, String partId, String serviceUrl, final String aliasLanguage) {
        report("Тест для проверки формата ссылки на экстернал для метода 'GetDocumentPartById'");
        report("Адрес сервиса - " + serviceUrl);
        report("ModuleId - " + moduleId);
        report("DocId - " + id);
        report("PartID - " + partId);

        try {
            String response = getResponse(serviceUrl, createGetDocumentPartById(moduleId, id, partId));
            Document xmlDocument = getXmlDocument(response);

            assertNotNull(xmlDocument, "SOAPException occurs. Response is null");
            assertTrue(xmlDocument.getElementsByTagName("Content").getLength() > 0, "Отсутствует тэг 'Content'");

            for (int i = 0; i < xmlDocument.getElementsByTagName("Content").getLength(); i++) {
                Node contentNode = xmlDocument.getElementsByTagName("Content").item(i);
                String content = contentNode.getTextContent();
                postponedAssertFalse(content.isEmpty(), "Тэг 'Content' пустой");
                if (!content.isEmpty()) {
                    List<String> hrefList = new ArrayList<String>();

                    String regexForExtractHref = "href=\"[^\"]*";
                    Pattern patternForExtractHref = Pattern.compile(regexForExtractHref);
                    Matcher matcherForExtractHref = patternForExtractHref.matcher(content);
                    while (matcherForExtractHref.find()) {
                        hrefList.add(matcherForExtractHref.group());
                    }

                    postponedAssertFalse(hrefList.isEmpty(), "Отсутствуют тэги 'href'");

                    for (String href : hrefList) {
                        Pattern pattern = Pattern.compile("^href=\"http://[a-zA-Z0-9._-]+/api/external/" + aliasLanguage + "/(-|)\\d+/");
                        Matcher matcher = pattern.matcher(href);
                        postponedAssertTrue(matcher.matches(), "Ссылка на экстернал не соответствует формату '<хост сервиса>/api/external/{алиас языка}/{id экстернала}/'. href - '" + href + "'");
                    }
                }
            }
        } catch (Exception e) {
            fail("SOAPException occurs ", e);
        }
    }

    public String getResponse(String serviceUrl, SOAPMessage soapRequest) {
        String response = "";
        try {
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            SOAPMessage soapResponse = soapConnection.call(soapRequest, serviceUrl);
            response = getSOAPResponse(soapResponse);
            soapConnection.close();
        } catch (Exception e) {
            fail("SOAPException occurs ", e);
        }
        return response;
    }

    /**
     * <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:gl="http://www.1gl.ru/">
     * <soapenv:Header/>
     * <soapenv:Body>
     * <gl:GetDocAttributes>
     * <gl:ModuleID>81</gl:ModuleID>
     * <gl:ID>184</gl:ID>
     * </gl:GetDocAttributes>
     * </soapenv:Body>
     * </soapenv:Envelope>
     */
    private SOAPMessage createGetDocAttributesRequest(String moduleId, String id) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://www.1gl.ru/";

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("gl", serverURI);

        SOAPBody soapBody = envelope.getBody();
        SOAPElement searchActionDigital = soapBody.addChildElement("GetDocAttributes", "gl");
        searchActionDigital.addChildElement("ModuleID", "gl").addTextNode(moduleId);
        searchActionDigital.addChildElement("ID", "gl").addTextNode(id);

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI + "GetDocAttributes");

        soapMessage.saveChanges();
        return soapMessage;
    }

    /**
     * <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:gl="http://www.1gl.ru/">
     * <soapenv:Header/>
     * <soapenv:Body>
     * <gl:GetDocumentPartById>
     * <gl:ModuleID>97</gl:ModuleID>
     * <gl:ID>272560</gl:ID>
     * <gl:PartID>1</gl:PartID>
     * </gl:GetDocumentPartById>
     * </soapenv:Body>
     * </soapenv:Envelope>
     */
    private SOAPMessage createGetDocumentPartById(String moduleId, String id, String partId) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://www.1gl.ru/";

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("gl", serverURI);

        SOAPBody soapBody = envelope.getBody();
        SOAPElement searchActionDigital = soapBody.addChildElement("GetDocumentPartById", "gl");
        searchActionDigital.addChildElement("ModuleID", "gl").addTextNode(moduleId);
        searchActionDigital.addChildElement("ID", "gl").addTextNode(id);
        searchActionDigital.addChildElement("PartID", "gl").addTextNode(partId);

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI + "GetDocumentPartById");

        soapMessage.saveChanges();
        return soapMessage;
    }

    private String getSOAPResponse(SOAPMessage soapResponse) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        Source sourceContent = soapResponse.getSOAPPart().getContent();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        StreamResult r = new StreamResult(outputStream);
        transformer.transform(sourceContent, r);
        return new String(outputStream.toByteArray());
    }

    private Document getXmlDocument(String xmlString) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(new InputSource(new StringReader(xmlString)));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
