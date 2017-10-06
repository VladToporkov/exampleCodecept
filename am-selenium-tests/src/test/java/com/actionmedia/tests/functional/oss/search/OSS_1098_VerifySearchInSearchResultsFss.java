package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

public class OSS_1098_VerifySearchInSearchResultsFss extends AbstractDomainTest {

    private static final String QUERY_1 = "закон";
    private static final String QUERY_2 = "65432123132123123132";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1098", testCaseVersion = "1")
    public void oss_1098_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Поиск в найденном. Отображение. ФСС");
        loginBss()
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
