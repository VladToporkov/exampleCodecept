package com.actionmedia.tests.content.etalons.bss;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.content;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 11:21
 */
public class BSS_VerifyModule12 extends AbstractDomainTest {

    @Test(groups = {content}, invocationCount = 2)
    public void bss_12_modules_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        loginBss()
                .checkContentLinksForModule(getDocumentUrlByKey("bss.12.module"));
    }
}
