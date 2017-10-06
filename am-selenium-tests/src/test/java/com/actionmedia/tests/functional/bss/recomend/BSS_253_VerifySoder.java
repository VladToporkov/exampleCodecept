package com.actionmedia.tests.functional.bss.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 01.06.2014
 * Time: 13:25
 */
public class BSS_253_VerifySoder extends AbstractDomainTest {

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "BSS-253", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_253_test() {
        loginBss()
                .navigateToRecomendPage()
                .openDocumentByUrl(getDocumentUrlByKey("bss.111.module"))
                .checkScrolling()
                .logout();
    }
}
