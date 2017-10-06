package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Shman4ik on 27.12.2014.
 */
public class OSS_333_VerifySearchOutputResultWizardsPagePresent extends AbstractDomainTest {

    private static final String QUERY_KSS = "оформление";
    private static final String QUERY_USS = "порядок";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-333", testCaseVersion = "1")
    public void oss_333_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Мастера) КСС КУ");
        kss_333_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Мастера)  КСС БУ");
        kss_333_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Мастера) КСС ВИП");
        kss_333_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Мастера) ЮСС КУ");
        uss_333_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Мастера) ЮСС ДОК");
        uss_333_test();
    }

    private void kss_333_test() {
        loginKss()
                .navigateToServicesPage()
                .inputTextInSearchBox(QUERY_KSS)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnServicesPageIsOpened()

                .checkSearchResultItemList()

                .logout();
    }

    private void uss_333_test() {
        loginUss()
                .navigateToServicesPage()
                .inputTextInSearchBox(QUERY_USS)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnServicesPageIsOpened()

                .checkSearchResultItemList()

                .logout();
    }
}
