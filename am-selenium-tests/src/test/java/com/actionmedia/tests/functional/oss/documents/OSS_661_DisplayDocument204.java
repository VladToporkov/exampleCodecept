package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 11/02/16.
 */
public class OSS_661_DisplayDocument204 extends AbstractDomainTest {

    private final static String DOC_PART_URL = "#/document/204/random";
    private final static String DOC_PART_URL_2 = "#/document/204/4";
    private final static String DOC_PART_URL_3 = "#/document/204/1";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-661", testCaseVersion = "2")
    public void oss_661_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общее отображение документов 204 модуль БСС КУ");
        bssDocument_204();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение документов 204 модуль БСС ВИП");
        bssDocument_204_vip();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общее отображение документов 204 модуль БСС БУ");
        bssDocument_204_u();

        report("Проверяется Общее отображение документов 204 модуль БСС КУ не оплаченный пользователь");
        updateLoginToInfo("");
        bssDocument_204_not_logged();
    }

    private void bssDocument_204() {
        loginBss()
                .openDocumentByModuleIdAndDocId(DOC_PART_URL)
                .сheckInfobarLinksIsNotPresent()

                .checkYellowBlockFactoid()

                .checkRubricatorButtonIsPresent("Все рекомендации")
                .checkMyFavoritesRubricatorButtonIsPresent()

                .logout();
    }

    private void bssDocument_204_vip() {
        loginBss()
                .openDocumentByModuleIdAndDocId(DOC_PART_URL_2)
                .сheckInfobarLinksIsNotPresent()

                .checkYellowBlockFactoid()

                .checkRubricatorButtonIsPresent("Все рекомендации")
                .checkMyFavoritesRubricatorButtonIsPresent()

                .logout();
    }

    private void bssDocument_204_u() {
        loginBss()
                .openDocumentByModuleIdAndDocId(DOC_PART_URL_3)
                .сheckInfobarLinksIsNotPresent()

                .checkYellowBlockFactoid()

                .checkRubricatorButtonIsPresent("Все рекомендации")
                .checkMyFavoritesRubricatorButtonIsPresent()

                .logout();
    }

    private void bssDocument_204_not_logged() {
        enterToBssWithoutLogin()
                .openDocumentByModuleIdAndDocId(DOC_PART_URL)
                .сheckInfobarLinksIsNotPresent()

                .checkYellowBlockFactoid()

                .checkRubricatorButtonIsPresent("Все рекомендации");
    }
}
