package com.actionmedia.tests.functional.fss.magazines;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 21.01.14
 * Time: 11:44
 */
public class FSS_VerifyTableOfContentsIsNotEmpty extends AbstractDomainTest {

    @Test(groups = {implemented})
    @LoginAs(key = "fss.user.commercial")
    public void fss_169_test() {
        loginFss()
                .navigateToMagazinesPage()
                .clickRandomBook()
                .checkCollapsedTableOfContentsIsNotEmpty()
                .checkExpandedTableOfContentsIsNotEmpty();
    }
}
