package com.actionmedia.tests.content.etalons.uss;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.content;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 11:21
 */
public class USS_VerifyModule96 extends AbstractDomainTest {

    @Test(groups = {content}, invocationCount = 2)
    public void uss_96_modules_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        loginUss()
                .checkContentLinksForModule(getDocumentUrlByKey("uss.96.module"));
    }
}