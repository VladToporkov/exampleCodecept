package com.actionmedia.tests.functional.fss.search.magazines;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 28.04.2014
 * Time: 16:03
 */
public class FSS_122_VerifySearchBoxInMagazineDocument extends AbstractDomainTest {

    private static final String QUERY = "форма";

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "FSS-122", testCaseVersion = "1")
    public void fss_122_test() {
        report("Проверяется для демодоступа");
        updateLoginAsInfo("fss.user.demo");
        checkSearchBox();

        report("Проверяется для оплаченного");
        updateLoginAsInfo("fss.user.commercial");
        checkSearchBox();

        report("Проверяется для эксперта");
        updateLoginAsInfo("fss.user.expert");
        checkSearchBox();
    }

    private void checkSearchBox() {
        loginFss()
                .navigateToMagazinesPage()
                .clickRandomSectionInRubricator()
                .openRandomSoderLink()
                .clickRandomLinkFromSoder()
                .checkSearchBoxPresentInMagazinesDocument()
                .checkTextInputInSearchBox()

                .clickSearchButtonWithEmptySearchBox()
                .checkSearchResultPageIsNotOpened()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonFss()
                .checkSearchResultIsPresent(false)

                .navigateToMagazinesPage()
                .clickRandomSectionInRubricator()
                .openRandomSoderLink()
                .clickRandomLinkFromSoder()
                .inputTextInSearchBox("к")
                .checkHintsIsPresent()
                .clickHint()
                .checkSearchResultOnMagazinesPageIsOpened()

                .navigateToMagazinesPage()
                .clickRandomSectionInRubricator()
                .openRandomSoderLink()
                .clickRandomLinkFromSoder()
                .inputTextInSearchBox("л")
                .checkHintsWithJumpIsPresent()
                .clickHintWithJump()
                .checkDocumentIsOpened()
                .logout();
    }
}
