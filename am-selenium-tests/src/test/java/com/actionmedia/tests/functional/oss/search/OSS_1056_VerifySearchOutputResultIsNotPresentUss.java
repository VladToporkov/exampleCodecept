package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

public class OSS_1056_VerifySearchOutputResultIsNotPresentUss extends AbstractDomainTest {

    private static final String QUERY = "65432123132123123132";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1056", testCaseVersion = "1")
    public void oss_1056_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Правовая база) ЮСС");
        loginUss()
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
