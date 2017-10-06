package com.actionmedia.tests.functional.bss.content.backlinks;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.backlinks;

public class BSS_VIP_VerifyBackLinks extends AbstractDomainTest {

    @Test(groups = {backlinks})
    @LoginAs(key = "bss.user.vip")
    @Version(section = "vip")
    public void bss_vip_test() {
        loginBss()
                .checkBackLinks(SystemPubs.bss_vip);
    }
}
