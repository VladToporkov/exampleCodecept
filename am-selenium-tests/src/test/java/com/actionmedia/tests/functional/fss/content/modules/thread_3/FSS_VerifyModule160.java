package com.actionmedia.tests.functional.fss.content.modules.thread_3;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.content;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 11:21
 */
public class FSS_VerifyModule160 extends AbstractDomainTest {

    @Test(groups = {content}, invocationCount = 2)
    @LoginAs(key = "fss.user.commercial")
    public void fss_160_modules_test() {
        loginFss()
                .checkContentLinksForModule(getDocumentUrlByKey("fss.160.module"));
    }
}