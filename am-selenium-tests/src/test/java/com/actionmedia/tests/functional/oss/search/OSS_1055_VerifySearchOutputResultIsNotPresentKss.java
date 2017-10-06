package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

public class OSS_1055_VerifySearchOutputResultIsNotPresentKss extends AbstractDomainTest {

    private static final String QUERY = "65432123132123123132";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1055", testCaseVersion = "1")
    public void oss_1055_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Правовая база) КСС");
        loginKss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkTypoBlockIsPresent()
                .checkInLawAndInPracticeFilterIsPresent()

                .clickInLawPracticeLinkFilter()
                .checkTypoBlockIsPresent()
                .checkInLawAndInPracticeFilterIsPresent()

                .navigateToAnswersPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkTypoBlockIsPresent()

                .logout();
    }
}
