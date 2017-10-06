package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 10/05/16.
 */
public class OSS_1676_DisplayDocuments98_KSS extends AbstractDomainTest {

    private static final String DOCUMENT_URL = "#/document/98/4249726/actual";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1676", testCaseVersion = "3")
    public void oss_1676_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется  Общее отображение документов (98 модуль) КСС КУ");
        oss_1676_kss_test();

        //bu
        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется  Общее отображение документов (98 модуль) КСС БУ");
        oss_1676_kss_test();

        //vip
        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется  Общее отображение документов (98 модуль) КСС ВИП");
        oss_1676_kss_test();
    }

    private void oss_1676_kss_test() {
        loginKss()
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
