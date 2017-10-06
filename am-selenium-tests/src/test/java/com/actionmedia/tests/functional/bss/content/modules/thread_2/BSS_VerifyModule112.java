package com.actionmedia.tests.functional.bss.content.modules.thread_2;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.content;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 11:21
 */
public class BSS_VerifyModule112 extends AbstractDomainTest {

    @Test(groups = {content}, invocationCount = 2)
    @LoginAs(key = "bss.user.commercial")
    public void bss_112_modules_test() {
        loginBss()
                .checkContentLinksForModule(getDocumentUrlByKey("bss.112.module"));
    }
}
