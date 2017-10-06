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
 * Date: 01.12.2015
 * Time: 21:47
 */
public class WizardStep extends AbstractServicesTest {

    private static final String METHOD_NAME = "WizardStep";

    @Test(groups = {glavbukh, service})
    public void wizardStep_test() {
        if (getSettings().isRunProduction()) {
            report("Тесты запущены на боевом сервисе. Тест не выполнялся.");
            return;
        }

        UnsignedByte modId = new UnsignedByte(150);
        int docId = 222;
        String answersCSV = "2851;2852;2872;2884;";
        if (getSettings().isRunKss()) {
            modId = new UnsignedByte(150);
            docId = 43;
            answersCSV = "491;497;";
        } else if (getSettings().isRunUss()) {
            modId = new UnsignedByte(150);
            docId = 204;
            answersCSV = "2603;2607;2610;2619;2628;";
        } else if (getSettings().isRunFss()) {
            return;
        }

        report("Тест для проверки метода '" + METHOD_NAME + "'");
        report("URL: " + getSettings().getGlavbukhServiceUrl());
        report("modId - " + modId);
        report("docId - " + docId);
        report("answersCSV - " + answersCSV);

        try {
            MessageElement messageElement = getGlavbukhService().wizardStep(modId, docId, answersCSV).get_any()[0];
            ServiceResponse response = new MessageElementConverter(messageElement).getResponse();
            List<NodeElement> stepsAndSolutionsTagList = response.getNodeElementListByName("StepsAndSolutions");
            if (!stepsAndSolutionsTagList.isEmpty()) {
                NodeElement stepsAndSolutionsTag = stepsAndSolutionsTagList.get(0);
                List<NodeElement> stepListTagList = stepsAndSolutionsTag.getChildrenListByName("StepList");
                if (!stepListTagList.isEmpty()) {
                    NodeElement stepListTag = stepsAndSolutionsTagList.get(0);
                    List<NodeElement> stepsToFinishTagList = stepListTag.getChildrenListByName("StepsToFinish");
                    List<NodeElement> stepTagList = stepListTag.getChildrenListByName("Step");

                    checkTagIsPresent(METHOD_NAME, "StepsToFinish", stepsToFinishTagList);
                    checkTagIsPresent(METHOD_NAME, "Step", stepTagList);
                    for (NodeElement step : stepTagList) {
                        List<NodeElement> idTagList = step.getChildrenListByName("ID");

                        checkTagIsPresent(METHOD_NAME, "Step >> ID", idTagList);
                        checkValueIsNotEmpty(METHOD_NAME, idTagList);
                    }
                } else {
                    checkTagIsPresent(METHOD_NAME, "StepList", stepsAndSolutionsTagList);
                }

                List<NodeElement> answerListTagList = stepsAndSolutionsTag.getChildrenListByName("AnswerList");
                if (!answerListTagList.isEmpty()) {
                    NodeElement answerListTag = answerListTagList.get(0);
                    List<NodeElement> answerTagList = answerListTag.getChildrenListByName("Answer");

                    checkTagIsPresent(METHOD_NAME, "Answer", answerTagList);
                    for (NodeElement answer : answerTagList) {
                        List<NodeElement> idTagList = answer.getChildrenListByName("ID");

                        checkTagIsPresent(METHOD_NAME, "Answer >> ID", idTagList);
                        checkValueIsNotEmpty(METHOD_NAME, idTagList);
                    }
                } else {
                    checkTagIsPresent(METHOD_NAME, "AnswerList", answerListTagList);
                }

                List<NodeElement> solutionListTagList = stepsAndSolutionsTag.getChildrenListByName("SolutionList");
                if (!solutionListTagList.isEmpty()) {
                    NodeElement solutionListTag = solutionListTagList.get(0);
                    List<NodeElement> solutionTagList = solutionListTag.getChildrenListByName("Solution");
                    if (!solutionTagList.isEmpty()) {
                        NodeElement solutionTag = solutionTagList.get(0);
                        List<NodeElement> idTagList = solutionTag.getChildrenListByName("ID");
                        List<NodeElement> numberTagList = solutionTag.getChildrenListByName("Number");
                        List<NodeElement> wizardIDTagList = solutionTag.getChildrenListByName("WizardID");
                        List<NodeElement> textTagList = solutionTag.getChildrenListByName("Text");
                        List<NodeElement> decideListTagList = solutionTag.getChildrenListByName("DecideList");
                        List<NodeElement> wizardTagList = solutionTag.getChildrenListByName("Wizard");

                        checkTagIsPresent(METHOD_NAME, "Solution >> ID", idTagList);
                        checkTagIsPresent(METHOD_NAME, "Solution >> Number", numberTagList);
                        checkTagIsPresent(METHOD_NAME, "Solution >> WizardID", wizardIDTagList);
                        checkTagIsPresent(METHOD_NAME, "Solution >> Text", textTagList);
                        checkTagIsPresent(METHOD_NAME, "Solution >> DecideList", decideListTagList);
                        checkTagIsPresent(METHOD_NAME, "Solution >> Wizard", wizardTagList);

                        checkValueIsNotEmpty(METHOD_NAME, idTagList);
                        if (!getSettings().isRunKss()) {
                            checkValueIsNotEmpty(METHOD_NAME, numberTagList);
                        }
                        checkValueIsNotEmpty(METHOD_NAME, wizardIDTagList);
                        checkValueIsNotEmpty(METHOD_NAME, decideListTagList);

                        if (!wizardTagList.isEmpty()) {
                            NodeElement wizardTag = wizardTagList.get(0);
                            List<NodeElement> moduleIdTagList = wizardTag.getChildrenListByName("ModuleID");
                            List<NodeElement> wizardIdTagList = wizardTag.getChildrenListByName("ID");
                            List<NodeElement> wizardNumberTagList = wizardTag.getChildrenListByName("Number");
                            List<NodeElement> nameTagList = wizardTag.getChildrenListByName("Name");
                            List<NodeElement> exportFileNameTagList = wizardTag.getChildrenListByName("ExportFileName");
                            List<NodeElement> titleTagList = wizardTag.getChildrenListByName("Title");
                            List<NodeElement> headerTagList = wizardTag.getChildrenListByName("Header");
                            List<NodeElement> serviceTypeIdTagList = wizardTag.getChildrenListByName("ServicetypeID");

                            checkTagIsPresent(METHOD_NAME, "Solution >> Wizard >> ModuleID", moduleIdTagList);
                            checkTagIsPresent(METHOD_NAME, "Solution >> Wizard >> ID", wizardIdTagList);
                            checkTagIsPresent(METHOD_NAME, "Solution >> Wizard >> Number", wizardNumberTagList);
                            checkTagIsPresent(METHOD_NAME, "Solution >> Wizard >> Name", nameTagList);
                            checkTagIsPresent(METHOD_NAME, "Solution >> Wizard >> ExportFileName", exportFileNameTagList);
                            checkTagIsPresent(METHOD_NAME, "Solution >> Wizard >> Title", titleTagList);
                            checkTagIsPresent(METHOD_NAME, "Solution >> Wizard >> Header", headerTagList);
                            checkTagIsPresent(METHOD_NAME, "Solution >> Wizard >> ServicetypeID", serviceTypeIdTagList);

                            checkValueIsNotEmpty(METHOD_NAME, moduleIdTagList);
                            checkValueIsNotEmpty(METHOD_NAME, wizardIdTagList);
                            if (!getSettings().isRunKss()) {
                                checkValueIsNotEmpty(METHOD_NAME, wizardNumberTagList);
                            }
                            checkValueIsNotEmpty(METHOD_NAME, nameTagList);
                            checkValueIsNotEmpty(METHOD_NAME, exportFileNameTagList);
                            checkValueIsNotEmpty(METHOD_NAME, titleTagList);
                            checkValueIsNotEmpty(METHOD_NAME, headerTagList);
                            checkValueIsNotEmpty(METHOD_NAME, serviceTypeIdTagList);
                        }

                        List<NodeElement> solutionStepListTagList = solutionTag.getChildrenListByName("StepList");
                        if (!solutionStepListTagList.isEmpty()) {
                            NodeElement solutionStepListTag = solutionStepListTagList.get(0);
                            List<NodeElement> stepSolutionStepListTag = solutionStepListTag.getChildrenListByName("Step");
                            if (!stepSolutionStepListTag.isEmpty()) {
                                NodeElement stepSolutionStepList = stepSolutionStepListTag.get(0);
                                List<NodeElement> idStepSolutionStepListTag = stepSolutionStepList.getChildrenListByName("ID");
                                List<NodeElement> numberStepSolutionStepListTag = stepSolutionStepList.getChildrenListByName("Number");
                                List<NodeElement> visibleStepSolutionStepListTag = stepSolutionStepList.getChildrenListByName("Visible");
                                List<NodeElement> nameStepSolutionStepListTag = stepSolutionStepList.getChildrenListByName("Name");
                                List<NodeElement> headerStepSolutionStepListTag = stepSolutionStepList.getChildrenListByName("Header");
                                List<NodeElement> seqnoStepSolutionStepListTag = stepSolutionStepList.getChildrenListByName("Seqno");
                                List<NodeElement> solutionIDStepSolutionStepListTag = stepSolutionStepList.getChildrenListByName("SolutionID");
                                List<NodeElement> stepCloneIDStepSolutionStepListTag = stepSolutionStepList.getChildrenListByName("StepCloneID");
                                List<NodeElement> stepTypeIDStepSolutionStepListTag = stepSolutionStepList.getChildrenListByName("SteptypeID");
                                List<NodeElement> documentListStepSolutionStepListTag = stepSolutionStepList.getChildrenListByName("DocumentList");

                                checkTagIsPresent(METHOD_NAME, "Solution >> StepList >> Step >> ID", idStepSolutionStepListTag);
                                checkTagIsPresent(METHOD_NAME, "Solution >> StepList >> Step >> Number", numberStepSolutionStepListTag);
                                checkTagIsPresent(METHOD_NAME, "Solution >> StepList >> Step >> Visible", visibleStepSolutionStepListTag);
                                checkTagIsPresent(METHOD_NAME, "Solution >> StepList >> Step >> Name", nameStepSolutionStepListTag);
                                checkTagIsPresent(METHOD_NAME, "Solution >> StepList >> Step >> Header", headerStepSolutionStepListTag);
                                checkTagIsPresent(METHOD_NAME, "Solution >> StepList >> Step >> Seqno", seqnoStepSolutionStepListTag);
                                checkTagIsPresent(METHOD_NAME, "Solution >> StepList >> Step >> SolutionID", solutionIDStepSolutionStepListTag);
                                checkTagIsPresent(METHOD_NAME, "Solution >> StepList >> Step >> StepCloneID", stepCloneIDStepSolutionStepListTag);
                                checkTagIsPresent(METHOD_NAME, "Solution >> StepList >> Step >> SteptypeID", stepTypeIDStepSolutionStepListTag);

                                checkValueIsNotEmpty(METHOD_NAME, idStepSolutionStepListTag);
                                if (!getSettings().isRunKss()) {
                                    checkValueIsNotEmpty(METHOD_NAME, numberStepSolutionStepListTag);
                                }
                                checkValueIsNotEmpty(METHOD_NAME, visibleStepSolutionStepListTag);
                                checkValueIsNotEmpty(METHOD_NAME, nameStepSolutionStepListTag);
                                checkValueIsNotEmpty(METHOD_NAME, headerStepSolutionStepListTag);
                                checkValueIsNotEmpty(METHOD_NAME, seqnoStepSolutionStepListTag);
                                checkValueIsNotEmpty(METHOD_NAME, solutionIDStepSolutionStepListTag);
                                checkValueIsNotEmpty(METHOD_NAME, stepCloneIDStepSolutionStepListTag);
                                checkValueIsNotEmpty(METHOD_NAME, stepTypeIDStepSolutionStepListTag);

                                if (!documentListStepSolutionStepListTag.isEmpty()) {
                                    NodeElement documentListStepSolutionStepTag = documentListStepSolutionStepListTag.get(0);
                                    List<NodeElement> documentStepSolutionStepListTag = documentListStepSolutionStepTag.getChildrenListByName("Document");
                                    checkTagIsPresent(METHOD_NAME, "Solution >> StepList >> Step >> DocumentList >> Document", documentStepSolutionStepListTag);

                                    for (NodeElement documentStepSolutionStepTag : documentStepSolutionStepListTag) {
                                        List<NodeElement> moduleIdDocumentStepSolutionStepListTag = documentStepSolutionStepTag.getChildrenListByName("ModuleID");
                                        List<NodeElement> idDocumentStepSolutionStepListTag = documentStepSolutionStepTag.getChildrenListByName("ID");
                                        List<NodeElement> docNameDocumentStepSolutionStepListTag = documentStepSolutionStepTag.getChildrenListByName("DocName");
                                        List<NodeElement> sortNameDocumentStepSolutionStepListTag = documentStepSolutionStepTag.getChildrenListByName("SortName");
                                        List<NodeElement> sectionDocumentStepSolutionStepListTag = documentStepSolutionStepTag.getChildrenListByName("Section");

                                        checkTagIsPresent(METHOD_NAME, "Solution >> StepList >> Step >> DocumentList >> Document >> ModuleID", moduleIdDocumentStepSolutionStepListTag);
                                        checkTagIsPresent(METHOD_NAME, "Solution >> StepList >> Step >> DocumentList >> Document >> ID", idDocumentStepSolutionStepListTag);
                                        checkTagIsPresent(METHOD_NAME, "Solution >> StepList >> Step >> DocumentList >> Document >> DocName", docNameDocumentStepSolutionStepListTag);
                                        checkTagIsPresent(METHOD_NAME, "Solution >> StepList >> Step >> DocumentList >> Document >> SortName", sortNameDocumentStepSolutionStepListTag);
                                        checkTagIsPresent(METHOD_NAME, "Solution >> StepList >> Step >> DocumentList >> Document >> Section", sectionDocumentStepSolutionStepListTag);

                                        checkValueIsNotEmpty(METHOD_NAME, moduleIdDocumentStepSolutionStepListTag);
                                        checkValueIsNotEmpty(METHOD_NAME, idDocumentStepSolutionStepListTag);
                                        checkValueIsNotEmpty(METHOD_NAME, docNameDocumentStepSolutionStepListTag);
                                        checkValueIsNotEmpty(METHOD_NAME, sortNameDocumentStepSolutionStepListTag);
                                        checkValueIsNotEmpty(METHOD_NAME, sectionDocumentStepSolutionStepListTag);
                                    }
                                } else {
                                    checkTagIsPresent(METHOD_NAME, "Solution >> StepList >> Step >> DocumentList", documentListStepSolutionStepListTag);
                                }

                                if (getSettings().isRunBss()) {
                                    List<NodeElement> stepListStepSolutionStepListTag = stepSolutionStepList.getChildrenListByName("StepList");
                                    if (!stepListStepSolutionStepListTag.isEmpty()) {
                                        NodeElement stepListStepSolutionStepTag = stepListStepSolutionStepListTag.get(0);
                                        List<NodeElement> stepStepListStepSolutionStepTagList = stepListStepSolutionStepTag.getChildrenListByName("Step");
                                        checkTagIsPresent(METHOD_NAME, "Solution >> StepList >> Step >> StepList >> Step", stepStepListStepSolutionStepTagList);

                                        for (NodeElement stepStepListStepSolutionStepTag : stepStepListStepSolutionStepTagList) {
                                            List<NodeElement> idStepStepListStepSolutionStepTag = stepStepListStepSolutionStepTag.getChildrenListByName("ID");
                                            List<NodeElement> numberStepStepListStepSolutionStepTag = stepStepListStepSolutionStepTag.getChildrenListByName("Number");
                                            List<NodeElement> visibleStepStepListStepSolutionStepTag = stepStepListStepSolutionStepTag.getChildrenListByName("Visible");
                                            List<NodeElement> nameStepStepListStepSolutionStepTag = stepStepListStepSolutionStepTag.getChildrenListByName("Name");
                                            List<NodeElement> headerStepStepListStepSolutionStepTag = stepStepListStepSolutionStepTag.getChildrenListByName("Header");
                                            List<NodeElement> parentStepIDStepStepListStepSolutionStepTag = stepStepListStepSolutionStepTag.getChildrenListByName("ParentStepID");
                                            List<NodeElement> seqnoStepStepListStepSolutionStepTag = stepStepListStepSolutionStepTag.getChildrenListByName("Seqno");
                                            List<NodeElement> stepCloneIDStepStepListStepSolutionStepTag = stepStepListStepSolutionStepTag.getChildrenListByName("StepCloneID");
                                            List<NodeElement> stepTypeIDStepStepListStepSolutionStepTag = stepStepListStepSolutionStepTag.getChildrenListByName("SteptypeID");

                                            checkTagIsPresent(METHOD_NAME, "Solution >> StepList >> Step >> StepList >> Step >> ID", idStepStepListStepSolutionStepTag);
                                            checkTagIsPresent(METHOD_NAME, "Solution >> StepList >> Step >> StepList >> Step >> Number", numberStepStepListStepSolutionStepTag);
                                            checkTagIsPresent(METHOD_NAME, "Solution >> StepList >> Step >> StepList >> Step >> Visible", visibleStepStepListStepSolutionStepTag);
                                            checkTagIsPresent(METHOD_NAME, "Solution >> StepList >> Step >> StepList >> Step >> Name", nameStepStepListStepSolutionStepTag);
                                            checkTagIsPresent(METHOD_NAME, "Solution >> StepList >> Step >> StepList >> Step >> Header", headerStepStepListStepSolutionStepTag);
                                            checkTagIsPresent(METHOD_NAME, "Solution >> StepList >> Step >> StepList >> Step >> ParentStepID", parentStepIDStepStepListStepSolutionStepTag);
                                            checkTagIsPresent(METHOD_NAME, "Solution >> StepList >> Step >> StepList >> Step >> Seqno", seqnoStepStepListStepSolutionStepTag);
                                            checkTagIsPresent(METHOD_NAME, "Solution >> StepList >> Step >> StepList >> Step >> StepCloneID", stepCloneIDStepStepListStepSolutionStepTag);
                                            checkTagIsPresent(METHOD_NAME, "Solution >> StepList >> Step >> StepList >> Step >> SteptypeID", stepTypeIDStepStepListStepSolutionStepTag);

                                            checkValueIsNotEmpty(METHOD_NAME, idStepStepListStepSolutionStepTag);
                                            checkValueIsNotEmpty(METHOD_NAME, numberStepStepListStepSolutionStepTag);
                                            checkValueIsNotEmpty(METHOD_NAME, visibleStepStepListStepSolutionStepTag);
                                            checkValueIsNotEmpty(METHOD_NAME, nameStepStepListStepSolutionStepTag);
                                            checkValueIsNotEmpty(METHOD_NAME, headerStepStepListStepSolutionStepTag);
                                            checkValueIsNotEmpty(METHOD_NAME, parentStepIDStepStepListStepSolutionStepTag);
                                            checkValueIsNotEmpty(METHOD_NAME, seqnoStepStepListStepSolutionStepTag);
                                            checkValueIsNotEmpty(METHOD_NAME, stepCloneIDStepStepListStepSolutionStepTag);
                                            checkValueIsNotEmpty(METHOD_NAME, stepTypeIDStepStepListStepSolutionStepTag);
                                        }
                                    } else {
                                        checkTagIsPresent(METHOD_NAME, "Solution >> StepList >> Step >> StepList", stepListStepSolutionStepListTag);
                                    }
                                }
                            } else {
                                checkTagIsPresent(METHOD_NAME, "Solution >> StepList >> Step", stepSolutionStepListTag);
                            }
                        } else {
                            checkTagIsPresent(METHOD_NAME, "Solution >> StepList", solutionTagList);
                        }
                    } else {
                        checkTagIsPresent(METHOD_NAME, "Solution", solutionTagList);
                    }
                } else {
                    checkTagIsPresent(METHOD_NAME, "SolutionList", solutionListTagList);
                }
            } else {
                checkTagIsPresent(METHOD_NAME, "StepsAndSolutions", stepsAndSolutionsTagList);
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }
}

