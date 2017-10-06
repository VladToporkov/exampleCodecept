package com.actionmedia.tests.experimental.createxml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class CreateXmlBase {

    protected static final Logger LOGGER = LoggerFactory.getLogger(CreateXmlBase.class);

    protected void copyTestNGXml(Map<String, String> classPathList) {
        try {

            Document modifiedTestNGXmlFileDocument = getModifiedTestNGXmlFile(classPathList);

            String modifiedTestNGXmlFilePath = getJenkinsHomePath() + "\\custom_xml\\" + getBuildTag() + ".xml";

            saveTestNGXmlFile(modifiedTestNGXmlFileDocument, modifiedTestNGXmlFilePath);
        } catch (ParserConfigurationException pce) {
            LOGGER.error("ParserConfigurationException occurs in CreateXmlBase", pce);
            Assert.fail(pce.getMessage());
        } catch (TransformerException tfe) {
            LOGGER.error("TransformerException occurs in CreateXmlBase", tfe);
            Assert.fail(tfe.getMessage());
        } catch (IOException ioe) {
            LOGGER.error("IOException occurs in CreateXmlBase", ioe);
            Assert.fail(ioe.getMessage());
        } catch (SAXException sae) {
            LOGGER.error("SAXException occurs in CreateXmlBase", sae);
            Assert.fail(sae.getMessage());
        }
    }

    private Document getModifiedTestNGXmlFile(Map<String, String> classPathList) throws IOException, SAXException, ParserConfigurationException {
        String platformList = getPlatform();
        if (platformList != null && !platformList.isEmpty()) {
            Document testNGXmlFileDocument = getNormalizeXmlFile("/testng/stub_platform.xml");
            Node suite = testNGXmlFileDocument.getElementsByTagName("suite").item(0);
            Node testNodeToCopy = testNGXmlFileDocument.getElementsByTagName("test").item(0);

            for (String platform : platformList.split(",")) {
                for (Map.Entry<String, String> entry : classPathList.entrySet()) {
                    String testCaseId = entry.getKey();
                    String testClassPath = entry.getValue();
                    Node newNode = testNodeToCopy.cloneNode(true);
                    NodeList nodeList = newNode.getChildNodes();
                    ((Element) newNode).setAttribute("name", "test." + testCaseId + "." + platform);

                    for (int j = 0; j < nodeList.getLength(); j++) {
                        Node node = nodeList.item(j);
                        node.getNodeName();
                        Node platformNode = newNode.getChildNodes().item(1);
                        ((Element) platformNode).setAttribute("value", platform);

                        Node classNode = newNode.getChildNodes().item(3).getChildNodes().item(1);
                        ((Element) classNode).setAttribute("name", testClassPath);
                    }

                    suite.appendChild(newNode);
                }
            }

            suite.removeChild(testNodeToCopy);
            return testNGXmlFileDocument;
        } else {
            Document testNGXmlFileDocument = getNormalizeXmlFile("/testng/stub.xml");
            Node suite = testNGXmlFileDocument.getElementsByTagName("suite").item(0);
            Node testNodeToCopy = testNGXmlFileDocument.getElementsByTagName("test").item(0);

            for (Map.Entry<String, String> entry : classPathList.entrySet()) {
                String testCaseId = entry.getKey();
                String testClassPath = entry.getValue();
                Node newNode = testNodeToCopy.cloneNode(true);
                NodeList nodeList = newNode.getChildNodes();
                ((Element) newNode).setAttribute("name", "test." + testCaseId);

                for (int j = 0; j < nodeList.getLength(); j++) {
                    Node node = nodeList.item(j);
                    node.getNodeName();
                    Node classNode = newNode.getChildNodes().item(1).getChildNodes().item(1);
                    ((Element) classNode).setAttribute("name", testClassPath);
                }

                suite.appendChild(newNode);
            }

            suite.removeChild(testNodeToCopy);
            return testNGXmlFileDocument;
        }
    }

    private void saveTestNGXmlFile(Document doc, String modifiedFilePath) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(modifiedFilePath));
        transformer.transform(source, result);
    }

    private Document getNormalizeXmlFile(String fileName) throws ParserConfigurationException, SAXException, IOException {
        URL url = getClass().getResource(fileName);
        File fXmlFile = new File(url.getPath());
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc;
    }

    protected String getJenkinsHomePath() {
        return System.getenv("JENKINS_HOME");
    }

    protected String getBuildTag() {
        return System.getenv("BUILD_TAG");
    }

    protected String getTestPlan() {
        return System.getenv("TEST_PLAN");
    }

    protected String getPlatform() {
        return System.getenv("OSS_PLATFORMS");
    }
}
