package com.actionmedia.tests.functional.kss.content.backlinks;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.backlinks;
import static com.actionmedia.autotest.Group.newDocuments;

public class KSS_VIP_VerifyBackLinks extends AbstractDomainTest {

    @Test(groups = {backlinks})
    @LoginAs(key = "kss.user.vip")
    @Version(section = "vip")
    public void test() {
        loginKss()
                .checkBackLinks(SystemPubs.kss_vip);
    }
}
