package com.actionmedia.tests.functional.oss.services;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.edu.EduDocumentPage;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 04/05/16.
 */
public class OSS_1632_VerifyDocumentsEDU_193 extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1632", testCaseVersion = "1")
    public void oss_1632_test() {
        //EDU
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.commercial");
        report("Проверяется Общее отображение документов OSS-1632 (подраздел Конструкторы) ОБР КУ");
        test_templates("#/document/193/117/");

        updateLoginAsInfo("edu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение документов OSS-1632 (подраздел Конструкторы) ОБР ВИП");
        test_templates("#/document/193/119/");
    }

    private void test_templates(String documentId) {
        loginEdu()
                .openDocumentByModuleIdAndDocId(documentId)
                .checkDocumentIsOpened()
                .checkWordButtonIsPresent()
                .checkPrintButtonIsPresent()
                .checkDocumentTitleIsPresent()
                .checkLinkTemplateDocEMCFRIsPresent()

                .checkLinkTemplateDocEMCFRHasAttributeTargetBlank()
                .clickOnLinkTemplateDocEMCFR() //REDIRECT LINK
                .checkConstructorTemplateEMCFRIsOpened()
                .openPageByUrl(String.valueOf(getParameter(EduDocumentPage.CURRENT_URL))) //SPIKE: REDIRECT LINK AFTER CLICKING BY THE LINK AND RETURN BACK IS NOT WORKING
                .logout()
                .deleteCookies()
                .openPageByUrl("https://id2.action-media.ru/Account/LogOff");
    }
}
