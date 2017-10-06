package com.actionmedia.tests.functional.uss.content.backlinks;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.backlinks;

public class USS_BU_VerifyBackLinks extends AbstractDomainTest {

    @Test(groups = {backlinks})
    @LoginAs(key = "uss.user.budget")
    @Version(section = "budget")
    public void test() {
        loginUss()
                .checkBackLinks(SystemPubs.uss_bu);
    }
}
