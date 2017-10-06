package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 16/05/16.
 */
public class OSS_1710_DisplayDocument81_GO extends AbstractDomainTest {

    private static final String DOCUMENT_URL = "#/document/81/113098";
    private static final String BUTTON_NAME = "Основные акты";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1710", testCaseVersion = "2")
    public void oss_1710_test() {
        updateSystemInfo(SystemPubs.go);
        updateLoginAsInfo("go.user.commercial");
        report("Проверяется  Общее отображение документов (81 модуль) ГЗ КУ");
        oss_1710_gz_test();

        updateLoginAsInfo("go.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется  Общее отображение документов (81 модуль) ГЗ БАЗ");
        oss_1710_gz_test();

        updateLoginAsInfo("go.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется  Общее отображение документов (81 модуль) ГЗ ВИП");
        oss_1710_gz_test();
    }

    private void oss_1710_gz_test() {
        loginGo()
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