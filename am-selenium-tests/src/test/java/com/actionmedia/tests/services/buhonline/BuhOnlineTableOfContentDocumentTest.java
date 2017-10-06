package com.actionmedia.tests.services.buhonline;

import com.actionmedia.base.AbstractServicesTest;
import com.actionmedia.webservice.MessageElementConverter;
import com.actionmedia.webservice.NodeElement;
import com.actionmedia.webservice.ServiceResponse;
import org.apache.axis.message.MessageElement;
import org.apache.axis.types.UnsignedByte;
import org.testng.annotations.Test;

import java.rmi.RemoteException;
import java.util.List;

import static com.actionmedia.autotest.Group.buhonline;
import static com.actionmedia.autotest.Group.service;

/**
 * User: n.tyukavkin
 * Date: 23.05.2014
 * Time: 12:21
 */
public class BuhOnlineTableOfContentDocumentTest extends AbstractServicesTest {

    @Test(groups = {buhonline, service})
    public void buhonline_TableOfContentDocument_test() {
        String methodName = "TableOfContentDocument";

        UnsignedByte moduleId = new UnsignedByte(99);
        int id = 902167485;

        report("Тест для проверки метода '" + methodName + "'");
        report("Адрес сервиса 'Программа главбух': " + getSettings().getBuhOnLineServiceUrl());
        report("moduleId - " + moduleId);
        report("id - " + id);

        try {
            MessageElement messageElement = getBuhOnlineService().tableOfContentDocument(moduleId, id).get_any()[0];
            MessageElementConverter converter = new MessageElementConverter(messageElement);
            ServiceResponse response = converter.getResponse();

            List<NodeElement> documentTagList = response.getNodeElementListByName("document");
            if (!documentTagList.isEmpty()) {
                NodeElement documentNode = documentTagList.get(0);

                List<NodeElement> idListTagList = documentNode.getChildrenListByName("idList");
                if (!idListTagList.isEmpty()) {
                    List<NodeElement> idTagList = idListTagList.get(0).getChildrenListByName("id");

                    checkTagIsPresent(methodName, "id", idTagList);
                    checkAttributeIsPresent("type", idTagList.get(0).getAttributes(), methodName);
                    checkAttributeIsPresent("value", idTagList.get(0).getAttributes(), methodName);
                } else {
                    checkTagIsPresent(methodName, "idList", idListTagList);
                }

                List<NodeElement> tocXMLTagList = documentNode.getChildrenListByName("tocXml");
                if (!tocXMLTagList.isEmpty()) {
                    NodeElement tocXmlNode = tocXMLTagList.get(0);
                    List<NodeElement> statisticsTagList = tocXmlNode.getChildrenListByName("statistics");
                    if (!statisticsTagList.isEmpty()) {
                        NodeElement statisticsNode = statisticsTagList.get(0);
                        List<NodeElement> totalElements = statisticsNode.getChildrenListByName("totalElements");
                        List<NodeElement> totalGroups = statisticsNode.getChildrenListByName("totalGroups");
                        List<NodeElement> distinctTypes = statisticsNode.getChildrenListByName("distinctTypes");
                        List<NodeElement> untypedElements = statisticsNode.getChildrenListByName("untypedElements");
                        List<NodeElement> customElements = statisticsNode.getChildrenListByName("customElements");
                        List<NodeElement> numberedElements = statisticsNode.getChildrenListByName("numberedElements");
                        List<NodeElement> unnumberedElements = statisticsNode.getChildrenListByName("unnumberedElements");
                        List<NodeElement> docRootElements = statisticsNode.getChildrenListByName("docrootElements");
                        List<NodeElement> minIndent = statisticsNode.getChildrenListByName("minIndent");
                        List<NodeElement> maxIndent = statisticsNode.getChildrenListByName("maxIndent");

                        checkTagIsPresent(methodName, "statistics:totalElements", totalElements);
                        checkTagIsPresent(methodName, "statistics:totalGroups", totalGroups);
                        checkTagIsPresent(methodName, "statistics:distinctTypes", distinctTypes);
                        checkTagIsPresent(methodName, "statistics:untypedElements", untypedElements);
                        checkTagIsPresent(methodName, "statistics:customElements", customElements);
                        checkTagIsPresent(methodName, "statistics:numberedElements", numberedElements);
                        checkTagIsPresent(methodName, "statistics:unnumberedElements", unnumberedElements);
                        checkTagIsPresent(methodName, "statistics:docrootElements", docRootElements);
                        checkTagIsPresent(methodName, "statistics:minIndent", minIndent);
                        checkTagIsPresent(methodName, "statistics:maxIndent", maxIndent);

                        checkValueIsNotEmpty(methodName, totalElements);
                        checkValueIsNotEmpty(methodName, totalGroups);
                        checkValueIsNotEmpty(methodName, distinctTypes);
                        checkValueIsNotEmpty(methodName, untypedElements);
                        checkValueIsNotEmpty(methodName, customElements);
                        checkValueIsNotEmpty(methodName, numberedElements);
                        checkValueIsNotEmpty(methodName, unnumberedElements);
                        checkValueIsNotEmpty(methodName, docRootElements);
                        checkValueIsNotEmpty(methodName, minIndent);
                        checkValueIsNotEmpty(methodName, maxIndent);
                    } else {
                        checkTagIsPresent(methodName, "statistics", statisticsTagList);
                    }

                    List<NodeElement> headingTagList = tocXmlNode.getChildrenListByName("heading");
                    if (!headingTagList.isEmpty()) {
                        checkValueIsNotEmpty(methodName, headingTagList);
                        for (NodeElement headingNode : headingTagList) {
                            checkAttributeIsPresent("level", headingNode.getAttributes(), methodName);
                            checkAttributeIsPresent("type", headingNode.getAttributes(), methodName);
                            checkAttributeIsPresent("structId", headingNode.getAttributes(), methodName);
                            checkAttributeIsPresent("anchor", headingNode.getAttributes(), methodName);
                        }
                    } else {
                        checkTagIsPresent(methodName, "heading", headingTagList);
                    }

                    List<NodeElement> headingGroupTagList = tocXmlNode.getChildrenListByName("headingGroup");
                    if (!headingGroupTagList.isEmpty()) {
                        for (NodeElement headingNode : headingGroupTagList) {
                            checkAttributeIsPresent("type", headingNode.getAttributes(), methodName);
                        }
                    } else {
                        checkTagIsPresent(methodName, "headingGroup", headingGroupTagList);
                    }
                } else {
                    checkTagIsPresent(methodName, "tocXml", tocXMLTagList);
                }
            } else {
                checkTagIsPresent(methodName, "document", documentTagList);
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
