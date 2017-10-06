package com.actionmedia.tests.functional.bss.content.backlinks;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.backlinks;
import static com.actionmedia.autotest.Group.newDocuments;

public class BSS_USN_VerifyBackLinks extends AbstractDomainTest {

    @Test(groups = {backlinks})
    @LoginAs(key = "bss.user.usn")
    @Version(section = "usn")
    public void bss_usn_test() {
        loginBss()
                .checkBackLinks(SystemPubs.bss_usn);
    }
}
