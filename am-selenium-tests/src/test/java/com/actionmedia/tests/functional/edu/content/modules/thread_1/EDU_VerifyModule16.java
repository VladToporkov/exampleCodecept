package com.actionmedia.tests.functional.edu.content.modules.thread_1;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.content;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 11:21
 */
public class EDU_VerifyModule16 extends AbstractDomainTest {

    @Test(groups = {content}, invocationCount = 2)
    @LoginAs(key = "edu.user.commercial")
    public void edu_16_module_test() {
        loginEdu()
                .checkContentLinksForModule(getDocumentUrlByKey("edu.16.module"));
    }
}
