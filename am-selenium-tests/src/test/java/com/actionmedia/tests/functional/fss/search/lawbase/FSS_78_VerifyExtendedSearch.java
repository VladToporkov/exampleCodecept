package com.actionmedia.tests.functional.fss.search.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.fss.FssBasePage;
import com.actionmedia.pages.fss.FssSearchResultPage;
import com.actionmedia.util.TestUtils;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 12.05.2014
 * Time: 12:41
 */
public class FSS_78_VerifyExtendedSearch extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-78", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_78_test() {
        String currentDate = TestUtils.getCurrentDateString("dd.MM.yyyy");
        setParameter(FssBasePage.QUERY, currentDate);
        FssSearchResultPage searchResultPage = loginFss()
                .navigateToLawBasePage()
                .clickExtendedFormButton()
                .inputStartDateDocument(currentDate)
                .clickExtendedSearchButton();
        if (searchResultPage.isSearchResultPresent()) {
            searchResultPage.checkSearchResultOnLawBasePageIsOpenedBoolean(true);
        } else {
            searchResultPage.checkSearchResultOnLawBasePageIsNotPresent(true);
        }
    }
}
