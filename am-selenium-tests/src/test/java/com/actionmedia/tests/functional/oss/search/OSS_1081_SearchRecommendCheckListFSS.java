package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 08/12/15.
 */
public class OSS_1081_SearchRecommendCheckListFSS extends AbstractDomainTest {

    private static final String QUERY = "Чек-лист";
    private static final String QUERY_CHECK_LIST = "Оценка финансовой устойчивости. Чек-лист";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1081", testCaseVersion = "1")
    public void oss_1081_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется чек-лист в поисковой выдаче ФСС");
        loginFss()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkDocumentWithTextIsPresent(QUERY)
                .checkDocumentModuleId("207")

                .inputTextInSearchBox(QUERY_CHECK_LIST)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkDocumentWithTextIsPresent(QUERY)
                .checkDocumentModuleId("207")

                .logout();
    }
}
