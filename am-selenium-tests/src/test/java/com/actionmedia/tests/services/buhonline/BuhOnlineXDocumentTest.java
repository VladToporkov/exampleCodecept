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
public class BuhOnlineXDocumentTest extends AbstractServicesTest {

    @Test(groups = {buhonline, service})
    public void buhonline_XDocument_test() {
        String methodName = "XDocument";

        UnsignedByte moduleID = new UnsignedByte(118);
        int id = 18464;
        String anchor = "";
        boolean isActual = false;

        report("Тест для проверки метода 'XDocument'");
        report("Адрес сервиса 'Программа главбух': " + getSettings().getBuhOnLineServiceUrl());
        report("moduleID - " + moduleID);
        report("id - " + id);
        report("anchor - " + anchor);
        report("isActual - " + isActual);

        try {
            MessageElement messageElement = getBuhOnlineService().XDocument(moduleID, id, anchor, isActual).get_any()[0];
            MessageElementConverter converter = new MessageElementConverter(messageElement);
            ServiceResponse response = converter.getResponse();

            List<NodeElement> content = response.getNodeElementListByName("content");
            if (!content.isEmpty()) {
                NodeElement contentNode = content.get(0);

                List<NodeElement> headerinfo = contentNode.getChildrenListByName("headerinfo");
                if (!headerinfo.isEmpty()) {
                    NodeElement headerinfoNode = headerinfo.get(0);
                    List<NodeElement> pubId = headerinfoNode.getChildrenListByName("PubID");
                    List<NodeElement> pubDivID = headerinfoNode.getChildrenListByName("PubDivID");
                    List<NodeElement> hostUrl = headerinfoNode.getChildrenListByName("HostUrl");
                    List<NodeElement> documentId = headerinfoNode.getChildrenListByName("document_id");
                    List<NodeElement> modulId = headerinfoNode.getChildrenListByName("modul_id");
                    List<NodeElement> ancorTo = headerinfoNode.getChildrenListByName("AncorTo");
                    List<NodeElement> suppressActualityCheck = headerinfoNode.getChildrenListByName("SuppressActualityCheck");

                    checkTagIsPresent(methodName, "headerinfo:PubID", pubId);
                    checkTagIsPresent(methodName, "headerinfo:PubDivID", pubDivID);
                    checkTagIsPresent(methodName, "headerinfo:HostUrl", hostUrl);
                    checkTagIsPresent(methodName, "headerinfo:document_id", documentId);
                    checkTagIsPresent(methodName, "headerinfo:modul_id", modulId);
                    checkTagIsPresent(methodName, "headerinfo:AncorTo", ancorTo);
                    checkTagIsPresent(methodName, "headerinfo:SuppressActualityCheck", suppressActualityCheck);

                    checkValueIsNotEmpty(methodName, pubId);
                    checkValueIsNotEmpty(methodName, pubDivID);
                    checkValueIsNotEmpty(methodName, documentId);
                    checkValueIsNotEmpty(methodName, modulId);
                } else {
                    checkTagIsPresent(methodName, "content:headerinfo", headerinfo);
                }

                List<NodeElement> pubDivListTagList = contentNode.getChildrenListByName("pubDivList");
                if (!pubDivListTagList.isEmpty()) {
                    List<NodeElement> pubDivTagList = pubDivListTagList.get(0).getChildrenListByName("pubDiv");
                    if (!pubDivTagList.isEmpty()) {
                        for (NodeElement pubDiv : pubDivTagList) {
                            checkAttributeIsPresent("id", pubDiv.getAttributes(), methodName);
                            checkAttributeIsPresent("alias", pubDiv.getAttributes(), methodName);
                            checkAttributeIsPresent("flags", pubDiv.getAttributes(), methodName);
                            if (!pubDiv.getAttributes().get("id").equals("10")) {
                                checkAttributeIsPresent("itemTypes", pubDiv.getAttributes(), methodName);
                            }
                        }
                    } else {
                        checkTagIsPresent(methodName, "pubDiv", pubDivTagList);
                    }
                } else {
                    checkTagIsPresent(methodName, "pubDivList", pubDivListTagList);
                }

                List<NodeElement> docInfo = contentNode.getChildrenListByName("docinfo");
                if (!docInfo.isEmpty()) {
                    NodeElement docInfoNode = docInfo.get(0);
                    checkAttributeIsPresent("type", docInfoNode.getAttributes(), methodName);
                    checkAttributeIsPresent("status", docInfoNode.getAttributes(), methodName);
                    checkAttributeIsPresent("begDate", docInfoNode.getAttributes(), methodName);

                    List<NodeElement> idList = docInfoNode.getChildrenListByName("idList");
                    if (!idList.isEmpty()) {
                        List<NodeElement> idIdList = idList.get(0).getChildrenListByName("id");
                        for (NodeElement idNode : idIdList) {
                            checkAttributeIsPresent("type", idNode.getAttributes(), methodName);
                            checkAttributeIsPresent("value", idNode.getAttributes(), methodName);
                        }
                    } else {
                        checkTagIsPresent(methodName, "content:docinfo:idList", idList);
                    }

                    List<NodeElement> documentTitle = docInfoNode.getChildrenListByName("documentTitle");
                    List<NodeElement> xmlcontent = docInfoNode.getChildrenListByName("xmlcontent");
                    List<NodeElement> exportFileName = docInfoNode.getChildrenListByName("ExportFileName");

                    checkTagIsPresent(methodName, "docinfo:artname", documentTitle);
                    checkTagIsPresent(methodName, "docinfo:prettyDocName", xmlcontent);
                    checkTagIsPresent(methodName, "docinfo:ExportFileName", exportFileName);

                    checkValueIsNotEmpty(methodName, documentTitle);
                    checkValueIsNotEmpty(methodName, exportFileName);

                    List<NodeElement> breadcrumbsList = docInfoNode.getChildrenListByName("BreadcrumbsList");
                    if (!breadcrumbsList.isEmpty()) {
                        List<NodeElement> breadcrumbs = breadcrumbsList.get(0).getChildrenListByName("Breadcrumbs");
                        if (!breadcrumbs.isEmpty()) {
                            List<NodeElement> number = breadcrumbs.get(0).getChildrenListByName("Number");
                            List<NodeElement> rubricatorID = breadcrumbs.get(0).getChildrenListByName("RubricatorID");
                            List<NodeElement> rubricList = breadcrumbs.get(0).getChildrenListByName("RubricList");
                            checkTagIsPresent(methodName, "Breadcrumbs:Number", number);
                            checkTagIsPresent(methodName, "Breadcrumbs:RubricatorID", number);
                            checkValueIsNotEmpty(methodName, number);
                            checkValueIsNotEmpty(methodName, rubricatorID);

                            if (!rubricList.isEmpty()) {
                                List<NodeElement> rubric = rubricList.get(0).getChildrenListByName("Rubric");
                                if (!rubric.isEmpty()) {
                                    List<NodeElement> rubricId = rubric.get(0).getChildrenListByName("ID");
                                    List<NodeElement> rubricName = rubric.get(0).getChildrenListByName("Name");

                                    checkTagIsPresent(methodName, "Breadcrumbs:RubricList:Rubric:ID", rubricId);
                                    checkTagIsPresent(methodName, "Breadcrumbs:RubricList:Rubric:Name", rubricName);

                                    checkValueIsNotEmpty(methodName, rubricatorID);
                                    checkValueIsNotEmpty(methodName, rubricName);
                                } else {
                                    checkTagIsPresent(methodName, "Breadcrumbs:RubricList:Rubric", rubric);
                                }
                            } else {
                                checkTagIsPresent(methodName, "Breadcrumbs:RubricList", number);
                            }
                        } else {
                            checkTagIsPresent(methodName, "content:docinfo:Breadcrumbs", breadcrumbs);
                        }
                    } else {
                        checkTagIsPresent(methodName, "content:docinfo:BreadcrumbsList", breadcrumbsList);
                    }

                    List<NodeElement> attachList = docInfoNode.getChildrenListByName("attach-list");
                    if (!attachList.isEmpty()) {
                        List<NodeElement> attach = attachList.get(0).getChildrenListByName("attach");
                        if (!attach.isEmpty()) {
                            for (NodeElement attachNode : attach) {
                                List<NodeElement> attachId = attachNode.getChildrenListByName("attach-id");
                                List<NodeElement> name = attachNode.getChildrenListByName("name");
                                List<NodeElement> isFilled = attachNode.getChildrenListByName("is-filled");

                                checkTagIsPresent(methodName, "attach:attach-id", attachId);
                                checkTagIsPresent(methodName, "attach:name", name);
                                checkTagIsPresent(methodName, "attach:is-filled", isFilled);

                                checkValueIsNotEmpty(methodName, attachId);
                                checkValueIsNotEmpty(methodName, name);
                                checkValueIsNotEmpty(methodName, isFilled);

                                checkAttributeIsPresent("role", attachNode.getAttributes(), methodName);
                            }
                        } else {
                            checkTagIsPresent(methodName, "attach", attach);
                        }
                    } else {
                        checkTagIsPresent(methodName, "attach-list", attachList);
                    }
                } else {
                    checkTagIsPresent(methodName, "content:docinfo", docInfo);
                }

                List<NodeElement> revisionList = contentNode.getChildrenListByName("revisionList");
                if (!revisionList.isEmpty()) {
                    List<NodeElement> revision = revisionList.get(0).getChildrenListByName("revision");
                    if (!revision.isEmpty()) {
                        for (NodeElement revisionNode : revision) {
                            List<NodeElement> idList = revisionNode.getChildrenListByName("idList");
                            if (!idList.isEmpty()) {
                                List<NodeElement> idIdList = idList.get(0).getChildrenListByName("id");
                                for (NodeElement idNode : idIdList) {
                                    checkAttributeIsPresent("type", idNode.getAttributes(), methodName);
                                    checkAttributeIsPresent("value", idNode.getAttributes(), methodName);
                                }
                            } else {
                                checkTagIsPresent(methodName, "revisionList:revision:idList", idList);
                            }
                        }
                    } else {
                        checkTagIsPresent(methodName, "revision", revision);
                    }
                } else {
                    checkTagIsPresent(methodName, "revisionList", revisionList);
                }
            } else {
                checkTagIsPresent(methodName, "content", content);
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
