package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 27.01.2014.
 */
public class OSS_335_VerifySearchOutputResultServicesAndRabotaPageNotPresent extends AbstractDomainTest {

    private static final String QUERY = "1";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-335", testCaseVersion = "1")
    public void oss_335_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Поиск в разделе Обучение/Подбор персонала КСС КУ");
        kss_335_services();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Поиск в разделе Обучение/Подбор персонала  КСС БУ");
        kss_335_services();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Поиск в разделе Обучение/Подбор персонала КСС ВИП");
        kss_335_services();

        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Поиск в разделе Обучение/Подбор персонала КСС КУ");
        kss_335_rabotaru();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Поиск в разделе Обучение/Подбор персонала  КСС БУ");
        kss_335_rabotaru();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Поиск в разделе Обучение/Подбор персонала КСС ВИП");
        kss_335_rabotaru();

    }

    private void kss_335_services() {
        loginKss()
                .navigateToEducationPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnEducationPageIsNotPresent()

                .logout();
    }

    private void kss_335_rabotaru() {
        loginKss()
                .navigateToRabotaruPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnRabotaruPageIsNotPresent()

                .logout();
    }
}
