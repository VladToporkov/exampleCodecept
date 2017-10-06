package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

public class OSS_1096_VerifySearchInSearchResultsKss extends AbstractDomainTest {

    private static final String QUERY_1 = "закон";
    private static final String QUERY_2 = "65432123132123123132";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1096", testCaseVersion = "1")
    public void oss_1096_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Поиск в найденном. Отображение. KСС");
        loginKss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY_1)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchInResultCheckBoxIsPresent()
                .checkSearchInResultCheckboxIsNoSelected()

                .clickInLawPracticeLinkFilter()
                .checkSearchInResultCheckBoxIsPresent()
                .checkSearchInResultCheckboxIsNoSelected()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY_2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchInResultCheckBoxIsNotPresent()

                .logout();
    }
}
