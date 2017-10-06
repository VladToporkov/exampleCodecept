package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 12/05/16.
 */
public class OSS_1699_DisplayDocument96_FSS extends AbstractDomainTest {

    private static final String DOCUMENT_URL = "#/document/96/902146610";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1699", testCaseVersion = "2")
    public void oss_1699_test() {
        //fss
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется  Общее отображение документов (96 модуль) ФСС КУ");
        oss_1699_fss_test();
    }

    private void oss_1699_fss_test() {
        loginFss()
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

                .logout();
    }
}
