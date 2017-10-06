package com.actionmedia.tests.functional.kss.magazines;

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
public class KSS_VerifyTableOfContentsIsNotEmpty extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @LoginAs(key = "kss.user.commercial")
    public void kss_test() {
        loginKss()
                .navigateToMagazinesPage()
                .clickRandomBook()
                .clickRandomArticle()
                .checkTableOfContentsIsNotEmpty()
                .logout();
    }
}
