package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 12/05/16.
 */
public class OSS_1697_DisplayDocument96_KSS extends AbstractDomainTest {

    private static final String KSS_DOCUMENT_URL = "#/document/96/420233983";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1697", testCaseVersion = "2")
    public void oss_1697_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется  Общее отображение документов (96 модуль) КСС КУ");
        oss_1697_kss_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется  Общее отображение документов (96 модуль) КСС БУ");
        oss_1697_kss_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется  Общее отображение документов (96 модуль) КСС ВИП");
        oss_1697_kss_test();
    }


    private void oss_1697_kss_test() {
        loginKss()
                .openDocumentByModuleIdAndDocId(KSS_DOCUMENT_URL)
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