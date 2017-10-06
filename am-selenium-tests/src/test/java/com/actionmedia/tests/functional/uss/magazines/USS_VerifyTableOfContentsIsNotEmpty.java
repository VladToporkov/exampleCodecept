package com.actionmedia.tests.functional.uss.magazines;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 20.01.14
 * Time: 10:26
 */
public class USS_VerifyTableOfContentsIsNotEmpty extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @LoginAs(key = "uss.user.commercial")
    public void uss_test() {
        loginUss()
                .navigateToMagazinesPage()
                .clickRandomBook()
                .clickRandomArticle()
                .checkTableOfContentsIsNotEmpty()
                .logout();
    }
}
