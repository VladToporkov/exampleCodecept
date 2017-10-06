package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 11/05/16.
 */
public class OSS_1691_DisplayDocument99_USS extends AbstractDomainTest {

    private static final String USS_DOCUMENT_URL = "#/document/97/24541";
    private static final String BUTTON_NAME = "Все кодексы";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1691", testCaseVersion = "2")
    public void oss_246_test() {
        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Общее отображение документов (97 модуль) ЮСС КУ");
        oss_246_uss_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Общее отображение документов (97 модуль) ЮСС КД");
        oss_246_uss_test();
    }

    private void oss_246_uss_test() {
        loginUss()
                .openDocumentByModuleIdAndDocId(USS_DOCUMENT_URL)
                .checkDocumentIsOpened()
                .checkSearchInTextWidgetIsPresent()
                .checkExtendedSearchButtonIsPresent()
                .checkHelpWidgetIsPresent()
                .checkWordButtonIsPresent()
                .checkPrintButtonInKodeksIsPresent()
                .checkSendButtonIsPresentForKodeks()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkCommentsRubricatorButtonIsPresent("Обсудить")
                .checkTableOfContentsButtonIsPresent()
                .checkAddToFavoritesButtonIsPresent()

                .logout();
    }
}
