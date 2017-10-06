package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel Popov on 23/10/15.
 */
public class OSS_1215_SearchFilterMagazineLogic extends AbstractDomainTest {

    private static final String QUERY = "1";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1215", testCaseVersion = "1")
    public void oss_1215_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Поисковые фильтры По изданиям (Логика) БСС КУ");
        testBSS();

        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Поисковые фильтры По изданиям (Логика) КСС КУ");
        testKSS();

        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Поисковые фильтры По изданиям (Логика) ЮСС КУ");
        testUSS();

        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Поисковые фильтры По изданиям (Логика) ФСС КУ");
        testFSS();
    }

    private void testBSS() {
        loginBss()
                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkLinksMagazinFilter()
                .logout();
    }

    private void testFSS() {
        loginFss()
                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkLinksMagazinFilter()
                .logout();
    }

    private void testUSS() {
        loginUss()
                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkLinksMagazinFilter()
                .logout();
    }

    private void testKSS() {
        loginKss()
                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkLinksMagazinFilter()
                .logout();
    }
}
