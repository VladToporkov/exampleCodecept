package com.actionmedia.tests.functional.bss.search;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 22.10.13
 * Time: 17:35
 */
public class BSS_145_VerifyFilter extends AbstractDomainTest {

    private static final String QUERY = "статья";

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-145", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_145_test() {
        loginBss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnLawBasePageIsOpened(true)
                .checkRelevanceFilterSelectedByName("По соответствию")
                .checkDepartmentFilterSelectedByName("Все документы")
                .checkStatusFilterSelectedByName("Все статусы")

                .clickDateSortedFilter()
                .checkResultAreSortedDescending()

                .clickExpiredStatusInFilter()
                .checkSearchResultOnLawBasePageIsOpened(true)
                .checkDepartmentFilterSelectedByName("Все документы")
                .checkStatusFilterSelectedByName("Утратившие силу")
                .clickRandomDocument()
                .checkExpiredWarningIsPresent()
                .returnToSearchResultPage()

                .clickInFutureStatusInFilter()
                .checkSearchResultOnLawBasePageIsOpened(true)
                .checkDepartmentFilterSelectedByName("Все документы")
                .checkStatusFilterSelectedByName("Не вступившие в силу")
                .clickRandomDocument()
                .checkFutureWarningIsPresent()
                .returnToSearchResultPage()

                .clickFederalDepartmentsFilter()
                .checkDepartmentFilterSelectedByName("Федеральные")
                .logout();
    }
}
