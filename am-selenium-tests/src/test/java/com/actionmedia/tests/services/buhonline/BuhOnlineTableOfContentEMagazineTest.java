package com.actionmedia.tests.services.buhonline;

import com.actionmedia.base.AbstractServicesTest;
import com.actionmedia.webservice.MessageElementConverter;
import com.actionmedia.webservice.NodeElement;
import com.actionmedia.webservice.ServiceResponse;
import org.apache.axis.message.MessageElement;
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
public class BuhOnlineTableOfContentEMagazineTest extends AbstractServicesTest {

    @Test(groups = {buhonline, service})
    public void buhonline_TableOfContentEMagazine_test() {
        String methodName = "TableOfContentEMagazine";

        int epMagID = 12093;

        report("Тест для проверки метода '" + methodName + "'");
        report("Адрес сервиса 'Программа главбух': " + getSettings().getBuhOnLineServiceUrl());
        report("epMagID - " + epMagID);

        try {
            MessageElement messageElement = getBuhOnlineService().tableOfContentEMagazine(epMagID).get_any()[0];
            MessageElementConverter converter = new MessageElementConverter(messageElement);
            ServiceResponse response = converter.getResponse();

            List<NodeElement> documentTagList = response.getNodeElementListByName("document");
            if (documentTagList.isEmpty()) {
                List<NodeElement> headerinfo = documentTagList.get(0).getChildrenListByName("headerinfo");
                if (!headerinfo.isEmpty()) {
                    NodeElement headerinfoNode = headerinfo.get(0);
                    List<NodeElement> pubId = headerinfoNode.getChildrenListByName("PubID");
                    List<NodeElement> pubDivID = headerinfoNode.getChildrenListByName("PubDivID");
                    List<NodeElement> hostUrl = headerinfoNode.getChildrenListByName("HostUrl");
                    List<NodeElement> documentId = headerinfoNode.getChildrenListByName("document_id");
                    List<NodeElement> modulId = headerinfoNode.getChildrenListByName("modul_id");
                    List<NodeElement> ancorTo = headerinfoNode.getChildrenListByName("AncorTo");
                    List<NodeElement> suppressContent = headerinfoNode.getChildrenListByName("SuppressContent");
                    List<NodeElement> includeExpertInformation = headerinfoNode.getChildrenListByName("IncludeExpertInformation");

                    checkTagIsPresent(methodName, "headerinfo:PubID", pubId);
                    checkTagIsPresent(methodName, "headerinfo:PubDivID", pubDivID);
                    checkTagIsPresent(methodName, "headerinfo:HostUrl", hostUrl);
                    checkTagIsPresent(methodName, "headerinfo:document_id", documentId);
                    checkTagIsPresent(methodName, "headerinfo:modul_id", modulId);
                    checkTagIsPresent(methodName, "headerinfo:AncorTo", ancorTo);
                    checkTagIsPresent(methodName, "headerinfo:SuppressContent", suppressContent);
                    checkTagIsPresent(methodName, "headerinfo:IncludeExpertInformation", includeExpertInformation);

                    checkValueIsNotEmpty(methodName, pubId);
                    checkValueIsNotEmpty(methodName, pubDivID);
                    checkValueIsNotEmpty(methodName, documentId);
                    checkValueIsNotEmpty(methodName, modulId);
                    checkValueIsNotEmpty(methodName, suppressContent);
                    checkValueIsNotEmpty(methodName, includeExpertInformation);
                } else {
                    checkTagIsPresent(methodName, "document:headerinfo", headerinfo);
                }

                List<NodeElement> docPubDivListTagList = documentTagList.get(0).getChildrenListByName("pubDivList");
                if (!docPubDivListTagList.isEmpty()) {
                    List<NodeElement> pubDivTagList = docPubDivListTagList.get(0).getChildrenListByName("pubDiv");
                    if (!pubDivTagList.isEmpty()) {
                        checkAttributeIsPresent("id", docPubDivListTagList.get(0).getAttributes(), methodName);
                        checkAttributeIsPresent("alias", docPubDivListTagList.get(0).getAttributes(), methodName);
                        checkAttributeIsPresent("flags", docPubDivListTagList.get(0).getAttributes(), methodName);
                        checkAttributeIsPresent("itemTypes", docPubDivListTagList.get(0).getAttributes(), methodName);

                        List<NodeElement> nameTagList = docPubDivListTagList.get(0).getChildrenListByName("name");
                        checkTagIsPresent(methodName, "name", nameTagList);
                        checkValueIsNotEmpty(methodName, nameTagList);
                        checkAttributeIsPresent("forms", nameTagList.get(0).getAttributes(), methodName);
                    } else {
                        checkTagIsPresent(methodName, "document:pubDivList:pubDiv", pubDivTagList);
                    }
                } else {
                    checkTagIsPresent(methodName, "document:pubDivList", docPubDivListTagList);
                }

                List<NodeElement> docInfo = documentTagList.get(0).getChildrenListByName("docinfo");
                if (!docInfo.isEmpty()) {
                    NodeElement docInfoNode = docInfo.get(0);
                    checkAttributeIsPresent("type", docInfoNode.getAttributes(), methodName);
                    checkAttributeIsPresent("tocAvailable", docInfoNode.getAttributes(), methodName);
                    checkAttributeIsPresent("viewerAvailable", docInfoNode.getAttributes(), methodName);

                    List<NodeElement> idList = docInfoNode.getChildrenListByName("idList");
                    if (!idList.isEmpty()) {
                        List<NodeElement> idIdList = idList.get(0).getChildrenListByName("id");
                        for (NodeElement idNode : idIdList) {
                            checkAttributeIsPresent("type", idNode.getAttributes(), methodName);
                            checkAttributeIsPresent("value", idNode.getAttributes(), methodName);
                        }
                    } else {
                        checkTagIsPresent(methodName, "document:docinfo:idList", idList);
                    }

                    List<NodeElement> magViewerID = docInfoNode.getChildrenListByName("magViewerID");
                    checkTagIsPresent(methodName, "magViewerID", magViewerID);
                    checkValueIsNotEmpty(methodName, magViewerID);

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
                            checkTagIsPresent(methodName, "document:docinfo:Breadcrumbs", breadcrumbs);
                        }
                    } else {
                        checkTagIsPresent(methodName, "document:docinfo:BreadcrumbsList", breadcrumbsList);
                    }
                } else {
                    checkTagIsPresent(methodName, "document:docinfo", docInfo);
                }

                List<NodeElement> linkList = documentTagList.get(0).getChildrenListByName("linkList");
                checkTagIsPresent(methodName, "document:linkList", linkList);

                List<NodeElement> revisionList = documentTagList.get(0).getChildrenListByName("revisionList");
                if (!revisionList.isEmpty()) {
                    List<NodeElement> revision = revisionList.get(0).getChildrenListByName("revision");
                    if (!revision.isEmpty()) {
                        checkAttributeIsPresent("startDate", revision.get(0).getAttributes(), methodName);
                        checkAttributeIsPresent("status", revision.get(0).getAttributes(), methodName);
                        checkAttributeIsPresent("current", revision.get(0).getAttributes(), methodName);

                        List<NodeElement> idList = revision.get(0).getChildrenListByName("idList");
                        if (!idList.isEmpty()) {
                            List<NodeElement> idIdList = idList.get(0).getChildrenListByName("id");
                            for (NodeElement idNode : idIdList) {
                                checkAttributeIsPresent("type", idNode.getAttributes(), methodName);
                                checkAttributeIsPresent("value", idNode.getAttributes(), methodName);
                            }
                        } else {
                            checkTagIsPresent(methodName, "document:revisionList:revision:idList", idList);
                        }
                    } else {
                        checkTagIsPresent(methodName, "document:revisionList:revision", revision);
                    }
                } else {
                    checkTagIsPresent(methodName, "document:revisionList", revisionList);
                }
            } else {
                checkTagIsPresent(methodName, "document", documentTagList);
            }

            List<NodeElement> magInfo = documentTagList.get(0).getChildrenListByName("maginfo");
            if (!magInfo.isEmpty()) {
                NodeElement magInfoNode = magInfo.get(0);
                List<NodeElement> pressId = magInfoNode.getChildrenListByName("pressId");
                List<NodeElement> magazineId = magInfoNode.getChildrenListByName("magazineId");
                List<NodeElement> number = magInfoNode.getChildrenListByName("number");
                List<NodeElement> name = magInfoNode.getChildrenListByName("name");
                List<NodeElement> date = magInfoNode.getChildrenListByName("date");
                List<NodeElement> monthFrom = magInfoNode.getChildrenListByName("monthFrom");
                List<NodeElement> monthTo = magInfoNode.getChildrenListByName("monthTo");
                List<NodeElement> isPublished = magInfoNode.getChildrenListByName("isPublished");
                List<NodeElement> coverImage = magInfoNode.getChildrenListByName("coverImage");
                List<NodeElement> pressType = magInfoNode.getChildrenListByName("pressType");
                List<NodeElement> press = magInfoNode.getChildrenListByName("press");
                List<NodeElement> moduleId = magInfoNode.getChildrenListByName("moduleId");
                List<NodeElement> magname = magInfoNode.getChildrenListByName("magname");

                checkTagIsPresent(methodName, "maginfo:pressId", pressId);
                checkTagIsPresent(methodName, "maginfo:magazineId", magazineId);
                checkTagIsPresent(methodName, "maginfo:number", number);
                checkTagIsPresent(methodName, "maginfo:name", name);
                checkTagIsPresent(methodName, "maginfo:date", date);
                checkTagIsPresent(methodName, "maginfo:monthFrom", monthFrom);
                checkTagIsPresent(methodName, "maginfo:monthTo", monthTo);
                checkTagIsPresent(methodName, "maginfo:isPublished", isPublished);
                checkTagIsPresent(methodName, "maginfo:coverImage", coverImage);
                checkTagIsPresent(methodName, "maginfo:pressType", pressType);
                checkTagIsPresent(methodName, "maginfo:moduleId", moduleId);
                checkTagIsPresent(methodName, "maginfo:magname", magname);

                checkValueIsNotEmpty(methodName, pressId);
                checkValueIsNotEmpty(methodName, magazineId);
                checkValueIsNotEmpty(methodName, number);
                checkValueIsNotEmpty(methodName, date);
                checkValueIsNotEmpty(methodName, monthFrom);
                checkValueIsNotEmpty(methodName, monthTo);
                checkValueIsNotEmpty(methodName, isPublished);
                checkValueIsNotEmpty(methodName, coverImage);
                checkValueIsNotEmpty(methodName, moduleId);
                checkValueIsNotEmpty(methodName, magname);

                if (!press.isEmpty()) {
                    List<NodeElement> pressPressId = press.get(0).getChildrenListByName("pressId");
                    List<NodeElement> pressPressName = press.get(0).getChildrenListByName("pressName");
                    List<NodeElement> pressPressAlias = press.get(0).getChildrenListByName("pressAlias");
                    List<NodeElement> pressPressType = press.get(0).getChildrenListByName("pressType");

                    checkTagIsPresent(methodName, "maginfo:press:pressId", pressPressId);
                    checkTagIsPresent(methodName, "maginfo:press:pressName", pressPressName);
                    checkTagIsPresent(methodName, "maginfo:press:pressAlias", pressPressAlias);

                    checkValueIsNotEmpty(methodName, pressPressId);
                    checkValueIsNotEmpty(methodName, pressPressName);
                    checkValueIsNotEmpty(methodName, pressPressAlias);

                    if (!pressPressType.isEmpty()) {
                        List<NodeElement> pressTypeId = pressPressType.get(0).getChildrenListByName("pressTypeId");
                        List<NodeElement> basePressType = pressPressType.get(0).getChildrenListByName("BasePressType");
                        List<NodeElement> pressTypeName = pressPressType.get(0).getChildrenListByName("pressTypeName");

                        checkTagIsPresent(methodName, "maginfo:press:pressType:pressTypeId", pressTypeId);
                        checkTagIsPresent(methodName, "maginfo:press:pressType:pressTypeName", pressTypeName);

                        checkValueIsNotEmpty(methodName, pressTypeId);
                        checkValueIsNotEmpty(methodName, pressTypeName);

                        if (!basePressType.isEmpty()) {
                            List<NodeElement> basePressTypeId = basePressType.get(0).getChildrenListByName("basePressTypeId");
                            List<NodeElement> basePressTypeName = basePressType.get(0).getChildrenListByName("basePressTypeName");

                            checkTagIsPresent(methodName, "maginfo:press:pressType:BasePressType:basePressTypeId", basePressTypeId);
                            checkTagIsPresent(methodName, "maginfo:press:pressType:BasePressType:basePressTypeName", basePressTypeName);

                            checkValueIsNotEmpty(methodName, basePressTypeId);
                            checkValueIsNotEmpty(methodName, basePressTypeName);
                        } else {
                            checkTagIsPresent(methodName, "maginfo:press:pressType:BasePressType", basePressType);
                        }
                    } else {
                        checkTagIsPresent(methodName, "maginfo:press:pressType", pressPressType);
                    }
                } else {
                    checkTagIsPresent(methodName, "maginfo:press", press);
                }
            } else {
                checkTagIsPresent(methodName, "maginfo", magInfo);
            }

            List<NodeElement> articleList = documentTagList.get(0).getChildrenListByName("articleList");
            if (!articleList.isEmpty()) {
                List<NodeElement> articleItem = articleList.get(0).getChildrenListByName("articleItem");
                if (!articleItem.isEmpty()) {
                    for (NodeElement articleItemNode : articleItem) {
                        List<NodeElement> pressId = articleItemNode.getChildrenListByName("pressId");
                        List<NodeElement> magazineId = articleItemNode.getChildrenListByName("magazineId");
                        List<NodeElement> rubric = articleItemNode.getChildrenListByName("rubric");
                        List<NodeElement> articleId = articleItemNode.getChildrenListByName("articleId");
                        List<NodeElement> title = articleItemNode.getChildrenListByName("title");
                        List<NodeElement> announce = articleItemNode.getChildrenListByName("announce");
                        List<NodeElement> announce2 = articleItemNode.getChildrenListByName("announce2");
                        List<NodeElement> firstBody = articleItemNode.getChildrenListByName("firstBody");
                        List<NodeElement> xmlContent = articleItemNode.getChildrenListByName("xmlContent");
                        List<NodeElement> isPublished = articleItemNode.getChildrenListByName("isPublished");
                        List<NodeElement> version = articleItemNode.getChildrenListByName("version");
                        List<NodeElement> isDeleted = articleItemNode.getChildrenListByName("isDeleted");
                        List<NodeElement> attributeList = articleItemNode.getChildrenListByName("attributeList");
                        List<NodeElement> moduleId = articleItemNode.getChildrenListByName("moduleId");

                        checkTagIsPresent(methodName, "articleItem:pressId", pressId);
                        checkTagIsPresent(methodName, "articleItem:magazineId", magazineId);
                        checkTagIsPresent(methodName, "articleItem:rubric", rubric);
                        checkTagIsPresent(methodName, "articleItem:articleId", articleId);
                        checkTagIsPresent(methodName, "articleItem:title", title);
                        checkTagIsPresent(methodName, "articleItem:announce", announce);
                        checkTagIsPresent(methodName, "articleItem:announce2", announce2);
                        checkTagIsPresent(methodName, "articleItem:firstBody", firstBody);
                        checkTagIsPresent(methodName, "articleItem:xmlContent", xmlContent);
                        checkTagIsPresent(methodName, "articleItem:isPublished", isPublished);
                        checkTagIsPresent(methodName, "articleItem:version", version);
                        checkTagIsPresent(methodName, "articleItem:isDeleted", isDeleted);
                        checkTagIsPresent(methodName, "articleItem:attributeList", attributeList);
                        checkTagIsPresent(methodName, "articleItem:moduleId", moduleId);

                        checkValueIsNotEmpty(methodName, pressId);
                        checkValueIsNotEmpty(methodName, magazineId);
                        checkValueIsNotEmpty(methodName, articleId);
                        checkValueIsNotEmpty(methodName, title);
                        checkValueIsNotEmpty(methodName, isPublished);
                        checkValueIsNotEmpty(methodName, isDeleted);
                        checkValueIsNotEmpty(methodName, moduleId);

                        if (!rubric.isEmpty()) {
                            List<NodeElement> rubricId = rubric.get(0).getChildrenListByName("rubricId");
                            List<NodeElement> rubricName = rubric.get(0).getChildrenListByName("rubricName");

                            checkTagIsPresent(methodName, "articleItem:rubric:rubricId", rubricId);
                            checkTagIsPresent(methodName, "articleItem:rubric:rubricName", rubricName);

                            checkValueIsNotEmpty(methodName, rubricId);
                            checkValueIsNotEmpty(methodName, rubricName);
                        } else {
                            checkTagIsPresent(methodName, "articleItem:rubric", rubric);
                        }
                    }
                } else {
                    checkTagIsPresent(methodName, "articleItem", articleItem);
                }
            } else {
                checkTagIsPresent(methodName, "articleList", articleList);
            }

            List<NodeElement> press = response.getNodeElementListByName("press");

            if (!press.isEmpty()) {
                List<NodeElement> pressPressId = press.get(0).getChildrenListByName("pressId");
                List<NodeElement> pressPressName = press.get(0).getChildrenListByName("pressName");
                List<NodeElement> pressPressAlias = press.get(0).getChildrenListByName("pressAlias");
                List<NodeElement> pressPressType = press.get(0).getChildrenListByName("pressType");

                checkTagIsPresent(methodName, "container:press:pressId", pressPressId);
                checkTagIsPresent(methodName, "container:press:pressName", pressPressName);
                checkTagIsPresent(methodName, "container:press:pressAlias", pressPressAlias);

                checkValueIsNotEmpty(methodName, pressPressId);
                checkValueIsNotEmpty(methodName, pressPressName);
                checkValueIsNotEmpty(methodName, pressPressAlias);

                if (!pressPressType.isEmpty()) {
                    List<NodeElement> pressTypeId = pressPressType.get(0).getChildrenListByName("pressTypeId");
                    List<NodeElement> basePressType = pressPressType.get(0).getChildrenListByName("BasePressType");
                    List<NodeElement> pressTypeName = pressPressType.get(0).getChildrenListByName("pressTypeName");

                    checkTagIsPresent(methodName, "container:press:pressType:pressTypeId", pressTypeId);
                    checkTagIsPresent(methodName, "container:press:pressType:pressTypeName", pressTypeName);

                    checkValueIsNotEmpty(methodName, pressTypeId);
                    checkValueIsNotEmpty(methodName, pressTypeName);

                    if (!basePressType.isEmpty()) {
                        List<NodeElement> basePressTypeId = basePressType.get(0).getChildrenListByName("basePressTypeId");
                        List<NodeElement> basePressTypeName = basePressType.get(0).getChildrenListByName("basePressTypeName");

                        checkTagIsPresent(methodName, "container:press:pressType:BasePressType:basePressTypeId", basePressTypeId);
                        checkTagIsPresent(methodName, "container:press:pressType:BasePressType:basePressTypeName", basePressTypeName);

                        checkValueIsNotEmpty(methodName, basePressTypeId);
                        checkValueIsNotEmpty(methodName, basePressTypeName);
                    } else {
                        checkTagIsPresent(methodName, "container:press:pressType:BasePressType", basePressType);
                    }
                } else {
                    checkTagIsPresent(methodName, "container:press:pressType", pressPressType);
                }
            } else {
                checkTagIsPresent(methodName, "container:press", press);
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}
