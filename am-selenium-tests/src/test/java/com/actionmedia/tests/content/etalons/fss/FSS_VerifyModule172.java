package com.actionmedia.tests.content.etalons.fss;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.content;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 11:21
 */
public class FSS_VerifyModule172 extends AbstractDomainTest {

    @Test(groups = {content}, invocationCount = 2)
    public void fss_172_modules_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        loginFss()
                .checkContentLinksForModule(getDocumentUrlByKey("fss.172.module"));
    }
}
