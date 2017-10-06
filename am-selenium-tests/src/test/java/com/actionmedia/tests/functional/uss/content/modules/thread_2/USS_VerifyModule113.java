package com.actionmedia.tests.functional.uss.content.modules.thread_2;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.content;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 11:21
 */
public class USS_VerifyModule113 extends AbstractDomainTest {

    @Test(groups = {content}, invocationCount = 2)
    @LoginAs(key = "uss.user.commercial")
    public void uss_113_modules_test() {
        loginUss()
                .checkContentLinksForModule(getDocumentUrlByKey("uss.113.module"));
    }
}
