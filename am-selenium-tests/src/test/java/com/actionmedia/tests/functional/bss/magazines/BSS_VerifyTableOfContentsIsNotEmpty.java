package com.actionmedia.tests.functional.bss.magazines;

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
public class BSS_VerifyTableOfContentsIsNotEmpty extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @LoginAs(key = "bss.user.commercial")
    public void bss_test() {
        loginBss()
                .navigateToMagazinesPage()
                .clickRandomBook()
                .clickRandomArticle()
                .checkTableOfContentsIsNotEmpty()
                .logout();
    }
}
