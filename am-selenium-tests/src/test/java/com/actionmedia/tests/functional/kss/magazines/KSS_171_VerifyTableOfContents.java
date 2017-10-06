package com.actionmedia.tests.functional.kss.magazines;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.kss.KssRubricator;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 01.04.2014
 * Time: 11:42
 */
public class KSS_171_VerifyTableOfContents extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-171", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_171_test() {
        KssRubricator kssRubricator = loginKss()
                .navigateToMagazinesPage()
                .clickRubricatorButton()
                .clickRandomMagazine();

        while (!kssRubricator.isNotFirstAndNotLastArticle()) {
            kssRubricator
                    .clickRandomMagazine();
        }

        kssRubricator
                .clickRandomNotFirstAndNotLastArticle()
                .checkSoderButtonIsPresent()
                .clickTableOfContentsButton()
                .checkCurrentItemIsHighlightedInTableOfContents()
                .clickRandomArticleFromTableOfContents()
                .checkSelectedArticleIsOpened()
                .clickTableOfContentsButton()
                .checkCurrentItemIsHighlightedInTableOfContents()

                .clickRubricatorButton()
                .clickRandomBook()
                .clickRandomArticle()
                .checkSoderButtonIsPresent()
                .clickTableOfContentsButton()
                .checkCurrentItemIsHighlightedInTableOfContents()
                .clickRandomArticleFromTableOfContents()
                .checkSelectedArticleIsOpened()
                .clickTableOfContentsButton()
                .checkCurrentItemIsHighlightedInTableOfContents()
                .logout();
    }
}
