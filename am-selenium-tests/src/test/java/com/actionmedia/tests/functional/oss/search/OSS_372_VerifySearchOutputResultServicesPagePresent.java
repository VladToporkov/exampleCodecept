package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Shman4ik on 04.03.2015
 */
public class OSS_372_VerifySearchOutputResultServicesPagePresent extends AbstractDomainTest {

    private static final String QUERY_BSS = "транспортный налог";
    private static final String QUERY_FSS = "руководство";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-372", testCaseVersion = "2")
    public void oss_372_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Поисковая выдача (Сервисы) БСС КУ");
        bss_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Поисковая выдача (Сервисы) БСС ВИП");
        bss_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Поисковая выдача (Сервисы) БСС ЮСН");
        bss_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Поисковая выдача (Сервисы) БСС БУ");
        bss_test();

        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Поисковая выдача (Сервисы) ФСС КУ");
        fss_test();
    }

    private void bss_test() {
        loginBss()
                .navigateToServicesPage()
                .inputTextInSearchBox(QUERY_BSS)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnServicesPageIsOpened()

                .checkSearchResultItemList()
                .checkDocumentWithTextIsPresent("Расчетчик транспортного налога")

                .logout();
    }

    private void fss_test() {
        loginFss()
                .navigateToServicesPage()
                .inputTextInSearchBox(QUERY_FSS)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnServicesPageIsOpened()

                .checkSearchResultItemList()

                .logout();
    }

}
