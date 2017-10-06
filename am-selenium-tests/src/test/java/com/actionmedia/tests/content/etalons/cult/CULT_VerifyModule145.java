package com.actionmedia.tests.content.etalons.cult;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.content;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 11:21
 */
public class CULT_VerifyModule145 extends AbstractDomainTest {

    @Test(groups = {content}, invocationCount = 2)
    public void cult_145_module_test() {
        updateSystemInfo(SystemPubs.cult);
        updateLoginAsInfo("cult.user.vip");
        updateLoginToInfo("vip");
        loginElpu()
                .checkContentLinksForModule(getDocumentUrlByKey("cult.145.module"));
    }
}
