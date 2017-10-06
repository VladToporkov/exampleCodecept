package com.actionmedia.tests.functional.fss.search.solutions;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 14.11.13
 * Time: 16:48
 */
public class FSS_27_VerifySearchOnSolutionsPage extends AbstractDomainTest {

    private static final String QUERY = "оптимизация при оценке товаров";
    private static final String DOCUMENT = "Как оптимизировать налог на прибыль при выборе метода оценки товаров";
    private static final String TYPO = "ext";
    private static final String FIXED_QUERY = "учет";


    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-27", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_27_test() {
        loginFss()
                .navigateToSolutionsPage()
                .checkSearchBoxPresentOnSolutionsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonFss()
                .checkSearchResultOnSolutionsPageIsOpened()
                .checkDocumentWithTextIsPresent(DOCUMENT)

                .inputTextInSearchBox(TYPO)
                .clickSearchButtonFss()
                .checkTypoWasFixed(TYPO, FIXED_QUERY);
    }
}
