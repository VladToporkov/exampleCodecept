package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 03/02/16.
 */
public class OSS_615_DisplayDocuments170 extends AbstractDomainTest {

    private final static String DOC_PART_URL_VIP = "#/document/170/9598";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-615", testCaseVersion = "1")
    public void oss_615_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение документов 170 модуль БСС ВИП");
        bssDocument_170_VIP();
    }

    private void bssDocument_170_VIP() {
        loginBss()
                .openDocumentByModuleIdAndDocId(DOC_PART_URL_VIP)
                .checkMenu()
                .checkWordButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkPrintIcon()

                .checkDocumentTitleIsPresent()
                .checkContentIsPresent()

                .checkSafetyLightsIsPresent()
                .checkControlBlockIncutForDocument170_9598()
                .checkSafetyResultIsPresent()

                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkRubricatorButtonIsPresent("Все рекомендации")

                .checkAddToFavoritesButtonsForDocumentArePresent()

                .logout();
    }
}
