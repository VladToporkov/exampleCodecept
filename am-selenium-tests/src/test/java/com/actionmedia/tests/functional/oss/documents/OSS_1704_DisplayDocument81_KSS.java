package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 16/05/16.
 */
public class OSS_1704_DisplayDocument81_KSS extends AbstractDomainTest {

    private static final String KSS_DOCUMENT_URL = "#/document/81/48473";
    private static final String BUTTON_NAME = "Все кодексы";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1704", testCaseVersion = "2")
    public void oss_1704_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется  Общее отображение документов (81 модуль) КСС КУ");
        oss_247_kss_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется  Общее отображение документов (81 модуль) КСС БУ");
        oss_247_kss_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется  Общее отображение документов (81 модуль) КСС ВИП");
        oss_247_kss_test();
    }

    private void oss_247_kss_test() {
        loginKss()
                .openDocumentByModuleIdAndDocId(KSS_DOCUMENT_URL)
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
