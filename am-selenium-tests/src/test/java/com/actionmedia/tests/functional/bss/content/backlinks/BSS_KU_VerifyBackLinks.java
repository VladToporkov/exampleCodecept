package com.actionmedia.tests.functional.bss.content.backlinks;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.backlinks;

/**
 * User: n.tyukavkin
 * Date: 27.04.14
 * Time: 15:48
 */
public class BSS_KU_VerifyBackLinks extends AbstractDomainTest {

    @Test(groups = {backlinks})
    @LoginAs(key = "bss.user.commercial")
    public void bss_ku_test() {
        loginBss()
                .checkBackLinks(SystemPubs.bss);
    }
}
