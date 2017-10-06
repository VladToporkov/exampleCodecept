package com.actionmedia.tests.functional.ehs.content.modules.thread_4;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.content;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 11:21
 */
public class EHS_VerifyModule193 extends AbstractDomainTest {

    @Test(groups = {content}, invocationCount = 2)
    @LoginAs(key = "ehs.user.commercial")
    public void ot_193_module_test() {
        loginOT()
                .checkContentLinksForModule(getDocumentUrlByKey("ot.193.module"));
    }
}