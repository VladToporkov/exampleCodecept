package com.actionmedia.tests.functional.bss.content.modules.thread_4;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.content;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 11:21
 */
public class BSS_VerifyModule150 extends AbstractDomainTest {

    @Test(groups = {content}, invocationCount = 2)
    @LoginAs(key = "bss.user.vip")
    @Version(section = "vip")
    public void bss_150_modules_test() {
        loginBss()
                .checkContentLinksForModule(getDocumentUrlByKey("bss.150.module"));
    }
}
