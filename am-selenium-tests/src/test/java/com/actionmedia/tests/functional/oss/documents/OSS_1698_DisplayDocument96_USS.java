package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 12/05/16.
 */
public class OSS_1698_DisplayDocument96_USS extends AbstractDomainTest {

    private static final String DOCUMENT_URL = "#/document/96/902285668";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1698", testCaseVersion = "2")
    public void oss_1698_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Общее отображение документов (97 модуль) ЮСС КУ");
        oss_1698_uss_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Общее отображение документов (97 модуль) ЮСС ВИП");
        oss_1698_uss_test();
    }

    private void oss_1698_uss_test() {
        loginUss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL)
                .checkDocumentIsOpened()
                .checkSearchInTextWidgetIsPresent()
                .checkExtendedSearchButtonIsPresent()
                .checkAddToFavoritesButtonsForDocumentArePresent()
                .checkHelpWidgetIsPresent()
                .checkWordButtonIsPresent()
                .checkPrintButtonInKodeksIsPresent()
                .checkSendButtonIsPresentForKodeks()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAssistantButtonIsPresent()
                .checkCommentsRubricatorButtonIsPresent("Обсудить")

                .logout();
    }
}
