package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 26.01.16
 * Time: 22:47
 */
public class OSS_245_DisplayDocument98_BSS extends AbstractDomainTest {

    private static final String DOCUMENT_URL = "#/document/98/9017";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-245", testCaseVersion = "3")
    public void oss_245_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется  Общее отображение документов (98 модуль) БСС КУ");
        oss_245_bss_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется  Общее отображение документов (98 модуль) БСС БУ");
        oss_245_bss_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется  Общее отображение документов (98 модуль) БСС УСН");
        oss_245_bss_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется  Общее отображение документов (98 модуль) БСС ВИП");
        oss_245_bss_test();
    }

    private void oss_245_bss_test() {
        loginBss()
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