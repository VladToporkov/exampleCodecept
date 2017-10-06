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
public class XDocumentWizards extends AbstractServicesTest {

    private static final String METHOD_NAME = "XDocument";

    @Test(groups = {glavbukh, service})
    public void xDocument_wizards_test() {
        if (getSettings().isRunProduction()){
            report("Тесты запущены на боевом сервисе. Тест не выполнялся.");
            return;
        }

        UnsignedByte modId;
        int docId;
        boolean actual = false;
        if (getSettings().isRunFss()) {
            return;
        } else if (getSettings().isRunKss()) {
            modId = new UnsignedByte(150);
            docId = 70;
        } else if (getSettings().isRunUss()) {
            modId = new UnsignedByte(150);
            docId = 204;
        } else {
            modId = new UnsignedByte(150);
            docId = 222;
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

                List<NodeElement> headerInfo = contentNode.getChildrenListByName("headerinfo");
                if (!headerInfo.isEmpty()) {
                    NodeElement headerInfoNode = headerInfo.get(0);
                    List<NodeElement> pubId = headerInfoNode.getChildrenListByName("PubID");
                    List<NodeElement> pubDivID = headerInfoNode.getChildrenListByName("PubDivID");
                    List<NodeElement> hostUrl = headerInfoNode.getChildrenListByName("HostUrl");
                    List<NodeElement> documentId = headerInfoNode.getChildrenListByName("document_id");
                    List<NodeElement> moduleId = headerInfoNode.getChildrenListByName("modul_id");
                    List<NodeElement> ancorTo = headerInfoNode.getChildrenListByName("AncorTo");
                    List<NodeElement> suppressActualityCheck = headerInfoNode.getChildrenListByName("SuppressActualityCheck");

                    checkTagIsPresent(METHOD_NAME, "headerinfo:PubID", pubId);
                    checkTagIsPresent(METHOD_NAME, "headerinfo:PubDivID", pubDivID);
                    checkTagIsPresent(METHOD_NAME, "headerinfo:HostUrl", hostUrl);
                    checkTagIsPresent(METHOD_NAME, "headerinfo:document_id", documentId);
                    checkTagIsPresent(METHOD_NAME, "headerinfo:modul_id", moduleId);
                    checkTagIsPresent(METHOD_NAME, "headerinfo:AncorTo", ancorTo);
                    checkTagIsPresent(METHOD_NAME, "headerinfo:SuppressActualityCheck", suppressActualityCheck);

                    checkValueIsNotEmpty(METHOD_NAME, pubId);
                    checkValueIsNotEmpty(METHOD_NAME, pubDivID);
                    checkValueIsNotEmpty(METHOD_NAME, documentId);
                    checkValueIsNotEmpty(METHOD_NAME, moduleId);
                } else {
                    checkTagIsPresent(METHOD_NAME, "content:headerinfo", headerInfo);
                }

                List<NodeElement> pubDivListTagList = contentNode.getChildrenListByName("pubDivList");
                if (!pubDivListTagList.isEmpty()) {
                    List<NodeElement> pubDivTagList = pubDivListTagList.get(0).getChildrenListByName("pubDiv");
                    checkTagIsPresent(METHOD_NAME, "pubDiv", pubDivTagList);

                    for (NodeElement pubDivTag : pubDivTagList) {
                        checkAttributeIsPresent("id", pubDivTag.getAttributes(), METHOD_NAME);
                        checkAttributeIsPresent("alias", pubDivTag.getAttributes(), METHOD_NAME);
                        checkAttributeIsPresent("flags", pubDivTag.getAttributes(), METHOD_NAME);
                    }
                } else {
                    checkTagIsPresent(METHOD_NAME, "pubDivList", pubDivListTagList);
                }

                List<NodeElement> docInfo = contentNode.getChildrenListByName("docinfo");
                if (!docInfo.isEmpty()) {
                    NodeElement docInfoNode = docInfo.get(0);
                    checkAttributeIsPresent("type", docInfoNode.getAttributes(), METHOD_NAME);

                    List<NodeElement> idList = docInfoNode.getChildrenListByName("idList");
                    if (!idList.isEmpty()) {
                        List<NodeElement> idIdList = idList.get(0).getChildrenListByName("id");
                        for (NodeElement idNode : idIdList) {
                            checkAttributeIsPresent("type", idNode.getAttributes(), METHOD_NAME);
                            checkAttributeIsPresent("value", idNode.getAttributes(), METHOD_NAME);
                        }
                    } else {
                        checkTagIsPresent(METHOD_NAME, "content:docinfo:idList", idList);
                    }

                    List<NodeElement> hostUrlDocInfoTagList = docInfoNode.getChildrenListByName("HostUrl");
                    List<NodeElement> moduleIdDocInfoTagList = docInfoNode.getChildrenListByName("ModuleID");
                    List<NodeElement> idDocInfoTagList = docInfoNode.getChildrenListByName("ID");
                    List<NodeElement> numberDocInfoTagList = docInfoNode.getChildrenListByName("Number");
                    List<NodeElement> nameDocInfoTagList = docInfoNode.getChildrenListByName("Name");
                    List<NodeElement> exportFileNameDocInfoTagList = docInfoNode.getChildrenListByName("ExportFileName");
                    List<NodeElement> titleDocInfoTagList = docInfoNode.getChildrenListByName("Title");
                    List<NodeElement> serviceTypeIdDocInfoTagList = docInfoNode.getChildrenListByName("ServicetypeID");

                    checkTagIsPresent(METHOD_NAME, "docinfo >> HostUrl", hostUrlDocInfoTagList);
                    checkTagIsPresent(METHOD_NAME, "docinfo >> ModuleID", moduleIdDocInfoTagList);
                    checkTagIsPresent(METHOD_NAME, "docinfo >> ID", idDocInfoTagList);
                    checkTagIsPresent(METHOD_NAME, "docinfo >> Number", numberDocInfoTagList);
                    checkTagIsPresent(METHOD_NAME, "docinfo >> Name", nameDocInfoTagList);
                    checkTagIsPresent(METHOD_NAME, "docinfo >> ExportFileName", exportFileNameDocInfoTagList);
                    checkTagIsPresent(METHOD_NAME, "docinfo >> Title", titleDocInfoTagList);
                    checkTagIsPresent(METHOD_NAME, "docinfo >> ServicetypeID", serviceTypeIdDocInfoTagList);

                    checkValueIsNotEmpty(METHOD_NAME, moduleIdDocInfoTagList);
                    checkValueIsNotEmpty(METHOD_NAME, idDocInfoTagList);
                    checkValueIsNotEmpty(METHOD_NAME, numberDocInfoTagList);
                    checkValueIsNotEmpty(METHOD_NAME, nameDocInfoTagList);
                    checkValueIsNotEmpty(METHOD_NAME, exportFileNameDocInfoTagList);
                    checkValueIsNotEmpty(METHOD_NAME, titleDocInfoTagList);
                    checkValueIsNotEmpty(METHOD_NAME, serviceTypeIdDocInfoTagList);

                    List<NodeElement> stepListDocInfoTagList = docInfoNode.getChildrenListByName("StepList");
                    if (!stepListDocInfoTagList.isEmpty()) {
                        NodeElement stepListDocInfoTag = stepListDocInfoTagList.get(0);
                        List<NodeElement> stepDocInfoTagList = stepListDocInfoTag.getChildrenListByName("Step");
                        checkTagIsPresent(METHOD_NAME, "docinfo >> ServicetypeID >> Step", stepDocInfoTagList);
                        for (NodeElement stepDocInfoTag : stepDocInfoTagList) {
                            List<NodeElement> stepId = stepDocInfoTag.getChildrenListByName("ID");
                            List<NodeElement> stepNumber = stepDocInfoTag.getChildrenListByName("Number");
                            List<NodeElement> stepVisible = stepDocInfoTag.getChildrenListByName("Visible");
                            List<NodeElement> stepSeqno = stepDocInfoTag.getChildrenListByName("Seqno");
                            List<NodeElement> stepStepType = stepDocInfoTag.getChildrenListByName("SteptypeID");
                            List<NodeElement> stepWizard = stepDocInfoTag.getChildrenListByName("WizardID");
                            List<NodeElement> stepQuestionList = stepDocInfoTag.getChildrenListByName("QuestionList");

                            checkTagIsPresent(METHOD_NAME, "docinfo >> ServicetypeID >> Step >> ID", stepId);
                            checkTagIsPresent(METHOD_NAME, "docinfo >> ServicetypeID >> Step >> Number", stepNumber);
                            checkTagIsPresent(METHOD_NAME, "docinfo >> ServicetypeID >> Step >> Visible", stepVisible);
                            checkTagIsPresent(METHOD_NAME, "docinfo >> ServicetypeID >> Step >> Seqno", stepSeqno);
                            checkTagIsPresent(METHOD_NAME, "docinfo >> ServicetypeID >> Step >> SteptypeID", stepStepType);
                            checkTagIsPresent(METHOD_NAME, "docinfo >> ServicetypeID >> Step >> WizardID", stepWizard);
                            checkTagIsPresent(METHOD_NAME, "docinfo >> ServicetypeID >> Step >> QuestionList", stepQuestionList);

                            checkValueIsNotEmpty(METHOD_NAME, stepId);
                            checkValueIsNotEmpty(METHOD_NAME, stepNumber);
                            checkValueIsNotEmpty(METHOD_NAME, stepVisible);
                            checkValueIsNotEmpty(METHOD_NAME, stepSeqno);
                            checkValueIsNotEmpty(METHOD_NAME, stepStepType);
                            checkValueIsNotEmpty(METHOD_NAME, stepWizard);

                            if (!stepQuestionList.isEmpty()) {
                                NodeElement stepQuestion = stepQuestionList.get(0);
                                List<NodeElement> stepQuestionId = stepQuestion.getChildrenListByName("ID");
                                List<NodeElement> stepQuestionNumber = stepQuestion.getChildrenListByName("Number");
                                List<NodeElement> stepQuestionStepId = stepQuestion.getChildrenListByName("StepID");
                                List<NodeElement> stepQuestionShowTypeId = stepQuestion.getChildrenListByName("ShowtypeID");
                                List<NodeElement> stepQuestionText = stepQuestion.getChildrenListByName("Text");
                                List<NodeElement> stepQuestionSeqno = stepQuestion.getChildrenListByName("Seqno");
                                List<NodeElement> stepQuestionAnswerTagList = stepQuestion.getChildrenListByName("AnswerList");

                                checkTagIsPresent(METHOD_NAME, "docinfo >> ServicetypeID >> Step >> QuestionList >> Question >> ID", stepQuestionId);
                                checkTagIsPresent(METHOD_NAME, "docinfo >> ServicetypeID >> Step >> QuestionList >> Question >> Number", stepQuestionNumber);
                                checkTagIsPresent(METHOD_NAME, "docinfo >> ServicetypeID >> Step >> QuestionList >> Question >> StepID", stepQuestionStepId);
                                checkTagIsPresent(METHOD_NAME, "docinfo >> ServicetypeID >> Step >> QuestionList >> Question >> ShowtypeID", stepQuestionShowTypeId);
                                checkTagIsPresent(METHOD_NAME, "docinfo >> ServicetypeID >> Step >> QuestionList >> Question >> Text", stepQuestionText);
                                checkTagIsPresent(METHOD_NAME, "docinfo >> ServicetypeID >> Step >> QuestionList >> Question >> Seqno", stepQuestionSeqno);
                                checkTagIsPresent(METHOD_NAME, "docinfo >> ServicetypeID >> Step >> QuestionList >> Question >> AnswerList", stepQuestionAnswerTagList);

                                checkValueIsNotEmpty(METHOD_NAME, stepQuestionId);
                                checkValueIsNotEmpty(METHOD_NAME, stepQuestionNumber);
                                checkValueIsNotEmpty(METHOD_NAME, stepQuestionStepId);
                                checkValueIsNotEmpty(METHOD_NAME, stepQuestionShowTypeId);
                                checkValueIsNotEmpty(METHOD_NAME, stepQuestionText);
                                checkValueIsNotEmpty(METHOD_NAME, stepQuestionSeqno);

                                if (!stepQuestionAnswerTagList.isEmpty()) {
                                    NodeElement stepQuestionAnswerTag = stepQuestionAnswerTagList.get(0);
                                    List<NodeElement> stepQuestionAnswerList = stepQuestionAnswerTag.getChildrenListByName("Answer");
                                    checkTagIsPresent(METHOD_NAME, "docinfo >> ServicetypeID >> Step >> QuestionList >> Question >> AnswerList >> Answer", stepQuestionAnswerList);
                                    for (NodeElement stepQuestionAnswer : stepQuestionAnswerList) {
                                        List<NodeElement> stepQuestionAnswerId = stepQuestionAnswer.getChildrenListByName("ID");
                                        List<NodeElement> stepQuestionAnswerNumberFirst = stepQuestionAnswer.getChildrenListByName("Number");
                                        List<NodeElement> stepQuestionAnswerQuestionId = stepQuestionAnswer.getChildrenListByName("QuestionID");
                                        List<NodeElement> stepQuestionAnswerText = stepQuestionAnswer.getChildrenListByName("Text");
                                        List<NodeElement> stepQuestionAnswerSeqno = stepQuestionAnswer.getChildrenListByName("Seqno");
                                        List<NodeElement> stepQuestionAnswerIsChoosed = stepQuestionAnswer.getChildrenListByName("IsChoosed");
                                        List<NodeElement> stepQuestionAnswerNumberSecond = stepQuestionAnswer.getChildrenListByName("Number");

                                        checkTagIsPresent(METHOD_NAME, "docinfo >> ServicetypeID >> Step >> QuestionList >> Question >> AnswerList >> Answer >> ID", stepQuestionAnswerId);
                                        checkTagIsPresent(METHOD_NAME, "docinfo >> ServicetypeID >> Step >> QuestionList >> Question >> AnswerList >> Answer >> Number", stepQuestionAnswerNumberFirst);
                                        checkTagIsPresent(METHOD_NAME, "docinfo >> ServicetypeID >> Step >> QuestionList >> Question >> AnswerList >> Answer >> QuestionID", stepQuestionAnswerQuestionId);
                                        checkTagIsPresent(METHOD_NAME, "docinfo >> ServicetypeID >> Step >> QuestionList >> Question >> AnswerList >> Answer >> Text", stepQuestionAnswerText);
                                        checkTagIsPresent(METHOD_NAME, "docinfo >> ServicetypeID >> Step >> QuestionList >> Question >> AnswerList >> Answer >> Seqno", stepQuestionAnswerSeqno);
                                        checkTagIsPresent(METHOD_NAME, "docinfo >> ServicetypeID >> Step >> QuestionList >> Question >> AnswerList >> Answer >> IsChoosed", stepQuestionAnswerIsChoosed);
                                        checkTagIsPresent(METHOD_NAME, "docinfo >> ServicetypeID >> Step >> QuestionList >> Question >> AnswerList >> Answer >> Number", stepQuestionAnswerNumberSecond);

                                        checkValueIsNotEmpty(METHOD_NAME, stepQuestionAnswerId);
                                        checkValueIsNotEmpty(METHOD_NAME, stepQuestionAnswerNumberFirst);
                                        checkValueIsNotEmpty(METHOD_NAME, stepQuestionAnswerQuestionId);
                                        checkValueIsNotEmpty(METHOD_NAME, stepQuestionAnswerText);
                                        checkValueIsNotEmpty(METHOD_NAME, stepQuestionAnswerSeqno);
                                        checkValueIsNotEmpty(METHOD_NAME, stepQuestionAnswerIsChoosed);
                                        checkValueIsNotEmpty(METHOD_NAME, stepQuestionAnswerNumberSecond);
                                    }
                                }
                            }
                        }
                    } else {
                        checkTagIsPresent(METHOD_NAME, "docinfo >> ServicetypeID >> StepList", stepListDocInfoTagList);
                    }
                } else {
                    checkTagIsPresent(METHOD_NAME, "content:docinfo", docInfo);
                }

                List<NodeElement> revisionList = contentNode.getChildrenListByName("revisionList");
                if (!revisionList.isEmpty()) {
                    List<NodeElement> revision = revisionList.get(0).getChildrenListByName("revision");
                    if (!revision.isEmpty()) {
                        for (NodeElement revisionNode : revision) {
                            checkAttributeIsPresent("status", revisionNode.getAttributes(), METHOD_NAME);
                            checkAttributeIsPresent("current", revisionNode.getAttributes(), METHOD_NAME);

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
