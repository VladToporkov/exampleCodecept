package com.actionmedia.tests.services.glavbuchservice;

import com.actionmedia.base.AbstractServicesTest;
import com.actionmedia.webservice.MessageElementConverter;
import com.actionmedia.webservice.NodeElement;
import com.actionmedia.webservice.ServiceResponse;
import org.apache.axis.message.MessageElement;
import org.apache.axis.types.UnsignedByte;
import org.testng.annotations.Test;

import java.rmi.RemoteException;
import java.util.List;

import static com.actionmedia.autotest.Group.glavbukh;
import static com.actionmedia.autotest.Group.service;

/**
 * User: n.tyukavkin
 * Date: 21.01.14
 * Time: 18:23
 */
public class XDocumentForms extends AbstractServicesTest {

    private static final String METHOD_NAME = "XDocument";

    @Test(groups = {glavbukh, service})
    public void xDocument_forms_test() {
        UnsignedByte modId;
        int docId;
        boolean actual = false;
        if (getSettings().isRunFss()) {
            modId = new UnsignedByte(191);
            docId = 708;
        } else if (getSettings().isRunKss()) {
            modId = new UnsignedByte(118);
            docId = 20449;
        } else if (getSettings().isRunUss()) {
            modId = new UnsignedByte(118);
            docId = 11291;
        } else {
            modId = new UnsignedByte(118);
            docId = 25462;
        }

        report("Тест для проверки метода '" + METHOD_NAME + "'");
        report("URL: " + getSettings().getGlavbukhServiceUrl());
        report("modId - " + modId);
        report("docId - " + docId);
        report("actual - " + actual);

        try {
            MessageElement messageElement = getGlavbukhService().XDocument(modId, docId, actual).get_any()[0];
            ServiceResponse response = new MessageElementConverter(messageElement).getResponse();

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

                    checkTagIsPresent(METHOD_NAME, "headerinfo >> PubID", pubId);
                    checkTagIsPresent(METHOD_NAME, "headerinfo >> PubDivID", pubDivID);
                    checkTagIsPresent(METHOD_NAME, "headerinfo >> HostUrl", hostUrl);
                    checkTagIsPresent(METHOD_NAME, "headerinfo >> document_id", documentId);
                    checkTagIsPresent(METHOD_NAME, "headerinfo >> modul_id", modulId);
                    checkTagIsPresent(METHOD_NAME, "headerinfo >> AncorTo", ancorTo);
                    checkTagIsPresent(METHOD_NAME, "headerinfo >> SuppressActualityCheck", suppressActualityCheck);

                    checkValueIsNotEmpty(METHOD_NAME, pubId);
                    checkValueIsNotEmpty(METHOD_NAME, pubDivID);
                    checkValueIsNotEmpty(METHOD_NAME, documentId);
                    checkValueIsNotEmpty(METHOD_NAME, modulId);
                } else {
                    checkTagIsPresent(METHOD_NAME, "content >> headerinfo", headerinfo);
                }

                List<NodeElement> pubDivListTagList = contentNode.getChildrenListByName("pubDivList");
                if (!pubDivListTagList.isEmpty()) {
                    List<NodeElement> pubDivTagList = pubDivListTagList.get(0).getChildrenListByName("pubDiv");
                    if (!pubDivTagList.isEmpty()) {
                        for (NodeElement pubDiv : pubDivTagList) {
                            checkAttributeIsPresent("id", pubDiv.getAttributes(), METHOD_NAME);
                            checkAttributeIsPresent("alias", pubDiv.getAttributes(), METHOD_NAME);
                            checkAttributeIsPresent("flags", pubDiv.getAttributes(), METHOD_NAME);
                            if (!pubDiv.getAttributes().get("id").equals("10") && !pubDiv.getAttributes().get("id").equals("14")) {
                                checkAttributeIsPresent("itemTypes", pubDiv.getAttributes(), METHOD_NAME);
                            }
                        }
                    } else {
                        checkTagIsPresent(METHOD_NAME, "pubDiv", pubDivTagList);
                    }
                } else {
                    checkTagIsPresent(METHOD_NAME, "pubDivList", pubDivListTagList);
                }

                List<NodeElement> docInfo = contentNode.getChildrenListByName("docinfo");
                if (!docInfo.isEmpty()) {
                    NodeElement docInfoNode = docInfo.get(0);
                    checkAttributeIsPresent("type", docInfoNode.getAttributes(), METHOD_NAME);
                    checkAttributeIsPresent("status", docInfoNode.getAttributes(), METHOD_NAME);
                    checkAttributeIsPresent("begDate", docInfoNode.getAttributes(), METHOD_NAME);

                    List<NodeElement> idList = docInfoNode.getChildrenListByName("idList");
                    if (!idList.isEmpty()) {
                        List<NodeElement> idIdList = idList.get(0).getChildrenListByName("id");
                        for (NodeElement idNode : idIdList) {
                            checkAttributeIsPresent("type", idNode.getAttributes(), METHOD_NAME);
                            checkAttributeIsPresent("value", idNode.getAttributes(), METHOD_NAME);
                        }
                    } else {
                        checkTagIsPresent(METHOD_NAME, "content >> docinfo >> idList", idList);
                    }

                    List<NodeElement> documentTitle = docInfoNode.getChildrenListByName("documentTitle");
                    List<NodeElement> xmlcontent = docInfoNode.getChildrenListByName("xmlcontent");
                    List<NodeElement> exportFileName = docInfoNode.getChildrenListByName("ExportFileName");

                    checkTagIsPresent(METHOD_NAME, "docinfo >> artname", documentTitle);
                    checkTagIsPresent(METHOD_NAME, "docinfo >> prettyDocName", xmlcontent);
                    checkTagIsPresent(METHOD_NAME, "docinfo >> ExportFileName", exportFileName);

                    checkValueIsNotEmpty(METHOD_NAME, documentTitle);
                    checkValueIsNotEmpty(METHOD_NAME, exportFileName);

                    List<NodeElement> breadcrumbsList = docInfoNode.getChildrenListByName("BreadcrumbsList");
                    if (!breadcrumbsList.isEmpty()) {
                        List<NodeElement> breadcrumbs = breadcrumbsList.get(0).getChildrenListByName("Breadcrumbs");
                        if (!breadcrumbs.isEmpty()) {
                            List<NodeElement> number = breadcrumbs.get(0).getChildrenListByName("Number");
                            List<NodeElement> rubricatorID = breadcrumbs.get(0).getChildrenListByName("RubricatorID");
                            List<NodeElement> rubricList = breadcrumbs.get(0).getChildrenListByName("RubricList");
                            checkTagIsPresent(METHOD_NAME, "Breadcrumbs >> Number", number);
                            checkTagIsPresent(METHOD_NAME, "Breadcrumbs >> RubricatorID", number);
                            checkValueIsNotEmpty(METHOD_NAME, number);
                            checkValueIsNotEmpty(METHOD_NAME, rubricatorID);

                            if (!rubricList.isEmpty()) {
                                List<NodeElement> rubric = rubricList.get(0).getChildrenListByName("Rubric");
                                if (!rubric.isEmpty()) {
                                    List<NodeElement> rubricId = rubric.get(0).getChildrenListByName("ID");
                                    List<NodeElement> rubricName = rubric.get(0).getChildrenListByName("Name");

                                    checkTagIsPresent(METHOD_NAME, "Breadcrumbs >> RubricList >> Rubric >> ID", rubricId);
                                    checkTagIsPresent(METHOD_NAME, "Breadcrumbs >> RubricList >> Rubric >> Name", rubricName);

                                    checkValueIsNotEmpty(METHOD_NAME, rubricatorID);
                                    checkValueIsNotEmpty(METHOD_NAME, rubricName);
                                } else {
                                    checkTagIsPresent(METHOD_NAME, "Breadcrumbs >> RubricList >> Rubric", rubric);
                                }
                            } else {
                                checkTagIsPresent(METHOD_NAME, "Breadcrumbs >> RubricList", number);
                            }
                        } else {
                            checkTagIsPresent(METHOD_NAME, "content >> docinfo >> Breadcrumbs", breadcrumbs);
                        }
                    } else {
                        checkTagIsPresent(METHOD_NAME, "content >> docinfo >> BreadcrumbsList", breadcrumbsList);
                    }

                    List<NodeElement> attachList = docInfoNode.getChildrenListByName("attach-list");
                    if (!attachList.isEmpty()) {
                        List<NodeElement> attach = attachList.get(0).getChildrenListByName("attach");
                        if (!attach.isEmpty()) {
                            for (NodeElement attachNode : attach) {
                                List<NodeElement> attachId = attachNode.getChildrenListByName("attach-id");
                                List<NodeElement> name = attachNode.getChildrenListByName("name");
                                List<NodeElement> mimeType = attachNode.getChildrenListByName("mime-type");
                                List<NodeElement> isFilled = attachNode.getChildrenListByName("is-filled");

                                checkTagIsPresent(METHOD_NAME, "attach >> attach-id", attachId);
                                checkTagIsPresent(METHOD_NAME, "attach >> name", name);
                                checkTagIsPresent(METHOD_NAME, "attach >> mime-type", mimeType);
                                checkTagIsPresent(METHOD_NAME, "attach >> is-filled", isFilled);

                                checkValueIsNotEmpty(METHOD_NAME, attachId);
                                checkValueIsNotEmpty(METHOD_NAME, name);
                                checkValueIsNotEmpty(METHOD_NAME, isFilled);

                                checkAttributeIsPresent("role", attachNode.getAttributes(), METHOD_NAME);
                            }
                        } else {
                            checkTagIsPresent(METHOD_NAME, "attach", attach);
                        }
                    } else {
                        checkTagIsPresent(METHOD_NAME, "attach-list", attachList);
                    }
                } else {
                    checkTagIsPresent(METHOD_NAME, "content >> docinfo", docInfo);
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
                                    checkAttributeIsPresent("type", idNode.getAttributes(), METHOD_NAME);
                                    checkAttributeIsPresent("value", idNode.getAttributes(), METHOD_NAME);
                                }
                            } else {
                                checkTagIsPresent(METHOD_NAME, "revisionList >> revision >> idList", idList);
                            }
                        }
                    } else {
                        checkTagIsPresent(METHOD_NAME, "revision", revision);
                    }
                } else {
                    checkTagIsPresent(METHOD_NAME, "revisionList", revisionList);
                }
            } else {
                checkTagIsPresent(METHOD_NAME, "content", content);
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
