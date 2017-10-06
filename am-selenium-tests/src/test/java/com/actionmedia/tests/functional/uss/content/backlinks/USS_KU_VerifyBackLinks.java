package com.actionmedia.tests.functional.uss.content.backlinks;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.backlinks;
import static com.actionmedia.autotest.Group.newDocuments;

public class USS_KU_VerifyBackLinks extends AbstractDomainTest {

    @Test(groups = {backlinks})
    @LoginAs(key = "uss.user.commercial")
    public void test() {
        loginUss()
                .checkBackLinks(SystemPubs.uss);
    }
}
