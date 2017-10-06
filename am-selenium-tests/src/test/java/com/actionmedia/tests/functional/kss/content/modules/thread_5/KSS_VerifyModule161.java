package com.actionmedia.tests.functional.kss.content.modules.thread_5;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.content;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 11:21
 */
public class KSS_VerifyModule161 extends AbstractDomainTest {

    @Test(groups = {content}, invocationCount = 2)
    @LoginAs(key = "kss.user.commercial")
    public void kss_161_modules_test() {
        loginKss()
                .checkContentLinksForModule(getDocumentUrlByKey("kss.161.module"));
    }
}