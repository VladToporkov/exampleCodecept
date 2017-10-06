package com.actionmedia.tests.functional.fss.content.backlinks;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.backlinks;
import static com.actionmedia.autotest.Group.newDocuments;

public class FSS_KU_VerifyBackLinks extends AbstractDomainTest {

    @Test(groups = {backlinks})
    @LoginAs(key = "fss.user.commercial")
    public void test() {
        loginFss()
                .checkBackLinks(SystemPubs.fss);
    }
}
