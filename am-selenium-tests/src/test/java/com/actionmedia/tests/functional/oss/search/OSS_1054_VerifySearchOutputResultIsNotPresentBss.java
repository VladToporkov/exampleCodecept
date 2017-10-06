package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

public class OSS_1054_VerifySearchOutputResultIsNotPresentBss extends AbstractDomainTest {

    private static final String QUERY = "65432123132123123132";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1054", testCaseVersion = "1")
    public void oss_1054_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Правовая база) БСС");
        loginBss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkTypoBlockIsPresent()
                .checkInLawAndInPracticeFilterIsPresent()

                .clickInLawPracticeLinkFilter()
                .checkTypoBlockIsPresent()
                .checkInLawAndInPracticeFilterIsPresent()

                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkTypoBlockIsPresent()

                .logout();
    }
}
