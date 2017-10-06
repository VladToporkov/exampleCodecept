package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 10/05/16.
 */
public class OSS_1681_DisplayDocuments98_FSS extends AbstractDomainTest {

    private static final String DOCUMENT_URL = "#/document/98/4249726/actual";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1681", testCaseVersion = "3")
    public void oss_1681_test() {
        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется  Общее отображение документов (98 модуль) ФСС КУ");
        oss_245_fss_test();
    }

    private void oss_245_fss_test() {
        loginFss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL)
                .checkDocumentIsOpened()
                .checkSearchInTextWidgetIsPresent()
                .checkExtendedSearchButtonIsPresent()
                .checkHelpWidgetIsPresent()
                .checkWordButtonIsPresent()
                .checkPrintButtonInKodeksIsPresent()
                .checkSendButtonIsPresentForKodeks()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonIsPresent()

                .logout();
    }
}
