package com.actionmedia.tests.functional.uss.videos;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 27.02.14
 * Time: 18:10
 */
public class USS_183_VerifyVideoSeminarPage extends AbstractDomainTest {

    @Test(groups = {smoke, inDevelopment})
    @TestLink(testCaseId = "BSS-183", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void bss_183_test() {
        loginBss()
                .navigateToVideoPage()
                .openDocumentByUrl(getDocumentUrlByKey("uss.145.module"))
                .checkInfoBarWidget()
                .logout();
    }
}
