package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 16/05/16.
 */
public class OSS_1707_DisplayDocument81_GF extends AbstractDomainTest {

    private static final String DOCUMENT_URL = "#/document/81/113098";
    private static final String BUTTON_NAME = "Все кодексы";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1707", testCaseVersion = "2")
    public void oss_1707_test() {
        //GF
        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется  Общее отображение документов (81 модуль) ГФ КУ");
        oss_1707_gf_test();
    }

    private void oss_1707_gf_test() {
        loginGF()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL)
                .checkDocumentIsOpened()
                .checkSearchInTextWidgetIsPresent()
                .checkExtendedSearchButtonIsPresent()
                .checkHelpWidgetIsPresent()
                .checkWordButtonIsPresent()
                .checkPrintButtonInKodeksIsPresent()
                .checkSendButtonIsPresentForKodeks()
                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonsForDocumentArePresent()
                .checkAssistantButtonIsPresent()

                .logout();
    }
}
