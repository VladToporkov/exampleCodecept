package com.actionmedia.tests.functional.fss.search.solutions;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 15.11.13
 * Time: 13:00
 */
public class FSS_34_VerifyRubricatorOnSearchResultPage extends AbstractDomainTest {

    private static final String QUERY = "учетная политика 2013";

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-34", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_34_test() {
        loginFss()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonFss()
                .checkSearchResultOnSolutionsPageIsOpened()
                .clickRandomFilter()
                .checkNumberOfResults(QUERY)
                .checkBreadcrumb()

                .clickSectionInRubricatorByName("В положениях и регламентах")
                .checkSearchResultOnFormsPageIsOpened()
                .clickRandomFilter()
                .checkNumberOfResults(QUERY)
                .checkBreadcrumb()

                .clickSectionInRubricatorByName("В правовой базе")
                .checkSearchResultOnLawBasePageIsOpenedBoolean(false)
                .clickRandomFilterInLawBase()
                .checkNumberOfResultsInLawBase(QUERY)

                .clickSectionInRubricatorByName("В библиотеке")
                .checkSearchResultOnMagazinesPageIsOpened()
                .clickRandomFilter()
                .checkNumberOfResults(QUERY)
                .checkBreadcrumbInMagazines()

                .clickSectionInRubricatorByName("В видео")
                .checkSearchResultOnVideoPageIsOpened()
                .clickRandomFilter()
                .checkNumberOfResults(QUERY)

                .clickSectionInRubricatorByName("В справочнике")
                .checkSearchResultOnDictionaryPageIsOpened()
                .clickRandomFilter()
                .checkNumberOfResults(QUERY)
                .checkBreadcrumb();
    }
}
