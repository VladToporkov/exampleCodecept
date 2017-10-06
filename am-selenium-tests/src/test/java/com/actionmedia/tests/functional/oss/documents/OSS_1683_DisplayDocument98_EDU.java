package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 11/05/16.
 */
public class OSS_1683_DisplayDocument98_EDU extends AbstractDomainTest {

    private static final String DOCUMENT_URL = "#/document/98/1380253";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1683", testCaseVersion = "3")
    public void oss_1683_test() {
        //edu
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.commercial");
        report("Проверяется  Общее отображение документов (98 модуль) ОБР КУ");
        oss_1683_edu_test();

        updateLoginAsInfo("edu.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется  Общее отображение документов (98 модуль) ОБР БАЗ");
        oss_1683_edu_test();

        updateLoginAsInfo("edu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется  Общее отображение документов (98 модуль) ОБР ВИП");
        oss_1683_edu_test();
    }

    private void oss_1683_edu_test() {
        loginEdu()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL)
                .checkDocumentIsOpened()
                .checkSearchInTextWidgetIsPresent()
                .checkExtendedSearchButtonIsPresent()
                .checkHelpWidgetIsPresent()
                .checkAddToFavoritesButtonsForDocumentArePresent()
                .checkWordButtonIsPresent()
                .checkPrintButtonInKodeksIsPresent()
                .checkSendButtonIsPresentForKodeks()
                .checkMyFavoritesRubricatorButtonIsPresent()

                .logout();
    }
}