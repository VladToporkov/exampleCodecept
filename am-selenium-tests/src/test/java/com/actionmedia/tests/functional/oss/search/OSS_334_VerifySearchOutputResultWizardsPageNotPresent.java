package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;

/**
 * Created by Shman4ik on 27.01.2014.
 */
public class OSS_334_VerifySearchOutputResultWizardsPageNotPresent extends AbstractDomainTest {

    private static final String QUERY = "qweqweqweqweqweqwe";

    @Test(groups = {inDevelopment})
    @TestLink(testCaseId = "OSS-334", testCaseVersion = "1")
    public void oss_334_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Мастера) КСС КУ");
        kss_334_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Мастера)  КСС БУ");
        kss_334_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Мастера) КСС ВИП");
        kss_334_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Мастера) ЮСС КУ");
        uss_334_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Мастера) ЮСС ДОК");
        uss_334_test();
    }

    private void kss_334_test() {
        loginKss()
                .navigateToWizardsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnWizardsPageIsNotPresent()

                .checkLinksOnTypo()

                .logout();
    }

    private void uss_334_test() {
        loginUss()
                .navigateToServicesPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnWizardsPageIsNotPresent()

                .checkLinksOnTypo()

                .logout();
    }
}
