package com.actionmedia.tests.experimental.createxml;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
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
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

public class CreateXml {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateXmlBase.class);

    @Test
    public void createTestNGXml() {
        Map<String, String> classPathList = getTestClassPathList();
        copyTestNGXml(classPathList);
    }

    private Map<String, String> getTestClassPathList() {
        Map<String, String> classPathMap = new HashMap<String, String>();
        Reflections reflections = new Reflections("com.actionmedia.tests.functional.oss");
        Set<Class<? extends AbstractDomainTest>> allClasses = reflections.getSubTypesOf(AbstractDomainTest.class);
        Iterator<Class<? extends AbstractDomainTest>> classIterator = allClasses.iterator();
        while (classIterator.hasNext()) {
            Class<? extends AbstractDomainTest> next = classIterator.next();
            Method[] methods = next.getMethods();
            for (Method method : methods) {
                TestLink testLinkAnnotation = method.getAnnotation(TestLink.class);
                if (testLinkAnnotation != null) {
                    if (getTestListById().contains(testLinkAnnotation.testCaseId())) {
                        classPathMap.put(testLinkAnnotation.testCaseId(), next.getName());
                    }
                    break;
                }
            }
        }
        return classPathMap;
    }

    private void copyTestNGXml(Map<String, String> classPathList) {
        try {
            Document testNGXmlFileDocument = getNormalizeXmlFile();

            Document modifiedTestNGXmlFileDocument = getModifiedTestNGXmlFile(testNGXmlFileDocument, classPathList);

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

    private Document getModifiedTestNGXmlFile(Document testNGXmlFileDocument, Map<String, String> classPathList) {
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

    private void saveTestNGXmlFile(Document doc, String modifiedFilePath) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(modifiedFilePath));
        transformer.transform(source, result);
    }

    private Document getNormalizeXmlFile() throws ParserConfigurationException, SAXException, IOException {
        URL url = getClass().getResource("/testng/stub.xml");
        File fXmlFile = new File(url.getPath());
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc;
    }

    private String getJenkinsHomePath() {
        return System.getenv("JENKINS_HOME");
    }

    private List<String> getTestListById() {
        return Arrays.asList(System.getenv("TEST_ID_LIST").split(";"));
    }

    private String getBuildTag() {
        return System.getenv("BUILD_TAG");
    }
}
