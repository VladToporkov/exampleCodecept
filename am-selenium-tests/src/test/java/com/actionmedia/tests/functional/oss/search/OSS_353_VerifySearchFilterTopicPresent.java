package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;

/**
 * Created by Shman4ik on 17.12.2014.
 */


public class OSS_353_VerifySearchFilterTopicPresent extends AbstractDomainTest {

    private static final String QUERY = "1";

    @Test(groups = {inDevelopment})
    @TestLink(testCaseId = "OSS-353", testCaseVersion = "1")
    public void oss_353_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        report("Проверяется Поисковые фильтры По темам (Рекомендации) КСС КУ");
        kss_353_test();

        updateLoginToInfo("budget");
        report("Проверяется Поисковые фильтры По темам (Рекомендации)  КСС БУ");
        kss_353_test();

        updateLoginToInfo("vip");
        report("Проверяется Поисковые фильтры По темам (Рекомендации) КСС ВИП");
        kss_353_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        report("Проверяется Поисковые фильтры По темам (Рекомендации) БСС КУ");
        bss_353_test();

        updateLoginToInfo("usn");
        report("Проверяется Поисковые фильтры По темам (Рекомендации)  БСС УСН");
        bss_353_test();

        updateLoginToInfo("budget");
        report("Проверяется Поисковые фильтры По темам (Рекомендации)  БСС БУ");
        bss_353_test();

        updateLoginToInfo("vip");
        report("Проверяется Поисковые фильтры По темам (Рекомендации) БСС ВИП");
        bss_353_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        report("Проверяется Поисковые фильтры По темам (Рекомендации) ФСС КУ");
        fss_353_test();
    }


    private void kss_353_test() {
        getKssBasePage()
                .navigateToAnswersPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkTopicFilter()
                .checkLinksTopicFilter()
                .logout();
    }

    private void bss_353_test() {
        getBssBasePage()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkTopicFilter()
                .checkLinksTopicFilter()
                .logout();
    }

    private void fss_353_test() {
        getFssBasePage()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkTopicFilter()
                .checkLinksTopicFilter()
                .logout();
    }
}
