package com.actionmedia.tests.content.etalons.kss;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.content;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 11:21
 */
public class KSS_VerifyModule81 extends AbstractDomainTest {

    @Test(groups = {content}, invocationCount = 2)
    public void kss_81_modules_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        loginKss()
                .checkContentLinksForModule(getDocumentUrlByKey("kss.81.module"));
    }
}
