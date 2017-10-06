package com.actionmedia.tests.functional.bss.magazines;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 15.04.2014
 * Time: 11:42
 */
public class BSS_136_VerifyMagazinesArticle extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-136", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_136_test() {
        loginBss()
                .navigateToMagazinesPage()
                .clickRandomMagazine()
                .clickRandomArticleFromMagazinesMainPage()

                .checkDocumentIsNotEmpty()
                .checkMagazineNameIsPresent()
                .checkMagazineNumberIsPresent()

                .checkTableOfContentsIsNotEmpty()

                .clickRandomArticleFromTableOfContents()
                .checkDocumentIsNotEmpty()

                .checkBrowserButton()
                .logout();
    }
}
