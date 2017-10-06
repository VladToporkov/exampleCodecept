package com.actionmedia.tests.services.comparesearchresults;

import com.actionmedia.base.AbstractServicesTest;
import org.apache.axis.types.UnsignedByte;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import ru.yandex.qatools.allure.annotations.Attachment;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompareSearchResults extends AbstractServicesTest {

    private UnsignedByte pubId = new UnsignedByte(6);
    private int[] moduleIdList = new int[]{11, 12, 14, 86, 111, 112, 117, 123, 184, 186, 190, 193, 199, 201, 202, 204, 210};
    private int[] searchTagList = new int[]{};
    private UnsignedByte sortOrder = new UnsignedByte(getSortOrder());
    private UnsignedByte searchOptionFlags = new UnsignedByte(0);
    private int snippetSize = 25;
    private int docPosition = 1;
    private int pageSize = 100;
    private String searchType = "7230";
    private Map<String, Document> standardQueryMap = new HashMap<String, Document>();
    private Map<String, Document> testQueryMap = new HashMap<String, Document>();
    private String[] queryList;

    @DataProvider(name = "provider", parallel = false)
    public Object[][] provider() {
        Object[][] data = new Object[getQueryList().length][1];
        for (int i = 0; i < getQueryList().length; i++) {
            data[i][0] = getQueryList()[i];
        }
        return data;
    }

    @Test(dataProvider = "provider", priority = 0)
    public void itemFoundCount(String query) {
        printReport(query);

        Document standardResponseXml = getStandardResponseDocument(query);
        Document testResponseXml = getTestResponseDocument(query);

        assertNotNull(standardResponseXml, "Пустой ответ от эталонного сервиса");
        assertNotNull(testResponseXml, "Пустой ответ от тестируемого сервиса");

        standardQueryMap.put(query, standardResponseXml);
        testQueryMap.put(query, testResponseXml);

        postponedAssertEquals(testResponseXml.getElementsByTagName("itemfound").getLength(), standardResponseXml.getElementsByTagName("itemfound").getLength(), "Количество найденных документов не соответсвует");
    }

    @Test(dataProvider = "provider", priority = 1)
    public void checkFirst10ItemFound(String query) {
        printReport(query);

        Document standardResponseXml = getStandardResponseDocument(query);
        Document testResponseXml = getTestResponseDocument(query);

        assertNotNull(standardResponseXml, "Пустой ответ от эталонного сервиса");
        assertNotNull(testResponseXml, "Пустой ответ от тестируемого сервиса");

        for (int i = 0; i < standardResponseXml.getElementsByTagName("itemfound").getLength() && i < 10; i++) {
            int numberOfResults = i + 1;
            report("Проверяется " + numberOfResults + " результат выдачи для запроса " + query);

            Node itemFoundStandard = standardResponseXml.getElementsByTagName("itemfound").item(i);
            Node itemFoundTest = testResponseXml.getElementsByTagName("itemfound").item(i);

            assertNotNull(itemFoundStandard, "Отсутствует " + numberOfResults + " результат в выдачи для эталонного сервиса");
            assertNotNull(itemFoundTest, "Отсутствует " + numberOfResults + " результат в выдачи для тестируемого сервиса");

            Node artNameStandard = ((Element) itemFoundStandard).getElementsByTagName("artname").item(0);
            Node artNameTest = ((Element) itemFoundTest).getElementsByTagName("artname").item(0);
            postponedAssertEquals(artNameTest.getTextContent(), artNameStandard.getTextContent(), "Тэг 'artname' не соответсвует для " + numberOfResults + " результата выдачи");

            Node modIdStandard = ((Element) itemFoundStandard).getElementsByTagName("modId").item(0);
            Node modIdTest = ((Element) itemFoundStandard).getElementsByTagName("modId").item(0);
            postponedAssertEquals(modIdTest.getTextContent(), modIdStandard.getTextContent(), "Тэг 'modId' не соответсвует для " + numberOfResults + " результата выдачи");

            Node docIdStandard = ((Element) itemFoundStandard).getElementsByTagName("docId").item(0);
            Node docIdTest = ((Element) itemFoundStandard).getElementsByTagName("docId").item(0);
            postponedAssertEquals(docIdTest.getTextContent(), docIdStandard.getTextContent(), "Тэг 'docId' не соответсвует для " + numberOfResults + " результата выдачи");

            Node searchIndexStandard = ((Element) itemFoundStandard).getElementsByTagName("search-index").item(0);
            Node searchIndexTest = ((Element) itemFoundStandard).getElementsByTagName("search-index").item(0);
            postponedAssertEquals(searchIndexTest.getTextContent(), searchIndexStandard.getTextContent(), "Тэг 'search-index' не соответсвует для " + numberOfResults + " результата выдачи");

            Node relevanceStandard = ((Element) itemFoundStandard).getElementsByTagName("relevance").item(0);
            Node relevanceTest = ((Element) itemFoundStandard).getElementsByTagName("relevance").item(0);
            postponedAssertEquals(relevanceTest.getTextContent().replaceAll(",", "."), relevanceStandard.getTextContent().replaceAll(",", "."), "Тэг 'relevance' не соответсвует для " + numberOfResults + " результата выдачи");

            Node legalForceStandard = ((Element) itemFoundStandard).getElementsByTagName("legal-force").item(0);
            Node legalForceTest = ((Element) itemFoundStandard).getElementsByTagName("legal-force").item(0);
            postponedAssertEquals(legalForceTest.getTextContent().replaceAll(",", "."), legalForceStandard.getTextContent().replaceAll(",", "."), "Тэг 'legal-force' не соответсвует для " + numberOfResults + " результата выдачи");

            Node docStatusStandard = ((Element) itemFoundStandard).getElementsByTagName("docStatus").item(0);
            Node docStatusTest = ((Element) itemFoundStandard).getElementsByTagName("docStatus").item(0);
            postponedAssertEquals(docStatusTest.getTextContent(), docStatusStandard.getTextContent(), "Тэг 'docStatus' не соответсвует для " + numberOfResults + " результата выдачи");

            Node snippetStandard = ((Element) itemFoundStandard).getElementsByTagName("snippet").item(0);
            Node snippetTest = ((Element) itemFoundStandard).getElementsByTagName("snippet").item(0);
            postponedAssertEquals(snippetTest.getTextContent(), snippetStandard.getTextContent(), "Тэг 'snippet' не соответсвует для " + numberOfResults + " результата выдачи");

            Node snippetCaptionStandard = ((Element) itemFoundStandard).getElementsByTagName("snippetCaption").item(0);
            Node snippetCaptionTest = ((Element) itemFoundStandard).getElementsByTagName("snippetCaption").item(0);
            postponedAssertEquals(snippetCaptionTest.getTextContent(), snippetCaptionStandard.getTextContent(), "Тэг 'snippetCaption' не соответсвует для " + numberOfResults + " результата выдачи");

            String nodeStandardString = getNodeString(itemFoundStandard);
            String nodeTestString = getNodeString(itemFoundTest);
            attachStandard(nodeStandardString, "response_from_standard_" + numberOfResults);
            attachTest(nodeTestString, "response_from_test_" + numberOfResults);
            attachDiff(nodeStandardString, nodeTestString, "diff_response_" + numberOfResults);
        }
    }

    @Test(dataProvider = "provider", priority = 2)
    public void checkFirst10Relevance(String query) {
        printReport(query);

        Document standardResponseXml = getStandardResponseDocument(query);
        Document testResponseXml = getTestResponseDocument(query);

        assertNotNull(standardResponseXml, "Пустой ответ от эталонного сервиса");
        assertNotNull(testResponseXml, "Пустой ответ от тестируемого сервиса");

        for (int i = 0; i < standardResponseXml.getElementsByTagName("itemfound").getLength() && i < 10; i++) {
            int numberOfResults = i + 1;
            report("Проверяется " + numberOfResults + " результат выдачи для запроса " + query);

            Node itemFoundStandard = standardResponseXml.getElementsByTagName("itemfound").item(i);
            Node itemFoundTest = testResponseXml.getElementsByTagName("itemfound").item(i);

            assertNotNull(itemFoundStandard, "Отсутствует " + numberOfResults + " результат в выдачи");
            assertNotNull(itemFoundTest, "Отсутствует " + numberOfResults + " результат в выдачи для тестируемого сервиса");

            Node relevanceStandard = ((Element) itemFoundStandard).getElementsByTagName("relevance").item(0);
            Node relevanceTest = ((Element) itemFoundTest).getElementsByTagName("relevance").item(0);
            postponedAssertEquals(relevanceTest.getTextContent().replaceAll(",", "."), relevanceStandard.getTextContent().replaceAll(",", "."), "Значение тэга 'relevance' не соответсвует для " + numberOfResults + " результата выдачи");

            for (int j = 0; j < relevanceStandard.getAttributes().getLength(); j++) {
                String relevanceStandardValue = relevanceStandard.getAttributes().item(j).getNodeValue();
                String relevanceTestValue = relevanceTest.getAttributes().item(j).getNodeValue();

                postponedAssertEquals(relevanceTestValue.replaceAll(",", "."), relevanceStandardValue.replaceAll(",", "."), "Значение аттрибута '" + relevanceStandard.getAttributes().item(j).getNodeName() + "' в тэге 'relevance' не соответсвует для " + numberOfResults + " результата выдачи");
            }

            String nodeStandardString = getNodeString(relevanceStandard);
            String nodeTestString = getNodeString(relevanceTest);
            attachStandard(nodeStandardString, "response_from_standard_" + numberOfResults);
            attachTest(nodeTestString, "response_from_test_" + numberOfResults);
            attachDiff(nodeStandardString, nodeTestString, "diff_response_" + numberOfResults);
        }
    }

    @Test(dataProvider = "provider", priority = 3)
    public void wizards(String query) {
        printReport(query);

        Document standardResponseXml = getStandardResponseDocument(query);
        Document testResponseXml = getTestResponseDocument(query);

        assertNotNull(standardResponseXml, "Пустой ответ от эталонного сервиса");
        assertNotNull(testResponseXml, "Пустой ответ от тестируемого сервиса");

        NodeList groupFoundStandard = standardResponseXml.getElementsByTagName("groupfound");
        NodeList groupFoundTest = testResponseXml.getElementsByTagName("groupfound");

        report("Проверяется наличие колдунщиков");
        postponedAssertEquals(groupFoundStandard.getLength(), groupFoundTest.getLength(), "Количество колдунщиков не соответсвует");

        attachWizardsNode(groupFoundStandard, groupFoundTest);
    }

    @Test(dataProvider = "provider", priority = 4)
    public void wizardsCount(String query) throws IOException, SAXException {
        printReport(query);

        Document standardResponseXml = getStandardResponseDocument(query);
        Document testResponseXml = getTestResponseDocument(query);

        assertNotNull(standardResponseXml, "Пустой ответ от эталонного сервиса");
        assertNotNull(testResponseXml, "Пустой ответ от тестируемого сервиса");

        NodeList groupFoundStandard = standardResponseXml.getElementsByTagName("groupfound");
        NodeList groupFoundTest = testResponseXml.getElementsByTagName("groupfound");

        report("Проверяется количество результатов в колдунщиках");
        for (int i = 0; i < groupFoundStandard.getLength(); i++) {
            Node groupItemStandard = groupFoundStandard.item(i);
            Node groupItemTest = groupFoundTest.item(i);
            NodeList nodeElementStandard = ((Element) groupItemStandard).getElementsByTagName("itemfound");
            NodeList nodeElementTest = ((Element) groupItemTest).getElementsByTagName("itemfound");

            postponedAssertEquals(nodeElementTest.getLength(), nodeElementStandard.getLength(), "Количество результатов в колдунщике не соответсвует");
            for (int j = 0; j < nodeElementStandard.getLength(); j++) {
                Node itemFoundStandard = nodeElementStandard.item(j);
                Node itemFoundTest = nodeElementTest.item(j);

                String itemFoundStandardString = getNodeString(itemFoundStandard);
                String itemFoundTestString = getNodeString(itemFoundTest);
                Diff diff = XMLUnit.compareXML(itemFoundStandardString, itemFoundTestString);
                postponedAssertTrue(diff.identical(), "Результат в колдунщике не соответсвует");
            }
        }

        attachWizardsNode(groupFoundStandard, groupFoundTest);
    }

    @Test(dataProvider = "provider", priority = 5)
    public void wizardsType(String query) {
        printReport(query);

        Document standardResponseXml = getStandardResponseDocument(query);
        Document testResponseXml = getTestResponseDocument(query);

        assertNotNull(standardResponseXml, "Пустой ответ от эталонного сервиса");
        assertNotNull(testResponseXml, "Пустой ответ от тестируемого сервиса");

        NodeList groupFoundStandard = standardResponseXml.getElementsByTagName("groupfound");
        NodeList groupFoundTest = testResponseXml.getElementsByTagName("groupfound");

        report("Проверяется количество результатов в колдунщиках");
        for (int i = 0; i < groupFoundStandard.getLength(); i++) {
            Node groupItemStandard = groupFoundStandard.item(i);
            Node groupItemTest = groupFoundTest.item(i);
            NodeList nodeElementStandard = ((Element) groupItemStandard).getElementsByTagName("itemfound");
            NodeList nodeElementTest = ((Element) groupItemTest).getElementsByTagName("itemfound");

            postponedAssertEquals(nodeElementTest.getLength(), nodeElementStandard.getLength(), "Количество результатов в колдунщике не соответсвует");
            for (int j = 0; j < nodeElementStandard.getLength(); j++) {
                Node itemFoundStandard = nodeElementStandard.item(j);
                Node itemFoundTest = nodeElementTest.item(j);

                postponedAssertEquals(itemFoundTest.getAttributes().getNamedItem("type"), itemFoundStandard.getAttributes().getNamedItem("type"), "Тип колдунщиков не соответсвует");
            }
        }

        attachWizardsNode(groupFoundStandard, groupFoundTest);
    }

    @Test(dataProvider = "provider", priority = 6)
    public void factoid(String query) {
        printReport(query);

        Document standardResponseXml = getStandardResponseDocument(query);
        Document testResponseXml = getTestResponseDocument(query);

        assertNotNull(standardResponseXml, "Пустой ответ от эталонного сервиса");
        assertNotNull(testResponseXml, "Пустой ответ от тестируемого сервиса");

        NodeList factoidDocumentStandard = standardResponseXml.getElementsByTagName("factoidDocument");
        NodeList factoidDocumentTest = testResponseXml.getElementsByTagName("factoidDocument");

        report("Проверяется количество и содержание фактоидов");
        assertEquals(factoidDocumentTest.getLength(), factoidDocumentStandard.getLength(), "Количество фактоидов не соответсвует");

        for (int i = 0; i < factoidDocumentStandard.getLength(); i++) {
            Node nodeElementStandard = factoidDocumentStandard.item(i);
            Node nodeElementTest = factoidDocumentTest.item(i);

            postponedAssertEquals(nodeElementTest.getAttributes().getNamedItem("modId").getNodeValue(), nodeElementStandard.getAttributes().getNamedItem("modId").getNodeValue(), "Тэг 'modId' в фактоиде не соответсвует");
            postponedAssertEquals(nodeElementTest.getAttributes().getNamedItem("docId").getNodeValue(), nodeElementStandard.getAttributes().getNamedItem("docId").getNodeValue(), "Тэг 'docId' в фактоиде не соответсвует");

            String nodeStandardString = getNodeString(nodeElementStandard);
            String nodeTestString = getNodeString(nodeElementTest);
            attachStandard(nodeStandardString);
            attachTest(nodeTestString);
            attachDiff(nodeStandardString, nodeTestString);
        }
    }

    @Test(dataProvider = "provider", priority = 7)
    public void yellowDieTag(String query) {
        printReport(query);

        Document standardResponseXml = getStandardResponseDocument(query);
        Document testResponseXml = getTestResponseDocument(query);

        assertNotNull(standardResponseXml, "Пустой ответ от эталонного сервиса");
        assertNotNull(testResponseXml, "Пустой ответ от тестируемого сервиса");

        NodeList itemFoundStandard = standardResponseXml.getElementsByTagName("itemfound");
        NodeList itemFoundTest = testResponseXml.getElementsByTagName("itemfound");

        report("Проверяется наличие зелёного шильдика популярного");

        Node nodeElementStandard = itemFoundStandard.item(0);
        Node nodeElementTest = itemFoundTest.item(0);
        NodeList yellowDieStandard = ((Element) nodeElementStandard).getElementsByTagName("yellow-die");
        NodeList yellowDieTest = ((Element) nodeElementTest).getElementsByTagName("yellow-die");

        if (yellowDieStandard.getLength() != yellowDieTest.getLength()) {
            setPostponedTestFail("Отсутствует тэг 'yellow-die'");
        }

        if (yellowDieStandard.getLength() > 0 && yellowDieTest.getLength() > 0) {
            postponedAssertEquals(yellowDieTest.item(0).getChildNodes().item(0).getNodeValue(), yellowDieStandard.item(0).getChildNodes().item(0).getNodeValue(), "Значение тэга 'yellow-die' не соответсвует");
        }

        String nodeStandardString = getNodeString(nodeElementStandard);
        attachStandard(nodeStandardString);
        String nodeTestString = getNodeString(nodeElementTest);
        attachTest(nodeTestString);
        attachDiff(nodeStandardString, nodeTestString);
    }

    @Test(dataProvider = "provider", priority = 8)
    public void lowRelevance(String query) {
        printReport(query);

        Document standardResponseXml = getStandardResponseDocument(query);
        Document testResponseXml = getTestResponseDocument(query);

        assertNotNull(standardResponseXml, "Пустой ответ от эталонного сервиса");
        assertNotNull(testResponseXml, "Пустой ответ от тестируемого сервиса");

        NodeList itemFoundStandard = standardResponseXml.getElementsByTagName("itemfound");
        NodeList itemFoundTest = testResponseXml.getElementsByTagName("itemfound");

        report("Проверяется обрезание поисковой выдачи");

        int lowRelevanceIndexStandard = getLowRelevanceIndexStandard(itemFoundStandard);
        int lowRelevanceIndexTest = getLowRelevanceIndexStandard(itemFoundTest);

        postponedAssertEquals(lowRelevanceIndexTest, lowRelevanceIndexStandard, "Номер документа с которого начинается обрезание поисковой выдачи не соответсвует");
    }

    @Test(dataProvider = "provider", priority = 9)
    public void searchTag(String query) {
        printReport(query);

        Document standardResponseXml = getStandardResponseDocument(query);
        Document testResponseXml = getTestResponseDocument(query);

        assertNotNull(standardResponseXml, "Пустой ответ от эталонного сервиса");
        assertNotNull(testResponseXml, "Пустой ответ от тестируемого сервиса");

        NodeList itemFoundStandard = standardResponseXml.getElementsByTagName("itemfound");
        NodeList itemFoundTest = testResponseXml.getElementsByTagName("itemfound");

        report("Проверка списков возвращаемых Search тегов");

        for (int i = 0; i < itemFoundStandard.getLength(); i++) {
            Node itemFoundStandardNode = itemFoundStandard.item(i);
            Node itemFoundTestNode = itemFoundTest.item(i);

            if (itemFoundTestNode == null) {
                setPostponedTestFail("Отсутствует " + (i + 1) + " результат выдачи для тестового сервиса");
            }

            NodeList searchTagListStandard = ((Element) itemFoundStandardNode).getElementsByTagName("searchTagList");
            NodeList searchTagListTest = ((Element) itemFoundTestNode).getElementsByTagName("searchTagList");

            if (searchTagListStandard.getLength() > 0 && searchTagListTest.getLength() > 0) {
                Node searchTagListStandardNode = searchTagListStandard.item(0);
                Node searchTagListTestNode = searchTagListTest.item(0);
                NodeList searchTagStandard = ((Element) searchTagListStandardNode).getElementsByTagName("searchTag");
                NodeList searchTagTest = ((Element) searchTagListTestNode).getElementsByTagName("searchTag");
                for (int j = 0; j < searchTagStandard.getLength(); j++) {
                    Node searchTagTagStandard = searchTagListStandard.item(j);
                    Node searchTagTagTest = searchTagTest.item(j);

                    Node idTagStandard = ((Element) searchTagTagStandard).getElementsByTagName("id").item(0);
                    Node idTagTest = ((Element) searchTagTagTest).getElementsByTagName("id").item(0);
                    postponedAssertEquals(idTagTest.getNodeValue(), idTagStandard.getNodeValue(), "Тэг 'id' для " + (j + 1) + " 'searchTag' в " + (i + 1) + " результате выдачи не соответсвует");

                    Node nameTagStandard = ((Element) searchTagTagStandard).getElementsByTagName("name").item(0);
                    Node nameTagTest = ((Element) searchTagTagTest).getElementsByTagName("name").item(0);
                    postponedAssertEquals(nameTagTest.getNodeValue(), nameTagStandard.getNodeValue(), "Тэг 'name' для " + (j + 1) + " 'searchTag' в " + (i + 1) + " результате выдачи не соответсвует");

                }
                String searchTagListStandardNodeString = getNodeString(searchTagListStandardNode);
                String searchTagListTestNodeString = getNodeString(searchTagListTestNode);
                attachStandard(searchTagListStandardNodeString);
                attachTest(searchTagListTestNodeString);
                attachDiff(searchTagListStandardNodeString, searchTagListTestNodeString);
            }
        }
    }

    private void attachWizardsNode(NodeList groupFoundStandard, NodeList groupFoundTest) {
        if (groupFoundStandard.getLength() > 0 && groupFoundTest.getLength() > 0) {
            String groupFoundStandardString = getNodeString(groupFoundStandard);
            String groupFoundTestString = getNodeString(groupFoundTest);
            attachStandard(groupFoundStandardString);
            attachTest(groupFoundTestString);
            attachDiff(groupFoundStandardString, groupFoundTestString);
        }
    }

    private int getLowRelevanceIndexStandard(NodeList itemFoundNodeList) {
        int lowRelevanceIndexStandard = -1;
        for (int i = 0; i < itemFoundNodeList.getLength(); i++) {
            Node itemFoundStandardNode = itemFoundNodeList.item(i);
            NodeList lowRelevanceStandard = ((Element) itemFoundStandardNode).getElementsByTagName("low-relevance");
            if (lowRelevanceStandard != null && lowRelevanceStandard.getLength() > 0 && lowRelevanceStandard.item(0).getTextContent().equals("True")) {
                lowRelevanceIndexStandard = (i + 1);
                break;
            }
        }
        return lowRelevanceIndexStandard;
    }

    private Document getTestResponseDocument(String query) {
        if (testQueryMap.containsKey(query)) {
            return testQueryMap.get(query);
        } else {
            String testResponse = SendRequest.getResponse(getTestUrl(), getSortOrder(), query, getPubId(), getPubDivId());
            return getXmlDocument(testResponse);
        }
    }

    private Document getStandardResponseDocument(String query) {
        if (standardQueryMap.containsKey(query)) {
            return standardQueryMap.get(query);
        } else {
            String standardResponse = SendRequest.getResponse(getStandardUrl(), getSortOrder(), query, getPubId(), getPubDivId());
            return getXmlDocument(standardResponse);
        }
    }

    private void printReport(String query) {
        report("searchString - " + query);
        report("pubId - " + pubId);
        report("moduleListId - " + convertArrayToString(moduleIdList));
        report("searchTagListId - " + convertArrayToString(searchTagList));
        report("sortOrder - " + sortOrder);
        report("searchOptionFlag - " + searchOptionFlags);
        report("snippetSize - " + snippetSize);
        report("docPosition - " + docPosition);
        report("pageSize - " + pageSize);
        report("searchType - " + searchType);
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

    private String getNodeString(Node node) {
        try {
            StringWriter sw = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            transformer.transform(new DOMSource(node), new StreamResult(sw));
            return sw.toString();
        } catch (TransformerException e) {
            logger.error(e);
        }
        return node.getTextContent();
    }

    private String getNodeString(NodeList nodeList) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (int i = 0; i < nodeList.getLength(); i++) {
                StringWriter sw = new StringWriter();
                TransformerFactory tf = TransformerFactory.newInstance();
                Transformer transformer = tf.newTransformer();
                transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
                transformer.setOutputProperty(OutputKeys.METHOD, "xml");
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

                transformer.transform(new DOMSource(nodeList.item(i)), new StreamResult(sw));
                stringBuilder.append(sw.toString());
            }
            return stringBuilder.toString();
        } catch (TransformerException e) {
            logger.error(e);
        }
        for (int i = 0; i < nodeList.getLength(); i++) {
            stringBuilder.append(nodeList.item(i).getTextContent());
        }

        return stringBuilder.toString();
    }

    @Attachment(value = "{1}")
    public String attachStandard(String docAsString, String name) {
        return docAsString;
    }

    @Attachment(value = "response_from_standard")
    public String attachStandard(String docAsString) {
        return docAsString;
    }

    @Attachment(value = "{1}")
    public String attachTest(String docAsString, String name) {
        return docAsString;
    }

    @Attachment(value = "response_from_test")
    public String attachTest(String docAsString) {
        return docAsString;
    }

    @Attachment(value = "{2}")
    public String attachDiff(String docStandardAsString, String docTestAsString, String name) {
        try {
            return XMLUnit.compareXML(docStandardAsString, docTestAsString).toString();
        } catch (SAXException e) {
            logger.error(e);
        } catch (IOException e) {
            logger.error(e);
        }
        return "";
    }

    @Attachment(value = "diff_response")
    public String attachDiff(String docStandardAsString, String docTestAsString) {
        try {
            return XMLUnit.compareXML(docStandardAsString, docTestAsString).toString();
        } catch (SAXException e) {
            logger.error(e);
        } catch (IOException e) {
            logger.error(e);
        }
        return "";
    }

    private String getStandardUrl() {
        return System.getenv("STANDARD_URL");
//        return "http://search-service-actiondigital/SearchService.asmx";
    }

    private String getTestUrl() {
        return System.getenv("TEST_URL");
//        return "http://search-service-pro/SearchService.asmx";
    }

    private String getSortOrder() {
        return System.getenv("SORT_ORDER");
//        return "0";
    }

    private String getPubId() {
        return System.getenv("PUB_ID");
//        return "6";
    }

    private String getPubDivId() {
        return System.getenv("PUB_DIV_ID");
//        return "1";
    }

    private String[] getQueryList() {
        if (queryList == null) {
            queryList = getQueryListFromCsvFile();
        }
        return queryList;
//        return "закон;налог;кодекс;ндс;видео".split(";");
    }

    private String[] getQueryListFromCsvFile() {
        Path currentRelativePath = Paths.get("");
        String workspacePath = currentRelativePath.toAbsolutePath().getParent().toString();
        System.out.println("Current relative path is: " + workspacePath);
        String csvFilePath = workspacePath + "\\query.csv";
        List<String> queryList = new ArrayList<String>();
        try {
            File csvData = new File(csvFilePath);
            CSVParser parser = CSVParser.parse(csvData, Charset.forName("windows-1251"), CSVFormat.RFC4180);
            for (CSVRecord csvRecord : parser) {
                if (csvRecord.get(0).isEmpty()) {
                    continue;
                }
                queryList.add(csvRecord.get(0));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return queryList.toArray(new String[queryList.size()]);
    }
}
