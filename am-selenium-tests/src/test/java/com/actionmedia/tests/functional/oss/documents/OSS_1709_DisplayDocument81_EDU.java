package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 16/05/16.
 */
public class OSS_1709_DisplayDocument81_EDU extends AbstractDomainTest {

    private static final String DOCUMENT_URL = "#/document/81/123381";
    private static final String BUTTON_NAME = "Правовая база";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1709", testCaseVersion = "2")
    public void oss_1709_test() {
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.commercial");
        report("Проверяется  Общее отображение документов (81 модуль) ОБР КУ");
        oss_1709_edu_test();

        updateLoginAsInfo("edu.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется  Общее отображение документов (81 модуль) ОБР БАЗ");
        oss_1709_edu_test();

        updateLoginAsInfo("edu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется  Общее отображение документов (81 модуль) ОБР ВИП");
        oss_1709_edu_test();
    }

    private void oss_1709_edu_test() {
        loginEdu()
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

                .logout();
    }
}
