package com.actionmedia.tests.functional.kss.answers;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 26.09.13
 * Time: 12:10
 */
public class KSS_172_VerifySoder extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-172", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_172_test() {
        loginKss()
                .navigateToAnswersPage()
                .openDocumentByUrl(getDocumentUrlByKey("kss.130.module"))
                .checkDocumentIsOpened()
                .checkSoderIsPresent()
                .checkScrolling()
                .logout();
    }
}
