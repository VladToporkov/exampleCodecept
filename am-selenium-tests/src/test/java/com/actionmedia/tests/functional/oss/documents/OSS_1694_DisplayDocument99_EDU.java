package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 11/05/16.
 */
public class OSS_1694_DisplayDocument99_EDU extends AbstractDomainTest {

    private static final String FSS_DOCUMENT_URL = "#/document/97/261282";
    private static final String BUTTON_NAME = "Правовая база";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1694", testCaseVersion = "2")
    public void oss_1694_test() {
        //edu
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.commercial");
        report("Проверяется  Общее отображение документов (97 модуль) ОБР КУ");
        oss_1694_edu_test();

        updateLoginAsInfo("edu.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется  Общее отображение документов (97 модуль) ОБР БАЗ");
        oss_1694_edu_test();

        updateLoginAsInfo("edu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется  Общее отображение документов (97 модуль) ОБР ВИП");
        oss_1694_edu_test();
    }

    private void oss_1694_edu_test() {
        loginEdu()
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
                .checkAddToFavoritesButtonsForDocumentArePresent()

                .logout();
    }
}