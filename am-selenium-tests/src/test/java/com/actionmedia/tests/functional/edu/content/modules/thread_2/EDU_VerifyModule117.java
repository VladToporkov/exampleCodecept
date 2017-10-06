package com.actionmedia.tests.functional.edu.content.modules.thread_2;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.content;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 11:21
 */
public class EDU_VerifyModule117 extends AbstractDomainTest {

    @Test(groups = {content}, invocationCount = 2)
    @LoginAs(key = "edu.user.commercial")
    public void edu_117_module_test() {
        loginEdu()
                .checkContentLinksForModule(getDocumentUrlByKey("edu.117.module"));
    }
}