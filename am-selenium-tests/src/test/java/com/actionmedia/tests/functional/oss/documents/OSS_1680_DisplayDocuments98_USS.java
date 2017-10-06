package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 10/05/16.
 */
public class OSS_1680_DisplayDocuments98_USS extends AbstractDomainTest {

    private static final String DOCUMENT_URL = "#/document/98/4249726/actual";
    private static final String BUTTON_NAME = "Обсудить";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1680", testCaseVersion = "3")
    public void oss_1680_test() {
        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Общее отображение документов (98 модуль) ЮСС КУ");
        oss_245_uss_test();

        updateLoginAsInfo("uss.user.commercial");
        updateLoginAsInfo("doc");
        report("Проверяется Общее отображение документов (98 модуль) ЮСС КУ");
        oss_245_uss_test();
    }

    private void oss_245_uss_test() {
        loginUss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL)
                .checkDocumentIsOpened()
                .checkSearchInTextWidgetIsPresent()
                .checkExtendedSearchButtonIsPresent()
                .checkHelpWidgetIsPresent()
                .checkWordButtonIsPresent()
                .checkPrintButtonInKodeksIsPresent()
                .checkSendButtonIsPresentForKodeks()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkCommentsRubricatorButtonIsPresent(BUTTON_NAME)
                .checkAddToFavoritesButtonIsPresent()

                .logout();
    }
}
