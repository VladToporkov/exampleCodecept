package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;

/**
 * Created by Shman4ik on 04.03.2015
 */
public class OSS_373_VerifySearchOutputResultServicesPageNotPresent extends AbstractDomainTest {

    private static final String QUERY = "qweqweqweqweqweqwe";

    @Test(groups = {inDevelopment})
    @TestLink(testCaseId = "OSS-373", testCaseVersion = "1")
    public void oss_373_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Сервисы) БСС ВИП");
        bss_373_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Сервисы) ФСС КУ");
        fss_373_test();
    }

    private void bss_373_test() {
        loginBss()
                .navigateToServicesPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnServicesPageIsNotPresent()
                .logout();
    }

    private void fss_373_test() {
        loginFss()
                .navigateToServicesPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnServicesPageIsNotPresent()
                .logout();
    }
}
