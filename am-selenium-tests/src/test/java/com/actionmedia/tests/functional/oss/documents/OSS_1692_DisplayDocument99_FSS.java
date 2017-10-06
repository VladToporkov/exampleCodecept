package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 11/05/16.
 */
public class OSS_1692_DisplayDocument99_FSS extends AbstractDomainTest {

    private static final String FSS_DOCUMENT_URL = "#/document/97/261282";
    private static final String BUTTON_NAME = "Все кодексы";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1692", testCaseVersion = "2")
    public void oss_246_test() {
        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется  Общее отображение документов (97 модуль) ФСС КУ");
        oss_246_fss_test();
    }

    private void oss_246_fss_test() {
        loginFss()
                .openDocumentByModuleIdAndDocId(FSS_DOCUMENT_URL)
                .checkDocumentIsOpened()
                .checkSearchInTextWidgetIsPresent()
                .checkExtendedSearchButtonIsPresent()
                .checkHelpWidgetIsPresent()
                .checkWordButtonIsPresent()
                .checkPrintButtonInKodeksIsPresent()
                .checkSendButtonIsPresentForKodeks()
                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAssistantButtonIsPresent()
                .checkAddToFavoritesButtonIsPresent()

                .logout();
    }
}
