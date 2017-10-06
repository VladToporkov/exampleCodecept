package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

public class OSS_1057_VerifySearchOutputResultIsNotPresentFss extends AbstractDomainTest {

    private static final String QUERY = "65432123132123123132";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1057", testCaseVersion = "1")
    public void oss_1057_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Правовая база) ФСС");
        loginFss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkTypoBlockIsPresent()
                .checkInLawAndInPracticeFilterIsPresent()

                .clickInLawPracticeLinkFilter()
                .checkTypoBlockIsPresent()
                .checkInLawAndInPracticeFilterIsPresent()

                .clickInLawLinkFilter()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkTypoBlockIsPresent()

                .logout();
    }
}
