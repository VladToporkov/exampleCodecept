package com.actionmedia.tests.content.etalons.klpu;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.content;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 11:21
 */
public class KLPU_VerifyModule145 extends AbstractDomainTest {

    @Test(groups = {content}, invocationCount = 2)
    public void klpu_145_module_test() {
        updateSystemInfo(SystemPubs.klpu);
        updateLoginAsInfo("klpu.user.vip");
        updateLoginToInfo("vip");
        loginElpu()
                .checkContentLinksForModule(getDocumentUrlByKey("klpu.145.module"));
    }
}
