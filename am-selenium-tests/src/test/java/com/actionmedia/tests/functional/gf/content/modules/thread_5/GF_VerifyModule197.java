package com.actionmedia.tests.functional.gf.content.modules.thread_5;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.content;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 11:21
 */
public class GF_VerifyModule197 extends AbstractDomainTest {

    @Test(groups = {content}, invocationCount = 2)
    @LoginAs(key = "gf.user.commercial")
    public void gf_197_module_test() {
        loginGF()
                .checkContentLinksForModule(getDocumentUrlByKey("gf.197.module"));
    }
}
